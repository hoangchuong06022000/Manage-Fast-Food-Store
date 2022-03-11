package doan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class MangTHUCAN implements CHUCNANG_MANG{
    private int n;
    THUCAN [] ta;
    THUCAN ta1 = new THUCAN();
    KiemTra ns=new KiemTra();
    Scanner sc=new Scanner(System.in);
    
    public MangTHUCAN() {
       ta=new THUCAN[4];
       ta[0]=new THUCAN("garan","Ga ran gion cay",5,30000,"16-2-2019");
       ta[1]=new THUCAN("mi","Mi xao cay",7,25000,"28-3-2019");
       ta[2]=new THUCAN("banhmi","Hamburger",10,25000,"25-7-2019");
       ta[3]=new THUCAN("khoai","Khoai tay lac",9,20000,"2-1-2019");
    }

    public MangTHUCAN(int n, THUCAN[] ta) {
        this.n = n;
        this.ta = new THUCAN[n];
    }
    public MangTHUCAN(int n){
        this.n = n;
    	this.ta = new THUCAN[this.n];
    	for(int i = 0; i < n; i++) {
    		ta[i] = new THUCAN();
    	}
    }
    public MangTHUCAN(THUCAN[] ta) {
    	this.n = ta.length;
    	this.ta = new THUCAN[this.n];
    	for(int i = 0;i < n; i++) {
    		this.ta[i] = new THUCAN();
    		this.ta[i] = ta[i];
    	}
    }
    public THUCAN[] getTa() {
        return ta;
    }

   
    public void setTa(THUCAN[] ta) {
        this.ta = ta;
    }
    @Override
    public void Nhap()
    {
        System.out.println("Nhap so luong mon an: ");
        n=ns.KTNhapSo(1);
        ta=new THUCAN[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap mon an thu " +(i+1));
            ta[i]=new THUCAN();
            ta[i].NhapThucAn();
        }
    }
    
    @Override
    public void ThucHien(){
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Them thuc an");
        System.out.println("2. Sua thong tin thuc an");
        System.out.println("3. Xoa thuc an");
        System.out.println("4. Tim kiem thuc an");
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
                System.out.println("1. Tim kiem theo ma thuc an");
                System.out.println("2. Tim kiem theo ten thuc an");
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
    public THUCAN MenuSuaTA(THUCAN sua){
        int c;
        String t = null;
        System.out.println(" Ban muon sua thong tin nao: ");   
        System.out.println("1. Ten thuc an");
        System.out.println("2. So luong phan an");
        System.out.println("3. Gia thuc an");
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
                System.out.println("Nhap ten thuc an moi:");
                t=ns.KTTen();
                sua.setTenMonAn(t);
                break;
            }
            
            case 2:{
                System.out.println("Nhap so luong phan an moi:");
                int b=sc.nextInt();
                sua.setSoLuong(b);
                break;
            }
            case 3:{
                System.out.println("Nhap gia thuc an moi:");
                Double a=sc.nextDouble();
                sua.setGiaMonAn(a);
                break;
            }
            case 4:{
                System.out.println("Nhap lai tat ca thong tin cua thuc an:");
                THUCAN tam=new THUCAN();
                tam.NhapThucAn();
                sua=tam;
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
        int len=ta.length;
        System.out.println("Nhap so luong thuc an can them: ");
        int k=ns.KTNhapSo(1);
        ta=Arrays.copyOf(ta,len + k);
        for (int i=len;i<ta.length;i++){
            ta[i]=new THUCAN();
            System.out.println("Thuc an duoc them thu "+(i+1));
            ta[i].NhapThucAn();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA THUC AN","TEN THUC AN","NGAY XUAT","SO LUONG","GIA THUC AN");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<ta.length; i++){
            ta[i].XuatThucAn(); 
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    @Override
    public void Sua(){
        System.out.println("Nhap ma thuc an ban muon sua:");
        String ma=sc.nextLine();
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
                ta[vt]=MenuSuaTA(ta[vt]);
        System.out.println("Ban da sua thanh cong ");
        Xuat();
        }
        else System.out.println("Khong tim thay thuc an can tim");
        
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma thuc an ban muon xoa:");
        String ma=sc.nextLine();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa thuc an nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaThucAn(vt);
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA THUC AN","TEN THUC AN","NGAY XUAT","SO LUONG","GIA THUC AN");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<ta.length; i++){
            ta[i].XuatThucAn(); 
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        }  
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa thuc an nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma thuc an ban can tim"); 
    }
    public void XoaThucAn(int vt) {
        int len = ta.length;
        ta=Arrays.copyOf(ta,len-1);
	for (int i = vt; i <len-1; i++) {
            ta[i] = ta[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma thuc an can tim: ");
        String ma=sc.nextLine();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA THUC AN","TEN THUC AN","NGAY XUAT","SO LUONG","GIA THUC AN");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ta[vt].XuatThucAn();
        }
        else{
            System.out.println("Khong tim thay ma thuc an ban can tim ");
        }
    }
    public void TimKiemHTen(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten thuc an can tim: ");
        String hoten = sc.nextLine();
        int vt=TimKiemTen(hoten);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA THUC AN","TEN THUC AN","NGAY XUAT","SO LUONG","GIA THUC AN");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            ta[vt].XuatThucAn();
        }
        else{
            System.out.println("Khong tim thay ten thuc an ban can tim ");
        }
    }    
    
    public int TimKiemMa(String ma){
        
        for(int i=0; i<ta.length;i++){
            if(ta[i].getMaMonAn().compareTo(ma)==0){
                return i;
            }
        }
        return -1;
    }
    public int TimKiemTen(String hoten){
        
        for(int i=0; i<ta.length;i++){
            if(ta[i].getTenMonAn().compareTo(hoten)==0){
                return i;
            }
        }
        return -1;
    }
    public double TongTienTA(){
        double tong=0,tinh;
        for(int i=0;i<n;i++){
            tinh=ta[i].TinhTienTA();
            tong+=tinh;
        }
        return tong;
    }
    public void thongKeTuGiaDenGia() {
    	
    	boolean isEmpty = true;
    	float giaTu;
    	float giaDen;
    	System.out.println("Thong ke thuc an tu gia den gia");
        System.out.println("Moi ban nhap: ");
    	System.out.print(" .Tu gia: ");
    	giaTu = sc.nextFloat();
    	
    	System.out.print(" .Den gia: ");
    	giaDen = sc.nextFloat();
    	
    	System.out.println("Cac thuc an co gia nam trong khoang " + giaTu + " va " + giaDen + " la: \n");
    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA THUC AN","TEN THUC AN","NGAY XUAT RA BAN","SO LUONG","GIA THUC AN");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    	sc.nextLine();
    	
    	for(int i = 0; i < ta.length; i++) {
    		if(ta[i].getGiaMonAn()>= giaTu && ta[i].getGiaMonAn()<= giaDen) {
    			isEmpty = false;
    			ta[i].XuatThucAn();
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
    		}
    	}
    	
    	if(isEmpty == true) {
    		System.out.println("!!!Khong co thuc uong nao trong khoang gia ban yeu cau!!!\n");
    	}
    	
    }
    public void thongKeSluongCo() {
    	//variable to check a result empty or not
    	boolean isEmpty = true;
    	System.out.println("Nhap vao so luong co toi thieu cua thuc an ma ban mong muon: ");
    	int slYeuCau;
    	slYeuCau = sc.nextInt();
    	sc.nextLine();
    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA THUC AN","TEN THUC AN","NGAY XUAT RA BAN","SO LUONG","GIA THUC AN");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i < ta.length; i++) {
    		if(ta[i].getSoLuong()>= slYeuCau) {
    			isEmpty = false;
    			ta[i].XuatThucAn();
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
    		}
    	}
    	
    	if(isEmpty == true) {
    		System.out.println("!!!Khong co thuc an nao dap ung du so luong ma ban yeu cau!!!\n");
    	}
    }
   
    @Override
    public void Xuat(){  
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA THUC AN","TEN THUC AN","NGAY XUAT","SO LUONG","GIA THUC AN");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<4; i++){
            ta[i].XuatThucAn(); 
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < ta.length; i++) {
    		ta[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }

        
            
        
    
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		ta[i] = new THUCAN();
    		ta[i].setMaMonAn(inp.readUTF());
    		ta[i].setTenMonAn(inp.readUTF());
                ta[i].setNgayXuat(inp.readInt(), inp.readInt(), inp.readInt());
                ta[i].setSoLuong(inp.readInt());
                ta[i].setGiaMonAn(inp.readDouble());
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
            docFile("src/thucan.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}