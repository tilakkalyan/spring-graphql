package com.graphql.repository;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.graphql.model.Address;
import com.graphql.model.User;

@Repository
public class UserRepository
{
    private List<User> users = new ArrayList<>();

    public List<User> findAll()
    {
        return users;
    }

    public User addUser(User user){
        users.add(user);
        return findById(user.getId());
    }

    public User findById(Long id)
    {
        return users.stream()
                .filter(author -> author.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostConstruct
    private void init()
    {
        users.add(new User(1L, "Abc", "Mr", new Address("Abc City")));
        users.add(new User(2L, "Xyz", "Mr", new Address("Xyz City")));
        users.add(new User(3L, "Pqr", "Mr", new Address("Pqr City")));
    }
}
