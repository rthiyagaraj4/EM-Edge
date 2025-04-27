<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
    String patientid		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
    String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
    String enc_id		= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
    String called_from		= request.getParameter("called_from")==null?"":request.getParameter("called_from");
    String normalcy		= request.getParameter("normalcy")==null?"":request.getParameter("normalcy");
	if(enc_id.equals("")) enc_id = "0";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	HashMap mapDescColor = new HashMap();
	ArrayList listDesc = new ArrayList();
	String low_value_color ="";
    String high_value_color ="";
	String abnml_value_color ="";
	String crtcl_value_color ="";
	String crtcl_low_value_color ="";
	String crtcl_high_value_color ="";
	String high_value_desc ="";
	String low_value_desc ="";
	String abnml_value_desc	= "";
	String crtcl_value_desc	= "";
	String crtcl_low_value_desc	= "";
	String crtcl_high_value_desc	= "";
	String delta_fail_str = "";
	String birth="";

	String emailDisp = "style='display'";
	String defPrevStatus = "";	
	String defPrevStatusForPrint = "";	
	String printDisp = "style='display'";
%>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCA/js/Encounters.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
<STYLE>
	td.errorEvents
	{
		background-color: BROWN;
		border-style: dashed;
	}
	FONT.DELTAFAIL{
		background-color:#FFE4E1;
	}

</STYLE>
</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="button_form" id="button_form">
<%
	
	try{
		
		con = ConnectionManager.getConnection(request);

		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'EMAIL_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatus = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		pstmt = con.prepareStatement("select DFLT_PRIVILEGE_STATUS from ca_appl_task where APPL_TASK_ID = 'PRINT_CLIN_DATA' ");
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			defPrevStatusForPrint = rs.getString("DFLT_PRIVILEGE_STATUS") == null ? "" : rs.getString("DFLT_PRIVILEGE_STATUS");
		}

		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if(defPrevStatusForPrint.equals("A")) printDisp = "style='display'";
		else printDisp = "style='display:none'";

		if(defPrevStatus.equals("A")) emailDisp = "style='display'";
		else emailDisp = "style='display:none'";

		pstmt = con.prepareStatement("SELECT high_str_desc,high_color_code,low_str_desc,low_color_code,abn_str_desc,abn_color_code,crit_str_desc,crit_color_code,crit_high_str_desc,crit_high_color_code,crit_low_str_desc,crit_low_color_code,DELTA_FAIL_STR,HIGH_SYMBOL_ICON,LOW_SYMBOL_ICON,ABN_SYMBOL_ICON,CRIT_SYMBOL_ICON,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_SYMBOL_ICON,nvl((select 'Y' from mp_birth_register where patient_id=?),'N') birth FROM CR_CLIN_EVENT_PARAM");

		pstmt.setString(1,patientid);
		rs = pstmt.executeQuery();

		if(rs.next())
		{
			high_value_desc = rs.getString("high_str_desc") == null ? "" : rs.getString("high_str_desc");
	        high_value_color = rs.getString("high_color_code") == null ? "" : rs.getString("high_color_code");
			if(normalcy.equals("I"))
				high_value_color = rs.getString("HIGH_SYMBOL_ICON") == null ? "" : rs.getString("HIGH_SYMBOL_ICON");
			mapDescColor.put(high_value_desc,high_value_color);
		    listDesc.add(high_value_desc);

		    low_value_desc = rs.getString("low_str_desc") == null ? "" : rs.getString("low_str_desc");
		    low_value_color = rs.getString("low_color_code") == null ? "" : rs.getString("low_color_code");
			if(normalcy.equals("I"))
				low_value_color = rs.getString("LOW_SYMBOL_ICON") == null ? "" : rs.getString("LOW_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(low_value_desc)))
			{
				mapDescColor.put(low_value_desc,low_value_color);
				listDesc.add(low_value_desc);
			}

		    abnml_value_desc = rs.getString("abn_str_desc") == null ? "" : rs.getString("abn_str_desc");
		    abnml_value_color = rs.getString("abn_color_code") == null ? "" : rs.getString("abn_color_code");
			if(normalcy.equals("I"))
				abnml_value_color = rs.getString("ABN_SYMBOL_ICON") == null ? "" : rs.getString("ABN_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(abnml_value_desc)))
			{
				mapDescColor.put(abnml_value_desc,abnml_value_color);
				listDesc.add(abnml_value_desc);
			}

		    crtcl_value_desc = rs.getString("crit_str_desc") == null ? "" : rs.getString("crit_str_desc");
		    crtcl_value_color = rs.getString("crit_color_code") == null ? "" : rs.getString("crit_color_code");
			if(normalcy.equals("I"))
				crtcl_value_color = rs.getString("CRIT_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(crtcl_value_desc)))
			{
				mapDescColor.put(crtcl_value_desc,crtcl_value_color);
				listDesc.add(crtcl_value_desc);
			}

		    crtcl_high_value_desc = rs.getString("crit_high_str_desc") == null ? "" : rs.getString("crit_high_str_desc");
		    crtcl_high_value_color = rs.getString("crit_high_color_code") == null ? "" : rs.getString("crit_high_color_code");
			if(normalcy.equals("I"))
				crtcl_high_value_color = rs.getString("CRIT_HIGH_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_HIGH_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(crtcl_high_value_desc)))
			{
				mapDescColor.put(crtcl_high_value_desc,crtcl_high_value_color);
				listDesc.add(crtcl_high_value_desc);
			}

		    crtcl_low_value_desc = rs.getString("crit_low_str_desc") == null ? "" : rs.getString("crit_low_str_desc");
		    crtcl_low_value_color = rs.getString("crit_low_color_code") == null ? "" : rs.getString("crit_low_color_code");
			if(normalcy.equals("I"))
				crtcl_low_value_color = rs.getString("CRIT_LOW_SYMBOL_ICON") == null ? "" : rs.getString("CRIT_LOW_SYMBOL_ICON");
			if(!(mapDescColor.containsKey(crtcl_low_value_desc)))
			{
				mapDescColor.put(crtcl_low_value_desc,crtcl_low_value_color);
				listDesc.add(crtcl_low_value_desc);
			}

			delta_fail_str = rs.getString("DELTA_FAIL_STR");
			birth = rs.getString("birth");		
		
			out.println("<input type=hidden name='mode' id='mode' value='update'>");				
	}
	else
	{
		out.println("<input type=hidden name='mode' id='mode' value='insert'>");
	}
	%>

	<table cellpadding=0 cellspacing=3 border = '0' width='100%' align='right'>
		<tr>
	<%
		String listValues = "";
		String listValuesdisp = "";
		String mapValues = "";
	%>
			<!--<td width='25%'>&nbsp;</td>-->
	<%

	    for(int i=0;i<listDesc.size();i++)
		{
			listValues = (String) listDesc.get(i);
			if(listValues.length()>15)
				listValuesdisp=listValues.substring(0,16);
			else
				listValuesdisp=listValues;
			mapValues = (String) mapDescColor.get(listValues);
			if(normalcy.equals("I"))
			{
	%>
				<%-- <td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')">
					<font style='background:url("../../eCA/images/<%=mapValues%>");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=listValuesdisp%></font>
				</td> --%>
				  <td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')">
        <span style='background:url("../../eCA/images/<%=mapValues%>"); width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size: 12px;"><%=listValuesdisp%></span>
    </td>
	<%
			}
			else{%>
				<%-- <td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')">
				 <font style='background-color:<%=mapValues%>;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1><%=listValuesdisp%></font></td> --%>
		  <td nowrap onMouseOut='clearLayer()' onMouseOver="showToolTip(this,'<%=i%>','<%=listValues%>')">
        <span style='background-color:<%=mapValues%>; width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size: 12px;"><%=listValuesdisp%></span>
    </td>
		
		<%}
		}
			if(normalcy.equals("I"))
			{
		%>
				 <td nowrap>
        <span style='background:url("../../eCA/images/NI_Normal.gif"); width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></span>
    </td>
		<%
			}
			else
			{
		%>
				<td nowrap>
        <span style='background-color:#32CD32; width:16px; height:16px; display:inline-block;'>&nbsp;&nbsp;</span>&nbsp;
        <span style="font-size:12px;"><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></span>
    </td>
		<%
			}
		%>
		<!-- <td colspan='2'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td  class='label'>&nbsp;<fmt:message key="eCA.ClickOnValueCell.label" bundle="${ca_labels}"/></td>
		<td width='5%'>
				<INPUT TYPE="button" value='<fmt:message key="eCA.Manage.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='manageText()' title='Click to manage the events'>
		</td>
		<td width='5%'>
				<INPUT TYPE="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")%>' class='BUTTON' onClick='showEnterQuickText();' title='Click to enter comments'>
		</td>
		<td  width='3%'>
				<input type="button"  name="print" id="print"  class="button" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.print.label","common_labels")%>' onClick="valsForPrint()" title='Click to print the events' >
		</td>
		<td width='5%'>
				<INPUT TYPE="button" value='<fmt:message key="eCA.Email.label" bundle="${ca_labels}"/>' class='BUTTON' onClick='emailText()' title='Click to email the events' name='emailBtn' <%=emailDisp%>>
		</td> -->		
		
	</tr>
	</table>

	<input type="hidden" value="<%=patientid%>" name="patient_id">
	<input type="hidden" value="<%=encounter_id%>" name="encounter_id">
	<input type="hidden" value="<%=enc_id%>" name="enc_id">
	<input type="hidden" value="<%=called_from%>" name="called_from">
	<input type="hidden" value="" name="data_type" id="data_type">
	<div id='descLink' style='position:absolute; visibility:hidden;overflow:overflow' ></div>
	</form>
<%
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	out.println("Exception in ChartRecordingColorBar.jsp"+e.toString());
	e.printStackTrace();
}
finally
{	
	if(con !=null)ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

