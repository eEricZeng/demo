package io.github.eericzeng;

/**
 * 双检锁单例模式（懒汉式，线程安全）。
 * <p>
 * <strong>注意:</strong>JDK1.5之前的版本volatile声明不一定起作用。
 * 
 * @author zengguang
 * @since JDK1.5
 */
public class DoubleCheckSingleton {

    /**
     * 一定要有<strong>volatile</strong>修饰，否则instance受指令重排的影响会返回一个空对象。
     */
    private volatile static DoubleCheckSingleton instance;

    /**
     * 构造函数私有，不允许外部创建实例。
     */
    private DoubleCheckSingleton() {
    }

    /**
     * 返回一个单例，当第一次调用时才创建一个实例。
     * <p>
     * <code>instance = new DoubleCheckSingleton();</code>并非源自操作，JVM中该行代码做了如下操作：
     * <ol>
     * <li>给instance分配内存</li>
     * <li>调用{@link DoubleCheckSingleton}的构造函数来初始化成员变量</li>
     * <li>将instance对象指向分配的内存空间</li>
     * </ol>
     * JVM在做指令重排时，并不能保证2/3步的顺序，顺序可能是1-2-3或者1-3-2，所以其他线程调用时可能{@link DoubleCheckSingleton}还没有初始化，进而出现NPE的问题。所以在instance变量声明需要加{@code volatile}修饰。
     * 
     * @return {@link DoubleCheckSingleton}的单实例。
     */
    public static DoubleCheckSingleton getSingleton() {
        if (null == instance) {
            synchronized (DoubleCheckSingleton.class) {
                if (null == instance) {
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
