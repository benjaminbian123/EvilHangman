package evilhangman_csc105;

import java.util.*;
import java.io.*;
public class EvilHangman_CSC105{
  
  private String secretWord = "";
  private int guessCount;
  private String dashLine = "";
  private String letterGuessHistory = "";
  private char letterGuess; //pointer
  private String[] word = new String[127142]; //127142 words
  private int wordCount = 0; //count only possible word that you choose the length
  private int secretWordLength;
  private boolean guessResult = false;
  public boolean isPlay = true;
  public static boolean checkLength = false;
  boolean check = false;
  //File dict = new File("dictionary.txt");
  
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    System.out.println("                     Welcome to Evil Hangman !!");
    System.out.println();
    System.out.println("        Guess the secret word by entering one letter at a time");
    System.out.println("                You have just 10 chances to be wrong.");
    System.out.println("         If your lives are out of ten then you will be lose!!");
    System.out.println();
    System.out.println("                         _ _ _ _ _ _ _ _ _");
    System.out.println();
    System.out.println("- if the letter is in the secret word, the blank will be filled in with the letter.");
    System.out.println("- if the letter is not in the word, your lives will be minused one.");
    System.out.println();
  
    EvilHangman_CSC105 h = new EvilHangman_CSC105();
    h.play();
  }
  
  public EvilHangman_CSC105(){ //created object 
    
  }
  
  public EvilHangman_CSC105(int secretWordLength){
    this.guessCount = 10;
    this.secretWordLength = secretWordLength;
    String fileName = "dictionary.txt";
        File file = new File(fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            while((line = br.readLine()) != null){
                if(line.length() == secretWordLength){ //เลือกเฉพาะคำที่มีlegthตามต้องการ
                    word[wordCount] = line; //arrayคำที่มีจำนวนlengthที่กำหนด
                    //System.out.println(word[count]); //ลองปริ้น
                    wordCount++;
                }
            }
            //System.out.println("Words with length " + secretWordLength + " have " + wordCount + " words");
        } catch (FileNotFoundException ex) {
            System.out.println("eiei excep filenot");
        } catch (IOException ex) {
            System.out.println("eiei excep IO");
        }
    
    for(int i = 0; i< secretWordLength; i++){
      dashLine += "_ ";
    }
  }
  
  public void play(){ // play method
    Scanner sc = new Scanner(System.in);
    
    isPlay = true;
    
    while(isPlay==true){
      while(checkLength==false){
        System.out.print("Enter word length you want to play : ");
        int length = sc.nextInt();
        if(length > 1 && (length != 23 && length != 25 && length != 26 && length != 27) && length < 30){ //no length 1 23 25 26 27
          EvilHangman_CSC105 h = new EvilHangman_CSC105(length);
          checkLength = true;
          h.play();
        } else {
          System.out.println("Don't have word with that length. Please try again");
        }
      }
      
      while(guessCount>=0){
        String temp = dashLine.replaceAll(" ","");
        if(guessCount==0){
          isPlay = false;
          System.out.println();
          System.out.println("                  SORRY YOU LOSE !!");
          System.out.println("         The secret word is : "+getSecretWord());
          System.out.println();
          playAgain();
          break;
        }
        else if(temp.equals(getSecretWord())){
          System.out.println();
          System.out.println("              CONGRATULATIONS YOU WIN !!");
          System.out.println("         The secret word is : "+getSecretWord());
          System.out.println();
          playAgain();
          break;
        } 
        
        //System.out.println("----------------------------------------------------------------");
        //System.out.println("Word length : "+secretWordLength);
        //System.out.println("Word count : "+wordCount);
        //System.out.println("----------------------------------------------------------------");
        System.out.println();
        System.out.println("          "+displayDashline());
        System.out.println("Guess remaining : "+guessCount());
        //System.out.println("----------------------------------------------------------------");
        System.out.println("Letter that you already used :"+showLetterGuess());
        //System.out.println("----------------------------------------------------------------");
        //System.out.println(getSecretWord());
        //System.out.println(temp);
        System.out.print("Enter a letter to guess : ");
        makeGuess(sc.next().charAt(0));
        
      }
      
    }
  }
  
  public boolean makeGuess(char ch) {
    guessResult = false;
    letterGuess = ch;
    checkHistory(letterGuess);
    if(checkWord(letterGuess)){ //ทายผิด
      guessCount--;
      guessResult = false;
    }
    else{ //ทายถูก
      for(int i = 0; i < secretWord.length(); i++){
        if(secretWord.charAt(i) == ch){
          String temp = "";
          for(int j = 0; j < secretWord.length(); j++){
            if(secretWord.charAt(j) == ch)
            {
              temp = temp + ch + " "; //เก็บตัวที่มี
            }
            else
            {
              temp = temp + dashLine.charAt(2*j) + dashLine.charAt(2*j+1);  //เก็บเพิ่มทีละตัว _ กับ ช่องว่าง             
            }
          }
          dashLine = temp;
          guessResult = true;
          break;
        }
      }
    } 
    return guessResult;
  }
  
  public boolean checkWord(char ch) {
    int tempWordCount = 0; //เช็คว่าคำที่ไม่มีตัว input อ่ะกี่คำ
    for (int i = 0; i < wordCount; i++) {
      for (int j = 0; j < secretWordLength; j++) {
        if (word[i].charAt(j) == ch){ 
          break;
        } else {  
          if (j == secretWordLength - 1){
            if (word[i].charAt(j) != ch) {
              tempWordCount++;
            }
          }
        }
      }
    }
    String[] temp = new String[tempWordCount]; //เอาคำที่ไม่มี input ใส่ใน array
    int tempIndex = 0;
    for (int i = 0; i < wordCount; i++) {
      for (int j = 0; j < secretWordLength; j++) {
        if (word[i].charAt(j) == ch) {
          break;
        } else {
          if (j == secretWordLength - 1) {
            if (word[i].charAt(j) != ch) {
              temp[tempIndex] = word[i];
              tempIndex++;
            }
          }
        }
      }
    }
    if(tempWordCount==0){ //มี input (ทายถูก)
      secretWord = word[0];
      return false;
    } else { //คำที่ไม่มี input (ทายผิด)
      secretWord = temp[0];
      wordCount = tempWordCount;
      word = temp;
      return true;
    }
  }
  
  public void playAgain(){
    Scanner sc = new Scanner(System.in);
    
    while(check==false){
      System.out.print("Do you want to play again ? (yes/no) : ");
      String input = sc.next();
      if(input.equals("yes") || input.equals("YES")){
        System.out.println();
        check = true;
        checkLength = false;
        play();
        break;
      }
      else if(input.equals("no") || input.equals("NO")){ 
        System.out.println();
        System.out.println("                 Thank for playing !!");
        System.out.println();
        isPlay = false;
        checkLength = true;
        check = true;
      }
      else {
        System.out.println("Invalid input, Try again !!");
        check = false;
        playAgain();
      }
    }
    
  }
  
  public void checkHistory(char ch){
    String temp = letterGuessHistory.replaceAll(" ","");
    for(int i = 0; i< temp.length(); i++){
      if(temp.charAt(i)==ch){
        System.out.println("Please input again // Be careful if you always answer wrong but you know about it, it will decrease you guesscount");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a letter : ");
        makeGuess(sc.next().charAt(0));
      }
    }
  }
  
  public String getSecretWord() {
    return secretWord;
  }
  
  public int guessCount() {
    return guessCount;
  }
  
  public String displayDashline() {
    return dashLine;
  }
  
  public String showLetterGuess() {
    if (!guessResult) {
      letterGuessHistory = letterGuessHistory +" "+ letterGuess;
    }
    return letterGuessHistory;
  }
  
}