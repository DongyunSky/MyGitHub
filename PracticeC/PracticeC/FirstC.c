#include <stdio.h>
#include <math.h>
int main()
{
    /* 某商场清仓，商品打折销售，现需要编一个新的程序：按清仓价格计算出客户应支付的商品金额。 */
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

    /* 编写程序，输入x，根据分段函数的定义计算y，并输出y的值 */
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