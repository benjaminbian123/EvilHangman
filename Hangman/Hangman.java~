import java.util.*; // import 
import java.io.*;

public class Hangman{
  
  private String secretWord = ""; // our secret word that change every time user play a letter
  private int guessCount; // number of guesses
  private String dashLine = ""; // to show dashline like this _ _ _ _
  private String letterGuessHistory = ""; // history of letter that you already guess
  private char letterGuess; // pointer
  private String[] word = new String[127142]; // 127142 words
  private int wordCount = 0; // count only possible word that you choose the length
  private int secretWordLength; // length of secret word
  private boolean guessResult = false; // check that you input correct or not
  public static boolean isPlay = true; // check that user play or not
  public static boolean checkLength = false; // check length to loop input of length
  public static boolean checkGuess = false;  // check length to loop input of guesses
  public static boolean check = false;  // check to loop a games
  File dict = new File("dictionary.txt"); // dictionary 
  
  public static void main(String [] args){
    Scanner sc = new Scanner(System.in); // Scanner
    Hangman h = new Hangman(); // created an object
    h.play(); // play it
  }
  
  public Hangman(){ //created object 
    // nothing here
  }
  
  public Hangman(int secretWordLength,int guessCount){ // 2 parameters with length,count
    check = false; // define 3 check
    checkGuess = false; 
    checkLength = false;
    this.guessCount = guessCount; // set count
    this.secretWordLength = secretWordLength; // set length
    Scanner readdict = null;
    try{
      readdict = new Scanner(dict); // read dictionary
    } catch(Exception e){
      throw new RuntimeException(e); // catch exception
    }
    int i = 0; // use to loop
    while(readdict.hasNext()) { // while it have next
      String temp = readdict.nextLine();
      if(temp.length()==secretWordLength){
        word[i] = temp;
        i++;
        wordCount++; // count a word
      }
    }
    for(i = 0; i< secretWordLength; i++){
      dashLine += "_ "; // created dash line _ _ _ _
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
    
    while(isPlay==true){ // while user played
      
      while(checkLength==false){ // while user input length
        System.out.print("Enter word length you want to play : ");
        int length = sc.nextInt();
        if(length>1 && length<23 || length==24 || length == 28 || length == 29){ // 1-22 and not equal to 24 28 29
          
          while(checkGuess==false){
            System.out.print("Enter number of your guess :");
            int count =  sc.nextInt();
            if(count>0 && count<=26){
              Hangman h = new Hangman(length,count);
              checkLength = true;
              checkGuess = true;
              h.play();
            }
            
            else if(count==0 || count>26){ // 0, more than 26 = cheater
              System.out.println("0 guess or more than 26 guess. NOT ALLOWED. Please try again");
            }
            else{
              System.out.println("Invalid Input. Please try again");
            }
            
          }
        } else if(length == 1 || length == 23 || length == 25 || length == 26 || length == 27 || length>=30){ // not 1,23,25,26,27 and more than or equal to 30
          System.out.println("We don't have word with that length. Please try again");
        }
        else{
          System.out.println("Invalid Input. Please try again");
        }
      }
      
      while(guessCount>=0){ // loop check and play
        String temp = dashLine.replaceAll(" ",""); // check that our dashline -> secretword or not
        if(guessCount==0){ // LOSE
          isPlay = false; // stop user
          if(check==false){
          System.out.println("----------------------------------------------------------------");
          System.out.println("SORRY YOU LOSE !!");
          System.out.println("The secret word is : "+getSecretWord());
          System.out.println("----------------------------------------------------------------");
          }
          playAgain(); // ask to play again
          break;
        }
        else if(temp.equals(getSecretWord())){ // WIN
          System.out.println("----------------------------------------------------------------");
          System.out.println("CONGRATULATIONS YOU WIN !!");
          System.out.println("The secret word is : "+getSecretWord());
          System.out.println("----------------------------------------------------------------");
          check = false;
          playAgain();
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
        //System.out.println(getSecretWord()); //show secret word
        //System.out.println(temp); // check word on dashline that == secret word?
        System.out.print("Enter a letter to guess : ");
        makeGuess(sc.next().charAt(0)); // make a guess
      }
    }
  }
  
  public boolean makeGuess(char ch) {
    guessResult = false;
    letterGuess = ch;
    checkHistory(letterGuess);
    if(checkWord(letterGuess)){ //if your word guess = false
      guessCount--;
      guessResult = false;
    }
    else{ // if word guess = true
      for(int i = 0; i < secretWord.length(); i++){
        if(secretWord.charAt(i) == ch){
          String temp = "";
          for(int j = 0; j < secretWord.length(); j++){
            if(secretWord.charAt(j) == ch)
            {
              temp = temp + ch + " "; // store the word that exists
            }
            else
            {
              temp = temp + dashLine.charAt(2*j) + dashLine.charAt(2*j+1); // store one to one with _ and space        
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
    int tempWordCount = 0;  // check word count from doesn't have input word
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
    String[] temp = new String[tempWordCount]; // store word that doesn't have input to array
    int tempIndex = 0;
    for (int i = 0; i < wordCount; i++) {
      for (int j = 0; j < secretWordLength; j++) {
        if (word[i].charAt(j) == ch) { 
          break;
        } else { // input check with secretword and doesn't exists
          if (j == secretWordLength - 1) {
            if (word[i].charAt(j) != ch) {
              temp[tempIndex] = word[i];
              tempIndex++;
            }
          }
        }
      }
    }
    if(tempWordCount==0){ // input correct
      secretWord = word[0];
      return false;
    } else {
      secretWord = temp[0];
      wordCount = tempWordCount;
      word = temp;
      return true;
    }
  }
  
  public void playAgain(){ // play again
    Scanner sc = new Scanner(System.in);
    while(check==false){
      System.out.println("                Do you want to play again ? (y/n)               ");
      System.out.println("----------------------------------------------------------------");
      char input = sc.next().charAt(0);
      if(input=='y' || input=='Y'){ // Yes
        check = true;
        checkGuess = false;
        checkLength = false;
        play();
        break;
      }
      else if(input=='n' || input=='N'){ // No
        System.out.println("----------------------------------------------------------------");
        System.out.println("                     Thank for playing !!                       ");
        System.out.println("----------------------------------------------------------------");
        isPlay = false;
        checkGuess = true;
        checkLength = true;
        check = true;
        break;
      }
      else { // not Y or N
        System.out.println("----------------------------------------------------------------");
        System.out.println("                  Invalid input, Try again !!"                   );
        System.out.println("----------------------------------------------------------------");
        check = false;
        playAgain();
      }
    }
  }
  
  public void checkHistory(char ch){ // check that user input same word as before
    String temp = letterGuessHistory.replaceAll(" ","");
    for(int i = 0; i< temp.length(); i++){
      if(temp.charAt(i)==ch){
        System.out.println("Please input again // Be careful if you always answer wrong but you know about it, it will decrease your chance to guess");
        Scanner sc = new Scanner(System.in);
        makeGuess(sc.next().charAt(0));
      }
    }
  }
  
  public String getSecretWord() {
    return secretWord; // show secret word
  }
  
  public int guessCount() {
    return guessCount; // show guess count
  }
  
  public String displayDashline() {
    return dashLine; // show dashline
  }
  
  public String showLetterGuess() {
    if (!guessResult) { // if it false
      letterGuessHistory = letterGuessHistory +" "+ letterGuess; // add history
    }
    return letterGuessHistory; // return hostory
  }
  
}