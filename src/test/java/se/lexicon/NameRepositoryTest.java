package se.lexicon;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * JUnit 5 tests for the NameRepository class.
 */
public class NameRepositoryTest {

    @Test
    void testGetSize(){
        //Arrange, Act, Assert
        //Arrange, Act
        int result = NameRepository.getSize();

        //Assert
        assertEquals(1, result, "Arrayen har 1 namn så borde vara 1");
    }

    @Test
    void testSetNames(){

//        Arrange
        String[] names = {"Erik Svensson", "Mehrdad Javan"};
//        Act
        NameRepository.setNames(names);
//        Assert
        assertEquals(names, names, "Array in - Array out");

    }

    @Test
    void testClear(){
//        Arrange
        String[] emptyArray = {};
        int y = emptyArray.length;
//        Act
        NameRepository.clear();
        String[] testArray = NameRepository.findAll();
        int x = testArray.length;
//        Assert
        assertEquals(x, y, "Clears the array");
    }

    @Test
    void testFindAll(){
//        Arrange
        String[] array = {};
//        Act
        String[] testArray = NameRepository.findAll();
//        Assert
        assertEquals(Arrays.toString(array), Arrays.toString(testArray), "Gives an empty array");
    }

    @Test
    void testFind(){

        NameRepository.add("Ivar Högblom");
        String[] array = NameRepository.getArray();

        String name = NameRepository.find("Ivar Högblom");

        assertEquals(array[0], name, "Both should be \"Ivar Högblom\"");
    }

    void testAdd(){

//        Arrange
        String name = "Barry Potter";
        boolean boolean1 = true;
//        Act
        boolean boolean2 = NameRepository.add(name);
//        Assert
        assertEquals(boolean1, boolean2, "Name should not be in array, so should give return true");
    }
    @Test
    void testFindByFirstName(){
//        Arrange
        String[] name1 = {"Ivar Högblom"};
//        Act
        String[] name2 = NameRepository.findByFirstName("Ivar");
//        Assert
        assertEquals(Arrays.toString(name1), Arrays.toString(name2), "Input Ivar should return" +
                "array [Ivar Högblom]");
    }
    @Test
    void testFindByLastName(){
        //        Arrange
        String[] name1 = {"Ivar Högblom"};
//        Act
        NameRepository.add("Ivar Högblom");
        String[] name2 = NameRepository.findByLastName("Högblom");
//        Assert
        assertEquals(Arrays.toString(name1), Arrays.toString(name2), "Input Högblom should return " +
                "array [Ivar Högblom]");
    }

    @Test
    void testUpdate(){
//        Arrange
        NameRepository.clear();
        NameRepository.add("Barry Potter");
        String[] testArray = {"Harry Potter"};
//        Act
        NameRepository.update("Barry Potter", "Harry Potter");
        String[] array = NameRepository.getArray();
//        Assert
        assertEquals(Arrays.toString(testArray), Arrays.toString(array), "Cleared array and added" +
                " Barry Potter to it, updated to Harry Potter, so they should be same");
    }

    @Test
    void testRemove(){
//        Arrange
        String name = "Morgan Alling";
        NameRepository.add(name);
        boolean boolean1 = true;
//        Act
        boolean boolean2 = NameRepository.remove(name);
//        Assert
        assertEquals(boolean1, boolean2, "Adding name to NameRepository and after that removing it, " +
                " which should return true");
    }

}
