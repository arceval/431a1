import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends ImplServerDate{

    public Server(){}

    public static void main(String[] args) {
        try{
            // The HOSTIP must be changed to the ip of the server, the port may need to be changed if in use
            int port = 1099;
            System.setProperty("java.rmi.server.hostname","HOSTIP"); // Some setup to allow the registry to work

            ImplServerDate obj = new ImplServerDate();
            Registry registry = LocateRegistry.createRegistry(port); // Creates the RMI registry

            ServerDate stub = (ServerDate) UnicastRemoteObject.exportObject(obj, port);
            registry.bind("CurrentDate", stub); // Makes ServerDate available on RMI from a remote client
            System.err.println("Server Ready");
        } catch(Exception e){
            System.err.println("Server exception: " + e.toString()); // Handle errors
            e.printStackTrace();
        }
    }
}
