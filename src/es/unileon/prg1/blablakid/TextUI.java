package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * User interface
 * @author Marcos García
 *
 */

public class TextUI {
	private Blablakid blablakid;//esta declarado ya para todos los blablakid (todos sus metodos)
	private static final Logger logger= LogManager.getLogger(Kid.class);
	public TextUI (Blablakid blablakid) {
		this.blablakid = blablakid;
	}
	
	
	/**
	 * program start method
	 */
	protected void start() {
		logger.info("Starting aplication");
		int number = 0;
		do{
		    try{
		    	logger.info("Showing menu");
		    showMenu();
		    number= Teclado.readInteger();//recogemos ese valor en int numero
			selectOption(number);
			} catch (BlaException e) {
				System.out.println(e.getMessage());
				}
		}while (number != 0); 

	}
	
	/**
	 * UI menu that is displayed by
	 * screen to choose what we want to do.
	 */
	public void showMenu() {
		showSummary();
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
	
	}
	/**
	 * Method to choose option within the program.
	 * @param number
	 * @throws BlaException
	 */
	public void selectOption(int number)throws BlaException{
		logger.info("Selected option "+number);
			switch (number){
				case 1: 
					addKid();	
					break;
				case 2: 
					removeKid();
					break;
				case 3: 
					addParent(); //igual que el askkid (mas el add)
					break;
				case 4: 
					removeParent();
					break;
				case 5: 
					addActivity();
					break;
				case 6: 
					removeActivity();
					break;
				case 7: 
					addRide();
					break;
				case 8: 
					removeRide();
					break;
				case 9: 
					showSummary();
					break;
				case 10: 
					checkStatus();
					break;
				case 0:
					break;
				default:
					logger.error("The user has introduced a incorrect option ("+number+")");
					System.out.println("Error: The number entered is not correct. Enter a menu option");

			}
	}


	/**
	 * Ask for a name to add a kid.
	 * @throws BlaException
	 */
	public void addKid()throws BlaException{
		logger.info("Running add kid");
		String name;
		System.out.println ("Name the kid to add:");
		name = readString();
		logger.info("Adding kid "+name);
		this.blablakid.add(new Kid(name));
	}

	/**
	 * The method asks for a name to remove a kid.
	 * @throws BlaException
	 */
	public void removeKid() throws BlaException{
		logger.info("Running remove kid");
		String name;
		System.out.println ("Name the kid to remove:\n");
		name = readString();
		logger.info("Removing kid "+name);
		blablakid.removeKid(name);
	}
	/**
	 * This method asks for a lot of information (name of the parent,
	 * number of children, number of rides per day and name of
	 * children) to add a parent.
	 * @throws BlaException
	 */
	public void addParent()throws BlaException{ 
		logger.info("Running add parent");
		String parentName;
		int numberKids;
		int numberRides;
		String kidName;
		Kids kids;
		Parent parent;
		System.out.println ("Name of the parent to add:");
		parentName = readString();
		do {
			System.out.println ("How many kids does "+parentName+" have?:");
			numberKids = Teclado.readInteger();
			if(numberKids == Integer.MIN_VALUE) {
				logger.error("The value entered in: how many kids does "+parentName+" have? is not numeric. Requesting again");
				System.out.println("Error: Please, enter a numeric value");
			}
		} while (numberKids == Integer.MIN_VALUE);
		kids = new Kids (numberKids);
		do {
			System.out.println ("How many rides can "+parentName+" make per day?:");
			numberRides = Teclado.readInteger();
			if(numberRides == Integer.MIN_VALUE) {
				logger.error("The value entered in: how many rides can "+parentName+" make per day? is not numeric. Requesting again");
				System.out.println("Error: Please, enter a numeric value");
			}
		} while (numberRides == Integer.MIN_VALUE);  
		parent = new Parent(parentName, numberRides, numberKids);	
		for(int i=0; i<numberKids; i++) {
			System.out.println ("Who is "+parentName+"'s kid number"+i+"?");
			kidName = readString();
			logger.info("Adding "+kidName+" to "+parentName);
			kids.add(new Kid (kidName)); 
		}
		logger.info("Adding parent "+parentName+" with "+numberRides+" rides per day and "+numberKids+" kids");
		this.blablakid.add(parent, kids);
	
	}
	
	/**
	 * After entering a name, you delete a parent.
	 * @throws BlaException
	 */
	public void removeParent() throws BlaException{
		logger.info("Running remove parent");
		String name;
		System.out.println ("Name of the parent to remove:");
		name = readString();
		logger.info("Removing parent "+name);
		this.blablakid.removeParent(name);
	}

	/**
	 * The method asks for several data in order to add an activity.
	 * @throws BlaException
	 */
	public void addActivity() throws BlaException{
		logger.info("Running add activity");
		String nameKid, nameActivity, place;
		WeekDays day = null;
		Time start, end;
		System.out.println ("Name of the activity:");
		nameActivity = readString();
		System.out.println ("Where does the activity "+nameActivity+" takes place?");
		place = readString();
		day = askWeekDay();
		System.out.println ("Name of the kid taking the activity:");
		nameKid = readString();
		System.out.println ("When does the activity start?");
		start = askTime();
		System.out.println ("When does the activity end?");
		end = askTime();
		logger.info("Adding activity "+nameActivity+" that takes place in "+place+"("+day.toString()+") to kid "+nameKid+".Start "+start.toString()+".End"+end.toString());
		this.blablakid.add(new Activity(nameActivity, place, day, start, end), nameKid);
	}
	
	/**
	 * After entering the kid's name, activity and day, the
	 * method eliminates the activity saved previously.
	 * @throws BlaException
	 */
	public void removeActivity() throws BlaException {
		logger.info("Running remove Activity");
		String nameKid, activityName;
		WeekDays day;
		System.out.println ("Name of the kid taking the activity to remove: ");
		nameKid = readString();
		System.out.println ("Name of the activity to remove: ");
		activityName = readString();
		day = askWeekDay();
		logger.info("Removing activity "+activityName+" from "+nameKid+" activities");
		this.blablakid.removeActivity(nameKid, activityName, day);	
	}
	
	/**
	 * 	A ride is added in this method.
	 *  @throws BlaException
	 */
	public void addRide() throws BlaException {
		logger.info("Running add ride");
		String parentName, activityName, kidName, startPlace, endPlace;
		Time start, end;
		WeekDays day;
		Ride ride;
		System.out.println ("Name of the parent in charge of the ride:");
		parentName = readString();
		System.out.println ("Name of the activity of the ride:");
		activityName = readString();
		System.out.println ("Name of the kid taking the activity:");
		kidName = readString();
		System.out.println ("Where does the ride start?");
		startPlace = readString();
		System.out.println ("Where does the ride end?");
		endPlace = readString();
		System.out.println ("When does the ride start?");
		start = askTime();
		System.out.println ("When does the ride end?");
		end = askTime();
		day = askWeekDay();
		ride = new Ride(start, end, startPlace, endPlace);
		logger.info("Adding ride to "+parentName+". Kid: "+kidName+". Activity: "+activityName+". Start Place: "+startPlace+".End Place: "+endPlace+".Start Time: "+start.toString()+"End Time: "+end.toString());
		this.blablakid.addRide(parentName, activityName, kidName, ride, day);
	}
	
	/**
	 * In this method we eliminate the previous ride.
	 * @throws BlaException
	 */
	public void removeRide() throws BlaException {
		logger.info("Running remove ride");
		String parentName, rideStart, rideEnd;
		WeekDays day;
		System.out.println ("Name of the parent in charge of the ride:");
		parentName = readString();
		day = askWeekDay();
		System.out.println ("Where does the ride start?");
		rideStart = readString();
		System.out.println ("Where does the ride end?");
		rideEnd = readString();
		logger.info("Removing ride of parent "+parentName+" in "+day.toString()+".Start Place: "+rideStart+".End Place: "+rideEnd);
		this.blablakid.removeRide(parentName, day, rideStart, rideEnd);
	}
	/**
	 * This method serves to ask about time. Returns
	 * one hour, and if the time entered is not
	 * correct an error appears.
	 * @return
	 * @throws BlaException
	 */
	public Time askTime() throws BlaException {
		logger.info("Asking and checking Time");
		int hour, minute;
		System.out.println("\tInsert hour:"); 
		do {
			hour= Teclado.readInteger();
			if(hour == Integer.MIN_VALUE) {
				logger.error("The hour entered is not numeric. Requesting again");
				System.out.println("Error: Please, enter a numeric value");
			}
		}while (hour == Integer.MIN_VALUE);
		do {
			System.out.println ("\tInsert minute:");
			minute = Teclado.readInteger();
			if(minute == Integer.MIN_VALUE) {
				logger.error("The minute entered is not numeric. Requesting again");
				System.out.println("Error: Please, enter a numeric value");
			}
		} while (minute == Integer.MIN_VALUE);
		return new Time(hour, minute);
	}
	/**
	 * Read read a text string checking that
	 * it is not empty.
	 * @return
	 * @throws BlaException
	 */
	public String readString() throws BlaException {
		String name;
		do {
			name = Teclado.readString();
			if(name.trim().length() == 0) { 
			logger.error("Has been entered a empty field");
			System.out.println("Error: The field can not be empty. Input it again");
			}
		} while (name.trim().length() == 0);
		return name;
	} 
	/**
	 * Ask for a day of the week using a switch, and
	 * each number from 0 to 4 is assigned a day.
	 * @return
	 * @throws BlaException
	 */
	public WeekDays askWeekDay() throws BlaException{
		WeekDays day = null;
		int number;
		System.out.println ("Insert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday ");
		do {
			number = Teclado.readInteger();
			switch(number){
				case 0:
					day = WeekDays.MONDAY;
					break;
				case 1:
					day = WeekDays.TUESDAY;
					break;
				case 2:
					day = WeekDays.WEDNESDAY;
					break;
				case 3:
					day = WeekDays.THURSDAY;
					break;
				case 4:
					day = WeekDays.FRIDAY;
					break;
				default:
					logger.error("Has been entered an incorrect numeric value "+number+" for WeekDay");
					System.out.println("Error: The number "+number+" is incorrect. Introduce a 0-4 number");			
			}
		} while (number>4 || number<0);
		return day;
	}
	
	/**
	 *This method displays the information on the screen of the status
	 *of the application at all times and that matches what
	 *we are showing every time we show the main menu.
	 */
	public void showSummary() {
	
	System.out.println(this.blablakid.toString());
	}
	
	/**
	 * This method shows information about the journeys
	 * missing to cover.
	 */
	public void checkStatus() {
	System.out.println(this.blablakid.checkStatus());	
	}
}



