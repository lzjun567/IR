import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

/**
 * Created by liuzhijun on 2014/8/17.
 * 科比·布莱恩特
 */
public class PlayerTokenizer extends Tokenizer {


    //词元文本属性
    private final CharTermAttribute termAtt;
    //词元位移属性
    private final OffsetAttribute offsetAtt;
    //词元分类属性（该属性分类参考org.wltea.analyzer.core.Lexeme中的分类常量）
    //记录最后一个词元的结束位置
    private int endPosition;

    @Override
    public boolean incrementToken() throws IOException {
        StringBuilder sb=new StringBuilder();
        BufferedReader br = new BufferedReader(this.input);
        String read = br.readLine();

        while(read != null) {
            sb.append(read);
            read =br.readLine();
        }
        String[] strs = sb.toString().split("·");
        for(int i=0;i<strs.length;i++){
            //清除所有的词元属性
            clearAttributes();
            //设置词元文本
            termAtt.append(strs[i]);
            //设置词元长度
            termAtt.setLength(strs[i].length());
            //设置词元位移
            offsetAtt.setOffset(0,20);
            //记录分词的最后位置
            endPosition = 3;
            //记录词元分类
            //返会true告知还有下个词元
            return true;
            //返会false告知词元输出完毕
        }
        return false;
    }


    public PlayerTokenizer(Reader in) {
        super(in);
        offsetAtt = addAttribute(OffsetAttribute.class);
        termAtt = addAttribute(CharTermAttribute.class);
    }
}
