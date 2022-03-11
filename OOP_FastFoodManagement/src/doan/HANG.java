package doan;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class HANG {
    String Ma;
    String Ten;
    private String NgayNhap;
    int SoLuong;
    double Gia;
    KiemTra nsl=new KiemTra();
    Scanner ha = new Scanner(System.in);
    NgayThangNam nn=new NgayThangNam();
    public HANG()
    {
	Ma = null;
	Ten = null;
	NgayNhap = null;
	SoLuong = 0;
        Gia=0;
    }
    public HANG(String Ma, String Ten, String NgayNhap, int SoLuong,double Gia)
    {
      	this.Ma = Ma;
	this.Ten = Ten;
	this.NgayNhap = NgayNhap;
	this.SoLuong  = SoLuong;
        this.Gia=Gia;
    }
	
    public void setMa(String Ma)
    {
        this.Ma = Ma;
    }
    public void setTen(String Ten)
    {
        this.Ten = Ten;
    }
    public void setNgayNhap(int ngay,int thang,int nam)
    {
        nn.setNgay(ngay);
        nn.setThang(thang);
        nn.setNam(nam);
    }
    public void setSoLuong(int SoLuong)
    {
        this.SoLuong = SoLuong;
    }
     public void setGia(double Gia)
    {
        this.Gia = Gia;
    }
    public String getMa() {
        return Ma;
    }

    public String getTen() {
        return Ten;
    }

    public String getNgayNhap() {
        return NgayNhap;
    }

    public int getSoLuong() {
        return SoLuong;
    }
    public double getGia() {
        return Gia;
    }
    public void NhapHang()
    {
        System.out.println("Nhap ma hang: ");
        Ma= ha.nextLine();
        System.out.println("Nhap ten hang: ");
        Ten = ha.nextLine();
        System.out.println("Nhap ngay nhap:");
        nn.nhap();
        System.out.println("Nhap so luong hang nhap ve: ");
        SoLuong = nsl.KTNhapSo(SoLuong);
        System.out.println("Nhap gia hang nhap ve: ");
        Gia = nsl.KTNhapSo((int) Gia);
    }
    public void XuatHang()
    {  
        System.out.printf("%-20s%-40s%02d-%02d-%04d                    %d                   %1.0f",Ma,Ten,nn.ngay,nn.thang,nn.nam,SoLuong,Gia);
    }
    public double TinhTienHang(){
        double tong=0;
        tong=Gia*SoLuong;
        return tong;
    }  
     public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeUTF(Ma);
            out.writeUTF(Ten);
            out.writeInt(nn.ngay);
            out.writeInt(nn.thang);
            out.writeInt(nn.nam);
            out.writeInt(SoLuong);
            out.writeDouble(Gia);
	}catch(IOException e) {}
    }  
}
