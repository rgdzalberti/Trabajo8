import javax.persistence.*;
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
        for (int i = 1; i < 100; i++){
            Point p = new Point(i,i);
            EM.persist(p);
        }
        EM.getTransaction().commit();

        //Recuperar Objeto
        //Le digo donde buscarlo y su clave identificatoria, en este caso el 1
        EM.getTransaction().begin();
        Point p = EM.find(Point.class, 1);


        //Actualizar Objeto
        //Una vez recuperado de la BBD, podemos modificarlo en memoria, en este caso lo haré de manera implicita como los demás ejemplos
        System.out.print("Valor p antes de actualizarlo");
        System.out.print(p);
        p.setX(50);
        System.out.print("Valor p después de actualizarlo");
        System.out.print(p);


        //Eliminar Objeto
        //Elimino el objeto en memoria, es decir el que he recuperado
        EM.remove(p);
        EM.getTransaction().commit();


        //Cerramos la conexión a la BBDD
        EM.close();
        EMF.close();

    }

}
