package ru.netology.spring_boot_rest.repository;

import org.springframework.stereotype.Repository;
import ru.netology.spring_boot_rest.auth.Authorities;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<String, String> users = Map.of(
            "admin", "1234",
            "user", "1111"
    );

    private final Map<String, List<Authorities>> authorities = Map.of(
            "admin", List.of(Authorities.READ, Authorities.WRITE, Authorities.DELETE),
            "user", List.of(Authorities.READ)
    );

    public List<Authorities> getUserAuthorities(String user, String password) {
        if (users.containsKey(user) && users.get(user).equals(password)) {
            return authorities.get(user);
        }
        return List.of();
    }
}