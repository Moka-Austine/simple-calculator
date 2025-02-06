import java.util.Scanner;

class app3 {
  public static void main(String[] args) {
        // scanner object
        Scanner scanner = new Scanner(System.in);


        //?prompting user to enter first number
        System.out.print("Enter first Number: ");
        // storage of entered first number
        String num1 = scanner.next();
        // if_valid_num value will be true if num1 is valid number and false is nu is not valid number
        boolean if_valid_num = validNum(num1);
        
        // if inputed number on first trial is valid 
        if (if_valid_num == true) {
            //converting num1 from STRING to DOUBLE
            double num1_double = Double.parseDouble(num1);
            second_Number_input(num1_double);
        } 

        // if inputed number on first trial is not  valid 
        else {
            valid_num1();
        }

        scanner.close();
    }

    //? starts executing when number one is valid
    static void second_Number_input(double num1_double) {

        Scanner scanner = new Scanner(System.in);
        //prompting user to enter second number
        System.out.print("Enter second Number: ");
        // storage of entered second number
        String num2 = scanner.next();

        //validating second number
        boolean if_valid_num2 = validNum(num2);

        // if inputed number on first trial is valid 
        if (if_valid_num2 == true) {
            //converting num1 from STRING to DOUBLE
            double num2_double = Double.parseDouble(num2);
            calculation_options(num1_double, num2_double);
        } 

        // if inputed number on first trial is not  valid 
        else {
            valid_num2(num1_double);
        }

        
    }
 //? user defined method for checking if inputed num1 and num2 numbers are valid
  //? returns true if valid number OR false if not valid number
  //? try block catches any errors that break program
    public static boolean validNum(String value) {
        //? try block for successful parsing of value 
        //? meaning no error or valid value
        try {
            double Value = Double.parseDouble(value);
            return true;
        }

        //? catch block for catching errors 
        //? resulting from changing non-int to int of value 
        catch (Exception e) {
            return false;
        }
    }

    static void calculation_options(double num1_double, double num2) {

        Scanner scanner = new Scanner(System.in);
        //calculation option for user to choose for the two entered tow numbers
        System.out.printf("""
            
            Enter what to do to $num1 and $num2 Numbers: 
            1.*
            2. -
            3. /
            4. +
            enter option 1 to 4: 
            """, num1_double, num2);
        // stores either int 1, 2, 3 or 4 option at a time  
        String action = scanner.next();
        boolean if_valid_num = validNum(action);

        // if inputed number on first trial is valid 
        if (if_valid_num == true) {
            //converting num1 from STRING to DOUBLE
            int option_double = Integer.parseInt(action);
            calculations(option_double, num1_double, num2);
        } 

        // if inputed number on first trial is not  valid 
        else {
            valid_calculations_option(num1_double, num2);
        }
        
       
    }

    //?  user method for re-entering first number until its valid
    static void valid_num1 () {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Please re-enter the first number by inputing valid number: ");
        String num1_again = scanner.next();

        boolean num1_again_boolean = validNum(num1_again);

        if (num1_again_boolean == true) {
            double num1_into_double = Double.parseDouble(num1_again);
            second_Number_input(num1_into_double);
            //return num1_into_double;
        }
        else {
            valid_num1();
        }

        
    }
    // user method for re-entering secong number until its valid
    static void valid_num2 (double num1_double) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Please re-enter the second number by inputing valid number: ");
        String num2_again = scanner.next();

        boolean num2_again_boolean = validNum(num2_again);

        if (num2_again_boolean == true) {
            double num2_into_double = Double.parseDouble(num2_again);
            calculation_options(num1_double, num2_into_double);
           // return num2_into_double;
        }
        else {
            valid_num2(num1_double);
        }

        
    }

    // user method for re-entering option number until its valid
    static void valid_calculations_option (double num1_double, double num2) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Please re-enter the option number by inputing valid number (1 - 4): ");
        String option_again = scanner.next();

        boolean option_again_boolean = validNum(option_again);

         // if valid number
        if (option_again_boolean == true) {
            int num2_into_integer = Integer.parseInt(option_again);
             
            // option range is  not 1 - 4 
            if (num2_into_integer > 4 || num2_into_integer < 1) {
                // recursion
                valid_calculations_option(num1_double, num2);
            }

            // option range is 1 - 4 
            else {
                calculations(num2_into_integer, num1_double, num2);
            }
            
        }
        // if not a valid number to re-enter again
        else {
            valid_calculations_option(num1_double, num2);
        }

        
    }


      //? user method for calculating number one with number two
    static void calculations(int action, double num1_double, double num2) {
         //?advanced arrow switch case for calculating the two numbers approapriately
         switch (action) {
            //case one for multiplying mum1 and num2 when user chooses option 1 having *
            case 1 -> {
                double multiplication_answer = num1_double * num2;

                //printing multiplication_answer
                System.out.print(num1_double + " * " + num2 + " = " + multiplication_answer);
                break;// to break out of switch case
            }
            //case two for minuzing mum1 and num2 when user chooses option 2 having -
            case 2 -> {
                double minus_answer = num1_double - num2;

                //printing minus_answer
                System.out.print(num1_double + " - " + num2 + " = " + minus_answer);
                break;// to break out of switch case
            }
            //case three for dividing mum1 and num2 when user chooses option 3 having /
            case 3 -> {
                // if second number is eqaul to zero
                if (num2 == 0) {

                    System.out.print("second number you entered cannot be zero. \nPlease input a number less than or greater than zero.");
                }
                // if second number is not eqaul to zero
                else {
                    double division_answer = num1_double / num2;

                    //printing division_answer
                    System.out.print(num1_double + " / " + num2 + " = " + division_answer);
                    break;// to break out of switch case
                }
                
            }
            //case four for adding mum1 and num2 when user chooses option 4 having +
            case 4 -> {
                double addition_answer = num1_double + num2;

                //printing addition_answer
                System.out.print(num1_double + " + " + num2 + " = " + addition_answer);
                break;// to break out of switch case
            }
                
            
            default -> {
                valid_calculations_option(num1_double, num2);
            }
                
        }
    }
}