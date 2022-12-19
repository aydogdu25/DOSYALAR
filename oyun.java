import java.util.*;

public class oyun {

public static void main(String[] args) {

		Scanner girdi = new Scanner(System.in);

		String matrisler[][] = new String[3][3];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				matrisler[i][j]= " "; 
			}
		}
		for (int i = 0; i < 9; i++) { 		//Oyun en fazla 9 tur olduğu için 9 sefer çeviriyoruz.
			
			tabloYazdir(matrisler); 
			String oyuncu ="";
			oyuncu = oyuncuAyar(i); 		//Sıra hangi oyuncuda olduğunu belirtir.
			int satir,sutun;
			System.out.print(oyuncu+" Oyuncusu icin satir giriniz (1,2, veya 3) : ");
			satir = girdi.nextInt();
			System.out.print(oyuncu+" Oyuncusu icin sutun giriniz (1,2, veya 3) : ");
			sutun = girdi.nextInt();
			boolean kazanan = false;
			if (satir >= 1 && satir <=3 && sutun >= 1 && sutun <=3) 
			{
				if (matrisler[satir-1][sutun-1].equals(" ")) 
				{
						matrisler[satir-1][sutun-1] = oyuncu;
						kazanan = oyunKontrol(matrisler); 		//Oyunun bitip bitmediğini kontrol eder.
						if (kazanan) 
						{
							tabloYazdir(matrisler);
							System.out.println(oyuncu+" Oyuncusu Kazandi...");
							return;								
						}
				}
				else
				{
					System.out.println("Orasi dolu!, Tekrar deneyin.."); 	//Dolu yere yazinca engeller ve hakkimizdan düşer.
					i--; 
				}
			} 
			else
			{
			System.out.println("Satir veya sutunu yanlis girdiniz!");		//Geçersiz satir veya sütunda hata verir ve hakkimizdan düşer.
			i--;
			}

		}
		System.out.println("OYUN BERABERE..."); 
}
		public static String oyuncuAyar(int i)  //Sırasıyla hakki belirleyen metot. oyuncu değerini geri döndürür.
		{
			String oyuncu;
			if (i % 2 == 1) 
			{
			oyuncu = "O";
			} 
			else 
			{
			oyuncu = "X";
			}
			return oyuncu;
			}
		
		public static boolean oyunKontrol(String[][] matrisler)		
		{
			//sütun kontrolü
			boolean ret = false;
			ret = sutunKontrol(matrisler);
			if (ret) 
			return true;
			//satır kontrolü
			ret = satirKontrol(matrisler);	
			if(ret)
			return true;
			//Köşegen kontrolü
			ret = kosegenKontrol(matrisler);
			if(ret) 
			return true;
			return false;
		}

		public static boolean kosegenKontrol(String[][] matrisler) 
		{
			
			//1. ve 2. köşegenleri kontrol eder.Değerleri bool tipindedir geri döndürür.
			String val00 = matrisler[0][0];
			String val11 = matrisler[1][1];
			String val22 = matrisler[2][2];
			String val02 = matrisler[0][2];
			String val20 = matrisler[2][0];
			if ((!val00.equals(" ")) && val00.equals(val11) && val11.equals(val22))
			{
			return true;
			}

			if ((!val02.equals(" ")) && val02.equals(val11) && val11.equals(val20))
			{
			return true;
			}
			return false;
		}

		public static boolean satirKontrol(String[][] matrisler)
		{
			for (int j = 0; j < 3; j++) { //j. satırdaki değerler eşitse oyunu kazanmıştır.j satirindakileri kontrol eder.
			String satir0 = matrisler[0][j];
			String satir1 = matrisler[1][j];
			String satir2 = matrisler[2][j];
			if ((!satir0.equals(" ")) && satir0.equals(satir1) && satir1.equals(satir2))
			{
			return true;
			}
	
		}
		return false;
		}

		public static boolean sutunKontrol(String[][] matrisler) 
		{

			for (int j = 0; j < 3; j++)					//j. sütundaki değerleri kontrol eder. Değerleri geri döndürür.
			{ 
			String sutun0 = matrisler[j][0];
			String sutun1 = matrisler[j][1];
			String sutun2 = matrisler[j][2];
			if ((!sutun0.equals(" ")) && sutun0.equals(sutun1) && sutun1.equals(sutun2))
			{
			return true;
			}
			}
			return false;
		}

		public static void tabloYazdir(String[][] matrisler)
		{
															//Döngüde kullanılan tabloyu yazdırır.
			for (int i = 0; i < 3; i++) 
			{
				System.out.println("-------------");
				System.out.print("|");
				for (int j = 0; j < 3; j++)					//Satırlar ve sütunlar boşluklara göre oluşturuldu.
				{
					System.out.print(" ");
					System.out.print(matrisler[i][j]);
					System.out.print(" ");
					System.out.print("|");
				}
			System.out.println("");

			}
			System.out.println("-------------");

		}

}