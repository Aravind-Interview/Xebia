package StepDefinitions;

public class BinaryToDecimal {
	static int binaryToDecimal(int n)
	{
		int no = n;
		int decval = 0;
		int base = 1;
		int tmp = no;
		while (tmp > 0) {
			int LastDig = tmp % 10;
			tmp = tmp / 10;
			decval += LastDig * base;
			base = base * 2;
		}
		return decval;
	}
	public static void main(String[] args)
	{
		int no = 111;
		System.out.println("Binary to Deciamal of " + no +" is : " +binaryToDecimal(no));
	}
}
