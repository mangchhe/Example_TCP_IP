package tcp_ip_c;

import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class ClientBackground {
    
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Scanner sc = new Scanner(System.in);
    String msg;
    
    public void connect(){
        
        try{
            
            socket = new Socket("192.168.0.7",7777);
            System.out.println("접속에 성공하였습니다.");
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            while(out!=null){
                System.out.println("서버님에 말씀 : "+in.readUTF());
                //out.writeUTF(sc.nextLine());
            }
        
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connect();
    }
    
}
