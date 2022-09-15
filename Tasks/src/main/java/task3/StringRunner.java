package task3;

import java.util.Scanner;

import myException.UserDefinedException;

public class StringRunner 
{
    static Scanner scan = new Scanner(System.in);

    public String getStringInput() 
    {
        String inputString;
        System.out.println("Enter the String ");
        inputString = scan.next();
        return inputString;
    }

    public String getStringLineInput() 
    {
        String inputString;
        System.out.println("Enter the String in line");
        scan.nextLine();
        inputString = scan.nextLine();
        return inputString;
    }

    public int getIntegerInput(int number) 
    {
        boolean value = true;
        while (value) {
            if (scan.hasNextInt()) 
            {
                number = scan.nextInt();
                value = false;
            } 
            else 
            {
                scan.next();
                System.out.println("Enter the value in Integer: ");
            }
        }
        return number;
    }


    public static void main(String[] args) throws UserDefinedException 
    {
        StringRunner get = new StringRunner();
        StringTask run = new StringTask();
        System.out.print("Enter the Exercise number in which you want to perform actions: ");
        int experiment = get.getIntegerInput(0);
        char character = '\0';
        String inputString = null, inputString2 = null, outputString = null, comparingString = null;
        String[] stringArray = {};
        int length = 0, occurance = 0, position = 0, index = 0;
        char[] chArray = {};
        boolean value = false;
        while (experiment != 0) 
        {
            switch (experiment) 
            {
                case 1: 
                {
                    if (args.length != 0) 
                    {
                        try 
                        {
                            length = run.getLength(args[0]);
                            System.out.println("Length of the String is " + length);
                        } 
                        catch (Exception e) 
                        {
                            System.out.println(e);
                        }
                    } 
                    else 
                    {
                        System.out.println("No String available");
                    }
                    break;
                }
                case 2: 
                {
                    inputString = get.getStringInput();
                    try 
                    {
                        chArray = run.getCharArr(inputString);
                        System.out.print("char arr of the String is: ");
                        for (int i = 0; i < chArray.length; i++) 
                        {
                            System.out.print(chArray[i] + " ");
                        }
                        System.out.println();
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 3: 
                {
                    inputString = get.getStringInput();
                    try 
                    {
                        character = run.getPenultimate(inputString);
                        System.out.println("The before Last letter in the String is " + character);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 4: 
                {
                    inputString = get.getStringInput();
                    System.out.println("Enter the letter you want to find occurance: ");
                    character = scan.next().charAt(0);
                    try 
                    {
                        occurance = run.getOccurance(inputString, character);
                        System.out.println("The number of occurance of the given letter is " + occurance);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 5: 
                {
                    inputString = get.getStringInput();
                    System.out.println("Enter the letter you want to find greatest position: ");
                    character = scan.next().charAt(0);
                    try 
                    {
                        position = run.getGreatestPosition(inputString, character);
                        if (position != 0) 
                        {
                            System.out.println("The Greatest Position of the given letter is: " + (position));
                        } 
                        else 
                        {
                            System.out.println("The given letter is not available");
                        }
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 6: 
                {
                    inputString = get.getStringInput();
                    System.out.println("Enter how many index from last you want to print: ");
                    index = get.getIntegerInput(index);
                    try 
                    {
                        outputString = run.getLastNCharacters(inputString, index);
                        System.out.println("");
                        System.out.println(outputString);
                        System.out.println("");
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 7: 
                {
                    inputString = get.getStringInput();
                    System.out.println("Enter how many index from first you want to print: ");
                    index = get.getIntegerInput(index);
                    try 
                    {
                        outputString = run.getFirstNCharacters(inputString, index);
                        System.out.println("");
                        System.out.println(outputString);
                        System.out.println("");
                    }
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 8: 
                {
                    inputString = get.getStringInput();
                    System.out.println("Enter first letters to replace: ");
                    inputString2 = scan.next();
                    try 
                    {
                        outputString = run.replaceFirstNCharacters(inputString, inputString2);
                        System.out.println("");
                        System.out.println(outputString);
                        System.out.println("");
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 9: 
                {
                    inputString = get.getStringInput();
                    System.out.println("Enter the starting letters to compare: ");
                    comparingString = scan.next();
                    try 
                    {
                        value = run.compareFirstNCharacters(inputString, comparingString);
                        System.out.println("");
                        System.out.println(value);
                        System.out.println("");
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 10: 
                {
                    inputString = get.getStringInput();
                    System.out.println("Enter the Last letters to compare: ");
                    comparingString = scan.next();
                    try 
                    {
                        value = run.compareLastNCharacters(inputString, comparingString);
                        System.out.println("");
                        System.out.println(value);
                        System.out.println("");
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 11: 
                {
                    inputString = get.getStringInput();
                    try 
                    {
                        outputString = run.convertToUppercase(inputString);
                        System.out.println("String to lowercase is: " + outputString);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 12: 
                {
                    inputString = get.getStringInput();
                    try 
                    {
                        outputString = run.convertToLowercase(inputString);
                        System.out.println("String to uppercase is: " + outputString);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 13: 
                {
                    inputString = get.getStringInput();
                    try 
                    {
                        outputString = run.getReverse(inputString);
                        System.out.println("The reverse of the String is: " + outputString);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 14: 
                {
                    int space = 1;
                    inputString = get.getStringLineInput();
                    try 
                    {
                        stringArray = run.stringToStringArray(inputString);
                        space = stringArray.length;
                        for (int i = 0; i < space; i++) 
                        {
                            System.out.print(stringArray[i] + " ");
                        }
                        System.out.println("");
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 15: 
                {
                    inputString = get.getStringLineInput();
                    try 
                    {
                        outputString = run.getStringWithoutSpace(inputString);
                        System.out.println("Without space is: " + outputString);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 16: 
                {
                    int space = 1;
                    inputString = get.getStringLineInput();
                    try 
                    {
                        stringArray = run.stringToStringArray(inputString);
                        for (int i = 0; i < run.getLength(inputString); i++) 
                        {
                            if (inputString.charAt(i) == ' ')
                                space++;
                        }
                        for (int i = 0; i < space; i++) 
                        {
                            System.out.print('"' + stringArray[i] + '"');
                        }
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    System.out.println();
                    break;
                }
                case 17: 
                {
                    System.out.println("Enter how many words you want to enter: ");
                    int number = get.getIntegerInput(index);
                    String[] stringArray2 = new String[number];
                    System.out.println("Enter the Strings ");
                    for (int i = 0; i < number; i++) 
                    {
                        stringArray2[i] = scan.next();
                    }
                    System.out.println("Enter any Symbol to replace: ");
                    String symbol = scan.next();
                    try 
                    {
                        outputString = run.mergeStringsWithSymbols(stringArray2, number, symbol);
                        System.out.println("Output string is: " + outputString);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 18: 
                {
                    System.out.println("Enter two Strings ");
                    inputString = scan.next();
                    inputString2 = scan.next();
                    try 
                    {
                        value = run.compareCaseSensitive(inputString, inputString2);
                        System.out.println(value);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 19: 
                {
                    System.out.println("Enter two Strings ");
                    inputString = scan.next();
                    inputString2 = scan.next();
                    try 
                    {
                        value = run.compareCaseInSensitive(inputString, inputString2);
                        System.out.println(value);
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e);
                    }
                    break;
                }
                case 20: 
                {
                    inputString = get.getStringLineInput();
                    try 
                    {
                        outputString = run.properString(inputString);
                        System.out.println("");
                        System.out.println("Output without begining and end spaces :" + outputString);
                    } 
                    catch (Exception e)
                    {
                        System.out.println(e);
                    }
                    break;
                }
                default: 
                {
                    System.out.println("Enter value between 1 and 20");
                    break;
                }
            }
            System.out.println("If you want to close the program enter 0");
        System.out.print("Enter the Exercise number in which you want to perform actions: ");
            experiment = get.getIntegerInput(0);
        }
    }
}