package komunikasi.object.socket.client;

import java.io.*;

public class PegawaiEx implements Externalizable {
    private String nama;
    private int umur;
    private String jabatan;
    private int gaji;
    
    //defaultcons->inisialisasi variabel default
    public PegawaiEx() {

    } 
    
    public PegawaiEx(String nama, int umur,String jabatan, int gaji) {
        this.nama = nama;
        this.umur = umur;
        this.jabatan = jabatan;
        this.gaji = gaji;
    } 
    
    public void writeExternal(ObjectOutput objout) throws IOException {
        objout.writeObject("Nama\t: " + this.nama);
        objout.writeInt(this.umur);
        objout.writeObject("Jabatan\t: " + this.jabatan);
        objout.writeInt(this.gaji);
    } 
    
    //classnotfoundexception untuk mengatasi file tidak ditemukan
    public void readExternal(ObjectInput objin) throws IOException, ClassNotFoundException {
        this.nama = (String) objin.readObject();
        this.umur = objin.readInt();
        this.jabatan = (String) objin.readObject();
        this.gaji = objin.readInt();
    } 
    
    //tostring = mengembalikan objek string
    public String toString()

    {

    return "Data Pegawai " + "\n" + this.nama + "\n" + "Umur\t: " + this.umur + "\n"+ this.jabatan + "\n" + "Gaji\t: Rp. " + this.gaji;
    } 
 
 } 