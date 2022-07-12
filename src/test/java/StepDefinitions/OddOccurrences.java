package StepDefinitions;
public class OddOccurrences
{
	//Bitwise XOR (exclusive or) "^" is an operator in Java that provides the answer '1' if both of the bits in its operands are different, if both of the bits are same then the XOR operator gives the result '0'. XOR is a binary operator that is evaluated from left to right
	static void printTwoOdd(int array[], int size)
	{
	//To keep XOR of two odd occurring elements
	int xor2 = array[0];
	/* To keep single set bit of xor2 */
	int set_bitnum;
	int i;
	int n = size - 2;
	int x = 0, y = 0;
	/* To get xor of all elements in array[]*/
	for(i = 1; i < size; i++)
		xor2 = xor2 ^ array[i];
	/* Get one set bit in the xor2*/
	set_bitnum = xor2 & ~(xor2-1);
	/* Divide elements in two sets*/
	for(i = 0; i < size; i++)
	{
		/* XOR of first set will hold one odd occurring number x */
		if((array[i] & set_bitnum)>0)
		x = x ^ array[i];
	
		/* XOR of second set will hold other odd occurring number y */
		else
		y = y ^ array[i];
	}
	System.out.println("Two ODD elements: "+ x + " and " + y);
	}
	// main function
	public static void main (String[] args)
	{
		int array[] = {10,20};
		int array_size = array.length;
		printTwoOdd(array, array_size);
	}
}
