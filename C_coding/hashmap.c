#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct pair{
	char* key;
	int value;
}pair_t;

typedef struct node{
	struct node* next;
	pair_t* kv; // key-value pair
}node_t;

int stringHash(char* myKey, int numberOfBuckets) {
	return strlen(myKey) % numberOfBuckets;
}

// Function pointer type definition
typedef int(*hashFunctionPointer) (char*, int);

typedef struct hashmap{
	int buckets;
	node_t** arrayOfLists;
	hashFunctionPointer hashFunction;
}hashmap_t;

hashmap_t* hashmap_create(int _buckets) {
	hashmap_t* map = (hashmap_t*)malloc(sizeof(hashmap_t));
	
	map->buckets = _buckets;

	map->arrayOfLists = (node_t**)malloc(sizeof(node_t*)*_buckets);
	for(int i = 0; i < 	_buckets; i++) {
		map->arrayOfLists[i] = NULL;
	}

	map->hashFunction = stringHash;
	
	return map;
}

void hashmap_insert(hashmap_t* in, char* key_in, int value) {
	pair_t* newpair = (pair_t*)malloc(sizeof(pair_t));
	newpair->key = (char*) malloc(strlen(key_in)*sizeof(char)+1);
	newpair->value = value;
	strcpy(newpair->key, key_in);

	node_t* newnode = (node_t*)malloc(sizeof(node_t));
	newnode->next = NULL;
	newnode->kv = newpair;

	unsigned int bucket = in->hashFunction(key_in, in->buckets);

	if(in->arrayOfLists[bucket]==NULL) { 
		in->arrayOfLists[bucket] = newnode;
	}else{
		newnode->next = in->arrayOfLists[bucket];
		in->arrayOfLists[bucket] = newnode;
	}
}

void hashmap_printKeyValues(hashmap_t* in) {
	for(int i=0; i < in->buckets; i++) {
		printf("Bucket# %d\n", i);
		node_t* iter = in->arrayOfLists[i];
		while(iter!= NULL){
			printf("\tKey=%s\tValue=%d\n", iter->kv->key, iter->kv->value);
			iter=iter->next;
		}
	}

}

int main() {
	hashmap_t* map = hashmap_create(8);
	hashmap_insert(map, "mike", 10);
	hashmap_insert(map, "Dr. House", 11);
	hashmap_insert(map, "Jeff Probst", 12);
	hashmap_insert(map, "Michael Jordan", 13);

	hashmap_printKeyValues(map);
	return 0;
}
