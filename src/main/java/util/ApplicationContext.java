package util;

import repository.BookRepository;
import repository.SubjectsRepository;
import repository.UsersRepository;
import repository.impl.BookRepositoryImpl;
import repository.impl.SubjectsRepositoryImpl;
import repository.impl.UsersRepositoryImpl;
import service.BookService;
import service.SubjectsService;
import service.UsersService;
import service.impl.BookServiceImpl;
import service.impl.SubjectsServiceImpl;
import service.impl.UsersServiceImpl;

public class ApplicationContext {
    public static final String[] LOGIN_MENU_ITEM = {"LOGIN USER", "EXIT"};
    public static final String[] ADMIN_MENU_ITEM = {
            "ADD SUBJECTS🩸",
            "DELETE SUBJECTS🩸😈",
            "EDITE SUBJECTS🩸",
            "SEE ALL SUBJECTS🩸",
            "SEE ALL SUBJECTS WITH ONE BOOK🩸😈",
            "ADD USERS🩸",
            "DELETE USERS🩸",
            "UPDATE USERS🩸",
            "ADD BOOK🩸",
            "DELETE BOOK🩸",
            "UPDATE BOOK🩸",
            "WHO TAKE BOOK🩸😈",
            "ADD USERS ADDRESS🩸😈",
            "SEE ALL BOOK🩸",
            "SEE ALL USERS🩸",
            "SEE ALL USERS ADDRESS🩸😈",
             "BACK TO LAST MENU🩸"};
    public static final String[] USER_MENU_ITEM = {"TAKE BOOK🩸😈", "SEE ALL BOOK🩸","BACK TO LAST MENU🩸"};


    //Repository
    public static UsersRepository usersRepository = new UsersRepositoryImpl();
    public static BookRepository bookRepository = new BookRepositoryImpl();
    public static SubjectsRepository subjectsRepository = new SubjectsRepositoryImpl();
    //Service
    public static BookService bookService = new BookServiceImpl();
    public static UsersService usersService = new UsersServiceImpl();
    public static SubjectsService subjectsService = new SubjectsServiceImpl();


}
