## 安卓笔记

#### Dagger2
Android和Java平台的完全静态的编译时依赖注入框架。
说到依赖注入就离不开IOC控制反转。
IOC需要来一个容器放需要用到的对象，然后用的时候去容器中取，这样就从依赖类变为依赖容器。
这样就实现了解耦，而MVP框架就是为了解耦而生，所以MVP和Dagger是绝配。

通常在另一个类中用到一个类要`new`，有了Dagger就不需要了。

@Inject
@Module
@Component
@Provide

再要注入的类的构造方法上加注解`@Inject`，用到的地方也用`@Inject`注入。
`@Inject`不能注解多个构造函数。

`@Module` + `@Provides`

`@Component(modules = Xxxx.class)`



