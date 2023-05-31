package bCh1.demo3;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest2 {
    public static void main(String[] args) {
        //收集到映射表中
        Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        Map<String,String> languageNames = locales.collect(
                Collectors.toMap(Locale::getDisplayLanguage,
                        locale -> locale.getDisplayLanguage(locale),
                        (existing,newValue)->existing));
        Map<String, Set<String>> countryLan = locales.collect(
                Collectors.toMap(
                        Locale::getDisplayCountry,
                        locale -> Collections.singleton(locale.getDisplayLanguage()),
                        (a,b) -> {
                            var union = new HashSet<String>(a);
                            union.addAll(b);
                            return union;
                        }
                )
        );
        Stream<People> peopleStream = Stream.of(new People("1","Lisa"),new People("5","Peter")  );
        Map<String,People> idToPeople = peopleStream.collect(Collectors.toMap(
                People::getId,Function.identity()
        ));
        Map<String,List<Locale>> countryToLocals = locales.collect(
                Collectors.groupingBy(Locale::getCountry));
//        Function.identity(); // t -> t;
        Map<Boolean,List<Locale>> englishCountry = locales.collect(
                Collectors.partitioningBy(lan -> lan.getLanguage().equals("en")));
        List<Locale> englishLocales = englishCountry.get(true);
        System.out.println("end");
    }
}
class People{
    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public People(String id, String name) {
        this.id = id;
        this.name = name;

    }
}
