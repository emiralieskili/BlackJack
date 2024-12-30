package blackjack;
import java.util.Scanner;
import java.util.Random;
public class BlackJack {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Random random=new Random();
        String[] kartlar={"2","3","4","5","6","7","8","9","10","joker","papaz","kiz","as"};
        int[] kartsayilari={2,3,4,5,6,7,8,9,10,10,10,10};
        int kartsayi=0,rastgeleindeks,kumarbaztoplam=0,kurpiyertoplam=0;
        String durum="",kartdeger; 
        boolean atla=false;
        while(true){
            //kumarbaz kısmı
            while(!durum.equalsIgnoreCase("kal")){
                rastgeleindeks=random.nextInt(kartlar.length);
                kartdeger=kartlar[rastgeleindeks];
                if(rastgeleindeks<12){
                    kartsayi=kartsayilari[rastgeleindeks];
                }
                else{
                    if(11+kumarbaztoplam>21){
                        System.out.println("AS GELDI. DEGERI OTOMATIK OLARAK 1 ALINDI.");
                        kartsayi=1;
                    }
                    else if(11+kumarbaztoplam==21){
                        System.out.println("AS GELDI. DEGERI OTOMATIK OLARAK 11 ALINDI.");
                    }
                    else{
                        System.out.println("AS GELDI. DEGERI KAC OLSUN?");
                        kartsayi=input.nextInt();
                        while(kartsayi!=1&&kartsayi!=11){
                            System.out.println("LUTFEN GECERLI BIR DEGER GIRINIZ.");
                            kartsayi=input.nextInt();
                        }
                    }
                }
                System.out.println("Gelen kart: "+kartdeger);
                kumarbaztoplam+=kartsayi;
                System.out.println("Kumarbaz: "+kumarbaztoplam);
                if(kumarbaztoplam==21){
                    System.out.println("21 ACTINIZ, KAZANDINIZ");
                    atla=true;
                    break;
                }
                else if(kumarbaztoplam>21){
                    System.out.println("21'I GECTINIZ, KAYBETTINIZ");
                    atla=true;
                    break;
                }
                System.out.println("Kal/Cek");
                durum=input.nextLine();
                while(!durum.equalsIgnoreCase("kal")&&!durum.equalsIgnoreCase("cek")){
                    System.out.println("LUTFEN GECERLI BIR SECIM YAPINIZ.");
                    System.out.println("Kal/Cek");
                    durum=input.nextLine();
                }  
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    System.out.println("Bekleme sirasinda hata oluştu.");
                }
            }
            if(atla==false){
                //kurpiyer kısmı
                while(kurpiyertoplam<=kumarbaztoplam&&kurpiyertoplam<=17){
                    rastgeleindeks=random.nextInt(kartlar.length);
                    kartdeger=kartlar[rastgeleindeks];
                    if(rastgeleindeks<12){
                        kartsayi=kartsayilari[rastgeleindeks];
                    }
                    else{
                            if(11+kurpiyertoplam<22){
                                kartsayi=11;
                            }
                            else{
                                kartsayi=1;
                            }
                    }
                    System.out.println("Kurpiyere gelen kart: "+kartdeger);
                    kurpiyertoplam+=kartsayi;
                    System.out.println("Kurpiyer: "+kurpiyertoplam);
                    if(kurpiyertoplam>21){
                        System.out.println("KURPIYER PATLADI,KAZANDINIZ");
                        break;
                    }
                    if(kurpiyertoplam==kumarbaztoplam&&kurpiyertoplam>=17){
                        System.out.println("BERABERE");
                        break;
                    }
                    if(kurpiyertoplam>kumarbaztoplam){
                        System.out.println("KURPIYER SIZDEN YUKSEK ACTI, KAYBETTINIZ");
                        break;
                    }
                    if(kurpiyertoplam>=17&&kurpiyertoplam<kumarbaztoplam){
                        System.out.println("KURPIYER SIZDEN DUSUK ACTI, KAZANDINIZ.");
                        break;
                    }
                    try {
                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    System.out.println("Bekleme sirasinda hata olustu.");
                    }
                }
            }
            kumarbaztoplam=0;
            kurpiyertoplam=0;
            durum="";
            atla=false;
            System.out.println("CIKMAK ICIN X'E, TEKRAR OYNAMAK ICIN HERHANGI BIR TUSA BASINIZ.");
            durum=input.nextLine();
            if(durum.equalsIgnoreCase("x")){
                break;
            }
            
        }
    }
}