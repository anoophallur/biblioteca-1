package com.twu28.biblioteca.LibraryPkg;

import org.junit.internal.matchers.StringContains;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 7/13/12
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class LibraryClass {

    private static final int NOOFBOOKS = 50;


    public static void main(String[] args){
        System.out.println("\t\tWelocome to BIBLIOTECA\n");
        while(true){
            System.out.println("1.File\t2.View\t3.Help\n");
            Scanner reader = new Scanner(System.in);
            int input = reader.nextInt();

            switch(input){
                case 1:
                    System.out.println("1.Display all the Books");
                    System.out.println("2.Reserve a book");
                    System.out.println("3.Check Your Library Number");
                    System.out.println("4.Exit");
                    int inputFile = reader.nextInt();
                    switch(inputFile){
                        case 1:
                            //Function to Display All the Books
                            DisplayBooks(0);
                            break;
                        case 2:
                            //Function to Reserve a Book
                            ReserveBook();
                            break;
                        case 3:
                            //Function to Check Library Number
                            CheckNumber();
                            break;
                        case 4:
                            //Function to Exit the Program
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Select A Valid Option\n");
                    }
                    break;
                case 2:
                    System.out.println("1.Sort Books by ISBN");
                    System.out.println("2.Sort Books by Title");
                    System.out.println("3.Sort Books by Author");
                    System.out.println("4.Sort Books by Publisher");
                    int inputView = reader.nextInt();
                    switch(inputView){
                        case 1:
                            //Function to Sort Books by ISBN
                            DisplayBooks(0);
                            break;
                        case 2:
                            //Function to Sort Books by Title
                            DisplayBooks(1);
                            break;
                        case 3:
                            //Function to Sort Books by Author
                            DisplayBooks(2);
                            break;
                        case 4:
                            //Function to Sort Books by Publisher
                            DisplayBooks(3);
                            break;
                        default:
                            System.out.println("Select A Valid Option\n");
                    }
                    break  ;
                case 3:
                    System.out.println("1.Bublioteca Help");
                    System.out.println("2.About");
                    int inputHelp = reader.nextInt();
                    switch(inputHelp){
                        case 1:
                            //Function to Give HELP
                            HelpFunction();
                            break;
                        case 2:
                            //Function to Display About
                            AboutFunction();

                            break;
                        default:
                            System.out.println("Select A Valid Option\n");
                    }
                    break ;
                default :
                    System.out.println("Select A Valid Option\n");
                    Scanner ready = new Scanner(System.in);
                    reader.nextLine();
            }

        }
    }

    public static void DisplayBooks(int SortBy){
        System.out.println("ISBN\t\tTitle\t\tAuthor\t\tPublisher");

        if(SortBy == 0){//Sort By ISBN

            for(int i = 0; i < NOOFBOOKS ; i++)
                System.out.println("ISBN-"+i+"\t\tTitle\t\tAuthor\t\tPublisher");
        }
        if(SortBy == 1){//Sort By Title

            for(int i = 0 ;i < NOOFBOOKS ; i++)
                System.out.println("ISBN\t\tTitle-"+i+"\t\tAuthor\t\tPublisher");
        }
        if(SortBy == 2){//Sort By Author

            for(int i = 0 ;i < NOOFBOOKS ; i++)
                System.out.println("ISBN\t\tTitle\t\tAuthor-"+i+"\t\tPublisher");
        }
        if(SortBy == 3){//Sort By Publisher

            for(int i = 0 ;i < NOOFBOOKS ; i++)
                System.out.println("ISBN\t\tTitle\t\tAuthor\t\tPublisher-"+i);
        }

    }

    public static void ReserveBook(){
        System.out.println("What do you know about the Book");
        System.out.println("1.ISBN\t2.Title\t3.Author\t4.Publisher");
        Scanner reader = new Scanner(System.in);
        int inputReserve = reader.nextInt();

        Scanner readerFeature = new Scanner(System.in);
        boolean Available;
        switch(inputReserve){
            case 1:
                System.out.println("Enter the ISBN");
                String ISBN = readerFeature.nextLine();
                Available = FindBook(ISBN,0);
                if(Available == true)
                    System.out.println("Thank You! Enjoy the book.");
                else
                    System.out.println("Sorry we don't have that book yet.");
                break;
            case 2:
                System.out.println("Enter the Title Of the Book");
                String Title = readerFeature.nextLine();
                Available = FindBook(Title,1);
                if(Available == true)
                    System.out.println("Thank You! Enjoy the book.");
                else
                    System.out.println("Sorry we don't have that book yet.");
                break;

            case 3:
                System.out.println("Enter the Author(s) Name");
                String Author = readerFeature.nextLine();
                Available = FindBook(Author,2);
                if(Available == true)
                    System.out.println("Thank You! Enjoy the book.");
                else
                    System.out.println("Sorry we don't have that book yet.");
                break;
            case 4:
                System.out.println("Enter the Publisher's Name");
                String Publisher = readerFeature.nextLine();
                Available = FindBook(Publisher,3);
                if(Available == true)
                    System.out.println("Thank You! Enjoy the book.");
                else
                    System.out.println("Sorry we don't have that book yet.");
                break;
            default:
                System.out.println("Select A Valid Option\n");
                Scanner reader1 = new Scanner(System.in);
                reader1.nextLine();
        }

    }

    public static boolean FindBook(String Feature,int Type){
        Random random = new Random();
        boolean status = false;//Assume Book not available unless it's availability is confirmed
        switch(Type){
            case 0://Feature is ISBN
                //Mechanism to check whether the Book with Specified ISBN is present in Database
                String[] PseudoDBofISBN = {}; //Pseudo Database of ISBN's of Books in Library...
                // Fill in Later when Available
                for(int i =0 ; i < NOOFBOOKS ; i++){
                    if(Feature == PseudoDBofISBN[i]){
                        status = random.nextBoolean();  //Problity that Book will be available
                        break;
                    }
                    else{
                        status = false;

                    }
                }

                break;

            case 1://Feature is Title
                //Mechanism to check whether the Book with Specified Title is present in Database
                status = random.nextBoolean();
                break;

            case 2://Feature is Author
                //Mechanism to check whether the Book with Specified Author(s) is present in Database
                status = random.nextBoolean();
                break;

            case 4://Feature is Publisher
                //Mechanism to check whether the Book with Specified Publisher is present in Database
                status = random.nextBoolean();
                break;

            default:
                System.out.println("Select a Valid Option");
                Scanner reader = new Scanner(System.in);
                reader.nextLine();
                status = random.nextBoolean();
        }
        return status;
    }

    public static void HelpFunction(){
        System.out.println("Help About Biblioteca is presently not Available");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
    }

    public static void AboutFunction(){
        System.out.println("Copyright ThoughtWorks Pvt Ltd\nBiblioteca version 1.0\n");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
    }

    public static void CheckNumber(){
        System.out.println("Please talk to Librarian. Thank you.\n");
        Scanner reader = new Scanner(System.in);
        reader.nextLine();
    }
}