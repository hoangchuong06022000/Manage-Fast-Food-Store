
package doan;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;

public class MangNV implements CHUCNANG_MANG{
    Scanner mnv=new Scanner(System.in);
    private int n;
    NHANVIEN snv=new NHANVIEN();
    NHANVIEN [] nv;
    KiemTra ns= new KiemTra();
    public MangNV() {
        nv=new NHANVIEN[5];
        nv[0]=new NHANVIEN("nv001",1,"Van Hoang Chuong",1,1,"Binh Tan","chuong@gmail.com","0705189519","026031272");
        nv[1]=new NHANVIEN("nv002",2,"Nguyen Thi My Hang",1,2,"Tan Binh","hang@gmail.com","0388874915","098765432");
        nv[2]=new NHANVIEN("nv003",1,"Nguyen Thai Bon",1,1,"Go Vap","bon@gmail.com","0704726043","021768345");
        nv[3]=new NHANVIEN("nv004",2,"Doan Thi Bich Tuyen",1,2,"Quan 1","tuyen@gmail.com","0705369134","046021854");
        nv[4]=new NHANVIEN("nv005",1,"Ly Nhat Hao",1,1,"Quan 12","hao@gmail.com","0798252214","096102567");
    }

    public MangNV(int n, NHANVIEN[] nv) {
        this.n = n;
        this.nv = new NHANVIEN[n];
    }
    public MangNV(int n){
        this.n = n;
    	this.nv = new NHANVIEN[this.n];
    	for(int i = 0; i < n; i++) {
    		nv[i] = new NHANVIEN();
    	}
    }
    public MangNV(NHANVIEN[] nv) {
    	this.n = nv.length;
    	this.nv = new NHANVIEN[this.n];
    	for(int i = 0;i < n; i++) {
    		this.nv[i] = new NHANVIEN();
    		this.nv[i] = nv[i];
    	}
    }
    public NHANVIEN[] getNv() {
        return nv;
    }

   
    public void setNv(NHANVIEN[] nv) {
        this.nv = nv;
    }
    @Override
    public void Nhap(){
        System.out.println("Nhap so luong nhan vien:");
        n=ns.KTNhapSo(1);
        nv=new NHANVIEN[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap thong tin nhan vien thu " +(i+1));
            nv[i]=new NHANVIEN();
            nv[i].nhap();
        }
    }
    @Override
    public void ThucHien(){
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Them nhan vien");
        System.out.println("2. Sua thong tin nhan vien");
        System.out.println("3. Xoa nhan vien");
        System.out.println("4. Tim kiem nhan vien");
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
                System.out.println("1. Tim kiem theo ma nhan vien");
                System.out.println("2. Tim kiem theo ten nhan vien");
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
    public NHANVIEN MenuSuaNV(NHANVIEN sua){
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
        System.out.println("8. Chuc vu nhan vien");
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
                t=mnv.nextLine();
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
                System.out.println("Chon chuc vu moi cho nhan vien");
                System.out.println("1.Ban hang       2.Thu ngan");
                int tam=0;
                tam=ns.KTChon(tam, 2);
                sua.setChucvu(tam);
                break;
            }
            case 9:{
                System.out.println("Nhap lai tat ca thong tin cua nhan vien:");
                NHANVIEN nvm=new NHANVIEN();
                nvm.nhap();
                sua=nvm;
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
        int len=nv.length;
        System.out.println("Nhap so luong nhan vien can them: ");
        int k=ns.KTNhapSo(1);
        nv=Arrays.copyOf(nv,len + k);
        for (int i=len;i<nv.length;i++){
            System.out.println(nv.length);
            nv[i]=new NHANVIEN();
            System.out.println("Nhan vien duoc them thu "+(i+1));
            nv[i].nhap();
        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA NV","HO TEN","CHUC VU","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<nv.length; i++){
            nv[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
    }
    @Override
    @SuppressWarnings("empty-statement")
    public void Sua(){
        System.out.println("Nhap ma nhan vien ban muon sua:");
        String ma=ns.KTManv();
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
            nv[vt]=MenuSuaNV(nv[vt]);
        System.out.println("Ban da sua thanh cong ");
        Xuat();
        }
        else System.out.println("Khong tim thay ma nhan vien can tim");
        
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma nhan vien ban muon xoa:");
        String ma=ns.KTManv();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa nhan vien nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns.KTYesNo();
                if (yn.matches(regex)) {
                    XoaNV(vt);
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA NV","HO TEN","CHUC VU","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
                    System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    for(int i=0; i<nv.length; i++){
                    nv[i].xuat(); 
                    System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
                    }       
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa nhan vien nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma nhan vien ban can tim"); 
    }
    public void XoaNV(int vt) {
        int len = nv.length;
        nv=Arrays.copyOf(nv,len-1);
	for (int i = vt; i <len-1; i++) {
            nv[i] = nv[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma nhan vien can tim: ");
        String ma =ns.KTManv();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA NV","HO TEN","CHUC VU","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            nv[vt].xuat();
        }
        else{
            System.out.println("Khong tim thay ma nhan vien ban can tim ");
        }
    }
    public void TimKiemHTen(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten nhan vien can tim: ");
        String hoten =ns.KTTen();
        int vt=TimKiemTen(hoten);
        if(vt!=-1){
            System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA NV","HO TEN","CHUC VU","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            nv[vt].xuat();
        }
        else{
            System.out.println("Khong tim thay ten nhan vien ban can tim ");
        }
    }    
    
    public int TimKiemMa(String ma){
        
        for(int i=0; i<nv.length;i++){
            if(nv[i].getManv().compareTo(ma)==0){
                return i;
            }
        }
        return -1;
    }
    public int TimKiemTen(String hoten){
        
        for(int i=0; i<nv.length;i++){
            if(nv[i].getHoten().compareTo(hoten)==0){
                return i;
            }
        }
        return -1;
    }
    public int TimKiemCV(int chucvu){
        
        for(int i=0; i<nv.length;i++){
            if(nv[i].getChucvu()==chucvu){
                return i;
            }
        }
        return -1;
    }
     public int TimKiemGioitinh(int ma){
        
        for(int i=0; i<nv.length;i++){
            if(nv[i].getGioitinh()==ma){
                return i;
            }
        }
        return -1;
    }
     public void ThongketheoGT(){
        
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap gioi tinh khach hang can tim: ");
        System.out.println("1.Nam                     2.Nu");
        int ma=0;
        ma = ns.KTChon(ma, 2);
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA NV","HO TEN","CHUC VU","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i=0;i<nv.length;i++){ 
        int vt=TimKiemGioitinh(ma);
        
        if(vt!=-1){ 
            
                nv[vt].xuat();
                
            
        }   
        }
    }   
     public void ThongketheoCV(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap chuc vu nhan vien can tim: ");
        System.out.println("1.Ban hang                2.Thu ngan");
        int chucvu=0;
        chucvu = ns.KTChon(chucvu, 2);
        int vt=TimKiemCV(chucvu);
        if(vt!=-1){
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA NV","HO TEN","CHUC VU","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for(int i=0; i<nv.length; i++){
                nv[vt].xuat();
             System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            }
        }
    }  
    public void ThongKeSLNV() {
        
            int len = nv.length;
            System.out.printf(" So luong nhan vien la: %d nhan vvien \n",len);
            for(int i=0; i<nv.length; i++){
            nv[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
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
                ThongketheoCV();
                break;
            }
            case 3:{
                ThongKeSLNV();
                break;
            }
        }
    }
    @Override
    public void Xuat(){
       
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-40s%-20s%-20s%-20s%-20s%-20s%-40s%-30s\n","MA NV","HO TEN","CHUC VU","NGAY SINH","GIOI TINH","SO CMND","SO DT","DIA CHI","EMAIL");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<5; i++){
            nv[i].xuat(); 
            System.out.println("\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        }
       
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < nv.length; i++) {
    		nv[i].ghiFile(fileName);
            }
    	}catch(IOException  e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		nv[i] = new NHANVIEN();
    		nv[i].setManv(inp.readUTF());
    		nv[i].setHoten(inp.readUTF());
                nv[i].setChucvu(inp.readInt());
    		nv[i].setNgaysinh(inp.readInt(),inp.readInt(),inp.readInt());
    		nv[i].setGioitinh(inp.readInt());
    		nv[i].setSocmnd(inp.readUTF());
    		nv[i].setSdt(inp.readUTF());
                nv[i].setDiachi(inp.readUTF());
                nv[i].setEmail(inp.readUTF());
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
            docFile("src/nhanvien.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}
