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
    private char[] letterGuessHistory = new char[20];
    private int secretWordLength;
    private int guessCount;
    private int pointer_guesshistory;
    private boolean guessResult;
    
    private static int countLetterGuessHistory;
    private static int countTotalWord;
    private boolean guessLetter;

    public static void main(String[] arg) {
        EvilHangman_CSC105 e1 = new EvilHangman_CSC105();
        e1.setSecretWordLength();
        System.out.println(e1.displayDashline());
        e1.getWordsFromDic();
        e1.inputLetter();
        e1.checkSecretWord();
    }

    public EvilHangman_CSC105() {
        guessCount = 10;
        countLetterGuessHistory = 0;
        countTotalWord = 0;
        countWord0 = 0;
        countWord1 = 0;
        countWord2 = 0;
        countWord3 = 0;
        countWord4 = 0;
        countWord5 = 0;
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                if(line.length() == secretWordLength){ //เลือกเฉพาะคำที่มีlegthตามต้องการ
                    word[countTotalWord] = line; //arrayคำที่มีจำนวนlengthที่กำหนด
                    //System.out.println(word[count]); //ลองปริ้น
                    countTotalWord++;
                }
            }
            System.out.println("Words with length " + secretWordLength + " have " + countTotalWord + " words");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EvilHangman_CSC105.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EvilHangman_CSC105.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String[] word0 = new String[50000];
    private int countWord0;
    private String[] word1 = new String[50000];
    private int countWord1;
    private String[] word2 = new String[50000];
    private int countWord2;
    private String[] word3 = new String[50000];
    private int countWord3;
    private String[] word4 = new String[50000];
    private int countWord4; 
    private String[] word5 = new String[50000];
    private int countWord5;
    public void checkSecretWord(){ //group the words 
        for(int i=0; i<countTotalWord; i++){ //check every word
            int countHaveLetter = 0;
            for(int j=0; j<secretWordLength; j++){ //check every leter
                char temp = word[i].charAt(j);
                if(letterGuessHistory[countLetterGuessHistory-1] == temp){
                    countHaveLetter++; //count letters in a word
                }
            }
            if(countHaveLetter == 0){ //separate words into groups
                word0[countWord0] = word[i]; 
                //System.out.println(word0[countWord0]);
                countWord0++;
            } else if(countHaveLetter == 1){
                word1[countWord1] = word[i];
                countWord1++;
            } else if(countHaveLetter == 2){
                word2[countWord2] = word[i];
                countWord2++;
            } else if(countHaveLetter == 3){
                word3[countWord3] = word[i];
                countWord3++;
            } else if(countHaveLetter == 4){
                word4[countWord4] = word[i];
                countWord4++;
            } else if(countHaveLetter == 5){
                word5[countWord5] = word[i];
                countWord5++;
            }
        }
        System.out.println("0 letter have : "+countWord0+" words");
        System.out.println("1 letter have : "+countWord1+" words");
        System.out.println("2 letter have : "+countWord2+" words");
        System.out.println("3 letter have : "+countWord3+" words");
        System.out.println("4 letter have : "+countWord4+" words");
        System.out.println("5 letter have : "+countWord5+" words");   
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
