package main;

import java.util.Date;

public class Reservation
{
  private int reservation_id;
  private int tablenumber;
  private Date dateandtime;
  private String name;
  private int people;
  private int customer_id;
  
  public Reservation(int reservation_id, int tablenumber, Date dateandtime,
      String name, int people, int customer_id) {
    super();
    this.reservation_id = reservation_id;
    this.tablenumber = tablenumber;
    this.dateandtime = dateandtime;
    this.name = name;
    this.people = people;
    this.customer_id = customer_id;
  }

  public int getTablenumber()
  {
    return tablenumber;
  }

  public void setTablenumber(int tablenumber)
  {
    this.tablenumber = tablenumber;
  }

  public Date getDateandtime()
  {
    return dateandtime;
  }

  public void setDateandtime(Date dateandtime)
  {
    this.dateandtime = dateandtime;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public int getPeople()
  {
    return people;
  }

  public void setPeople(int people)
  {
    this.people = people;
  }

  public int getCustomer_id()
  {
    return customer_id;
  }

  public void setCustomer_id(int customer_id)
  {
    this.customer_id = customer_id;
  }

  public int getReservation_id()
  {
    return reservation_id;
  }
  
  
  
}
