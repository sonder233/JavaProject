package bCh1.demo2;

import java.util.Optional;

public class OptionalGeneratorTest {
    public Optional<String> generateOpt(){
        return Optional.ofNullable("MY_VALUE");
    }
}
