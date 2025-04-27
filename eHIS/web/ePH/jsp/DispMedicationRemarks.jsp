<!DOCTYPE html>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8"); 
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale = (String) session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String title = request.getParameter("title")==null?"":request.getParameter("title");
		String called_from = request.getParameter("called_from")==null?"":request.getParameter("called_from");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<%
		if(called_from.equals("IPFILL")){
%>
			<script language="JavaScript" src="../js/IPFillAll.js"></script>	
<%
		}
		else if(called_from.equals("VIEW")){
%>
			<script language="JavaScript" src="../js/QueryPatientDrugProfile.js"></script>	
<%
		}
		else{
%>
			<script language="JavaScript" src="../js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<%
		}
%>
	</head>
	<title><fmt:message key="ePH.AltDrugRemarks.label" bundle="${ph_labels}"/></title>
<%
	String order_id=request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String order_line_num=request.getParameter("order_line_num")==null?"":request.getParameter("order_line_num");
	String alt_drug_remarks_ind = request.getParameter("alt_drug_remarks_ind")==null?"":request.getParameter("alt_drug_remarks_ind");
	String alt_drug_remarks = "", readonly="", callMethod="", alt_drug_remarks_yn="N";
	String id = request.getParameter("id")==null?"":request.getParameter("id");
	String callFrom = request.getParameter("callFrom")==null?"":request.getParameter("callFrom");
	String bean_id						= "DispMedicationAllStages" ;
	String bean_name					= "ePH.DispMedicationAllStages";
	if(id.equals("Q")){
		String stkey=request.getParameter("stkey")==null?"":request.getParameter("stkey");
		bean_id			=	"QueryPatientDrugProfileBean" ;
		bean_name		=	"ePH.QueryPatientDrugProfileBean";
		QueryPatientDrugProfileBean bean = (QueryPatientDrugProfileBean)getBeanObject( bean_id,bean_name, request) ;
		alt_drug_remarks = bean.getAltDrugRemarks(stkey);
	}
	else{
		if(called_from.equals("IPFILL")){
			bean_id						= "IpFillAllBean" ;
			bean_name					= "ePH.IpFillAllBean";
			IpFillAllBean bean = (IpFillAllBean)getBeanObject(bean_id, bean_name, request ) ;
			alt_drug_remarks = bean.getAltDrugRemarks(order_id+"~"+order_line_num);
		}
		else{
			DispMedicationAllStages bean		= (DispMedicationAllStages)getBeanObject( bean_id, bean_name,request ) ;
			alt_drug_remarks = bean.getAltDrugRemarks(order_id+"~"+order_line_num);
		}
		if(alt_drug_remarks!=null && !alt_drug_remarks.equals(""))
			alt_drug_remarks_yn="Y";
	}
	if(called_from.equals("VIEW")){
		readonly = "readonly";
		callMethod="parent.window.returnValue='Y';parent.window.close();";
		alt_drug_remarks_yn = "Y";
	}
	else{
		readonly = "";
		callMethod = "saveRemarks('"+callFrom+"');";
	}
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name="DispMedicationRemarks" id="DispMedicationRemarks">
			<table  border='0' align="center" width='100%' cellpadding='0' cellspacing='0'>
				<tr><td>&nbsp;</td></tr>
				<tr> 
					 <td  class="label"><textarea cols="78" rows="10" name="alt_drug_remarks" <%=readonly%> onkeypress="return checkRemarksMaxLimit(this, 2000)"  onchange=" checkRemarksMaxLimit(this,'2000')"  ><%=alt_drug_remarks%></textarea>
<%
					if(alt_drug_remarks_ind.equals("M")){
%>
						<img  id='altDrugRmkMand' src='../../eCommon/images/mandatory.gif'></img>
<%
					 }
%>
					 </td>	 
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr>
					<td class='button'>
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="<%=callMethod%>">&nbsp;&nbsp;&nbsp;
<%
					if(!called_from.equals("VIEW") && !alt_drug_remarks_ind.equals("M")){
%>
						<input type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="BUTTON" onClick="parent.window.returnValue='N';parent.window.close();">&nbsp;&nbsp;&nbsp;</td>
<%
					 }
%>
				</tr>
			</table>
			<input type="hidden" value="<%=bean_id%>" name="bean_id">
			<input type="hidden" value="<%=bean_name%>" name="bean_name">
			<input type="hidden" value="<%=order_id%>" name="order_id">
			<input type="hidden" value="<%=order_line_num%>" name="order_line_num">
			<input type="hidden" value="<%=alt_drug_remarks_ind%>" name="alt_drug_remarks_ind">
			<input type="hidden" value="<%=alt_drug_remarks_yn%>" name="alt_drug_remarks_yn">
<%
			if(!called_from.equals("VIEW")){
%>
			<script>
				parent.window.returnValue='<%=alt_drug_remarks_yn%>';
			</script>
<%
			}
%>
		</form>
	</body>
</html>

