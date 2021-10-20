/*
Yavuz Selim GÜLER
1306160016
Kalp Atışı
 */
package KalpAtisi;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

public class KalpAtisi {
    
    int dt_gun, dt_ay, dt_yil;
    String adi, soyadi;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");  
    LocalDateTime now = LocalDateTime.now();
    String s_yil = dtf.format(now);
    int yil = Integer.parseInt(s_yil);
    
    public KalpAtisi(String k_adi, String k_soyadi, int gun, int ay, int yil){
	
        adi=k_adi;
	soyadi=k_soyadi;
	dt_gun=gun;
	dt_ay=ay;
	dt_yil=yil;
    }
    
    public KalpAtisi(String k_adi, String k_soyadi){
	
        adi=k_adi;
	soyadi=k_soyadi;
    }

    int yasHesapla(){
        
        if(dt_yil==0){
            return 30;}
        else{
            int h_yas = yil - dt_yil;
            return h_yas;}
    }
    
    String idealKalpAtisi(){
        
        int kalpYasi = yasHesapla();
        int maxKalpAtisi = 220;
        float ideal_taban,ideal_tavan;
        ideal_taban = (float) ((maxKalpAtisi - kalpYasi) * 0.5 );
        ideal_tavan = (float) ((maxKalpAtisi - kalpYasi) * 0.85);
        return "Ideal kalp atis araligi dakikada "+ideal_taban+" ile "+ideal_tavan+" arasındadır.";
    }
    
    void setAd(String ad_set){
        adi = ad_set;}
    
    void setSoyad(String soyad_set){
        soyadi = soyad_set;}
    
    void setDogumGunu(int gun_set){
        dt_gun = gun_set;}
    
    void setDogumAyi(int ay_set){
        dt_ay = ay_set;}
    
    void setDogumYili(int yil_set){
        dt_yil = yil_set;}
    
    String getAd(){
        return adi;}
    
    String getSoyad(){
        return soyadi;}
    
    int getDogumGunu(){
        return dt_gun;}
    
    int getDogumAyi(){
        return dt_ay;}
    
    int getDogumYili(){
        return dt_yil;}
    
    public static void main(String[] args) {
        
        Scanner scan= new Scanner(System.in);
        KalpAtisi kisi[];
        kisi = new KalpAtisi[10];
        String main_ad,main_soyad, main_dg, main_da, main_dy;
        
        for(int i=0 ; i<3 ; i++){
            System.out.println("Ad giriniz:");
            main_ad = scan.next();
            System.out.println("Soyad giriniz:");
            main_soyad = scan.next();
            System.out.println("Dogum gununu giriniz:");
            main_dg = scan.next();
            System.out.println("Dogum ayini giriniz:");
            main_da = scan.next();
            System.out.println("Dogum yilini giriniz:");
            main_dy = scan.next();
            
            /*try {int main_dg_int = Integer.parseInt(main_dg);} 
            catch (NumberFormatException e) {
                System.out.println("Girdiginiz gun gecersiz.");
            }*/
            
            int main_dg_int = Integer.parseInt(main_dg);
            int main_da_int = Integer.parseInt(main_da);
            int main_dy_int = Integer.parseInt(main_dy);
            
            if(main_dg_int>31){main_dg_int=0;}
            if(main_da_int>12){main_da_int=0;}
            if(main_dy_int>9999){main_dy_int=0;}
        
            if(main_dg_int==0 || main_da_int==0 || main_dy_int==0){
                kisi[i]=new KalpAtisi(main_ad,main_soyad);
                System.out.println("Dogum tarihi kabul edilemedi. Yas 30 alinacak");}
            else{
                kisi[i]=new KalpAtisi(main_ad, main_soyad, main_dg_int, main_da_int, main_dy_int);}
        }
        
        for(int i=0;i<3;i++){
            System.out.println("---------------Kisi ["+i+"]---------------");
            System.out.println("Adi   : "+kisi[i].adi);
            System.out.println("Soyadi: "+kisi[i].soyadi);
            System.out.println(kisi[i].idealKalpAtisi());
        }
}
}