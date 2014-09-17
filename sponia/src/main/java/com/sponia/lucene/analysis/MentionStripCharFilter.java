package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.charfilter.BaseCharFilter;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Created by liuzhijun on 2014/9/12.
 */
public class MentionStripCharFilter extends BaseCharFilter {

    private Reader transformedInput;

    public MentionStripCharFilter(Reader in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        if (transformedInput == null) {
            fill();
        }

        return transformedInput.read();
    }


    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        if (transformedInput == null) {
            fill();
        }
        return transformedInput.read(cbuf, off, len);
    }

    private void fill() throws IOException {
        StringBuilder buffered = new StringBuilder();
        char[] temp = new char[1024];
        for (int cnt = input.read(temp); cnt > 0; cnt = input.read(temp)) {
            buffered.append(temp, 0, cnt);
        }
        String pattern = "\\[\\w+\\([\\w:]+\\)(.*?)\\]";
        String source = buffered.toString();
        source = source.replaceAll("\\[", " \\[");
        source = source.replaceAll(pattern, "$1");
        transformedInput = new StringReader(source);
    }

    @Override
    protected int correct(int currentOff) {
        return Math.max(0,  super.correct(currentOff));
    }


}
