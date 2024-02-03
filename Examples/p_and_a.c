#include <stdio.h>
#include <stdlib.h>

void update_array1(int array[]){
	array[1] = 10;
/* equals  *(array + 1) = 10; */
}

void update_array2(int* array){
	array[1] = 10;
}

int main(){
	int numbers[3] = {1, 2, 3};
	
	update_array1(numbers);
	
	printf("%p\n", &numbers[0]);
	printf("%p\n", &numbers[1]);
	printf("%p\n", &numbers[2]);
	printf("Equals: \n");
	printf("%p\n", numbers);
	printf("%p\n", numbers + 1);
	printf("%p\n", numbers + 2);
	printf("____________________\n");
	printf("%d\n", numbers[0]);
	printf("%d\n", numbers[1]);
	printf("%d\n", numbers[2]);
    printf("Equals: \n");
	printf("%d\n", *numbers);
	printf("%d\n", *(numbers + 1));
	printf("%d\n", *(numbers + 2));
}
