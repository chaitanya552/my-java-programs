
public class DirectionBetweenTwoPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		System.out.println(direction(1,2,3,7)); //NE
	}
	public static String direction (int x1, int y1,int  x2,int  y2)  {
	  String d = "";
	    d += y1 < y2 ? "N" : y1 > y2 ? "S" : "";
	    d += x1 < x2 ? "E" : x1 > x2 ? "W" : "";
	    return d == "" ? "here" : d;
	}
}
