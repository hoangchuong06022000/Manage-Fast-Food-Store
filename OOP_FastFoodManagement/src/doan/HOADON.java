
package doan;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class HOADON {
    Scanner hd= new Scanner(System.in);
    protected static int ma1=1;
    protected int mahd;
    protected double TongTien=0;
    public String t,t1,t2;
    KiemTra kt=new KiemTra();
    public HOADON() {
        this.mahd=ma1++;
    }

    public HOADON(int mahd, double TongTien) {
        this.mahd = mahd;
        this.TongTien = TongTien;
    }

    
    public int getMahd() {
        return mahd;
    }

    public void setMahd(int mahd) {
        this.mahd = mahd;
    } 
    public double getTongTien() {
        return TongTien;
    }

    
    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public void nhapHD() throws Exception {
        System.out.println("Nhap ma nhan vien(VD:nv___(sau nv la 3 ki tu so)):");
        MangNV nv=new MangNV();
        nv.docFile("src/nhanvien.txt");
        while(true){
            try{
                t=kt.KTManv();
                int vt=nv.TimKiemMa(t);
                if(vt!=-1){
                    break;
                }
            }catch(NullPointerException e){
                System.out.println("Nhan vien khong ton tai!! Nhap lai");
            }
        }
            
    }

    public void xuatHD(){
        System.out.println("Ma hoa don: "+mahd);
        System.out.println("Ma nhan vien: "+t);
        System.out.println("Ma khach hang:"+t1);
        System.out.println("Tong tien: "+TongTien);
    }
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeInt(mahd);
            out.writeUTF(t);
            out.writeUTF(t1);
            out.writeUTF(t2);
            out.writeDouble(TongTien);
	}catch(IOException e) {}
    }  
}
