<!DOCTYPE html>
<%@page import="eBL.BLReportIdMapper"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="eBL.PolicyInsuranceMasterBean"%>
<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	String title = request.getParameter("title");
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id = (String)session.getAttribute("facility_id");
	String rowNumber = request.getParameter("rowNumber");
	String criteria = request.getParameter("criteria");
	String inclExclDesc = "";
	String inclExclCode = "";
	String diagTypeDesc = "";
	String diagTypeCode = "";
	LinkedHashMap<String,String> criteriaMap = new LinkedHashMap<String,String>();
	LinkedHashMap<String,String> diagTypeMap = new LinkedHashMap<String,String>();
	String siteId = "";
%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><%=title %></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/PolicyAddTable.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<script language='javascript'>
function checkDateFrom(obj){
	
	var stdt = document.forms[0].startDate.value;
	var endt = document.forms[0].endDate.value;
	var startdtarr =stdt.split("/");
	var enddtarr = endt.split("/");
	var objarr = obj.value.split("/");
	var startdt = new Date();
	var enddt = new Date();
	var objdt = new Date();
	startdt.setFullYear(startdtarr[2], startdtarr[1]-1, startdtarr[0]);
	enddt.setFullYear(enddtarr[2], enddtarr[1]-1, enddtarr[0]);
	objdt.setFullYear(objarr[2], objarr[1]-1, objarr[0]);
	if((objdt < startdt) || (objdt > enddt) ){
		alert("Please enter date in range "+stdt+" and "+endt);
		obj.value = '';
	}
}
function close(){
	var frmObj = document.forms[0];
	xmlString=formXMLStringMain(frmObj);
	//alert(xmlString);
	updation=formValidation(xmlString,"popup");
	window.close();	
}
	
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('popDiag_effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('popDiag_effTo_'+obj)
	}
	
}
function showCalendarLocal(fromTo,obj){
	if(fromTo == 1){
		return showCalendar('popDiag_effFrom_'+obj)
	}
	else if(fromTo == 2){
		return showCalendar('popDiag_effTo_'+obj)
	}
	
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onKeyDown= "lockKey();" onMouseDown="CodeArrest();" >
<br/>
<br/>
<%
String beanId = "bl_PolicyInsuranceMasterBean";
String beanName = "eBL.PolicyInsuranceMasterBean";
String readonly = "";
PolicyInsuranceMasterBean policyBean = null;
String prevTab = rowNumber;
String mode = checkForNull(request.getParameter("mode"));
HashMap<String,List<PolicyInsuranceMasterBean>> policyMap = null;
List<PolicyInsuranceMasterBean> policyList = null; 
String checked = "";
String disabled = "";
String exclDisabled = "";
//String facility_id = (String)session.getAttribute("facility_id");
String payerGroup = checkForNull(request.getParameter("payerGroup"));
String payer = checkForNull(request.getParameter("payer"));
String policy = checkForNull(request.getParameter("policy"));
String patClass = checkForNull(request.getParameter("patClass"));
String blngCode = checkForNull(request.getParameter("blngCode"));
String startDate = checkForNull(request.getParameter("startDate"));
String endDate = checkForNull(request.getParameter("endDate"));
System.err.println("startDate inside Diag Popup:"+startDate);
System.err.println("endDate inside Diag Popup:"+endDate);
String encEpsd = checkForNull(request.getParameter("encEpsd"));
String gender = checkForNull(request.getParameter("gender"));
String ageGroup = checkForNull(request.getParameter("ageGroup"));
String clinicNursInd = checkForNull(request.getParameter("clinicNursInd"));
String clinicNursCode = checkForNull(request.getParameter("clinicNursCode"));
String spltyCode = checkForNull(request.getParameter("spltyCode"));
Connection con = null;
ResultSet rst = null;
PreparedStatement pstmt = null;
//Delete Definitions
PolicyInsuranceMasterBean deletedPolicyBean = null;
HashMap<String,List<PolicyInsuranceMasterBean>> deletedPolicyMap = null;
List<PolicyInsuranceMasterBean> deletedPolicyList = null; 
//Delete Definitions
try{
	con = ConnectionManager.getConnection(request);
	siteId = BLReportIdMapper.getCustomerId();
	policyBean = (PolicyInsuranceMasterBean) getBeanObject(beanId, beanName, request);
	policyMap = policyBean.getDiagPopupMap();
	if(!(policyMap == null || policyMap.isEmpty())){
		policyList = policyMap.get(rowNumber);
	}
	System.err.println("policyMap inside Diag Popup:"+policyMap);
	System.err.println("policyList inside Diag Popup:"+policyList);
	//Delete Definitions
		deletedPolicyBean = (PolicyInsuranceMasterBean) getBeanObject("DeletedPolicyBean", beanName, request);
		deletedPolicyMap = deletedPolicyBean.getPopupMap();
		if(!(deletedPolicyMap == null || deletedPolicyMap.isEmpty())){
			deletedPolicyList = deletedPolicyMap.get(rowNumber);
		}
	System.err.println("deletedPolicyList inside Diag Popup:"+deletedPolicyList);
	System.err.println("Mode inside Diag Popup:"+mode);
	if ("modify".equals(mode) ) {
		HashMap<String,List<PolicyInsuranceMasterBean>> fmtDetailsMap = new HashMap<String,List<PolicyInsuranceMasterBean>>();
		PolicyInsuranceMasterBean fmtDtlsBean = null;
		if(policyList == null || policyList.isEmpty())
		{
			if(deletedPolicyList == null || deletedPolicyList.isEmpty()){
				PolicyInsuranceMasterBean titleBean = new PolicyInsuranceMasterBean();
				titleBean.setDiagStartDate(startDate);
				titleBean.setDiagEndDate(endDate);
				policyList = new ArrayList<PolicyInsuranceMasterBean>();
				policyList.add(titleBean);
				System.err.println("TitleBeanloop");
			}
			//Delete Definition
			else{
				policyList.add(new PolicyInsuranceMasterBean());
			}
			//Delete Definition		
			
		}		
	}
	else{
		System.err.println("policyList in diag popup1:"+policyList);
		if(policyList == null || policyList.isEmpty()){
			PolicyInsuranceMasterBean covBean = new PolicyInsuranceMasterBean();
			covBean.setDiagStartDate(startDate);
			covBean.setDiagEndDate(endDate);
			policyList = new ArrayList<PolicyInsuranceMasterBean>();
			policyList.add(covBean);
		}
	}
	System.err.println("policyList in diag popup2:"+policyList);
	pstmt = null;
	rst = null;
	String inclExclSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_POP_CRITERIA");
	System.err.println(inclExclSql);
	pstmt = con.prepareStatement(inclExclSql);
	pstmt.setString(1,"L_SERV_INC_EXC_CR_"+criteria);
	pstmt.setString(2,locale);
	rst = pstmt.executeQuery();
	inclExclDesc = "";
	inclExclCode = "";
	if(rst!=null){
		while(rst.next()){
			criteriaMap.put(rst.getString("code"),rst.getString("description"));
			inclExclDesc = inclExclDesc+":::"+rst.getString("description");
			inclExclCode = inclExclCode+":::"+rst.getString("code");
		}	
	}
	
	inclExclDesc = inclExclDesc.substring(3);
	inclExclCode = inclExclCode.substring(3);
	
	String servDiagTypeSql  =  	BlRepository.getBlKeyValue("POLICY_DEF_INCL_EXCL_POP_CRITERIA");
	System.err.println(inclExclSql);
	pstmt = con.prepareStatement(inclExclSql);
	pstmt.setString(1,"L_SERV_DIAG_TYPE");
	pstmt.setString(2,locale);
	rst = pstmt.executeQuery();

	if(rst!=null){
		while(rst.next()){
			diagTypeMap.put(rst.getString("code"),rst.getString("description"));
			diagTypeDesc = diagTypeDesc+":::"+rst.getString("description");
			diagTypeCode = diagTypeCode+":::"+rst.getString("code");			
		}	
	}

	diagTypeDesc = diagTypeDesc.substring(3);
	diagTypeCode = diagTypeCode.substring(3);	
}
catch(Exception e){
	System.err.println("Exception "+e);
}
finally{
	ConnectionManager.returnConnection(con);
	pstmt = null;
	rst = null;
}
%>
	<form  id="frmPolicyDiagCopay">	
      	<table width='100%' class='grid' border='1' cellpadding='3'  cellspacing=0 align="center" id="PolicyDiagCopayPopup">  
      		<tr>
				<td class='COLUMNHEADER' nowrap><fmt:message key="Common.DiagnosisType.label" bundle="${common_labels}"/><img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.PatCopay.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffFromDate.label" bundle="${bl_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.EffToDate.label" bundle="${bl_labels}"/></td>
				<td class='COLUMNHEADER' nowrap><fmt:message key="eBL.DeleteRecord.label" bundle="${bl_labels}"/></td>			 
			</tr>
			<%
				int tableIndex = 1;
					for (PolicyInsuranceMasterBean policyBean1 : policyList) {
						System.err.println("policyBean1.getStatus():"+policyBean1.getDiagStatus());
						if("I".equals(policyBean1.getDiagStatus())){
							readonly = "";
							disabled = "";
						}
						else if("U".equals(policyBean1.getDiagStatus())){
							readonly = "readonly";
							disabled = "disabled";
						}
						
						if("E".equals(policyBean1.getInclExclInd())){
							exclDisabled = "disabled";
						}
						else{
							exclDisabled = "";
						}
						System.err.println("readonly:"+readonly);
						System.err.println("disabled:"+disabled);
			%>
			 <tr>
				<td class='fields' nowrap>
					<Select id='popDiag_diagType_<%= tableIndex%>' name='popDiag_diagType_<%= tableIndex%>' <%=disabled %> onchange="">
						<%
						for (Iterator iterator = diagTypeMap.keySet().iterator(); iterator.hasNext();) {
							String type = (String) iterator.next();
							if(type.equals(policyBean1.getDiagType())){ %>
								<option value='<%=type %>' selected><%=diagTypeMap.get(type) %></option>	
							<%}
							else{%>
								<option value='<%=type %>'><%=diagTypeMap.get(type) %></option>	
							<%} 
							
						}
						
					%>						
					</Select>
				</td>
				<td class='fields' nowrap>
					<input type='text' id='popDiag_copay_<%= tableIndex%>' name='popDiag_copay_<%= tableIndex%>' value='<%=checkForNull(policyBean1.getDiagPatCopay())%>' size='10' onkeypress="return checkForSpecChars(event)" onblur="checkForNumberDecimal(this);checkCopayValue(this);" maxlength='5'>
					
				</td>
				
				<td class='fields' nowrap>
					<input type='text' id='popDiag_effFrom_<%= tableIndex%>' name='popDiag_effFrom_<%= tableIndex%>' <%=readonly %> size='10' value='<%=checkForNull(policyBean1.getDiagStartDate())%>' onblur='isValidDate(this);checkDateFrom(popDiag_effFrom_<%= tableIndex%>);compareDates(popDiag_effFrom_<%= tableIndex%>,popDiag_effTo_<%= tableIndex%>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='diag_effFrom_ctrl_<%= tableIndex%>' <%=disabled %> onClick="return showCalendar('popDiag_effFrom_<%= tableIndex%>');" />
				</td>
				<td class='fields' nowrap>
					<input type='text' id='popDiag_effTo_<%= tableIndex%>' name='popDiag_effTo_<%= tableIndex%>' size='10' value='<%=checkForNull(policyBean1.getDiagEndDate())%>' onblur='isValidDate(this);checkDateFrom(popDiag_effTo_<%= tableIndex%>);compareDates(popDiag_effFrom_<%= tableIndex%>,popDiag_effTo_<%= tableIndex%>);'>
					<img src='../../eCommon/images/CommonCalendar.gif' id='diag_effTo_ctrl_<%= tableIndex%>' onClick="return showCalendar('popDiag_effTo_<%= tableIndex%>');" />
					<input type='hidden' name='popDiag_rowStatus<%= tableIndex%>' id='popDiag_rowStatus<%= tableIndex%>' value='<%= checkForStatus(policyBean1.getDiagStatus())%>'>
				</td>
				<td class='fields' nowrap>
				<%if("Y".equals(policyBean1.getDiagDelFlag())){ %>
					<input type='checkbox' checked name='popDiag_delFlag<%= tableIndex%>' id='popDiag_delFlag<%= tableIndex%>'>
				<%} else{ %>
					<input type='checkbox' name='popDiag_delFlag<%= tableIndex%>' id='popDiag_delFlag<%= tableIndex%>'>
				<%} %>
				</td>
			</tr>
			<%
			tableIndex++;	
			}	
			%>
      	</table>
      	<input type='hidden' name='pageInfo' id='pageInfo' value='DiagCopayPopup'>
      	<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
      	<input type='hidden' name='rowNumber' id='rowNumber' value='<%=rowNumber%>'>
      	<input type='hidden' name='locale' id='locale' value='<%=locale %>'>
      	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id %>'>
      	<input type='hidden' name='criteria' id='criteria' value='<%=criteria %>'>
      	<input type='hidden' name='startDate' id='startDate' value='<%=startDate %>'>
      	<input type='hidden' name='endDate' id='endDate' value='<%=endDate %>'>
      	<input type='hidden' name='inclExclDesc' id='inclExclDesc' value='<%=inclExclDesc%>'>
      	<input type='hidden' name='inclExclCode' id='inclExclCode' value='<%=inclExclCode%>'>
		<input type='hidden' name='blngCode' id='blngCode' value='<%=blngCode%>'>
		
		<input type='hidden' name='encEpsd' id='encEpsd' value='<%=encEpsd %>'>
      	<input type='hidden' name='gender' id='gender' value='<%=gender %>'>
      	<input type='hidden' name='ageGroup' id='ageGroup' value='<%=ageGroup %>'>
      	<input type='hidden' name='clinicNursInd' id='clinicNursInd' value='<%=clinicNursInd%>'>
      	<input type='hidden' name='clinicNursCode' id='clinicNursCode' value='<%=clinicNursCode%>'>
		<input type='hidden' name='spltyCode' id='spltyCode' value='<%=spltyCode%>'>
		<input type='hidden' name='mode' id='mode' value='<%=mode %>' >
		<input type='hidden' name='payerGroup' id='payerGroup' value='<%=payerGroup%>'>
      	<input type='hidden' name='payer' id='payer' value='<%=payer%>'>
      	<input type='hidden' name='policy' id='policy' value='<%=policy%>'>
      	<input type='hidden' name='patClass' id='patClass' value='<%=patClass%>'>
		<input type='hidden' name='siteId' id='siteId' value='<%=siteId %>'>
		
      	<input type='hidden' name='diagTypeDesc' id='diagTypeDesc' value='<%=diagTypeDesc%>'>
      	<input type='hidden' name='diagTypeCode' id='diagTypeCode' value='<%=diagTypeCode%>'>		
     </form>
    <%!
		private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
		}
		private String checkForStatus(String inputString) {
			return (inputString == null || "".equals(inputString)) ? "I" : inputString;
		}
    %>
</body>
</html>

