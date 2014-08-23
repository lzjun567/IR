package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by liuzhijun on 2014/8/17.
 */
public class PlayerNameMergerFilter extends TokenFilter {

    private CharTermAttribute charTermAttr = addAttribute(CharTermAttribute.class);
    //球员的全名
    private StringBuffer fullName = new StringBuffer();
    private boolean isEnd = false;
    public PlayerNameMergerFilter(TokenStream ts) {
        super(ts);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (isEnd){
            return false;
        }
        boolean rtn = input.incrementToken();
        if (rtn){
            fullName.append(charTermAttr);
            isEnd = false;
            return true;
        }else{
            charTermAttr.setEmpty();
            charTermAttr.append(fullName);
            isEnd= true;
            return true ;
        }

    }

}