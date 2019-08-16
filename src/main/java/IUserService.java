public interface IUserService {


    //public int addUser(User user) throws ApiException;

    public String loginUser(String username, String passwoprd); //(String username,String password);//cuando el usuario se logea le genero un token..por eso devuelvo String

    public boolean existToken(String token);

}
