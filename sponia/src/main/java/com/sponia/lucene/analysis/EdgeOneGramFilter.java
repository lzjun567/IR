package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;

import java.io.IOException;

/**
 * Created by liuzhijun on 2014/8/23.
 * 把字符串的第一个字符分出来
 */
public class EdgeOneGramFilter extends TokenFilter {

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);
    private char[] curTermBuffer;
    private int curTermLength;
    private int tokStart;
    private int tokEnd; // only used if the length changed before this filter
    private boolean isFirst = false;

    public EdgeOneGramFilter(TokenStream ts) {
        super(ts);
    }

    @Override
    public boolean incrementToken() throws IOException {

        if (curTermBuffer==null){
            if (!input.incrementToken()) {
                return false;
            } else {
                curTermBuffer = termAtt.buffer().clone();
                curTermLength = termAtt.length();

                tokStart = offsetAtt.startOffset();
                tokEnd = offsetAtt.endOffset();
            }
        }
        clearAttributes();
        if (isFirst){
            termAtt.copyBuffer(curTermBuffer, 0, 1);
            offsetAtt.setOffset(tokStart, tokStart + 1);
            isFirst = false;
        }else{
            isFirst = true;
            termAtt.copyBuffer(curTermBuffer, 0, curTermLength);
            offsetAtt.setOffset(tokStart, tokEnd);
            curTermBuffer = null;
        }
        return true;


    }

}