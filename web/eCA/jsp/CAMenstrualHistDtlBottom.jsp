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

<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.Common.*,java.util.*,eCA.*,eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
    String locale = ((String)session.getAttribute("LOCALE"));
    String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) || (session.getAttribute("PREFERRED_STYLE") != "") ? (String)session.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
    request.setCharacterEncoding("UTF-8");
    request = new XSSRequestWrapper(request); //MOHE-SCF-0153
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">	
<link rel='stylesheet' type='text/css' href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src="../../eCommon/js/CommonCalendar.js"></script>		
	<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eCA/js/CAMenstrualHistDtlTrans.js'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String eventStatus = "",eventStatus_validation="",exisiting_delivery_miscarrage_type_value="",exisiting_delivery_miscarrage_date_value="",new_delivery_miscarrage_type_value="",new_delivery_miscarrage_date_value="";
    String lmp_Date="";
	String edd_Date="";
	String seld="";
	String remark_unsure="";
	String pervious_scan_gestation_days= "";
	String pervious_scan_gestation_weeks= "";

	String selm="";
	Integer gestation_poa_week = null;
	Integer gestation_poa_days = null;
	Integer scan_gestation_weeks = null;
	Integer scan_gestation_days = null;
	Integer gestation_pog_weeks = null;
	Integer gestation_pog_days = null;
	String lmp_Delivery_Miscarrage_Type="";
	String unsure_delivery_miscarrage_type="";
	String lmp_Delivery_Miscarrage_Date="",delivery_miscarrage_date_validation="";
	String unsure_delivery_miscarrage_date="";
	String remark_lmp="";
	String redd_date="";
	String  gestation_poa="";
	Integer cutOffBackdate = null;        
	Integer cutOffDeliveryDate = null;   
	Integer cutOffDeliveryLmp = null;    
	Integer cutOffMiscarriageLmp = null; 
	String pervious_remark_lmp="";
	String enableMarkAsErrorYN="N";
	String scan_gestation="";
	String delivery_miscarrage_date_value="";
	String Lmp_Date_Value="";
	String unsure_date="";
	String gestation_pog="";
	String srl_no="";
	String event="";
	String pervious_lmp_date="";
	String 	selectedValue="";
	 String selected_Values="";
	 String scan_gestation_value	="";
	 String delivery_miscarrage_type_value="";
	 String unsure_date_value	="";
	 String pervious_remark_unsure="";
   	String edd_value	="";
	 String mode="";
	  String redd_value="";
	  String remarks_value="";
     String gestation_poa_value="";
     String gestation_pog_value="";
	 String facility_id=(String) session.getValue("facility_id");
    String option_id = request.getParameter("option_id") == null ? "" : request.getParameter("option_id");
    String	mode1 =  request.getParameter("mode1")==null?"":request.getParameter("mode1");
	String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
	String episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
	String finalize_yn = request.getParameter("finalize_yn") == null ? "" : request.getParameter("finalize_yn");
	String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
	String multibirthvalue = request.getParameter("multibirthvalue") == null ? "" : request.getParameter("multibirthvalue");

	String called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");
	String function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");

    String ca_bean_id = "@CAMenstrualHistDtlTransBean";
    String ca_bean_name = "eCA.CAMenstrualHistDtlTransBean";
    CAMenstrualHistDtlTransBean bean = (CAMenstrualHistDtlTransBean)getBeanObject(ca_bean_id, ca_bean_name, request);
    ArrayList resArrayValidate = bean.getPatientPASValidation(patient_id);
    if (resArrayValidate.size() > 0) { 
    	for (int i = 0; i < resArrayValidate.size(); i++) {
            String[] validated = (String[]) resArrayValidate.get(i);
            delivery_miscarrage_date_validation		= CommonBean.checkForNull(validated[10]);
		 eventStatus_validation		= CommonBean.checkForNull(validated[14]);

    	}
    }
    
    
    ArrayList resArray2 = bean.getPatientActiveValidation(patient_id);
    if (resArray2.size() > 0) { 
    	for (int j = 0; j < resArray2.size(); j++) {
            String[] record2 = (String[]) resArray2.get(j);
            
            new_delivery_miscarrage_type_value		= CommonBean.checkForNull(record2[9]);
            new_delivery_miscarrage_date_value			= CommonBean.checkForNull(record2[10]);

    	}
    }
    
    ArrayList resArray = bean.getPatientBottomValidation(patient_id);
    if (resArray.size() > 0) { 
    	for (int i = 0; i < resArray.size(); i++) {
            String[] record = (String[]) resArray.get(i);
            selected_Values	= CommonBean.checkForNull(record[1]);
            Lmp_Date_Value			= CommonBean.checkForNull(record[2]);
            edd_value		= CommonBean.checkForNull(record[3]);
            gestation_poa_value		= CommonBean.checkForNull(record[4]); 
            scan_gestation_value			= CommonBean.checkForNull(record[5]); 
            unsure_date_value				= CommonBean.checkForNull(record[6]);
            redd_value					= CommonBean.checkForNull(record[7]);
            gestation_pog_value			= CommonBean.checkForNull(record[8]);
            delivery_miscarrage_type_value		= CommonBean.checkForNull(record[9]);
            delivery_miscarrage_date_value			= CommonBean.checkForNull(record[10]);
    		 remarks_value		= CommonBean.checkForNull(record[11]);
    		 eventStatus		= CommonBean.checkForNull(record[14]);

    	 if((delivery_miscarrage_type_value == null ||delivery_miscarrage_type_value.equals("")) && (delivery_miscarrage_date_value == null || delivery_miscarrage_date_value.equals("")) && "A".equals(eventStatus)|| ("MAINTAIN_BIRTH".equals(module_id) && "Y".equals(finalize_yn) && "C".equals(eventStatus)) || ("Y".equals(multibirthvalue) && "N".equals(finalize_yn) && "C".equals(eventStatus)))
          {
          	selectedValue = request.getParameter("selectedValue") == null ? "": request.getParameter("selectedValue");
           }
    	 else
    	 {
           	selectedValue = request.getParameter("selectedValue") == null ? "L": request.getParameter("selectedValue");

    	 }
    	}
    }
    else
    {
    	 finalize_yn = request.getParameter("finalize_yn") == null ? "" : request.getParameter("finalize_yn");
    	 module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");

	    if ("MAINTAIN_BIRTH".equals(module_id) && "Y".equals(finalize_yn)) {
      	selectedValue = request.getParameter("selectedValue") == null ? "": request.getParameter("selectedValue");
	    }else{
	      selectedValue = request.getParameter("selectedValue") == null ? "L": request.getParameter("selectedValue");
	    }
    }
    
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
	 

	  	if(mode1.equals("modify")){
	    option_id = request.getParameter("option_id") == null ? "": request.getParameter("option_id");
	    lmp_Date = request.getParameter("lmp_Date") == null ? "": request.getParameter("lmp_Date");
	    pervious_lmp_date=lmp_Date;
	    edd_Date = request.getParameter("edd_Date") == null ? "": request.getParameter("edd_Date");
	    gestation_poa = request.getParameter("gestation_poa") == null ? "" : request.getParameter("gestation_poa");
	    srl_no = request.getParameter("srl_no") == null ? "" : request.getParameter("srl_no");
    	if (gestation_poa != null && gestation_poa.length() > 0){
	    String[] parts = gestation_poa.split(" ");
		  	gestation_poa_week = Integer.parseInt(parts[0]); 
		  	gestation_poa_days = Integer.parseInt(parts[2]); 
    	}
    	
		  	lmp_Delivery_Miscarrage_Type = request.getParameter("lmp_Delivery_Miscarrage_Type") == null ? "" : request.getParameter("lmp_Delivery_Miscarrage_Type");
		    lmp_Delivery_Miscarrage_Date = request.getParameter("lmp_Delivery_Miscarrage_Date") == null ? "" : request.getParameter("lmp_Delivery_Miscarrage_Date");
		    remark_lmp = request.getParameter("remark_lmp") == null ? "" : request.getParameter("remark_lmp");
		    pervious_remark_lmp=remark_lmp;
	    scan_gestation = request.getParameter("scan_gestation") == null ? "" : request.getParameter("scan_gestation");
	    	if (scan_gestation != null && scan_gestation.length() > 0){
   			String[] part1 = scan_gestation.split(" ");
		  	scan_gestation_weeks = Integer.parseInt(part1[0]); 
		  	scan_gestation_days = Integer.parseInt(part1[2]); 
		    pervious_scan_gestation_weeks=String.valueOf(scan_gestation_weeks);
		
		    pervious_scan_gestation_days=String.valueOf(scan_gestation_days);
	

	    	}
	    unsure_date = request.getParameter("unsure_date") == null ? "" : request.getParameter("unsure_date");
	    redd_date = request.getParameter("redd_date") == null ? "" : request.getParameter("redd_date");
	    unsure_delivery_miscarrage_type = request.getParameter("unsure_delivery_miscarrage_type") == null ? "" : request.getParameter("unsure_delivery_miscarrage_type");

	    unsure_delivery_miscarrage_date = request.getParameter("unsure_delivery_miscarrage_date") == null ? "" : request.getParameter("unsure_delivery_miscarrage_date");

	    remark_unsure = request.getParameter("remark_unsure") == null ? "" : request.getParameter("remark_unsure");
	    pervious_remark_unsure=remark_unsure;

	    gestation_pog = request.getParameter("gestation_pog") == null ? "" : request.getParameter("gestation_pog");

	    if (gestation_pog != null && gestation_pog.length() > 0){
	  		 String[] part2 = gestation_pog.split(" ");
		  	gestation_pog_weeks = Integer.parseInt(part2[0]); 
		 
		  	gestation_pog_days = Integer.parseInt(part2[2]); 
    	}
	     encounter_id = request.getParameter("encounter_id") == null ? "" : request.getParameter("encounter_id");
		 episode_id = request.getParameter("episode_id") == null ? "" : request.getParameter("episode_id");
		 called_form = request.getParameter("called_form") == null ? "" : request.getParameter("called_form");
		 module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
		 eventStatus = "A";

		 ArrayList resArray1 = bean.getPatientActiveValidation(patient_id);
		    if (resArray1.size() > 0) { 
		    	for (int i = 0; i < resArray1.size(); i++) {
		            String[] record1 = (String[]) resArray1.get(i);
		            
		            exisiting_delivery_miscarrage_type_value		= CommonBean.checkForNull(record1[9]);
		            exisiting_delivery_miscarrage_date_value			= CommonBean.checkForNull(record1[10]);

		    	}
		    }
		    
	    } else {
		mode = "insert";
	}
%>
<form name='MenstrualHistDtlBottomForm' id='MenstrualHistDtlBottomForm'>
<%if(selectedValue.equals("L")){%>
    <table width='100%' align='center'>
        <tr>
            <td class='columnheader' colspan="4">
                <fmt:message key="eCA.LastMenstrualPeriod.label" bundle="${ca_labels}"/>
            </td>
        </tr>
        <tr>
            <td width="100%" class="Border" align='center' colspan="4">
                <table border="0" width='100%' align='center'>
                    <tr>
                        <td class="label"><fmt:message key="eCA.LMP.label" bundle="${ca_labels}"/></td>
                        <td ><input type=textbox size=11 maxlength=10  id='lmpDate' name='lmpDate' id='lmpDate' value="<%=lmp_Date%>" onblur='return Check_Date(this,"DMY","<%=locale%>"),loadLmpDate();' OnKeyPress='return CheckForNumsAndColon(event)' ><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('lmpDate');" style='cursor:pointer'><img src='../../eCommon/images/mandatory.gif'></td>
						<td><span class='label' style='color: red; white-space: nowrap; display: inline;'>Note: EDD and Gestation (POA) are auto-calculated based on LMP date according to Naegele's Rule.</span></td>
                    </tr>
                        <tr>
                    <td></td>
                    </tr>
                    <tr>
                        <td class='label'><fmt:message key="eCA.EDD.label" bundle="${ca_labels}"/></td>
                        <td><input type='text' id='eddDate' name='eddDate' id='eddDate' size='8'   value="<%=edd_Date%>"  disabled></td>
                        <td  class="label">
                            <fmt:message key="eCA.GestationPOA.label" bundle="${ca_labels}"/>
                            <input type='text' id='gestationPoaWeek' name='gestationPoaWeek' id='gestationPoaWeek' size='6'  maxlength='2' value="<%=(gestation_poa_week != null ? gestation_poa_week : "")%>"     onblur="" disabled>
                            <fmt:message key="Common.weeks.label" bundle="${common_labels}"/>
                            <input type='text' id='gestationPoaDays' name='gestationPoaDays' id='gestationPoaDays' size='6'  maxlength='2' value="<%=(gestation_poa_days != null ? gestation_poa_days : "")%>"     onblur="" disabled>
                            <fmt:message key="Common.days.label" bundle="${common_labels}"/>
                        </td>
                    </tr>
                        <tr>
                    <td></td>
                    </tr>
                    <tr>
                        <td class='label'><fmt:message key="eCA.DeliveryMiscarrage.label" bundle="${ca_labels}"/></td>
                       <td>
 						 <%if(module_id.equals("REGISTER_NEWBORN") || module_id.equals("MAINTAIN_BIRTH")){ %>  
 						<input type="text" id="lmpDeliveryMiscarrageType" name="lmpDeliveryMiscarrageType" id="lmpDeliveryMiscarrageType"  value="<fmt:message key='eCA.delivery.label' bundle='${ca_labels}'/>"  disabled>
                        <input type="hidden" id="lmpDeliveryMiscarrageType" name="lmpDeliveryMiscarrageType" id="lmpDeliveryMiscarrageType" value="D" />
    					<%}else{ %>
    					<select id='lmpDeliveryMiscarrageType' name='lmpDeliveryMiscarrageType' id='lmpDeliveryMiscarrageType' onchange='toggleDeliveryMiscarrageDate();' disabled>
       					 <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
        				<option value='D' <%= "D".equals(lmp_Delivery_Miscarrage_Type) ? "selected" : "" %> >
           				 <fmt:message key="eCA.delivery.label" bundle="${ca_labels}"/>
        				</option>
        				<option value='M' <%= "M".equals(lmp_Delivery_Miscarrage_Type) ? "selected" : "" %> >
            			<fmt:message key="eCA.miscarrage.label" bundle="${ca_labels}"/>
        				</option>
    					</select>
    					<%}%>
						</td>
                         <td class="label"><fmt:message key="eCA.deliveryMiscarrageDate.label" bundle="${ca_labels}"/>&nbsp;&nbsp;&nbsp;
                         <%if(module_id.equals("REGISTER_NEWBORN") || module_id.equals("MAINTAIN_BIRTH")){ %>
                          <input type=textbox size='11' maxlength='10'  id='lmpDeliveryMiscarrageDate' name='lmpDeliveryMiscarrageDate' id='lmpDeliveryMiscarrageDate' value="<%=lmp_Delivery_Miscarrage_Date%>" onblur='return Check_Date1(this,"DMY","<%=locale%>"),dateValidation();' OnKeyPress='return CheckForNumsAndColon1(event)'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="if (!document.getElementById('lmpDeliveryMiscarrageDate').disabled) { return showCalendarValidate1('lmpDeliveryMiscarrageDate'); } else { return false; }" ><img src='../../eCommon/images/mandatory.gif' id='mandatoryIcon' style='display:none'>                        
                        <%}else{ %>
                         <input type=textbox size='11' maxlength='10'  id='lmpDeliveryMiscarrageDate' name='lmpDeliveryMiscarrageDate' id='lmpDeliveryMiscarrageDate' value="<%=lmp_Delivery_Miscarrage_Date%>" onblur='return Check_Date1(this,"DMY","<%=locale%>"),dateValidation();' OnKeyPress='return CheckForNumsAndColon1(event)' disabled><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="if (!document.getElementById('lmpDeliveryMiscarrageDate').disabled) { return showCalendarValidate1('lmpDeliveryMiscarrageDate'); } else { return false; }" ><img src='../../eCommon/images/mandatory.gif' id='mandatoryIcon' style='display:none'>                        
                        <%} %>
                         </td>   
                    </tr>
                    <tr>
                    <td></td>
                    </tr>
                    <tr>
                        <td class='label'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
                        <td colspan="3"><textarea id="remarkLmp" name='remarkLmp' rows='2' cols='80' maxlength='150' onblur="remarksvalidation();"><%=remark_lmp%></textarea></td>
                    </tr>
                    <tr>
                    <td></td>
                     <td colspan="4" style="text-align: center;">
                            <input type='button' name='record' id='record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onClick='apply();'>
                            <input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearAll();'>
                            <%if(mode1.equals("modify") && enableMarkAsErrorYN.equals("Y")){ %>
    						<input type='button' name='markAsError' id='markAsError' value='<fmt:message key="eCA.markAsError.label" bundle="${ca_labels}"/>' class='button' onClick='markAsErrorRecord();'>
                            <%} %>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
 <%}%>
 
 
<% if(selectedValue.equals("U")) { %>

<table width='100%' align='center'>
    <tr>
        <td colspan="5" class="columnheader">
            <fmt:message key="eCA.UltraSoundScan.label" bundle="${ca_labels}" />
        </td>
    </tr>
        <tr>
        <td></td>
      </tr>
    <tr>
        <td class="label" style="width: 15%; white-space: nowrap;">
            <fmt:message key="eCA.ScanGestation.label" bundle="${ca_labels}" />
        </td>
        <td class="label" style="width: 20%; white-space: nowrap;">
            <input type="text" id="scanGestationWeeks" name="scanGestationWeeks" id="scanGestationWeeks" size="4"  class="NUMBER" maxlength='2'   onblur='unSureDate(this);' value="<%=(scan_gestation_weeks != null ? scan_gestation_weeks : "")%>" onKeyPress="return isValidInteger(this);">
            <fmt:message key="Common.weeks.label" bundle="${common_labels}" />
            <input type="text" id="scanGestationDays" name="scanGestationDays" id="scanGestationDays" size="4"  class="NUMBER" maxlength='2'  onblur='unSureDate(this);' value="<%=(scan_gestation_days != null ? scan_gestation_days : "")%>" onKeyPress="return isValidInteger(this);">
            <fmt:message key="Common.days.label" bundle="${common_labels}" />
            <img src="../../eCommon/images/mandatory.gif" alt="Mandatory" class="mandatory">
        </td>
        <td class="label" style="width: 10%; padding-left: 20px;">
            <fmt:message key="eCA.LMP.label" bundle="${ca_labels}" />&nbsp;&nbsp;&nbsp;
            <input type="text" id="unsureDate" name="unsureDate" id="unsureDate" size="8" value="<%=unsure_date%>" disabled>
        </td>
        <td style="width: 35%;">
            <span class="label" style="color: red; white-space: nowrap;">
                Note: LMP date, REDD, and Gestation (POG) are auto-calculated based on Scan Gestation according to Naegele's Rule.
            </span>
        </td>
    </tr>
     <tr>
        <td></td>
      </tr>
    <tr style="padding-top: 10px;">
        <td class="label">
            <fmt:message key="eCA.REDD.label" bundle="${ca_labels}" />
        </td>
        <td>
            <input type="text" id="redd" name="redd" id="redd" size="8" value="<%=redd_date%>" disabled>
        </td>
        <td colspan="3">
            <table width="100%">
                <tr>
                    <td class="label" style="width: 25%;">
                        <fmt:message key="eCA.GestationPOG.label" bundle="${ca_labels}" />
                        <input type="text" id="gestationPogWeeks" name="gestationPogWeeks" id="gestationPogWeeks" size="6" value="<%=(gestation_pog_weeks != null ? gestation_pog_weeks : "")%>" disabled>
                        <fmt:message key="Common.weeks.label" bundle="${common_labels}" />
                        <input type="text" id="gestationPogDays" name="gestationPogDays" id="gestationPogDays" size="6" value="<%=(gestation_pog_days != null ? gestation_pog_days : "")%>" disabled>
                        <fmt:message key="Common.days.label" bundle="${common_labels}" />
                    </td>
                    <td style="width: 25%;"></td>
                </tr>
            </table>
        </td>
    </tr>
     <tr>
        <td></td>
      </tr>
    <tr style="padding-top: 10px;">
        <td class="label" style="white-space: nowrap;">
            <fmt:message key="eCA.DeliveryMiscarrage.label" bundle="${ca_labels}" />
        </td>
          <td>
			<%if(module_id.equals("REGISTER_NEWBORN") || module_id.equals("MAINTAIN_BIRTH")){ %>
          <input type="text" id="unsureDeliveryMiscarrageType" name="unsureDeliveryMiscarrageType" id="unsureDeliveryMiscarrageType"  value="<fmt:message key='eCA.delivery.label' bundle='${ca_labels}'/>"  disabled>
          <input type="hidden" id="unsureDeliveryMiscarrageType" name="unsureDeliveryMiscarrageType" id="unsureDeliveryMiscarrageType" value="D" />
          
        <%}else{ %>
    	<select id='unsureDeliveryMiscarrageType' name='unsureDeliveryMiscarrageType' id='unsureDeliveryMiscarrageType' onchange='toggleUnSureDeliveryMiscarrageDate();' disabled>
       	 <option value=''>-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
        <option value='D' <%= "D".equals(unsure_delivery_miscarrage_type) ? "selected" : "" %> >
        <fmt:message key="eCA.delivery.label" bundle="${ca_labels}"/>
        </option>
        <option value='M' <%= "M".equals(unsure_delivery_miscarrage_type) ? "selected" : "" %> >
         <fmt:message key="eCA.miscarrage.label" bundle="${ca_labels}"/>
        </option>
    	</select>
    	<%} %>
		</td>
        <td class="label" style="width: 25%; white-space: nowrap;">
            <fmt:message key="eCA.deliveryMiscarrageDate.label" bundle="${ca_labels}" />&nbsp;&nbsp;&nbsp;
			<%if(module_id.equals("REGISTER_NEWBORN") || module_id.equals("MAINTAIN_BIRTH")){ %>
            <input type='textbox' size='11' maxlength='10' id='unsureDeliveryMiscarrageDate' name='unsureDeliveryMiscarrageDate' id='unsureDeliveryMiscarrageDate' value="<%=unsure_delivery_miscarrage_date%>" onblur='return Check_Date2(this,"DMY","<%=locale%>"),dateValidation1();' OnKeyPress='return CheckForNumsAndColon(event);'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="if (!document.getElementById('unsureDeliveryMiscarrageDate').disabled) { return showCalendarValidate1('unsureDeliveryMiscarrageDate'); } else { return false; }" ><img src='../../eCommon/images/mandatory.gif' id='mandatoryIcons' style='display:none'>
       <%}else{ %>
        <input type='textbox' size='11' maxlength='10' id='unsureDeliveryMiscarrageDate' name='unsureDeliveryMiscarrageDate' id='unsureDeliveryMiscarrageDate' value="<%=unsure_delivery_miscarrage_date%>" onblur='return Check_Date2(this,"DMY","<%=locale%>"),dateValidation1();' OnKeyPress='return CheckForNumsAndColon(event);' disabled><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="if (!document.getElementById('unsureDeliveryMiscarrageDate').disabled) { return showCalendarValidate1('unsureDeliveryMiscarrageDate'); } else { return false; }" ><img src='../../eCommon/images/mandatory.gif' id='mandatoryIcons' style='display:none'>
       <%} %>
        </td>
        <td></td>
    </tr>
     <tr>
        <td></td>
      </tr>
    <tr style="padding-top: 10px;">
        <td class="label">
            <fmt:message key="Common.remarks.label" bundle="${common_labels}" />
        </td>
        <td colspan="4">
            <textarea  id="remarkUnsure" name="remarkUnsure" rows="2" cols="80" maxlength="150" style="width: 40%;" onblur="remarksvalidation1();"><%=remark_unsure%></textarea>
        </td>
    </tr>
     <tr>
        <td></td>
      </tr>
      <tr>
      <td></td>
   		<td colspan="4" style="text-align: center;">
    	<input type='button' name='record' id='record' value='<fmt:message key="Common.record.label" bundle="${common_labels}"/>' class='button' onClick='apply1();'>
    	<input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clear1();'>
    <% if(mode1.equals("modify") && enableMarkAsErrorYN.equals("Y")) { %>
    <input type='button' name='markAsError' id='markAsError' value='<fmt:message key="eCA.markAsError.label" bundle="${ca_labels}"/>' class='button' onClick='markAsErrorRecord();'>
    <% } %>
	</td>

      </tr>
              
</table>
<% } %>


	<input type='hidden'  name='lmp_Date' id='lmp_Date' value="<%=lmp_Date%>">
    <input type='hidden' name='edd_Date' id='edd_Date' value="<%=edd_Date%>">
    <input type='hidden' name='gestation_poa_week' id='gestation_poa_week' value="<%=gestation_poa_week != null ? gestation_poa_week.toString() : ""%>">
    <input type='hidden' name='gestation_poa_days' id='gestation_poa_days' value="<%=gestation_poa_days != null ? gestation_poa_days.toString() : ""%>">
    <input type='hidden' name='scan_gestation_weeks' id='scan_gestation_weeks' value="<%=scan_gestation_weeks != null ? scan_gestation_weeks.toString() : ""%>">
    <input type='hidden' name='scan_gestation_days' id='scan_gestation_days' value="<%=scan_gestation_days != null ? scan_gestation_days.toString() : ""%>">
    <input type='hidden' name='gestation_pog_weeks' id='gestation_pog_weeks' value="<%=gestation_pog_weeks != null ? gestation_pog_weeks.toString() : ""%>">
    <input type='hidden' name='gestation_pog_days' id='gestation_pog_days' value="<%=gestation_pog_days != null ? gestation_pog_days.toString() : ""%>">
    <input type='hidden' name='lmp_delivery_miscarrage_type' id='lmp_delivery_miscarrage_type' value="<%=lmp_Delivery_Miscarrage_Type%>">
    <input type='hidden' name='unsure_delivery_miscarrage_type' id='unsure_delivery_miscarrage_type' value="<%=unsure_delivery_miscarrage_type%>">
    <input type='hidden' name='lmp_Delivery_Miscarrage_Date' id='lmp_Delivery_Miscarrage_Date' value="<%=lmp_Delivery_Miscarrage_Date%>">
    <input type='hidden' name='unsure_Delivery_Miscarrage_Date' id='unsure_Delivery_Miscarrage_Date' value="<%=unsure_delivery_miscarrage_date%>">
    <input type='hidden'  name='remark_Unsure' id='remark_Unsure' value="<%=remark_unsure%>">
   <input type='hidden'  name='remark_Lmp' id='remark_Lmp' value="<%=remark_lmp%>">
    <input type='hidden' name='redd_date' id='redd_date' value="<%=redd_date%>">
    <input type='hidden'  name='unsure_date' id='unsure_date' value="<%=unsure_date%>">
     <input type="hidden"  id="selectedValue" name="selectedValue" id="selectedValue" value="<%= selectedValue %>">
	<input type="hidden" name="patient_id" id="patient_id" value="<%= patient_id %>">
	<input type="hidden" name="option_id" id="option_id" value="<%= option_id %>">
	<input type='hidden'   id='mode1' name='mode1' id='mode1' value='<%=mode1%>'>
	<input type="hidden" id="cutOffBackdate"  name="cutOffBackdate" id="cutOffBackdate" value="<%= cutOffBackdate %>" />
	<input type="hidden" id="cutOffDeliveryDate" name="cutOffDeliveryDate" id="cutOffDeliveryDate" value="<%= cutOffDeliveryDate %>" />
	<input type="hidden" id="cutOffDeliveryLmp" name="cutOffDeliveryLmp" id="cutOffDeliveryLmp" value="<%= cutOffDeliveryLmp %>" />
	<input type="hidden" id="cutOffMiscarriageLmp" name="cutOffMiscarriageLmp" id="cutOffMiscarriageLmp" value="<%= cutOffMiscarriageLmp %>" />
	<input type="hidden" id="enableMarkAsErrorYN" name="enableMarkAsErrorYN" id="enableMarkAsErrorYN" value="<%= enableMarkAsErrorYN %>" />
	<input type="hidden" id="delivery_miscarrage_type_value" name="delivery_miscarrage_type_value" id="delivery_miscarrage_type_value" value="<%= new_delivery_miscarrage_type_value %>" />
	<input type="hidden" id="selected_Values" name="selected_Values" id="selected_Values" value="<%=selected_Values %>" />
	<input type="hidden" id="delivery_miscarrage_date_value" name="delivery_miscarrage_date_value" id="delivery_miscarrage_date_value" value="<%=new_delivery_miscarrage_date_value %>" />
	<input type="hidden" id="srl_no" name="srl_no" id="srl_no" value="<%=srl_no %>" />
	<input type="hidden" id="encounter_id" name="encounter_id" id="encounter_id" value="<%=encounter_id%>"/>
	<input type="hidden" id="episode_id" name="episode_id" id="episode_id" value="<%=episode_id%>" />
	<input type="hidden" id="pervious_lmp_date" name="pervious_lmp_date" id="pervious_lmp_date" value="<%=pervious_lmp_date %>" />
	<input type="hidden" id="pervious_remark_lmp" name="pervious_remark_lmp" id="pervious_remark_lmp" value="<%=pervious_remark_lmp %>" />
	<input type="hidden" id="pervious_scan_gestation_weeks" name="pervious_scan_gestation_weeks" id="pervious_scan_gestation_weeks" value="<%=pervious_scan_gestation_weeks %>" />
	<input type="hidden" id="pervious_scan_gestation_days" name="pervious_scan_gestation_days" id="pervious_scan_gestation_days" value="<%=pervious_scan_gestation_days %>" />
	<input type="hidden" id="pervious_remark_unsure" name="pervious_remark_unsure" id="pervious_remark_unsure" value="<%=pervious_remark_unsure %>" />
	<input type="hidden" id="called_form" name="called_form" id="called_form" value="<%=called_form%>" />
	<input type="hidden" id="function_id" name="function_id" id="function_id" value="<%=function_id%>" />
	<input type="hidden" id="finalize_yn" name="finalize_yn" id="finalize_yn" value="<%=finalize_yn%>" />
	<input type="hidden" id="module_id" name="module_id" id="module_id" value="<%=module_id%>" />
	<input type="hidden" id="multibirthvalue" name="multibirthvalue" id="multibirthvalue" value="<%=multibirthvalue%>" />
	<input type="hidden" id="delivery_miscarrage_date_validation" name="delivery_miscarrage_date_validation" id="delivery_miscarrage_date_validation" value="<%=delivery_miscarrage_date_validation%>" />
	<input type="hidden" id="eventStatus_validation" name="eventStatus_validation" id="eventStatus_validation" value="<%=eventStatus_validation%>" />
	<input type="hidden" id="exisiting_delivery_miscarrage_date_value" name="exisiting_delivery_miscarrage_date_value" id="exisiting_delivery_miscarrage_date_value" value="<%=exisiting_delivery_miscarrage_date_value%>" />
    <input type="hidden" id="exisiting_delivery_miscarrage_type_value" name="exisiting_delivery_miscarrage_type_value" id="exisiting_delivery_miscarrage_type_value" value="<%=exisiting_delivery_miscarrage_type_value%>" />
	 <input type="hidden" id="eventStatus" name="eventStatus" id="eventStatus" value="<%=eventStatus%>" />
	
</form>
<Script>
var module_id =  document.getElementById('module_id').value;
var eventStatus =  document.getElementById("eventStatus").value;

if(module_id!="REGISTER_NEWBORN" && module_id!="MAINTAIN_BIRTH"){
unSurucheckFields();
}

if (module_id == "REGISTER_NEWBORN" || module_id == "MAINTAIN_BIRTH") {
    var unsureDeliveryMiscarrageDate = document.getElementById('unsureDeliveryMiscarrageDate');
    if(unsureDeliveryMiscarrageDate){
    unsureDeliveryMiscarrageDate.disabled = true;
    }// Disable the date input field
}

if ((module_id === "REGISTER_NEWBORN" || module_id === "MAINTAIN_BIRTH") && eventStatus === "A") {
	var unsureDeliveryMiscarrageDate = document.getElementById('unsureDeliveryMiscarrageDate');
    var mandatoryIcons = document.getElementById('mandatoryIcons');
    if(mandatoryIcons){
    mandatoryIcons.style.display = 'inline';
    }
    if(unsureDeliveryMiscarrageDate){
    unsureDeliveryMiscarrageDate.disabled = false; // Disable the date input field
    }
}
</Script>
<Script>
var module_id =  document.getElementById('module_id').value;
if(module_id!="REGISTER_NEWBORN" && module_id!="MAINTAIN_BIRTH"){
checkFields();
}

if (module_id == "REGISTER_NEWBORN" || module_id == "MAINTAIN_BIRTH") {
    var lmpDeliveryMiscarrageDate = document.getElementById('lmpDeliveryMiscarrageDate');
    if(lmpDeliveryMiscarrageDate){
    lmpDeliveryMiscarrageDate.disabled = true; // Disable the date input field
    }
}

if ((module_id === "REGISTER_NEWBORN" || module_id === "MAINTAIN_BIRTH") && eventStatus === "A") {
    var lmpDeliveryMiscarrageDate = document.getElementById('lmpDeliveryMiscarrageDate');
    var mandatoryIcon = document.getElementById('mandatoryIcon');
    if(mandatoryIcon){
    mandatoryIcon.style.display = 'inline';
    }
    
    if(lmpDeliveryMiscarrageDate){
    lmpDeliveryMiscarrageDate.disabled = false;  // Disable the date input field
    }
}
</Script>
</body>
</html>

