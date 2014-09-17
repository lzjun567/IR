package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.KeywordTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuzhijun on 2014/9/11.
 */
public class MentionStripFilter extends TokenFilter {
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final String PATTERN = "\\[\\w+\\([\\w:]+\\)(.*?)\\]";

    public MentionStripFilter(TokenStream in) {
        super(in);
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (!input.incrementToken()) return false;
        String source = termAtt.toString();
        source = source.replaceAll("\\[", " \\[");
        termAtt.setEmpty().append(source.replaceAll(this.PATTERN, "$1"));
        return true;
    }
}
