<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
Connection con= null;
Statement stmt= null;
ResultSet rs= null;

try{
	String practitionerid = request.getParameter("practitioner_id");
	
	String opfacilityid=(String)session.getValue("facility_id");
	String locale			= (String)session.getAttribute("LOCALE");
    

	String IPval = request.getParameter("IPval");	
	if(IPval== null) IPval = "";
	
	con= ConnectionManager.getConnection(request);
	out.println("<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	stmt= con.createStatement();	
	String ps ="";	
	String sql1="Select primary_speciality_code from AM_PRACTITIONER where practitioner_id='"+practitionerid+"' ";
	rs = stmt.executeQuery(sql1) ;
	
	while (rs.next())
	{			
		ps = rs.getString(1);	//gets the value of primary_speciality_code
	} 	
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();
	 stmt 	= con.createStatement() ;
	 String sql2="Select speciality_code,AM_GET_DESC.AM_SPECIALITY(SPECIALITY_CODE,'"+locale+"','2') speciality_short_desc  from AM_PRACT_FOR_SPECIALITY_VW where facility_id ='"+opfacilityid+"' and practitioner_id='"+practitionerid+"' union  Select a.primary_speciality_code speciality_code, b.short_desc speciality_short_desc from AM_PRACT_FOR_FACILITY_VW a, am_speciality_lang_vw b where b.speciality_code = a.primary_speciality_code and a.operating_facility_id ='"+opfacilityid+"' and a.practitioner_id='"+practitionerid+"' and language_id='"+locale+"' order by 2 ";
	 rs = stmt.executeQuery(sql2) ;	
	 	 
	 if( rs != null ) 
  	 {
  	 
  	  if(IPval.equals("ip"))
  	  {  	  
%>	 	<script>
		
		var len=parent.frames[1].frames[1].document.getElementById('speciality_code').length;
		var i=1;
		while(i<len)
		{
			len=parent.frames[1].frames[1].document.getElementById('speciality_code').length;
			parent.frames[1].frames[1].document.getElementById('speciality_code').remove(i)
		}			
		var ps="<%=ps%>";		
	</script>
<%		String str1 = "";
		String str2 = "";

		while( rs.next() ) 
		{		  
			str1 = rs.getString( "speciality_code" ) ;
			str2 = rs.getString( "speciality_short_desc" );
%>		 
		<script>
			var str2="<%=str2%>"; 
			var str1="<%=str1%>";

			var element =parent.frames[1].frames[1].document.createElement('OPTION');
			element.text = "<%=str2%>"; 
			element.value= "<%=str1%>";



			if(ps==str1)
			element.selected=true	
		</script>
<%   
			out.println("<script>parent.frames[1].frames[1].document.forms[0].speciality_code.add(element);</script>");	 
     		}
	   }
	   else
	   {   
  	 
%>		<script>		
			
			var n=parent.frames[1].frames[1].document.forms[0].speciality_code.options.length;
			for(var i=0;i<n;i++)
			{	  
			    parent.frames[1].frames[1].document.forms[0].speciality_code.remove("speciality_code");				
	  		}				
			var ps="<%=ps%>";		
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
     
			var element =parent.frames[1].frames[1].document.createElement('OPTION');
			element.text = "<%=str2%>"; 
			element.value= "<%=str1%>";
			if(ps==str1)
			element.selected=true	
    		</script>
<%   								
			out.println("<script>parent.frames[1].frames[1].document.forms[0].speciality_code.add(element);</script>");
	     }	   		
	   }
	 }
	 if(rs!=null)rs.close();
	 if(stmt!=null)stmt.close();

		out.println("</script></head><body onMouseDown='CodeArrest()' onKeyDown='lockKey()' CLASS='MESSAGE'></body></html>");		
		
		}catch(Exception e){out.println("eror" + e);}
		finally
		{
			ConnectionManager.returnConnection(con,request);
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

