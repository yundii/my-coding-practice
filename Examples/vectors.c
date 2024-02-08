#include <stdio.h>
#include <stdlib.h>

typedef struct vector{
	int* data;
	int size;
	int capacity;
}vector_t;


vector_t* makeVector(int initCapacity) {
	vector_t* vector = (vector_t*)malloc(sizeof(vector_t));
	if ( vector == NULL) {
		return NULL;
	}
	// Allocate memory for our data array.
	vector->data = (int*)malloc(sizeof(int) * initCapacity);
	vector->size = 0;
	vector->capacity = initCapacity;
	return vector;
}

void freeVector(vector_t* vector) {
	if (vector == NULL) {
		return;
	}
	//First delete the data array, then delete the vector.
	if (vector->data != NULL ){
		free(vector->data);
	}
	free(vector);
}

int resize(vector_t* vector) {
	if (vector == NULL){
		return 0;
	}
	
	vector->capacity = vector->capacity * 2;
	int* newData = (int*)malloc(sizeof(int) * vector->capacity);
	
	if ( newData == NULL || vector->data == NULL){
		return 0;
	}

	//We need to copy the data from the array into our new array.
	for( int i = 0; i < vector->size; i++){
		newData[i] = vector->data[i];
	}
	// We have to free the old data
	//The data is already stored into the newData.
	free(vector->data);
	vector->data = newData;
	return 1;	
}

int push_back(vector_t* vector, int element){
	if (vector == NULL){
		return 0;
	}
	if (vector->data == NULL){
		return 0;
	}

	//Check to make sure that we have enough room 
	// DO we have to resize our data array.
	if (vector ->size == vector->capacity){
		int resizeSuccess = resize(vector);
		if (resizeSuccess == 0) {
			return 0;
		}
	}
	// lets go ahead and append to the back of the array;
	vector->data[vector->size] = element;
	vector->size += 1;
	return 1;

}

int insert(vector_t* vector, int pos, int element){
	if (vector == NULL || pos < 0){
		return 0;
	}
	
	if (pos == vector->size) {
		return push_back(vector, element);
	}
    
	if (vector->size == vector->capacity){
    	int successOnResize = resize(vector);
		if (successOnResize == 0){
             return 0;
        }
    }

    if (vector->data == NULL){
        return 0;
    }
 
     for (int i = vector->size-1; i>= pos; i--){
         vector->data[i+1] = vector->data[i];
     }
 
     vector->data[pos] = element;
     vector->size += 1;
     return 1;
}

int push_front(vector_t* vector, int element){
	return insert(vector, 0, element);
}

void print(vector_t* vector){
	if (vector == NULL)
		return;
	if (vector->data == NULL)
		return;
	for( int i = 0; i < vector->size; i++){
		printf("%d ", vector->data[i]);
	}
	printf("\n");
}



int main(){
	//Constructed a vector on the heap, with the help of makeVector.
	vector_t* vector = makeVector(2);
	push_back(vector, 2);
	push_back(vector, 4);
	push_back(vector, 6);
	push_back(vector, 8);
	push_back(vector, 9);
	print(vector);

	push_front(vector, 1);
	print(vector);
	push_front(vector, 0);
	print(vector);

	insert(vector, 3, 3);
	print(vector);
	insert(vector, 5, 5);
	print(vector);

	insert(vector, vector->size, 10);
	print(vector);
	//Delete the vector from the heap.
	freeVector(vector);
	return 0;


}
