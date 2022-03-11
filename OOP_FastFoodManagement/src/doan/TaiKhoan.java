/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Netpham1970
 */
public class TaiKhoan {
    private String user, pass;
    Scanner sc = new Scanner(System.in);
    KiemTra kt = new KiemTra();

    public TaiKhoan() {
    }

    public TaiKhoan(String user, String pass) {
        this.user = user;
        this.pass = pass;
       
    }

    
    public String getUser() {
        return user;
    }

   
    public void setUser(String user) {
        this.user = user;
    }

   
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    
    
    public void nhap(){
	System.out.print("Ten tai khoan :  ");
	user=sc.nextLine();
        System.out.print("Mat khau:  ");
	pass = sc.nextLine();
    }
    public void xuat() {
	System.out.printf("%-20s%-20s\n", user, pass);	
    }
    public void ghiFile(String fileName)throws IOException {
	try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName, Boolean.TRUE))) {
            out.writeUTF(user);
            out.writeUTF(pass);
	}catch(IOException e) {}
    }  
}
