package es.unileon.prg1.blablakid;

public class Parents {
	int next;
	private Parent parent[];
	
	public Parents(int numParents) throws BlaException {
		if (isCorrectNumber(numParents)) {
			parent = new Parent[numParents];
			this.next=0;
		}
	}
	
	private boolean isCorrectNumber(int numParents) throws BlaException {
		boolean salida;
		if (numParents>0) salida=true;
		else {
			salida=false;
			throw new BlaException ("Error:The number must be greater than zero");
		}
		return salida;
	}
	
	public void removeKid(String name) throws BlaException{
		for (int i=0;i<this.next;i++) {
			if(parent[i].find(name)) {
				this.parent[i].remove(name);
			}
		}
	}
	public int find(String name) {
		int i=0,out=-1;
		while (i<this.next && -1==out) {
			if (parent[i].getName().toLowerCase().equals(name.toLowerCase())) {
				out=i;
			}
			i++;
		}
		return out;
	}
	
	public void add(Parent parent) throws BlaException{
		if (find(parent.getName())!=-1) throw new BlaException("Error:That parent has allready exist");
		else {
			this.parent[next++]=parent;
		}
	}
	
	public void add(String name, WeekDays day,Ride ride) throws BlaException{
		int number=find(name);
		if (number==-1) {
			throw new BlaException("Error:That parent does not exist");
		}
		this.parent[number].add(day, ride);
	}
	
	public Ride remove(String name, WeekDays day,String start,String end) throws BlaException{
		int number=find(name);
		if (number==-1) {
			throw new BlaException("Error:That parent does not exist");
		}
		return this.parent[number].remove(day,start,end);
		
	}
	
	public void remove(Rides rides) {
		Ride ride;
		int number=0;
		boolean outRide=false;
		for (int i=0;i<rides.getNext();i++) {
			ride = rides.getRide(i);
			while(number<this.next && !outRide) {
				outRide=this.parent[number].remove(ride);
				number++;
			}
		}
		
	}
	public void remove(String name) throws BlaException{
		Parent parent;
		int number=find(name);
		if (number==-1) {
			throw new BlaException("Error: That parent does not exist");
		}
		this.parent[number]=null;
		if (number<=(this.parent.length-1)) {
			for (int i=number;i<=this.next;i++) {
				parent=this.parent[i+1];
				this.parent[i]=this.parent[i+1];
				this.parent[i]=parent;
			}
		}
		next--;
	}
	
	public String toString() {
		StringBuffer output= new StringBuffer();
		output.append("\nPARENTS:");
		for (int i=0;i<this.next;i++) {
			output.append(parent[i].toString());
		}
		return output.toString();
	}
}
	