package menu;

import model.enums.UserType;
import util.ApplicationContext;
import util.Printer;
import util.Util;

public class Menu {
    public static void startMenu() {
        System.out.println("\u001B[91m" + "Welcome to Library Management System");

        while (true) {
            Printer.printItem(ApplicationContext.LOGIN_MENU_ITEM);
            int choice = Util.getIntInput("SELECT ONE ITEM --> ");
            switch (choice) {
                case 1 -> loginMenu();
                case 2 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }
        }
    }

    public static void loginMenu() {
        String username = Util.getStringInput("Enter Username : ");
        String password = Util.getStringInput("ٍEnter Password : ");
        try {
            UserType userType = ApplicationContext.usersService.login(username, password);
            switch (userType) {
                case ADMIN -> adminMenu();
                case USER -> usersMenu();
                default -> System.out.println("Invalid User");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static void adminMenu() {
        System.out.println("\u001B[91m" + "Menu Admin Management System");
        Printer.printItem(ApplicationContext.ADMIN_MENU_ITEM);
        int choice = Util.getIntInput("SELECT ONE ITEM --> ");
        switch (choice) {
            case 1://1 Add Subjects❤️
                Printer.printAllSubjects();
                String nameSubject = Util.getStringInput("Enter Name Subject : ");
                ApplicationContext.subjectsService.addSubject(nameSubject);
                adminMenu();
            case 2: //2 Delete Subjects❤️
                Printer.printAllSubjects();
                Long id = (long) Util.getIntInput("Enter ID Subject: ");
                ApplicationContext.subjectsService.deleteSubject(id);
                adminMenu();
            case 3://3 Edit Subjects❤️
                Printer.printAllSubjects();
                Long idSubject = (long) Util.getIntInput("Enter ID Subjects : ");
                String name = Util.getStringInput("Enter Name To Edited Subject : ");
                ApplicationContext.subjectsService.updateSubject(idSubject, name);
                adminMenu();
            case 4://4 See All Subjects ❤️
                Printer.printAllSubjects();
                adminMenu();
            case 5://5 SEE ALL SUBJECTS WITH ONE BOOK❤️
                Printer.printSubjectsWithOneBook();
                adminMenu();
            case 6://6  ADD USERS❤️
                Printer.printAllUsers();
                String firstName = Util.getStringInput("Enter FirstName : ");
                String lastName = Util.getStringInput("Enter LastName : ");
                String gender = Util.getStringInput("Enter Gender(Only Men or Women Exist) : ");
                String username = Util.getStringInput("Enter new Username : ");
                String password = Util.getStringInput("Enter new Password : ");
                ApplicationContext.usersService.addUser(firstName, lastName, gender, username, password);
                adminMenu();
            case 7://7 DELETE USERS❤️
                Printer.printAllUsers();
                Long idUser = (long) Util.getIntInput("Enter ID User To Delete : ");
                ApplicationContext.usersService.deleteUser(idUser);
                adminMenu();
            case 8://8 UPDATE USERS❤️
                Printer.printAllUsers();
                Long idUser1 = (long) Util.getIntInput("Enter ID User To Update : ");
                String firstName1 = Util.getStringInput("Enter FirstName : ");
                String lastName1 = Util.getStringInput("Enter LastName : ");
                String gender1 = Util.getStringInput("Enter Gender(Only Men or Women Exist) : : ");
                String username1 = Util.getStringInput("Enter New Username : ");
                String password1 = Util.getStringInput("Enter New Password : ");
                ApplicationContext.usersService.updateUser(idUser1, firstName1, lastName1, gender1, username1, password1);
                adminMenu();
            case 9: //9 ADD BOOK
                Printer.printAllBook();
                Printer.printAllSubjects();
                String title = Util.getStringInput("Enter Book Title : ");
                String author = Util.getStringInput("Enter Book Author : ");
                Long subject = (long) Util.getIntInput("Enter ID Subject : ");
                ApplicationContext.bookService.addBook(title, author, subject);
                adminMenu();
            case 10://10 DELETE BOOK❤️
                Printer.printAllBook();
                Long idBook = (long) Util.getIntInput("Enter ID Book To Delete: ");
                ApplicationContext.bookService.deleteBook(idBook);
                adminMenu();
            case 11://11 UPDATE BOOK❤️
                Printer.printAllBook();
                Printer.printAllSubjects();
                Long idBook1 = (long) Util.getIntInput("Enter ID Book To Update : ");
                String title1 = Util.getStringInput("Enter New Title Book  : ");
                String author1 = Util.getStringInput("Enter Author : ");
                Long subject1 = (long) Util.getIntInput("Enter ID Subject : ");
                ApplicationContext.bookService.updateBook(idBook1, title1, author1, subject1);
                adminMenu();
            case 12: //See all book take❤️
                Printer.printAllBookTake();
                adminMenu();

            case 13://add user address
                Printer.printAllUsers();
                Long idUser2 = (long) Util.getIntInput("Enter ID User To Add Address : ");
                String country = Util.getStringInput("Enter Country : ");
                String city1 = Util.getStringInput("Enter City : ");
                String street1 = Util.getStringInput("Enter Street : ");
                String zipCode = Util.getStringInput("Enter ZipCode : ");
                ApplicationContext.usersService.addAddress(idUser2, street1, city1, zipCode, country);
                adminMenu();
            case 14://see all book❤️
                Printer.printAllBook();
                adminMenu();
            case 15://see all users❤️
                Printer.printAllUsers();
                adminMenu();
            case 16: //see all users address❤️
                Printer.printAllUsersAddress();
                adminMenu();
            case 17://see all book with same id❤️
                Printer.printAllSubjects();
                Long subjectsId = (long) Util.getIntInput("Enter Subjects ID To See All Book : ");
                Printer.printAllBookWithSubjectsId(subjectsId);
                adminMenu();
            case 18 ://BACK TO LAST MENU❤️
                startMenu();
            default:
                System.out.println("Invalid Choice");
                System.out.println("Try again");
                adminMenu();
        }
    }

    public static void usersMenu() {
        Printer.printItem(ApplicationContext.USER_MENU_ITEM);
        int choice = Util.getIntInput("SELECT ONE ITEM --> ");
        switch (choice) {
            case 1://TAKE BOOK❤️
                Printer.printAllBook();
                Long BookID = (long) Util.getIntInput("Enter ID Book : ");
                String username = Util.getStringInput("Enter your Username : ");
                ApplicationContext.bookService.takeBook(BookID, username);
                usersMenu();
                break;
            case 2://SEE ALL BOOK❤️
                Printer.printAllBook();
                usersMenu();
                break;
            case 3:
                startMenu();
            default:
                System.out.println("Invalid Choice");
                System.out.println("Try again");
                usersMenu();
        }
    }
}
