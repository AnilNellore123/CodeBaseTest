package com.zensar;

public class DessertShoppe {

	    public final static double TAX_RATE = 6.5;        // 6.5%
	    public final static String STORE_NAME = "M & M Dessert Shoppe";
	    public final static int MAX_ITEM_NAME_SIZE = 25;
	    public final static int COST_WIDTH = 6;

	    public static String cents2dollarsAndCents(int cents) {
	        String s = "";

	        if (cents < 0) {
	            s += "-";
	            cents *= -1;
	        }

	        int dollars = cents/100;
	        cents = cents % 100;

	        if (dollars > 0)
	            s += dollars;

	        s +=".";

	        if (cents < 10)
	            s += "0";

	        s += cents;
	        return s;
	    } 
	}


	public abstract class DessertItem {

	    protected String name;

	    public DessertItem() {
	        this("");
	    }

	    public DessertItem(String name) {
	        if (name.length() <= DessertShoppe.MAX_ITEM_NAME_SIZE)
	            this.name = name;
	        else
	            this.name = name.substring(0,DessertShoppe.MAX_ITEM_NAME_SIZE);
	    }

	    public final String getName() {
	        return name;
	    }

	    public abstract int getCost();
	}


	public class Cookie extends DessertItem{

	    protected double number;
	    protected double pricePerDoze;

	    public Cookie(String _n, double _ppd, int _number){
	        super(_n);
	        pricePerDoze = _ppd;
	        number = _number;
	    }

	    public int getCost(){
	        return  (int)Math.round(number / 12 * pricePerDoze);
	    }
	}


	public class Candy extends DessertItem{

	    protected double weight;
	    protected double pricePerPound;

	    public Candy(String _n, double _ppp, int _w){
	        //using parent's constructor with name while storing its own properties
	        super(_n);
	        pricePerPound = _ppp;
	        weight = _w;
	    }

	    public int getCost(){
	        return  (int)Math.round(weight * pricePerPound);
	    }
	}


	public class IceCream extends DessertItem{

	    protected int cost;

	    public IceCream(String _n, int _cost){
	        super(_n);
	        cost = _cost;
	    }

	    public int getCost(){
	        return  cost;
	    }
	}


	public class Sundae extends IceCream{

	    protected String topName;
	    protected int topCost;

	    public Sundae(String _n0, int _cost0, String _n1, int _cost1){
	        //put the icecream name in icecream while putting top name and cost in a separate property
	        super(_n0, _cost0);
	        topName = _n1;
	        topCost = _cost1;
	    }

	    public final String getName(){
	        //return both the icecream name and the topping name
	        return name + " " + topName;
	    }

	    public int getCost(){
	        //return the sum of the icecream and the topping
	        return cost + topCost;
	    }
	}


	public class Checkout{

	    protected int size;
	    protected DessertItem[] dessertItems;
	    protected int amount;
	    protected int sum;
	    protected final double taxRate;

	    Checkout(){
	        size = 100;
	        dessertItems = new DessertItem[size];
	        amount = 0;
	        sum = 0;
	        taxRate = DessertShoppe.TAX_RATE;
	    }

	    public void enterItem(DessertItem d){
	        dessertItems[amount] = d;
	        amount ++;
	    }

	    public int numberOfItems(){
	        return amount;
	    }

	    public int totalCost(){
	        //make sum into zero, and calculate price from every item
	        sum = 0;
	        for(int i = 0; i < amount; i ++){
	            sum += dessertItems[i].getCost();
	        }
	        return sum;
	    }

	    public int totalTax(){
	        //use the totalCost method
	        return (int)(Math.round(this.totalCost() * taxRate / 100));
	    }

	    public void clear(){
	        //clear the array
	        for(DessertItem d : dessertItems){
	            d = null;
	        }
	        amount = 0;
	        sum = 0;
	    }

	    public String toString(){
	        String result = "Thank You! \n";

	        result += DessertShoppe.STORE_NAME + "\n";

	        result += "Purchased: ";

	        String totalPay = DessertShoppe.cents2dollarsAndCents( totalCost()+totalTax() );
	        if(totalPay.length() > DessertShoppe.COST_WIDTH){
	            totalPay = totalPay.substring(0, DessertShoppe.COST_WIDTH);
	        }
	        result += "$" + totalPay;
	        return result;
	    }
	}


	public class TestCheckout {

	    public static void main(String[] args) {

	        Checkout checkout = new Checkout();

	        checkout.enterItem(new Candy("Peanut Butter Fudge", 2.25, 399));
	        checkout.enterItem(new IceCream("Vanilla Ice Cream",105));
	        checkout.enterItem(new Sundae("Choc. Chip Ice Cream",145, "Hot Fudge", 50));
	        checkout.enterItem(new Cookie("Oatmeal Raisin Cookies", 4, 399));

	        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
	        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
	        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
	        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
	        System.out.println(checkout);

	        checkout.clear();

	        checkout.enterItem(new IceCream("Strawberry Ice Cream",145));
	        checkout.enterItem(new Sundae("Vanilla Ice Cream",105, "Caramel", 50));
	        checkout.enterItem(new Candy("Gummy Worms", 1.33, 89));
	        checkout.enterItem(new Cookie("Chocolate Chip Cookies", 4, 399));
	        checkout.enterItem(new Candy("Salt Water Taffy", 1.5, 209));
	        checkout.enterItem(new Candy("Candy Corn",3.0, 109));

	        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
	        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
	        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
	        System.out.println("\nCost + Tax: " + (checkout.totalCost() + checkout.totalTax()) + "\n");
	        System.out.println(checkout);
	    }
	}
