
package doan;
import java.util.Scanner;

public class NgayThangNam {
    Scanner ntn=new Scanner(System.in);
    int ngay;
    int thang;
    int nam;
    KiemTra ns=new KiemTra();
    public NgayThangNam() {
    }

    public NgayThangNam(int ngay, int thang, int nam) {
        this.ngay = ngay;
        this.thang = thang;
        this.nam = nam;
    }
    public boolean setNgay(int ngay) {
        if(ngay>0 && ngay<=31){
            this.ngay=ngay;
            return true;
        }else{
            System.err.println("Nhap sai!! Moi ban nhap lai ngay");
            return false;
        }
    }
    public boolean setThang(int thang) {
        if(thang>0 && thang<=12){
            this.thang=thang;
            return true;
        }else{
            System.err.println("Nhap sai!! Moi ban nhap lai thang");
            return false;
        }
    }
    public boolean setNam(int nam) {
        if(nam>=1980 && nam<2020){
            this.nam=nam;
            return true;
        }else{
            System.err.println("Nhap sai!! Moi ban nhap lai nam");
            return false;
        }
    }
    @SuppressWarnings("empty-statement")
    public void nhap(){
        System.out.println("Nhap ngay:");
        while(!setNgay(ns.KTNhapSo(1)));
        System.out.println("Nhap thang:");
        while(!setThang(ns.KTNhapSo(1)));
        System.out.println("Nhap nam ( <=1980 && >2020 ):");
        while(!setNam(ns.KTNhapSo(1)));
    }
    public int getNgay() {
        return ngay;
    }

    
    public int getThang() {
        return thang;
    }

   
    public int getNam() {
        return nam;
    }
}
