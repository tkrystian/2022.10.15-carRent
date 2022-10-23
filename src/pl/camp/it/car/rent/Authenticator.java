package pl.camp.it.car.rent;

import org.apache.commons.codec.digest.DigestUtils;
import pl.camp.it.car.rent.database.UserDB;
import pl.camp.it.car.rent.gui.GUI;
import pl.camp.it.car.rent.model.User;

public class Authenticator {
    public static final String seed = "1Tl8*G3Ertpxvj0%8qpy";
    public static User loggedUser;

    public static boolean authenticate(UserDB userDB) {
        
        for(int i = 0; i < 3; i++) {
            User user = GUI.readLoginAndPassword();
            User userFromDB = userDB.findUserByLogin(user.getLogin());
            if(userFromDB != null &&
                    userFromDB.equals(user)) {
                Authenticator.loggedUser = userFromDB;
                return true;
            }
        }
        return false;
    }
}
