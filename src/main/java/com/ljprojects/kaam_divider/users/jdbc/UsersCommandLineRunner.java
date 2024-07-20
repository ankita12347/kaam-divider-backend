package com.ljprojects.kaam_divider.users.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.ljprojects.kaam_divider.users.Users;

@Component
public class UsersCommandLineRunner implements CommandLineRunner{

    @Autowired
    private UsersRepository usersRepository;
    
    @Override
    public void run(String... args) throws Exception{ 
        usersRepository.insert(new Users(1l, "Little", "Jishnu"));
        usersRepository.insert(new Users(2l, "Jishnu", "Little"));
        usersRepository.insert(new Users(3l, "Jishnu1", "Little1"));
        usersRepository.deleteById(3l);
        System.out.println(usersRepository.findById(1l));
        System.out.println(usersRepository.findById(2l));
    }
}
