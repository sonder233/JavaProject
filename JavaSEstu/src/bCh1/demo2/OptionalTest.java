package bCh1.demo2;

import bCh1.demo1.StreamTest1;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<OptionalGeneratorTest> optional = Optional.of(new OptionalGeneratorTest());
        Optional<String> result = optional.flatMap(x->x.generateOpt());
        Optional<String> result_ = optional.flatMap(OptionalGeneratorTest::generateOpt);
        System.out.println(optional.get().generateOpt());
    }
}
