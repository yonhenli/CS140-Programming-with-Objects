package project;

import java.util.TreeMap;
import java.util.Map;

public class MachineModel {
	public final Map<Integer, Instruction> IMAP = new TreeMap<>();
	private CPU cpu = new CPU();
	private Memory memory = new Memory();
	private HaltCallback callback;
	private Code code = new Code();
	private Job currentJob;
	
	Job[] jobs = new Job[4]; //PRIVATE???????????????????????????????????
	
	public MachineModel() {
		this(() -> System.exit(0));
	}
	
	public MachineModel(HaltCallback hcb) {
		this.callback = hcb;
		
		//INSTRUCTION MAP entry for "NOP"
		IMAP.put(0x0, (arg, level) -> {
			cpu.incrPC();
		});
		
		//INSTRUCTION MAP entry for "LOD"
		IMAP.put(0x1, (arg, level) -> {
			if (level < 0 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in LOD instruction");
			}if (level > 0) {
				IMAP.get(0x1).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			}else {
				cpu.setAccum(arg);
				cpu.incrPC();
			}
		});
		
		//INSTRUCTION MAP entry for "STO"
		IMAP.put(0x2, (arg, level) -> {
			if (level < 1 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in STO instruction");
			}if (level == 1) {
				memory.setData(cpu.getMemBase()+arg, cpu.getAccum());
				cpu.incrPC();
			}else {
				IMAP.get(0x2).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			}
		});
		
		//INSTRUCTION MAP entry for "ADD"
		IMAP.put(0x3, (arg, level) -> {
			if(level < 0 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in ADD instruction");
			}
			if(level > 0) {
				IMAP.get(0x3).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			} else {
				cpu.setAccum(cpu.getAccum() + arg);
				cpu.incrPC();
			}
		});
		
		//INSTRUCTION MAP entry for "SUB"
		IMAP.put(0x4, (arg, level) -> {
			if(level < 0 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in SUB instruction");
			}
			if(level > 0) {
				IMAP.get(0x4).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			} else {
				cpu.setAccum(cpu.getAccum() - arg);
				cpu.incrPC();
			}
		});
		
		//INSTRUCTION MAP entry for "MUL"
		IMAP.put(0x5, (arg, level) -> {
			if(level < 0 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in MUL instruction");
			}
			if(level > 0) {
				IMAP.get(0x5).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			} else {
				cpu.setAccum(cpu.getAccum() * arg);
				cpu.incrPC();
			}
		});
		
		//INSTRUCTION MAP entry for "DIV"
		IMAP.put(0x6, (arg, level) -> {
			if(level < 0 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in DIV instruction");
			}if (arg == 0) {
				throw new DivideByZeroException("Can't divide by zero.");
			}
			if(level > 0) {
				IMAP.get(0x6).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			} else {
				cpu.setAccum(cpu.getAccum() / arg);
				cpu.incrPC();
			}
		});
		
		//INSTRUCTION MAP entry for "AND"
		IMAP.put(0x7, (arg, level) -> {
			if(level < 0 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in AND instruction");
			}
			if(level > 0) {
				IMAP.get(0x7).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			}else {
				if (cpu.getAccum() != 0 && arg != 0) {
					cpu.setAccum(1);
				}else {
					cpu.setAccum(0);
				}
				cpu.incrPC();
			}
		});
		
		//INSTRUCTION MAP entry for "NOT"
		IMAP.put(0x8, (arg, level) -> {
			if (level != 0) {
				throw new IllegalArgumentException(
						"Illegal indirection level in NOT instruction");
			}
			if (cpu.getAccum() == 0) {
				cpu.setAccum(1);
			}else {
				cpu.setAccum(0);
			}
			cpu.incrPC();
		});
		
		//INSTRUCTION MAP entry for "CMPL"
		IMAP.put(0x9, (arg, level) -> {
			if (level < 1 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in CMPL instruction");
			}if(level > 1) {
				IMAP.get(0x9).execute(memory.getData(cpu.getMemBase()+arg), level-1);
			}
			else {
				if (memory.getData(arg+cpu.getMemBase()) < 0) {
					cpu.setAccum(1);
				}else {
					cpu.setAccum(0);
				}
				cpu.incrPC();
			}
		});
		
		//INSTRUCTION MAP entry for "CMPZ"
		IMAP.put(0xA, (arg, level) -> {
			if(level < 1 || level > 2) {
				throw new IllegalArgumentException(
					"Illegal indirection level in CMPZ instruction");
			}if (memory.getData(arg+cpu.getMemBase()) == 0) {
				cpu.setAccum(1);
			}else {
				cpu.setAccum(0);
			}
			cpu.incrPC();
		});
		
		//INSTRUCTION MAP entry for "JUMP"
		IMAP.put(0xB, (arg, level) -> {
			if(level < 0 || level > 3) {
				throw new IllegalArgumentException(
					"Illegal indirection level in JUMP instruction");
			}else if (level == 3) {
				int arg1 = memory.getData(cpu.getMemBase()+arg); // CORRECTION
				cpu.setpCounter(arg1 + currentJob.getStartcodeIndex());
			}else {
				if (level > 0) {
					IMAP.get(0xB).execute(memory.getData((cpu.getMemBase()+arg)), level-1);
				}else {
					cpu.setpCounter(cpu.getpCounter()+arg);
				}
			}
				
		});
		
		//INSTRUCTION MAP entry for "JMPZ"
		IMAP.put(0xC, (arg, level) -> {
			if(level < 0 || level > 3) {
				throw new IllegalArgumentException(
					"Illegal indirection level in JMPZ instruction");
			}
			if (cpu.getAccum() == 0) {
				if (level == 3) {
					int arg1 = memory.getData(cpu.getMemBase()+arg); // CORRECTION
					cpu.setpCounter(arg1 + currentJob.getStartcodeIndex());
				}else if (level > 0) {
						IMAP.get(0xc).execute(memory.getData((cpu.getMemBase()+arg)), level-1);
				}else {
						cpu.setpCounter(cpu.getpCounter()+arg);
				}	
			}else {
				cpu.incrPC();
			}
			
		});
		
		//INSTRUCTION MAP entry for "HALT"
		IMAP.put(0xF, (arg, level) -> {
			callback.halt();			
		});
		
		for (int i = 0; i <= 3; i++) {
			jobs[i] = new Job();
			jobs[i].setId(i);
			jobs[i].setStartcodeIndex(i*Code.CODE_MAX/4);
			jobs[i].setStartmemoryIndex(i*Memory.DATA_SIZE/4);
			jobs[i].getCurrentState().enter();
		}
		currentJob = jobs[0];
		
		
	}
	
	public int getData(int index) {
		return memory.getData(index);
	}
	
	public void setData(int index, int value) {
		memory.setData(index, value);
	}
	
	public int getChangedIndex() {
		return memory.getChangedIndex();
	}
	
	public int[] getData() {
		return memory.getData();
	}
	
	public Instruction get(Integer instrNum) {
		return IMAP.get(instrNum);
	}
	
	public int getpCounter() {
		return cpu.getpCounter();
	}

	public int getAccum() {
		return cpu.getAccum();
	}

	public int getMemBase() {
		return cpu.getMemBase();
	}
	
	public void setpCounter(int pCounter) {
		cpu.setpCounter(pCounter);
	}

	public void setAccum(int accum) {
		cpu.setAccum(accum);
	}

	public void setMemBase(int memBase) {
		cpu.setMemBase(memBase);
	}
	
	public Code getCode() {
		return code;
	}
	
	public void setCode(int index, int op, int indirLvl, int arg) {
		code.setCode(index, op, indirLvl, arg);
	}
	
	public Job getCurrentJob() {
		return currentJob;
	}
	
	public void changeToJob(int i) {
		if (i < 0 || i > 3) {
			throw new IllegalArgumentException("Not a possible job");
		}else if (i == currentJob.getId()) {
			
		}else {
			currentJob.setCurrentAcc(cpu.getAccum());
			currentJob.setCurrentPC(cpu.getpCounter());
			currentJob = jobs[i];
			cpu.setAccum(currentJob.getCurrentAcc());
			cpu.setpCounter(currentJob.getCurrentPC());
			cpu.setMemBase(currentJob.getStartmemoryIndex());
		}
	}
	
	public States getCurrentState() {
		return currentJob.getCurrentState();
	}
	
	public void setCurrentState(States currentState) {
		currentJob.setCurrentState(currentState);
	}
	
	public void step() {
		try {
			int pc = cpu.getpCounter();
			if (!(pc >= currentJob.getStartcodeIndex() 
					&& pc < currentJob.getStartcodeIndex()+currentJob.getCodeSize())) {
				throw new CodeAccessException("Illegal access outside of executing code");
			}
			get(code.getOp(pc)).execute(code.getArg(pc), code.getIndirLvl(pc));
		}catch (Exception e) {
			callback.halt();
			throw e;
		}
	}
	
	public void clearJob() {
		memory.clear(currentJob.getStartmemoryIndex(), 
				currentJob.getStartmemoryIndex()+Memory.DATA_SIZE/4);
		code.clear(currentJob.getStartcodeIndex(), 
				currentJob.getCodeSize());
		cpu.setAccum(0);
		cpu.setpCounter(currentJob.getStartcodeIndex());
		currentJob.reset();
	}
	
	
	
	
	

}
