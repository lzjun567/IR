import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.LowerCaseTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Created by liuzhijun on 2014/8/6.
 */
public class SimpleAnalyzer extends Analyzer {

    @Override
    protected TokenStreamComponents createComponents(String fieldName, Reader reader) {
        return new TokenStreamComponents(new LowerCaseTokenizer(Version.LUCENE_4_9, reader));
    }

    public static void main(String[] args) throws Exception{

        SimpleAnalyzer simpleAnalyzer = new SimpleAnalyzer();
        TokenStream ts = simpleAnalyzer.tokenStream("title", "this is AN title");
        ts.reset();
        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
        while(ts.incrementToken()){
            System.out.println("["+term+"]");
        }

    }
}
