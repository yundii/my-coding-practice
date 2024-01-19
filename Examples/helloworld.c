#include <stdio.h>

int main(void){
	int classNumber;

	printf("What is your class number?\n");
	scanf("%d", &classNumber);

	printf("Hello CS %d\n", classNumber);

	return 0;
}
