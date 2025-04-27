<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Hema Malini B
*	Created On		:	24 Jan 2005

-->
<%@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,webbeans.eCommon.*,eCommon.Common.* " %>
<%-- Mandatory declarations start --%>
	<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<% 
//This file is saved on 18/10/2005.
String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
%>
<link rel='stylesheet' type='text/css'href='../../eCommon/html/<%=sStyle%>'></link>

<% ecis.utils.CommonQueryPage querypage= new ecis.utils.CommonQueryPage();
StringBuffer strbuf;

Connection con=null;
PreparedStatement Practitioner_pstmt=null;
ResultSet Practitioner_rs=null;

try{
	con=ConnectionManager.getConnection(request);
	
  ArrayList Practitioner_Data		= new ArrayList() ;
  String[] record  = null;
  String Practitioner_sql="";

  

  Practitioner_sql="Select pract_type, desc_userdef from am_pract_type where eff_status = 'E' order by desc_userdef";

  Practitioner_pstmt=con.prepareStatement(Practitioner_sql);
  Practitioner_rs= Practitioner_pstmt.executeQuery();
  	 	try{
		   if(Practitioner_rs!=null)
		     {
			 while(Practitioner_rs.next())
			  {
				 record=new String[2];
					record[0]= Practitioner_rs.getString("pract_type");
					record[1]=  Practitioner_rs.getString("desc_userdef");
					Practitioner_Data.add(record);
			  }
			 }
	 }catch(Exception exp){exp.toString();}
	ArrayList finalArray=new ArrayList();

	ArrayList firstItem=new ArrayList();
	firstItem.add("List"); //Type of item
	firstItem.add("Practitioner Type"); // label
	firstItem.add("pract_type"); //name
	
	String strList="%"+","+"-------------------All----------------------"+",";
	for( int k=0;k<Practitioner_Data.size();k++)
	{
		record=(String[])Practitioner_Data.get(k);
		strList=strList+ (String)record[0]+","+(String)record[1]+",";
	}
	firstItem.add(strList);  //Values to be passed
   	finalArray.add(firstItem);

    ArrayList secondItem=new ArrayList();
	secondItem.add("Text"); //Type of item
	secondItem.add("Practitioner Name"); // label
	secondItem.add("practitioner_name"); //name
	secondItem.add("30");  //size
    secondItem.add("30");   //Length
	finalArray.add(secondItem);

	ArrayList ThirdItem=new ArrayList();
	ThirdItem.add("Text"); //Type of item
	ThirdItem.add("Practitioner ID"); // label
	ThirdItem.add("practitioner_id"); //name
	ThirdItem.add("15");  //size
	ThirdItem.add("15");  //Length

   	finalArray.add(ThirdItem);

	
	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];

	orderByCols[0]	= "Practitioner Type";
	orderByCols[1]	= "Practitioner Name";
	orderByCols[2]	= "Practitioner ID";
	
	orderByColVals[0] = "c.pract_type";
	orderByColVals[1] = "practitioner_name";
	orderByColVals[2] = "b.practitioner_id";


   strbuf = querypage.getQueryPage(con,finalArray,"AccessRights","../jsp/CPAccessRightsQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

   out.println(strbuf.toString());

}catch(Exception e)
{//out.println(e.toString());//common-icn-0181
e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(Practitioner_rs != null) Practitioner_rs.close();
	if(Practitioner_pstmt != null) Practitioner_pstmt.close();
	ConnectionManager.returnConnection(con,request);
}


%>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>
