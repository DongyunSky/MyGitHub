package fun.chaoxi.bet;

import java.util.Random;

/**
 * @author Wing Gao
 * @date 2018/12/12 16:33
 */
public class TestBet {

    public static String doBet(int money1, int money2, Double rate) {
        Gambler king = new Gambler("King", money1);
        Gambler luRen = new Gambler("LuRen", money2);
        System.out.println("\n" + king + "\n" + luRen);
        int count = 0;
        String winner = luRen.getName();
        // 赌到有人没钱
        try {
            for (;;) {
                TestBet.bet(king, luRen, rate);
                count++;
            }
        } catch (Exception e) {
            System.out.println("count: " + count);
            System.out.println(e.getMessage());
            if (king.getMoney() > 0) {
                winner = king.getName();
            }
        }
        return winner;
    }

    public static void bet(Gambler a, Gambler b, double rate) {
        int i = 10000;
        // 先确定两个人都有钱
        if (a.getMoney() == 0 || b.getMoney() == 0) {
            System.out.println("\n" + a + "\n" + b);
            throw new RuntimeException("有人没钱了");
        }
        // 模拟硬币正反面
        Random random = new Random();
        int randomI = random.nextInt(i);
        // 判断输赢
        if (randomI < i * rate) {
            a.setMoney(a.getMoney() + 1);
            b.setMoney(b.getMoney() - 1);
        } else {
            a.setMoney(a.getMoney() - 1);
            b.setMoney(b.getMoney() + 1);
        }
    }
}
