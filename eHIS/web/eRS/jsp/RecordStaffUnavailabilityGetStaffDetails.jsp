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
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%
	
	String staff_id = (String)request.getParameter("staff_id")==null?"":(String)request.getParameter("staff_id");
	String role_type = (String)request.getParameter("role_type")==null?"":(String)request.getParameter("role_type");
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	String Staff_desc="";
	String Position="";
	System.err.println("Record Staff unavailabilitygetstaffdeatails.jsp----------------------");
	

	
	//String sql_stafftype_desc="select b.desc_userdef staff_desc from am_staff_vw a, am_pract_type b where ? = 'P' and a.staff_id=?  and a.staff_type=b.pract_type union select   b.short_desc staff_desc from am_staff_vw a, am_other_staff_type b  where ? = 'O'  and a.staff_id=? and a.staff_type=b.other_staff_type  ";
	String sql_stafftype_desc="select b.desc_userdef staff_desc from am_staff_vw a, am_pract_type_lang_vw b where ? = 'P' and a.staff_id=?  and a.staff_type=b.pract_type and a.language_id = ? and b.language_id = ? union select   b.short_desc staff_desc from am_staff_vw a, am_other_staff_type_lang_vw b  where ? = 'O'  and a.staff_id=? and a.staff_type=b.other_staff_type  and a.language_id = ? and b.language_id = ?   ";
	
	//String sql_position_desc="select c.position_desc FROM am_staff_vw a, am_position c WHERE ? = 'P' and a.staff_id=?  and a.position_code=c.position_code union select c.position_desc from am_staff_vw a, am_other_staff_type b, am_position c where ? = 'O' and a.staff_id=? and a.position_code=c.position_code ";
	String sql_position_desc="select c.position_desc FROM am_staff_vw a, am_position_lang_vw c WHERE ? = 'P' and a.staff_id=?  and a.position_code=c.position_code and a.language_id = ? and c.language_id = ? union select c.position_desc from am_staff_vw a, am_other_staff_type b, am_position_lang_vw c where ? = 'O' and a.staff_id=? and a.position_code=c.position_code and a.language_id = ? and c.language_id = ? ";

	conn = ConnectionManager.getConnection(request);
	try {
		//to get the Staff Type Desc
		pstmt = conn.prepareStatement( sql_stafftype_desc);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,role_type);
		pstmt.setString(6,staff_id);
		pstmt.setString(7,locale);
		pstmt.setString(8,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			Staff_desc = resultSet.getString("staff_desc")==null?"":resultSet.getString("staff_desc");
		}
		if(pstmt != null)
			pstmt.close() ;
		if(resultSet != null)
			resultSet.close();

		//to get the Position Desc
		pstmt = conn.prepareStatement( sql_position_desc);
		pstmt.setString(1,role_type);
		pstmt.setString(2,staff_id);
		pstmt.setString(3,locale);
		pstmt.setString(4,locale);
		pstmt.setString(5,role_type);
		pstmt.setString(6,staff_id);
		pstmt.setString(7,locale);
		pstmt.setString(8,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			Position = resultSet.getString("position_desc")==null?"":resultSet.getString("position_desc");
		}
		
		if(pstmt != null)
			pstmt.close() ;
		if(resultSet != null)
			resultSet.close();
		out.println( "addDesc(\"" + Staff_desc + "\",\"" + Position + "\") ; " ) ;			

	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		try{
			if(pstmt != null)
				pstmt.close() ;
			if(resultSet != null)
				resultSet.close();
			ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception exp){
			out.println(exp.toString());
		}
	}
%>
