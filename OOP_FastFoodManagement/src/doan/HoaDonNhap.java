/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
/**
 *
 * @author Netpham1970
 */
public class HoaDonNhap extends HOADON{
    Scanner hdn=new Scanner(System.in);
    MangHang h=new MangHang();
    HANG hang= new HANG();
    KiemTra kt6=new KiemTra();
    public HoaDonNhap() {
        super();
    }
    public HoaDonNhap(int mahd, double TongTien) {
        super(mahd,TongTien);
    }
    @Override
    public void nhapHD() throws Exception{
        MangNCC ncc=new MangNCC();
        ncc.docFile("src/nhacungcap.txt");
        super.nhapHD();
        System.out.println("Nhap ma nha cung cap(VD:ncc___(sau ncc la 3 ki tu so)):");
        while(true){
            try{
                t2=kt.KTMancc();
                int vt=ncc.TimKiemMa(t2);
                if(vt!=-1){
                    break;
                }
            }catch(NullPointerException e){
                System.out.println("Nha cung cap khong ton tai!! Nhap lai");
            }
        }
        h.Nhap();   
    }
    @Override
    public void xuatHD(){
        TongTien=h.TongTienHang();
        h.Xuat();
        System.out.println("Ma hoa don la:"+mahd);
        System.out.println("Ma nhan vien la:"+t);
        System.out.println("Ma nha cung cap la:"+t2);
        System.out.println("Tong tien :"+TongTien);
    }
    @Override
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeInt(mahd);
            out.writeUTF(t);
            out.writeUTF(t2);
            out.writeDouble(TongTien);
	}catch(IOException e) {}
    }  
}
