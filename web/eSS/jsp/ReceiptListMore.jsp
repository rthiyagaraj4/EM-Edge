<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*,java.util.ArrayList"contentType="text/html;charset=UTF-8"%>    

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
		<title><fmt:message key="eSS.AcknowledgeGroupDetails.label" bundle="${ss_labels}"/></title>
		<meta name="Generator" content="EditPlus @ MEDICOM Solutions (P) Ltd. Bangalore. INDIA.">
		<meta name="Author" content="Sudha Krishnadasar">
<%
			request.setCharacterEncoding("UTF-8");
			String locale			=	(String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/Receipt.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body onMouseDown='CodeArrest();'>
<form name='formReceiptListMore' id='formReceiptListMore' >
<div style="max-height:80vh; overflow-y:auto;">
	<table border='1' cellpadding='0' cellspacing='0' height='100%' width='100%'style="table-layout: fixed;">
		<tr>
			<th><fmt:message key="eSS.SterReqDocNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.ReceivedDate.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.Acknowledge.label" bundle="${ss_labels}"/><input type="checkbox" value="Y" name="selectAll" id="selectAll"   onClick="return toggleCheck(formReceiptListMore);" ></th>
			
		</tr>
<%
		ReceiptBean bean = (ReceiptBean)getBeanObject( "receiptBean",  "eSS.ReceiptBean" ,request) ;
	

	String doc_type_code	=	request.getParameter("rof_doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	String index	    	=	request.getParameter("index");
	String facility_id 		=   (String)session.getAttribute("facility_id");
	String checked_yn	    =	request.getParameter("checked_yn");
	
	
	ArrayList result				=		new ArrayList();
	ArrayList Arrchkitem			=		new ArrayList();
	ArrayList Arrchkgroup			=		new ArrayList();
	Arrchkitem						=		bean.getnewalGroupRecords();
	Arrchkgroup						=		bean.getnewcheckedalGroupRecords();
	String checked					=		"checked";  
	String receipt_date 			= 		"";
	String disabled					=		"";
	HashMap hmRecord				=		new HashMap();
	String className				=		"";
	
	result=bean.loadListPage(doc_type_code,doc_no,facility_id);

	

	int i=0;
	for	(i	=0;	i<result.size();i++){
		hmRecord	=(HashMap)	result.get(i);
		
		checked = "checked";
		className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
		
		receipt_date = bean.getalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hmRecord.get("TRAY_NO")+"-"+(String)hmRecord.get("GROUP_CODE") ) ;
		
		if(receipt_date.equals("")){
			receipt_date = (String)hmRecord.get("RECEIPTDATE");
		}
		
		//Check uncheck logic starts
				if(Arrchkitem.size()>0) {
					if(Arrchkgroup.contains(doc_type_code+"-"+doc_no)) {
					
							if(! Arrchkitem.contains(doc_type_code+"-"+doc_no+"-"+(String)hmRecord.get("TRAY_NO")+"-"+(String)hmRecord.get("GROUP_CODE") ) ) {
								checked = "";

							}
								}else  if(! checked_yn.equals("true")){
									checked = "";
							}
				}else if(! checked_yn.equals("true")){
					checked = "";
				}	//Added ends	
				
		
%>
	<tr>
		<td class="<%=className%>" ><%=doc_no%></td>
		<td class="<%=className%>" ><%=(String)hmRecord.get("DESCRIPTION")%></td>
		
		<td class="<%=className%>"><%=(String)hmRecord.get("TRAY_NO")%></td>
		<%if(locale.equals("en"))
		{%>
 		<td class="<%=className%>" align='center'><input type='text' name="receipt_date<%=i%>" id="receipt_date<%=i%>" value="<%=receipt_date%>" maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('receipt_date<%=i%>');"></img><img src="../../eCommon/images/mandatory.gif" align=center></td>
		<%} else 
		{%>
				<td class="<%=className%>" align='center'><input type='text' name="receipt_date<%=i%>" id="receipt_date<%=i%>" value="<%=bean.checkForNull(com.ehis.util.DateUtils.convertDate(receipt_date,"DMY","en",locale),"")%>" maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('receipt_date<%=i%>');"></img><img src="../../eCommon/images/mandatory.gif" align=center></td>
	<%	}%>
	<td class="<%=className%>" align='center'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox' name="checkbox_tray<%=i%>" id="checkbox_tray<%=i%>" value="<%=doc_type_code %>-<%=doc_no %>-<%=(String)hmRecord.get("TRAY_NO") %>" onclick="updateSelectionListMore();removeVals();" <%=checked %>></td>
	</tr> 
	<input type="hidden" name="do_no_<%=i%>" id="do_no_<%=i%>"			value="<%=doc_no%>" %>	
	<input type="hidden" name="tray_no_<%=i%>" id="tray_no_<%=i%>"			value="<%=(String)hmRecord.get("TRAY_NO")%>" %>
	<input type="hidden" name="receipt_date_<%=i%>" id="receipt_date_<%=i%>"	value="<%=(String)hmRecord.get("RECEIPTDATE")%>" %>
	<input type="hidden" name="group_code<%=i%>" id="group_code<%=i%>"	value="<%=(String)hmRecord.get("GROUP_CODE")%>" %>
	<input type="hidden" name="dispatch_date<%=i%>" id="dispatch_date<%=i%>"	value="<%=(String)hmRecord.get("DISPATCH_DATE")%>" %>
	
<%
}
	
%>
	
	
	</table>
</div>	
	<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
	
	<input type='hidden' name="sysdate" id="sysdate"			value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
	<input type="hidden" name="records_to_modify" id="records_to_modify" >
	<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
	<input type="hidden" name="facility_id" id="facility_id" value="<%=session.getAttribute("facility_id")%>">
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	<input type="hidden" name="index" id="index" value="<%=index%>">
	<input type="hidden" name="bean_id" id="bean_id" value="ReceiptBean">
	<input type="hidden" name="bean_name" id="bean_name" value="eSS.ReceiptBean">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	
	
	<table align = right cellpadding=0 cellspacing=0  width="100%" align="center">
		<tr>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
		
		<td valign=bottom>
		<input type="button" align = right value=" OK " name=" ok " id=" ok " class="BUTTON" onClick="saveVals();">
		<input type="button" align = right value="Cancel" name="cancel" id="cancel" class="BUTTON" onClick="parent.document.getElementById('dialog_tag').close();">
		</td>
		
		</tr>
		</table>
		</td>
		</tr>
		</BR>
		</table>

</form>
</body>

</html>
<script>
		
			var frmObject		= document.formReceiptListMore;
			var total_check_boxes = frmObject.total_checkboxes.value;
			
			var exist=true;
				for (var count = 0;count<total_check_boxes;count++) {

						if(!(eval("frmObject.checkbox_tray"+count+".checked"))) {
							exist=false;
						}
				}
					if(exist){
					document.formReceiptListMore.selectAll.checked=true;
					}else{
					document.formReceiptListMore.selectAll.checked=false;
					}
		
		</script>
<%
	putObjectInBean("receiptBean",  bean,request);
%>



