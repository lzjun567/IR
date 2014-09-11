package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.util.AbstractAnalysisFactory;
import org.apache.lucene.analysis.util.MultiTermAwareComponent;
import org.apache.lucene.analysis.util.TokenFilterFactory;

import java.util.Map;


/**
* Created by liuzhijun on 2014/8/17.
*/
public class EdgeOneGramFilterFactory extends TokenFilterFactory implements MultiTermAwareComponent {

    /**
     * Initialize this factory via a set of key-value pairs.
     *
     * @param args
     */
    public EdgeOneGramFilterFactory(Map<String, String> args) {
        super(args);
        assureMatchVersion();
        if (!args.isEmpty()) {
            throw new IllegalArgumentException("Unknown parameters: " + args);
        }
    }

    @Override
    public EdgeOneGramFilter create(TokenStream input) {
        return new EdgeOneGramFilter(input);
    }



    @Override
    public AbstractAnalysisFactory getMultiTermComponent() {
        return this;
    }
}
