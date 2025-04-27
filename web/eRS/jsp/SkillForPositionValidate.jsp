<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page language="java" contentType="text/html;charset=UTF-8"  import ="java.util.*, java.sql.*,eCommon.Common.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>


<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	

	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	
	String role_type	= request.getParameter( "role_type" )==null?"":request.getParameter("role_type");
	String sql			="";
	ArrayList Staff		= new ArrayList() ;
	String[] record		= null;
		
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;

	try{
		  Con = ConnectionManager.getConnection(request);

		if(role_type.equalsIgnoreCase("P")){
			
			sql="SELECT pract_type, desc_userdef FROM am_pract_type WHERE eff_status = 'E' ORDER BY desc_userdef";
			
			pstmt=Con.prepareStatement(sql);
			rslRst = pstmt.executeQuery();
		
			while(rslRst.next()){
				record = new String[2];
				record[0]	=rslRst.getString("pract_type");
				record[1]	=rslRst.getString("desc_userdef");
				Staff.add(record) ;
			}
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
		}else if(role_type.equalsIgnoreCase("O")){
			
			sql="SELECT other_staff_type, short_desc FROM am_other_staff_type WHERE eff_status = 'E' ORDER BY short_desc";
			
			pstmt=Con.prepareStatement(sql);
			rslRst = pstmt.executeQuery();
		
			while(rslRst.next()){
				record = new String[2];
				record[0]	=rslRst.getString("other_staff_type");
				record[1]	=rslRst.getString("short_desc");
				Staff.add(record) ;
			}
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
	}

		for( int i=0 ; i< Staff.size(); i++ ) {
			String[] record1 = (String[])Staff.get(i);
			out.println( "addStaffType(\"" + record1[0] + "\",\"" + record1[1] + "\") ; " ) ;			
		}

	}catch(Exception e){
		e.printStackTrace() ;
		throw e ;
	}
	finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			ConnectionManager.returnConnection(Con,request);
	}

%>
