
package doan;
import java.util.Scanner;
abstract public class NGUOI {
    protected String hoten;
    protected int ngaysinh;
    protected int gioitinh;
    protected String diachi;
    protected String email;
    protected String sdt;
    protected String socmnd;
    Scanner cn=new Scanner(System.in);
    NgayThangNam ntns=new NgayThangNam();
    KiemTra kt=new KiemTra();
    public NGUOI() {
    }

    public NGUOI(String hoten,int ngaysinh, int gioitinh, String diachi,String email, String sdt,String socmnd) {
        this.hoten = hoten;
        this.ngaysinh = ngaysinh;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.email=email;
        this.sdt = sdt;
        this.socmnd=socmnd;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten=hoten;
    }

    public int getNgaysinh() {
        return ngaysinh;
    }

    public void setNgaysinh(int ngay,int thang,int nam) {
        ntns.setNgay(ngay);
        ntns.setThang(thang);
        ntns.setNam(nam);
    }

    public int getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(int gioitinh) {
        this.gioitinh=gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }
    
    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt=sdt;
    }
    public String getSocmnd() {
        return socmnd;
    }

    public void setSocmnd(String socmnd) {
        this.socmnd=socmnd;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email=email;
    }
    public void nhap(){
        System.out.println("Nhap ho ten(tu 10-40 ki tu(khong co ki tu la so)):");
        hoten=kt.KTTen();
        System.out.println("Nhap ngay sinh:");
        ntns.nhap();
        System.out.println("Chon gioi tinh");
        System.out.println("1.Nam       2.Nu");
        gioitinh=kt.KTChon(gioitinh,2);
        System.out.println("Nhap dia chi:");
        diachi=cn.nextLine();
        System.out.println("Nhap dia chi email(VD:_____@gmail.com):");
        email=kt.KTEmail();
        System.out.println("Nhap so dien thoai(10 so):");
        sdt=kt.KTSdt();
        System.out.println("Nhap so chung minh nhan dan(9 so):");
        socmnd=kt.KTSocmnd();
    }
    abstract public void xuat();
}
