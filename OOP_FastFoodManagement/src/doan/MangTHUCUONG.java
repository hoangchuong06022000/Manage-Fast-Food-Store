package doan;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
public class MangTHUCUONG implements CHUCNANG_MANG{
    private int n;
    THUCUONG [] tu;
    KiemTra ns1=new KiemTra();
    Scanner sc=new Scanner(System.in);
    
    public MangTHUCUONG() {
       tu=new THUCUONG[4];
       tu[0]=new THUCUONG("ns","Nuoc suoi",5,10000,"16-2-2019");
       tu[1]=new THUCUONG("tx","Tra xanh",7,15000,"28-3-2019");
       tu[2]=new THUCUONG("ps","Pepsi",10,20000,"25-7-2019");
       tu[3]=new THUCUONG("cl","Coca cola",9,20000,"2-1-2019");
    }

    public MangTHUCUONG(int n, THUCUONG[] tu) {
        this.n = n;
        this.tu = new THUCUONG[n];
    }
    public MangTHUCUONG(int n){
        this.n = n;
    	this.tu = new THUCUONG[this.n];
    	for(int i = 0; i < n; i++) {
    		tu[i] = new THUCUONG();
    	}
    }
    public MangTHUCUONG(THUCUONG[] tu) {
    	this.n = tu.length;
    	this.tu = new THUCUONG[this.n];
    	for(int i = 0;i < n; i++) {
    		this.tu[i] = new THUCUONG();
    		this.tu[i] = tu[i];
    	}
    } 
    public THUCUONG[] getTu() {
        return tu;
    } 
    public void setTu(THUCUONG[] tu) {
        this.tu = tu;
    }
    @Override
    public void Nhap()
    {
        System.out.println("Nhap so loai nuoc uong: ");
        n=ns1.KTNhapSo(1);
        tu=new THUCUONG[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Nhap nuoc uong thu: " +(i+1));
            tu[i]=new THUCUONG();
            tu[i].NhapThucUong();
            
        }
    }
    
    @Override
    public void ThucHien(){
        int c;
        System.out.println("Ban muon thuc hien thao tac nao: ");
        System.out.println("1. Them thuc uong");
        System.out.println("2. Sua thong tin thuc uong");
        System.out.println("3. Xoa thuc uong");
        System.out.println("4. Tim kiem thuc uong");
        System.out.println("0. Thoat");
        System.out.println("Nhap lua chon cua ban:");
        c = ns1.KTNhapSo(0);
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
                System.out.println("1. Tim kiem theo ma thuc uong");
                System.out.println("2. Tim kiem theo ten thuc uong");
                System.out.println("0. Quay lai");
                int c1=ns1.KTNhapSo(1);
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
    public THUCUONG MenuSuaTU(THUCUONG sua){
        int c;
        String t = null;
        System.out.println(" Ban muon sua thong tin nao: ");     
        System.out.println("1. Ten thuc uong");
        System.out.println("2. So luong phan nuoc");
        System.out.println("3. Gia thuc uong"); 
        System.out.println("4. Toan bo");
        System.out.println("5. Thoat");
        System.out.println("0. Quay lai");
        System.out.print(" Nhap lua chon cua ban:");
        c = ns1.KTNhapSo(0);
        switch (c) {
            case 0:{
                ThucHien();
            }
            case 1:{
                System.out.println("Nhap ten thuc an moi:");
                t=ns1.KTTen();
                sua.setTenNuoc(t);
                break;
            }
            
            case 2:{
                System.out.println("Nhap so luong phan uong moi:");
                int b=sc.nextInt();
                sua.setSoLuong(b);
                break;
            }
            case 3:{
                System.out.println("Nhap gia thuc uong moi:");
                Double a=sc.nextDouble();
                sua.setGiaNuoc(a);
                break;
            }
            case 4:{
                System.out.println("Nhap lai tat ca thong tin cua thuc uong:");
                THUCUONG tam=new THUCUONG();
                tam.NhapThucUong();
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
        int len=tu.length;
        System.out.println("Nhap so luong thuc uong can them: ");
        int k=ns1.KTNhapSo(1);
        tu=Arrays.copyOf(tu,len + k);
        for (int i=len;i<tu.length;i++){
            tu[i]=new THUCUONG();
            System.out.println("Thuc uong duoc them thu "+(i+1));
            tu[i].NhapThucUong();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA NUOC","TEN NUOC","NGAY XUAT","SO LUONG","GIA NUOC");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<tu.length; i++){
            tu[i].XuatThucUong(); 
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    @Override
    public void Sua(){
        System.out.println("Nhap ma thuc uong ban muon sua:");
        String ma=sc.nextLine();
        int vt;
        if ((vt = TimKiemMa(ma)) != -1) {
                tu[vt]=MenuSuaTU(tu[vt]);
        System.out.println("Ban da sua thanh cong ");
            Xuat();
        }
        else System.out.println("Khong tim thay thuc uong can tim");
    }
    @Override
    public void Xoa(){
        System.out.println("Nhap ma thuc uong ban muon xoa:");
        String ma=sc.nextLine();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.print("Ban thuc su muon xoa thuc uong nay ?? (y or n) ");
            while (true) {
                String regex = "[yY]{1}";
                String yn = ns1.KTYesNo();
                if (yn.matches(regex)) {
                    XoaThucUong(vt);
                    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA NUOC","TEN NUOC","NGAY XUAT","SO LUONG","GIA NUOC");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<tu.length; i++){
            tu[i].XuatThucUong(); 
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        }  
                    System.out.println("Ban da xoa thanh cong.");
                    break;
                } else {
                    System.out.print("Ban da khong xoa thuc uong nay");
                    break;
                }
            }
        } else  System.out.println("Khong tim thay ma thuc uong ban can tim"); 
    }
    public void XoaThucUong(int vt) {
        int len = tu.length;
        tu=Arrays.copyOf(tu,len-1);
	for (int i = vt; i <len-1; i++) {
            tu[i] = tu[i + 1];
	}
	len--;
    }
    @Override
    public void TimKiem(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma thuc uong can tim: ");
        String ma=sc.nextLine();
        int vt=TimKiemMa(ma);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA NUOC","TEN NUOC","NGAY XUAT","SO LUONG","GIA NUOC");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            tu[vt].XuatThucUong();
        }
        else{
            System.out.println("Khong tim thay ma thuc uong ban can tim ");
        }
    }
    public void TimKiemHTen(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ten thuc uong can tim: ");
        String hoten = ns1.KTTen();
        int vt=TimKiemTen(hoten);
        if(vt!=-1){
            System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA NUOC","TEN NUOC","NGAY XUAT","SO LUONG","GIA NUOC");
            System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            tu[vt].XuatThucUong();
        }
        else{
            System.out.println("Khong tim thay ten thuc uong ban can tim ");
        }
    }    
    
    public int TimKiemMa(String ma){
        
        for(int i=0; i<tu.length;i++){
            if(tu[i].getMaNuoc().compareTo(ma)==0){
                return i;
            }
        }
        return -1;
    }
    public int TimKiemTen(String hoten){
        
        for(int i=0; i<tu.length;i++){
            if(tu[i].getTenNuoc().compareTo(hoten)==0){
                return i;
            }
        }
        return -1;
    }
    public double TongTienTU(){
        double tong=0,tinh;
        for(int i=0;i<tu.length;i++){
            
            tinh=tu[i].TinhTienTU();
            tong+=tinh;
        }
        return tong;
    }
    public void thongKeTuGiaDenGia() {
    	
    	boolean isEmpty = true;
    	float giaTu;
    	float giaDen;
    	System.out.println("Thong ke thuc uong tu gia den gia");
        System.out.println("Moi ban nhap: ");
    	System.out.print(" .Tu gia: ");
    	giaTu = sc.nextFloat();
    	
    	System.out.print(" .Den gia: ");
    	giaDen = sc.nextFloat();
    	
    	System.out.println("Cac thuc uong co gia nam trong khoang " + giaTu + " va " + giaDen + " la: \n");
    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA NUOC","TEN NUOC","NGAY XUAT RA BAN","SO LUONG","GIA NUOC");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    	sc.nextLine();
    	
    	for(int i = 0; i < tu.length; i++) {
    		if(tu[i].getGiaNuoc()>= giaTu && tu[i].getGiaNuoc()<= giaDen) {
    			isEmpty = false;
    			tu[i].XuatThucUong();
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
    	System.out.println("Nhap vao so luong co toi thieu cua thuc uong ma ban mong muon: ");
    	int slYeuCau;
    	slYeuCau = sc.nextInt();
    	sc.nextLine();
    	System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA NUOC","TEN NUOC","NGAY XUAT RA BAN","SO LUONG","GIA NUOC");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
    	for(int i = 0; i < tu.length; i++) {
    		if(tu[i].getSoLuong()>= slYeuCau) {
    			isEmpty = false;
    			tu[i].XuatThucUong();
                        System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
    		}
    	}
    	
    	if(isEmpty == true) {
    		System.out.println("!!!Khong co thuc uong nao dap ung du so luong ma ban yeu cau!!!\n");
    	}
    }
   
    @Override
    public void Xuat(){
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s%-40s%-40s%-20s%-20s\n","MA NUOC","TEN NUOC","NGAY XUAT","SO LUONG","GIA NUOC");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------");
        for(int i=0; i<4; i++){
            tu[i].XuatThucUong(); 
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------");
        }  
    }
    public void ghiFile(String fileName)throws IOException{
    	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName))) {
            for(int i = 0; i < tu.length; i++) {
    		tu[i].ghiFile(fileName);
            }
    	}catch(IOException e) {}
    }
    public void docFile(String fileName)throws IOException {
    	DataInputStream inp = null;
    	int i = 0;
    	try {
            inp = new DataInputStream(new FileInputStream(fileName));
            while(true) {
    		tu[i] = new THUCUONG();
    		tu[i].setMaNuoc(inp.readUTF());
    		tu[i].setTenNuoc(inp.readUTF());
                tu[i].setNgayXuat(inp.readInt(), inp.readInt(), inp.readInt());
                tu[i].setSoLuong(inp.readInt());
                tu[i].setGiaNuoc(inp.readDouble());
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
            docFile("src/thucuong.txt");
            Xuat();
        }catch(EOFException e){
            
        }
    }
}