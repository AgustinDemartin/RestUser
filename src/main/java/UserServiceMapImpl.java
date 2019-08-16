import java.util.HashMap;
import java.util.Map;


public class UserServiceMapImpl implements IUserService {

    private Map<String, User> userMap; //creo un objeto map que tiene como key  el username del usuario..osea que tendria <username1,User1>, <username2,User2>




    public UserServiceMapImpl(){

        userMap = new HashMap<String, User>();
        userMap.put("pedro", new User("pedro", "123"));
    }


    public String loginUser(String username,String password){
        String token;
        int n=30;
        int numberRandom=(int)(Math.random() * n) + 1;
        token = Integer.toString(numberRandom);
        boolean flag;

        /////////
        //User user= new User(username,password);

        //userMap.containsValue(); //aca qiero buscar el token del usuario y contraseña que me vienen por parametro

        //userMap.put(token,user);//inserto el usuario con un token en el hashMap

        flag = userMap.containsKey(username);

        if(flag){
            //userMap.replace(username,userMap.get(username).setToken(token));
            userMap.get(username).setToken(token);
             //user.setToken(token);
            return token;   //retorno el token
        }
        else{
            return "error";
        }



    }

    public boolean existToken(String token){
        for(String aux:userMap.keySet()){

            if (userMap.get(aux).getToken().equals(token)){
                return true;}

        }
        return false;

    }




}
