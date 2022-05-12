/**
* @author Ahmet Furkan Söðütcü / 1-A / ahmet.sogutcu@ogr.sakarya.edu.tr
* @since 01.04.2022
* <p>
* Bu Class'ta get set metotlarý ile koruma amaçlý private tanýmlanan deðiþkenler var.
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
		// Verilerin dýþarýdan etkilenmemesi için private olarak tanýmlandý
		// Bununla baðlantýlý olarak get-set metotlarý kullanýldý
	
	public int getUnaryOp() {
		return unaryOp;
	}
	
	public void setUnaryOp(int unaryOp) {
		this.unaryOp = unaryOp;    
			// Parametre olarak verilen ismin obje ile karýþmamasý için this kullanýldý
		
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

