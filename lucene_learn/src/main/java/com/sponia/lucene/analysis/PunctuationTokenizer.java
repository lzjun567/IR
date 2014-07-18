package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.util.CharTokenizer;
import org.apache.lucene.util.Version;
import org.apache.lucene.util.AttributeSource.AttributeFactory;

import java.io.Reader;

/**
 * Created by liuzhijun on 2014/7/18.
 */
public class PunctuationTokenizer extends CharTokenizer {

    public PunctuationTokenizer(Version matchVersion, Reader in) {
        super(matchVersion, in);
    }

    public PunctuationTokenizer(Version matchVersion, AttributeFactory factory, Reader in) {
        super(matchVersion, factory, in);
    }

    @Override
    protected boolean isTokenChar(int c) {

        return c != ' ' && c != ',' && c != '.' && c != '·';
    }

}
