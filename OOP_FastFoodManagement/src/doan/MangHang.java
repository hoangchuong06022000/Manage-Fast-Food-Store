
package doan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MangHang implements CHUCNANG_MANG{
    Scanner mha=new Scanner(System.in);
    HANG [] h;
    private int n;
    KiemTra ns=new KiemTra();
    public MangHang() {
        h=new HANG[3];
        h[0]=new HANG("001","ong hut","08-12-2019",500,2000);
        h[1]=new HANG("002","ly giay","12-12-2019",50,3000);
        h[2]=new HANG("003","hop giay","2-12-2019",100,5000);
    }

    public MangHang(int n, HANG[] h) {
        this.n = n;
        this.h = new HANG[n];
    }
    public MangHang(int n){
        this.n = n;
    	this.h = new HANG[this.n];
    	for(int i = 0; i < n; i++) {
    		h[i] = new HANG();
    	}
    }
    public MangHang(HANG[] h) {
    	this.n = h.length;
    	this.h = new HANG[this.n];
    	for(int i = 0;i < n; i++) {
    		this.h[i] = new HANG();
    		this.h[i] = h[i];
    	}
    }
    public HANG[] getH() {
        return h;
    }
    public void setH(HANG[] h) {
        this.h = h;
    }
    @Override
    public void Nhap() {
        System.out.println("Nhap so loai hang:");
        n=ns.KTNhapSo(1);
        h=new HANG[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap thong tin hang thu " +(i+1));
            h[i]=new HANG();
            h[i].NhapHang();
        }
    }

    @Override
    public void Xuat() {
        
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-30s%-20s%-20s\n","MA HANG","TEN HANG","NGAY NHAP","SO LUONG","GIA HANG");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<3; i++){
            h[i].XuatHang(); 
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }

     @Override
    public void ThucHien(){
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Them hang");
        System.out.println("2. Sua thong tin hang");
        System.out.println("3. Xoa hang");
        System.out.println("4. Tim kiem hang");
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
                System.out.println("1. Tim kiem theo ma hang");
                System.out.println("2. Tim kiem theo ten hang");
                System.out.println("0. Quay lai");
                int c1=ns.KTNhapSo(1);
                switch(c1){
                    case 0:ThucHien();
                    case 1:{
                        TimKiem();
                        break;
                    }
                    case 2:{
                        TimKiemHTen();
                        break;
                    }
                }
                    break;
            }
        }
    }
    public HANG MenuSuaHang(HANG sua){
        int c;
        String t = null;
        System.out.println(" Ban muon sua thong tin nao: ");
        System.out.println("1. Ten hang");
        System.out.println("2. Ngay nhap");
        System.out.println("3. So luong");  
        System.out.println("4. Toan bo");
        System.out.println("5. Thoat");
        System.out.println("0. Quay lai");
        System.out.print(" Nhap lua chon cua ban:");
        c = ns.KTNhapSo(0);
        switch (c) {
            case 0:{
                ThucHien();
            }
            case 1:{
                System.out.println("Nhap ten hang moi(tu 10-40 ki tu(khong co ki tu la so)):");
                t=mha.nextLine();
                sua.setTen(t);
                break;
            }
            case 2:{
                System.out.println("Nhap ngay nhap:");
                NgayThangNam ntns=new NgayThangNam();
                ntns.nhap();
                sua.setNgayNhap(ntns.getNgay(), ntns.getThang(), ntns.getNam());
                break;
            }
            case 3:{
                System.out.println("Nhap so luong hang moi:");
                int b=mha.nextInt();
                sua.setSoLuong(b);
                break;
            }
            case 4:{
                System.out.println("Nhap lai tat ca thong tin cua hang:");
                HANG hm=new HANG();
                hm.NhapHang();
                sua=hm;
                break;
            }
            case 5:{
                System.out.println("Ban da thoat");
                break;
            }
        }
        return sua;
    }
    @Override
    public void Them(){
        int len=h.length;
        System.out.println("Nhap so luong hang can them: ");
        int k=ns.KTNhapSo(1);
        h=Arrays.copyOf(h,len + k);
        for (int i=len;i<h.length;i++){
            h[i]=new HANG();
            System.out.println("Nhan vien duoc them thu "+(i+1));
            h[i].NhapHang();
        }
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-30s%-20s%-20s\n","MA HANG","TEN HANG","NGAY NHAP","SO LUONG","GIA HANG");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<h.length; i++){
            h[i].XuatHang(); 
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    @Override
    public void Sua(){
        System.out.println("Nhap ma hang ban muon sua:");
        String ma=mha.nextLine();
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
                h[vt]=MenuSuaHang(h[vt]);
        System.out.println("Ban da sua thanh cong ");
        Xuat();
        }
        else System.out.println("Khong tim thay ma hang can tim");
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma hang ban muon xoa:");
        String ma=mha.nextLine();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa hang nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaHang(vt);
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-30s%-20s%-20s\n","MA HANG","TEN HANG","NGAY NHAP","SO LUONG","GIA HANG");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<h.length; i++){
            h[i].XuatHang(); 
            System.out.println("\n------------------------------------------------------------------------------------------------------------------------------------------");
        }  
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa hang nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma hang ban can tim"); 
    }
    public void XoaHang(int vt) {
        int len = h.length;
        h=Arrays.copyOf(h,len-1);
	for (int i = vt; i <len-1; i++) {
            h[i] = h[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma hang can tim: ");
        String ma=sc.nextLine();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-30s%-20s%-20s\n","MA HANG","TEN HANG","NGAY NHAP","SO LUONG","GIA HANG");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            h[vt].XuatHang();
        }
        else{
            System.out.println("Khong tim thay ma hang ban can tim ");
        }
    }
    public void TimKiemHTen(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten hang can tim: ");
        String hoten =sc.nextLine();
        int vt=TimKiemTen(hoten);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-30s%-20s%-20s\n","MA HANG","TEN HANG","NGAY NHAP","SO LUONG","GIA HANG");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            h[vt].XuatHang();
        }
        else{
            System.out.println("Khong tim thay ten hang ban can tim ");
        }
    }    
    
    public int TimKiemMa(String ma){
        
        for(int i=0; i<h.length;i++){
            if(h[i].getMa().compareTo(ma)==0){
                return i;
            }
        }
        return -1;
    }
    public int TimKiemTen(String hoten){
        
        for(int i=0; i<h.length;i++){
            if(h[i].getTen().compareTo(hoten)==0){
                return i;
            }
        }
        return -1;
    }
    public double TongTienHang(){
        double tong=0,tinh;
        for(int i=0;i<n;i++){
            tinh=h[i].TinhTienHang();
            tong+=tinh;
        }
        return tong;
    }

    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < h.length; i++) {
    		h[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		h[i] = new HANG();
    		h[i].setMa(inp.readUTF());
    		h[i].setTen(inp.readUTF());
    		h[i].setNgayNhap(inp.readInt(),inp.readInt(),inp.readInt());
    		h[i].setSoLuong(inp.readInt());
                h[i].setGia(inp.readDouble());
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
            docFile("src/hang.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}
