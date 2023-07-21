package mini.aspire.services;

import mini.aspire.data.UserDao;
import mini.aspire.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public User getUserById(int id) throws Exception {
        return userDao.getUserById(id);
    }

    public int addUser(String name) throws Exception {
        return userDao.addUser(name);
    }
}
