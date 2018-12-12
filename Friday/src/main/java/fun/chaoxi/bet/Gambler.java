package fun.chaoxi.bet;

/**
 * @author Wing Gao
 * @date 2018/12/12 16:34
 * @description 赌徒的实体
 */
public class Gambler {
    private String name;
    private long money;

    public Gambler() {
    }

    public Gambler(String name, long money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Gambler{" +
                "name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
