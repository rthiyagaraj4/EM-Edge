<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*, ePH.Common.* ,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu 
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../js/DrugSynonym.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='frmDrugSynonymQueryResult' id='frmDrugSynonymQueryResult'>
<%
			String DrugCode = request.getParameter("DrugCode")==null?"":request.getParameter("DrugCode");
			String DrugName = request.getParameter("DrugName")==null?"":request.getParameter("DrugName");
//			drug_synonym_desc 
			String DrugSynonymType	= request.getParameter( "DrugSynonymType" ) ;
			String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
			String  classValue="",  synonym_desc="",eff_status, srl_no;
			ArrayList alSynonymsForDrug = null;
			String bean_id = "DrugSynonymBean" ;
			String bean_name = "ePH.DrugSynonymBean";
			DrugSynonymBean bean			= (DrugSynonymBean)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			alSynonymsForDrug = bean.getSynonymsForDrug(DrugSynonymType,DrugCode);
			bean.setLanguageId(locale);
			if(alSynonymsForDrug!=null && alSynonymsForDrug.size()>0){
				int index=0, count=0;
%>
				<table border="1" align="center" width="70%" cellpadding="0" cellspacing="0">
					<tr>
						<th><fmt:message key="ePH.CommonName.label" bundle="${ph_labels}"/></th>
						<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
					</tr>
<%
					while(index < alSynonymsForDrug.size()){
						DrugCode = (String)alSynonymsForDrug.get(index++);
						srl_no = (String)alSynonymsForDrug.get(index++);
						DrugSynonymType = (String)alSynonymsForDrug.get(index++);
						synonym_desc = (String)alSynonymsForDrug.get(index++);
						eff_status = (String)alSynonymsForDrug.get(index++);
						if( (count+1)%2 == 0)  
							classValue="QRYODD";
						else
							classValue="QRYEVEN";
%>
						<tr>
							<td class='<%=classValue%>' onclick="modify('<%=count%>')">&nbsp;<font class='HYPERLINK' onmouseover="changeCursor(this);"><%=synonym_desc%></font></td>
							<input type='hidden' name='SrlNo<%=count%>' id='SrlNo<%=count%>' value='<%=srl_no%>'>
							<input type='hidden' name='DrugSynonymDesc<%=count%>' id='DrugSynonymDesc<%=count%>' value='<%=synonym_desc%>'>
							<input type='hidden' name='EffStatus<%=count%>' id='EffStatus<%=count%>' value='<%=eff_status%>'>
							<td class='<%=classValue%>'style='text-align:center;'>
<%
							if(eff_status.equals("E")){
%>
								<img src="../../eCommon/images/enabled.gif" align="center">
<%
							}
							else{
%>
								<img src="../../eCommon/images/disabled.gif" align="center">
<%
							}
%>          
							</td>
						</tr>
<%
						count++;
					}
%>
				</table>
<%
			}
			else{
%>
				<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				//	window.close();
				</script>
<%
			}
%>
			<input type='hidden' name='DrugName' id='DrugName' value='<%=DrugName%>'>
			<input type='hidden' name='DrugCode' id='DrugCode' value='<%=DrugCode%>'>
			<input type='hidden' name='DrugSynonymType' id='DrugSynonymType' value='<%=DrugSynonymType%>'>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
		</form>
	</body>
<%
	putObjectInBean(bean_id,bean,request);
%>
</html>

