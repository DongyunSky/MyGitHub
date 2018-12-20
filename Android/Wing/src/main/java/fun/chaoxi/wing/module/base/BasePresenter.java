package fun.chaoxi.wing.module.base;

/**
 * @author Wing Gao
 * @date 2018/12/17 15:23
 * @description Presenter 是Model 和View 的中间衔接层，一个标准的Presenter 中至少应该包含一个Model 和一个View。
 * View <--> Presenter <--> Model <--> Data
 * Presenter 不能直接操作数据
 */
public interface BasePresenter {
    void start();
}
