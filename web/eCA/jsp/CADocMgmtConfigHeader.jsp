<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
19/03/2020 	IN070345  		Ramesh Goli											MO-CRF-20147.1
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%> 
<%@ page language="java" import ="java.util.*, eCA.*, eCommon.Common.*, webbeans.eCommon.*,eCA.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title></title>
		<%	
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String mode = request.getParameter("mode");	
			
			String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			Properties p = (Properties)session.getValue("jdbc");
			String locale	= (String) p.getProperty("LOCALE");
			
			try{
				CADocumentConfigBean docConfig = new CADocumentConfigBean();
				
				List<FacilityDetailsBean> facilityDetailsList = new ArrayList<FacilityDetailsBean>();
				FacilityDetailsBean facilityDetailsBean = new FacilityDetailsBean();
				
				int facilityListSize = 0;				
				
				facilityDetailsList = docConfig.getFacilityDetails(facilityDetailsBean);	
				
				facilityListSize = facilityDetailsList.size();
				
			%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src ='../../eCommon/js/CommonLookup.js'></Script>
		
		<script language='javascript' src='../../eCA/js/CADocMgmtConfig.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'DocMgmtConfigHeaderForm'>
			<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 1000px;">
				<tr>
					
					<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td class='fields' >&nbsp;<select name='facility_id' id='facility_id'  onchange='changeFacility(this)'>
							<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
							<%
								if (facilityListSize>0){
									for (int i=0;i<facilityListSize;i++){
										facilityDetailsBean = facilityDetailsList.get(i);
										%>
										<Option value="<%=facilityDetailsBean.getsFacilityId()%>"> <%=facilityDetailsBean.getsFacilityName()%></option>
										<%
									}
								}
							%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'>
					</td>											
					<td align='right' colspan ='2'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onclick="getSearchDetails();">
					</td>
				</tr>				
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
			<input type ="hidden" name ="facilityId" value="">
			<%
			}catch(Exception e1){
				//out.println("(CADocMgmtConfigHeader.jsp:Exception) "+e1);//COMMON-ICN-0181
				e1.printStackTrace(System.err);
			}
%>
		</form>
	</body>	
</html>

