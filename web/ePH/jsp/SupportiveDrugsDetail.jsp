<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.DrugMasterBean, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		     Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/10/2011        		          Chandra Shekar a  26/07/2019                              TH-KW-CRF-0008
--------------------------------------------------------------------------------------------------------------
*/
%>
<%	
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

%>
<html>
<head>
<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>


<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script language="javascript" src="../../ePH/js/DrugMasterDetail.js"></script>
<script language="javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
<script language="JavaScript" src="../js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>


<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
    String locale			= (String)session.getAttribute("LOCALE");
    String bean_id				=	"DrugMasterBean" ;
	String bean_name			=	"ePH.DrugMasterBean";
	String mode			= request.getParameter("mode");
	DrugMasterBean bean = (DrugMasterBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	String drug_code		= request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String curr_drug_code ="";
	String classvalue				=		"";
	int k= 1;

	ArrayList drugList = bean.getSupportdrugList();
	System.err.println("drugList@@==="+drugList+"drug_code==="+drug_code);
	if(!drugList.contains(drug_code) && !drug_code.equals("")){
		bean.setSupportdrugList(drug_code);
		bean.setSupportDrugDetails(drug_code);
	}
	
	 HashMap supportDrugs =bean.getSupportDrugs();
	 System.err.println("supportDrugs@@===="+supportDrugs);
	 ArrayList drugDetails = new ArrayList();
	
	int total_records =supportDrugs.size();
	System.err.println("supportDrugs@@@==="+supportDrugs+"drugList@@@=="+drugList);
	
%>
		<form name='supportdrugsdetails' id='supportdrugsdetails'>
			<table border="0" align="center" width="80%" cellpadding="0" cellspacing="0">
			<tr>
			    <th align="center"><fmt:message key="Common.SrlNo.label" bundle="${common_labels}"/></th>
	            <th align="center"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
	            <th align="center"><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></th>
				<th align="center"><fmt:message key="Common.Form.label" bundle="${common_labels}"/></th>
				<th align="center"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></th>
				<th align="center"><fmt:message key="ePH.AdminRoute.label" bundle="${ph_labels}"/></th>
				<th align="center"><fmt:message key="Common.action.label" bundle="${common_labels}"/></th>
           </tr>
<%
                if(supportDrugs.size()>0){
					for(int j=0;j<drugList.size();j++){
						curr_drug_code =(String)drugList.get(j);
						//System.err.println("curr_drug_code@@=="+curr_drug_code+"supportDrugs.size()=="+supportDrugs.size());
					drugDetails = (ArrayList)supportDrugs.get(curr_drug_code);
			//		System.err.println("drugDetails@@==="+drugDetails+"jjj"+j);
                   for(int i=0;i<drugDetails.size();i=i+7){//Changed supportDrugs.size to  drugDetails.size() for ICN-52719
					   System.err.println("i---"+i);

					   if (i % 2 == 0)
					       classvalue = "OAQRYEVEN" ;
				      else
					       classvalue = "OAQRYODD" ;
%>
                <tr>
				    <td class="<%=classvalue%>" name="srl_no_<%=k%>"  id ="srl_no_<%=k%>">
						<%=k%>
					</td>
                     <td class="<%=classvalue%>" name="drug_name_<%=k%>"  id ="drug_name_<%=k%>">
						<%=drugDetails.get(i+1)%>
						<input type="hidden" name="drug_code_<%=k%>" id="drug_code_<%=k%>" value="<%=drugDetails.get(i)%>">
					</td>
					<td class="<%=classvalue%>" name="generic_<%=k%>"  id ="generic_<%=k%>">
						<%=drugDetails.get(i+2)%>
					</td>
					<td class="<%=classvalue%>" name="form_<%=k%>"  id ="form_<%=k%>">
						<%=drugDetails.get(i+3)%>
					</td>
					<td class="<%=classvalue%>" name="strength_<%=k%>"  id ="strength_<%=k%>">
						<%=drugDetails.get(i+6)%>
					</td>
					<td class="<%=classvalue%>"  name="route_<%=k%>"  id ="route_<%=k%>">
						<%=drugDetails.get(i+5)%>
					</td>
					<td class="<%=classvalue%>">
						<input type="checkbox" value="" name="check_<%=k%>" id="check_<%=k%>"  id ="check_<%=k%>"   onClick="" checked>
					</td>
               </tr>
<%
					  
				   }
				   k++;
				}

}
%>
			</table>
			      <input type="hidden" name="total_records" id="total_records" value="<%=total_records%>">
				   <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				    <input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
        </form>
	</body>
</html>

