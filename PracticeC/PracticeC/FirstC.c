#include <stdio.h>
#include <math.h>
int main()
{
    // 华氏温度转摄氏温度
    int f = 0;
    float c = 0;
    printf("请输入华氏温度：");
    scanf_s("%d", &f);
    c = 5.0 / 9.0 * (f - 32);
    printf("摄氏温度为：%.2f\n", c);

    printf("-------------------------------------------------------------------------\n");

    /* 我的第一个 C 程序 */
    printf("This Program prints a formula :\n");
    printf("98*16=%d", 1568);

    /* 输入输出 */
    float a = 0;
    float b = 0;
    printf("请输入两个变量：");
    scanf_s("%f%f",&a,&b);
    // printf("您输入的整数是：%d；您输入的小数是：%f",a,b);
    printf("较大的数是：%f\n" , ((a + b + fabs(a - b)) / 2) );
    printf("平方根是：%f\n" , sqrt(((a + b + fabs(a - b)) / 2)));




    /* ** */
    getchar();
    getchar();
    return 0;
}