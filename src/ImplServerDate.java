import java.util.Date;

public class ImplServerDate implements ServerDate{
    @Override
    public Date getDate() {
        return new Date();
    }
}
