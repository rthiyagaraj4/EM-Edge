<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna Pranay	         30/04/2024         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
	String locale = ((String)session.getAttribute("LOCALE"));
    String sStyle = (session.getAttribute("PREFERRED_STYLE") != null && !session.getAttribute("PREFERRED_STYLE").equals("")) ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	request.setCharacterEncoding("UTF-8");
    request = new XSSRequestWrapper(request); // MOHE-SCF-0153
    response.addHeader("X-XSS-Protection", "1; mode=block"); // MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); // MMS-ME-SCF-0085
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></Script>
<script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'></script>	
</head>
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name='CAMenstrualHistDtlResultForm' id='CAMenstrualHistDtlResultForm'>
	<%
String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	String	mode1 =  request.getParameter("mode1")==null?"":request.getParameter("mode1");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String finalize_yn = request.getParameter("finalize_yn") == null ? "" : request.getParameter("finalize_yn");
	String finalized_prev = request.getParameter("finalized_prev") == null ? "" : request.getParameter("finalized_prev");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String multibirthvalue = request.getParameter("multibirthvalue") == null ? "" : request.getParameter("multibirthvalue");
		int resAuditDetailsCount=0; 
		String eventStatus="";
		String selectedValue="";
		String Lmp_Date="";
		String gestation_pog="";
		String edd="";
		String gestation_poa="";
		String scan_gestation="";
		String unsure_date="";
		String mode="";
		String redd="";
		String delivery_miscarrage_type="";
		String delivery_miscarrage_date="";
		String remarks="";
		String modified_remarks="";
		String error_remarks="";
		String srl_no="";
		Integer cutOffBackdate = null;        
		Integer cutOffDeliveryDate = null;   
		Integer cutOffDeliveryLmp = null;    
		Integer cutOffMiscarriageLmp = null; 
		String enableMarkAsErrorYN="N";

		String added_date="";
		String event_remarks="";
		String display_E_Button="";
String facility_id = request.getParameter("facility_id");

String slClassValue = "gridData";
String ca_bean_id = "@CAMenstrualHistDtlTransBean";
String ca_bean_name = "eCA.CAMenstrualHistDtlTransBean";
CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean)getBeanObject(ca_bean_id, ca_bean_id, request);
ArrayList resArray = bean.getPatientMenstrualHistory(patient_id);
ArrayList masterArray = bean.getMenstrualHistoryMaster(facility_id);


	if(masterArray.size()>0){
	for(int i=0;i<masterArray.size();i++){
		ArrayList array = (ArrayList)masterArray.get(i);
  		cutOffBackdate = Integer.parseInt((String) array.get(0)); 
		cutOffDeliveryDate = Integer.parseInt((String) array.get(1)); 
		cutOffDeliveryLmp = Integer.parseInt((String) array.get(2)); 
		  cutOffMiscarriageLmp = Integer.parseInt((String) array.get(3)); 
		enableMarkAsErrorYN=(String)array.get(4);
	}
}
 
%>
<div id='divDataTitle' style='position:relative'>
    <center>
        <!-- Table for header -->
        <table border='1px' width='100%' cellpadding='3' cellspacing='0' align='center'>
            <tr>
                <td class='COLUMNHEADERCENTER' width='100%'><fmt:message key="eCA.ViewMenstrualHistDtl.label" bundle="${ca_labels}"/></td>
            </tr>
        </table>
        
        <!-- Table for column headers -->
  <!-- Table for column headers -->
<!-- Table for column headers -->
<table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center' >
    <tr>
    <td class='columnheader' width="5%"><fmt:message key="eCA.Event.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="10%"><fmt:message key="eCA.EventStatus.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="7%"><fmt:message key="eCA.LMPDate.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="7%"><fmt:message key="eCA.EDD.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="9%"><fmt:message key="eCA.GestationPOA.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="9%"><fmt:message key="eCA.ScanGestation.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="7%"><fmt:message key="eCA.LMPDate.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="7%"><fmt:message key="eCA.REDD.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="9%"><fmt:message key="eCA.GestationPOG.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="8%"><fmt:message key="eCA.DeliveryMiscarrage.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="8%"><fmt:message key="eCA.deliveryMiscarrageDate.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="5%"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
    <td class='columnheader' width="8%"><fmt:message key="eCA.AuditTrail.label" bundle="${ca_labels}"/></td>
    </tr>
</table>

    </center>
</div>

<!-- Display Data -->
<% if (resArray.size() > 0) { %>
<div class='table-responsive'>
    <center>
    <table border='1' width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center'  class='grid'>
            <% for (int i = 0; i < resArray.size(); i++) {
                String[] record = (String[]) resArray.get(i);
                selectedValue	= CommonBean.checkForNull(record[1]);
        		Lmp_Date			= CommonBean.checkForNull(record[2]);
        		edd			= CommonBean.checkForNull(record[3]);
        		gestation_poa			= CommonBean.checkForNull(record[4]); 
        		scan_gestation			= CommonBean.checkForNull(record[5]); 
        		unsure_date					= CommonBean.checkForNull(record[6]);
        		redd						= CommonBean.checkForNull(record[7]);
        		gestation_pog			= CommonBean.checkForNull(record[8]);
        		delivery_miscarrage_type		= CommonBean.checkForNull(record[9]);
        		delivery_miscarrage_date			= CommonBean.checkForNull(record[10]);
        		remarks		= CommonBean.checkForNull(record[11]);
        		modified_remarks		= CommonBean.checkForNull(record[12]);
        		srl_no		= CommonBean.checkForNull(record[13]);
        		eventStatus		= CommonBean.checkForNull(record[14]);
        		error_remarks		= CommonBean.checkForNull(record[15]);
        		added_date		= CommonBean.checkForNull(record[16]);
        		display_E_Button		= CommonBean.checkForNull(record[17]);
        		event_remarks		= CommonBean.checkForNull(record[18]);
			
        		if(eventStatus.equals("A"))
        		{
        			eventStatus="Active";
        		}
        		else if(eventStatus.equals("AC"))
        		{
        			eventStatus="Auto Closed";
        		}
        		else if(eventStatus.equals("C"))
        		{
        			eventStatus="Closed";
        		}
        		else if(eventStatus.equals("E"))
        		{
        			eventStatus="Marked as Error";
        		}
              
        		resAuditDetailsCount = bean.getAuditTrailCount(patient_id, srl_no, selectedValue);
              mode = "modify";
            %>
            <tr class='bordered-row'>
              <td class='<%=slClassValue %>' width="5%">
 			<% 
    // Assuming eventStatus has already been set based on the delivery_miscarrage_type and delivery_miscarrage_date
   			 if ("Active".equals(eventStatus)) {
      		  if ("L".equals(selectedValue)) { // If the event is LMP
			%>
       		 <a href="javascript:void(0);" onclick="openLMPDetails('<%= patient_id %>','<%= selectedValue %>', '<%= Lmp_Date %>', '<%= edd %>', '<%= gestation_poa %>', '<%= delivery_miscarrage_type %>', '<%= delivery_miscarrage_date %>', '<%=remarks.replace("\\", "\\\\").replace("'", "\\'").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r")%>', '<%= srl_no %>');">LMP</a>
			<%
        	} else if ("U".equals(selectedValue)) { // If the event is USOD
			%>
        	<a href="javascript:void(0);" onclick="openUSODDetails('<%= patient_id %>','<%=selectedValue%>','<%=scan_gestation%>','<%=unsure_date%>','<%=redd%>','<%=gestation_pog%>','<%=delivery_miscarrage_type%>','<%=delivery_miscarrage_date%>','<%=remarks.replace("\\", "\\\\").replace("'", "\\'").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r")%>', '<%=srl_no%>');">USOD</a>
			<%
      		  }
   			 } else { // eventStatus is "Closed", so no hyperlink
       		 if ("L".equals(selectedValue)) {
       			if ("Closed".equals(eventStatus) && "Y".equals(enableMarkAsErrorYN) && "E".equals(display_E_Button) && !("Y".equals(finalize_yn) && "N".equals(multibirthvalue)) && !(("N".equals(finalize_yn) && "Y".equals(multibirthvalue) && "Y".equals(finalized_prev)))) {
        		    // Logic for when all conditions are satisfied
        		    out.print("<span style='vertical-align: top;'>LMP</span> ");
        		    out.print("<button title='Mark as Error' onclick=\"markAsErrorUSOD('" + patient_id + "', '" + selectedValue + "', '" + srl_no + "')\" style='font-size: 9px; padding: 2px 4px; width: 17px; height: 14px; line-height: 1; text-align: center;'>E</button>");
        		}
       			else {
       			    // Only print "LMP" if the condition is not satisfied
       			    out.print("LMP");
       			}
        	} else if ("U".equals(selectedValue)) {
        		if ("Closed".equals(eventStatus) && "Y".equals(enableMarkAsErrorYN) && "E".equals(display_E_Button) && !("Y".equals(finalize_yn) && "N".equals(multibirthvalue)) && !(("N".equals(finalize_yn) && "Y".equals(multibirthvalue) && "Y".equals(finalized_prev)))) {
        		    // Logic for when all conditions are satisfied
        		    out.print("<span style='vertical-align: top;'>USOD</span> ");
        		    out.print("<button title='Mark as Error' onclick=\"markAsErrorUSOD('" + patient_id + "', '" + selectedValue + "', '" + srl_no + "')\" style='font-size: 9px; padding: 2px 4px; width: 17px; height: 14px; line-height: 1; text-align: center;'>E</button>");
        		}
          		else {
       			    // Only print "LMP" if the condition is not satisfied
       			    out.print("USOD");
       			}
        	}
   		 }
		%>
				</td>
                <td class='<%=slClassValue %>'width="10%">
                <% 
                if ("Marked as Error".equals(eventStatus)) { %>
                <span><%=eventStatus%></span>&nbsp;<a href="#" onclick="openErrorRemarksView('<%= patient_id %>','<%= srl_no %>')">R</a>
               <% } else { %>
               <span><%=eventStatus %></span>
              <% } %>
                 </td> <!-- Event Status -->
                <td class='<%=slClassValue %>'  width="7%"><%=Lmp_Date%></td> <!-- LMP Date -->
                <td class='<%=slClassValue %>'  width="7%"><%=edd%></td> <!-- EDD -->
                <td class='<%=slClassValue %>'  width="9%"><%=gestation_poa%></td> <!-- Gestation POA -->
                <td class='<%=slClassValue %>'  width="9%"><%=scan_gestation%></td> <!-- Scan Gestation -->
                <td class='<%=slClassValue %>'  width="7%"><%=unsure_date%></td> <!-- LMP Date -->
                <td class='<%=slClassValue %>'  width="7%"><%=redd%></td><!-- REDD -->
                <td class='<%=slClassValue %>'  width="9%"><%=gestation_pog%></td> <!-- Gestation POG -->
                <td class='<%=slClassValue %>'  width="8%">
                  <% if ("D".equals(delivery_miscarrage_type)) { %>
       				 Delivery
  				  <% } else if ("M".equals(delivery_miscarrage_type)) { %>
     			   Miscarriage
   				 <% } else { %>
      			  &nbsp; <!-- To ensure the cell is not empty -->
  				  <% } %> 
                </td> <!-- Delivery/Miscarriage -->
                <td class='<%=slClassValue %>'  width="8%"><%= delivery_miscarrage_date%></td> <!-- Delivery/Miscarriage Date -->
                <td class='<%=slClassValue %>' width="5%">
    			<% if ((remarks != null && !remarks.equals("")) || ("Auto Closed".equals(eventStatus))) { %>
       			 <a href="#" onclick="openRemarksPopup('<%=remarks.replace("\\", "\\\\").replace("'", "\\'").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r")%>','<%=event_remarks%>','<%=srl_no %>','<%= patient_id %>')">R</a>
   				 <% } else { %>
       				 &nbsp;
   					 <% } %>
				</td>
                <td class='<%=slClassValue %>' width="8%"> <!-- Audit Trail -->
   			   <% if (resAuditDetailsCount>0) { %>
       		   <a href="#" onclick="openAuditTrailPopup('<%= patient_id %>','<%= selectedValue %>','<%= srl_no %>')">View Audit Trail</a>
    			<% } else { %>
       			 &nbsp; <!-- Display a blank cell or some other placeholder text if no remarks -->
   			 <% } %>
			</td>
            </tr>
            <% } %>
        </table>
    </center>
</div>
<% } else { %>
<div id='dataTitle' style='position:relative'>
    <center>
        <table width='100%' id='dataTable' cellpadding='3' cellspacing='0' align='center' style='table-layout: fixed;' class='grid'>
            <tr class='bordered-row'>
                <td class='<%=slClassValue %>' colspan='13'>&nbsp;&nbsp;&nbsp;</td> <!-- Empty row when no data -->
            </tr>
        </table>
    </center>
</div>
<% } %>
	<input type="hidden" name="option_id" id="option_id" value="<%= option_id %>">
<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
<input type="hidden" id="eventStatus"  name="eventStatus" id="eventStatus" value="<%= eventStatus %>">
<input type="hidden" id="encounter_id"  name="encounter_id" id="encounter_id" value="<%= encounter_id %>">
<input type="hidden" id="episode_id"  name="episode_id" id="episode_id" value="<%= episode_id %>">
	<input type="hidden" id="called_form" name="called_form" id="called_form" value="<%=called_form%>" />
	<input type="hidden" id="function_id" name="function_id" id="function_id" value="<%=function_id%>" />
	<input type="hidden" id="finalize_yn" name="finalize_yn" id="finalize_yn" value="<%=finalize_yn%>" />
	<input type="hidden" id="module_id" name="module_id" id="module_id" value="<%=module_id%>" />
	<input type="hidden" id="multibirthvalue" name="multibirthvalue" id="multibirthvalue" value="<%=multibirthvalue%>" />

	</form>
</body>
</html>

