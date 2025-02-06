Java Program Documentation: Basic Calculator
Overview
This Java program simulates a basic calculator that performs operations such as addition, subtraction, multiplication, and division on two numbers provided by the user. The program ensures that the inputs are valid before proceeding with the calculation. If invalid inputs are entered (non-numeric values or inappropriate options), the user is prompted to re-enter valid values.

Functionalities
User Input Validation: The program checks if the entered values are valid numbers.
Arithmetic Operations: The program supports four basic operations:
Multiplication (*)
Subtraction (-)
Division (/)
Addition (+)
Error Handling: If invalid input is entered (e.g., text instead of numbers or a division by zero), the program prompts the user to re-enter the data.
Recursion: If an invalid input is entered at any stage, the program uses recursion to ask the user to re-enter the value.
Code Walkthrough
1. Main Method - Entry Point of the Program
java
Copy
public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter first Number: ");
    String num1 = scanner.next();
    boolean if_valid_num = validNum(num1);

    if (if_valid_num == true) {
        double num1_double = Double.parseDouble(num1);
        second_Number_input(num1_double);
    } else {
        valid_num1();
    }

    scanner.close();
}
Description:
The program starts by prompting the user to enter the first number.
The input is stored as a string (num1), and the validNum() method is called to check whether the input is a valid number.
If the input is valid, it is converted to a double and passed to the second_Number_input() method for further processing.
If the input is invalid, the valid_num1() method is called to prompt the user to re-enter the first number.
2. Validating User Input
java
Copy
public static boolean validNum(String value) {
    try {
        double Value = Double.parseDouble(value);
        return true;
    } catch (Exception e) {
        return false;
    }
}
Description:
The validNum() method checks if the input value can be parsed into a valid double.
If parsing is successful, it returns true; otherwise, it catches the exception and returns false.
3. Second Number Input
java
Copy
static void second_Number_input(double num1_double) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter second Number: ");
    String num2 = scanner.next();

    boolean if_valid_num2 = validNum(num2);

    if (if_valid_num2 == true) {
        double num2_double = Double.parseDouble(num2);
        calculation_options(num1_double, num2_double);
    } else {
        valid_num2(num1_double);
    }
}
Description:
After the first number is successfully entered, the program prompts the user to enter the second number.
The validNum() method is called to check if the second input is a valid number.
If valid, it proceeds to the calculation_options() method to select an arithmetic operation.
If invalid, it calls valid_num2() to ask the user to re-enter the second number.
4. Calculation Options
java
Copy
static void calculation_options(double num1_double, double num2) {
    Scanner scanner = new Scanner(System.in);
    System.out.printf("""
        Enter what to do to %f and %f Numbers: 
        1. *
        2. -
        3. /
        4. +
        enter option 1 to 4: 
        """, num1_double, num2);
    String action = scanner.next();
    boolean if_valid_num = validNum(action);

    if (if_valid_num == true) {
        int option_double = Integer.parseInt(action);
        calculations(option_double, num1_double, num2);
    } else {
        valid_calculations_option(num1_double, num2);
    }
}
Description:
The program prompts the user to choose one of the four arithmetic operations (multiplication, subtraction, division, addition) by entering a number from 1 to 4.
The entered option is validated to ensure it's a number.
If the input is valid, the program proceeds to the calculations() method to perform the operation.
If invalid, the program calls valid_calculations_option() to prompt the user to re-enter the option.
5. Calculation Execution
java
Copy
static void calculations(int action, double num1_double, double num2) {
    switch (action) {
        case 1 -> {
            double multiplication_answer = num1_double * num2;
            System.out.print(num1_double + " * " + num2 + " = " + multiplication_answer);
            break;
        }
        case 2 -> {
            double minus_answer = num1_double - num2;
            System.out.print(num1_double + " - " + num2 + " = " + minus_answer);
            break;
        }
        case 3 -> {
            if (num2 == 0) {
                System.out.print("second number you entered cannot be zero. \nPlease input a number less than or greater than zero.");
            } else {
                double division_answer = num1_double / num2;
                System.out.print(num1_double + " / " + num2 + " = " + division_answer);
            }
            break;
        }
        case 4 -> {
            double addition_answer = num1_double + num2;
            System.out.print(num1_double + " + " + num2 + " = " + addition_answer);
            break;
        }
        default -> {
            valid_calculations_option(num1_double, num2);
        }
    }
}
Description:
The calculations() method performs the chosen arithmetic operation based on the user's input (action).
It handles the four cases:
Case 1: Multiplication
Case 2: Subtraction
Case 3: Division (with check for division by zero)
Case 4: Addition
If the user selects an invalid option, it triggers valid_calculations_option() to prompt the user for a valid option.
6. Handling Invalid Inputs Recursively
Each method that accepts user input, such as valid_num1(), valid_num2(), and valid_calculations_option(), uses recursion to handle invalid inputs. When the user enters an invalid value, the program will ask the user to re-enter the value until it is valid.

Example:

java
Copy
static void valid_num1() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Please re-enter the first number by inputing valid number: ");
    String num1_again = scanner.next();

    boolean num1_again_boolean = validNum(num1_again);

    if (num1_again_boolean == true) {
        double num1_into_double = Double.parseDouble(num1_again);
        second_Number_input(num1_into_double);
    } else {
        valid_num1();
    }
}
Description: This method recursively asks the user to re-enter the first number if the initial input is invalid.
Illustrations (Program Flow)
User Input Flow
First Input: The user is prompted to enter the first number.

If valid: The program proceeds to the second input.
If invalid: The program prompts the user to re-enter the first number.
Second Input: The user is prompted to enter the second number.

If valid: The program proceeds to choose the calculation option.
If invalid: The program prompts the user to re-enter the second number.
Operation Selection: The user is prompted to select an arithmetic operation (1-4).

If valid: The operation is performed.
If invalid: The program prompts the user to re-enter the operation choice.
Calculation: Based on the selected operation, the result is displayed.
