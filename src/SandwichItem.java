import java.util.ArrayList;
import java.util.List;

interface SandwichItem {

	public String name();

}

abstract class Bread implements SandwichItem { 
	
}
class LOWER_REGULAR_BUN extends Bread {
	
	 @Override
	   public String name() {
	      return "LOWER REGULAR BUN";
	   }
}
class UPPER_REGULAR_BUN extends Bread {
	
	 @Override
	   public String name() {
	      return "UPPER REGULAR BUN";
	   }
}
class LOWER_ARTISAN_ROLL extends Bread {
	
	 @Override
	   public String name() {
	      return "LOWER ARTISAN ROLL";
	   }
}
class UPPER_ARTISAN_ROLL extends Bread {
	
	 @Override
	   public String name() {
	      return "UPPER ARTISAN ROLL";
	   }
}

abstract class BeefPatty implements SandwichItem { }

class Regular_BeefPatty extends BeefPatty {
	
	 @Override
	   public String name() {
	      return "100% BEEF PATTY";
	   }
}
class QuarterPound extends BeefPatty {
	
	 @Override
	   public String name() {
	      return "QUARTER POUND 100% BEEF PATTY";
	   }
}

abstract class Sauce implements SandwichItem { }

class KETCHUP extends Sauce {
	
	 @Override
	   public String name() {
	      return "KETCHUP";
	   }
}

class BISTRO_AIOLI extends Sauce {
	 @Override
	   public String name() {
	      return "BISTRO AIOLI";
	   }
}

class MUSTARD extends Sauce {
	 @Override
	   public String name() {
	      return "MUSTARD";
	   }
}
abstract class Cheese implements SandwichItem { }

class SWISS_CHEESE extends  Cheese {
	 @Override
	   public String name() {
	      return "SWISS CHEESE";
	   }
}

class AMERICAN_CHEESE extends Cheese {
	 @Override
	   public String name() {
	      return "PASTEURIZED PROCESS AMERICAN CHEESE";
	   }
}

abstract class Onion implements SandwichItem { }

class Regular_Onion extends  Onion {	
	 @Override
	   public String name() {
	      return "ONIONS";
	   }
}

class FRIED_ONION extends Onion {
	 @Override
	   public String name() {
	      return "FRIED ONION STRINGS";
	   }
}

class  SEASONED_MUSHROOMS implements SandwichItem  {	
	 @Override
	   public String name() {
	      return "SEASONED MUSHROOMS";
	   }
}

class  PICKLE_SLICES implements SandwichItem  {
	 @Override
	   public String name() {
	      return "PICKLE SLICES";
	   }
}

class  GRILL_SEASONING implements SandwichItem  {	
	 @Override
	   public String name() {
	      return "GRILL SEASONING";
	   }
}
interface Meal {
	 public String getDescription();
}

abstract class MealDecorator implements Meal {
	
	private Meal mealToBeDecorated;
	 public MealDecorator (Meal mealToBeDecorated) {
	        this.mealToBeDecorated =mealToBeDecorated;
	    }
	 @Override
	   public String getDescription() {
		 return mealToBeDecorated.getDescription();
	 }
}

class soda extends MealDecorator {
	
	public soda (Meal mealToBeDecorated) {
        super(mealToBeDecorated);
    }
	@Override
	   public String getDescription() {
		 return super.getDescription() + " + Soda ";
	 }
	
	
}

class Fries extends MealDecorator {
	public Fries (Meal mealToBeDecorated) {
        super(mealToBeDecorated);
    }
	 @Override
	   public String getDescription() {
		 return super.getDescription() + " + Fries";
	 }
}

class MealSandwich implements Meal  {
	   private List<SandwichItem> items = new ArrayList<SandwichItem>();	
	   public String Description;
	   
	   public void addItem(SandwichItem item){
	      items.add(item);
	   }
	   public void showDescription(){
		   
		      for (SandwichItem item : items) {
		         System.out.println(item.name());
		      }		
		   }
	   @Override
	   public String getDescription() {
		   return Description;
	   }
	  	
}

class  MealSandwichBuilder {

	   public  MealSandwich make_cheeseburger(){
		   MealSandwich  mealSandwich = new  MealSandwich();
		   mealSandwich.addItem(new LOWER_REGULAR_BUN());
		   mealSandwich.addItem(new Regular_BeefPatty() );
		   mealSandwich.addItem(new AMERICAN_CHEESE());
		   mealSandwich.addItem(new KETCHUP());
		   mealSandwich.addItem(new MUSTARD());
		   mealSandwich.addItem(new PICKLE_SLICES());
		   mealSandwich.addItem(new Regular_Onion());
		   mealSandwich.addItem(new UPPER_REGULAR_BUN());
	      
		   mealSandwich.Description ="Cheeseburger";
	      return  mealSandwich;
	   }   
	   public  MealSandwich make_double_cheeseburger(){
		   MealSandwich  mealSandwich = new  MealSandwich();
		   
		   mealSandwich.addItem(new LOWER_REGULAR_BUN());
		   mealSandwich.addItem(new Regular_BeefPatty());
		   mealSandwich.addItem(new AMERICAN_CHEESE());
		   mealSandwich.addItem(new Regular_BeefPatty());
		   mealSandwich.addItem(new AMERICAN_CHEESE());
		   mealSandwich.addItem(new KETCHUP());
		   mealSandwich.addItem(new MUSTARD());
		   mealSandwich.addItem(new PICKLE_SLICES());
		   mealSandwich.addItem(new Regular_Onion());
		   mealSandwich.addItem(new UPPER_REGULAR_BUN());
		   
		   mealSandwich.Description ="Double Cheeseburger";
	      
	      return  mealSandwich;
	   }  
	   
	   public  MealSandwich make_mushroom_SwissBurger (){
		   MealSandwich  mealSandwich = new  MealSandwich();
	       mealSandwich.addItem(new LOWER_ARTISAN_ROLL() );
		   mealSandwich.addItem(new QuarterPound () );
		   mealSandwich.addItem(new  SWISS_CHEESE());
		   mealSandwich.addItem(new SEASONED_MUSHROOMS());
		   mealSandwich.addItem(new FRIED_ONION() );
		   mealSandwich.addItem(new BISTRO_AIOLI ());
		   mealSandwich.addItem(new GRILL_SEASONING ());
		   mealSandwich.addItem(new UPPER_ARTISAN_ROLL());
		   mealSandwich.Description ="Mushroom & Swiss Burger";
		   
		   return  mealSandwich;
	}
}


class MealCreator {
	   public static void main(String[] args) {

          		   
	      MealSandwichBuilder mealSandwichBuilder = new MealSandwichBuilder(); 
	      
	      MealSandwich Sandwich = mealSandwichBuilder.make_mushroom_SwissBurger();
	     
	      // for cheese burger
	      // MealSandwich Sandwich = mealSandwichBuilder.make_cheeseburger();
	      //for double cheese burger
	      //MealSandwich Sandwich = mealSandwichBuilder.make_double_cheeseburger();
	      
	      
	      System.out.println("Meal");
	      Sandwich.showDescription();
	      
	      
	      //for fries and soda
	      Meal FriesSodaMeal = new  Fries (new soda (Sandwich));
	      System.out.println("With Fries And Soda");
	      System.out.println(FriesSodaMeal.getDescription());
	      
	     
	   }
}
