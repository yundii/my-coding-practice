#include <stdio.h>
#include <stdlib.h>

typedef struct node{
	int data;
	struct node* left;
	struct node* right;
}node_t;

typedef struct tree{
	node_t* root;
	int numNodes;
}tree_t;

node_t* makeNode(int data) {
	node_t* newNode = (node_t*)malloc(sizeof(node_t));
	if (newNode == NULL) {
		return NULL;
	}
	newNode->data = data;
	newNode->left = NULL;
	newNode->right = NULL;
	return newNode;
}

int add(tree_t* t, int data) {
	if (t == NULL) {
		return 0;
	}
	node_t* newNode = makeNode(data);
	if (t->root == NULL) {
		t->root = newNode;
		return 1;
	}
	return addHelper(t->root, newNode);
}

int addHelper(node_t* node, node_t* newNode){
	if (newNode->data < node->data) {
		if (node->left == NULL) {
			node->left = newNode;
			return 1;
		}
		addHelper(node->left, newNode);
	}else if (newNode->data > node->data) {
		if (node->right == NULL) {
			node->right = newNode;
			return 1;
		}
		addHelper(node->right, newNode);
	}

void printHelper(node_t* node) {
	if (node == NULL) {
		return;
	}
	printHelper(node->left);
	printf("%d ", node->data);
	printHelper(node->right);

void print(tree_t* t) {
	if (t == NULL) {
		return;
	}
	printHelper(t->root);
}

void bfs(tree_t* t) {
	if (t == NULL) {
		return;
	}
	queue_t* q = makeQueue();
	push(q, t->root);
	while (!empty(q)) {
		node_t* elem = pop(q);
		printf("%d ", elem->data);
		if (elem->left != NULL) {
			push(q, elem->left);
		}
		if (elem->right != NULL) {
			push(q, elem->right);
		}
	}
}
	
}
