/**
 * SocialNetwork
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class User {
    //this is for userId
    private String userId;

    //store the username
    private String username;

    //storing the password
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
        SocialNetwork socialNetwork = new SocialNetwork();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Enter the command(signup/login/exit):");
            String command = scanner.next();
            if(command.equals("signup")) {
                System.out.println("Enter User ID:");
                String userId = scanner.next();
                System.out.println("Enter Username:");
                String username = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();
                socialNetwork.signUp(userId, username, password);
            } else if(command.equals("login")) {
                System.out.println("Enter User ID:");
                String userId = scanner.next();
                System.out.println("Enter password:");
                String password = scanner.next();
                socialNetwork.login(userId, password);
            } else if(command.equals("exit")) {
                System.out.println("Exiting Program...");
                break;
            } else {
                System.out.println("Invalid command. Please try again.");
            }
        }
        scanner.close();
    }
}
