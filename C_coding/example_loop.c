#include <stdio.h>

int main(){
	int counter = 0;

	while ( counter < 5){
		printf("%d ", counter);
		counter = counter + 1;
	}

	printf("\n");
	
	// i++ means i = i + 1
	// gcc don't like initial variables in a loop, so use clang to compile
	for( int i = 0; i < 5; i++){
		printf("%d ", i);
	}

	printf("\n");

	return 0;
}
