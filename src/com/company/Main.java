package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        boolean play = true;
        String userGuess;

        while (play){


            Bull newGame = new Bull();

            while( ! newGame.isSuccess()){

                boolean isNotNum = false;

                Scanner scan = new Scanner(System.in);
                System.out.println("Enter Your 4 digits Guess!");

                userGuess = scan.nextLine(); // input a number from the user

                if(userGuess.length()!= 4){ // check if its 4 digits
                    System.out.println("Please enter 4 digits\n");
                    continue;
                }
                for (int i=0 ; i<4 ; i++){
                    if (userGuess.charAt(i) < 48 || userGuess.charAt(i) > 57) {// check if between ascii values
                        System.out.println("Please enter just digits\n");
                        isNotNum = true;
                        break;

                    }

                }
                if (isNotNum)
                    continue;

                newGame.bullEyes(userGuess);
                newGame.toString();



            }

            while(true) {

                String anotherShot;

                Scanner scan = new Scanner(System.in);
                System.out.println("Do you want another shot? y/n");

                anotherShot = scan.nextLine();

                if (anotherShot.equals("y"))
                    break;
                else if (anotherShot.equals("n")) {
                    play = false;
                    break;

                }



            }
        }


    }
}
