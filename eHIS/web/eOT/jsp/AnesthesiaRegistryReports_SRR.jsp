<!DOCTYPE html>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>

<%
	
//	String anaesthetist_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Anaesthetist.Label","ot_labels")+",";
//	String surgeon_title  =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels")+",";
//	String anaesthesiaType_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.AnaesthesiaType.Label","ot_labels")+",";
	
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String anaesthetist_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_anesth = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";	

	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"'  AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";

	String  sql_anes_type = "SELECT ANAESTHESIA_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_ANAESTHESIA_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ANAESTHESIA_CODE) LIKE UPPER(?) ORDER BY 2";	

	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY_LANG_VW B WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";

//Addded by Anitha for scf
	String sql_procedure="SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  AND  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";	
  
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
		//Modified by Muthukumar against AnesthesiaRegistry Language(Date) issue on 11-07-2011 
			//surgery_date = rst.getString("CURRENT_DATE"); //Commented by muthu
			surgery_date = com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		//Modified by Muthukumar against AnesthesiaRegistry Language issue on 11-07-2011
		}
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();	
		String sql_anest_type = "SELECT ANAESTHESIA_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_ANAESTHESIA_LANG_VW  WHERE LANGUAGE_ID = ? ORDER BY 2";

		pstmt = con.prepareStatement(sql_anest_type);		
		pstmt.setString(1,locale);
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
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
    <script language="javascript">
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
	formObj=document.OtReportOptionsForm;
	
    var male=getLabel("Common.male.label","common");
	var female=getLabel("Common.female.label","common");
	var qryStr = "SELECT  B.OPERATING_FACILITY_ID,B.OPER_NUM, TO_CHAR(B.OPER_DATE, 'DD/MM/YYYY'),  A.PATIENT_ID, decode ('"+locale+"','en',H.PATIENT_NAME, NVL(H.PATIENT_NAME_LOC_LANG,H.PATIENT_NAME)),  DECODE(H.SEX, 'M', '"+male+"', '"+female+"', 'Female')  SEX,  GET_AGE(H.DATE_OF_BIRTH) AGE, H.NATIONAL_ID_NO  NRIC, B.REF_SOURCE_CODE, G.SHORT_DESC ANESTH_DESC,  C.OPER_NUM DTLS_OPER_NUM, D.SHORT_DESC OPER_DESC ,  to_char(A.START_TIME, 'hh24:mi') start_time , to_char(A.END_TIME, 'hh24:mi') end_time   FROM  AT_ANAESTHESIA_RECORD_HDR  A, OT_POST_OPER_HDR B, OT_POST_OPER_DTLS C  , OT_OPER_MAST D ,  MP_PATIENT H , AM_ANAESTHESIA_LANG_VW G WHERE G.LANGUAGE_ID='"+locale+"' AND A.OPERATING_FACILITY_ID  =  '"+formObj.p_facility_id.value+"'   AND  A.OPERATING_FACILITY_ID = B.OPERATING_FACILITY_ID   AND A.ACCESSION_NUM = B.OPER_NUM AND B.OPERATING_FACILITY_ID = C.OPERATING_FACILITY_ID  AND B.OPER_NUM = C.OPER_NUM AND C.OPER_CODE = D.OPER_CODE AND A.PATIENT_ID = H.PATIENT_ID AND  A.ANAESTHESIA_CODE = G.ANAESTHESIA_CODE(+)  AND B.OPER_DATE   BETWEEN   TO_DATE('"+formObj.param1.value+"'||' 00:00', 'DD/MM/YYYY HH24:MI')   AND   TO_DATE('"+formObj.param2.value+"'||' 23:59' , 'DD/MM/YYYY HH24:MI')  AND  B.ANESTHESIA_CODE  =  NVL('"+formObj.param5.value+"', B.ANESTHESIA_CODE) AND  ( ( ('"+formObj.param3.value+"' IS NOT NULL OR '"+formObj.param4.value+"' IS NOT NULL)  AND  (A.OPERATING_FACILITY_ID, A.ACCESSION_NUM) IN (SELECT  OPERATING_FACILITY_ID , OPER_NUM FROM    OT_POST_OPER_PERSONNEL WHERE  (PRACTITIONER_ID = NVL('"+formObj.param3.value+"', PRACTITIONER_ID)  AND ROLE_TYPE = 'MA') AND        (PRACTITIONER_ID = NVL('"+formObj.param4.value+"', PRACTITIONER_ID)  AND ROLE_TYPE = 'OS') )  ) or  ('"+formObj.param3.value+"' IS NULL OR '"+formObj.param4.value+"' IS NULL) )     ORDER BY  TO_CHAR(B.OPER_DATE, 'DD/MM/YYYY'), B.OPER_NUM, C.OPER_NUM , A.PATIENT_ID";

	//var sql_site_name="SELECT SITE_NAME  FROM SM_SITE_PARAM";
	var sql_site_name="SELECT SITE_NAME  FROM SM_SITE_PARAM_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' ";
	var sql_facility_name="SELECT FACILITY_NAME FROM SM_FACILITY_PARAM WHERE  FACILITY_ID ='"+formObj.p_facility_id.value+"' ";
	var sql_report_desc="SELECT REPORT_DESC FROM SM_REPORT WHERE  REPORT_ID = '"+formObj.p_report_id.value+"' AND  MODULE_ID  = '"+formObj.p_module_id.value+"' ";

	if(formObj.param5.value==null || formObj.param5.value=="")
        formObj.param5.value="All";
    if(formObj.param4.value==null || formObj.param4.value=="")
        formObj.param4.value="All";
	if(formObj.param3.value==null || formObj.param3.value=="")
        formObj.param3.value="All";
	var		FromOperationDate_title = getLabel("eOT.FromOperationDate.Label","OT");
	var		ToOperationDate_title   = getLabel("eOT.ToOperationDate.Label","OT");
	var		AnaesthesiaType_title   = getLabel("eOT.AnaesthesiaType.Label","OT");
	var		Surgeon_title		= getLabel("Common.Surgeon.label","Common");
	var		Anaesthetist_title		= getLabel("Common.Anaesthetist.label","Common");
	
	var header_Details = FromOperationDate_title +"*"+formObj.param1.value+"*"+ToOperationDate_title  +"*"+formObj.param2.value+"*"+AnaesthesiaType_title+"*"+formObj.param5.value+"#"+Surgeon_title+"*"+formObj.param4.value+"*"+Anaesthetist_title+"*"+formObj.param3.value;

   
    formObj.header_Details.value=header_Details;

	formObj.sql_site_name.value=sql_site_name;
	formObj.sql_facility_name.value=sql_facility_name;
	formObj.sql_report_desc.value=sql_report_desc;	

    formObj.qryStr.value = qryStr;
	formObj.noOfCols.value = "13";
	formObj.method = 'POST';
	formObj.action='../../servlet/eOT.OtRegistryReportsServlet';
	formObj.target = 'f_query_add_mod';
	formObj.submit();
	frm.location.reload();
	
}
    </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
<table border='0' cellpadding=3 cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width="25%" nowrap>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> 
	  </td>
	  <td class='fields' width="25%">
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onBlur="CheckDate(this);"> <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	  <td class='label' width="25%" nowrap>
		<fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/>
	  </td>
	  <td class='fields' width="25%">
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onBlur="CheckDate(this);"> <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
 </tr>
 <tr>
	<td class='label'>
		<fmt:message key="eOT.FromProcedure.Label" bundle="${common_labels}"/>
	</td>
     <td class='fields'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="param3" id="param3" value=""> 
		<input type='text' name='param3_desc' id='param3_desc' size='20'  onBlur="if(this.value!='')srchCommonCode(param3,param3_desc, param4, '<%=procedure_title%>', document.forms[0].sql_text_6.value );else param3.value='' "> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="srchCommonCode(param3,param3_desc, param4, '<%=procedure_title%>', document.forms[0].sql_text_6.value );" >
	</td>

	<td class='label'>
		<fmt:message key="eOT.ToProcedure.Label" bundle="${common_labels}"/>
	</td>
     <td class='fields'>
		<input type='hidden' name='param6' id='param6' value=""> 
		<input type='hidden' name="param5" id="param5" value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='20'  onBlur="if(this.value!='')srchCommonCode(param5,param5_desc, param6, '<%=procedure_title%>', document.forms[0].sql_text_6.value );else param5.value='' "> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="srchCommonCode(param5,param5_desc, param6, '<%=procedure_title%>', document.forms[0].sql_text_6.value );" >
	</td>
 </tr>
<tr>
	<td class='label' width='25%'>
		<fmt:message key="eOT.AnaesthesiaType.Label" bundle="${ot_labels}"/>
     <td class='fields' width='25%'>
		<select name="param7" id="param7" >  
			<option value= "" ><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
		<% while(rst.next()){ %>
			  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
		<%   }//end of while-loop
            }catch(Exception e){
				System.err.println("Err Msg AnesthesiaRegistryReports.jsp "+e.getMessage());
			}finally{
				if(rst!=null)rst.close();
				if(rst!=null)pstmt.close();
				if(con!=null)
				ConnectionManager.returnConnection(con,request);
		 }
		%>
		</select>
	</td>	
</tr>
<tr>
	
	<td class='label' width='25%'>
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param9' id='param9'>
		<input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' title='<%=surgeon_title%>' param1 = 'param8'  param2 = 'param9' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param8.value='',param9.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param8_desc);" >
	</td>

	<td class='label'>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
    <td class='fields'>
		<input type='hidden' name='param11' id='param11'> 
		<input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param10_desc' id='param10_desc' size='20'   onBlur="if(this.value!='')srchCommonCode(param10,param10_desc,param11,'<%=speciality_title%>',document.forms[0].sql_text_2.value);else param10.value=''"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="srchCommonCode(param10,param10_desc,param11,'<%=speciality_title%>',document.forms[0].sql_text_2.value);" >
	</td>
</tr>
<tr>
	
			
<tr>
	<td class='label' width ="25%" nowrap>
		<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width ="25%">
		<input type='hidden' name='param13' id='param13' >
		<input type='hidden' name='param12' id='param12'> 
		<input type='text' name='param12_desc' id='param12_desc' size='15' onBlur="if(this.value!='')searchCode(param12,param12_desc,'<%=anaesthetist_title%>',document.forms[0].sql_text_1.value); else param12.value='' ">  
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="searchCode(param12,param12_desc,'<%=anaesthetist_title%>', document.forms[0].sql_text_1.value );" >
	</td>
</tr>
	

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
    <input type="hidden" name="header_Details" id="header_Details"	value="">
	<input type="hidden" name="sql_site_name" id="sql_site_name" value="">
	<input type="hidden" name="sql_facility_name" id="sql_facility_name" value="">
	<input type="hidden" name="sql_report_desc" id="sql_report_desc" value="">
	<input type="hidden" name="qryStr" id="qryStr" value="">
	<input type="hidden" name="noOfCols" id="noOfCols" value="">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="ATRANREG">
	<input type="hidden" name="pgm_id" id="pgm_id" value="ATRANREG">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_anesth%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_anes_type%>" disabled>
    <input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_speciality%>" disabled>
	<!--Addded by Anitha for scf  -->
	<input type="hidden" name="sql_text_6" id="sql_text_6" value="<%=sql_procedure%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

