#include <stdio.h>
#include <math.h>
int main()
{
    // �����¶�ת�����¶�
    int f = 0;
    float c = 0;
    printf("�����뻪���¶ȣ�");
    scanf_s("%d", &f);
    c = 5.0 / 9.0 * (f - 32);
    printf("�����¶�Ϊ��%.2f\n", c);

    printf("-------------------------------------------------------------------------\n");

    /* �ҵĵ�һ�� C ���� */
    printf("This Program prints a formula :\n");
    printf("98*16=%d", 1568);

    /* ������� */
    float a = 0;
    float b = 0;
    printf("����������������");
    scanf_s("%f%f",&a,&b);
    // printf("������������ǣ�%d���������С���ǣ�%f",a,b);
    printf("�ϴ�����ǣ�%f\n" , ((a + b + fabs(a - b)) / 2) );
    printf("ƽ�����ǣ�%f\n" , sqrt(((a + b + fabs(a - b)) / 2)));




    /* ** */
    getchar();
    getchar();
    return 0;
}