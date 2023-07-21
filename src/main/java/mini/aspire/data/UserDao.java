package mini.aspire.data;

import mini.aspire.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    private int incrementalId = 1;
    private final List<User> users;

    public UserDao(List<User> users) {
        this.users = users;
    }

    public User getUserById(int id) throws Exception {
        Optional<User> user = users.stream().filter(it -> it.getId() == id).findFirst();
        if (user.isEmpty()) throw new Exception("user: $id does not exist");
        return user.get();
    }

    public int addUser(String name) throws Exception {
        User user = new User(incrementalId++, name);
        users.add(user);
        return user.getId();
    }
}
