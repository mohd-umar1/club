#include <stdio.h>
#include<stdlib.h>
#include <stdbool.h>
struct node{
    int data;
    struct node *prev;
};
struct node*temp,*top=0,*newnode;

void push(int a){
    newnode = (struct node*)malloc(sizeof(struct node));
    newnode->data=a;
    if(top==0){
        top=temp=newnode;
    }
    else{
        newnode->prev = top;
        top=temp=newnode;
    }
}
void pop(){
    int item;
    struct node *item1 = top;
    if(top==0){
        printf("the stack is empty \n");
    }else{
        item = top->data;
        top = top->prev;
        temp = temp->prev;
        free(item1);
        printf("the deleted data is %d \n ",item);
    }
}
void display(){
    if(top==0){
        printf("the stack is empty \n");
    }else{
        while(temp!=0){
            printf("\n %d \n",temp->data);
            temp = temp->prev;
        }
    }
    temp =top;
}
void peek(){
    if(top == 0){
        printf("the stack is empty");
    }else{
        printf("\n %d \n",top->data);
    }
}
int main() {
    // Implementation of stack using linked list
    printf("Implementation of stack using linked list \n");
    int choice,data;
    bool run = true;
    while(run){
        printf("1 for push| 2 for pop| 3 for display | 4 for peek |5 for return:");
    scanf("%d",&choice);
        switch(choice){
            case 1:printf("enter the data:");
            scanf("%d",&data);
            push(data);
            break;
            case 2:pop();
            break;
            case 3:display();
            break;
            case 4: peek();
            break;
            case 5:run = false;
            break;
            default: printf("invalid input \n");
            break;
        }
    }
    return 0;
}