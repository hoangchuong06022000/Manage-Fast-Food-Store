
package doan;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class KHACHHANG extends NGUOI{
    Scanner kh=new Scanner(System.in);
    String makh;
    private int loaikh;
    KiemTra kt2=new KiemTra();
    public KHACHHANG() {
        
    }

    public KHACHHANG(String makh, int loaikh, String hoten, int ngaysinh, int gioitinh, String diachi, String email, String sdt, String socmnd) {
        super(hoten, ngaysinh, gioitinh, diachi, email, sdt, socmnd);
        this.makh = makh;
        this.loaikh = loaikh;
    }
    public String getMakh() {
        return makh;
    }
    public void setMakh(String makh) {
        this.makh=makh;
    }
    public int getLoaikh() {
        return loaikh;
    }
    public void setLoaikh(int loaikh) {
        this.loaikh=loaikh;
    }
    @Override
    public void nhap(){
        System.out.println("Nhap vao ma khach hang( VD:kh___(sau kh la 3 ki tu so)):");
        makh=kt2.KTMakh();
        System.out.println("Chon loai khach hang");
        System.out.println("1.VIP   2.THUONG");
        loaikh=kt2.KTChon(loaikh,2);
        super.nhap();
    }
    @Override
     public void xuat(){
        System.out.printf("%-15s%-40s%-20s%02d-%02d-%04d          %-20s%-20s%-20s%-40s%-30s",makh,hoten,kt2.KTLoaikh(loaikh),ntns.ngay,ntns.thang,ntns.nam,kt2.KTGioitinh(gioitinh),socmnd,sdt,diachi,email);
    }
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeUTF(makh);
            out.writeUTF(hoten);
            out.writeInt(loaikh);
            out.writeInt(ntns.ngay);
            out.writeInt(ntns.thang);
            out.writeInt(ntns.nam);
            out.writeInt(gioitinh);
            out.writeUTF(socmnd);
            out.writeUTF(sdt);
            out.writeUTF(diachi);
            out.writeUTF(email);
	}catch(IOException e) {}
    }  

}
