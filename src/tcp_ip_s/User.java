package tcp_ip_s;

import java.util.HashMap;
import java.io.DataOutputStream;
import java.util.Collections;
import java.net.Socket;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class User extends Thread {
    
    String echoMsg;
    String nickName;
    Scanner sc = new Scanner(System.in);
    HashMap<String, DataOutputStream> user = new HashMap<String, DataOutputStream>();
    
    public User(){
        Collections.synchronizedMap(user);
    }
    
    public void AddClient(String nickName,Socket socket){
        try{
            user.put(nickName,new DataOutputStream(socket.getOutputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void RemoveClient(String nickName){
        user.remove(nickName);
    }
    
    public void run(){
        while(true){
        echoMsg=sc.nextLine();
        Iterator it=user.keySet().iterator();
        while(it.hasNext()){
            nickName=(String)it.next();
            try {
                user.get(nickName).writeUTF("서버 : " + echoMsg);
            } catch (IOException e) {
                e.printStackTrace();
            }            
        }
        }
    }
}
