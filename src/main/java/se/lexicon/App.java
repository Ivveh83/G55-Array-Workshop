package se.lexicon;


import java.util.Arrays;

public class App {
    public static void main(String[] args) {

        int size = NameRepository.getSize();
        System.out.println(size);
        NameRepository.setNames(new String[]{"Erik Svensson", "Mehrdad Javan"});
        System.out.println(NameRepository.getSize());
        // call more methods as needed
        //        NameRepository.clear();
        //        System.out.println(NameRepository.getSize());
        System.out.println(Arrays.toString(NameRepository.findAll()));
        System.out.println(NameRepository.find("mehrdad javan"));
        System.out.println("Adding name: " + NameRepository.add("Ylva Högblom"));
        System.out.println("Adding name: " + NameRepository.add("ivar Högblom"));
        System.out.println("Adding name: " + NameRepository.add("Ivar Flinthjärta"));
        System.out.println(NameRepository.getSize());
        System.out.println(Arrays.toString(NameRepository.findByFirstName("ivar")));
        System.out.println(Arrays.toString(NameRepository.findByLastName("högblom")));
        System.out.println("Updating name: " + NameRepository.update("Ivar Flinthjärta", "Stål-Ivar Flinthjärta"));
        System.out.println("Updating name: " + NameRepository.update("ivar Högblom", "Ivar Högblom"));
        System.out.println(NameRepository.getSize());
        System.out.println("Array with name in: " + Arrays.toString(NameRepository.findByLastName("Flinthjärta")));
        System.out.println("Array with name in: " + Arrays.toString(NameRepository.findByFirstName("ivar")));
        System.out.println("Removing name: " + NameRepository.remove("Ivar Högblom"));
        System.out.println(NameRepository.getSize());
        System.out.println("Name in Array: " + Arrays.toString(NameRepository.findByFirstName("ivar")));
        System.out.println("Removing name: " + NameRepository.remove("Ivar Högblom"));
        System.out.println("Found name = " + Arrays.toString(NameRepository.findByFirstName("ivar")));
        System.out.println(NameRepository.getSize());

        String[] strings =  NameRepository.findAll();
        for (String name : strings){
            System.out.println(name);
        }
        System.out.println("Removing name: " + NameRepository.remove("Ylva Högblom"));
        String[] strings2 =  NameRepository.findAll();
        for (String name : strings2){
            System.out.println(name);
        }

    }
}
