<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eIP/js/PseudoBedCreation.js' language='javascript'></script>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
		<%
			request.setCharacterEncoding("UTF-8");
			//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
			Connection con = null;
			Statement stmt = null;
			ResultSet rset = null;
			ResultSet BedRs			= null;
			Statement BedStmt		= null;
//			Statement new_born_stmt = null;
//			ResultSet new_born_rs	= null;

			String frommodal = checkForNull(request.getParameter("from_modal"));
			String facilityId = (String)session.getValue("facility_id");
			String fn_val="insert";
			String nursing_unit_code= checkForNull(request.getParameter("nursing_unit_code"));
			String nursing_unit_desc= checkForNull(request.getParameter("nursing_unit_desc"));
			String bed_no="";
			String room_no="";
			String eff_status="E";
			String bed_class_code="";
			String bed_type="";
			String gender_spec_ind="";
			String speciality_code="";
//			String inpatient ="";
//			String emergency="";
//			String day_care="";
//			String new_born="";
//			String lodger="";
			String bed_class_desc="";
			String speciality_code_desc="";
			String bed_type_desc="";
			String occ_patient_id="";
//			String new_born_yn = "";
			String Transaction_YN= "";

			try
			{
				con = ConnectionManager.getConnection(request);	

				if(nursing_unit_code!=null && !nursing_unit_code.equals("") && !frommodal.equals("Y")) 
				{
					fn_val="modify";
					
					bed_no=checkForNull(request.getParameter("bed_no"));
					StringBuffer modify_sql = new StringBuffer();
					modify_sql.append("select * from ip_nursing_unit_bed_vw where nursing_unit_code='"+nursing_unit_code+"' and bed_no='"+bed_no+"'  and facility_id='"+facilityId+"'");
					stmt=con.createStatement();
					rset=stmt.executeQuery(modify_sql.toString());

					if(rset!=null)
					{
						if(rset.next())
						{
							nursing_unit_desc=rset.getString("NURSING_UNIT_SHORT_DESC")	;
							bed_no=rset.getString("bed_no")	;
							if(bed_no==null)bed_no="";

							room_no=rset.getString("room_no");

							eff_status=rset.getString("eff_status")	;
							out.print("<script>eff_status='"+eff_status+"'</script>");

							bed_class_code=rset.getString("bed_class_code")	;
							bed_class_desc=rset.getString("BED_CLASS_SHORT_DESC")	;

							bed_type=rset.getString("bed_type_code")	;
							bed_type_desc=rset.getString("BED_TYPE_SHORT_DESC")	;

							gender_spec_ind=rset.getString("sex_spec_ind");

							if(gender_spec_ind==null)
								gender_spec_ind="";

							speciality_code=rset.getString("specialty_code")	;
							if(speciality_code==null)
								speciality_code="";

							speciality_code_desc=rset.getString("SPECAILTY_SHORT_DESC")	;
							if(speciality_code_desc==null)
								speciality_code_desc="";

							occ_patient_id = rset.getString("occupying_patient_id");
							if(occ_patient_id != null)
							{
							out.println("<script>alert(getMessage('BED_OCCUPIED_BY_PATIENT','IP'))</script>");
							}
//							inpatient =rset.getString("inpatient_pat_class_appl_yn")	;
//							emergency=rset.getString("emergency_pat_class_appl_yn")	;
//							day_care=rset.getString("daycare_pat_class_appl_yn")	;
//							new_born=rset.getString("newborn_pat_class_appl_yn")	;
//							lodger=rset.getString("lodger_pat_class_appl_yn")	;
						}
					}
				}

	/// Added by Sridhar on Apr 7 2005..
	/// This chunk of code will chk if the PseudoBed was used in any Previous transaction ...
		if(nursing_unit_code!=null && fn_val.equals("modify")) 
		{
			if(occ_patient_id == null)
			{	
				String BedSql = " select count(1) from IP_ADT_TRN where to_nursing_unit ='"+nursing_unit_code+"' and TO_BED_NO='"+bed_no+"'and facility_id='"+facilityId+"'";
				BedStmt=con.createStatement();
				BedRs = BedStmt.executeQuery(BedSql);
				if(BedRs != null)
				{
					while(BedRs.next())
					{
						int count = BedRs.getInt(1);
						if(count > 0)
							Transaction_YN = "TransactionExists";
						else
							Transaction_YN = "";
					}
				}
			}
		}	
		if(BedRs != null) BedRs.close();
		if(BedStmt != null) BedStmt.close();

/// Added by Sridhar on 16 SEP 2004
/// If New_Born indicator is 'Y' in ip_nursing_unit table for that nursing_unit then, Main Bed No can be entered...else disabled...MIAN BED REMOVED 
/*
	if(fn_val.equals("modify"))
	{
		StringBuffer sql_New_Born = new StringBuffer();
		sql_New_Born.append("select ALLOW_NEW_BORN_REGN_YN from IP_NURSING_UNIT where NURSING_UNIT_CODE = '"+nursing_unit_code+"' and facility_id='"+facilityId+"' ");
		try
		{
			new_born_stmt	= con.createStatement();
			new_born_rs		= new_born_stmt.executeQuery(sql_New_Born.toString());

			if(new_born_rs!=null)
			{
				while(new_born_rs.next())
				{
//					new_born_yn = new_born_rs.getString("ALLOW_NEW_BORN_REGN_YN");
				}
			}

		}catch(Exception e)
		{
			//out.print("New Born : "+e);
			e.printStackTrace();
		}
		finally
		{
			if(new_born_stmt!=null)	new_born_stmt.close();
			if(new_born_rs!=null)		new_born_rs.close();
		}
	}	
*/

%>
<script>

/* CODED ON 7 FEB 2004 by SRIDHAR */
/* COMMON LOOKUP FOR Nursing Unit START */
async function Lookup(target_id,target)
{
	var facility_id = "<%=facilityId%>";
	var title="";
	
	var argumentArray=new Array(8);
	
	if(target_id.name == "nursing_unit")
	{
		title=getLabel('Common.nursingUnit.label','common');

		argumentArray[0]="select NURSING_UNIT_CODE code, SHORT_DESC description from IP_NURSING_UNIT where EFF_STATUS like ? and ALLOW_PSEUDO_BED_YN like ? and facility_id='"+facility_id+"' and  upper(NURSING_UNIT_CODE) like upper(nvl(?,NURSING_UNIT_CODE)) and upper(SHORT_DESC) like upper(nvl(?,SHORT_DESC)) ";

		argumentArray[1]=new Array("EFF_STATUS","ALLOW_PSEUDO_BED_YN");
		argumentArray[2]=new Array("E","Y");
		argumentArray[3]=new Array(STRING,STRING);
		argumentArray[4]="3,4";
		argumentArray[5]=target.value;
		argumentArray[6]=CODE_DESC_LINK;
		argumentArray[7]=CODE_DESC;
}
			
	var retVal=await CommonLookup(title,argumentArray);
			
	if(retVal ==null || retVal=="" || !retVal)
	{
		target.value	= "";
		target_id.value	= "";
	}
	else
	{
		var ret1=unescape(retVal);
		arr=ret1.split(",");
		target_id.value	= arr[0];
		target.value	= arr[1];
		document.forms[0].nurs_desc_hid.value = document.forms[0].nursing_unit_desc.value;
		popDynamicValues(document.forms[0].nursing_unit)
	}
}

</script>
  </head>
	<body OnMouseDown='CodeArrest()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name='Nursing_Unit_Bed' id='Nursing_Unit_Bed' method='post' action='../../servlet/eIP.PseudoBedCreationServlet' target='messageFrame'>
			<table cellspacing=0 cellpadding=0 align='center' width='95%' border='0'>
				<tr>
					<td height='100%' width='100%' align='center' class='white'>
						<table cellspacing=0 cellpadding=0 align='center' width='100%' border='0'>

							<tr><td colspan='4'>&nbsp;</td></tr>

							<tr>
								<td  class='label' ><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td colspan='3'>
								<%if(fn_val.equals("insert") && !frommodal.equals("Y"))
									{%>
								&nbsp;<input type="text" name="nursing_unit_desc" id="nursing_unit_desc" size="15" maxlength="15" onblur="beforeGetNursingUnit(nursing_unit,nursing_unit_desc)"><input type="button" class="button" name="search_nur_unit" id="search_nur_unit" value="?" onclick="checkTxtVal(nursing_unit,nursing_unit_desc)"><input type="hidden" name="nursing_unit" id="nursing_unit" size="4" maxlength="4" ><img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
								<input type=hidden name="nurs_desc_hid" id="nurs_desc_hid" value=''>
								<%}
									else
									{%>
										&nbsp;<input type='text' name='nursing_unit1' id='nursing_unit1' value="<%=nursing_unit_desc%>" readonly>
										<input type='hidden' name='nursing_unit' id='nursing_unit' value="<%=nursing_unit_code%>">
										<img src='../../eCommon/images/mandatory.gif'align='center'></img>
								<%}%>
								</td>
							</tr>

							<tr><td colspan='4'>&nbsp</td></tr>

							<tr>
								<td  class='label' ><fmt:message key="Common.roomcubicleno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td>
								<%
									if(eff_status.equals("E") && fn_val.equals("insert"))
									{
								%>
										&nbsp;<select name='room' id='room'>
											<option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</option></select><%}else{%>&nbsp;<input type='text' name='room' id='room' value="<%=room_no%>" maxlength=8 size=8 readonly><%}%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
								</td>
								<td  class='label'><fmt:message key="Common.bedno.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td>
									<%
										String readOnly="";
										if(fn_val.equals("modify"))	readOnly="readonly";%>
									&nbsp;<input type='text' name='bed_no' id='bed_no' size='8' maxlength='8' value="<%=bed_no%>" <%=readOnly%> onBlur='ChangeUpperCase(this)' onKeyPress="return CheckForSpecChars(event)"><img src='../../eCommon/images/mandatory.gif'align='center'></img>
								</td>
							</tr>
							<tr><td colspan='4'>&nbsp</td></tr>
						
							<tr>
								<td  class='label' 
								><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<%
									String chk_val="checked";
									if(eff_status.equals("D"))
										chk_val="";
								%>
								<!--<td colspan='1'><input type='checkbox' onClick='checkStatus(this)' name='eff_status' id='eff_status' <% if(occ_patient_id != null) {%> <%}%> value='E'  <%=chk_val%>></td>--> <!--Commented by Ashwini on 23-05-2018 for ML-MMOH-CRF-1074-->
								<td colspan='1'><input type='checkbox' name='eff_status' id='eff_status' <% if(occ_patient_id != null) {%> <%}%> value='E'  <%=chk_val%>></td>
								<td colspan='2'>&nbsp;</td>
							</tr>
							<tr><th colspan='4' align='left'><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/></th></tr>
							<tr><td colspan='4'>&nbsp</td></tr>
							<tr>
								<td  class='label' ><fmt:message key="Common.BedClass.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td>
									<%
										if(eff_status.equals("E") && fn_val.equals("insert"))
										{
									%>
											&nbsp;<select name="bed_class" id="bed_class" onchange='popDynamicValues(this)'>
											<option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</option>
											<%
											StringBuffer bed_class_sql = new StringBuffer();
												bed_class_sql.append("select short_desc, bed_class_code from ip_bed_class ");
														  bed_class_sql.append("where eff_status='E' order by short_desc");
												try
												{
													stmt	 =con.createStatement();
													rset		 =stmt.executeQuery(bed_class_sql.toString());
													String sel="";
													while(rset.next())
													{
														if(rset.getString(2).equals(bed_class_code))
														{
															sel="selected";
														}
														out.print("<option value='"+rset.getString(2)+"' "+sel+">"+rset.getString(1)+"</option>");
														sel="";
													}
													rset.close();
													stmt.close();
												}
												catch(Exception e)
												{
													//out.print(e);
													e.printStackTrace();
												}
											%></select><%}else{%><input type='hidden' name='bed_class' id='bed_class' value="<%=bed_class_code%>">&nbsp;<input type='text' name='bed_class_desc' id='bed_class_desc' value="<%=bed_class_desc%>" maxlength=15 size=15 readonly><%}%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
								</td>
								<td  class='label' ><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td>
									<%if(eff_status.equals("E") && fn_val.equals("insert"))
										{%>							
											&nbsp;<select name="bed_type" id="bed_type">
												<option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</option>
											</select><%}else{%><input type='hidden' name='bed_type' id='bed_type' value="<%=bed_type%>">&nbsp;<input type='text' name='bed_type_desc' id='bed_type_desc' value="<%=bed_type_desc%>" maxlength=15 size=15 readonly><%}%><img src='../../eCommon/images/mandatory.gif'align='center'></img>
								</td>
							</tr>

							<tr><td colspan='4'>&nbsp</td></tr>

							<tr>
								<td  class='label' ><fmt:message key="Common.GenderSpecificInd.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td >
								<%	
							
							if(eff_status.equals("E")&&fn_val.equals("insert"))
									{	%>
										&nbsp;<select name="gender_specific_ind" id="gender_specific_ind" onchange="assign_gender_specific_ind(this)">
										<option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</option>
										<%
											String sel="";
										if(gender_spec_ind.equals("M"))	sel="selected";%>
										<option value='M' <%=sel%>><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
										<%sel="";
										if(gender_spec_ind.equals("F"))	sel="selected";%>
										<option value='F' <%=sel%>><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
										<%sel="";
										if(gender_spec_ind.equals("U"))	sel="selected";%>
										<option value='U' <%=sel%>><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
									</select><%}else
									{
										String gend="";
										if(gender_spec_ind.equals("U"))
												gend="Unknown";
										if(gender_spec_ind.equals("M"))
												gend="Male";
										if(gender_spec_ind.equals("F"))
												gend="Female";
										%>
											&nbsp;<input type='text' name='gender_specific_ind' id='gender_specific_ind' value="<%=gend%>" maxlength=15 size=15 readonly>
										<%
									}
									%>
									<input type='hidden' name='gender_specific_ind_code' id='gender_specific_ind_code' value="<%=gender_spec_ind%>";>
								</td>
								<td  class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
								<td>
								<%if(eff_status.equals("E")&&fn_val.equals("insert"))
								{%>
									&nbsp;<select name="speciality" id="speciality">
										<option value=''>&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;</option>
									</select>
								<%}
								else
								{
									%>
											<input type=hidden name='speciality' id='speciality' value="<%=speciality_code%>">
											<input type=text name='speciality_desc' id='speciality_desc' value="<%=speciality_code_desc%>" maxlength=15 size=15 readonly >
									<%
								}%>
								</td>
							</tr>

							<tr><td colspan='4'>&nbsp</td></tr>
						</table>
					</td>
				</tr>
			</table>
			<%if(occ_patient_id == null)occ_patient_id="";%>
			<input type='hidden' name='function_name' id='function_name' value="<%=fn_val%>">
			<input type='hidden' name='pseudo_bed_yn' id='pseudo_bed_yn' value='Y'>
			<input type='hidden' name='from_modal' id='from_modal' value="<%=frommodal%>">
			<input type='hidden' name='occed_patient_id' id='occed_patient_id' value="<%=occ_patient_id%>">
			<input type='hidden' name='Transaction_YN' id='Transaction_YN' value="<%=Transaction_YN%>">
			<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>">
		</form>
	<%
		if(frommodal.equals("Y"))
		{	
				out.println("<script>getRoomValues('"+nursing_unit_code+"')</script>");
		}
			
		if(stmt != null) stmt.close();
		if(rset != null) rset.close();

		}catch(Exception e){
			//out.println(e.toString());
			e.printStackTrace();
			}		
			
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
	%>

<script>
	if(document.forms[0].occed_patient_id.value != '' && document.forms[0].function_name.value=='modify')
	{
		document.forms[0].eff_status.disabled = true;
	}
</script>

	</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

