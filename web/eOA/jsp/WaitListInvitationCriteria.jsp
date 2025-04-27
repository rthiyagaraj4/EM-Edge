<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<!--
	Developed by 	:	Suman
	Created on 	:	14/04/2005
	Module		:	OA
	Function	:	Manage WaitList
-->
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" %>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link>
 -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eOA/js/WaitListInvitation.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eOA/js/WaitListMgmt.js'></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script>


<script>
async function searchCountry(obj,target)
            {
                var retVal =    new String();
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
				var locale=document.forms[0].locale.value;
                var tit="";				
               					
					tit=getLabel("Common.nationality.label","Common");
                    sql="Select country_code code,long_desc description from Mp_Country_lang_vw where eff_status='E' and  upper(country_code) like upper(?) and upper(long_desc) like upper(?) and language_id = '"+locale+"'";					
				
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
				document.forms[0].nat_id_code.value=arr[0]	;
				}
				else{
					target.value='';
				}
			}



	async function searchCommonCode(obj,target,title)
            {
				var retVal =    new String();                
                var tit=title;				
				var argumentArray  = new Array() ;
				var dataNameArray  = new Array() ;
				var dataValueArray = new Array() ;
				var dataTypeArray  = new Array() ;
                var locale=document.forms[0].locale.value;
				if(obj.name=="town_code")
                {
					 sql="Select res_town_code code,long_Desc description from Mp_res_town_lang_vw where eff_status='E' and upper(res_town_code) like upper(?) and upper(long_Desc) like upper(?) and eff_status = 'E' and language_id = '"+locale+"'";
                 }
				if(obj.name=="region_code")
                {
                    sql="Select region_code code,long_Desc description from Mp_region_lang_vw where eff_status='E' and upper(region_code) like upper(?) and upper(long_Desc) like upper(?) and eff_status = 'E' and language_id = '"+locale+"'";
                }
				if(obj.name=="area_code")
                {
                    sql="Select res_area_code code ,long_Desc description from Mp_res_area_lang_vw where eff_status='E' and upper(res_area_code) like upper(?) and upper(long_Desc) like upper(?) and eff_status = 'E' and language_id = '"+locale+"'";
                }
				argumentArray[0] =sql;
				argumentArray[1] = dataNameArray ;
				argumentArray[2] = dataValueArray ;
				argumentArray[3] = dataTypeArray ;
				argumentArray[4] = "1,2";
				argumentArray[5] = target.value;
				if(obj.name=="postal_code"){
					argumentArray[6] = CODE_LINK  ;
					argumentArray[7] = CODE_DESC ;
				}
				else{
				argumentArray[6] = DESC_LINK  ;
				argumentArray[7] = DESC_CODE ;
				}               
				retVal = await CommonLookup( tit, argumentArray );
				var arr=new Array();
                if(retVal != null && retVal != "" )
                {
				
                    var ret1=unescape(retVal);
					arr=ret1.split(",");
					if(obj.name=="postal_code"){
					target.value=arr[0];
					}
					else{
					target.value=arr[1];
					}
				
					 if(target.name=='r_area_code'){
						document.forms[0].r_area.value= arr[0];
					}
					else if(target.name=='m_area_code'){
						document.forms[0].m_area.value= arr[0];
					}else if(target.name=='r_region_code'){
						document.forms[0].r_region.value= arr[0];
					}else if(target.name=='m_region_code'){
						document.forms[0].m_region.value= arr[0];

					} else if(target.name=='r_town_code'){
						document.forms[0].r_town.value= arr[0];
					}
					else if(target.name=='m_town_code'){
						document.forms[0].m_town.value= arr[0];
					}

		
              }
                else
				{
					if(obj.name=='postal_code'){
                    target.value='';
					}
					else
					{
					 if(target.name=='r_area_code'){
						document.forms[0].r_area.value= '';
					 }
					 else if(target.name=='m_area_code'){
						document.forms[0].m_area.value= '';
					 }else if(target.name=='r_region_code'){
					  document.forms[0].r_region.value='';
					 }
					 else if(target.name=='m_region_code'){
						document.forms[0].m_region.value= '';
					 } else if(target.name=='r_town_code'){
						document.forms[0].r_town.value= '';
					 }
					 else if(target.name=='m_town_code'){
						document.forms[0].m_town.value= '';
					 }
					}
					target.value='';
				}
            } 
</script>
<%
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");


		Connection con = null;		
		Statement stmt   	= null;		 
		Statement stmt1 = null;
		ResultSet rs_oa 		=null;	 
		ResultSet rs=null;
		ResultSet rset1 = null;
		PreparedStatement pstmt=null;
	

		int pat_id_len=0;
		String currentdate="";
		String oper_stn_id="";
		 String ALCN_CRITERIA_YN="";
		 String ELAPSED_GRACE_PERIOD="";
		 String cancel_wait_list_yn="";
		 String modify_wait_list_yn="";
		 String waitlist_category_reqd_yn="";
		 String waitlist_category_appl_yn = "" ;
		 String install_yn_ca = "" ;
		 String curr_month = "" ;
		 String old_date = "" ;
		 String prd = "" ;
		 String invitation_list_appl_yn = "" ;
		 String restrict_wl_cat_agst_splty_yn = "" ;
		 String Patient_Id_Length="";
		
		String sql4="";
	   String install_yn="";
						
		

		  String function_id=request.getParameter("function_id");	
		  cancel_wait_list_yn=request.getParameter("cancel_wait_list_yn");
		  modify_wait_list_yn=request.getParameter("modify_wait_list_yn");
		  oper_stn_id=request.getParameter("oper_stn_id");
		  currentdate=request.getParameter("currentdate");
		  Patient_Id_Length=request.getParameter("Patient_Id_Length");
		  install_yn = request.getParameter("install_yn");
		  pat_id_len = Integer.parseInt(Patient_Id_Length);		
		  Properties p=(Properties)session.getValue("jdbc");

		  String globaluser = (String)p.getProperty("login_user");
		  String locale=(String)session.getAttribute("LOCALE"); 
		  String facilityId	=(String) session.getValue("facility_id");


		
try
{
		con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;		
		 stmt1 = con.createStatement();

			String fac_id    	= (String) session.getValue( "facility_id" ) ;
			rs_oa = stmt1.executeQuery("select nvl(ALCN_CRITERIA,'None') ALCN_CRITERIA,ELAPSED_GRACE_PERIOD,waitlist_category_appl_yn, invitation_list_appl_yn,WAITLIST_CATEGORY_REQD_YN,restrict_wl_cat_agst_splty_yn,nvl(FORCECLOSE_PERIOD,0) prd,(SELECT install_yn FROM sm_module WHERE module_id = 'CA') install_yn_ca,to_char(sysdate,'mm') curr_month, to_char(sysdate,'dd/mm/yyyy') old_date  from oa_param");
			if(rs_oa !=null && rs_oa .next()) {
				ALCN_CRITERIA_YN=rs_oa.getString("ALCN_CRITERIA");
				ELAPSED_GRACE_PERIOD=rs_oa.getString("ELAPSED_GRACE_PERIOD");
				waitlist_category_reqd_yn=rs_oa.getString("WAITLIST_CATEGORY_REQD_YN");
				restrict_wl_cat_agst_splty_yn=rs_oa.getString("restrict_wl_cat_agst_splty_yn");
				invitation_list_appl_yn=rs_oa.getString("invitation_list_appl_yn");
				waitlist_category_appl_yn=rs_oa.getString("waitlist_category_appl_yn");
				install_yn_ca=rs_oa.getString("install_yn_ca");
				curr_month=rs_oa.getString("curr_month");
				old_date=rs_oa.getString("old_date");
				prd=rs_oa.getString("prd");
			}
			 
			if(rs_oa !=null) rs_oa.close();

			/*if (!ALCN_CRITERIA_YN.equals("None") )
			out.println("<script>alert(getMessage('OA_PARAM_NOT_FOUND','OA'));			parent.frames[0].document.location.href='../../eCommon/jsp/home.jsp';</script>");*/
			
			String prompt_sql = "select initcap(res_area_prompt)res_area_prompt, initcap(res_town_prompt)res_town_prompt, postal_code_prompt, initcap(region_prompt)region_prompt from sm_site_param_lang_vw where language_id = '"+locale+"'";
			String res_area_prompt = "";
			String res_town_prompt = "";
			String region_prompt = "";
			
			rset1 = stmt1.executeQuery(prompt_sql) ;

		while(rset1.next())
		{
			res_area_prompt=rset1.getString("res_area_prompt");
			if(res_area_prompt ==null) res_area_prompt="";
			res_town_prompt=rset1.getString("res_town_prompt");
			if(res_town_prompt ==null) res_town_prompt="";
			region_prompt=rset1.getString("region_prompt");
			if(region_prompt ==null) region_prompt="";
		}

		if(rset1 !=null) rset1.close();	 

		%>

		<html>
		<head>
		</head>
		
		<body onLoad="chgbuttonclr();" onload='focus()' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='WaitListMgmtForm' id='WaitListMgmtForm' method="post">
		
<table name='waitMgmtTable1' id='waitMgmtTable1' width='100%' align='center' cellpadding='0' cellspacing='0' border='0'>		
		
	<tr>
			<td class='label' nowrap width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
			
			<td class='fields' nowrap width='25%'>
					<%
		

				//rs=stmt.executeQuery("select short_desc ,speciality_code from Am_Speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id='"+facilityId+"' and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id='"+oper_stn_id+"' and b.eff_status='E') and language_id = '"+locale+"'  order by short_desc");
			    String sql1 = "select short_desc ,speciality_code from Am_Speciality_lang_vw where eff_status='E' and speciality_code  in (select speciality_code FROM op_clinic a, am_locn_for_oper_stn b where a.facility_id=? and a.facility_id = b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id=? and b.eff_status='E') and language_id =?  order by short_desc";
				pstmt = con.prepareStatement(sql1);
				pstmt.setString(1,facilityId);
				pstmt.setString(2,oper_stn_id);
				pstmt.setString(3,locale);
				rs = pstmt.executeQuery();

					%>
					<select name="speciality" id="speciality" tabindex=1 onchange='enable_category(this);'> 
					<option value="">----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
					<%
					while(rs.next()){

						out.println("<option value='" + rs.getString("Speciality_Code") + "' >" + rs.getString("Short_Desc")+"</option>");
					}
					%>
					</select><img id='image' align=center src='../../eCommon/images/mandatory.gif'></img></td>

			<td class='label' nowrap width='25%'><fmt:message key="eOA.WaitlistCategory.label" bundle="${oa_labels}"/></td>
			
			<td class='fields' nowrap width='25%'>
			<input type='text' disabled name='walst_category' id='walst_category' onblur='open_lookup_one();' value='' size='20' maxlength='20'><input disabled type='button' class='BUTTON' name='walst_cate_search' id='walst_cate_search' value='?' onClick='open_lookup();'></td>
	
			
	</tr>
	
	<tr>				
		<%							
			if(install_yn.equals("Y")) { %>	
	
			<td class='label' nowrap ><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
				
			<td class='fields'>
				<input type=text name='or_catalogue_desc' id='or_catalogue_desc' size=20 onblur="clear_vals()"><input type='button' class='button' value='?'  name='search_or' id='search_or' onClick="callORSearch();"   tabindex=0>
				<input type="hidden" name="or_catalogue_code" id="or_catalogue_code">
				
			</td>
				
			<td class='label' nowrap ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			
			<td class='fields'  nowrap>
				<select name='priority' id='priority'>
				<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/></option>
				<option value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option></td>

		<% } else {%>
			<td class='label' nowrap ><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
			
			<td class='fields'  nowrap>
				<select name='priority' id='priority'>
				<option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
				<option value='U'><fmt:message key="Common.urgent.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.semiurgent.label" bundle="${common_labels}"/></option>
				<option value='N'><fmt:message key="Common.Normal.label" bundle="${common_labels}"/></option></td>

			<td colspan='2'>&nbsp;</td>

			<%}%>
	</tr>
			
		
	<tr>
			<td class='label' ><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></td>
		
			<td class='fields'>
				
				<select name='location' id='location' onChange='ensureSpl(this);enable_dis1(this);' tabindex=2><option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				
					<%
					String sql_locn="Select Locn_Type, Short_Desc, care_locn_type_ind from am_care_locn_type_lang_vw where sys_user_def_ind = 'S' and locn_type in ('C','E','Y','N') and language_id = '"+locale+"' order by 2";
					String locationType="";
					String shortDesc="";
					if (rs!=null) rs.close();
					rs=stmt.executeQuery(sql_locn);

					if (rs!=null)
					{
						while(rs.next())
						{	
							locationType= rs.getString("care_locn_type_ind");
							shortDesc= rs.getString("Short_Desc");
							out.println("<option value='"+locationType+"'>"+shortDesc+"</option>");
						}
					}
					%> 

					</select></td>
						
			<td class='label' ><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
		
			<td class='fields'>  
				
				<!--<select name='locationType' id='locationType' onChange='enable_dis(this);dispPrimaryResource();' tabindex=3><option value=''>---------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option></select>-->
				<input type='text' size='25' maxlength='25' name='b_loc_val' id='b_loc_val' value='' onblur="ena_loc_lookup(this);"><input type="hidden" name="locationType" id="locationType" value=""><input type='button' name="b_loc_search" id="b_loc_search" value="?" onClick="open_loc_lookup();" class='button'>
				</td>
			
			
	</tr>

	<tr id='resource_part'><jsp:include page="../../eOA/jsp/OAResourcelookupframe.jsp" ><jsp:param name="flush" value="true" />
	<jsp:param name ="from_page" value= "create_wl" />
	<jsp:param name ="pract_value" value= "" />
	</jsp:include>



			<td class="label" style="font-weight:bold" align='left' colspan='4' id='pract_type1' width='12%' nowrap >&nbsp;</td> 

	</tr>


	

	<tr>
			
			<td class='label' nowrap ><fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/></td>
			
			<td class='fields' nowrap>
				<input type=text name='WaitListNo' id='WaitListNo' size='10' maxlength='12' value='' tabindex=4></td>

			<td class='label' nowrap ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></td>
			
			<td class='fields' nowrap>	
			
				<input type='text' name='frmDate'  id='frmDate' value='' size='10' maxlength='10' onBlur="ValidateDate(this);" tabindex=9><img  style="cursor:pointer" id='img1'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].frmDate.focus();return showCalendar('frmDate');">&nbsp;-&nbsp;<input type=text name='ToDate'  id='ToDate' size='10' maxlength='10' value='' onBlur="validate_date_to(this,frmDate);" tabindex=10><img  style="cursor:pointer" id='img2'  src='../../eCommon/images/CommonCalendar.gif' onClick="document.forms[0].ToDate.focus();return showCalendar('ToDate');"></td>

	</tr>
	<tr>
			<td class='label' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
			
			<td class='fields' nowrap>
						<%if(function_id.equals("WAIT_LIST_MGMT")) {%>
						<select name='waitlst_status' id='waitlst_status' disabled tabindex=2>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option></select>
						<%}else {%>
						<select name='waitlst_status' id='waitlst_status' onchange='chk_open_elap(this)' tabindex=2>
						<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
						<option value='S'><fmt:message key="Common.Selected.label" bundle="${common_labels}"/></option>
						<option value='I'><fmt:message key="eOA.invited.label" bundle="${oa_labels}"/>
						</select>
							<%}%>
				
						</td> 
	
		</td>
		<td class='label' nowrap><fmt:message key="Common.Elapsed.label" bundle="${common_labels}"/></td>	
		<td class='fields' nowrap><input type='checkbox' name='elapswl' id='elapswl' value='N' onclick='elapswlClick(this);'tabindex=11></td>
	</tr>
	<tr>
				
			<td class='label' nowrap ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				
			<td class='fields'>
				
					<input type=text name='patientid' id='patientid' size='<%=pat_id_len%>'  maxlength='<%=pat_id_len%>' value='' onblur='changeCase(this);' tabindex=6><input type=button name='commonLookup' id='commonLookup' value='?' class='button' onclick='callPatientSearch(); '></td>
				
			<td class='label' nowrap ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></td>
				
			<td class='fields'><input type=text name='patientName' id='patientName' size='35' maxlength='60' value='' tabindex=7></td>

	</tr>
				
				
	<tr>
					
			<td class='label' nowrap ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				
			<td class='fields' >
				
					<select name='gender' id='gender' tabindex=8><option value=''>-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/><option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/><option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></select>
				</td>

			<td class='label' nowrap ><fmt:message key="Common.nationality.label" bundle="${common_labels}"/></td>
				
			<td class='fields'>
				
					<input type=text name='nationality_desc' id='nationality_desc'  size='20' maxlength='20' value='' onblur='if(this.value !="")searchCountry(nationality_id,nationality_desc);'><input type='button' name='nationality_id' id='nationality_id' value='?' class='button' onclick='searchCountry(this,nationality_desc)'>
			</td>

	</tr>

	<tr>			
			<td class='label' nowrap ><fmt:message key="Common.Town.label" bundle="${common_labels}"/></td>
			
			<td class='fields' ><input type=text name='r_town_code' id='r_town_code' size='20'  maxlength='20' onchange="if(this.value != '') { searchCommonCode(town_code,r_town_code,'<%=res_town_prompt%>')}else{
					clr_value(town_code,this);
				}"><INPUT TYPE='button' class='button' name='town_code' id='town_code' value='?' onclick='searchCommonCode(this,r_town_code,"<%=res_town_prompt%>")' tabindex='$'> 
			</td>
				
			 <td class=label ><fmt:message key="Common.area.label" bundle="${common_labels}"/></td>
			
			 <td class='fields'  ><input type='text' name='r_area_code' id='r_area_code'   onchange= "if(this.value != ''){ searchCommonCode(area_code,r_area_code,'<%=res_area_prompt%>')}else{clr_value(area_code,this);
			}"><input type='button' name='area_code' id='area_code' value='?' class='button' onclick="searchCommonCode(this,r_area_code,'<%=res_area_prompt%>')">
			 </td>
						 
 </tr>

<tr>
				
				 
				<td class='label'  nowrap ><fmt:message key="eMP.region.label" bundle="${mp_labels}"/></td>
				 <td class='fields' nowrap>
				<input type=text name='r_region_code' id='r_region_code' onblur= "if(this.value != ''){searchCommonCode(region_code,r_region_code,'<%=region_prompt%>')}else{
					clr_value(region_code,this);
				}"><input type='button' name='region_code' id='region_code' value='?' class='button' onclick="searchCommonCode(this,r_region_code,'<%=region_prompt%>')"></td>
				<td colspan='2' >&nbsp;</td>
</tr>

			<tr><td class='white' colspan='4' ></td></tr>



		<tr>	
					<td colspan='4' align='left'>
					<jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name ="patient_id"   value= "" />
					<jsp:param name ="alert_reqd_yn"   value= ""  /> 
					<jsp:param name ="nat_id_disabled"  value = "" /> 
					</jsp:include>
					</td>	
			<tr>
				

		</table>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='b_pract' id='b_pract' value=''>
		<input type='hidden' name='res_class' id='res_class' value=''>
		<input type='hidden' name='oper_stn' id='oper_stn' value='<%=oper_stn_id%>'>
		<input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>
		<input type='hidden' name='Patient_Id_Length' id='Patient_Id_Length' value='<%=Patient_Id_Length%>'>
		 <input type='hidden' name='fac_id' id='fac_id' value='<%=fac_id%>'>
		<input type='hidden' name='ALCN_CRITERIA_YN' id='ALCN_CRITERIA_YN' value='<%=ALCN_CRITERIA_YN%>'>
		<input type='hidden' name='r_town' id='r_town' value=''> 
		<input type='hidden' name='m_town' id='m_town' value=''> 
		<input type='hidden' name='r_area' id='r_area' value=''> 
		<input type='hidden' name='m_area' id='m_area' value=''> 
		<input type='hidden' name='r_region' id='r_region' value=''> 
		<input type='hidden' name='m_region' id='m_region' value=''> 
		<input type='hidden' name='nat_id_code' id='nat_id_code' value=''> 
		<input type='hidden' name='elapsed_grace_period' id='elapsed_grace_period' value='<%=ELAPSED_GRACE_PERIOD%>'>
		<input type='hidden' name='open_elap_val' id='open_elap_val'    value=''>
		<input type='hidden' name='install_yn' id='install_yn'     value='<%=install_yn%>'>
		<input type='hidden' name='waitlist_category_reqd_yn' id='waitlist_category_reqd_yn' value='<%=waitlist_category_reqd_yn%>'>
		<input type='hidden' name='waitlist_category_appl_yn' id='waitlist_category_appl_yn' value='<%=waitlist_category_appl_yn%>'>
		<input type='hidden' name='install_yn_ca' id='install_yn_ca' value='<%=install_yn_ca%>'>
		<input type='hidden' name='curr_month' id='curr_month' value='<%=curr_month%>'>
		<input type='hidden' name='old_date' id='old_date' value='<%=old_date%>'>
		<input type='hidden' name='prd' id='prd' value='<%=prd%>'>
		<input type='hidden' name='invitation_list_appl_yn' id='invitation_list_appl_yn' value='<%=invitation_list_appl_yn%>'>
		<input type='hidden' name='restrict_wl_cat_agst_splty_yn' id='restrict_wl_cat_agst_splty_yn' value='<%=restrict_wl_cat_agst_splty_yn%>'>
		 
		<input type='hidden' name='ORDER_BY_VAL' id='ORDER_BY_VAL' value=''>
		<input type='hidden' name='ORDER' id='ORDER' value=''>
		<input type='hidden' name='walst_category_code' id='walst_category_code' value=''>
		<input type='hidden' name='function_id' id='function_id' value='<%=function_id%>'>
		<input type='hidden' name='fromSelect' id='fromSelect' value='fromSelect'>
        <input type='hidden' name='modify_wait_list_yn' id='modify_wait_list_yn' value='<%=modify_wait_list_yn%>'>
		<input type='hidden' name='cancel_wait_list_yn' id='cancel_wait_list_yn' value='<%=cancel_wait_list_yn%>'>
		


		</form>
		</body>
		</html>

			
<% 
	if (rs !=null) rs.close(); 
	if (rs_oa !=null) rs_oa.close();
	if (rset1 !=null) rset1.close();	 
	if (stmt!=null) stmt.close();
	if (stmt1!=null) stmt1.close();

	 
}catch(Exception e)
{
	//out.println("asdsad :" +e);
	e.printStackTrace();
}
finally
{
	if (stmt!=null) stmt.close();
	if (stmt1!=null) stmt1.close();

	ConnectionManager.returnConnection(con,request);
}
%>

