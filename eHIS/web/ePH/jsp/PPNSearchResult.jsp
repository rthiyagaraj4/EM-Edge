<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- Mandatory declarations end --%>
<html>
<head>
	<%

	String locale			= (String)session.getAttribute("LOCALE");
	 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String sPatientId	= request.getParameter("patientId");
	String sOrderId		= request.getParameter("orderId");
%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../ePH/js/PPNRegimen.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name = "PPNSearchResult">
<%
	String bean_id					= "DispMedicationAllStages" ;
	String bean_name				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean	= (DispMedicationAllStages)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);

	String bean_id_1				= "DispMedicationBean" ;
	String bean_name_1				= "ePH.DispMedicationBean";
	DispMedicationBean bean_1		= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1 , request) ;
	bean_1.setLanguageId(locale);

	String sSearchBy				= request.getParameter("searchBy");
	String sSearchText				= request.getParameter("searchText")==null?"":request.getParameter("searchText");
	String sSearchCriteria			= request.getParameter("searchCriteria");

	ArrayList alPPNItems			= new ArrayList();

	if(sSearchBy!=null)
	{
		alPPNItems					= bean.getPPNItems(sSearchBy,sSearchText,sSearchCriteria);
		if(alPPNItems != null && alPPNItems.size()>0)
		{
			int i=0;
%>
<table width ="100%">
	<tr>
		<td>
			<table width="98.5%">
				<tr>
					<td class= "COLUMNHEADER" width="20%" style="font-size:9">
						<fmt:message key="ePH.RegimenCode.label" bundle="${ph_labels}"/>
					</td>
					<td class= "COLUMNHEADER" width="40%" style="font-size:9" colspan ="2">
						<fmt:message key="Common.longname.label" bundle="${common_labels}"/>
					</td>
					<td class= "COLUMNHEADER" width="13%" style="font-size:9">
						<fmt:message key="Common.BatchID.label" bundle="${common_labels}"/>
					</td>
					<td class= "COLUMNHEADER" width="11%" style="font-size:9">
						<fmt:message key="ePH.AvailableQty.label" bundle="${ph_labels}"/>
					</td>
					<td class= "COLUMNHEADER" width="11%" style="font-size:9">
					<!-- /**
					* @Name - Sandhya A 
					* @Date - 23/12/2009
					* @Inc# - IN017455 (Legend name changed)
					 * @Select legend- changed to Allocate.
					 */ -->
						<fmt:message key="Common.Allocate.label" bundle="${common_labels}"/> <fmt:message key="Common.Qty.label" bundle="${common_labels}"/>
					</td>

				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
   <!-- This div tag is used to achieve scrolling of the contents -->
   <div id="bar" style="postition:absolute; overflow: auto; height: 342; width: 1010;">
<%	

		//If scrolling is on, then the table width should be changed accordingly
			String sWidth ="98.5%" ; 

			if(alPPNItems.size()>13)
				sWidth ="100%" ;
%>	

				<table width="<%=sWidth%>">
<%

			for(i=0; i<alPPNItems.size();i++)
			{
				HashMap hmPPNItemDetails = (HashMap) alPPNItems.get(i);
%>
					<tr>
						<td class="label" width="20%"> 
							<label class="label"  style="cursor:pointer;color:blue" onclick="returnPPNValues('<%=i%>')">
								<%=hmPPNItemDetails.get("ItemCode")%>
							</label>
						</td>
						<td class="label" width="30%">
							<label class="label"><%=hmPPNItemDetails.get("ItemDesc")%></label>
						</td>
						<td class="label" width="10%">
							<label class="label"  style="cursor:pointer;color:blue" onClick="displayConstInPPN('<%=hmPPNItemDetails.get("ItemCode")%>')">
								<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/>		
							</label>
						</td>
						<td class="label" width="13%" >
							<input type='text' name = "batchSearch" onkeypress="if(event.keyCode !=32){return CheckForSpecChars(event)}" size = "10" maxlength = "12"><input class="button" type = "button" name ="batchSarchBtn" value ="?" onclick=" callBatchSearchForPPN('<%=hmPPNItemDetails.get("ItemCode")%>','<%=bean_1.getDispLocnCode().trim()%>','<%=i%>')">
						</td>
						<td class="label" id="dispAvailQty" width="11%">
							<%=hmPPNItemDetails.get("AvailQty")%>
						</td>
						<td class="label" width="11%">
							<input type='text' name = "selectQty" onkeypress="return allowValidNumber(this,event,12,0);" size = "10" maxlength = "12" onblur = "checkWithMaxQty('<%=i%>',this)">
							<input type='hidden' name = "ItemCode" value="<%=hmPPNItemDetails.get("ItemCode")%>">
							<input type='hidden' name = "ItemDesc" value="<%=hmPPNItemDetails.get("ItemDesc")%>">
							<input type='hidden' name = "BatchId" value="<%=hmPPNItemDetails.get("BatchId")%>">
							<input type='hidden' name = "TradeId" value="<%=hmPPNItemDetails.get("TradeId")%>">
							<input type='hidden' name = "ManufacturerId" value="<%=hmPPNItemDetails.get("ManufacturerId")%>">
							<input type='hidden' name = "AvailQty" value="<%=hmPPNItemDetails.get("AvailQty")%>">
							<input type='hidden' name = "UOMCode" value="<%=hmPPNItemDetails.get("UOMCode")%>">
							<input type='hidden' name = "BinLocation" value="<%=hmPPNItemDetails.get("BinLocation")%>">
							<input type='hidden' name = "ExpiryDate" value="<%=hmPPNItemDetails.get("ExpiryDate")%>">
						</td>
					</tr>
<% 
		}
%>
				</table>
			</div>
		</td>
	</tr>
</table>
<input type="hidden" name="totalItems" id="totalItems" value="<%=i%>">
<input type="hidden" name="PatientId" id="PatientId" value="<%=sPatientId%>">
<input type="hidden" name="OrderId" id="OrderId" value="<%=sOrderId%>">
<%
		}
		else
		{
%>
<script>
	alert(getMessage("NO_PPN_FOUND","PH"));
</script>
<%
		}

	}
%>


</form>
</body>
</html>

