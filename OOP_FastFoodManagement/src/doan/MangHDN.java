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
public class MangHDN implements CHUCNANG_MANG{
    Scanner mhdn=new Scanner(System.in);
    HoaDonNhap [] hdn;
    private int n;
    KiemTra ns=new KiemTra();
    public MangHDN() {
        hdn=new HoaDonNhap[0];
    }

    public MangHDN(int n, HoaDonNhap[] hdn) {
        this.n = n;
        this.hdn = new HoaDonNhap[n];
    }
    public MangHDN(int n){
        this.n = n;
    	this.hdn = new HoaDonNhap[this.n];
    	for(int i = 0; i < n; i++) {
    		hdn[i] = new HoaDonNhap();
    	}
    }
    public MangHDN(HoaDonNhap[] hdn) {
    	this.n = hdn.length;
    	this.hdn = new HoaDonNhap[this.n];
    	for(int i = 0;i < n; i++) {
    		this.hdn[i] = new HoaDonNhap();
    		this.hdn[i] = hdn[i];
    	}
    }
    public HoaDonNhap[] getHdn() {
        return hdn;
    }

   
    public void setHdn(HoaDonNhap[] hdn) {
        this.hdn = hdn;
    }
    @Override
    public void Nhap() throws Exception{
        System.out.println("Nhap so luong hoa don:");
        n=Integer.parseInt(mhdn.nextLine());
        hdn=new HoaDonNhap[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap chi tiet hoa don thu " +(i+1));
            hdn[i]=new HoaDonNhap();
            hdn[i].nhapHD();
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
    public HoaDonNhap MenuSuaHDN(HoaDonNhap sua){
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
        int len=hdn.length;
        System.out.println("Nhap so luong hoa don can them: ");
        int k=ns.KTNhapSo(1);
        hdn=Arrays.copyOf(hdn,len + k);
        for (int i=len;i<hdn.length;i++){
            hdn[i]=new HoaDonNhap();
            System.out.println("Hoa don ban hang duoc them thu "+(i+1));
            hdn[i].nhapHD();
        }
    }
    @Override
    @SuppressWarnings("empty-statement")
    public void Sua(){
        System.out.println("Nhap ma hoa don ban muon sua:");
        int ma=ns.KTNhapSo(1);
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
                hdn[vt]=MenuSuaHDN(hdn[vt]);
        System.out.println("Ban da sua thanh cong ");
        }
        else System.out.println("Khong tim thay ma nhan vien can tim");
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma nhan vien ban muon xoa:");
        int ma=ns.KTNhapSo(1);
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa nhan vien nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaHD(vt);
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa nhan vien nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma nhan vien ban can tim"); 
    }
    public void XoaHD(int vt) {
        int len = hdn.length;
        hdn=Arrays.copyOf(hdn,len-1);
	for (int i = vt; i <len-1; i++) {
            hdn[i] = hdn[i + 1];
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
            hdn[vt].xuatHD();
        }
        else{
            System.out.println("Khong tim thay hoa don ban can tim ");
        }
    }
    
    public int TimKiemMa(int ma){
        
        for(int i=0; i<hdn.length;i++){
            if(hdn[i].getMahd()==ma){
                return i;
            }
        }
        return -1;
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < hdn.length; i++) {
    		hdn[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		hdn[i] = new HoaDonNhap();
    		hdn[i].setMahd(inp.readInt());
                hdn[i].setTongTien(inp.readDouble());
    		i++;
            }
    	}catch(EOFException e) {}
    	finally {
            this.n=i;
            inp.close();
    	}
    }   
    @Override
    public void Xuat(){
        for(int i=0; i<hdn.length; i++){
            System.out.println("Chi tiet hoa don thu "+(i+1));
            hdn[i].xuatHD();
            System.out.println("---------------------------------");
        }    
    }
    public void HienDS() throws IOException{
        try{
            docFile("src/hoadonhaphang.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}
