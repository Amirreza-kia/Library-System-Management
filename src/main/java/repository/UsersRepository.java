package repository;

import model.Address;
import model.User;
import model.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends BaseRepository<Users> {
    Optional<User> login(String username, String password);

    Optional<Users> findByUsername(String username);



}
