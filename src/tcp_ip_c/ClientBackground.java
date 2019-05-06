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
    Receiver receiver = new Receiver();
    
    public void connect(){
        
        try{
            
            socket = new Socket("192.168.0.7",7777);
            System.out.println("접속에 성공하였습니다.");
            
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            
            System.out.println("닉네임 입력해주세요");
            out.writeUTF(sc.nextLine());
            
            receiver.start();
            
            while(out!=null){
                out.writeUTF(sc.nextLine());
            }
        
            
        }catch(IOException e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args){
        
        ClientBackground clientBackground = new ClientBackground();
        clientBackground.connect();
    }
    
    class Receiver extends Thread{
    	public void run() {
    		while(true) {
    			try {
    				System.out.println(in.readUTF());
    			}catch(IOException e) {
    				System.out.println("서버와의 연결이 끊겼습니다.");
    				break;
    			}
    		}
    	}
    }
}