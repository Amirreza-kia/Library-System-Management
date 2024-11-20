package service;

import model.User;
import model.enums.UserType;

public interface UsersService {
    UserType login(String username, String password);

    void addUser(String firstname, String lastname,String gender, String username, String password);
    void updateUser(Long id,String firstname, String lastname, String gender, String username, String password);
    void addAddress(Long id, String street, String city, String zipCode, String country);
    void deleteUser(Long id);

}
