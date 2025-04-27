<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import=" eSS.*,eSS.Common.*,java.util.*,java.util.ArrayList"contentType="text/html;charset=UTF-8"%>    
<jsp:useBean id="dispatchList" scope="session" class="java.util.ArrayList"/>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
	<head>
		<title><fmt:message key="eSS.DispatchGroupDetails.label" bundle="${ss_labels}"/> </title>
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
		<script language="javascript" src="../../eSS/js/Dispatch.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onMouseDown='CodeArrest();'>

<form name='formDispatchListMore' id='formDispatchListMore' >
<div style="max-height: 80vh; overflow-y: auto;">
	<table border='1' cellpadding='0' cellspacing='0' width='100%' style="table-layout: fixed;">
		<tr>
			<th><fmt:message key="eSS.SterReqDocNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.DispatchDate.label" bundle="${ss_labels}"/></th>
			<th><fmt:message key="eSS.Dispatch.label" bundle="${ss_labels}"/><input type="checkbox" value="Y" name="selectAll" id="selectAll"   onClick="return toggleCheck(formDispatchListMore);" ></th>
			
		</tr>
<%
	DispatchBean bean = (DispatchBean)getBeanObject( "DispatchBean",  "eSS.DispatchBean" ,request) ;
	
	String doc_type_code	=	request.getParameter("rof_doc_type_code");
	String doc_no			=	request.getParameter("doc_no");
	String facility_id 		=   (String)session.getAttribute("facility_id");
	String checked_yn	    =	request.getParameter("checked_yn");
	String index	    =	request.getParameter("index");

	
	int i=0;
	
	//Added by Sakti against BRU-HIMS-CRF-371
	ArrayList Arrchkitem			=		new ArrayList();
	ArrayList Arrchkgroup			=		new ArrayList();
	HashMap hmRecord				=	new HashMap();
	Arrchkitem						=		bean.getnewalGroupRecords();
	Arrchkgroup						=		bean.getnewcheckedalGroupRecords();
	String checked					=		"checked";  
	int checked_ind;
	
		
	ArrayList alItems =		bean.loadListPage(doc_type_code,doc_no,facility_id);
	
	String disabled				=	"";
	String className			=	"";
	
	if (alItems != null && (alItems.size()>0)) {
		

	for (i=0;	i<alItems.size();	i++){
		
		hmRecord	=(HashMap)	alItems.get(i);
		checked = "checked";	
			
		//bean.initialize(hmRecord);	//Comented by Sakti against BRU-HIMS-CRF-371
		className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
		String dispatch_date = bean.getalGroupRecords(doc_type_code+"-"+doc_no+"-"+(String)hmRecord.get("TRAY_NO")+"-"+(String)hmRecord.get("GROUP_CODE") ) ;
		if(dispatch_date.equals("")){
			dispatch_date = (String)hmRecord.get("DISPATCH_DATE");
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
 		<td class="<%=className%>" align='center'><input type='text' name="dispatch_date_<%=i%>" id="dispatch_date_<%=i%>" value="<%=bean.checkForNull(dispatch_date,"")%>" maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dispatch_date_<%=i%>');"></img><img src="../../eCommon/images/mandatory.gif" align=center></td>
		<%} else 
		{%>
				<td class="<%=className%>" align='center'><input type='text' name="dispatch_date_<%=i%>" id="dispatch_date_<%=i%>" value="<%=bean.checkForNull(com.ehis.util.DateUtils.convertDate(dispatch_date,"DMY","en",locale),"")%>" maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dispatch_date_<%=i%>');"></img><img src="../../eCommon/images/mandatory.gif" align=center></td>
	<%	}%>
	<td class="<%=className%>" align='center'><input type='checkbox' name="checkbox_tray<%=i%>" id="checkbox_tray<%=i%>" onclick="updateSelectionGroupSearch();removeVals();" value="<%=doc_type_code %>-<%=doc_no %>-<%=(String)hmRecord.get("TRAY_NO") %>" <%= checked%>></td>
	</tr> 
	<input type="hidden" name="do_no_<%=i%>" id="do_no_<%=i%>"			value="<%=doc_no%>" %>	
	<input type="hidden" name="tray_no_<%=i%>" id="tray_no_<%=i%>"			value="<%=(String)hmRecord.get("TRAY_NO")%>" %>
	<input type="hidden" name="dispatch_date<%=i%>" id="dispatch_date<%=i%>"	value="<%=(String)hmRecord.get("DISPATCH_DATE")%>" %>
	<input type="hidden" name="group_code<%=i%>" id="group_code<%=i%>"	value="<%=(String)hmRecord.get("GROUP_CODE")%>" %>
	<input type="hidden" name="autoclave_date<%=i%>" id="autoclave_date<%=i%>"	value="<%=(String)hmRecord.get("AUTOCLAVE_DATE")%>" %>
<%
}
	}
%>

	
	</table>
	</div>
	<input type="hidden" name="total_checkboxes" id="total_checkboxes" value="<%=i%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
	<input type='hidden' name="sysdate" id="sysdate"				value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
	<input type="hidden" name="locale" id="locale" value="<%=locale%>">
	<input type="hidden" name="bean_id" id="bean_id" value="DispatchBean">
	<input type="hidden" name="bean_name" id="bean_name" value="eSS.DispatchBean">
	<input type="hidden" name="doc_type_code" id="doc_type_code" value="<%=doc_type_code%>">
	<input type="hidden" name="doc_no" id="doc_no" value="<%=doc_no%>">
	<input type="hidden" name="index" id="index" value="<%=index%>">

	
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
		
		<td valign=bottom>
		<input type="button" align = right value="Close" name=" ok " id=" ok " class="BUTTON" onClick="saveVals();">
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
		
			var frmObject		= document.formDispatchListMore;
			var total_check_boxes = frmObject.total_checkboxes.value;
			var exist=true;
				for (var count = 0;count<total_check_boxes;count++) {

						if(!(eval("frmObject.checkbox_tray"+count+".checked"))) {
							exist=false;
						}
				}
					if(exist){
					document.formDispatchListMore.selectAll.checked=true;
					}else{
					document.formDispatchListMore.selectAll.checked=false;
					}
		
		</script>
<%
	putObjectInBean("DispatchBean",  bean,request);
%>


 

