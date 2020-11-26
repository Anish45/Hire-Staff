
/**
 * This class StaffHire has three attributes and those attributes are assigned
the value of the local variables in the constructor and the getter and setter
method is made for these attribute to get and set values from and for these 
attributes. At, last creating a method which displays these attributes.
 * @author (Anish chaudhary)
 * 2020/1/5
 */
public class StaffHire
{
    //initializing the attributes of class StaffHire
    private int vacancyNumber;
    private String designation;
    private String jobType;
    //creating a constructor of class StaffHire
    public StaffHire(int vacancyNumber, String designation, String jobType){
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
    }
    //getter method of the attributes of class StaffHire which returns the values of corresponding instance variables
    public int getVacancyNumber(){
        return vacancyNumber; 
    }

    public String getDesignation(){
        return designation;
    }

    public String getJobType(){
        return jobType;
    }
    //setter method of the attributes of class StaffHire which assigns the value of instance variable to the local variable
    public void  setVacancynumber(int vacnacyNumber){
        this.vacancyNumber = vacancyNumber;
    }

    public void setDesignation(String designation){
        this.designation = designation;
    }

    public void setJobType(String jobType){
        this.jobType = jobType;
    }
    //creating a method display whch displays vacancy number, designation and jobtype of the staffhire class
    public void display(){
        System.out.println("The vacancy number is: " +getVacancyNumber());
        System.out.println("The designation is: " +getDesignation());
        System.out.println("The type of job is: " +getJobType());
    }
}
