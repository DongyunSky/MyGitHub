#include <stdio.h>
#include <math.h>
int main()
{

    /* ����ѧ�ţ������������ѧ��ݡ�ѧԺ���롢�༶���š� */
    int year, code, number;
    printf("������ѧ�ţ�");
    scanf_s("%3d%4d%*2d%3d", &code, &year, &number);
    printf("��ѧ��ݣ�%d\nѧԺ���룺%d\n�༶���ţ�%03d", year, code, number);
    printf("\n");


    /* �����û������ʱ�䣬�����ͬ���ʺ��� */
    int hour, minute;
    printf("�����뵱ǰʱ��(��ʽ��ʱ:��)��");
    scanf_s("%d:%d", &hour, &minute);
    if (hour >= 6 && hour < 12) {
        printf("�����");
    }
    else if (hour >= 12 && hour < 18) {
        printf("�����");
    }
    else
    {
        printf("���Ϻ�");
    }

    printf("\n");
    

    int x = 10;
    int t = x && x > 10;
    printf("%d", t);

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