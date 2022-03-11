package doan;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
    public class THUCUONG {
    private String MaNuoc;
    private String TenNuoc;
    private int SoLuong;
    private double GiaNuoc;
    String Ngayxuat;
    KiemTra kt3=new KiemTra();
    NgayThangNam nx=new NgayThangNam();
    Scanner tu = new Scanner(System.in);

    public THUCUONG()
    {
        MaNuoc = null;
        TenNuoc = null;
        GiaNuoc = 0;
        SoLuong = 0;
        Ngayxuat=null;
        
    }
    public THUCUONG(String MaNuoc, String TenNuoc, int SoLuong, double GiaNuoc,String Ngayxuat)
    {
        this.MaNuoc = MaNuoc;
        this.TenNuoc = TenNuoc;
        this.GiaNuoc = GiaNuoc;
        this.SoLuong  = SoLuong;
        this.Ngayxuat=Ngayxuat;
        
    }
	
    public void setMaNuoc(String MaNuoc)
    {
        this.MaNuoc= MaNuoc;
    }
    public void setTenNuoc(String TenNuoc)
    {
        this.TenNuoc = TenNuoc;
    }
    public void setSoLuong(int SoLuong)
    {
        this.SoLuong = SoLuong;
    }
    public void setGiaNuoc(double GiaNuoc)
    {
        this.GiaNuoc = GiaNuoc;
    }
    public String getNgayXuat() {
        return Ngayxuat;
    }

    public void setNgayXuat(int ngay,int thang,int nam)
    {
        nx.setNgay(ngay);
        nx.setThang(thang);
        nx.setNam(nam);
    }
    
    public String getMaNuoc() {
        return MaNuoc;
    }

    public String getTenNuoc() {
        return TenNuoc;
    }

    public double getSoLuong() {
        return SoLuong;
    }

    public double getGiaNuoc() {
        return GiaNuoc;
    }
   
    
    public void NhapThucUong()
    {
        System.out.println("Nhap ma nuoc uong: ");
        MaNuoc= tu.nextLine();
        System.out.println("Nhap ten nuoc uong: ");
        TenNuoc = tu.nextLine();
        System.out.println("Nhap ngay xuat:");
        nx.nhap();
        System.out.println("Nhap so luong phan nuoc: ");
        SoLuong=kt3.KTNhapSo(SoLuong);
        System.out.println("Nhap gia nuoc uong: ");
        GiaNuoc=kt3.KTNhapSo((int) GiaNuoc);
    }
    public void XuatThucUong()
    {
        System.out.printf("%-20s%-40s%02d-%02d-%04d                              %d                   %1.0f",MaNuoc,TenNuoc,nx.ngay,nx.thang,nx.nam,SoLuong,GiaNuoc);
    }
    public double TinhTienTU(){
        double tong=0;
        tong=GiaNuoc*SoLuong;
        return tong;
    }
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeUTF(MaNuoc);
            out.writeUTF(TenNuoc);
            out.writeInt(nx.ngay);
            out.writeInt(nx.nam);
            out.writeInt(nx.nam);
            out.writeInt(SoLuong);
            out.writeDouble(GiaNuoc);
	}catch(IOException e) {}
    }  
    
}
