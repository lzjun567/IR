package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.CharFilter;
import org.apache.lucene.analysis.util.CharFilterFactory;

import java.io.Reader;
import java.util.Map;

/**
 * Created by liuzhijun on 2014/9/12.
 */
public class MentionStripCharFilterFactory extends CharFilterFactory {
    public MentionStripCharFilterFactory(Map<String, String> args) {
        super(args);
    }

    @Override
    public CharFilter create(Reader input) {
        return new MentionStripCharFilter(input);
    }
}

