/**
* @author Ahmet Furkan Söðütcü / 1-A / ahmet.sogutcu@ogr.sakarya.edu.tr
* @since 23.03.2022 - 01.04.2022
* <p>
* Bu Class'ta try-catch yapýsý, dosya tanýmlama, regexler, nesne tanýmlamalarý ve istenilen çýktýlarý veren ifadeler var.
* </p>
*/
package odev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
	// Program için gerekli kütüphaneler

public class Program {

	public static void main(String[] args) {
				
		try {
			Scanner scanner = new Scanner(new BufferedReader(new FileReader( args[0] )));
				// Dosyayý parametre olarak alma iþlemleri	(raporda ayrýntýlý açýklandý)
			String javaFile = "";
				// Okutulacak dosya ismi belirleyip string olarak tanýmlama
			
			Lexical unary = new Lexical();
			Lexical binary = new Lexical();
			Lexical relational = new Lexical();
			Lexical logical = new Lexical();
			Lexical arithmetic = new Lexical();
			Lexical operanD = new Lexical();
				// Lexical sýnýfýndan obje(nesne) oluþturma iþlemleri
			
			int unaryOp = 0;
			unary.setUnaryOp(unaryOp);
			int binaryOp = 0;
			binary.setBinaryOp(binaryOp);
			int relationalOp = 0;
			relational.setRelationalOp(relationalOp);
			int logicalOp = 0;
			logical.setLogicalOp(logicalOp);
				// Oluþturulan objeleri set ifadesi ile tanýmlama 
						
			while(scanner.hasNextLine()) {	//Dosya her bir satýra sahip oldukça döngü devam edecek.
				javaFile = javaFile.concat(scanner.nextLine() + "\n");	
					// satýr satýr okutup tüm satýrlarý tek stringe atama gerçekleþiyor.

			}
			
			javaFile = javaFile.replaceAll("(\\/\\/[^\\n\\r]+?(?:\\*\\)|[\\n\\r]))|(\\/\\*(?:[^\\*]|\\**[^\\*\\/])*\\*+\\/)","");
				// Burada yorum satýrlarý regex ile bulunup yerine boþluk atanýyor.
			javaFile = javaFile.replaceAll("<(.*>)","");
				// Arraylistler'de kullanýlan < ve > iþaretlerini ortadan kaldýrmak için kullanýldý.
			
			Pattern unaryP = Pattern.compile("([\\+]|[-]){2,3}");   
				// Tekli operatör regexi
			Pattern binaryP = Pattern.compile("\\*|\\/|%|\\^|(?<!\\+)\\+(?!\\+)|(?<!-)-(?!-)|(?<!&)&(?!&)|(?<!\\|)\\|(?!\\|)|(?<!=|<|>|!|-|\\+|\\||\\*|\\/|%|\\^|&)=(?!=)|(?<!\\.)\\*(?!\\.|;)");	
				// Ýkili operatör regexi
			Pattern relationalP = Pattern.compile("<|>|[?<!\\!|=|<|>][\\=?!\\=]");	
				// Ýliþkisel operatör regexi
			Pattern logicalP = Pattern.compile("([\\|]{2})|([&]{2})|(!(?=[^=]))");
				// Mantýksal operatör regexi

			Matcher unaryM = unaryP.matcher(javaFile);
				// fileContent dosyasý içerisinde unaryP regexi ile eþleþen ifadeler
			Matcher binaryM = binaryP.matcher(javaFile);
				// fileContent dosyasý içerisinde binaryP regexi ile eþleþen ifadeler
			Matcher relationalM = relationalP.matcher(javaFile);
				// fileContent dosyasý içerisinde relationalP regexi ile eþleþen ifadeler
			Matcher logicalM = logicalP.matcher(javaFile);
				// fileContent dosyasý içerisinde logicalP regexi ile eþleþen ifadeler

			while (unaryM.find()) {	   // Operatörler her bulunduðunda operatör sayýsý 1 arttýrýlýyor.
				unaryOp++;
//				System.out.println(tekliM.start() + "..." + tekliM.end() + "..." + tekliM.group());
					// isteðe göre tekli operatörlerin yeri ve kendisi görüntülenebilir
			}
			while(binaryM.find()) {
				binaryOp++;
//				System.out.println(ikiliM.start() + "..." + ikiliM.end() + "..." + ikiliM.group());
					// isteðe göre ikili operatörlerin yeri ve kendisi görüntülenebilir
			}			
			while (relationalM.find()) {
				relationalOp++;
//				System.out.println(relationalM.start() + "..." + relationalM.end() + "..." + relationalM.group());	            
					// isteðe göre iliþkisel operatörlerin yeri ve kendisi görüntülenebilir
			}
			while (logicalM.find()) {
				logicalOp++;
//				System.out.println(logicalM.start() + "..." + logicalM.end() + "..." + logicalM.group());
					// isteðe göre mantýksal operatörlerin yeri ve kendisi görüntülenebilir
			}
						
			int arithmeticOp = unaryOp + binaryOp;
			arithmetic.setArithmeticOp(arithmeticOp);
			int operand = unaryOp + binaryOp*2 + relationalOp*2 + logicalOp*2;
			operanD.setOperand(operand);
				// Oluþturulan objeleri set ifadesi ile tanýmlama
			
			System.out.println("Operatör Bilgisi:");
			System.out.println("	Tekli Operatör Sayýsý: " + unaryOp);
			System.out.println("	Ýkili Operatör Sayýsý: " + binaryOp);
			System.out.println("	Sayýsal Operatör Sayýsý: " + arithmeticOp);
			System.out.println("	Ýliþkisel Operatör Sayýsý: " + relationalOp);
			System.out.println("	Mantýksal Operatör Sayýsý: " + logicalOp);
			System.out.println("Operand Bilgisi: ");
			System.out.println("	Toplam Operand Sayýsý: " + operand);
				// Ekrana istenilen þekilde çýktý veriliyor
			
//			System.out.print(fileContent);
				// Dosyadaki yorum satýrlarýnýn tam silinip silinmediðini dosyayý yazdýrarak test etme
		}
		catch(FileNotFoundException FileNotFound) {    // Dosya bulunamadýðý zaman catch bloðuna geçiliyor. 
			FileNotFound.printStackTrace();
			System.out.print(" We couldn't find the file :( ");
				// Hatanýn olduðuna dair bir çýktý
		}
	}
}


