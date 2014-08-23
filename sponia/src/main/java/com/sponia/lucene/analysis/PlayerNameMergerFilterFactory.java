package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.AbstractAnalysisFactory;
import org.apache.lucene.analysis.util.MultiTermAwareComponent;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.util.Map;


/**
* Created by liuzhijun on 2014/8/17.
*/
public class PlayerNameMergerFilterFactory extends TokenFilterFactory implements MultiTermAwareComponent {

    /**
     * Initialize this factory via a set of key-value pairs.
     *
     * @param args
     */
    public PlayerNameMergerFilterFactory(Map<String, String> args) {
        super(args);
        assureMatchVersion();
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("Unknown parameters: " + args);
        }
    }

    @Override
    public PlayerNameMergerFilter create(TokenStream input) {
        return new PlayerNameMergerFilter(input);
    }



    @Override
    public AbstractAnalysisFactory getMultiTermComponent() {
        return this;
    }
}
