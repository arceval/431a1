import java.util.Date;

public class ImplServerDate implements ServerDate{
    @Override
    public Date getDate() {
        Date now = new Date();
        System.out.println(now);
        return now;
    }
}
