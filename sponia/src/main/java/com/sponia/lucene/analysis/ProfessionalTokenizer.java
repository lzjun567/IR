package com.sponia.lucene.analysis;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.util.AttributeFactory;


/**
专用于分析专有名词
 */
public final class ProfessionalTokenizer extends Tokenizer {


    public ProfessionalTokenizer(Reader in) {
        super(in);
    }

    public ProfessionalTokenizer(AttributeFactory factory, Reader in) {
        super(factory, in);
    }

    private int offset = 0, bufferIndex = 0, dataLen = 0, fullBufferIndex=0;
    private final static int MAX_WORD_LEN = 255;
    private final static int IO_BUFFER_SIZE = 1024;
    private final static int MAX_NAME_LEN = 255;
    private final char[] buffer = new char[MAX_WORD_LEN];
    private final char[] ioBuffer = new char[IO_BUFFER_SIZE];
    //缓存整个字符串
    private final char[] fullBuffer = new char[MAX_NAME_LEN];

    private  final char[] firstChar = new char[1];


    private int length;
    private int start;

    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);

    private final void push(char c) {

        if (length == 0) start = offset - 1;            // start of token
        if (length < MAX_WORD_LEN)
        buffer[length++] = Character.toLowerCase(c);  // buffer it
        if (fullBufferIndex < MAX_NAME_LEN)
        fullBuffer[fullBufferIndex++] = Character.toLowerCase(c);


    }

    private final boolean flush() {

        if (length > 0) {
            termAtt.copyBuffer(buffer, 0, length);
            offsetAtt.setOffset(correctOffset(start), correctOffset(start + length));
            return true;
        } else if(fullBufferIndex>0){
            termAtt.copyBuffer(fullBuffer, 0, fullBufferIndex);
            offsetAtt.setOffset(correctOffset(0), correctOffset(fullBufferIndex));
            fullBufferIndex = 0;
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();

        length = 0;
        start = offset;


        while (true) {

            final char c;
            offset++;

            if (bufferIndex >= dataLen) {
                dataLen = input.read(ioBuffer);
                bufferIndex = 0;
            }

            if (dataLen == -1) {
                offset--;
                return flush();
            } else
                c = ioBuffer[bufferIndex++];


            switch (Character.getType(c)) {

                case Character.DECIMAL_DIGIT_NUMBER:
                case Character.LOWERCASE_LETTER:
                case Character.UPPERCASE_LETTER:
                    push(c);
                    if (length == MAX_WORD_LEN) return flush();
                    break;

                case Character.OTHER_LETTER:
                    push(c);
                    if (length == MAX_WORD_LEN) return flush();
                    break;

                default:
                    if (length > 0) return flush();
                    break;
            }
        }
    }

    @Override
    public final void end() throws IOException {
        super.end();
        // set final offset
        final int finalOffset = correctOffset(offset);
        this.offsetAtt.setOffset(finalOffset, finalOffset);
    }

    @Override
    public void reset() throws IOException {
        super.reset();
        offset = bufferIndex = dataLen = 0;
    }
}
