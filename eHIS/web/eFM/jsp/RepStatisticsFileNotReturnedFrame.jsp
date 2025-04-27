<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import=" java.sql.*,java.text.*,java.util.*,java.io.*,webbeans.eCommon.* " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;

	String facility_id	= (String) session.getValue("facility_id"); 
%>
<HTML>
	<HEAD>
		<!-- <LINK rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
		<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eCommon/js/ValidControls.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<SCRIPT>
		function PopFSLocn(Obj)
		{
			var facility_id			= '<%=facility_id%>';
			var fsLocnCode			= document.forms[0].fsLocnCode.value;
			var outstndFSLocnCode   = document.forms[0].outstndFSLocnCode.value;
			
			var sel	= document.forms[0].outstndFSLocn;
			while(sel.options.length > 1)
			{
				sel.remove(1);
			}
			var HTMLVal = "<HTML><BODY onKeyDown = 'lockKey()'><FORM name='populateFSLoc' id='populateFSLoc' action='../../eFM/jsp/FMReturnPopFSLoc.jsp' method='post'><INPUT type='hidden' name='p_facility_id' id='p_facility_id' value='"+facility_id+"'><INPUT type='hidden' name='p_curr_fs_loc' id='p_curr_fs_loc' value='"+fsLocnCode+"'><INPUT type='hidden' name='p_fs_locn_id' id='p_fs_locn_id' value='"+outstndFSLocnCode+"'><INPUT type='hidden' name='param_num' id='param_num' value='5'></FORM></BODY></HTML>";

			parent.messageFrame.document.write( HTMLVal);
			parent.messageFrame.document.populateFSLoc.submit();
		}
		function ClearAllValues()
		{
			document.forms[0].outstndFSLocnCode.value='';
			document.forms[0].outstandFacilityID.value='';
			var sel = document.forms[0].outstndFSLocn;
			while(sel.options.length > 1)
			{
				sel.remove(1);
			}
		}
		function run()
		{
			repStatsNotRetCriteria.document.forms[0].submit() ;
		}
		function reset()
		{
			repStatsNotRetCriteria.document.location.reload();
			messageFrame.document.location.href = "../../eCommon/jsp/error.jsp?err_num=";
		}
	</SCRIPT>
<%
	String callFrom = request.getParameter("callFrom");
	if(callFrom == null || callFrom.equals("null"))
		callFrom = "";
	if(callFrom.equals("mainFrame"))
	{
		Connection conn		= null;
		Statement stmt		= null;
		ResultSet rst		= null;
		
		StringBuffer sb     = new StringBuffer();
		StringBuffer sb1    = new StringBuffer();

		String fsLocnCode   = "";
		String fsLocnDesc   = "";
		String facilityID   = "";
		String facilityName = "";

		String mysql  = "SELECT fs_locn_code,short_desc FROM fm_storage_locn WHERE facility_id='" +facility_id+"' AND mr_locn_yn='Y' AND permanent_file_area_yn='Y' AND 	eff_status='E' ORDER BY 2";
		String mysql1 = "SELECT facility_id,facility_name FROM sm_facility_param ORDER BY 2";
		try
		{
			conn = ConnectionManager.getConnection(request);
			stmt = conn.createStatement();
			rst  = stmt.executeQuery(mysql);
			while(rst != null && rst.next())
			{
				fsLocnCode = ((rst.getString("fs_locn_code") == null) || (rst.getString("fs_locn_code").equals("null"))) ? "" : rst.getString("fs_locn_code");
				fsLocnDesc = ((rst.getString("short_desc") == null) || (rst.getString("short_desc").equals("null"))) ? "" : rst.getString("short_desc");

				sb.append("<OPTION  value='"+fsLocnCode+"'>"+fsLocnDesc+"</OPTION>"); 
			}
			if(rst  != null) rst.close();
			rst = stmt.executeQuery(mysql1);
			while(rst != null && rst.next())
			{
				facilityID   = ((rst.getString("facility_id") == null) || (rst.getString("facility_id").equals("null"))) ? "" : rst.getString("facility_id");
				facilityName = ((rst.getString("facility_name") == null) || (rst.getString("facility_name").equals("null"))) ? "" : rst.getString("facility_name"); 

				sb1.append("<OPTION value='"+facilityID+"'>"+facilityName+"</OPTION>");
			}
%>
			<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
				<FORM name='repStatsFileNotRetForm' id='repStatsFileNotRetForm' action='../../eCommon/jsp/report_options.jsp' target='messageFrame'>
					<BR><BR><BR><BR><BR>
					<TABLE cellspacing='0' cellpadding='0' border='0' align='center'>
						<TR><TD colspan='2'>&nbsp;</TD></TR>
						<TR>
							<TD class='label' width='20%' ><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
							<TD class='fields' width='40%' ><SELECT name='fsLocnCode' id='fsLocnCode' onChange='ClearAllValues()'>
									<OPTION value='all'>----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</OPTION>
									<%=sb.toString()%>
								</SELECT>
							</TD>
						</TR>
						<TR><TD colspan='2'>&nbsp;</TD></TR>
						<TR>
							<TD class='label' width='20%' ><fmt:message key="eFM.OutstandingFrom.label" bundle="${fm_labels}"/></TD>
							<TD class='fields' width='40%' ><SELECT name='outstandFacilityID' id='outstandFacilityID'>
									<OPTION value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</OPTION>
									<%=sb1.toString()%>
								</SELECT>
							</TD>
						</TR>
						<TR><TD colspan='2'>&nbsp;</TD></TR>
						<TR>
							<TD class='label' width='20%'><fmt:message key="eFM.OutstandingFSLocation.label" bundle="${fm_labels}"/></TD>
							<TD class='fields' width='40%' ><SELECT name='outstndFSLocnCode' id='outstndFSLocnCode' onChange='PopFSLocn(this)'>
									<OPTION value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</OPTION>
									<OPTION value='C'><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
									<OPTION value='T'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></OPTION>
									<OPTION value='N'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
									<OPTION value='E'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></OPTION>
									<OPTION value='Y'><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></OPTION>
									<OPTION value='D'><fmt:message key="Common.department.label" bundle="${common_labels}"/></OPTION>
								</SELECT>
								&nbsp;/&nbsp;
								<SELECT name='outstndFSLocn' id='outstndFSLocn'>
									<OPTION value=''>--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</OPTION>
								</SELECT>
							</TD>
						</TR>
						<TR><TD colspan='2'>&nbsp;</TD></TR>
					</TABLE>
				</FORM>
			</BODY>
<%	
		if(rst  != null) rst.close();
		if(stmt != null) stmt.close();
		}
		catch(Exception e)
		{
			out.println("Exception :"+e.toString());
		}
		finally
		{			
			ConnectionManager.returnConnection(conn,request);
		}
%>
		</HTML>
<%
	}
	else
	{
%>	
		<iframe name='commonToolbar' id='commonToolbar' src='<%=source%>' frameborder='0' scrolling='no' noresize style='height:8%;width:100vw'></iframe>
			<iframe name='repStatsNotRetCriteria' id='repStatsNotRetCriteria' src='../../eFM/jsp/RepStatisticsFileNotReturnedFrame.jsp?callFrom=mainFrame' frameborder='0' scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' scrolling='no' noresize style='height:9%;width:100vw'></iframe>
		
<%
	}
%>

