/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.pangestu.controller;


import me.pangestu.model.ModelMahasiswa;
import me.pangestu.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Scanner;
/**
 *
 * @author tri pangestu
 */

@Controller
public class MahsiswaController {
   
    @Autowired
    private MahasiswaRepository mahasiswaRepository;
    
    public void TampilkanMenu() {
        Scanner scanner = new Scanner(System.in);
        int opsi;
        
        do{
            System.out.println("\nMenu : ");
            System.out.println("1.Tampilkan semua mahasiswa");
            System.out.println("2. tambah mahasiswa");
            System.out.println("3. cek koneksi database");
            System.out.println("4. keluar");
            System.out.println("pilih opsi :");
            opsi = scanner.nextInt();
            scanner.nextLine();
            
            switch (opsi) {
                case 1: 
                    tampilkanSemuaMahasiswa();
                    break;
                case 2: 
                    tambahMahasiswa(scanner);
                    break;
                case 3: 
                    cekKoneksi();
                    break;
                case 4:
                    System.out.println("keluar dari program");
                    break;
                default:
                    System.out.println("Opsi tidak valid");
            }
        }while (opsi !=4);
    }
    private void tampilkanSemuaMahasiswa() {
        List<ModelMahasiswa> mahasiswaList = mahasiswaRepository.findAll();
        if (mahasiswaList.isEmpty()) {
            System.out.println("tidak ada data");
        }else {
            mahasiswaList.forEach(mahasiswa -> System.out.println(mahasiswa));
        }
    }
    
    private void tambahMahasiswa (Scanner scanner) {
        System.out.println("Masukkan NPM: ");
        String npm = scanner.nextLine();
         System.out.println("Masukkan Nama: ");
        String nama = scanner.nextLine();
         System.out.println("Masukkan Semester: ");
        int semester = scanner.nextInt();
         System.out.println("Masukkan IPK: ");
        float ipk = scanner.nextFloat();
        
        ModelMahasiswa mahasiswa = new ModelMahasiswa(0, npm, nama, semester, ipk);
        mahasiswaRepository.save(mahasiswa);
        System.out.println("Mahasiswa Berhasil ditambahkan");
    }
    
    private void cekKoneksi() {
        try {
            mahasiswaRepository.findAll();
            System.out.println("KOneksi berhasil");
        } catch (Exception e) {
            System.out.println("gagal terhubung");
        }
    }
    
    
}
