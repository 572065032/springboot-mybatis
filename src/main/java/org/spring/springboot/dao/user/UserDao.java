package org.spring.springboot.dao.user;

import com.buchou.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    public void insert(User user);

    public int update(User user);

    public List<User> selectList(User user);
}
