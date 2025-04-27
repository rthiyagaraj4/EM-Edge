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
PreparedStatement pstmt= null;
ResultSet rset			= null;
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


</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DischargeCheckListTab4' id='DischargeCheckListTab4'>
<table border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>

<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
<tr><td class='COLUMNHEADER' colspan=4><fmt:message key="eIP.OtherDocuments.label" bundle="${ip_labels}"/></td>
<tr></tr><tr></tr>
<tr>
	<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width='25%'></td>
	<td class='COLUMNHEADER' width='25%'><fmt:message key="Common.details.label" bundle="${common_labels}"/></td>
	<td class=COLUMNHEADER width='25%'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.ReferralLetter.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='ref_ltr_chk' id='ref_ltr_chk' onclick="setValue_tab5(this);enable_disable_tab5(this);" <%=disable_fld%>></td>
	<td class='label' ><fmt:message key="Common.confirm.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='confirm_chk' id='confirm_chk' onclick="setValue_tab5(this);" disabled></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.ReplyLetter.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='rep_ltr_chk' id='rep_ltr_chk' onclick="setValue_tab5(this);enable_disable_tab5(this);" <%=disable_fld%> ></td>
	<td class='fileds' ><input type='text' name='rep_dtl_txt' id='rep_dtl_txt' size='20' maxlength='20' disabled></td>
	<td class='fileds' ><input type='text' name='rep_cnf_txt' id='rep_cnf_txt' size='20' maxlength='20' disabled></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.ClinicalDocFilm.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='cln_doc_chk' id='cln_doc_chk' onclick="setValue_tab5(this);enable_disable_tab5(this);" <%=disable_fld%> ></td>
	<td class='fileds' ><input type='text' name='cln_dtl_txt' id='cln_dtl_txt' size='20' maxlength='20' disabled></td>
	<td class='fileds' ><input type='text' name='cln_cnf_txt' id='cln_cnf_txt' size='20' maxlength='20' disabled></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='oth_doc_chk' id='oth_doc_chk' onclick="setValue_tab5(this);enable_disable_tab5(this);" <%=disable_fld%> >&nbsp;<input type='text' name='oth_doc_txt' id='oth_doc_txt' size='20' maxlength='20' disabled></td>
	<td class='fileds' ><input type='text' name='oth_dtl_txt1' id='oth_dtl_txt1' size='20' maxlength='20' disabled></td>
	<td class='fileds' ><input type='text' name='oth_cnf_txt1' id='oth_cnf_txt1' size='20' maxlength='20' disabled></td>
</tr>


<tr><td class='COLUMNHEADER' colspan='4'><fmt:message key="eIP.LeaveWardAccompaniedBy.label" bundle="${ip_labels}"/></td></tr>
<tr>
	<td class='label' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
	<td class='fileds' >
	<select name='relationship' id='relationship' <%=disable_fld%> >
	<option value='' selected>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
	<%
		try{	
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
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
	}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
	finally
	{
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}
	%>
	</select>
	</td>
	<td class='label' nowrap><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='text' name='rel_date_time' id='rel_date_time'  size='16' maxlength='16' onkeypress="return Valid_DT_tab5(event);" onBlur="chk_with_sysdate_tab5(this);" <%=disable_fld%>><input type="image" id="rel_date_time_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].rel_date_time.select();return showCalendar('rel_date_time',null,'hh:mm')"></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fileds' colspan=3><input type='text' name='rem_lv_ward' id='rem_lv_ward' size='100' maxlength='100' <%=disable_fld%> ></td>
</tr>
<tr>
	<td class='label' colspan=4></td>
</tr>
</table>
</tr>
</table>
</form>
<script>

document.forms[0].rel_date_time.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_rel_date_time.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_rel_date_time.value!='')
{
	document.forms[0].rel_date_time.disabled = true;
	document.getElementById("rel_date_time_img").disabled = true;
}
if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_relationship.value!='')
{
document.forms[0].relationship.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_relationship.value;
}
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_relationship.value!='')
document.forms[0].relationship.disabled = true;
 
document.forms[0].ref_ltr_chk.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_ref_ltr_chk.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_ref_ltr_chk.value == 'Y')
document.forms[0].ref_ltr_chk.checked = true;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_ref_ltr_chk.value != '')
document.forms[0].ref_ltr_chk.disabled = true;


document.forms[0].confirm_chk.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_confirm_chk.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_confirm_chk.value == 'Y')
document.forms[0].confirm_chk.checked = true;
if(document.forms[0].ref_ltr_chk.checked==true)
{
	if(document.forms[0].ref_ltr_chk.disabled==false)
	{
 
		document.forms[0].confirm_chk.disabled=false;
	}
}
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_confirm_chk.value != '')
document.forms[0].confirm_chk.disabled = true;


document.forms[0].rep_ltr_chk.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_rep_ltr_chk.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_rep_ltr_chk.value == 'Y')
document.forms[0].rep_ltr_chk.checked = true;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_rep_ltr_chk.value!='')
document.forms[0].rep_ltr_chk.disabled = true;

document.forms[0].rem_lv_ward.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_rem_lv_ward.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_rem_lv_ward.value!='')
document.forms[0].rem_lv_ward.disabled = true;


document.forms[0].rep_dtl_txt.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_rep_dtl_txt.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_rep_dtl_txt.value!='')
document.forms[0].rep_dtl_txt.disabled = true;

document.forms[0].rep_cnf_txt.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_rep_cnf_txt.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_rep_cnf_txt.value!='')
document.forms[0].rep_cnf_txt.disabled = true;

document.forms[0].cln_doc_chk.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_cln_doc_chk.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_cln_doc_chk.value == 'Y')
document.forms[0].cln_doc_chk.checked = true;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_cln_doc_chk.value != '')
document.forms[0].cln_doc_chk.disabled = true;


document.forms[0].cln_dtl_txt.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_cln_dtl_txt.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_cln_dtl_txt.value!='')
document.forms[0].cln_dtl_txt.disabled = true;

document.forms[0].cln_cnf_txt.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_cln_cnf_txt.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_cln_cnf_txt.value!='')
document.forms[0].cln_cnf_txt.disabled = true;

document.forms[0].oth_doc_chk.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_doc_chk.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_doc_chk.value == 'Y')
document.forms[0].oth_doc_chk.checked = true;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_doc_chk.value != '')
document.forms[0].oth_doc_chk.disabled = true;


document.forms[0].oth_dtl_txt1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_dtl_txt1.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_dtl_txt1.value!='')
document.forms[0].oth_dtl_txt1.disabled = true;

document.forms[0].oth_cnf_txt1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_cnf_txt1.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_cnf_txt1.value!='')
document.forms[0].oth_cnf_txt1.disabled = true;

document.forms[0].oth_cnf_txt1.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_cnf_txt1.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_cnf_txt1.value!='')
document.forms[0].oth_cnf_txt1.disabled = true;


document.forms[0].oth_doc_txt.value = parent.parent.DischargeCheckList_frame1.document.forms[0].h_oth_doc_txt.value;
if(parent.parent.DischargeCheckList_frame1.document.forms[0].hh_oth_doc_txt.value!='')
document.forms[0].oth_doc_txt.disabled = true;

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

