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
public class MangTK implements CHUCNANG_MANG{
    Scanner mtk=new Scanner(System.in);
    private int n,lenfile;
    private TaiKhoan [] tk;
    KiemTra ns= new KiemTra();
    public MangTK() {
       tk=new TaiKhoan[10];
    }

    public MangTK(int n, TaiKhoan[] tk) {
        this.n = n;
        this.tk = new TaiKhoan[n];
    }
    public MangTK(int n){
        this.n = n;
    	this.tk = new TaiKhoan[this.n+lenfile];
    	for(int i = 0; i < n; i++) {
    		tk[i] = new TaiKhoan();
    	}
    }
    public MangTK(TaiKhoan[] tk) {
    	this.n = tk.length;
    	this.tk = new TaiKhoan[this.n];
    	for(int i = 0;i < n; i++) {
    		this.tk[i] = new TaiKhoan();
    		this.tk[i] = tk[i];
    	}
    }

    public TaiKhoan[] getTk() {
        return tk;
    }

    public void setTk(TaiKhoan[] tk) {
        this.tk = tk;
    }
    @Override
    public void Nhap() throws Exception{
        System.out.println("Nhap so luong tai khoan:");
        n=ns.KTNhapSo(1);
        tk=new TaiKhoan[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap thong tin tai khoan thu " +(i+1));
            tk[i]=new TaiKhoan();
            tk[i].nhap();
        }
    }
    @Override
    public void ThucHien() throws IOException{
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Them tai khoan");
        System.out.println("2. Sua thong tin tai khoan");
        System.out.println("3. Xoa tai khoan");
        System.out.println("4. Tim kiem tai khoan");
        System.out.println("0. Thoat");
        System.out.println("Nhap lua chon cua ban:");
        c = ns.KTNhapSo(0);
        switch(c){
            case 0:{
                System.out.println("Ban da thoat");
                break;
            }
            case 1: {Them();break;}
            case 2: {Sua();break;}
            case 3: {Xoa();break;}
            case 4: {
                System.out.println("Chon thao tac:");
                System.out.println("1. Tim kiem theo ten tai khoan");
                System.out.println("2. Thoat");
                System.out.println("0. Quay lai");
                int c1=ns.KTNhapSo(0);
                switch(c1){
                    case 0:ThucHien();
                    case 1:{
                        TimKiem();
                        break;
                    }
                    case 2:{
                        System.out.println("Ban da thoat");
                        break;
                    }
                }
                    break;
            }
        }
    }
    public TaiKhoan MenuSuaTK(TaiKhoan sua) throws IOException{
        int c;
        String t = null;
        System.out.println(" Ban muon sua thong tin nao: ");
        System.out.println("1. Ten tai khoan");
        System.out.println("2. Mat khau");
        System.out.println("3. Thoat");
        System.out.println("0. Quay lai");
        System.out.print(" Nhap lua chon cua ban:");
        c = ns.KTNhapSo(0);
        switch (c) {
            case 0:{
                ThucHien();
            }
            case 1:{
                System.out.println("Nhap tai khoan moi:");
                t=mtk.nextLine();
                sua.setUser(t);
                break;
            }
            case 2:{
                System.out.println("Nhap mat khau moi:");
                t=mtk.nextLine();
                sua.setPass(t);
                break;
            }
            case 3:{
                System.out.println("Ban da thoat");
                break;
            }
        }
        return sua;
    }
    @Override
    public void Them() throws IOException{
            int len=tk.length;
            System.out.println("Nhap so luong tai khoan can them: ");
            int k=ns.KTNhapSo(1);
            tk=Arrays.copyOf(tk,len + k);
            for (int i=len;i<tk.length;i++){
                tk[i]=new TaiKhoan();
                System.out.println("Tai khoan duoc them thu "+(i+1));
                tk[i].nhap();
            }
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-20s%-20s\n","Ten TK","Pass");
            System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
            for(int i=0; i<tk.length; i++){
            tk[i].xuat(); 
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    @Override
    @SuppressWarnings("empty-statement")
    public void Sua() throws IOException{
        System.out.println("Nhap ten tai khoan ban muon sua:");
        String ma=ns.KTManv();
        int vt;
        if ((vt = TimKiemTK(ma)) != -1) {
                tk[vt]=MenuSuaTK(tk[vt]);
        System.out.println("Ban da sua thanh cong ");
        Xuat();
        }
        else System.out.println("Khong tim thay tai khoan can tim");
        
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ten tai khoan ban muon xoa:");
        String ma=ns.KTManv();
        int vt=TimKiemTK(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa tai khoan nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaTK(vt);
                    System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s\n","Ten TK","Pass");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<tk.length; i++){
            tk[i].xuat(); 
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
        }  
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa tai khoan nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay tai khoan ban can tim"); 
    }
    public void XoaTK(int vt) {
        int len = tk.length;
        tk=Arrays.copyOf(tk,len-1);
	for (int i = vt; i <len-1; i++) {
            tk[i] = tk[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten tai khoan can tim: ");
        String ma =ns.KTManv();
        int vt=TimKiemTK(ma);
        if(vt!=-1){
            tk[vt].xuat();
        }
        else{
            System.out.println("Khong tim thay tai khoan ban can tim ");
        }
    }
    
    public int TimKiemTK(String ma){
        
        for(int i=0; i<tk.length;i++){
            if(tk[i].getUser().compareTo(ma)==0){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void Xuat(){
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-20s\n","Ten TK","Pass");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<2; i++){
            tk[i].xuat(); 
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < tk.length; i++) {
    		tk[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		tk[i] = new TaiKhoan();
    		tk[i].setUser(inp.readUTF());
    		tk[i].setPass(inp.readUTF());
    		i++;
            }
    	}catch(EOFException e) {}
    	finally {
            this.n=i;
            inp.close();
    	}
    }
    public void HienDS() throws IOException{
        try{
            docFile("src/taikhoan.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}
