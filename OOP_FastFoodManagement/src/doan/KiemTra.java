
package doan;

import java.io.IOException;
import java.util.Scanner;


public class KiemTra {
    Scanner sc=new Scanner(System.in);
    static String ma="nv";
    static String ma1="kh";
    static String ma2="ncc";
    public KiemTra() {
    }
    
    public String KTGioitinh(int gt){
        if (gt == 1)    return "Nam";
        return "Nu";
    }
    public String KTChucvu(int cv){
        if (cv == 1)    return "Ban hang";
	return "Thu ngan";
    }
    public String KTLoaikh(int lkh){
        if (lkh == 1)    return "VIP";
	return "Thuong";
    }
    public String KTYesNo(){
        String regex="[yn]{1}",s;
        while(true){
            s=sc.nextLine();
            boolean test;
            if ((test = s.matches(regex)) == true)
		break;
            else
                System.out.print("Ki tu nhap khong hop le!! Nhap lai");
	}
	return s;
    }
    public int KTNhapSo(int x) {
	int so = 0;
	while (true) {
            try {
		so = (int) Double.parseDouble(sc.nextLine());
		if (so >= x)
                    break;
		else
                    System.out.print("So nhap vao khong dc am!! Vui long nhap lai\n");
            } catch (NumberFormatException e) {
		System.out.print("Chi duoc nhap so!! Nhap lai\n");
            }
	}
	return so;
    }
    public int KTChon(int Chon,int x) {
        while (true) {
            Chon=KTNhapSo(0);
            if(Chon<=x && Chon>0)
                break;
            else{
                System.out.println("Lua chon sai! Vui long nhap lai\n");                                       
            }
        }
        return Chon;
    }
    public String KTTen(){
        String hoten;
        String regex="[^0-9]{10,40}";
        while (true){
            hoten=sc.nextLine();
            if(hoten != null &&hoten.matches(regex)==true)
                break;
            else{
                System.err.println("Nhap sai!! Moi ban nhap lai ho ten");
            }       
        }
        return hoten;
    } 
    public String KTSdt(){
        String sdt;
        String regex="0[0-9]{9}";
        while(true){
            sdt=sc.nextLine();
            if(sdt != null && sdt.length()==10 &&sdt.matches(regex)==true)
                break;
            else{
                System.err.println("Nhap sai!! Moi ban nhap lai so dien thoai");
            }
        }
        return sdt;
    }
    public String KTSocmnd(){
        String socmnd;
        String regex="[0-9]{9}";
        while(true){
            socmnd=sc.nextLine();
            if(socmnd != null && socmnd.length()==9 &&socmnd.matches(regex)==true)
                break;
            else{
                System.err.println("Nhap sai!! Moi ban nhap lai so dien thoai");
            }
        }
        return socmnd;
    }
    public String KTEmail(){
        String email;
        String regex ="[a-zA-Z0-9]+@gmail.com$";
        while(true){
            email=sc.nextLine();
            if(email != null && email.matches(regex)==true && !email.contains(" "))
                break;
            else{
                System.err.println("Nhap sai!! Moi ban nhap lai dia chi email");
            }
        }
        return email;
    }
    public String KTManv(){
        String manv;
        String regex=ma+"[0-9]{3}";
        while(true){
            manv=sc.nextLine();
            if(manv != null &&manv.matches(regex)==true)
                break;
            else{
                System.err.println("Nhap sai!! Moi ban nhap lai ma nhan vien");           
            }
        }
        return manv;
    }
    public String KTMakh(){
        String makh;
        String regex=ma1+"[0-9]{3}";
        while(true){
            makh=sc.nextLine();
            if(makh != null &&makh.matches(regex)==true)
                break;
            else{
                System.err.println("Nhap sai!! Moi ban nhap lai ma khach hang");
            }
        }
        return makh;
    }
    public String KTMancc(){
        String mancc;
        String regex=ma2+"[0-9]{3}";
        while(true){
            mancc=sc.nextLine();
            if(mancc != null &&mancc.matches(regex)==true)
                break;
            else    System.err.println("Nhap sai!! Moi ban nhap lai ma nha cung cap");
        }
        return mancc;
    }
    public boolean KTAdmin() throws IOException{
        MangTK ad=new MangTK();
        ad.docFile("src/taikhoan.txt");
        String tk,mk;
        String tamtk="admin1";
        String tammk="admin123";
        while(true){
            try{
                System.out.println("Nhap tai khoan:");
                tk=sc.nextLine();
                System.out.println("Nhap mat khau:");
                mk=sc.nextLine();
                int vt=ad.TimKiemTK(tk);
                if(vt!=-1 && tk.equals(tamtk) && mk.equals(tammk)){
                    break;
                }
            }catch(NullPointerException e){
                System.out.println("Tai khoan admin ban nhap khong ton tai!! Nhap lai");
            }   
        }
        return true;
    }
    public boolean KTUser() throws IOException{
        MangTK user=new MangTK();
        user.docFile("src/taikhoan.txt");
        String tk,mk;
        String tamtk="admin1";
        String tammk="admin123";
        while(true){
            try{
                System.out.println("Nhap tai khoan:");
                tk=sc.nextLine();
                System.out.println("Nhap mat khau:");
                mk=sc.nextLine();
                int vt=user.TimKiemTK(tk);
                if(vt!=-1 && tk.compareTo(tamtk)!=0 && mk.compareTo(tammk)!=0){
                    break;
                }
            }catch(NullPointerException e){
                System.out.println("Tai khoan user ban nhap khong ton tai!! Nhap lai");
            }   
        }
        return true;
    }
    
}
