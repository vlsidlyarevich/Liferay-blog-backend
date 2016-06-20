package com.github.solairerove.blog.repository;

import com.github.solairerove.blog.Application;
import com.github.solairerove.blog.domain.Authority;
import com.github.solairerove.blog.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by vlad on 23.05.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@SpringApplicationConfiguration(Application.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findUserByIdTest() {
        List<Authority> authorities = new LinkedList<>();
        authorities.add(new Authority("ADMIN"));
        User saved = new User("stark2", "iron2@gmail.com", "iron_man_2", "strongpwd", authorities);
        userRepository.save(saved);

        User found = userRepository.findUserById(saved.getId());

        Assert.assertEquals(saved, found);
    }

    @Test
    public void changeUserNicknameTest() {
        List<Authority> authorities = new LinkedList<>();
        authorities.add(new Authority("ADMIN"));
        User saved = new User("stark3", "iron3@gmail.com", "iron_man_3", "strongpwd", authorities);
        userRepository.save(saved);

        userRepository.changeUserNickname("tony", saved.getId());

        Assert.assertEquals("tony", userRepository.findUserById(saved.getId()).getNickname());
    }

    @Test
    public void findUserByNicknameTest() {
        List<Authority> authorities = new LinkedList<>();
        authorities.add(new Authority("ADMIN"));
        User saved = new User("stark4", "iron4@gmail.com", "iron_man_4", "strongpwd", authorities);
        userRepository.save(saved);

        User found = userRepository.findUserByNickname(saved.getNickname());

        Assert.assertEquals(saved, found);
    }
}
