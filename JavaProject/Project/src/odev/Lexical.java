/**
* @author Ahmet Furkan S���tc� / 1-A / ahmet.sogutcu@ogr.sakarya.edu.tr
* @since 01.04.2022
* <p>
* Bu Class'ta get set metotlar� ile koruma ama�l� private tan�mlanan de�i�kenler var.
* </p>
*/
package odev;

public class Lexical {
	
	private int unaryOp = 0;
	private int binaryOp = 0;
	private int logicalOp = 0;
	private int relationalOp = 0;
	private int arithmeticOp = 0;
	private int operanD = 0;
		// Verilerin d��ar�dan etkilenmemesi i�in private olarak tan�mland�
		// Bununla ba�lant�l� olarak get-set metotlar� kullan�ld�
	
	public int getUnaryOp() {
		return unaryOp;
	}
	
	public void setUnaryOp(int unaryOp) {
		this.unaryOp = unaryOp;    
			// Parametre olarak verilen ismin obje ile kar��mamas� i�in this kullan�ld�
		
	}
	
	public int getBinaryOp() {
		return binaryOp;
	}
	
	public void setBinaryOp(int binaryOp) {
		this.binaryOp = binaryOp;
	}
	
	public int getRelationalOp() {
		return relationalOp;
	}
	
	public void setRelationalOp(int relationalOp) {
		this.relationalOp = relationalOp;
	}
	
	public int getLogicalOp() {
		return logicalOp;
	}
	
	public void setLogicalOp(int logicalOp) {
		this.logicalOp = logicalOp;
	}
	
	public int getArithmeticOp() {
		return arithmeticOp;
	}
	
	public void setArithmeticOp(int arithmeticOp) {
		this.arithmeticOp = arithmeticOp; 
	}
	
	public int getOperand() {
		return operanD;
	}
	
	public void setOperand(int operand) {
		this.operanD = operand;
	}
}

