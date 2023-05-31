package bCh1.demo3;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\JavaProject\\JavaSEstu\\src\\bCh1\\small_words.txt");
        Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8);
        //收集到列表
//        List<String> list = stream.collect(Collectors.toList());
//        TreeSet<String> treeSet = stream.collect(Collectors.toCollection(TreeSet::new));
//        String results = stream.collect(Collectors.joining());
        IntSummaryStatistics sum = stream.collect(Collectors.summarizingInt(x -> x.length()));
        double average = sum.getAverage();
        double maxWordLength = sum.getMax();
        System.out.println(average + "," + maxWordLength);
    }

}
