<!DOCTYPE html>
<%
/* 
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
31/03/2017	IN061907	Krishna Gowtham J		26/02/2017		Ramesh G			Created new jsp file for ML-MMOH-CRF-0559
------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*,java.sql.*,webbeans.eCommon.*,java.net.*,java.text.*,eCA.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<jsp:useBean id="Beannew" class="webbeans.eCommon.RecordSet" scope="session"/>
<%
	
	String func_mode 		= request.getParameter( "func_mode" ) ;
	
	Connection con = null;
	
	PreparedStatement pstmt_auto_res =null;
	ResultSet rs_auto_res =null; 

	try
	{
		if ("REC_CLINICAL_NOTE_FREE_FORMAT_LINK_DOC_BUTTON".equalsIgnoreCase(func_mode))
		{
			String curr_sec_hdg_code = request.getParameter("sec_hdg_code")==null?"": request.getParameter("sec_hdg_code");
			String freeFormatAutoResYN = "";
			String SqlGetAutoResultYN = "";
			
			SqlGetAutoResultYN = "select AUTO_RESULT_YN from CA_SECTION_HDG where sec_hdg_code = ?";
			try
			{
				con =  ConnectionManager.getConnection(request);
				pstmt_auto_res = con.prepareStatement(SqlGetAutoResultYN.toString());
				pstmt_auto_res.setString(1,curr_sec_hdg_code);
			
				rs_auto_res = pstmt_auto_res.executeQuery();
				while(rs_auto_res.next())
				{
					freeFormatAutoResYN = rs_auto_res.getString("AUTO_RESULT_YN")==null?" ":rs_auto_res.getString("AUTO_RESULT_YN");
				}
				
				if(rs_auto_res != null) rs_auto_res.close();
				if(pstmt_auto_res != null) pstmt_auto_res.close();
				
				out.println(freeFormatAutoResYN);
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
%>
