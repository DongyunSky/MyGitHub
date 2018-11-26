#include <stdio.h>
#include <math.h>
int main()
{

    /* 九九 */
    for (int i = 1; i < 10; i++)
    {
        for (int j = 1; j < i + 1; j++)
        {
            printf("%d*%d=%d  ", i, j, i*j);
        }
        printf("\n");
    }

    /* 有30个人，在一家饭馆里吃饭共花了50先令，每个男人各花3先令，每个女人各花2先令，每个小孩各花1先令，
    问男人、女人和小孩各有几人？(男人、女人和小孩都至少有1人) */
    for (int i = 1; i < 30; i++)
    {
        for (int j = 1; j < 30; j++)
        {
            for (int k = 1; k < 30; k++)
            {
                if ((3 * i + 2 * j + 1 * k) == 50 && i + j + k == 30) {
                    printf("男人：%d；女人：%d；小孩：%d。\n", i, j, k);
                }
            }
        }
    }

    /* 某珠宝鉴定大赛，由主持人输入珠宝的真实价格，再由8位参赛选手输入各自估计的价格，估价与真实价格最接近的选手获胜。 */
    float realPrice, mini, price;
    int num = 1;
    printf("请输入真实价格（单位：万）");
    scanf_s("%f", &realPrice);
    printf("请选手输入估计的价格（单位：万）");
    scanf_s("%f", &mini);
    for (int i = 0; i < 7; i++)
    {
        scanf_s("%f", &price);
        if (fabs(realPrice - price) < fabs(realPrice - mini))
        {
            mini = price;
            num = i + 2;
        }
    }
    printf("%d号选手获胜，最接近的估价是：%.1f", num, mini);



    /* 输入一个整数n，输出由n行上三角形与n+1行下三角形组成的如下菱形。 */
    int n;
    scanf_s("%d", &n);
    for (int i = 0; i < n + 1; i++)
    {
        for (int j = i; j < n; j++)
        {
            printf(" ");
        }
        for (int k = n - i; k < n + 1 + i; k++)
        {
            printf("*");
        }
        printf("\n");
    }
    for (int i = n - 1; i >= 0; i--)
    {
        for (int j = i; j < n; j++)
        {
            printf(" ");
        }
        for (int k = n - i; k < n + 1 + i; k++)
        {
            printf("*");
        }
        printf("\n");
    }


    /* 计算s=1+1/2+1/3+1/4+......+1/200的值并输出（保留4位小数），正确结果为5.8780 */
    float s = 0.0, a = 1.0;
    for (int i = 1; i < 201; i++)
    {
        s += a / i;
    }
    printf("%.4f", s);

    /* 二次三项式   ，p>0,q>0，如果常数项 q 可分解为2个因数a,b的积，并且a+b=p ，那么 就可分解为(x+a)(x+b) . */
    int p, q, flag = 0;
    scanf_s("%d%d", &p, &q);
    for (int i = 1; i <= sqrt(q); i++)
    {
        if (q%i == 0) {
            if (p == (i + q / i)) {
                printf("(x+%d)(x+%d)\n", i, q / i);
                flag = 1;
            }
        }
    }
    if (flag == 0) {
        printf("无分解式");
    }


   /* 第一天训练300米，第二天训练337.5米，第三天训练379.688米，......，
   后一天训练长度是前一天的 1+1/8倍，编程判断学生第几天训练的长度开始超过10000米？ */
    float totalDistance = 300;
    int day = 1;
    while (totalDistance <= 10000)
    {
        totalDistance = totalDistance * (1 + 1.0 / 8);
        day++;
    }
    printf("%d", day);


    /* 输出1至1000之间所有满足用3除余2、用5除余3、用7除余2的数，要求分行输出，每行5个，并且每列左对齐。 */
    int count = 0;
    for (int i = 1; i < 1000; i++)
    {
        if (i % 3 == 2 && i % 5 == 3 && i % 7 == 2) {
            printf("%-5d", i);
            count++;
        }
        if (count == 5) {
            printf("\n");
            count = 0;
        }
    }

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