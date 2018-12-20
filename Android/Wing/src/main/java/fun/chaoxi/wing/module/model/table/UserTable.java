package fun.chaoxi.wing.module.model.table;

/**
 * @author Wing Gao
 * @date 2018/12/17 16:07
 * @description 用户表结构
 */
public class UserTable {

    /**
     * 用户表
     */
    public static final String TABLE_NAME = "User";

    /**
     * 字段
     */
    public static final String ID = "id";
    public static final String USERNAME = "name";
    public static final String PASSWORD = "isEnable";
    public static final String NAME = "position";
    public static final String PHONE = "position";

    /**
     * 字段ID
     */
    public static final int ID_ID = 0;
    public static final int ID_USERNAME = 1;
    public static final int ID_PASSWORD = 2;
    public static final int ID_NAME = 3;
    public static final int ID_PHONE = 4;

    /**
     * 创建表
     */
    public static final String CREATE_TABLE = "" +
            "create table if not exists " + TABLE_NAME + "(" +
            ID + " text primary key, " +
            USERNAME + " text, " +
            PASSWORD + " text, " +
            NAME + " text," +
            PHONE + " text)";
}
