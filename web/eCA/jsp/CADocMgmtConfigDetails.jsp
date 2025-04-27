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
<%@ page import="java.sql.*,eCA.*,webbeans.eCommon.*,eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");	
	String mode="";
	
	
	String sFacilityId = "",sFacilityId_df = "";
	
	
	mode = (request.getParameter("mode")==null)?"":request.getParameter("mode");
	sFacilityId = (request.getParameter("facilityId")==null)?"":request.getParameter("facilityId");	
	sFacilityId_df = (request.getParameter("facilityId_df")==null)?"":request.getParameter("facilityId_df");	
	
	
	
	try{

		CADocumentConfigBean docConfigBean = new CADocumentConfigBean(); 
		HashMap<String,Object> docConfigDetailsMap= new HashMap<String,Object>();		
		ArrayList<CADocumentConfig> documentFuncitonList = new ArrayList<CADocumentConfig>() ;
		HashMap<String,ArrayList<CADocumentConfig>> documentMapDetails = new HashMap<String,ArrayList<CADocumentConfig>>();
		CADocumentConfig docConfig = null;
		CADocumentConfig docConfigDetails = null;
		
		docConfigDetailsMap = docConfigBean.getDocumentConfigDetails(sFacilityId);
		
		documentFuncitonList = (ArrayList<CADocumentConfig>)docConfigDetailsMap.get("DOCFUNCTIONLIST");
		documentMapDetails = (HashMap<String,ArrayList<CADocumentConfig>>)docConfigDetailsMap.get("DOCFUNCTIONLISTDETAILS");		
		int totalDocuments = 0;
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../js/CADocMgmtConfig.js' language='javascript' ></script>
<Script src='../../eCommon/js/CommonLookup.js' language="JavaScript" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body onscroll='scrollTitleTop()' class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
	<form name="CADocMgmtConfigForm" id="CADocMgmtConfigForm" action="../../servlet/eCA.CADocMgmtConfigServlet" method="post" target="messageFrame">
		<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"	style="width: 1000px;">
			<tbody>
				<!--
				<tr>
					<td class='columnheadercenter' colspan="3">Document Option&nbsp;</td>
				</tr>
				-->
				<%
				for(int i=0; i<documentFuncitonList.size();i++){
					docConfig = documentFuncitonList.get(i);
				%>
					<tr>
						<td class='COLUMNHEADER' width="50%"><%=docConfig.getDocFunctionName() %>  Option&nbsp;</td>
						<td class='COLUMNHEADER' colspan="2" width="50%"> Storage Option Type &nbsp;</td>
					</tr>
				<%
					ArrayList<CADocumentConfig> docFuncitonDetailsList = new ArrayList<CADocumentConfig>() ;
					docFuncitonDetailsList = documentMapDetails.get(docConfig.getDocFuncitonId());
					
					for(int j=0; j<docFuncitonDetailsList.size();j++){
						docConfigDetails = docFuncitonDetailsList.get(j);
						String docFolderOption =(String)docConfigDetails.getDocStoredType();
						System.out.println("--------------------->"+docFolderOption+"<-------------");
				%>				
						<tr>
							<td class='gridData' style="border-bottom-width: 0px; " width="50%">&nbsp;</td>
							<td class='Fields'   width="25%" >
								<input type="radio" name="docFolderOption<%=j %>" id="docFolderOption<%=j %>" value="D" <%if("D".equals(docFolderOption)){%>checked<%}%> onclick="setDocPathEnabled('<%=j%>')">Database(Existing)
							</td>						
							<td class='Fields' width="25%">
								<input type="radio"	name="docFolderOption<%=j %>" id="docFolderOption<%=j %>" value="F" <%if("F".equals(docFolderOption)){%>checked<%}%> onclick="setDocPathEnabled('<%=j%>')">Shared Path
							</td>
						</tr>
					 
						<tr>
							<td class='gridData' style="border-top-width: 0px; border-bottom: 3px black;" width="50%" >							
								<%=docConfigDetails.getDocSubFunctionName() %>
								<img src='../../eCommon/images/mandatory.gif' id="sharedPathMandatoryImg<%=j %>" name="sharedPathMandatoryImg<%=j %>" <%if("F".equals(docFolderOption)){%>style='display: inline;'<%}else{ %>style='display: none;'<%}%>>
								&nbsp;
							</td>
							<td class='Fields'  colspan="2"  width="50%" >
								<input type="text" name="docSharedPath<%=j %>" id="docSharedPath<%=j %>" id="docSharedPath<%=j %>" value="<%=docConfigDetails.getDocStoredPath() %>" style="border-bottom-width: 0px;border-top-width: 0px;border-left-width: 0px;border-right-width: 0px;" size=90 maxlength=128 onkeypress="return CheckForSpecCharsWithSpaceBlur(event)" onBlur="return validateSharedPath(this);";<%if("D".equals(docFolderOption)){%> disabled <%}%> >
							</td>
						</tr>	
						<input type="hidden" name="docSubFuncitonId<%=j %>" id="docSubFuncitonId<%=j %>" value="<%=docConfigDetails.getDocSubFuncitonId() %>"/>
						<input type="hidden" name="docStoredType<%=j %>" id="docStoredType<%=j %>" value="<%=docFolderOption %>"/>
						<input type="hidden" name="docFuncitonName<%=j %>" id="docFuncitonName<%=j %>" value="<%=docConfigDetails.getDocSubFunctionName() %>"/>						
						<input type="hidden" name="docSharedPathValue<%=j %>" id="docSharedPathValue<%=j %>" value="<%=docConfigDetails.getDocStoredPath() %>"/>					
				
				<% 
						if((j+1)==docFuncitonDetailsList.size()){
							totalDocuments=(j+1);
						}
					}
				}
				%>	
			</tbody>
		</table>						
		<br>

		
		<input type="hidden" name="facilityId" id="facilityId" value="<%=sFacilityId%>"/>
		<input type="hidden" name="facilityId_df" id="facilityId_df" value="<%=sFacilityId_df%>"/>
		<input type="hidden" name="totaldocuments" id="totaldocuments" value="<%=totalDocuments %>"/>
	<%
	}catch(Exception e1){
	 //out.println("(CADocMgmtConfigDetails.jsp:Exception) "+e1);//common-icn-0181
	 e1.printStackTrace(System.err);
	}
	finally
	{
		
	}
	%>	
	</form>
</body>
</html>

