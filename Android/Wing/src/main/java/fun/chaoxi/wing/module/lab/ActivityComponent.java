package fun.chaoxi.wing.module.lab;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Wing Gao
 * @date 2019/1/7 13:54
 * @description Dagger的连接注入器
 */
@Singleton
@Component
public interface ActivityComponent {
    void inject(TestDagger activity);
}
