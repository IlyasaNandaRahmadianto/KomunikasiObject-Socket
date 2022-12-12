package komunikasi.object.socket.server;

import komunikasi.object.socket.client.PegawaiEx;
import java.io.*;
import java.net.*;

public class KomunikasiObjectSocketServer {
    public static void main(String[] args) {
        ServerSocket ser = null;
        Socket soc = null;
        Object pegawaiInput = null;
        try {
            ser = new ServerSocket(07316);
            System.out.println("Berhasil terhubung pada Port Server 07316");
            soc = ser.accept();
            
            ObjectInput ois = new ObjectInputStream(soc.getInputStream());
            ObjectOutput ous = new ObjectOutputStream(soc.getOutputStream());
            
            pegawaiInput = (PegawaiEx) ois.readObject();
            
            System.out.println("Hasil Kiriman dari Client");
            System.out.println(pegawaiInput);
            
            String res = new String("Data Pegawai Telah Diterima");
            ous.writeObject(res);
            ous.flush();
            
            ous.close();
            ois.close();
        } catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}
