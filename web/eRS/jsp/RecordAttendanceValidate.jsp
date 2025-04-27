<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 			:	
*	Created By		:	Subbulakshmky. k
*	Created On		:	29 Nov 2004
--%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
	String facility_id = (String)session.getAttribute("facility_id");
	String workplace_code = request.getParameter( "workplace_code" )==null?"":request.getParameter( "workplace_code" );
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Shift_Data		= new ArrayList();
	String[] record				= null;
	//String sql_shift="select a.shift_code,b.short_desc shift_desc from rs_shift_for_workplace a, am_shift b where a.facility_id = ? and a.workplace_code = ? and b.shift_code = a.shift_code order by shift_desc";
	String sql_shift="select a.shift_code,b.short_desc shift_desc from rs_shift_for_workplace a, am_shift_lang_Vw b where a.facility_id = ? and a.workplace_code = ? and b.shift_code = a.shift_code and b.language_id = ? order by shift_desc";

	conn = ConnectionManager.getConnection(request);
	try {
		//to get the shift data
		pstmt = conn.prepareStatement( sql_shift);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("shift_code");
			record[1] = resultSet.getString("shift_desc");
			Shift_Data.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		for( int i=0 ; i< Shift_Data.size() ; i++ ) {
			record = (String[])Shift_Data.get(i);
			out.println( "addShift(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;		
		}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} 
	finally 
	{
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}
%>
