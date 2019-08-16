import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class ConnectionApiSite {



    public String getSites() {

        try {
            URL url=new URL("http://localhost:8082/sites");
            try {
                URLConnection urlConnection=url.openConnection();
                ///////vamos a poner algunas cuestiones para que no se rompa cuando tenga acentos y esas cosas el archivo
                urlConnection.setRequestProperty("Accept","aplication/json");//esto es para que me lo devuelva como obj JSON
                urlConnection.setRequestProperty("User-Agent","Mozilla/5.0");//para los acentos

                    //es obligatorio hacer el cast porque urlConnection puede ser una http urlConnection o un jar..entonces tengo que castearlo
                    //puedo llegar a tener problemas con el casteo..entonces por eso hago el if(1)

                    HttpURLConnection connection = (HttpURLConnection) urlConnection;

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String sites = readAll(in);

                    return sites;


            } catch (IOException exception) {//capta el error de que la coneccion no se pudo hacer
                System.out.println(exception.getMessage() + " hola");
            }

        } catch (MalformedURLException exception) {//capta el error de que la url no este bien formada
            System.out.println(exception.getMessage() + " chau");//con esto me dice unknown protocol htt si borro la ps de la url
        }

        return ""; //me pedia si o si un return
    }


    public String getCategories(String id) {

        try {
            URL url=new URL("http://localhost:8082/sites/"+id+"/categories");
            try {
                URLConnection urlConnection=url.openConnection();
                ///////vamos a poner algunas cuestiones para que no se rompa cuando tenga acentos y esas cosas el archivo
                urlConnection.setRequestProperty("Accept","aplication/json");//esto es para que me lo devuelva como obj JSON
                urlConnection.setRequestProperty("User-Agent","Mozilla/5.0");//para los acentos

                    //es obligatorio hacer el cast porque urlConnection puede ser una http urlConnection o un jar..entonces tengo que castearlo
                    //puedo llegar a tener problemas con el casteo..entonces por eso hago el if(1)

                    HttpURLConnection connection = (HttpURLConnection) urlConnection;

                    BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                    String categories = readAll(in);

                System.out.println("Clase API Site");
                System.out.println(categories);


                    return categories;

            } catch (IOException exception) {//capta el error de que la coneccion no se pudo hacer
                System.out.println(exception.getMessage());
            }

        } catch (MalformedURLException exception) {//capta el error de que la url no este bien formada
            System.out.println(exception.getMessage());//con esto me dice unknown protocol htt si borro la ps de la url
        }

        return "";  //me pedia si o si un return
    }


    public static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {

            sb.append((char) cp);
        }

        String s = sb.toString().replace("\\"," ");
        return s;
    }


}
