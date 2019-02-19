//3
#include <stdio.h>

int A[6] = {0, 1, 3, 6, 11, 17};
int H[6] = {0, 2, 5, 1,  5,  0};
int k[4] = {0, 0, 0, 0};	// �����ϴ� ���� �迭�� ����, �ִ� 4�� ���� ����
int cnt = 0;	// ���� �ϴ� ���� ���� ī��Ʈ
int m[6] = {0, 10000, 10000, 10000, 10000, 10000};

int airtel(int d){

	int cost;
	int i, j;

	if(d == 0) return 0;	// d = 0 �̸� ��� �������� ����
	
	m[0] = 0;

	for(i = 1; i < d; i ++){
		for(j = 0; j < i; j++){
			cost = m[j] + H[j] + A[i - j];

			if(m[i] > cost){
				m[i] = cost;
				k[cnt++] = j;
			}
		}
		
	}

	return m[d - 1];
}

int main(){

	int d;
	int i;

	printf("15011025 ��ƿ�\n\n");
	printf("Enter the destination (range 1 ~ 5) : "); scanf("%d", &d);

	airtel(d + 1);

	for(i = 0; i < cnt; i++){
		if(i == cnt - 1) printf("<%d -> %d>\n", k[i], d);	//������ ���� ��� ���
		else if(i != 0) printf("<%d -> %d>", k[i], k[i + 1]);	//���� ��� ���
	}

	printf("Minimum cost is %d\n", airtel(d + 1));

}