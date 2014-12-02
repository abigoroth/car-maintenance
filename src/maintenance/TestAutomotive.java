// package project;


package maintenance;
// from listModelExample
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import javax.swing.*;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
// 

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class TestAutomotive {

	// private NewJPanel newjpanel = new NewJPanel();
	public static void main(String[] args){
		// System.out.println("heee");

		OwnerList owners = new OwnerList();
		Owner o1 = owners.addOwner("Yakob", "no25", "0172931521");
		Owner o2 = owners.addOwner("Rodza", "208 L05", "01999999");
		Car c1 = o1.addCar("Proton Saga", 1990, "ABK456", "WHITE");
		Car c2 = o1.addCar("Mitsubishi EVO", 1990, "ABK123", "RED");
		Car c3 = o1.addCar("Skyline GTR", 2014, "Y1", "BLACK");

		Service s1 = new ChangeParts("Tyre", 300, 20);
		Service s3 = new ChangeParts("Engine Oil", 50, 20);
		Service s2 = new CarWash(10, 5, 5);
		// Visit v = c1.addVisit("Amir");
		// try{		
		// 	v.addService(s1);
		// 	v.addService(s2);
		// 	v.addService(s3);
		// } catch( Exception e){
		// 	System.out.println("Error add service : " + e);
		// }
		// c1.displayInfo();

		System.out.println("Printing out from owner list");
		for(int i = 0; i < owners.getOwnerCount(); i++){
			System.out.println( owners.getList()[i].getName() );
		}

    JFrame frame2 = new JFrame("Car Maintenance System");
    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame2.setContentPane(new NewJPanel(owners));
    frame2.setSize(664, 436);
    frame2.setVisible(true);
	}
}

class Owner {
	int carCounter = 0;
	public String name, address, phone;
	private Car [] cars = new Car[100];
	public Owner(String n, String a, String p){
		name = n;
		address = a;
		phone = p;
	}
	public String getName(){ return name; }
	public String getAddress(){ return address; }
	public String getPhone(){ return phone; }
	public Car addCar(String m, int y, String r, String c){
		cars[carCounter] = new Car(m, y, r, c, this);
		carCounter += 1;
		try{
			NewJPanel.addCar(m);
		} catch ( Exception e ){
			System.out.println("Error adding car : "+ e);
		}
		return cars[carCounter-1];
	}
	public void delCar(int idx){
		System.arraycopy(cars,idx+1,cars,idx,cars.length-1-idx);
		NewJPanel.delCar(idx);
	}
	public Car[] getCars(){ return cars; }
	public int getCarCounter(){ return carCounter; }
}

class OwnerList {
	private int ownerCounter = 0; 
	public int getOwnerCount(){ return ownerCounter; }
	Owner [] owners = new Owner[100];
	public OwnerList(){ }
	public Owner addOwner(String n, String a, String p){
		owners[ownerCounter] = new Owner(n, a, p);
		ownerCounter += 1;
		try {
			NewJPanel.addOwner(n);
		} catch (Exception e){
			System.out.println("error" + e);
		}
		// modelOwner.addElement("dfdfdfdf");
		// addOwner("hehe from main TestAutomotive");
		return owners[ownerCounter-1];
	}
	public Owner[] delOwner(int idx){
		System.arraycopy(owners,idx+1,owners,idx,owners.length-1-idx);
		// owners = ArrayUtils.removeElement(owners, owners[idx]);
		NewJPanel.delOwner(idx);
		return owners;
	}
	public Owner[] getList(){ return owners; }
}

class Car {
	int serviceCount = 0; // car has many service record through visits
	int year;
	private String model, registration_no, color;
	private Owner ownr;
	Service [] services = new Service[10];
	public Car(String m, int y, String r, String c, Owner o){
		model = m;
		year = y;
		registration_no = r;
		color = c;
		ownr = o;
	}
	public void displayInfo(){
		System.out.println("Model\t\t:" + model);
		System.out.println("Year\t\t:" + year);
		System.out.println("Registration #\t:" + registration_no);
		System.out.println("Owner\t\t:" + ownr.getName() );
		System.out.println("Address\t\t:" + ownr.getAddress() );
		System.out.println("Phone\t\t:" + ownr.getPhone() );
		System.out.println("----------");
		for (int i = 0; i < serviceCount; i++){
			services[i].displayInfo();
		}
	}

	public String getModel(){ return model; }
	public String getRegistration(){ return registration_no; }
	public int getYear(){ return year; }
	public String getColor(){ return color; }

	Visit[] visits = new Visit[100];
	int visitCount = 0;
	public Visit addVisit(String e){
		visits[visitCount] = new Visit(e);
		visitCount += 1;
		try{
			ServicePanel.addVisit(new Date().toString());
		} catch (Exception exp){
			System.out.println("Error adding visit to a car "+ exp);
		}
		return visits[visitCount-1];
	}
	public Visit[] getVisits(){ return visits; }
	public void delVisit(int idx){
		System.arraycopy(visits,idx+1,visits,idx,visits.length-1-idx);
		ServicePanel.delVisit(idx);	
	}
}

abstract class Service {
	int id;
	public Service(){};
	public abstract double getTotalCharges();
	public abstract void displayInfo();
	public abstract String brief();
	public abstract Boolean isWash();
	public abstract String[] getInfo();
}

class ChangeParts extends Service {
	String partName;
	double partCharges, laborCharges;
	public ChangeParts(String n, double c, double l){
		partName = n;
		partCharges = c;
		laborCharges = l;
	}
	public void displayInfo(){
		System.out.println("------------ Change Parts ----------");
		System.out.println("Part name\t: " + partName);
		System.out.println("Price\t\t: " + partCharges);
		System.out.println("Labor charge\t: " + laborCharges);
	}
	public double getTotalCharges(){ 
		double total = partCharges + laborCharges;
		return total;
	}
	public String brief(){ return "Change Part: " + partName; }
	public Boolean isWash(){ return false; }
	public String[] getInfo(){ 
		String[] s = {partName, String.valueOf( partCharges ) , String.valueOf( laborCharges ) }; 
		return s;
	}
}

class CarWash extends Service {
	double washCharges, polishCharges, vacuumCharges;
	public CarWash(double w, double p, double v){
		washCharges = w;
		polishCharges = p;
		vacuumCharges = v;
	}
	public double getTotalCharges(){ 
		double total = washCharges + polishCharges + vacuumCharges;
		// total = total - getTotalCharges( total );
		return total;
	}
	public void displayInfo(){ 
		System.out.println("------------ Car Wash ----------");
		System.out.println("Wash charge\t: " + washCharges);
		System.out.println("Polish charge\t: " + polishCharges);
		System.out.println("Vacuum charge\t: " + vacuumCharges);
	}
	public String brief(){ return "Wash"; }
	public Boolean isWash(){ return true; }
	public double getWashCharge(){ return washCharges; }
	public double getPolishCharge(){ return polishCharges; }
	public double getVacuumCharge(){ return vacuumCharges; }
	public String[] getInfo(){ 
		String[] s = {String.valueOf(washCharges) , String.valueOf( polishCharges ) , String.valueOf( vacuumCharges ) }; 
		return s;
	}
}

class Visit implements Discountable { // visit has many service record too instead of car
	Date date;
	String employee;
	Service [] services = new Service[100];
	int serviceCount = 0;

	public Visit(String e){
		date = new Date();
		employee = e;
	}
	public Visit(){}

	public void addService(Service s){
		services[serviceCount] = s;
		serviceCount += 1;
		ServicePanel.addService(s.brief());
		ServicePanel.updateTotalCost( sumUpCharges() );
	}

	public double[] sumUpCharges(){
		double change_parts = 0;
		double wash_charges = 0;
		double charges = 0;
		for(Service s: services){
			if (s != null){			
				if (s.isWash()){
					wash_charges += s.getTotalCharges();
				} else {
					change_parts += s.getTotalCharges();
				}
				System.out.println("sum up charges " + s.getTotalCharges() );
				charges += s.getTotalCharges();
			}
		}
		double wash_discount = calcDiscount(change_parts);
		if (wash_charges - wash_discount < 0){
			wash_charges = 0;
		} else { wash_charges = wash_charges - wash_discount; }
		double [] s = { change_parts + wash_charges , change_parts, wash_charges, wash_discount };
		return s;
	}

	public Service[] getServices(){ return services; }
	public Date getDate(){ return date; }
	public String getEmployee(){ return employee; }
	public int getServiceCount(){ return serviceCount; }
	public void delService(int idx){ 
		System.arraycopy(services,idx+1,services,idx,services.length-1-idx);
		ServicePanel.delService(idx);	
	}

	public double calcDiscount(double totalCharges){
		if (totalCharges >= TRIGGER_DISCOUNT){
			return WASH_DISCOUNT;
		} else {
			return 0;
		}
	}
	public static double getCalcWashDiscountTrigger(){ return TRIGGER_DISCOUNT; }
}

interface Discountable {
	double TRIGGER_DISCOUNT = 500;
	double WASH_DISCOUNT = 20;
	public double calcDiscount(double totalCharges);
}