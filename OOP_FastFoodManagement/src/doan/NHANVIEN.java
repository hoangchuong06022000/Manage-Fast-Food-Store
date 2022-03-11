
package doan;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class NHANVIEN extends NGUOI {
    Scanner nv=new Scanner(System.in);
    String manv;
    private int chucvu;
    KiemTra kt1=new KiemTra();
    public NHANVIEN() {
        
    }

    public NHANVIEN(String manv, int chucvu, String hoten, int ngaysinh, int gioitinh, String diachi,String email,String sdt, String socmnd) {
        super(hoten, ngaysinh, gioitinh, diachi,email, sdt, socmnd);
        this.manv = manv;
        this.chucvu = chucvu;
    }

    public Scanner getNv() {
        return nv;
    }

    public void setNv(Scanner nv) {
        this.nv = nv;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv){
        this.manv=manv;
    }

    public int getChucvu() {
        return chucvu;
    }

    public void setChucvu(int chucvu) {
        this.chucvu=chucvu;
    }
    @Override
    public void nhap(){
        System.out.println("Nhap vao ma nhan vien( VD:nv___(sau nv la 3 ki tu so)):");
        manv=kt1.KTManv();
        System.out.println("Chon chuc vu nhan vien");
        System.out.println("1.Ban hang       2.Thu ngan");
        chucvu=kt1.KTChon(chucvu,2);
        super.nhap();
    }
    @Override
    public void xuat(){
        System.out.printf("%-15s%-40s%-20s%02d-%02d-%04d          %-20s%-20s%-20s%-40s%-30s",manv,hoten,kt1.KTChucvu(chucvu),ntns.ngay,ntns.thang,ntns.nam,kt1.KTGioitinh(gioitinh),socmnd,sdt,diachi,email);
    }

    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeUTF(manv);
            out.writeUTF(hoten);
            out.writeInt(chucvu);
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