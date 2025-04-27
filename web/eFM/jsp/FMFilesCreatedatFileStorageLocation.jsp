<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String p_module_id		= "FM" ;
	String p_report_id			=  "FMFLCFSL" ;
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
%>
<html>
	<head>
		<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
			request.setCharacterEncoding("UTF-8"); 
		String sStyle	=
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eFM/js/FMCheck.js" language="javascript"></script>
		<script language="javascript" src="../../eFM/js/checkSystemDate.js" language="javascript"></script>
		<script language="javascript" src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eFM/js/FilesCreatedatFileStorageLocation.js'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
	<br>
	<br>
	<form name="Files_For_FSLocn_Form" id="Files_For_FSLocn_Form" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
	<%
	Connection conn = ConnectionManager.getConnection(request);
	PreparedStatement stmt=null;
	ResultSet rset=null;
	StringBuffer SB_locn_list= new StringBuffer();
	String FS_LOCN_SQL		= "";
	String DATE_SQL			= "";
	String MP_PARAM_SQL	= "";
	int	 recordCount				= 0;	
	int p_patient_id_length		= 0 ;
	//String OneRecordFlag		= "" ;
	String itemDescription		= "" ;
	String itemCOde				= "" ;
	String today						= "";

	try{	
			MP_PARAM_SQL = "SELECT PATIENT_ID_LENGTH FROM MP_PARAM " ;
			stmt = conn.prepareStatement(MP_PARAM_SQL);
			rset = stmt.executeQuery();
			while (rset.next()){
				p_patient_id_length = rset.getInt("PATIENT_ID_LENGTH");
			}
			if(rset!=null)	rset.close();
			if(stmt!=null)	stmt.close();

			DATE_SQL = "SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY')TODAY FROM DUAL";
			stmt = conn.prepareStatement(DATE_SQL);
			rset = stmt.executeQuery();
			while (rset.next()){
				today = rset.getString("TODAY");
			}
			if(rset!=null)	rset.close();
			if(stmt!=null)	stmt.close();

			FS_LOCN_SQL ="SELECT  'ALL' FS_LOCN_CODE  , '"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"' SHORT_DESC  FROM  dual  UNION SELECT FS_LOCN_CODE,SHORT_DESC FROM FM_STORAGE_LOCN_LANG_VW WHERE FACILITY_ID='"+
			p_facility_id+"' AND MR_LOCN_YN='Y' AND PERMANENT_FILE_AREA_YN='Y' AND EFF_STATUS='E' AND LANGUAGE_ID='"+localeName+"' ORDER BY 2 " ;
			SB_locn_list.append("<option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----</option>");		
			stmt = conn.prepareStatement(FS_LOCN_SQL);		
			rset = stmt.executeQuery();
			while(rset.next()){
					 itemDescription = rset.getString("SHORT_DESC");
					 itemCOde	     = rset.getString("FS_LOCN_CODE");
 					 SB_locn_list.append("<option value='"+itemCOde+"'>"+itemDescription+"</option>");
					 recordCount++;
				}
		//		if(recordCount == 1)
		//		OneRecordFlag="Yes";
				if(stmt!=null)   stmt.close();
				if(rset!=null)    rset.close();
	 }
 	catch(Exception e){
		e.printStackTrace();	
	}
	finally{	
			if(rset!=null)	rset.close();
			if(stmt!=null)	stmt.close();
		    ConnectionManager.returnConnection(conn,request);
	}
%>
		<table width='70%' cellPadding="2" cellSpacing="0"  align='center' >
					<tr>
							<td height="3" colspan="2" class='label'>&nbsp;</td>
							<td height="3" colspan="2" class='label'>&nbsp;</td>
					</tr>
					<tr>	
					<td class='label'  width='30%' ><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/> </td>
					<td	class='fields' width='30%' ><select name='p_fs_locn_code' id='p_fs_locn_code'  onChange=''><%=SB_locn_list.toString()%></select>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
					</td>
					<td  class='label' width='40%'></td>
					</tr>		

					<tr>
							<td  class='label' width='20%'>&nbsp;</td>
							<td  class='querydata' width='20%'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
							<td  class='querydata' width='20%'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>			
					<tr>
							<td  class='label'><fmt:message key="eFM.FileCreatedDate.label" bundle="${fm_labels}"/></td>
							<td	class='fields' ><input type='text' id="date_from" tabIndex='3'
							name='p_from_date' id='p_from_date' value=''  size="10"	maxlength="10"
							onBlur="validDateObj(this,'DMY','<%=localeName%>');setDate(this);"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_from');"/>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
							<td class='fields'><input type='text' id="date_to" tabIndex='4'
							name='p_to_date' id='p_to_date' value=''  size="10"	maxlength="10" onBlur="validDateObj(this,'DMY','<%=localeName%>');setDate(this);"><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('date_to');"/>&nbsp;<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
					</tr>
					<tr>
							<td class='label' width='20%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
							<td class='fields' width='30%'><input type='text' name='p_patient_id' id='p_patient_id' value='' onBlur="ChangeUpperCase(this);checkPatientID(this);" onKeyPress='return CheckForSpecChars(event)' size='20' maxlength="<%=p_patient_id_length%>" ><input type=button name=search value='?' tabIndex="5"   class=button onClick="callPatientSearch()"></td>
					</tr>
					<tr><td colspan="4" class='label'>&nbsp;</td></tr>
				</table>
				<input type="hidden" name="p_facility_id" id="p_facility_id"  value="<%=p_facility_id %>">
				<input type="hidden" name="p_module_id" id="p_module_id" value="<%=p_module_id %>">
				<input type="hidden" name="p_report_id" id="p_report_id"   value="<%=p_report_id %>">
				<input type="hidden" name="p_user_name" id="p_user_name" value="<%=p_user_name %>">
				<input type="hidden" name="today" id="today"	value="<%=today%>">
				<%-- <INPUT TYPE="hidden" name="p_language_id" id="p_language_id" value="<%=localeName%>"> --%>
		</form>
	</BODY>
</HTML>

