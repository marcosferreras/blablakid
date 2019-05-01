package es.unileon.prg1.blablakid;
public class Blablakid{
	Kids kids;
	protected Blablakid(int maxNumOfKids) throws BlaException{
		kids = new Kids(maxNumOfKids);
	}
	void addKid(Kid kid) throws BlaException {
		kids.addKid(kid);
	}
	void removeKid(String name) throws BlaException {
		kids.removeKid(name);
	}
	public String toString(){
		return kids.toString();
	}
}
