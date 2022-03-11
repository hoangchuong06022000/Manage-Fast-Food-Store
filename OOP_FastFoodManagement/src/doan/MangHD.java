/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Netpham1970
 */
public class MangHD implements CHUCNANG_MANG{
    Scanner mhd=new Scanner(System.in);
    HOADON [] hd;
    private int n;
    HOADON ban=new ChitietHDBan();
    HOADON nhap=new HoaDonNhap();
    KiemTra ns=new KiemTra();
    public MangHD() {
        hd=new HOADON[0];
    }

    public MangHD(int n, HOADON[] hd) {
        this.n = n;
        this.hd = new HOADON[n];
    }
    public MangHD(int n){
        this.n = n;
    	this.hd = new HOADON[this.n];
    	for(int i = 0; i < n; i++) {
    		hd[i] = new HOADON();
    	}
    }
    public MangHD(HOADON[] hd) {
    	this.n = hd.length;
    	this.hd = new HOADON[this.n];
    	for(int i = 0;i < n; i++) {
    		this.hd[i] = new HOADON();
    		this.hd[i] = hd[i];
    	}
    }
    public HOADON[] getHd() {
        return hd;
    }

   
    public void setHd(HOADON[] hd) {
        this.hd = hd;
    }
    @Override
    public void Nhap() throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.println("Ban muon nhap hoa don nao:");
        System.out.println("1.HOA DON NHAP HANG ");
        System.out.println("2.HOA DON BAN HANG ");
        int c=ns.KTNhapSo(1);
        switch(c){
            case 1:{
                ban.nhapHD();
                ban.xuatHD();
                break;
            }
            case 2:{
                nhap.nhapHD();
                nhap.xuatHD();
                break;
            }
        }
    }

    @Override
    public void Xuat() {
       for(int i=0; i<hd.length; i++){
            System.out.println("Chi tiet hoa don thu "+(i+1));
            hd[i].xuatHD();
            System.out.println("---------------------------------");
        }    
    }

    
    public void MenuHoadon() throws IOException {
            Scanner in = new Scanner(System.in);
            int c;
            System.out.println("+--------------------------------------------+");
            System.out.println("|                 MENU HOA DON               |");
            System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            System.out.println("| 1.  Quan ly hoa don ban hang               |");
            System.out.println("| 2.  Quan ly hoa don nhap hang              |");
            System.out.println("| 0.  Thoat                                  |");
            System.out.println("+--------------------------------------------+");
            c = ns.KTNhapSo(0);
            MangCTHDBan ban1=new MangCTHDBan();
            MangHDN nhap1=new MangHDN();
            String nhf = "src/hoadonnhaphang.txt";
            String bhf = "src/hoadonbanhang.txt";
            ban1.docFile(bhf);
            nhap1.docFile(nhf);
            switch(c) {
                case 0:{
                    System.out.println("\n!!!CAM ON VA HEN GAP LAI!!!\n");
                    break;
                }

                case 1:{
                    ban1.HienDS();
                    ban1.ThucHien();
                    ban1.ghiFile(bhf);
                    break;
                }
                case 2:{
                    nhap1.HienDS();
                    nhap1.ThucHien();
                    nhap1.ghiFile(nhf);
                    break;
                }
                default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
            }
    }            
    @Override
    public void ThucHien(){
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Sua chi tiet hoa don");
        System.out.println("2. Xoa hoa don");
        System.out.println("3. Tim kiem hoa don");
        System.out.println("0. Thoat");
        System.out.println("Nhap lua chon cua ban:");
        c = ns.KTNhapSo(0);
        switch(c){
            case 0:{
                System.out.println("Ban da thoat");
                break;
            }
            case 1: {Sua();break;}
            case 2: {Xoa();break;}
            case 3: {
                System.out.println("Chon thao tac:");
                System.out.println("1. Tim kiem theo ma hoa don");
                System.out.println("0. Quay lai");
                int c1=ns.KTNhapSo(0);
                switch(c1){
                    case 0:ThucHien();
                    case 1:{
                        TimKiem();
                        break;
                    }
                }
                    break;
            }
        }
    }
    public HOADON MenuSuaHD(HOADON sua){
        int c;
        String t = null;
        System.out.println(" Ban muon sua thong tin nao: ");
        System.out.println("1.Ma hoa don");
        System.out.println("2.Thoat");
        System.out.println("0. Quay lai");
        System.out.print(" Nhap lua chon cua ban:");
        c = ns.KTNhapSo(0);
        switch (c) {
            case 0:{
                ThucHien();
            }
            case 1:{
                System.out.println("Nhap ma hoa don moi:");
                int tam=ns.KTNhapSo(1);
                sua.setMahd(tam);
                break;
            }
            case 2:{
                System.out.println("Ban da thoat");
                break;
            }
        }
        return sua;
    }
    @Override
    public void Them() throws Exception{
        int len=hd.length;
        System.out.println("Nhap so luong hoa don can them: ");
        int k=ns.KTNhapSo(1);
        hd=Arrays.copyOf(hd,len + k);
        for (int i=len;i<hd.length;i++){
            hd[i]=new ChitietHDBan();
            System.out.println("Hoa don ban hang duoc them thu "+(i+1));
            hd[i].nhapHD();
        }
    }
    @Override
    @SuppressWarnings("empty-statement")
    public void Sua(){
        System.out.println("Nhap ma hoa don ban muon sua:");
        int ma=ns.KTNhapSo(1);
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
                hd[vt]=MenuSuaHD(hd[vt]);
        System.out.println("Ban da sua thanh cong ");
        }
        else System.out.println("Khong tim thay ma hoa don can tim");
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma hoa don ban muon xoa:");
        int ma=ns.KTNhapSo(1);
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa hoa don nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaHD(vt);
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa hoa don nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma hoa don ban can tim"); 
    }
    public void XoaHD(int vt) {
        int len = hd.length;
        hd=Arrays.copyOf(hd,len-1);
	for (int i = vt; i <len-1; i++) {
            hd[i] = hd[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma hoa don can tim: ");
        int ma =ns.KTNhapSo(1);
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            hd[vt].xuatHD();
        }
        else{
            System.out.println("Khong tim thay hoa don ban can tim ");
        }
    }
    
    public int TimKiemMa(int ma){
        
        for(int i=0; i<hd.length;i++){
            if(hd[i].getMahd()==ma){
                return i;
            }
        }
        return -1;
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < hd.length; i++) {
    		hd[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		hd[i] = new HOADON();
    		hd[i].setMahd(inp.readInt());
                hd[i].setTongTien(inp.readDouble());
    		i++;
            }
    	}catch(EOFException e) {}
    	finally {
            this.n=i;
            inp.close();
    	}
    }   
}
