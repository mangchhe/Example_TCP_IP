package tcp_ip_s;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.Scanner;

public class ServerBackground {
    
    ServerSocket serverSocket;
    Socket socket;
    DataInputStream in;
    DataOutputStream out;
    Scanner sc = new Scanner(System.in);
    String msg;
    
    public void setting(){
        try{
            
            serverSocket = new ServerSocket(7777);
            System.out.println("접속 대기중");
            socket=serverSocket.accept();
            System.out.println(socket.getInetAddress()+"님께서 접속하셨습니다.");
        
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            abc a=new abc(socket);
            a.start();
        
            while(in!=null){
                System.out.println("고객님 말씀 : "+in.readUTF());
            //    out.writeUTF(sc.nextLine());
            }
        
        
        }catch(IOException e){
            System.out.println(socket.getInetAddress()+"님께서 퇴장하셨습니다.");
        }
    }
    
    public static void main(String[] args){
        
        ServerBackground serverBackground = new ServerBackground();
        serverBackground.setting();
        
    }
    
    class abc extends Thread{
        
       // DataInputStream in;
        //DataOutputStream out;
       // Socket socket;
        
        public abc(Socket socket){
            try{
                in = new DataInputStream(socket.getInputStream());
                //out = new DataOutputStream(socket.getOutputStream());
            }catch(IOException e){
                e.printStackTrace();
            }
        }
        
        public void run(){
            while(out!=null){
                try{
                    out.writeUTF(sc.nextLine());
                }catch(Exception e){
                    e.printStackTrace();
                }
            }    
        }
    }
    
}
