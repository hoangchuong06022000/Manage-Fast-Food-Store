
package doan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class MangKH implements CHUCNANG_MANG{
    Scanner mkh=new Scanner(System.in);
    KHACHHANG [] kh;
    private int n;
    KiemTra ns=new KiemTra();
    public MangKH() {
        kh=new KHACHHANG[5];
        kh[0]=new KHACHHANG("kh001",1,"Van Hoang Chuong",1,1,"Binh Tan","chuong@gmail.com","0705189519","026031272");
        kh[1]=new KHACHHANG("kh002",2,"Nguyen Thi My Hang",1,2,"Tan Binh","hang@gmail.com","0388874915","098765432");
        kh[2]=new KHACHHANG("kh003",1,"Nguyen Thai Bon",1,1,"Go Vap","bon@gmail.com","0704726043","021768345");
        kh[3]=new KHACHHANG("kh004",2,"Doan Thi Bich Tuyen",1,2,"Quan 1","tuyen@gmail.com","0705369134","046021854");
        kh[4]=new KHACHHANG("kh005",1,"Ly Nhat Hao",1,1,"Quan 12","hao@gmail.com","0798252214","096102567");
    }

    public MangKH(int n, KHACHHANG[] kh) {
        this.n = n;
        this.kh = new KHACHHANG[n];
    }
    public MangKH(int n){
        this.n = n;
    	this.kh = new KHACHHANG[this.n];
    	for(int i = 0; i < n; i++) {
    		kh[i] = new KHACHHANG();
    	}
    }
    public MangKH(KHACHHANG[] kh) {
    	this.n = kh.length;
    	this.kh = new KHACHHANG[this.n];
    	for(int i = 0;i < n; i++) {
    		this.kh[i] = new KHACHHANG();
    		this.kh[i] = kh[i];
    	}
    }
    public KHACHHANG[] getKh() {
        return kh;
    }

   
    public void setKh(KHACHHANG[] kh) {
        this.kh = kh;
    }
    @Override
    public void Nhap(){
        System.out.println("Nhap so luong khach hang:");
        n=ns.KTNhapSo(1);
        kh=new KHACHHANG[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap thong tin khach hang thu " +(i+1));
            kh[i]=new KHACHHANG();
            kh[i].nhap();
        }
    }
     @Override
    public void ThucHien() throws IOException{
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Them khach hang");
        System.out.println("2. Sua thong tin khach hang");
        System.out.println("3. Xoa khach hang");
        System.out.println("4. Tim kiem khach hang");
         System.out.println("5. Thong ke khach hang");
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
                System.out.println("1. Tim kiem theo ma khach hang");
                System.out.println("2. Tim kiem theo ten khach hang");
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
            case 5:{
                MenuThongke();
                break;
            }
        }
    }
    public KHACHHANG MenuSuaKH(KHACHHANG sua) throws IOException{
        int c;
        String t = null;
        System.out.println(" Ban muon sua thong tin nao: ");
        System.out.println("1. Ho ten");
        System.out.println("2. Ngay sinh");
        System.out.println("3. Gioi tinh");
        System.out.println("4. Dia chi");
        System.out.println("5. So dien thoai");
        System.out.println("6. So chung minh thu");
        System.out.println("7. Email");
        System.out.println("8. Loai khach hang");
        System.out.println("9. Toan bo");
        System.out.println("10. Thoat");
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
                sua.setHoten(t);
                break;
            }
            case 2:{
                System.out.println("Nhap ngay sinh:");
                NgayThangNam ntns=new NgayThangNam();
                ntns.nhap();
                sua.setNgaysinh(ntns.getNgay(), ntns.getThang(), ntns.getNam());
                break;
            }
            case 3:{
                System.out.println("Chon gioi tinh:");
                System.out.println("1.Nam       2.Nu");
                int tam=0;
                tam=ns.KTChon(tam, 2);
                sua.setGioitinh(tam);
                break;
            }
            case 4:{
                System.out.println("Nhap dia chi moi:");
                t=mkh.nextLine();
                sua.setDiachi(t);
                break;
            }
            case 5:{
                System.out.println("Nhap so dien thoai moi(10 so):");
                t=ns.KTSdt();
                sua.setSdt(t);
                break;
            }
            case 6:{
                System.out.println("Nhap so chung minh nhan dan moi(9 so):");
                t=ns.KTSocmnd();
                sua.setSocmnd(t);
                break;
            }
            case 7:{
                System.out.println("Nhap dia chi email moi(VD:_____@gmail.com):");
                t=ns.KTEmail();
                sua.setEmail(t);
                break;
            }
            case 8:{
                System.out.println("Chon loai khach hang");
                System.out.println("1.VIP       2.Thuong");
                int tam=0;
                tam=ns.KTChon(tam, 2);
                sua.setLoaikh(tam);
                break;
            }
            case 9:{
                System.out.println("Nhap lai tat ca thong tin cua khach hang:");
                KHACHHANG khm=new KHACHHANG();
                khm.nhap();
                sua=khm;
                break;
            }
            case 10:{
                System.out.println("Ban da thoat");
                break;
            }
        }
        return sua;
    }
    @Override
    public void Them(){
        int len=kh.length;
        System.out.println("Nhap so luong khach hang can them: ");
        int k=ns.KTNhapSo(1);
        kh=Arrays.copyOf(kh,len + k);
        for (int i=len;i<kh.length;i++){
            kh[i]=new KHACHHANG();
            System.out.println("Khach hang duoc them thu "+(i+1));
            kh[i].nhap();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA KH","HO TEN","LOAI KH","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<kh.length; i++){
            kh[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    @Override
    public void Sua() throws IOException{
        System.out.println("Nhap ma khach hang ban muon sua:");
        String ma=ns.KTMakh();
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
                kh[vt]=MenuSuaKH(kh[vt]);
        System.out.println("Ban da sua thanh cong ");
        Xuat();
        }
        else System.out.println("Khong tim thay ma khach hang can tim");
       
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma khach hang ban muon xoa:");
        String ma=ns.KTMakh();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa khach hang nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaKH(vt);
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA KH","HO TEN","LOAI KH","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<kh.length; i++){
            kh[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }  
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa khach hang nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma khach hang ban can tim"); 
    }
    public void XoaKH(int vt) {
        int len = kh.length;
        kh=Arrays.copyOf(kh,len-1);
	for (int i = vt; i <len-1; i++) {
            kh[i] = kh[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma khach hang can tim: ");
        String ma = ns.KTMakh();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA KH","HO TEN","LOAI KH","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            kh[vt].xuat();
        }
        else{
            System.out.println("Khong tim thay ma khach hang ban can tim ");
        }
    }
    public void TimKiemHTen(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten khach hang can tim: ");
        String hoten = ns.KTTen();
        int vt=TimKiemTen(hoten);
        if(vt!=-1){
            System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA KH","HO TEN","LOAI KH","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            kh[vt].xuat();
        }
        else{
            System.out.println("Khong tim thay ten khach hang ban can tim ");
        }
    }    
    
    public int TimKiemMa(String ma){
        
        for(int i=0; i<kh.length;i++){
            if(kh[i].getMakh().compareTo(ma)==0){
                return i;
            }
        }
        return -1;
    }
    public int TimKiemTen(String hoten){
        
        for(int i=0; i<kh.length;i++){
            if(kh[i].getHoten().compareTo(hoten)==0){
                return i;
            }
        }
        return -1;
    }
     public int TimKiemLKH(int loaikh){
        
        for(int i=0; i<kh.length;i++){
            if(kh[i].getLoaikh()==loaikh){
                return i;
            }
        }
        return -1;
    }
     public int TimKiemGioitinh(int ma){
        
        for(int i=0; i<kh.length;i++){
            if(kh[i].getGioitinh()==ma){
                return i;
            }
        }
        return -1;
    }
     public void ThongketheoGT() throws IOException{
        try{
            docFile("src/khachhang.txt");
            Scanner sc=new Scanner(System.in);
        System.out.println("Nhap gioi tinh khach hang can tim: ");
        System.out.println("1.Nam                     2.Nu");
        int ma=0;
        int i;
        ma = ns.KTChon(ma, 2);
            System.out.println(ma);
        int vt=TimKiemGioitinh(ma);
        if(vt!=-1){
            System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA KH","HO TEN","LOAI KH","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            
            for (;vt<kh.length;vt++) {
                kh[vt].xuat();
                System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        else{
            System.out.println("Khong tim thay gioi tinh khach hang ban can tim ");
        }
        }catch(NullPointerException e){
            
        }
        
    }   
     public void ThongketheoLKH(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap loai khach hang can tim: ");
        System.out.println("1.VIP                 2.Thuong");
        int loaikh=0;
        loaikh = ns.KTChon(loaikh, 2);
        int vt=TimKiemLKH(loaikh);
        if(vt!=-1){
            System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA KH","HO TEN","LOAI KH","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for(int i=0; i<kh.length; i++){
                kh[vt].xuat();
             System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
        else{
            System.out.println("Khong tim thay loai khach hang ban can tim ");
        }
    }  
    public void ThongKeSLKH() {
        try{
            int len = kh.length;
            System.out.printf(" So luong khach hang la: %d khach hang \n",len);
            for(int i=0; i<kh.length; i++){
            kh[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }  
        }catch(NullPointerException e){
            
        }
    }
    public void MenuThongke() throws IOException{
        Scanner sc= new Scanner(System.in);
        System.out.println("1. Thong ke theo gioi tinh");
        System.out.println("2. Thong ke theo loai khach hang");
        System.out.println("3. Thong ke so luong khach hang");
        System.out.println("0. Thoat");
        int c=ns.KTNhapSo(0);
        switch(c){
            case 0:{
                System.out.println("Ban da thoat");
                break;
            }
            case 1:{
                ThongketheoGT();
                break;
            }
            case 2:{
                ThongketheoLKH();
                break;
            }
            case 3:{
                ThongKeSLKH();
                break;
            }
        }
    }
    @Override
    public void Xuat(){
      
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA KH","HO TEN","LOAI KH","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<5; i++){
            kh[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < kh.length; i++) {
    		kh[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		kh[i] = new KHACHHANG();
    		kh[i].setMakh(inp.readUTF());
    		kh[i].setHoten(inp.readUTF());
                kh[i].setLoaikh(inp.readInt());
    		kh[i].setNgaysinh(inp.readInt(),inp.readInt(),inp.readInt());
    		kh[i].setGioitinh(inp.readInt());
    		kh[i].setSocmnd(inp.readUTF());
    		kh[i].setSdt(inp.readUTF());
                kh[i].setDiachi(inp.readUTF());
                kh[i].setEmail(inp.readUTF());
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
            docFile("src/khachhang.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}
