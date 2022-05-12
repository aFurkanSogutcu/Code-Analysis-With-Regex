/**
* @author Ahmet Furkan S���tc� / 1-A / ahmet.sogutcu@ogr.sakarya.edu.tr
* @since 23.03.2022 - 01.04.2022
* <p>
* Bu Class'ta try-catch yap�s�, dosya tan�mlama, regexler, nesne tan�mlamalar� ve istenilen ��kt�lar� veren ifadeler var.
* </p>
*/
package odev;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
	// Program i�in gerekli k�t�phaneler

public class Program {

	public static void main(String[] args) {
				
		try {
			Scanner scanner = new Scanner(new BufferedReader(new FileReader( args[0] )));
				// Dosyay� parametre olarak alma i�lemleri	(raporda ayr�nt�l� a��kland�)
			String javaFile = "";
				// Okutulacak dosya ismi belirleyip string olarak tan�mlama
			
			Lexical unary = new Lexical();
			Lexical binary = new Lexical();
			Lexical relational = new Lexical();
			Lexical logical = new Lexical();
			Lexical arithmetic = new Lexical();
			Lexical operanD = new Lexical();
				// Lexical s�n�f�ndan obje(nesne) olu�turma i�lemleri
			
			int unaryOp = 0;
			unary.setUnaryOp(unaryOp);
			int binaryOp = 0;
			binary.setBinaryOp(binaryOp);
			int relationalOp = 0;
			relational.setRelationalOp(relationalOp);
			int logicalOp = 0;
			logical.setLogicalOp(logicalOp);
				// Olu�turulan objeleri set ifadesi ile tan�mlama 
						
			while(scanner.hasNextLine()) {	//Dosya her bir sat�ra sahip olduk�a d�ng� devam edecek.
				javaFile = javaFile.concat(scanner.nextLine() + "\n");	
					// sat�r sat�r okutup t�m sat�rlar� tek stringe atama ger�ekle�iyor.

			}
			
			javaFile = javaFile.replaceAll("(\\/\\/[^\\n\\r]+?(?:\\*\\)|[\\n\\r]))|(\\/\\*(?:[^\\*]|\\**[^\\*\\/])*\\*+\\/)","");
				// Burada yorum sat�rlar� regex ile bulunup yerine bo�luk atan�yor.
			javaFile = javaFile.replaceAll("<(.*>)","");
				// Arraylistler'de kullan�lan < ve > i�aretlerini ortadan kald�rmak i�in kullan�ld�.
			
			Pattern unaryP = Pattern.compile("([\\+]|[-]){2,3}");   
				// Tekli operat�r regexi
			Pattern binaryP = Pattern.compile("\\*|\\/|%|\\^|(?<!\\+)\\+(?!\\+)|(?<!-)-(?!-)|(?<!&)&(?!&)|(?<!\\|)\\|(?!\\|)|(?<!=|<|>|!|-|\\+|\\||\\*|\\/|%|\\^|&)=(?!=)|(?<!\\.)\\*(?!\\.|;)");	
				// �kili operat�r regexi
			Pattern relationalP = Pattern.compile("<|>|[?<!\\!|=|<|>][\\=?!\\=]");	
				// �li�kisel operat�r regexi
			Pattern logicalP = Pattern.compile("([\\|]{2})|([&]{2})|(!(?=[^=]))");
				// Mant�ksal operat�r regexi

			Matcher unaryM = unaryP.matcher(javaFile);
				// fileContent dosyas� i�erisinde unaryP regexi ile e�le�en ifadeler
			Matcher binaryM = binaryP.matcher(javaFile);
				// fileContent dosyas� i�erisinde binaryP regexi ile e�le�en ifadeler
			Matcher relationalM = relationalP.matcher(javaFile);
				// fileContent dosyas� i�erisinde relationalP regexi ile e�le�en ifadeler
			Matcher logicalM = logicalP.matcher(javaFile);
				// fileContent dosyas� i�erisinde logicalP regexi ile e�le�en ifadeler

			while (unaryM.find()) {	   // Operat�rler her bulundu�unda operat�r say�s� 1 artt�r�l�yor.
				unaryOp++;
//				System.out.println(tekliM.start() + "..." + tekliM.end() + "..." + tekliM.group());
					// iste�e g�re tekli operat�rlerin yeri ve kendisi g�r�nt�lenebilir
			}
			while(binaryM.find()) {
				binaryOp++;
//				System.out.println(ikiliM.start() + "..." + ikiliM.end() + "..." + ikiliM.group());
					// iste�e g�re ikili operat�rlerin yeri ve kendisi g�r�nt�lenebilir
			}			
			while (relationalM.find()) {
				relationalOp++;
//				System.out.println(relationalM.start() + "..." + relationalM.end() + "..." + relationalM.group());	            
					// iste�e g�re ili�kisel operat�rlerin yeri ve kendisi g�r�nt�lenebilir
			}
			while (logicalM.find()) {
				logicalOp++;
//				System.out.println(logicalM.start() + "..." + logicalM.end() + "..." + logicalM.group());
					// iste�e g�re mant�ksal operat�rlerin yeri ve kendisi g�r�nt�lenebilir
			}
						
			int arithmeticOp = unaryOp + binaryOp;
			arithmetic.setArithmeticOp(arithmeticOp);
			int operand = unaryOp + binaryOp*2 + relationalOp*2 + logicalOp*2;
			operanD.setOperand(operand);
				// Olu�turulan objeleri set ifadesi ile tan�mlama
			
			System.out.println("Operat�r Bilgisi:");
			System.out.println("	Tekli Operat�r Say�s�: " + unaryOp);
			System.out.println("	�kili Operat�r Say�s�: " + binaryOp);
			System.out.println("	Say�sal Operat�r Say�s�: " + arithmeticOp);
			System.out.println("	�li�kisel Operat�r Say�s�: " + relationalOp);
			System.out.println("	Mant�ksal Operat�r Say�s�: " + logicalOp);
			System.out.println("Operand Bilgisi: ");
			System.out.println("	Toplam Operand Say�s�: " + operand);
				// Ekrana istenilen �ekilde ��kt� veriliyor
			
//			System.out.print(fileContent);
				// Dosyadaki yorum sat�rlar�n�n tam silinip silinmedi�ini dosyay� yazd�rarak test etme
		}
		catch(FileNotFoundException FileNotFound) {    // Dosya bulunamad��� zaman catch blo�una ge�iliyor. 
			FileNotFound.printStackTrace();
			System.out.print(" We couldn't find the file :( ");
				// Hatan�n oldu�una dair bir ��kt�
		}
	}
}


