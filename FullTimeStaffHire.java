
/**
 * This class has seven attributes and those values are assigned the values of
local variable in the constructor and the parent class constructor is called 
and the attributes staffName, joiningDate, qualification and appointedBy are 
assigned as the empty string and joined status is made false. The corresponding
getter and setter method is made to get and set the values to those attributes.
The salary can be set only when the staff has not joined. There is another method
hireFullTimeStaff which set the values to the attributes staffName, joiningDate,
qualification and appointedBy if the staff has not joined otherwise displays the
staffName and joining date of the staff. At, last there is display method which
calls the display method of parent class and if the staff has joined then displays
all the attribute of this class otherwise displays output saying the staff has
not joined.
 * @author (Anish Chaudhary)
 * 2020/1/5
 */
//initializing the attributes of class FullTimeStaffHire and it extends the class StaffHire
public class FullTimeStaffHire extends StaffHire{
    private int salary;
    private int workingHour;
    private String staffName;
    private String joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;
    //constructor for the class FullTimeStaffHire
    public FullTimeStaffHire(int salary, int workingHour,int vacancyNumber, String designation, String jobType){
        super(vacancyNumber,designation,jobType);
        this.salary = salary;
        this.workingHour = workingHour;
        staffName = "";
        joiningDate = "";
        qualification = "";
        appointedBy = "";
        setJoined(false);
    }
    //getter method for the attributes of this class which returns the values of the instance variables
    public int getSalary(){
        return salary;
    }

    public int getWorkingHour(){
        return workingHour;
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

    public boolean getJoined(){
        return joined;
    }
    //setter method for the attributes of class FullTimeStaffHire which assigns the value of instance variable to the local variable
    public void setSalary(int salary){
        if(getJoined() == false){      //this condition checks whether the joined status is true or false
            this.salary = salary;
        }
        else{
            System.out.println("sorry! its not possible to change the salary of this staff.");
        }
    }

    public void setWorkingHour(int workingHour){
        this.workingHour = workingHour;
    }

    public void setStaffName(String staffName){
        this.staffName = staffName;
    }

    public void setJoiningDate(String joiningDate){
        this.joiningDate = joiningDate;
    }

    public void setQualification(String qualification){
        this.qualification = qualification;
    }

    public void setappointedBy(String appointedBy){
        this.appointedBy = appointedBy;
    }

    public void setJoined(boolean joined){
        this.joined = joined;
    }
    //method hireFullTimeStaff which set the values to the instance variable if the staff has not joined otherwise displays suitable message with the staffName and joiningDate
    public void hireFullTimeStaff(String staffName, String joiningDate, String qualification, String appointedBy){
        if(getJoined() == false){   //checking condition whether the staff has joined or not
            this.staffName = staffName;
            this.joiningDate = joiningDate;
            this.qualification = qualification;
            this.appointedBy = appointedBy;
            setJoined(true);
        }
        else{
            System.out.println("The Staff is already hired.");
            System.out.println("The name of staff is :" +getStaffName());
            System.out.println("The staff has joined in : " +getJoiningDate());
        }

    }
    //display method of class FullTimeStaffHire which display details of the staff
    public void display(){
        super.display();  //calling the display method of parent class
        if(getJoined() == true){ //displays details of staff when joined status is true
            System.out.println("The name of staff is : " +getStaffName());
            System.out.println("The salary of the Staff is : " +getSalary());
            System.out.println("The working hour of staff is : " +getWorkingHour());
            System.out.println("The joined date of staff is : " +getJoiningDate());
            System.out.println("The qualification of staff is : " +getQualification());
            System.out.println("This staff is appointed by : " +getAppointedBy());
        }
        else{
            System.out.println("This staff has not joined yet.");
        }
    }

}

