import static spark.Spark.*;

public class UserApiRestFul {

    public static void main(String[] args) {

        final IUserService serviceU = new UserServiceMapImpl();
        port(8083);



        post("/users",(req,res)->{

            res.type("application/json");
            //User user = new Gson().fromJson(req.body(),User.class);
            String token = serviceU.loginUser(req.headers("username"),req.headers("password"));
            return token; //tenemos que devolverlo en un formato json

        });



        get("/sites",(req,res)->{
            res.type("application/json"); //esto es para que me lo devuelva en formato json

            if(serviceU.existToken(req.headers("token"))){

                ConnectionApiSite conex = new ConnectionApiSite();
                String sites = conex.getSites();
                if (sites!= null)
                {
                    return sites; //conex.getSites() me devuelve algo de tipo Json
                }
                else
                {
                    return "No existe site"; //conex.getSites() me devuelve algo de tipo Json

                }

            }else{
               return "NO EXISTE EL TOKEN"; //agregar despues como devolver los errores..Ponerse de acuerdo con los chicos
            }

        });



        get("/sites/:id/categories",(req,res)->{
            res.type("application/json"); //esto es para que me lo devuelva en formato json

            if(serviceU.existToken(req.headers("token"))){

                ConnectionApiSite conex = new ConnectionApiSite();

                return conex.getCategories(req.params(":id")); //conex.getCategories() me devuelve algo de tipo String

            }else{
                return "NO EXISTE EL TOKEN";
            }

        });




    }



}
