/**
 * class CSCI251ProjThree. It is an interactive test class for MyHashTable
 * 
 * @author Hongbiao Zeng
 * @version March 31, 2020
 */
import java.util.Scanner;

public class CSCI251ProjThree
{
   public static void main(String args[]){
        String value;
        String key;
        int choice;
        Scanner input = new Scanner(System.in);
        MyHashTable<String, String> table = new MyHashTable<String, String>(10);
       
        do{
            menu();
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch(choice){
            case 1:
                System.out.println("Enter an (Key, Value) pair that you will add to table ");
                System.out.print("Separate by white space: ");
                key = input.next();
                value = input.next();
                table.insert(key, value);
                System.out.println("(" + key + ", " + value + ") entered");
                break;
            case 2: 
                System.out.print("Enter a key that you will remvoe from table: ");
                key = input.next();
                value = table.remove(key);
                if(value != null)
                    System.out.println("Remove successfully. The removed value is " + value);   
                else
                    System.out.println("No such key in table");
                break;
            case 3:
                System.out.print("Enter the key that you want to search for: ");
                key = input.next();
                value = table.get(key);
                if(value == null)
                    System.out.println("No such data in table");
                else
                    System.out.println("The corresponding value is: " + value);
                break;
            case 4:
                if(table.isEmpty())
                    System.out.println("table is empty");
                else
                    System.out.println(table);
                break;
            case 5:
                System.out.println("Make sure you run enough test before you turn it in");
                break;
            default:
                System.out.println("Wrong option. Please choose from menu");
                break;
            }
        }while(choice != 5);
        
    }
    
    private static void menu(){
        System.out.println("********************************");
        System.out.println("*              MENU            *");
        System.out.println("* 1. Add a (key, value) pair   *");
        System.out.println("* 2. Remove a value by its key *");
        System.out.println("* 3. Search a value by its key *");
        System.out.println("* 4. Print out table           *");
        System.out.println("* 5. Quit                      *");
        System.out.println("********************************");
    }
}

/*
 * 
 
//TESTING DIRECT HASHING//

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 450 450
The key has a hash code of 51663 and located in bucket 3
(450, 450) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 4
The item(s) in index 0 is: Empty
The item(s) in index 1 is: Empty
The item(s) in index 2 is: Empty
The item(s) in index 3 is: 450.
The item(s) in index 4 is: Empty
The item(s) in index 5 is: Empty
The item(s) in index 6 is: Empty
The item(s) in index 7 is: Empty
The item(s) in index 8 is: Empty
The item(s) in index 9 is: Empty

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: 450
The corresponding value is: 450
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 2
Enter a key that you will remvoe from table: 450
Remove successfully. The removed value is 450
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: 450
No such data in table
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 4
The item(s) in index 0 is: Empty
The item(s) in index 1 is: Empty
The item(s) in index 2 is: Empty
The item(s) in index 3 is: Empty
The item(s) in index 4 is: Empty
The item(s) in index 5 is: Empty
The item(s) in index 6 is: Empty
The item(s) in index 7 is: Empty
The item(s) in index 8 is: Empty
The item(s) in index 9 is: Empty

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 5
Make sure you run enough test before you turn it in





//TESTING HASHING USING A "STRING" AS A KEY I.E., ONE, TWO, THREE//

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: One 758
The key has a hash code of 79430 and located in bucket 0
(One, 758) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Two 370
The key has a hash code of 84524 and located in bucket 4
(Two, 370) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Three 247
The key has a hash code of 80786814 and located in bucket 4
(Three, 247) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Four 373
The key has a hash code of 2195782 and located in bucket 2
(Four, 373) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Five 605
The key has a hash code of 2190034 and located in bucket 4
(Five, 605) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Six 1
The key has a hash code of 83138 and located in bucket 8
(Six, 1) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Seven 301
The key has a hash code of 79777773 and located in bucket 3
(Seven, 301) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Eight 459
The key has a hash code of 66953327 and located in bucket 7
(Eight, 459) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Nine 127
The key has a hash code of 2428114 and located in bucket 4
(Nine, 127) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Ten 861
The key has a hash code of 83965 and located in bucket 5
(Ten, 861) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: Eleven 882
The key has a hash code of 2078277217 and located in bucket 7
(Eleven, 882) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: One
The corresponding value is: 758
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: ahhhh
No such data in table
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: Eight
The corresponding value is: 459
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 4
The item(s) in index 0 is: 758.
The item(s) in index 1 is: Empty
The item(s) in index 2 is: 373.
The item(s) in index 3 is: 301.
The item(s) in index 4 is: 370, 247, 605, 127.
The item(s) in index 5 is: 861.
The item(s) in index 6 is: Empty
The item(s) in index 7 is: 459, 882.
The item(s) in index 8 is: 1.
The item(s) in index 9 is: Empty

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 2
Enter a key that you will remvoe from table: Ten
Remove successfully. The removed value is 861
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 4
The item(s) in index 0 is: 758.
The item(s) in index 1 is: Empty
The item(s) in index 2 is: 373.
The item(s) in index 3 is: 301.
The item(s) in index 4 is: 370, 247, 605, 127.
The item(s) in index 5 is: Empty
The item(s) in index 6 is: Empty
The item(s) in index 7 is: 459, 882.
The item(s) in index 8 is: 1.
The item(s) in index 9 is: Empty

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 5
Make sure you run enough test before you turn it in


//TESTING USING "INTEGERS" AS THE KEY I.E., 0, 1, 2..//
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 0 502
The key has a hash code of 48 and located in bucket 8
(0, 502) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 1 953
The key has a hash code of 49 and located in bucket 9
(1, 953) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 2 412
The key has a hash code of 50 and located in bucket 0
(2, 412) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 3
331
The key has a hash code of 51 and located in bucket 1
(3, 331) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 4 387
The key has a hash code of 52 and located in bucket 2
(4, 387) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 5 666
The key has a hash code of 53 and located in bucket 3
(5, 666) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 6 973
The key has a hash code of 54 and located in bucket 4
(6, 973) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 7 973
The key has a hash code of 55 and located in bucket 5
(7, 973) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 8 20
The key has a hash code of 56 and located in bucket 6
(8, 20) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 1
Enter an (Key, Value) pair that you will add to table 
Separate by white space: 9 618
The key has a hash code of 57 and located in bucket 7
(9, 618) entered
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 4
The item(s) in index 0 is: 412.
The item(s) in index 1 is: 331.
The item(s) in index 2 is: 387.
The item(s) in index 3 is: 666.
The item(s) in index 4 is: 973.
The item(s) in index 5 is: 973.
The item(s) in index 6 is: 20.
The item(s) in index 7 is: 618.
The item(s) in index 8 is: 502.
The item(s) in index 9 is: 953.

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: 10
No such data in table
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: 7
The corresponding value is: 973
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 3
Enter the key that you want to search for: 1
The corresponding value is: 953
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 2
Enter a key that you will remvoe from table: 3
Remove successfully. The removed value is 331
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 4
The item(s) in index 0 is: 412.
The item(s) in index 1 is: Empty
The item(s) in index 2 is: 387.
The item(s) in index 3 is: 666.
The item(s) in index 4 is: 973.
The item(s) in index 5 is: 973.
The item(s) in index 6 is: 20.
The item(s) in index 7 is: 618.
The item(s) in index 8 is: 502.
The item(s) in index 9 is: 953.

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 2
Enter a key that you will remvoe from table: 7
Remove successfully. The removed value is 973
********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 4
The item(s) in index 0 is: 412.
The item(s) in index 1 is: Empty
The item(s) in index 2 is: 387.
The item(s) in index 3 is: 666.
The item(s) in index 4 is: 973.
The item(s) in index 5 is: Empty
The item(s) in index 6 is: 20.
The item(s) in index 7 is: 618.
The item(s) in index 8 is: 502.
The item(s) in index 9 is: 953.

********************************
*              MENU            *
* 1. Add a (key, value) pair   *
* 2. Remove a value by its key *
* 3. Search a value by its key *
* 4. Print out table           *
* 5. Quit                      *
********************************
Enter your choice: 5
Make sure you run enough test before you turn it in

 */