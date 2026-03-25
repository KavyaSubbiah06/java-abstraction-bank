import java.util.*;

abstract class Account{
    long Accnumber;
    String name;
    String Branch_name;
    String IFSC;
    long phnum;
    double balance;
    
    Account(long Accnumber, String name, String Branch_name, String IFSC, long phnum, double balance){
        this.Accnumber = Accnumber;
        this.name = name;
        this.Branch_name = Branch_name;
        this.IFSC = IFSC;
        this.phnum = phnum;
        this.balance = balance;
    }

    abstract void deposit(double amt);
    abstract void withdraw(double amt);
    abstract void transferAccount(String newBank, String newIFSC);

    void showDetails(){
        System.out.println("Account Number: " + Accnumber);
        System.out.println("Name: " + name);
        System.out.println("Bank Name: " + Branch_name);
        System.out.println("IFSC: " + IFSC);
        System.out.println("Phone Number: " + phnum);
        System.out.println("Balance: " + balance);
    }
}

class BANK extends Account{

    BANK(long Accnumber, String name, String Branch_name, String IFSC, long phnum, double balance){
        super(Accnumber, name, Branch_name, IFSC, phnum, balance );
    }

    @Override
    public void deposit(double amt){
        balance += amt;
        System.out.println("Deposited Amount: " + amt);
        System.out.println("Balance: " + balance);
    }

    @Override
    public void withdraw(double amt){
        if(amt <= balance){
            balance -= amt;
            System.out.println("Withdraw Amount: " + amt);
            System.out.println("Balance: " + balance);  
        }
        else{
            System.out.println("Insufficient balance");
        }
    }

    @Override
    public void transferAccount(String newBank, String newIFSC){
        Branch_name = newBank;
        IFSC = newIFSC;
        System.out.println("Account successfully transferred to:");
        System.out.println("New Bank: " + Branch_name);
        System.out.println("New IFSC: " + IFSC);
    }
}

class Main{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);

        BANK b1 = new BANK(1234567, "Kavya", "SBI", "SBI34567", 908756, 5500.76);

        int choice;

        do{
            System.out.println("\n1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Transfer account to another bank");
            System.out.println("4.Show account details");
            System.out.println("5.Exit");

           System.out.print("Enter choice: ");
            if(!sc.hasNextInt()){
                break;
            }
            choice = sc.nextInt();
            switch(choice){

    case 1:
        System.out.print("Enter deposit amount: ");
        double d = sc.nextDouble();
        b1.deposit(d);
        break;

    case 2:
        System.out.print("Enter withdraw amount: ");
        double w = sc.nextDouble();
        b1.withdraw(w);
        break;

    case 3:
        sc.nextLine();
        System.out.print("Enter new bank name: ");
        String bank = sc.nextLine();

        System.out.print("Enter new IFSC code: ");
        String ifsc = sc.nextLine();

        b1.transferAccount(bank, ifsc);
        break;

    case 4:
        b1.showDetails();
        break;

    case 5:
        System.out.println("Exiting...");
        break;

    default:
        System.out.println("Invalid choice. Please enter a number between 1 and 5.");
}

        }while(choice != 5);
    }
}