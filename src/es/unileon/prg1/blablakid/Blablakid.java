package es.unileon.prg1.blablakid;
public class Blablakid{
	Kids kids;
	Parents parents;
	protected Blablakid(int maxNumOfKids) throws BlaException{
		kids = new Kids(maxNumOfKids);
	}
	void add(Kid kid) throws BlaException {
		kids.add(kid);
	}
	public Kids getKids() {
		return this.kids;
	}
	
	void removeKid(String name) throws BlaException {
		kids.remove(name);
	}
	void add(Activity activity, String nameKid) throws BlaException {
		kids.search(nameKid).add(activity);
	}
	void add(Parent parent, Kids kids) throws BlaException{
		parents.add(parent);
	}
	public String toString(){
		return kids.toString();
	}
}
