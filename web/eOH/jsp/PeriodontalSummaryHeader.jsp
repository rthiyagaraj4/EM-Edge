<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.util.*,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 //String locale = (String)session.getAttribute("LOCALE"); 
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	String gingival_recording_by=checkForNull(request.getParameter("gingival_recording_by"));
	String tooth_numbering_system=checkForNull(request.getParameter("tooth_numbering_system"));
	String quadrant_sno=checkForNull(request.getParameter("quadrant_sno"));
	

	String code_desc="";

	try{
			con=ConnectionManager.getConnection(request);

			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			if(gingival_recording_by.equals("Q")){
				 
				pstmt=con.prepareStatement("SELECT QUADRANT_DESC CODE_DESC FROM OH_QUADRANT WHERE NUMBERING_SYSTEM=? AND QUADRANT_SNO = ?");

				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,quadrant_sno);
			}
			else{
				pstmt=con.prepareStatement("SELECT SEXTANT_DESC CODE_DESC FROM OH_SEXTANT WHERE NUMBERING_SYSTEM=? AND SEXTANT_SNO = ?");
				pstmt.setString(1,tooth_numbering_system);
				pstmt.setString(2,quadrant_sno);
				
			}
			
			rs=pstmt.executeQuery();
			while(rs.next()){
				code_desc = checkForNull(rs.getString("CODE_DESC"));
			}
%>

	<html>
		<head>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script> 
			<script language="javascript" src="../../eOH/js/PeriodontalSummary.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
		</head>
		<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
			<form name="PeridontalSummary" id="PeridontalSummary" method="post" target="messageFrame">
				<table width="96%" cellpadding =4 cellspacing='1' border='0' align='center' valign='center'>
					<tr>
						<td width="25%" class='CAGROUPHEADING' colspan=3><%=code_desc%> Details</td>
					</tr>
					<tr>
						<th width="25%" ><fmt:message key="eOH.ToothNo.Label" bundle="${oh_labels}"/></th>
						<th  width="25%" ><fmt:message key="eOH.GingivalStatus.Label" bundle="${oh_labels}"/></th>
						<th  width="25%" ><fmt:message key="Common.Value.label" bundle="${common_labels}"/></th>
					</tr>
				</table>
			</form>
		</body>
	</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

