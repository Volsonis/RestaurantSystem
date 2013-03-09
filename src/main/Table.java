package main;

public class Table
{

  private int number;
  private String tabledetails;
  private double revenue;
  
  public Table(int number, String tabledetails, double revenue) {
    super();
    this.number = number;
    this.tabledetails = tabledetails;
    this.revenue = revenue;
  }

  public String getTabledetails()
  {
    return tabledetails;
  }

  public void setTabledetails(String tabledetails)
  {
    this.tabledetails = tabledetails;
  }

  public double getRevenue()
  {
    return revenue;
  }

  public void setRevenue(double revenue)
  {
    this.revenue = revenue;
  }

  public int getNumber()
  {
    return number;
  }
  
  
}
