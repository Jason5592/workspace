package pattern.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-7-30
 * Time: 17:37
 * 抽象享元
 * 这里假定文章由行对象组成，行对象由若干个字符对象组成，
 * 但是如果每个字符都保存自己的对象，那么一篇文章成千上万个字符对象，
 * 这样严重消耗系统内存，造成不可接受的运行时开销，好的方法是利用享元模式，
 * 只保存ASCII字符编码值，作为内部不变的状态，对当个字符对象进行共享，而相对字符颜色、
 * 大小这样的格式化数据作为外部状态，由客户端维护，运行时由外部传入即可。
 * 每个行作为不可共享享元对象，它是由享元对象（字符对象）组合而成的。
 */
public interface Glyph {
    public void draw(Context context);
}
