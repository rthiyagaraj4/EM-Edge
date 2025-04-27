<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name	Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
22/01/2018	IN063931		Prakash C	23/01/2018		Ramesh		KDAH-CRF-0431(Copy previous section)										
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,java.text.SimpleDateFormat" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");

String accession_num 			=	"";
String curr_sec_hdg_code 		=	"";
String curr_child_sec_hdg_code	=	"";
String sql 						=	"";
String result 					=	"";

Connection con=null;
PreparedStatement pst = null;
ResultSet rs = null;

try{
		Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
		hash = (Hashtable)hash.get( "SEARCH" ) ;
		accession_num				= (String)hash.get("accession_num");
		curr_sec_hdg_code			= (String)hash.get("curr_sec_hdg_code");
		curr_child_sec_hdg_code		= (String)hash.get("curr_child_sec_hdg_code");
		con	= ConnectionManager.getConnection(request);			
		sql = "SELECT 'Y' FROM ca_section_hdg a, ca_encntr_note_section b WHERE a.sec_hdg_code = b.sec_hdg_code AND a.sec_hdg_code = ? AND b.accession_num = ? AND a.modified_date>b.modified_date";
		pst = con.prepareStatement(sql);		
		pst.setString(1,curr_child_sec_hdg_code);
		pst.setString(2,accession_num);
		
		rs = pst.executeQuery();		
		if(rs.next())
		{				
			result = "SECTION_FORMAT_CHANGED";
		}			
		out.print(result);		
	}
	catch(Exception e)
	{		
		e.printStackTrace();
		System.out.print("RecPreviousSectionIntermediate.jsp, Exception@ ===>" + e);
	}
	finally
	{
		if(pst!=null) pst.close();
		if(rs!=null) rs.close();
		if(con!=null) con.close();
	}
%>
