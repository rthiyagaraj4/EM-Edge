<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:34 AM -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
request.setCharacterEncoding("UTF-8");
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs    =null;

String func_act = request.getParameter("func_act");
String view= request.getParameter("view");
if(view == null) view="";

func_act = (func_act == null)?"":func_act;

func_act = "VIEW";

String locale =((String)session.getAttribute("LOCALE"));
String patientIDLength = "";
String alt_id1_length = "",alt_id2_length = "",alt_id3_length = "",alt_id4_length = "";// added for PMG2014-HSA-CRF-0001 [IN:050020] 
String alt_id1_Type   = "",alt_id2_Type   = "",alt_id3_Type   = "",alt_id4_Type   = "";// added for PMG2014-HSA-CRF-0001 [IN:050020] 
//String alternate_id_type_desc = "";
String dflt_sndx_type = "", first_name_prompt = "", second_name_prompt = "", third_name_prompt = "", family_name_prompt = "";
String names_in_oth_lang_yn = "";
String pat_name_as_multipart_yn = "";
String alt_id1_type_desc = "",alt_id2_type_desc = "",alt_id3_type_desc = "",alt_id4_type_desc = "",nat_id_prompt="",nat_id_length="";// added for PMG2014-HSA-CRF-0001 [IN:050020] 
String function_id = request.getParameter("function_id");
String func_idpassed = request.getParameter("func_idpassed")==null?"":request.getParameter("func_idpassed");
String first_name_length = "";
String second_name_length = "";
String third_name_length = "";
String family_name_length = "";
String accept_oth_alt_id_yn="";
String accept_national_id_no_yn="";

if (function_id==null) function_id = "";
try 
{
	con = ConnectionManager.getConnection(request);
	pstmt = con.prepareStatement(" Select patient_id_length,Alt_id1_length,Alt_id1_type,Alt_id2_length,Alt_id2_type, Alt_id3_length,Alt_id3_type,Alt_id4_length,Alt_id4_type,nat_id_prompt, Alt_id1_type Dflt_Sndx_type, First_Name_Prompt, second_Name_Prompt, third_Name_Prompt, family_Name_Prompt, names_in_oth_lang_yn, pat_name_as_multipart_yn,nat_id_length,accept_oth_alt_id_yn,accept_national_id_no_yn,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id1_type and language_id='"+locale+"') alt_id1_type_desc,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id2_type and language_id='"+locale+"') alt_id2_type_desc,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id3_type and language_id='"+locale+"') alt_id3_type_desc,(select long_desc from mp_alternate_id_type_lang_vw where ALT_ID_TYPE=alt_id4_type and language_id='"+locale+"') alt_id4_type_desc,first_name_length, second_name_length, third_name_length,family_name_length from mp_param_lang_vw where language_id='"+locale +"'");
	rs=pstmt.executeQuery();
	if(rs.next()) 
	{           
		patientIDLength= checkForNull(rs.getString(1));
		alt_id1_length = checkForNull(rs.getString(2));
		alt_id1_Type   = checkForNull( rs.getString(3));
		alt_id2_length =checkForNull( rs.getString(4));
		alt_id2_Type   = checkForNull(rs.getString(5));
		alt_id3_length = checkForNull(rs.getString(6));
		alt_id3_Type   =checkForNull( rs.getString(7));
		alt_id4_length = checkForNull(rs.getString(8));
		alt_id4_Type   = checkForNull(rs.getString(9));
		nat_id_prompt   = checkForNull(rs.getString(10));
		dflt_sndx_type = checkForNull(rs.getString(11));
		first_name_prompt =checkForNull( rs.getString(12));
		second_name_prompt =checkForNull(rs.getString(13));
		third_name_prompt = checkForNull(rs.getString(14));
		family_name_prompt =checkForNull(rs.getString(15));
		if (first_name_prompt==null) first_name_prompt="First Name";
		if (second_name_prompt==null) second_name_prompt="Second Name";
		if (third_name_prompt==null) third_name_prompt="Third Name";
		if (family_name_prompt==null) family_name_prompt="Family Name";
		names_in_oth_lang_yn = rs.getString(16)==null?"":rs.getString(16);
		pat_name_as_multipart_yn =checkForNull(rs.getString(17));
		alt_id1_type_desc =checkForNull( rs.getString("alt_id1_type_desc"));
		alt_id2_type_desc =checkForNull( rs.getString("alt_id2_type_desc"));
		alt_id3_type_desc = checkForNull(rs.getString("alt_id3_type_desc"));
		alt_id4_type_desc = checkForNull(rs.getString("alt_id4_type_desc"));
		nat_id_length = rs.getString("nat_id_length")==null?"":rs.getString("nat_id_length");
		first_name_length = rs.getString("first_name_length")==null?"":rs.getString("first_name_length");
		second_name_length = rs.getString("second_name_length")==null?"":rs.getString("second_name_length");
		third_name_length = rs.getString("third_name_length")==null?"":rs.getString("third_name_length");
		family_name_length = rs.getString("family_name_length")==null?"":rs.getString("family_name_length");
		accept_oth_alt_id_yn = rs.getString("accept_oth_alt_id_yn")==null ? "N" : rs.getString("accept_oth_alt_id_yn");
		accept_national_id_no_yn = rs.getString("accept_national_id_no_yn")==null ? "N" : rs.getString("accept_national_id_no_yn");
	}
	if (rs!=null) rs.close();
	if (pstmt!=null) pstmt.close();

	/*
	pstmt = con.prepareStatement("select long_desc from mp_alternate_id_type_lang_vw where alt_id_type = ? and language_id='"+locale+"'");
	pstmt.setString(1,altIDType);
	rs=pstmt.executeQuery();
	if(rs.next()) 
	{
		alternate_id_type_desc = rs.getString("long_desc")==null?"":rs.getString("long_desc");
	}

	if (rs!=null) rs.close();
	if (pstmt!=null) pstmt.close();
	*/

%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eMP/js/NewbornRegistration.js' language='javascript'></script>
<script src='../../eMP/js/NewbornRegistration1.js' language='javascript'></script>
<script src='../../eMP/js/NewbornRegistration2.js' language='javascript'></script>
<!-- <Script src="../../eMP/js/MaintainBirthRegistration.js" language="JavaScript"></Script> -->
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<Script src='../../eMP/js/ViewBirthDetails.js' language='JavaScript'></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<script src='../../eMP/js/NameSuffix.js' language='javascript'></script>

<!--	
		The following methods are moved to ViewBirthDetails.js :
		EnableFamSearch(),DefaultSelect(),checkReadOnly(),makeToDateEnable(),ChangeCase(),
		DobToCheck() ,changeOtherInput(),changeInputFocus(), PatSearch(), formatFlds(),callEmpty()
-->

<script>
var flag;
var strand=" AND ";
	function Posting()
	{

		var flag=false;
		if(document.getElementById("names_search_by").value=="")
		{
			flag=true;
		}
		else
		{
			if(document.birth_register_Form.first_name.value != "" || document.birth_register_Form.second_name.value != "" || document.birth_register_Form.third_name.value != "" || document.birth_register_Form.family_name.value != "")
			{
				flag=true;
			}

		}
		if(flag==true)
		{
		var PatientID=document.birth_register_Form.Patient_Id.value;
		var MotherPatientID= document.birth_register_Form.Mother_Patient_Id.value;
		if(document.birth_register_Form.Alt_Id1_No)
		var AltId1No = document.birth_register_Form.Alt_Id1_No.value;
		if(document.birth_register_Form.Alt_Id2_No)
		var AltId2No = document.birth_register_Form.Alt_Id2_No.value;
		if(document.birth_register_Form.Alt_Id3_No)
		var AltId3No = document.birth_register_Form.Alt_Id3_No.value;
		if(document.birth_register_Form.Alt_Id4_No)
		var AltId4No = document.birth_register_Form.Alt_Id4_No.value;
		if(document.birth_register_Form.other_alt_id)
		var other_alt_id = document.birth_register_Form.other_alt_id.value;
		if(document.birth_register_Form.other_alt_Id_no)
		var other_alt_Id_no = document.birth_register_Form.other_alt_Id_no.value;
		if(document.birth_register_Form.nat_id_prompt)
		var nat_id_prompt = document.birth_register_Form.nat_id_prompt.value;
		var Sex = document.birth_register_Form.Sex.value;
		var DOB = document.birth_register_Form.Dob.value;
		var DOBTo =document.birth_register_Form.DobTo.value; 
		var view='<%=view%>';
		var altIDType=document.birth_register_Form.altIDType.value;
		var fourth_name="";
		var fifth_name="";
		if (document.birth_register_Form.fourth_name)
			fourth_name = document.birth_register_Form.fourth_name.value;
		if (document.birth_register_Form.fifth_name)
			fifth_name = document.birth_register_Form.fifth_name.value;
		var altIDType1='<%=alt_id1_Type%>';
		var function_id = "<%=function_id%>";
		var regn_type = "";
		//Added by kumar on 17/03/2003 for Malaysia Enhancements		
		var searchby = "";
		if (document.forms[0].searchby)
			searchby = document.forms[0].searchby.value;
		var pat_name_as_multipart_yn = "<%=pat_name_as_multipart_yn%>";
		//End of Addition
		var regn_no = "";
		for (var i=0;i<document.forms[0].elements.length;i++)
		{
			document.forms[0].elements[i].disabled=true;
		}
		parent.frames[2].document.forms[0].Search.focus();
		parent.frames[2].document.forms[0].Search.disabled = true;
		parent.frames[0].location.href='../../eCommon/jsp/process.jsp';
		parent.frames[3].location.href='../../eCommon/html/blank.html';
		if (parent.frames[1].document.forms[0].searchby)
			if (document.birth_register_Form.soundex_val.value != '')
				parent.frames[1].document.forms[0].searchby.disabled=true;
		
		var hiddenVals   = " <html> <head><META HTTP-EQUIV='Content-Type' CONTENT='text/html; charset=UTF-8'></head> \n"
		hiddenVals   += " <body onKeyDown='lockKey()'> <form name='tempform' id='tempform' method='post' action='../../eMP/jsp/ViewBirthRegisterResult.jsp'> \n" ; 
		hiddenVals   += " <input type='hidden' name='function_id' id='function_id' value=\""+function_id+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='Patient_Id' id='Patient_Id' value=\""+PatientID+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='Mother_Patient_Id' id='Mother_Patient_Id' value=\""+MotherPatientID+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='Alt_Id1_No' id='Alt_Id1_No' value=\""+AltId1No+"\" > \n" ; 		
		hiddenVals   += " <input type='hidden' name='Alt_Id2_No' id='Alt_Id2_No' value=\""+AltId2No+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='Alt_Id3_No' id='Alt_Id3_No' value=\""+AltId3No+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='Alt_Id4_No' id='Alt_Id4_No' value=\""+AltId4No+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='other_alt_id' id='other_alt_id' value=\""+other_alt_id+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='other_alt_Id_no' id='other_alt_Id_no' value=\""+other_alt_Id_no+"\" > \n" ;
		hiddenVals   += " <input type='hidden' name='nat_id_prompt' id='nat_id_prompt' value=\""+nat_id_prompt+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='Sex' id='Sex' value=\""+Sex+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='Dob' id='Dob' value=\""+DOB+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='view' id='view' value=\""+view+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='altIDType' id='altIDType' value=\""+altIDType1+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='DobTo' id='DobTo' value=\""+DOBTo+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='regn_type' id='regn_type' value=\""+regn_type+"\" > \n" ;
		hiddenVals   += " <input type='hidden' name='regn_no' id='regn_no' value=\""+regn_no+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='first_name' id='first_name' value=\""+document.birth_register_Form.first_name.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='second_name' id='second_name' value=\""+document.birth_register_Form.second_name.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='third_name' id='third_name' value=\""+document.birth_register_Form.third_name.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='family_name' id='family_name' value=\""+document.birth_register_Form.family_name.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='fourth_name' id='fourth_name' value=\""+fourth_name+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='fifth_name' id='fifth_name' value=\""+fifth_name+"\" > \n" ;
		//Added by kumar on 17/03/2003 for Malaysia Enhancements
		hiddenVals   += " <input type='hidden' name='searchby' id='searchby' value=\""+searchby+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='pat_name_as_multipart_yn' id='pat_name_as_multipart_yn' value=\""+pat_name_as_multipart_yn+"\" > \n" ; 
		//End of Addition
		hiddenVals   += " <input type='hidden' name='soundex' id='soundex' value=\""+document.birth_register_Form.soundex_val.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='names_search_by' id='names_search_by' value=\""+document.birth_register_Form.names_search_by.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='alt_id1_type_deschd' id='alt_id1_type_deschd' value=\""+document.birth_register_Form.alt_id1_type_deschd.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='alt_id2_type_deschd' id='alt_id2_type_deschd' value=\""+document.birth_register_Form.alt_id2_type_deschd.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='alt_id3_type_deschd' id='alt_id3_type_deschd' value=\""+document.birth_register_Form.alt_id3_type_deschd.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='alt_id4_type_deschd' id='alt_id4_type_deschd' value=\""+document.birth_register_Form.alt_id4_type_deschd.value+"\" > \n" ; 
		hiddenVals   += " <input type='hidden' name='nat_id_prompt_des' id='nat_id_prompt_des' value=\""+document.birth_register_Form.nat_id_prompt_des.value+"\" > \n" ; 
		if (document.forms[0].names_in_oth_lang)
			if(document.forms[0].names_in_oth_lang.checked )
				hiddenVals   += " <input type='hidden' name='apply_oth_name' id='apply_oth_name' value='Y' > \n" ; 
		hiddenVals   += " </form></body></html> \n" ; 
		parent.frames[3].document.body.insertAdjacentHTML('afterbegin',hiddenVals);
		
		parent.frames[3].document.forms[0].submit();		
		}
		else
		{
			alert(getMessage('ONE_NAME_ENTER','MP'));
			parent.frames[0].location.href='../../eMP/jsp/BirthRegisterToolBar.jsp';
			return;
		}
}

function setFields()
{
	var sp='<%=family_name_prompt%>';
	EnableFamSearch(document.forms[0].soundex_val);
	if(document.forms[0].names_search_by.value=="F")
	{
		//document.getElementById('aa').innerHTML=getLabel('eMP.fathername.label','MP');
		//document.forms[0].soundex_val.disabled=true;
	//	document.forms[0].family_name.value="";
		if(document.forms[0].searchby)
			document.forms[0].searchby.disabled=false;
	}
	
	else
	{
		//document.getElementById('aa').innerHTML=sp;
		document.forms[0].soundex_val.disabled=false;
	}

	if(document.forms[0].names_search_by.value != "")
	{
		document.birth_register_Form.first_name.disabled =  false; document.birth_register_Form.second_name.disabled = false; document.birth_register_Form.third_name.disabled = false; document.birth_register_Form.family_name.disabled = false;
	}
	else
	{
	document.birth_register_Form.first_name.disabled =  true; document.birth_register_Form.second_name.disabled = true; document.birth_register_Form.third_name.disabled = true; document.birth_register_Form.family_name.disabled = true;

	document.birth_register_Form.first_name.value =  "";
	document.birth_register_Form.second_name.value = ""; 
	document.birth_register_Form.third_name.value = ""; 
	document.birth_register_Form.family_name.value = "";
	}
}

</script>

</head>

<body ID='HR' class='content'  onload="FocusFirstElement();DefaultSelect('<%=dflt_sndx_type%>');EnableFamSearch(document.forms[0].soundex_val)" onKeyDown = 'lockKey()'>

<form name="birth_register_Form" id="birth_register_Form" action='../../eMP/jsp/ViewBirthRegisterResult.jsp' target='results'>

<center>
<table border="0" cellpadding="0" cellspacing="0" width="100%" >

<td class='COLUMNHEADER'><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td>
<tr>
	<td width="100%" class="BORDER">
		<table border="0" cellpadding="2" cellspacing="0" width="100%">
			<tr>
				<td width="25%" class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
				<td width="25%" class="FIELDS"><input type="text" name="Patient_Id" id="Patient_Id" size="15" maxlength="<%=patientIDLength%>" 
				onFocus="changeInputFocus(this)" onKeyPress='return CheckForSpecChars(event)'
				onBlur="makeValidQueryCriteria(this);ChangeUpperCase(this);"  
				></td>	
				<%if(names_in_oth_lang_yn.equals("Y")) { %>
				<td width="25%" class="label" ><fmt:message key="eMP.SearchNameWithLocalLang.label" bundle="${mp_labels}"/></td>
				<td width="25%" class="fields" ><input type='checkbox' name='names_in_oth_lang' id='names_in_oth_lang' value='Y' checked></td>
				<%}else {%>	
	           <td  class='fields' >						
	           </td>
	           <%}%> 
			</tr>				 
			<tr><td class="label" ><fmt:message key="Common.birthDate.label" bundle="${common_labels}"/></td>
				<td  class="FIELDS"><input type="text" id="dobfrom" name="Dob" id="Dob" size="8" onBlur="makeToDateEnable(this);DobToCheck();" maxlength="10"><img src='../../eCommon/images/CommonCalendar.gif' onClick="showCalendar('dobfrom');document.forms[0].Dob.select();" tabindex=-1></img>-<input type="text" id="dobto" name="DobTo" id="DobTo" size="8" onBlur="validDateObj(this,'DMY','<%=localeName%>');DobToCheck();" maxlength="10"  ><img src='../../eCommon/images/CommonCalendar.gif' id="dobtoimg" disabled onClick="showCalendar('dobto');document.forms[0].DobTo.select();" tabindex=-1></img></td>	
				<td width="25%" class="label" ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
				<td width="25%" class="FIELDS"><Select name="Sex" id="Sex"><Option value="" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><Option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><Option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><Option value="U"><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></Select></td>
			</tr>
			
			<tr> 
				<td class="label" ><fmt:message key="eMP.motherpatientid.label" bundle="${mp_labels}"/></td>
							 
				<td  class="FIELDS"><input type="text" name="Mother_Patient_Id" id="Mother_Patient_Id" size="15" maxlength="<%=patientIDLength%>"  
				onFocus="changeInputFocus(this)"
				onKeyPress='return CheckForSpecChars(event)'	onBlur="makeValidQueryCriteria(this);ChangeUpperCase(this);" ><input type='button' class='button' value='?' tabIndex='-1' name="search" id="search" onClick="PatSearch(); "></td>
				<%if(!alt_id1_type_desc.equals("")){%>
				<td class="label" ><%=alt_id1_type_desc%></td>
				<td class="FIELDS"><input type="text" name="Alt_Id1_No" id="Alt_Id1_No" size="15" maxlength="<%=alt_id1_length%>"
				onFocus="changeInputFocus(this)"
				onKeyPress='return CheckForSpecChars(event)'
				 <!--onblur = "checkReadOnly();--> makeValidQueryCriteria(this);"></td>
	               <%} %>
	 			
				 <input type ="hidden" name="alt_id1_Type" id="alt_id1_Type" value="<%=alt_id1_Type%>">
			  
				 </tr>
				 <tr>
				  <%if(!alt_id2_type_desc.equals("")){%>
				 <td class="label" ><%=alt_id2_type_desc%></td>
				<td class="FIELDS"><input type="text" name="Alt_Id2_No" id="Alt_Id2_No" size="15" maxlength="<%=alt_id2_length%>"
				onFocus="changeInputFocus(this)"
				onKeyPress='return CheckForSpecChars(event)' makeValidQueryCriteria(this);"></td>
					<%} %>
				 <input type ="hidden" name="alt_id2_Type" id="alt_id2_Type" value="<%=alt_id2_Type%>">
				 <%if(!alt_id3_type_desc.equals("")){%>
				 <td class="label" ><%=alt_id3_type_desc%></td>
				<td class="FIELDS"><input type="text" name="Alt_Id3_No" id="Alt_Id3_No" size="15" maxlength="<%=alt_id3_length%>"
				onFocus="changeInputFocus(this)"
				onKeyPress='return CheckForSpecChars(event)' makeValidQueryCriteria(this);"></td>
				<%} %>
				 <input type ="hidden" name="alt_id3_Type" id="alt_id3_Type" value="<%=alt_id3_Type%>">
			  
				 </tr>
				  <tr>
				<%if(!alt_id4_type_desc.equals("")){%>
				 <td class="label" ><%=alt_id4_type_desc%></td>
				<td class="FIELDS"><input type="text" name="Alt_Id4_No" id="Alt_Id4_No" size="15" maxlength="<%=alt_id4_length%>"
				onFocus="changeInputFocus(this)"
				onKeyPress='return CheckForSpecChars(event)' makeValidQueryCriteria(this);"></td>
				<%} %>
				 <input type ="hidden" name="alt_id4_Type" id="alt_id4_Type" value="<%=alt_id4_Type%>">
				 <%if (accept_national_id_no_yn.equals("Y")){%>
				 <td class="label" ><%=nat_id_prompt%></td>
				<td class="FIELDS"><input type="text" name="nat_id_prompt" id="nat_id_prompt" size="15" maxlength="<%=nat_id_length%>"
				onFocus="changeInputFocus(this)"
				onKeyPress='return CheckForSpecChars(event)' makeValidQueryCriteria(this);"></td>
				<%} %>
				
				 <input type ="hidden" name="alt_id4_Type" id="alt_id4_Type" value="<%=alt_id4_Type%>">
			  
				 </tr>
				   <tr>
				  <%if(accept_oth_alt_id_yn.equals("Y")){%>
								
					<td  width='25%' class="label" ><fmt:message key="Common.OtherAltType.label" bundle="${common_labels}"/></td>
								
					<td  width='25%' class="fields" ><select onchange='enableOtherAltId(this.value)' name='other_alt_id' id='other_alt_id' ><option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----

								<%String Qry_For_AltType = "SELECT alt_id_type,nvl((select desc1_value from SM_OTH_LANG_DATA_SKEY where table_id ='MP_ALTERNATE_ID_TYPE' and language_id =? and pk_value=mp_alternate_id_type.alt_id_type),SHORT_DESC) SHORT_DESC FROM mp_alternate_id_type WHERE alt_id_type NOT IN (SELECT alt_id1_type FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id2_type,1) FROM MP_PARAM where module_id='MP'  UNION SELECT NVL(alt_id3_type,2) FROM MP_PARAM where module_id='MP' UNION SELECT NVL(alt_id4_type,3) FROM MP_PARAM where module_id='MP') and eff_status='E' order by 2";
									pstmt = con.prepareStatement(Qry_For_AltType);
									pstmt.setString(1,locale);
									rs = pstmt.executeQuery();	
									
									if(rs != null){
										while (rs.next()){          
											out.println ( "<Option value=\""+rs.getString("alt_id_type")+"\" >"+rs.getString("SHORT_DESC")+"</Option>" ) ;
										}
									}	
								%>
								</select></td>
								
								<td  class=label  width='25%'><fmt:message key="eMP.OtherAltNo.label" bundle="${mp_labels}"/></td>
								<td class=fields  width='25%'><input type ='text' name = 'other_alt_Id_no' value="" size='25' disabled  maxlength='20'  onKeyPress="return CheckForSpecChars(event)"></td>
							<%}%>
			     </tr>
				 
			     <tr> 
				<td class="label" ><fmt:message key="eMP.namesearchby.label" bundle="${mp_labels}"/></td>
				<td  class="FIELDS"><select name="names_search_by" id="names_search_by" onchange="setFields('<%=family_name_prompt%>')">
						<option value=''>----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<option value="B"><fmt:message key="eMP.BabyName.label" bundle="${mp_labels}"/></option>
						<option value="M" ><fmt:message key="eMP.mothername.label" bundle="${mp_labels}"/></option>
						<option value="F"><fmt:message key="eMP.fathername.label" bundle="${mp_labels}"/></option>
						</select>
				</td>
                   <% if (function_id.equals("")) { 
					//Added by kumar on 17/03/2003 for Malaysia Enhancements
					if (pat_name_as_multipart_yn.equals("N"))
					{%>
						<td class="label"><fmt:message key="Common.soundex.label" bundle="${common_labels}"/></td>
		                <td class="FIELDS"><Select name="soundex_val" id="soundex_val" onChange="EnableFamSearch(this)" tabindex=14><Option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---<Option value="E"><fmt:message key="Common.Ethnic.label" bundle="${common_labels}"/><Option value="G"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></Select></td>
					<%}
					else
					{
				%>		<td class="label"><fmt:message key="Common.soundex.label" bundle="${common_labels}"/></td>
						<td class="FIELDS"><Select name="soundex_val" id="soundex_val" tabindex=14><Option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---<Option value="E"><fmt:message key="Common.Ethnic.label" bundle="${common_labels}"/><Option value="G"><fmt:message key="Common.generic.label" bundle="${common_labels}"/></Select></td>                 
				<%	}
				}
				else
				{
				%>
					<td colspan=2><input type='hidden' name='soundex_val' id='soundex_val'></td>
				<%}%> 
				 
					

			</tr>			
								
		</table>
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr> 
				<% if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG")) {
					//Added by kumar on 17/03/2003 for Malaysia Enhancements
					if (pat_name_as_multipart_yn.equals("N")) {
				%>					
					<td width='25%' class="LABELLEFT" ><div id="aa"><%=family_name_prompt%></div></td>
					<td colspan=3></td>
				<%	}
					else
					{ 
					%>
						<td width='25%' class="LABELLEFT" ><%=first_name_prompt%></td>
						<td width='25%' class="LABELLEFT" ><%=second_name_prompt%></td>
						<td width='25%' class="LABELLEFT" ><%=third_name_prompt%></td>
						<td width='25%' class="LABELLEFT" ><div id="aa"><%=family_name_prompt%></div></td>	
					<%}
				}
				%>
				
			</tr>
			<tr> 
				<%if (function_id.equals("") || function_id.equals("MP_VIEW_BIRTH_REG")) {
					//Added by kumar on 17/03/2003 for Malaysia Enhancements
					if (pat_name_as_multipart_yn.equals("N")) { %>
						<input type='hidden' name='first_name' id='first_name'>
						<input type='hidden' name='second_name' id='second_name'>
						<input type='hidden' name='third_name' id='third_name'>
						<td class="FIELDS"  ><input type='text' maxlength='40' size='40' name='family_name' id='family_name' disabled onBlur='makeValidQueryCriteria(this)'></td>
						<td class="FIELDS" ><select disabled name='searchby' id='searchby'><option selected value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option><option value='S'><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option><option value='C'><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><option value='E'><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option></select></td>
						<td colspan=2></td>
					<%}
					else
					{
				%>
					<td   class="FIELDS"><input type='text'  maxlength='<%=first_name_length %>' size='30' name='first_name' onBlur='makeValidQueryCriteria(this)' disabled></td>
					<td  class="FIELDS"><input type='text' maxlength='<%=second_name_length%>' size='30' name='second_name' onBlur='makeValidQueryCriteria(this)' disabled></td>
					<td  class="FIELDS"><input type='text' maxlength='<%=third_name_length%>' size='30' name='third_name' onBlur='makeValidQueryCriteria(this)' disabled></td>
					<td  class="FIELDS"><input type='text' maxlength='<%=family_name_length%>' size='30' name='family_name' onBlur='makeValidQueryCriteria(this)' disabled></td>
				<%
					}
				}
				%>
			</tr>
			<%if (function_id.equals("")) {
			%>
				<tr><td colspan='4'></td></tr>
			<%}
			%>
		</table>
	</td>
</tr>
</table>
</center>
<input type ="hidden" name="altIDType" id="altIDType" value="<%=alt_id1_Type%>">
<input type ="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type ="hidden" name="func_idpassed" id="func_idpassed" value="<%=func_idpassed%>">
<input type ="hidden" name="alt_id1_type_deschd" id="alt_id1_type_deschd" value="<%=alt_id1_type_desc%>">
<input type ="hidden" name="alt_id2_type_deschd" id="alt_id2_type_deschd" value="<%=alt_id2_type_desc%>">
<input type ="hidden" name="alt_id3_type_deschd" id="alt_id3_type_deschd" value="<%=alt_id3_type_desc%>">
<input type ="hidden" name="alt_id4_type_deschd" id="alt_id4_type_deschd" value="<%=alt_id4_type_desc%>">
<input type ="hidden" name="nat_id_prompt_des" id="nat_id_prompt_des" value="<%=nat_id_prompt%>">
<input type ="hidden" name="accept_oth_alt_id_yn" id="accept_oth_alt_id_yn" value="<%=accept_oth_alt_id_yn%>">
<input type ="hidden" name="accept_national_id_no_yn" id="accept_national_id_no_yn" value="<%=accept_national_id_no_yn%>">

</form>
</body>
<%        
}catch(Exception e)
{
out.println(e.toString());
}
finally
{
if(rs !=null) rs.close();
if(pstmt != null) pstmt.close();
if(con!=null) ConnectionManager.returnConnection(con,request);                
}
%>
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

