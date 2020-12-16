package pattern.flyweight;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: stream
 * Date: 13-7-30
 * Time: 17:39
 * 行 不可共享享元
 */
public class Row implements Glyph {

    private List<Character> list = new ArrayList<Character>();

    @Override
    public void draw(Context context) {

    }

    public Row() {
    }

    public void setCharacter(Glyph r){
        list.add((Character) r);
    }

    public int getSize(){
        return list.size();
    }

    public String getRow(){
        StringBuilder sb = new StringBuilder();
        for(Character g:list){
            sb.append(g.getC());
        }
        return sb.toString();
    }
}
