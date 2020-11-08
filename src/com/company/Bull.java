package com.company;
import java.util.Random;

/* Maman 11 Question 1
*  A class for generating random number and method for the game Bull'eyes
*  @author  Shimi Sadaka
 * @version 1.0
 * @since   2020-11-07
 *
*  */



public class Bull {

    private String randomNum;
    private int NumOfGuess;
    private boolean success = false;
    private final int maxNum = 10000;


    public Bull(){ // constructor for building the Bull object

        this.randomNum = generateRandNum(); // generate a random number and initialize it.
        this.NumOfGuess = 0;

    }

    /* private method for generating a number between 0 to 9999 */
    private String generateRandNum(){

        Random rand = new Random();

        return Integer.toString(rand.nextInt(maxNum)); // returns String presentation of the rand Num
    }

    /* for checking the status of the game - success or not  */
    public boolean isSuccess(){

        return success;

    }


    /* the function that make the comparison and determine the result of the session
    * @param number
    * */
    public boolean bullEyes(String number){

        int bull = 0; // number of bull in the guess
        int eye =0; // number of eyes in the guess
        this.NumOfGuess++;

        for (int i = 0 ; i < 4 ; i++){ // count the bulls

            if (number.charAt(i) == this.randomNum.charAt(i))
                bull++;
        }
        if (bull == 4) {

            success(); // invoke the success function if the user guess the number */
            success = true; // update the new status
            return true;
        }

        for (int i = 0 ; i < 4 ; i++){ // count the eyes

            for (int j = 0 ; j < 4 ; j++){

                if (this.randomNum.charAt(j) == number.charAt(i)) {
                    eye++;
                    break;
                }
            }
        }
        eye = eye - bull; // minus the bull times
        result(bull, eye);// invoke the meanwhile result function if the user did not guess the number

        return false;

    }
    /* if the user guessed the number, then it print to the screen */
    private void success(){

        System.out.println("Success! You needed "+ NumOfGuess+" Guesses!");
    }
    /* if the user did not guess the number, then it print to the screen - try again and meanwhile results */
    private void result(int bull, int eye){

        System.out.println("Bull: "+bull+"\nEye: "+eye+"\nTry Again!\n");


    }

    /* for testing purposes */
    @Override
    public String toString() {

        System.out.println(this.randomNum);
        return this.randomNum;
    }
}
