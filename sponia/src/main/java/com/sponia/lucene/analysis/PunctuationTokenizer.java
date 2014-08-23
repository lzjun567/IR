package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.util.CharTokenizer;
import org.apache.lucene.util.Version;
//lucene:4.8之前的版本
//import org.apache.lucene.util.AttributeSource.AttributeFactory;
//lucene:4.9
import org.apache.lucene.util.AttributeFactory;

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
