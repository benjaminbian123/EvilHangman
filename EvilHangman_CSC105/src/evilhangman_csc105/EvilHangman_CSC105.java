package evilhangman_csc105;

import java.util.Scanner;

public class EvilHangman_CSC105 {

    private String secretWord;
    private String dashline;
    private String[] word;
    private char[] letterGuessHistory;
    private int secretWordLength;
    private int guessCount;
    private int pointer_guesshistory;
    private boolean guessResult;

    public static void main(String[] arg) {
        EvilHangman_CSC105 e1 = new EvilHangman_CSC105();
        e1.setSecretWordLength(0);
        System.out.println(e1.displayDashline());
    }

    public EvilHangman_CSC105() {
        guessCount = 10;
    }

    public String getSecretWord() {
        return secretWord;
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
        System.out.print("Enter word length : ");
        secretWordLength = sc.nextInt();
        this.secretWordLength = secretWordLength;
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
