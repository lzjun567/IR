import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;

/**
 * Created by liuzhijun on 2014/8/5.
 */
public class AnalyzerTest {

    public static void main(String[] args) throws Exception{


        Analyzer analyzer = new SimpleAnalyzer();
        Directory directory = FSDirectory.open(new File("test"));
        IndexWriterConfig writerConfig = new IndexWriterConfig(Version.LUCENE_4_9, analyzer);
        IndexWriter writer = new IndexWriter(directory, writerConfig);

        Document doc = new Document();
//        Field field = new Field("title","this is the title", Field.Store.YES, Field.Index.ANALYZED);
        String s = "this is the title";
        for(int i=0; i< s.length(); i++){
            System.out.println((int)s.charAt(i)+"  "+(char)s.charAt(i));

        }
        Field titleField = new StringField("title", "this is the title", Field.Store.YES);
        doc.add(titleField);

        Field contentField = new TextField("contents", "this is content", Field.Store.NO);
        doc.add(contentField);


        writer.addDocument(doc);


    }
}
