import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Calendar;
import java.util.Date;

public class Client {

    private Client(){}

    public static void main(String[] args) {
        try{
            // The HOSTIP must be changed, the port may need to be changed if in use on the server/client
            Registry registry = LocateRegistry.getRegistry("HOSTIP",1099);
            Date time = new Date();
            long before_server_call = time.getTime();
            ServerDate stub = (ServerDate) registry.lookup("CurrentDate");
            time = new Date();
            long after_server_call = time.getTime();
            Date syn_server_time = stub.getDate();
            long syn_client_time = syn_server_time.getTime() + ((after_server_call - before_server_call) / 2);
            Date syn_time = new Date(syn_client_time);
            // Synchronize the time in client based on remote server
            System.out.println(syn_time.toString());
        } catch(Exception e){
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
