package main;

public class Dish
{
	private int ID;
	private String name;
	private String descripton;
	private double price;
	private int[] ingredient_id;
	
	public Dish(int iD, String name, String descripton, double price,
      int[] ingredient_id) {
    super();
    ID = iD;
    this.name = name;
    this.descripton = descripton;
    this.price = price;
    this.ingredient_id = ingredient_id;
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

	public int getID() {
		return ID;
	}
	
	
	
}
