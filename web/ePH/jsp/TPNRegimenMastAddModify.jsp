<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimenMast.js"></SCRIPT>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
function tab_click2(id)
{


	selectTab(id);
	
	showTabDetail(id);
}
</script>
</HEAD>

<!-- <BODY TOPMARGIN="0" onKeyDown="lockKey()" onload="chkValue()" onMouseDown="CodeArrest()"> -->
<body TOPMARGIN="0" onMouseDown="" onKeyDown="lockKey()" onload="chkValue()">

<%
	/* Mandatory checks start */
	String mode			= request.getParameter("mode");
	String bean_id		= "TPNRegimenMastBean";
	String bean_name	= "ePH.TPNRegimenMastBean";
    String drug_item_code_ind = "";
	String regimen_code_visible = "";
	String item_code_man_visible = "visibility:hidden";
	String item_code_lookup		 = "";
//	String standard_regimen_yn	 = "";
  //added for ml-mmoh-crf-1290 start
	boolean tpn_tab_reg = false;//ML-MMOH-CRF-1290
	Connection	con=null;
	try{
		con	= ConnectionManager.getConnection(request);
		tpn_tab_reg          =eCommon.Common.CommonBean.isSiteSpecific(con, "PH","INSTRUCTIONS_REQUIRED_YN");//ADDED FOR ML-MMOH-CRF-1290
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		con.close();
	}
	//added for ml-mmoh-crf-1290 end
	if (mode == null || mode.equals(""))
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	TPNRegimenMastBean bean	= (TPNRegimenMastBean)getBeanObject(bean_id,bean_name,request);
	bean.clear();
	bean.setLanguageId(locale);
	bean.setMode(mode);
	bean.setTotalEnergy("");
	bean.setLipidEmulsion("");
	bean.setNpcRatioBean("");
	drug_item_code_ind = bean.getDrugItemCodeIndicator();
	if(drug_item_code_ind == null) drug_item_code_ind = "";
	if(drug_item_code_ind.equals("S")){
		regimen_code_visible	= "disabled";
		item_code_man_visible   = "visibility:visible";
	}else if(drug_item_code_ind.equals("X")){
		item_code_lookup = "disabled";
		item_code_man_visible   = "visibility:hidden";
	}
	/* Initialize Function specific end */

	String pres_base_uom		= "";
	String pres_base_uom_desc	= "";
	StringTokenizer stoken		= new StringTokenizer(bean.getPrescBaseUOM(), "|");

	while (stoken.hasMoreTokens()) {
		pres_base_uom_desc	= stoken.nextToken();
		pres_base_uom		= stoken.nextToken();
	}

	String tpn_regimen_code			= "";
	String single_emulsion_status	= "";
	String single_emulsion_value	= "N";
	String short_name				= "";
	String long_name				= "";
	String dflt_tpn_route			= "";
	String item_code				= "";
	String single_emulsion			= "";
	String regimen_status			= "";
	boolean	or_status				= false;
	String std_result				=	"";
	String disable_all_fields		=	"";
	String ppn						=  "";
	String ppn_status				= "";
	String ppn_value				= "N";
	String pead_tpn_regimen_yn		= "";
	String pead_tpn_regimen_yn_status	= "";
	String pead_tpn_regimen_yn_value	= "";
	String overage_volume			= "";
	String item_code_man_invisible	= "";


	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		tpn_regimen_code	= request.getParameter("tpn_regimen_code");
		bean.getTotalEnergy(tpn_regimen_code);
		bean.setLipidEmlBean(tpn_regimen_code);
		bean.setNpcRatioBean(tpn_regimen_code);

		or_status			= bean.getDrugStatusInOR(tpn_regimen_code);
		bean.loadRegimenValues(tpn_regimen_code);

		std_result	=	bean.checkStandardRegimen(tpn_regimen_code);

		if(std_result.equals("N")) {
			disable_all_fields	=	"disabled";
			item_code_man_invisible   = "visibility:hidden";
		}

		HashMap	header = bean.getHeader();
		if(header.size()!=0) {
		
			short_name		= (String)header.get("short_name");
			long_name		= (String)header.get("long_name");
			dflt_tpn_route	= (String)header.get("dflt_tpn_route");
			item_code		= (String)header.get("item_code");
			single_emulsion	= (String)header.get("single_emulsion");
			ppn				= (String)header.get("ppn");
			pead_tpn_regimen_yn	= (String)header.get("pead_tpn_regimen_yn");
			overage_volume	= (String)header.get("overage_volume");

			regimen_status	= "disabled";
			if(single_emulsion.equals("Y")) {
				single_emulsion_status	= "checked";
				single_emulsion_value	= "Y";
			}
			if(ppn.equals("Y")) {
				ppn_status	= "checked";
				ppn_value	= "Y";
			}

			if(pead_tpn_regimen_yn.equals("Y")) {
				pead_tpn_regimen_yn_status= "checked";
				pead_tpn_regimen_yn_value	= "Y";
			}



		}

	}

%>
 
<FORM name="TPNRegimenMastForm" id="TPNRegimenMastForm" >
<INPUT TYPE="hidden" name="std_result" id="std_result" VALUE="<%=std_result%>">
<INPUT TYPE="hidden" name="drug_item_code_ind" id="drug_item_code_ind" VALUE="<%=drug_item_code_ind%>">
<INPUT TYPE="hidden" name="curr_tab" id="curr_tab" VALUE="">
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD ALIGN="right" WIDTH="17%" CLASS="label" name="stdreg"><fmt:message key="ePH.StandardRegimen.label" bundle="${ph_labels}"/></TD>
		<% if(std_result.equals("N")) {	%>
<!--
<TD ALIGN="left" WIDTH="40%"><INPUT TYPE="checkbox" name="standard_regimen_yn" id="standard_regimen_yn" DISABLED VALUE="N">
-->
<TD ALIGN="left" WIDTH="17%"><INPUT TYPE="checkbox" name="standard_regimen_yn" id="standard_regimen_yn" <%=disable_all_fields%> VALUE="N" onClick="enableValue(this)"></td>
		<%	
		 }	else	{ %>
<!--
<TD ALIGN="left" WIDTH="40%"><INPUT TYPE="checkbox" name="standard_regimen_yn" id="standard_regimen_yn" CHECKED DISABLED VALUE="Y">
--> 
<TD ALIGN="left" WIDTH="17%"><INPUT TYPE="checkbox" name="standard_regimen_yn" id="standard_regimen_yn" CHECKED <%=disable_all_fields%> VALUE="Y" onClick="enableValue(this)"> </td>

		<%	
		}	%>&nbsp;&nbsp;&nbsp;&nbsp;<TD ALIGN="left" WIDTH="10%"> <FONT SIZE="" COLOR="" class="label" ><fmt:message key="ePH.PPN.label" bundle="${ph_labels}"/></FONT>&nbsp;<INPUT TYPE="checkbox" name="ppn" id="ppn" onClick="assignValue(this)" <%=ppn_status%> VALUE="<%=ppn_value%>" <%=disable_all_fields%>></td><td ALIGN="left" WIDTH="20%" CLASS="label"><div id="pedReg"> Pediatric Regimen&nbsp;<INPUT TYPE="checkbox" name="pead_tpn_regimen_yn" id="pead_tpn_regimen_yn" onClick="assignValue(this)" <%=pead_tpn_regimen_yn_status%> VALUE="<%=pead_tpn_regimen_yn_value%>" >
		</TD></div>

		<TD ALIGN="right" WIDTH="14%" CLASS="label"><fmt:message key="ePH.RegimenCode.label" bundle="${ph_labels}"/>&nbsp;</TD>
 
		<TD ALIGN="left"><INPUT TYPE="text" CLASS="UPPER" name="tpn_regimen_code" id="tpn_regimen_code" MAXLENGTH="20" SIZE="20" VALUE="<%=tpn_regimen_code%>" <%=regimen_status%> <%=disable_all_fields%> onKeyPress="return CheckForSpecChars(event);" onBlur="validateCode(this); this.value=this.value.toUpperCase();checkSplChars(this, '1')" <%=regimen_code_visible%> >&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN="center"></TD><%
%>
	</TR>
	</TABLE>
	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR> 
		<TD ALIGN="right" WIDTH="21%" CLASS="label"><fmt:message key="Common.longname.label" bundle="${common_labels}"/>
		&nbsp;&nbsp;&nbsp;<INPUT TYPE="text" name="long_name" id="long_name" MAXLENGTH="40" SIZE="40" VALUE="<%=long_name%>" >&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN="center"></td>
		<TD ALIGN="left" WIDTH="20%" CLASS="label"><div id="overegVol">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <fmt:message key="ePH.OverageVolume.label" bundle="${ph_labels}"/> &nbsp;<INPUT TYPE="text" name="overage_volume" id="overage_volume" MAXLENGTH="2" SIZE="2" onKeyPress="return(ChkNumberInput(this,event,'1'))" VALUE="<%=overage_volume%>" >&nbsp;<fmt:message key="Common.ml.label" bundle="${common_labels}"/></TD></div>
				
		<!-- <TD ALIGN="right" WIDTH="1%" CLASS="label">Short Name </TD>
		<TD ALIGN="left" WIDTH="1%" <%=disable_all_fields%>>&nbsp; <INPUT TYPE="hidden" name="short_name" id="short_name" MAXLENGTH="15" SIZE="15" VALUE="<%=short_name%>">&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" style='visibility:hidden'ALIGN="center"></TD>  -->

	</TR>
	</TABLE>
<%
//if(!tpn_regimen_code.equals("NON_STANDARD")){
	%>
	<TABLE CELLPADDING="0" CELLSPACING="4" WIDTH="100%" ALIGN="center" BORDER="0">
	<TR>
		<TD ALIGN="left" WIDTH="33%" CLASS="label"><fmt:message key="ePH.InfusionLine.label" bundle="${ph_labels}"/>
		&nbsp;&nbsp;<SELECT name="dflt_tpn_route" id="dflt_tpn_route" >   
				<OPTION>&nbsp;&nbsp;&nbsp;---<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>---&nbsp;&nbsp;&nbsp;</OPTION>

<%
	if(dflt_tpn_route.equals("C")) {
%>

		<OPTION VALUE="C" SELECTED><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="P"><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
<%
	}
	else if(dflt_tpn_route.equals("P")) {
%>

		<OPTION VALUE="C"><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="P" SELECTED><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>

<%	}
	else {
%>

		<OPTION VALUE="C"><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
		<OPTION VALUE="P"><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>

<%
	}
%>

		</SELECT>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN="center">
		</TD>
		<TD ALIGN="right" WIDTH="38%" CLASS="label"><fmt:message key="ePH.SingleEmulsion.label" bundle="${ph_labels}"/></TD>
		<TD ALIGN="left" WIDTH="23%" CLASS="label">&nbsp;<INPUT TYPE="checkbox" name="single_emulsion" id="single_emulsion" onClick="assignValue(this)" <%=single_emulsion_status%>  VALUE="<%=single_emulsion_value%>" <%=disable_all_fields%>></TD>
	</TR> 
	<%if(!tpn_regimen_code.equals("NON_STANDARD")) {%>
	<TR>

		<TD ALIGN="right" WIDTH="39%" CLASS="label"><div id="itmCode"><label id="lblFluidShowBatches" style='<%=item_code_man_invisible%>'> &nbsp;<fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/> &nbsp;&nbsp;&nbsp;
		&nbsp;</label><INPUT TYPE="text" name="item_code" id="item_code" SIZE="20" MAXLENGTH="20" style='<%=item_code_man_invisible%>'  VALUE="<%=item_code%>" <%=disable_all_fields%> <%=item_code_lookup%>><INPUT TYPE="button" CLASS="button" name="item_code_lkup" id="item_code_lkup" VALUE="?"  onClick="searchItem(document.TPNRegimenMastForm.item_code)"  <%=disable_all_fields%>  <%=item_code_lookup%> style='<%=item_code_man_invisible%>'> &nbsp; <IMG   id='item_code_man' SRC="../../eCommon/images/mandatory.gif" ALIGN="center" style='<%=item_code_man_invisible%>' ></TD></div>
		<TD ALIGN="right" WIDTH="20%" CLASS="label"><fmt:message key="ePH.PrescribingBaseUnit.label" bundle="${ph_labels}"/></TD>
		<TD ALIGN="left" WIDTH="23%" CLASS="label">&nbsp;<B><%= pres_base_uom_desc %></B></TD>
	</TR>
	</TABLE>

	<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="80%" ALIGN="left" BORDER="0">
		<TR>
			 <TD CLASS="white" WIDTH="40%">
			 <ul id="tablist" class="tablist" style="padding-left: 5px;">
			 <li class="tablistitem" title='<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/>'>
				 <a onclick="tab_click2('Constituents_tab');" class="tabClicked" id="Constituents_tab" >
					<span class="tabSpanclicked" id="Constituents_tabspan">
					<fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></span>
					</a>
				</li>
			 <li class="tablistitem" title='<fmt:message key="ePH.OrderingDispensingRules.label" bundle="${ph_labels}"/>'>
				 <a onclick="tab_click2('OrderingDispensingRules_tab');" class="tabA" id="OrderingDispensingRules_tab" >
					<span class="tabAspan" id="OrderingDispensingRules_tabspan">
					<fmt:message key="ePH.OrderingDispensingRules.label" bundle="${ph_labels}"/></span>
					</a>
				</li>
			 </ul>
			
			</TD>
		</TR>
	</TABLE>	
<SCRIPT>

<%
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && !std_result.equals("N")) {
%>
document.getElementById("Constituents_tab").click();

		//showTabDetail(document.getElementById("constituents"));
<%
	}
}	
%>

</SCRIPT>
   <INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
	<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%=mode%>">
	<INPUT TYPE="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="or_yn" id="or_yn" VALUE="<%=bean.getORModuleYN()%>">
	<INPUT TYPE="hidden" name="sql_ph_drug_select25" id="sql_ph_drug_select25" VALUE="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SELECT25")%>">
	<INPUT TYPE="hidden" name="or_status" id="or_status" VALUE="<%=or_status%>">
	<INPUT TYPE="hidden" name="schedule_id" id="schedule_id" VALUE="">
	<INPUT TYPE="hidden" name="pres_base_uom" id="pres_base_uom" VALUE="<%=pres_base_uom%>">
	<INPUT TYPE="hidden" name="pres_base_uom_desc" id="pres_base_uom_desc" VALUE="<%=pres_base_uom_desc%>">
	<INPUT TYPE="hidden" name="locale" id="locale" VALUE="<%=locale%>">
	<INPUT TYPE="hidden" name="tpn_tab_reg" id="tpn_tab_reg" value="<%=tpn_tab_reg%>"><!-- added for ml-mmoh-crf-1290 -->

</FORM>
<% putObjectInBean(bean_id,bean,request); %>
</BODY>
</HTML>

