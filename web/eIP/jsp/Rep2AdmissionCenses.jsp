<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
 <% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		=	"IP" ;
	String p_report_id		=	"IPBADSTA" ;
	String p_facility_id	=	(String) session.getValue( "facility_id" ) ;
	String p_user_name		=	(String) session.getValue( "login_user" ) ;
	String p_resp_id		=	(String) session.getValue("responsibility_id");
	String locale = (String)session.getAttribute("LOCALE");

	Connection	con			=	null;
	Statement	stmt		=	null;
	ResultSet	rset		=	null;
	Statement	stmt1		=	null;
	ResultSet	rset1		=	null;
%>

<html>	
<HEAD>
<TITLE></TITLE>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

//var val_id = new Array("to_nursing_unit_short_desc","to_practitioner_long_name","to_specialty_short_desc")
	var val_id = new Array("c.short_desc","d.practitioner_name","e.short_desc")
	var val	  = new Array(getLabel('Common.nursingUnit.label','Common'),getLabel('Common.practitioner.label','Common'),getLabel('Common.speciality.label','Common')) ;

	function chkVal(obj)
	{
		if ( obj.name == "p_col1" )
		{
			if(obj.value == "null" )
			{
				document.Rep2AdmissionCensesForm.p_col3.options(0).selected = true
				document.Rep2AdmissionCensesForm.p_col2.options(0).selected = true

				document.Rep2AdmissionCensesForm.p_col3.disabled = true
				document.Rep2AdmissionCensesForm.p_col2.disabled = true

			}
			else
			{
				removeitems( document.Rep2AdmissionCensesForm.p_col2 );
				removeitems( document.Rep2AdmissionCensesForm.p_col3 );
				for ( var i=0; i<val_id.length; i++ )
				{
					if ( val_id[i] != obj.value  )
					{
						var element		  = document.createElement("option");
							element.value = val_id[i];
							element.text  =	val[i];

						document.Rep2AdmissionCensesForm.p_col2.add(element)
					}
				}

				document.Rep2AdmissionCensesForm.p_col2.disabled = false ;
				document.Rep2AdmissionCensesForm.p_col3.disabled = true ;
			}
		}
		else
		{
			if( obj.name == "p_col2" )
			{
				if(obj.value == "null")
				{
					removeitems( document.Rep2AdmissionCensesForm.p_col3 ); 
					document.Rep2AdmissionCensesForm.p_col2.options(0).selected = true
					document.Rep2AdmissionCensesForm.p_col3.disabled = true 
				}
				else
				{
					removeitems( document.Rep2AdmissionCensesForm.p_col3 );
					for ( var i=0; i<val_id.length; i++ )
					{
						if ( val_id[i] != obj.value && val_id[i] != document.Rep2AdmissionCensesForm.p_col1.value  )
						{
							var element		  = document.createElement("option");
								element.value = val_id[i];
								element.text  =	val[i];
						document.Rep2AdmissionCensesForm.p_col3.add(element)
						}
					}
					document.Rep2AdmissionCensesForm.p_col3.disabled = false ;

				}
			}
		}

		if ( obj.name == "p_all_facility_id" )
		{
			
			if ( obj.value == "All" )//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
			{	if(document.Rep2AdmissionCensesForm.isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.Rep2AdmissionCensesForm.p_fm_nursing_unit.disabled = true
					document.Rep2AdmissionCensesForm.p_to_nursing_unit.disabled = true
					document.Rep2AdmissionCensesForm.nursing_unit_desc.disabled = true
					document.Rep2AdmissionCensesForm.nursing_unit.disabled = true
				}else{
					document.Rep2AdmissionCensesForm.p_fm_nursing_unit.disabled = true
					document.Rep2AdmissionCensesForm.p_to_nursing_unit.disabled = true
					document.Rep2AdmissionCensesForm.nursing_unit_code_fm.disabled = true
					document.Rep2AdmissionCensesForm.nursing_unit_code_to.disabled = true
				}
					document.Rep2AdmissionCensesForm.p_fm_practitioner.disabled = true
					document.Rep2AdmissionCensesForm.p_to_practitioner.disabled = true
					document.Rep2AdmissionCensesForm.practitioner_id_fm.disabled = true
					document.Rep2AdmissionCensesForm.practitioner_id_to.disabled = true

					document.Rep2AdmissionCensesForm.fm_pract_type.disabled = true
					document.Rep2AdmissionCensesForm.to_pract_type.disabled = true
			}
			else
			{		if(document.Rep2AdmissionCensesForm.isSpltyNurUnitToEnableYNAppl.value=="N"){//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
					document.Rep2AdmissionCensesForm.p_fm_nursing_unit.disabled = false
					document.Rep2AdmissionCensesForm.p_to_nursing_unit.disabled = false
					document.Rep2AdmissionCensesForm.nursing_unit_desc.disabled = false
					document.Rep2AdmissionCensesForm.nursing_unit.disabled = false
					}else{
					document.Rep2AdmissionCensesForm.p_fm_nursing_unit.disabled = false
					document.Rep2AdmissionCensesForm.p_to_nursing_unit.disabled = false
					document.Rep2AdmissionCensesForm.nursing_unit_code_fm.disabled = false
					document.Rep2AdmissionCensesForm.nursing_unit_code_to.disabled = false
					}
					document.Rep2AdmissionCensesForm.p_fm_practitioner.disabled = false
					document.Rep2AdmissionCensesForm.p_to_practitioner.disabled = false
					document.Rep2AdmissionCensesForm.practitioner_id_fm.disabled = false
					document.Rep2AdmissionCensesForm.practitioner_id_to.disabled = false

					document.Rep2AdmissionCensesForm.fm_pract_type.disabled = false
					document.Rep2AdmissionCensesForm.to_pract_type.disabled = false

			}		//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
					if(document.Rep2AdmissionCensesForm.isSpltyNurUnitToEnableYNAppl.value=="N"){
					document.Rep2AdmissionCensesForm.nursing_unit_desc.value = ""}
					
					document.Rep2AdmissionCensesForm.p_fm_nursing_unit.value = ""
					document.Rep2AdmissionCensesForm.p_to_nursing_unit.value = ""
					document.Rep2AdmissionCensesForm.p_fm_practitioner.value = ""
					document.Rep2AdmissionCensesForm.p_to_practitioner.value = ""
					document.Rep2AdmissionCensesForm.fm_pract_type.value = ""
					document.Rep2AdmissionCensesForm.to_pract_type.value = ""
		}

	}

	async function searchCode(obj,target)
	{
			var retVal = 	new String();
			var dialogHeight= "400px" ;
			var dialogWidth	= "700px" ;
			var status = "no";
			var arguments	= "" ;
			var sql="";
			var search_code="";
			var search_desc="";
			var tit="";
			var locale= "<%=locale%>";
				
			var allfacilityid	=	document.Rep2AdmissionCensesForm.p_all_facility_id.value;
			var from_pract_type = Rep2AdmissionCensesForm.fm_pract_type.value;
			var to_pract_type = Rep2AdmissionCensesForm.to_pract_type.value;

			if(obj.name=="practitioner_id_fm")
			{
				var tit=getLabel('Common.practitioner.label','Common')
				//sql="select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where  operating_facility_id=`"+allfacilityid+"`  and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) "; 
				
				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+from_pract_type+"`,PRACT_TYPE) ";

				sql  = "SELECT a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`)      Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where  a.PRACT_TYPE=nvl(`"+from_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id";

				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="practitioner_id_to")
			{
				var tit=getLabel('Common.practitioner.label','Common')
				//sql="select Practitioner_id,Practitioner_name from am_pract_for_facility_vw where  operating_facility_id=`"+allfacilityid+"`  and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) "; 

				//sql  = "select Practitioner_id, AM_GET_DESC.AM_PRACTITIONER(Practitioner_id,`"+locale+"`, `1`) Practitioner_name from am_pract_for_facility where FACILITY_ID=`<%= p_facility_id %>` and PRACT_TYPE=nvl(`"+to_pract_type+"`,PRACT_TYPE) ";

				sql  = "SELECT a.Practitioner_id  Practitioner_id,AM_GET_DESC.AM_PRACTITIONER(a.Practitioner_id,`"+locale+"`, `1`)      Practitioner_name  FROM AM_PRACTITIONER a, AM_PRACT_FOR_FACILITY b where  a.PRACT_TYPE=nvl(`"+to_pract_type+"`,a.PRACT_TYPE)  AND b.FACILITY_ID=`<%= p_facility_id %>` AND a.Practitioner_id=b.Practitioner_id";

				search_code="a.practitioner_id";
				search_desc= "a.Practitioner_name";
			}

			if(obj.name=="Speciality")
			{
				var tit=getLabel('Common.speciality.label','Common');
				//sql="select speciality_code, short_desc from am_speciality ";
				
				sql="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";

				search_code="speciality_code";
				search_desc= "short_desc";
			}

			if(obj.name=="bed_class_code")
			{
				tit=getLabel('Common.BedClass.label','common')
				//sql="select bed_class_code,short_desc from ip_bed_class ";

				sql="select bed_class_code,short_desc from ip_bed_class_lang_vw where language_id=`"+locale+"`";
				search_code="bed_class_code";
				search_desc= "short_desc";
			}


			if(obj.name=="nursing_unit_code_fm" || obj.name=="nursing_unit_code_to")
			{
			
				tit=getLabel('Common.nursingUnit.label','Common');
				//sql="select nursing_unit_code, short_desc from ip_nursing_unit where facility_id=`"+allfacilityid+"` ";
				sql="select nursing_unit_code, short_desc from ip_nursing_unit_lang_vw where facility_id=`"+allfacilityid+"` and language_id=`"+locale+"`";
				search_code="nursing_unit_code";
				search_desc= "short_desc";
			}
			

			if(obj.name=="admission_type")
			{
				tit=getLabel('Common.admissiontype.label','Common');
				//sql=" select admission_type_code, short_desc from ip_admission_type ";

				sql=" select admission_type_code, short_desc from ip_admission_type_lang_vw where language_id=`"+locale+"`";
				search_code="admission_type_code";
				search_desc= "short_desc";
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

	function removeitems(obj)
	{
		var len=obj.length;
		var i=1;
		while(i<len)
		{
			len=obj.length
			obj.remove(i)
		}
	}




</script>
</HEAD>

<BODY onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<br>
<br>
<form name="Rep2AdmissionCensesForm" id="Rep2AdmissionCensesForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<%
	String isSpltyNurUnitToEnableYNAppl="";
	con			=	ConnectionManager.getConnection(request);
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
				StrVal.append("<option value='"+rset1.getString(1)+"'>"+rset1.getString(2)+"</option>");
			}
		}
	 }
	 catch(Exception e){/* out.println(e); */ e.printStackTrace();}
%>
<table width='80%' align='center' valign='top'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	<tr>
		<td width="100%" class="Border" align='center'>
			<table width='100%' cellPadding="0" cellSpacing="0"  align='center'  >
				<tr>
					<td class="label" width ='30%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width ='30%' colspan='2'> 
							<select name='p_all_facility_id' id='p_all_facility_id'  onchange = "chkVal(this)">
						<%
							try
							{
							stmt=con.createStatement();
							String fid;
							String fname;
							//String sql1 = "select 'All' facility_id, 'All Access Facilities' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param p where u.appl_user_id ='"+ p_user_name+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2 ";	
							
							String all_access = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllAccessFacilities.label","common_labels");

							String sql1 = "select 'All' facility_id, '"+all_access+"' facility_name from dual union select u.facility_id facility_id, p.facility_name facility_name from  sm_facility_for_user u, sm_facility_param_lang_vw p where u.appl_user_id ='"+ p_user_name+"'and p.language_id='"+locale+"' and p.facility_id = u.facility_id and u.facility_id in (select distinct facility_id from sm_facility_for_resp where resp_id = '"+p_resp_id+"') order by 2";					


							rset=stmt.executeQuery(sql1);
							if(rset!=null)
							{
							   while(rset.next())
							   {
								fid=rset.getString("facility_id");
								fname=rset.getString("facility_name");
								if(fid.equals("All"))
								out.println("<option value='"+fid+ "'  selected>"+fname+"</option>");
								else
								out.println("<option value='"+fid+ "' >"+fname+"</option>");
							   }
							}
							}catch(Exception e)
							{
								//out.println(e);
								e.printStackTrace();
							}
							 finally
							 {
								if(rset != null)    rset.close();
								if(stmt != null)    stmt.close();
								if(rset1 != null)    rset1.close();
								if(stmt1 != null)    stmt1.close();
								if(con!=null) ConnectionManager.returnConnection(con,request);
							 }
						%>	
						</select>
					</td>
				</tr>

				<tr>
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
				</tr>

				<tr>
					<td class="label" width ='30%'><fmt:message key="Common.groupby.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width ='30%' colspan='2'>
						<select name='p_col1' id='p_col1' onchange='chkVal(this)'>
							<!-- <option value='to_nursing_unit_short_desc'>Nursing Unit</option>
							<option value='to_practitioner_long_name'>Practitioner</option>
							<option value='to_specialty_short_desc'>Specialty</option> -->
							<option value='c.short_desc'><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
							<option value='d.practitioner_name'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
							<option value='e.short_desc'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
						</select>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<select name='p_col2' id='p_col2'  onchange='chkVal(this)'>
 							<option value='null'>&nbsp;------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------&nbsp;</option>
 							<!-- <option value='to_practitioner_long_name'>Practitioner</option>
							<option value='to_specialty_short_desc'>Specialty</option> -->
							<option value='d.practitioner_name'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
							<option value='e.short_desc'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>

						</select>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<select name='p_col3' id='p_col3' disabled onchange='chkVal(this)'>
							<option value='null'>&nbsp;------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------&nbsp;</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
				</tr>
				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="querydata" width="30%"style="font-weight: bold;"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="querydata" width="40%" style="font-weight: bold;"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<!-- Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1 -->
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonNursingUnitLookup.jsp">
					<jsp:param name="nursing_unit_code_Appl" value="p_fm_nursing_unit"/>
					<jsp:param name="nursing_unit_to_code_Appl" value="p_to_nursing_unit"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.NursingUnitCode.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width="30%"  >
						<input type=text  disabled name='p_fm_nursing_unit' id='p_fm_nursing_unit' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_fm' id='nursing_unit_code_fm' value='?' class='button' onclick='searchCode(this, p_fm_nursing_unit)'>
					</td>
					<td class="fields" width='40%'> 
						<input type=text  disabled name='p_to_nursing_unit' id='p_to_nursing_unit' size="4" maxlength="4" align="center"><input type='button' disabled name='nursing_unit_code_to' id='nursing_unit_code_to' value='?' class='button' onclick='searchCode(this, p_to_nursing_unit)'>
					</td>
				</tr><%}%>
				<tr>
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
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
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
				</tr>
				<tr>
						<td  width='30%' class="label"><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class="fields" width='30%'  >
							<input type=text  disabled name='p_fm_practitioner' id='p_fm_practitioner' size="15" maxlength="15" align="center"><input type='button' disabled name='practitioner_id_fm' id='practitioner_id_fm' value='?' class='button' onclick='searchCode(this, p_fm_practitioner)'>
						</td>
						<td class="fields" width='40%'> 
							<input type=text  disabled name='p_to_practitioner' id='p_to_practitioner' size="15" maxlength="15" align="center"><input type='button' disabled name='practitioner_id_to' id='practitioner_id_to' value='?' class='button' onclick='searchCode(this, p_to_practitioner)'>
						</td>
				</tr>
				<tr>
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
				</tr>
				<%if(isSpltyNurUnitToEnableYNAppl.equals("N")){%>
					<tr>
					<jsp:include page="CommonSpecialityLookup.jsp">
					<jsp:param name="speciality_code_Appl" value="p_fm_speciality"/>
					<jsp:param name="speciality_to_code_Appl" value="p_to_speciality"/>
					</jsp:include>
					</tr>
				<%}else{%>
				<tr>
						<td width='30%' class="label"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/> &nbsp;</td>
						<td class="fields" width='30%'  >
							<input type=text  name='p_fm_speciality' id='p_fm_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_fm_speciality)'>
						</td>
						<td class="fields" width='40%'> 
							<input type=text  name='p_to_speciality' id='p_to_speciality' size="4" maxlength="4" align="center"><input type='button' name='Speciality' id='Speciality' value='?' class='button' onclick='searchCode(this, p_to_speciality)'>
						</td>
				</tr><%}%>
				<tr>
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
				</tr>
				<tr>
						<td  width='30%' class="label"><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
						<td class="fields" width='30%'  >
							<input type=text  name='p_fm_adm_type' id='p_fm_adm_type' size="2" maxlength="2" align="center" ><input type='button' name='admission_type' id='admission_type' value='?' class='button' onclick='searchCode(this, p_fm_adm_type)'>
						</td>
						<td class="fields" width='40%'> 
							<input type=text  name='p_to_adm_type' id='p_to_adm_type' size="2" maxlength="2" align="center"><input type='button' name='admission_type' id='admission_type' value='?' class='button' onclick='searchCode(this, p_to_adm_type)'>
						</td>
				</tr>
				<tr>
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
				</tr>
				<tr>
					<td  width='30%' class="label"><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/> &nbsp;</td>
					<td class="fields" width='30%'  >
						<input type=text id="adm_date_from" name='p_fm_admission_date' id='p_fm_admission_date' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_from');">
					</td>
					<td class="fields" width='40%'> 
						<input type=text id="adm_date_to" name='p_to_admission_date' id='p_to_admission_date' size="10" maxlength="10" align="center" onblur='validDateObj(this,"DMY",localeName);'><input type="image" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('adm_date_to');">
					</td>
				</tr>
				<tr>
					<td class="label" width ='30%' colspan='3'>&nbsp;</td>
				</tr>
		</table>
	</td>
</tr>
</table>
	<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%= p_facility_id %>">
	<input type="hidden" name="p_module_id" id="p_module_id" 		value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id" 		value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"			value="<%= p_user_name %>">
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
	//Added by shanmukh on 3rd-OCT-2018 for ML-MMOH-CRF-1115.1
	if(document.Rep2AdmissionCensesForm.isSpltyNurUnitToEnableYNAppl.value=="N"){
	document.Rep2AdmissionCensesForm.nursing_unit_desc.disabled = true
	document.Rep2AdmissionCensesForm.nursing_unit.disabled = true
	document.Rep2AdmissionCensesForm.p_fm_nursing_unit.disabled = true
	document.Rep2AdmissionCensesForm.p_to_nursing_unit.disabled = true}
</script>
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

