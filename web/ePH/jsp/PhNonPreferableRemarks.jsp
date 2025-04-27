<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086

	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called_from	= request.getParameter("called_from")==null?"":request.getParameter("called_from");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/Prescription_1.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/ConsumableOrder.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/DispMedicationAllStages.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<TITLE><fmt:message key="ePH.NotPreferedItemRemarks.label" bundle="${ph_labels}"/></TITLE>
	<script>
	  function checkMandRemarks(){
		var remarks = document.formNonPreferenceRemarks.non_prefered_item_remarks.value;
		if(remarks==""){
			alert(getMessage("REMARKS_CAN_NOT_BE_BLANK","PH"));
			return false;
		}else{
			return true;
		}
	  }
	</script>
</HEAD>

<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">


<%
try{
	
	String patient_id   = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String item_code	=  request.getParameter("item_code");
	String bean_id_1		= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name_1	= "ePH.PrescriptionBean_1";
	
	String bean_id_2		= "ConsumableOrderBean"+patient_id+encounter_id;
	String bean_name_2	= "ePH.ConsumableOrderBean";

	String order_id   = request.getParameter("order_id");
	String order_line_no = request.getParameter("order_line_no");
	

	String bean_id = "";
	String bean_name = "";


	PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject(bean_id_1,bean_name_1,request);
	ConsumableOrderBean bean_1		= (ConsumableOrderBean)getBeanObject(bean_id_2,bean_name_2,request);
	
	if(called_from.equals("D")){
		bean_id = bean_id_1;
		bean_name = bean_name_1;
	}
	else{
		bean_id = bean_id_2;
		bean_name = bean_name_2;
	}

		

	String login_user_id = bean.getLoginById();

	ArrayList arr = bean.getNotPreferenceItemRemarks();
	String item_remarks_option = "";
	if(arr!=null && arr.size()>0){
		for(int i=0;i<arr.size();i=i+2){
			item_remarks_option		= item_remarks_option +	"<option value='"+((String) arr.get(i))+"'>"+((String) arr.get(i+1))+"</option>";
		}

	}

	
	String onClick = "";
	if(called_from.equals("D")){
	onClick ="if(checkMandRemarks()){saveNonPreRemForDrug('"+item_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"')};";
	}else if(called_from.equals("A")){
	onClick ="if(checkMandRemarks()){saveNonPreRemForDispAlternate('"+item_code+"','"+patient_id+"','"+encounter_id+"','"+order_id+"','"+order_line_no+"')};";
	}else{
	onClick ="if(checkMandRemarks()){saveNonPreRemForMedItem('"+item_code+"','"+patient_id+"','"+encounter_id+"','"+bean_id+"','"+bean_name+"')};";
	}
%>
<FORM name="formNonPreferenceRemarks" id="formNonPreferenceRemarks">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="login_user_id" id="login_user_id" VALUE="<%= login_user_id %>">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="104%" ALIGN="center" BORDER="0">
	<TR>
	<TD CLASS="label" WIDTH="40%"> <fmt:message key="Common.username.label" bundle="${common_labels}"/>&nbsp; </TD>
		<TD>
		<input type="text" name="user_name" id="user_name" readonly value ="<%=bean.getUserName(login_user_id)%>" >
		</TD>
	</TR>

  	<TR>
		<TD CLASS="label" WIDTH="40%"><fmt:message key="ePH.NotPreferedItemRemarks.label" bundle="${ph_labels}"/>&nbsp;</TD>
		<TD WIDTH="30%">
		<select name="non_prefered_item_remarks" id="non_prefered_item_remarks">
		<option value="">----------select-----------</option>
			<%=item_remarks_option%>
		</select>
		</TD>
	</TR>
	<TR>
		
	</TR>
	</TABLE>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="104%" ALIGN="center" BORDER="0">
<br><br>
	<TR>
		<TD CLASS="WHITE" WIDTH="5%" align="center"><INPUT TYPE="button" CLASS="button" name="OKBtn" id="OKBtn" VALUE='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="<%=onClick%>">&nbsp;&nbsp;&nbsp; 
		<INPUT TYPE="button" CLASS="button" name="CancelBtn" id="CancelBtn" VALUE='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="window.close()">
		</TD>

	</TR>
	</TABLE>
</FORM>
<%
putObjectInBean(bean_id_1,bean,request);
putObjectInBean(bean_id_2,bean_1,request);
}catch(Exception e){
  e.printStackTrace();
}
%>

