import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.IOException;

/**
 * Created by liuzhijun on 2014/8/29.
 */
public class FirstDemo {


    static Directory directory = null;

    public static void main(String[] args) throws IOException{

        System.out.println(Math.abs(333));
        //内存索引
        directory = new RAMDirectory();
        //文件索引
        directory = FSDirectory.open(new File("/tmp/"));

//        index();
//        search();
//        IndexWriter indexWriter = getIndexWriter();
//        indexWriter.deleteAll();
//        indexWriter.commit();
        search();
}

    public static void search() throws IOException{
        DirectoryReader reader = DirectoryReader.open(directory);
        System.out.println(reader.numDocs());
        System.out.println(reader.getDocCount("content"));
        System.out.println(reader.getRefCount());

    }

    public static void  index() throws IOException{

        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_4_9);

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_9, analyzer);

        IndexWriter writer = new IndexWriter(directory, config);

        Document doc = new Document();

        doc.add(new Field("content", "这个是将要被索引的内容", TextField.TYPE_STORED));

        writer.addDocument(doc);
        writer.close();
    }

    public static IndexWriter getIndexWriter() throws IOException{
        Analyzer analyzer = new StandardAnalyzer(Version.LUCENE_4_9);

        IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_4_9, analyzer);

        IndexWriter writer = new IndexWriter(directory, config);

        return writer;
    }

    public static void deleteAll() throws IOException{
        IndexWriter indexWriter = getIndexWriter();
        indexWriter.deleteAll();
        indexWriter.commit();
    }
}
