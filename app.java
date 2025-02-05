//package simpleCalc;
import java.util.Scanner;

class app {

    public static void main(String[] args ){
         
        //scanner 
        Scanner scanner = new Scanner(System.in);
        boolean needToRepeat = true;
        
        while (needToRepeat) {
            needToRepeat = performTask();
            boolean need_to_repeat_num1 = true; 
            
            //..........................................................................
            while (need_to_repeat_num1) { 
                System.out.println("""
                Welcome to our simple calculator: 
                \n
                Enter your first number:                
            """);

                //? first value==============================
                String num1 = scanner.nextLine();
                boolean validNum1 = validNum(num1);
                if (validNum1 == true) {
                    need_to_repeat_num1 = false;
                    break;
                } else {
                    System.out.println("Please Enter valid number:  ");
                }
            }
            
            System.out.println("Enter your second number: ");
            //? second value==============================
            String num2 = scanner.nextLine();
            boolean validNum2 = validNum(num1);
            
            // option for what to do to values
            System.out.printf("""
                What do you want to do to  %num1  and  %num2, enter option 1-4 :
                1. *
                1. -
                3. / 
                4. + 
                """ , num1, num2);

            String action = scanner.nextLine();
            boolean valid_option_number = validNum(action);


            if(valid_option_number == true){
                int action_in_number_format = Integer.parseInt(action);
                double num1_in_number_format = Double.parseDouble(num1);
                double num2_in_number_format = Double.parseDouble(num2);

                whatToDo(valid_option_number, action_in_number_format, num1_in_number_format, num2_in_number_format);
            }
            else{
              
            }
            

            
            
        }

        


    }

    //? method for valid number
    //? returns true if valid number an false if non valid value
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


    // TRUEvalue is true value after confirming if entered numbers are valid numbers 
    // action is what to do to those two numbers user entered
    static void whatToDo(boolean TRUEvalue, int action, double val1, double  val2) {
         
        if(TRUEvalue == true) {
            switch (action) {
                case 1:
                    // multiplication
                    double ans = val1 * val2;
                    System.out.println(val1 + " * " + val2 + " = " + ans);
                    break;
                
                case 2:
                    // minus
                    double ans2 = val1 - val2;
                    System.out.println(val1 + " - " + val2 + " = " + ans2);
                    break;

                case 3:
                    // division
                    double ans3 = val1 / val2;
                    System.out.println(val1 + " / " + val2 + " = " + ans3);
                    break;

                case 4:
                    // addition
                    double ans4 = val1 + val2;
                    System.out.println(val1 + " + " + val2 + " = " + ans4);
                    break;
                default:
                    System.out.println("Please enter values  1, 2, 3 or 4 to choose what to do with values you entered");
                    
            }
        }
    }

    public static boolean performTask() {
        // Perform some task here
        System.out.println("Task is being performed...");
        
        // Return whether we want to repeat the task
        return false; // Change this to `true` to repeat the task
    }
}