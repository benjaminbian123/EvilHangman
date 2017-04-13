package evilhangman_csc105;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EvilHangman_CSC105 {

    private String secretWord;
    private String dashline;
    private String[] word = new String[50000];
    private char[] letterGuessHistory;
    private int secretWordLength;
    private int guessCount;
    private int pointer_guesshistory;
    private boolean guessResult;

    public static void main(String[] arg) {
        EvilHangman_CSC105 e1 = new EvilHangman_CSC105();
        e1.setSecretWordLength(0);
        System.out.println(e1.displayDashline());
        e1.getSecretWord();
    }

    public EvilHangman_CSC105() {
        guessCount = 10;
    }

    public String getSecretWord() {
        String fileName = "C:\\Users\\PS\\Desktop\\EvilHangman_CSC105\\dictionary.txt";
        File file = new File(fileName);
        int count=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                if(line.length() == secretWordLength){ //
                    word[count] = line; //arrayคำที่มีจำนวนlenghtที่กำหนด
                    System.out.println(word[count]); //ลองปริ้น
                    count++;
                }
            }
            System.out.println(count);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EvilHangman_CSC105.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EvilHangman_CSC105.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "eiei";
        //return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public int getSecretWordLength() {
        //secretWordLength = (int)(Math.random() * 7 + 1);
        return secretWordLength;
    }

    public void setSecretWordLength(int secretWordLength) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i >= -1; i++){
            System.out.print("Enter word length : ");
            secretWordLength = sc.nextInt();
            if(secretWordLength > 1 && (secretWordLength != 23 || secretWordLength != 25 ||   //no length 1 23 25 26 27
                secretWordLength != 26 || secretWordLength != 27) && secretWordLength < 30){  
                this.secretWordLength = secretWordLength;
                break;
            } else {
                System.out.println("Don't have word with that length. Please try again");
            }
        }
    }

    public String displayDashline() {
        dashline = "";
        for(int i=0; i<secretWordLength; i++){
            String temp = "_ ";
            dashline += temp;
        }
        return dashline;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public void setGuessCount(int guessCount) {
        this.guessCount = guessCount;
    }

    public int getPointer_guesshistory() {
        return pointer_guesshistory;
    }

    public void setPointer_guesshistory(int pointer_guesshistory) {
        this.pointer_guesshistory = pointer_guesshistory;
    }

    public boolean getGuessResult() {
        return guessResult;
    }

    public void setGuessResult(boolean guessResult) {
        this.guessResult = guessResult;
    }

    public boolean chooseWord(char ch) {
        return false;
    } // nothing

    public char[] addLetterGuess(char ch) { // nothing
        return letterGuessHistory;
    }

    public boolean isSameGuessLetter() { // nothing
        return false;
    }

    public boolean guessLetter() { //nothing
        return false;
    }

}
