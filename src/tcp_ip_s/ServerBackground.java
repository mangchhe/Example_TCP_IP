package tcp_ip_s;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;


public class ServerBackground {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private Scanner sc = new Scanner(System.in);
    
    public void setting(){
        try{
            serverSocket = new ServerSocket(7777);
            while(true){
                System.out.println("접속 대기중");
                socket=serverSocket.accept();
                System.out.println(socket.getInetAddress()+"님께서 접속하셨습니다.");
                Access a=new Access(socket);
                a.start();
            }        
        
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
        
    }
    
    class Access extends Thread{

    private DataInputStream in;
    private DataOutputStream out;
    private String nickName;
    
        public Access(Socket socket){
            try{
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());           
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public void run(){
            try {                
                nickName=in.readUTF();
                while(true){            
                    System.out.println(nickName + " : " + in.readUTF());
                }
            } catch (IOException e) {
                System.out.println(nickName+"님께서 퇴장하셨습니다.");
            }
        }
    }
}
