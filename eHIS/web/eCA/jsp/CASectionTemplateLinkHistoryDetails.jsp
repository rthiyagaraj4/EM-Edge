<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String component_id = request.getParameter("component_id") == null ? "" : request.getParameter("component_id");
%>
<title><fmt:message key="eCA.LinkHistoryElementsFor.label" bundle="${ca_labels}"/> <%=component_id%>
</title>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language="javascript" src="../js/SectionTemplate.js"></script>
<script language='javascript' src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>


<body onKeyDown="lockKey()">
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
%>
<form name='CASectionTemplateLinkHistoryForm' id='CASectionTemplateLinkHistoryForm'>
<%

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String old_hist_time_frame_unit = request.getParameter("old_hist_time_frame_unit")==null?"":request.getParameter("old_hist_time_frame_unit");

String old_hist_time_frame_val = request.getParameter("old_hist_time_frame_val")==null?"":request.getParameter("old_hist_time_frame_val");
String event_code = request.getParameter("event_code")==null?"":request.getParameter("event_code");
String event_code_type = request.getParameter("event_code_type")==null?"":request.getParameter("event_code_type");

String hist_rec_type_hdn = request.getParameter("hist_rec_type")==null?"":request.getParameter("hist_rec_type");

String sql = "";
String hist_rec_type = "";
String hist_rec_type_desc = "";
String dis_hist_type = "";

/*if(!hist_rec_type_hdn.equals(""))
    dis_hist_type = "disabled";
else
	dis_hist_type = "";*/

//out.println("<script>alert('"+old_hist_time_frame_unit+"LHHH "+old_hist_time_frame_val+"')</script>");

%>
<br>
<br>
<table width='100%' height='80%' cellpadding='3' cellspacing=0 border=0 align='center'>
	<tr>
		<td class='label' width='25%' ><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td>
		<td class='fields'width='25%' >
			<select name='result_category' id='result_category' onchange='setHiddenVal(this)' <%=dis_hist_type%>>
				<option value='' >-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
				<%
					try
					{
						con = ConnectionManager.getConnection(request);
						//sql = "select short_desc, hist_rec_type from cr_hist_rec_type where hist_rec_type !='CLNT' order by 1";
						sql ="SELECT  hist_rec_type,short_desc FROM cr_hist_rec_type WHERE hist_rec_type NOT IN('DIAG','ALGY','MEDN','NBDT','FEVT','CLNT') ORDER BY 2";
						pstmt = con.prepareStatement(sql);
						rs = pstmt.executeQuery();

						while(rs.next())
						{
							hist_rec_type = rs.getString("hist_rec_type");
							hist_rec_type_desc = rs.getString("short_desc");

							if(hist_rec_type_hdn.equals(hist_rec_type))
							{
									out.println("<option value=\""+hist_rec_type+"\"  selected >"+hist_rec_type_desc+"</option>");
							}
							else
							{
									out.println("<option value=\""+hist_rec_type+"\" >"+hist_rec_type_desc+"</option>");
							}
						}
						if(pstmt != null) pstmt.close();
						if(rs != null) rs.close();
					}
					catch(Exception e)
					{
						//out.println("Exception in CASectionTemplateLinkHistoryDetails.jsp "+e.toString());//COMMON-ICN-0181
						e.printStackTrace();//COMMON-ICN-0181
					}
					finally
					{
                      if(con!=null) ConnectionManager.returnConnection(con,request);
					}

				%>
			</select>
		</td>
		<td class='label' width='25%'><fmt:message key="eCA.ClinicalEvents.label" bundle="${ca_labels}"/></td>
		<td class='fields'width='25%' >
			<input type='text' name='clinEventLookUpTxt' id='clinEventLookUpTxt' value="<%=event_code%>" onBlur="openClinEventWindow(this)"><input type='button' class='button' value='?' name='clinEventLookUpBtn' id='clinEventLookUpBtn' onclick="openClinEventWindow(this)" ><img name='mand_img' src='../../eCommon/images/mandatory.gif' align='center' style="display:none"></img>
		</td>
	</tr>
	<tr>
		<td class="label" width='25%' ><fmt:message key="Common.Limit.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%'><input type='text' name='time_frame_value' id='time_frame_value' size='3' maxlength='3' value="<%=old_hist_time_frame_val%>" onKeyPress="return allowValidNumber(this,event,2,0)" onBlur="checkForZero(this)">
			<select name="linkHistoryResult" id="linkHistoryResult" onChange='defaultTimeVal(this)'>
				<option value="" >---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<option value="D" <%=old_hist_time_frame_unit.equals("D")?"selected":""%>><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
				<option value="W" <%=old_hist_time_frame_unit.equals("W")?"selected":""%>><fmt:message key="Common.weeks.label" bundle="${common_labels}"/></option>
				<option value="M" <%=old_hist_time_frame_unit.equals("M")?"selected":""%>><fmt:message key="Common.months.label" bundle="${common_labels}"/></option>
				<option value="Y" <%=old_hist_time_frame_unit.equals("Y")?"selected":""%>><fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>
				<option value="L" <%=old_hist_time_frame_unit.equals("L")?"selected":""%>><fmt:message key="Common.Last.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Event.label" bundle="${common_labels}"/></option>
			</select><img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td width='25%'></td><td width='25%'></td>
	</tr>
	<tr>
	    <td width='25%'></td><td width='25%'></td><td width='25%'></td>
		<td width='25%'  ><input type='button' name='ok_butn' id='ok_butn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='callOnOKBtn()' class='button' ><input type='button' name='close_butn' id='close_butn' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onclick="callOnClose('<%=old_hist_time_frame_val%>','<%=event_code%>','<%=event_code_type%>','<%=hist_rec_type_hdn%>','<%=old_hist_time_frame_unit%>')" class='button' ></td>
	</tr>
</table>
	<input type='hidden' name='clinEventLookUpCodeHidden' id='clinEventLookUpCodeHidden' value='<%=event_code%>'>
	<input type='hidden' name='clinEventLookUptypeHidden' id='clinEventLookUptypeHidden' value='<%=event_code_type%>'>
	<input type='hidden' name='histRecTypeHidden' id='histRecTypeHidden' value='<%=hist_rec_type_hdn%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
</form>
</body>

			

		


