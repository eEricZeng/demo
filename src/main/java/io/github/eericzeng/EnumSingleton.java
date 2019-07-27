package io.github.eericzeng;

/**
 * 枚举型单例模式（线程安全）。
 *
 * @author zengguang
 * @since JDK1.5
 */
public class EnumSingleton {

    /**
     * 构造函数私有，不允许外部创建实例。
     */
    private EnumSingleton() {
    }

    /**
     * 
     * @return {@link EnumSingleton}的单实例
     */
    public static EnumSingleton getSingleton() {
        return Singleton.INSTANCE.getSingleton();
    }

    /**
     * 这种实现方式有点类似静态内部类，而且枚举类型本质还是一个类。
     */
    private enum Singleton {

        INSTANCE(new EnumSingleton());

        private EnumSingleton isntance;

        /**
         * 外部类作为构造参数
         * 
         * @param singleton
         *            外部类
         */
        private Singleton(EnumSingleton singleton) {
            this.isntance = singleton;
        }

        /**
         * 枚举类型持有的单实例
         * 
         * @return {@link EnumSingleton}的单实例
         */
        private EnumSingleton getSingleton() {
            return isntance;
        }
    }
}
