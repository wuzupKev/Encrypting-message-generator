
package def;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class EncryptionProgram {

    private Scanner scanner;
    private Random random;private ArrayList<Character> list;
    private ArrayList<Character> shuffledList;
    private char character;
    private String line;
    private char[] letters;
    private char[] secretLetters;

    public EncryptionProgram() {

        scanner = new Scanner(System.in);
        random = new Random();
        list = new ArrayList();
        shuffledList = new ArrayList();
        character = ' ';
        newKey();
        askQuestion();
    }
    private void askQuestion(){
        while(true){
            System.out.println("What do you want to do: ");
            System.out.println("(N)ew Key ,(G)et key, (E)crypt,(D)ecrypt,(Q)uit ");
            char response= Character.toUpperCase(scanner.nextLine().charAt(0));

            switch (response){
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encryt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'Q':
                    quit();
                default:
                    System.out.println("not a valid answer");


            }
        }
    }
    private void newKey() {
        character= ' ';
        list.clear();
        shuffledList.clear();
        for ( int i=32;i<127;i++){
            list.add(Character.valueOf(character));
            character++;
        }
        shuffledList= new ArrayList(list);
        Collections.shuffle(shuffledList);
        System.out.println("**A new key has been generate**");

    }

    private void getKey() {
        System.out.println("Key: ");
        for (Character x : list) {
            System.out.print(x);
        }
        System.out.println();
        for (Character x : shuffledList) {
            System.out.print(x);
            
        }
        System.out.println();
    }

    private void encryt() {
        System.out.println("Enter a message to be encrypted: ");
        String message = scanner.nextLine();
        letters= message.toCharArray();

        for(int i=0;i<letters.length;i++)
        {
            for (int j=0;j<list.size();j++){
                if (letters[i]==list.get(j))
                {
                    letters[i]=shuffledList.get(j);
                    break;
                }
                    
            }
        }
        System.out.println("Encrypted message");
        for (char c : letters) {
            System.out.print(c);
            
        }
        System.out.println();
    }

    private void decrypt() {
        System.out.println("Enter a message to be decrypted: ");
        String message = scanner.nextLine();
        letters= message.toCharArray();

        for(int i=0;i<letters.length;i++)
        {
            for (int j=0;j<shuffledList.size();j++){
                if (letters[i]==shuffledList.get(j))
                {
                    letters[i]=list.get(j);
                    break;
                }
                    
            }
        }
        System.out.println("Display the message");
        for (char c : letters) {
            System.out.print(c);
            
        }
        System.out.println();

    }

    private void quit() {
        System.out.println("Thanks bro , have a awesome day beast!");
        System.exit(0);

    }
}
