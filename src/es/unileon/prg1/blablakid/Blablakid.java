package es.unileon.prg1.blablakid;
public class Blablakid{
	Kids kids;
	Parents parents;
	protected Blablakid(int maxNumOfKids) throws BlaException{
		this.kids = new Kids(maxNumOfKids);
		this.parents = new Parents(maxNumOfKids*2);
	}
	public void add(Kid kid) throws BlaException {
		kids.add(kid);
	}
	
	public void removeKid(String name) throws BlaException {
		this.kids.remove(name);
	}
	public void add(Activity activity, String nameKid) throws BlaException {
		Kid kid = kids.search(nameKid);
		if(kid == null){
			throw new BlaException("Error: The kid "+nameKid+" does not exist");
		} else {
			kid.add(activity);
		}
	}
	public void addRide(String nameParent,String activity,String nameKid,Ride ride, WeekDays day) throws BlaException {
		kids.addRide(activity,nameKid,ride,day);
		
	}
	void add(Parent parent, Kids kids) throws BlaException{
		parents.add(parent);
	}
	public String toString(){
		return kids.toString();
	}
}
