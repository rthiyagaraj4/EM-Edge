<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

StringBuffer sql=new StringBuffer();
String relationship_type="";
String enc_checked="checked";
String reln_enabled = "";
String reln_checked = "checked";
String disable_seq_no = "";
String life_checked="";
String expiry_based_checked="checked";
String expiry_based_disabled="disabled";
String direct_yn="";
String direct_yn_checked="checked";
//String direct_yn_checked="";
String ip_admit="";
String ip_attend="";
String op_attend="";
String ae_attend="";
String nm_attend="";
String dc_attend="";
String reln_attend="";

/*****************************************/
String ip_admit_dflt_enabled = "disabled";
String ip_attend_dflt_enabled = "disabled";
String op_attend_dflt_enabled = "disabled";
String ae_attend_dflt_enabled = "disabled";
String nm_attend_dflt_enabled = "disabled";
String dc_attend_dflt_enabled = "disabled";
String reln_attend_dflt_enabled = "disabled";

/*****************************************/
String ip_admit_dflt="";
String ip_attend_dflt="";
String op_attend_dflt="";
String ae_attend_dflt="";
String nm_attend_dflt="";
String dc_attend_dflt="";
String reln_attend_dflt="";

String ip_admit_checked="";
String ip_attend_checked="";
String op_attend_checked="";
String ae_attend_checked="";
String dc_attend_checked="";
String nm_attend_checked="";
String reln_attend_checked="";

String ip_admit_dflt_checked="";
String ip_dflt_checked="";
String op_dflt_checked="";
String ae_dflt_checked="";
String dc_dflt_checked="";
String nm_dflt_checked="";
String reln_dflt_checked="";

String expiry_based="";
String expiry_rule="";
String expiry_rule_desc="";
String expiry_period="";

String dis="";
String dis1="";
String mode="";
String pract_reln_seq="";
String relation_name="";
String nature = "";
String diss_1 = "";

String relation_id=request.getParameter("relation_id");

if(relation_id==null) 
{
	relation_id="";
	mode="insert";
}
else
	mode="modify";

try
{
	con=ConnectionManager.getConnection(request);

	if( mode.equals("modify") )
	{
		if(sql.length() > 0) sql.delete(0,sql.length());
	
		diss_1 = " disabled ";
		nature=request.getParameter("nature");
		
		if(nature == null) nature="";

		sql.append(" Select  pract_reln_name, lifetime_or_encntr, direct_yn, ");  
		sql.append(" ip_admit_phys_yn, ip_attend_phys_yn, op_attend_phys_yn,ae_attend_phys_yn,dc_attend_phys_yn,attend_nurse_reln_yn,referal_reln_yn, ");
		sql.append("dflt_ip_admit_phys_yn,dflt_ip_attend_phys_yn,dflt_op_attend_phys_yn,dflt_ae_attend_phys_yn,dflt_dc_attend_phys_yn,dflt_referal_reln_yn,dflt_attend_nurse_reln_yn,expiry_based_yn, expiry_rule, ");
		
		sql.append(" expiry_period, pract_reln_seq, eff_status from ca_pract_reln  ");
		sql.append(" where pract_reln_id='"+relation_id+"' ");
		stmt=con.prepareStatement(sql.toString());
		rs=stmt.executeQuery();

		if(rs!=null)
		{
			while(rs.next())
			{
				reln_enabled	= rs.getString("eff_status") == null ? "E" : rs.getString("eff_status");
				direct_yn		= rs.getString("direct_yn")==null?"":rs.getString("direct_yn");

				if(direct_yn.equals("Y"))
					direct_yn_checked ="checked";
				else
					direct_yn_checked="";

				relation_name		=(rs.getString("pract_reln_name")==null)?"":rs.getString("pract_reln_name");
				relationship_type	=(rs.getString("lifetime_or_encntr")==null)?"":rs.getString("lifetime_or_encntr");
				pract_reln_seq		=(rs.getString("pract_reln_seq")==null)?"":rs.getString("pract_reln_seq");
				ip_attend			=(rs.getString("ip_attend_phys_yn")==null)?"N":rs.getString("ip_attend_phys_yn");
				ip_admit			=(rs.getString("ip_admit_phys_yn")==null)?"N":rs.getString("ip_admit_phys_yn");
				ae_attend			=(rs.getString("ae_attend_phys_yn")==null)?"N":rs.getString("ae_attend_phys_yn");
				op_attend			=(rs.getString("op_attend_phys_yn")==null)?"N":rs.getString("op_attend_phys_yn");
				dc_attend			=(rs.getString("dc_attend_phys_yn")==null)?"N":rs.getString("dc_attend_phys_yn");
				nm_attend			=(rs.getString("attend_nurse_reln_yn")==null)?"N":rs.getString("attend_nurse_reln_yn");
				reln_attend			=(rs.getString("referal_reln_yn")==null)?"N":rs.getString("referal_reln_yn");
				ip_admit_dflt		=(rs.getString("dflt_ip_admit_phys_yn")==null)?"N":rs.getString("dflt_ip_admit_phys_yn");	
				ip_attend_dflt		=(rs.getString("dflt_ip_attend_phys_yn")==null)?"N":rs.getString("dflt_ip_attend_phys_yn");
				op_attend_dflt		=(rs.getString("dflt_op_attend_phys_yn")==null)?"N":rs.getString("dflt_op_attend_phys_yn");
				ae_attend_dflt		=(rs.getString("dflt_ae_attend_phys_yn")==null)?"N":rs.getString("dflt_ae_attend_phys_yn");
				dc_attend_dflt		=(rs.getString("dflt_dc_attend_phys_yn")==null)?"N":rs.getString("dflt_dc_attend_phys_yn");
				reln_attend_dflt	=(rs.getString("dflt_referal_reln_yn")==null)?"N":rs.getString("dflt_referal_reln_yn");
				nm_attend_dflt		=(rs.getString("dflt_attend_nurse_reln_yn")==null)?"N":rs.getString("dflt_attend_nurse_reln_yn");
				expiry_based		=(rs.getString("expiry_based_yn")==null)?"N":rs.getString("expiry_based_yn");

				if(relationship_type.equals("L"))
					life_checked = "checked";
				else if(relationship_type.equals("E"))
					enc_checked = "checked";

				if(ip_admit.equals("Y"))
				{
					ip_admit_checked		=	"checked";
					ip_admit_dflt_enabled	=	"";
				}
				else
					ip_admit_checked		=	"";

				if(ip_attend.equals("Y"))
				{
					ip_attend_checked="checked";
					ip_attend_dflt_enabled= "";					
				}
				else
					ip_attend_checked="";

				if(op_attend.equals("Y"))
				{
					op_attend_checked="checked";
					op_attend_dflt_enabled = "";
				}
				else
					op_attend_checked="";

				if(ae_attend.equals("Y"))
				{
					ae_attend_checked="checked";
					ae_attend_dflt_enabled = "";
				}
				else
					ae_attend_checked="";

				if(dc_attend.equals("Y"))
				{
					dc_attend_checked="checked";
					dc_attend_dflt_enabled = "";				
				}
				else
					dc_attend_checked="";

				if(nm_attend.equals("Y"))
				{
					nm_attend_checked="checked";
					nm_attend_dflt_enabled = "";
				}
				else
					nm_attend_checked="";

				if(reln_attend.equals("Y"))
				{
					reln_attend_checked="checked";
					reln_attend_dflt_enabled = "";
				}
				else
					reln_attend_checked="";
				
				if(ip_admit_dflt.equals("Y"))
					ip_admit_dflt_checked="checked";
				else
					ip_admit_dflt_checked="";

				if(ip_attend_dflt.equals("Y"))
					ip_dflt_checked="checked";
				else
					ip_dflt_checked="";
				
				if(op_attend_dflt.equals("Y"))
					op_dflt_checked="checked";
				else
					op_dflt_checked="";

				if(ae_attend_dflt.equals("Y"))
					ae_dflt_checked="checked";
				else
					ae_dflt_checked="";
				
				if(dc_attend_dflt.equals("Y"))
					dc_dflt_checked="checked";
				else
					dc_dflt_checked="";

				if(reln_attend_dflt.equals("Y"))
					reln_dflt_checked="checked";
				else
					reln_dflt_checked="";
				
				if(nm_attend_dflt.equals("Y"))
					nm_dflt_checked="checked";
				else
					nm_dflt_checked="";

				if(expiry_based.equals("Y"))
					expiry_based_checked="checked";
				else
					expiry_based_checked=""; 

				expiry_rule=rs.getString("expiry_rule");

				if(expiry_rule==null) expiry_rule="";
				
				if(expiry_rule.equals("DAE"))		expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterEffect.label","ca_labels");
				else if(expiry_rule.equals("DAA"))	expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterAdmit.label","ca_labels");
				else if(expiry_rule.equals("DAT"))	expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.DayAfterTransfer.label","ca_labels");
				else if(expiry_rule.equals("DAD"))	expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DayAfterDischarge.label","common_labels");
				else if(expiry_rule.equals("HAE"))	expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterEffect.label","ca_labels");
				else if(expiry_rule.equals("HAA"))	expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterAdmit.label","ca_labels");
				else if(expiry_rule.equals("HAT"))	expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.HourAfterTransfer.label","ca_labels");
				else if(expiry_rule.equals("HAD"))	expiry_rule_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.HourAfterDischarge.label","common_labels");
				
				expiry_period=rs.getString("expiry_period");
				if(expiry_period==null) expiry_period="";
			}
		}

		if(reln_enabled.equals("D"))
		{
			//dis1 = " disabled ";
			dis1 = "readOnly";
			diss_1 = " disabled ";
			reln_checked = "";
			disable_seq_no = " readOnly ";
		}
		else
		{
			reln_checked = " checked ";
			disable_seq_no = "";
		}
}
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script language='javascript' src='../../eCA/js/PractRelation.js'></script>
<!--<script src='../../js/PractRelation.js'				language='javascript' ></script> -->
<script src="../../eCommon/js/common.js"			language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' onload='FocusFirstElement()'>
<form name="pract_relation_form" id="pract_relation_form" action="../../servlet/eCA.PractRelationServlet" method="post" target="messageFrame">
<br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='75%' align="center">
<tr>
	<td class='label' ><fmt:message key="eCA.RelationshipID.label" bundle="${ca_labels}"/></td>
	<td class='fields'><input type="text" name="relation_id" id="relation_id" value="<%=relation_id%>" size=20 maxlength=20 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" <%=diss_1%>><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eCA.RelationshipName.label" bundle="${ca_labels}"/></td>
	<td class='fields'><input type="text" name="relation_name" id="relation_name" value="<%=relation_name%>"  onblur="makeValidString(this); pop5(this);" size=30 maxlength=60 <%=dis1%>><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<input type="hidden" name="enabled" id="enabled" value=''>
<tr>
	<td class='label' ><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="text" name="pract_reln_seq" id="pract_reln_seq" value='<%=pract_reln_seq%>' size=4 maxlength=4 onkeyPress='return allowValidNumber(this,event,4,0)'    onblur='CheckPositiveNumberLocal(this)' <%=disable_seq_no%>></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type="radio" name="relationship_type" id="relationship_type" value='E' <%=enc_checked%> onclick='add(this)'  <%=diss_1%>><fmt:message key="Common.encounter.label" bundle="${common_labels}"/> &nbsp; <fmt:message key="Common.specific.label" bundle="${common_labels}"/><input type="radio" name="relationship_type" id="relationship_type" value='L' onclick='add(this)'  <%=life_checked%> <%=diss_1%>><fmt:message key="eCA.LifeTime.label" bundle="${ca_labels}"/></td>
</tr>
 <tr>
	<td class='label'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='checkbox' name='enable_reln' id='enable_reln' value='' <%=reln_checked%>></td>
</tr> 
<tr>

	<td class='COLUMNHEADERCENTER' colspan=2 ><fmt:message key="eCA.DirectIndirectSettings.label" bundle="${ca_labels}"/></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="eCA.AllowDirect.label" bundle="${ca_labels}"/></td>
	<td class='fields'><input type="checkbox" name="direct_yn" id="direct_yn" value='Y'  onclick='expiry_rule2(this)' <%=diss_1%> <%=direct_yn_checked%>></td>
</tr>

	
	<table border=0 cellspacing=0 cellpadding=3 width='75%' align=center>
	<tr>
		
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.Applicable.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
		
	</tr>
	<tr>
		<td class='label'  ><fmt:message key="eCA.IPEnc.label" bundle="${ca_labels}"/></td>
		<td align=center >
			<input type="checkbox" name="ip_attend"  value='Y' id='IPEn' onClick='checkdefault(this)' <%=ip_attend_checked%> ></td>
		<td class='fields'   >&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="ip_default"  value='Y' id='IPEnD' onClick='Assigndefault(this)' <%=ip_dflt_checked%> <%=ip_attend_dflt_enabled%>></td>
	</tr>
	<tr>
		<td class='label'  ><fmt:message key="eCA.IPAdmit.label" bundle="${ca_labels}"/></td>
		<td align=center>
			<input type="checkbox" name="ip_admit"  value='Y'  id='IPAd' onClick='checkdefault(this)' <%=ip_admit_checked%>></td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="ip_admit_default" value='Y' id='IPAdD' onClick='Assigndefault(this)' <%=ip_admit_dflt_enabled%> <%=ip_admit_dflt_checked%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eCA.OPVisit.label" bundle="${ca_labels}"/></td>
		<td align=center>
			<input type="checkbox" name="op_attend"  value='Y' id='OP' onClick='checkdefault(this)' <%=op_attend_checked%>></td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="op_default"  value='Y'  id='OPD' onClick='Assigndefault(this)'<%=op_dflt_checked%> <%=op_attend_dflt_enabled%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eCA.AccidentEmergency.label" bundle="${ca_labels}"/></td>
		<td align=center>
			<input type="checkbox" name="ae_attend"  value='Y' id='AE' onClick='checkdefault(this)' <%=ae_attend_checked%>></td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="ae_default"  value='Y'  id='AED' onClick='Assigndefault(this)'<%=ae_dflt_checked%> <%=ae_attend_dflt_enabled%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td>
		<td align=center>
			<input type="checkbox" name="dc_attend"  value='Y'  id='DC' onClick='checkdefault(this)' <%=dc_attend_checked%>></td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="dc_default"  value='Y' id='DCD'  onClick='Assigndefault(this)'<%=dc_dflt_checked%> <%=dc_attend_dflt_enabled%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eCA.ReferralReln.label" bundle="${ca_labels}"/></td>
		<td align=center>
			<input type="checkbox" name="referral_reln"  value='Y' id='RL' onClick='checkdefault(this)' <%=reln_attend_checked%>></td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="referral_deflt"  value='Y' id='RLD' onClick='Assigndefault(this)' <%=reln_dflt_checked%> <%=reln_attend_dflt_enabled%>></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="eCA.NurseRelation.label" bundle="${ca_labels}"/></td>
		<td align=center>
			<input type="checkbox" name="nm_attend"  value='Y' id='NM' onClick='checkdefault(this)' <%=nm_attend_checked%>></td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="checkbox" name="nm_default"  value='Y'  id='NMD' onClick='Assigndefault(this)' <%=nm_dflt_checked%> <%=nm_attend_dflt_enabled%>></td>
	</tr>
	


<tr>
	<td class='COLUMNHEADERCENTER' colspan=3  ><fmt:message key="Common.ExpiryRule.label" bundle="${common_labels}"/></td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.ExpiryBased.label" bundle="${common_labels}"/></td>
	<td  class='fields'>
		<input type="checkbox" name="expiry_based" id="expiry_based" value='Y' onclick='pop1(this);setMode(this)'  <%=dis%> <%=expiry_based_checked%> <%=expiry_based_disabled%>></td>
			<td colspan=1></td>

</tr> 
<tr>
	<td class='label'  ><fmt:message key="Common.rule.label" bundle="${common_labels}"/></td>
	<td  class='fields'>
		<%
		if(mode.equals("insert")) 
		{
			%>
				<select name="expiry_rule" id="expiry_rule"  <%=dis%>>
			<option value=''>------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------</option>
			<option value='DAE'><fmt:message key="eCA.DayAfterEffect.label" bundle="${ca_labels}"/></option>
			<option value='DAA'><fmt:message key="eCA.DayAfterAdmit.label" bundle="${ca_labels}"/></option>
			<option value='DAT'><fmt:message key="eCA.DayAfterTransfer.label" bundle="${ca_labels}"/></option>
			<option value='DAD'><fmt:message key="Common.DayAfterDischarge.label" bundle="${common_labels}"/></option>
			<option value='HAE'><fmt:message key="eCA.HourAfterEffect.label" bundle="${ca_labels}"/></option>
			<option value='HAA'><fmt:message key="eCA.HourAfterAdmit.label" bundle="${ca_labels}"/></option>
			<option value='HAT'><fmt:message key="eCA.HourAfterTransfer.label" bundle="${ca_labels}"/></option>
			<option value='HAD'><fmt:message key="Common.HourAfterDischarge.label" bundle="${common_labels}"/></option>
			</select>
			<%
		}
		%>
		<%
			if(mode.equals("modify"))
			{
				%>
				<input type=text name=expiry_rule_modify value='<%=expiry_rule_desc%>' readonly>
				<%
			}
		%>
	
		<img id=id1 src='../../eCommon/images/mandatory.gif'></td>
			<td colspan=1></td>
</tr>
<tr>
	<td class='label'  ><fmt:message key="Common.ExpiryPeriod.label" bundle="${common_labels}"/></td>
	<td  class='fields'><input type="text" name="expiry_period" id="expiry_period" value='<%=expiry_period%>' maxlength=6 size=6 onblur='CheckPositiveNumberLocal(this)' onkeyPress=' allowValidNumber(this,event,6,0);chkZero(this)'  <%=dis%><% if((mode.equals("modify"))&& (expiry_based.equals("N"))) {%>disabled <% }%> ><img id=id2 src='../../eCommon/images/mandatory.gif'></td>
		<td colspan=1></td>
</tr>
</table>

<%
	if((!mode.equals("modify")) || direct_yn.equals("Y"))
	{
		%>
		<script>
		  document.forms[0].ip_admit.disabled=true;
		  document.forms[0].ip_attend.disabled=true;
		  document.forms[0].op_attend.disabled=true;
		  document.forms[0].nm_attend.disabled=true;
		  document.forms[0].dc_attend.disabled=true;
		  document.forms[0].ae_attend.disabled=true;
		  document.forms[0].referral_reln.disabled=true;
		  document.forms[0].ip_default.disabled=true;
		  document.forms[0].op_default.disabled=true;
		  document.forms[0].ip_admit_default.disabled=true;
		  document.forms[0].nm_default.disabled=true;
		  document.forms[0].dc_default.disabled=true;
		  document.forms[0].ae_default.disabled=true;
		  document.forms[0].referral_deflt.disabled=true;
		</script>
		<%
	}
	
	if(mode.equals("modify") && nature.equals("LifeTime") && expiry_based.equals("N"))
	{
		%>
		<script>
			document.forms[0].id1.style.visibility="hidden";
			document.forms[0].id2.style.visibility="hidden";
		</script>
		<%
	}
	if(mode.equals("modify") && nature.equals("LifeTime"))
	{
		%>
		<script>
		document.forms[0].ip_admit.disabled=true;
		document.forms[0].ip_attend.disabled=true;
		document.forms[0].op_attend.disabled=true;
		document.forms[0].nm_attend.disabled=true;
		document.forms[0].dc_attend.disabled=true;
		document.forms[0].ae_attend.disabled=true;
		document.forms[0].referral_reln.disabled=true;
		document.forms[0].direct_yn.checked=true;
		document.forms[0].direct_yn.disabled=true;
		document.forms[0].ip_default.disabled=true;
		document.forms[0].op_default.disabled=true;
		document.forms[0].ip_admit_default.disabled=true;
		document.forms[0].nm_default.disabled=true;
		document.forms[0].dc_default.disabled=true;
		document.forms[0].ae_default.disabled=true;
		document.forms[0].referral_deflt.disabled=true;
		</script>
		<%
	}
%>
<input type=hidden name=mode value='<%=mode%>'>
<input type=hidden name=pract_reln_seq1 value="<%=pract_reln_seq%>">
<input type=hidden name=relation_id1 value="<%=relation_id%>">
<input type=hidden name=relation_name1 value="<%=relation_name%>">
<input type=hidden name=nature value='E'>
<input type=hidden name=direct_yn1 value='<%=direct_yn%>'>
<input type=hidden name=ip_admit1 value='<%=ip_admit%>'>
<input type=hidden name=ip_attend1 value='<%=ip_attend%>'>
<input type=hidden name=op_attend1 value='<%=op_attend%>'>
<input type=hidden name=ae_attend1 value='<%=ae_attend%>'>
<input type=hidden name=dc_attend1 value='<%=dc_attend%>'>
<input type=hidden name=nm_attend1 value='<%=nm_attend%>'>
<input type=hidden name=reln_attend1 value='<%=reln_attend%>'>
<input type=hidden name=ip_admit_dflt value='<%=ip_admit_dflt%>'>
<input type=hidden name=ip_attend_dflt value='<%=ip_attend_dflt%>'>
<input type=hidden name=op_attend_dflt value='<%=op_attend_dflt%>'>
<input type=hidden name=ae_attend_dflt value='<%=ae_attend_dflt%>'>
<input type=hidden name=dc_attend_dflt value='<%=dc_attend_dflt%>'>
<input type=hidden name=nm_attend_dflt value='<%=nm_attend_dflt%>'>
<input type=hidden name=reln_attend_dflt value='<%=reln_attend_dflt%>'>
<input type=hidden name=expiry_based1 value='Y'>
<input type=hidden name=expiry_rule1 value="<%=expiry_rule%>">
</form>
</body>
</html>

<%
	
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	
}
catch(Exception e)
{
	//out.println(e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181

}
finally
{	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

