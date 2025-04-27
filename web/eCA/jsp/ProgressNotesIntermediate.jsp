<!DOCTYPE html>
<%@page import="java.sql.*,java.util.*, eCA.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
	hash = (Hashtable)hash.get( "SEARCH" ) ;


	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
	String progression_ref = request.getParameter("progression_ref")==null?"":request.getParameter("progression_ref");

	if(mode.equals("NTstat"))
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String NoteStatQry = " select 1 from CA_PAT_PROGRESSION_DTL A,CA_ENCNTR_NOTE B where a.ACCESSION_NUM=B.ACCESSION_NUM AND A.PROGRESSION_REF = ? and B.EVENT_STATUS not in('4','5','9') ";
		
		try
		{
			con = ConnectionManager.getConnection(request);
			pstmt		=	con.prepareStatement(NoteStatQry);
			pstmt.setString(1,progression_ref);

			rs	 =	pstmt.executeQuery();
			if(rs.next())
			{
				out.println("close_progression('N');");
			} 
			else
			{
				out.println("close_progression('Y');");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();			
		}
		finally
		{
			if(con != null) ConnectionManager.returnConnection(con,request);
		}	
	
	
	
	}

 %>
