<!DOCTYPE html>
<HTML>
<%@ page import= "java.util.*" %>
<%@ page import="java.sql.Connection,com.ehis.util.DateUtils,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<% 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>	

<HEAD>
																									  
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>		      
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	    

<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eXH/js/ViewEvents.js"></script>
<script language="javascript">

function searchMembershipCheck()
{   
	parent.resultFrame.location.href='../../eCommon/html/blank.html';
	var patient_id = document.getElementById('patient_id').value;
	var encounter_id = document.getElementById('encounter_id').value;
	var practitioner_id = document.getElementById('practitioner_id').value;
	var patient_class = document.getElementById("patient_class").value;  
	var nursing_unit_code = document.getElementById("nursing_unit_code").value;
	var period_dt1 =  document.getElementById("msg_dt1").value;
	var period_dt2 =  document.getElementById("msg_dt2").value;
	var cust_id = document.getElementById("cust_id").value;
	var eligibility_check = document.getElementById("responseCode").value;
	var cust_group_code = document.getElementById("cust_group_code").value;
	var application_id = document.getElementById("applicationId").value;


	/*if(encounter_id=='')
	{ 
		alert(getMessage( 'XH1003','XH'));
		parent.parent.frames[0].document.forms[0].encounter_id.focus();
		return;
	} */
	var params= "patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt2+"&cust_id="+cust_id+"&eligibility_check="+eligibility_check+"&cust_group_code="+cust_group_code
		+"&application_id="+application_id;
	parent.frames[2].document.location.href='../../eXH/jsp/XHPatientMembershipCheckResult.jsp?'+params;
}

function clearSearch()
{
   
   parent.f_query_add_mod.location.reload();
   /*

   document.forms[0].patient_id.value="";
   document.forms[0].encounter_id.value="";
   document.forms[0].practitioner_id.value="";
   document.forms[0].patient_class.value=""; 
   document.forms[0].msg_dt1.value="";
   alert("6");
   document.forms[0].msg_dt2.value="";
   alert("7");
   document.forms[0].nursing_unit_code.value="";

   
   document.forms[0].encounter_desc.value="";
   document.forms[0].practitioner_name.value="";
   document.forms[0].nursing_unit_desc.value="";
   document.forms[0].cust_id.value="";
   document.forms[0].cust_name.value="";
   document.forms[0].eligibility_check.value="";
   	alert("3");
	*/
   parent.resultFrame.location.href='../../eCommon/html/blank.html';	
}


function clearSearchResult()
{
   parent.resultFrame.location.href='../../eCommon/html/blank.html';
}

async function getPatID()
	{					  
		var pat_id=await PatientSearch('','','','','','','','','','VIEW');
		if( pat_id != null )						
			document.forms[0].patient_id.value = pat_id ;					
	}

//Episode_id -  code  Encounter_id  - Desc
async function searchEncounterId(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.encounterid.label","Common");			
            var target=this.document.forms[0].encounter_id;
            var encounter_desc=this.document.forms[0].encounter_desc;
			var patient_id = this.document.forms[0].patient_id.value;

			if(patient_id!="" && patient_id!=null)
	        {
				sql="SELECT ENCOUNTER_ID code, EPISODE_ID description FROM pr_encounter WHERE  PATIENT_ID='"+patient_id+"' AND UPPER(ENCOUNTER_ID) LIKE UPPER(?) AND UPPER(EPISODE_ID) LIKE UPPER(?) ORDER BY 1 ";

			}
			else
			{
				sql="SELECT ENCOUNTER_ID code, EPISODE_ID description FROM pr_encounter WHERE  UPPER(ENCOUNTER_ID) LIKE UPPER(?) AND UPPER(EPISODE_ID) LIKE UPPER(?) ORDER BY 1 ";
			}
            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;

            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                encounter_desc.value=arr[1];
                 target.value=arr[0];
            }
            else{
                target.value=tdesc;
                encounter_desc.value=tcode;
            }
			
}// End of searchEncounterId

async function searchPractitionerId(){
     
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.practitioner.label","Common");			
            var target=this.document.forms[0].practitioner_name;
            var pract_id=this.document.forms[0].practitioner_id;
		
            sql="SELECT PRACTITIONER_ID code,PRACTITIONER_NAME description FROM am_practitioner WHERE  UPPER(PRACTITIONER_ID) LIKE UPPER(?) AND UPPER(PRACTITIONER_NAME) LIKE UPPER(?)  ORDER BY 1 ";

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//          argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;

            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                 pract_id.value=arr[0];
            }
            else{
                target.value=tdesc;
                pract_id.value=tcode;
            }
			
}// End of searchPractitionerId


async function searchNursingUnit(){
             
			var patient_class = document.forms[0].patient_class.value;
			if(patient_class=='')
			{ 
				alert("Select the Patient Class");
				document.forms[0].patient_class.focus();
				return;
			}
			var tdesc="";
            var tcode="";

            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ;
            var tit= getLabel("Common.nursingUnit.label","Common");			
            var target=this.document.forms[0].nursing_unit_desc;
            var nursing_unit_code=this.document.forms[0].nursing_unit_code;
		    if(patient_class == "IP")
			{
			  sql = "select NURSING_UNIT_CODE code, long_desc description from ip_nursing_unit where upper(NURSING_UNIT_CODE) LIKE upper(?) AND upper(LONG_DESC) LIKE upper(?) order by 1";
			}
			else
			{
			  sql = "select clinic_code code, long_desc description from op_clinic where upper(clinic_code) LIKE upper(?) AND upper(long_desc) LIKE upper(?) order by 1";
			}

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
//            argumentArray[4] = "2,1";
		    argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ;

            retVal = await CommonLookup( tit, argumentArray );

            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                nursing_unit_code.value=arr[0];
            }
            else{
                target.value=tdesc;
                nursing_unit_code.value=tcode;
            }
			
}// End of searchNursingUnit


async function searchCompanyName()
{
	var tdesc="";
	var tcode="";

	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.practitioner.label","Common");			
	var target=this.document.forms[0].cust_name;
	var cust_id=this.document.forms[0].cust_id;

	sql="SELECT CUST_CODE code,SHORT_NAME description FROM ar_customer WHERE  UPPER(CUST_CODE) LIKE UPPER(?) AND UPPER(SHORT_NAME) LIKE UPPER(?)  ORDER BY 1 ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//          argumentArray[4] = "2,1";
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		cust_id.value=arr[0];
	}
	else{
		target.value=tdesc;
		cust_id.value=tcode;
	}
}

async function searchCustGroup()
{
	var tdesc="";
	var tcode="";

	var retVal =new String();
	var argumentArray  = new Array() ;
	var dataNameArray  = new Array() ;
	var dataValueArray = new Array() ;
	var dataTypeArray  = new Array() ;
	var tit= getLabel("Common.CustomerGroup.label","Common");			
	var target=this.document.forms[0].cust_group_code_desc;
	var custGrpCode=this.document.forms[0].cust_group_code;

	sql="SELECT CUST_GROUP_CODE code,SHORT_DESC description FROM ar_cust_group WHERE  UPPER(CUST_GROUP_CODE) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?)  ORDER BY 1 ";

	argumentArray[0] = sql;
	argumentArray[1] = dataNameArray ;
	argumentArray[2] = dataValueArray ;
	argumentArray[3] = dataTypeArray ;
//          argumentArray[4] = "2,1";
	argumentArray[4] = "1,2";
	argumentArray[5] = target.value;
	argumentArray[6] = DESC_LINK  ;
	argumentArray[7] = DESC_CODE ;

	retVal = await CommonLookup( tit, argumentArray );

	if(retVal != null && retVal != "" ){
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target.value=arr[1];
		custGrpCode.value=arr[0];
	}
	else{
		target.value=tdesc;
		custGrpCode.value=tcode;
	}
}


function clearNursingUnit()
{
	document.forms[0].nursing_unit_code.value="";
	document.forms[0].nursing_unit_desc.value="";
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	

<BODY leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown='submitFormOnEnter()' >
<% 

String period_dt1 = "";
String period_dt2 = "";
   
period_dt1 = period_dt2 = DateUtils.getCurrentDate("DMY",locale);

Statement stmt=null;
ResultSet rset=null, rs = null ;
Connection con=null;
String pid_length="";
//String ID="";
//String dat="";
//String en="";
try{
con=ConnectionManager.getConnection(request); 

//String sql="";

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
if(con != null) con.close();

}catch(Exception e)
{
   e.printStackTrace();
}

%>
<form name="PatientMembershipMaster" id="PatientMembershipMaster" method="post">
<fieldset style=" border-color:grey;">
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td class=label width="10%"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<INPUT TYPE="text" id="patient_id" name="patient_id"  align="left" size='20' maxlength='<%=pid_length%>'  value="" onBlur="ChangeUpperCase(this);" onkeypress="return CheckForSpecChars(event);">
		<input type="button" value="?" class="button" name='pat_search' id='pat_search' onClick="getPatID()">
	</td>
	<td class=label width="10%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	     <input type="hidden"  name="encounter_desc" id="encounter_desc">
		<INPUT TYPE="text"  name="encounter_id" id="encounter_id" onBlur='searchEncounterId()'  value="">
		<input class="BUTTON" type="button"  name="encounterIDSearch" id="encounterIDSearch" value='?' onClick="searchEncounterId()">
	</td>
</tr>
<tr>
	<td class=label width="10%"><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<input type=text name="msg_dt1" id="msg_dt1" value="<%=period_dt1 %>" size=11 onBlur='isAfterCurrDate(this);'> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('msg_dt1','dd/mm/y');" >
		<input type=text name="msg_dt2" id="msg_dt2" value="<%=period_dt2 %>" size=11 onBlur='isAfterCurrDate(this);'> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('msg_dt2','dd/mm/y');" >
	</td>
	<td class=label width="10%"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	    <input type="hidden" name="practitioner_id" id="practitioner_id">
		<INPUT TYPE="text"  name="practitioner_name" id="practitioner_name" onBlur='searchPractitionerId()' >
		<input class="BUTTON" type="button"  name="practitionerIDSearch" id="practitionerIDSearch" value='?' onClick="searchPractitionerId()">
	</td>
</tr>
<tr>
	<td class=label width="10%"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<select name="patient_class"  id="patient_class" style="width: 200px" onSelect="clearNursingUnit()" onBlur="clearNursingUnit()">
		<option value = ''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
		<option value="OP"><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/>
		<option value="EM"><fmt:message key="Common.emergency.label" bundle="${common_labels}"/>
		<option value="IP"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/>
		<option value="DC"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/>
		</select>
		<!-- <img src='../../eCommon/images/mandatory.gif'> -->
	</td>
	<td class=label width="10%"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
	<td class='fields'>
	    <input type="hidden"  name="nursing_unit_code" id="nursing_unit_code">
		<INPUT TYPE="text"  name="nursing_unit_desc" id="nursing_unit_desc" onBlur='searchNursingUnit()'>
		<input class="BUTTON" type="button"  name=nursingUnitSearch value='?' onClick="searchNursingUnit()">
	</td>
</tr>
<tr>
	<td class=label width="10%"><fmt:message key="Common.Payer.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
	    <input type="hidden" name="cust_id" id="cust_id">
		<INPUT TYPE="text"  name="cust_name" id="cust_name"  onBlur='searchCompanyName()'>
		<input class="BUTTON" type="button"  name=companyNameSearch value='?' onClick="searchCompanyName()"> 
	</td>
	<td class=label width="10%"><fmt:message key="Common.EligibilityCheck.label" bundle="${common_labels}"/></td>
	
	<td class='fields'>
		<select name="responseCode" id="responseCode"  style="width: 150px" onChange='clearSearchResult()'>
		<option value = ''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
	<% 
		try															    
		{  
			con=ConnectionManager.getConnection(request); 
			String queryApplication = "SELECT list_elmt_value, list_elmt_label FROM sm_list_item WHERE module_id='XH' AND list_ref='HSELIGIFL'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);	
			
			System.out.println(" queryApplication ::: "+queryApplication);
			
			while(rs.next())
			{
				System.out.println(" Inside RS ::: ");
			%>	 	
				
				<option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(2)%></option> 
	        <%
			}

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1) "+e1.toString());
		}		
	%>
	</select>
	</td>
</tr>
<tr>
	<td class=label width="10%"><fmt:message key="eBL.PAYER_GROUP.label" bundle="${bl_labels}"/></td>
	
	<td class='fields'>
		<input type="hidden"  name="cust_group_code" id="cust_group_code">
		<INPUT TYPE="text"  name="cust_group_code_desc" id="cust_group_code_desc" onBlur='searchCustGroup()'>
		<input class="BUTTON" type="button"  name=custGroupCodeSearch value='?' onClick="searchCustGroup()">
	</td>
	
	<td class=label width="10%"><fmt:message key="Common.Application.label" bundle="${common_labels}"/></td>
	<td class='fields'>
		<select name="applicationId" id="applicationId"  style="width: 150px" onChange='clearSearchResult()'>
		<option value = ''><fmt:message key="Common.Select.label" bundle="${common_labels}"/></option>
	<% 
		try															    
		{  
			con=ConnectionManager.getConnection(request); 
			String queryApplication = "SELECT application_id, APPLICATION_NAME FROM xh_application WHERE ELG_CHK_APPL_YN = 'Y'";
			stmt = con.createStatement();
			rs	 =	stmt.executeQuery(queryApplication);	
			
			System.out.println(" queryApplication ::: "+queryApplication);
			
			while(rs.next())
			{
				System.out.println(" Inside RS ::: ");
			%>	 	
				
				<option value='<%=rs.getString(1).toString().trim()%>' ><%=rs.getString(2)%></option> 
	        <%
			}

			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(con != null) con.close();
			
		}
		catch(Exception e1)
		{
			System.out.println("(CommProtocolIdQueryCriteria.jsp:Exception-1) "+e1.toString());
		}		
	%>
	</select>
	</td>


</tr>
</table>
<table width='100%' cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
		<input class='BUTTON' type="button"  id="search" name="search" value='Search' onClick="searchMembershipCheck()">
		<input class='BUTTON' type="button"  id="clear" name="clear" value='Clear' onClick="clearSearch()">
		</td>
	</tr>
</table>
</fieldset>
</form>
</body>
</html>

