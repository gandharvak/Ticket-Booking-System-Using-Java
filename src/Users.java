import java.util.ArrayList;

public class Users {
    public ArrayList<User> users;
    public Users() {
        this.users = new ArrayList<>();
    }

    public void addUser(User u){
        users.add(u);
    }
    public int getUser(String email, String password, String role){
        for (int i=0; i<users.size();i++) {
            User user = users.get(i);
            if (user.getEmail().equals(email) && user.getRole().equals(role)) {
                if (user.getPassword().equals(password)) {
                    return i;
                } else {
                    return 404;
                }
            }
        }
        return 400;
    }

    public void getAllUsers(){
        for (User user : users) {
            if(user.getRole().equals("admin"))
                continue;
            System.out.println("Name: "+ user.getName()+ " Email: "+ user.getEmail()+ " Phone: "+ user.getPhone());
        }
    }
    public void getAllAdmin(){
        for (User user : users) {
            if(user.getRole().equals("user"))
                continue;
            System.out.println("Name: "+ user.getName()+ " Email: "+ user.getEmail()+ " Phone: "+ user.getPhone());
        }
    }


}
