package fun.chaoxi.wing.module.lab;

/**
 * @author Wing Gao
 * @date 2018/12/19 16:22
 * @description
 */
public class Item {
    public String name;
    public boolean isSelect = false;
    public String imageUrl = "";
    public String background ="";
    public boolean isTitle = false;
    public int subItemCount = 0;

    public Item() {
    }

    public Item(String name, boolean isSelect, String imageUrl, String background, boolean isTitle, int subItemCount) {
        this.name = name;
        this.isSelect = isSelect;
        this.imageUrl = imageUrl;
        this.background = background;
        this.isTitle = isTitle;
        this.subItemCount = subItemCount;
    }
}
