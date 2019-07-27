package io.github.eericzeng;

/**
 * 饿汉式单例，在第一次加载类到内存时进行初始化（线程安全）。
 * <p>
 * <strong>缺点：</strong>非懒加载模式，在实例依赖参数或配置文件时无法使用。
 * 
 * @author zengguang
 *
 */
public class StarveSingleton {

    /**
     * 第一次类加载时创建实例。
     */
    private static final StarveSingleton INSTANCE = new StarveSingleton();

    /**
     * 构造函数私有，不允许外部创建实例。
     */
    private StarveSingleton() {
    }

    /**
     * 直接返回类加载时创建的实例。
     * 
     * @return {@link StarveSingleton}的实例。
     */
    public static StarveSingleton getSingleton() {
        return INSTANCE;
    }
}
