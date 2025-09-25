#include<stdio.h>
#include<stdlib.h>

int i=1;
int count=0;

struct node{
    int data;
    struct node *front;
    struct node *prev;
};
struct node *head=0,*tail,*newnode,*temp;

void createll(){

while(i==1){
newnode = (struct node*)malloc(sizeof(struct node));
printf("enter the data");
scanf("%d", &newnode->data);
newnode->prev=0;
newnode->front=0;
if(head==0){
    head=tail=newnode;
}
else{
    newnode->prev = tail;
    tail->front = newnode;
    tail = newnode;
}
count++;
printf("press 1 to continue to add data or else press 0 to stop");
scanf("%d",&i);
}
printf("you have added %d nodes",count);
}
void displayll(){
    temp=head;
    while(temp!=NULL){
        printf("%d\n",temp->data);
        temp = temp->front;
    }
}
int main(){
    createll();
    displayll();
}
