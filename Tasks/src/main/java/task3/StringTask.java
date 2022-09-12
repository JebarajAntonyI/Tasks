package task3;
import java.util.Objects;
public class StringTask {
    private void checkNull(Object inputString) throws Exception {
        if (Objects.isNull(inputString)) {
            throw new Exception("Input Value is null");
        }
    }

    private void checkEmpty(String inputString) throws Exception {
        if (inputString.isEmpty()) {
            throw new Exception("Input value is empty");
        }
    }

    //EX1
    public int getLength(String inputString) throws Exception {
        checkNull(inputString);
        return inputString.length();
    }
    //EX2
    public char[] getCharArr(String inputString) throws Exception {
        checkNull(inputString);
        char[] chArray = inputString.toCharArray();
        return chArray;
    }
    //EX3
    public char getPenultimate(String inputString) throws Exception {
        int length = getLength(inputString);
        return inputString.charAt(length - 2);
    }
    //EX4
    public int getOccurance(String inputString, char character) throws Exception {
        char[] chArray = getCharArr(inputString);
        int number = 0, length = getLength(inputString);
        for (int i = 0; i < length; i++) {
            if (chArray[i] == character) {
                number++;
            }
        }
        return number;
    }
    //EX5
    public int getGreatestPosition(String inputString, char character) throws Exception {
        char[] chArray = getCharArr(inputString);
        int number = 0, length = getLength(inputString);
        for (int i = 0; i < length; i++) {
            if (chArray[i] == character) {
                number = i;
            }
        }
        if (number != 0) {
            return number + 1;
        } else {
            return 0;
        }
    }
    //EX6
    public String getLastNCharacters(String inputString, int index) throws Exception {
        if (getLength(inputString) >= index) {
            if (index < 0) {
                throw new Exception("The index value must be positive");
            }
            return inputString.substring(getLength(inputString) - index);
        } else {
            throw new Exception("The index value must not greater than string length");
        }
    }
    //EX7
    public String getFirstNCharacters(String inputString, int index) throws Exception {
        if (getLength(inputString) >= index) {
            if (index < 0) {
                throw new Exception("The index value must be positive");
            }
            return inputString.substring(0, index);
        } else
            throw new Exception("The index value must not greater than string length");
    }
    //EX8
    public String replaceFirstNCharacters(String inputString, String inputString2) throws Exception {
        if (getLength(inputString2) <= getLength(inputString)) {
            String outputString = "";
            outputString = inputString2 + inputString.substring(getLength(inputString2));
            return outputString;
        } else {
            throw new Exception("Replaceable string must be smaller than original string");
        }
    }
    //EX9
    public String compareFirstNCharacters(String inputString, String comparingString) throws Exception {
        if (getLength(comparingString) <= getLength(inputString)) {
            String stringSub = inputString.substring(0, getLength(comparingString));
            if (stringSub.equals(comparingString)) {
                return "Yes the string starts with " + comparingString;
            } else {
                return "No the string not starts with " + comparingString;
            }
        } else {
            throw new Exception("Comparing string must be smaller than original string");
        }
    }
    //EX10
    public String compareLastNCharacters(String inputString, String comparingString) throws Exception {
        if (getLength(comparingString) <= getLength(inputString)) {
            String stringSub = inputString.substring(getLength(inputString) - getLength(comparingString));
            if (stringSub.equals(comparingString)) {
                return "Yes the string ends with " + comparingString;
            } else {
                return "No the string not ends with " + comparingString;
            }
        } else {
            throw new Exception("Comparing string must be smaller than original string");
        }
    }
    //EX11
    public String convertToUppercase(String inputString) throws Exception {
        checkNull(inputString);
        return inputString.toLowerCase();
    }
    //EX12
    public String convertToLowercase(String inputString) throws Exception {
        checkNull(inputString);
        return inputString.toUpperCase();
    }
    //EX13
    public String getReverse(String inputString) throws Exception {
        String reverseString = "";
        int length = getLength(inputString);
        for (int i = 0; i < length; i++) {
            char character = inputString.charAt(i);
            reverseString = character + reverseString;
        }
        return reverseString;
    }
    //EX14
    public String[] stringToStringArray(String inputString) throws Exception {
        checkEmpty(inputString);
        checkNull(inputString);
        String[] stringArray = inputString.split(" ");
        return stringArray;
    }
    //EX15
    public String getStringWithoutSpace(String inputString) throws Exception {
        checkEmpty(inputString);
        checkNull(inputString);
        String outputString;
        outputString = inputString.replace(" ", "");
        return outputString;
    }
    //EX16
    public String[] getStringArray(String inputString) throws Exception {
        checkEmpty(inputString);
        checkNull(inputString);
        String[] stringArray = inputString.split(" ");
        return stringArray;
    }
    //EX17
    public String mergeStringsWithSymbols(String[] stringArray, int number, char symbol) throws Exception {
        checkNull(stringArray);
        String outputString = "";
        outputString = outputString + stringArray[0];
        for (int i = 1; i < number; i++) {
            outputString = outputString + symbol + stringArray[i];
        }
        return outputString;
    }
    //EX18
    public boolean compareCaseSensitive(String inputString, String inputString2) throws Exception {
        checkNull(inputString);
        checkNull(inputString2);
        boolean value;
        value = inputString.equals(inputString2);
        return value;
    }
    //EX19
    public boolean compareCaseInSensitive(String inputString, String inputString2) throws Exception {
        checkNull(inputString);
        checkNull(inputString2);
        boolean value;
        value = inputString.equalsIgnoreCase(inputString2);
        return value;
    }
    //EX20
    public String properString(String inputString) throws Exception {
        checkEmpty(inputString);
        checkNull(inputString);
        return inputString.trim();
    }
}