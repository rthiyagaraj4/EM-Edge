<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- Created by Uma on 11/26/2009 for  IN003477-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8"%>

<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%!
private String decodeLocal(String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}

	//Duration Type
	if(objVal.trim().equalsIgnoreCase("M"))		
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
		return	returntext;
	}
	if(objVal.trim().equalsIgnoreCase("H"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
		return	returntext;
	}
	if(objVal.trim().equalsIgnoreCase("D"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Day(s).label","or_labels");
		return	returntext;
	}
	if(objVal.trim().equalsIgnoreCase("W"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Week(s).label","or_labels");
		return	returntext;
		
	}
	if(objVal.trim().equalsIgnoreCase("L"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Month(s).label","or_labels");
		return	returntext;
		
	}
	if(objVal.trim().equalsIgnoreCase("Y"))
	{
		returntext=(String)com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Year(s).label","or_labels");
		return	returntext;
		
	}
	else
	return "";
}
%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntrySearch.js"></script>
	<script language="JavaScript" src="../../eOR/js/OrderEntry.js"></script>
	<script language='javascript' src='../../eOR/js/ScheduleFrquency.js'></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="scheduleFreqencyAddModHeader" id="scheduleFreqencyAddModHeader" action="" method="post" >
<%

/* Mandatory checks start */
	String bean_id	= "OrScheduleFreq" ;
	String bean_name= "eOR.ScheduleFrequencyCompBean";
	OrderEntryBean beanEntry				= (OrderEntryBean)getBeanObject( "orderentrybean", "eOR.OrderEntryBean", request ) ;
	
	String bean_id1= beanEntry.checkForNull(request.getParameter("bean_id"));
	String bean_name1= beanEntry.checkForNull(request.getParameter("bean_name"));
	String catalog_code= beanEntry.checkForNull(request.getParameter("catalog_code"));
	String org_drug_code= beanEntry.checkForNull(request.getParameter("org_drug_code"));
	if((org_drug_code==null)||(org_drug_code.equals("null"))) org_drug_code="";
	String patient_id= beanEntry.checkForNull(request.getParameter("patient_id"));
	String encounter_id= beanEntry.checkForNull(request.getParameter("encounter_id"));
	String mode		=  "1" ;
	//String uom_code		=  "" ;
	//String strDose = "";
	String[] frequencyRecords	   = null;
	String[] recordDefault			= null;
	ArrayList Default				= null;
	ArrayList PlaceOrderFrequency	= null;
	String duration_value					   = "";
	String max_durn_value				   ="";
	String chk_for_max_durn_action  ="";
	String prompt_msg						="";
	String comments							="";
	String softStopYN						="";
	String freqLegendStyle		= "display:inline";
	int i=0;
	boolean isSchdApplicable = true;
	//HashMap schdMap = null;


	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))) )
		return ;

	String qtyDisabled		    =  ""; //Disable in modify mode

/* Mandatory checks end */

	/* Initialize Function specific start */	
	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		beanEntry				= (OrderEntryBean)getBeanObject( bean_id1, bean_name1, request ) ;
		beanEntry.setLanguageId(localeName);
		 qtyDisabled		=  "disabled";
	}

	ScheduleFrequencyCompBean bean = (ScheduleFrequencyCompBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	/* Initialize Function specific end */

	/******Caller Bean name and id*******/
	String bean_id_P			= bean.checkForNull(request.getParameter("bean_id"));
	String bean_name_P			= bean.checkForNull(request.getParameter("bean_name"));	
	
	/**************/
try
{

	/*Parameters Passed*/
	String freq_code			=bean.checkForNull( request.getParameter("freq_code"));
	//String facility_id			=bean.checkForNull( request.getParameter("facility_id"));
	String durationType_P		= bean.checkForNull(request.getParameter("interval_durn_type"));
	String pr_duration_type		= bean.checkForNull(request.getParameter("pr_duration_type")); 	
	String pr_duration		=  bean.checkForNull(request.getParameter("pr_duration"));
	String pr_duration_display		=  bean.checkForNull(request.getParameter("pr_duration"));
	if(pr_duration_display == null)
		pr_duration_display = "";
	
	if(pr_duration == null || pr_duration.equals(""))
		pr_duration = "0";
	
	
	String code					= bean.checkForNull(request.getParameter("code"));
	mode						= bean.checkForNull(request.getParameter( "mode" ),"1");
	if(mode.equalsIgnoreCase("2"))
	{
		if(catalog_code.equals(""))
		{
			catalog_code = code.substring(13);
		}
	}

	String row_value			=bean.checkForNull( request.getParameter("row_value"));	
	String module_id			= bean.checkForNull(request.getParameter("module_id"));	
 	String order_category		= bean.checkForNull(request.getParameter("order_category"));
	if(order_category.equals("")) order_category = module_id;
	String visit_adm_date		= bean.checkForNull(request.getParameter("visit_adm_date")); 	
	String future_order_date	= bean.checkForNull(request.getParameter("future_order_date"));	
 	String past_order_date		= bean.checkForNull(request.getParameter("past_order_date"));
	
	int	   indxTime				= 0;
    String start_day_param		= "";
    String start_time_param		= "";

	//Taking values for start day and time
	String start_time_day_param	= bean.checkForNull(request.getParameter("start_time_day_param"));

	if(start_time_day_param!=null && !start_time_day_param.trim().equals(""))
	{
	    indxTime				= start_time_day_param.indexOf(" ");
	    start_day_param			= start_time_day_param.substring(0,indxTime);
	    start_time_param		= start_time_day_param.substring(indxTime+1);			
	}
	
	//For Ph

	String max_qty				= bean.checkForNull(request.getParameter("max_qty"));
	String chk_max				= bean.checkForNull(request.getParameter("chk_max"));

	String unit_qty				= bean.checkForNull(request.getParameter("unit_qty"));
	String chk_unit				= bean.checkForNull(request.getParameter("chk_unit"));

	String split_dose_yn		= bean.checkForNull(request.getParameter("split_dose_yn"));
	String split_qty			= bean.checkForNull(request.getParameter("split_qty"));


	//String uom_desc				= bean.checkForNull(request.getParameter("uom_desc"));
   	//String fract_value_yn				= bean.checkForNull(request.getParameter("fract_value_yn"));
   	//String sliding_scale_yn				= bean.checkForNull(request.getParameter("sliding_scale_yn"));
	
	 
	 String daysSelected ="";
	 String weeksSelected ="";
	 String monthsSelected ="";
	 String hoursSelected ="";
	 String minutesSelected ="";
	 String yearsSelected ="";
	 String duration_opt_value ="";

	softStopYN = bean.checkForNull(bean.getSoftStopYN(catalog_code));	

	/*********BEAN OF CALLER FUNCTION IS INSTANTIATED AND VALUES FOR FREQ LOADED ****/
	Default =beanEntry.getPlaceOrderDefault(catalog_code);
	if(Default!=null)
	{
		for(int j=0;j<Default.size();j++)
		{
			recordDefault	 = ((String[])Default.get(j));
			if(recordDefault[1]==null || recordDefault[1].equals("0")) recordDefault[1] = "";
		}
	}

	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		if(durationType_P==null)durationType_P="";
		if(durationType_P.equals(""))
		{
			durationType_P = (String)beanEntry.getDurationType(freq_code);
		}
	}
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("D"))
		daysSelected = "selected";
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("W"))
		weeksSelected = "selected";
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("L"))
		monthsSelected = "selected";	
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("H"))
		hoursSelected = "selected";	
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("M"))
		minutesSelected = "selected";	
	if(durationType_P!=null && durationType_P.equalsIgnoreCase("Y"))
		yearsSelected = "selected";	
	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
		PlaceOrderFrequency = bean.getPlaceOrderFrequency(catalog_code,"header",durationType_P,order_category,"",""); // Pass the order_category and catalog_code		
		org_drug_code=catalog_code;
	}
	else
	{
		PlaceOrderFrequency = bean.getPlaceOrderFrequency(org_drug_code,"header",durationType_P,order_category,"",""); // Pass the order_category and catalog_code		
	}
%>
<table border="0" id="frequencyHeader" cellpadding=0 cellspacing=0 width="100%" class="grid">
	<tr>
		<td width="25%" class="gridHeader"  style="<%=freqLegendStyle%>" nowrap>
			<B><fmt:message key="eOR.DurationType.label" bundle="${or_labels}"/></B>
		</td>
		<td width="25%" class="gridHeader"  style="<%=freqLegendStyle%>">
			<select name="hdr_duration_type" id="hdr_duration_type" onchange="chkDurationType(this,'<%=org_drug_code%>')">
				<option value="D" <%=daysSelected%>><fmt:message key="eOR.Day(s).label" bundle="${or_labels}"/></option>
				<option value="W"  <%=weeksSelected%>><fmt:message key="eOR.Week(s).label" bundle="${or_labels}"/></option>
				<option value="L" <%=monthsSelected%>><fmt:message key="eOR.Month(s).label" bundle="${or_labels}"/></option>
			</select>
		</td>
		<td width="25%" class="gridHeader"  style="<%=freqLegendStyle%>">
			<B><fmt:message key="eOR.Frequency.label" bundle="${or_labels}"/></B>
		</td>
		<td width="25%" class="gridHeader"  style="<%=freqLegendStyle%>">
			<select name="hdr_frequency_code" id="hdr_frequency_code" onChange="setFrequency(this,<%=row_value%>,'<%=org_drug_code%>','<%=beanEntry.getLoginFacilityId()%>','onChange');">
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
			<%
				
				for(int j=0; j<PlaceOrderFrequency.size(); j++)
				{
					frequencyRecords = (String[]) PlaceOrderFrequency.get(j);
					if(freq_code!=null && freq_code.equalsIgnoreCase(frequencyRecords[2]))
					{
					%>
						<option value=<%=frequencyRecords[0]%> SELECTED><%=frequencyRecords[1]%></option>						
					<%
					}
					else
					{
					%>
						<option value=<%=frequencyRecords[0]%>><%=frequencyRecords[1]%></option>				
					<%
					}
				}						
				%>
			</select>
			<% 
					//if(recordDefault!=null) frequency_val = recordDefault[0]; else frequency_val="";	%>
			<input type="hidden" name="hdr_frequency_val" id="hdr_frequency_val" value="<%=freq_code%>">
			<input type="hidden" name="hdr_repeat_value" id="hdr_repeat_value" value="">
			<input type="hidden" name="hdr_start_date_time" id="hdr_start_date_time" value="<%=start_time_day_param%>">
			<input type="hidden" name="order_category" id="order_category" value="<%=order_category%>">
		</td>
		</tr>
		<tr>
		<td width="25%" class="gridHeader"  style="<%=freqLegendStyle%>">
			<B><fmt:message key="eOR.Duration.label" bundle="${or_labels}"/></B>
		</td>
		<td  colspan ="3" class="gridHeader"  style="<%=freqLegendStyle%>">
		<%
			if(durationType_P==null)durationType_P="D";
			if(recordDefault!=null) duration_value = recordDefault[1]; else duration_value="";
			if((duration_value==null) || (duration_value=="undefined"))duration_value = "";
			if(recordDefault!=null) max_durn_value = recordDefault[3]; else max_durn_value="";
			if(recordDefault!=null) chk_for_max_durn_action = recordDefault[5]; else chk_for_max_durn_action ="";
			if(recordDefault!=null) prompt_msg 		= recordDefault[6]; else prompt_msg="";
			if(recordDefault!=null) comments 		= bean.checkForNull(recordDefault[7],""); else comments="";
			ArrayList durationTypes = new ArrayList();
			ArrayList durationAppl = new ArrayList();
			ArrayList durationDesc = new ArrayList();
			durationTypes.add("M");
			durationTypes.add("H");
			durationTypes.add("D");
			durationTypes.add("W");
			durationTypes.add("L");
			durationTypes.add("Y");
			
			
			for(int d=durationTypes.indexOf(durationType_P);d<durationTypes.size();d++)
			{
				durationAppl.add(durationTypes.get(d));
				durationDesc.add(decodeLocal(((String)durationTypes.get(d)),pageContext));
			}
			
			//DurationDesc.put("M","
		%>
			<input type="text"  class="NUMBER" name="hdr_duration_value" id="hdr_duration_value" value="<%=pr_duration_display%>" size="2" maxLength="3" onKeyPress="return(ChkNumberInput(this,event,'0'))" onBlur='checkMaxValue(this,"<%=max_durn_value%>","<%=chk_for_max_durn_action%>",escape("<%=prompt_msg%>"),"<%=softStopYN%>","<%=i%>","<%=org_drug_code%>");'>
			<input type="hidden" class="NUMBER" name="hdr_duration_def_value" id="hdr_duration_def_value" value="<%=duration_value%>">
			<select name="hdr_duration_code" id="hdr_duration_code" onchange="populateDetail(this)">
				<%
				for(int dt=0; dt<durationAppl.size(); dt++)
				{
					duration_opt_value = (String) durationAppl.get(dt);
					if(pr_duration_type!=null && pr_duration_type.equalsIgnoreCase(duration_opt_value))
					{
					%>		
						<option value="<%=duration_opt_value%>" selected><%= (String) durationDesc.get(dt)%></option>
					<%
					}
					else
					{
					%>

						<option value="<%=duration_opt_value%>"><%= (String) durationDesc.get(dt)%></option>
				<%
					}					
				}
				%>	
			</select>
		<td>
	</tr>
</table>
<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
<input type="hidden" name="durationType" id="durationType"	value="<%=durationType_P%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="code" id="code" value="<%=request.getParameter("code")%>">
<INPUT TYPE="hidden" name="bean_id_caller" id="bean_id_caller" value="<%=bean_id_P%>">
<INPUT TYPE="hidden" name="bean_name_caller" id="bean_name_caller" value="<%=bean_name_P%>">
<INPUT TYPE="hidden" name="hdr_freq_code" id="hdr_freq_code" value="<%=freq_code%>">

<!-- For PH Only -->
<INPUT TYPE="hidden" name="max_qty" id="max_qty" value="<%=max_qty%>">
<INPUT TYPE="hidden" name="chk_max" id="chk_max" value="<%=chk_max%>">
<INPUT TYPE="hidden" name="unit_qty" id="unit_qty" value="<%=unit_qty%>">
<INPUT TYPE="hidden" name="chk_unit" id="chk_unit" value="<%=chk_unit%>">
<INPUT TYPE="hidden" name="split_dose_yn" id="split_dose_yn" value="<%=split_dose_yn%>">
<INPUT TYPE="hidden" name="split_qty" id="split_qty" value="<%=split_qty%>">


 <!-- For Order Entry Only -->
<INPUT TYPE="hidden" name="visit_adm_date" id="visit_adm_date" value="<%=visit_adm_date%>">
<INPUT TYPE="hidden" name="future_order_date" id="future_order_date" value="<%=future_order_date%>">
<INPUT TYPE="hidden" name="past_order_date" id="past_order_date" value="<%=past_order_date%>">

<!-- Start Time Param passed by order entry function -->
<INPUT TYPE="hidden" name="start_day_param" id="start_day_param" value="<%=start_day_param%>">
<INPUT TYPE="hidden" name="start_time_param" id="start_time_param" value="<%=start_time_param%>">


<INPUT TYPE="hidden" name="module_id" id="module_id" value="<%=module_id%>">
<INPUT TYPE="hidden" name="row_value" id="row_value" value="<%=request.getParameter("row_value")%>">
<INPUT TYPE="hidden" name="loadFlag" id="loadFlag"  value="YES">
<INPUT TYPE="hidden" name="dummmyDate" id="dummmyDate"  value="">
<input type="hidden" name="start_day_assign" id="start_day_assign" value="<%=start_day_param%>">
<input type="hidden" name="pr_duration" id="pr_duration" value="<%=pr_duration%>">
<input type="hidden" name="pr_duration_type" id="pr_duration_type" value="<%=pr_duration_type%>">
<input type="hidden" name="isSchdApplicable" id="isSchdApplicable" value="<%=isSchdApplicable%>">
<input type="hidden" name="hdr_freq_nature" id="hdr_freq_nature" value="F" >
<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>" >
<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>" >

<%
	if(bean_name1.equals("eOR.OrderEntryBean"))
	{
	%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id1%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name1%>">
<%
	}
	else if(bean_name1.equals("ePH.PrescriptionBean_1"))
	{
		bean_id1 = bean_id1.replace("@PrescriptionBean_1","@orderentrybean");
	%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id1%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name1%>">
	<%
	}
	else if(bean_name1.equals("ePH.DirectDispensingBean"))
	{
	%>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id1%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name1%>">
	<%
	}
}
catch(Exception e)
{
	 e.printStackTrace();
}
%>
</form>
<%
 	putObjectInBean(bean_id,bean,request);
%>
</body>

</html>





