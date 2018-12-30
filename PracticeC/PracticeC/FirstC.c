#include <stdio.h>
#include <math.h>
#include <time.h>

int qshu(int n, int k) {
    for (int i = 0; i < k - 1; i++) {
        n = n / 10;
    }
    return n % 10;
}

int f(int x) {
    return 3 * x*x*x + 2 * x*x + 5 * x + 1;
}

/* ��ӡֱ�������� */
void triangle(int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 2 * i + 1; j++) {
            printf("*");
        }
        printf("\n");
    }
}

/* ��ӡ���� */
void rectangle(int n) {
    for (int i = 0; i < n; i++) {
        printf("***\n");
    }
}

int count; // ���еĴ���
int guess() {
    int magic; //magic���ڱ��������
    srand(time(0));	//��ϵͳʱ���ʼ���������
    magic = rand() % 10 + 1; //����һ��1��10���������
    //�����ƺ����Ĺ���
    count = 0;
    int i;
    do{
        scanf_s("%d", &i);
        count++;
        if (i > magic) {
            printf("�´��ˣ�\n");
        }
        else if (i < magic) {
            printf("��С�ˣ�\n");
        }
        else {
            printf("��¶��ˣ���%d��������%d�Ρ�\n", magic, count);
            break;
        }
    } while (i != magic);
    return magic; // return ���е���
}

int a, b, c, d, flag = 100;
// ���4����ͥ������
int fa[4];
void getFamNum() {
    printf("�밴������4����ͥ��������\n");
    scanf_s("%d%d%d%d", &fa[0], &fa[1], &fa[2], &fa[3]);
}

// ÿ����������
int room[19] = { 0,20,4,10,6,10,4,0,0,20,5,3,0,5,8,3,4,3,10 };
// �ж��Ƿ��Ǻ��ʷ���
int getRoom(int index) {
    int result = -1;
    for (int i = 0; i < 19; i++) {
        if (room[i] != 0) {
            int temp = room[i] - fa[index];
            if (temp >= 0 && temp <= flag) {
                flag = temp;
                result = i;
            }
        }
    }
    if (result != -1) {
        room[result] = 0;
    }
    flag = 100; // ��� ���һ���ҵ�����ûд��̫��ô�̼��ˡ�
    return result;
}

int main() {
    getFamNum();
    // �ж�
    int i = getRoom(0);
    int j = getRoom(1);
    int k = getRoom(2);
    int l = getRoom(3);
    if (i == -1) {
        printf("��1���ͥ û�к��ʵİ���\n");
    }
    else {
        printf("��1���ͥ��%d�Ű���Ͳ�\n", i);
    }
    if (j == -1) {
        printf("��2���ͥ û�к��ʵİ���\n");
    }
    else {
        printf("��2���ͥ��%d�Ű���Ͳ�\n", j);
    }
    if (k == -1) {
        printf("��3���ͥ û�к��ʵİ���\n");
    }
    else {
        printf("��3���ͥ��%d�Ű���Ͳ�\n", k);
    }
    if (l == -1) {
        printf("��4���ͥ û�к��ʵİ���\n");
    }
    else {
        printf("��4���ͥ��%d�Ű���Ͳ�\n", l);
    }


    /* ��д�򵥵����ַ������ */
    char c;
    printf("\t\t\t�������\n1-5 --- ����תӢ��\t\t\te --- ��������\n");
    do {
        c = getchar();
        // scanf_s("%c", &c);
        if (c == '1') {
            printf("one\n");
        } else if (c == '2') {
            printf("two\n");
        }
        else if (c == '3') {
            printf("three\n");
        }
        else if (c == '4') {
            printf("four\n");
        }
        else if (c == '5') {
            printf("five\n");
        }
    } while (c != 'e');

    /* ��д�����ж�һ��Ӣ�ľ��ӵ�����ĸ�Ƿ�ΪԪ����ĸ����ͳ�ƾ�����Ԫ����ĸ��a��e��i��o��u���ĸ����� */
    char c;
    int flag = 0, vowelCount = 0;
    printf("��������ӣ�\n");
    do {
        c = getchar();

        // �ж�����ĸ�Ƿ�ΪԪ����ĸ
        if (flag == 0) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                flag = 1;
            } else {
                flag = -1;
            }
        }

        // ͳ��Ԫ����ĸ����
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
        {
            vowelCount++;
        }
    } while (c != '.');

    // ��ӡ���
    if (flag == 1) {
        vowelCount++;
        printf("\n����ĸ��Ԫ����ĸ��");
    }
    printf("\n��%d��Ԫ����ĸ��", vowelCount);

    /* ������Ϸ */
    printf("��׿�ʼ����\n");
    int a = guess();
    int countA = count;
    printf("���ҿ�ʼ����\n");
    int b = guess();
    int countB = count;
    
    if (countA == countB) {
        printf("ƽ��\n");
    } else if (countA > countB) {
        printf("�һ�ʤ\n");
    } else {
        printf("�׻�ʤ\n");
    }

    /* ��Ҫ����ú�����ӡͼ�� */
    int i, k;
    printf("����������������3����");
    scanf_s("%d", &i);
    printf("��ѡ��ͼ�Σ�1---������  \t2---����\t3---С�� ��");
    scanf_s("%d", &k);
    // ���������ĿҪ��
    if (k == 1) {
        triangle(i);
    }
    else if (k == 2) {
        rectangle(i);
    }
    else if (k == 3) {
        triangle(i);
        rectangle(i);
    }

    /* ���ú��� */
    printf("%d\n", qshu(12345, 2));
    printf("%d\n", f(1) + f(2) + f(12) + f(15) + f(25));

    /* �ž� */
    for (int i = 1; i < 10; i++)
    {
        for (int j = 1; j < i + 1; j++)
        {
            printf("%d*%d=%d  ", i, j, i*j);
        }
        printf("\n");
    }

    /* ��30���ˣ���һ�ҷ�����Է�������50���ÿ�����˸���3���ÿ��Ů�˸���2���ÿ��С������1���
    �����ˡ�Ů�˺�С�����м��ˣ�(���ˡ�Ů�˺�С����������1��) */
    for (int i = 1; i < 30; i++)
    {
        for (int j = 1; j < 30; j++)
        {
            for (int k = 1; k < 30; k++)
            {
                if ((3 * i + 2 * j + 1 * k) == 50 && i + j + k == 30) {
                    printf("���ˣ�%d��Ů�ˣ�%d��С����%d��\n", i, j, k);
                }
            }
        }
    }

    /* ĳ�鱦�����������������������鱦����ʵ�۸�����8λ����ѡ��������Թ��Ƶļ۸񣬹�������ʵ�۸���ӽ���ѡ�ֻ�ʤ�� */
    float realPrice, mini, price;
    int num = 1;
    printf("��������ʵ�۸񣨵�λ����");
    scanf_s("%f", &realPrice);
    printf("��ѡ��������Ƶļ۸񣨵�λ����");
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
    printf("%d��ѡ�ֻ�ʤ����ӽ��Ĺ����ǣ�%.1f", num, mini);



    /* ����һ������n�������n������������n+1������������ɵ��������Ρ� */
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


    /* ����s=1+1/2+1/3+1/4+......+1/200��ֵ�����������4λС��������ȷ���Ϊ5.8780 */
    float s = 0.0, a = 1.0;
    for (int i = 1; i < 201; i++)
    {
        s += a / i;
    }
    printf("%.4f", s);

    /* ��������ʽ   ��p>0,q>0����������� q �ɷֽ�Ϊ2������a,b�Ļ�������a+b=p ����ô �Ϳɷֽ�Ϊ(x+a)(x+b) . */
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
        printf("�޷ֽ�ʽ");
    }


   /* ��һ��ѵ��300�ף��ڶ���ѵ��337.5�ף�������ѵ��379.688�ף�......��
   ��һ��ѵ��������ǰһ��� 1+1/8��������ж�ѧ���ڼ���ѵ���ĳ��ȿ�ʼ����10000�ף� */
    float totalDistance = 300;
    int day = 1;
    while (totalDistance <= 10000)
    {
        totalDistance = totalDistance * (1 + 1.0 / 8);
        day++;
    }
    printf("%d", day);


    /* ���1��1000֮������������3����2����5����3����7����2������Ҫ����������ÿ��5��������ÿ������롣 */
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