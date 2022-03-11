
package doan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MangNCC implements CHUCNANG_MANG{
    Scanner mncc=new Scanner(System.in);
    private int n;
    NHACC [] ncc;
    KiemTra ns=new KiemTra();
    public MangNCC() {
        ncc=new NHACC[2];
        ncc[0]=new NHACC("ncc001","Van Hoang Chuong","0705189519","Binh Tan","chuong@gmail.com");
        ncc[1]=new NHACC("ncc002","Nguyen Thi My Hang","0388874915","Tan Binh","hang@gmail.com");
    }

    public MangNCC(int n, NHACC[] nv) {
        this.n = n;
        this.ncc = new NHACC[n];
    }
    public MangNCC(int n){
        this.n = n;
    	this.ncc = new NHACC[this.n];
    	for(int i = 0; i < n; i++) {
    		ncc[i] = new NHACC();
    	}
    }
    public MangNCC(NHACC[] ncc) {
    	this.n = ncc.length;
    	this.ncc = new NHACC[this.n];
    	for(int i = 0;i < n; i++) {
    		this.ncc[i] = new NHACC();
    		this.ncc[i] = ncc[i];
    	}
    }
    public NHACC[] getNcc() {
        return ncc;
    }

   
    public void setNcc(NHACC[] ncc) {
        this.ncc = ncc;
    }
    @Override
    public void Nhap(){
        System.out.println("Nhap so luong nha cung cap:");
        n=ns.KTNhapSo(1);
        ncc=new NHACC[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap thong tin nha cung cap thu " +(i+1));
            ncc[i]=new NHACC();
            ncc[i].nhap();
        }
    }
    @Override
    public void ThucHien(){
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Them nha cung cap");
        System.out.println("2. Sua thong tin nha cung cap");
        System.out.println("3. Xoa nha cung cap");
        System.out.println("4. Tim kiem nha cung cap");
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
                System.out.println("1. Tim kiem theo ma nha cung cap");
                System.out.println("2. Tim kiem theo ten nha cung cap");
                System.out.println("0. Quay lai");
                int c1=ns.KTNhapSo(0);
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
    public NHACC MenuSuaNCC(NHACC sua){
        int c;
        String t = null;
        System.out.println(" Ban muon sua thong tin nao: ");
        System.out.println("1. Ho ten");
        System.out.println("2. Dia chi");
        System.out.println("3. So dien thoai");
        System.out.println("4. Email");   
        System.out.println("5. Toan bo");
        System.out.println("6. Thoat");
        System.out.println("0. Quay lai");
        System.out.print(" Nhap lua chon cua ban:");
        c = ns.KTNhapSo(0);
        switch (c) {
            case 0:{
                ThucHien();
            }
            case 1:{
                System.out.println("Nhap ho ten moi(tu 10-40 ki tu(khong co ki tu la so)):");
                t=ns.KTTen();
                sua.setTenncc(t);
                break;
            }
            case 2:{
                System.out.println("Nhap dia chi moi:");
                t=mncc.nextLine();
                sua.setDiachi(t);
                break;
            }
            case 3:{
                System.out.println("Nhap so dien thoai moi(10 so):");
                t=ns.KTSdt();
                sua.setSdt(t);
                break;
            }
            case 4:{
                System.out.println("Nhap dia chi email moi(VD:_____@gmail.com):");
                t=ns.KTEmail();
                sua.setEmail(t);
                break;
            }
           
            case 5:{
                System.out.println("Nhap lai tat ca thong tin cua nha cung cap:");
                NHACC nccm=new NHACC();
                nccm.nhap();
                sua=nccm;
                break;
            }
            case 6:{
                System.out.println("Ban da thoat");
                break;
            }
        }
        return sua;
    }
    @Override
    public void Them(){
        int len=ncc.length;
        System.out.println("Nhap so luong nha cung cap can them: ");
        int k=ns.KTNhapSo(1);
        ncc=Arrays.copyOf(ncc,len + k);
        for (int i=len;i<ncc.length;i++){
            ncc[i]=new NHACC();
            System.out.println("Nha cung cap duoc them thu "+(i+1));
            ncc[i].nhap();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-20s%-40s%-30s\n","MA NHACC","TEN NHACC","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<ncc.length; i++){
            ncc[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    @Override
    public void Sua(){
        System.out.println("Nhap ma nha cung cap ban muon sua:");
        String ma=ns.KTMancc();
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
                ncc[vt]=MenuSuaNCC(ncc[vt]);
        System.out.println("Ban da sua thanh cong ");
        Xuat();
        }
        else System.out.println("Khong tim thay ma nha cung cap can tim");
       
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma nha cung cap ban muon xoa:");
        String ma=ns.KTMancc();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa nha cung cap nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaNV(vt);
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-20s%-40s%-30s\n","MA NHACC","TEN NHACC","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<ncc.length; i++){
            ncc[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }  
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa nha cung cap nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma nha cung cap ban can tim"); 
    }
    public void XoaNV(int vt) {
        int len = ncc.length;
        ncc=Arrays.copyOf(ncc,len-1);
	for (int i = vt; i <len-1; i++) {
            ncc[i] = ncc[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma nha cung cap can tim: ");
        String ma = ns.KTMancc();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-20s%-40s%-30s\n","MA NHACC","TEN NHACC","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ncc[vt].xuat();
        }
        else{
            System.out.println("Khong tim thay ma nha cung cap ban can tim ");
        }
    }
    public void TimKiemHTen(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten nha cung cap can tim: ");
        String hoten = ns.KTTen();
        int vt=TimKiemTen(hoten);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-20s%-40s%-30s\n","MA NHACC","TEN NHACC","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ncc[vt].xuat();
        }
        else{
            System.out.println("Khong tim thay ten nha cung cap ban can tim ");
        }
    }    
    
    public int TimKiemMa(String ma){
        
        for(int i=0; i<ncc.length;i++){
            if(ncc[i].getMancc().compareTo(ma)==0){
                return i;
            }
        }
        return -1;
    }
    public int TimKiemTen(String hoten){
        
        for(int i=0; i<ncc.length;i++){
            if(ncc[i].getTenncc().compareTo(hoten)==0){
                return i;
            }
        }
        return -1;
    }
    @Override
    public void Xuat(){
        
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-20s%-40s%-30s\n","MA NHACC","TEN NHACC","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<2; i++){
            ncc[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < ncc.length; i++) {
    		ncc[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		ncc[i] = new NHACC();
    		ncc[i].setMancc(inp.readUTF());
    		ncc[i].setSdt(inp.readUTF());
                ncc[i].setDiachi(inp.readUTF());
                ncc[i].setEmail(inp.readUTF());
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
            docFile("src/nhacungcap.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}
