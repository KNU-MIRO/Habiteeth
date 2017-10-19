package habiteeth.seeds;

import habiteeth.models.User;
import java.util.Objects;

public class UserSeed {

    // TODO: you can custom user list
    private User[] userList = new User[] {
        new User(12345, "Alen", "54330098"),
        new User(434, "David", "54377754"),
        new User(6678, "Olla", "54333445"),
        new User(225, "Jenkins", "54322334"),
        new User(14400, "DongYoung", "55454543"),
        new User(8888, "Geektree0101", "50000308")};

    public User findUser(int id) {
        for (User user: this.userList) {
            if (user.userId == id) {
                return user;
            }
        }

        return null;
    }

    public User findOwner(int id, String uuid) {
        for (User user: this.userList) {
            if ((user.userId == id) & (user.deviceUUID.compareTo(uuid) == 0)) {
                return user;
            }
        }

        return null;
    }

    public User[] getUserList() {
        return this.userList;
    }
}