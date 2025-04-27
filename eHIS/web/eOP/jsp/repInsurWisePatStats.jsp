<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//String p_menu_id=request.getParameter("menu_id");
//String p_module_id      = request.getParameter("module_id");
String p_report_id      = "OPIWPVSR" ;
String p_facility_id    = (String) session.getValue( "facility_id" ) ;
String p_user_name      = (String) session.getValue( "login_user" ) ;
String locale      = (String)session.getAttribute("LOCALE");
String function_id		= request.getParameter("function_id");
String function_name	=  request.getParameter("function_name");
String function_type	=  request.getParameter("function_type");
//String access			=  request.getParameter("access");

Statement stmt=null;
ResultSet rset=null ;
Connection con=null;
//String ID="";
//String dat="";
//String en="";
try{
con=ConnectionManager.getConnection(request); 

//String sql="";
String pid_length="";
stmt = con.createStatement();
String sql4 = "select patient_id_length from mp_param";
rset = stmt.executeQuery(sql4);
if(rset != null){
if(rset.next())
pid_length = rset.getString(1);

}
if(pid_length==null || pid_length.equals(""))
pid_length = "10";
if(rset != null) rset.close();
if(stmt != null) stmt.close();

%>
<script>
function fnExportToExcel(){  
	var isProceed	= false;	
	var fields = new Array ( document.reportInsWisePatStatsform.p_from_date,document.reportInsWisePatStatsform.p_to_date);
	var visitDate=getLabel("eOP.VisitAdmDate.label","op");
	var names = new Array(getLabel("Common.from.label","Common")+" "+visitDate,getLabel("Common.to.label","Common")+" "+visitDate);
	if(checkFields( fields, names, parent.frames[2])) 
		{
			 if(chkGrtr(document.reportInsWisePatStatsform.p_from_date,
					document.reportInsWisePatStatsform.p_to_date)==true)
				{
				 if(CheckString(getLabel("Common.speciality.label","Common")+" "+getLabel("Common.code.label","Common"),document.forms[0].p_fm_specialty_code,document.forms[0].p_to_specialty_code,parent.frames[2]))
				 if(CheckString(getLabel("Common.locationcode.label","Common"),document.forms[0].p_fm_locn_code,document.forms[0].p_to_locn_code,parent.frames[2]))
				 if(CheckString(getLabel("Common.NursingUnitCode.label","Common"),document.forms[0].p_fm_nursing_code,document.forms[0].p_to_nursing_code,parent.frames[2]))
				 if(CheckString(getLabel("Common.practitionerid.label","Common"),document.forms[0].p_from_pract_id,document.forms[0].p_to_pract_id,parent.frames[2]))
				 if(CheckString(getLabel("Common.BillingGroup.label","Common"),document.forms[0].p_from_bl_grp_id,document.forms[0].p_to_bl_grp_id,parent.frames[2]))
				 if(CheckString(getLabel("Common.BillingGroup.label","Common"),document.forms[0].p_from_bl_grp_id,document.forms[0].p_to_bl_grp_id,parent.frames[2]))
				 if(CheckString(getLabel("Common.Customer.label","Common")+" "+getLabel("Common.GroupCode.label","Common"),document.forms[0].p_from_cust_grp_code,document.forms[0].p_to_cust_grp_code,parent.frames[2]))
				 if(CheckString(getLabel("Common.CustomerCode.label","Common"),document.forms[0].p_from_cust_code,document.forms[0].p_to_cust_code,parent.frames[2]))
					isProceed	= true;
				}
		}


		if(isProceed==true){
			var visitAdmDateFrom		= document.forms[0].p_from_date.value;            
			var visitAdmDateTo			= document.forms[0].p_to_date.value;              
			var episodeType				= document.forms[0].p_patient_class.value;        
			var specialityFrom			= document.forms[0].p_fm_specialty_code.value;        
			var specialityTo			= document.forms[0].p_to_specialty_code.value;    
			var locationCodeFrom		= document.forms[0].p_fm_locn_code.value;         
			var locationCodeTo			= document.forms[0].p_to_locn_code.value;         
			var nursingUnitCodeFrom		= document.forms[0].p_fm_nursing_code.value;      
			var nursingUnitCodeTo		= document.forms[0].p_to_nursing_code.value;      
			var practitionerIdFrom		= document.forms[0].p_from_pract_id.value;        
			var practitionerIdTo		= document.forms[0].p_to_pract_id.value;          
			var billingGroupFrom		= document.forms[0].p_from_bl_grp_id.value;       
			var billingGroupTo			= document.forms[0].p_to_bl_grp_id.value;         
			var customerGroupFrom		= document.forms[0].p_from_cust_grp_code.value;   
			var customerGroupTo			= document.forms[0].p_to_cust_grp_code.value;     
			var customerCodeFrom		= document.forms[0].p_from_cust_code.value;   
			var customerCodeTo			= document.forms[0].p_to_cust_code.value;     
			var policyType				= document.forms[0].p_policy_type_code.value;     
			var policyNo				= document.forms[0].p_policy_number.value;        
			var patientId				= document.forms[0].p_patient_id.value;           
			var orderBy					= document.forms[0].p_order_by.value;   
			
			var orderByTxt				= document.forms[0].p_order_by.options[document.forms[0].p_order_by.selectedIndex].innerHTML;
			var episodeTypeTxt			= document.forms[0].p_patient_class.options[document.forms[0].p_patient_class.selectedIndex].innerHTML;
			
		

				
				/*var HTMLVal	= "";
				HTMLVal = "<html><body onKeyDown='lockKey()'><form name='form1' id='form1' method='get' action='../../servlet/eOP.repInsuranceWisePatientVisitStatServlet'><input type='hidden' name='visitAdmDateFrom' id='visitAdmDateFrom' value=\""+visitAdmDateFrom+"\"><input type='hidden' name='visitAdmDateTo' id='visitAdmDateTo' value=\""+visitAdmDateTo+"\"><input type='hidden' name='episodeType' id='episodeType' value=\""+episodeType+"\"><input type='hidden' name='specialityFrom' id='specialityFrom' value=\""+specialityFrom+"\"><input type='hidden' name='specialityTo' id='specialityTo' value=\""+specialityTo+"\"><input type='hidden' name='locationCodeFrom' id='locationCodeFrom' value=\""+locationCodeFrom+"\"><input type='hidden' name='locationCodeTo' id='locationCodeTo' value=\""+locationCodeTo+"\"><input type='hidden' name='nursingUnitCodeFrom' id='nursingUnitCodeFrom' value=\""+nursingUnitCodeFrom+"\"><input type='hidden' name='nursingUnitCodeTo' id='nursingUnitCodeTo' value=\""+nursingUnitCodeTo+"\"><input type='hidden' name='practitionerIdFrom' id='practitionerIdFrom' value=\""+practitionerIdFrom+"\"><input type='hidden' name='practitionerIdTo' id='practitionerIdTo' value=\""+practitionerIdTo+"\"><input type='hidden' name='billingGroupFrom' id='billingGroupFrom' value=\""+billingGroupFrom+"\"><input type='hidden' name='billingGroupTo' id='billingGroupTo' value=\""+billingGroupTo+"\"><input type='hidden' name='customerGroupFrom' id='customerGroupFrom' value=\""+customerGroupFrom+"\"><input type='hidden' name='customerGroupTo' id='customerGroupTo' value=\""+customerGroupTo+"\"><input type='hidden' name='customerCodeFrom' id='customerCodeFrom' value=\""+customerCodeFrom+"\"><input type='hidden' name='customerCodeTo' id='customerCodeTo' value=\""+customerCodeTo+"\"><input type='hidden' name='policyType' id='policyType' value=\""+policyType+"\"><input type='hidden' name='policyNo' id='policyNo' value=\""+policyNo+"\"><input type='hidden' name='patientId' id='patientId' value=\""+patientId+"\"><input type='hidden' name='orderBy' id='orderBy' value=\""+orderBy+"\"><input type='hidden' name='orderByTxt' id='orderByTxt' value=\""+orderByTxt+"\"><input type='hidden' name='episodeTypeTxt' id='episodeTypeTxt' value=\""+episodeTypeTxt+"\"></form></body></html>";  
				
				parent.frames[2].location.href = "../../eCommon/jsp/error.jsp";
				parent.frames[3].document.innerHTML	= "";
				parent.frames[3].document.write("");
				parent.frames[3].document.write(HTMLVal);
				parent.frames[3].document.form1.submit();*/


				parent.frames[1].document.forms[0].method	= "POST";
				parent.frames[1].document.forms[0].action	='../../servlet/eOP.repInsuranceWisePatientVisitStatServlet?visitAdmDateFrom='+visitAdmDateFrom+'&visitAdmDateTo='+visitAdmDateTo+'&episodeType='+episodeType+'&specialityFrom='+specialityFrom+'&specialityTo='+specialityTo+'&locationCodeFrom='+locationCodeFrom+'&locationCodeTo='+locationCodeTo+'&nursingUnitCodeFrom='+nursingUnitCodeFrom+'&nursingUnitCodeTo='+nursingUnitCodeTo+'&practitionerIdFrom='+practitionerIdFrom+'&practitionerIdTo='+practitionerIdTo+'&billingGroupFrom='+billingGroupFrom+'&billingGroupTo='+billingGroupTo+'&customerGroupFrom='+customerGroupFrom+'&customerGroupTo='+customerGroupTo+'&customerCodeFrom='+customerCodeFrom+'&customerCodeTo='+customerCodeTo+'&policyType='+policyType+'&policyNo='+policyNo+'&patientId='+patientId+'&orderBy='+orderBy+'&orderByTxt='+orderByTxt+'&episodeTypeTxt='+episodeTypeTxt;
				parent.frames[1].document.forms[0].submit();
				
		}

}
function chkGrtr(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"DMYHM",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			parent.frames[2].location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}
	async function getPatID()
	{					  
		var pat_id=await PatientSearch();
		if( pat_id != null )						
			document.forms[0].p_patient_id.value = pat_id ;					
	}

	function searchCode1(obj,target)
	{
		var retVal = 	new String();
		var dialogHeight= "28" ;
		var dialogWidth	= "43" ;
		var status = "no";
		var arguments	= "" ;
		var sql="";
		var search_code="";
		var search_desc="";
		var tit="";
		var locale= "<%=locale%>";
		var p_facility_id =document.forms[0].p_facility_id.value;
		var argumentArray  = new Array();
		var dataNameArray  = new Array();
		var dataValueArray = new Array();
		var dataTypeArray  = new Array();
		var p_patient_class = document.forms[0].p_patient_class.value;

		if(obj.name=="frmSpeciality"||obj.name=="toSpeciality")
		{
			tit=getLabel('Common.speciality.label','common');

			argumentArray[0]="select speciality_code code, short_desc description from am_speciality_lang_vw where language_id='"+locale+"' and upper(speciality_code) like upper(?) and upper(short_desc) like upper(?)";
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
		}
		if(obj.name=="fromlocn" || obj.name=="tolocn")
		{
			tit=getLabel("Common.locationcode.label","Common");

			if(p_patient_class=='OP')
			{
				argumentArray[0]="select clinic_code code, long_desc description from op_clinic_lang_vw where language_id='"+locale+"' and facility_id ='"+p_facility_id+"' and clinic_type IN ('C','E') and LEVEL_OF_CARE_IND = 'A' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) ";
			}
			else if(p_patient_class=='EM')
			{
				argumentArray[0]="select clinic_code code, long_desc description  from op_clinic_lang_vw where language_id='"+locale+"' and facility_id  ='"+p_facility_id+"' and clinic_type ='C' and LEVEL_OF_CARE_IND = 'E' and upper(clinic_code) like upper(?) and upper(long_desc) like upper(?)";
			}
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
		}

		if(obj.name=="frmnursing_unit_code"||obj.name=="tonursing_unit_code")
		{
			tit=getLabel('Common.NursingUnitCode.label','common');
			
			argumentArray[0]="select nursing_unit_code code, short_desc description from ip_nursing_unit_lang_vw where facility_id='"+p_facility_id+"' and patient_class='"+p_patient_class+"' and language_id='"+locale+"' and upper(nursing_unit_code) like upper(?) and upper(short_desc) like upper(?)";
			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
		}
		if(obj.name=="practitioner_id2" || obj.name=="practitioner_id1")
		{
			tit=getLabel('Common.practitioner.label','common')

			argumentArray[0]  = "select a.Practitioner_id  code,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,'"+locale+"', '1') description  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where b.FACILITY_ID='"+p_facility_id+"' AND a.Practitioner_id=b.Practitioner_id and upper(a.Practitioner_id) like upper(?) and upper(a.Practitioner_id) like upper(?)";

			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
		}

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
		if(obj.name=="cust_grp_code"){

			tit=getLabel('Common.Customer.label','common')+' '+getLabel('Common.GroupCode.label','common');
			argumentArray[0]="select cust_group_code code, short_desc description from ar_cust_group_lang_vw where language_id='"+locale+"' and (cust_group_code) like upper(nvl(?,cust_group_code)) and upper(short_desc) like upper(nvl(?,short_desc)) ";
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
			var group_id	= "";
			if(target.name=="p_from_cust_code"){
				group_id	= document.forms[0].p_from_cust_grp_code.value;
			}else{
				group_id	= document.forms[0].p_to_cust_grp_code.value;
			}
			if(group_id==""){
				argumentArray[0]="select cust_code code, long_name description from ar_customer_lang_vw where '1' like ? and language_id='"+locale+"' and upper(cust_code) like upper(nvl(?,cust_code)) and upper(long_name) like upper(nvl(?,long_name)) order by 2 ";
			}else{ 
				argumentArray[0]="select code,description from (SELECT a.cust_code code, a.long_name description FROM ar_customer_lang_vw a,ar_cust_group_lang_vw b, bl_cust_by_cust_group d  WHERE a.acc_entity_code =  b.acc_entity_code AND b.acc_entity_code =d.acc_entity_code AND a.language_id = b.language_id AND b.cust_group_code = d.cust_group_code AND a.cust_group_code = b.cust_group_code AND a.cust_code = d.cust_code AND b.cust_group_code = '"+group_id+"' AND a.language_id = '"+locale+"' AND a.acc_entity_code IN (SELECT d.acc_entity_code FROM sy_acc_entity d  WHERE acc_entity_id = d.acc_entity_id) ) where 1 like ? and UPPER (code) LIKE UPPER (NVL (?, code)) AND UPPER (description) LIKE UPPER (NVL (?, description)) ORDER BY 2"; 
			}	
			argumentArray[1]=new Array("1");
			argumentArray[2]=new Array("1");
			argumentArray[3]=new Array(STRING);
			argumentArray[4]="2,3";
			argumentArray[5]=target.value;
			argumentArray[6]=CODE_DESC_LINK;
			argumentArray[7]=CODE_DESC; 
		}
		if(obj.name=="p_policy_type"){
			tit=getLabel('eBL.POLICY_TYPE.label','bl');
			argumentArray[0] ="SELECT policy_type_code code, short_desc description FROM bl_ins_policy_types_lang_vw  where language_id = '"+locale+"' and upper(policy_type_code) like upper(?) and upper(short_desc) like upper(?)";

			argumentArray[1] = dataNameArray ;
			argumentArray[2] = dataValueArray ;
			argumentArray[3] = dataTypeArray ;
			argumentArray[4] = "1,2";
			argumentArray[5] = target.value;
			argumentArray[6] = CODE_LINK;
			argumentArray[7] = CODE_DESC;
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

/*	function setValue()
	{

		if ( document.forms[0].sum_id.checked == true)
		{
			document.forms[0].p_sum_yn.value="Y";			 
		}              
		if ( document.forms[0].detail_id.checked == true)
		{
			document.forms[0].p_sum_yn.value="N";
		}           
	}*/

	function setDate(Object){ 

		if(Object.value!="")
		{
			if(!validDateObjforAdm(Object.value,'DMYHM',localeName))
			{
				alert(getMessage("INVALID_DATE_TIME",'SM'));
				Object.select();
			}else {
				if (isBeforeNow(Object.value,"DMYHM",localeName))
				{
					return true;
				}
				else
				{
					alert(getMessage("DATE_LESS_EQL_SYS_DATE",'FM'));
					Object.value="";
					Object.focus();            
				}
			}
		}
	}

	function disablefields()
	{
		if(document.forms[0].p_patient_class.value=="ALL"){
			document.forms[0].p_fm_locn_code.disabled=true;
			document.forms[0].fromlocn.disabled=true;
			document.forms[0].p_to_locn_code.disabled=true;
			document.forms[0].tolocn.disabled=true;
			document.forms[0].p_fm_nursing_code.disabled=true;
			document.forms[0].p_to_nursing_code.disabled=true;
			document.forms[0].frmnursing_unit_code.disabled=true;
			document.forms[0].tonursing_unit_code.disabled=true;
			
			
		}

		if(document.forms[0].p_patient_class.value=="IP" || document.forms[0].p_patient_class.value=="DC"){
			document.forms[0].p_fm_locn_code.disabled=true;
			document.forms[0].fromlocn.disabled=true;
			document.forms[0].p_to_locn_code.disabled=true;
			document.forms[0].tolocn.disabled=true;
			
			document.forms[0].p_fm_nursing_code.disabled=false;
			document.forms[0].p_to_nursing_code.disabled=false;
			document.forms[0].frmnursing_unit_code.disabled=false;
			document.forms[0].tonursing_unit_code.disabled=false;

			

		}
		if(document.forms[0].p_patient_class.value=="OP" || document.forms[0].p_patient_class.value=="EM"){
			document.forms[0].p_fm_nursing_code.disabled=true;
			document.forms[0].p_to_nursing_code.disabled=true;
			document.forms[0].frmnursing_unit_code.disabled=true;
			document.forms[0].tonursing_unit_code.disabled=true;
			
			document.forms[0].p_fm_locn_code.disabled=false;
			document.forms[0].fromlocn.disabled=false;
			document.forms[0].p_to_locn_code.disabled=false;
			document.forms[0].tolocn.disabled=false;

		}

		document.forms[0].p_fm_locn_code.value='';
		document.forms[0].p_to_locn_code.value='';
		document.forms[0].p_fm_nursing_code.value='';
		document.forms[0].p_to_nursing_code.value='';
		document.forms[0].p_fm_specialty_code.value='';
		document.forms[0].p_to_specialty_code.value='';

	}
	function validDateObjforAdm(Object3){

		var checkFlag= true ;
		var strDate;
		var strDay;
		var strMonth;
		var strYear;

		var dateArray1=Object3.split(" ");
		var	dateArray=(dateArray1[0]).split("/");
		var time1arr=dateArray1[1].split(":")
		if(time1arr.length==2)
		{
			var time1hr=time1arr[0]
			var time1min=time1arr[1]

			if(time1hr < 0 && time1hr >24 && time1min < 00 && time1min > 59)
			{
				checkFlag=false;
			}

			if (time1hr.length != 2 || time1min.length != 2)
			{
				checkFlag=false;
			}
		}
		var strDateArray = new Array();


		if (dateArray.length == 0) checkFlag= true;


		strDateArray = dateArray;
		if (strDateArray.length != 3) {
			checkFlag= false;
		}
		else {
			strDay = trimString(strDateArray[0]);
			strMonth = trimString(strDateArray[1]);
			strYear = trimString(strDateArray[2]);
		}


		if (strYear.length < 4 || strYear.length > 4) checkFlag= false;
		if (strMonth.length != 2) checkFlag= false;
		if (strDay.length != 2) checkFlag= false;

		if (isNaN(strDay)==true) checkFlag= false;
		if (isNaN(strMonth)==true) checkFlag = false;
		if (isNaN(strYear)==true) checkFlag= false;

		if (strYear < 1800) checkFlag = false;

		if (strMonth>12 || strMonth<1)  checkFlag = false;

		if ((strMonth == 01 || strMonth == 03 || strMonth == 05 || strMonth == 07 || strMonth == 08 || strMonth == 10 || strMonth == 12) && (strDay > 31 || strDay < 1)) checkFlag = false;

		if ((strMonth == 04 || strMonth == 06 || strMonth == 09 || strMonth == 11) && (strDay > 30 || strDay < 01)) checkFlag = false;

		if (strMonth == 02) {
			if (strDay < 01) checkFlag = false;

			if (LeapYear(strYear) == true) {
				if (strDay > 29) checkFlag = false;
			}
			else {
				if (strDay > 28) checkFlag = false;
			}
		}
		return checkFlag;
	}

</script>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();' onload='disablefields();'>
	<center>
		<form name="reportInsWisePatStatsform" id="reportInsWisePatStatsform" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
			<BR>
				<table width='80%' align='center' valign='top'>
					<th class='columnheader' align="left" width='100%'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				</table>   
				<table width='80%' cellPadding="2" cellSpacing="0"  align='center' border='0'>        
					<tr>
						<td >&nbsp;</td>
						<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;</td>
						<td class="querydata" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
					<tr>

						<td class="label"><fmt:message key="eOP.VisitAdmDate.label" bundle="${op_labels}"/></td>
						<td class='fields'><input type=text id='p_from_date'  name='p_from_date' id='p_from_date' size="16" maxlength="16" align="left" onBlur='if(validDateObj(this,"DMYHM",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_from_date',null,'hh:mm');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>	
						<td class='fields'><input type=text id='p_to_date'  name='p_to_date' id='p_to_date' size="16" maxlength="16" align="left" onBlur='if(validDateObj(this,"DMYHM",localeName)){setDate(this)};'><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_date',null,'hh:mm');" style="cursor='hand'"></img><img src='../../eCommon/images/mandatory.gif'></img></td>
					</td>
				</tr> 

				<tr>
					<td class="label"><fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/>
					</td>
					<td class='fields'><select name="p_patient_class" id="p_patient_class" onchange='disablefields();'>
						<option value='ALL' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/>

							<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
								<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
									<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
										<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
										</select></td>
									</tr>  
									<tr>
										<td align='right'  class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
										<td class='fields'>
											<input type=text  name='p_fm_specialty_code' id='p_fm_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='frmSpeciality' id='frmSpeciality' value='?' class='button' onclick='searchCode1(this, p_fm_specialty_code)'>
										</td>
										<td class='fields'> 
											<input type=text  name='p_to_specialty_code' id='p_to_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='toSpeciality' id='toSpeciality' value='?' class='button' onclick='searchCode1(this, p_to_specialty_code)'>
										</td>
									</tr>
									<tr class='fields'>
										<td class="label"><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></td>
										<td class='fields'><input type="text" name="p_fm_locn_code" id="p_fm_locn_code" size="4" maxlength="4" ><input type='button' name='fromlocn' id='fromlocn' value='?' class='button' onclick='searchCode1(this, p_fm_locn_code)'>
										</td>
										<td class='fields'><input type="text" name="p_to_locn_code" id="p_to_locn_code" size="4" maxlength="4"><input type='button' name='tolocn' id='tolocn' value='?' class='button' onclick='searchCode1(this, p_to_locn_code)'>
										</td>
									</tr>

									<tr>
										<td align='right' width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
										<td width='40%'  >
											<input type=text  name='p_fm_nursing_code' id='p_fm_nursing_code' size="4" maxlength="4" align="center"><input type='button' name='frmnursing_unit_code' id='frmnursing_unit_code' value='?' class='button' onclick='searchCode1(this, p_fm_nursing_code)'>
										</td>
										<td width='30%'> 
											<input type=text  name='p_to_nursing_code' id='p_to_nursing_code' size="4" maxlength="4" align="center"><input type='button' name='tonursing_unit_code' id='tonursing_unit_code' value='?' class='button' onclick='searchCode1(this, p_to_nursing_code)'>
										</td>
									</tr>

									<tr>
										<tr>
											<td align='right' width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
											<td width='40%'  >
												<input type=text  name='p_from_pract_id' id='p_from_pract_id' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id1' id='practitioner_id1' value='?' class='button' onclick='searchCode1(this, p_from_pract_id)'>
											</td>
											<td width='30%'> 
												<input type=text  name='p_to_pract_id' id='p_to_pract_id' size="15" maxlength="15" align="center"><input type='button' name='practitioner_id2' id='practitioner_id2' value='?' class='button' onclick='searchCode1(this, p_to_pract_id)'>
											</td>
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
											<td  width='30%' class="label"><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.GroupCode.label" bundle="${common_labels}"/></td>
											<td class="fields" width='20%'  >
											<input type=text  name='p_from_cust_grp_code' id='p_from_cust_grp_code' size="2" maxlength="2" align="center"><input type='button' name='cust_grp_code' id='cust_grp_code' value='?' class='button' onclick='searchCode1(this, p_from_cust_grp_code)'>
											</td>
											<td class="fields" width='40%'>
												<input type=text  name='p_to_cust_grp_code' id='p_to_cust_grp_code' size="2" maxlength="2" align="center"><input type='button' name='cust_grp_code' id='cust_grp_code' value='?' class='button' onclick='searchCode1(this, p_to_cust_grp_code)'>
											</td>
										</tr>
										
										<tr>
											<td  width='30%' class="label"><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/>&nbsp;</td>
											<td class="fields" width='20%'  >
												<input type=text  name='p_from_cust_code' id='p_from_cust_code' size="8" maxlength="8" align="center"><input type='button' name='cust_code' id='cust_code' value='?' class='button' onclick='searchCode1(this, p_from_cust_code)'>
											</td>
											<td class="fields" width='40%'>
												<input type=text  name='p_to_cust_code' id='p_to_cust_code' size="8" maxlength="8" align="center"><input type='button' name='cust_code' id='cust_code' value='?' class='button' onclick='searchCode1(this, p_to_cust_code)'>
											</td>
										</tr>
										<tr>
											<td align='right' width='30%' class="label"><fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/> &nbsp;</td>
											<td width='40%'  >
												<input type=text  name='p_policy_type_code' id='p_policy_type_code' size="15" maxlength="15" align="center"><input type='button' name='p_policy_type' id='p_policy_type' value='?' class='button' onclick='searchCode1(this, p_policy_type_code)'>
											</td>
										</tr>
										<td  width='30%' class="label"><fmt:message key="eBL.POLICY.label" bundle="${bl_labels}"/>&nbsp;<fmt:message key="eBL.NUM.label" bundle="${bl_labels}"/></td>
										<td width='40%'  >
											<input type=text  name='p_policy_number' id='p_policy_number' size="30" maxlength="30" onkeypress="return CheckForSpecChars(event);" align="center">
										</td>
									</tr>
									<tr>
										<td align='right' width='30%' class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/> &nbsp;</td>
										<td width='40%'  >
											<input type="text"  name="p_patient_id" id="p_patient_id" align="left" size='<%=pid_length%>' maxlength='<%=pid_length%>' onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);"><input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">
										</td>
									</tr>


									<tr>
										<td align='right' width='30%' class="label">
											<fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> &nbsp;
										</td>
										<td  width='40%' align="left">
											<select name='p_order_by' id='p_order_by'>
														<option value='1'><fmt:message key="Common.Customer.label" bundle="${common_labels}"/>
														<option value='2'><fmt:message key="Common.Location.label" bundle="${common_labels}"/>
															<option value='3'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>

															</select>
														</td>
													</tr>
									<tr>
										<td align='right' width='100%' class="label" colspan='2'>
											<input type="button" name="export" id="export" value="Export" onclick="return fnExportToExcel();" />
										</td>
										
									</tr> 
													
													
													
													
													<!--
													<table width='80%' align='center' valign='top'>

														<tr>
															<td align='right' width='30%' class="label">
																<fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
																<td width='3%'><input type='radio' id='sum_id' name='p_sum_yn' id='p_sum_yn' value = 'Y' checked onClick="setValue();"></td>
																<td align='right' width='5%' class="label">
																	<fmt:message key="Common.Detail.label" bundle="${common_labels}"/></td>
																	<td><input type='radio' id='detail_id' name='p_sum_yn' id='p_sum_yn' value = 'N'  onClick="setValue();">  </td>
																</tr>


															</table> -->
		
															<input type="hidden" name="p_facility_id" id="p_facility_id"       value="<%= p_facility_id %>">
															<input type="hidden" name="p_module_id" id="p_module_id"         value="OP">
															<input type="hidden" name="p_report_id" id="p_report_id"         value="<%= p_report_id %>">
															<input type="hidden" name="p_user_name" id="p_user_name"         value="<%= p_user_name %>">

															<input type="hidden" name="p_function_id" id="p_function_id"		value="<%= function_id %>">
															<input type="hidden" name="p_function_name" id="p_function_name"		value="<%= function_name %>">
															<input type="hidden" name="p_function_type" id="p_function_type"		value="<%= function_type %>">
														</form>
														<% }
														catch(Exception e)
														{ out.println(e.toString());}
														finally{
														try{
														if(stmt != null) stmt.close();
														if(rset != null) rset.close();
													}
													catch(Exception e)
													{
													e.printStackTrace();
												}
												if( con !=null ) ConnectionManager.returnConnection(con,request);
											}
											%>
										</center>
									</body>
									</html>

