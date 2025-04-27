
<%@ page import ="eBL.*,eBL.Common.*,java.sql.*,oracle.jdbc.*,java.math.*,java.net.*,java.text.*,webbeans.eCommon.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="org.json.simple.JSONObject"%>  

 
<%

String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";

Connection con				= null;
PreparedStatement pstmt		= null;
Statement stmt				= null;
ResultSet rs				= null;		


try
{
	//String locale	= (String)session.getAttribute("LOCALE");	
	//if(locale==null || locale.equals("")) locale="en";	

	String facilityid = (String) session.getValue("facility_id");
	if (facilityid==null) facilityid = "";
con	=	ConnectionManager.getConnection(request);
	
String sqlSplAgenDepYN = BlRepository.getBlKeyValue("RECPT_TYP_SPLAGEN_DEPOSIT_YN");

System.out.println("sqlSplAgenDepYN :: "+sqlSplAgenDepYN);

String recptNatCode =request.getParameter("rcptNatcode"); //"MI";
String recptTypCode =null;
String recptTypLongDesc =null;
String splAgnDepYN =null;
String recTypCode = request.getParameter("recTypCode");
System.out.println("recTypCode >>>>> "+recTypCode);

pstmt = con.prepareStatement(sqlSplAgenDepYN);
pstmt.setString(1,"en");
pstmt.setString(2,facilityid);
pstmt.setString(3,recptNatCode);
pstmt.setString(4,recTypCode);
rs = pstmt.executeQuery() ;

if( rs != null ) 
{	
	while( rs.next() )
	{  
		recptTypCode = rs.getString(1);
		recptTypLongDesc = rs.getString(2);
		splAgnDepYN  = rs.getString(3);
		System.out.println("recptTypCode/recptTypLongDesc/splAgnDepYN "+recptTypCode+"/"+recptTypLongDesc+"/"+splAgnDepYN);		
		out.println(recptTypCode+"::"+recptTypLongDesc+"::"+splAgnDepYN);	
	}
}
if (rs != null) rs.close();
pstmt.close();	

}catch(Exception e)
{
	System.out.println("Exception in Special Agency Deposit check"+e);
}


%>












