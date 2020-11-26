/**
* This class has the 6 methods in it. The first method is the consructor where we have called the three methods initialize body, initializePartTimePanel
and initializeFullTimePanel. in the first method we take the input value from the user of vacancy number, designation and jobtype. After that,
we have different panels for teo methods initializePartTimePanel and initializeFullTimePanel. in this both panels we add and appoint the
staff. The termination of staff is done only foe parttime. we can view all the list of the staff also. This class helps to interact more
with the users due to its GUI. 
* @author (Anish chaudhary)
* 2020/5/1
*/
// importing all the components needed in the GUI from swing class 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
public class INGNepal
{
ArrayList<StaffHire> al = new ArrayList<StaffHire>(); //Creating a arraylist for staffhire class
private JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;
private JFrame window;
private JPanel p1,p2,p3;
private JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf14,tf15,tf16,tf17,tf18;
private JRadioButton rb1,rb2;
private ButtonGroup bg;
private JButton btn1,btn2,btn3,btn4,btn5,btn6,btn8,btn9,btn10,btn11,btn14,btn15;

// This is the constructor for the INGNepal class
public INGNepal(){
initializeBody();
initializePartTimePanel();
initializeFullTimePanel();
}

// This is the initializeBody method 
public void initializeBody(){
window = new JFrame("MyApplication");  // Giving a name to the window

p1 = new JPanel();

//labels for this panel
l1 = new JLabel("Enter the below fields to hire the staff");
l1.setBounds(150,15,250,25);
l1.setForeground(Color.red);
p1.add(l1);

l2 = new JLabel("Vacancy Number : ");
l2.setBounds(70,60,125,25);
p1.add(l2);

l3 = new JLabel("Designation : ");
l3.setBounds(100,100,125,25);
p1.add(l3);

l4 = new JLabel("Job Type : ");
l4.setBounds(70,140,125,25);
p1.add(l4);

//textfieldss for this panel
tf1 = new JTextField();
tf1.setBounds(200,60,150,25);
p1.add(tf1);

tf2 = new  JTextField();
tf2.setBounds(200,100,150,25);
p1.add(tf2);

// Creating a button group for the radiobutton values
bg = new ButtonGroup();
rb1 = new JRadioButton("Fulltime");
rb1.setActionCommand("Fulltime");
rb1.setBounds(200,140,100,25);
bg.add(rb1);
p1.add(rb1);

rb2 = new JRadioButton("Parttime");
rb2.setActionCommand("Parttime");
rb2.setBounds(300,140,100,25);
bg.add(rb2);
p1.add(rb2);

btn15 = new JButton("Display");
btn15.setBounds(160,240,100,25);
btn15.addActionListener(new ActionListener(){  //Adding a ActionListener in the Display button
public void actionPerformed(ActionEvent ae){
if(al.size() > 0){  // Checking the condition if size of arraylist is greater than zero or not
displayDetails();  // Calling displayDetails method
}
else{
JOptionPane.showMessageDialog(window, "The list is empty", "Error", 2); //Displaying suitable message
}
}
});
p1.add(btn15);

btn1 = new JButton("OK");
btn1.setBounds(70,200,100,25);
btn1.addActionListener(new ActionListener(){ // Adding ActionListener in ok button
    public void actionPerformed(ActionEvent ae){
        try{ // try and catch for NullPointer Exception
            String jobtype = bg.getSelection().getActionCommand();
            if(tf1.getText().isEmpty() || tf2.getText().isEmpty() || jobtype.isEmpty()){ //Checking whether the values are empty or not
            JOptionPane.showMessageDialog(window, "Fill all the details!", "Error", 2); //Displaying suitable message
        }
          else{
              try{ // try and catch for NumberFormat Exception
                Integer i = Integer.parseInt(tf1.getText());
            }catch(NumberFormatException nfe){
                JOptionPane.showMessageDialog(window, "The given input is invalid for vacancy number", "Error", 2);            
                return;
            }
        }
    }
       catch(NullPointerException npe){
        JOptionPane.showMessageDialog(window, "Fill the jobtype!", "Error", 2);
        }
        Condition();
    }
    // Condition method to check the values of the radiobutton
    public void Condition(){
            if(bg.getSelection().getActionCommand().equals("Parttime")){ //Checking condition if the selected radiobutton value is parttime or not
            initializePartTimePanel(); //Calling initializePartTimePanel method
            p1.setVisible(false);
            p2.setVisible(true);
            window.setSize(500,500);
    }
        else{
            initializeFullTimePanel(); //Calling initializeFullTimePanel method
            p1.setVisible(false);
            p3.setVisible(true);
            window.setSize(500,500);
        }
    }
});
p1.add(btn1);

btn2 = new JButton("Clear");
btn2.setBounds(250,200,100,25);
btn2.addActionListener(new ActionListener(){ // Adding ActionLiistener in clear button
    public void actionPerformed(ActionEvent ae){
        // Setting all the textfields and radio button values null
        tf1.setText(null);
        tf2.setText(null);
        bg.clearSelection();
    }
});
p1.add(btn2);

window.add(p1);
p1.setSize(500,325);
p1.setLayout(null);
p1.setVisible(true);

window.setSize(500,325);
window.setLayout(null);
window.setVisible(true);
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
//This is for the second panel which is for the PartTimeStaffHire
public void initializePartTimePanel(){
p2 = new JPanel();

btn3 = new JButton("Back");
btn3.setBounds(10,5,100,35);
btn3.addActionListener(new ActionListener(){ // Adding ActionListener in back button
    public void actionPerformed(ActionEvent ae){
        // Setting the visible true for p1 and false for p2
        p1.setVisible(true);
        p2.setVisible(false);
        window.setSize(500,325);
    }
});
p2.add(btn3);

//label for this panel
l21 = new JLabel("FOR PARTTIME STAFFHIRE");
l21.setBounds(185,5,250,25);
l21.setForeground(Color.red);
p2.add(l21);

l5 = new JLabel("Staff Name : ");
l5.setBounds(55,50,100,25);
p2.add(l5);

l6 = new JLabel("Joining Date : ");
l6.setBounds(50,80,100,25);
p2.add(l6);

l7 = new JLabel("Qualification : ");
l7.setBounds(50,110,100,25);
p2.add(l7);

l8 = new JLabel("Appointed By : ");
l8.setBounds(45,140,100,25);
p2.add(l8);

l9 = new JLabel("Salary : ");
l9.setBounds(85,170,100,25);
p2.add(l9);

l10 = new JLabel("Working Shifts : ");
l10.setBounds(40,200,100,25);
p2.add(l10);

l11 = new JLabel("Wages Per Hour : ");
l11.setBounds(30,230,120,25);
p2.add(l11);

l12 = new JLabel("Working Hour : ");
l12.setBounds(45,260,100,25);
p2.add(l12);

//textfields for this panel
tf3 = new JTextField();
tf3.setBounds(150,50,150,25);
p2.add(tf3);

tf4 = new JTextField();
tf4.setBounds(150,80,150,25);
p2.add(tf4);

tf5 = new JTextField();
tf5.setBounds(150,110,150,25);
p2.add(tf5);

tf6 = new JTextField();
tf6.setBounds(150,140,150,25);
p2.add(tf6);

tf7 = new JTextField();
tf7.setBounds(150,170,150,25);
p2.add(tf7);

tf8 = new JTextField();
tf8.setBounds(150,200,150,25);
p2.add(tf8);

tf9 = new JTextField();
tf9.setBounds(150,230,150,25);
p2.add(tf9);

tf10 = new JTextField();
tf10.setBounds(150,260,150,25);
p2.add(tf10);

btn4 = new JButton("ADD");
btn4.setBounds(15,300,100,45);
btn4.addActionListener(new ActionListener(){ //Adding ActionListener for add button
public void actionPerformed(ActionEvent ae){
    int vacancyNumber = Integer.parseInt(tf1.getText());
    String designation =tf2.getText();                  
    String jobType = bg.getSelection().getActionCommand();
    // Checking the condition whether the values in the textfields are empty or not
    if(tf3.getText().isEmpty() || tf4.getText().isEmpty() || tf5.getText().isEmpty() || tf6.getText().isEmpty() || tf7.getText().isEmpty() || tf8.getText().isEmpty() || tf9.getText().isEmpty() || tf10.getText().isEmpty()){
     JOptionPane.showMessageDialog(window, "Fill all the details!", "Error", 2);
}
 else{
     try{ //try and catch for NumberFormat Exception
         int workingHour =Integer.parseInt(tf10.getText ());
         String shifts = tf8.getText();
         int wagesPerHour = Integer.parseInt(tf9.getText());
          for(StaffHire s : al) //checking for the object of staffhire is in arraylist or not 
                  {
                       if (s instanceof PartTimeStaffHire)// condition for if object of staffhire is instance of parttimestaffhire or not 
                       {
                       PartTimeStaffHire p = (PartTimeStaffHire)s;// typecasting object of satffhire to parttimestaffhire
                       if (p.getVacancyNumber() == vacancyNumber)//checking the condition if the vacancy is already added
                       {
                            JOptionPane.showMessageDialog(window,"This vacancy number is already added","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                  }
          //creating object of parttimestaffhire and passing the values into the parameter
         PartTimeStaffHire pt = new PartTimeStaffHire(vacancyNumber, designation, jobType, workingHour, wagesPerHour, shifts);        
         al.add(pt);                   
         JOptionPane.showMessageDialog( window,"PartTimeStaff sucessfully added" ,"Information",JOptionPane.INFORMATION_MESSAGE);         
        }
         catch(NumberFormatException fe){        
    JOptionPane.showMessageDialog( window,"Enter the correct data " ,"Warning",JOptionPane.WARNING_MESSAGE); 
}
}
}
});
p2.add(btn4);

btn5 = new JButton("Appoint");
btn5.setBounds(150,300,100,45);
btn5.addActionListener(new ActionListener(){ //adding actionlistener in the appoint button
public void actionPerformed(ActionEvent ae){
int vacancyNumber;
String staffName = tf3.getText().trim();
String joiningDate = tf4.getText().trim();
String qualification = tf5.getText().trim();
String appointedBy = tf6.getText().trim();
// checking condition whether the textfields are empty or not
if(tf3.getText().equals("") || tf4.getText().equals("") || tf5.getText().equals("") || tf6.getText().equals("") || tf7.getText().equals("") || tf8.getText().equals("") || tf9.getText().equals("") ||tf10.getText().equals("")){
JOptionPane.showMessageDialog(window,  "please fill all the field", "Warning",2); 
return;
}
else{
try{ //try and catch for NumberFormat Exception
    vacancyNumber = Integer.parseInt(tf1.getText());   
}
catch(NumberFormatException e){
    JOptionPane.showMessageDialog(window,"please enter valid data" ,"Warning",JOptionPane.WARNING_MESSAGE); 
    return;
}
}
boolean vacancyfound = false; //assigning boolean value vacancy found as false
for(StaffHire staffhirearraylist: al){ //checking for the object of staffhire in the arraylist
if(staffhirearraylist instanceof PartTimeStaffHire){ //if the object of staffhire instance of parttimestaffhire
    PartTimeStaffHire parttimestaff = (PartTimeStaffHire)staffhirearraylist; //typecasting object of staffhire to parttimestaffhire
    if(parttimestaff.getVacancyNumber() == vacancyNumber){ //condition if vacancynumber is found
        vacancyfound = true;
        if(parttimestaff.getJoined()==false){ //condition if vacancynumber is not joined
            JOptionPane.showMessageDialog(window,"SUccessfully appointed","parttimestaff sucessfully appointed",1);
        }else{
            JOptionPane.showMessageDialog(window,"Staff was appointed");
            parttimestaff.hirePartTimeStaff(staffName, joiningDate, qualification, appointedBy);
            return;
        }
    }
}
}
}
});
p2.add(btn5);

btn6 = new JButton("Terminate");
btn6.setBounds(300,300,100,45);
btn6.addActionListener(new ActionListener(){ //adding actionlistener in terminate button
public void actionPerformed(ActionEvent ae){
String vacancyNumber=JOptionPane.showInputDialog(window,"Vacancy Number: ");;
        try{ //trycatch for NullPointer Exception
            if(vacancyNumber.trim().equals(null)); //checking whether the vacancy number is null 
        }catch(NullPointerException e){
            return;
        }
        int number=0;
        if(!vacancyNumber.trim().equals("")){ //checking if the vacancy number is not null
            try{ //try and catch for NumberFormat Exception
                number= Integer.parseInt(vacancyNumber.trim());
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(window,"Enter Data in correct format","Error",0);
                return;
            }
            boolean vacancyfound=false; //assigning the boolean value vacacnyfound as false
            for(StaffHire staffhirearraylist : al){ //for the object of staffhire in the arraylist
                if(staffhirearraylist instanceof PartTimeStaffHire){
                    PartTimeStaffHire parttimestaff = (PartTimeStaffHire) staffhirearraylist; //type casting object of staff hire to parttimestaffhire
                    if(staffhirearraylist.getVacancyNumber()== number){ //condition if the vaccny is found
                        vacancyfound=true;
                        JOptionPane.showMessageDialog(window,"sucessfully Staff Terminated.","information",1);
                        break;
                    }
                }
            } 
            if(!vacancyfound){ //condition if vacancy is not found
                JOptionPane.showMessageDialog(window,"Vacany Number not found","Error",1);
            }
        }
        else{    
            JOptionPane.showMessageDialog(window,"Invalid. Field Empty","Error",1);
        }
    }
});
p2.add(btn6);

btn8 = new JButton("Clear");
btn8.setBounds(150,370,100,45);
btn8.addActionListener(new ActionListener(){ //adding actionlistener in clear button
    public void actionPerformed(ActionEvent ae){
      // settinig textfields value to null
      tf3.setText(null);
      tf4.setText(null);
      tf5.setText(null);
      tf6.setText(null);
      tf7.setText(null);
      tf8.setText(null);
      tf9.setText(null);
      tf10.setText(null);
    }
});
p2.add(btn8);

p2.setSize(500,500);
p2.setLayout(null);
p2.setVisible(false);
window.add(p2);
}
//This is for the full time panel
public void initializeFullTimePanel(){
p3 = new JPanel();

btn4 = new JButton("Back");
btn4.setBounds(10,5,100,35);
btn4.addActionListener(new ActionListener(){ //adding actionlistener for back button
    public void actionPerformed(ActionEvent ae){
        // Setting the visible true for p1 and false for p3
        p1.setVisible(true);
        p3.setVisible(false);
        window.setSize(500,325);
    }
});
p3.add(btn4);

//labels for this panel
l22 = new JLabel("FOR FULLTIME STAFFHIRE");
l22.setBounds(185,5,250,25);
l22.setForeground(Color.red);
p3.add(l22);

l13 = new JLabel("Staff Name : ");
l13.setBounds(55,50,100,25);
p3.add(l13);

l14 = new JLabel("Joining Date : ");
l14.setBounds(50,80,100,25);
p3.add(l14);

l15 = new JLabel("Qualification : ");
l15.setBounds(50,110,100,25);
p3.add(l15);

l16 = new JLabel("Appointed By : ");
l16.setBounds(45,140,100,25);
p3.add(l16);

l17 = new JLabel("Salary : ");
l17.setBounds(85,170,100,25);
p3.add(l17);

l18 = new JLabel("Working Shifts : ");
l18.setBounds(40,200,100,25);
p3.add(l18);

l19 = new JLabel("Wages Per Hour : ");
l19.setBounds(30,230,120,25);
p3.add(l19);

l20 = new JLabel("Working Hour : ");
l20.setBounds(45,260,100,25);
p3.add(l20);

//textfields for this panel
tf11 = new JTextField();
tf11.setBounds(150,50,150,25);
p3.add(tf11);

tf12 = new JTextField();
tf12.setBounds(150,80,150,25);
p3.add(tf12);

tf13 = new JTextField();
tf13.setBounds(150,110,150,25);
p3.add(tf13);

tf14 = new JTextField();
tf14.setBounds(150,140,150,25);
p3.add(tf14);

tf15 = new JTextField();
tf15.setBounds(150,170,150,25);
p3.add(tf15);

tf16 = new JTextField();
tf16.setBounds(150,200,150,25);
p3.add(tf16);

tf17 = new JTextField();
tf17.setBounds(150,230,150,25);
p3.add(tf17);

tf18 = new JTextField();
tf18.setBounds(150,260,150,25);
p3.add(tf18);

btn10 = new JButton("ADD");
btn10.setBounds(15,300,100,45);
btn10.addActionListener(new ActionListener(){ //adding actionlistener for add button
public void actionPerformed(ActionEvent ae){
    int vacancyNumber = Integer.parseInt(tf1.getText());
    String designation =tf2.getText();                  
    String jobType = bg.getSelection().getActionCommand(); 
    // condition checking if all the textfields value are empty or not
    if(tf11.getText().isEmpty() || tf12.getText().isEmpty() || tf13.getText().isEmpty() || tf14.getText().isEmpty() || tf15.getText().isEmpty() || tf16.getText().isEmpty() || tf17.getText().isEmpty() || tf18.getText().isEmpty()){
     JOptionPane.showMessageDialog(window, "Fill all the details!", "Error", 2);   
    }
 else{
     try{ //try and catch for NumberFormat Exception
         int salary = Integer.parseInt(tf15.getText ());              
         int workingHour =Integer.parseInt(tf18.getText ());
         String joiningDate = tf12.getText();
         int wagesPerHour = Integer.parseInt(tf17.getText());
          for(StaffHire s : al) // for the object of staffhire in the arraylist
                  {
                       if (s instanceof FullTimeStaffHire) // condition if object of staffhire instance of  fulltimiestaffhire
                       {
                       FullTimeStaffHire f = (FullTimeStaffHire)s; //type casting object of staff hire to fulltimestaffhire
                       if (f.getVacancyNumber() == vacancyNumber) //checking condition if  vacancy is already added
                       {
                            JOptionPane.showMessageDialog(window,"This vacancy number is already added","Error",JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    }
                  } 
           // creating object of fulltimestaffhire and passing values to the parameters
         FullTimeStaffHire ft = new FullTimeStaffHire(salary, workingHour, vacancyNumber, designation, jobType);        
         al.add(ft);                   
         JOptionPane.showMessageDialog( window,"FullTimeStaff sucessfully added" ,"Information",JOptionPane.INFORMATION_MESSAGE);                  
    }  
catch(NumberFormatException fe){        
    JOptionPane.showMessageDialog( window,"Enter the correct data " ,"Warning",JOptionPane.WARNING_MESSAGE); 
}
}
}
});
p3.add(btn10);

btn11 = new JButton("Appoint");
btn11.setBounds(150,300,100,45);
btn11.addActionListener(new ActionListener(){ //adding actionlistener for appoint button
public void actionPerformed(ActionEvent ae){
int vacancyNumber;
String staffName = tf11.getText().trim();
String joiningDate = tf12.getText().trim();
String qualification = tf13.getText().trim();
String appointedBy = tf14.getText().trim();
//checking if the teextfields are empty or not
if(tf11.getText().equals("") || tf12.getText().equals("") || tf13.getText().equals("") || tf14.getText().equals("") || tf15.getText().equals("") || tf16.getText().equals("") || tf17.getText().equals("") || tf18.getText().equals("")){
JOptionPane.showMessageDialog(window,  "please fill all the field", "Warning",2); 
return;
}
else{
try{ //try and catch for NumberFormat Exception
    vacancyNumber = Integer.parseInt(tf1.getText());   
}
catch(NumberFormatException e){
    JOptionPane.showMessageDialog(window,"please enter valid data" ,"Warning",JOptionPane.WARNING_MESSAGE); 
    return;
}
}
boolean vacancyfound = false; // assigning the boolean value vacancyfound as false
for(StaffHire staffhirearraylist: al){ // for the object of staffhire in the arraylist
if(staffhirearraylist instanceof FullTimeStaffHire){ //condition if object of staffhire instance of fulltimestaffhire
    FullTimeStaffHire fulltimestaff = (FullTimeStaffHire)staffhirearraylist; // type casting object of staffhire to fulltimestaffhire
    if(fulltimestaff.getVacancyNumber() == vacancyNumber){ // condition to check for the vacancy number
        vacancyfound = true;
        if(fulltimestaff.getJoined()==false){ // condition for if the vacacy is not joined
            JOptionPane.showMessageDialog(window,"successfully appointed","fulltimestaff sucessfully appointed",1);
        }else{
            JOptionPane.showMessageDialog(window,"Staff was appointed");
            fulltimestaff.hireFullTimeStaff(staffName, joiningDate, qualification, appointedBy);
            return;
        }
    }
}
}
}
});
p3.add(btn11);

btn14 = new JButton("Clear");
btn14.setBounds(270,300,100,45);
btn14.addActionListener(new ActionListener(){ //adding actionlistener for clear button
    public void actionPerformed(ActionEvent ae){
     // setting the textfields to null
     tf11.setText(null);
     tf12.setText(null);
     tf13.setText(null);
     tf14.setText(null);
     tf15.setText(null);
     tf16.setText(null);
     tf17.setText(null);
     tf18.setText(null);
    }
});
p3.add(btn14);

p3.setSize(500,500);
p3.setLayout(null);
p3.setVisible(false);
window.add(p3);
}
// This is the method  display details
public void displayDetails(){
for(StaffHire details : al){ // for the object of staffhire in the arraylist
if(details instanceof FullTimeStaffHire){ // condition if the object of staffhire is instance  of fulltimestaffhire
FullTimeStaffHire fulltimestaffdetails = (FullTimeStaffHire)details;//type casting the object of staffhire to fulltimestaffhire 
fulltimestaffdetails.display(); //calling the display method
}
else{
PartTimeStaffHire parttimestaffdetails = (PartTimeStaffHire)details;//type casting the object of staffhire to parttimestaffhire 
parttimestaffdetails.display(); //calling the display mehod
}
}
}

//This is the main method for INGNepal class
public static void main(String[] args){
new INGNepal(); //calling the constructor
}
}



