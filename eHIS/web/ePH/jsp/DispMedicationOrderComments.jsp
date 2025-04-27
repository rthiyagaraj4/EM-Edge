<!DOCTYPE html>

  <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<HTML>
<%
	String order_id		= request.getParameter("order_id");
	String called_from	= request.getParameter("called_from");	
	String title		=	"";

	if(called_from==null)
		called_from		=	"";

	if(called_from.equals("remarks"))
		title		=	"Drug Remarks";
	else
		title		=	"Clinical Comments";
	%>

<HEAD>
	<%
	  request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<title><%=title%></title>

</HEAD>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" style="overflow-x:hidden;overflow-y:hidden">
<%
	String bean_id = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	//bean.setLanguageId(locale);

	String pres_remarks	=	"";
	if(called_from.equals("remarks")) {	
			String pres_bean_id		= "PrescriptionBean_1" ;
			String pres_bean_name	= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject( pres_bean_id, pres_bean_name , request) ;
				pres_bean.setLanguageId(locale);

		String drug_code			=	request.getParameter("drug_code");
		String line_no				=	pres_bean.getLineNo(order_id,drug_code);

		ArrayList drug_remarks		=	pres_bean.getPrescribedRemarks(order_id,line_no);
		if(drug_remarks.size()!=0) { 
				for(int x=0; x<drug_remarks.size(); x++) {	
					if(x==(drug_remarks.size()-1)) {	
						pres_remarks	+=	(String)drug_remarks.get(x);
					} else {
						pres_remarks	+=	(String)drug_remarks.get(x)+",";
					}
				} 
		   } 
		
	putObjectInBean(pres_bean_id,pres_bean,request);
	}

	String order_comments = bean.getOrderComments(order_id.trim());
	if(order_comments == null){
		order_comments = "" ;
	}

	if(!pres_remarks.equals("")) {
		order_comments	=	pres_remarks;
	}
%>
<form name="frmDispMedicationOrderComments" id="frmDispMedicationOrderComments">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
	<tr>
		<td><textarea cols="53" rows="12" readOnly><%=order_comments%></textarea></td>
	</tr>
	<tr>
		<td >
			<input type="button" name="btnClose" id="btnClose" value="Close" onClick="window.close()" class="button">
		</td>
	</tr>
</table>
	<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
</body>
</html>
<%
//putObjectInBean(bean_id,bean,request);

%>

