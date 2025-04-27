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
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head><title><fmt:message key="eRS.LicensureDetails.label" bundle="${rs_labels}"/></title>
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
	ArrayList LicensureData		= new ArrayList() ;
	String[] record				= null;

	//String SQL_RS_STAFF_PROFILE_LICENSURE_SELECT ="select b.license_desc title, a.license_id license_id, a.license_code, to_char(a.issue_date,'dd/mm/yyyy') issue_date, nvl2(a.valid_until,to_char(a.valid_until,'dd/mm/yyyy'),null) valid_until, decode(a.facility_type,'I','In-House','L','Local','O','Overseas') organisation_type, a.facility_name organisation from rs_staff_licensure a, rs_licensure b where a.role_type = ? and a.staff_id = ? and b.license_code = a.license_code order by issue_date";
	String SQL_RS_STAFF_PROFILE_LICENSURE_SELECT ="select b.license_desc title, a.license_id license_id, a.license_code, to_char(a.issue_date,'dd/mm/yyyy') issue_date, nvl2(a.valid_until,to_char(a.valid_until,'dd/mm/yyyy'),null) valid_until, decode(a.facility_type,'I','In-House','L','Local','O','Overseas') organisation_type, a.facility_name organisation from rs_staff_licensure a, rs_licensure_lang_vw b where a.role_type = ? and a.staff_id = ? and b.license_code = a.license_code and b.language_id = ? order by issue_date";
	try {
		conn = ConnectionManager.getConnection();
		pstmt = conn.prepareStatement( SQL_RS_STAFF_PROFILE_LICENSURE_SELECT);
		role_type=role_type.trim();
		staff_id=staff_id.trim();
		pstmt.setString( 1,role_type);
		pstmt.setString( 2,staff_id);
		pstmt.setString( 3,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[7];				
			record[0] = resultSet.getString("title");
			record[1] = resultSet.getString("license_id");
			record[2] = resultSet.getString("license_code");
			record[3] = resultSet.getString("issue_date");
			record[4] = resultSet.getString("valid_until");
			record[5] = resultSet.getString("organisation_type");
			record[6] = resultSet.getString("organisation");

			LicensureData.add(record) ;
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
	<form name=form_licensure>
		<table cellpadding=0 cellspacing=0 border=1 width="100%" align=center>
			 <tr>
				<th  Align='left'>&nbsp;<fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.License.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.Issue.label"bundle="${rs_labels}"/> &nbsp;<fmt:message key="Common.date.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="Common.valid.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.until.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.Organisation.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.Organisation.label" bundle="${rs_labels}"/></th>
				<th  Align='left' >&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			</tr>
			<%
		int totalRecords=LicensureData.size();

			if(totalRecords>0)
			{
				for( int i=0 ; i<totalRecords ; i++ ) {
				if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}
				String[] record1 = (String[])LicensureData.get(i);
				String title=(record1[0]==null)?"":record1[0];
				String license_id=(record1[1]==null)?"":record1[1];
				String license_code=(record1[2]==null)?"":record1[2];
				String issue_date=(record1[3]==null)?"":com.ehis.util.DateUtils.convertDate(record1[3],"DMY","en",locale);
				String valid_until=(record1[4]==null)?"":com.ehis.util.DateUtils.convertDate(record1[4],"DMY","en",locale);
				String organisation_type=(record1[5]==null)?"":record1[5];
				String organisation=(record1[6]==null)?"":record1[6];
			%>
			 <tr>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=title%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=license_id%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=issue_date%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=valid_until%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=organisation_type%></td>
				<td  Align='left' class ='<%=slClassValue%>'>&nbsp;<%=organisation%> </td>
				<td  onclick='javascript:showremarks("<%=role_type%>","<%=staff_id%>","<%=license_code%>","L")' align="center" class=<%=slClassValue%>> <a id='remarks'  href='#'>R</a></td> 
			</tr>
		<%
			}}
		%>
		</table>
	</form>
</body>
</html>

