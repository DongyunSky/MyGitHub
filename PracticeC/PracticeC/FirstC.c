#include <stdio.h>
#include <math.h>
int main()
{

    /* 输入学号，输出该生的入学年份、学院代码、班级座号。 */
    int year, code, number;
    printf("请输入学号：");
    scanf_s("%3d%4d%*2d%3d", &code, &year, &number);
    printf("入学年份：%d\n学院代码：%d\n班级座号：%03d", year, code, number);
    printf("\n");


    /* 根据用户输入的时间，输出不同的问候语 */
    int hour, minute;
    printf("请输入当前时间(格式：时:分)：");
    scanf_s("%d:%d", &hour, &minute);
    if (hour >= 6 && hour < 12) {
        printf("上午好");
    }
    else if (hour >= 12 && hour < 18) {
        printf("下午好");
    }
    else
    {
        printf("晚上好");
    }

    printf("\n");
    

    int x = 10;
    int t = x && x > 10;
    printf("%d", t);

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