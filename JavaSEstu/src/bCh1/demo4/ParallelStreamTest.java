package bCh1.demo4;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ParallelStreamTest {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\JavaProject\\JavaSEstu\\src\\bCh1\\small_words.txt");
        Stream<String> stream = Files.lines(path, StandardCharsets.UTF_8);
        var contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));
        Map<Integer,Long> shortWordCounts = words.parallelStream()
                .filter(s -> s.length() < 10)
                .collect(groupingBy(String::length,counting()));
    }
}
