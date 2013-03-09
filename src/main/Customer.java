package main;

public class Customer
{

  private int customer_id;
  private String email;
  private String password;
  private String address;
  private String phone;
  
  public Customer(int customer_id, String email, String password,
      String address, String phone) {
    super();
    this.customer_id = customer_id;
    this.email = email;
    this.password = password;
    this.address = address;
    this.phone = phone;
  }

  public String getEmail()
  {
    return email;
  }

  public void setEmail(String email)
  {
    this.email = email;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getAddress()
  {
    return address;
  }

  public void setAddress(String address)
  {
    this.address = address;
  }

  public String getPhone()
  {
    return phone;
  }

  public void setPhone(String phone)
  {
    this.phone = phone;
  }

  public int getCustomer_id()
  {
    return customer_id;
  }
  
  
}
