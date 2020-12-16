package pattern.flyweight;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-7-30
 * Time: 17:42
 * To change this template use File | Settings | File Templates.
 */
public class Client {

    public static void main(String[] args) {
        Row r =new Row();
        GlyphFactory factory = new GlyphFactory();
        Context context1= new Context(12, 'a');
        Glyph gly1 = factory.getGlyph(context1);
        r.setCharacter(gly1);

        Context context2= new Context(13, 'a');
        Glyph gly2 = factory.getGlyph(context2);
        r.setCharacter(gly2);

        Context context3= new Context(13, 'b');
        Glyph gly3 = factory.getGlyph(context3);
        r.setCharacter(gly3);

        System.out.println(r.getRow());

    }
}
