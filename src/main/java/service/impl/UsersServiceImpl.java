package service.impl;

import model.Address;
import model.User;
import model.Users;
import model.enums.Gender;
import model.enums.UserType;
import service.UsersService;
import util.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersServiceImpl implements UsersService {
    @Override
    public UserType login(String username, String password) {
        Optional<User> optionalUser = ApplicationContext.usersRepository.login(username, password);
        if (optionalUser.isEmpty()) {
            System.out.println("\u001B[91m" +"Username or Password incorrect 😂😂😂");
        }
        return optionalUser.get().getUserType();
    }

    @Override
    public void addUser(String firstname, String lastname, String gender, String username, String password) {
        Users user = new Users();
        user.setFirstName(firstname);
        user.setLastName(lastname);
        Gender gender1 = Gender.valueOf(gender.toUpperCase());
        user.setGender(gender1);
        user.setUsername(username);
        user.setPassword(password);
        user.setUserType(UserType.USER);
        ApplicationContext.usersRepository.saveOrUpdate(user);
    }

    @Override
    public void updateUser(Long id, String firstname, String lastname, String gender, String username, String password) {
        if (ApplicationContext.usersRepository.findById(id).isPresent()) {
            Users user = ApplicationContext.usersRepository.findById(id).get();
            user.setFirstName(firstname);
            user.setLastName(lastname);
            Gender gender1 = Gender.valueOf(gender.toUpperCase());
            user.setGender(gender1);
            user.setUsername(username);
            user.setPassword(password);
            user.setUserType(UserType.USER);
            ApplicationContext.usersRepository.saveOrUpdate(user);
        }else System.out.println("User not found");
    }

    @Override
    public void addAddress(Long id, String street, String city, String zipCode, String country) {
        if(ApplicationContext.usersRepository.findById(id).isPresent()) {
            Users user = ApplicationContext.usersRepository.findById(id).get();
            Address address = new Address();
            address.setStreet(street);
            address.setCity(city);
            address.setZipCode(zipCode);
            address.setCountry(country);
            List<Address> addressList = user.getAddressList();
            addressList.add(address);
            ApplicationContext.usersRepository.saveOrUpdate(user);
        }else System.out.println("User not found");
    }
}
