package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.Version;
//lucene:4.8之前的版本
//import org.apache.lucene.util.AttributeSource.AttributeFactory;
//lucene:4.9
import org.apache.lucene.util.AttributeFactory;

import java.io.Reader;
import java.util.Map;

/**
 * Created by liuzhijun on 2014/8/23.
 */
public class ProfessionalTokenizerFacotry extends TokenizerFactory {
    public ProfessionalTokenizerFacotry(Map<String, String> args) {
        super(args);
        assureMatchVersion();
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("Unknown parameters: " + args);
        }
    }

    @Override
    public Tokenizer create(AttributeFactory factory, Reader input) {
        return new ProfessionalTokenizer(factory, input);
    }
}
