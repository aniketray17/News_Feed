/**
 * SocialNetwork
 */
import java.util.HashMap;
import java.util.Map;

class User {
    private String userId;
    private String username;
    private String password;
    public User(String userId,String username,String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
    }
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class SocialNetwork {
    private Map<String, User> users;
    
    public SocialNetwork() {
        users = new HashMap<>();
    }

    public void signUp(String userId, String username, String password) {
        if(!users.containsKey(userId)) {
            User newUser = new User(userId,username,password);
            users.put(userId,newUser);
            System.out.println("User signed up successfully !");
        }
        else {
            System.out.println("User Id already exists. Please choose a different ID.");
        }
    }

    public User login(String userId, String password) {
        User user = users.get(userId);
        if(user != null && user.getPassword().equals(password)) {
            System.out.println("User logged in successfully!");
            return user;
        }
        else {
            System.out.println("Invalid login credentials. Please try again.");
            return null;
        }
    }

    public static void main(String[] args) {
        
    }
}
