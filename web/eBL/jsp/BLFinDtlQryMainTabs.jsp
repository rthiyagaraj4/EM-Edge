<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");	
	Connection con				= null;
	String strAllParam = "", strBillGrpId="", strPatientId="", strEncounterDate="", str_valid_pkg_for_pat_avail_YN="N",str_valid_pkg_for_pat_enc_avail_YN="N";
	String strEpisodeId="", strVisitId="", strEpisodeType="";
	String fin_class_flag_YN="N";

	try
	{
		strAllParam = request.getQueryString();
		if(strAllParam == null) strAllParam="";

		strBillGrpId = request.getParameter("strBillGrpId");
		if(strBillGrpId == null) strBillGrpId="";

		strPatientId = request.getParameter("strPatientId");
		if(strPatientId == null) strPatientId="";

		strEpisodeId = request.getParameter("episodeid");
		if(strEpisodeId == null) strEpisodeId="";

		strVisitId = request.getParameter("visitid");
		if(strVisitId == null) strVisitId="";

		strEpisodeType = request.getParameter("episodetype");
		if(strEpisodeType == null) strEpisodeType="";

		strEncounterDate = request.getParameter("strEncRegDate");
		if(strEncounterDate == null) strEncounterDate="";

		str_valid_pkg_for_pat_avail_YN = request.getParameter("valid_pkg_for_pat_avail_YN");
		if(str_valid_pkg_for_pat_avail_YN == null) str_valid_pkg_for_pat_avail_YN="N";

		str_valid_pkg_for_pat_enc_avail_YN = request.getParameter("valid_pkg_for_pat_enc_avail_YN");
		if(str_valid_pkg_for_pat_enc_avail_YN == null) str_valid_pkg_for_pat_enc_avail_YN="N";

		fin_class_flag_YN= request.getParameter("fin_class_flag_YN");
		if(fin_class_flag_YN == null) fin_class_flag_YN="";

%>	
<html>
	<head>
<%	
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>	
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>


<script>

function tab_change(obj,cald_for)
{
	var params = document.forms[0].params.value;
	var patient_id = document.forms[0].patient_id.value;
	var blng_grp_id = document.forms[0].blng_grp_id.value;
	var encounter_date = document.forms[0].encounter_date.value;
	var episode_type = document.forms[0].episode_type.value;
	var episode_id = document.forms[0].episode_id.value;
	var visit_id = document.forms[0].visit_id.value;

	var fin_class_flag_YN = document.forms[0].fin_class_flag_YN.value;
	var valid_pkg_for_pat_avail_YN = document.forms[0].valid_pkg_for_pat_avail_YN.value;
	var valid_pkg_for_pat_enc_avail_YN = document.forms[0].valid_pkg_for_pat_enc_avail_YN.value;
	
	document.getElementById('fin_dtl_tab').className = "tabA";
	document.getElementById('FinancialDetails').className = "tabAspan";

	if(fin_class_flag_YN == "Y")
	{
		document.getElementById('fin_class_tab').className = "tabA";
		document.getElementById('FinancialClass').className = "tabAspan";
	}

	if(valid_pkg_for_pat_avail_YN == "Y")
	{
		document.getElementById('open_pkg_tab').className = "tabA";
		document.getElementById('OpenPackageDtls').className = "tabAspan";
	}

	if(valid_pkg_for_pat_enc_avail_YN == "Y")
	{
		document.getElementById('enc_avail_pkg_tab').className = "tabA";
		document.getElementById('EncAvailedPackageDtls').className = "tabAspan";
	}

	if(cald_for == "C")
	{
		document.getElementById('fin_class_tab').className = "tabClicked";
		document.getElementById('FinancialClass').className = "tabSpanclicked";
	}
	else if(cald_for == "F")
	{
		document.getElementById('fin_dtl_tab').className = "tabClicked";
		document.getElementById('FinancialDetails').className = "tabSpanclicked";
	}
	else if(cald_for == "P")
	{
		document.getElementById('open_pkg_tab').className = "tabClicked";
		document.getElementById('OpenPackageDtls').className = "tabSpanclicked";
	}
	else if(cald_for == "E")
	{
		document.getElementById('enc_avail_pkg_tab').className = "tabClicked";
		document.getElementById('EncAvailedPackageDtls').className = "tabSpanclicked";
	}

	/*
	var obj_id=obj.id;
	cellref = document.getElementById('tab').rows[0].cells;
	for(i=0; i<cellref.length; i++)
	{
		alert(cellref[i].id);
		if(cellref[i].id == 'FinancialClassDetails' || cellref[i].id == 'FinancialDetails' || cellref[i].id == 'PatPackageDetails' || cellref[i].id == 'EncPackageDetails')
		{
			if(cellref[i].id == obj_id)
			{
				cellref[i].className='TDCLICKED';
			}
			else
			{
				cellref[i].className='TDNORMAL';
			}
		}
	}
	*/
	
	if(cald_for == 'C')
	{
		parent.frames[1].location.href = "../../eBL/jsp/BLFinDtlQryMainFrames.jsp?"+params+"&strCaldFrmClassFinDtls=C";
	}
	else if(cald_for == 'F')
	{
		parent.frames[1].location.href = "../../eBL/jsp/BLFinDtlQryMainFrames.jsp?"+params+"&strCaldFrmClassFinDtls=F";
	}
	else if (cald_for == 'P')
	{
		parent.frames[1].location.href = "../../eBL/jsp/BLViewTrmtPkgDtlsMain.jsp?patient_id="+patient_id+"&blng_grp_id="+blng_grp_id+"&encounter_date="+encounter_date+"&cald_for_is=P&cald_frm=VW";
	}
	else if (cald_for == 'E')
	{
		parent.frames[1].location.href = "../../eBL/jsp/BLViewTrmtPkgDtlsMain.jsp?patient_id="+patient_id+"&blng_grp_id="+blng_grp_id+"&encounter_date="+encounter_date+"&episode_type="+episode_type+"&episode_id="+episode_id+"&visit_id="+visit_id+"&cald_for_is=E&cald_frm=VW";
	}
}

function onload_tab_sel(class_YN)
{
	var params = document.forms[0].params.value;

	if(class_YN =="Y")
	{
		parent.frames[1].location.href = "../../eBL/jsp/BLFinDtlQryMainFrames.jsp?"+params+"&strCaldFrmClassFinDtls=C";
	}
	else
	{
		parent.frames[1].location.href = "../../eBL/jsp/BLFinDtlQryMainFrames.jsp?"+params+"&strCaldFrmClassFinDtls=F";
	}
}
</script>	
<BODY onLoad="onload_tab_sel('<%=fin_class_flag_YN%>')" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();">
	<FORM name='' id='' action="" method='post'>
	  <TABLE border='0' cellpadding='3' cellspacing='1' align='center' width='100%' id='tab'>

<!--	  <tr>

<%
//		if(fin_class_flag_YN.equals("Y"))
//		{
%>
  		<td id='FinancialClassDetails' class="TDCLICKED" border='3' align='left' onclick="tab_change(this,'C');"><a style='color:white;cursor:pointer' ><fmt:message key="eBL.FIN_CLASS.label" bundle="${bl_labels}"/></a></td>
<%
//		}
%>
  		<td id='FinancialDetails' class="TDNORMAL" border='3' align='left' onclick="tab_change(this,'F');"><a style='color:white;cursor:pointer' ><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></a></td>
<%
//	if(str_valid_pkg_for_pat_avail_YN.equals("Y"))
//	{
%>
		<td id='PatPackageDetails' class="TDNORMAL" border='3' align='left'  onclick="tab_change(this,'P');"><a style='color:white;cursor:pointer'><fmt:message key="eBL.SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></a></td>
<%
//	}
//	if(str_valid_pkg_for_pat_enc_avail_YN.equals("Y"))
//	{
%>
		<td id='EncPackageDetails' class="TDNORMAL" border='3' align='left'  onclick="tab_change(this,'E');"><a style='color:white;cursor:pointer'><fmt:message key="eBL.AVAILD_PACK_DTLS.label" bundle="${bl_labels}"/></a></td>
<%
//	}
%>
	  </tr>
-->
	<tr>
		<td width= "100%" class="white">
			<ul id="tablist" class="tablist" style='padding-left:0px'>
<%
		if(fin_class_flag_YN.equals("Y"))
		{
%>
				<li class="tablistitem" title='<fmt:message key="eBL.FIN_CLASS.label" bundle="${bl_labels}"/>'>
					<a onclick="tab_change('fin_class_tab','C')" class="tabClicked" id="fin_class_tab" >
						<span class="tabSpanclicked" id="FinancialClass"><fmt:message key="eBL.FIN_CLASS.label" bundle="${bl_labels}"/></span>
					</a>
				</li>

				<li class="tablistitem" title='<fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/>'>
					<a onclick="tab_change('fin_dtl_tab','F')" class="tabA" id="fin_dtl_tab">
					<span class="tabAspan" id="FinancialDetails"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
<%
		}
		else
		{
%>
				<li class="tablistitem" title='<fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/>'>
					<a onclick="tab_change('fin_dtl_tab','F')" class="tabClicked" id="fin_dtl_tab">
					<span class="tabSpanclicked" id="FinancialDetails"><fmt:message key="Common.financialdetails.label" bundle="${common_labels}"/></span>
					</a>
				</li>
<%
		}
%>

<%
		if(str_valid_pkg_for_pat_avail_YN.equals("Y"))
		{
%>
				<li class="tablistitem" title='<fmt:message key="eBL.SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/>'>
					<a onclick="tab_change('open_pkg_tab','P')" class="tabA" id="open_pkg_tab">
					<span class="tabAspan" id="OpenPackageDtls"><fmt:message key="eBL.SUBS_OPEN_PACKAGE_DTL.label" bundle="${bl_labels}"/></span>
					</a>
				</li>
<%
		}
		if(str_valid_pkg_for_pat_enc_avail_YN.equals("Y"))
		{
%>
				<li class="tablistitem" title='<fmt:message key="eBL.AVAILD_PACK_DTLS.label" bundle="${bl_labels}"/>'>
					<a onclick="tab_change('enc_avail_pkg_tab','E')" class="tabA" id="enc_avail_pkg_tab">
					<span class="tabAspan" id="EncAvailedPackageDtls"><fmt:message key="eBL.AVAILD_PACK_DTLS.label" bundle="${bl_labels}"/></span>
					</a>
				</li>
<%
		}
%>
			</ul>
		</tr>

</TABLE>
<input type='hidden' name='params' id='params' value="<%=strAllParam%>">
<input type='hidden' name='patient_id' id='patient_id' value='<%=strPatientId%>'>
<input type='hidden' name='blng_grp_id' id='blng_grp_id' value='<%=strBillGrpId%>'>
<input type='hidden' name='encounter_date' id='encounter_date' value='<%=strEncounterDate%>'>
<input type='hidden' name='episode_type' id='episode_type' value='<%=strEpisodeType%>'>
<input type='hidden' name='episode_id' id='episode_id' value='<%=strEpisodeId%>'>
<input type='hidden' name='visit_id' id='visit_id' value='<%=strVisitId%>'>

<input type='hidden' name='fin_class_flag_YN' id='fin_class_flag_YN' value='<%=fin_class_flag_YN%>'>
<input type='hidden' name='valid_pkg_for_pat_avail_YN' id='valid_pkg_for_pat_avail_YN' value='<%=str_valid_pkg_for_pat_avail_YN%>'>
<input type='hidden' name='valid_pkg_for_pat_enc_avail_YN' id='valid_pkg_for_pat_enc_avail_YN' value='<%=str_valid_pkg_for_pat_enc_avail_YN%>'>

</FORM>
</BODY>	
</HTML>
<%
	}
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{	
		ConnectionManager.returnConnection(con, request);
	}
%> 

