package kr.hs.dgsw.java.dept1.d0420;

public class Circle extends Polygon {
	
	protected final int l;
	
	public Circle(int l) {
		this.l = l;
	}
	
	@Override
	public String getType() {
		return "원";
	}
	
	@Override
	public double getArea() {
		return this.l*this.l*Math.PI;
	}
	
	public static void main(String[] args) {
		Polygon circle = new Circle(4);
		circle.print();
	}

}
