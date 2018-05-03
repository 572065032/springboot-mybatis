package com.buchou.service.user;

import com.buchou.domain.user.User;
import com.buchou.domain.web.JsonData;

import java.util.List;

public interface UserService {

    public JsonData insert(User u);

    public JsonData update(User user);

    public JsonData selectList(User user);

    public JsonData addPhoneCode(User user);

    public JsonData registerPhone(User user);
}
