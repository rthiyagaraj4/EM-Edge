<!DOCTYPE html>
<!--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:
*	Created By		:	Subbulakshmy. K
*	Created On		:	25 Oct 2004-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="java.util.*, eRS.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head><title><fmt:message key="Common.TrainingDetails.label" bundle="${common_labels}"/></title>
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
	String certifiedGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String uncertifiedGif="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>"; 
	
	Connection conn 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList TrainingData		= new ArrayList() ;
	String[] record				= null;
	//String SQL_RS_STAFF_PROFILE_TRAINING_SELECT ="select b.training_desc training, b.training_code, to_char(a.start_date,'dd/mm/yyyy') start_date, to_char(a.end_date,'dd/mm/yyyy') end_date, decode(a.facility_type,'I','In-House','L','Local','O','Overseas') type, a.facility_name organisation,a.certified_yn certified_yn from rs_staff_training a, rs_training b where a.role_type = ? and a.staff_id =? and b.training_code = a.training_code order by start_date desc";
	String SQL_RS_STAFF_PROFILE_TRAINING_SELECT ="select b.training_desc training, b.training_code, to_char(a.start_date,'dd/mm/yyyy') start_date, to_char(a.end_date,'dd/mm/yyyy') end_date, decode(a.facility_type,'I','In-House','L','Local','O','Overseas') type, a.facility_name organisation,a.certified_yn certified_yn from rs_staff_training a, rs_training_lang_vw b where a.role_type = ? and a.staff_id =? and b.training_code = a.training_code and b.language_id = ? order by start_date desc";
	try {
		conn = ConnectionManager.getConnection();
		pstmt = conn.prepareStatement( SQL_RS_STAFF_PROFILE_TRAINING_SELECT);
		role_type=role_type.trim();
		staff_id=staff_id.trim();
		pstmt.setString( 1,role_type);
		pstmt.setString( 2,staff_id);
		pstmt.setString( 3,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[7];				
			record[0] = resultSet.getString("training");			
			record[1] = resultSet.getString("training_code");
			record[2] = resultSet.getString("start_date");
			record[3] = resultSet.getString("end_date");
			record[4] = resultSet.getString("type");
			record[5] = resultSet.getString("organisation");
			record[6] = resultSet.getString("certified_yn");
			TrainingData.add(record) ;
		}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		resultSet.close() ;
		pstmt.close() ;
		ConnectionManager.returnConnection(conn,request);
	}%>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name=form_training>
		<table cellpadding=0 cellspacing=0 border=1 width="100%" align=center>
			 <tr>
				 <th  Align='left'  width='10%'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></th>
				<th  Align='left'   width='10%'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></th>
				 <th  Align='left'  width='20%'>&nbsp;<fmt:message key="eRS.Training.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="eRS.Program.label" bundle="${rs_labels}"/></th>
				 <th  Align='left'  width='10%'>&nbsp;<fmt:message key="eRS.Training.label" bundle="${rs_labels}"/>&nbsp;<fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
				 <th  Align='left'  width='30%'>&nbsp;<fmt:message key="eRS.Organisation.label" bundle="${rs_labels}"/></th>
				 <th  Align='left'  width='5%'>&nbsp;<fmt:message key="eRS.Certified.label" bundle="${rs_labels}"/></th>
				 <th  Align='left'  width='*%'>&nbsp;<fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
			</tr>
<%
	int totalRecords=TrainingData.size();
            if(totalRecords>0)
      		{
				for( int i=0 ; i<totalRecords ; i++ ) {
				if(i % 2 == 0){
					slClassValue = "QRYEVEN";
				}else{
					slClassValue = "QRYODD";
				}
				String[] record1 = (String[])TrainingData.get(i);
				String training=(record1[0]==null)?"":record1[0];
				String training_code=(record1[1]==null)?"":record1[1];
				String start_date=(record1[2]==null)?"":com.ehis.util.DateUtils.convertDate(record1[2],"DMY","en",locale);
				String end_date=(record1[3]==null)?"":com.ehis.util.DateUtils.convertDate(record1[3],"DMY","en",locale);
				String training_type=(record1[4]==null)?"":record1[4];
				String organisation=(record1[5]==null)?"":record1[5];
				String certified_yn=(record1[6]==null)?"":record1[6];
				String certified=certified_yn;

					
				certified=certified.equals("Y")?certifiedGif:uncertifiedGif;
		%>
			 <tr>
				<td  Align='left' class ='<%=slClassValue%>'  width='%'><%=start_date%></td>
				<td  Align='left' class ='<%=slClassValue%>'  width='%'><%=end_date%></td>
				<td  Align='left' class ='<%=slClassValue%>'  width='%'><%=training%></td>
				<td  Align='left' class ='<%=slClassValue%>'  width='%'><%=training_type%></td>
				<td  Align='left' class ='<%=slClassValue%>'  width='%'><%=organisation%></td>
				<td  Align='left' class ='<%=slClassValue%>'  width='%'><%=certified%></td>
				<td  onclick='javascript:showremarks("<%=role_type%>","<%=staff_id%>","<%=training_code%>","T")' align="center" class=<%=slClassValue%>> <a id='remarks'  href='#'>R</a></td>
			</tr>
		<%
			}}
		%>
		</table>
	</form>
</body>
</html>

