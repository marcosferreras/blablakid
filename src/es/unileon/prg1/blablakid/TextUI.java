package es.unileon.prg1.blablakid;

public class TextUI {
	Blablakid blablakid;//esta declarado ya para todos los blablakid (todos sus metodos)
	protected TextUI (Blablakid blablakid) {
		this.blablakid = blablakid;
	}
	
	protected void start() {
		//TODO Menú
int number;
String name;
Teclado teclado = new Teclado ();

do{

System.out.println ("---------");	
System.out.println ("Blablakid");
System.out.println ("---------");

System.out.println ("Select an option:");

System.out.println ("1 - Add kid"); 
System.out.println ("3 - Add parent");
System.out.println ("4 - Remove parent");
System.out.println ("5 - Add activity");
System.out.println ("6 - Remove activity");
System.out.println ("7 - Add ride");
System.out.println ("8 - Remove ride");
System.out.println ("9 - Show summary");
System.out.println ("10 -Check status");

System.out.println ("0 - Exit");


	number= teclado.readInteger();//recogemos ese valor en int numero	
switch (number){
	case 1:
		System.out.println ("Name the kid to add:\n");
		name = teclado.readString();
		blablakid.addKid(name);
		break;
	case 2:
		break;
	case 3:
		break;
	case 4:
		break;
	case 5:
		break;
	case 6:
		break;
	case 7:
		break;
	case 8:
		break;
	case 9:
		break;
	case 10:
		break;
	case 0:
		break;

	default:
		System.out.println("Error: el número introducido no es correcto, introduzca un número del menú");

}

}while (number != 0);






	}
}
