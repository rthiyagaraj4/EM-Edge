<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
 %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rset          = null;

%>
<html>
<%
String call_function= request.getParameter("call_function")==null?"":request.getParameter("call_function");

String disable_fld = "";
if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
	disable_fld = "disabled";
}
%>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eIP/js/DischargeCheckList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function checkMaxLimit1(obj,maxSize)	
{
   var len  = obj.value;
   
	if ( obj.value.length >= maxSize )
	{
		event.returnValue = false;
	}
}
function chklim(obj,maxSize)	
{
   var len  = obj.value;
	if ( obj.value.length > maxSize )
	{
	    alert(getMessage("REMARKS_NOT_EXCEED_200_CH","SM"));
	    obj.focus();
	    obj.select();
	}
}
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DischargeCheckListTab5' id='DischargeCheckListTab5'>
<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
<tr>
	<td class='label' width="25%"><fmt:message key="eIP.Takencareby.label" bundle="${ip_labels}"/></td>
	<td class='fileds' width="25%" >
	<select name='relationship_txt' id='relationship_txt' <%=disable_fld%>>
	<option value='' selected>---&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp;---</option>

<%	try
	{		
		con = ConnectionManager.getConnection(request);
		String sqlRelation = "select relationship_code, short_desc from MP_RELATIONSHIP_LANG_VW where language_id='"+locale+"' and eff_status = 'E' order by 2";
		String strRelationShipCode = "";
		String strRelationShip = "";
		pstmt = con.prepareStatement(sqlRelation);
		rset = pstmt.executeQuery();
		if(rset != null)
		{
			while(rset.next())
			{								
				strRelationShipCode = rset.getString("relationship_code");
				strRelationShip = rset.getString("short_desc");					
			%>
				<option value="<%=strRelationShipCode%>" ><%=strRelationShip%></option> 
		<%  }
		}
		if(rset!=null)	rset.close();
		if(pstmt!= null)pstmt.close();		
	}
	catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
	</select>	</td>	
	<td class='label' width="25%" ></td>
	<td class='label'  width="25%"></td>
</tr>

<tr>
	<td class='label' ><fmt:message key="eMP.mothername.label" bundle="${mp_labels}"/></td>
	<td class='fileds'  ><input type='text' name='mother_name' id='mother_name' size='20' maxlength='20' <%=disable_fld%>></td>
	<td class='label' ><fmt:message key="eIP.MotherIDNo.label" bundle="${ip_labels}"/></td>
	<td class='fileds'  ><input type='text' name='mother_no' id='mother_no' size='20' maxlength='20' <%=disable_fld%>></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eMP.fathername.label" bundle="${mp_labels}"/></td>
	<td class='fileds'  ><input type='text' name='father_name' id='father_name' size='20' maxlength='20' <%=disable_fld%>></td>
	<td class='label' ><fmt:message key="eIP.FatherIDNo.label" bundle="${ip_labels}"/></td>
	<td class='fileds'  ><input type='text' name='father_no' id='father_no' size='20' maxlength='20' <%=disable_fld%>></td>

</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.OthersSpecify.label" bundle="${ip_labels}"/></td>
	<td class='fileds' colspan='3'><textarea name='Remarks' rows=3 cols='60' onkeypress="checkMaxLimit1(this,200)" onblur = "makeValidString(this);chklim(this,200)" <%=disable_fld%>></textarea></td>
</tr>
<!-- </table>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'> -->
<tr>
	<td class='label' ><fmt:message key="Common.R/N.label" bundle="${common_labels}"/></td>
	<td class='fileds'  ><input type='text' name='rn_txt' id='rn_txt' size='30' maxlength='80' <%=disable_fld%>></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.Ward.label" bundle="${common_labels}"/></td>
	<td class='fileds'  ><input type='text' name='ward_txt' id='ward_txt' size='30' maxlength='30' <%=disable_fld%>></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr>
	<td class='label'><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></td>
	<td class='fileds'  ><input type='text' name='discharge_date' id='discharge_date' id='dischargedate' size='16' maxlength='16'  onkeypress="return Valid_DT_tab6(event);" onBlur="chk_with_sysdate_tab1(this);" <%=disable_fld%>><input type="image" id="discharge_date_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].discharge_date.select();return showCalendar('dischargedate',null,'hh:mm')"></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.weight.label" bundle="${common_labels}"/></td>
	<td class='fileds'  ><input type='text' name='weight_txt' id='weight_txt' size='6' maxlength='6' onKeyPress='return allowValidNumber(this,event,2,3)' <%=disable_fld%>></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.length.label" bundle="${common_labels}"/></td>
	<td class='fileds'  ><input type='text' name='length_txt' id='length_txt' size='6' maxlength='6' onKeyPress='return allowValidNumber(this,event,3,2)' <%=disable_fld%>></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.HeadCircumference.label" bundle="${common_labels}"/></td>
	<td class='fileds'  ><input type='text' name='head_circum' id='head_circum' size='6' maxlength='6' onKeyPress='return allowValidNumber(this,event,3,2)' <%=disable_fld%>></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.AdviceGivenTo.label" bundle="${ip_labels}"/></td>
	<td class='fileds'  ><input type='text' name='adv_given' id='adv_given' size='30' maxlength='50' <%=disable_fld%>></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>

<tr>
	<td class='label' colspan=4></td>
</tr>
<table>
</form>
<script>

document.forms[0].rn_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_rn_txt.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_rn_txt.value!='')
document.forms[0].rn_txt.disabled = true;

document.forms[0].ward_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_ward_txt.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_ward_txt.value!='')
document.forms[0].ward_txt.disabled = true;

document.forms[0].discharge_date.value = parent.DischargeCheckList_frame1.document.forms[0].h_discharge_date.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_discharge_date.value!='')
{
	document.forms[0].discharge_date.disabled = true;
	document.getElementById("discharge_date_img").disabled = true;
}

document.forms[0].weight_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_weight_txt.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_weight_txt.value!='')
document.forms[0].weight_txt.disabled = true;

document.forms[0].length_txt.value = parent.DischargeCheckList_frame1.document.forms[0].h_length_txt.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_length_txt.value!='')
document.forms[0].length_txt.disabled = true;

document.forms[0].head_circum.value = parent.DischargeCheckList_frame1.document.forms[0].h_head_circum.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_head_circum.value!='')
document.forms[0].head_circum.disabled = true;

document.forms[0].adv_given.value = parent.DischargeCheckList_frame1.document.forms[0].h_adv_given.value;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_adv_given.value!='')
document.forms[0].adv_given.disabled = true;


if(parent.DischargeCheckList_frame1.document.forms[0].h_relationship_txt.value!='')
{
	document.forms[0].relationship_txt.value = 
	parent.DischargeCheckList_frame1.document.forms[0].h_relationship_txt.value;
	document.forms[0].relationship_txt.disabled = true;
}

// NEWFILEDS

if(parent.DischargeCheckList_frame1.document.forms[0].h_mother_name.value!='')
{
	document.forms[0].mother_name.value = 
	parent.DischargeCheckList_frame1.document.forms[0].h_mother_name.value;
	document.forms[0].mother_name.disabled = true;
}


if(parent.DischargeCheckList_frame1.document.forms[0].h_mother_no.value!='')
{
	document.forms[0].mother_no.value = 
	parent.DischargeCheckList_frame1.document.forms[0].h_mother_no.value;
	document.forms[0].mother_no.disabled = true;
}

if(parent.DischargeCheckList_frame1.document.forms[0].h_father_name.value!='')
{
	document.forms[0].father_name.value = 
	parent.DischargeCheckList_frame1.document.forms[0].h_father_name.value;
	document.forms[0].father_name.disabled = true;
}

if(parent.DischargeCheckList_frame1.document.forms[0].h_father_no.value!='')
{
	document.forms[0].father_no.value = 
	parent.DischargeCheckList_frame1.document.forms[0].h_father_no.value;
	document.forms[0].father_no.disabled = true;
}

if(parent.DischargeCheckList_frame1.document.forms[0].h_Remarks.value!='')
{
	document.forms[0].Remarks.value = 
	parent.DischargeCheckList_frame1.document.forms[0].h_Remarks.value;
	document.forms[0].Remarks.disabled = true;
}


</script>
</body>
</html> 
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

