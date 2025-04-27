<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
    	Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
    	 hash = (Hashtable)hash.get("SEARCH") ;
    	 
	String userId =(String) hash.get("userId");
	
	if ( hash != null ) hash.clear();

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		con = ConnectionManager.getConnection(request);
	
	%>
	
		var element =parent.frames[0].document.createElement('OPTION');
		element.text = '   ----- Select -----  ';
		element.value= '';
		document.forms[0].user_fac_id.add(element);
<%					
	pstmt 	= con.prepareStatement( "select facility_id,facility_name from SM_FACILITY_FOR_USER_VW  where APPL_USER_ID = '"+userId+"' order by 2" ) ;
	rs = pstmt.executeQuery() ;
	String str1 = "";
	String str2 = "";
	if( rs != null ) 
	{
		while( rs.next() ) 
		{
			str1 = rs.getString( "facility_name" ) ;
			str2 = rs.getString( "facility_id" );
	%>
				var element = parent.frames[0].document.createElement('OPTION');
				element.text = "<%=str1%>";
				element.value="<%=str2%>";
				document.forms[0].user_fac_id.add(element);

	<%	}
	}
	pstmt.close() ;      		

	}catch(Exception e){/* out.println(e.toString()); */e.printStackTrace();	}
	finally
	{
		if(rs != null)rs.close();
		ConnectionManager.returnConnection(con,request);
	}
%>
	
