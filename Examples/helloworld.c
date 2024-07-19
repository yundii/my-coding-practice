#include <stdio.h>

int main(void){
	int amount;

	printf("What is your amount?\n");
	scanf("%d", &amount);
	
	int change = 100 - amount;

	printf("Change  %d dollars\n", change);

	return 0;
}
