import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.LowerCaseTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Created by liuzhijun on 2014/8/17.
 */
public class PlayerAnalyzer  extends Analyzer {
    @Override
    protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        return new TokenStreamComponents(new PlayerTokenizer(reader));
    }

    public static void main(String[] args) throws Exception{

        PlayerAnalyzer playerAnalyzer = new PlayerAnalyzer();
        TokenStream ts = playerAnalyzer.tokenStream("title", "科比·布莱恩特");
        System.out.println(ts);
        ts.reset();
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        while(ts.incrementToken()){
            System.out.println("["+term+"]");
        }

    }
}
