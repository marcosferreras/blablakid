package es.unileon.prg1.blablakid;

public class MainBlablakid{

	public static void main(String[] args) {
		Blablakid blablakid;
		try {
			if (args.length == 1) {
				int maxNumOfKids = Integer.parseInt(args[0]);
				blablakid = new Blablakid(maxNumOfKids);
			} else {
				throw new BlaException("Error: Indique un único parámetro en la ejecución del programa. java –cp classes es.unileon.prg1.blablakid.MainBlablakid maxKids");
			}
			blablakid.addKid("Aurelio");
		} catch (BlaException e) {
		System.out.println(e.getMessage());
		}
	}
}
