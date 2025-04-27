<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,com.ehis.util.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale			= (String)session.getAttribute("LOCALE");
	Connection con 			= null;
	Statement  stmt			= null;
	ResultSet  rs 			= null;
	ResultSet rset	= null;
	Boolean isBasedOnNameFilterAppl = false;
	
	//Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
	Boolean isPatIdMandAppl =  false;
	//Maheshwaran K added for TH-KW-CRF-0141.1
	Boolean isCoderClearance =  false;
	try
	{
		con = ConnectionManager.getConnection(request);

		//Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
		isPatIdMandAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "MAKE_PAT_ID_MAND");
		isCoderClearance = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "IP_DISCHAGE_PAT_CODER_CLR");//Maheshwaran K added for TH-KW-CRF-0141.1					
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
		if(call_function.equals("DischargePatient"))
		{
			display_discharge_pat_list				= checkForNull(request.getParameter("display_discharge_pat_list"),"A");

			if(display_discharge_pat_list.equals("D"))
			{
				dis_adv_chk							= "checked";
				dis_adv_val							= "Y";
			}else
			{
				dis_adv_chk							= "";
				dis_adv_val							= "N";
			}

		}
		try
		{
			if(oper_stn_id.equals("") || call_function.equals("TransferPatientOut"))
			{
				sbSql.append(" select a.oper_stn_id oper_stn_id,a.routine_tfr_yn, to_char(sysdate,'dd/mm/rrrr') systemdate,(select patient_id_length  from mp_param where  module_id = 'MP' )patient_id_length from am_oper_stn a, am_user_for_oper_stn b 	   ");
				sbSql.append(" where a.facility_id='"+facilityID+"' and a.facility_id=b.facility_id	   ");
				sbSql.append(" and a.oper_stn_id = b.oper_stn_id and b.appl_user_id ='"+loginUser+"'   ");
				sbSql.append( " and trunc(sysdate) between b.eff_date_from and ");
				sbSql.append(" nvl(b.eff_date_to,trunc(sysdate)) ");
				stmt = con.createStatement();
				rs = stmt.executeQuery(sbSql.toString());

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
					if(stmt!=null) stmt.close();
				}
			}
			else
			{
					sbSql.append(" select patient_id_length,to_char(sysdate,'dd/mm/rrrr'), to_char(trunc(sysdate)-round(");
					sbSql.append(chk_in_lodger_max_period);
					sbSql.append("/24),'dd/mm/yyyy') from mp_param where  module_id = 'MP' ");
					stmt = con.createStatement();
					rs = stmt.executeQuery(sbSql.toString());

					if(rs!=null && rs.next())
					{
						patient_id_length	= checkForNull(rs.getString(1));
						systemdate	= checkForNull(rs.getString(2));
						if(!(systemdate==null || systemdate.equals("")))
							systemdate_converted = DateUtils.convertDate(systemdate,"DMY","en",locale); 
						chk_in_lodger_min_date	= checkForNull(rs.getString(3));
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
					}
				
				
				operstn = oper_stn_id;
			}

		}catch(Exception e)
		{
			
			e.printStackTrace();
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if (sbSql.length() > 0)
          	sbSql.delete(0, sbSql.length());
	%>
	
	<!--Santhosh Start ML-MMOH-CRF-1894-->
<%
		
		String sql="";
		Statement stmt1 = null;
		Statement stmt2 = null;

		ResultSet rs1 = null;
		ResultSet rs2 = null;
		ResultSet rs3 = null;
		
		stmt1 = con.createStatement();
		stmt2 = con.createStatement();
		
		
		
		if(function_id == null)	function_id = "";
		
		String First_Name_Accept_Yn ="";
		int First_Name_Order=0;
		String First_Name_Prompt ="";
		String Second_Name_Accept_Yn ="";
		int Second_Name_Order =0;
		String Second_Name_Prompt ="";
		String Third_Name_Accept_Yn ="";
		int Third_Name_Order =0;
		String Third_Name_Prompt ="";
		String Family_Name_Accept_Yn ="";
		int Family_Name_Order =0;
		String Family_Name_Prompt ="";
		
		String Name_Suffix_Accept_Yn ="";
		String Name_Suffix_Prompt ="";
		String Name_Prefix_Accept_Yn = "";
		String Name_Prefix_Prompt = "";
		
		String First_Name_Reqd_Yn ="";
		String Second_Name_Reqd_Yn ="";
		String Third_Name_Reqd_Yn ="";
		String Family_Name_Reqd_Yn ="";
		String Name_Suffix_Reqd_Yn ="";
		String Name_Prefix_Reqd_Yn ="";
		String patient_id_len="";
		
		String pat_name_as_multipart_yn = "";
		String dflt_sndx_type = "";

		String fam_name_ind="N"; 
		String searchBy_first_name="";
		String searchBy_second_name="";
		String searchBy_third_name="";
		String searchBy_family_name="";
		
		String first_name_length		= "";
		String second_name_length		= "";
		String third_name_length		= "";
		String family_name_length		= "";
		isBasedOnNameFilterAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "RIP_REFERRAL_NAME_FILTER");


		

			sql = "Select NVL(first_name_accept_yn,'N') first_name_accept_yn, First_Name_Order, NVL(first_name_prompt,'First Name') first_name_prompt, NVL(second_name_accept_yn,'N') second_name_accept_yn, Second_Name_Order, NVL(second_name_prompt,'Second Name') second_name_prompt , NVL(third_name_accept_yn,'N') third_name_accept_yn, Third_Name_Order, NVL(third_name_prompt,'Third Name') third_name_prompt, NVL(family_name_accept_yn,'N') family_name_accept_yn, Family_Name_Order, NVL(family_name_prompt,'Family Name') family_name_prompt , NVL(name_suffix_accept_yn,'N') name_suffix_accept_yn, NVL(name_prefix_accept_yn,'N') name_prefix_accept_yn, NVL(name_suffix_prompt,'Name Suffix') name_suffix_prompt, NVL(name_prefix_prompt,'Name Prefix') name_prefix_prompt, NVL(first_name_reqd_yn,'N') first_name_reqd_yn, NVL(second_name_reqd_yn,'N') second_name_reqd_yn, NVL(third_name_reqd_yn,'N') third_name_reqd_yn, NVL(family_name_reqd_yn,'N') family_name_reqd_yn, NVL(name_suffix_reqd_yn,'N') name_suffix_reqd_yn, NVL(name_prefix_reqd_yn,'N') name_prefix_reqd_yn,NVL(patient_id_length,0) patient_id_length, pat_name_as_multipart_yn, dflt_sndx_type, NVL(first_name_length,0) first_name_length, NVL(second_name_length,0)  second_name_length, NVL(third_name_length,0) third_name_length, NVL(family_name_length,0) family_name_length from mp_param" ;
		

		rs1 = stmt1.executeQuery(sql);
		
		if (rs1 != null)
		{
			while(rs1.next())
			{
				First_Name_Accept_Yn = checkForNull(rs1.getString(1));
				First_Name_Order = rs1.getInt(2);
				First_Name_Prompt = checkForNull(rs1.getString(3));
				Second_Name_Accept_Yn = checkForNull(rs1.getString(4));
				Second_Name_Order = rs1.getInt(5);
				Second_Name_Prompt = checkForNull(rs1.getString(6));
				if(Second_Name_Prompt ==null) Second_Name_Prompt="";
				Third_Name_Accept_Yn = checkForNull(rs1.getString(7));
				Third_Name_Order = rs1.getInt(8);
				Third_Name_Prompt = checkForNull(rs1.getString(9));
				if(Third_Name_Prompt ==null) Third_Name_Prompt="";
				Family_Name_Accept_Yn = checkForNull(rs1.getString(10));
				Family_Name_Order = rs1.getInt(11);    
				Family_Name_Prompt = checkForNull(rs1.getString(12));
				if(Family_Name_Prompt ==null) Family_Name_Prompt="";
				Name_Suffix_Accept_Yn = checkForNull(rs1.getString(13));
				Name_Prefix_Accept_Yn = checkForNull(rs1.getString(14));
				Name_Suffix_Prompt = checkForNull(rs1.getString(15));
				Name_Prefix_Prompt = checkForNull(rs1.getString(16));
				
				First_Name_Reqd_Yn = checkForNull(rs1.getString(17));
				Second_Name_Reqd_Yn = checkForNull(rs1.getString(18));
				Third_Name_Reqd_Yn = checkForNull(rs1.getString(19));
				Family_Name_Reqd_Yn = checkForNull(rs1.getString(20));
				Name_Suffix_Reqd_Yn = checkForNull(rs1.getString(21));
				Name_Prefix_Reqd_Yn = checkForNull(rs1.getString(22));
				patient_id_len	= checkForNull(rs1.getString(23));
				pat_name_as_multipart_yn = checkForNull(rs1.getString(24));
				
				first_name_length = checkForNull(rs1.getString(26));
				second_name_length = checkForNull(rs1.getString(27));
				third_name_length = checkForNull(rs1.getString(28));
				family_name_length = checkForNull(rs1.getString(29));
				
				//dflt_sndx_type = rs1.getString(25);
				//if (dflt_sndx_type == null) dflt_sndx_type  ="";				
			}
			
			if(rs1!=null)	 rs1.close();
		if(stmt1!=null)	 stmt1.close();
		}
		

		%>		
<!--Santhosh End-->
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
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
<script>
		// below code is added for the 17600 end  Wednesday, December 23, 2009
		function clearResultpage()
		{
			parent.frames[2].location.href ='../../eCommon/html/blank.html';
		}

// Added by Sridhar on Jan 3rd 2006...
// This Function will check for empty values before calling up the common lookup func..
function BeforeGetPractitioner(obj, target, details)
{
	if(details == 'from')
	{
		if(document.forms[0].from_practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].from_practid.value =""
	}
	else
	{
		if(document.forms[0].practid_desc.value !="")
			getPractitionerLocal(obj, target, details);
		else
			document.forms[0].practid.value =""
	}

}


// By Annadurai 2/6/2004 ., to use Common Lookup. starts.,
function getPractitionerLocal(obj, target, details)
{
	var practName_FName="";
	var practName_FValue="";
	var practId_FName="";

	practName_FName=target.name;
	practName_FValue=target.value;
	if(details == 'from')
		practId_FName=document.forms[0].from_practid.name;
	else
		practId_FName=document.forms[0].practid.name;

	var facility_id		= "<%=facilityID%>";
	var locale			= "<%=locale%>";
		getPractitioner(obj, target, facility_id, "","","Q3");

} // End of getToPractitioner.

// To be called by the GeneralPractitionerSearch to set Practitioner.
function PractLookupRetVal(retVal,objName)
{
	var arr;
	if (retVal != null)
	{
		arr=retVal.split("~");
		if(objName == "from_practid_desc")
		{
			document.forms[0].from_practid.value=arr[0];
			document.forms[0].from_practid_desc.value=arr[1];			
		}
		else if(objName=='cancel_pract')
		{
			document.forms[0].cancel_pract_id.value=arr[0];
			document.forms[0].cancel_pract.value=arr[1];

		}	
		else
		{
			document.forms[0].practid.value=arr[0];
			document.forms[0].practid_desc.value=arr[1];			
		}
	}
	else
	{
		if(objName.name == "practid_desc")
		{
			document.forms[0].from_practid.value="";
			document.forms[0].from_practid_desc.value="";			
		}
		else if(objName=='cancel_pract'){
		
			document.forms[0].cancel_pract_id.value="";
			document.forms[0].cancel_pract.value="";
		}
		else
		{
			document.forms[0].practid.value="";
			document.forms[0].practid_desc.value="";			
		}
	}
}

function CheckZeroVal(obj) 
{
	
    if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{
		
        return true;
    }
    else 
	{
		if(obj.value.length > 0 && obj.value==0) 
		{
			
            alert(getMessage("VALUE_SHOULD_BE_GR_ZERO","Common"));
            obj.select();
            obj.focus();
            return false;
        }
    }
}

//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...    
function clearAll()
{
	
<%	if(call_function.equals("CheckInLodger"))
	{	%>
		
		document.forms[0].reset();
		parent.frames[1].location.href ='../../eCommon/html/blank.html';
<%	} 
	else if(!call_function.equals("InpatientLookupCall"))
	{	if(call_function.equals("DischargeCheckList") || call_function.equals("ViewCheckList"))
		{
		
		%>
			document.forms[0].reset();
			document.forms[0].Disc_Chk.value = 'N';
			document.forms[0].disc_from_date.disabled = true;
			document.forms[0].disc_to_date.disabled = true;
			document.getElementById("disc_man_gif1").style.visibility			= 'hidden';
			document.getElementById("disc_man_gif2").style.visibility			= 'hidden';
			parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
	<%
		}else{
	%>		
	
		//document.forms[0].reset();
		parent.frames[2].document.location.href ='../../eCommon/html/blank.html';
<%	}}
	else
	{	%>
		parent.frames[1].document.location.href ='../../eCommon/html/blank.html';
<%	}	%>

<%	if(call_function.equals("RepDischargeAdvice"))
	{	%>
		document.forms[0].reset();
		parent.frames[1].location.href ='../../eCommon/html/blank.html';
<%	}	%>

	if(parent.messageFrame)
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';

	document.forms[0].search.disabled=false;
}


//Pls note.. This function is not moved to IPLookup.js as many Java variables are directly used in this function...
function submitPage()
{	
	var condition="";
	for(var i=0; i<document.forms[0].elements.length; i++)
	{
			condition+= document.forms[0].elements[i].name +"="+ escape(document.forms[0].elements[i].value)+"&"
	}
	document.forms[0].search.disabled=true;
	oper_stn = document.forms[0].operstn.value;
	routine_tfr_yn = document.forms[0].routine_tfr_yn.value;
	call_function =document.forms[0].call_function.value;

	//Added by Arthi on 31-Jan-2022 for GHL-CRF-0643
	var isPatIdMandAppl = document.forms[0].isPatIdMandAppl.value;

	if(call_function == "IPList" || call_function == "IpInternalReportReprint")
	{
		if(document.forms[0].include_yn)
		{
			if(document.forms[0].include_yn.checked == true && document.forms[0].no_of_days.value == "")
			{
				var error = getMessage('GENERAL_CNT_BE_BLANK','IP');
				error = error.replace('$',getLabel("Common.noofdays.label","Common"));  
				alert(error);	
				parent.frames[2].location.href='../../eCommon/html/blank.html';
				document.forms[0].no_of_days.focus();
				document.forms[0].search.disabled = false;
				return false;
			}

			/*Added by Arthi on 31-Jan-2022 for GHL-CRF-0643*/
			var no_of_days = document.forms[0].no_of_days.value;

			if(isPatIdMandAppl == "true" && call_function == "IpInternalReportReprint"){
				if(document.forms[0].patient_id && document.forms[0].patient_id.value == "" && no_of_days.length > 2)
				{
					var error = getMessage('GENERAL_CNT_BE_BLANK','IP');
				    error = error.replace('$',getLabel("Common.patientId.label","Common"));
					alert(error);
					parent.frames[2].location.href='../../eCommon/html/blank.html';
					document.forms[0].patient_id.focus();
					document.forms[0].search.disabled = false;
					return false;
				}
			}
			/*End GHL-CRF-0643*/
		}
	}
	if(document.forms[0].modal.value == 'yes')
	{
		if(call_function == "AdminHist")
		{
			var names = new Array (getLabel("eIP.AdmDateFrom.label","IP"),getLabel("eIP.AdmDateTo.label","IP")); 
			var fields=new Array();

			fields[0]= document.forms[0].from_date;
			fields[1]= document.forms[0].to_date;

			if(!parent.frames[1].checkFields( fields, names, parent.messageFrame))
			{
				document.forms[0].search.disabled = false;
			}
			else
			{
				parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&call_function='+call_function+'&show_bed_yn=Y&opst='+oper_stn+'';
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
		}
		else
		{
			
			parent.frames[1].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&call_function='+call_function+'&show_bed_yn=Y&opst='+oper_stn+'';
		}
	}
	else
	{
		
		if(call_function == "AdminHist")
		{
			var names = new Array (getLabel("eIP.AdmDateFrom.label","IP"),getLabel("eIP.AdmDateTo.label","IP"));
			var fields=new Array();

			fields[0]= document.forms[0].from_date;
			fields[1]= document.forms[0].to_date;

			if(!parent.frames[1].checkFields( fields, names, parent.messageFrame))
			{
				document.forms[0].search.disabled = false;
				parent.frames[2].location.href='../../eCommon/html/blank.html';
			}
			else
			{
				parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&call_function='+call_function+'&show_bed_yn=Y&opst='+oper_stn+'';
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
		}
		else
		if(call_function == "DischargeCheckList" || call_function == "ViewCheckList"  )
		{
			//alert(document.forms[0].Disc_Chk.checked);
			if(document.forms[0].Disc_Chk.checked == true)
			{
			
				var names = new Array (getLabel("eIP.DischargeDateFrom.label","IP"), getLabel("eIP.DischargeDateTo.label","IP"));
				var fields=new Array();

				fields[0]= document.forms[0].disc_from_date;
				fields[1]= document.forms[0].disc_to_date;

				if(!parent.frames[1].checkFields( fields, names, parent.messageFrame))
				{
					document.forms[0].search.disabled = false;
					parent.frames[2].location.href='../../eCommon/html/blank.html';
				}
				else
				{
				 parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&show_bed_yn=Y&opst='+oper_stn+'';
				 parent.frames[3].location.href='../../eCommon/jsp/error.jsp';
				}
			}
			else			
			{

			 parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&show_bed_yn=Y&opst='+oper_stn+'';
			 parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			}
		}
		else if(call_function == "QueryDischarge" ){
				var names = new Array (getLabel("eIP.DischargeDateFrom.label","IP"), getLabel("eIP.DischargeDateTo.label","IP"));
				var fields=new Array();
				fields[0]= document.forms[0].from_date;
				fields[1]= document.forms[0].to_date;

				if(!parent.frames[1].checkFields( fields, names, parent.messageFrame))
				{
					document.forms[0].search.disabled = false;
					parent.frames[2].location.href='../../eCommon/html/blank.html';
				}
				else
				{
					parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&show_bed_yn=Y&opst='+oper_stn+'';
					parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
				}		
			}
			else if(call_function == "ChangedAdmDtls"){
			var names = new Array (getLabel("eIP.modifieddatefrom.label","IP"),getLabel("eIP.modifieddateto.label","IP")); 
			var fields=new Array();

			fields[0]= document.forms[0].modified_from_date;
			fields[1]= document.forms[0].modified_to_date;

			if(!parent.frames[1].checkFields( fields, names, parent.messageFrame)){
				document.forms[0].search.disabled = false;
			}
			else
			{
				parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&call_function='+call_function+'&show_bed_yn=Y&opst='+oper_stn+'';
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
			}
		}//Wednesday, February 23, 2011,SRR20056-SCF-6968 [IN:026632]
		else if(call_function == "IPList")
		{
				var patient_name = encodeURIComponent(document.forms[0].patient_name.value);
				//GHL-SCF-708 [IN:038170] By Saanthaakumar 
												
				parent.frames[2].location.href= "../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&"+condition+"&oper_stn_id="+oper_stn+"&routine_tfr_yn ="+routine_tfr_yn+"&call_function="+call_function+"&show_bed_yn=Y&opst="+oper_stn+"&patientName="+patient_name;
				parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		}//
		else
		{
			//function involkes Cancel reserve bed serach criteria
			if(call_function == "CancelReserveBeds" ){
				var from_nursing_unit=document.Inpatientlookup_Form.from_nursing_unit_desc.value
				var to_nursing_unit=document.Inpatientlookup_Form.nursing_unit_desc.value;
				var from_specialty=document.Inpatientlookup_Form.from_specialty_desc.value 
				var to_specialty=document.Inpatientlookup_Form.specialty_desc.value 
				var	from_practid=document.Inpatientlookup_Form.from_practid_desc.value 
				var	to_practid=document.Inpatientlookup_Form.practid_desc.value
				var	encounter_id=document.Inpatientlookup_Form.encounter_id.value
				var	from_date=document.Inpatientlookup_Form.from_date.value
				var	to_date=document.Inpatientlookup_Form.to_date.value
				var patient_id=document.Inpatientlookup_Form.patient_id.value
				parent.frames[2].location.href=				'../../eIP/jsp/CancelReserveBedSearchResult.jsp?fromSelect=fromSelect&call_function=CancelReserveBeds&from_nursing_unit='+from_nursing_unit+'&to_nursing_unit='+to_nursing_unit+'&from_specialty='+from_specialty+'&to_specialty='+to_specialty+'&from_practid='+from_practid+'&to_practid='+to_practid+'&encounter_id='+encounter_id+'&from_date='+from_date+'&to_date='+to_date+'&patient_id='+patient_id+'';
			}
			else{
				var exclude_nda_pats="N";
				if(call_function=="DischargePatient"){
					exclude_nda_pats=document.forms[0].exclude_nda_pats.value;
					if(document.forms[0].exclude_nda_pats.checked == true)
						exclude_nda_pats = "Y";
					else
						exclude_nda_pats = "N";

				}
				parent.frames[2].location.href= '../../eIP/jsp/InpatientLookupQueryResult.jsp?<%=request.getQueryString()%>&'+condition+'&oper_stn_id='+oper_stn+'&routine_tfr_yn ='+routine_tfr_yn+'&show_bed_yn=Y&opst='+oper_stn+'&exclude_nda_pats='+exclude_nda_pats+'';
				parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
			}
		}
	}
}
function BeforeGetPractID1(obj1,obj2)
{
	if(document.forms[0].cancel_pract.value!="")
		getPractitioner(obj1,obj2,'','','Q7');	// For 17674 (Monday, December 28, 2009)
}
	
</script>
</head>
	<body onSelect="codeArrestThruSelect();" onMouseDown='CodeArrest()' onKeyDown='lockKey()' onLoad="FocusFirstElement();//checkForMPRequest();">
		<form name='Inpatientlookup_Form' id='Inpatientlookup_Form' action='../../eIP/jsp/BookingReferenceLookupResult.jsp' target='result' >
			<table cellspacing=0 cellpadding=3 align='center' width='98%' border='0'>
			
			<%	
				//call_function.equals("CancelReserveBeds")
			if(call_function.equals("TransferPatientIn") || call_function.equals("CancelTransferPatientOut") || call_function.equals("TransferPatientOut")||
				call_function.equals("CancelReserveBeds"))
				{	
					
				%>	<tr>
					<td class='COLUMNHEADERCENTER' colspan='2'><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' colspan='2'><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					</tr>
				<tr>
					<td class='label' width='25%' nowrap><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
					
					<td width="25%" class='fields'><input type=text name="from_nursing_unit_desc" id="from_nursing_unit_desc" size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','from');"><input type=hidden  name="from_nursing_unit" id="from_nursing_unit" size=15 ><input type=button class=button name='from_nursing_unit_lookup' id='from_nursing_unit_lookup' value='?' onClick="getNursingUnitValue(from_nursing_unit_desc, '<%=facilityID%>','from');" ></td>
					
					
					<td class='label' width='25%' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
						
					<td class='fields' width='25%'><input type=text name="nursing_unit_desc" id="nursing_unit_desc" size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','to');"><input type=hidden  name="nursing_unit" id="nursing_unit" size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facilityID%>','to');" ></td>
				</tr>

				<tr>

					
					<td  class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
						
					<td class='fields' width='25%'><input type=text name=from_specialty_desc size=15 maxlength='15' onblur="BeforeGetSpecialtyValue(this,'<%=facilityID%>','from');"><input type=hidden class=label name=from_Splcode id=from_Splcode size=15 readonly><input type=button class=button name='from_specialty_lookup' id='from_specialty_lookup' value='?' onClick="getSpecialtyValue(from_specialty_desc, '<%=facilityID%>','from');">

					<td  class='label' width='25%' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
						
					<td class='fields' width='25%'><input type=text name=specialty_desc size=15 maxlength='15' onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>','to');"><input type=hidden class=label name=Splcode id=Splcode size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>','to');"></td>
				</tr>		
					
				<tr>
					
					
					<td  class='label' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						
					
					<td class='fields' width='25%'><input type='text' name='from_practid_desc' id='from_practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].from_practid,from_practid_desc,'from');" value=""><input type='hidden' name='from_practid' id='from_practid' value="" size="15" maxlength="15" ><input type='button' name='from_pract_id_search' id='from_pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].from_practid,from_practid_desc,'from');"></td>

					<td  class='label' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
						
					<td class='fields' width='25%'><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid,practid_desc,'to');"></td>
				</tr>
						<!--<tr>
					<tr align='center' colspan='4'></tr>
				
					</tr>-->
			<%	}
				else 
				{	
	%>
					<tr>
					<td class='label' width='25%'><script>getLabel("Common.nursingUnit.label","common")</script><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
						
					<td CLASS='fields' width='25%'><input type=text name="nursing_unit_desc" id="nursing_unit_desc" size=15 maxlength='15' onblur="BeforeGetNursingUnit(this, '<%=facilityID%>','to');"><input type=hidden  name="nursing_unit" id="nursing_unit" size=15 ><input type=button class=button name='nursing_unit_lookup' id='nursing_unit_lookup' value='?' onClick="getNursingUnitValue(nursing_unit_desc, '<%=facilityID%>','to');" ></td>


					<%
						if(modal.equals("yes")) 
					{ 
						if(call_function.equals("QueryDischarge") || call_function.equals("RepDischargeAdvice")) 	
						{	%>
								<td class='label' width='25%' nowrap><fmt:message key="eIP.DischargeDateFrom.label" bundle="${ip_labels}"/></td>
								
								<td class='fields' width='25%'  nowrap><input type='text' id="dis_date_from" maxlength='10' size='10' name='from_date' value="" onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="dis_date_to" value="" maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('dis_date_to',null);"></td>
					<%	} 
						else 
						{	
			
							%>
								<td class='label'  nowrap width="25%"><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
								
								<td   class='fields' width='25%'  nowrap><input type='text' id="adm_date_from" maxlength='10' size='10' name='from_date' value="" onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="adm_date_to" value="" maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_to',null); "></td>						
					<% 	} 
					}else {
						if(call_function.equals("QueryDischarge") || call_function.equals("RepDischargeAdvice") || call_function.equals("CHECK_IN_LODGER") ) 
						{	
							%>
							
							<td class='label' width='25%' nowrap><fmt:message key="eIP.DischargeDateFrom.label" bundle="${ip_labels}"/></td>
							
							<td  class='fields' width='25%'  nowrap><input type='text' id="disc_date_from" maxlength='10' size='10' name='from_date' value="" <%if(call_function.equals("CHECK_IN_LODGER")){%>onBlur='LodgerDateCompare	(this,parent.frames[3]);validDateObj(this,"DMY","<%=locale%>");compareDates();'<%}else{%>onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'<%}%>><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('disc_date_from');"/><%if(call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT") ){%><img id="" src='../../eCommon/images/mandatory.gif' align='center'></img><%}%> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="disc_date_to" value="" maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].disc_date_to.focus();return showCalendar('disc_date_to');"/><%if(call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT")){%><img id="" src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>

						

								<%	if(call_function.equals("CHECK_IN_LODGER")) 
								{	%>
									<script>
								//	document.forms[0].from_date.value="<%=systemdate%>";
									</script>
							<%	}
						}else{
							String colspanValue = "Colspan = 2";
							if (call_function.equals("TransferPatientOut"))		
								colspanValue = "Colspan = 2";
							if (call_function.equals("CHECK_IN_ACCMP_PERSON"))		
								colspanValue = "Colspan = 2";

				if(call_function.equals("ViewCheckList") || call_function.equals("DischargeCheckList")  )
				{	
				
					%>
					<td class='label'  nowrap width="25%"><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
					
					<td  class='fields' width='25%'  nowrap><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' value="" onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="admn_date_to" value="" maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_to');" ></td>

	
		<%	}
			else if(!call_function.equals("QueryCancelDischarge"))
			{	
				%>
				<td class='label'  nowrap width="25%"><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
				
				<td   class='fields' width='25%'  nowrap><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' <%if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT") || call_function.equals("ChangedAdmDtls")){%> value="<%=systemdate_converted%>" <%}%> onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].admn_date_from.focus();return showCalendar('admn_date_from');"><%if(call_function.equals("AdminHist")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="admn_date_to"  <%if(call_function.equals("MODIFY_SERVICE_FOR_INPATIENT") || call_function.equals("ChangedAdmDtls")){%> value="<%=systemdate_converted%>" <%}%> maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_to');" ><%if(call_function.equals("AdminHist")){%><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%></td>
			<%}
				else if(call_function.equals("QueryCancelDischarge")){%>
				<td class=label width='25%' ><fmt:message key="Common.dischargetype.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%' nowrap ><select name="discharge_type" id="discharge_type" onchange='clearResultpage()'>
				<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---
						<%
							String dat = "";
							String ID = "";
							stmt = con.createStatement();
							rset = stmt.executeQuery("select discharge_type_code, short_desc from IP_DISCHARGE_TYPE_VW where eff_status = 'E'  order by short_Desc ");

							while (rset.next())
							{
								dat	= checkForNull(rset.getString("short_desc"));
								ID	= checkForNull(rset.getString("discharge_type_code"));
								out.print("<option value=\""+ID+"\"  >"+dat+"");
							}
							if(rset != null) rset.close(); 
						%>
				</select></td>
				<%
				}%>
			<%	}
					}%>


		<%
		if(!call_function.equals("TransferPatientIn") || !call_function.equals("CancelTransferPatientOut") || !call_function.equals("TransferPatientOut") ){%>
			
			<tr>
					<td  class='label' width='25%' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type=text name=specialty_desc size=15 maxlength='15' onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>','to');"><input type=hidden class=label name=Splcode size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>','to');"></td>
					
					<%if(call_function.equals("QueryCancelDischarge"))
					{%>
				
							<td class='label'><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/></td>
							<td class='fields' nowrap ><select name="discharge_status" id="discharge_status" onchange='clearResultpage()'>
							<option value="">---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---
						<%
							String stat_desc = "";
							String  stat_code= "";
							stmt = con.createStatement();
							rset = stmt.executeQuery("select discharge_status_code, short_desc from IP_DISCHARGE_STATUS_LANG_VW where language_id='"+locale+"' and eff_status = 'E'  order by short_Desc ");

							while (rset.next())
							{
								stat_desc	= checkForNull(rset.getString("short_desc"));
								stat_code	= checkForNull(rset.getString("discharge_status_code"));
								out.print("<option value=\""+stat_code+"\"  >"+stat_desc+"");
							}
							if(rset != null) rset.close(); 
						%>
						</select></td>
					<%}else{%>
					<td  class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc,'to');"></td>
					<% if(call_function.equals("ChangedAdmDtls")){%>
					 <tr>
							<td colspan=6 style="padding:0px">
									<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>

							</td>
					</tr>
					<tr>
						<td class='label' width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
						<td class='fields' width='25%'  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this);"></td>
					</tr>
					 <tr>
						<td class='label' align='left' nowrap><fmt:message key="Common.modifiedby.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
						<td><input type='text' maxlength='15' size='15' name='user_name' id='user_name'  value='' onblur="beforeGetCancelledBy('Modify')" ><input type='hidden'   name='user' id='user' value=''><input type="button" class=BUTTON name="modified_search" id="modified_search" value="?" onClick="javascript:showLookUpCancel('Modify')"><input type='hidden'   name='user_hid' id='user_hid' value=''>
						</td>
						<td class='label' align='left' nowrap><fmt:message key="eIP.modifieddatefrom.label" bundle="${ip_labels}"/>&nbsp</td>
						<td nowrap><input type='text' id="modified_from_date" maxlength='10' size='10' name='modified_from_date' onBlur='date_compare_sysdate(this);DateCompare_unasgPat(this,modified_to_date);' value="<%=systemdate_converted%>" ><img src='../../eCommon/images/CommonCalendar.gif' onClick="modified_from_date.focus();return showCalendar('modified_from_date');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>-&nbsp;<input type='text' id="modified_to_date"  maxlength='10' size='10' name='modified_to_date' onBlur='DateCompare_unasgPat(modified_from_date,this);date_compare_sysdate(this);' value="<%=systemdate_converted%>"><img src='../../eCommon/images/CommonCalendar.gif' onClick="modified_to_date.focus();return showCalendar('modified_to_date');"><img src='../../eCommon/images/mandatory.gif' align='center'></img>&nbsp;</td>

						<!--<td colspan='2'>&nbsp;</td>-->
					</tr> 
					<%}%>
			<%}%>
			</tr>
			

		<%	if(call_function.equals("IPList"))
			{	%>
				<tr>
					<td  class='label' width='25%' nowrap><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'  nowrap><input type=text name="Service_desc" id="Service_desc" size="15" maxlength='15' onblur="BeforeGetServiceValue(this, '<%=facilityID%>');"><input type=hidden class=label name="ServiceCode" id="ServiceCode" size=15 readonly><input type=button class=button name='service_lookup' id='service_lookup' value='?' onClick="getDescriptions(Service_desc, '<%=facilityID%>','S');"></td>
					<td  class='label' width='25%' nowrap><fmt:message key="Common.subservice.label" bundle="${common_labels}"/></td>
					<td class='fields' width='25%'  nowrap><input type=text name="SubService_desc" id="SubService_desc" size="15" maxlength='15' onblur="BeforeGetSubServiceValue(this, '<%=facilityID%>');"><input type=hidden class=label name="SubServiceCode" id="SubServiceCode" size=15 readonly><input type=button class=button name='subservice_lookup' id='subservice_lookup' value='?' onClick="getDescriptions(SubService_desc, '<%=facilityID%>','SS');"></td>
				</tr>
		<%	}	%>


		<%	if(call_function.equals("ConfirmBedClass"))
			{	%>
				<tr>
					<td  class='label'  nowrap><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
					<td class="fields"><jsp:include page="BedClassComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include></td>
					<td  class='label'  nowrap><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
					<td class="fields" ><jsp:include page="BedTypeComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include></td>
				</tr>
		<%	}	%>

		<%}else{%>
				<tr>
					<td  class='label' width='25%' nowrap> <fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type=text name=specialty_desc size=15 maxlength='15' onblur="BeforeGetSpecialtyValue(this, '<%=facilityID%>','to');"><input type=hidden class=label name=Splcode size=15 readonly><input type=button class=button name='specialty_lookup' id='specialty_lookup' value='?' onClick="getSpecialtyValue(specialty_desc, '<%=facilityID%>','to');"></td>
				
					<td  class='label' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc,'to');"></td>
					</tr>

	<%}%>
<%}%>
	<tr>
	<%	if(!modal.equals("yes")) {
		  if(call_function.equals("ViewCheckList") || call_function.equals("DischargeCheckList")  )
				{%>
					
					<td class='label' nowrap  width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>

					<td class='label' ></td>
					<td class='label' ></td>
			</tr>
			
			<tr>
					<td class='label'  width='25%'><fmt:message key="Common.DischargePatient.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'nowrap><INPUT TYPE="checkbox" name="Disc_Chk" id="Disc_Chk" onclick = 'enable_date_flds(this);' value="N"></td>	

					<td  class='label' width='25%'><fmt:message key="eIP.DischargeDateFrom.label" bundle="${ip_labels}"/></td>
						
					<td class='fields' width='25%'  nowrap>
						<input type='text' id="disc_from_date" maxlength='10' disabled size='10' name='disc_from_date' onBlur='compareDisDates2(this);'>
							<img id="disc_cal_gif1" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('disc_from_date');" style="pointer-events: none;"></img>
							<img id="disc_man_gif1" src='../../eCommon/images/mandatory.gif' style="visibility:hidden" align='center' ></img> 
							- 
							<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;
						<input type='text' name='disc_to_date' id='disc_to_date' disabled value="" maxlength='10' size='10' onBlur='compareDisDates2(this);'>
							<img id="disc_cal_gif2"  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].disc_to_date.focus();return showCalendar('disc_to_date');" style="pointer-events: none;"></img>
							<img id="disc_man_gif2" src='../../eCommon/images/mandatory.gif' style="visibility:hidden" align='center' ></img>
					</td>
	<%}else{%>
	<%}%>
	<%	
		}// e.O MODAL = ""
			
		if(call_function.equals("IPList") || call_function.equals("IpInternalReportReprint")) 
		{	%>		
				<td class='label' width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>

				<td class='fields' width='25%'  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this);"></td>
				
				<td class='label'  width='25%' nowrap><fmt:message key="eIP.InclDiscPatients.label" bundle="${ip_labels}"/></td>
				
				<td class='fields' width='25%' nowrap><input type="checkbox" name="include_yn" id="include_yn" value="N" onClick="enableDisableDays(this);"><fmt:message key="Common.noofdays.label" bundle="${common_labels}"/>
				
				<!--Added by Arthi on 31-Jan-2022 for GHL-CRF-0643-->
				<% if(isPatIdMandAppl && call_function.equals("IpInternalReportReprint")){ %>
				<input type="text" name="no_of_days" id="no_of_days" onBlur="CheckZeroVal(this);makePatientIdMandatory(this);" size="4" maxlength="4" onKeyPress="return allowValidNumber_local(this,event,4,0)" readOnly>
				<% }else{ %>
                <input type="text" name="no_of_days" id="no_of_days" onBlur="CheckZeroVal(this);" size="2" maxlength="2" onKeyPress="return allowValidNumber_local(this,event,2,0)" readOnly>
				<% } %>
				
				<img src='../../eCommon/images/mandatory.gif' style='visibility:hidden' id='daysImg'></img></td>

	<%	}else if(call_function.equals("RepDischargeAdvice")){	%>
					
				<td class='label' nowrap width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'  nowrap><input type='text'  size='12' value="<%=encounterID_repDischargeAdvice%>" maxlength='12' name='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>

	<% }else if((!call_function.equals("TransferPatientOut")) &&(!call_function.equals("CancelReserveBeds"))&& (!call_function.equals("TransferPatientIn")) && (!call_function.equals("CancelTransferPatientOut"))&& (!call_function.equals("DischargeCheckList"))&&(!call_function.equals("ViewCheckList"))&&(!call_function.equals("ChangedAdmDtls"))){ 
					//	(11-sep-2008) code append&&(!call_function.equals("CancelReserveBeds"))
				%>
				<td class='label' nowrap width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class='fields' width='25%'  nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>
				
				<!-- Santhosh Start ML-MMOH-CRF-1894-->
				<%if(call_function.equals("ReferralPatientDetails") && isBasedOnNameFilterAppl){%>
				<td colspan=1 class='label' width ='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
			<td  class='fields' width ='25%'><select name='gender' id='gender'>
					<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
					<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
					<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				</select>
			</td>
				<%}%>
				<!-- Santhosh End-->
		<% 
					/*
						Change Added :
						 On 10/28/2010	
						 For FD-PMG20089-CRF-0862
						 By Chiranjeevi.C
					*/
					if(call_function.equals("DischargePatient")){%>
							<td class='label' nowrap width='25%'><fmt:message key="eIP.ExcludeNonPDA.label" bundle="${ip_labels}"/></td>
							<td class='fields' width='25%'><input type='checkbox'  name="exclude_nda_pats" id="exclude_nda_pats" onclick="excludeNDAPatient(this)" value="<%=dis_adv_val%>" <%=dis_adv_chk%>></td>
					<%}
					/***Ends**/
				
				if( call_function.equals("QueryDischarge") || call_function.equals("CANCEL_DISCHARGE_PATIENT")){%>
				<td class='label' width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields' width='25%'>
					<select name="gender" id="gender">
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
				</td>
						
	<%}
	else if(call_function.equals("QueryCancelDischarge"))
		{%>
				<td  class='label' width='25%' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>

					<td class='fields' width='25%'  nowrap><input type='text' name='practid_desc' id='practid_desc' size="25" maxlength="30" onblur="BeforeGetPractitioner(document.forms[0].practid,practid_desc,'to');" value=""><input type='hidden' name='practid' id='practid' value="" size="15" maxlength="15" ><input type='button' name='pract_id_search' id='pract_id_search' value='?' class='button' onClick="getPractitionerLocal(document.forms[0].practid, practid_desc,'to');"></td>
		<%}else{%><td class='label' colspan='2'></td><%}%>

	<% }else if((!call_function.equals("TransferPatientOut")) && (!call_function.equals("DischargeCheckList")) && !(call_function.equals("ViewCheckList"))&&(!call_function.equals("ChangedAdmDtls"))){%>
				
				<td class='label' nowrap width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>

				<td class='fields' width='25%' nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>

				<td class='label'  nowrap width='25%'><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
					
				<td   class='fields' width='25%' nowrap ><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' value="" onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="admn_date_to" value="" maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_to');" ></td>
				
	<%}%>
	<%if(call_function.equals("QueryCancelDischarge")){	%>
		<tr>
			<td class="label" width='25%'><fmt:message key="Common.cancelledby.label" bundle="${common_labels}"/></TD>
			<td class="fields" width='25%'><input type='text' name='cancel_pract' id='cancel_pract'  size='15' maxlength='30' value="" onblur="if(this.value==''){document.forms[0].cancel_pract_id.value='';};BeforeGetPractID1(document.forms[0].cancel_pract_lookup,cancel_pract);"><input type='hidden' name='cancel_pract_id' id='cancel_pract_id'  value=""></input><input type='button' value='?' name='cancel_pract_lookup' id='cancel_pract_lookup' class='button' onClick="if(document.forms[0].cancel_pract.value == '') getPractitioner(this,cancel_pract,'','','Q7');"></input></TD>
<!-- 	For 17674 (Monday, December 28, 2009)-->
			<td class='label' width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td class='fields' width='25%'>
					<select name="gender" id="gender">
						<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
						<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
						<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
					</select>
				</td>
		</tr>
	<%}%>	

	<%if(!call_function.equals("TransferPatientOut")){	%>
		<td colspan=4></td>
		</tr>
	<%}%>	

	<%if(call_function.equals("CANCEL_DISCHARGE_PATIENT"))
		{%>
		<tr>
		<td  class='label' width='25%'><fmt:message key="eIP.DischargeDateFrom.label" bundle="${ip_labels}"/></td>
		<td class='fields' width='25%' >
		<input type='text' id="disc_from_date" maxlength='10' size='10' name='disc_from_date' value="<%=systemdate_converted%>" onBlur='compareDisDates2(this);'><img id="disc_cal_gif1" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('disc_from_date');" ></img>-<fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' name='disc_to_date' id='disc_to_date' value="<%=systemdate_converted%>" maxlength='10' size='10' onBlur='compareDisDates2(this);'><img id="disc_cal_gif2"  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('disc_to_date');" ></img>
		</td>
		<td class='label' colspan='2'></td>
		</tr>
		<%}%>
	
	<%if(call_function.equals("TransferPatientOut")){%>
				
				<td class='label' nowrap width='25%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>

				<td class='fields' width='25%' nowrap><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this)"></td>
					
				<td class='label'  nowrap width='25%'><fmt:message key="eIP.AdmDateFrom.label" bundle="${ip_labels}"/></td>
					
				<td  class='fields' width='25%' nowrap ><input type='text' id="admn_date_from" maxlength='10' size='10' name='from_date' value="" onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_from');"> - <fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;<input type='text' id="admn_date_to" value="" maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('admn_date_to');" ></td>
		</tr>
		
		<tr>				
			
				<td class='label' width='25%'><fmt:message key="eIP.RequestInpatientConfirmed.label" bundle="${ip_labels}"/></td>
				
				<td class='fields' width='25%' nowrap>
						<select name="confirmIP" id="confirmIP">
						<option value = "01" selected ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value = "02" ><fmt:message key="Common.confirmed.label" bundle="${common_labels}"/></option>
						</select>
				</td>
				<td class='label' width='25%' colspan='2'></td>
		</tr>	
			<tr>
				<td colspan=6>
						<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
				</td>
		</tr>
  <%}else{%><!--modified on 3-07-08 for SCR 3228-->
			<%	if(call_function.equals("QueryCancelDischarge"))
				{%>	
			<tr>
			<!-- code added for17600 instead colspan 2 Wednesday, December 23, 2009 -->
				<td colspan=6>
					<table width='100%'>
						<tr>
							<td>
								<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
							</td>
							<td class='label' width='25.2%' nowrap><fmt:message key="Common.CancelledDateFrom.label" bundle="${common_labels}"/></td>
							<td  class='fields' width='24.8%'  nowrap><input type='text' id="disc_date_from" maxlength='10' size='10' name='from_date' value="" <%if(call_function.equals("CHECK_IN_LODGER")){%>onBlur='LodgerDateCompare	(this,parent.frames[3]);validDateObj(this,"DMY","<%=locale%>");compareDates();'<%}else{%>onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'<%}%>><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('disc_date_from');"> - &nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> <input type='text' id="disc_date_to" value="" maxlength='10' size='10' name='to_date' onBlur='validDateObj(this,"DMY","<%=locale%>");compareDates();'><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('disc_date_to');"></td>
						</tr>
					</table>
				</td>
				<!--<td class='label'><fmt:message key="eIP.DischargeStatus.label" bundle="${ip_labels}"/></td>-->
			</tr>

			<%}else{
				if (!call_function.equals("ChangedAdmDtls")){%><!-- -->
			<tr>
				<td colspan=4>
						<jsp:include page="IPPatientLookUpDetailCriteria.jsp" ><jsp:param name="flush" value="true" /><jsp:param name ="patient_id_length"  value="<%=patient_id_length%>" /></jsp:include>
				</td>
				
			</tr>
	
  <%}}}%>
		<%
		//Maheshwaran K added for TH-KW-CRF-0141.1
		if(call_function.equals("DischargePatient") && isCoderClearance){%>
		<tr>
		<td class='label' nowrap width='25%'><fmt:message key="Common.CurrentStatus.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' nowrap><select name="current_bill_status" id="current_bill_status" >
			<option value="A" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/>
			<option value="CC"><fmt:message key="eIP.CoderClearance.label" bundle="${ip_labels}"/>
			<option value="DB"><fmt:message key="eIP.DischargeBill.label" bundle="${ip_labels}"/>
			<option value="DC"><fmt:message key="eIP.DischargeClearance.label" bundle="${ip_labels}"/>
			</select>
		</td>
		</tr>
		<%}	
%>		
	</table>	
	<!--Santhosh starts ML-MMOH-CRF-1894-->
	<%if(call_function.equals("ReferralPatientDetails") && isBasedOnNameFilterAppl){
		Boolean firstNameAvailabilty = false;
		Boolean secondNameAvailabilty = false;
		Boolean thirdNameAvailabilty = false;
		Boolean familyNameAvailabilty = false;%>
<table width='100%'>
<tr>

	<%if(Name_Prefix_Accept_Yn.equals("Y")) {%>						
									
			<td class='label' width='50%' nowrap><%=Name_Prefix_Prompt%>
				<input type='hidden' name='name_Prefix_reqd_yn' id='name_Prefix_reqd_yn' value='N'></input></td> 
				
	<%}%>
	<%if(First_Name_Accept_Yn.equals("Y")) {
		firstNameAvailabilty = true; %>						
									
			<td class='label' width='50%' nowrap><%=First_Name_Prompt%>
				<input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input></td> 
				
	<%} else if(Second_Name_Accept_Yn.equals("Y")) {
		secondNameAvailabilty = true;%>
	<td class='label' width='50%' nowrap><%=Second_Name_Prompt%>
				<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input></td> 
				
	<%} else if(Third_Name_Accept_Yn.equals("Y")) {
		thirdNameAvailabilty = true;%>
	<td class='label' width='50%' nowrap><%=Third_Name_Prompt%>
				<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input></td> 
				
	<%} else if(Family_Name_Accept_Yn.equals("Y")) {
		familyNameAvailabilty = true;%>
	<td class='label' width='50%' nowrap><%=Family_Name_Prompt%>
				<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'>
				<input type='hidden' name='family_name_prompt' id='family_name_prompt' value="<%=Family_Name_Prompt%>"></input></td> 
				
	<%}%>
	
	
</tr>
<tr>

	<%if(Name_Prefix_Accept_Yn.equals("Y")) {
		 
		 out.println("<td class='fields'  width='25%' >&nbsp;<Select name='name_prefix' id='name_prefix' tabIndex='14'>");

											out.println("<Option value=''>------"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"------</option>");

									sql="Select decode('"+locale+"', 'en', Name_Prefix, name_prefix_loc_lang) Name_Prefix from Mp_Name_Prefix where eff_status='E' and trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr')) order by 1";
									rs2 = stmt2.executeQuery(sql);
									
									
									if (rs2 != null)
									{
										while( rs2.next() ) {
																				
											
											out.println("<Option value=\"" + rs2.getString("Name_Prefix") + "\">" + rs2.getString("Name_Prefix")+"</option>");
											
										}
									if(rs2!=null)	 rs2.close();
									if(stmt2!=null)	 stmt2.close();
									}
									out.println("</Select>");
									out.println("<input type='hidden' name='name_prefix_reqd_yn' id='name_prefix_reqd_yn' value='N'></input>");
									

								out.println("</td>");
	 }%>
 
	<%if(First_Name_Accept_Yn.equals("Y")) {	%>				
	
<td class='fields' ><input type='text' name='first_name' id='first_name' size="61" maxlength='<%=first_name_length%>'>
			<select name="searchBy_first_name" id="searchBy_first_name">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
	</td>	
	<%} else if(Second_Name_Accept_Yn.equals("Y")) {%>
	<td class='fields' ><input type='text' name='second_name' id='second_name' size="61" maxlength='<%=second_name_length%>'>
			<select name="searchBy_second_name" id="searchBy_second_name">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
	</td>
	<%} else if(Third_Name_Accept_Yn.equals("Y")) {%>
	<td class='fields' ><input type='text' name='third_name' id='third_name' size="61" maxlength='<%=third_name_length%>'>
			<select name="searchBy_third_name" id="searchBy_third_name">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
	</td>
	<%} else if(Family_Name_Accept_Yn.equals("Y")) {%>
	<td class='fields' ><input type='text' name='family_name' id='family_name' size="61" maxlength='<%=family_name_length%>'>
			<select name="searchBy_family_name" id="searchBy_family_name">
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
			</select>
	</td>
	<%}%>
	
</tr>

	<%if(Second_Name_Accept_Yn.equals("Y") && !secondNameAvailabilty) {%>						
		<tr>
			<td class='label' width='50%'><input type='hidden' name='first_name_reqd_yn' id='first_name_reqd_yn' value='N'></input></td> 	
			<td class='label' width='50%'><%=Second_Name_Prompt%>
				<input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input></td> 
		</tr>
	<tr>

	<td class='field'><input type='hidden' name='second_name_reqd_yn' id='second_name_reqd_yn' value='N'></input></td> 

	<td  class='fields' ><input type='text' name='second_name' id='second_name' size="61" maxlength='<%=second_name_length%>'>
				<select name="searchBy_second_name" id="searchBy_second_name">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
		</td>
	</tr>
	<%}%>
		
	<%if(Third_Name_Accept_Yn.equals("Y") && !thirdNameAvailabilty) {%>						
		<tr>
			<td class='label' width='50%'><input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input></td> 	
			<td class='label' width='50%'><%=Third_Name_Prompt%>
				<input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input></td> 
			</tr>	
	<tr>
	<td class='field'><input type='hidden' name='third_name_reqd_yn' id='third_name_reqd_yn' value='N'></input></td> 

	<td class='fields' ><input type='text' name='third_name' id='third_name' size="61" maxlength='<%=third_name_length%>'>
				<select name="searchBy_third_name" id="searchBy_third_name">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
		</td>
	</tr>		
	<%}%>

	<%if(Family_Name_Accept_Yn.equals("Y") && !familyNameAvailabilty) {%>						
		<tr>						
			<td class='label' width='50%'><input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input></td> 	
			<td class='label' width='50%'><%=Family_Name_Prompt%>
				<input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input>
				<input type='hidden' name='family_name_prompt' id='family_name_prompt' value="<%=Family_Name_Prompt%>"></input></td> 
			</tr>
		<tr>
		<td class='field'><input type='hidden' name='family_name_reqd_yn' id='family_name_reqd_yn' value='N'></input></td> 

			<td class='fields' ><input type='text' name='family_name' id='family_name' size="61" maxlength='<%=family_name_length%>'>
				<select name="searchBy_family_name" id="searchBy_family_name">
				<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/>
				</select>
			</td>
		</tr>
	<%}%>
	

	</table>
	<%}%>
	<!--Santhosh end-->
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr>
			<td width = "75%" class='white' >&nbsp;</td>
			<td width = "25%" class='white' align="right"><input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' class='button' onclick='submitPage()'><input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class='button' onclick='clearAll()'>
<%	if(call_function.equals("RepDischargeAdvice"))
	{	%>
			<input type='button' name='Close' id='Close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' class='button' onclick='parent.parent.document.getElementById("dialog_tag").close();'>
<%	}	%>
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
	<!--Added by Arthi on 31-Jan-2022 for GHL-CRF-0643-->
	<input type='hidden' name='isPatIdMandAppl' id='isPatIdMandAppl' value="<%=isPatIdMandAppl%>" >
	<!--//Maheshwaran K added for TH-KW-CRF-0141.1-->
	<input type='hidden' name='isCoderClearance' id='isCoderClearance' value="<%=isCoderClearance%>" >
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

