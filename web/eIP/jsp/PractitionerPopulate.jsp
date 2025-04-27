<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*,java.util.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get("SEARCH") ;
	
	String practid = request.getParameter("ippractid");
	
	String facilityId	= (String) session.getValue("facility_id");
	String dateVal = request.getParameter("dateVal");
		if(dateVal == null) dateVal= "";
	String booking = request.getParameter("booking");
		if(booking == null) booking ="";
	String expdate = request.getParameter("expdate");
		if(expdate == null) expdate ="";		
  
		
		
	
	Connection con= null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;
	PreparedStatement pstmt1 =null;
	ResultSet rs1 = null;

try{	
	con = ConnectionManager.getConnection(request);	
	out.println("<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	String selectsql = "select distinct(a.short_desc) short_desc ,a.team_id,b.practitioner_id from 	"+
					" am_medical_team a,am_pract_for_team b   where  				"+
					" a.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id 		"+
					" and b.practitioner_id ='"+practid+"' and b.team_id=a.team_id";
	pstmt 	= con.prepareStatement( selectsql ) ;
	rs = pstmt.executeQuery() ;
	String str1 = "";
	String str2 = "";
	if( rs != null ) 
	{
	    if(booking.equals("booking"))
	    { 
	    while( rs.next() ) 
		{
			str1 = rs.getString( "team_id" ) ;
			str2 = rs.getString( "short_desc" );
			out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
				"element.text = \""+str2+"\";"+ 
				"element.value= \""+str1+"\";"+
				"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
		}		
	    }
	    else if(booking.equals("admit"))
	    {
		while( rs.next() ) 
		{
			str1 = rs.getString( "team_id" ) ;
			str2 = rs.getString( "short_desc" );
			out.println(	"<script> var element = parent.f_query_add_mod.document.frames[2].document.createElement('OPTION');"+
				"element.text = \""+str2+"\";"+ 
				"element.value= \""+str1+"\";"+
				"parent.f_query_add_mod.document.frames[2].document.forms[0].team_id.add(element);</script>");
		}
	     }

	   if(booking.equals("transfer"))
	  {
	   while( rs.next() ) 
		{
			str1 = rs.getString( "team_id" ) ;
			str2 = rs.getString( "short_desc" );
			out.println(	"<script> var element = parent.frames[1].document.createElement('OPTION');"+
				"element.text = \""+str2+"\";"+ 
				"element.value= \""+str1+"\";"+
				"parent.frames[1].document.forms[0].team_id.add(element);</script>");				 
		}		     
	  }
	}
	pstmt.close() ;      		

		out.println("</script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'></body></html>");
	
	

   if(expdate.equals("expdate"))
    {				
	if(!dateVal.equals(""))
	{	
		pstmt1 	= con.prepareStatement( "select to_char(sysdate+'"+dateVal+"','dd/mm/rrrr hh24:mi') disdate from dual");
		rs1 = pstmt1.executeQuery();
		if(rs1.next())
		{
			String Expdate = rs1.getString("disdate");
			out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = '"+Expdate+"';parent.f_query_add_mod.document.frames[2].document.forms[0].circumstance_of_injury.focus();</script>");				
		}
	}
	else
	{
			out.println("<script>parent.f_query_add_mod.document.frames[2].document.forms[0].expecteddischargedate.value = ''</script>");				
	
	}
    }
	
		
	
}catch(Exception e){/* out.println("Exception in tryCatch : "+ e.toString()); */ e.printStackTrace();}

	finally{
	 	ConnectionManager.returnConnection(con,request);	

		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		if(pstmt1!=null) pstmt1.close();
		if(rs1!=null) rs1.close();
	}
  
%>	

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

