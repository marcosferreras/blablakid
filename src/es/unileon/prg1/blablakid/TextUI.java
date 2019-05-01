package es.unileon.prg1.blablakid;

public class TextUI {
	Blablakid blablakid;//esta declarado ya para todos los blablakid (todos sus metodos)
	protected TextUI (int numMaxKids) {
		try{
			blablakid = new Blablakid(numMaxKids);
			} catch (BlaException e) {
				System.out.println(e.getMessage());
		}
	}
	
	protected void start() {
		//TODO Menú
		int number = 0;
		String name;
		Teclado teclado = new Teclado ();

		do{
		     try{

			System.out.println ("---------");	
			System.out.println ("Blablakid");
			System.out.println ("---------");

			System.out.println ("Select an option:");

			System.out.println ("1 - Add kid"); 
			System.out.println ("2 - Remove kid"); 
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
					blablakid.addKid(new Kid(teclado.readString()));
					break;
				case 2:
					System.out.println ("Name the kid to remove:\n");
					blablakid.removeKid(teclado.readString());
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
		   } catch (BlaException e) {
				System.out.println(e.getMessage());
				}

		}while (number != 0);

	}
	
}
