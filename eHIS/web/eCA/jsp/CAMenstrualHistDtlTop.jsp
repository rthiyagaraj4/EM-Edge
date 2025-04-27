<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       		Edit History    	 Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
29/04/2024     58928	     Krishna pranay	         30/04/204         Ramesh Goli       	ML-MMOH-CRF-1759.2
01/10/2024     68508     krishna pranay             13/10/2024  Ashwini Ragupathi  ML-MMOH-CRF-1759							
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page import ="java.sql.*,java.text.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
    String locale = ((String)session.getAttribute("LOCALE"));
    String sStyle =
    (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? 
    (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
    
    request.setCharacterEncoding("UTF-8");
    request = new XSSRequestWrapper(request); //MOHE-SCF-0153
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    
    String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
    String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
    String facility_id=(String) session.getValue("facility_id");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String multibirthvalue = request.getParameter("multibirthvalue") == null ? "" : request.getParameter("multibirthvalue");

%>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
    <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
    <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
    <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
    <script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
    <script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'></script>
</head>
<%
    String eventStatus = "";
    boolean shouldCheckLastMenstrualPeriod = false; // Flag for checking the radio button
    boolean shouldCheckUnsureOfDate = false; // New flag for UnsureOfDate radio button
    String ca_bean_id = "@CAMenstrualHistDtlTransBean";
    String ca_bean_name = "eCA.CAMenstrualHistDtlTransBean";
    CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean)getBeanObject(ca_bean_id, ca_bean_name, request);
    ArrayList resArray = bean.getPatientMenstrualHistory(patient_id);
    boolean disableLastMenstrualPeriod = false;
    boolean disableUnsureOfDate = false;
    String mode1 = request.getParameter("mode1") == null ? "" : request.getParameter("mode1");
    String selectedValue = request.getParameter("selectedValue") == null ? "" : request.getParameter("selectedValue");
	String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");
	String finalize_yn = request.getParameter("finalize_yn") == null ? "" : request.getParameter("finalize_yn");

	
	  boolean disableRadioButtons = false;
	
	if (mode1.equals("modify")) {
        // If mode is "modify", select the radio based on selectedValue
        if ("L".equals(selectedValue)) {
            shouldCheckLastMenstrualPeriod = true;
            disableUnsureOfDate = true;
        } else if ("U".equals(selectedValue)) {
            shouldCheckUnsureOfDate = true;
            disableLastMenstrualPeriod = true;
        }
    } else {
        // This code executes if mode is NOT "modify"
        if (resArray.size() > 0) {
            for (int i = 0; i < resArray.size(); i++) {
                String[] record = (String[]) resArray.get(i);
              
                eventStatus = CommonBean.checkForNull(record[14]);
              String  delivery_miscarrage_type = CommonBean.checkForNull(record[9]);
              String  delivery_miscarrage_date = CommonBean.checkForNull(record[10]);

              if ("C".equals(eventStatus) && (("Y".equals(multibirthvalue) && "N".equals(finalize_yn) && "MAINTAIN_BIRTH".equals(module_id)) || ("MAINTAIN_BIRTH".equals(module_id) && "Y".equals(finalize_yn)))) {

            	  disableRadioButtons = true;
       	        shouldCheckLastMenstrualPeriod = false;
       	        shouldCheckUnsureOfDate = false;
              
              }

                // If any event status is Active, do not check the radio button by default
                if ("A".equals(eventStatus) && delivery_miscarrage_type.equals("") && delivery_miscarrage_date.equals("")) {
                    shouldCheckLastMenstrualPeriod = false; // Don't check by default
                }
                else
                {
                	 shouldCheckLastMenstrualPeriod = true; // Don't check by default
                }
            }
        } else {
            // No records means the radio button should be checked by default
            shouldCheckLastMenstrualPeriod = true;
        }
    }
%>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
    <form name='MenstrualHistDtlTopForm' id='MenstrualHistDtlTopForm'>
        <table border='0' cellspacing='0' width='50%'>
            <td class="label">
                <input type="radio" id="radio_event_L" name="radio_event" id="radio_event" onclick="selectRadio('L')" 
                	<% if (shouldCheckLastMenstrualPeriod && !disableRadioButtons) { %> checked <% } %> <% if (disableLastMenstrualPeriod || disableRadioButtons) { %> disabled <% } %> >                <fmt:message key="eCA.LastMenstrualPeriod.label" bundle="${ca_labels}"/>
            </td>
            <td class="label">
                <input type="radio" id="radio_event_U" name="radio_event" id="radio_event" onclick="selectRadio('U')" 
                	<% if (shouldCheckUnsureOfDate && !disableRadioButtons) { %> checked <% } %> <% if (disableUnsureOfDate || disableRadioButtons) { %> disabled <% } %> >                <fmt:message key="eCA.UnsureOfDate.label" bundle="${ca_labels}"/>
            </td>
            <input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
             <input type="hidden" name="episode_id" id="episode_id" value="<%= episode_id %>">    
             <input type="hidden" name="encounter_id" id="encounter_id" value="<%= encounter_id %>">    
            <input type="hidden" name="option_id" id="option_id" value="<%= option_id %>">    
            <input type="hidden" name="selectedValue" id="selectedValue" value="<%= selectedValue %>"> 
			<input type="hidden" id="called_form" name="called_form" id="called_form" value="<%=called_form%>" />
			<input type="hidden" id="function_id" name="function_id" id="function_id" value="<%=function_id%>" />
			<input type="hidden" id="finalize_yn" name="finalize_yn" id="finalize_yn" value="<%=finalize_yn%>" />
			<input type="hidden" id="module_id" name="module_id" id="module_id" value="<%=module_id%>" />
					<input type="hidden" id="multibirthvalue" name="multibirthvalue" id="multibirthvalue" value="<%=multibirthvalue%>" />
		
            
        </table>    
    </form>    
</body>
</html>

