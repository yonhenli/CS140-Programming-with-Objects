package assignment06;

public class FormatterTest {
	public static void main (String[] args) {
		int i = -10000000;
		DecimalSeperatorFormatter dsp = new DecimalSeperatorFormatter();
		System.out.println(dsp.format(i));
		
//		AccountingFormatter af = new AccountingFormatter();
//		System.out.println(af.format(i));
		
//		BaseFormatter bf = new BaseFormatter (2);
//		System.out.println(bf.format(10));
		
//		System.exit(0);
	}
}
