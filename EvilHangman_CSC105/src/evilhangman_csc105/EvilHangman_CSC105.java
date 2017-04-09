package evilhangman_csc105;

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
    }

    public EvilHangman_CSC105() {

    }

    public String getSecretWord() {
        return secretWord;
    }

    public void setSecretWord(String secretWord) {
        this.secretWord = secretWord;
    }

    public int getSecretWordLength() {
        return secretWordLength;
    }

    public void setSecretWordLength(int secretWordLength) {
        this.secretWordLength = secretWordLength;
    }

    public String displayDashline() {
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
