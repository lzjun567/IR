package com.demo;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;

import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.charfilter.HTMLStripCharFilter;
import org.apache.lucene.analysis.core.LowerCaseFilter;
import org.apache.lucene.analysis.core.StopAnalyzer;
import org.apache.lucene.analysis.core.StopFilter;
import org.apache.lucene.analysis.core.WhitespaceTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.Version;

public final class Test {

    private static void displayTokens(TokenStream ts) throws IOException {
        CharTermAttribute termAttr = ts.addAttribute(CharTermAttribute.class);
        ts.reset();
        while (ts.incrementToken()) {
            String token = termAttr.toString();
            System.out.print("[" + token + "] ");
        }
        System.out.println();
        ts.end();
        ts.close();
    }

    public static void main(String[] args) throws Exception {
        String testinput =
         "<h1>HTMLStripCharFilter</h1> "
         + "<p><em><strong>strips html tags</strong></em></p>";
        
        
        Version ver=Version.LUCENE_47;

        Set<String> escapedTags=new HashSet<String>();
        escapedTags.add("title");
        escapedTags.add("h1");

        Reader reader =
            new HTMLStripCharFilter(new StringReader(testinput), escapedTags);
        WhitespaceTokenizer tokenizer =
            new WhitespaceTokenizer(ver, reader);
        TokenStream ts = new LowerCaseFilter(ver, tokenizer);
        ts = new StopFilter(ver, ts,
                    StopAnalyzer.ENGLISH_STOP_WORDS_SET);
        displayTokens(ts);
    }
}