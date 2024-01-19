#include <stdio.h>

void update(int* argument){
	*argument = 10;
}


int main(){
	int value = 5;
	// '*' after a type: convert the type into a pointer type 
	int* p_value = &value;
	printf("Value is: %d\n", value);
	printf("The address of value is: %p\n", p_value);
	/*
	 '*' comes before a variable: dereference the pointer, giving back the value that is stored at that address
	*/
	printf("The value at p_value is: %d\n", *p_value);

	*p_value = 15; //used to be 5, but it is 15.
	printf("The updated value at p_value is: %d\n", *p_value);

	update(p_value);
	printf("Value updated is: %d\n", value);
	return 0;
}
