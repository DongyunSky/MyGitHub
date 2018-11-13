package fun.chaoxi.android.view.home;

import java.util.List;

import fun.chaoxi.android.common.base.BasePresenter;
import fun.chaoxi.android.common.base.BaseView;
import fun.chaoxi.android.common.bean.DriverTask;

/**
 * Create by Wing Gao on 2018/10/31 13:19
 */
public interface HomeContract {

    interface Presenter extends BasePresenter {

        void getTask(String status);

        void updateTaskStatus(String taskId, String taskStatus);

        void switchTask(String taskId);

        void uploadOverData(String overTime, String overKm, String overMoney, String taskId, String orderId);

        void getTaskDetail(String taskId);

        /**
         * 支付
         * @param orderId    支付订单号
         * @param taskId     任务号
         * @param payChannel 支付方式
         */
        void pay(String orderId, String taskId, String payChannel);
    }

    interface View extends BaseView<Presenter>{

        void showLoading(boolean b);

        void getTaskList(List<DriverTask> taskList);

        void waitPay(); // 等待用户支付的处理

        void setTaskDetail(String finalMoney,String isReport);

        void getPayMoneyResult();
    }
}
