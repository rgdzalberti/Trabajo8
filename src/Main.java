import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class Main{

    public static void main(String[] args){

        //SE ABRE LA CONEXION A LA BASE DE DATOS
        //Y SE CREA UNA NUEVA EN CASO DE QUE NO EXISTA
        EntityManagerFactory EMF =
                Persistence.createEntityManagerFactory("$objectdb/db/points.odb");
        EntityManager EM = EMF.createEntityManager();

        //SE ALMACENAN 100 OBJETOS EN LA BASE DE DATOS
        EM.getTransaction().begin();
        for (int i = 0; i < 100; i++){
            Point p = new Point(i,i);
            EM.persist(p);
        }
        EM.getTransaction().commit();

        //Recuperar Objeto
        //Le digo donde buscarlo y su clave primaria, en este caso el 1
        EM.getTransaction().begin();
        Point p = EM.find(Point.class, 1);
        EM.getTransaction().commit();

        //Actualizar Objeto
        //Una vez recuperado de la BBD, podemos modificarlo en memoria
        EM.getTransaction().begin();
        p.x = p.x + 1;
        //p.setNickname("New nickname");
        EM.getTransaction().commit();

        //Eliminar Objeto
        EM.getTransaction().begin();
        EM.remove(p);
        EM.getTransaction().commit();


        //Cerramos la conexión a la BBDD
        EM.close();
        EMF.close();

    }

}
