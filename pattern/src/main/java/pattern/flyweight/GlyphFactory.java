package pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-7-30
 * Time: 17:41
 */
public class GlyphFactory {
    private Map<String,Glyph> map = new HashMap<String,Glyph>();

    public Glyph getGlyph(Context context){
        String cStr = context.getC()+"";
        Glyph gl = map.get(cStr);
        if(gl == null){
            gl = new Character(context.getC());
            map.put(cStr, gl);
        }
        gl.draw(context);
        return gl;
    }
}
