<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "IP" ;
	String p_report_id		= "IPBADTYR" ;
	String CurrentDate = "";
	String p_facility_id		= (String) session.getValue( "facility_id" ) ;
	String p_user_name	= (String) session.getValue( "login_user" ) ;
	String p_resp_id			=	(String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	Connection	con				=	null;
	Statement	stmt			=	null;
	Statement	stmt1			=	null;
	ResultSet	rset			=	null;
	ResultSet	rset1			=	null;

%>

<html>	
<HEAD>

<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eIP/js/Rep2MasterList.js' language='javascript'></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src="../../eCommon/js/CommonCalendar.js" language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function validate_date(obj) 
		{
			var from = convertDate(obj.value,'YY',localeName,'en');
			var to   = convertDate(document.forms[0].CurrentDate.value,'YY',localeName,'en');
			
				if(to < from) 
				{
					var invaldt = getMessage("CAN_NOT_GREAT_CURR_YR","IP") ;
					var stat_year=getLabel("Common.statistics.label","Common")+" "+getLabel("Common.year.label","Common");
					invaldt = invaldt.replace('$',stat_year);
					alert(invaldt);
					obj.focus();
					obj.select();
				}
			
		}

	async function searchCode(obj,target)
	{
			var retVal = 	new String();			
			var locale= "<%=locale%>"
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var allfacilityid	=	document.Rep2YrlyAdmnTypeForm.p_all_facility_id.value;
			var from_pract_type = document.Rep2YrlyAdmnTypeForm.fm_pract_type.value;
			var to_pract_type = document.Rep2YrlyAdmnTypeForm.to_pract_type.value;

										
			if(obj.name=="nursing_unit_code_fm" || obj.name=="nursing_unit_code_to")
			{
				tit=getLabel('Common.nursingUnit.label','common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`"+allfacilityid+"` ";

				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`"+allfacilityid+"` and language_id=`"+locale+"`";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			
			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','common');
				//sql="select speciality_code, short_desc from am_speciality ";

				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`";
				search_code="speciality_code";
				search_desc= "short_desc";
			}
			
			if(obj.name=="practitioner_id_fm")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql="select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where  operating_facility_id=`"+allfacilityid+"` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) "; 

				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";

				sql  = "SELECT a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`)      Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where  a.PRACT_TYPE=nvl(`"+from_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id";
			
				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="practitioner_id_to")
			{
				var tit=getLabel('Common.practitioner.label','common')
				//sql="select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where  operating_facility_id=`"+allfacilityid+"` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) "; 

				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";

				sql  = "SELECT a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`)      Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where  a.PRACT_TYPE=nvl(`"+to_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id";

				
				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
			retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?SQL="+sql+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+encodeURIComponent(tit),arguments,features);

			if (!(retVal == null))
			{
				target.value=retVal;
			}
			else
				target.focus();
	}


	function chkVal(obj)
	{

			if ( obj.value == "All" )
			{	if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].p_fm_nursing_unit.disabled = true
					document.forms[0].p_to_nursing_unit.disabled = true
					document.forms[0].nursing_unit_desc.disabled = true
					document.forms[0].nursing_unit.disabled = true
				}else{
					document.forms[0].p_fm_nursing_unit.disabled = true
					document.forms[0].p_to_nursing_unit.disabled = true
					document.forms[0].nursing_unit_code_fm.disabled = true
					document.forms[0].nursing_unit_code_to.disabled = true
				}
					document.forms[0].p_fm_practitioner_id.disabled = true
					document.forms[0].p_to_practitioner_id.disabled = true
					document.forms[0].practitioner_id_fm.disabled = true
					document.forms[0].practitioner_id_to.disabled = true

					document.forms[0].fm_pract_type.disabled = true
					document.forms[0].to_pract_type.disabled = true
			}
			else
			{	if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].p_fm_nursing_unit.disabled = false
					document.forms[0].p_to_nursing_unit.disabled = false
					document.forms[0].nursing_unit_desc.disabled = false
					document.forms[0].nursing_unit.disabled = false
				}else{
					document.forms[0].p_fm_nursing_unit.disabled = false
					document.forms[0].p_to_nursing_unit.disabled = false
					document.forms[0].nursing_unit_code_fm.disabled = false
					document.forms[0].nursing_unit_code_to.disabled = false
				}	
					document.forms[0].p_fm_practitioner_id.disabled = false
					document.forms[0].p_to_practitioner_id.disabled = false
					document.forms[0].practitioner_id_fm.disabled = false
					document.forms[0].practitioner_id_to.disabled = false

					document.forms[0].fm_pract_type.disabled = false
					document.forms[0].to_pract_type.disabled = false
			}
					if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.forms[0].nursing_unit_desc.value = ""}
					document.forms[0].p_fm_nursing_unit.value = ""
					document.forms[0].p_to_nursing_unit.value = ""
					document.forms[0].p_fm_practitioner_id.value = ""
					document.forms[0].p_to_practitioner_id.value = ""
					document.forms[0].fm_pract_type.value = ""
					document.forms[0].to_pract_type.value = ""
	}



	/*function dateVal( obj )
	{
		if(obj.value !="")
		{
			if(!doDateTimeChk(obj))
			{
				obj.focus()
				alert( parent.parent.parent.frames[0].getMessage("INVALID_DATE_TIME","SM") )
			}
		}
	}*/

</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2YrlyAdmnTypeForm" id="Rep2YrlyAdmnTypeForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	con		=	ConnectionManager.getConnection(request);
	String isSpltyNurUnitToEnableYNAppl="";
	isSpltyNurUnitToEnableYNAppl = eIP.IPCommonBean.getSpltyNurUnitToEnableYN(con);//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
    stmt1 = con.createStatement(); 
    String sql = "" ;
	//sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE Where EFF_STATUS = 'E' order by 2" ;

	sql = "Select PRACT_TYPE, DESC_USERDEF From AM_PRACT_TYPE_lang_vw Where EFF_STATUS = 'E' and language_id='"+locale+"' order by 2" ;
    rset1 = stmt1.executeQuery(sql);
	StringBuffer StrVal = new StringBuffer();

    try
    {
		if(rset1 != null)
		{
			while(rset1.next())
			{
				StrVal.append(" <option value='"+rset1.getString(1)+"'>"+rset1.getString(2)+"</option> ");
			}
		}
	 }
	 catch(Exception e){out.println(e);}
%>

<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
	<tr>

		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' >

				<tr>
					<td  class="label" > <fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
					<td colspan ="4"> 
							<select name='p_all_facility_id' id='p_all_facility_id'  onchange = "chkVal(this)">
						<%
							try
							{
							stmt=con.createStatement();
							String fid;
							String fname;
							//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	
							
							String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

							String sql1 = "select 'All' facility_id, '"+all_access+"' facility_name,to_char(sysdate,'yyyy') CurrentDate from dual union select u.facility_id facility_id, p.facility_name facility_name,to_char(sysdate,'yyyy')CurrentDate from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";
							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								CurrentDate=rset.getString("CurrentDate");
								CurrentDate = DateUtils.convertDate(CurrentDate,"YY","en",locale);
								if(fid.equals("All"))
								out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
								else
								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
								if(rset != null)    rset.close();
								if(stmt != null)    stmt.close();
								if(rset1 != null)    rset1.close();
								if(stmt1 != null)    stmt1.close();

							}catch(Exception e)
							{
								out.println(e);
							}
							finally 
							{ 
								ConnectionManager.returnConnection(con,request);
							}

						%>	
						</select>
					</td>
				</tr>


				<tr>
					<td align="center" width="35%">&nbsp;</td>
					<td class="querydata" width="20%" style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
					<td  width='40%' class="label"><fmt:message key="eIP.AdmissionYear.label" bundle="${ip_labels}"/> &nbsp;</td>
					<td class="fields" width='40%'  >
						<input type=text  name='p_fm_admission_date' id='p_fm_admission_date' size="4" maxlength="4" align="center" onBlur='validDateObj(this,"YY",localeName);validate_date(this);' onKeyPress='return(ChkNumberInput(this,event,2))' ><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_fm_admission_date','y',null);"/> 
					</td>
					<td class="fields" width='40%'> 
						<input type=text  name='p_to_admission_date' id='p_to_admission_date' size="4" maxlength="4" align="center" onBlur='validDateObj(this,"YY",localeName);validate_date(this);' onKeyPress='return(ChkNumberInput(this,event,2))'><img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('p_to_admission_date','y',null);"/>  
					</td>
				</tr>

				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>
				<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonNursingUnitLookup.jsp">
					<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
					<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
					</jsp:include>
					</tr>
					<tr>
					<td class="label">&nbsp;</td>
					<td class="label">&nbsp;</td>
					</tr>
					<tr>
					<jsp:include page="CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_specialty_code"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_specialty_code"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width='20%'  >
						<input type=text  disabled name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_fm' id='nursing_unit_code_fm' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
					</td>
					<td class="fields" width='40%'> 
						<input type=text  disabled name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_to' id='nursing_unit_code_to' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
					</td>
				</tr>
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>

				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> <fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width='20%'  >
						<input type=text  name='p_fm_specialty_code' id='p_fm_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_specialty_code)'>
					</td>
					<td class="fields" width='40%'> 
						<input type=text  name='p_to_specialty_code' id='p_to_specialty_code' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_specialty_code)'>
					</td>
				</tr><%}%>			

				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>
                <tr>
                    <td  width='30%' class="label" ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/> &nbsp;</td>
                    <td class="fields" width='30%'><select name="fm_pract_type" id="fm_pract_type" disabled>
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                    <td class="fields" width='40%'><select name="to_pract_type" id="to_pract_type" disabled>
						<option value="">---&nbsp; <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>
						<%=StrVal.toString()%>
						</select>
					</td>
                </tr>
				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>

				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width='20%'  >
						<input type=text disabled  name='p_fm_practitioner_id' id='p_fm_practitioner_id' size="15" maxlength="15" align="center"><input type='button' disabled name='practitioner_id_fm' id='practitioner_id_fm' value='?' class='button' onclick='searchCode(this, p_fm_practitioner_id)'>
					</td>
					<td class="fields" width='40%'> 
						<input type=text  disabled name='p_to_practitioner_id' id='p_to_practitioner_id' size="15" maxlength="15" align="center"><input type='button' disabled name='practitioner_id_to' id='practitioner_id_to' value='?' class='button' onclick='searchCode(this, p_to_practitioner_id)'>
					</td>
				</tr>

				<tr>
					<td class="label">&nbsp;</td>
					<Td class="label">&nbsp;</td>
				</tr>

		</table>
	</td>
</tr>
</table>

	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"		value="<%= p_user_name %>">
	<input type="hidden" name="p_resp_id" id="p_resp_id"		value="<%= p_resp_id %>">
	<input type="hidden" name="CurrentDate" id="CurrentDate"		value="<%= CurrentDate %>">
	<input type="hidden" name="isSpltyNurUnitToEnableYNAppl" id="isSpltyNurUnitToEnableYNAppl"  value="<%= isSpltyNurUnitToEnableYNAppl %>">
	<%if(localeName.equals("en"))
	{%>
	<!-- <INPUT TYPE="hidden" name="p_passing_local_date" id="p_passing_local_date" value="N"> -->
	<%}
	else if(localeName.equals("th"))
	{%>
	<INPUT TYPE="hidden" name="P_passing_local_date" id="P_passing_local_date" value="Y">
	<%}%>
		

</form>
<script>
	document.forms[0].p_all_facility_id.focus()
	if(document.forms[0].isSpltyNurUnitToEnableYNAppl.value=="N"){
	document.forms[0].nursing_unit_desc.disabled = true
	document.forms[0].nursing_unit.disabled = true
	document.forms[0].p_fm_nursing_unit.disabled = true
	document.forms[0].p_to_nursing_unit.disabled = true}
</script>
</BODY>
</HTML>

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

