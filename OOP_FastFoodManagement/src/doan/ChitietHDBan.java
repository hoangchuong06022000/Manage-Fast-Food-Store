
package doan;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ChitietHDBan extends HOADON{
    Scanner cthd=new Scanner(System.in);
    MangTHUCAN ta1=new MangTHUCAN();
    MangTHUCUONG tu1=new MangTHUCUONG();
    public ChitietHDBan() {
        super();
    }
    public ChitietHDBan(int mahd,double TongTien) {
        super(mahd,TongTien);
    }
    
    @Override
    public void nhapHD() throws Exception{
        MangKH kh=new MangKH();
        kh.docFile("src/khachhang.txt");
        super.nhapHD();
        System.out.println("Nhap vao ma khach hang( VD:kh___(sau kh la 3 ki tu so)):");
        while(true){
            try{
                t1=kt.KTMakh();
                int vt=kh.TimKiemMa(t1);
                if(vt!=-1){
                    break;
                }
            }catch(NullPointerException e){
                System.out.println("Khach hang khong ton tai!! Nhap lai");
            }
        }
        ta1.Nhap();
        System.out.println("---------------------------------------------");
        tu1.Nhap();
    }
    @Override
    public void xuatHD(){
        long millis=System.currentTimeMillis();  
        java.util.Date date=new java.util.Date(millis);   
        System.out.println("---------------------------------------------");
        ta1.Xuat();
        System.out.println("---------------------------------------------");
        tu1.Xuat();
        System.out.println("---------------------------------------------");
        System.out.println("Ngay xuat hoa don: "+date);
        TongTien=ta1.TongTienTA()+tu1.TongTienTU();
        super.xuatHD();
    }
    @Override
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeInt(mahd);
            out.writeUTF(t);
            out.writeUTF(t1);
            out.writeDouble(TongTien);
	}catch(IOException e) {}
    }  
    
}
