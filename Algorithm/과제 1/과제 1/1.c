/* 1
#include <stdio.h>
void print(int x){

	static int a = 1;

	if(a <= x){
		printf("%d ", a++);
		print(x);
	}
		
}
int main(){

	printf("김아연 15011025\n");
	print(3);

}/*/

/* 2
#include <stdio.h>
void print(int x){

	printf("%d ", x);
	
	if(x > 1) print(x - 1);

}

int main(){
	
	printf("김아연 15011025\n");
	print(3);

}*/

/* 3
#include <stdio.h>

//int path[10] = {0, 0, 1, 2};	// 경유 노드
int path[10] = {0, 4, 1, 2, 0, 0, 4};	// 경유 노드

void print_path(int start, int end){

	int i, node;

	while(1){
		
		for(i = 0; i < 10; i ++){

			if(start == path[i]){
				if(i == start) continue;
				node = i;
				break;
			}
		}

		printf("<%d -> %d> ", start, node);

		if(end == node) break;
		start = node;	//start를 이전 노드로 사용

	}

}
int main(){

	printf("김아연 15011025\n");
	print_path(0,3);	// 정점 0에서 정점 3으로 가는 최단경로 출력

}*/

//* 4
#include <stdio.h>
#include <stdlib.h>
#include <memory.h>

struct avl_node   {
	struct avl_node *left_child, *right_child;  // Subtrees 
	int data;                   // Pointer to data 
};

struct avl_node *root;

int maxm(int a, int b){   // 김도년 추가
	if(a>=b) return a;
	else return b;
}
// 오른쪽 회전 함수
struct avl_node * rotate_right(struct avl_node *parent)
{
	struct avl_node *child = parent->left_child;
	parent->left_child = child->right_child;
	child->right_child = parent;
	return child;
}
// 왼쪽 회전 함수
struct avl_node * rotate_left(struct avl_node *parent)
{
	struct avl_node *child = parent->right_child;
	parent->right_child = child->left_child;
	child->left_child = parent;
	return child;
}
// 오른쪽-왼쪽 회전 함수
struct avl_node * rotate_right_left(struct avl_node *parent)
{
	struct avl_node *child = parent->right_child;
	parent->right_child = rotate_right(child);
	return rotate_left(parent);
}
// 왼쪽-오른쪽 회전 함수
struct avl_node * rotate_left_right(struct avl_node *parent)
{
	struct avl_node *child = parent->left_child;
	parent->left_child = rotate_left(child);
	return rotate_right(parent);
}
// 트리의 높이를 반환
int get_height(struct avl_node *node)
{
	int height=0;

	if( node != NULL ){
		height = 1 + maxm(get_height(node->left_child), 
			get_height(node->right_child)) ;
	}
	return height;
}

// 노드의 균형인수를 반환
int get_height_diff(struct avl_node *node) 
{
	if( node == NULL ) return 0;
	return get_height(node->left_child) - get_height(node->right_child);
} 

// 트리를 균형트리로 만든다
struct avl_node * rebalance(struct avl_node **node)
{ 
	int height_diff = get_height_diff(*node);  
	if( height_diff > 1 ){  
		if( get_height_diff((*node)->left_child) > 0 ) 
			*node = rotate_right(*node);
		else
			*node = rotate_left_right(*node);
	}
	else if ( height_diff < -1 ){ 
		if( get_height_diff((*node)->right_child) < 0 )
			*node = rotate_left(*node);
		else
			*node = rotate_right_left(*node);
	}
	return *node;
}

// AVL 트리의 삽입 연산
struct avl_node * avl_add(struct avl_node **root, int new_key)
{
	if( *root == NULL ){
		*root = (struct avl_node *)
			malloc(sizeof(struct avl_node));
		if( *root == NULL ){
			fprintf(stderr, "메모리 할당 에러\n");
			exit(1);
		}
		(*root)->data = new_key;
		(*root)->left_child = (*root)->right_child = NULL;
	}
	else if( new_key < (*root)->data ){
		(*root)->left_child=avl_add(&((*root)->left_child), new_key);
		*root = rebalance(root);
	}
	else if( new_key > (*root)->data ){
		(*root)->right_child=avl_add(&((*root)->right_child), new_key);
		*root = rebalance(root);
	}
	else{
		fprintf(stderr, "중복된 키 에러\n");
		exit(1);
	}
	return *root;
}

// AVL 트리의 탐색함수
struct avl_node *avl_search(struct avl_node *node, int key) 
{ 
	if( node == NULL ) return NULL; 
	printf("%d\n", node->data);
	if( key == node->data ) return node; 
	else if( key < node->data ) {
		printf("↙ \n" );
		return avl_search(node->left_child, key); }
	else {
		printf("↘ \n" );
		return avl_search(node->right_child, key); }
} 

void main()
{
	/* 8,9,10,2,1,5,3,6,4,7,11,12
	avl_add(&root, 8);
	avl_add(&root, 9);
	avl_add(&root, 10); 
	avl_add(&root, 2);
	avl_add(&root, 1);
	avl_add(&root, 5);
	avl_add(&root, 3);
	avl_add(&root, 6);

	avl_add(&root, 4);
	avl_add(&root, 7);
	avl_add(&root, 11);
	avl_add(&root, 12);  
	avl_search(root, 12);
	*/
	
	printf("김아연 15011025\n");

	avl_add(&root, 10);
	avl_add(&root, 20);
	avl_add(&root, 30);
	avl_add(&root, 40);
	avl_add(&root, 50);
	avl_add(&root, 60);
	avl_add(&root, 70);
	avl_add(&root, 80);
	avl_add(&root, 90);
	avl_add(&root, 100);
	avl_search(root, 100);


}//*/