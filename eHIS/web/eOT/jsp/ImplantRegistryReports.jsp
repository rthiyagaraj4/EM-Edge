<!DOCTYPE html>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>            
<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String procedure_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");

	String surgery_date = "";
	
	String  sql_implanttype = "SELECT A.PROSTHESIS_CODE CODE, A.SHORT_DESC DESCRIPTION FROM OT_PROSTHESIS_LANG_VW A  WHERE UPPER(A.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.PROSTHESIS_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID='"+locale+"'  ORDER BY 2";

	String  sql_implantvendor = "SELECT A.PROSTHESIS_MFR CODE, null DESCRIPTION FROM OT_SURGICAL_ACCESSORIES A  WHERE UPPER(A.PROSTHESIS_MFR) LIKE UPPER(?) ORDER BY 1";

	if(facility_id == null) facility_id="";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//surgery_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);

		}
	}
	catch(Exception e){
		System.err.println("Err Msg ImplantRegistryReports.jsp "+e.getMessage());
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
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="javascript" src="../../eOT/js/OTReportsLkupSQL.js"> </script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<!--<script language="JavaScript" src="../../eOT/js/OTMessages.js"></script>-->	
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script>
		var speciality_title=getLabel("Common.speciality.label","common");
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var implantType_title=getLabel("eOT.ImplantType.Label","OT");
		var procedure_title=getLabel("Common.Procedures.label","Common");
		
		
	</script>


<script language='javascript'>
function checkProcess(obj)
{
	var frmObj=document.forms[0];
	if(obj.checked==true)
		 frmObj.param12.value='Y'
	else
		 frmObj.param12.value='N'
		 
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
	var locale = formObj.locale.value;
	var female_value=getLabel("Common.female.label","common");
	var male_value=getLabel("Common.male.label","common");

	var qryStr="SELECT  B.OPER_NUM, TO_CHAR(B.OPER_DATE, 'DD/MM/YYYY'), B.PATIENT_ID, decode ('"+locale+"','en',PATIENT_NAME, NVL(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)) PATIENT_NAME, GET_AGE(C.DATE_OF_BIRTH) AGE,  DECODE(C.SEX, 'M', '"+male_value+"', 'F', '"+female_value+"') SEX,  C.NATIONAL_ID_NO NRIC, I.SHORT_DESC SPECIALITY,    J.SHORT_NAME , G.LONG_DESC OPER_DESC,  D.SHORT_DESC ||' '||  LTRIM(RTRIM(E.PROSTHESIS_CAT_DESC)) ||',  '|| LTRIM(RTRIM(F.PROSTHESIS_TYPE_DESC ))   PROS_CATG_TYPE,QUANTITY, DECODE(CONSIGNMENT_ITEM_YN, 'Y', 'Yes', 'N', 'No', 'No') CONSIGNMENT_ITEM_YN  ,  PROSTHESIS_MFR, substr(APPL_USER_NAME,1, 15)  RECORDING_NURSE, A.REMARKS      FROM    OT_POST_OPER_HDR  B, MP_PATIENT C,  OT_SURGICAL_ACCESSORIES  A , OT_PROSTHESIS_LANG_VW  D, OT_PROSTHESIS_CATEGORY E, OT_PROSTHESIS_TYPE_LANG_VW F , OT_OPER_MAST  G,  sm_appl_user  H , AM_SPECIALITY_LANG_VW I , AM_PRACTITIONER_LANG_VW J WHERE I.LANGUAGE_ID='"+locale+"' AND J.LANGUAGE_ID='"+locale+"' AND F.LANGUAGE_ID='"+locale+"' AND  B.OPERATING_FACILITY_ID  =  nvl('"+formObj.p_facility_id.value+"', B.OPERATING_FACILITY_ID ) AND  B.PATIENT_ID  =  C.PATIENT_ID AND B.OPERATING_FACILITY_ID = A.OPERATING_FACILITY_ID AND     B.OPER_NUM =  A.OPER_NUM AND   TRUNC(B.OPER_DATE)  BETWEEN  TRUNC(nvl(TO_DATE('"+formObj.param1.value+"','DD/MM/YYYY'), B.OPER_DATE))   AND TRUNC(nvl(TO_DATE('"+formObj.param2.value+"','DD/MM/YYYY'), B.OPER_DATE)) AND A.ACCESSORY_CODE  =  D.PROSTHESIS_CODE  AND    D.PROSTHESIS_CAT_CODE =  E.PROSTHESIS_CAT_CODE (+) AND    D.PROSTHESIS_TYPE = F.PROSTHESIS_TYPE (+) AND D.LANGUAGE_ID='"+locale+"'  AND  A.ACCESSORY_TYPE  = 'S' AND   A.OPER_CODE = G.OPER_CODE AND  A.ADDED_BY_ID = H.APPL_USER_ID(+) AND  B.SPECIALITY_CODE = I.SPECIALITY_CODE AND B.SURGEON_CODE = J.PRACTITIONER_ID(+) AND A.OPER_CODE  BETWEEN  NVL('"+formObj.param3.value+"', A.OPER_CODE )  AND NVL('"+formObj.param4.value+"', A.OPER_CODE ) AND  A.ACCESSORY_CODE  BETWEEN    NVL('"+formObj.param9.value+"', A.ACCESSORY_CODE)   AND   NVL('"+formObj.param10.value+"',  A.ACCESSORY_CODE) AND ( (A.PROSTHESIS_MFR  IS NOT NULL AND upper(A.PROSTHESIS_MFR)  =  upper(NVL('"+formObj.param11.value+"',  A.PROSTHESIS_MFR)) )  OR  (A.PROSTHESIS_MFR  IS NULL )) AND   NVL(CONSIGNMENT_ITEM_YN , 'N') =  DECODE(NVL('"+formObj.param12.value+"', 'N'),   'Y', 'Y', 'N', 'N') AND  B.SPECIALITY_CODE BETWEEN  NVL('"+formObj.param5.value+"' , B.SPECIALITY_CODE)  AND  NVL('"+formObj.param6.value+"',  B.SPECIALITY_CODE) AND  B.SURGEON_CODE BETWEEN NVL('"+formObj.param7.value+"', B.SURGEON_CODE)   AND  NVL('"+formObj.param8.value+"', B.SURGEON_CODE) ORDER BY   B.OPER_DATE , B.OPERATING_FACILITY_ID, B.OPER_NUM ";//MMS-CRF-199-US2

	var sql_site_name="SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID= '"+locale+"'";
	
	var sql_facility_name="SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID ='"+formObj.p_facility_id.value+"' ";
	var sql_report_desc="SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = '"+formObj.p_report_id.value+"' AND  MODULE_ID  = '"+formObj.p_module_id.value+"' ";
    
	if(formObj.param11.value==null || formObj.param11.value=="")
        formObj.param11.value="All";
    if(formObj.chk.checked==true)
       formObj.chk.value="Yes";
	else
       formObj.chk.value="No";
	if(formObj.chk.value==null)
       formObj.chk.value="No";
	if(formObj.param8.value==null || formObj.param8.value=="")
		formObj.param8.value="All";
	var header_Details = "From Operation Date"+"*"+formObj.param1.value+"*"+"To Operation Date"+"*"+formObj.param2.value+"*"+"From Speciality"+"*"+decodeLower(formObj.param5)+"*"+"To Speciality"+"*"+decodeHigher(formObj.param6)+"*"+"Consignment Item "+"*"+formObj.chk.value+"#"+"From Procedure"+"*"+decodeLower(formObj.param3)+"*"+"To Procedure"+"*"+decodeHigher(formObj.param4)+"*"+"Surgeon"+"*"+formObj.param8.value+"#"+"From Implant Type"+"*"+decodeLower(formObj.param9)+"*"+"To Implant Type"+"*"+decodeHigher(formObj.param10)+"*"+"Implant Vendor"+"*"+formObj.param11.value;

    formObj.header_Details.value=header_Details;

	formObj.sql_site_name.value=sql_site_name;
	formObj.sql_facility_name.value=sql_facility_name;
	formObj.sql_report_desc.value=sql_report_desc;	
   
	formObj.qryStr.value = qryStr;
	formObj.noOfCols.value = "16";
	formObj.method = 'POST';
	formObj.action='../../servlet/eOT.OtRegistryReportsServlet';
	formObj.target = 'f_query_add_mod';
	formObj.submit();
	frm.location.reload();
	//formObj.action="../../eCommon/jsp/report_options.jsp" ;
	//formObj.target="messageFrame";
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">

<table border='0' cellpadding='3' cellspacing='0' width='100%'>

<tr> 
	<td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	<td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	 <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> 
	 </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	
</tr>


<tr>
	 <td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> 
</td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=procedure_title%>' param1 = 'param3'  param2 = 'param4' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='ProcedureLookUp' id='ProcedureLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
<!-- 	<td class='label' align='right' nowrap>To Procedure </td>
	 <td align='left'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' > 
		<input type='button' class='button' value='?' name='ProcedureLookUp' id='ProcedureLookUp' onClick="searchCode(param4,param4_desc, 'To Procedure', document.forms[0].sql_text_1.value);" >
	 </td> -->
 
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> 
</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
	 	 

<!-- 	<td class='label' align='right' nowrap>To Speciality </td>
	 <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param6,param6_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td>
 	 <td colspan='2'></td> -->

</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	     <input type='hidden' name='param8' id='param8'>
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' title='<%=surgeon_title%>' param1 = 'param7'  param2 = 'param8' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>
	<!--<td class='label' align='right' nowrap>To Surgeon </td>
	 <td align='left'>
		 <input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' > 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(param8,param8_desc, 'To Surgeon', document.forms[0].sql_text_3.value);" >

	 </td>-->
	


	<td class='label' width='25%'><fmt:message key="eOT.ImplantType.Label" bundle="${ot_labels}"/> </td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param10' id='param10'> 
		<input type='hidden' name='param9' id='param9'> 
		<input type='text' name='param9_desc' id='param9_desc' size='20' onBlur="if(this.value!='')srchCommonCode(param9,param9_desc,param10,implantType_title, document.forms[0].sql_text_4.value); else param10.value='',param9.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='ImplantLookUp' id='ImplantLookUp' onClick="srchCommonCode(param9,param9_desc,param10,implantType_title, document.forms[0].sql_text_4.value);" >
	</td>
		 	 

<!-- 	<td class='label' align='right' nowrap>To Implant Type </td>
	 <td align='left'>
		 <input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param10_desc' id='param10_desc' size='20' > 
		<input type='button' class='button' value='?' name='ImplantLookUp' id='ImplantLookUp' onClick="searchCode(param10,param10_desc, 'To Implant Type', document.forms[0].sql_text_4.value);" >
	 </td> -->
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="eOT.ImplantVendor.Label" bundle="${ot_labels}"/> </td>
    <td class='fields' width='25%'>
		<input type='text' name='param11' id='param11' size='20' > 
<!-- 		  <input type='button' class='button' value='?' name='ImplantVendorLookUp' id='ImplantVendorLookUp' onClick="searchCode(param11,param11_desc, 'Implant Vendor');" > -->
	</td>
	
	<td class='label' width='25%'><fmt:message key="eOT.ConsignmentItem.Label" bundle="${ot_labels}"/> </td>
	<td class='fields' width='25%'>
		<input type ='checkbox' name ='chk' onClick='checkProcess(this)'>
		
	
	<!-- <input type="BUTTON" class="button" name="Submit" id="Submit" value='Report in Excel Format' onClick="callExcelDisplay();"> 
 </td>
  -->
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
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRIMPRY">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRIMPRY">
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_implanttype%>" disabled>
	<input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_implantvendor%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>
<!-- Validatiosn is removed for CRF-45 as per dilip instruction on 09/06/2010 -->
	<!-- <input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled> -->

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Procedure" disabled>
	<input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
	<input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>

	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param9##Implant Type" disabled>
	<input type="hidden" name="compare_to_3" id="compare_to_3" value="param10" disabled>
	<input type="hidden" name="param12" id="param12" value="N" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param4#param3#param6#param5#param7#param8#param9#param10#param11#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

