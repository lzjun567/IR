package org.wltea.analyzer.lucene;

import java.io.IOException;
import java.io.Reader;

import org.apache.lucene.analysis.charfilter.BaseCharFilter;

/**
 * 过滤mention结构中的无用字符
 * @author liuzhijun
 *
 */
public class MentionStripCharFilter extends BaseCharFilter{

	public MentionStripCharFilter(Reader in) {
		super(in);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int read(char[] cbuf, int off, int len) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
