<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
//MMS-ME-SCF-0096 vulnerability Issue 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
    	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    	 hash = (Hashtable)hash.get("SEARCH") ;
    	 
	String facilityID =(String) hash.get("facilityID");
	//String sql="";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		con = ConnectionManager.getConnection(request);
	
	%>
	
		var element =parent.frames[0].document.createElement('OPTION');
		element.text = '   ----- Select -----  ';
		element.value= '';
		document.forms[0].team.add(element);
<%					
	pstmt 	= con.prepareStatement( "Select Team_Id, Short_Desc, Speciality_code, Speciality_Desc from am_medical_team_vw where Facility_Id ='"+facilityID+"' and eff_Status = 'E' order by Short_Desc " ) ;
	rs = pstmt.executeQuery() ;
	String str1 = "";
	String str2 = "";
	String speciality_code="",speciality_desc="";
	if( rs != null ) 
	{
		while( rs.next() ) 
		{
			str1 = rs.getString( "Short_Desc" ) ;
			str2 = rs.getString( "Team_Id" );
			speciality_code= rs.getString("speciality_code");
			speciality_desc= rs.getString("speciality_desc");
			
	%>
				var element = parent.frames[0].document.createElement('OPTION');
				element.text = "<%=str1%>";
				element.value="<%=str2%>$<%=speciality_code%>$<%=speciality_desc%>";
				document.forms[0].team.add(element);

	<%	}
	}

    hash.clear();
	}catch(Exception e){}
	finally
	{
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
	
