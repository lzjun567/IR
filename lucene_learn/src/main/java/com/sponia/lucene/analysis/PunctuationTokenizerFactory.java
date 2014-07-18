package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeSource;
import org.apache.lucene.util.Version;

import java.io.Reader;
import java.util.Map;

/**
 * Created by liuzhijun on 2014/7/18.
 */
public class PunctuationTokenizerFactory extends TokenizerFactory {

    /** Creates a new WhitespaceTokenizerFactory */
    public PunctuationTokenizerFactory(Map<String,String> args) {
        super(args);
        assureMatchVersion();
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("Unknown parameters: " + args);
        }
    }

    @Override
    public Tokenizer create(AttributeSource.AttributeFactory factory, Reader input) {
        return new PunctuationTokenizer(Version.LUCENE_47, factory, input);
    }
}
