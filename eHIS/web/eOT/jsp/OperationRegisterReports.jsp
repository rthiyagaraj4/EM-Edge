<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  contentType="text/html;charset=UTF-8"%>             
<% 
	String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>    
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>

<%
	String operationType_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationType.Label","ot_labels");
	String speciality_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String diagnosis_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String anesthetist_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String Procedure_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String status_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");	
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String strPatientId = checkForNull(request.getParameter("p_patient_id"));
	String surgery_date = "";
	String strPatientName="";
	if(facility_id == null) facility_id="";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'   ORDER BY 2";

	String  sql_oper_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
	String  sql_oper_type = "SELECT OPER_TYPE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_TYPE_LANG_VW WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_TYPE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_anaesthetist = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String sql_status = "SELECT STATUS_CODE CODE, STATUS_DESC DESCRIPTION FROM OT_STATUS WHERE UPPER(STATUS_DESC) LIKE UPPER(?) AND UPPER(STATUS_CODE) LIKE UPPER(?) ORDER BY 2";
	String sql_diagnosis = "SELECT DIAG_CODE CODE, SHORT_DESC DESCRIPTION FROM MR_ICD_CODE WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(DIAG_CODE) LIKE UPPER(?) ORDER BY 2";

	String sql_ward="SELECT NURSING_UNIT_CODE CODE, LONG_DESC DESCRIPTION FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(NURSING_UNIT_CODE) LIKE UPPER(?) AND EFF_STATUS = 'E' ORDER BY 2 ";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	ResultSet rs = null;
	String PatIDLen="";
	con = ConnectionManager.getConnection(request);
	try{
		String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
		pstmt=con.prepareStatement(sqlLen);
		rs=pstmt.executeQuery();
			while(rs.next() && rs!=null)
			{
			PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}catch(Exception  ee){ee.printStackTrace();}
	try{		
			pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
			rst = pstmt.executeQuery();
			while(rst.next()){
				surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			}		
			if(pstmt!=null) pstmt.close();
			if(rst!=null) rst.close();
			pstmt = con.prepareStatement(sql_surgery_type);
			rst = pstmt.executeQuery();
%>

<html>
<head><title></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<script src="../../eCommon/js/common.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<script language="javascript">
  function checkval() {
		var frmObj=document.forms[0];
		if (frmObj.param18_desc.value == null || frmObj.param18_desc.value == ""){
			frmObj.param18.value = "";
			frmObj.param19.value = "";
		}
		if (((frmObj.param18.value != null) && (frmObj.param18.value !=""))
		&& ((frmObj.param19.value == null) || (frmObj.param19.value =="")))
		{
			frmObj.param19.value = frmObj.param18.value; 
		}
  } 
  
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
	//Modified against SRR20056-SCF-12442 - Submitting dummy Form 
	tmpformObj = document.dummy1;
	var locale = formObj.locale.value;
	//Added by  SRR20056-SCF-12442 @ Bangkok by MuthuN on 2/10/2014
	
	var qryStr = "SELECT  A.OPERATING_FACILITY_ID, A.OPER_NUM, sm_convert_date_2t (a.oper_date,'"+formObj.locale.value+"') oper_date /*TO_CHAR(A.OPER_DATE, 'DD/MM/YYYY')*/ , A.PATIENT_ID,  decode ('"+formObj.locale.value+"','en',B.PATIENT_NAME, NVL(B.PATIENT_NAME_LOC_LANG,B.PATIENT_NAME)) SHORT_NAME,  DECODE(B.SEX, 'M', 'Male', 'F', 'Female')  SEX,  GET_AGE(B.DATE_OF_BIRTH) AGE, B.NATIONAL_ID_NO  NRIC, A.REF_SOURCE_CODE  ,  R.SHORT_DESC RACE_DESC,  decode(A.NATURE_TYPE, 'EL', 'Elective', 'EM', 'Emergency') NATURE_TYPEM , PRE_OPER_DIAG, POST_OPER_DIAG,  H.SHORT_DESC ANESTH_DESC , C.OPER_NUM DTL_OPER_NUM, E.LONG_DESC ||'('|| J.SHORT_DESC||')'   OPER_DESC,decode(c.OPER_ADDED_IN_SURGEON_NOTES_YN,'Y','Yes','N','No') FROM  OT_POST_OPER_HDR  A,  MP_PATIENT B ,  MP_RACE R, OT_POST_OPER_DTLS C , OT_OPER_MAST E ,  AM_ANAESTHESIA H , OT_OPER_TYPE_LANG_VW  J, OT_POST_OPER_DIAG K  WHERE  J.LANGUAGE_ID='"+formObj.locale.value+"' AND A.OPERATING_FACILITY_ID  =  NVL('"+formObj.p_facility_id.value+"' ,A.OPERATING_FACILITY_ID)        AND  A.PATIENT_ID  = B.PATIENT_ID AND A.PATIENT_ID  =  NVL('"+formObj.p_patient_id.value+"',A.PATIENT_ID)  AND B.RACE_CODE = R.RACE_CODE(+)  AND A.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID(+) AND A.OPER_NUM = C.OPER_NUM(+) AND A.OPERATING_FACILITY_ID = K.OPERATING_FACILITY_ID(+) AND A.OPER_NUM = K.OPER_NUM(+) AND C.OPER_CODE = E.OPER_CODE  AND A.ANESTHESIA_CODE = H.ANAESTHESIA_CODE(+) AND  E.OPER_TYPE_CODE =  J.OPER_TYPE(+) AND A.NATURE_CODE  =  DECODE('"+formObj.param7.value+"', 'A',  A.NATURE_CODE,  '"+formObj.param7.value+"' ) AND A.SPECIALITY_CODE  BETWEEN   NVL('"+formObj.param8.value+"', A.SPECIALITY_CODE)   AND   NVL('"+formObj.param9.value+"', A.SPECIALITY_CODE) AND   TRUNC(A.OPER_DATE)   BETWEEN  TRUNC(TO_DATE('"+formObj.param1.value+"', 'dd/mm/yyyy'))   AND TRUNC(TO_DATE('"+formObj.param2.value+"', 'dd/mm/yyyy')) AND  OPER_STATUS   =  DECODE(NVL('"+formObj.param13.value+"', 'A'), 'A',  A.OPER_STATUS,  '"+formObj.param13.value+"') AND  (A.OPERATING_FACILITY_ID , A.OPER_NUM) IN (SELECT OPERATING_FACILITY_ID ,  OPER_NUM   FROM  OT_POST_OPER_DTLS Y,  OT_OPER_MAST  X   WHERE  Y.OPER_CODE  = X.OPER_CODE   AND  Y.OPER_CODE  BETWEEN   NVL('"+formObj.param3.value+"',  Y.OPER_CODE)   AND   NVL('"+formObj.param4.value+"',  Y.OPER_CODE)   AND  X.OPER_TYPE_CODE  BETWEEN  NVL('"+formObj.param5.value+"', X.OPER_TYPE_CODE)  AND NVL('"+formObj.param6.value+"', X.OPER_TYPE_CODE)  )";//AAKH-CRF-90 & MMS-CRF-199-US2

	if((formObj.param18.value!=null && formObj.param18.value!=""))
		qryStr = qryStr+" AND K.DIAG_CODE BETWEEN  NVL('"+formObj.param18.value+"', K.DIAG_CODE)  AND  NVL('"+formObj.param18.value+"', K.DIAG_CODE) " ;

    qryStr = qryStr+" ORDER BY OPER_DATE,    A.OPER_NUM, C.OPER_NUM,  A.PATIENT_ID";

   	var sql_site_name="SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID= '"+locale+"'";
	var sql_facility_name="SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID ='"+formObj.p_facility_id.value+"' ";
	var sql_report_desc="SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = '"+formObj.p_report_id.value+"' AND  MODULE_ID  = '"+formObj.p_module_id.value+"' ";

	if(formObj.param13_desc.value==null || formObj.param13_desc.value=="")
        formObj.param13_desc.value="All";
	if(formObj.param10.value==null || formObj.param10.value=="")
		formObj.param10.value="All";
	if(formObj.param18.value==null || formObj.param18.value=="")
		formObj.param18.value="All";
    if(formObj.param14.value==null || formObj.param14.value=="")
		formObj.param14.value="All";
	var fromoperationdate	=getLabel("eOT.FromOperationDate.Label","OT");
	var tooperationdate		=getLabel("eOT.ToOperationDate.Label","OT");
	var fromSpeciality		=getLabel("eOT.FromSpeciality.Label","OT");
	var tospeciality		=getLabel("eOT.ToSpeciality.Label","OT");
	var	surgeon				=getLabel("Common.Surgeon.label","Common");
	var fromProcedure		=getLabel("eOT.FromProcedure.Label","OT");
	var toprocedure			=getLabel("eOT.ToProcedure.Label","OT");
	var	diagnosis			=getLabel("Common.diagnosis.label","Common");
	var anaesthetist		=getLabel("Common.Anaesthetist.label","Common");
	var fromOperationType	=getLabel("eOT.FromOperationType.Label","OT");
	var	fromProcedure		=getLabel("eOT.FromProcedure.Label","OT");
	var toOperationType		=getLabel("eOT.ToOperationType.Label","OT");
	var status				=getLabel("Common.status.label","Common");
	
	//57891
	var p1=convertDate(formObj.param1.value,'DMY','en',locale);		
	var p2=convertDate(formObj.param2.value,'DMY','en',locale);
	//57891
	
	var header_Details = fromoperationdate+"*"+p1+"*"+tooperationdate+"*"+p2+"*"+fromSpeciality+"*"+decodeLower(formObj.param8)+"*"+tospeciality+"*"+decodeHigher(formObj.param9)+"*"+surgeon+"*"+nullSafe(formObj.param10.value)+"#"+fromProcedure+"*"+decodeLower(formObj.param3)+"*"+toprocedure+"*"+decodeHigher(formObj.param4)+"*"+diagnosis+"*"+formObj.param18.value+"*"+anaesthetist+"*"+formObj.param14.value+"#"+fromOperationType+"*"+decodeLower(formObj.param5)+"*"+toOperationType+"*"+decodeHigher(formObj.param6)+"*"+status+"*"+formObj.param13_desc.value;//57891
	// Modified against SCF-12442 - Start
	tmpformObj.header_Details.value=header_Details;
	tmpformObj.sql_site_name.value=sql_site_name;
	tmpformObj.sql_facility_name.value=sql_facility_name;
	tmpformObj.sql_report_desc.value=sql_report_desc;
	tmpformObj.qryStr.value = qryStr;
	tmpformObj.noOfCols.value = "15";
	tmpformObj.method = 'POST';
	
	tmpformObj.action='../../servlet/eOT.OtRegistryReportsServlet';
	
	tmpformObj.target = 'f_query_add_mod';
	tmpformObj.submit();
	frm.location.reload();//57891
	// Modified against SCF-12442 - End
}

function nullSafe(str){
	return (str!=null)?str:"";
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<table>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width="16%"nowrap>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> 
	  </td>
	  <td class='fields' width="41%">
	  <!-- Added against 57891 Starts -->
		  <input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');">
			<img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
		 </td>
		
	  <td class='label' width="18%"  nowrap>
		  <fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> 
	  </td>
	  <td class='fields' width="25%" >
		  <input type='text' name='param2_disp' id='param2_disp' size='8'  value='<%=surgery_date%>' onKeyPress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
			<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2_disp');">
			<img src='../../eCommon/images/mandatory.gif'></img>
			<input type='hidden' name='param2' id='param2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	<!-- Added against 57891 Ends -->			
	 </td>
	 <td width="0%" colspan='2'></td>
</tr>

<tr>
	<td class='label' width="16%" nowrap>
		<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width="41%" >
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="param3" id="param3" value=""> 
		<input type='text' name='param3_desc' id='param3_desc' size='00' title='<%=Procedure_title%>' param1 = 'param3'  param2 = 'param4' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' 
		onClick="callCommonLookup(param3_desc);" >
	</td>		
		<td class='fields' width="18%" nowrap>		
	</td>
		<td class='fields' width="25%" nowrap>		
	</td>
</tr>

<tr>
	<td class='label' width="16%" nowrap>
		<fmt:message key="eOT.OperationType.Label" bundle="${ot_labels}"/>
	</td>
     <td class='fields' width="41%" >
		<input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=operationType_title%>' param1 = 'param5'  param2 = 'param6' key ='OPER_TYPE' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
		<td class='fields' width="18%" nowrap>		
	</td>
		<td class='fields' width="25%" nowrap>		
	</td>
</tr>

<tr>
	<td class='label' width="16%">
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width="41%"  >
		 <input type='hidden' name='param9' id='param9'> 
		<input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' title='<%=speciality_title%>' param1 = 'param8'  param2 = 'param9' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param8.value='',param9.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param8_desc);" >
	</td>
		<td class='fields' width="18%" nowrap>		
	</td>
		<td class='fields' width="25%" nowrap>		
	</td>
</tr>	 

<tr>
	<td class='label' width="16%" nowrap>
		<fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width="41%"  >
		<input type='hidden' name='param19' id='param19'> 
		<input type='hidden' name='param18' id='param18'> 
		<input type='text' name='param18_desc' id='param18_desc' size='20' title='<%=diagnosis_title%>' param1 = 'param18'  param2 = 'param19' key ='DIAGNOSIS' onBlur="if(this.value!='')callCommonLookup(this); else param18.value='',param19.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='DiagnosisLookUp' id='DiagnosisLookUp' onClick="callCommonLookup(param18_desc);checkval();" >
	</td>
		<td class='fields' width="18%" nowrap>		
	</td>
		<td class='fields' width="25%" nowrap>		
	</td>
</tr>

<tr>
	<td class='label' width="16%"nowrap>
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width="41%"  >
	     <input type='hidden' name='param11' id='param11' > 
		<input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param10_desc' id='param10_desc' size='20' title='<%=surgeon_title%>' param1 = 'param10'  param2 = 'param11' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param11.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param10_desc);" >
	</td>
		<td class='fields' width="18%" nowrap>		
	</td>
		<td class='fields' width="25%" nowrap>		
	</td>
</tr>

<tr>
<td class='label' width="16%"nowrap>
	<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width="41%"  >
	    <input type='hidden' name='param15' id='param15'> 
		<input type='hidden' name='param14' id='param14'> 
		<input type='text' name='param14_desc' id='param14_desc' size='20' title='<%=anesthetist_title %>' param1 = 'param14'  param2 = 'param15' key ='ANAESTHETIST' onBlur="if(this.value!='')callCommonLookup(this); else param14.value='',param15.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='AnaesthetistLookUp' id='AnaesthetistLookUp' onClick="callCommonLookup(param14_desc);" >
	</td>
	    <td class='fields' width="18%" nowrap>
	</td>
		<td class='fields' width="25%" nowrap>	
	</td>
</tr>

<tr>
	<td class='label' width="16%" nowrap>
		<fmt:message key="Common.status.label" bundle="${common_labels}"/>
	</td>
	 <td class='fields' width="41%" nowrap >
		<input type='hidden' name='param13' id='param13'> 
		<input type='text' name='param13_desc' id='param13_desc' size='20' onBlur="if(this.value!='')searchCode(param13,param13_desc, '<%=status_title%>', document.forms[0].sql_text_5.value); else param13.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='StatusLookUp' id='StatusLookUp' onClick="searchCode(param13,param13_desc, '<%=status_title%>', document.forms[0].sql_text_5.value);" >
	</td>
		<td class='fields' width="18%" nowrap>
	</td>
		<td class='fields' width="25%" nowrap>	
	</td>
</tr>

<tr>

	<td class='label' width="16%" nowrap>
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/> 
	</td>
	<td class='fields' width="41%">
	 <select name="param7" id="param7" >  
	 <option value="A">
	<fmt:message key="Common.all.label" bundle="${common_labels}"/>  </option>
	<% while(rst.next()){ %>
		<option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg TheatreBkgStatByOtRoomReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
        if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
	
%>
	 </select>
	 <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		 <td class='fields' width="18%" nowrap>
	 </td>
		<td class='fields' width="25%" nowrap>	
	</td>
</tr>

<tr> 
<td  class='label'  width="16%">
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td align='left'>
		<input type='text' name='p_patient_id' id='p_patient_id' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value= "<%=strPatientId%>" onBlur="if(this.value!='')callPatientSearch();else clearDesc();" onKeyPress="return CheckForSpecChars(event)">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();" maxlength='70'>
	</td>
		<td class='fields' width="18%" nowrap>
	</td>
		<td class='fields' width="25%" nowrap>	
	</td>
</tr>

<tr>
	<td  class='label'  width="16%">
		<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>
	<td align='left'>
		<input type='text' name='patientname' id='patientname' maxlength='60' size='30' value= "<%=strPatientName%>" readonly>
	</td>
		<td class='label' width='18%' ></td>
</tr>

<tr>
	<td class='label' width='16%'>
		<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>
	</td>
      <td class='fields' width='41%'>
		 <input type='hidden' name='param22' id='param22' value=''> 
		 <input type='hidden' name='p_nursing_unit_code' id='p_nursing_unit_code'>
		 <!-- ML-MMOH-CRF-0752.3-US001 -->
		 <input type='text' name='param9_desc' id='param9_desc' size='67' title='<%=ward_title%>' param1 = 'p_nursing_unit_code'  param2 = 'param22' key ='WARD' onBlur="if(this.value!='')callCommonLookup(this); else param22.value='',p_nursing_unit_code.value='' " maxlength='70' onKeyPress="return CheckForSpecChars_local(event);"> 
		 <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param9_desc);" >
	</td>
	<td class='fields' width="18%" > 
		<image src='../../eOT/images/excel.gif' onClick="callExcelDisplay();" width="15" height="15" title='<fmt:message key="eOT.ReportinExcelFormat.Label" bundle="${ot_labels}"/>'  >
	</td>
	</tr>
</table>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="qryStr" id="qryStr" value="">
	<input type="hidden" name="header_Details" id="header_Details" value="">
	<input type="hidden" name="noOfCols" id="noOfCols" value="">
	<input type="hidden" name="sql_site_name" id="sql_site_name" value="">
	<input type="hidden" name="sql_facility_name" id="sql_facility_name" value="">
	<input type="hidden" name="sql_report_desc" id="sql_report_desc" value="">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROPREG">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="p_loc_type" id="p_loc_type" id="p_currn_locn"  value="N" ><!--SRR20056-SCF-15511-->
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROPREG">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_oper_procedure%>" disabled>
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_oper_type%>" disabled>
	<input type="hidden" name="z" id="z" value="<%=sql_speciality%>" disabled>
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_anaesthetist%>" disabled>
	<input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_status%>" disabled>
	<input type="hidden" name="sql_text_6" id="sql_text_6" value="<%=sql_diagnosis%>" disabled>
	<input type="hidden" name="sql_text_7" id="sql_text_7" value="<%=sql_ward%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Procedure" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>
	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Operation Type" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>
	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param8##Speciality" disabled>
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="param9" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='nursingUnitTitle' id='nursingUnitTitle' id="nursingUnitTitle" value="<%=ward_title%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param4#param3#param5#param6#param7#param8#param9#param18#param19#param10#param11#param14#param15#param13#p_patient_id#param22#p_nursing_unit_code#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id#p_loc_type">
</form>
<!-- Modified against SCF-12442 - Included dummy Form:: -->
<form name="dummy1" id="dummy1">
	<input type='hidden' name='param3' id='param3'> 
	<input type='hidden' name='param4' id='param4'> 
	<input type='hidden' name='param5' id='param5'> 
	<input type='hidden' name='param6' id='param6'> 
	<input type='hidden' name='param7' id='param7'> 
	<input type='hidden' name='param8' id='param8'> 
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="qryStr" id="qryStr" value="">
	<input type="hidden" name="header_Details" id="header_Details" value="">
	<input type="hidden" name="noOfCols" id="noOfCols" value="">
	<input type="hidden" name="sql_site_name" id="sql_site_name" value="">
	<input type="hidden" name="sql_facility_name" id="sql_facility_name" value="">
	<input type="hidden" name="sql_report_desc" id="sql_report_desc" value="">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROPREG">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROPREG">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_oper_procedure%>" disabled>
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_oper_type%>" disabled>
	<input type="hidden" name="z" id="z" value="<%=sql_speciality%>" disabled>
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_anaesthetist%>" disabled>
	<input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_status%>" disabled>
	<input type="hidden" name="sql_text_6" id="sql_text_6" value="<%=sql_diagnosis%>" disabled>
	<input type="hidden" name="sql_text_7" id="sql_text_7" value="<%=sql_ward%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
   	<input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Procedure" disabled>
   	<input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>
	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Operation Type" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>
	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param8##Speciality" disabled>
   	<input type="hidden" name="compare_to_3" id="compare_to_3" value="param9" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param4#param3#param5#param6#param7#param8#param9#param18#param19#param10#param11#param14#param15#param13#p_patient_id#param22#p_nursing_unit_code#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">
</form>
</body>
</html>

