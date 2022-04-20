package kr.hs.dgsw.java.dept1.d0420;

public class Triangle extends Polygon {
	
	protected final int width;
	
	protected final int height;
	
	public Triangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public String getType() {
		return "삼각형";
	}
	
	@Override
	public double getArea() {
		return this.width * this.height /2;
	}
	
	public static void main(String[] args) {
		Polygon triangle = new Triangle(10, 2);
		triangle.print();
	}
	
}
