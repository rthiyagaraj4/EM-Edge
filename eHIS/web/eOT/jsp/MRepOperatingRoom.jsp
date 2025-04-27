<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
 <% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
	Connection con=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;	
	String sql=null;
	String fac_id=null;
	String fac_name=null;
	String locale	= (String)session.getAttribute("LOCALE");
    String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
   (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   String operatingroom_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OperatingRoom.label","common_labels");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eOT/js/MasterReports.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="document.MRepOperatingRoomForm.param1.focus();">
	<BR>
	<FORM name="MRepOperatingRoomForm" id="MRepOperatingRoomForm" ACTION="../../eCommon/jsp/report_options.jsp" TARGET="messageFrame">

 
		<TABLE WIDTH="70%" ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0">
		<TH COLSPAN="7" ALIGN="left"><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></TH>
		<TR>
			<TD WIDTH="25%"></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></TD>
			<TD CLASS="label" ALIGN="left" WIDTH="25%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></TD>
			<TD WIDTH="25%" colspan='4'></TD>
		</TR>
		<TR>
			<TD ALIGN="left" WIDTH="25%" CLASS="label">
			<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>&nbsp;
			</TD>
			<TD ALIGN="left" WIDTH="25%">
				<INPUT TYPE='text' name="param1" id="param1" SIZE="8" maxlength="8" onKeyPress="return CheckForSpecChars(event)" tabIndex="1" onblur="if(this.value!='')searchCode(document.all, 'OPERATINGROOM','<%=operatingroom_title%>', document.forms[0].param1); else this.value='' ">
				<INPUT TYPE="button" name="operatingroom" id="operatingroom" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'OPERATINGROOM','<%=operatingroom_title%>', document.forms[0].param1)">
			</TD>
			<TD ALIGN="left" WIDTH="25%">
				<INPUT TYPE='text' name="param2" id="param2" SIZE="8" maxlength="8" onKeyPress="return CheckForSpecChars(event)" tabIndex="2" onblur="if(this.value!='')searchCode(document.all, 'OPERATINGROOM','<%=operatingroom_title%>', document.forms[0].param2); else this.value='' ">
				<INPUT TYPE="button" name="operatingroomTo" id="operatingroomTo" VALUE="?" CLASS="button" onclick="searchCode(document.all, 'OPERATINGROOM','<%=operatingroom_title%>', document.forms[0].param2)">
			</TD>
			<TD WIDTH="30%" colspan='4'></TD>
		</TR>
		<TR>
			<TD COLSPAN="7">&nbsp;</TD>
		</TR>
		<TR>
			<TD COLSPAN="7">&nbsp;</TD>
		</TR>
		<TR>
			<TD ALIGN="left" WIDTH="25%" CLASS="label">
			<fmt:message key="eOT.PrintOption.Label" bundle="${ot_labels}"/> &nbsp;</TD>
			<TD  ALIGN="left">
			<SELECT name="param3" id="param3" tabIndex="3">
				<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="A"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="S"><fmt:message key="Common.Disabled.label" bundle="${common_labels}"/></OPTION>
			</TD>
			<TD class='label'>
			<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;
			</TD>
			<TD>
			<SELECT name="p_order_by" id="p_order_by" tabIndex="4">
				<OPTION VALUE="D" selected><fmt:message key="Common.description.label" bundle="${common_labels}"/></OPTION>
				<OPTION VALUE="C"><fmt:message key="Common.code.label" bundle="${common_labels}"/></OPTION>
			</SELECT>
			</TD>
			<TD WIDTH="30%" colspan='2'></TD>
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
       con=ConnectionManager.getConnection(request);
		sql="select FACILITY_ID, FACILITY_NAME from sm_facility_param";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        fac_id=rs.getString(1);
			        fac_name=rs.getString(2);
                    %>	
					<option value= " <%=fac_id%>"> <%=fac_name%> </option>
            <%  }
	  }
	  	if(rs!=null)rs.close();
		if(rs!=null)stmt.close();
		
		%>
			</select>		

			</TD>
			<TD COLSPAN="2" ALIGN="left">
			<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</td>&nbsp;
			<td>
			<SELECT name="printoption" id="printoption" tabIndex="3">
				<OPTION VALUE=""></OPTION>
			<% 
       // con=ConnectionManager.getConnection(request);
		sql="select FACILITY_ID, FACILITY_NAME from sm_facility_param";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs!=null)
		{
		   while(rs.next())
		        {
			        fac_id=rs.getString(1);
			        fac_name=rs.getString(2);
                    %>	
					<option value= " <%=fac_id%>"> <%=fac_name%> </option>
            <%  }
	  }%>
			</select>		
	 <% }catch(Exception e){out.println("exp"+e);}

	  finally{
	try{
		
	 if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
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
	<INPUT TYPE="hidden" name="report_id" id="report_id" VALUE="OTROTROM">
	<INPUT TYPE="hidden" name="p_report_id" id="p_report_id" VALUE="OTROTROM">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	
</FORM>
</BODY>
</HTML>





