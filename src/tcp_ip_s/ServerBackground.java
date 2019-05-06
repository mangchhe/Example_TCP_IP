package tcp_ip_s;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

public class ServerBackground {
    
    ServerSocket serverSocket;
    Socket socket;
    
    public void setting(){
        try{
            
        serverSocket = new ServerSocket(7777);
        System.out.println("접속 대기중");
        socket=serverSocket.accept();
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
        
    }
    
}
