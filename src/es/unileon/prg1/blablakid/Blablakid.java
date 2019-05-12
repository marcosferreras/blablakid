package es.unileon.prg1.blablakid;
public class Blablakid{
	Kids kids;
	protected Blablakid(int maxNumOfKids) throws BlaException{
		kids = new Kids(maxNumOfKids);
	}
	void addKid(Kid kid) throws BlaException {
		kids.add(kid);
	}
	void removeKid(String name) throws BlaException {
		kids.remove(name);
	}
	void addActivity(Activity activity, String nameKid) throws BlaException {
		kids.search(nameKid).add(activity);
	}
	public String toString(){
		return kids.toString();
	}
}
