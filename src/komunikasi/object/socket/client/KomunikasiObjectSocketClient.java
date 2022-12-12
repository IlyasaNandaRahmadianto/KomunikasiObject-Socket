package komunikasi.object.socket.client;

import java.io.*;
import java.net.*;
public class KomunikasiObjectSocketClient {
    public static void main(String[] args) {
        Socket soc = null;
        PegawaiEx pegawaiInput = null;
        
        try{
            soc = new Socket("localhost", 07316);
            
            ObjectOutput ous = new ObjectOutputStream(soc.getOutputStream());
            ObjectInput ois = new ObjectInputStream(soc.getInputStream());
            
            pegawaiInput = new PegawaiEx("Ilyasa Nanda Rahmadianto", 20, "Manager", 150000000);
            
            ous.writeObject(pegawaiInput);
            ous.flush();
            
            String s = (String) ois.readObject();
            System.out.println(s);
            
            ous.close();
            ois.close();
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
    
}
