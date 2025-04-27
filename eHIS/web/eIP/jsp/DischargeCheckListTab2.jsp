<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,com.ehis.util.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle				= checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
Connection con				= null;
PreparedStatement pstmt		= null;
ResultSet rset				= null; 
String locale				= (String)session.getAttribute("LOCALE");
String facility_Id			= (String)session.getValue("facility_id");
String practitioner_name	= "";
String appl_user_name		= "";
String witness_name			= "";
String witness_id			= request.getParameter("witness_id")==null?"":request.getParameter("witness_id");
String witness_user			= request.getParameter("witness_user")==null?"":request.getParameter("witness_user");
String facility_id			= (String)session.getValue("facility_id");
String call_function		= request.getParameter("call_function")==null?"":request.getParameter("call_function");

String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
Boolean isChangesInAdditionalDtlsTabAppl = false;
String alignCenter = "";
/*End ML-MMOH-CRF-1142*/

//Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
Boolean isItemOnLoanOthersDisableDateAppl = false;
String disable_fld			= "";
if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
	disable_fld				= "disabled";
}

try
{
	con = ConnectionManager.getConnection(request);

	isChangesInAdditionalDtlsTabAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","DISCHRG_CHKLST_ADD_DTLS"); //Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
	isItemOnLoanOthersDisableDateAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "ADD_ITEMS_AND_DISBL_DATE"); //Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218

	if(!witness_id.equals(""))
	{

		//pstmt = con.prepareStatement("SELECT unique appl_user_name FROM sm_appl_user, pr_patient_valuables WHERE appl_user_id = witness_id and APPL_USER_ID = '"+witness_id+"' ");
		/*Wednesday, September 15, 2010, SRR20056-SCF-5169-IN023708*/
		pstmt = con.prepareStatement("SELECT sm_get_desc.sm_appl_user(witness_id,'"+locale+"',1) witness_name ,am_get_desc.am_practitioner(witness_id,'"+locale+"',1) pract_name FROM  pr_patient_valuables WHERE encounter_id='"+encounter_id+"' and patient_id='"+patient_id+"' and facility_id='"+facility_Id+"' ");

		rset = pstmt.executeQuery();
		if (rset.next())
		{
			witness_name	  = rset.getString(1) == null ? "" : rset.getString(1);
			if(witness_name.equals(""))
				practitioner_name = rset.getString(2)  == null ? "" : rset.getString(2);
			
			if(practitioner_name.equals(""))
				practitioner_name = witness_name ;
		}

		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
	}
	if(pstmt!=null)pstmt.close();
	if(rset!=null)rset.close();	

	if(!witness_user.equals(""))
	{
		
		pstmt = con.prepareStatement("select appl_user_name  from sm_appl_user_lang_vw where appl_user_id = '"+witness_user+"' and language_id = '"+locale+"'");
		rset = pstmt.executeQuery();
		if (rset.next())
		{
			appl_user_name = rset.getString(1);
		}
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();
	}
	if(pstmt!=null)pstmt.close();
	if(rset!=null)rset.close();

}catch(Exception e){out.println("Exception in tryCatch : "+ e.toString());}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>

<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script src='../../eCommon/js/DateUtils.js' language='javascript'></script>
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<Script src="../../eCommon/js/CommonLookup.js" language="JavaScript"></Script>
	<script src='../../eIP/js/DischargeCheckList.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



    

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='DischargeCheckListTab2' id='DischargeCheckListTab2'>
<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>

<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
<%if(isChangesInAdditionalDtlsTabAppl){
	 alignCenter = "align='center'";
}%>

<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
<%if(isChangesInAdditionalDtlsTabAppl){%>
<tr><td class='COLUMNHEADER' colspan=6><fmt:message key="Common.item.label" bundle="${common_labels}"/></td></tr>
<%}else{%>
<tr><td class='COLUMNHEADER' colspan=4><fmt:message key="eIP.RemovalOf.label" bundle="${ip_labels}"/></td></tr>
<%}%>

<tr>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='LABELCENTER' width='20%'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td class='LABELCENTER' width='10%'><fmt:message key="eIP.Keep.label" bundle="${ip_labels}"/></td>
	<td class='LABELCENTER' width='20%'><fmt:message key="Common.Remove.label" bundle="${common_labels}"/></td>
	<td class='LABELCENTER' width='30%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<%}else{%>
	<td class='LABELCENTER' width='40%'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
	<td class='label' width='40%'></td>
	<%}%>

	<!--Modified by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620-->
	<td class='LABELCENTER' width='30%'><fmt:message key="eIP.RemovedDoneby.label" bundle="${ip_labels}"/></td>
	<td class='LABELCENTER' width='30%'><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.IVCatheters.label" bundle="${ip_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='iv_catheters_chk' id='iv_catheters_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%> ></td>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='iv_remove_chk' id='iv_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='iv_remarks' id='iv_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds' ><input type='text' name='iv_removed_by' id='iv_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='iv_removed_dt' id='iv_removed_dt' id='ivremoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="iv_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].iv_removed_dt.select();return showCalendar('ivremoveddt',null,'hh:mm')" disabled></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.Tubes.label" bundle="${ip_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='tubes_chk' id='tubes_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%> ></td>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='tubes_remove_chk' id='tubes_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='tubes_remarks' id='tubes_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds' ><input type='text' name='tubes_removed_by' id='tubes_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='tubes_removed_dt' id='tubes_removed_dt' id='tubesremoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="tubes_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].tubes_removed_dt.select();return showCalendar('tubesremoveddt',null,'hh:mm')" disabled>
	</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.DrainageCatheters.label" bundle="${ip_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='drg_chk' id='drg_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%> ></td>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='drg_remove_chk' id='drg_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='drg_remarks' id='drg_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds' ><input type='text' name='drg_removed_by' id='drg_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='drg_removed_dt' id='drg_removed_dt' id='drgremoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="drg_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].drg_removed_dt.select();return showCalendar('drgremoveddt',null,'hh:mm')" disabled></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.NasogastricTube.label" bundle="${ip_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='ngt_tube_chk' id='ngt_tube_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%>></td>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='ngt_remove_chk' id='ngt_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='ngt_remarks' id='ngt_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds' ><input type='text' name='ngt_tube_removed_by' id='ngt_tube_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='ngt_tube_removed_dt' id='ngt_tube_removed_dt' id='ngttuberemoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="ngt_tube_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].ngt_tube_removed_dt.select();return showCalendar('ngttuberemoveddt',null,'hh:mm')" disabled>
	</td>
</tr>

<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
<%if(!isChangesInAdditionalDtlsTabAppl){%>
<tr>
	<td class='label' ><fmt:message key="eIP.ChangeofNasogastricTube.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='cngt_tube_chk' id='cngt_tube_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%>></td>
	<td class='fileds' ><input type='text' name='cngt_tube_removed_by' id='cngt_tube_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='cngt_tube_removed_dt' id='cngt_tube_removed_dt' id='cngttuberemoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="cngt_tube_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].cngt_tube_removed_dt.select();return showCalendar('cngttuberemoveddt',null,'hh:mm')" disabled>
	</td>
</tr>
<%}%>

<tr>
	<td class='label' ><fmt:message key="eIP.UrinaryCatheter.label" bundle="${ip_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='urn_chk' id='urn_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%>></td>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='urn_remove_chk' id='urn_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='urn_remarks' id='urn_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds' ><input type='text' name='urn_removed_by' id='urn_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='urn_removed_dt' id='urn_removed_dt' id='urnremoveddt' size='16' maxlength='16'disabled onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" ><input type="image" id="urn_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].urn_removed_dt.select();return showCalendar('urnremoveddt',null,'hh:mm')" disabled>
	</td>
</tr>

<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
<%if(!isChangesInAdditionalDtlsTabAppl){%>
<tr>
	<td class='label' ><fmt:message key="eIP.ChangeofUrinaryCatheter.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='curn_chk' id='curn_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%> ></td>
	<td class='fileds' ><input type='text' name='curn_removed_by' id='curn_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='curn_removed_dt' id='curn_removed_dt' id='curnremoveddt' size='16' maxlength='16' disabled onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" ><input type="image" id="curn_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].curn_removed_dt.select();return showCalendar('curnremoveddt',null,'hh:mm')" disabled>
	</td>
</tr>
<%}%>

<tr>
	<td class='label' ><fmt:message key="eIP.STO.label" bundle="${ip_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='sto_chk' id='sto_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%> ></td>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='sto_remove_chk' id='sto_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='sto_remarks' id='sto_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds' ><input type='text' name='sto_removed_by' id='sto_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='sto_removed_dt' id='sto_removed_dt' id='storemoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="sto_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].sto_removed_dt.select();return showCalendar('storemoveddt',null,'hh:mm')" disabled>
	</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.Dressing.label" bundle="${common_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='dressing_chk' id='dressing_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%>></td>
	<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='dressing_remove_chk' id='dressing_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='dressing_remarks' id='dressing_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds'> <input type='text' name='dressing_removed_by' id='dressing_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='dressing_removed_dt' id='dressing_removed_dt' id='dressingremoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="dressing_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].dressing_removed_dt.select();return showCalendar('dressingremoveddt',null,'hh:mm')" disabled></td>
</tr>
<!--Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->
<%if(isItemOnLoanOthersDisableDateAppl){%>
<tr>
	<td class='label' ><fmt:message key="eIP.ItemOnLoan.label" bundle="${ip_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='itemloan_chk' id='itemloan_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%>></td>
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='itemloan_remove_chk' id='itemloan_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='itemloan_remarks' id='itemloan_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds'> <input type='text' name='itemloan_removed_by' id='itemloan_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='itemloan_removed_dt' id='itemloan_removed_dt' id='itemloanremoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="itemloan_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].itemloan_removed_dt.select();return showCalendar('itemloanremoveddt',null,'hh:mm')" disabled></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.others.label" bundle="${common_labels}"/></td>
	<td class='fileds' <%=alignCenter%>><input type='checkbox' name='others_chk' id='others_chk' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%>></td>
	<%if(isChangesInAdditionalDtlsTabAppl){%>
	<td class='fileds' align='center'><input type='checkbox' name='others_remove_chk' id='others_remove_chk' onclick="setValue_tab2(this);enableDisableFields(this);" <%=disable_fld%>></td>
	<td class='fileds' align='center'><input type='text' name='others_remarks' id='others_remarks' size='30' maxlength='50' disabled></td>
	<%}%>
	<td class='fileds'> <input type='text' name='others_removed_by' id='others_removed_by' size='30' maxlength='30' disabled></td>
	<td class='fileds' ><input type='text' name='others_removed_dt' id='others_removed_dt' id='othersremoveddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="others_removed_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].others_removed_dt.select();return showCalendar('othersremoveddt',null,'hh:mm')" disabled></td>
</tr>
<%}%>
<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
<%if(isChangesInAdditionalDtlsTabAppl){%>
</table>
<table border="0" cellpadding="2" cellspacing="0" width="100%" align='center'>
<%}%>
<tr><td class='COLUMNHEADER' colspan=6><fmt:message key="eIP.Properties.label" bundle="${ip_labels}"/></td></tr>
<tr>
	<td class='label' ><fmt:message key="eIP.BelongingsReturned.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='blng_returned' id='blng_returned' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%> ></td>
	<td class='label' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='text' name='blng_returned_dt' id='blng_returned_dt' id='blngreturneddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="blng_returned_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].blng_returned_dt.select();return showCalendar('blngreturneddt',null,'hh:mm')" disabled></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td><td class='fileds' ><input type='text' name='blng_remarks' id='blng_remarks' size='30' maxlength='100' disabled></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eIP.ValuablesReturned.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='vlb_returned' id='vlb_returned' onclick="setValue_tab2(this);enable_disable_tab2(this);" disabled><a href ="javascript:showValuables_tab2()"><fmt:message key="Common.ViewDetails.label" bundle="${common_labels}"/></a></td>
	<td class='label' ><fmt:message key="Common.returnedby.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='text' name='vlb_returned_by' id='vlb_returned_by' size='20' maxlength='30' value="<%=appl_user_name%>" disabled><input type='button' class='button' name='user_search' id='user_search' value='?' onclick='displayUser_tab2(this,vlb_returned_by,vlb_user)' disabled><input type='hidden' name='vlb_user' id='vlb_user'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.Witness.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='text' name='vlb_witness' id='vlb_witness' size='20' maxlength='30' onBlur='getattndpract_tab2();' value="<%=practitioner_name%>" disabled><input type='button' class='button' name='pract_id_search' id='pract_id_search' value='?' onclick='callPractSearch_tab2(document.forms[0].pract_id_search,document.forms[0].vlb_witness);fixvaluespractitioner_tab2();' disabled ><input type='hidden' name='witness_id' id='witness_id'><input type='hidden' name='temp_desc' id='temp_desc'><input type='hidden' name='temp_physician_id' id='temp_physician_id'></td>
	<td class='label'></td>
	<td class='label'></td>
</tr>
<tr><td class='COLUMNHEADER' colspan=6><fmt:message key="eIP.Transport.label" bundle="${ip_labels}"/></td>
<tr>
	<td class='label' ><fmt:message key="eIP.TransportArranged.label" bundle="${ip_labels}"/></td>
	<td class='fileds' ><input type='checkbox' name='tp_arranged' id='tp_arranged' onclick="setValue_tab2(this);enable_disable_tab2(this);" <%=disable_fld%>></td>
	<td class='label' ><fmt:message key="Common.datetime.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='text' name='tp_returned_dt' id='tp_returned_dt' id='tpreturneddt' size='16' maxlength='16' onkeypress="return Valid_DT_tab2(event);" onBlur="chk_with_sysdate_tab2(this);" disabled><input type="image" id="tp_returned_dt_img" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].tp_returned_dt.select();return showCalendar('tpreturneddt',null,'hh:mm')" disabled></td>
</tr>
<tr>

	<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fileds' ><input type='text' name='tp_remarks' id='tp_remarks' size='30' maxlength='100' disabled></td>
	<td class='label' ></td>
	<td class='label' ></td>
</tr>
<!-- </tr>
<tr>
<td class='label' colspan=4></td></tr> -->
</table>
<!-- </td>
</tr>
</table> -->
<input type='hidden' name='facility' id='facility' value="<%=facility_id%>">
<input type='hidden' name='patient_id' id='patient_id' value="<%=patient_id%>">
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->
<input type='hidden' name='isChangesInAdditionalDtlsTabAppl' id='isChangesInAdditionalDtlsTabAppl' value="<%=isChangesInAdditionalDtlsTabAppl%>">
<!--Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->
<input type='hidden' name='isItemOnLoanOthersDisableDateAppl' id='isItemOnLoanOthersDisableDateAppl' value="<%=isItemOnLoanOthersDisableDateAppl%>">

</form>
<script>
document.forms[0].iv_catheters_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_catheters_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_iv_catheters_chk.value == 'Y')
document.forms[0].iv_catheters_chk.checked=true;


document.forms[0].iv_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_removed_by.value;


document.forms[0].iv_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_removed_dt.value;



document.forms[0].tubes_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_tubes_chk.value == 'Y')
document.forms[0].tubes_chk.checked=true;


document.forms[0].tubes_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_removed_by.value;


document.forms[0].tubes_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_removed_dt.value;


document.forms[0].drg_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_drg_chk.value == 'Y')
document.forms[0].drg_chk.checked = true;


document.forms[0].drg_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_removed_by.value;


document.forms[0].drg_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_removed_dt.value;

document.forms[0].ngt_tube_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_chk.value == 'Y')
document.forms[0].ngt_tube_chk.checked = true;

document.forms[0].ngt_tube_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_removed_by.value;

document.forms[0].ngt_tube_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_tube_removed_dt.value;

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false")
{
	document.forms[0].cngt_tube_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_chk.value == 'Y')
	document.forms[0].cngt_tube_chk.checked= true;

document.forms[0].cngt_tube_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_removed_by.value;

	document.forms[0].cngt_tube_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_cngt_tube_removed_dt.value;
}

document.forms[0].urn_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_urn_chk.value == 'Y')
document.forms[0].urn_chk.checked = true;

document.forms[0].urn_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_removed_by.value;

document.forms[0].urn_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_removed_dt.value;

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false")
{
	document.forms[0].curn_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_curn_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_curn_chk.value == 'Y')
	document.forms[0].curn_chk.checked = true;

document.forms[0].curn_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_curn_removed_by.value;

	document.forms[0].curn_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_curn_removed_dt.value;
}

document.forms[0].sto_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_sto_chk.value == 'Y')
document.forms[0].sto_chk.checked = true;

document.forms[0].sto_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_removed_by.value;

document.forms[0].sto_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_removed_dt.value;

document.forms[0].dressing_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_chk.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_dressing_chk.value == 'Y')
document.forms[0].dressing_chk.checked= true;

document.forms[0].dressing_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_removed_by.value;

document.forms[0].dressing_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_removed_dt.value;
/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
if(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == "true")
{
	document.forms[0].itemloan_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_chk.value == 'Y')
	document.forms[0].itemloan_chk.checked= true;
	document.forms[0].itemloan_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_removed_by.value;
	document.forms[0].itemloan_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_removed_dt.value;
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].itemloan_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_remove_chk.value;
		if(parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_remove_chk.value == 'Y')
		document.forms[0].itemloan_remove_chk.checked=true;
		document.forms[0].itemloan_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_itemloan_remarks.value;
	}
	document.forms[0].others_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_others_chk.value == 'Y')
	document.forms[0].others_chk.checked= true;
	document.forms[0].others_removed_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_removed_by.value;
	document.forms[0].others_removed_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_removed_dt.value;
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].others_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_remove_chk.value;
		if(parent.DischargeCheckList_frame1.document.forms[0].h_others_remove_chk.value == 'Y')
		document.forms[0].others_remove_chk.checked=true;
		document.forms[0].others_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_others_remarks.value;
	}
}

document.forms[0].blng_returned.value = parent.DischargeCheckList_frame1.document.forms[0].h_blng_returned.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_blng_returned.value == 'Y')
document.forms[0].blng_returned.checked = true;
 
document.forms[0].blng_returned_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_blng_returned_dt.value;

 
document.forms[0].blng_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_blng_remarks.value;
 
document.forms[0].vlb_returned.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_returned.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_vlb_returned.value == 'Y')
document.forms[0].vlb_returned.checked = true;
 
if(document.forms[0].vlb_returned_by.value=='')
document.forms[0].vlb_returned_by.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_returned_by.value;

if(document.forms[0].vlb_witness.value=='')
{
	document.forms[0].vlb_witness.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_witness.value;
}

document.forms[0].witness_id.value = parent.DischargeCheckList_frame1.document.forms[0].h_witness_id.value;
document.forms[0].vlb_user.value = parent.DischargeCheckList_frame1.document.forms[0].h_vlb_user.value;

 
document.forms[0].tp_arranged.value = parent.DischargeCheckList_frame1.document.forms[0].h_tp_arranged.value;
if(parent.DischargeCheckList_frame1.document.forms[0].h_tp_arranged.value == 'Y')
document.forms[0].tp_arranged.checked = true;

 
document.forms[0].tp_returned_dt.value = parent.DischargeCheckList_frame1.document.forms[0].h_tp_returned_dt.value;

 
document.forms[0].tp_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_tp_remarks.value;

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
{
	document.forms[0].iv_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_remove_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_iv_remove_chk.value == 'Y')
	document.forms[0].iv_remove_chk.checked=true;

	document.forms[0].iv_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_iv_remarks.value;	

	document.forms[0].tubes_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_remove_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_tubes_remove_chk.value == 'Y')
	document.forms[0].tubes_remove_chk.checked=true;

	document.forms[0].tubes_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_tubes_remarks.value;

	document.forms[0].drg_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_remove_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_drg_remove_chk.value == 'Y')
	document.forms[0].drg_remove_chk.checked=true;

	document.forms[0].drg_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_drg_remarks.value;

	document.forms[0].ngt_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_remove_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_ngt_remove_chk.value == 'Y')
	document.forms[0].ngt_remove_chk.checked=true;

	document.forms[0].ngt_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_ngt_remarks.value;

	document.forms[0].urn_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_remove_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_urn_remove_chk.value == 'Y')
	document.forms[0].urn_remove_chk.checked=true;

	document.forms[0].urn_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_urn_remarks.value;

	document.forms[0].sto_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_remove_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_sto_remove_chk.value == 'Y')
	document.forms[0].sto_remove_chk.checked=true;

	document.forms[0].sto_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_sto_remarks.value;

	document.forms[0].dressing_remove_chk.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_remove_chk.value;
	if(parent.DischargeCheckList_frame1.document.forms[0].h_dressing_remove_chk.value == 'Y')
	document.forms[0].dressing_remove_chk.checked=true;

	document.forms[0].dressing_remarks.value = parent.DischargeCheckList_frame1.document.forms[0].h_dressing_remarks.value;
}
/*End ML-MMOH-CRF-1142*/

</script>
<%
if(!call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
{
%>
<script>
if(document.forms[0].iv_catheters_chk.checked==true)	
{
		document.forms[0].iv_removed_by.disabled = false;
		document.forms[0].iv_removed_dt.disabled = false;
		document.getElementById('iv_removed_dt_img').disabled = false;
		/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
		if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
		{
			document.forms[0].iv_remove_chk.disabled = true;
			document.forms[0].iv_remarks.disabled = false;
		}
}

if(document.forms[0].tubes_chk.checked==true)	
{
	document.forms[0].tubes_removed_by.disabled = false;
	document.forms[0].tubes_removed_dt.disabled = false;
	document.getElementById('tubes_removed_dt_img').disabled = false;	
	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].tubes_remove_chk.disabled = true;
		document.forms[0].tubes_remarks.disabled = false;
	}
}

if(document.forms[0].drg_chk.checked==true)	
{
	document.forms[0].drg_removed_by.disabled = false;
	document.forms[0].drg_removed_dt.disabled = false;
	document.getElementById('drg_removed_dt_img').disabled = false;
	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].drg_remove_chk.disabled = true;
		document.forms[0].drg_remarks.disabled = false;
	}
}

if(document.forms[0].ngt_tube_chk.checked==true)	
{
	document.forms[0].ngt_tube_removed_by.disabled = false;
	document.forms[0].ngt_tube_removed_dt.disabled = false;
	document.getElementById('ngt_tube_removed_dt_img').disabled = false;	
	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].ngt_remove_chk.disabled = true;
		document.forms[0].ngt_remarks.disabled = false;
	}
}

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false")
{
	if(document.forms[0].cngt_tube_chk.checked==true)	
	{
		document.forms[0].cngt_tube_removed_by.disabled = false;
		document.forms[0].cngt_tube_removed_dt.disabled = false;
		document.getElementById('cngt_tube_removed_dt_img').disabled = false;	
	}
}

if(document.forms[0].urn_chk.checked==true)
{	
	document.forms[0].urn_removed_by.disabled = false;
	document.forms[0].urn_removed_dt.disabled = false;
	document.getElementById('urn_removed_dt_img').disabled = false;
	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].urn_remove_chk.disabled = true;
		document.forms[0].urn_remarks.disabled = false;
	}
}

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false")
{
	if(document.forms[0].curn_chk.checked==true)
	{
		document.forms[0].curn_removed_by.disabled = false;
		document.forms[0].curn_removed_dt.disabled = false;
		document.getElementById('curn_removed_dt_img').disabled = false;	
	}
}

if(document.forms[0].sto_chk.checked==true)
{
	document.forms[0].sto_removed_by.disabled = false;
	document.forms[0].sto_removed_dt.disabled = false;
	document.getElementById('sto_removed_dt_img').disabled = false;
	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].sto_remove_chk.disabled = true;
		document.forms[0].sto_remarks.disabled = false;
	}
}

if(document.forms[0].dressing_chk.checked==true)
{
	document.forms[0].dressing_removed_by.disabled = false;
	document.forms[0].dressing_removed_dt.disabled = false;
	document.getElementById('dressing_removed_dt_img').disabled = false;
	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
	{
		document.forms[0].dressing_remove_chk.disabled = true;
		document.forms[0].dressing_remarks.disabled = false;
	}
}

/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
if(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == "true")
{
	if(document.forms[0].itemloan_chk.checked==true)
	{
		document.forms[0].itemloan_removed_by.disabled = false;
		document.forms[0].itemloan_removed_dt.disabled = false;
		document.getElementById('itemloan_removed_dt_img').disabled = false;
		if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
		{
			document.forms[0].itemloan_remove_chk.disabled = true;
			document.forms[0].itemloan_remarks.disabled = false;
		}
	}
	if(document.forms[0].others_chk.checked==true)
	{
		document.forms[0].others_removed_by.disabled = false;
		document.forms[0].others_removed_dt.disabled = false;
		document.getElementById('others_removed_dt_img').disabled = false;
		if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
		{
			document.forms[0].others_remove_chk.disabled = true;
			document.forms[0].others_remarks.disabled = false;
		}
	}
}
if(document.forms[0].blng_returned.checked==true)
{
	document.forms[0].blng_returned_dt.disabled = false;
	document.getElementById('blng_returned_dt_img').disabled = false;
	document.forms[0].blng_remarks.disabled = false;
}

if(document.forms[0].vlb_returned.checked==true)
{
}

if(document.forms[0].tp_arranged.checked==true)
{
	document.forms[0].tp_returned_dt.disabled = false;
	document.getElementById("tp_returned_dt_img").disabled = false;
	document.forms[0].tp_remarks.disabled = false;
}

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
{
	if(document.forms[0].iv_remove_chk.checked==true)	
	{
		document.forms[0].iv_removed_by.disabled = false;
		document.forms[0].iv_removed_dt.disabled = false;
		document.getElementById('iv_removed_dt_img').disabled = false;
		document.forms[0].iv_catheters_chk.disabled = true;
		document.forms[0].iv_remarks.disabled = false;
	}

	if(document.forms[0].tubes_remove_chk.checked==true)	
	{
		document.forms[0].tubes_removed_by.disabled = false;
		document.forms[0].tubes_removed_dt.disabled = false;
		document.getElementById('tubes_removed_dt_img').disabled = false;	
		document.forms[0].tubes_chk.disabled = true;
		document.forms[0].tubes_remarks.disabled = false;
	}

	if(document.forms[0].drg_remove_chk.checked==true)	
	{
		document.forms[0].drg_removed_by.disabled = false;
		document.forms[0].drg_removed_dt.disabled = false;
		document.getElementById('drg_removed_dt_img').disabled = false;
		document.forms[0].drg_chk.disabled = true;
		document.forms[0].drg_remarks.disabled = false;
	}

	if(document.forms[0].ngt_remove_chk.checked==true)	
	{
		document.forms[0].ngt_tube_removed_by.disabled = false;
		document.forms[0].ngt_tube_removed_dt.disabled = false;
		document.getElementById('ngt_tube_removed_dt_img').disabled = false;
		document.forms[0].ngt_tube_chk.disabled = true;
		document.forms[0].ngt_remarks.disabled = false;
	}

	if(document.forms[0].urn_remove_chk.checked==true)
	{	
		document.forms[0].urn_removed_by.disabled = false;
		document.forms[0].urn_removed_dt.disabled = false;
		document.getElementById('urn_removed_dt_img').disabled = false;
		document.forms[0].urn_chk.disabled = true;
		document.forms[0].urn_remarks.disabled = false;
	}

	if(document.forms[0].sto_remove_chk.checked==true)
	{
		document.forms[0].sto_removed_by.disabled = false;
		document.forms[0].sto_removed_dt.disabled = false;
		document.getElementById('sto_removed_dt_img').disabled = false;
		document.forms[0].sto_chk.disabled = true;
		document.forms[0].sto_remarks.disabled = false;
	}

	if(document.forms[0].dressing_remove_chk.checked==true)
	{
		document.forms[0].dressing_removed_by.disabled = false;
		document.forms[0].dressing_removed_dt.disabled = false;
		document.getElementById('dressing_removed_dt_img').disabled = false;
		document.forms[0].dressing_chk.disabled = true;
		document.forms[0].dressing_remarks.disabled = false;
	}
	/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
	if(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == "true")
	{
		if(document.forms[0].itemloan_remove_chk.checked==true)
		{
			document.forms[0].itemloan_removed_by.disabled = false;
			document.forms[0].itemloan_removed_dt.disabled = false;
			document.getElementById('itemloan_removed_dt_img').disabled = false;
			document.forms[0].itemloan_chk.disabled = true;
			document.forms[0].itemloan_remarks.disabled = false;
		}
		if(document.forms[0].others_remove_chk.checked==true)
		{
			document.forms[0].others_removed_by.disabled = false;
			document.forms[0].others_removed_dt.disabled = false;
			document.getElementById('others_removed_dt_img').disabled = false;
			document.forms[0].others_chk.disabled = true;
			document.forms[0].others_remarks.disabled = false;
		}
	}
}
/*End ML-MMOH-CRF-1142*/

if(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_catheters_chk.value != '')
document.forms[0].iv_catheters_chk.disabled=true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_removed_by.value !='')
document.forms[0].iv_removed_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_removed_dt.value !='')
{
	document.forms[0].iv_removed_dt.disabled = true;
	document.getElementById('iv_removed_dt_img').disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_chk.value != '')
document.forms[0].tubes_chk.disabled=true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_removed_by.value !='')
document.forms[0].tubes_removed_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_removed_dt.value != '')
{
	document.forms[0].tubes_removed_dt.disabled = true;
	document.getElementById('tubes_removed_dt_img').disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_chk.value == 'Y')
document.forms[0].drg_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_removed_by.value != '')
document.forms[0].drg_removed_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_removed_dt.value != '')
{
	document.forms[0].drg_removed_dt.disabled = true;
	document.getElementById('drg_removed_dt_img').disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_tube_chk.value != '')
document.forms[0].ngt_tube_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_tube_removed_by.value != '')
document.forms[0].ngt_tube_removed_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_tube_removed_dt.value !='')
{
	document.forms[0].ngt_tube_removed_dt.disabled = true;
	document.getElementById('ngt_tube_removed_dt_img').disabled = true;
}

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false")
{
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_cngt_tube_chk.value != '')
	document.forms[0].cngt_tube_chk.disabled= true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_cngt_tube_removed_by.value != '')
	document.forms[0].cngt_tube_removed_by.disabled = true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_cngt_tube_removed_dt.value != '')
	{
		document.forms[0].cngt_tube_removed_dt.disabled = true;
		document.getElementById('cngt_tube_removed_dt_img').disabled = true;
	}
}

if(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_chk.value != '')
document.forms[0].urn_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_removed_by.value!='')
document.forms[0].urn_removed_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_removed_dt.value != '')
{
	document.forms[0].urn_removed_dt.disabled = true;
	document.getElementById('urn_removed_dt_img').disabled = true;
}

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "false")
{
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_curn_chk.value != '')
	document.forms[0].curn_chk.disabled = true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_curn_removed_by.value != '')
	document.forms[0].curn_removed_by.disabled = true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_curn_removed_dt.value != '')
	{
		document.forms[0].curn_removed_dt.disabled = true;
		document.getElementById('curn_removed_dt_img').disabled = true;
	}
}

if(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_chk.value != '')
document.forms[0].sto_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_removed_by.value != '')
document.forms[0].sto_removed_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_removed_dt.value != '')
{
	document.forms[0].sto_removed_dt.disabled = true;
	document.getElementById('sto_removed_dt_img').disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_chk.value != '')
document.forms[0].dressing_chk.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_removed_by.value != '')
document.forms[0].dressing_removed_by.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_removed_dt.value!='')
{
	document.forms[0].dressing_removed_dt.disabled = true;
	document.getElementById('dressing_removed_dt_img').disabled = true;
}
/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
if(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == "true")
{
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_chk.value != '')
	document.forms[0].itemloan_chk.disabled = true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_removed_by.value != '')
	document.forms[0].itemloan_removed_by.disabled = true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_removed_dt.value!='')
	{
		document.forms[0].itemloan_removed_dt.disabled = true;
		document.getElementById('itemloan_removed_dt_img').disabled = true;
	}
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_others_chk.value != '')
	document.forms[0].others_chk.disabled = true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_others_removed_by.value != '')
	document.forms[0].others_removed_by.disabled = true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_others_removed_dt.value!='')
	{
		document.forms[0].others_removed_dt.disabled = true;
		document.getElementById('others_removed_dt_img').disabled = true;
	}
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_blng_returned.value == 'Y')
document.forms[0].blng_returned.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_blng_returned_dt.value != '')
{
	document.forms[0].blng_returned_dt.disabled = true;
	document.getElementById('blng_returned_dt_img').disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_blng_remarks.value != '')
document.forms[0].blng_remarks.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_tp_arranged.value != '')
document.forms[0].tp_arranged.disabled = true;
if(parent.DischargeCheckList_frame1.document.forms[0].hh_tp_returned_dt.value!='')
{
	document.forms[0].tp_returned_dt.disabled = true;
	document.getElementById("tp_returned_dt_img").disabled = true;
}
if(parent.DischargeCheckList_frame1.document.forms[0].hh_tp_remarks.value!='')
document.forms[0].tp_remarks.disabled = true;

/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
if(document.forms[0].isChangesInAdditionalDtlsTabAppl.value == "true")
{
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_remove_chk.value != '')
	document.forms[0].iv_remove_chk.disabled=true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_iv_remarks.value !='')
	document.forms[0].iv_remarks.disabled = true;

	if(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_remove_chk.value != '')
	document.forms[0].tubes_remove_chk.disabled=true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_tubes_remarks.value !='')
	document.forms[0].tubes_remarks.disabled = true;

	if(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_remove_chk.value != '')
	document.forms[0].drg_remove_chk.disabled=true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_drg_remarks.value !='')
	document.forms[0].drg_remarks.disabled = true;

	if(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_remove_chk.value != '')
	document.forms[0].ngt_remove_chk.disabled=true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_ngt_remarks.value !='')
	document.forms[0].ngt_remarks.disabled = true;

	if(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_remove_chk.value != '')
	document.forms[0].urn_remove_chk.disabled=true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_urn_remarks.value !='')
	document.forms[0].urn_remarks.disabled = true;

	if(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_remove_chk.value != '')
	document.forms[0].sto_remove_chk.disabled=true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_sto_remarks.value !='')
	document.forms[0].sto_remarks.disabled = true;

	if(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_remove_chk.value != '')
	document.forms[0].dressing_remove_chk.disabled=true;
	if(parent.DischargeCheckList_frame1.document.forms[0].hh_dressing_remarks.value !='')
	document.forms[0].dressing_remarks.disabled = true;
	/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
	if(document.forms[0].isItemOnLoanOthersDisableDateAppl.value == "true")
	{
		if(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_remove_chk.value != '')
		document.forms[0].itemloan_remove_chk.disabled=true;
		if(parent.DischargeCheckList_frame1.document.forms[0].hh_itemloan_remarks.value !='')
		document.forms[0].itemloan_remarks.disabled = true;
		if(parent.DischargeCheckList_frame1.document.forms[0].hh_others_remove_chk.value != '')
		document.forms[0].others_remove_chk.disabled=true;
		if(parent.DischargeCheckList_frame1.document.forms[0].hh_others_remarks.value !='')
		document.forms[0].others_remarks.disabled = true;
	}
}
/*End ML-MMOH-CRF-1142*/

</script>
<%}%>
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

