import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuzhijun on 2014/9/11.
 */
public class Hello {

    public Hello(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {

        String str = "\\[\\w+\\([\\w:]+\\)(.*?)\\]";
        String source = "fhdhgfjhgkjhkjhljfugdayg f fkhggkhg[user(e9eae6ddc4c3446a868405c43fc542f3)平克斯喝小酒]<br>[competition(soccer:1777757)立陶宛 vs 阿联酋][competition(soccer:1668283)德国 vs 阿根廷][group(52d539f6fa6aa00e9ce2e90a)测试群组][group(53089590fa6aa06b707252b4)测试报 bug 专用圈子][team(soccer:2016)皇家马德里][team(soccer:676)曼城][person(soccer:119)梅西][person(soccer:16046)纳什]";
        source = source.replaceAll("\\[", " \\[");
        System.out.println(source);
        System.out.println(source.replaceAll(str, "$1"));

    }
}


class Sub extends Hello{

    public Sub(){
        super("aaa");
    }
}