#include <stdio.h>
int main() {

	int arr[] = {10, 20, 30, 40, 50};
	int* ptr = arr;

	printf("let's print the array\n");
	for(int i = 0; i < 5; i++){
		printf("%d is %d\n", i, arr[i]);
		printf("%d is %p\n", i,  &arr[i]);
	} 

	printf("\n");
	printf("let's print the array with pointer arithmetic\n");
	for(int j = 0; j < 5; j++){
		printf("%d is %d\n",j, *(ptr + j));
		printf("%d is %p\n",j, (ptr + j));
	} 
	
	return 0;	
}
