<!DOCTYPE html>
<!-- 
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        Description
-----------------------------------------------------------------------------------------------
?             	100         ?           	created
06/02/2013	IN037675		Dinesh T	IN037675
16/03/2013	IN038659		DineshT		Privilege level setup with sign is not working		
05/06/2018  IN67872	  Dinesh T	05/06/2018	Ramesh G	CRF-0497.1
-----------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@taglib uri="/WEB-INF/tld/iba-autocompletetag.tld" prefix="ibaAutoComplete" %>
<%
	
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;

	String	note_type			=	"",		clinician_id				=	"";
	String	clinician_name		=	"",		query_clinician_details		=	"";
	String	operation_mode		=	"",		window_title				=	"";
	String  query_speciality_details = "";
	String	facility_id = session.getValue("facility_id")==null?"": (String) session.getValue("facility_id");
	String	ca_practitioner_id = "";
	String remarks = "";
	HashMap map = new HashMap();
	HashMap map1 = new HashMap();
	
	//IN037675, starts
	String displayPracTable = "";
	String displaySpecTable = "";
	String pracDefaultValue = "";
	String specDefaultValue = "";
	String prac_level = "";
	String spec_level = "";
	String forward_mode = request.getParameter("forward_mode")==null?"P":request.getParameter("forward_mode");
	//IN037675, ends
	
	try
	{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		con	= ConnectionManager.getConnection(request);

		try
		{
			ca_practitioner_id	=	(String) session.getValue("ca_practitioner_id");

			note_type		=	checkForNull( request.getParameter("note_type"));
			operation_mode	=	checkForNull( request.getParameter("operation_mode"));

			//if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ))//IN67872
			if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ||operation_mode.equals("REJECT")))//IN67872
				remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Subject.label","ca_labels");
			else
				remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
			
		}
		catch(Exception e)
		{
			out.println("Exception@1: "+e);
		}
		query_clinician_details = "SELECT a.practitioner_id clinician_id, b.practitioner_name clinician_name FROM am_pract_for_facility a, am_practitioner_lang_vw b WHERE b.language_id = ? AND a.facility_id = ? and b.practitioner_id = a.practitioner_id AND a.practitioner_id != ? AND a.practitioner_id IN (SELECT ia.func_role_id FROM ca_note_type_for_resp ib,sm_appl_user ia, sm_resp_for_user ic WHERE ib.note_type = ? AND ib.privilege_type IN ('3', '4') AND ia.appl_user_id = ic.appl_user_id AND ic.resp_id = ib.resp_id)  order by 2"; 
		query_speciality_details = "Select speciality_code, short_desc speciality_desc from am_speciality_lang_vw where EFF_STATUS = 'E' and language_id = ? ORDER BY 2";

		int pract = 0;
		int splty = 0;
%>
<html>
<head>
<!--	<title><%=window_title%></title> -->
	
	<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart2.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<style>
textarea {
  resize: none;
}
</style>
 
	<ibaAutoComplete:setup></ibaAutoComplete:setup>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" class='CONTENT'>
	<center>
	<form name='RecClinicalNotesForwardForm' id='RecClinicalNotesForwardForm' >

<%
	//if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ))//IN67872
	if(!(operation_mode.equals("MarkAsError") || operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") ||operation_mode.equals("REJECT")))//IN67872
	{
		if(operation_mode.equals("Forward"))
		{
%>
		 <table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' style="display">
			<TR>
				<TD class='LABEL' width='25%'><fmt:message key="eCA.ForwardTo.label" bundle="${ca_labels}"/>:</TD>
				<TD class='LABEL' width='75%' colspan='2'>&nbsp;
					<input type="radio" name="forward_to" id="forward_to" class="label" value="P" checked onclick='setValues(this)'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
					<input type="radio" name="forward_to" id="forward_to" class="label" value = "S" onclick='setValues(this)'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
				</TD>
			</TR>
			<tr><td colspan=3>&nbsp;</td></tr>
		</table> 
<%
		}
		else
		{
			out.println("<br><br><br>");
		}
		String key = "*ALL";
		String value = "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;----- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
		try
		{
			map.put(key,value);
			pstmt		=	con.prepareStatement(query_speciality_details);
			pstmt.setString( 1,	locale);
			rs			=	pstmt.executeQuery();
			while(rs.next())
			{
				splty++;
				clinician_id	=	rs.getString("speciality_code");
				clinician_name	=	rs.getString("speciality_desc");
				map.put(clinician_id,clinician_name);
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(splty == 0)
			{
				key = "ALL";
				value = "ALL";
				map.put(key,value);
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
		          e.printStackTrace();//COMMON-ICN-0181
		}
		
		try
		{
			map1.put(key,value);
			pstmt		=	con.prepareStatement(query_clinician_details);
			pstmt.setString( 1,	locale);
			pstmt.setString( 2,	facility_id);
			pstmt.setString( 3,	ca_practitioner_id);
			pstmt.setString( 4, note_type);

			rs			=	pstmt.executeQuery();

			while(rs.next())
			{
				pract++;
				clinician_id	=	rs.getString("clinician_id");
				clinician_name	=	rs.getString("clinician_name");
				map1.put(clinician_id,clinician_name);
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			if(pract == 0)
			{
				key = "ALL";
				value = "ALL";
				map1.put(key,value);
			}
		}
		catch(Exception e)
		{
			//out.println("Exception@2: "+e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}

		//IN037675, starts
		
		Statement stmt11 = null;
		PreparedStatement	pstmt11		=	null;//common-icn-0180
		ResultSet rs11 = null;

		try
		{
			//String sql = "SELECT FWD_PRACT_IND,FWD_SPLTY_IND FROM CA_NOTE_TYPE WHERE NOTE_TYPE = '"+ note_type +"'";	//common-icn-0180
			String sql = "SELECT FWD_PRACT_IND,FWD_SPLTY_IND FROM CA_NOTE_TYPE WHERE NOTE_TYPE = ?";	//common-icn-0180
			//stmt11 = con.createStatement();//common-icn-0180	
			pstmt11		=	con.prepareStatement(sql);//common-icn-0180
			pstmt11.setString(1,note_type);//common-icn-0181
			//rs11 = stmt11.executeQuery(sql);//common-icn-0180
			rs11 = pstmt11.executeQuery();//common-icn-0180

			while(rs11.next())
			{
				prac_level = rs11.getString("FWD_PRACT_IND");
				spec_level = rs11.getString("FWD_SPLTY_IND");
			}			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs11!=null)
				rs11.close();
			if(stmt11!=null)	
				stmt11.close();
		}
	
		//String facility_id = (String)session.getValue("facility_id");
		
		displayPracTable = "";
		displaySpecTable = "";
		pracDefaultValue = "";
		specDefaultValue = "";

		if(forward_mode.equals("P"))
		{
			if(prac_level.equals("A"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display:none";
			}
			else if(prac_level.equals("F"))
			{
				displayPracTable = "display";
				displaySpecTable = "display:none";
			}
			else if(prac_level.equals("P"))
			{
				displayPracTable = "display";
				displaySpecTable = "display:none";
			}
		}
		else
		{
			if(spec_level.equals("A"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display:none";
			}
			else if(spec_level.equals("F"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display";
			}
			else if(spec_level.equals("P"))
			{
				displayPracTable = "display:none";
				displaySpecTable = "display";
			}
		}

		if(!prac_level.equals("F"))
			pracDefaultValue = "ALL";

		if(!spec_level.equals("F"))
			specDefaultValue = "ALL";
		//IN037675, ends
		
%>
		<!--IN037675, starts-->
		<table width= '100%' align = 'center' id = 'pracLevelFacility' style = '<%=displayPracTable%>'>
		<tr>
			<td class = 'LABEL' width='30%'>
				<fmt:message key = "Common.FacilityID.label" bundle = "${common_labels}"/>
			</td>
			<td class = 'field' width='50%'>
				<select name = 'forwardToFac' id = 'forwardToFac'>
<%
					if(pracDefaultValue.equals("ALL"))
					{
%>
					<option value = '*A'>ALL</option><!--IN038659-->
		<%			
					}
		Statement stmt = null;

		try
		{
			
			stmt 		=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs			=	stmt.executeQuery("SELECT FACILITY_ID,FACILITY_NAME from SM_FACILITY_PARAM");

			while(rs.next())
			{
%>
				<option value = '<%=rs.getString("FACILITY_ID")%>' <%if(prac_level.equals("F") && facility_id.equals(rs.getString("FACILITY_ID"))){%>selected<%}%>><%=rs.getString("FACILITY_NAME")%></option>
				
<%
			}
		}
		catch(Exception e)
		{
			out.println("Exception@2: "+e);
		}	
		finally
		{
			if(stmt!=null)
				stmt.close();
		}
		
		%>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
		</table>

		<table width= '100%' align = 'center' id = 'specLevelFacility' style = '<%=displaySpecTable%>'>
		<tr>
			<td class = 'LABEL' width='30%'>
				<fmt:message key = "Common.FacilityID.label" bundle = "${common_labels}"/>
			</td>
			<td class = 'field' width='50%'>
				<select name = 'forwardToFac1' id = 'forwardToFac1'>
<%
					if(specDefaultValue.equals("ALL"))
					{
%>
					<option value = '*A'>ALL</option><!--IN038659-->
		<%	
					}
		
		//Statement stmt = null;
		try
		{
			stmt 		=	con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs			=	stmt.executeQuery("SELECT FACILITY_ID,FACILITY_NAME from SM_FACILITY_PARAM");

			while(rs.next())
			{
%>
				<option value = '<%=rs.getString("FACILITY_ID")%>' <%if(spec_level.equals("F") && facility_id.equals(rs.getString("FACILITY_ID"))){%>selected<%}%>><%=rs.getString("FACILITY_NAME")%></option>
				
<%
			}
		}
		catch(Exception e)
		{
			out.println("Exception@2: "+e);
		}	
		finally
		{
			if(rs!=null)
				rs.close();
			if(stmt!=null)
				stmt.close();	
		}
		
		%>
				</select>
			</td>
			<td>&nbsp;</td>
		</tr>
		</table>
		<!--IN037675, ends-->

		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' id='speciality'>
			<tr>
				<td class='LABEL'  width='19.5%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td width='50%' id='speciality_list' nowrap><ibaAutoComplete:ibaAutoCompleteCombo map="<%=map%>" id="splty_id" name='splty_id' defaultSelection='*ALL'  onfocus='delSelect(splty_id)' onblur='speciality_change(splty_id)' onclick='delSelect1(splty_id)' /></td>
			</tr>
		</table>

		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' id="practitioner" style="display">
			<tr>
				<td class='LABEL' id='pract_label' width='28%' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td width='25%' id='pract_list' nowrap>
					<input type ="text" name ="forwarded_clinician_id" value=""  onBlur="populatePractitioner1(this)" size="32"><input type="button" value="?" class="button" onClick="populatePractitioner()" name='search_btn_pract' id='search_btn_pract' >
					<!-- <ibaAutoComplete:ibaAutoCompleteCombo map="<%=map1%>" id="forwarded_clinician_id" name='forwarded_clinician_id'    defaultSelection='*ALL' onfocus='delSelect(forwarded_clinician_id)' onblur='pract_change(forwarded_clinician_id)' onclick='delSelect1(forwarded_clinician_id)' /> -->
				</td>
				<td><img src='../../eCommon/images/mandatory.gif'></img></td>
			</tr>
		</table>

<%
	} // end of if(!(operation_mode.equals("MarkAsError")))
%>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center' style="display">
		<tr>
			<td class='LABEL'  width='27%'><%=remarks%></td>
			<td colspan=1>&nbsp;<TEXTAREA NAME="action_comment" ROWS="3"  COLS="35" onKeyPress="return restrictPercentile(event);return checkMaxLimit(this,200);" onblur="chkMaxLenForLongTest('action_comment','<%=remarks%>',200)"></TEXTAREA>&nbsp;<img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		</tr>
		<tr>
			<td colspan=2 align='right' width='100%'>
				<input type='BUTTON' class='BUTTON' name='ok' id='ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='closeForwardWindow();'>&nbsp;<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='parent.window.close();'>
			</td>
		</tr>
		<tr><td colspan=2>&nbsp;</td></tr>
		<tr><td colspan=2>&nbsp;</td></tr>
	</table>

	
		<input type='hidden' name='operation_mode' id='operation_mode' value="<%=operation_mode%>">
		<input type='hidden' name='forward_mode' id='forward_mode' value="P">
		<input type='hidden' name='note_type' id='note_type' value="<%=note_type%>">
		<input type='hidden' name='speciality_id' id='speciality_id' value="">
		<input type='hidden' name='pract_id' id='pract_id' value="">
		<input type='hidden' name='clinician_id' id='clinician_id' value="<%=ca_practitioner_id%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
		<!--IN037675, starts-->
		<input type = 'hidden' name = 'displayPracTable' value = '<%=displayPracTable%>'/>
		<input type = 'hidden' name = 'displaySpecTable' value = '<%=displaySpecTable%>'/>
		<input type = 'hidden' name = 'prac_level' value = '<%=prac_level%>'/>
		<input type = 'hidden' name = 'spec_level' value = '<%=spec_level%>'/>
		<!--IN037675, ends-->
	</form>
	</center>
</body>

</html>
<%
}
catch(Exception e)
{
	out.println("Exception @ finally RecClinicalNotesForward.jsp "+e.toString());
}
finally
{
	if(con!=null)	ConnectionManager.returnConnection(con,request);
}			
%>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

