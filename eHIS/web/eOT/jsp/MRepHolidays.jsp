<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
 <% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
	String locale	= (String)session.getAttribute("LOCALE");
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   String holiday_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Holiday.label","common_labels");
Connection con=null;
PreparedStatement pstmt=null;
ResultSet rst=null;
String fac_id="";
String fac_name="";
String sql = "";
String surgery_date = "";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}

	
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
	%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOT/js/OtReports.js"> </script>
	<script language="javascript" src="../../eOT/js/OTReportsLkupSQL.js"> </script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eOT/js/MasterReports.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.MRepHolidayForm.param1.focus();">
	<FORM name="MRepHolidayForm" id="MRepHolidayForm" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

 
		<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="7" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD WIDTH="25%"></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
			<TD WIDTH="25%" colspan='4'></TD>
		</TR>
		<tr> 
	<td class='label' width='25%'>
		<fmt:message key="Common.Holiday.label" bundle="${common_labels}"/>&nbsp;
	</td>
	 <td class='fields' width='25%'>
		 <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('param1');">
		</td>
		<td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onBlur="CheckDate(this);">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('param2');">
		</td>
		<TD WIDTH="25%" colspan='4'></TD>
	 
</tr>
		
		<TR>
			<TD COLSPAN="7">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="7">&nbsp;</TD>
		</TR>
		<TR><!-- Commented by Rajesh according to Vishwa's Instruction for Issue 6585 -->
<!-- 			<TD ALIGN="right" WIDTH="25%" CLASS="label">
			<fmt:message key="eOT.PrintOption.Label" bundle="${ot_labels}"/> &nbsp;</TD>
			<TD ALIGN="left">
			<SELECT name="param3" id="param3" tabIndex="3">
				<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="A"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="S"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
			</TD>
 -->			<TD class='label'>
			<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
			</TD>
			<TD>
			<SELECT name="p_order_by" id="p_order_by" tabIndex="4">
				<OPTION VALUE="D" selected><fmt:message key="Common.description.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="C"><fmt:message key="Common.code.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
			</TD>
			<TD WIDTH="30%" colspan='3'></TD>
		</TR>
		<TR>
			<TD COLSPAN="7">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="7">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="left" WIDTH="25%" CLASS="label">
			<fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD COLSPAN="2" ALIGN="left">
			<SELECT name="param4" id="param4" tabIndex="3">
				<OPTION VALUE=""></OPTION>
			<% try
      {
     //   con=ConnectionManager.getConnection(request);
	//	String ot="OT";
		sql="select FACILITY_ID, FACILITY_NAME from sm_facility_param";
		pstmt=con.prepareStatement(sql);
		rst=pstmt.executeQuery();
		if(rst!=null)
		{
		   while(rst.next())
		        {
			        fac_id=rst.getString(1);
			        fac_name=rst.getString(2);
                    %>	
					<option value= "<%=fac_id%>"><%=fac_name%></option>
            <%  }}
	  }catch(Exception e){
		System.err.println("Err Msg TheatreBkgByOtRoomReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		
	}
		
	  %>
			</select>		

			</TD>
			<TD COLSPAN="2" ALIGN="left" class='label'>
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</td>&nbsp;
			<td>
			<SELECT name="param5" id="param5" tabIndex="3">
				<OPTION VALUE=""></OPTION>
			<% 
       // con=ConnectionManager.getConnection(request);
//		String ot="OT";
		sql="select FACILITY_ID, FACILITY_NAME from sm_facility_param";
		pstmt=con.prepareStatement(sql);
		rst=pstmt.executeQuery();
		   while(rst.next())
		        {   fac_id=rst.getString(1);
			        fac_name=rst.getString(2);
                    %>	
					<option value= "<%=fac_id%>"><%=fac_name%></option>
            <%  }
	  %>
			</select>		
	 <%}catch(Exception e){out.println("exp"+e);}

	  finally{
	try{
		
	 if(rst!=null) rst.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con);
	}catch(Exception e)
		{
		out.println("exp"+e);
		}
}
%>
			</TD>
		</TR>
		<TR>
			<TD COLSPAN="7">&nbsp;</TD>
		</TR>
	</TABLE>

	<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="p_facility_id" id="p_facility_id" VALUE="<%= session.getValue( "facility_id" ) %>">
	<INPUT TYPE="hidden" name="user_name" id="user_name" VALUE="<%= session.getValue( "login_user" ) %>">
	<INPUT TYPE="hidden" name="module_id" id="module_id" VALUE="OT">
	<INPUT TYPE="hidden" name="p_module_id" id="p_module_id" VALUE="OT">
	<INPUT TYPE="hidden" name="report_id" id="report_id" VALUE="OTRHOLID">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="OTRHOLID">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	
</FORM>
</BODY>
</HTML>





