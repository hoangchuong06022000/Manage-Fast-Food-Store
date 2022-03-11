
package doan;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class NHACC{
    Scanner ncc=new Scanner(System.in);
    String mancc,tenncc,sdt,diachi,email;
    KiemTra kt5=new KiemTra();
    public NHACC() {    
    }

    public NHACC(String mancc, String tenncc, String sdt, String diachi, String email) {
        this.mancc = mancc;
        this.tenncc = tenncc;
        this.sdt = sdt;
        this.diachi = diachi;
        this.email = email;
    }
     public String getTenncc() {
        return tenncc;
    }

    public void setTenncc(String tenncc) {
        this.tenncc = tenncc;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getMancc() {
        return mancc;
    }
    
    public void setMancc(String mancc) {
        this.mancc=mancc;
    }
    
    public void nhap(){
        System.out.println("Nhap ma nha cung cap(VD:ncc___(sau ncc la 3 ki tu so)):");
        mancc=kt5.KTMancc();
        System.out.println("Nhap ten nha cung cap(tu 10-40 ki tu(khong co ki tu la so)):");
        tenncc=kt5.KTTen();
        System.out.println("Nhap dia chi:");
        diachi=ncc.nextLine();
        System.out.println("Nhap dia chi email(VD:_____@gmail.com):");
        email=kt5.KTEmail();
        System.out.println("Nhap so dien thoai(10 so):");
        sdt=kt5.KTSdt();
    }
    public void xuat(){
        System.out.printf("%-20s%-40s%-20s%-40s%-30s",mancc,tenncc,sdt,diachi,email);
    }
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeUTF(mancc);
            out.writeUTF(tenncc);
            out.writeUTF(sdt);
            out.writeUTF(diachi);
            out.writeUTF(email);
	}catch(IOException e) {}
    }  
}
