<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	25 Oct 2004
-->
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>



<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<title><fmt:message key="eRS.ExperienceDetails.label" bundle="${rs_labels}"/></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
	<script language="javascript" src="../js/StaffProfile.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	
<%
	String role_type=request.getParameter("role_type");
	String staff_id= request.getParameter("staff_id");
	
	String slClassValue="";
	
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList ExperienceData		= new ArrayList() ;
	String[] record				= null;
	//String SQL_RS_STAFF_PROFILE_EXPERIENCE_SELECT ="select a.serial_no, to_char(a.from_date,'dd/mm/yyyy') from_dt, to_char(a.to_date,'dd/mm/yyyy') to_dt, b.position_desc position, decode(a.facility_type,'e','enterprise','x','external') facility_type, a.facility_name facility,a.workplace_name workplace, c.grade_desc grade,a.fte fte from rs_staff_experience a, am_position b, rs_grade c where a.role_type = ? and a.staff_id = ? and b.position_code = a.position_code and c.grade_code = a.grade_code order by a.from_date desc";
	String SQL_RS_STAFF_PROFILE_EXPERIENCE_SELECT ="select a.serial_no, to_char(a.from_date,'dd/mm/yyyy') from_dt, to_char(a.to_date,'dd/mm/yyyy') to_dt, b.position_desc position, decode(a.facility_type,'e','enterprise','x','external') facility_type, a.facility_name facility,a.workplace_name workplace, c.grade_desc grade,a.fte fte from rs_staff_experience a, am_position_lang_vw b, rs_grade_lang_vw c where a.role_type = ? and a.staff_id = ? and b.position_code = a.position_code and c.grade_code = a.grade_code and b.language_id = ? and c.language_id = b.language_id order by a.from_date desc";

	conn = ConnectionManager.getConnection(request);
	try {
		pstmt = conn.prepareStatement( SQL_RS_STAFF_PROFILE_EXPERIENCE_SELECT);
		role_type=role_type.trim();
		staff_id=staff_id.trim();
		pstmt.setString( 1,role_type);
		pstmt.setString( 2,staff_id);
		
		pstmt.setString( 3,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[9];				
			record[0] = resultSet.getString("serial_no");
			record[1] = resultSet.getString("from_dt");
			record[2] = resultSet.getString("to_dt");
			record[3] = resultSet.getString("position");
			record[4] = resultSet.getString("facility_type");
			record[5] = resultSet.getString("facility");
			record[6] = resultSet.getString("workplace");
			record[7] = resultSet.getString("grade");
			record[8] = resultSet.getString("fte");
			ExperienceData.add(record) ;
			
		}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		resultSet.close() ;
		pstmt.close() ;
		ConnectionManager.returnConnection(conn,request);
	}
%>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name=form_experience>
		<table cellpadding=0 cellspacing=0 border=1 width="100%" align=center>
			 <tr>
				<th  Align='left' >&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="Common.Position.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.WorkPlace.label" bundle="${rs_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.Grade.label" bundle="${rs_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.FTE.label" bundle="${rs_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			</tr>
			
			<%  
			int totalRecords=ExperienceData.size();
			//out.println("totalRecords="+totalRecords);
				if(totalRecords>0)
				{
				for( int i=0 ; i<totalRecords ; i++ ) 
				{
				if(i % 2 == 0)
				{
					slClassValue = "QRYEVEN";
				}
				else
				{
					slClassValue = "QRYODD";
				}
				
				String[] record1 = (String[])ExperienceData.get(i);
				String serial_no=(record1[0]==null)?"":record1[0];
				String from_dt=(record1[1]==null)?"":com.ehis.util.DateUtils.convertDate(record1[1],"DMY","en",locale);
				String to_dt=(record1[2]==null)?"":com.ehis.util.DateUtils.convertDate(record1[2],"DMY","en",locale);
				String position=(record1[3]==null)?"":record1[3];
				String facility=(record1[5]==null)?"":record1[5];
				String workplace=(record1[6]==null)?"":record1[6];
				String grade=(record1[7]==null)?"":record1[7];
				String fte=(record1[8]==null)?"":record1[8];
				

			%> <tr>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=from_dt%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=to_dt%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=position%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=facility%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=workplace%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=grade%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=fte%></td>
				<td  onclick='javascript:showremarks("<%=role_type%>","<%=staff_id%>","<%=serial_no%>","E")' align="center" class=<%=slClassValue%>> <a id='remarks'  href='#'>R</a></td>

			</tr>

		<%
			
			}
		}
		%>
		</table>
	</form>
</body>
</html>

