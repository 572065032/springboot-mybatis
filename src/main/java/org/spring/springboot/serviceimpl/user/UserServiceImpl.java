package org.spring.springboot.serviceimpl.user;

import com.buchou.domain.user.User;
import com.buchou.domain.web.JsonData;
import com.buchou.service.user.UserService;
import org.spring.springboot.dao.user.UserDao;
import org.spring.springboot.domain.Information;
import org.spring.springboot.util.jedisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    @Autowired
    public JedisPool jedisPool;//非切片连接池


    @Override
    public JsonData insert(User user) {
        JsonData json=new JsonData();
        try {
            User u=new User(user.getUsername(),user.getPassword());
            List<User> list=userDao.selectList(u);
            String code="0";
            if(list.size()>0){
                code="2001";
            }else{
                userDao.insert(u);
                if(u.getId()!=null){
                    json.setSuccess(true);
                }else{
                    code="802";
                }
            }
            json.setCode(code);
            json.setMsg(Information.getInstance().getErrorInfo(code));
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setCode(e.getMessage());
            json.setMsg(Information.getInstance().getErrorInfo(e.getMessage()));
        }
          return json;
    }

    @Override
    public JsonData update(User user) {
        JsonData json=new JsonData();
        try {
            User u=new User(user.getUsername(),user.getPassword());
           int num= userDao.update(u);
            String code="0";
            if(num>0){
                json.setSuccess(true);
            }else{
                code="1";
            }
            json.setCode(code);
            json.setMsg(Information.getInstance().getErrorInfo(code));
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setCode(e.getMessage());
            json.setMsg(Information.getInstance().getErrorInfo(e.getMessage()));
        }
        return json;
    }

    @Override
    public JsonData selectList(User user) {
        JsonData json=new JsonData();
        try {
            User u=new User(user.getUsername(),user.getPassword());
            List<User> list=userDao.selectList(u);
            String code="0";
            if(list.size()>0){
                json.setSuccess(true);
            }else{
                code="1003";
            }
            json.setCode(code);
            json.setMsg(Information.getInstance().getErrorInfo(code));
        } catch (Exception e) {
            e.printStackTrace();
            json.setSuccess(false);
            json.setCode(e.getMessage());
            json.setMsg(Information.getInstance().getErrorInfo(e.getMessage()));
        }
        return json;
    }

    @Override
    public JsonData addPhoneCode(User user) {
        JsonData json =new JsonData();
        Jedis j= jedisTest.getInstance().jedisPool.getResource();
        j.set("user:code:"+user.getPhone(),"159357");
        json.setMsg("159357");
        System.out.println(j.get("user:code:"+user.getPhone()));
        j.close();
        return json;
    }

    // redis可以通过两种方式获取
    // 1.单例模式   2.直接注入
    @Override
    public JsonData registerPhone(User user) {
        JsonData json =new JsonData();
        String message="";
        Jedis j= this.jedisPool.getResource();
        System.out.println(j.get("user:code:"+user.getPhone()));
        if(user.getCode().equals(j.get("user:code:"+user.getPhone())+"")){
            message="注册成功！";
        }else{
            message="验证码输入错误！";
        }
            j.close();
        json.setMsg(message);
        return json;
    }
}
