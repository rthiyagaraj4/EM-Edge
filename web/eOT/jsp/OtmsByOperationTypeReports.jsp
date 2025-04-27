<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>          
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String fromproceduredate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromProcedureDate.Label","ot_labels");
	String toproceduredate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToProcedureDate.Label","ot_labels");
	String surgery_date = "";
	
	if(facility_id == null) facility_id="";
	//Modified by Muthukumar against Statistics by Operation type/Speciality on 13-07-2011
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','SHORT_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	//Modified by Muthukumar against Statistics by Operation type/Speciality on 13-07-2011

	//Commented by Muthukumar against Statistics by Operation type/Speciality on 13-07-2011 
	/* String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, GET_DESC('"+locale+"','AM_SPECIALITY_LANG_VW','LONG_DESC','SPECIALITY_CODE',B.SPECIALITY_CODE) DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2"; */

	//String  sql_operation = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST_LANG_VW  WHERE LANGUAGE_ID = '"+locale+"' AND UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";//MMS-QH-CRF-0199
	String  sql_operation = "SELECT OPER_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_MAST_LANG_VW  WHERE LANGUAGE_ID = '"+locale+"' AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";//MMS-QH-CRF-0199

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
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	}
 	catch(Exception e){
		System.err.println("Err Msg OtmsByOperationType.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
 
%>

<SCRIPT LANGUAGE="JavaScript">

async function searchCatg(obj,target, tit){
	var formObj = document.forms[0];
	var locale  = formObj.locale.value;
	var facility_id=document.forms[0].facility_id.value;

	if (document.OtReportOptionsForm.param3_desc.value==null || document.OtReportOptionsForm.param3_desc.value=="") 
	{
		document.OtReportOptionsForm.param3.value="";
	}
   // var  sql = "SELECT OPER_CAT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_CATEGORY WHERE OPER_GROUP_CODE = nvl('"+document.OtReportOptionsForm.param3.value+"', OPER_GROUP_CODE) AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) ORDER BY 2";

	var  sql = "SELECT OPER_CAT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_CATEGORY_LANG_VW WHERE OPER_GROUP_CODE = nvl('"+document.OtReportOptionsForm.param3.value+"', OPER_GROUP_CODE) AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_CAT_CODE) LIKE UPPER(?) AND LANGUAGE_ID = '"+locale+"' ORDER BY 2";

	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//	argumentArray[4] = "1,2"; Modified by rajesh for Code Desc Issue
	argumentArray[4] = "2,1";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value=arr[1];
		obj.value=arr[0];
	} else{
		target.value="";
		obj.value="";
	}
}

async function searchSubCatg(obj,target, tit){
	var formObj = document.forms[0];
	var locale  = formObj.locale.value;

	if (document.OtReportOptionsForm.param3_desc.value==null || document.OtReportOptionsForm.param3_desc.value=="") 
	{
		document.OtReportOptionsForm.param3.value="";
	}

	if (document.OtReportOptionsForm.param5_desc.value==null || document.OtReportOptionsForm.param5_desc.value=="") 
	{
		document.OtReportOptionsForm.param5.value="";
	}

	//var  sql = "SELECT OPER_SUB_CAT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_SUB_CATEGORY WHERE OPER_GROUP_CODE = nvl('"+document.OtReportOptionsForm.param3.value+"', OPER_GROUP_CODE) AND OPER_CAT_CODE = nvl('"+document.OtReportOptionsForm.param5.value+"', OPER_CAT_CODE) AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_SUB_CAT_CODE) LIKE UPPER(?) ORDER BY 2";
	var  sql = "SELECT OPER_SUB_CAT_CODE CODE, LONG_DESC DESCRIPTION FROM OT_OPER_SUB_CATEGORY_LANG_VW WHERE OPER_GROUP_CODE = nvl('"+document.OtReportOptionsForm.param3.value+"', OPER_GROUP_CODE) AND OPER_CAT_CODE = nvl('"+document.OtReportOptionsForm.param5.value+"', OPER_CAT_CODE) AND UPPER(LONG_DESC) LIKE UPPER(?) AND UPPER(OPER_SUB_CAT_CODE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"'  ORDER BY 2";

	var returnedValues =    new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;
	returnedValues = await CommonLookup( tit, argumentArray );
	if((returnedValues != null) && (returnedValues != "") )  {
		var ret1=unescape(returnedValues);
	 	var arr=ret1.split(",");
	 	if(arr[1]==undefined) { 
		arr[1]="";
		arr[0]="";
		}
		target.value=arr[1];
		obj.value=arr[0];
	} else{
		target.value="";
		obj.value="";
	} 
}

function setDefaults() {
  document.OtReportOptionsForm.param3.value = "";
  document.OtReportOptionsForm.param3_desc.value = "";
  document.OtReportOptionsForm.param4.value = "";
  document.OtReportOptionsForm.param5.value = "";
  document.OtReportOptionsForm.param5_desc.value = "";
  document.OtReportOptionsForm.param6.value = "";
  document.OtReportOptionsForm.param6_desc.value = "";
  document.OtReportOptionsForm.param8.value = "";
  document.OtReportOptionsForm.param8_desc.value = "";
}


function setendis(){
	var formObj = document.forms[0];
	setDefaults();

	if  (formObj.param7.value =="S"){
		formObj.p_report_id.value="OTRMSBSP";
		formObj.pgm_id.value="OTRMSBSP";

		formObj.param3_desc.disabled=false;
		formObj.OperCodeLookUp1.disabled=false;

		formObj.param5_desc.disabled=true;
		formObj.OperCodeLookUp2.disabled=true;

		formObj.param6_desc.disabled=true;
		formObj.OperCodeLookUp3.disabled=true;

		formObj.param8_desc.disabled=true;
		formObj.OperCodeLookUp4.disabled=true;
	}

	else if  (formObj.param7.value =="C"){
		formObj.p_report_id.value="OTRMSBCT";
		formObj.pgm_id.value="OTRMSBCT";

		//Modified by muthukumar against Statistics by Operation Types on 12-07-2011
		formObj.param3_desc.disabled=false;  //Added this line
		formObj.OperCodeLookUp1.disabled=false; //Added this line
		//Modified by muthukumar against Statistics by Operation Types on 12-07-2011

		formObj.param5_desc.disabled=false;
		formObj.OperCodeLookUp2.disabled=false;

		formObj.param6_desc.disabled=true;
		formObj.OperCodeLookUp3.disabled=true;

		formObj.param8_desc.disabled=true;
		formObj.OperCodeLookUp4.disabled=true;
	}	

	else if  (formObj.param7.value =="U"){
		formObj.p_report_id.value="OTRMSBSC";
		formObj.pgm_id.value="OTRMSBSC";

		//Modified by muthukumar against Statistics by Operation Types on 12-07-2011
		formObj.param3_desc.disabled=false; //Added this line
		formObj.OperCodeLookUp1.disabled=false; //Added this line
		//Modified by muthukumar against Statistics by Operation Types on 12-07-2011

		formObj.param5_desc.disabled=false;
		formObj.OperCodeLookUp2.disabled=false;

		formObj.param6_desc.disabled=false;
		formObj.OperCodeLookUp3.disabled=false;

		formObj.param8_desc.disabled=true;
		formObj.OperCodeLookUp4.disabled=true;
	}	

	else if  (formObj.param7.value =="O"){
		formObj.p_report_id.value="OTRMSBOP";
		formObj.pgm_id.value="OTRMSBOP";

		formObj.param3_desc.disabled=true;
		formObj.OperCodeLookUp1.disabled=true;

		formObj.param5_desc.disabled=true;
		formObj.OperCodeLookUp2.disabled=true;

		formObj.param6_desc.disabled=true;
		formObj.OperCodeLookUp3.disabled=true;

		formObj.param8_desc.disabled=false;
		formObj.OperCodeLookUp4.disabled=false;
	}	

}
</SCRIPT>


<html>
<head>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script>
			var procedure_title=getLabel("Common.Procedure.label","common");
			var subCategory_title=getLabel("eOT.SubCategory.Label","ot");
			var category_title=getLabel("Common.category.label","common");
			var speciality_title=getLabel("Common.speciality.label","common");
	</script>
<title></title>
	<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<body  onLoad="setendis()" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm'>
<table border='0' cellpadding=3 cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromProcedureDate.Label" bundle="${ot_labels}"/></td>
	  <td class='fields' width='25%'>
	  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
	  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	  <td class='label' width='25%'><fmt:message key="eOT.ToProcedureDate.Label" bundle="${ot_labels}"/></td>
	  <td class='fields' width='25%' colspan="9">
	  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
	  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td colspan='8'></td>
</tr>

<tr> 
	  <td class='label' width='25%'><fmt:message key="Common.ReportBy.label" bundle="${common_labels}"/></td>
	 <td class='fields' width='25%'>
		  <select name="param7" id="param7"  onChange="setDefaults();  setendis();">  
		  <option value="S" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </option>
		  <option value="C" ><fmt:message key="Common.category1.label" bundle="${common_labels}"/> </option>
		  <option value="U" ><fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/> </option>
		  <option value="O" ><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> </option>
		  </select>
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%'>
		<input type='hidden' name="param4" id="param4" value=""> 
		<input type='hidden' name="param3" id="param3" value=""> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' onBlur="if(this.value!='') return srchCommonCode(param3,param3_desc,param4, speciality_title, document.forms[0].sql_text_2.value ); else param3.value='' ">
		<input type='button' class='button' value='?' name='OperCodeLookUp1' id='OperCodeLookUp1' onClick="srchCommonCode(param3,param3_desc,param4, speciality_title, document.forms[0].sql_text_2.value );" >
	</td>
	<td align='left' colspan="16"></td>
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
      <td class='fields' width='25%'>
		<input type='hidden' name="param5" id="param5" value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' onBlur="if(this.value!='') return searchCatg(param5,param5_desc,category_title); else param5.value='' ">
		<input type='button' class='button' value='?' name='OperCodeLookUp2' id='OperCodeLookUp2' onClick="searchCatg(param5,param5_desc,category_title);" >
	</td>
	
	<td class='label' width='25%'><fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/></td>
      <td class='fields' width='25%'>
		<input type='hidden' name="param6" id="param6" value=""> 
		<input type='text' name='param6_desc' id='param6_desc' size='20' onBlur="if(this.value!='') return searchSubCatg(param6,param6_desc,subCategory_title); else param6.value='' ">
		<input type='button' class='button' value='?' name='OperCodeLookUp3' id='OperCodeLookUp3' onClick="searchSubCatg(param6,param6_desc,subCategory_title);" >
	</td>
	<td align='left' colspan="16"></td> 
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%'>
		<input type='hidden' name="param8" id="param8" value=""> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' onBlur="if(this.value!='') return searchCode(param8,param8_desc,procedure_title, document.forms[0].sql_text_4.value); else param8.value='' ">
		<input type='button' class='button' value='?' name='OperCodeLookUp4' id='OperCodeLookUp4' onClick="searchCode(param8,param8_desc,procedure_title, document.forms[0].sql_text_4.value);" >
	</td>
	<td align='left' colspan="16"></td>
</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
 	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRMSBSP">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRMSBSP">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_speciality%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_operation%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromproceduredate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=toproceduredate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>

<!-- <input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param9##Operation Type">
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param10">
 -->
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<!-- <input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param7#param3#param4#param5#param6#param8#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">
 -->
</form>
</body>
</html>

