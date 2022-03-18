import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Classname TestMain
 * @Description TODO
 * @Date 2022/3/18 8:47
 * @Created by HUI
 */
public class TestMain {
    public static void main(String[] args) throws Exception{
        String path = "D:\\project\\java\\wms\\wms-web\\wms_new.html";
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line = "";
        StringBuffer sb = new StringBuffer();
        while (null != (line = reader.readLine())) {
            sb.append(line);
        }
        Pattern pattern = Pattern.compile("[\\u4E00-\\u9FA5]{1,20}");
        Matcher matcher = pattern.matcher(sb);
        Set<String> sets = new HashSet<>();
        StringBuilder sb2 = new StringBuilder();
        while (matcher.find()) {
            sets.add(matcher.group());
        }
        sets.forEach((s) -> {
            sb2.append(s + "\n");
        });
        BufferedWriter write = new BufferedWriter(new FileWriter("G:\\hadooptest\\入库页面wms_new.txt"));
        write.write(sb2.toString());
        write.flush();
        write.close();
        reader.close();
        System.out.println(sb2);
    }
}
