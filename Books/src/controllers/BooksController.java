package controllers;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.http.*;

public class BooksController extends HttpServlet {
    //DoPost y doGet se pone codigo para las peticiones hechas por navegador
    //Get admite muy pocos datos
    //es como un colador tanto para post como para get

    private static final String [] descriptions = {
      "La catedral del mar es la primera novela del abogado y escritor español Ildefonso Falcones. Fue escrita originalmente en castellano durante cuatro años consecutivos y publicada en 2006. Narra la vida de la Barcelona del siglo XIV, la historia tiene como nexo de unión la construcción de la iglesia de Santa María del Mar.","Elvira Sastre revela en este libro su mundo interior y sus experiencias más íntimas. El diálogo que se establece entre el texto y las ilustraciones de Emba logra una composición estética única, digna de coleccionistas.","En esta asombrosa novela negra, divertida, tierna y sobrecogedora de principio a fin, Arturo Pérez-Reverte narra con increíble maestría la aventura de un perro en un mundo diferente al de los humanos...","Macarena, Jimena y Adriana están a un paso de descubrir que preoucuparse de lo que los demás opinan puede malograr cualquier sueño.Fuimos canciones es la novela de tres amigas con una historia impactante que provocará la carcajada en las lectoras, tres historias distintas, originales al más puro estilo Benavent."
    };
    protected void service(HttpServletRequest request,HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    //le llega un param desde el navegador, el request y response es el propio server que les da valor a estas variables
        //pillamos params del navegador, le tenemos que decir como se llama ese mismo
        String paramFromBrowser = request.getParameter("identificadorLibro");
        //int para llegar al array de descripciones
        int indxDesc = Integer.parseInt(paramFromBrowser);
        //para obtener la descripcion
        //tenemos la descrip para enviar al navegador
        String description = descriptions[indxDesc];

        //ahora toca enviar la respuesta
        //formato de la respuesta
        response.setContentType("text/plain");
        //hacemos u try with results por si se generan excepciones al intentarlo
        try(Writer wr = response.getWriter()){
            wr.write(description);
        }
    }
}
