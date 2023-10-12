
/**
 * Write a description of class Computer here.
 *
 * @author Eric Shen
 * @version Oct 6th
 */

import java.util.Scanner;
public class Computer
{
    public static final int Fail = 0;
    public static final int rock = 1;
    public static final int paper = 2;
    public static final int crossblades = 3;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Weak Human! Challenge me in Rock, Paper, Crossblades to make me spare your life! HAHAHAHAHA!");
        System.out.println("You: ");
        String response = input.nextLine();
        response = response.toLowerCase();
        reply(neaten(response));
    }

    static int neaten (String r) {
        int answer = 0;
        if (check("rock", r)) {
            answer += rock;
        } else if (check("paper", r)) {
            answer += paper;
        } else if (check("crossblades", r)) {
            answer += crossblades;
        }
        if (r.length() < 50) {
            answer *= -1;
        }
        //System.out.println(answer);
        return answer;
    }

    static boolean check(String choice, String res) {
        return res.lastIndexOf(choice) == res.length()-choice.length();
    }

    static int reply (int n) {
        if (n == 0) {
            System.out.println("Me: You have failed to adhere to the ancient traditions of "
            + "Rock, Paper, Crossblades! You have lost by disqualification! Disgraceful!");
            System.out.println();
            System.out.println("Result: As I predicted, I have won this battle. Your Life is MINE!");
        } else if (n < 0) {
            System.out.println("Me: Pathetic. You cannot hope to beat me without the passion" 
            + " of a thousand suns, without the dedication of a Pleistocene glacier! I choose "
             + autoDefeat(n) + "!");
            System.out.println();
            System.out.println("Result: As I predicted, I have won this battle. Your Life is MINE!");
        } else if (n > 0) {
            int fight = (int) (Math.random()*3)+1;
            System.out.println("Good job human, I appreciate your courage! But destiny is destiny! I pick "
             + changeInt(fight) + "!!!");
             
            finalResult(fight, n);
        } 
        return Fail;
    }

    static String changeInt (int b) {
        //System.out.println(b);
        if (b == 1) return "ROCK";
        else if (b == 2) return "PAPER";
        else return "CROSSBLADES";
    }
    
    static String autoDefeat(int a) {
        a = Math.abs(a);
        if (a == 1) return "PAPER";
        else if (a == 2) return "CROSSBLADES";
        else return "ROCK";
    }
    
    static String finalResult(int computer, int human){
        System.out.println("Result: ");
        if (computer == human) {
        System.out.println("Unbelievable! We have tied! *Eye twitches*");
        } else if (computer == rock && human == paper 
        || computer == paper && human == crossblades
        || computer == crossblades && human == rock) {
        System.out.println("WHAT!!! You win? You have good luck human, I spare your life!");
        } else {
        System.out.println("As I predicted, I have won this battle. Your Life is MINE!");
        }
        return "99";
    }
}
