<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<HTML>
<HEAD>
	<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<!-- <SCRIPT language="javascript" src="../../eCommon/js/dchk.js"></SCRIPT> -->
	<SCRIPT language='javascript' src='../../eDR/js/DRParam.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/DateUtils.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<FORM name ='dr_param_form' target="messageFrame">
<%
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	try
	{
		con		= ConnectionManager.getConnection(request);
		stmt	= con.createStatement();

		String sql						= "";
		String searchacrossfacilityyn   = "";     
		String warnorerrorbeforeunmerge	= "";
		String rebuilddicbeforemergeyn  = "";   
		String criteriaforsugvalpatient	= "";
		String EXEC_START_TIME			= "";
		String EXEC_END_TIME			= "";

						
		sql = " SELECT  search_across_facility_yn,warn_or_error_before_unmerge,rebuild_dic_before_merge_yn,criteria_for_sug_val_patient,to_char(EXEC_END_TIME,'hh24:mi')EXEC_END_TIME,to_char(EXEC_START_TIME,'hh24:mi')EXEC_START_TIME from dr_param ";
	
		rs = stmt.executeQuery(sql);
		if(rs != null)
		{
			if(rs.next())
			{
			  	searchacrossfacilityyn	= rs.getString("search_across_facility_yn");
				if(searchacrossfacilityyn.equals("Y") ) searchacrossfacilityyn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels"); 
				else searchacrossfacilityyn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");  
				warnorerrorbeforeunmerge = rs.getString("warn_or_error_before_unmerge");
				if(warnorerrorbeforeunmerge.equals("E")) warnorerrorbeforeunmerge ="Error";		
				else warnorerrorbeforeunmerge ="Warning";		
		 		rebuilddicbeforemergeyn = rs.getString("rebuild_dic_before_merge_yn");
				if(rebuilddicbeforemergeyn.equals("Y")) rebuilddicbeforemergeyn =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
				else rebuilddicbeforemergeyn = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		 		criteriaforsugvalpatient = rs.getString("criteria_for_sug_val_patient");
				if(criteriaforsugvalpatient.equals("E")) criteriaforsugvalpatient ="By Encounter";		
				else criteriaforsugvalpatient ="By Registration Date";	
				EXEC_START_TIME = rs.getString("EXEC_START_TIME");
				if(EXEC_START_TIME==null) EXEC_START_TIME="";
				EXEC_END_TIME = rs.getString("EXEC_END_TIME");
				if(EXEC_END_TIME==null) EXEC_END_TIME="";
			}	
		} if(rs != null) rs.close();
%>
<br><br><br><br><br><br>	
<TABLE cellpadding='0' cellspacing='0' width='80%' align='center' border='0' style='text-align:left;'>	
<TR><th class='columnheader' colspan='2' ><fmt:message key="eDR.ParametersForSearchProcess.label" bundle="${dr_labels}"/></th></TR>
<tr><td colspan='2'>&nbsp;</td></tr>
<TR>
	<TD class='label' width='50%'><fmt:message key="eDR.SearchAcrossFacility.label" bundle="${dr_labels}"/></TD>
	<TD class='QUERYDATA' width='50%'><%=searchacrossfacilityyn%></TD>		
</TR>
<tr><td colspan='2'>&nbsp;</td></tr>
<TR>	
		<TD class= 'label'><fmt:message key="eDR.CriteriaforSuggestedMainPatient.label" bundle="${dr_labels}"/></TD>
		<TD class='QUERYDATA'><%=criteriaforsugvalpatient%></TD>				
</TR>
<tr><td colspan='2'>&nbsp;</td></tr>	
<TR>
<th class='columnheader' colspan='2'><fmt:message key="eDR.ForMergeProcess.label" bundle="${dr_labels}"/></th>
</TR>
<tr><td colspan='2'>&nbsp;</td></tr>
<TR>			
			<TD class='label' width='50%'><fmt:message key="eDR.RebuildDictionaryBeforeMerge.label" bundle="${dr_labels}"/></TD>
			<TD class='QUERYDATA' width='50%'><%=rebuilddicbeforemergeyn%></TD>			
</TR>	
<tr><td colspan='2'>&nbsp;</td></tr>	
<TR>
	<TD class='label'><fmt:message key="eDR.MergePatientOnlyDuring.label" bundle="${dr_labels}"/></TD>
	<td class='fields'><input type='text' id='drparam' name='start_time' id='start_time' size='4' maxlength='5' value='<%=EXEC_START_TIME%>' Onblur="(this,'HM',localeName);">
	<input type='hidden' name='start_time1' id='start_time1' size='6' maxlength='5' value=''>/<input type='text' id='drparam' name='end_time' id='end_time' size='4' maxlength='5' value="<%=EXEC_END_TIME%>"  Onblur="(this,'HM',localeName);"><input type='hidden' name='end_time1' id='end_time1' size='10' maxlength='5' value=''><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>			
</TR>
	<tr><td colspan='2'>&nbsp;</td></tr>
<TR><th class='columnheader' colspan='2'><fmt:message key="eDR.ForUnmergeProcess.label" bundle="${dr_labels}"/></th></TR>
<tr><td colspan='2'>&nbsp;</td></tr>
<TR>
	<TD class='label' width='50%'><fmt:message key="eDR.WarningErrorBeforeUnmerge.label" bundle="${dr_labels}"/></TD>
	<TD class='QUERYDATA' width='50%'><%=warnorerrorbeforeunmerge%></TD>			
</TR>	
<tr><td colspan='2'>&nbsp;</td></tr>
</TABLE>
	
	<SCRIPT>
		var mandatefields     		   = '<%=searchacrossfacilityyn%>';	
		var searchacrossfacilityyn     = '<%=searchacrossfacilityyn%>';		
		var warnorerrorbeforeunmerge   = '<%=warnorerrorbeforeunmerge%>';
		var rebuilddicbeforemergeyn    = '<%=rebuilddicbeforemergeyn%>';   
		var criteriaforsugvalpatient   = '<%=criteriaforsugvalpatient%>';	
		var EXEC_START_TIME			   = '<%=EXEC_START_TIME%>';
		var EXEC_END_TIME			   = '<%=EXEC_END_TIME%>';
	</SCRIPT>
<%
	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+ e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</FORM>
</BODY>
</HTML>

