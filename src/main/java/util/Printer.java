package util;

import model.Address;
import model.Book;
import model.Subjects;
import model.Users;

import java.util.List;

public class Printer {
    //done❤️
    public static void printItem(String[] menuItem) {
        System.out.println("\u001B[34m" + "🔥--------------------------🔥");
        for (int i = 0; i < menuItem.length; i++) {
            System.out.printf("\u001B[34m" + "%d )☠️ %s \n", (i + 1), menuItem[i]);
        }
        System.out.println("\u001B[34m" + "🔥--------------------------🔥");
    }
    //done❤️
    public static void printAllSubjects() {
        List<Subjects> subjects = ApplicationContext.subjectsRepository.findAll();
        String leftAlignFormat = "\u001B[34m" + "| %-4d |💀%-14s |️%n";
        System.out.format("\u001B[34m" + "+卐卐卐卐+卐卐卐卐卐卐卐卐卐卐卐+%n");
        System.out.format("\u001B[34m" + "| ID   |        SUBJECT     |%n");
        System.out.format("\u001B[34m" + "+卐卐卐卐+卐卐卐卐卐卐卐卐卐卐卐+%n");

        for (Subjects subject : subjects) {
            System.out.format(leftAlignFormat,subject.getId(),subject.getName());
            System.out.format("\u001B[34m" + "+卐卐卐卐+卐卐卐卐卐卐卐卐卐卐卐+%n");
        }
    }
    //done❤️
    public static void printSubjectsWithOneBook(){
        List<Subjects> subjects = ApplicationContext.subjectsRepository.findSubjectsWhitOneBook();
        //ID_SUBJECT SUBJECT
        String leftAlignFormat = "\u001B[34m" + "| %-4d |💀%-14s |️%n";
        System.out.format("\u001B[34m" + "+------+-----------------+%n");
        System.out.format("\u001B[34m" + "| ID   |     SUBJECT     |%n");
        System.out.format("\u001B[34m" + "+------+-----------------+%n");

        for (Subjects subject : subjects) {
           System.out.format(leftAlignFormat,subject.getId(),subject.getName());
            System.out.format("\u001B[34m" + "+------+-----------------+%n");
        }
    }
    //done❤️
    public static void printAllBook() {
        List<Book> books = ApplicationContext.bookRepository.findAll();
        //author title subjects id
        String leftAlignFormat = "\u001B[34m" + "| %-4d |💀%-14s |️💀%-15s|💀%-15s|💀%-15s|%n";

        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("\u001B[34m" + "| ID   |      TITLE      |      AUTHOR     |     SUBJECT     |    SUBJECT-ID   |%n");
        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        for (Book book : books) {
            System.out.format(leftAlignFormat,book.getId(),book.getTitle(),book.getAuthor(),book.getSubjects().getName(),book.getSubjects().getId());
            System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        }

    }
    //done❤️
    public static void printAllUsers(){
        List<Users> users = ApplicationContext.usersRepository.findAll();
        // id - firstname - lastname - username - gender
        String leftAlignFormat = "\u001B[34m" + "| %-4d |💀%-14s |️💀%-15s|💀%-15s|💀%-15s|%n";

        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("\u001B[34m" + "| ID   |     FIRSTNAME   |     LASTNAME    |     USERNAME    |     GENDER🤰    |%n");
        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        for (Users user : users) {
            System.out.format(leftAlignFormat,user.getId(),user.getFirstName(),user.getLastName(),user.getUsername(),user.getGender());
            System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        }
    }
    //done❤️
    public static void printAllBookTake(){
        List<Users> users = ApplicationContext.usersRepository.findAll();
        String leftAlignFormat = "\u001B[34m" + "|💀%-14s |️💀%-15d|%n";
        for (Users user : users) {
            System.out.format(leftAlignFormat, user.getUsername(),user.getBooks().toArray().length);
            System.out.format("\u001B[34m" + "+-----------------+-----------------+%n");
            System.out.format("\u001B[34m" + "|    USERNAME     | COUNT_BOOK_TAKE |%n");
            System.out.format("\u001B[34m" + "+-----------------+-----------------+%n");
        }
    }
    //done❤️
    public static void printAllUsersAddress(){
        List<Users> usersListAddress = ApplicationContext.usersRepository.findAll();
        String leftAlignFormat = "\u001B[34m" + "| %-4d |💀%-14s |️💀%-15s|💀%-15s|💀%-15s|%n";
        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("\u001B[34m" + "| ID   |     COUNTRY     |       CITY      |      STREET     |      ZIPCODE    |%n");
        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        for (Users user : usersListAddress) {
            List<Address> addressList = user.getAddressList();
            for (Address address : addressList) {
                System.out.format(leftAlignFormat,user.getId(),address.getCountry(),address.getCity(),address.getStreet(),address.getZipCode());
                System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
            }

        }
    }
    public static void printAllBookWithSubjectsId(Long id){
        List<Book> books = ApplicationContext.subjectsService.findAllBookWithSubject(id);
        String leftAlignFormat = "\u001B[34m" + "| %-4d |💀%-14s |️💀%-15s|💀%-15s|💀%-15s|%n";
        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        System.out.format("\u001B[34m" + "| ID   |      TITLE      |      AUTHOR     |     SUBJECT     |    SUBJECT-ID   |%n");
        System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        for (Book book : books) {
            System.out.format(leftAlignFormat,book.getId(),book.getTitle(),book.getAuthor(),book.getSubjects().getName(),book.getSubjects().getId());
            System.out.format("\u001B[34m" + "+------+-----------------+-----------------+-----------------+-----------------+%n");
        }
    }

}
