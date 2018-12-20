package fun.chaoxi.wing.module.base;

/**
 * @author Wing Gao
 * @date 2018/12/17 15:22
 * @description View 必须是哑View，只能显示数据、响应操作，不能直接操作Model。
 */
public interface BaseView<T> {
    /**
     * 让View 持有Presenter，这样可以让View 在合适时机调用Presenter 中的方法来 请求|加载 数据。
     * @param presenter
     */
    void setPresenter(T presenter);
}
