package es.unileon.prg1.blablakid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



/**
 * User interface
 * @author Marcos Garcia
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
		logger.info("Program finished");

	}
	
	/**
	 * UI menu that is displayed by screen to choose what we want to do.
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
	 * @param number The option of the menu
	 * @throws BlaException If the number is not an option of the menu
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
	 * This method asks for information of the parent, and add it.
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
		logger.info("Parent name: "+parentName);
		do {
			System.out.println ("How many kids does "+parentName+" have?:");
			numberKids = Teclado.readInteger();
			if(numberKids == Integer.MIN_VALUE) {
				logger.error("The value entered in: how many kids does "+parentName+" have? is not numeric. Requesting again");
				System.out.println("Error: Please, enter a numeric value");
			}
		} while (numberKids == Integer.MIN_VALUE);
		logger.info("Kids of "+parentName+": "+numberKids);
		kids = new Kids (numberKids);
		do {
			System.out.println ("How many rides can "+parentName+" make per day?:");
			numberRides = Teclado.readInteger();
			if(numberRides == Integer.MIN_VALUE) {
				logger.error("The value entered in: how many rides can "+parentName+" make per day? is not numeric. Requesting again");
				System.out.println("Error: Please, enter a numeric value");
			}
		} while (numberRides == Integer.MIN_VALUE);  
		logger.info("Limit of rides for "+parentName+": "+numberRides);
		parent = new Parent(parentName, numberRides, numberKids);	
		for(int i=0; i<numberKids; i++) {
			System.out.println ("Who is "+parentName+"'s kid number"+i+"?");
			kidName = readString();
			logger.info("Adding "+kidName+" to "+parentName);
			kids.add(new Kid (kidName)); 
		}
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
		logger.info("Activity name: "+nameActivity);
		System.out.println ("Where does the activity "+nameActivity+" takes place?");
		place = readString();
		logger.info("Place: "+place);
		day = askWeekDay();
		System.out.println ("Name of the kid taking the activity:");
		nameKid = readString();
		logger.info("Kid Name: "+nameKid);
		logger.info("Asking when start");
		System.out.println ("When does the activity start?");
		start = askTime();
		logger.info("Asking when end");
		System.out.println ("When does the activity end?");
		end = askTime();
		this.blablakid.add(new Activity(nameActivity, place, day, start, end), nameKid);
	}
	
	/**
	 * After entering the kid's information, remove the activity.
	 * @throws BlaException
	 */
	public void removeActivity() throws BlaException {
		logger.info("Running remove Activity");
		String nameKid, activityName;
		WeekDays day;
		System.out.println ("Name of the kid taking the activity to remove: ");
		nameKid = readString();
		logger.info("Kid name: "+nameKid);
		System.out.println ("Name of the activity to remove: ");
		activityName = readString();
		logger.info("Activity name: "+activityName);
		day = askWeekDay();
		this.blablakid.removeActivity(nameKid, activityName, day);	
	}
	
	/**
	 * 	Add a ride.
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
		logger.info("Parent name: "+parentName);
		System.out.println ("Name of the activity of the ride:");
		activityName = readString();
		logger.info("Activity name: "+activityName);
		System.out.println ("Name of the kid taking the activity:");
		kidName = readString();
		logger.info("Kid name: "+kidName);
		System.out.println ("Where does the ride start?");
		startPlace = readString();
		logger.info("Start place: "+startPlace);
		System.out.println ("Where does the ride end?");
		endPlace = readString();
		logger.info("End place: "+endPlace);
		logger.info("Asking when start");
		System.out.println ("When does the ride start?");
		start = askTime();
		logger.info("Asking when end");
		System.out.println ("When does the ride end?");
		end = askTime();
		day = askWeekDay();
		ride = new Ride(start, end, startPlace, endPlace);
		this.blablakid.addRide(parentName, activityName, kidName, ride, day);
	}
	
	/**
	 * This method eliminate the previous ride.
	 * @throws BlaException
	 */
	public void removeRide() throws BlaException {
		logger.info("Running remove ride");
		String parentName, rideStart, rideEnd;
		WeekDays day;
		System.out.println ("Name of the parent in charge of the ride:");
		parentName = readString();
		logger.info("Parent name: "+parentName);
		day = askWeekDay();
		logger.info("Asking when start");
		System.out.println ("Where does the ride start?");
		rideStart = readString();
		logger.info("Asking when end");
		System.out.println ("Where does the ride end?");
		rideEnd = readString();
		this.blablakid.removeRide(parentName, day, rideStart, rideEnd);
	}
	/**
	 * This method serves to ask about time
	 * @return a Time object with the hour an minute
	 * @throws BlaException
	 */
	public Time askTime() throws BlaException {
		logger.info("Asking Time");
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
	 * Read a text from console checking that it is not empty.
	 * @return
	 * @throws BlaException If the field is empty
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
	 * Ask for a day of the week using 
	 * @return Day of the week
	 * @throws BlaException If the numeric day entered is not [0-5]
	 */
	public WeekDays askWeekDay() throws BlaException{
		WeekDays day = null;
		int number;
		System.out.println ("Insert the number of the day of the week:\n0 -Monday / 1-Tuesday / 2 -Wednesday / 3 -Thursday / 4 -Friday ");
		do {
			number = Teclado.readInteger();
			logger.info("Day :"+number);
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
	 * This method shows information about the rides
	 * missing to cover.
	 */
	public void checkStatus() {
	System.out.println(this.blablakid.checkStatus());	
	}
}



