<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");



%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	
	String facility_id	= request.getParameter( "facility_id" ) ;
	String locn_id		= request.getParameter( "locn_id" ) ;

	//System.err.println("facility_id----------->"+facility_id);
	//System.err.println("locn_id----------->"+locn_id);

	String sql			="";
	ArrayList wrkPlace	= new ArrayList() ;
	String[] record		= null;
		
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;

	try{
		Con=ConnectionManager.getConnection(request);

		//sql="SELECT workplace_code code, workplace_desc description FROM rs_workplace WHERE facility_id = ? AND (? IS NULL OR locn_type = ?) AND eff_status = 'E' ORDER BY workplace_desc";
		sql="SELECT workplace_code code, workplace_desc description FROM rs_workplace_lang_vw WHERE facility_id = ? AND (? IS NULL OR locn_type = ?) AND eff_status = 'E' and language_id = ? ORDER BY workplace_desc";
		
		pstmt=Con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,locn_id);
		pstmt.setString(3,locn_id);
		pstmt.setString(4,locale);

		rslRst = pstmt.executeQuery();
	
		while(rslRst.next()){
			record = new String[2];
			record[0]	=rslRst.getString("code");
			record[1]	=rslRst.getString("description");
			wrkPlace.add(record) ;
		}				
		if (pstmt != null) pstmt.close();
		if (rslRst != null) rslRst.close();
		//System.err.println("wrkPlace----------->"+wrkPlace);
		for( int i=0 ; i< wrkPlace.size() ; i++ ) {
			String[] record1 = (String[])wrkPlace.get(i);
			out.println( "addWrkPlace(\"" + record1[0] + "\",\"" + record1[1] + "\") ; " ) ;
		}
	}catch(Exception e){
			out.println("Exception in try of StaffprofilesetupValidate.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}
%>
