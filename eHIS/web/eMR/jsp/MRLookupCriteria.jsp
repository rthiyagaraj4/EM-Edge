<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<%

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con 			= null;
	Statement  stmt			= null;
	PreparedStatement pstmt = null;
	ResultSet  rs 			= null;
	ResultSet rset	= null;
	try
	{
		con = ConnectionManager.getConnection(request);
		// added for assign bed on 3/8/2005 by Sridhar R 
		String chg_nurs_unit_in_assign_bed_yn		= checkForNull(request.getParameter("chg_nurs_unit_in_assign_bed_yn"),"N");

		String chk_in_lodger_max_period		= checkForNull(request.getParameter("chk_in_lodger_max_period"),"0");
		String bed_block_period_max			= checkForNull(request.getParameter("bed_block_period_max"));
		String bl_install_yn						= checkForNull(request.getParameter("bl_install_yn"));
		String bedBlock_normal					= checkForNull(request.getParameter("bedBlock_normal"));
		String max_blk_type						= checkForNull(request.getParameter("max_blk_type"));
		String oper_stn_id						= checkForNull(request.getParameter("oper_stn_id"));
		String routine_tfr_yn						= "";
		String jsp_name							= checkForNull(request.getParameter("jsp_name"));
		String win_height							= checkForNull(request.getParameter("win_height"));
		String win_width							= checkForNull(request.getParameter("win_width"));
		String call_function						= checkForNull(request.getParameter("call_function"));
		String modal								= checkForNull(request.getParameter("modal"));
		String dialogTop							= checkForNull(request.getParameter("dialogTop"));
		String module								= checkForNull(request.getParameter("module"));
		String model_window						= checkForNull(request.getParameter("model_window"));
		String function_id							= checkForNull(request.getParameter("function_id"));
		String function_name					= checkForNull(request.getParameter("function_name"));
		String prog_id								= checkForNull(request.getParameter("prog_id"));
		String wherecondn						= checkForNull(request.getParameter("wherecondn"));
		String operstn								= checkForNull(request.getParameter("oper_stn_id"));
		String targetURL							= checkForNull(request.getParameter("targetURL"));
		String facilityID							= (String)session.getValue("facility_id");
		String loginUser							= (String)session.getValue("login_user");
		String practitioner_id						= checkForNull(request.getParameter("practitioner_id"));
		String encounterID_repDischargeAdvice		= checkForNull(request.getParameter("encounter_id"));
		StringBuffer sbSql							= new StringBuffer();
		String systemdate							= "";
		String chk_in_lodger_min_date				= "";
		String systemdate_converted					= "";
		String patient_id_length					= "";
		String dis_adv_chk							= "";
		String dis_adv_val							= "N";
		String display_discharge_pat_list			= "";
		//out.println("oper_stn_id::"+oper_stn_id);
		//out.println("call_function::"+call_function);
		String loctype ="";
		String loctypedesc="";
		
		try
		{
			if(oper_stn_id.equals("") || call_function.equals("TransferPatientOut"))
			{
				sbSql.append(" select a.oper_stn_id oper_stn_id,a.routine_tfr_yn, to_char(sysdate,'dd/mm/rrrr') systemdate,(select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b 	   ");
				sbSql.append(" where a.facility_id=? and a.facility_id=b.facility_id	   ");
				sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id =?   ");
				sbSql.append( " and trunc(sysdate) between b.eff_date_from and ");
				sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
				//stmt = con.createStatement();
				pstmt = con.prepareStatement(sbSql.toString());
				pstmt.setString(1,facilityID);
			    pstmt.setString(2,loginUser);
				rs = pstmt.executeQuery();

				if(rs!=null)
				{
					while(rs.next())
					{
						systemdate		= checkForNull(rs.getString("systemdate"));
						if(!(systemdate==null || systemdate.equals("")))
						systemdate_converted = DateUtils.convertDate(systemdate,"DMY","en",locale); 			
						operstn			= checkForNull(rs.getString("oper_stn_id"));
						routine_tfr_yn	= checkForNull(rs.getString("routine_tfr_yn"));
						patient_id_length	= checkForNull(rs.getString("patient_id_length"));
					}
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
				}
			}
			else
			{
					sbSql.append(" select patient_id_length,to_char(sysdate,'dd/mm/rrrr'), to_char(trunc(sysdate)-round(");
					sbSql.append("?");
					sbSql.append("/24),'dd/mm/yyyy') from mp_param where  module_id = 'MP' ");
					//stmt = con.createStatement();
					pstmt = con.prepareStatement(sbSql.toString());
					pstmt.setString(1,chk_in_lodger_max_period);
					rs = pstmt.executeQuery();

					if(rs!=null && rs.next())
					{
						patient_id_length	= checkForNull(rs.getString(1));
						systemdate	= checkForNull(rs.getString(2));
						if(!(systemdate==null || systemdate.equals("")))
							systemdate_converted = DateUtils.convertDate(systemdate,"DMY","en",locale); 
						chk_in_lodger_min_date	= checkForNull(rs.getString(3));
						if(rs!=null) rs.close();
						if(pstmt!=null) pstmt.close();
					}
				
				
				operstn = oper_stn_id;
			}

		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if (sbSql.length() > 0)
          	sbSql.delete(0, sbSql.length());
	%>
<head>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<Script src="../../eIP/js/IPLookup.js" language="JavaScript"></Script>
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<Script src="../../eIP/js/IPPractitionerComponent.js" language="JavaScript"></Script>
	
	<script src="../../eMR/js/MRPatientMovementHistory.js" language="JavaScript" ></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


 
<script>

function compareDates1()
{ 
	var from = document.forms[0].from_date1;
	var to = document.forms[0].to_date1;
	
	if(from.value !='' && to.value !='')// DateUtils.js
	{
		if(validDate(from.value,"DMY",localeName) && validDate(to.value,"DMY",localeName))
		{  
			var fromDt	= convertDate(document.forms[0].from_date1.value,"DMY",localeName,"en");
			var toDt	= convertDate(document.forms[0].to_date1.value,"DMY",localeName,"en");
			
			if(!isBefore(fromDt,toDt,'DMY',"en"))// DateUtils.js // modified by mujafar for SRR20056-SCF-16103
			{
				alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
				document.forms[0].to_date1.select();
			}
		}
	}

}
function callGetPractitioner(obj,target)
		{ //alert('iiii');
			
			var facility_id = document.forms[0].facilityID.value;
			var loginuser   = document.forms[0].loginUser.value;
            var locale=document.forms[0].locale.value; 

			target.value=trimString(target.value);
			if(target.value=="" && window.event.target == target)
			{
				document.forms[0].practid1.value="";
				return;
			}
			
			if(document.forms[0].speciality_desc && document.forms[0].speciality_desc.value!=null)
				speciality=document.forms[0].speciality_desc.value;     
			
			getPractitioner1(obj,target,facility_id,speciality,'','','','','','',"Q2");
			
	
							
					
			
		}
		
		
		
		
		function chkEncounter()
		{
			
			clearList();
			document.forms[0].Qloctype.value="";
			document.forms[0].nursing_unit_desc.value="";
			document.forms[0].nursing_unit.value=""; 
			document.forms[0].admn_date_from.value="";
			document.forms[0].admn_date_from1.value="";
			document.forms[0].admn_date_to.value="";
			document.forms[0].admn_date_to1.value=""; 
			document.forms[0].specialty_desc.value="";
			document.forms[0].speciality_desc.value="";
			document.forms[0].Splcode.value="";
			document.forms[0].speciality_code.value=""; 
			document.forms[0].practid_desc.value="";
			document.forms[0].practid_desc1.value="";
			document.forms[0].practid.value="";
			document.forms[0].practid1.value="";
			document.forms[0].encounter_id.value="";
			document.forms[0].encounter_id1.value="";
			parent.frames[1].document.forms[0].patient_id.value="";
			
			if(document.forms[0].encounter_type_sel.value == "IP" || document.forms[0].encounter_type_sel.value == "DC" )
			{	
				document.getElementById("check1").style.display="none";
				document.getElementById("check").style.display="inline";
				
			}
			if(document.forms[0].encounter_type_sel.value == "OP" || document.forms[0].encounter_type_sel.value == "EM" )
			{
				document.getElementById("check").style.display="none";
				document.getElementById("check1").style.display="inline";
			}
		} 
		
	 function clearList()
{

document.forms[0].Qloc.value="";    
document.forms[0].Qloc1.value="";     
clearAll();   

 

}	
		

async function getValues(obj,target,targetId)
		{
			var locale=document.forms[0].locale.value
			var tit="";
			var facilityid =document.forms[0].facilityID.value;
			var dataNameArray  = new Array() ;
		     var dataValueArray = new Array() ;
		     var dataTypeArray  = new Array() ;
			var argumentArray=new Array(8);
			var sql="";
			var sqlSecond="";
			target.value=trimString(target.value);
			if(target.value=="" && window.event.target == target)
			{
				targetId.value="";
				return;
			}

			
			
			
			if(obj.name=="speciality_button")
			{
				tit=getLabel("Common.speciality.label","Common");							

				argumentArray[0]="select SPECIALITY_CODE code, am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2) description from AM_SPECIALITY where EFF_STATUS = 'E' and upper(speciality_code) like upper(nvl(?,speciality_code)) and upper(am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)) like upper(nvl(?,am_get_desc.am_speciality(SPECIALITY_CODE,'"+locale+"',2)))"; 

				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=CODE_DESC_LINK;
				argumentArray[7]=CODE_DESC;

			}
			
			var retVal=await CommonLookup(tit,argumentArray);
			
			if(retVal ==null || retVal=="" || !retVal)
			{
				target.value="";
				targetId.value="";
			}
			else
			{
				targetId.value=retVal[0];
				target.value=retVal[1];
			}
		}
function onBlurgetLoc(loginuser,oper_id,fac_id,objval,target)
{ 

		 
		if(target.value == "")
		{
			target.value="";
			document.forms[0].Qloc.value="";
			return;
		}
 getLocn(loginuser,oper_id,fac_id,objval,target);

}
async function getLocn(loginuser,oper_id,fac_id,objval,target)
{  
//alert(objval);
   var retVal =    new String();
   var argumentArray  = new Array() ;
   var dataNameArray  = new Array() ;
   var dataValueArray = new Array() ;
   var dataTypeArray  = new Array() ;
   var tit="";				
   locale=document.forms[0].locale.value; 
   
   tit=getLabel("Common.Location.label",'Common')
   
   if(document.forms[0].encounter_type_sel.value == "OP" )
   {
		sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'A' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and b.oper_stn_id = '"+oper_id+"' and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";
   }
   else
	  {
		sql ="SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+fac_id+"' AND a.language_id='"+locale+"' AND a.level_of_care_ind = 'E' AND a.eff_status='E' AND a.clinic_type = '"+objval+"' and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+loginuser+"' and b.oper_stn_id = '"+oper_id+"' and b.manage_queue_yn = 'Y' and  upper(clinic_code) like upper(?) and upper(long_desc) like upper(?) and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N' ";
		   
	   }

		
		sql=sql+"  ORDER BY  2";
		
  //alert(sql);
   
  				
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;

				retVal = await CommonLookup( tit, argumentArray );
				
				if(retVal != null && retVal != "" )
                {

	             var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
				document.forms[0].Qloc.value=arr[0];


          }
}
function clearAll()
{
		//document.forms[0].reset(); 
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
if(parent.messageFrame)
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

	document.forms[0].search.disabled=false;
}
function BeforeGetPractitioner(obj, target, details)
{ 
		if(document.forms[0].practid_desc1.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].practid1.value =""
	

}
function PractLookupRetVal(retVal,objName)
{ 
	var arr;
	if (retVal != null)
	{ 
		
		arr=retVal.split("~");
		
			if(objName == "practid_desc"){ 
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];
			}
				if(objName == "practid_desc1")
				{ 
					document.forms[0].practid1.value=arr[0];
					document.forms[0].practid_desc1.value=arr[1];
				}
		
	}
	else
	{ 
		if(objName == "practid_desc")
		{
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";	
		}
		if(objName == "practid_desc1")
				{
					document.forms[0].practid1.value="";
					document.forms[0].practid_desc1.value="";
				}
		
		
	}
}
function getPractitionerLocal(obj, target, details)
{ 
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	
		practId_FName=document.forms[0].practid.name;

	var facility_id		= "<%=facilityID%>";
	var locale			= "<%=locale%>";
		getPractitioner(obj, target, facility_id, "","","Q3");

}
function submitPage()
{
	
	var condition=""
	for(var i=0; i<document.forms[0].elements.length; i++)
	{
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
	}
	
	//alert("condition==>"+condition);
	
	document.forms[0].search.disabled=true;
	oper_stn = document.forms[0].operstn.value;
	routine_tfr_yn = document.forms[0].routine_tfr_yn.value;
	call_function =document.forms[0].call_function.value;
	//alert('document.forms[0].modal.value::'+document.forms[0].modal.value);
	
	
		var patient_class_val = document.forms[0].encounter_type_sel.value ;
	if(document.forms[0].modal.value == 'yes')
	{
		
		
			
			parent.frames[1].location.href= '../jsp/MRLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&pat_class='+patient_class_val+'&call_function='+call_function+'&show_bed_yn=Y&opst='+oper_stn+'';
		
	}
	else
	{  
		
				var exclude_nda_pats="N";
				
				
				parent.frames[2].location.href= '../jsp/MRLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&pat_class='+patient_class_val+'&show_bed_yn=Y&opst='+oper_stn+'&exclude_nda_pats='+exclude_nda_pats+'';
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			
		
	}
	
	
}
</script>
</head>
	<body onSelect="codeArrestThruSelect();" onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="FocusFirstElement();//checkForMPRequest();">
		<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			
			<tr>
			<td class=label width='25%'  nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td class=fields width='25%' ><select name="encounter_type_sel" id="encounter_type_sel" onchange="chkEncounter();" >
		<%	
		try{	
		stmt = con.createStatement();
			rset = null;
			rset = stmt.executeQuery("select PATIENT_CLASS, short_desc from  Am_PATIENT_CLASS where patient_class not in ('XT') ")  ;
			if(rset != null)
			{									
				while (rset.next())
				{	%>
					<option value='<%=rset.getString("PATIENT_CLASS")%>'><%=rset.getString("short_desc")%></option>
		<%     }
			}
		}
		catch(Exception e)
		{
			if(rset != null) rset.close();
			if(stmt!=null) stmt.close();
		}
		
			%>
		</select></td>
		<td width='25%' ></td><td width='25%' ></td>
			</tr>
			</table>
			<div id="check" style="display:inline"> 
			
			<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
			<tr>
					
					<!-- <td class='label' width='25%'><script>getLabel("Common.nursingUnit.label","common")</script><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
					<td CLASS='fields' width='25%'><input type=text name="nursing_unit_desc" id="nursing_unit_desc" size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','to');"><input type=hidden  name="nursing_unit" id="nursing_unit" size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facilityID%>','to');" ></td>-->
					
					<td class='label' width='25%'><script>getLabel("Common.nursingUnit.label","common")</script><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
					<td CLASS='fields' width='25%'><input type=text name="nursing_unit_desc" id="nursing_unit_desc" size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','to');"><input type=hidden  name="nursing_unit" id="nursing_unit" size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facilityID%>','to');" ></td>
					
					
					
					
					
					
					
					<td class='label'  nowrap width="25%"><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
				
					<td   class='fields' width='25%'  nowrap><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' id='from_date'  onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_from.focus();return showCalendar('admn_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="admn_date_to"   maxlength='10' size='10' name='to_date' id='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_to.focus();return showCalendar('admn_date_to');" ></td>
			</tr>
			<tr>
					<td  class='label' width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type=text name='specialty_desc' id='specialty_desc' size='15' maxlength='15' onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>','to');"><input type='hidden' class='label' name='Splcode' id='Splcode' size=15 readonly><input type='button' class='button' name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>','to');"></td>
					
					<td  class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc,'to');"></td>
			</tr>
			<tr>
			<td class='label' nowrap width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>
			<td width='25%' ></td><td width='25%' ></td>
			</tr>
								
</table>

</div>
<div id="check1" style="display:none"> 
<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0' >
<tr>
<td   class='label' width='25%' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/>
				<td  class='Fields' width='25%' nowrap>
					<select name="Qloctype" id="Qloctype" onChange="clearList()">
						<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------
							<%	StringBuffer sql = new StringBuffer();
							     rset = null;
								sql.append("select locn_type,short_desc from am_care_locn_type_lang_vw where care_locn_type_ind in ('C','E') and SYS_USER_DEF_IND='S' and language_id='"+locale+"' order by short_desc");

								rset=stmt.executeQuery(sql.toString());
								if(rset != null)
								{
									while(rset.next())
									{
										loctype=rset.getString("locn_type");
										loctypedesc=rset.getString("short_desc");
										%>
											<option value="<%=loctype%>" ><%=loctypedesc%>
										<%
									}
								}						  
							  if (rset != null)       rset.close();
							 // sql.setLength(0);						

				%>
				
			</select>
			</td>
			<td class='label' width='25%'  ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
			<td class='Fields' width='25%' >
			<INPUT TYPE="text" name="Qloc1" id="Qloc1"  onBlur="onBlurgetLoc('<%=loginUser%>','<%=operstn%>','<%=facilityID%>',document.forms[0].Qloctype.value,document.forms[0].Qloc1)"><input type="button" name="qloc_butt" id="qloc_butt" value="?" class="button" onClick="getLocn('<%=loginUser%>','<%=operstn%>','<%=facilityID%>',document.forms[0].Qloctype.value,document.forms[0].Qloc1)" >
			<input type="hidden" name="Qloc" id="Qloc">
			</td>
			</tr>
			<tr>
			
			<td class="label" width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' ><input type="text" name ="speciality_desc" maxlength="15" size="15" onBlur="getValues(speciality_button,this,speciality_code)"><input type='button' class='button'  name='speciality_button' id='speciality_button' value='?' onclick="getValues(this,speciality_desc,speciality_code)"><input type='hidden' name='speciality_code' id='speciality_code' value=''></td>
		
		<td class='label'  nowrap width="25%"><fmt:message key="Common.VisitDateFrom.label" bundle="${common_labels}"/></td>
				
					<td   class='fields' width='25%'  nowrap><input type='text' id="admn_date_from1" maxlength='10' size='10' name='from_date1' id='from_date1'  onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates1();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_from1.focus();return showCalendar('admn_date_from1');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="admn_date_to1"   maxlength='10' size='10' name='to_date1' id='to_date1' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates1();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_to1.focus();return showCalendar('admn_date_to1');" ></td>
			
			</tr>
		<tr>
		<td class='label' nowrap width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id1' id='encounter_id1' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>		
		<td  class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type='text' name='practid_desc1' id='practid_desc1' size="25" maxlength="30" onblur="callGetPractitioner(document.forms[0].pract_id_search1,practid_desc1);" value=""><input type='hidden' name='practid1' id='practid1' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search1' id='pract_id_search1' value='?' class='button' onClick="callGetPractitioner(this,practid_desc1);"></td>
		
		
		</tr>
		
			



</tr>
</table>

</div>

<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
<tr>
			
			<td colspan=6>
						<jsp:include page="../../eIP/jsp/IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
				</td>
				
		</tr>

		<tr>
			<td width = "75%" class='white' >&nbsp;</td>
			<td width = "25%" class='white' align="right"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'>

			</td>
		</tr>
	

		


	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >

	<input type='hidden' name='win_height' id='win_height' value="<%=win_height%>" >
	<input type='hidden' name='win_width' id='win_width' value="<%=win_width%>" >
	<input type='hidden' name='param' id='param' value="<%=call_function%>" >	
	<input type='hidden' name='dialogTop' id='dialogTop' value="<%=dialogTop%>" >
	<input type='hidden' name='modal' id='modal' value="<%=modal%>" >
	<input type='hidden' name='module' id='module' value="<%=module%>" >
	<input type='hidden' name='model_window' id='model_window' value="<%=model_window%>" >
	<input type='hidden' name='function_name' id='function_name' value="<%=function_name%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='call_function' id='call_function' value="<%=call_function%>" >
	<input type='hidden' name='prog_id' id='prog_id' value="<%=prog_id%>" >
	<input type='hidden' name='practitioner_id' id='practitioner_id' value="<%=practitioner_id%>" >
	<input type='hidden' name='operstn' id='operstn' value="<%=operstn%>" >
	<input type='hidden' name='routine_tfr_yn' id='routine_tfr_yn' value="<%=routine_tfr_yn%>" >
	<input type='hidden' name='loginUser' id='loginUser' value="<%=loginUser%>" >
	<input type='hidden' name='targetURL' id='targetURL' value="<%=targetURL%>" >
	<input type='hidden' name='wherecondn' id='wherecondn' value="<%=wherecondn%>" >
	<input type='hidden' name='bed_block_period_max' id='bed_block_period_max' value="<%=bed_block_period_max%>" >
	<input type='hidden' name='bl_install_yn' id='bl_install_yn' value="<%=bl_install_yn%>" >
	<input type='hidden' name='bedBlock_normal' id='bedBlock_normal' value="<%=bedBlock_normal%>" >
	<input type='hidden' name='max_blk_type' id='max_blk_type' value="<%=max_blk_type%>" >
	<input type='hidden' name='oper_stn_id' id='oper_stn_id' value="<%=oper_stn_id%>" >
	<input type='hidden' name='systemdate' id='systemdate' value="<%=systemdate%>" >
	<input type='hidden' name='chk_in_lodger_min_date' id='chk_in_lodger_min_date' value="<%=chk_in_lodger_min_date%>">
	<input type='hidden' name='chg_nurs_unit_in_assign_bed_yn' id='chg_nurs_unit_in_assign_bed_yn' value="<%=chg_nurs_unit_in_assign_bed_yn%>" >
	<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>" >
	<input type='hidden' name='locale' id='locale' value="<%=locale%>" >
	<input type='hidden' name='patient_id_length' id='patient_id_length' value="<%=patient_id_length%>" >
	<input type='hidden' name='facilityID' id='facilityID' value="<%=facilityID%>" >
</form>
</body>
<% 
	if(rset != null) rset.close(); 
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	
}catch(Exception e)	
{
	

	e.printStackTrace();
}
finally
{
	if(con != null)
	ConnectionManager.returnConnection(con,request);
}
%>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}
%>

