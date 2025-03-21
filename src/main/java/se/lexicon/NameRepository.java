package se.lexicon;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

/**
 * The NameRepository class provides methods to manage a list of names.
 * It offers functionalities such as adding, removing, finding, and updating names.
 */
public class NameRepository {

    private static String[] names = new String[0];


    /**
     * Retrieves the current size of the names array.
     *
     * @return The number of elements in the names array.
     */
    public static int getSize() {
        //todo: implement getSize method
        return names.length;
    }


    /**
     * Sets the names array to the provided array of names & it should replace all existing names.
     *
     * @param names The array of names to set.
     */
    public static void setNames(String[] names) {
        //todo: implement setNames method
        NameRepository.names = names;
    }


    /**
     * Clears the names array by creating a new empty array.
     */
    public static void clear() {
        //todo: implement clear method
        NameRepository.names = new String[0];
    }


    /**
     * Returns all names in a new array (Retrieves a copy of the names array).
     *
     * @return A new array containing all elements from the names array.
     */
    public static String[] findAll() {
        //todo: implement findAll method
        String[] newArray = Arrays.copyOf(NameRepository.names, NameRepository.names.length);
        return newArray;
    }


    /**
     * Finds a name that matches the given fullName case-insensitively.
     *
     * @param fullName The full name to search for.
     * @return The matching name if found; otherwise, null.
     */
    public static String find(String fullName) {
        //todo: implement find method
        for (String name : NameRepository.names) {
            if (fullName.equalsIgnoreCase(name)) {
                return name;
            }
        }
        return null;
    }


    /**
     * Adds a new fullName to the names array if it doesn't already exist.
     *
     * @param fullName The full name to add.
     * @return True if the fullName is added successfully; false if it already exists.
     */
    public static boolean add(String fullName) {
        //todo: implement add method
        for (String name : NameRepository.names) {
            if (name.equals(fullName)) {
                return false;
            }
        }
        NameRepository.names = Arrays.copyOf(NameRepository.names, NameRepository.names.length + 1);
        NameRepository.names[NameRepository.names.length - 1] = fullName;
        return true;
    }


    /**
     * Find all names that match the given firstName.
     *
     * @param firstName The first name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByFirstName(String firstName) {
        //todo: findByFirstName method
        String[] matchingNames = new String[0];
        for (String fullName : NameRepository.names) {
            if (fullName.substring(0, fullName.indexOf(" ")).equalsIgnoreCase(firstName)) {
                matchingNames = Arrays.copyOf(matchingNames, matchingNames.length + 1);
                matchingNames[matchingNames.length - 1] = fullName;
            }
        }
        if (matchingNames.length > 0) {
            return matchingNames;
        } else {
            return null;
        }
    }


    /**
     * Find all names that match the given lastName.
     *
     * @param lastName The last name to search for.
     * @return An array containing all matching names.
     */
    public static String[] findByLastName(String lastName) {
        //todo: implement findByLastName method
        String[] matchingNames = new String[0];
        for (String fullName : NameRepository.names) {
            if (fullName.substring(fullName.indexOf(" ") + 1).equalsIgnoreCase(lastName)) {
                matchingNames = Arrays.copyOf(matchingNames, matchingNames.length + 1);
                matchingNames[matchingNames.length - 1] = fullName;
            }
        }
        if (matchingNames.length > 0) {
            return matchingNames;
        } else {
            return null;
        }
    }


    /**
     * Updates a name in the names array from the original name to the updated name.
     *
     * @param original    The original name to update.
     * @param updatedName The updated name to set.
     * @return True if the name is updated successfully; false if the updated name already exists or the original name is not found.
     */
    public static boolean update(String original, String updatedName) {
        //todo: implement update method
        for (int i = 0; i < NameRepository.names.length; i++) {
            if (NameRepository.names[i].equalsIgnoreCase(original)) {
                if (NameRepository.names[i].equals(updatedName)) {
                    return false;
                } else {
                    NameRepository.names[i] = updatedName;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Removes a name from the names array, case-insensitively.
     *
     * @param fullName The full name to remove.
     * @return True if the name is removed successfully; false if the name is not found in the array.
     * skapa en ny array som är en indexpostion kortare än names
     * kolla om namnet finns i arrayen
     * om namnet finns ska det inte med i den nya arrayen
     * alla andra namn ska med i den nya arrayen
     */
    public static boolean remove(String fullName) {
        //todo: implement remove method
        boolean shouldReturn = false;
        String[] newNames = new String[NameRepository.names.length];
        if (find(fullName) != null){
            newNames = new String[NameRepository.names.length - 1];
        }

        for (int i = 0, j = 0; i < NameRepository.names.length; i++) {
            if (!NameRepository.names[i].equalsIgnoreCase(fullName)) {
                newNames[j] = NameRepository.names[i];
                j++;
            }else {
                shouldReturn = true;
            }
        }
        if (shouldReturn){
            NameRepository.setNames(newNames);
            return true;
        }else {
            return false;
        }
    }

}