/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doan;

import java.io.*;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author Netpham1970
 */
public class Menu {
    static KiemTra kt=new KiemTra();
     /*===========MENU DangNhap===========*/
    public static void MenuDangNhap() throws Exception{
            Scanner sc = new Scanner(System.in);
            int c;
            System.out.println("+--------------------------------------------+");
            System.out.println("|               MENU DANG NHAP               |");
            System.out.println("+============================================+");
            System.out.println("| 1.  Dang nhap Admin                        |");
            System.out.println("| 2.  Dang nhap User                         |");
            System.out.println("| 3.  Dang ki User                           |");
            System.out.println("| 0.  Thoat                                  |");
            System.out.println("+--------------------------------------------+");
            c = kt.KTNhapSo(0);
            switch(c) {
                case 0:{
                    System.out.println("\n!!!CAM ON VA HEN GAP LAI!!!\n");
                    break;
                }
                case 1:{
                    kt.KTAdmin();
                    System.out.println("Chao Admin");
                    MenuAdmin();
                    break;
                }
                case 2:{
                    kt.KTUser();
                    System.out.println("Chao User");
                    MenuUser();
                    break;
                }
                case 3:{
                    MangTK tkm=new MangTK();
                    String tk="src/taikhoan.txt";
                    tkm.Them();
                    tkm.ghiFile(tk);
                    MenuDangNhap();
                    break;
                }
                default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
            }      
    }		
    
    /*===========MENU ADMIN===========*/
    public static void MenuAdmin() throws Exception{
            Scanner sc = new Scanner(System.in);
            int c;
            System.out.println("+--------------------------------------------+");
            System.out.println("|                  MENU ADMIN                |");
            System.out.println("+============================================+");
            System.out.println("| 1.  Quan ly san pham                       |");
            System.out.println("| 2.  Quan ly khach hang                     |");
            System.out.println("| 3.  Quan ly nhan vien                      |");
            System.out.println("| 4.  Quan ly hoa don                        |");
            System.out.println("| 5.  Quan ly nha cung cap                   |");
            System.out.println("| 6.  Quan ly tai khoan                      |");
            System.out.println("| 7.  Quay lai                               |");
            System.out.println("| 0.  Thoat                                  |");
            System.out.println("+--------------------------------------------+");
            c = kt.KTNhapSo(0);
            switch(c) {
                case 0:{
                    System.out.println("\n!!!CAM ON VA HEN GAP LAI!!!\n");
                    break;
                }

                case 1:{
                    MenuSanPham();
                    break;
                }
                case 2:{
                    MangKH kh=new MangKH();
                    kh.Xuat();
                    kh.ThucHien();
                    break;
                }
                case 3:{
                    MangNV nv=new MangNV();
                    nv.Xuat();
                    nv.ThucHien();
                    break;
                }
                case 4:{
                    MenuHoadon();
                    break;
                }
                case 5:{
                    MangNCC ncc=new MangNCC();
                    ncc.Xuat();
                    ncc.ThucHien();
                    break;
                }   
                case 6:{
                    MangTK tk=new MangTK();
                    tk.Xuat();
                    tk.ThucHien();
                    break;
                }
                case 7:{
                    MenuDangNhap();
                    break;
                }
                default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
            }
        }		
    
    /*===========MENU User===========*/
    public static void MenuUser() throws Exception{
            Scanner sc = new Scanner(System.in);
            int c;
            System.out.println("+--------------------------------------------+");
            System.out.println("|                  MENU USER                 |");
            System.out.println("+============================================+");
            System.out.println("| 1.  Quan ly khach hang                     |");
            System.out.println("| 2.  Quan ly hoa don                        |");
            System.out.println("| 3.  Quay lai                               |");
            System.out.println("| 0.  Thoat                                  |");
            System.out.println("+--------------------------------------------+");
            c = kt.KTNhapSo(0);
            switch(c) {
                case 0:{
                    System.out.println("\n!!!CAM ON VA HEN GAP LAI!!!\n");
                    break;
                }

                case 1:{
                    MangKH kh=new MangKH();
                    kh.Xuat();
                    kh.ThucHien();
                    break;
                }
                case 2:{
                    MenuHoadon();
                    break;
                }
                case 3:{
                    MenuDangNhap();
                    break;
                }
                default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
            }		
    }
    /*===========MENU SAN PHAM===========*/
    public static void MenuSanPham() throws IOException, Exception {
            Scanner in = new Scanner(System.in);
            int c;
            System.out.println("+--------------------------------------------+");
            System.out.println("|                 MENU SAN PHAM              |");
            System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            System.out.println("| 1.  Quan ly thuc an                        |");
            System.out.println("| 2.  Quan ly thuc uong                      |");
            System.out.println("| 3.  Quan ly hang                           |");
            System.out.println("| 4.  Thong ke thuc an                       |");
            System.out.println("| 5.  Thong ke nuoc uong                       |");
            System.out.println("| 6.  Quay lai                               |");
            System.out.println("| 0.  Thoat                                  |");
            System.out.println("+--------------------------------------------+");
            c = kt.KTNhapSo(0);
            MangTHUCAN d=new MangTHUCAN();
            MangTHUCUONG e=new MangTHUCUONG();
            MangHang f=new MangHang();
            switch(c) {
                case 0:{
                    System.out.println("\n!!!CAM ON VA HEN GAP LAI!!!\n");
                    break;
                }

                case 1:{
                    d.Xuat();
                    d.ThucHien();
                    
                    break;
                }
                case 2:{
                    e.Xuat();
                    e.ThucHien();
                    break;
                }
                case 3:{
                    f.Xuat();
                    f.ThucHien();
                    break;
                }
                case 4:{
                    System.out.println("Chon thao tac:");
                    System.out.println("1.Thong ke so luong thuc an");
                    System.out.println("2.Thong ke gia thuc an");
                    System.out.println("0.Thoat");
                    int c1=kt.KTNhapSo(0);
                    switch(c1){
                        case 0:{
                            System.out.println("Ban da thoat");
                            break;
                        }
                        case 1:{
                            d.Xuat();
                            d.thongKeSluongCo();
                            break;
                        }
                        case 2:{
                            d.Xuat();
                            d.thongKeTuGiaDenGia();
                            break;
                        }
                    }
                    break;
                }
                case 5:{
                    System.out.println("Chon thao tac:");
                    System.out.println("1.Thong ke so luong nuoc uong");
                    System.out.println("2.Thong ke gia nuoc uong");
                    System.out.println("0. Thoat");
                    int c1=kt.KTNhapSo(0);
                    switch(c1){
                        case 0:{
                            System.out.println("Ban da thoat");
                            break;
                        }
                        case 1:{
                            e.Xuat();
                            e.thongKeSluongCo();
                            break;
                        }
                        case 2:{
                            e.Xuat();
                            e.thongKeTuGiaDenGia();
                            break;
                        }
                    }
                    break;
                }
                case 6:{
                    MenuAdmin();
                    break;
                }
                default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
            }
    }            
    
    /*===========MENU HOA DON===========*/
    public static void MenuHoadon() throws IOException {
            Scanner in = new Scanner(System.in);
            int c;
            System.out.println("+--------------------------------------------+");
            System.out.println("|                 MENU HOA DON               |");
            System.out.println("+-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=+");
            System.out.println("| 1.  Quan ly hoa don ban hang               |");
            System.out.println("| 2.  Quan ly hoa don nhap hang              |");
            System.out.println("| 0.  Thoat                                  |");
            System.out.println("+--------------------------------------------+");
            c = kt.KTNhapSo(0);
            MangCTHDBan ban=new MangCTHDBan();
            MangHDN nhap=new MangHDN();
            switch(c) {
                case 0:{
                    System.out.println("\n!!!CAM ON VA HEN GAP LAI!!!\n");
                    break;
                }

                case 1:{
                    ban.Xuat();
                    ban.ThucHien();
                    
                    break;
                }
                case 2:{
                   nhap.Xuat();
                    nhap.ThucHien();
                    
                    break;
                }
                default: System.out.println("Muc ban chon khong co trong danh sach xin moi chon lai!!!");
            }
    }            
}
