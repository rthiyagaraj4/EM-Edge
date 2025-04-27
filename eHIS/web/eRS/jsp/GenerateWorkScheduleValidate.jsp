<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<%
	Connection Con			= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
	
	String role_type	= request.getParameter("role_type" ) ;
	String position_code	= request.getParameter("position_code" )==null?"":request.getParameter("position_code");
	String sql			="";
	ArrayList Staff		= new ArrayList() ;
	String[] record		= null;
		
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;

	try{
		Con=ConnectionManager.getConnection(request);
		if(!position_code.equals("")){
			//sql="select position_code, position_desc from am_position where position_code=?";
			sql="select position_code, position_desc from am_position_lang_vw where position_code=? and language_id = ?";
			pstmt=Con.prepareStatement(sql);
			pstmt.setString(1, position_code);
			pstmt.setString(2, locale);
			rslRst = pstmt.executeQuery();
			//System.out.println("position_code------|"+position_code+"|------locale-------|"+locale+"|-----");
			while(rslRst.next()){
				record = new String[2];
				record[0]	=rslRst.getString("position_code");
				record[1]	=rslRst.getString("position_desc");
			}
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			out.println( "addPosition(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
		}
		else
		if(!role_type.equals("")){
				
			//sql="select pract_type staff_type, desc_userdef staff_desc from am_pract_type where eff_Status = 'E' and ? = 'P' union select other_staff_type staff_type, short_desc staff_desc from am_other_staff_type where eff_status = 'E' and ? = 'O' order by staff_desc";
			sql="select pract_type staff_type, desc_userdef staff_desc from am_pract_type where eff_Status = 'E' and ? = 'P' union select other_staff_type staff_type, short_desc staff_desc from am_other_staff_type_lang_vw where eff_status = 'E' and ? = 'O' and language_id = ? order by staff_desc";
			
			pstmt=Con.prepareStatement(sql);
			pstmt.setString(1, role_type);
			pstmt.setString(2, role_type);
			pstmt.setString(3, locale);
			rslRst = pstmt.executeQuery();
			//System.out.println("role_type------|"+role_type+"|--------locale-------|"+locale+"|-----");
		
			while(rslRst.next()){
				record = new String[2];
				record[0]	=rslRst.getString("staff_type");
				record[1]	=rslRst.getString("staff_desc");
				Staff.add(record) ;
			}
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			for( int i=0 ; i< Staff.size() ; i++ ) {
				record = (String[])Staff.get(i);
				out.println( "addStaffType(\"" + record[0] + "\",\"" + record[1] + "\") ; " ) ;
				
			}
		}

	}catch(Exception e){
			out.println("Exception in try of GenerateWrkValidate.jsp : "+e);
		}finally {
			if (pstmt != null) pstmt.close();
			if (rslRst != null) rslRst.close();
			if(Con!=null) ConnectionManager.returnConnection(Con,request);
		}

%>
