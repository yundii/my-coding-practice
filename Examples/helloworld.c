#include <stdio.h>

int main(void){
	int amount1;
	int amount2;

	printf("What is your amount?\n");
	scanf("%d %d", &amount1, &amount2);

	const int NUMBER = 100;
	
	int change = NUMBER - amount1 - amount2;

	printf("Change  %d dollars\n", change);

	return 0;
}
