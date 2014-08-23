import com.sponia.lucene.analysis.ProfessionalTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.StringReader;

/**
 * Created by liuzhijun on 2014/7/18.
 */
public class Test {

    private int age;

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws Exception{

//        PunctuationTokenizer playerAnalyzer = new PlayerAnalyzer();
//        TokenStream ts = playerAnalyzer.tokenStream("title", "科比·布莱恩特");
//        System.out.println(ts);
//        ts.reset();
//        CharTermAttribute term = ts.getAttribute(CharTermAttribute.class);
//        while(ts.incrementToken()){
//            System.out.println("["+term+"]");
//        }
//        PunctuationTokenizer punctuationTokenizer = new PunctuationTokenizer(Version.LUCENE_4_9, new StringReader("科比·布莱恩特"));
////        punctuationTokenizer.
//        PlayerNameMergerFilter playerNameMergerFilter = new PlayerNameMergerFilter(punctuationTokenizer);
//        playerNameMergerFilter.reset();
//        CharTermAttribute term = playerNameMergerFilter.getAttribute(CharTermAttribute.class);
//        while(playerNameMergerFilter.incrementToken()){
////            System.out.println("["+term+"]");
//        }

        ProfessionalTokenizer technicalToken = new ProfessionalTokenizer( new StringReader("J科比·布莱"));
        CharTermAttribute t = technicalToken.getAttribute(CharTermAttribute.class);
        technicalToken.reset();
        while(technicalToken.incrementToken()){
            System.out.println("["+t+"]");
        }

    }



}

abstract class Testab{
    abstract void hello();
}

class Testabi extends Testab{

    @Override
    void hello() {

    }
}