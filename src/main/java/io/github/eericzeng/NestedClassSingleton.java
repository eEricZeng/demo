package io.github.eericzeng;

/**
 * 静态内部类单例（懒汉式，线程安全）。
 *
 * @author zengguang
 *
 */
public class NestedClassSingleton {

    /**
     * 构造函数私有，不允许外部创建实例。
     */
    private NestedClassSingleton() {
    }

    /**
     * 静态内部类只有在第一次引用的时候才会被加载。
     * 
     * @return {@link NestedClassSingleton}的单实例。
     */
    public static NestedClassSingleton getSingleton() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 内部类，且为私有的，只有{@link NestedClassSingleton}本身才能访问。
     */
    private static class SingletonHolder {
        private static final NestedClassSingleton INSTANCE = new NestedClassSingleton();
    }
}
