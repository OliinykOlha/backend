package de.ait.userapi.repository;

import de.ait.userapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class UserDb implements UserRepository {
    private  Long lastId = 6L;
    private static HashMap<Long, User> map = new HashMap<>();
    static {
        map.put(1L, new User(1L, "John", "john@gmail.com", "qw1"));
        map.put(2L, new User(2L, "Jack", "jack@gmail.com", "jjj3"));
        map.put(3L, new User(3L, "Jan", "jan@gmail.com", "kjjn4"));
        map.put(4L, new User(4L, "Anna", "anna@gmail.com", "ghgh3"));
        map.put(5L, new User(5L, "Ira", "ira@gmail.com", "ghgh5"));
        map.put(6L, new User(4L, "Lisa", "lisa@gmail.com", "hghgfj8"));
    }

    public List<User> findAll() {
       return  map.values().stream().toList();
    }

    public User findById(Long id) {
        return map.get(id);
    }

    @Override
    public User save(User user) {
         user.setId(++lastId);
         map.put(user.getId(), user);
         return user;
    }


}
