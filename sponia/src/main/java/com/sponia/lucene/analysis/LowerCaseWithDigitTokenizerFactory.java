package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;

import java.io.Reader;
import java.util.Map;

/**
 * Created by liuzhijun on 2014/7/23.
 */
public class LowerCaseWithDigitTokenizerFactory extends TokenizerFactory {

    public LowerCaseWithDigitTokenizerFactory(Map<String,String> args) {
        super(args);
        assureMatchVersion();
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("Unknown parameters: " + args);
        }
    }

    @Override
    public Tokenizer create(AttributeFactory factory, Reader input) {
        return new LowerCaseWithDigitTokenizer(luceneMatchVersion, factory, input);
    }
}
