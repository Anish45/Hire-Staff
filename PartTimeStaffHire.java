
/**
 * This class has nine attributes and they are assigned the value in the constructor
and the constructor of the parent class is called and the attributes staffName,
joiningDate, qualification and appointedBy are assigned as the empty string and 
terminated is made false. The corresponding getter and setter method is made to 
get and set the values to those attributes. There is a method setShifts which set
the value to the instance variable if the joined status is false. Ther is another 
method hirePartTimeStaff which set the values to the atttributes staffName, qualification,
appointedBy and joinigDate and the joined status is made true and terminated status is made
false if joined status is false othewise the suitable message with the staffName and joiningDate
are displayed. There is method terminateStaff which make the joined status false 
if the staff is terminated otherwise assigns attributes staffName, qualification,
appointedBy and joinigDate as an empty string. At, last there is a method display
which calls the method from the parent class using super keyword and displays 
all the attributes including income per day if the staff has joined.
 * @author (Anish Chaudhary)
 * 2020/1/5
 */
//initializing the attributes of class FullTimeStaffHire and it extends the class StaffHire
public class PartTimeStaffHire extends StaffHire{
    private int workingHour;
    private int wagesPerHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private String shifts;
    private boolean joined;
    private boolean terminated;
    //constructor for the class PartTimeStaffHire
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType, int workingHour, int wagesPerHour, String shifts){
        super(vacancyNumber,designation,jobType);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        staffName = "";
        joiningDate = "";
        qualification = "";
        appointedBy = "";
        setJoined(false);
        setTerminated(false);
    }
    //getter method for the attributes of this class which returns the values of the instance variables
    public int getWorkingHour(){
        return workingHour;
    }

    public int getWagesPerHour(){
        return wagesPerHour;
    }

    public String getStaffName(){
        return staffName;
    }

    public String getJoiningDate(){
        return joiningDate;
    }

    public String getQualification(){
        return qualification;
    }

    public String getAppointedBy(){
        return appointedBy;
    }

    public String getShifts(){
        return shifts;
    }

    public boolean getJoined(){
        return joined;
    }

    public boolean getTerminated(){
        return terminated;
    }
    //setter method for the attributes of class PartTimeStaffHire which assigns the value of instance variable to the local variable
    public void setWorkingHour(int workingHour){
        this.workingHour = workingHour;
    }

    public void setWagesPerHour(int wagesPerHour){
        this.wagesPerHour = wagesPerHour;
    }

    public void setStaffName(String staffName){
        this.staffName = staffName;
    }

    public void setJoiningDate(String joiningDate){
        this.joiningDate = joiningDate;
    }

    public void setQualification(String qualification){
        this.qualification =  qualification;
    }

    public void setAppointedBy(String appointedBy){
        this.appointedBy = appointedBy;
    }

    public void setShifts(String shifts){
        if (getJoined() == false){   //checks the condition for the attribute joined
            this.shifts = shifts;
        }
        else{
            System.out.println("This staff is already hired");
        }
    }

    public void setJoined(boolean joined){
        this.joined = joined;
    }

    public void setTerminated(boolean terminated){
        this.terminated = terminated;
    }
    //method hirePartTimeStaff which set the values to the instance variable if the staff has not joined otherwise displays suitable message with the staffName and joiningDate
    public void hirePartTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy){
        if(getJoined() == false){
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            setJoined(true);
            setTerminated(false);
        }
        else{
            System.out.println("The Staff is already hired.");
            System.out.println("The name of staff is : " +getStaffName());
            System.out.println("The staff has joined in : " +getJoiningDate());
        }

    }
    //method terminateStaff which displays suitable outbut and set joined as false if the staff has been terminated otherwise assigns attributes staffName,joiningDate,qualification and appointedBy as an empty value
    public void terminateStaff(){
        if (getTerminated() == true){
            System.out.println("The staff is already terminated.");
        }
        else{
            staffName = "";
            joiningDate = "";
            qualification = "";
            appointedBy = "";
            setJoined(false);
            setTerminated(true);
        }
    }
    //method display which calls the display method from parent class and displays all the attributes of this class and income per day too which is the product of wages per hour and working hour
    public void display(){
        super.display();
        if(joined == true){
            System.out.println("The name of the staff is " +getStaffName());
            System.out.println("The wages per hour of the staff is " +getWagesPerHour());
            System.out.println("The working hour of the staff is " +getWorkingHour());
            System.out.println("This staff has joined in " +getJoiningDate());
            System.out.println("The qualification of this staff is " +getQualification());
            System.out.println("This staff has been appointed by " +getAppointedBy());
            double incomePerDay = wagesPerHour*workingHour;
            System.out.println("The income per day of this staff is " +incomePerDay);
        }
    }

}

