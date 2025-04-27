<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../js/NursingUnitBed.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
		<%
			request.setCharacterEncoding("UTF-8");
			//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
			Connection con			= null;
			ResultSet GenderRS1		= null;
			Statement Genderstmt1	= null;
			Statement stmt			= null;
			ResultSet rs			= null;
			Statement stmt1			= null;
			ResultSet rs1			= null;
			ResultSet BedRs			= null;
			Statement BedStmt		= null;

			String facility_id		= (String)session.getAttribute("facility_id");
			String nursing_unit_code= request.getParameter("nursing_unit_code");

			String fn_val				= "insert";
			String nursing_unit_desc	= "";
			String bed_no				= "";
			String room_no				= "";
			String eff_status			= "E";
			String bed_class_code		= "";
			String bed_type				= "";
			String gender_spec_ind		= "";
			String speciality_code		= "";
			String bed_class_desc		= "";
			String speciality_code_desc	= "";
			String mainBedNo			= "";
			String disable				= "";
			String bed_type_desc		= "";
			String disableVal			= "";
			String occupying_patient_id = "";
			String DisVal				= "";
			String isCensusBedEnable    = "";     //Added by mano GHL-CRF-418
			String census_bed_yn	    = "";     //Added by Mano GHL-CRF-418
			StringBuffer BedSql         = new StringBuffer();

try{
			con							= ConnectionManager.getConnection(request);
			stmt						= con.createStatement();
			//added by mano GHL-CRF-418
            boolean isCensusBedApplicable	= eCommon.Common.CommonBean.isSiteSpecific(con, "IP","CENSUS_BED");
			//End of the GHL-CRF-418
			if(nursing_unit_code!=null)
			{
				fn_val					= "modify"; 
				bed_no					= request.getParameter("bed_no");
				StringBuffer modify_sql = new StringBuffer();

				modify_sql.append("select * from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit_code+"' and bed_no='"+bed_no+"'  and facility_id='"+facility_id+"'");

				rs						= stmt.executeQuery(modify_sql.toString());

				if(rs!=null)
				{
					if(rs.next())
					{
						nursing_unit_desc	= rs.getString("NURSING_UNIT_SHORT_DESC")	;
						bed_no				= rs.getString("bed_no")	;
						room_no				= rs.getString("room_no");
						occupying_patient_id= rs.getString("occupying_patient_id");
						if(occupying_patient_id==null)
							occupying_patient_id="";
						eff_status			= rs.getString("eff_status")	;

						bed_class_code		= rs.getString("bed_class_code")	;
						bed_class_desc		= rs.getString("BED_CLASS_SHORT_DESC")	;

						bed_type			= rs.getString("bed_type_code")	;
						bed_type_desc		= rs.getString("BED_TYPE_SHORT_DESC")	;

						gender_spec_ind		= rs.getString("sex_spec_ind")	;
						if(gender_spec_ind==null)	gender_spec_ind="";

						speciality_code		= rs.getString("specialty_code")	;
						if(speciality_code==null)	speciality_code="";

						speciality_code_desc= rs.getString("SPECAILTY_SHORT_DESC")	;
						if(speciality_code_desc==null)
							speciality_code_desc="";

						mainBedNo			=	rs.getString("MAIN_BED_NO")	;

						census_bed_yn	    =  rs.getString("census_bed_yn")	;   //Added By Mano GHL-CRF-418
						

						if(mainBedNo==null) mainBedNo = "";
						disable				= "Disabled";

						//inpatient	= rs.getString("inpatient_pat_class_appl_yn")	;
						//emergency	= rs.getString("emergency_pat_class_appl_yn")	;
						//day_care	= rs.getString("daycare_pat_class_appl_yn")	;
						//new_born	= rs.getString("newborn_pat_class_appl_yn")	;
						//lodger		= rs.getString("lodger_pat_class_appl_yn")	;
					}
					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				StringBuffer sql_gender = new StringBuffer();
				sql_gender.append("select gender from am_age_group ");
				sql_gender.append("where  age_group_code=(select age_group_code from ip_nursing_unit ");
				sql_gender.append("where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"')");

				stmt					= con.createStatement();
				rs						= stmt.executeQuery(sql_gender.toString());
				String gender			= "";
				if(rs != null)
				if(rs.next())
				{
					gender				= rs.getString(1);
					if(gender == null || gender.equals("null"))		gender = "";
				}
					if(rs!=null) rs.close();

				if(!gender.equals(""))
					disableVal			= "disabled";
				else
					disableVal			= "";

				
			}

// Added on 6 FEB by Sridhar
// DisVal will contain the Patient_ID who has Ocuppied the Corresponding Bed.
	if(fn_val.equals("modify"))
	{
		bed_no							= request.getParameter("bed_no");

		BedSql.append("Select occupying_patient_id FROM ip_nursing_unit_bed WHERE bed_no = '"+bed_no+"' and nursing_unit_code='"+nursing_unit_code+"' and facility_id='"+facility_id+"' ");

		BedStmt							= con.createStatement();
		BedRs							= BedStmt.executeQuery(BedSql.toString());

		if(BedRs != null)
		{
			while(BedRs.next())
			{
				DisVal					= BedRs.getString("occupying_patient_id");
			}
		}
		
		if(DisVal == null)
		{	
			if(BedRs!=null) BedRs.close();
			if(BedStmt!=null) BedStmt.close();
			if(BedSql.length() > 0) BedSql.delete(0,BedSql.length());
			//BedSql.append("select count(*) count from pr_encounter where ASSIGN_CARE_LOCN_CODE = '"+nursing_unit_code+"' and ASSIGN_BED_NUM = '"+bed_no+"'");

			BedSql.append(" select count(1) from IP_ADT_TRN where to_nursing_unit ='"+nursing_unit_code+"' and TO_BED_NO='"+bed_no+"'and facility_id='"+facility_id+"' ");

			BedStmt						= con.createStatement();
			BedRs						= BedStmt.executeQuery(BedSql.toString());

			if(BedRs != null)
			{
				while(BedRs.next())
				{
					int count			= BedRs.getInt(1);
					if(count > 0)
					DisVal				= "TransactionExists";
					else
					DisVal				= "";
				}
			}
		}
		if(BedRs!=null) BedRs.close();
		if(BedStmt!=null) BedStmt.close();
		if(DisVal == null ) DisVal="";
	}

	String Gender = "";
	if(gender_spec_ind == "")
	{	
			Genderstmt1=con.createStatement();
			GenderRS1=Genderstmt1.executeQuery(" SELECT a.nursing_unit_code, a.short_desc, a.age_group_code, DECODE(b.gender,'M','Male','F','Female','U','Unknown')gender FROM ip_nursing_unit a, am_age_group b WHERE a.nursing_unit_code ='"+nursing_unit_code+"' AND b.age_group_code = a.age_group_code and a.facility_id='"+facility_id+"' ");
			if(GenderRS1!=null)
			{
				while(GenderRS1.next())
				{
					Gender = GenderRS1.getString("Gender");
				}
			}
			if(Gender == null)	Gender = "";
	}
%>
</head>
	
	<%if(fn_val.equals("insert")){%>
		<body onLoad='focusTxt();' onMouseDown="CodeArrest()" onKeyDown = "lockKey()">
	<%}else{%><body onMouseDown="CodeArrest()" onKeyDown = "lockKey()" ><%}%>

	<form name='Nursing_Unit_Bed' id='Nursing_Unit_Bed' method='post' action='../../servlet/eIP.NursingUnitBedServlet' target='messageFrame'>
	<table cellspacing=0 cellpadding=0 align='center' width='100%' height='100%'  border='0'>
	<tr>
		<td height='100%' width='100%' align='middle' class='white'>
		<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>
		<tr><td colspan='4'>&nbsp;</td></tr>

			<tr>
				<td  class='label' align='right'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></td>
				<td colspan='3' align ='left'>&nbsp;
				<%if(fn_val.equals("insert"))
					{%>							
					<jsp:include page="NursingUnitComponent.jsp" ><jsp:param name="flush" value="true" /></jsp:include><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<%}
					else
					{%><input type='text' name='nursing_unit1' id='nursing_unit1' maxlength='15' size='15' value="<%=nursing_unit_desc%>" readonly><input type='hidden' name='nursing_unit' id='nursing_unit' value="<%=nursing_unit_code%>" readonly><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				<%}%>
				</td>
			</tr>

			<tr><td colspan='4'>&nbsp</td></tr>

				<%
				String disbl_bed = "disabled";
				if(fn_val.equals("modify"))
				 {
					if(eff_status.equals("D")) 
						disbl_bed = "disabled";
					else
						disbl_bed = "";
				 }
				 else if(fn_val.equals("insert"))
						 disbl_bed = "disabled";
				%>

			<tr>
				<td class='label' align='right'><fmt:message key="eIP.MainBedNo.label" bundle="${ip_labels}"/></td>
				<td colspan='3' align ='left'>&nbsp;&nbsp;<input type='text'  name='main_bed_no' id='main_bed_no' value="<%=mainBedNo%>" <%=disable%> <%=disbl_bed%> size='8' maxlength='8' onKeyPress='return CheckForSpecChars(event)' value='' onblur='ChangeUpperCase(this);getDetails(this);'><input type='button'  name='search_bed' id='search_bed' value='?' onclick='searchBed()' class='button' <%=disable%> <%=disbl_bed%>></td>
			</tr>
			<tr><td colspan='4'>&nbsp</td></tr>
			<tr>
				<td  class='label' align='right'><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<%
					if(eff_status.equals("E"))
					{
						StringBuffer sql_room = new StringBuffer();
						sql_room.append("select room_no from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"' and eff_status='E' order by 1");
				%><select name='room' id='room'>
				<option value='' >---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
				<%
					if (fn_val.equals("modify"))
					{

						stmt1 = con.createStatement();

						rs1 = stmt1.executeQuery(sql_room.toString());
						
						String p_room_no="";

						while (rs1.next())
						{
							p_room_no = rs1.getString("room_no");

							if (p_room_no.equals(room_no))
							{
				%>
							<OPTION VALUE="<%=p_room_no%>" selected><%= p_room_no %>
				<%		
							}
							else
							{
				%>
							<OPTION VALUE="<%=p_room_no%>" ><%= p_room_no %>
				<%			}
						}
					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					}
				%>
						</select>
				<%}
					else
					{%><input type='text' name='room' id='room' value="<%=room_no%>" maxlength=8 size=12 readonly><%
					}%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			
				<td  class='label' align='right'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<%
				String readOnly="";
				if(fn_val.equals("modify"))	readOnly="readonly";%><input type='text' name='bed_no' id='bed_no' size='8' maxlength='8' value="<%=bed_no%>" <%=readOnly%> onBlur='ChangeUpperCase(this)' onKeyPress="return CheckForSpecChars(event)" ><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>

			<tr><td colspan='4'>&nbsp</td></tr>
            <tr>
			<%
			  if(isCensusBedApplicable) { //Added by Mano GHL-CRF-418
				 isCensusBedEnable = "checked";
				 if(census_bed_yn.equals("Y"))
					isCensusBedEnable = "checked";	
				 else if(census_bed_yn.equals("N"))
					 isCensusBedEnable = "";
			%>
			<td class='label' align='right'>
			<fmt:message key="eIP.CensusBed.label" bundle="${ip_labels}"/></td>     
			<td>&nbsp;&nbsp;<input type='checkbox'  name='CENSUS_BED' id='CENSUS_BED' value='Y' <%=isCensusBedEnable%> ></td> 
			<%}else{%>
				<input type='hidden' name='CENSUS_BED' id='CENSUS_BED' value="" />
			<%}%>
			<td  class='label' align='right'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
				<%
					String chk_val="checked";
					if(eff_status.equals("D"))
						chk_val="";
				%>
			<td <%if(isCensusBedApplicable){%>colspan='2'<%}else{%>colspan='3'<%}%>>&nbsp;<input type='checkbox'  name='eff_status' id='eff_status' value='E'  <%=chk_val%>></td>
		
			
			</tr>
			<tr><td colspan=4 class='white'>&nbsp</td></tr>
			<tr><td colspan=4 class='white'>&nbsp</td></tr>

			<tr>
				<th colspan='4' align='left'><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></th>
			</tr>

			<tr><td colspan='4'>&nbsp</td></tr>

			<tr>
				<td  class='label' align='right'><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<%
						if(eff_status.equals("E"))
						{
					%><select name="bed_class" id="bed_class" onchange='popDynamicValues(this)'>
							<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
							<%
								StringBuffer bed_class_sql = new StringBuffer();
								bed_class_sql.append("select short_desc, bed_class_code from ip_bed_class ");
     							bed_class_sql.append("where eff_status='E' order by short_desc");
								try
								{
									rs = stmt.executeQuery(bed_class_sql.toString());
									String sel = "";
									while(rs.next())
									{
										if(rs.getString(2).equals(bed_class_code))
										{
											sel="selected";
										}
										out.print("<option value='"+rs.getString(2)+"' "+sel+">"+rs.getString(1)+"</option>");
										sel="";
									}
									if(rs!=null) rs.close();
									if(stmt!=null) stmt.close();
								}
								catch(Exception e)
								{
									//out.print(e);
									e.printStackTrace();
								}
							%>
						</select><%}else
						{%><input type='hidden' name='bed_class' id='bed_class' value="<%=bed_class_code%>"><input type='text' name='bed_class_desc' id='bed_class_desc' value="<%=bed_class_desc%>" maxlength=15 size=15 readonly><%}%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
				<td  class='label' align='right'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<%if(eff_status.equals("E"))
					{
					StringBuffer sql_bed_type = new StringBuffer();
					sql_bed_type.append("select short_desc, bed_type_code from ip_bed_type where bed_class_code='"+bed_class_code+"' and eff_status='E' order by short_desc");
					%><select name="bed_type" id="bed_type">
								<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
					<%
				if (fn_val.equals("modify"))
					{
						stmt1 = con.createStatement();
						rs1	  = stmt1.executeQuery(sql_bed_type.toString());
						
						String p_bed_type_code="";
						String p_bed_type_desc="";

						while (rs1.next())
						{
							p_bed_type_code = rs1.getString("bed_type_code");
							p_bed_type_desc = rs1.getString("short_desc");

							if (p_bed_type_code.equals(bed_type))
							{
				%>
							<OPTION VALUE="<%=p_bed_type_code%>" selected><%= p_bed_type_desc %>
				<%		
							}
							else
							{
				%>
							<OPTION VALUE="<%=p_bed_type_code%>" ><%= p_bed_type_desc %>
				<%			}
						}
					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					}
					%>

							</select>
						<%}
							else
							{%><input type='hidden' name='bed_type' id='bed_type' value="<%=bed_type%>"><input type='text' name='bed_type_desc' id='bed_type_desc' value="<%=bed_type_desc%>" maxlength=15 size=15 readonly>
								<%
							}%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>

			<tr><td colspan='4'>&nbsp</td></tr>

			<tr>
				<td  class='label' align='right'><fmt:message key="Common.GenderSpecificInd.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<%if(eff_status.equals("E"))
				{													
				%><select name="gender_specific_ind" id="gender_specific_ind" onchange="assign_gender_specific_ind(this)" <%=disableVal%> <%if(!mainBedNo.equals("")){%>disabled<%}%>>
				<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
				<% String sel="";
				if(gender_spec_ind.equals("M"))	sel="selected";%>
				<option value='M' <%=sel%>><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
				<%sel="";
				if(gender_spec_ind.equals("F"))	sel="selected";%>
				<option value='F' <%=sel%>><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				<%sel="";
				if(gender_spec_ind.equals("U"))	sel="selected";%>
				<option value='U' <%=sel%>><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
				<%
					String sel1=""; 
					if (fn_val.equals("modify"))
					{	
						if(gender_spec_ind.equals("") && !Gender.equals(""))	
						{
							sel1="selected";%>							<option value='' <%=sel1%>><%=Gender%></option>
					<%	}
					}%>
					</select>
				<%}
					else
					{
						String gend="";
						if(gender_spec_ind.equals("U"))
								gend="Unknown";
						if(gender_spec_ind.equals("M"))
								gend="Male";
						if(gender_spec_ind.equals("F"))
								gend="Female";
						%><input type='text' name='gender_specific_ind' id='gender_specific_ind' value="<%=gend%>" maxlength=15 size=10 readonly>
						<%
					}
					%>
					<input type='hidden' name='gender_specific_ind_code' id='gender_specific_ind_code' value="<%=gender_spec_ind%>";>
				</td>
				<td  class='label' align='right'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
				<td>&nbsp;&nbsp;<%

				if(eff_status.equals("E"))
				{
				StringBuffer sql_speciality = new StringBuffer();
				sql_speciality.append("select specialty_code, specialty_short_desc from ip_nurs_unit_for_specialty_vw where facility_id='"+facility_id+"' and nursing_unit_code='"+nursing_unit_code+"' order by specialty_short_desc");

				%><select name="speciality" id="speciality">
						<option value=''>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
				<%
					if (fn_val.equals("modify"))
					{

						stmt1 = con.createStatement();
						rs1	  = stmt1.executeQuery(sql_speciality.toString());
						String p_specialty_code="";
						String p_specialty_desc="";

						while (rs1.next())
						{
							p_specialty_code = rs1.getString("specialty_code");
								if(p_specialty_code == null) p_specialty_code = "";
							p_specialty_desc = rs1.getString("specialty_short_desc");
								if(p_specialty_desc == null) p_specialty_desc = "";

							if (p_specialty_code.equals(speciality_code))
							{
				%>
							<OPTION VALUE="<%=p_specialty_code%>" selected><%= p_specialty_desc %>
				<%		
							}
							else
							{
				%>
							<OPTION VALUE="<%=p_specialty_code%>" ><%= p_specialty_desc %>
				<%			}
						}
					if(rs1!=null) rs1.close();
					if(stmt1!=null) stmt1.close();
					}
				%>
				</select>
				<%}
				else
				{
					%><input type=hidden name='speciality' id='speciality' value="<%=speciality_code%>"><input type=text name='speciality_desc' id='speciality_desc' value="<%=speciality_code_desc%>" maxlength=15 size=15 readonly >
					<%
				}%>
				</td>
			</tr>

			<tr><td colspan='4'>&nbsp</td></tr>

			<tr><td colspan=4 class='white'>&nbsp</td></tr>
			<tr><td colspan=4 class='white'>&nbsp</td></tr>
				
				</table>
			</td>
		</tr>
	</table>
	<input type='hidden' name='function_name' id='function_name' value="<%=fn_val%>">
	<input type='hidden' name='occupying_patient_id' id='occupying_patient_id' value="<%=occupying_patient_id%>">
	<input type='hidden'  name='inpatient' id='inpatient' value='Y'>
	<input type='hidden'  name='emergency' id='emergency' value='Y'>
	<input type='hidden'  name='day_care' id='day_care' value='Y'>
	<input type='hidden'  name='new_born' id='new_born' value='Y'>
	<input type='hidden'  name='lodger' id='lodger' value='Y'>
	<input type='hidden'  name='hdd_room' id='hdd_room' value=''>
	<input type='hidden'  name='hdd_bed_class' id='hdd_bed_class' value=''>
	<input type='hidden'  name='hdd_bed_type' id='hdd_bed_type' value=''>
	<input type='hidden'  name='hdd_bed_type_desc' id='hdd_bed_type_desc' value=''>
	<input type='hidden'  name='hdd_speciality_code' id='hdd_speciality_code' value=''>
	<input type='hidden'  name='hdd_speciality_desc' id='hdd_speciality_desc' value=''>
	<input type="hidden" name="hddBedVal" id="hddBedVal" value=<%=DisVal%> >
	<input type="hidden" name="sStyle" id="sStyle" value=<%=sStyle%> >
<input type="hidden" name="status" id="status" value="">
				</form>
<script>
			
		if("<%=fn_val%>"=="modify" && "<%=eff_status%>"=="E")
		{
			document.forms[0].room.focus();
		}

if("<%=fn_val%>"=="modify" )
{
	if(document.forms[0].hddBedVal.value != "")
	{
		/*Thursday, December 02, 2010, PMG20089-CRF-0864 [IN:025309]*/
		//if(document.forms[0].customer_id.value =='EK'){  //this line commented CRF [AMRI-CRF-0220]*/ 
		
			document.forms[0].room.disabled = true;
			document.forms[0].bed_no.disabled = true;
			//document.forms[0].bed_no.readonly = true;
			if(document.forms[0].hddBedVal.value == 'TransactionExists')
				document.forms[0].eff_status.disabled = false;
			else
				document.forms[0].eff_status.disabled = true;
			document.forms[0].bed_class.disabled = true;
			document.forms[0].bed_type.disabled = true;
			document.forms[0].gender_specific_ind.disabled = true;
			document.forms[0].speciality.disabled = true;
			document.forms[0].main_bed_no.disabled = true;
			document.forms[0].CENSUS_BED.disabled = true;//Added by Mano GHL-CRF-418
			
			if(document.forms[0].hddBedVal.value == 'bedReserved' && document.forms[0].hddBedVal.value != 'TransactionExists')
			{
				var message = getMessage("BED_RESERVED_BY_PATIENT","IP")
					message = message.replace("$",getLabel("Common.Modify.label","Common"));
				alert(message);
			}
			else if(document.forms[0].hddBedVal.value != 'bedReserved' && document.forms[0].hddBedVal.value != 'TransactionExists')
				alert(getMessage("BED_OCCUPIED_BY_PATIENT","IP"));	
			
		/*Below else condtion commeneted for this CRF [AMRI-CRF-0220]*/ 		
		/*}else
		{
				
				document.forms[0].room.disabled = true;
				document.forms[0].bed_no.disabled = true;
				//document.forms[0].bed_no.readonly = true;
				document.forms[0].eff_status.disabled = true;
				document.forms[0].bed_class.disabled = true;
				document.forms[0].bed_type.disabled = true;
				document.forms[0].gender_specific_ind.disabled = true;
				document.forms[0].speciality.disabled = true;
				document.forms[0].main_bed_no.disabled = true;
				if(document.forms[0].hddBedVal.value == 'TransactionExists')
				alert(getMessage("BEDS_USED","IP"));
				else
				alert(getMessage("BED_OCCUPIED_BY_PATIENT","IP"));
		}*/
	}
}

if("<%=fn_val%>"=="modify")
{
	if(document.forms[0].main_bed_no.value != '')
	{
		document.forms[0].room.disabled = true;
		document.forms[0].bed_class.disabled = true;
		document.forms[0].bed_type.disabled = true;
		document.forms[0].speciality.disabled = true;
	}
}

</script>

<%
		if (rs != null)			rs.close();
		if (stmt != null)		stmt.close();
		if (GenderRS1 != null)	GenderRS1.close();
		if (Genderstmt1 != null)Genderstmt1.close();
		if (rs1 != null)		rs1.close();
		if (stmt1 != null)		stmt1.close();
		if (BedRs != null)		BedRs.close();
		if (BedStmt != null)	BedStmt.close();

	}catch(Exception e) {
		//out.println(e.toString());
		e.printStackTrace();
		}
	finally
	{
		if(con != null )ConnectionManager.returnConnection(con,request);
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

