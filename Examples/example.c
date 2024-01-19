#include <stdio.h>

//This is the entry point to my program.

int main(){
	int accountId = 5;
	double accountBalance = 100.53;
	char accountType = 'C';

	// %d for digits
	// %f for floating point numbers or say decimal numbers
	// %c for characters
	printf("AccountID is: %d\n", accountId);
	printf("AccountBL is: %f\n", accountBalance);
	printf("AccountTY is: %c\n", accountType);

	printf("sizeof(int): %d\n", sizeof(int));
	printf("sizeof(double): %d\n", sizeof(double));
	printf("sizeof(char): %d\n", sizeof(char));	
	return 0;

}
