package es.unileon.prg1.blablakid;
public class Blablakid{
	Kids kids;
	protected Blablakid(int maxNumOfKids) throws BlaException{
		kids = new Kids(maxNumOfKids);
	}
	void addKid(String name) {
		kids.addKid(name);
	}
}