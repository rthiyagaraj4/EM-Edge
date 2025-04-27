<!DOCTYPE html>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
08/04/2024     IN072994          Himanshu Saxena                 GHL-CRF-0672.1
--------------------------------------------------------------------------------------------------------------------------------
--> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*, eOR.*,ePH.*" contentType="text/html;charset=UTF-8" %>
   

	<html>
<%
System.out.println("========================");
request.setCharacterEncoding("UTF-8");
%>
<head>

	<title>Manual Barcode Entry Reason</title> 
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale					= (String)session.getAttribute("LOCALE");
	System.out.println("========================");
	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
	String bean_id		    = request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
	String bean_name		= request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	System.out.println("========================"+patient_id);
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	System.out.println("========================"+encounter_id);
	String menu_id          = request.getParameter("menu_id")==null?"":request.getParameter("menu_id");
	String sub_menu_id      = request.getParameter("sub_menu_id")==null?"":request.getParameter("sub_menu_id");
	String module_id        = request.getParameter("module_id")==null?"":request.getParameter("module_id");
	String entry_type       = request.getParameter("entry_type")==null?"":request.getParameter("entry_type");
	String order_id         = request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_no    = request.getParameter("order_line_no")==null?"":request.getParameter("order_line_no");
	System.out.println("========================"+order_id);
	System.out.println("========================"+order_line_no);
	String batch_id         = request.getParameter("batch_id")==null?"":request.getParameter("batch_id");
	String item_code        = request.getParameter("item_code")==null?"":request.getParameter("item_code");
	String remarks_mandetory_yn        = request.getParameter("remarks_mandetory_yn")==null?"":request.getParameter("remarks_mandetory_yn");
	String patient_class        = request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
	String speciality        = request.getParameter("speciality")==null?"":request.getParameter("speciality");
	String OPERATING_FACILITY_ID        = request.getParameter("OPERATING_FACILITY_ID")==null?"":request.getParameter("OPERATING_FACILITY_ID");

	String	code ="";
	String	desc ="";
	String	added_by_id ="";
	String	Added_date ="";
	
%> 
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="javascript" src="../../eOR/js/BarCodeManualEntryReason.js"></script>
<script>
		</script>

</head>
<body   onload='FocusFirstElement()'  OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=manualBarCodeReason id=manualBarCodeReason>
<table cellpadding=3 cellspacing=0 border=0 width='100%' height="100%" align=center>
		<%
			try{
				con = ConnectionManager.getConnection(request);
				   String reasonQuery="select reason_code,reason_remarks,added_by_id,Added_date,TO_CHAR(Added_date, 'DD-MM-YYYY HH24:MI') as addate from PR_BARCODE_SCAN_DETAILS  where  encounter_id=? and order_id=? and order_line_no=? and module_id='PH' and Function_id='MAR' order by added_date desc" ;//and OPERATING_FACILITY_ID=? 
				   pstmt = con.prepareStatement(reasonQuery);
				   pstmt.setString(1, encounter_id);
				   pstmt.setString(2, order_id);
				   pstmt.setString(3, order_line_no);
				   //pstmt.setString(4, "GH");
				    rs = pstmt.executeQuery();
				   while (rs.next()) {
				       code = rs.getString("reason_code");
				       desc = rs.getString("reason_remarks");
				       added_by_id = rs.getString("added_by_id");
				       Added_date = rs.getString("addate");
				   }
			}catch(Exception e){
				e.printStackTrace();
				
			}
		%>
	</td>

	<tr>
	<td class="fields" colspan="2">
	<TEXTAREA NAME="reason_desc" ROWS="7" COLS="80" readonly onBlur = "return makeValidString(this)"  onKeyPress="return CheckMaxLength(this,255)"><%=desc %></TEXTAREA>
	</td>
	</tr>
	<tr><td class="fields" colspan="2"><fmt:message key="ePH.Date_time.label" bundle="${ph_labels}"/><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=Added_date %></b></td></tr>
	<tr><td class="fields" colspan="2"><fmt:message key="ePH.User.label" bundle="${ph_labels}"/><b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=added_by_id %></b></td></tr>
	<td  class='button' colspan=2><input type=button class=button name='ok' id='ok' Value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="window.close();">
	</td>
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

