#include <stdio.h>
#include <math.h>
int main()
{
    /* ĳ�̳���֣���Ʒ�������ۣ�����Ҫ��һ���µĳ��򣺰���ּ۸������ͻ�Ӧ֧������Ʒ�� */
    int w, c;
    float price;
    scanf_s("%d%d", &w, &c);
    if (w <= 1000 && w>0) {
        int i = w / 200;
        if (c == 1)
            price = (i + 1) * 4.5;
        if (c == 2)
            price = (i + 1) * 7;
    }
    else if (w > 1000) {
        int i = (w - 1000) / 300;
        if (c == 1)
            price = (i + 1) * 6;
        if (c == 2)
            price = (i + 1) * 8.5;
        price += 35;
    }
    printf("%.2f", price);

    /* ��д��������x�����ݷֶκ����Ķ������y�������y��ֵ */
    double x, y;
    scanf_s("%lf", &x);
    if (x <= -1) {
        y = 2 * x*x*x - 1;
    }
    else if (x > -1 && x <= 0) {
        y = x * x;
    }
    else if (x > 0 && x <= 1) {
        y = sqrt(x);
    }
    else if (x > 1) {
        y = 3 * x + 2;
    }
    printf("%f", y);

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