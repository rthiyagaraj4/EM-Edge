<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IPFillAll.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<title><fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></title>
<%
	String bean_id					= request.getParameter("bean_id");
	String bean_name				= request.getParameter("bean_name");
	String disp_locn_code			= request.getParameter("disp_locn_code");
	int ord_drug_qty				= Integer.parseInt((String)request.getParameter("ord_drug_qty"));
	String fill_int_end_date_time	= request.getParameter("fill_int_end_date_time");
	String ord_drug_code			= request.getParameter("ord_drug_code");
	String order_id			= request.getParameter("order_id"); 
	String order_line_num			= request.getParameter("order_line_num");
		
	IpFillAllBean bean = (IpFillAllBean)getBeanObject(bean_id, bean_name, request ) ;
	ArrayList alt_drg_dtls			= (ArrayList)bean.getFillListAltDrugs(disp_locn_code,ord_drug_qty,fill_int_end_date_time,ord_drug_code,locale);
    String alt_drug_remarks_ind = bean.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
%>
	<body onKeyDown="lockKey()">
		<FORM name="formPHViewFillList" id="formPHViewFillList"  TARGET="messageFrame" >
			<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
				<br><br>
				<tr>
					<TD class="BODYCOLORFILLED" ALIGN="center" nowrap><font size="2" ><b>	 
					<fmt:message key="ePH.AlternateDrugs.label" bundle="${ph_labels}"/></b>&nbsp;&nbsp;&nbsp;&nbsp;
					<select name="fillListAltDrug" id="fillListAltDrug" >
					<option value="">-------<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>-----</option>
<%
					for(int i=0;i<alt_drg_dtls.size();i=i+2){
%>
						<option value="<%=alt_drg_dtls.get(i)%>"><%=alt_drg_dtls.get(i+1)%></option>
<%
					}	
%>
					</select>		
					</TD>						
				</tr>
				<tr colspan="6" height="16"><TD class="BODYCOLORFILLED" ALIGN="center"  nowrap><font size="1" ></TD></tr>
				<tr colspan="6" height="16"><TD class="BODYCOLORFILLED" ALIGN="center"  nowrap><font size="1" ></TD></tr>
				<tr>
					<TD class="BODYCOLORFILLED" ALIGN="center"  nowrap><font size="1" ><input type="button" name="altDrgOk" id="altDrgOk" class="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="winClose('<%=order_id%>','<%=order_line_num%>','<%=alt_drug_remarks_ind%>');"></TD>
				</tr>
			<table>
		</FORM>
	</BODY>
</HTML>

