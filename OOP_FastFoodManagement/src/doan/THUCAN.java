package doan;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
public class THUCAN{
    String MaMonAn;
    String TenMonAn;
    int SoLuong;
    double GiaMonAn;
    String NgayXuat;  
    NgayThangNam nx=new NgayThangNam();
    KiemTra nso=new KiemTra();
    Scanner ta = new Scanner(System.in);

    public THUCAN()
    {
        this.MaMonAn = null;
        this.TenMonAn = null;
        this.GiaMonAn = 0;
        this.SoLuong = 0;
        this.NgayXuat=null;
    }
    public THUCAN(String MaMonAn, String TenMonAn, int SoLuong, double GiaMonAn,String NgayXuat)
    {
        this.MaMonAn = MaMonAn;
        this.TenMonAn = TenMonAn;
        this.GiaMonAn = GiaMonAn;
        this.SoLuong = SoLuong;
        this.NgayXuat=NgayXuat;
        
    }
	
    public void setMaMonAn(String MaMonAn)
    {
        this.MaMonAn= MaMonAn;
    }
    public void setTenMonAn(String TenMonAn)
    {
        this.TenMonAn = TenMonAn;
    }
    public void setSoLuong(int SoLuong)
    {
        this.SoLuong = SoLuong;
    }
    public void setGiaMonAn(double GiaMonAn)
    {
        this.GiaMonAn = GiaMonAn;
    }
    public void setNgayXuat(int ngay,int thang,int nam)
    {
        nx.setNgay(ngay);
        nx.setThang(thang);
        nx.setNam(nam);
    }
   
    public String getMaMonAn() {
        return MaMonAn;
    }

    public String getTenMonAn() {
        return TenMonAn;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public double getGiaMonAn() {
        return GiaMonAn;
    }
    public String getNgayXuat() {
        return NgayXuat;
    }
      
    public void NhapThucAn()
    {
        System.out.println("Nhap ma mon an: ");
        MaMonAn= ta.nextLine();
        System.out.println("Nhap ten mon an: ");
        TenMonAn = ta.nextLine();
        System.out.println("Nhap ngay xuat:");
        nx.nhap();
        System.out.println("Nhap so luong phan an: ");
        SoLuong=nso.KTNhapSo(SoLuong);
        System.out.println("Nhap gia mon an: ");
        GiaMonAn=nso.KTNhapSo((int) GiaMonAn);
    }
    public void XuatThucAn()
    {
        System.out.printf("%-20s%-40s%02d-%02d-%04d                              %d                   %1.0f",MaMonAn,TenMonAn,nx.ngay,nx.thang,nx.nam,SoLuong,GiaMonAn);
    }
    public double TinhTienTA(){
        double tong=0;
        tong=GiaMonAn*SoLuong;
        return tong;
    }  
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeUTF(MaMonAn);
            out.writeUTF(TenMonAn);
            out.writeInt(nx.ngay);
            out.writeInt(nx.nam);
            out.writeInt(nx.nam);
            out.writeInt(SoLuong);
            out.writeDouble(GiaMonAn);
	}catch(IOException e) {}
    }  
}
