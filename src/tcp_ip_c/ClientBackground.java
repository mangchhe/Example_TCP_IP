package tcp_ip_c;

import java.net.Socket;
import java.io.IOException;

public class ClientBackground {
    
    Socket socket;
    
    public void connect(){
        
        try{
            
            socket = new Socket("192.168.0.7",7777);
            System.out.println("접속에 성공하였습니다.");
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connect();
    }
    
}
