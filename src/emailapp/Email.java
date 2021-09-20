package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity=500;

    private String alternateEmail;
    private int defaultPasswordLength=8;
    private String companySuffix = "KoalaTea.com";
    //constructor to receive the first name and last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

        //call a method asking for the department+return the department
        department = setDepartment();

        // call a method that returns a random password
        password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is "+ password);

        //return the email address
        email = firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companySuffix;
        System.out.println("Your email is: "+email);

    }

    //ask for the department
    private String setDepartment(){
        System.out.println("New worker: "+firstName+"\nDEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting \n0 for None\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice=in.nextInt();
        if(depChoice==1){return "sales"; }
        else if(depChoice==2){return "dev";}
        else if(depChoice==3){return "acct ";}
        else{return "";}
    }
    //generate random password
    private String randomPassword(int length){
    String passwordSet = "ABCD34SAFJDFIS323R";
    char[] password = new char[length];
    for(int i =0; i<length;i++){
        int rand = (int)(Math.random()*passwordSet.length());
        password[i]=passwordSet.charAt(rand);
    }
    return new String(password);
}
    //set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }
    //set alternate email
    public void setAlternateEmail(String altEmail){
        alternateEmail =altEmail;
    }
    //change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){return mailboxCapacity;}
    public String getAlternateEmail(){return alternateEmail;}
    public String getPassword(){return password;}

    public String showInfo(){
        return "DISPLAY NAME: " +firstName+"."+lastName+
                "\nCOMPANY EMAIL: "+email+
                "\nMAILBOX CAPACITY: "+mailboxCapacity+"mb";
    }
}
