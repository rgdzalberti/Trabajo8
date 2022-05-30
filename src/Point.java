import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Point implements Serializable {
    private static final long serialVersionUID = 1L;

    //Con esto se declara una clave automáticamente
    @Id @GeneratedValue long id;

    private int x;
    private int y;

    public Point(){
        super();
    }

    public Point (int x, int y) {
        super();
        this.x = x;
        this.y = y;
    }

    public Long getId(){
        return id;
    }

    public void setX(int x){
        this.x = x;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)", this.x, this.y);
    }


}