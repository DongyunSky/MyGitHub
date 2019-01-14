package fun.chaoxi.wing.util;

/**
 * @author Wing Gao
 * @date 2019/1/8 15:27
 * @description
 */
public class AppUtil {

    /**
     * 判断字符串是否有内容
     * @param str 被判断的字符串
     * @return 是否有内容
     */
    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty() || "Null".equalsIgnoreCase(str);
    }
}
