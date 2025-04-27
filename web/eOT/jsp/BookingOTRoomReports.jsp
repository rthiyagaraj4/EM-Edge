<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- Added New file against AAKH-CRF-0071 -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8"); %>
<%	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String asst_surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AsstSurgeon.Label","ot_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	String noticedate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.BookingDaterep.Label","ot_labels");	
	
	String bean_id		= "OR_ListBean";
	String bean_name	= "eOT.OR_ListBean";
	OR_ListBean   bean  = (OR_ListBean)mh.getBeanObject(bean_id, request, bean_name);

	HashMap PatientType=new HashMap();
	HashMap OT_Notification=new HashMap();
	HashMap Surgery_Type=new HashMap();

	PatientType=(HashMap)bean.getPatientType();
	OT_Notification=(HashMap)bean.getOTNotification(facility_id);
	Surgery_Type=(HashMap)bean.getSurgeryType();
	
	Iterator PatientTypeIterator= PatientType.entrySet().iterator();
	Iterator SurgeryTypeIterator= Surgery_Type.entrySet().iterator();

	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"' ORDER BY 2";

	try{
			String	sql="SELECT TO_CHAR((SYSDATE+1), 'DD/MM/YYYY') TDATE, TO_CHAR(OT_SEC1_NOTICE_FM_TIME,'hh24:mi') SEC1_FM_TIME1,TO_CHAR(OT_SEC1_NOTICE_TO_TIME,'hh24:mi') SEC1_TO_TIME1,      TO_CHAR(OT_SEC2_NOTICE_FM_TIME,'hh24:mi') SEC2_FM_TIME1,  TO_CHAR(OT_SEC2_NOTICE_TO_TIME,'hh24:mi') SEC2_TO_TIME1,       TO_CHAR(OT_SEC3_NOTICE_FM_TIME,'hh24:mi') SEC3_FM_TIME1,  TO_CHAR(OT_SEC3_NOTICE_TO_TIME,'hh24:mi')SEC3_TO_TIME1  FROM OT_PARAM_FOR_FACILITY    WHERE OPERATING_FACILITY_ID = ?";

			String sql_patient_type = "SELECT patient_class,  short_desc  FROM am_patient_class_lang_vw WHERE patient_class IN ('IP', 'OP', 'EM', 'XT', 'DC')	and language_id =?";

			String fdate="";
			String strSecFr1="";
			String strSecFr2="";
			String strSecFr3="";
			String strSecTo1="";
			String strSecTo2="";
			String strSecTo3="";		
			fdate=com.ehis.util.DateUtils.convertDate(checkForNull(OT_Notification.get("tdate").toString()),"DMY","en",locale);	
			strSecFr1=checkForNull(OT_Notification.get("sec1_fm_time1").toString());
			strSecFr2=checkForNull(OT_Notification.get("sec2_fm_time1").toString());
			strSecFr3=checkForNull(OT_Notification.get("sec3_fm_time1").toString());
			strSecTo1=checkForNull(OT_Notification.get("sec1_to_time1").toString());
			strSecTo2=checkForNull(OT_Notification.get("sec2_to_time1").toString());
			strSecTo3=checkForNull(OT_Notification.get("sec3_to_time1").toString());		
%>
<html>
<head>
<title></title>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
<script language="Javascript" src="../../eOT/js/OTReportsLkupSQL.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
<script language="JavaScript">
	var locale = "<%= locale %>";	
	function enableCtrl(enableField1, enableField2, valField, thisObj)
	{	
		valField.value = "";
		document.getElementById("locationCode").value="";//58598
		if(thisObj.value != "")
		{
			document.getElementById(enableField1).disabled = false;
			document.getElementById(enableField2).disabled = false;
		}
		else
		{
			document.getElementById(enableField1).disabled = true; 
			document.getElementById(enableField2).disabled = true; 
		}
	}
	async function populateLocations(target,code)
	{
		//formobj=parent.frameMultiPatientOrdersHdr.document.formMultiPatientOrdersHdr;
		location_type=document.forms[0].location_type.value;
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		if(location_type!='')
		{
			localeName=document.forms[0].locale.value;
			var sql="";
			practitioner_id=document.forms[0].p_user_id.value;	
			facility_id=document.forms[0].facility_id.value;	
		if(location_type!="C")
			{			
			//if(location_type!=null && location_type=="C")
			  // location_type	= "OP";
			if(location_type!=null && location_type=="D")
				   location_type	= "DC";
				else if(location_type!=null && location_type=="E")
				   location_type	= "EM";
				else if(location_type!=null && location_type=="N")
				   location_type	= "IP";
				dataNameArray[0] = "PATIENT_CLASS";
				dataValueArray[0] = location_type;
				dataTypeArray[0] = STRING;
				dataNameArray[1] = "FACILITY_ID";
				dataValueArray[1] = facility_id;
				dataTypeArray[1] = STRING;
				dataNameArray[2] = "FACILITY_ID";
				dataValueArray[2] = facility_id;
				dataTypeArray[2] = STRING;  
			}
		if(location_type=="C")
			{
				sql=sql=document.forms[0].procedure_sql.value;
				sql=sql.replace('?',"'"+localeName+"'");
			}else
			{
				sql = document.forms[0].location_sql.value;
				for(x=0;x<5;x++)
				{
					sql=sql.replace('?',"'"+localeName+"'");
				}
				//sql=sql.replace('?',"'"+practitioner_id+"'");
			}
			
			if(location_type!=null && location_type=="D")
			{
				sql = sql.replace("##FILTER##"," and CLINIC_TYPE='Y' ");
			}
			else if(location_type!=null && location_type=="E")
			{
				sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='E' ");
			}
			else if(location_type!=null && location_type=="C")
			{
				sql = sql.replace("##FILTER##"," and CLINIC_TYPE='C' AND LEVEL_OF_CARE_IND='A' ");
			}
			else
			{
				sql = sql.replace("##FILTER##"," ");
			}
			
			argumentArray[0]   = sql;
			argumentArray[1]   = dataNameArray ;
			argumentArray[2]   = dataValueArray ;
			argumentArray[3]   = dataTypeArray ;
			if(location_type=="C")
			{
				argumentArray[4]   = "1,2";
			}
			else
			{
				argumentArray[4]   = "4,5";
			}
			argumentArray[5]   = target.value;
			argumentArray[6]   = CODE_LINK ;
			argumentArray[7]   = CODE_DESC ;
			retVal = await CommonLookup(getLabel("Common.Location.label","Common") , argumentArray );
			if(retVal !=null && retVal != "")
			{var ret1=unescape(retVal);
		 	arr=ret1.split(",");
				code.value=arr[0];
				target.value=arr[1];
				document.forms[0].locationCode.value = arr[0];
			}else{
				nationality_code.value = arr[0]; 
			nationality_desc.value = arr[1]; 
			desc.value=arr[1];
			code.value=arr[0];
				target.value = "";
				code.value = "" ;
			}
		}
}

function validDateObj(date, format, locale){
	if(date.value != ''){
		var dateValue=date.value;
		var dateArray="";
		var dateArray1;
		var checkFlag=true;
		if(format=="DMY"){
			dateArray=dateValue.split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="DMYHM"){
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
			if(dateArray1.length >1){
				var time1arr=dateArray1[1].split(":")
				if(time1arr.length==2)
				{
					var time1hr=time1arr[0]
					var time1min=time1arr[1]
					if (time1hr.length != 2 || time1min.length != 2)
					{
						 checkFlag=false;
					}
				}
			}
		}else if(format=="DMYHMS"){			
			dateArray1=dateValue.split(" ");
			dateArray=(dateArray1[0]).split("/");
			if(dateArray[2]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
			var time1arr=dateArray1[1].split(":")
			if(time1arr.length==3)
            {
				var time1hr=time1arr[0]
				var time1min=time1arr[1]
				var time1sec=time1arr[2]
				if (time1hr.length != 2 || time1min.length != 2 || time1sec.length != 2)
				{
					 checkFlag=false;
				}
			}
		}else if(format=="YY"){
			if(date==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}else if(format=="MY"){
			dateArray=dateValue.split("/");
			if(dateArray[1]==0){
				checkFlag=false;
			}else{
				if(locale=='th'){
					if(dateArray[2]<=543){
						checkFlag=false;
					}
				}
			}
		}	
		if(checkFlag){
			if(!validDate(date.value,format,locale)){
				if(top.header != null){
				//alert('318');
					alert(top.header.getMessage("INVALID_DATE_FMT", "SM"));
				}else{
				//alert('320');
					alert(getMessage("INVALID_DATE_FMT", "SM"));
				}
				date.select();
				date.focus();
				return false;
			}else{
				return true;
			}
		}else{
			var msg=getMessage("INVALID_VALUE", "COMMON");
			//alert('330');
			alert(getMessage("INVALID_DATE_FMT", "SM"));
			//alert(msg.replace('#',getLabel("Common.date.label","Common")));
			date.select();
			date.focus();
			return false;
		}
	}
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">  Commented against IN057879-->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
  <table border='0' cellpadding=3 cellspacing='0' width='100%'>
  <tr>
    <td class='label' width="21%" nowrap><fmt:message key="eOT.BookingDaterep.Label" bundle="${ot_labels}"/></td>
    <td class='fields' colspan="3"><input type='text' name='param1_disp' id='param1_disp' size='8' maxlength='10'  value='<%=fdate%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
      <img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('param1_disp');"><img src='../../eCommon/images/mandatory.gif'></img> 
      <!-- Added against IN057879 -->
      
      <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(fdate,"DMY",locale,"en")%>'></td>
  </tr>
  <tr>
    <td class='label' width="21%" ><fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
    <td class='label' width="23%" nowrap><fmt:message key="eOT.Section1.Label" bundle="${ot_labels}"/></td>
    <td class='label' width="18%" nowrap><fmt:message key="eOT.Section2.Label" bundle="${ot_labels}"/></td>
    <td class='label' width="38%" nowrap><fmt:message key="eOT.Section3.Label" bundle="${ot_labels}"/></td>
  </tr>
  <tr>
    <td class='label' width="21%" ><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
    <td class='fields' width="23%" ><input type='text' name='section1_from' id='section1_from' size='6' value="<%=strSecFr1%>"  readonly></td>
    <td class='fields' width="18%"><input type='text' name='section2_from' id='section2_from' size='6' value="<%=strSecFr2%>" readonly></td>
    <td class='fields' width="38%"><input type='text' name='section3_from' id='section3_from' size='6' value="<%=strSecFr3%>" readonly></td>
  </tr>
  <tr>
    <td class='label' width="21%" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
    <td class='fields' width="23%" ><input type='text' name='section1_to' id='section1_to' size='6' value="<%=strSecTo1%>" readonly></td>
    <td class='fields' width="18%" ><input type='text' name='section2_to' id='section2_to' size='6' value="<%=strSecTo2%>" readonly></td>
    <td class='fields' width="38%" ><input type='text' name='section3_to' id='section3_to' size='6' value="<%=strSecTo3%>" readonly></td>
  </tr>
  <tr>
    <td class='label' width="21%" nowrap><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
    <td class='fields' width="23%" ><input type='hidden' name='param8' id='param8'>
      <input type='hidden' name='param9' id='param9'>
      <input type='text' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param8'  param2 = 'param9' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookupORList(this,document.OtReportOptionsForm.P_OPER_ROOM_CODE); else from_oper_room_desc.value='',P_OPER_ROOM_CODE.value='' "  >
      <input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp'  onClick="callCommonLookupORList(from_oper_room_desc,document.OtReportOptionsForm.P_OPER_ROOM_CODE);" >
      <input type="hidden" name="P_OPER_ROOM_CODE" id="P_OPER_ROOM_CODE" value=""></td>
    <td class='label' width="18%" nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
    <td  class='fields' width="38%" ><input type='hidden' name='param14' id='param14'>
      <input type='hidden' name='param15' id='param15'>
      <input type='text' name='from_speciality_desc' id='from_speciality_desc' size='20'  title='<%=speciality_title%>' param1 = 'param14'  param2 = 'param15' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookupORList(this,document.OtReportOptionsForm.P_SPECIALITY_CODE); else from_speciality_desc.value='',P_SPECIALITY_CODE.value=''" >
      <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp'     onClick="callCommonLookupORList(from_speciality_desc,document.OtReportOptionsForm.P_SPECIALITY_CODE);"  >
      <input type="hidden" name="P_SPECIALITY_CODE" id="P_SPECIALITY_CODE" value=""></td>
  </tr>
  <tr>
    <td class='label' width="21%" nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width="23%" ><input type='hidden' name='param17' id='param17'>
      <input type='hidden' name='param16' id='param16'>
      <input type='text' name='param16_desc' id='param16_desc' size='20'title='<%=surgeon_title%>' param1 = 'param16'  param2 = 'param17' key ='SURGEON' onBlur="if(this.value!='')callCommonLookupORList(this,document.OtReportOptionsForm.surgeon); else param16.value='',surgeon.value='' " >
      <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookupORList(param16_desc,document.OtReportOptionsForm.surgeon);" >
      <input type="hidden" name="surgeon" id="surgeon" value=""></td>
    <td align="left" class="label" width="18%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
    <td class=fields width="38%"><SELECT name="location_type" id="location_type" onChange="enableCtrl('location','btnLocation',location,this);">
        <option value="">-----
        <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
        -----</option>
        <option value="C">
        <fmt:message key="Common.clinic.label" bundle="${common_labels}"/>
        </option>
        <option value='D'>
        <fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
        </option>
        <option value='E'>
        <fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
        </option>
        <option value='N'>
        <fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
        </option>
        <!--<option value='P'><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>-->
      </SELECT>
      
      <!-- ML-MMOH-CRF-0752.3-US001 -->
      
      <input type="text" name="location" id="location" onBlur="if(this.value!='')populateLocations(location,location);else location.value='',locationCode.value=''" value="" size='40' disabled=true>
      <input type="hidden" name="locationCode" id="locationCode" value="">
      <input type="button" class=button value='?' name="btnLocation" id="btnLocation" onClick="populateLocations(location,location)" disabled=true></td>
  </tr>
  <!-- Added extra against Location type and location -->
  <tr>
    <td class='label' width="21%" nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
    <td class='fields' width="23%" ><select name="param12" id="param12" id="param12" >
        <option value= "*ALL" >
        <fmt:message key="Common.all.label" bundle="${common_labels}"/>
        </option>
        <% 
			while(SurgeryTypeIterator.hasNext())
			{
				Map.Entry mapEntry = (Map.Entry) SurgeryTypeIterator.next();
		%>
        <option value='<%=mapEntry.getKey()%>'> <%=mapEntry.getValue()%> </option>
        <%   }//end of while-loop%>
      </select></td>
  </tr>
  <!-- Added extra against Location type and location -->
  <% 
	 }catch(Exception e){
			System.err.println("Err Msg NotifListByOTRoomReport.jsp "+e);
			System.err.println("Err Msg NotifListByOTRoomReport.jsp "+e.getMessage());
		}finally{
			System.err.println("Finally Block");
	}%>
  <input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
  <input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
  <input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
  <input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
  <input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
  <input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
  <input type="hidden" name="p_report_id" id="p_report_id" value="OTORLIST">
  <input type="hidden" name="pgm_id" id="pgm_id" value="OTORLIST">
  <input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_surgery_type%>" disabled>
  <input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="1" disabled>
  <input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=noticedate%>" disabled>
  <!--<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>-->
  <input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>
  <input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param8##Operation Room" disabled>
  <!--<input type="hidden" name="compare_to_1" id="compare_to_1" value="param9" disabled>-->
  <input type="hidden" name="compare_to_1" id="compare_to_1" value="P_OPER_ROOM_CODE" disabled>
  <input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param14##Speciality" disabled>
  <!--<input type="hidden" name="compare_to_2" id="compare_to_2" value="param15" disabled>-->
  <input type="hidden" name="compare_to_2" id="compare_to_2" value="P_SPECIALITY_CODE" disabled>
  <input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param10##Ward" disabled>
  <input type="hidden" name="compare_to_3" id="compare_to_3" value="param11" disabled>
  <input type='hidden' name='locale' id='locale' value="<%=locale%>">
  <input type='hidden' name="p_language_id" id="p_language_id" value="<%=locale%>">
  <input type="hidden" name="location_sql" id="location_sql" value="<%= OTRepository.getOTKeyValue("SQL_OR_AUTHORISE_ORDER_SELECT_LOCATION_LOOKUP")%>">
  <input type="hidden" name="procedure_sql" id="procedure_sql" value="<%=OTRepository.getOTKeyValue("SQL_OR_PAT_ORDER_BY_LOCN_CLINIC_MULTI_PATIENT_PROCEDURE_LOOKUP")%>">
 </table>
</form>
</body>
</html>

