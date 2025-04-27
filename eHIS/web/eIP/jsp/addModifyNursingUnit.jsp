<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.text.*,java.util.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
 <jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/> <!-- included for the CRF - RUT-CRF-013 23396-->
<%

	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con				= null;
	Statement st				= null;
	Statement stmt				= null;
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt2	= null;
	ResultSet rs				= null;
	ResultSet rset				= null;
	ResultSet rset7				= null;
	Statement stmt2				= null;
	ResultSet rs2				= null;
	Statement dfstmt			= null;
	ResultSet dfrset			= null;
	String shortdesc1			= "";


	String facilityId			= (String)session.getAttribute("facility_id");
	String locale				= (String)session.getAttribute("LOCALE");
	String callfunc				=(request.getParameter("call_func") == null)?"":request.getParameter("call_func");
	
	//included for the CRF - RUT-CRF-013 23396
	
	
	associateDiagBean.clearAll();
		
	String fnval				= "insert";
	String default_code			= "";
	String default_desc			= "";
	String mrflag1				= "Y";
	String dat					= "";
	String chkval				= "";
	String ID					= "";
	String sel					= "";
	String chk1					= "checked";
	String disable				= "";
	String selvalue				= "";
	String chk2					= "";
	String chk3					= "";
	String chk4					= "";
	String chk5					= "";
	String chk6					= "";
	String chk7					= "";
	String rd1					= "";
	String dis1					= "";
	String disbled				= ""; 
	String rdall				= "";
	String disall				= "";
	String disfld 				= "";
	StringBuffer dfsql			= new StringBuffer();
	String defaultdisable		= "";
	String fslocndesc			= "";
	String ALLOW_NEW_BORN_REGN_YN = "";
	StringBuffer sqlString		= new StringBuffer();
	String file_type_code		= "";
	String file_type_desc		= "";
	String fsflag				= "Y";
    String central_value		= "N";
	String fs_locn_code			= "";
	String fs_locn_desc			= "";

	String allow_alter			= request.getParameter("allow_alter");
		if(allow_alter==null)allow_alter="N";

	String disablechksex				= "";
	String nursingunitcode				= "";
	String longdesc						= "";
	String shortdesc					= "";
	String locntype						= "";
	String effstatus					= "";
	String nursingunittypecode			= "";
	String LevelCode					= "";
	String agegroupcode					= "";
	String inclforhospoccupcalcyn		= "";
	String dfltfiletypedesc      		= "";
	String dflt_file_type_code    		= "";
	String allowemergtrgyn				= "";
	String checksamesexinroomyn			= "";
	String temporarylocationyn			= "";
	String teachinglocationyn			= "";
	String allowpseudobedsrlyn			= "";
	//String generatepseudobedsrlyn		= "";
	String deptcode						= "";
	String physicalLocation				= "";
	String servicecode					= "";
	String chk_rel_bed_leave			= "";
	String dis							= "";
	String param_allow_release_bed_on_lv= "N";
	String allow_release_bed_on_lv		= "N";
	String locntypedesc					= "";
	String bill_type					= "";
	String bl_setup_ip					= "N";
	String fslocncode					= "";
	String fm_install_yn				= "";
	String online_mr_notfn_yn			= "Y";
	String auto_file_transfer_yn		= "Y";
	String online_mr_notfn_yn_chk		= "Checked";
	String auto_file_transfer_yn_chk	= "Checked";
	String dayCareDesc					= "";
	String dayCareCode					= "";
	String patientClassCode				= "";
	String sectioncode					= "";
	String mrsection					= "";
	String mrsectiondesc				= "";
	String mrsectioncode				= "";
	String mrSectionType				= "";
	String mrSectionTypedesc			= "";
	String maintain_doc_or_file			= "";
	String single_or_multi_files_ind	= "";
	String separate_file_no_yn			= "";
	String mrflag						= "Y";
	String sql1							= "";
	String create_file_yn				= "";
	int reportcnt						= 0;
	//String shortdes="";

//	String levelofcarecode[] = {"","A","E","F","N","C","R","S"};
//	String levelofcaredesc[] = {" ------- Select ------- ","Ambulatory","Emergency","Isolation","Intensive Care","Critical Care","Routine","Surgery"};

	String code = request.getParameter("nursing_unit_code");
	
	String facid = request.getParameter("facility_id");
	facid=(String)session.getAttribute("facility_id");

	
	try{	
		con = ConnectionManager.getConnection(request);
		stmt= con.createStatement();
		stmt2 = con.createStatement();
		st = con.createStatement();
		
		StringBuffer chkmp = new StringBuffer();
		//chkmp.append("select maintain_doc_or_file, single_or_multi_files_ind, separate_file_no_yn from MP_PARAM ");
		chkmp.append("select maintain_doc_or_file, single_or_multi_files_ind, separate_file_no_yn , create_file_yn from MP_PARAM ");
		rs = st.executeQuery(chkmp.toString());
		if(rs!=null)
		{
			while(rs.next())
			{
				maintain_doc_or_file		= checkForNull(rs.getString("maintain_doc_or_file"));
				single_or_multi_files_ind	= checkForNull(rs.getString("single_or_multi_files_ind"));
				separate_file_no_yn			= checkForNull(rs.getString("separate_file_no_yn"));
				create_file_yn				= checkForNull(rs.getString("create_file_yn"));
			}
		}

		if(maintain_doc_or_file.equals("D"))
			defaultdisable="disabled";
		else
			defaultdisable="";

		

		if(st!=null) st.close();
		if(rs!=null) rs.close(); 

	try
	{
		StringBuffer query_bl_chk = new StringBuffer();
		query_bl_chk.append("select setup_bl_dtls_in_ip_yn,allow_release_bed_on_lv from ip_param where facility_id='"+facilityId+"' ");
		rset = stmt.executeQuery(query_bl_chk.toString());
		if(rset!=null)
		{
			while(rset.next())
			{
				bl_setup_ip=rset.getString("setup_bl_dtls_in_ip_yn");

				param_allow_release_bed_on_lv = rset.getString("allow_release_bed_on_lv");
				if(param_allow_release_bed_on_lv.equalsIgnoreCase("y"))
				{
					chk_rel_bed_leave = "checked";
					dis = "disabled";
				}
				else
				{
					chk_rel_bed_leave = "";
					dis = "";
				}
			}
		}
	}
	catch(Exception e)
	{
		//out.print("Exception @ query_bl_chk :"+e);
		e.printStackTrace();
	}
	
/*try{
		//String str = "Select short_desc,fs_locn_code from fm_storage_locn";
		String str = "Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and locn_identity ='N' and eff_status = 'E' order by short_desc ";

		stmt=con.createStatement();
		rs = stmt.executeQuery(str);
		if(rs != null)
		{
		while(rs.next())
			{
	  shortdesc1=(rs.getString("short_desc") == null)?"":rs.getString("short_desc");
		out.println("shortdesc1=="+shortdesc1);

	}
		}
	
}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	*/

	try
	{
		StringBuffer query_FM_chk = new StringBuffer();
		query_FM_chk.append("select install_yn from sm_module where module_id='FM' ");
		stmt= con.createStatement();
		rset = stmt.executeQuery(query_FM_chk.toString());
		if(rset!=null )
		{
			if(rset.next())
			{
				fm_install_yn=rset.getString("install_yn");
				if (fm_install_yn==null) fm_install_yn="N";
			}
		}
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
	}
	catch(Exception e)
	{
		//out.print("Exception @ query_bl_chk :"+e);
		e.printStackTrace();
	}	
	
	if(code == null)
	{
		code = "";
	}
	else
	{
			fnval  = "modify";
			rd1    = "readonly";
			
			pstmt=con.prepareStatement("select nursing_unit_code, nursing_unit_code,locn_type,locn_short_desc,nursing_unit_long_desc,nursing_unit_short_desc,nursing_unit_type_code,level_of_care_code,age_group_code,dept_code,service_code,physical_location,section_code,patient_class,mr_section_code,mr_section_short_desc,file_type_short_desc,file_type_short_desc,dflt_file_type_code,mr_section_type,LOCN_SHORT_DESC,incl_for_hosp_occup_calc_yn,allow_emerg_trf_yn,temporary_location_yn,teaching_location_yn,allow_pseudo_bed_yn,check_same_sex_in_room_yn,eff_status,online_mr_notfn_yn,auto_file_transfer_yn,release_bed_on_leave_yn,fs_locn_code,FM_GET_DESC.FM_STORAGE_LOCN(FACILITY_ID, fs_locn_code,'"+locale+"','2') fs_locn_desc,ALLOW_NEW_BORN_REGN_YN from IP_NURSING_UNIT_VW where nursing_unit_code=? and facility_id =?");
			
			pstmt.setString(1,code);
			pstmt.setString(2,facid);

			rset=pstmt.executeQuery();
			rset.next();
			ALLOW_NEW_BORN_REGN_YN = checkForNull(rset.getString("ALLOW_NEW_BORN_REGN_YN"));
			if(ALLOW_NEW_BORN_REGN_YN.equals("Y")) 
				ALLOW_NEW_BORN_REGN_YN ="checked";
			else
				ALLOW_NEW_BORN_REGN_YN = "";
			nursingunitcode			= checkForNull(rset.getString("nursing_unit_code"));
			nursingunitcode			= checkForNull(rset.getString("nursing_unit_code"));
			locntype				= checkForNull(rset.getString("locn_type"));
			locntypedesc			= checkForNull(rset.getString("locn_short_desc"));
			longdesc				= checkForNull(rset.getString("nursing_unit_long_desc"));
			shortdesc				= checkForNull(rset.getString("nursing_unit_short_desc"));
			nursingunittypecode		= checkForNull(rset.getString("nursing_unit_type_code"));
			LevelCode				= checkForNull(rset.getString("level_of_care_code"));
			agegroupcode			= checkForNull(rset.getString("age_group_code"));	
			deptcode				= checkForNull(rset.getString("dept_code"));
			servicecode				= checkForNull(rset.getString("service_code"));
			physicalLocation		= checkForNull(rset.getString("physical_location"));
			sectioncode				= checkForNull(rset.getString("section_code"));
			patientClassCode		= checkForNull(rset.getString("patient_class"));
			mrsection				= checkForNull(rset.getString("mr_section_code"));
			mrsectiondesc			= checkForNull(rset.getString("mr_section_short_desc"));
			dfltfiletypedesc		= checkForNull(rset.getString("file_type_short_desc"));
			dflt_file_type_code		= checkForNull(rset.getString("dflt_file_type_code"));
			mrSectionType			= checkForNull(rset.getString("mr_section_type"));
			if(mrSectionType.equals("D"))
				mrSectionTypedesc="Department";
			else if(mrSectionType.equals("C"))
				mrSectionTypedesc="Central";

			if(fm_install_yn.equals("Y"))
			{
				fslocndesc=(rset.getString("LOCN_SHORT_DESC") == null)?"":rset.getString("LOCN_SHORT_DESC");
			}
			inclforhospoccupcalcyn	= checkForNull(rset.getString("incl_for_hosp_occup_calc_yn"));
			allowemergtrgyn			= checkForNull(rset.getString("allow_emerg_trf_yn"));
			temporarylocationyn		= checkForNull(rset.getString("temporary_location_yn"));
			teachinglocationyn		= checkForNull(rset.getString("teaching_location_yn"));
			allowpseudobedsrlyn		= checkForNull(rset.getString("allow_pseudo_bed_yn"));
			//generatepseudobedsrlyn	= checkForNull(rset.getString("generate_pseudo_bed_srl_yn"));
			checksamesexinroomyn	= checkForNull(rset.getString("check_same_sex_in_room_yn"));
			effstatus				= checkForNull(rset.getString("eff_status"));
			online_mr_notfn_yn		= checkForNull(rset.getString("online_mr_notfn_yn"));
			auto_file_transfer_yn	= checkForNull(rset.getString("auto_file_transfer_yn"));
			allow_release_bed_on_lv = checkForNull(rset.getString("release_bed_on_leave_yn"));

			if (online_mr_notfn_yn.equals("Y"))
				online_mr_notfn_yn_chk = "Checked";
			else
				online_mr_notfn_yn_chk = "";
			if (auto_file_transfer_yn.equals("Y"))
				auto_file_transfer_yn_chk = "Checked";
			else
				auto_file_transfer_yn_chk = "";
			String eff_stat=effstatus;
			fs_locn_code 			= rset.getString("fs_locn_code");
			if(fs_locn_code == null) fs_locn_code ="";

			fs_locn_desc 			= rset.getString("fs_locn_desc");
			if(fs_locn_desc == null) fs_locn_desc ="";
			
			
			if(allow_alter!=null && allow_alter.equals("Y"))
			{
				effstatus="E";
			}
			else
			{
				effstatus=eff_stat;
			}
			
			if(effstatus.equals("D"))
			{
				chk1	= "";
				disall	= "disabled";
				rdall	= "readonly";
			}
			if(inclforhospoccupcalcyn.equals("Y"))	chk2 = "checked";
			if(allowemergtrgyn.equals("Y"))			chk3 = "checked";
			if(checksamesexinroomyn.equals("Y"))	chk4 = "checked";
			if(temporarylocationyn.equals("Y"))		chk5 = "checked";
			if(teachinglocationyn.equals("Y"))		chk6 = "checked";

			if(allow_release_bed_on_lv.equals("Y"))  
			{
				chk_rel_bed_leave="checked";
				dis = "disabled";
			}
			else
			{
				chk_rel_bed_leave = "";
				dis = "";
			}
			
			if(allowpseudobedsrlyn.equals("Y"))
			{
				chk7		= "checked";
				dis1		= "disabled";
			}
			else if(fnval.equals("modify"))
				dis1		= "disabled";
			else
				dis1 = "";
			
			if(rset!=null) rset.close();
			if(pstmt!=null) pstmt.close();

			try
			{
				if(bl_setup_ip.equals("Y"))
				{
					StringBuffer query_bill_type = new StringBuffer();
					query_bill_type.append("select bill_type_code from bl_ip_nursing_unit where nursing_unit_code='"+nursingunitcode+"' and facility_id='"+facilityId+"'");

					rs2 = stmt2.executeQuery(query_bill_type.toString());

					if(rs2 != null)
					{
						while(rs2.next())
						{
							bill_type = checkForNull(rs2.getString("bill_type_code"));
						}
					if(rs2!=null) rs2.close();
					if(stmt2!=null) stmt2.close();
					}

					if((bill_type==null)||(bill_type.equals("null")))
					{
						bill_type="";
					}
				}
			}
			catch(Exception e)
			{
				
				e.printStackTrace();
			}

	try{
		//String str = "Select short_desc,fs_locn_code from fm_storage_locn";
			String str = "Select short_desc,fs_locn_code from fm_storage_locn  where facility_id = '"+facilityId+"' and locn_identity ='N' and eff_status = 'E' order by short_desc ";
			stmt=con.createStatement();
			rs = stmt.executeQuery(str);
			if(rs != null)
			{
				while(rs.next())
				{
					shortdesc1=(rs.getString("short_desc") == null)?"":rs.getString("short_desc");
		

				}
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
	
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
		try{
		
			String rptr = "Select 1 from ip_online_report where report_id = 'FMFLRQSL' and nursing_unit_code = '"+nursingunitcode+"' and facility_id ='"+facilityId+"' ";
			stmt=con.createStatement();
			rs = stmt.executeQuery(rptr);
			if(rs != null && rs.next())
			{
				reportcnt = rs.getInt(1);
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	
	
%>

<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../js/NursingUnit.js' language='javascript'></script>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language='javascript' src='../../eIP/js/IPPatInstructions.js'></script><!--included for the CRF - RUT-CRF-013 23396 -->
<script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></script>
<script language="JavaScript">
	//Function not moved because the function uses the following script variables.
	var gender_ind = new Array () ;
	var cnt = 0;

	function enableDisableChkSex(obj)
	{
	   var n = obj.selectedIndex;
	   var gender = gender_ind[n];

	   if (gender=="M" || gender=="F")
	   {
		  document.forms[0].check_same_sex_in_room_yn.disabled=true;
		  document.forms[0].check_same_sex_in_room_yn.checked=true;
		  document.forms[0].check_same_sex.value = "Y";
	   }
	   else
	   {
		  document.forms[0].check_same_sex_in_room_yn.disabled=false;
		  document.forms[0].check_same_sex_in_room_yn.checked=false;
		  document.forms[0].check_same_sex.value = "N";
	   }
	}



function GetValues(obj)
{
		
	/*
		This function is called When mr_section type value changes the mr section drop down enables and disables accrodingly and values are changed.The auto file request checkbox also enables and disables accordingly.

	*/
	//	var callfunction=document.forms(0).call_function.value;
		var LevelCode=document.getElementById('level_of_care_code').value;
		var centralValue=document.forms[0].centralValue.value;

		

		var callfunction="";

		var HTMLVal = "<html><body onKeyDown='lockKey()'><form name='popSectionVal'  id='popSectionVal' method='post' action='../../eIP/jsp/GetService.jsp'>";

		if(obj.name == "mr_section_type")
		{
			if(obj.value == 'D' && document.NursingUnit_form.reportcnt.value > 0)
			{
				alert(getMessage("FM_ONLINE_REP_RULE_NOT_DEFINED","FM"));
				obj.value = '<%=mrSectionType%>';
			}
			else
			{
				clearlist(document.forms[0].mr_section_type);
				clearlist(document.forms[0].mr_section);
				clearlist(document.forms[0].mr_location_code);
				clearlist(document.forms[0].dflt_file_type);

				var seperatefile	= document.forms[0].separate_file_no_yn.value;
				var sormid			= document.forms[0].single_or_multi_files_ind.value;

				document.forms[0].mr_section.disabled=false;

				HTMLVal+= "<input id='sectionType' name='sectionType'  type='hidden' value='"+obj.value + "'><input type='hidden' name='mrsectionName' id='mrsectionName' value='"+obj.name+"'><input name='centralValue' id='centralValue' type='hidden' value='"+centralValue+"'><input name='fminstall' id='fminstall' type='hidden' value='"+document.forms[0].fm_install.value+"'>";
				/*Friday, March 12, 2010 , 18770 to disable mr_section other than departmental and single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N")*/
				//if(obj.value=="C")
				if(obj.value != "D")
				{
					if(seperatefile=="N" && sormid=="M")
					{
						HTMLVal+="<input type='hidden' name='seperatefile' id='seperatefile' value='"+seperatefile+"'><input type='hidden' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='"+sormid+"'>";
					}
					else
					{						
						document.forms[0].mr_section.disabled=true;
					}
				}
				
				if(document.getElementById("fm_install").value == "Y")
				{
					
					HTMLVal+="<input name='criteria' id='criteria' type='hidden' value='populatefs'> ";

					if (obj.value=="D")
					{
						document.getElementById('popUp').style.visibility='visible';
						document.forms[0].online_mr_notfn_yn.value="N";
						document.forms[0].online_mr_notfn_yn1.value="N";
						document.forms[0].online_mr_notfn_yn.disabled=true;
						document.forms[0].online_mr_notfn_yn.checked=false;
						document.forms[0].auto_file_transfer_yn.value="N";
						document.forms[0].auto_file_transfer_yn.disabled=true;
						document.forms[0].auto_file_transfer_yn.checked=false;
					}	
					else
					{
						document.getElementById("popUp").style.visibility='hidden';
						if(parent.f_query_add_mod.document.forms[0].create_file_yn.value=='Y')
							document.forms[0].online_mr_notfn_yn.disabled=false;
						else
							document.forms[0].online_mr_notfn_yn.disabled=true;
						document.forms[0].auto_file_transfer_yn.disabled=false;
					}
				}
			}
		}
		else if(obj.name=="mr_location_code")
		{
			var fm_installyn=parent.frames[1].document.forms[0].fm_install.value;
		
			clearlist(document.forms[0].mr_location_code);
			clearlist(document.forms[0].dflt_file_type);

			HTMLVal+= "<input name='defaultlocn' id='defaultlocn' type='hidden' value='"+obj.value+"'><input name='criteria' id='criteria' type='hidden' value='populateDF'><input name='fminstall' id='fminstall' type='hidden' value='"+fm_installyn+ "'>";
		}
		
		HTMLVal+="<input type='hidden' name='callfunction' id='callfunction' value='"+callfunction+"'>";
		HTMLVal+="<input type='hidden' name='levelfcare' id='levelfcare' value='"+LevelCode+"'>";
		HTMLVal+= "</form></body></html>";

		/*5/12/2009 IN010516*/
		//if(obj.name != "")
		//{
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.popSectionVal.submit();
		//}

}

function clearlist(obj)
{
	if(obj.name == "mr_section_type")
	{			
		var length1= parent.frames[1].document.forms[0].mr_section.length;	
		for(i=0;i<length1;i++)
		{
			parent.frames[1].document.forms[0].mr_section.remove(1);
		}

		var length  =parent.frames[1].document.forms[0].mr_location_code.length;
		for(i=0;i<length;i++)
		{
		  parent.frames[1].document.forms[0].mr_location_code.remove(1);
		}	
		
		
	}
	else if(obj.name=="mr_location_code")
	{
         var length=parent.frames[1].document.forms[0].dflt_file_type.length;
		 for(i=0;i<length;i++)
		{
			 parent.frames[1].document.forms[0].dflt_file_type.remove(1);
		}

	}
}


function assignval(obj)
{
	if(obj.checked == true)
	{
		obj.value="Y";
		eval("parent.frames[1].document.forms[0]."+obj.name+"1").value="Y";				
	}
	else
	{
		obj.value="N";
		eval("parent.frames[1].document.forms[0]."+obj.name+"1").value="N";	
	}			
}
/* Included for the CRF Rut-CRF-013 23396*/
function invokeTab(tabdetails)
{
	if (tabdetails=='details_tab')
	{
		// parent.nur_unit_frame.rows="42,*,0,50"; 
		 
		 parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		 parent.document.getElementById("f_query_add_mod").style.height="83vh";
	     parent.document.getElementById("blank").style.height="0vh";
		 parent.document.getElementById("messageFrame").style.height="9vh";
		document.getElementById("Oth_dtls").style.display = 'inline';
		document.getElementById("pat_instns_div").style.display = 'none';	
		document.getElementById("details_tab").className="tabClicked";
		document.getElementById("patinstruction_tab").className="tabA";
		document.getElementById("othdtls_tabspan").className="tabSpanclicked";
		document.getElementById("p_tabspan").className="tabAspan";
	}
	else if (tabdetails=='patinstruction_tab')
	{
		//parent.nur_unit_frame.rows="42,30%,*,5%"; 
		
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="83vh";
		parent.document.getElementById("blank").style.height="1vh";
		parent.document.getElementById("messageFrame").style.height="8vh";
		
		document.getElementById("Oth_dtls").style.display = 'none';
		document.getElementById("pat_instns_div").style.display = 'inline';
		document.getElementById("details_tab").className="tabA";
		document.getElementById("patinstruction_tab").className="tabClicked";
		document.getElementById("othdtls_tabspan").className="tabAspan";
		document.getElementById("p_tabspan").className="tabSpanclicked";
		document.getElementById('pat_instns_div').style.visibility ='visible' ; 
	}	
}
</script>
</head>

<body onLoad="FocusFirstElement();disfilreq('<%=maintain_doc_or_file%>');" onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<form name='NursingUnit_form' id='NursingUnit_form'  method="post" action="../../servlet/eIP.NursingUnitServlet" target="messageFrame">
	<input type='hidden' name='all_new_bor' id='all_new_bor' value=''>
	<%	
	
//	if(bl_setup_ip.equals("N"))
//	{	%>	<!-- <br><br><br><br><br> -->	<%//	}	%>
<!--    <br><br><br><br> -->
	<table cellspacing=0 cellpadding=2 align='center' width='100%' border='0'>
	<tr>
		<td class='label' align='right' width='20%' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td  width='25%' align='left'>&nbsp;<input type="text" name="nursing_unit_code" id="nursing_unit_code" size='4' maxlength='4' value="<%=nursingunitcode%>" <%=rd1%> onblur="javascript:ChangeUpperCase(this)" onKeyPress="return CheckForSpecChars(event)"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td  width='25%' class='label' align='right'  ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		<td   width='20%'   align='left'><%
		if(fnval.equals("insert"))
		{
		%>&nbsp;<select name="locn_type" id="locn_type" >
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			<%
					stmt= con.createStatement();
					//rset=stmt.executeQuery("select locn_type, short_desc from am_care_locn_type where care_locn_type_ind='N'  order by short_desc");
					// modified on 11/7/2008 for ICN-6071 
					
					rset=stmt.executeQuery("select locn_type, short_desc from am_care_locn_type where care_locn_type_ind='N' and sys_user_def_ind = 'S' order by short_desc");
					if(rset!=null)
					{
					   while(rset.next())
					   {
							dat=checkForNull(rset.getString("short_desc"));
							ID=checkForNull(rset.getString("locn_type"));
							if(locntype.equals(ID))
								sel = "selected";
							else
								sel = "";
							out.println("<option value='"+ID+"' "+sel+"  "+rd1+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					out.print("</select>");}
					else
					{out.print("&nbsp;<input type='text' size=17 maxlength=15 name='locn' id='locn' readonly value='"+locntypedesc+"'>");
						out.print("<input type='hidden'  name='locn_type' id='locn_type'  value='"+locntype+"'>");}%><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
<% if(fnval.equals("modify"))
		{
		 disbled="disabled";
		}
		%>
	<tr>
		<td  class='label' align='right' width='20%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td align='left' width='30%'>&nbsp;<input type="text" name="long_desc" id="long_desc" size='60' maxlength='60' value="<%=longdesc%>" <%=rdall%> onBlur="return makeValidString(this);"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td  class='label' align='right' width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td width='20%' align='left'>&nbsp;<input type="text" name="short_desc" id="short_desc" size='30' maxlength='30' value="<%=shortdesc%>" <%=rdall%> onBlur="return makeValidString(this);"><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
	</tr>
	<tr>
			<td  class='label' align='right' width='20%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td align='left' width='25%'><input type="checkbox" name="eff_status" id="eff_status" value='E' <%=chk1%> ></td>
				<td  class='label' align='right' width='25%' ><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
				<td   align='left' width='20%'>&nbsp;<select name="applicable_to" id="applicable_to" <%=disbled%> onChange="populateFileType();disableall()">
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			<%
				stmt= con.createStatement();
				rset=stmt.executeQuery("select patient_class,short_desc from am_patient_class where patient_class in('IP','DC') order by short_desc ");
	
				if(rset!=null)
				{
				   while(rset.next())
				   {
						dayCareDesc = checkForNull(rset.getString("short_desc"));
						dayCareCode = checkForNull(rset.getString("patient_class"));
						if(patientClassCode.equals(dayCareCode))
							sel = "selected";
						else
							sel="";	   
						out.println("<option value='"+dayCareCode+"' "+sel+">"+dayCareDesc+"</option>");
					}
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			%>
			</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
	</td>
	</tr>
	<tr>
<!-- Physical Location for NU -->
		<td nowrap class='label' align='right' ><fmt:message key="Common.PhysicalLocation.label" bundle="${common_labels}"/></td>
		<td nowrap align='left' >&nbsp;<input type="text" name="physical_location" id="physical_location" size='20' maxlength='40' value="<%=physicalLocation%>" <%=rdall%> onblur="" ></td>
		<td>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>

	 </table> 
	<!--Below Line Code Added for this RUT-CRF-013 Shanthi -->
	<table cellspacing='0' cellpadding='0' width='100%' border=0>
	<tr>
		<td width= "100%" class="white">
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title='<fmt:message key="Common.details.label" bundle="${common_labels}"/>'>
				<a onclick="invokeTab('details_tab')" class="tabClicked" id="details_tab" >
					<span class="tabSpanclicked" id="othdtls_tabspan"><fmt:message key="Common.details.label" bundle="${common_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title='<fmt:message key="eAM.PatInstructions.label" bundle="${common_labels}"/>'>
				<a onclick="invokeTab('patinstruction_tab')" class="tabA" id="patinstruction_tab" >
					<span class="tabAspan" id="p_tabspan"><fmt:message key="eAM.PatInstructions.label" bundle="${am_labels}"/></span>
				</a>
			</li>
 </td></tr>
</table>	
	
	<!--Above Line Code Added for this CRF  Shanthi-->
<div id='Oth_dtls'>
<table cellspacing=0 cellpadding=2 align='center' width='100%' border='0'>
	<th align='left'  colspan='4'><fmt:message key="Common.FileDetails.label" bundle="${common_labels}"/></th>
<tr>
	<td   class='label' align='right' width='20%'  ><fmt:message key="Common.MRSectionType.label" bundle="${common_labels}"/></td>
	<td width='30%' align='left'   >
	<%	if(fnval.equals("modify") && effstatus.equals("D"))
		{	%>
			<input type="text" name="mr_section_type_desc" id="mr_section_type_desc" value="<%=mrSectionTypedesc%>" readonly>
			<input type="hidden" name="mr_section_type" id="mr_section_type" value="<%=mrSectionType%>">
	<%	}
		else
		{
			// For the mr section type only if the single or multi files indicator == M then the values are populated else the field is shown as disabled.
			if(maintain_doc_or_file.equals("F"))
			{
				if(!single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N"))
				{
					mrflag="N";
			%>
					<select name='mr_section_type' id='mr_section_type' >
					<option value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select>
			<%	}
				else
				{	%>
					<select name='mr_section_type' id='mr_section_type' onChange='GetValues(this);' onmousewheel='return false;'>
			<%	}
			}
			else
			{	%>
				<select name='mr_section_type' id='mr_section_type' <%=defaultdisable%> >
				<option value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select>
		<%	}
		
			if(maintain_doc_or_file.equals("F") && mrflag.equals("Y"))
			{
				if(mrSectionType.equals("D"))
				{	%>
					<option value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
					<option value='D' selected><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/>
					<option value='C'><fmt:message key="Common.Central.label" bundle="${common_labels}"/>
			<%	}
				else if(mrSectionType.equals("C"))
				{	%>
					<option value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
					<option value='D'><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/>
					<option value='C' selected><fmt:message key="Common.Central.label" bundle="${common_labels}"/>
			<%	}
				else
				{	%>
					<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
					<option value='D'><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/>
					<option value='C'><fmt:message key="Common.Central.label" bundle="${common_labels}"/>
			<%	}	%>
				</select>
				<%
			}
		}	%>
	</td>
		
		<td   class='label' width='25%' align='right'  ><fmt:message key="Common.MRSection.label" bundle="${common_labels}"/></td>
		<td width='20%' align='left'   >
	<%		if(fnval.equals("modify") && effstatus.equals("D"))
			{
			%>
				<input type="text" name="mr_section_desc" id="mr_section_desc" value="<%=mrsectiondesc%>" readonly>
				<input type="hidden" name="mr_section" id="mr_section" value="<%=mrsection%>">
			<%
			}
			else
			{	
				// For the mr section only if the single or multi files indicator == M && separate_file_no_yn == N then the values are populated else the field is shown as disabled.
				
				if(maintain_doc_or_file.equals("F"))
				{
					/*Friday, March 12, 2010 , 18770 to disable mr_section other than departmental and should satisfy single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N")*/
					//if(!single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N"))
					if(!mrSectionType.equals("D"))
					{
						if(!(single_or_multi_files_ind.equals("M") && separate_file_no_yn.equals("N")))
						{
						mrflag1="N";
						%>
						&nbsp;<select name='mr_section' id='mr_section' disabled><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
						<%		
						}
					}
				}
				else
				{	
				%>
					&nbsp;<select name='mr_section' id='mr_section'  <%=defaultdisable%>>
						<option value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
					</select>
		<%		}	
				if(mrflag1.equals("Y"))
				{
				%>
				&nbsp;<select name='mr_section' id='mr_section'>
						<option value='' >--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
<%
				if(maintain_doc_or_file.equals("F"))
				{
					try
					{
						if(!fnval.equals("insert") && fm_install_yn.equals("Y"))
						{

							if(!mrSectionType.equals(""))
							{
								if(mrSectionType.equals("C"))
								{
									sql1="select mr_section_code,short_name from mr_section where 	facility_id='"+facilityId+"' and eff_status='E' and mr_section_type = 'C' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
								}
								else if(mrSectionType.equals("D"))
								{
									sql1="select mr_section_code,short_name from mr_section where facility_id='"+facilityId+"' and eff_status='E' and mr_section_type = 'D' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by short_name";
								}

								pstmt=con.prepareStatement(sql1);								
								rs=pstmt.executeQuery();

								if(rs != null)
								{
									while(rs.next())
									{
										mrsectioncode=checkForNull(rs.getString("mr_section_code"));
										if(mrsection.equals(mrsectioncode))
											sel="selected";
										else
											sel="";
										%>
										<option value='<%=mrsectioncode%>' <%=sel%>><%=checkForNull(rs.getString("short_name"))%></option>
								<%	}
								}

								if(rs != null) rs.close();
								if(pstmt != null) pstmt.close();
							}
						}
					}catch(Exception e)
					{
						
						e.printStackTrace();
					}

					%>
					</select>
					<%
				}
			}
			}	%>
	 </td>
</tr>
<tr>
	<td   class='label' width='20%' align='right'  ><fmt:message key="Common.FileStorageLocation.label" bundle="${common_labels}"/></td>
	<td width='30%' align='left' >
	<%
	 if(fnval.equals("modify") && effstatus.equals("D"))
	{
	%>
		&nbsp;<input type="text" name="mr_location_desc" id="mr_location_desc" value="<%=fs_locn_desc%>" readonly>
		<input type="hidden" name="mr_location_code" id="mr_location_code" value="<%=fs_locn_code%>">
	<%
	}
	else
	{	
	%>
		&nbsp;<select name=mr_location_code onchange="GetValues(this);">
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
		// If the FM install boolean is yes and in insert mode the single and multi files indicator is not M...then the field values are populated.The single and multi files ind is not considered for modify mode.

		if(fm_install_yn.equals("Y"))
		{									
			if(fnval.equals("modify"))
			{
				try
				{
					if(maintain_doc_or_file.equals("F"))
					{
						fsflag="N";
						if(!mrSectionType.equals(""))
						{
							if(mrSectionType.equals("D"))
							{
								pstmt=con.prepareStatement("Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and eff_status = 'E' and MR_LOCN_YN='Y' and permanent_file_area_yn='Y' and locn_identity ='"+central_value+"' order by short_desc ");
							}
							else if(mrSectionType.equals("C"))
							{
								pstmt=con.prepareStatement(" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ");
							}
						}
						else
						{
							pstmt=con.prepareStatement(" Select short_desc,fs_locn_code from fm_storage_locn where facility_id = ? and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' and eff_status = 'E' order by short_desc ");
						}

							pstmt.setString(1,facilityId);

							rs=pstmt.executeQuery();
							if(rs != null)
							{
								while(rs.next())
								{
									

									fslocncode=(rs.getString("fs_locn_code") == null)?"":rs.getString("fs_locn_code");

								
										
									if(fs_locn_code.equals(fslocncode))
										sel="selected";
									else
										sel="";
									%>
										<option value='<%=fslocncode%>' <%=sel%>><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%>
								<%
								}
							}

							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();

					}
				}catch(Exception e)
				{
					
					e.printStackTrace();
				}
			}
		try
		{
			if(fsflag.equals("Y") && !maintain_doc_or_file.equals(""))
			{
				if(maintain_doc_or_file.equals("D"))
				{
					pstmt=con.prepareStatement("Select short_desc,fs_locn_code from fm_storage_locn where facility_id = '"+facilityId+"' and locn_identity ='"+central_value+"' and eff_status = 'E' order by short_desc");
				
				}
				else if(maintain_doc_or_file.equals("F")&& fsflag.equals("Y"))
				{
					pstmt=con.prepareStatement("Select short_desc,fs_locn_code from fm_storage_locn   where facility_id = '"+facilityId+"' and eff_status = 'E' and locn_identity ='"+central_value+"' and permanent_file_area_yn='N' order by short_desc ");
				
				}
				
				rs=pstmt.executeQuery();
				if(rs != null)
				{
					while(rs.next())
					{
						fslocncode=(rs.getString("fs_locn_code") == null)?"":rs.getString("fs_locn_code");
						if(fs_locn_code.equals(fslocncode))
							sel="selected";
						else
							sel="";
						%>
							<option value='<%=fslocncode%>' <%=sel%>><%=(rs.getString("short_desc") == null)?"":rs.getString("short_desc")%>
						<%
					}
				}
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
			}
			}catch(Exception ef)
			{
				
				ef.printStackTrace();
			}
			
		}
	%>
		</select><img id='popUp' src='../../eCommon/images/mandatory.gif' align='center' style='visibility:hidden'></img>
	<%
	}
	%>
	 </td>
	<td align='right' class='label' width='25%' ><fmt:message key="Common.DefaultFileType.label" bundle="${common_labels}"/></td>
	<td align='left' width='20%' >
	<%
	if(fnval.equals("modify") && effstatus.equals("D"))
	{
	%>
		&nbsp;<input type="text" name="dflt_file_type_desc" id="dflt_file_type_desc" value="<%=dfltfiletypedesc%>" readonly>
		<input type="hidden" name="dflt_file_type" id="dflt_file_type" value="<%=dflt_file_type_code%>">
	<%
	}
	else
	{
		if(fnval.equals("modify"))
		{
			if(fm_install_yn.equals("Y"))
			{
				dfsql.append(" select a.file_type_code file_type_code,b.short_desc file_type_desc from FM_FILE_TYPE_FOR_FSL a, MR_FILE_TYPE b where b.facility_id ='"+facilityId+"' and a.facility_id = b.facility_id and a.fs_locn_code ='"+fs_locn_code+"'  and a.file_type_code = b.file_type_code and a.eff_status = 'E' ");

				if((LevelCode.equals("A"))&&(!callfunc.equals("DaycareUnit")))
					dfsql.append(" and b.appl_to_ip='Y' ");
				else if((LevelCode.equals("A"))&&(callfunc.equals("DaycareUnit")))
					dfsql.append(" and b.appl_to_dc='Y' ");
				else if(LevelCode.equals("E"))
					dfsql.append(" and b.appl_to_em='Y' ");

				dfsql.append(" order by file_type_desc ");

			}
		}

		/*if(fm_install_yn.equals("N") )
		{
			dfsql.append(" select file_type_code,SHORT_DESC file_type_desc from mr_file_type where facility_id ='"+facilityId+"' and EFF_STATUS = 'E' and appl_to_op = 'Y' order by short_desc ");*/
/*
			if(fnval.equals("insert"))
			{
				if(!callfunc.equals("DaycareUnit")) 
				   dfsql+=" and appl_to_op = 'Y' ";
				else
					dfsql+=" and appl_to_dc='Y'";
			}
			else
			{
				if((LevelCode.equals("A"))&&(!callfunc.equals("DaycareUnit")))
					dfsql+=" and appl_to_op='Y'";
				else if((LevelCode.equals("A"))&&(callfunc.equals("DaycareUnit")))
					dfsql+=" and appl_to_dc='Y'";
				else if(LevelCode.equals("E"))
					dfsql+=" and appl_to_em='Y'";
			}
			 dfsql+=" order by short_desc";
		 */
		/*}*/
		%>
		&nbsp;<select name=dflt_file_type <%=defaultdisable%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
		//if(fnval.equals("modify")  || fm_install_yn.equals("N") )
		if(fnval.equals("modify")  && fm_install_yn.equals("Y") )
		{

			dfstmt=con.createStatement();
			dfrset=dfstmt.executeQuery(dfsql.toString());

			while(dfrset.next())
			{
				default_code=dfrset.getString("file_type_code");
				default_desc=dfrset.getString("file_type_desc");
					
				if(dflt_file_type_code.equals(default_code))	
					selvalue="selected";
				else
					selvalue="";
				%>
				<option value='<%=default_code%>' <%=selvalue%>><%=default_desc%></option>
		<%	}	
			if(dfrset != null )dfrset.close();
			if(dfstmt != null )dfstmt.close();

		}	%>																
		</select>
		<%

		}
		%>
		</td>
	</tr>
	<tr>
		<td align='right' class='label'  width='20%'><fmt:message key="Common.AutoFileRequest.label" bundle="${common_labels}"/></td>
		<td align='left' width='30%' >
		<%
			chkval="";
		//String chkval2= "";

			
			if(online_mr_notfn_yn.equals("Y") && create_file_yn.equals("Y"))
			{
				chkval="checked";
			}
			else if(online_mr_notfn_yn.equals("N"))
			{
				chkval="";
			}
			
			if(maintain_doc_or_file.equals("D"))
			 {
				online_mr_notfn_yn="N";
				chkval="";
			 }

			if(fnval.equals("modify") && ((effstatus.equals(""))||(effstatus==null)||(effstatus.equals("D"))))
			{
				disable="disabled";
			}else
			{
				disable="";
			}
		%>
		<input type='checkbox' name='online_mr_notfn_yn' id='online_mr_notfn_yn' value='<%=online_mr_notfn_yn%>' <%=chkval%>  onClick='assignval(this);chkAutoFilReq(this);' <%=disable%> <%=defaultdisable%> <%if(create_file_yn.equals("N")){%>disabled<%}%>>	
		<input type='hidden' name='online_mr_notfn_yn1' id='online_mr_notfn_yn1' value='<%=online_mr_notfn_yn%>' >
		<input type='hidden' name='create_file_yn' id='create_file_yn' value='<%=create_file_yn%>' >
		</td>
		<%
			if(auto_file_transfer_yn.equals("Y"))
			{
				chkval="checked";
			}
			else if(auto_file_transfer_yn.equals("N"))
			{
				chkval="";
			}
			
			if(maintain_doc_or_file.equals("D"))
			 {
				auto_file_transfer_yn="N";
				chkval="";
			 }
		%>
		<td  class='label' width='25%' align='right'><fmt:message key="eIP.AutoFileTransfer.label" bundle="${ip_labels}"/></td>
		<td width='20%' align='left' ><input type="checkbox" name="auto_file_transfer_yn" id="auto_file_transfer_yn" value='<%=auto_file_transfer_yn%>' <%=disable%> <%=chkval%> <%=defaultdisable%> onClick='checkvalue(this)' ></td>	
	</tr>
</table>

<!-- 	
<select name="mr_section_type" id="mr_section_type" onchange='populatemrSectionType(this);disen();' <%=disall%> ><option value=''> ------- Select ------- ;</option>
		<%if(fnval.equals("insert")){%>
	 <option value='C'><fmt:message key="Common.Central.label" bundle="${common_labels}"/> </option>
	 <option value='D'><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/> </option>
		<%
	}else if(fnval.equals("modify"))
		{%>
		<option value='C'<%=(mrSectionType.equals("C"))?"Selected":""%>><fmt:message key="Common.Central.label" bundle="${common_labels}"/> </option>
	 <option value='D'<%=(mrSectionType.equals("D"))?"Selected":""%>><fmt:message key="Common.Departmental.label" bundle="${common_labels}"/></option>
		
		<%}	%> 
	</select></td>


		<td  nowrap class='label' align='right' width = '20%' >MR Section</td>
		<td nowrap width = '20%'>&nbsp;&nbsp;<select name="mr_section_code" id="mr_section_code"  <%=disall%>  style ='width:145px'><option value=''> ------- Select ------- ;</option>
		 <%
		stmt= con.createStatement();
		rset=stmt.executeQuery(" select SHORT_NAME, MR_SECTION_CODE from MR_SECTION where eff_status='E' and facility_id='"+facilityId+"' and MR_SECTION_TYPE ='"+mrSectionType+"' order by SHORT_NAME");
			if(rset!=null)
			{
			   while(rset.next())
			   {
					dat=checkForNull(rset.getString("SHORT_NAME"));
					ID=checkForNull(rset.getString("MR_SECTION_CODE"));
				
					if(mrsection.equals(ID))
				   {				
						sel = "selected";
				   }
					else
				   {
						sel="";
				   }
					out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
				}
			}
		%> 
				</select>
&nbsp;<img id="img3" src='../../eCommon/images/mandatory.gif'align='center'></img>
		</td>
</tr>
<tr>
	<td nowrap class='label' align='right' nowrap>File Storage Location</td>
			<td nowrap>&nbsp;
			<%
				  if(disall.equals("disabled"))
					{
				  disfld="disabled";
				    }
%>				<select name="fs_locn_code" id="fs_locn_code" <%=disfld%> style ='width:200px' onChange="populateFileType();">
				<option value=''>&nbsp; ------- Select ------- &nbsp;
<%				
		if(fnval.equals("modify"))
		{
	
		stmt= con.createStatement();
		if(mrSectionType.equals("C"))
			{
			rset=stmt.executeQuery("select FS_LOCN_CODE, short_desc from fm_storage_locn where locn_identity='N' and eff_status = 'E' and locn_identity = 'N' and permanent_file_area_yn = 'N' and facility_id='"+facilityId+"' order by short_desc");
			}
		else
		if(mrSectionType.equals("D"))
			{
			rset=stmt.executeQuery(" select fs_locn_code, short_desc from fm_storage_locn where facility_id = '"+facilityId+"' and mr_locn_yn ='Y' and permanent_file_area_yn = 'Y' and locn_identity = 'N'");
			}

			if(rset!=null)
			{
			   while(rset.next())
			   {
				dat=checkForNull(rset.getString("short_desc"));
				ID=checkForNull(rset.getString("FS_LOCN_CODE"));
				if(fslocncode.equals(ID))
					sel = "selected";
				else
					sel="";
				out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
				}
			}
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		}

%>			</select><img align='center' id='mandatory_gif' src='../../eCommon/images/mandatory.gif' style="visibility:hidden"></img>
			</td>
	<td  nowrap class='label' align='right' > &nbsp;Default File Type</td>
	<td nowrap >&nbsp;&nbsp;<select name="dflt_file_type" id="dflt_file_type"  <%=disall%>  style="width:123">	
	<%
	if(!dfltfiletypedesc.equals(""))
	{
	%>
		<option value=''> ------- Select ------- ;</option>
	<%
		if ((fm_install_yn.equals("Y")) && (!fslocncode.equals("")) && (dayCareCode.equals("IP")))
		{
			sqlString.append(" SELECT distinct a.file_type_code file_type_code, c.short_desc file_type_desc FROM fm_file_type_for_fsl a, mr_file_type c WHERE c.facility_id = ? AND a.facility_id = c.facility_id AND a.fs_locn_code = ? AND a.file_type_code = c.file_type_code AND appl_to_ip = 'Y' ORDER BY file_type_desc ");
		}
		else if ((fm_install_yn.equals("N")) && (dayCareCode.equals("IP")))
		{
			sqlString.append(" SELECT  distinct file_type_code, short_desc file_type_desc FROM mr_file_type WHERE facility_id = ? AND appl_to_ip = 'Y' AND eff_status = 'E' ORDER BY short_desc ");
		} 
		if (sqlString.length() > 0)
		{
			pstmt2	=	con.prepareStatement(sqlString.toString());
			pstmt2.setString(1, facilityId);
			if (fm_install_yn.equals("Y"))
			pstmt2.setString(2, fslocncode);
			rset7	=	pstmt2.executeQuery();
			if (rset7 != null)
			{
				while(rset7.next())
				{
					file_type_code	=	checkForNull(rset7.getString("file_type_code"));
					file_type_desc	=	checkForNull(rset7.getString("file_type_desc"));
					if(dfltfiletypedesc.equals(file_type_desc))
					{
					out.println("<option value='"+file_type_code+"' selected>"+file_type_desc+"</option>");
					}
					else
					{
					out.println("<option value='"+file_type_code+"'>"+file_type_desc+"</option>");
					}
				}
			if(rset7!=null) rset7.close();
			if(pstmt2!=null) pstmt2.close();
		}
		}
	}
	else
		{
		%>
		<option value=''> ------- Select ------- ;</option>
		<%
		}
	%>
	</select>
	</td>
</tr>
		<%
			if(fm_install_yn.equals("Y"))
	{
			%>
			<tr><td nowrap class='label' align='right'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Auto File Request</td>
	   <td nowrap>&nbsp;<input type="checkbox" name="online_mr_notfn_yn" id="online_mr_notfn_yn" value='<%=online_mr_notfn_yn%>' <%=online_mr_notfn_yn_chk%> <%=disall%> onClick='checkvalue(this)'></td>	
	   <td nowrap class='label' align='right'>&nbsp;&nbsp;Auto File Transfer</td>
	   <td nowrap>&nbsp;<input type="checkbox" name="auto_file_transfer_yn" id="auto_file_transfer_yn" value='<%=auto_file_transfer_yn%>' <%=auto_file_transfer_yn_chk%>  <%=disall%> onClick='checkvalue(this)' ></td>	
		   <%
	}
	   %>
	</tr>
-->


<table cellspacing=0 cellpadding=2 align='center' width='100%' border='0'>
	<th align='left' width='25%' colspan='4'><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></th>
	<tr>
		<td   class='label' align='right' width='20%'><fmt:message key="eIP.NursingUnitType.label" bundle="${ip_labels}"/></td>
		<td  width='30%' align='left'>&nbsp;<select name="nursing_unit_type_code" id="nursing_unit_type_code" <%=disall%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%
		stmt= con.createStatement();
		rset=stmt.executeQuery(" select short_desc, nursing_unit_type_code from ip_nursing_unit_type where eff_status='E'  order by short_desc");
					if(rset!=null)
					{
					   while(rset.next())
					   {
							dat=checkForNull(rset.getString("short_desc"));
							ID=checkForNull(rset.getString("nursing_unit_type_code"));
							if(nursingunittypecode.equals(ID))
								sel = "selected";
							else
								sel="";
							out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					
				%>
				</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>
					
				
		<td  class='label' align='right' width='25%'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
		<td  width='20%' align='left'>&nbsp;<select name="age_group_code" id="age_group_code" <%=disall%> onChange="enableDisableChkSex(this)">
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%
					stmt= con.createStatement();
					rset=stmt.executeQuery("select short_desc, age_group_code, gender from am_age_group where eff_status = 'E' order by short_desc ");
					if(rset!=null)
					{
					   String genderval = "";
					   out.println("<script>gender_ind[cnt]='';cnt++;</script>");
					   while(rset.next())
					   {
							dat	= checkForNull(rset.getString("short_desc"));
							ID	= checkForNull(rset.getString("age_group_code"));
							if(agegroupcode.equals(ID))
								sel = "selected";
							else
								sel	= "";

							genderval = rset.getString(3);
							if (genderval == null) genderval = "";
							if(agegroupcode.equals(ID) && (genderval.equals("M") || genderval.equals("F")))
								disablechksex = "disabled";

							out.println("<script>gender_ind[cnt] = '"+genderval+"';cnt++;</script>");
							out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
				%>
				</select>
		</td>
	</tr>
<tr>

<!-- LEVEL OF CARE  -->
	<td  class='label' align='right' width='20%'><fmt:message key="Common.levelofcare.label" bundle="${common_labels}"/></td>
	<td  width='30%' align='left'>&nbsp;<select name="level_of_care_code" id="level_of_care_code" <%=disall%>><option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%
	stmt= con.createStatement();
	rset=stmt.executeQuery("SELECT LEVEL_OF_CARE_CODE,LEVEL_OF_CARE_DESC FROM am_level_of_care where eff_status = 'E' order by LEVEL_OF_CARE_DESC");
			if(rset!=null)
				{
				   while(rset.next())
				   {
						dat	= checkForNull(rset.getString("LEVEL_OF_CARE_DESC"));
						ID	= checkForNull(rset.getString("LEVEL_OF_CARE_CODE"));
						if(LevelCode.equals(ID))
							sel = "selected";
						else
							sel="";
						out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
					}
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			%>
		</select>
	</td> 
	<td colspan='2' class='label'></td>
</tr>

	<tr>
		<td  class='label' align='right' width='20%'><fmt:message key="eIP.AllowTransferWOReq.label" bundle="${ip_labels}"/></td>
		<td  width='30%' align='left'><input type="checkbox" name="allow_emerg_trg_yn" id="allow_emerg_trg_yn" value='Y' <%=chk3%> <%=disall%>></td>
		<td   class='label' width='25%' align='right'><fmt:message key="eIP.CheckforSameSexinRoom.label" bundle="${ip_labels}"/></td><td  width='20%' align='left'><input type="hidden" name="check_same_sex" id="check_same_sex" value='Y' ><input type="checkbox" name="check_same_sex_in_room_yn" id="check_same_sex_in_room_yn" value='Y' <%=chk4%> <%=disall%> <%=disablechksex%> onClick='assignValues(this)'></td>
	</tr>

	<tr>
		<td  class='label' align='right' width='20%'><fmt:message key="eIP.TemporaryLocation.label" bundle="${ip_labels}"/></td>
		<td  align='left' width='30%'><input type="checkbox" name="temporary_location_yn" id="temporary_location_yn" value='Y' <%=chk5%> <%=disall%>></td>
		<td  class='label' align='right' width='25%'><fmt:message key="eIP.TeachingLocation.label" bundle="${ip_labels}"/></td><td  align='left' width='20%'><input type="checkbox" name="teaching_location_yn" id="teaching_location_yn" value='Y' <%=chk6%> <%=disall%>></td>
	</tr>

<!-- Release Bed on Leave added on 31/01/04 by Sridhar -->
	<tr>
		<td  class='label' align='right' width='20%'><fmt:message key="eIP.ReleaseBedonLeave.label" bundle="${ip_labels}"/></td>
		<td  align='left' width='30%'><input type="checkbox" name="rel_bed_on_leave" id="rel_bed_on_leave" value='Y' <%=dis%> <%=chk_rel_bed_leave%> ></td>
		
		<td  class='label' align='right' width='25%'><fmt:message key="eIP.IncludeforHospitalOccupancyCalculations.label" bundle="${ip_labels}"/></td><td  align='left' width='20%'><input type="checkbox" name="incl_for_hosp_occup_calc_yn" id="incl_for_hosp_occup_calc_yn" value='Y' <%=chk2%> <%=disall%>></td>
	</tr>
			<tr>
		<td  class='label' align='right' width='20%'><fmt:message key="eIP.AllowNewbornRegn.label" bundle="${ip_labels}"/></td>
		<td  align='left' width='30%'><input type="checkbox" name="ALLOW_NEW_BORN_REGN_YN" id="ALLOW_NEW_BORN_REGN_YN" value='Y'  <%=ALLOW_NEW_BORN_REGN_YN%> <%=disall%>></td>
		<td colspan=2></td>	</tr>

	<tr><th colspan='4' align='left'><fmt:message key="eIP.Pseudo.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="eIP.Beds.label" bundle="${ip_labels}"/></th></tr>
	<tr>
		<td class='label' align='right' width='20%' ><fmt:message key="eIP.AllowPseudoBeds.label" bundle="${ip_labels}"/></td>
		<td align='left' width='30%'><input type="checkbox" name="allow_pseudo_bed_srl_yn" id="allow_pseudo_bed_srl_yn" value='Y'  <%=dis1%> <%=chk7%> <%=disall%> onClick="javascript:enableDisable(this)"></td>
		<td colspan='2'></td>
	</tr>

	<tr>
		<th align='left' colspan='4'><fmt:message key="eIP.AcctDeptService.label" bundle="${ip_labels}"/></th>
	</tr>
	<tr>
		<td   class='label' align='right' width='20%'><fmt:message key="Common.acctdept.label" bundle="${common_labels}"/></td>
		<td width='30%' align='left'>&nbsp;<select name="dept_code" id="dept_code" <%=disall%> onChange="javascript:getService('I')">
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---<%
				    stmt= con.createStatement();
					rset=stmt.executeQuery("select dept_short_desc, dept_code from am_facility_dept_vw where operating_facility_id='"+facilityId+"' and eff_status = 'E' order by 1");
					if(rset!=null)
					{
					   while(rset.next())
					   {
							dat=checkForNull(rset.getString("dept_short_desc"));
							ID=checkForNull(rset.getString("dept_code"));
							if(deptcode.equals(ID))
								sel = "selected";
							else
								sel="";
							out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
						}
					}
					if(rset!=null) rset.close();
					if(stmt!=null) stmt.close();
					
				%>
				 </select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
		</td>

<!-- SECTION  -->
		<td   class='label' align='right' width='25%'><fmt:message key="Common.Section.label" bundle="${common_labels}"/></td>
		<td width='20%' align='left'>&nbsp;<select name="section" id="section" <%=disall%> ><option>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option></select>
		<input type="hidden" name="hidden_section_code" id="hidden_section_code" value="<%=sectioncode%>"></td>
	</tr>
<tr>
<!-- SERVICE -->
	<td nowrap class='label' align='right' ><fmt:message key="Common.service.label" bundle="${common_labels}"/></td>
	<td nowrap align='left' >&nbsp;<select name="service_code" id="service_code" <%=disall%> >
	<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</select><img align='center' src='../../eCommon/images/mandatory.gif'></img><input type="hidden" name="hidden_service_code" id="hidden_service_code" value="<%=servicecode%>">
	<%
		if(fnval.equals("modify"))
			out.println("<script>getService('M');</script>");
	%> 
	</td>
	<td>&nbsp;</td>
	<td>&nbsp;</td>
	</tr>
			<input type="hidden" name="function_name" id="function_name" value= '<%=fnval%>'>
			<input type="hidden" name="bl_setup_ip" id="bl_setup_ip" value= '<%=bl_setup_ip%>'>
			<input type="hidden" name="fm_install_yn" id="fm_install_yn" value= '<%=fm_install_yn%>'>
			<input type="hidden" name="hdd_param_releaseBed" id="hdd_param_releaseBed" value="<%=param_allow_release_bed_on_lv%>" >	
				<input type="hidden" name="fslocncode" id="fslocncode"			value="<%= fslocncode %>">

</table>

<br>
	<%
	if(bl_setup_ip.equals("Y"))
	{
	%>
	<table cellspacing=0 cellpadding=2 width='100%' border='0'>
		<th colspan='4' align='left'><fmt:message key="eIP.BillingParameter.label" bundle="${ip_labels}"/></th>
		<tr><td  class='label' align='right' width='20%'><fmt:message key="Common.BillingClass.label" bundle="${common_labels}"/></td>
				<td  width='30%'>&nbsp;<select name="bill_type" id="bill_type" <%=disall%>>
						<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
						<%
							stmt= con.createStatement();
							rset=stmt.executeQuery("select bill_type_code, short_desc from bl_bill_type where status is null order by 2");
							if(rset!=null)
							{
								while(rset.next())
								{
									dat	= checkForNull(rset.getString("short_desc"));
									ID	= checkForNull(rset.getString("bill_type_code"));
									if(bill_type.equals(ID))
										sel = "selected";
									else
										sel="";
									out.println("<option value='"+ID+"' "+sel+">"+dat+"</option>");
								}
							}
							if(rset!=null) rset.close();
							if(stmt!=null) stmt.close();
							
						%>
						</select><img align='center' src='../../eCommon/images/mandatory.gif'></img>
			<input type="hidden" name="hidden_bill_type" id="hidden_bill_type" value="<%=bill_type%>" >
		</td>
		<td colspan=2></td>
	</tr>
</table>
	<%
	}
%>
</div>
<!--Included for the CRF - RUT CRF 013 -->
<div id="pat_instns_div" style="visibility:hidden;display:none">
<table border='0' cellpadding='0' cellspacing='0'  align='center'  width='100%'>
<tr>
	<td  colspan='5'>&nbsp;</td>
</tr> 
<tr>
	 <td width='20%' class='label'><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></td>
	 <td class='fields'><input type='text' name='serial_no' id='serial_no' value="" size='10' maxlength='2'  onKeyPress="return CheckForSpecChar(event)" onblur="if(this.value!='')CheckForZero()"><img src='../../eCommon/images/mandatory.gif'></img></td>
	 <td width='20%'>&nbsp;</td>
     <td class='label'><fmt:message key="eAM.InstructionDescript.label" bundle="${am_labels}"/></td>
	 <td><input type="text" name="instruction_desc" id="instruction_desc" size="12" maxlength="200" value="" onblur='getInstructionDesc(instruction_desc)' ><input type='button' name='desc_button' id='desc_button' value='?'  class='button' onClick='getInstructionDesc(instruction_desc)' ><img src='../../eCommon/images/mandatory.gif'></img></td>
</tr>
<tr>
	 <td width='20%' class='label'><fmt:message key="eAM.InstructionID.label" bundle="${am_labels}"/></td>
	 <td class='fields'><input type='text' name='instruction_id' id='instruction_id' size='10' maxlength='8' value="" readonly></td>
	 <td width='20%'>&nbsp;</td>
     <td width='20%'>&nbsp;</td>
	 <td><input type='button' name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' class='button' onClick='addRecord()'>
	<input type='button' name='del' id='del'  disabled value='<fmt:message key="Common.delete.label" bundle="${common_labels}"/>' class='button' onClick='deleteRecord()' ></td>
</tr>
<tr id='searchBoxBG' style='display:inline'>
	<td colspan="5">

	</td>
</tr> 
</table>
</div>
<%
if(fnval.equals("modify"))
{
%>	
	<script>
		document.NursingUnit_form.long_desc.select();
	</script>
 	<script>	
		
		parent.frames[2].location.href="../../eIP/jsp/IPPatInstructionsResult.jsp?mode=modify&nursing_unit_code=<%=nursingunitcode%>&facility_id=<%=facilityId%>";
	</script> 
<%	}
	else if (fnval.equals("insert")) {
		%>
		<script>		
		parent.frames[2].location.href="../../eIP/jsp/IPPatInstructionsResult.jsp";
		</script> 
		<%
	}

	if(fnval.equals("modify"))
	{
		if(patientClassCode!=null)
		if(patientClassCode.equals("DC"))
		{	%>
			<script>
				document.forms[0].mr_section_type.value			  =  "";
				document.forms[0].mr_section_type.disabled		  = true;
				document.forms[0].mr_section.value			      =  "";
				document.forms[0].mr_section.disabled			  = true;
				document.forms[0].mr_location_code.value		  =  "";
				document.forms[0].mr_location_code.disabled		  = true;
				document.forms[0].dflt_file_type.value			  =  "";
				document.forms[0].dflt_file_type.disabled		  = true;
				document.forms[0].online_mr_notfn_yn.disabled    = true;
				document.forms[0].auto_file_transfer_yn.disabled  = true;
//				document.forms[0].img3.style.visibility = 'hidden';
				</script>
	
	<%	}
	if(mrSectionType.equals("D")&&effstatus.equals("E"))
	   {
	%>
			<script>
				if('<%=maintain_doc_or_file%>' != "")
					document.getElementById("popUp").style.visibility='visible';

				document.forms[0].online_mr_notfn_yn.disabled=true;
				document.forms[0].online_mr_notfn_yn.checked=false;
				document.forms[0].auto_file_transfer_yn.disabled=true;
				document.forms[0].auto_file_transfer_yn.checked=false;
			</script>
<%	
	}
	}
%>	
	<script>
			if(document.NursingUnit_form.hdd_param_releaseBed.value == "Y")
			   document.NursingUnit_form.rel_bed_on_leave.disabled = true;
		</script>
		<input type='hidden' name='separate_file_no_yn' id='separate_file_no_yn' value='<%=separate_file_no_yn%>' >
		<input type='hidden' name='single_or_multi_files_ind' id='single_or_multi_files_ind' value='<%=single_or_multi_files_ind%>' >
		<input type='hidden' name='fm_install' id='fm_install' value='<%=fm_install_yn%>' >
		<input type='hidden' name='online_mr_notfn_yn1' id='online_mr_notfn_yn1' value='<%=online_mr_notfn_yn%>' >
		<input type='hidden' name='maintain_doc_or_file' id='maintain_doc_or_file' value='<%=maintain_doc_or_file%>' >
		<input type='hidden' name='centralValue' id='centralValue' value="N">
		<input type='hidden' name='reportcnt' id='reportcnt' value="<%=reportcnt%>">
		<input type='hidden' name='locale' id='locale' value="<%=locale%>">
		<input type='hidden' name='mode_flag' id='mode_flag' value='false'>
		<input type='hidden' name='ins_flag' id='ins_flag' value='false'>


</form>
	<%
		if(rset	 != null)	rset.close();
		if(rs2	 != null)	rs2.close();
		if(rs	 != null)	rs.close();
		if(rset7 != null)	rset7.close();
		if(stmt2  != null)	stmt2.close();
		if(st  != null)		st.close();
		if(stmt  != null)	stmt.close();
		if(pstmt != null)	pstmt.close();
		if(pstmt2 != null)	pstmt2.close();

	}catch(Exception e){
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	 %>

</body>
</html>
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

