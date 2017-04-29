import java.util.*;
import java.io.*;
public class Hangman{
  
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
  public boolean check = false;
  public boolean checkinput = false;
  File dict = new File("dictionary.txt");
  
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in);
    Hangman h = new Hangman();
    h.play();
  }
  
  public Hangman(){ //created object 
    
  }
  
  public Hangman(int secretWordLength,int guessCount){
    this.guessCount = guessCount;
    this.secretWordLength = secretWordLength;
    Scanner readdict = null;
    try{
      readdict = new Scanner(dict); // read dictionary
    } catch(Exception e){
      throw new RuntimeException(e);
    }
    int i = 0; 
    while(readdict.hasNext()) { // while it have next
      String temp = readdict.nextLine();
      if(temp.length()==secretWordLength){
        word[i] = temp;
        i++;
        wordCount++;
      }
    }
    
    for(i = 0; i< secretWordLength; i++){
      dashLine += "_ ";
    }
    
    readdict.close();
  }
  
  public void play(){ // play method
    Scanner sc = new Scanner(System.in);
    
    isPlay = true;
    System.out.println("----------------------------------------------------------------");
    System.out.println("                  Welcome to Evil Hangman !!!                   ");
    System.out.println("----------------------------------------------------------------");
    System.out.println("     Guess the secret word by entering one letter at a time     ");
    System.out.println("               Choose how many chances to be play.              ");
    System.out.println("          If your chances are zero then you will be lose!       ");
    System.out.println("----------------------------------------------------------------");
    System.out.println("                    _ _ _ _ _ _ _ _ _ _ _                       ");
    System.out.println("----------------------------------------------------------------");
    System.out.println("              if the letter is in the secret word               ");
    System.out.println("           the blank will be filled in with the letter.         ");
    System.out.println("                if the letter is not in the word                ");
    System.out.println("                your chances will be minused one.               ");
    System.out.println("----------------------------------------------------------------");
    
    while(isPlay==true){
      
      while(checkLength==false){
        
        System.out.print("Enter word length you want to play : ");
        int length = sc.nextInt();
        if(length>1 && length<23 || length==24){ // no length 1 23 25 26 27
          System.out.print("Enter number of your guess :");
          int count =  sc.nextInt();
          Hangman h = new Hangman(length,count);
          checkLength = true;
          h.play();
        } else if(length == 1 || length == 23 || length == 25 || length == 26 || length == 27 || length < 30){
          System.out.println("Don't have word with that length. Please try again");
        }
        else{
          System.out.println("Invalid Input. Please try again");
        }
      }
      
      
      
      while(guessCount>=0){
        String temp = dashLine.replaceAll(" ","");
        if(guessCount==0){
          isPlay = false;
          if(check==false){
            System.out.println("----------------------------------------------------------------");
            System.out.println("SORRY YOU LOSE !!");
            System.out.println("The secret word is : "+getSecretWord());
            System.out.println("----------------------------------------------------------------");
          }
          break;
        }
        else if(temp.equals(getSecretWord())){
          System.out.println("----------------------------------------------------------------");
          System.out.println("CONGRATULATIONS YOU WIN !!");
          System.out.println("The secret word is : "+getSecretWord());
          System.out.println("----------------------------------------------------------------");
          break;
        } 
        
        System.out.println("----------------------------------------------------------------");
        System.out.println("Word length : "+secretWordLength);
        System.out.println("Word count : "+wordCount);
        System.out.println("----------------------------------------------------------------");
        System.out.println("Word : "+displayDashline());
        System.out.println("Guess remaining : "+guessCount());
        System.out.println("----------------------------------------------------------------");
        System.out.println("Letter that you already used :"+showLetterGuess());
        System.out.println("----------------------------------------------------------------");
        System.out.println(getSecretWord());
        System.out.println(temp);
        System.out.print("Enter a letter to guess : ");
        makeGuess(sc.next().charAt(0));
      }
      
      playAgain();
      break;
      
    }
  }
  
  public boolean makeGuess(char ch) {
    guessResult = false;
    letterGuess = ch;
    checkHistory(letterGuess);
    if(checkWord(letterGuess)){
      guessCount--;
      guessResult = false;
    }
    else{
      for(int i = 0; i < secretWord.length(); i++){
        if(secretWord.charAt(i) == ch){
          String temp = "";
          for(int j = 0; j < secretWord.length(); j++){
            if(secretWord.charAt(j) == ch)
            {
              temp = temp + ch + " ";
            }
            else
            {
              temp = temp + dashLine.charAt(2*j) + dashLine.charAt(2*j+1);              
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
    int tempWordCount = 0;
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
    String[] temp = new String[tempWordCount];
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
    if(tempWordCount==0){
      secretWord = word[0];
      return false;
    } else {
      secretWord = temp[0];
      wordCount = tempWordCount;
      word = temp;
      return true;
    }
  }
  
  public void playAgain(){
    Scanner sc = new Scanner(System.in);
    
    while(check==false){
      System.out.println("                Do you want to play again ? (y/n)               ");
      System.out.println("----------------------------------------------------------------");
      char input = sc.next().charAt(0);
      if(input=='y' || input=='Y'){
        check = true;
        checkLength = false;
        play();
        //break;
      }
      else if(input=='n' || input=='N'){ 
        System.out.println("----------------------------------------------------------------");
        System.out.println("                     Thank for playing !!                       ");
        System.out.println("----------------------------------------------------------------");
        isPlay = false;
        checkLength = true;
        check = true;
        //break;
      }
      else {
        System.out.println("----------------------------------------------------------------");
        System.out.println("                  Invalid input, Try again !!"                   );
        System.out.println("----------------------------------------------------------------");
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