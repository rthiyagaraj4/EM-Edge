<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
08/07/2020     IN072994          Chandrashekar raju                 Modified for MMS-DM-CRF-0170.1
--------------------------------------------------------------------------------------------------------------------------------
--> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*, eOR.*,ePH.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
   

	<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>

	<title>Manual Barcode Entry Reason</title> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale					= (String)session.getAttribute("LOCALE");
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
	String bean_id		    = request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String menu_id          = request.getParameter("menu_id")==null?"":request.getParameter("menu_id");
	String sub_menu_id      = request.getParameter("sub_menu_id")==null?"":request.getParameter("sub_menu_id");
	String module_id        = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String entry_type       = request.getParameter("entry_type")==null?"":request.getParameter("entry_type");
	String order_id         = request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_no    = request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
	String batch_id         = request.getParameter("batch_id")==null?"":request.getParameter("batch_id");
	String item_code        = request.getParameter("item_code")==null?"":request.getParameter("item_code");
	String remarks_mandetory_yn        = request.getParameter("remarks_mandetory_yn")==null?"":request.getParameter("remarks_mandetory_yn");
	String patient_class        = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String speciality        = request.getParameter("speciality")==null?"":request.getParameter("speciality");

					
	
%> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="javascript" src="../../eOR/js/BarCodeManualEntryReason.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
		</script>

</head>
<body   onload='FocusFirstElement()'  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=manualBarCodeReason>
<table cellpadding=3 cellspacing=0 border=0 width='100%' height="100%" align=center>
<tr>
<td class=label>Manual Barcode Entry Reason</td>
	<td class='fields'><SELECT name="manual_reason" id="manual_reason" onchange='displayDesc(this)'>
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
			try{
				con = ConnectionManager.getConnection(request);
				   String reasonQuery="select contact_reason_code code,contact_reason description  from am_contact_reason where eff_status='E' and BARCODE_SCANNING_YN = 'Y'";
					System.err.println("locale@@==="+locale);
					pstmt =con.prepareStatement(reasonQuery);
					rs=pstmt.executeQuery();
					while(rs!=null && rs.next()){
						String	code = rs.getString("code");
						String	desc = rs.getString("description");
						System.err.println("code==="+code+"desc=="+desc);
			
		%>
				<option value="<%=code%>"><%=desc%>
		<%	
				}
			}catch(Exception e){
				e.printStackTrace();
				
			}
		%>
		<option value='O'>--- <fmt:message key="Common.other.label" bundle="${common_labels}"/> ---
	</SELECT>
	</td>
	</tr>
	<tr>
	<td class="fields" colspan="2">
	<TEXTAREA NAME="reason_desc" ROWS="5" COLS="50" readonly onBlur = "return makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"></TEXTAREA>
	<img  src="../../eCommon/images/mandatory.gif"  id=''>
	</td>
	</tr>
	<tr><td  class='button' colspan=2><input type=button class=button name='ok' id='ok' Value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="saveManulRemarks('<%=bean_id%>','<%=bean_name%>','<%=patient_id%>','<%=encounter_id%>','<%=menu_id%>','<%=sub_menu_id%>','<%=module_id%>','<%=entry_type%>','<%=order_id%>','<%=order_line_no%>','<%=item_code%>','<%=batch_id%>','<%=patient_class%>','<%=remarks_mandetory_yn%>','<%=speciality%>')">
	</td></tr>
	</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" name="menu_id" id="menu_id" value="<%= menu_id %>">
<input type="hidden" name="sub_menu_id" id="sub_menu_id" value="<%= sub_menu_id %>">
<input type="hidden" name="module_id" id="module_id" value="<%= module_id %>">

</FORM>
</body>
</html>

