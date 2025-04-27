<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	25 Oct 2004
-->
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*, eRS.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

<html>
<head><title><fmt:message key="eRS.SkillDetails.label" bundle="${rs_labels}"/></title>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- <script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../js/StaffProfile.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%
	String role_type=request.getParameter("role_type");
	String staff_id= request.getParameter("staff_id");
	String slClassValue="";

	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList SkillData		= new ArrayList() ;
	String[] record				= null;
	//String SQL_RS_STAFF_PROFILE_SKILL_SELECT ="select b.skill_desc skill_desc, a.proficiency_level pref_level from  rs_staff_skillset a, rs_skill b where a.role_type = ? and a.staff_id = ? and b.skill_code = a.skill_code order by skill_desc";
	String SQL_RS_STAFF_PROFILE_SKILL_SELECT ="select b.skill_desc skill_desc, a.proficiency_level pref_level from  rs_staff_skillset a, rs_skill_lang_vw b where a.role_type = ? and a.staff_id = ? and b.skill_code = a.skill_code and b.language_id = ? order by skill_desc";
	try {
		conn = ConnectionManager.getConnection();
		pstmt = conn.prepareStatement( SQL_RS_STAFF_PROFILE_SKILL_SELECT);
		role_type=role_type.trim();
		staff_id=staff_id.trim();
		pstmt.setString( 1,role_type);
		pstmt.setString( 2,staff_id);
		pstmt.setString( 3,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("skill_desc");
			record[1] = resultSet.getString("pref_level");
			SkillData.add(record) ;
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
	<form name=form_skill>
		<table cellpadding=0 cellspacing=0 border=1 width="40%" >
			 <tr>
				 <th  Align='left'>&nbsp;<fmt:message key="eRS.Skill.label" bundle="${rs_labels}"/></th>
				<th  Align='left'>&nbsp;<fmt:message key="eRS.Proficiency.label" bundle="${rs_labels}"/></th>
			</tr>
			<%
			int totalRecords=SkillData.size();
                if(totalRecords>0)
				{
				for( int i=0 ; i<totalRecords ; i++ ) {
				if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}
				String[] record1 = (String[])SkillData.get(i);
				String skill_desc=(record1[0]==null)?"":record1[0];
				String pref_level=(record1[1]==null)?"":record1[1];
			%>
			 <tr>
				 <td  Align='left' class ='<%=slClassValue%>' >&nbsp;<%=skill_desc%></td>
				<td  Align='left' class ='<%=slClassValue%>' > &nbsp;<%=pref_level%></td>
			</tr>
		<%
			}}
		%>
		</table>
	</form>
</body>
</html>

