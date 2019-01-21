import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

public interface ServerDate extends Remote {
    Date getDate() throws RemoteException;
}
