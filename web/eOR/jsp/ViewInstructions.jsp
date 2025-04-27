<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
-----------------------------------------------------------------------
Date			Edit History	Name        Description
-----------------------------------------------------------------------
?				100         	?     		created	 
15/11/2012		IN030472		Ramesh G	Bru-HIMS-CRF-031[Patient instructions to be printed on demand] 
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L			24/08/2014		Ramesh			An Audit Trail for Additional Information Amendment of Order
12/9/2014		IN051103		Karthi L			12/9/2014		Akbar		Amended by Details displayed as Null
15/09/2014		IN051122		Karthi L			15/09/2014		Ramesh			Audit History is not displayed at Task list after Register Order
16/09/2014		IN051127		Karthi L			16/09/2014		Ramesh			View Audit trail->All the text of entered reason is displayed in same line
18/09/2014		IN051106		Karthi L			18/09/2014		Ramesh			Selected Amend reason is not displaying for recent Amend Audit.
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
20/11/2018		ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, java.sql.*, eOR.* ,eOR.Common.*,eCommon.Common.*,webbeans.eCommon.*" %> <!-- IN049419 -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
			<style>
textarea {
  resize: none;
}
</style>
	<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
	<title><fmt:message key="Common.Instructions.label" bundle="${common_labels}"/></title>
</head>

<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	//out.println(catalog_code+"<br>");
	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	//String sex =  request.getParameter("sex");
	bean.setLanguageId(localeName);
	String instruction = "";
	String orderId   = request.getParameter("orderId");
 	String order_line_num   = request.getParameter("order_line_num");
 	
	// IN049419 - Start
	String deptData  = "";
 	String bean_id1 = "Or_ViewOrder";
 	String bean_name1 = "eOR.ViewOrder";
 	ViewOrder bean1 = (ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
 	bean1.setLanguageId(localeName);
 	String audit_reqd_yn = bean.getOrderFormatAuditTrailYN();
 	String max_seq = request.getParameter("max_seq")==null?"":request.getParameter("max_seq") ;	
 	String field_mnemonic = request.getParameter("field_mnemonic")==null?"":request.getParameter("field_mnemonic");
 	String curr_sequ_num = request.getParameter("curr_sequ_num")==null?"":request.getParameter("curr_sequ_num");
 	String instrn_type = request.getParameter("instrn_type")==null?"":request.getParameter("instrn_type");//IN64543
 	String base_max_sequ_num = "0";
 	String modified_max_sequ = "";
 	int modified_max_sequ_num = 0;
 	//int curr_mod_sequ_num = 0;//commented for checkstyle
 	String max_num = "0";
 	String max_action_seq_num = "";
 	PreparedStatement prepStat = null;
 	ResultSet resultSet = null;
 	Connection con = null;
 	String sql = "";
 	String amend_date = "";
 	String amend_by = "";
 	String amend_rson = "";
 	if(max_seq==null) max_seq="";
 		max_action_seq_num = max_seq;
 	HashMap orderLineMap = null;
 	String	audit_comments_reqd = request.getParameter("audit_comments_reqd")==null?"":request.getParameter("audit_comments_reqd"); // added for IN051122
 	int amendRsonLength = 0; //IN051127
	// IN049419 End.
 	
	//String no_of_days = (String)bean.getPatientNoOfDays( patient_id, orderId) ;
	//if(no_of_days == null) no_of_days = ""; else	no_of_days = no_of_days.trim();

	//out.println(catalog_code +"-");
	//out.println(no_of_days +"-");
	//out.println(sex);

	//instruction = bean.getPatientInstruction(catalog_code.trim(),no_of_days,sex) ;
	// commented for IN049419 - Start
	/*instruction = bean.getPatientInstruction(orderId,order_line_num) ;
	if(instruction == null)	instruction = "";

	String deptData  = "";
	deptData = bean.getDeptdata(orderId,order_line_num) ; */
	// Commented End
	// IN049419 Start
	try{
		if(audit_reqd_yn.equalsIgnoreCase("Y")) {
			base_max_sequ_num = bean1.getOrderLineInstMaxCount(orderId, order_line_num, field_mnemonic);
			
			modified_max_sequ_num = Integer.parseInt(base_max_sequ_num);
			modified_max_sequ_num = modified_max_sequ_num + 1;
			modified_max_sequ = Integer.toString(modified_max_sequ_num);
			if(curr_sequ_num == null || curr_sequ_num.equals("")){
				if(max_action_seq_num.equals(""))
					max_action_seq_num	=  base_max_sequ_num;
				if(max_action_seq_num == null)
					max_action_seq_num = "";
				else 
					max_action_seq_num = max_action_seq_num.trim();
				
				max_num = max_action_seq_num;
	
			}else{
				max_num = curr_sequ_num;
			}
			if(curr_sequ_num.equals("") || modified_max_sequ.equals(curr_sequ_num) ) {
				instruction = bean.getPatientInstruction(orderId,order_line_num) ;
				deptData 	= bean.getDeptdata(orderId,order_line_num) ; 
				//orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, "Instruction", localeName); - IN051106
				//IN051106 - Start
				if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
	 				orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, max_num, field_mnemonic, localeName);
				}
				else {
					orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, curr_sequ_num, field_mnemonic, localeName);
				}
				//IN051106 - End
				if(orderLineMap != null){
					amend_by = (String)orderLineMap.get("ADDED_NAME")==null?"":(String)orderLineMap.get("ADDED_NAME");
					amend_date = (String)orderLineMap.get("ADDED_DATE")==null?"":(String)orderLineMap.get("ADDED_DATE");
					amend_date = com.ehis.util.DateUtils.convertDate(amend_date,"DMYHM","en",localeName);
					amend_rson = (String)orderLineMap.get("AMEND_REASON")==null?"":(String)orderLineMap.get("AMEND_REASON"); //IN051106
				}
			}
			else {
			
				if(max_num != null && max_num != "") { 
					
					con = ConnectionManager.getConnection(); 
					//sql = "SELECT (SELECT practitioner_name FROM am_practitioner_lang WHERE practitioner_id = a.added_by_id AND language_id = ?)ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.ORDER_LINE_FIELD_MNEMONIC in( 'DEPT_INSTRNS',   'PATIENT_INSTRNS')   AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; - Commented for IN051103
					//sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=A.ADDED_BY_ID), ?, '1') ADDED_NAME, to_char(a.ADDED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.ORDER_LINE_FIELD_MNEMONIC in( 'DEPT_INSTRNS',   'PATIENT_INSTRNS')   AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; // Modified for IN051103 - Commented for IN051105
					sql = "SELECT AM_GET_DESC.AM_PRACTITIONER((SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID=b.MODIFIED_BY_ID), ?, '1') ADDED_NAME, to_char(b.MODIFIED_DATE,'dd/mm/yyyy hh24:mi') ADDED_DATE, a.order_amend_reason, b.order_line_field_value FROM  or_order_amend_reason a, or_order_line_fld_val_action b WHERE b.order_id = ? AND b.action_seq_num = ? AND b.order_line_num = ?  AND b.ORDER_LINE_FIELD_MNEMONIC in( 'DEPT_INSTRNS',   'PATIENT_INSTRNS')   AND a.order_id = b.order_id AND a.action_seq_num = b.action_seq_num"; // Modified for IN051105
					prepStat = con.prepareStatement(sql);
					prepStat.setString(1, localeName);
					prepStat.setString(2, orderId);
					prepStat.setInt(3, Integer.parseInt(max_num));
					prepStat.setInt(4, Integer.parseInt(order_line_num));
					resultSet = prepStat.executeQuery();
					while(resultSet.next()){
						//amend_rson = resultSet.getString("ORDER_AMEND_REASON"); - IN051106
						amend_by = resultSet.getString("ADDED_NAME")==null?"":resultSet.getString("ADDED_NAME");
						amend_date = resultSet.getString("ADDED_DATE")==null?"":resultSet.getString("ADDED_DATE");
						amend_date = com.ehis.util.DateUtils.convertDate(amend_date,"DMYHM","en",localeName);
					}
					
					orderLineMap 	= bean1.getOrderLineInstructions(orderId, order_line_num, max_num, "PATIENT_INSTRNS", localeName);
					if(orderLineMap != null){
						instruction 	= (String)orderLineMap.get("ORDER_LINE_FIELD_VALUE");
					}	
					orderLineMap 	= bean1.getOrderLineInstructions(orderId, order_line_num, max_num, "DEPT_INSTRNS", localeName);
					if(orderLineMap != null) {
						deptData 		= (String)orderLineMap.get("ORDER_LINE_FIELD_VALUE");
						amend_rson = (String)orderLineMap.get("AMEND_REASON")==null?"":(String)orderLineMap.get("AMEND_REASON"); //IN051106
					}	
				}
			}
			// IN051127 - Start	
			if(!amend_rson.equals("") && !amend_rson.equals(null)){
				amendRsonLength = amend_rson.length();
			}
			// IN051127 - End
		}
		else {
			instruction = bean.getPatientInstruction(orderId,order_line_num) ;
			deptData 	= bean.getDeptdata(orderId,order_line_num) ; 
	
		}
	}
	catch(Exception ex){
		System.err.println(" 165. ViewInstructions.jsp " + ex.getMessage());
		ex.printStackTrace();
	}
	finally {
		if(resultSet != null) resultSet.close();
		if(prepStat != null) prepStat.close();
		if(con != null) con.close();
	}
	if(instruction == null || instruction.equals("null"))
		instruction = "";
	if(deptData == null || deptData.equals("null"))
		deptData = "";
	// IN049419 - End

%>
<FORM METHOD=POST ACTION="">
<!--<table cellpadding=3 cellspacing=0 border=0 align=center width="100%" height="100%">--><!--IN64543-->
<table cellpadding=3 cellspacing=0 border=0 align=center width="100%"><!--IN64543-->
<%
if("T".equals(instrn_type))//IN64543
{
%>
<tr>
	<td class=label><fmt:message key="Common.patient.label" bundle="${common_labels}"/></td>
	<td class=fields><TEXTAREA NAME="" ROWS="6" COLS="25" readonly><%=instruction%></TEXTAREA></td>
	<td class=label><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/></td>
	<td class=fields><TEXTAREA NAME="" ROWS="6" COLS="27" readonly><%=deptData%></TEXTAREA></td>
</tr>
<%
}
%>
</table>
<%
//IN64543, starts
if("E".equals(instrn_type))
{
%>
 <div class="outer-container" style='width:630px;height:435px'>
    <div class="top-section" style='width:630px;height:200px;overflow:auto'>
      <table cellpadding='3' cellspacing='0' border='0' align='center' width="100%">
     	<tr>
	      <td  class='normal'>
	      <fmt:message key="Common.patient.label" bundle="${common_labels}"/>
	      </td>
      	</tr>
      	<tr>
	      <td>
	      <%=instruction%>
	      </td>
      	</tr>     
       </table> 
    </div>
    <table>
    <tr><td>&nbsp;</td></tr>
    <tr>
    	<td class="button" colspan=2 align='right'><INPUT TYPE="button"  class="button" align='right' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>" onClick='instructionsPrintPreview();'>
    </td>
    </tr>
    <tr><td>&nbsp;</td></tr>   
    </table>
    <div class="top-section" style='width:630px;height:200px;overflow:auto'>
    <table cellpadding=3 cellspacing=0 border=0 align=center width="100%">
    <tr>
	 	<td  class=normal>
	     	<fmt:message key="Common.Departmental.label" bundle="${common_labels}"/>
	 	</td>
     </tr>
     <tr>
		<td> 
		    <%=deptData%>  
		</td>
      </tr>
      </table>
    </div>
  </div>
<%
}
//IN64543,ends
%>
<table cellpadding=3 cellspacing=0 border=0 align=center width="100%"><!--IN64543-->
<!-- IN049419 - Start -->
<% if(audit_reqd_yn.equalsIgnoreCase("Y")) { 
	if(audit_comments_reqd.equalsIgnoreCase("Y")) { // IN051122
	//ML-MMOH-SCF-1108 start
		String seqStr = "".equals(max_seq)?curr_sequ_num:max_seq;
		int max_seq_int = Integer.parseInt(seqStr);
%>
		<tr>
			<td  class='LABEL'>
				 <%if(max_seq_int>1){ %><fmt:message key="eOR.amenddate.label" bundle="${or_labels}"/><%}else{%><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/><%}%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=amend_date %>
			</td>
		</tr>
		<tr>
			<td class='LABEL'> 
				 <%if(max_seq_int>1){ %><fmt:message key="eOR.amendby.label" bundle="${or_labels}"/><%}else{%><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/><%}%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=amend_by%>
			</td>
		</tr>
		<tr>
			<td class='LABEL'>  
				  <%if(max_seq_int>1){ %><fmt:message key="eOR.amendreason.label" bundle="${or_labels}"/><%}else{%> <fmt:message key="Common.Order.label" bundle="${common_labels}"/>  <fmt:message key="Common.reason.label" bundle="${common_labels}"/><%}%> &nbsp;:
		<%
		//ML-MMOH-SCF-1108 end
		// IN051127 - Start
		if(amendRsonLength > 30) { 
			//IN051106 - Start
			if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
				
				max_num = max_num;
			}
			else {
				max_num = curr_sequ_num;
			}
			modified_max_sequ_num = Integer.parseInt(max_num);
			modified_max_sequ_num = modified_max_sequ_num - 1;
			max_num = Integer.toString(modified_max_sequ_num);
			
			//IN051106 - End
		%>
			<a class="gridLink" href="javascript:ShowComments('<%=orderId%>','<%=max_num%>')"><%=amend_rson.substring(0,29)%>...</a>
		<% }else {%> <%=amend_rson %> <% } // IN051127 - End%>	
		</td></tr>
<% } } //IN051122 %>
<!-- IN049419 - End -->
<!--IN030472 Start.-->
<!--
<tr><td class="button" colspan=5><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td></tr>
-->
</table><!--IN64543-->
<table cellpadding='3' cellspacing='0' border='0' align='center' width="100%"><!--IN64543-->
<tr>
<%
if(!"E".equals(instrn_type))//IN64543
{
%>
<td colspan='2' align='center'><INPUT TYPE="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PrintPreview.label","common_labels")%>" onClick='instructionsPrintPreview();'></td>
<%
}
%>
<td colspan='2' align='right'><INPUT TYPE="button" class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='toCloseTopShowModal();'></td>
</tr>
</table>
<input type="hidden" name="queryString" id="queryString" value="<%=request.getQueryString()%>">
<!--IN030472 End.-->
<input type="hidden" name="instrn_type" id="instrn_type" value = "<%=instrn_type%>"/>
</FORM>
</BODY>
</HTML>
<%	
		putObjectInBean(bean_id,bean,request);
%>	

