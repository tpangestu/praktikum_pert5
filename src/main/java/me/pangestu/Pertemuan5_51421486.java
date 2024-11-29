/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package me.pangestu;


import me.pangestu.controller.MahsiswaController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * @author tri pangestu
 */

@SpringBootApplication
public class Pertemuan5_51421486 implements CommandLineRunner{
    
    @Autowired
    private MahsiswaController mhsController;
    
    public static void main(String[] args) {
        SpringApplication.run(Pertemuan5_51421486.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception{
        mhsController.TampilkanMenu();
    }
}