<!DOCTYPE html>
<%@ page  contentType="text/html;charset=UTF-8"  import ="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%
	
	request.setCharacterEncoding("UTF-8"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String practitionerid = request.getParameter("practitioner_id");
	String opfacilityid=(String)session.getValue("facility_id");

	Statement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	try{
		   con = ConnectionManager.getConnection(request);
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
	stmt= con.createStatement();	
	String ps ="";	
	String sql1="Select primary_speciality_code from AM_PRACTITIONER where practitioner_id='"+practitionerid+"' ";
	rs = stmt.executeQuery(sql1) ;
	
	while (rs.next())
	{			
		ps = rs.getString(1);	//gets the value of primary_speciality_code
	} 
	
	 if(stmt != null) stmt.close();
	 if(rs != null) rs.close();

	 stmt 	= con.createStatement() ;
	 String sql2="Select speciality_code,speciality_short_desc  from AM_PRACT_FOR_SPECIALITY_VW where facility_id ='"+opfacilityid+"' and practitioner_id='"+practitionerid+"' union  Select a.primary_speciality_code speciality_code, b.short_desc speciality_short_desc from AM_PRACT_FOR_FACILITY_VW a, am_speciality b where b.speciality_code = a.primary_speciality_code and a.operating_facility_id ='"+opfacilityid+"' and a.practitioner_id='"+practitionerid+"' order by 2 ";
	 rs = stmt.executeQuery(sql2) ;	
	 	 
	 if( rs != null ) 
  	 {
%>	 <script>
	var len=parent.document.frames[1].document.frames[1].document.forms[0].speciality_code.length;
	var i=1;
	while(i<len)
	{
		len=parent.document.frames[1].document.frames[1].document.forms[0].speciality_code.length;
		parent.document.frames[1].document.frames[1].document.forms[0].speciality_code.remove(i)
	}		
	  	
		var ps='<%=ps%>';		
	</script>
<%		
		
		String str1 = "";
		String str2 = "";
			
		while( rs.next() ) 
		{		  
		 	str1 = rs.getString( "speciality_code" ) ;
		 	str2 = rs.getString( "speciality_short_desc" );
%>		 
		<script>
			var str2="<%=str2%>"; 
			var str1="<%=str1%>";
     			var element =parent.document.frames[1].document.frames[1].document.createElement('OPTION');          
			element.text = "<%=str2%>"; 
			element.value= "<%=str1%>";
	                
			if(ps==str1)
			element.selected=true	
    		</script>
<%   
			out.println("<script>parent.document.frames[1].document.frames[1].document.forms[0].speciality_code.add(element);</script>");

	     }	   		
	   }
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}catch(Exception e) { 
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		ConnectionManager.returnConnection(con,request); 
		
		
	}
		out.println("</script></head><body CLASS='MESSAGE' onMouseDown='CodeArrest()' onKeyDown='lockKey()'></body></html>");		
	
%>	
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

