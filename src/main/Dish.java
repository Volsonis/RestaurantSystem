package main;

public class Dish
{
	private int ID;
	private String name;
	private String descripton;
	private double price;
	private String type;
	private int[] ingredient_id;
	//it would make sense to chache the name of the ingredients as well
	private String[] ingredients;
	
	//this is only used to temporarily create the new dish, while the data is still unknown
	public Dish() {
    //empty constructor
  }

  //used to create a new dish
	public Dish(String name, String descripton, double price, String type,
      int[] ingredient_id) {
    super();
    this.name = name;
    this.descripton = descripton;
    this.price = price;
    this.setType(type);
    this.ingredient_id = ingredient_id;
  }
	
	//used to display dishes
	public Dish(int iD, String name, String descripton, double price, String type,
      int[] ingredient_id, String[] ingredients) {
    super();
    ID = iD;
    this.name = name;
    this.descripton = descripton;
    this.price = price;
    this.setType(type);
    this.ingredient_id = ingredient_id;
    this.setIngredients(ingredients);
  }

  //this should not be possible anymore later, just for testing
  public Dish(int iD, String name, String descripton, double price)
	{
		super();
		ID = iD;
		this.name = name;
		this.descripton = descripton;
		this.price = price;
	}

	public int[] getIngredient_id()
  {
    return ingredient_id;
  }

  public void setIngredient_id(int[] ingredient_id)
  {
    this.ingredient_id = ingredient_id;
  }

  public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescripton() {
		return descripton;
	}

	public void setDescripton(String descripton) {
		this.descripton = descripton;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType()
  {
    return type;
  }

  public void setType(String type)
  {
    this.type = type;
  }

  public int getID() {
		return ID;
	}



  public String[] getIngredients()
  {
    return ingredients;
  }



  public void setIngredients(String[] ingredients)
  {
    this.ingredients = ingredients;
  }
  
  public String ingredientsToString()
  {
    String names = "";
    
    for(int i=0; i<ingredients.length; i++)
      names += ingredients[i] + ", ";
    
    return names;
  }
	
	
	
}
