package ass2;

public class Point {

	double x;
	double y;

	public Point(double x, double y) {
		
		this.x = x;
		this.y = y;
	}
	
	public double distance(Point other) {
        double distance = Math.sqrt(((this.x - other.x) *(this.x - other.x)) + ((this.y - other.y)*(this.y - other.y)));   
		
		return distance;
	}
	
	public boolean equals(Point other) { 
		double distance = distance(other);
		if (distance == 0){
		return true;
		}
		else{
			return false;
		}
		
	}
	
	 public double getX() {
	      return this.x;
	   }
	 public double getY() {
	      return this.y;
	   }
}