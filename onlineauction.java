class ticket
{
  private String username;
  private String password;
  private String place;
  private String amount;
  
  public ticket(String username,String password,String place,String amount)
  {
    this.username=username;
    this.password=password;
    this.place=place;
    this.amount=amount;
  }
  
  public boolean insertTicketRecord() throws SQLException
  {
    //connect to a database 
    dbmsConnection connect=null;
    PreparedStatement stmt=null;
    Connection con = null;
    boolean insert=false;
    try
    {
      connect = new dbmsConnection("jdbc:mysql://localhost:3306/alekhya","root","1234");
      con=connect.getConnection();
      String sql = "insert into onlineauction values (?,?,?,?);";
      stmt=con.prepareStatement(sql);
      stmt.setString(1, username);
      stmt.setString(2, password);
      stmt.setString(3, place);
      stmt.setString(4, amount);
      int i= stmt.executeUpdate();
      if(i<=0)
      {
          insert=true;
      }
      else
      {
        insert=false;
      }
    }
    catch(Exception e)
    {
      System.out.println(e.getMessage());
    }
    finally
    {
      connect.closeConnection(stmt, con);
    }
    
    return insert;
  }
}
