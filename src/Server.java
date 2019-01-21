import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplServerDate{

    public Server(){}

    public static void main(String[] args) {
        try{
            int port = 1099;
            System.setProperty("java.rmi.server.hostname","HOSTIP");
            ImplServerDate obj = new ImplServerDate();
            Registry registry = LocateRegistry.createRegistry(port);
            ServerDate stub = (ServerDate) UnicastRemoteObject.exportObject(obj, port);

            registry.bind("CurrentDate", stub);
            System.err.println("Server Ready");
        } catch(Exception e){
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
