<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*, eCommon.Common.*"  contentType="text/html;charset=UTF-8" %>

<%
	request.setCharacterEncoding("UTF-8");
	
	String p_module_id		= "MR" ;
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");

	SimpleDateFormat dateFormat1 = new SimpleDateFormat( "MM/yyyy" ) ;
   	String currentdate 		= dateFormat1.format(new java.util.Date()) ;

	Connection con = ConnectionManager.getConnection(request);
    ResultSet rs   = null;
    Statement stmt = null;
	try {
		//String pat_length="";
       // stmt=con.createStatement();
	   // rs=stmt.executeQuery("select patient_id_length from mp_param");
	   // if (rs!=null&&rs.next())
        //  pat_length = rs.getString(1);

		//String patient_id_length =  eCommon.Common.CommonBean.getPatientIDLength(con);

			HashMap ResultParamHashMap			= new HashMap();
			HashMap sqlColumns					= new HashMap();
			sqlColumns.put("patient_id_length","S");
			
			String whereClause					= "";
			ResultParamHashMap					= CommonBean.getParamDetails(sqlColumns,whereClause,"MP_PARAM",con);
			String patient_id_length			= (String) ResultParamHashMap.get("patient_id_length");
			patient_id_length					= patient_id_length==null?"":patient_id_length;
			sqlColumns.clear();
			ResultParamHashMap.clear();

%>
<html>
<head>
    <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>

		<script src="../../eCommon/js/ValidateControl.js"></script>
		<script src="../../eCommon/js/common.js"></script>
		<script src='../js/MRReports.js' language='javascript'></script> 
		<script src="../../eCommon/js/DateUtils.js"></script>
		<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
function checkForExcel(){
	var IPCheckbox = document.forms[0].p_visit_type1;
	var OPCheckbox = document.forms[0].p_visit_type2;
	var AECheckbox = document.forms[0].p_visit_type3;
    var tempcheckbox = "";
	var finalString = "";

	if(IPCheckbox.checked ){
		tempcheckbox = document.forms[0].p_visit_type1.value+",DC";
	}
    if(OPCheckbox.checked ){
		tempcheckbox = tempcheckbox + ","  + document.forms[0].p_visit_type2.value;
	}
	if(AECheckbox.checked ){
		tempcheckbox = tempcheckbox + "," + "AE";
	}
	
	if(tempcheckbox.charAt(0) == ','){
       
	   finalString = tempcheckbox.substring(1,tempcheckbox.length);
	   
	}else{
       finalString = tempcheckbox;
	}
    
	if(finalString.length === 0){
       finalString = "IP,DC,OP,AE";
	}
	
	document.forms[0].visitType_hdn.value = finalString;
	
}

function changereportID()
{
	document.forms[0].p_from_termcode.disabled=false;
	document.forms[0].p_to_termcode.disabled=false;
	document.forms[0].from_term_code.disabled=false;
	document.forms[0].to_term_code.disabled=false;

	if (document.forms[0].P_REPORT_TYPE.value=='1')
	{
		document.forms[0].p_report_id.value = "MRT10PMB";
	}
	else if(document.forms[0].P_REPORT_TYPE.value=='2')
	{
		document.forms[0].p_report_id.value = "MRPMBCOD";
	}
	else if(document.forms[0].P_REPORT_TYPE.value=='3')
	{
		document.forms[0].p_report_id.value = "MRINCOMP";
		document.forms[0].p_from_termcode.value="";
		document.forms[0].p_to_termcode.value="";
		document.forms[0].p_from_termcode.disabled=true;
		document.forms[0].p_to_termcode.disabled=true;
		document.forms[0].from_term_code.disabled=true;
		document.forms[0].to_term_code.disabled=true;
	}
	else if(document.forms[0].P_REPORT_TYPE.value=='4')
	{
		document.forms[0].p_report_id.value = "MRINCORCT";
	}
 
}

//function for exporting to EXCEL
function excelExport()
	{
	        var isProceed	= false;
			var fields		= new Array()
			var names		= new Array() 
			var formObj		= document.ICD10PMBReport;
			var fields		= new Array(formObj.P_FM_DATE,formObj.P_TO_DATE);
			var names1		= new Array ( getLabel("eMR.AdmVisitMonth.label","MR"));
			var names		= new Array ( getLabel("Common.from.label","Common")+" "+getLabel("eMR.AdmVisitMonth.label","MR"),getLabel("Common.to.label","Common")+" "+getLabel("eMR.AdmVisitMonth.label","MR"));

			if ( checkFields(fields, names, parent.frames[2]) )
			{
            if( checkmonths( names1,document.forms[0].P_FM_DATE, document.forms[0].P_TO_DATE, parent.frames[2] ) )

			if( CheckString1( getLabel("Common.patientId.label","Common"),document.forms[0].p_fm_patient_id, document.forms[0].p_to_patient_id, parent.frames[2] ) )

			if( CheckString1( getLabel("Common.BillingGroup.label","Common"),document.forms[0].p_from_bl_grp_id, document.forms[0].p_to_bl_grp_id, parent.frames[2] ) ) 
				
			if( CheckString1( getLabel("Common.Customer.label","Common"),document.forms[0].p_from_cust_code, document.forms[0].p_to_cust_code, parent.frames[2] ) ) 

			if( CheckTerm(getLabel("eMR.ICD10CODE.label","MR"), document.forms[0].p_from_termcode,document.forms[0].p_to_termcode, parent.frames[2] )  )
			
			isProceed	= true;
			}

           if(isProceed==true){
				
				var patientIDFrom		= document.forms[0].p_fm_patient_id.value; 
				var patientIDTO			= document.forms[0].p_to_patient_id.value; 
				var visitAdmDateFrom	= document.forms[0].P_FM_DATE.value; 
				var visitAdmDateTo		= document.forms[0].P_TO_DATE.value; 
				var billingGroupFrom	= document.forms[0].p_from_bl_grp_id.value; 
				var billingGroupTo		= document.forms[0].p_to_bl_grp_id.value; 
				var customerFrom		= document.forms[0].p_from_cust_code.value; 
				var customerTo			= document.forms[0].p_to_cust_code.value; 
				var termcodeFrom		= document.forms[0].p_from_termcode.value; 
				var termcodeTo			= document.forms[0].p_to_termcode.value;  
				var reportType			= document.forms[0].P_REPORT_TYPE.value; 
				var visitType			= document.forms[0].visitType_hdn.value	;
				var P_facility_id		= document.forms[0].P_facility_id.value	;

				if(document.forms[0].p_visit_type1.checked)
					{var visitType1			= document.forms[0].p_visit_type1.value	;}
				else{var visitType1		="";}

				if(document.forms[0].p_visit_type2.checked)
					{var visitType2			= document.forms[0].p_visit_type2.value	;}
				else{var visitType2		="";}

				if(document.forms[0].p_visit_type3.checked)
					{var visitType3			= document.forms[0].p_visit_type3.value	;}
				else{var visitType3		="";}

				parent.frames[1].document.forms[0].method	= "POST";
                parent.frames[1].document.forms[0].action	= '../../servlet/eMR.repICD10PMBCodesServlet?patientIDFrom='+patientIDFrom+'&patientIDTO='+patientIDTO+'&visitAdmDateFrom='+visitAdmDateFrom+'&visitAdmDateTo='+visitAdmDateTo+'&billingGroupFrom='+billingGroupFrom+'&billingGroupTo='+billingGroupTo+'&customerFrom='+customerFrom+'&customerTo='+customerTo+'&termcodeFrom='+termcodeFrom+'&termcodeTo='+termcodeTo+'&reportType='+reportType+'&visitType='+visitType+'&visitType1='+visitType1+'&visitType2='+visitType2+'&visitType3='+visitType3+'&P_facility_id='+P_facility_id;

				parent.frames[1].document.forms[0].submit();
			}

	}


function searchCode1(obj,target)
	{
		var retVal = 	new String();
		var tit="";
		var locale= "<%=locale%>";
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();


		if(obj.name=="billing_group"){
			tit=getLabel('Common.BillingGroup.label','common');
			argumentArray[0]="select blng_grp_id code, short_desc description from bl_blng_grp_lang_vw where  language_id='"+locale+"' and upper(blng_grp_id) like upper(?) and upper(short_desc) like upper(?)";
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
		}

		if(obj.name=="cust_code"){
			tit=getLabel('Common.CustomerCode.label','common');
			
				argumentArray[0]="select cust_code code, long_name description from ar_customer_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_code) like upper(nvl(?,cust_code)) and upper(long_name) like upper(nvl(?,long_name)) order by 2 ";
			
			argumentArray[1]=new Array("1");
			argumentArray[2]=new Array("1");
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC; 
		}
		

		retVal = await CommonLookup( tit, argumentArray ) ;

		if(retVal != null && retVal != "" )
		{
			var ret1=unescape(retVal);
			arr=ret1.split(",");
			target.value=arr[0];
		}
		else
		{
			target.value='';
		}
	}

</script>


<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();changereportID();checkForExcel()"  onKeyDown = 'lockKey()'>
<br>
<br>
<form name="ICD10PMBReport" id="ICD10PMBReport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<table width='80%' align='center' valign='top' border='0'>

		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>

	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' border="0" >

				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="label" width="30%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="label" width="40%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
                </tr>
                
                <tr>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<input type=text  name='p_fm_patient_id' id='p_fm_patient_id' size=<%=patient_id_length%> maxlength=<%=patient_id_length%> onBlur="ChangeUpperCase(this);" align="center" onKeypress='return CheckForSpecChars(event);' ><input type='button' name='fm_patient_id' id='fm_patient_id' value='?' class='button' onclick='searchPatient1(this)'>
					</td>
					<td class='fields'>
						<input type=text  name='p_to_patient_id' id='p_to_patient_id' size=<%=patient_id_length%> maxlength=<%=patient_id_length%> onBlur="ChangeUpperCase(this);" align="center" onKeypress='return CheckForSpecChars(event);' ><input type='button' name='to_patient_id' id='to_patient_id' value='?' class='button' onclick='searchPatient1(this)'>
					</td>
                </tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td align='right' width='30%' class="label"><fmt:message key="eMR.AdmVisitMonth.label" bundle="${mr_labels}"/> &nbsp;</td>
						<td width='30%'  >
							<input type=text id="P_FM_DATE"  name='P_FM_DATE' id='P_FM_DATE' size="7" maxlength="7" align="center" onBlur="if(validDateObj(this,'MY','<%=locale%>'))validatePeriod_from_PMB(this);" ><img  src='../../eCommon/images/CommonCalendar.gif'  onClick="return showCalendar('P_FM_DATE','mm/y', null);" />&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td width='40%'> 
							<input type=text id="P_TO_DATE"  name='P_TO_DATE' id='P_TO_DATE' size="7" maxlength="7" align="center" onBlur="if(validDateObj(this,'MY','<%=locale%>'))validatePeriod_to_PMB(this);" ><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_TO_DATE','mm/y', null);"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
 
				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
                
                <tr>
						<td  width='30%' class="label"><fmt:message key="Common.BillingGroup.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_from_bl_grp_id' id='p_from_bl_grp_id' size="4" maxlength="4" align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode1(this, p_from_bl_grp_id)'>
						</td>
						<td class="fields" width='40%'>
							<input type=text  name='p_to_bl_grp_id' id='p_to_bl_grp_id' size="4" maxlength="4" align="center"><input type='button' name='billing_group' id='billing_group' value='?' class='button' onclick='searchCode1(this,  p_to_bl_grp_id)'>
						</td>
					</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
                 
                <tr>
						<td  width='30%' class="label"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_from_cust_code' id='p_from_cust_code' size="8" maxlength="8" align="center"><input type='button' name='cust_code' id='cust_code' value='?' class='button' onclick='searchCode1(this, p_from_cust_code)'>
						</td>
						<td class="fields" width='40%'>
							<input type=text  name='p_to_cust_code' id='p_to_cust_code' size="8" maxlength="8" align="center"><input type='button' name='cust_code' id='cust_code' value='?' class='button' onclick='searchCode1(this, p_to_cust_code)'>
						</td>
					</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
						<td  width='30%' class="label"><fmt:message key="eMR.ICD10.label" bundle="${mr_labels}"/>&nbsp<fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class="fields" width='20%'  >
							<input type=text  name='p_from_termcode' id='p_from_termcode' size="10" maxlength="20" align="center" onKeyPress="return SpCharChkForICD10(event);"><input type='button' name='from_term_code' id='from_term_code' value='?' class='button' onclick='termCodeLookup(this, p_from_termcode)'>
						</td>
						<td class="fields" width='40%'>
							<input type=text  name='p_to_termcode' id='p_to_termcode' size="10" maxlength="20" align="center" onKeyPress="return SpCharChkForICD10(event);"><input type='button' name='to_term_code' id='to_term_code' value='?' class='button' onclick='termCodeLookup(this, p_to_termcode)'>
						</td>
					</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

                <tr>
						<td align='right' width='30%' class="label"><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></td>
						<td class="fields" width='30%'  >
							<input type="checkbox" name="p_visit_type1" id="p_visit_type1" value="IP" onclick='checkForExcel(this)'><fmt:message key="Common.IP.label" bundle="${common_labels}"/>&nbsp;&nbsp;
							<input type="checkbox" name="p_visit_type2" id="p_visit_type2" value="OP" onclick='checkForExcel(this)'><fmt:message key="Common.OP.label" bundle="${common_labels}"/>&nbsp;&nbsp;
                            <input type="checkbox" name="p_visit_type3" id="p_visit_type3" value="EM" onclick='checkForExcel(this)'><fmt:message key="Common.AE.label" bundle="${common_labels}"/>
						</td>
				</tr>

				<tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>

				<tr>
				    <td align='right' width='30%' class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class='fields'>
					<select name="P_REPORT_TYPE" id="P_REPORT_TYPE" onchange='changereportID()'>
					<option value="2" selected><fmt:message key="eMR.PMBCodes.label" bundle="${mr_labels}"/></option>
					<option value="1"><fmt:message key="eMR.Top10PMBICDCodes.label" bundle="${mr_labels}"/></option>
					<option value="3"><fmt:message key="eMR.IncompleteICDCodes.label" bundle="${mr_labels}"/></option>
		            <option value="4"><fmt:message key="eMR.IncorrectICDCodes.label" bundle="${mr_labels}"/></option>
					</select>
					</td>		
				</tr>
				 
				<!-- added by Sangeetha for GDOH-CRF-0082 US 07 -->
                <tr>
					<td>&nbsp;</td>
					<Td>&nbsp;</td>
				</tr>
                
                <tr>
					<td align='right' width='100%' class="label" colspan='2'>
						<input type="button" name="export" id="export" value="Export" onclick="return excelExport();" />
					</td>
					
				</tr> 

	         </table>	
	    </td>
     </tr>
</table>

	<input type="hidden" name="P_facility_id" id="P_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"	value="">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">	
	<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
	<input type="hidden" name="visitType_hdn" id="visitType_hdn" value="">
	<input type='hidden' name='CurrentDate' id='CurrentDate' value = "<%=currentdate%>"></input>

</form>
</body>
</html>
<%
} catch(Exception e) {
          e.printStackTrace();
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
     }
     finally {
		 try
		 {
          if (rs != null) rs.close();
          if (stmt != null) stmt.close();
		 }
catch(Exception e) { }
		  ConnectionManager.returnConnection(con,request);

     }
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

