#include <stdio.h>
#include <stdlib.h>
//struct student{
//	int id;
//	int age;
//	double creditHours;
//};

typedef struct student{
	int id;
	int age;
	double creditHours;
}student;

student* makeStudent(int id, int age, double creditHours){
	student* p_tempStudent = (student*)malloc(sizeof(student));
	p_tempStudent->id = id;
	p_tempStudent->age = age;
	p_tempStudent->creditHours = creditHours;
	return p_tempStudent;
}

void updateStudent(student* aStudent, int id, int age, double creditHours) {
	aStudent-> age = age;
	aStudent-> id = id;
	aStudent-> creditHours = creditHours;

}

//void printStudent(struct student aStudent){
//	printf("Student: %d %d %f\n", aStudent.id, aStudent.age, aStudent.creditHours); 
//}

void printStudent(student* aStudent) {
	printf("Student: %d %d %.2f\n", aStudent->id, aStudent->age, aStudent->creditHours);
}

int main(){
	student* s1 = makeStudent(1001, 23, 14.5);
	student* s2 = makeStudent(1002, 24, 13.0);

	printStudent(s1);
	printStudent(s2);

	// pointer use ->, struct use .
	updateStudent(s2, 1003, s2->age, s2->creditHours);
	printStudent(s2);


	free(s1);
	free(s2);
	return 0;
}
