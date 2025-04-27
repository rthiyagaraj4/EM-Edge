<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>

<%@ page contentType="text/html;charset=UTF-8"%>            
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>            
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>	
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String operatingRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OperatingRoom.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String surgery_date = "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	}
	catch(Exception e){
		System.err.println("Err Msg SpecimenRegisterReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
%>
<html>
<head><title></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="JavaScript" src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	var surgeon_title=getLabel("Common.Surgeon.label","Common");
	var speciality_title=getLabel("Common.speciality.label","Common");
	var operation_title=getLabel("Common.operation.label","Common");
	var fromOperationDate_title=getLabel("eOT.FromOperationDate.Label","OT");
	var toOperationDate_title=getLabel("eOT.ToOperationDate.Label","OT");
	var fromSpeciality_title=getLabel("eOT.FromSpeciality.Label","OT");
	var toSpeciality_title=getLabel("eOT.ToSpeciality.Label","OT");
	var toSpeciality_title=getLabel("eOT.ToSpeciality.Label","OT");
	var toOperationRoom_title=getLabel("eOT.ToOperationRoom.Label","OT");

function decodeLower(obj)
   {
            if ( (obj.value==null)||(obj.value=="")||(obj.value=="undefined") )
             {
                 return("LOWEST");
             }
            else
             {
                 return(obj.value);
             }
   }

   function decodeHigher(obj)
     {
            if ( (obj.value==null)||(obj.value=="")||(obj.value=="undefined") )
             {
                 return("HIGHEST");
             }
            else
             {
                 return(obj.value);
             }
   }

function callExcelDisplay(){
	var frm=window.parent.frames[1];
	formObj = document.OtReportOptionsForm;
	var locale = formObj.locale.value;
	var qryStr = "SELECT  DISTINCT  A.OPER_NUM,  TO_CHAR(B.OPER_DATE, 'DD/MM/YYYY'), B.PATIENT_ID , C.PATIENT_NAME,  DECODE(C.SEX, 'M', 'Male', 'F', 'Female') SEX,  C.NATIONAL_ID_NO , D.SHORT_DESC DEPT_DESC,  A.SPECIMEN_DTL        FROM   OT_POST_OPER_SPECIMENS  A,   OT_POST_OPER_HDR  B, MP_PATIENT C,  AM_DEPT_LANG_VW  D  WHERE D.language_id='"+locale+"' and   A.OPERATING_FACILITY_ID  =  NVL('"+formObj.facility_id.value+"', A.OPERATING_FACILITY_ID)   AND         A.OPERATING_FACILITY_ID  =  B.OPERATING_FACILITY_ID	  AND         A.OPER_NUM   =  B.OPER_NUM AND          B.PATIENT_ID  =  C.PATIENT_ID  AND      A.DEPT_CODE =  D.DEPT_CODE (+)	AND   TO_DATE(TO_CHAR(B.OPER_DATE, 'DD/MM/YYYY') , 'DD/MM/YYYY') BETWEEN  TO_DATE('"+formObj.param1.value+"', 'DD/MM/YYYY')   AND TO_DATE('"+formObj.param2.value+"', 'DD/MM/YYYY') AND   B.SPECIALITY_CODE  BETWEEN   NVL('"+formObj.param5.value+"', B.SPECIALITY_CODE)   AND  NVL('"+formObj.param6.value+"', B.SPECIALITY_CODE) AND  B.OPER_ROOM_CODE   BETWEEN   NVL('"+formObj.param3.value+"' , B.OPER_ROOM_CODE)  AND   NVL('"+formObj.param4.value+"', B.OPER_ROOM_CODE)   AND   (B.OPERATING_FACILITY_ID, B.OPER_NUM)  IN  ( SELECT OPERATING_FACILITY_ID, OPER_NUM FROM         OT_POST_OPER_PERSONNEL  WHERE PRACTITIONER_ID BETWEEN  NVL('"+formObj.param7.value+"', PRACTITIONER_ID)  AND  NVL('"+formObj.param8.value+"', PRACTITIONER_ID)) ORDER BY   TO_CHAR(B.OPER_DATE, 'DD/MM/YYYY'), A.OPER_NUM,  B.PATIENT_ID,  D.SHORT_DESC , A.SPECIMEN_DTL ";

	var sql_site_name="SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ";
	var sql_facility_name="SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID ='"+formObj.p_facility_id.value+"' ";
	var sql_report_desc="SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = '"+formObj.p_report_id.value+"' AND  MODULE_ID  = '"+formObj.p_module_id.value+"' ";
    
	if(formObj.param7.value==null || formObj.param7.value=="")
		formObj.param7.value="All";
    
	var header_Details = fromOperationDate_title+"*"+formObj.param1.value+"*"+toOperationDate_title+"*"+formObj.param2.value+"*"+fromSpeciality_title+"*"+decodeLower(formObj.param5)+"*"+toSpeciality_title+"*"+decodeHigher(formObj.param6)+"#"+"From Operation Room"+"*"+decodeLower(formObj.param3)+"*"+toOperationRoom_title+"*"+decodeHigher(formObj.param4)+"*"+surgeon_title+"*"+formObj.param7.value;
    

	formObj.sql_site_name.value=sql_site_name;
	formObj.sql_facility_name.value=sql_facility_name;
	formObj.sql_report_desc.value=sql_report_desc;	
    
	formObj.header_Details.value=header_Details;
	formObj.qryStr.value = qryStr;
	formObj.noOfCols.value = "8";
	formObj.method = 'POST';
	formObj.action='../../servlet/eOT.OtRegistryReportsServlet';
	formObj.target = 'f_query_add_mod';
	formObj.submit();
	frm.location.reload();
}
</script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>

<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">  
		  <img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	  <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>	
</tr>

<tr>
	 <td class='label' width='25%'> <fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/> </td>
      <td class='fields' width='25%'>
			<input type='hidden' name='param3' id='param3'> 
			<input type='hidden' name='param4' id='param4'> 
			<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=operatingRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' "> 
			<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
	  
	 <td class='label' width='25%'> <fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
      <td class='fields' width='25%'>
 			<input type='hidden' name='param6' id='param6'> 
			<input type='hidden' name='param5' id='param5'> 
			<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' "> 
			<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td> 
 </tr>

<tr>
	 <td class='label' width='25%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
			<input type='hidden' name='param8' id='param8'>
			<input type='hidden' name='param7' id='param7'> 
			<input type='text' name='param7_desc' id='param7_desc' size='20' title='<%=surgeon_title%>' param1 = 'param7'  param2 = 'param8' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' "> 
			<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>
		<td colspan='1'></td>
		<td class='fields' width='25%'>
		<image src='../../eOT/images/excel.gif' onClick="callExcelDisplay();" width="15" height="15" title="Report in Excel Format" >	
	</td>	 		 
</tr>

    <input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="header_Details" id="header_Details" value="">
	<input type="hidden" name="sql_site_name" id="sql_site_name" value="">
	<input type="hidden" name="sql_facility_name" id="sql_facility_name" value="">
	<input type="hidden" name="sql_report_desc" id="sql_report_desc" value="">
	<input type="hidden" name="qryStr" id="qryStr" value="">
	<input type="hidden" name="noOfCols" id="noOfCols" value="">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRREGRP">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRREGRP">
	   
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Operation Room" disabled>
	<input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
	<input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

