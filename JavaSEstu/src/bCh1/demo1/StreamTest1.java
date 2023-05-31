package bCh1.demo1;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) throws IOException {
        test_2();
    }
    public static Optional<Double> inverse(Double x){
        return x == 0 ? Optional.empty() : Optional.ofNullable(1/x);
//        return x == 0 ? Optional.empty() : Optional.of(1/x);
    }
    public static void test_3() {


    }
    public static void test_2() throws IOException {
        Path path = Paths.get("E:\\JavaProject\\JavaSEstu\\src\\bCh1\\test_words.txt");
        Path smallPath = Paths.get("E:\\JavaProject\\JavaSEstu\\src\\bCh1\\small_words.txt");
        var contents = new String(Files.readAllBytes(smallPath), StandardCharsets.UTF_8);
        List<String> words = List.of(contents.split("\\PL+"));
//        words.forEach(w -> System.out.println(w));
        Stream<String> fileStream = Files.lines(smallPath);
//        fileStream.forEach(x-> System.out.println(x));
        Stream<String> wordStream = words.stream();
//        var smallWordStream = wordStream.filter(w -> w.length()>15);
//        smallWordStream.forEach(w-> System.out.println(w));
        var upperWordStream = wordStream.map(w -> w.toUpperCase());
        upperWordStream.forEach(w -> System.out.println(w));
        Stream<String> sorted = fileStream.sorted(Comparator.comparing(a -> a.length()));
//        sorted.forEach(x-> System.out.println(x));
//        System.out.println(smallWordStream.count());
        Optional<String> longest = sorted.max((x,y) -> y.length()-x.length());
        System.out.println(longest.orElse(""));
    }
    public static void test(){
        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<String> words = Stream.of("Alloc","Bar","Candy");
        System.out.println(words.count());
        BigInteger limits = new BigInteger("100");
        Stream<BigInteger> integers = Stream.iterate(BigInteger.ZERO,
                n -> n.compareTo(limits) < 0,

                n -> n.add(BigInteger.ONE));
//        System.out.println(integers.count());//count()是一个终止操作，之后流会被关闭！！
//        integers.forEach(n -> System.out.println(n));
    }
}
