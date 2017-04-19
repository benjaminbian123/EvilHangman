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
    private char[] letterGuessHistory = new char[10];
    private int secretWordLength;
    private int guessCount;
    private int pointer_guesshistory;
    private boolean guessResult;
    
    private static int countLetterGuessHistory;

    public static void main(String[] arg) {
        EvilHangman_CSC105 e1 = new EvilHangman_CSC105();
        e1.setSecretWordLength();
        System.out.println(e1.displayDashline());
        e1.getWordsFromDic();
        e1.inputLetter();
        e1.inputLetter();
        e1.inputLetter();
        e1.inputLetter();
    }

    public EvilHangman_CSC105() {
        guessCount = 10;
        countLetterGuessHistory = 0;
    }

    public void inputLetter(){
        Scanner sc = new Scanner(System.in);
        for(int i=0; i >= -1; i++){
            System.out.print("Enter a letter : ");
            char inputLetter = sc.next().toLowerCase().charAt(0);
            int countCheck = -1; //เอาไว้เช็คว่า input ซ้ำตัวเดิมมั้ย
            for(int j=0; j<=countLetterGuessHistory; j++){ //เช็คว่า input ซ้ำตัวเดิมมั้ย
                if(inputLetter != letterGuessHistory[j]){
                    countCheck++;
                }
            }
            if((inputLetter >= 97 && inputLetter <= 122) && countCheck == countLetterGuessHistory){ //เช็คว่า input เป็น letter
                letterGuessHistory[countLetterGuessHistory] = inputLetter; //เก็บ letter ลงใน array
                countLetterGuessHistory++;
                break;
            } else {
                System.out.println("Enter one letter. Please try again."); //ถ้าใส่ผิดให้ใส่ใหม่
            }
        }
        
        System.out.print("Letter you have guessed : "); //ปริ้น letter ที่เดาไป
        for(int i=0; i<countLetterGuessHistory; i++){
            System.out.print(letterGuessHistory[i]+ " ");
        }
        System.out.println("");
    }
    
    public void getWordsFromDic(){
        String fileName = "C:\\Users\\PS\\Desktop\\EvilHangman_CSC105\\dictionary.txt";
        File file = new File(fileName);
        int count=0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                if(line.length() == secretWordLength){ //เลือกเฉพาะคำที่มีlegthตามต้องการ
                    word[count] = line; //arrayคำที่มีจำนวนlengthที่กำหนด
                    //System.out.println(word[count]); //ลองปริ้น
                    count++;
                }
            }
            System.out.println("Words with length " + secretWordLength + " have " + count + " words");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EvilHangman_CSC105.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EvilHangman_CSC105.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    public void setSecretWordLength() {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i >= -1; i++){
            System.out.print("Enter word length : ");
            int inputLength = sc.nextInt();
            if(inputLength > 1 && (inputLength != 23 && inputLength != 25 &&   //no length 1 23 25 26 27
                inputLength != 26 && inputLength != 27) && inputLength < 30){  
                this.secretWordLength = inputLength;
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
