<!DOCTYPE html>
 <!-- by Meghanath -->
<%@ page import='java.sql.*,java.text.*,java.util.*,webbeans.eCommon.*' contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");
	Connection conn = null;
	Statement stmt  = null;
	ResultSet rst   = null;

	String mysql			 = "SELECT patient_id_length,file_type_appl_yn FROM mp_param";
	String file_type_appl_yn = "";

	int patient_id_max_length = 0;
	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rst  = stmt.executeQuery(mysql);
		if(rst != null && rst.next())
		{
			file_type_appl_yn     = rst.getString("file_type_appl_yn");
			patient_id_max_length = rst.getInt("patient_id_length");
		}
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
		<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
		<SCRIPT language='javascript' src='../../eFM/js/QueryFMFileEncounterDetails.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	</HEAD>
	<BODY OnMouseDown='CodeArrest();' onLoad='FocusFirstElement();' onKeyDown = 'lockKey();'>
		<FORM name='QFMFEDSearchForm' id='QFMFEDSearchForm'>
			<TABLE border='0' cellpadding='3' cellspacing='0' width='100%'>
				<TR><TD class='label' colspan='4'>&nbsp;</TD></TR>
				<TR><TD class='label' width='25%'><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></TD>
					<TD class='fields' width='25%'><INPUT type='text' name='patient_id' id='patient_id' value='' onKeyPress='return CheckForSpecChars(event)' maxlength='<%=patient_id_max_length%>' size='<%=patient_id_max_length+2%>' onBlur='ChangeUpperCase(this);clearEnctr();'><INPUT type='button' class='button' name='pat_search' id='pat_search' value='?' align=center onClick='patientSearch();'><IMG src='../../eCommon/images/mandatory.gif' align='center'></IMG></TD>
					<TD class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></TD>
					<TD class='fields'><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="//validSplchars1(this);" disabled><input type="button" name='encounter_id_search' id='encounter_id_search' value="?" class="button" onclick="callSearchScreen('E');" disabled></TD>
				</TR>
				<TR><TD class='label' colspan='4'>&nbsp;</TD>
					<TD class='button'><INPUT type='button' name='Search' id='Search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onClick='fetchResultPage();'><INPUT type='button' name='Clear' id='Clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onClick='clearPage();'></TD>
				</TR>
			</TABLE>
			<!-- below details Added by Mano against ML-MMOH-SCF-0761 -->
			<script>parent.frames[1].document.forms[0].patient_id.select();</script> 
			<!--End of ML-MMOH-SCF-0761 -->
			<INPUT type ='hidden' name='file_type_appl_yn' id='file_type_appl_yn' value='<%=file_type_appl_yn%>'>
		</FORM>
<%
	if(rst  != null) rst.close();
	if(stmt != null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
	</BODY>
</HTML>

