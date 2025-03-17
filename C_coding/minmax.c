#include <stdio.h>
#include <stdlib.h>

// write function that finds the minimum and maximum value in an array of integers
//
//

void max_min(int* a, int n, int* max, int* min) {
	
	int* p;
	p = a;
	*max = *p;
	*min = *p;
	for (;p <a + n; p++) {
		if (*p > *max) {
			*max = *p;

		}else if (*p < *min){
			*min = *p;
		}
		printf("p = %d, *max = %d, *min = %d\n", *p, *max, *min); 
	}





}

int main() {
 
	int array[] = {1, 3, 88, -5, 33, 11, 12, -1};
	int size = 8;
	int a;
	int b;

	max_min(array, size,&a, &b);

	printf("%d is a, %d is b\n", a, b);
		

	return 0;
}
