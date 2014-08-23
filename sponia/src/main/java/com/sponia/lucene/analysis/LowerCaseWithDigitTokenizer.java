package com.sponia.lucene.analysis;

import org.apache.lucene.analysis.core.LetterTokenizer;
import org.apache.lucene.analysis.util.CharTokenizer;
import org.apache.lucene.util.AttributeFactory;
import org.apache.lucene.util.Version;

import java.io.Reader;

/**
 * Created by liuzhijun on 2014/7/23.
 */
public class LowerCaseWithDigitTokenizer extends LetterTokenizer {

    /**
     * Construct a new LowerCaseWithDigitTokenizer.
     *
     * @param matchVersion Lucene version to match See {@link <a href="#version">above</a>}
     * @param in           the input to split up into tokens
     */
    public LowerCaseWithDigitTokenizer(Version matchVersion, Reader in) {
        super(matchVersion, in);
    }

    /**
     * Construct a new LowerCaseWithDigitTokenizer using a given
     * {@link org.apache.lucene.util.AttributeFactory}.
     *
     * @param matchVersion Lucene version to match See {@link <a href="#version">above</a>}
     * @param factory      the attribute factory to use for this {@link org.apache.lucene.analysis.Tokenizer}
     * @param in           the input to split up into tokens
     */
    public LowerCaseWithDigitTokenizer(Version matchVersion, AttributeFactory factory, Reader in) {
        super(matchVersion, factory, in);
    }

    /**
     * Converts char to lower case
     * {@link Character#toLowerCase(int)}.
     */
    @Override
    protected int normalize(int c) {
        return Character.toLowerCase(c);
    }

    /**
     * Collects only characters and digit which satisfy
     * {@link Character#isLetter(int)}.
     */
    @Override
    protected boolean isTokenChar(int c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}

