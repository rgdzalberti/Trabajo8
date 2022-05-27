import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Point implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue
    private long id;

    protected int x;
    private int y;

    public Point(){}

    Point (int x, int y) {
        this.x = x;
        this.y = y;
    }


}