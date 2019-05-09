package es.unileon.prg1.blablakid;

public class MainBlablakid{

	public static void main(String[] args) {
			int maxNumOfKids = 0;
			if (args.length != 1) {
				System.out.println("Error: Indique un unico parametro en la ejecucion del programa. java -cp classes es.unileon.prg1.blablakid.MainBlablakid maxKids");
			} else {
				try {
					maxNumOfKids = Integer.parseInt(args[0]);
					Blablakid blablakid = new Blablakid(maxNumOfKids);
					TextUI textUI = new TextUI(blablakid);
					textUI.start();
				} catch (NumberFormatException e) {
					System.out.println("Error: El valor pasado en la ejecución no es un número entero");
				} catch (BlaException e) {
					System.out.println(e.getMessage());
				}
	
					
			}
	}
}
