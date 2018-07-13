import java.util.ArrayList;



public class Warning {


    public static void main(String[] args) {
	ArrayList al = new ArrayList();
	for (String arg : args) {
	    al.add(arg);
	}

	al.add(new Darble());

	int c = 0;

	for (Object a : al) {
	    System.out.println("a is " + a);
	    c += Integer.parseInt((String) a);
	    System.out.println("c is " + c);
	}
    }


}

class Darble {
}
