<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	request.setCharacterEncoding("UTF-8");	
%>

<HTML>
<HEAD>
<%

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
Connection con=null;

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 
<title>IBW Calculator</title>
<script src='../../eCA/js/CACalcIBW.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

</script>

<%
   try
   {
	

	String formula_ref_id ="";
	String formula_detail ="";
	String formula_ref_desc ="";
	String age_disp ="";


	PreparedStatement stmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
	String qry ="select r.FORMULA_REF_ID,g.FORMULA_REF_DESC ,g.FORMULA_DETAIL from CA_CLINICAL_CALC r,CA_CLIN_CALC_DEF g where r.CALC_ID=g.CALC_ID and r.FORMULA_REF_ID=g.FORMULA_REF_ID and r.CALC_ID='IDLBODYWT'";

	stmt = con.prepareStatement(qry);
	rs = stmt.executeQuery();

	while(rs.next())
	{
		formula_ref_id = rs.getString("FORMULA_REF_ID");
		formula_detail = rs.getString("FORMULA_DETAIL");
		formula_ref_desc = rs.getString("FORMULA_REF_DESC");
	
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();

	if(formula_ref_id.equals("DE")){
		age_disp="display";
	}
	else
	   {
			age_disp="display:none";
	   }

%>


</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name ='CalIBWForm' >
<table  width ='100%' height='25%' border=0 cellpadding=0 cellspacing=0 align="center" RULES=NONE>
<%/*****************************/%>
<tr><th colspan='4' align='left'>&nbsp;<fmt:message key="eCA.IBW.label" bundle="${ca_labels}"/></th></tr>

<tr>
	<td class='LABEL' width='20%' align='right'><fmt:message key="Common.weight.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class=label width="25%" nowrap><input type='text' name ='wtInput' size ='10' style="text-align: Right" maxLength ='10' onBlur='CheckNum(this);clearIBW(this)' value="">
	<select name ='wtUnits' onChange="calWt(this.form)">
	<option value="kg"><fmt:message key="eCA.Kilograms.label" bundle="${ca_labels}"/></option>
	<option value="lbs"><fmt:message key="eCA.Pounds.label" bundle="${ca_labels}"/></option>
		</select>
	</td>
	<td class='LABEL' colspan='2'><i>&nbsp;<fmt:message key="eCA.CanConvertLbsToKg.label" bundle="${ca_labels}"/></i></td>
</tr>
<tr>
	<td class='LABEL' align='right' width='20%'><fmt:message key="Common.height.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class=label width="25%" nowrap><input type='text' name ='htInput' size ='10'  style="text-align: Right" maxLength ='10' onBlur='CheckNum(this);callsetFeetAndInches(this.form);' value="">
	<select name ='htUnits' onChange='calHt(this.form)'>
	<option value="cm"><fmt:message key="Common.cm.label" bundle="${common_labels}"/></option>
	<option value="inches"><fmt:message key="Common.Inch.label" bundle="${common_labels}"/></option>
	</select>
	</td>
	<td class='LABEL' align ='center' width='15%'><fmt:message key="eCA.Or.label" bundle="${ca_labels}"/>&nbsp;</td>
	<td class=label align='left' nowrap>
	<select name ='htInFt'onChange='feetAndInches(this.form)'>
	<%for(int i=1;i<8;i++){%>
	<option value="<%=i%>"><%=i%>'</option>
	<%}%>
	</select>
	<select name ='htInInch' onChange='feetAndInches(this.form)'>
	<%for(int j=0;j<12;j++){%>
	<option value='<%=j%>'><%=j%>"</option>
	<%}%>
	</select>
	</td>
</tr>
<tr id="tr_age" style="<%=age_disp%>" >
	<td class='LABEL' align='right' width='20%'><fmt:message key="Common.age.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class=label width="15%" ><input type='text' name ='ageInput' size ='10'  style="text-align: Right" maxLength ='10' onBlur='CheckNum(this);clearIBW(this)' value="">&nbsp;<fmt:message key="Common.Years.label" bundle="${common_labels}"/>&nbsp;
	<td class='LABEL' align ='center' width='15%'><fmt:message key="eCA.Or.label" bundle="${ca_labels}"/>&nbsp;</td>
	<td class=label align='left' nowrap>
	<select name ='ageRng' onChange='calAge(this.form)'>
		<option>70 + <fmt:message key="Common.Years.label" bundle="${common_labels}"/></option>0
        <option>60 - 69 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>1
		<option>50 - 59 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>2
		<option>40 - 49 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>3
		<option>30 - 39 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>4
		<option>20 - 29 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>5
		<option>18 - 19 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>6
		<option>17 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>7
		<option>16 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>8
		<option>15 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>9
		<option>14 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>10
		<option>13 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>11
		<option>12 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>12
		<option>11 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>13
		<option>10 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>14
		<option>9 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>15
		<option>8 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>16
		<option>7 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>17
		<option>6 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>18
		<option>5 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>19
		<option>4 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>20
		<option>3 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>21
		<option>2 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>22
		<option>1.5 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>23
		<option>1 <fmt:message key="eCA.yrs.label" bundle="${ca_labels}"/></option>24
		<option selected><fmt:message key="Common.Adult.label" bundle="${common_labels}"/></option>25
		<option><fmt:message key="eCA.Child.label" bundle="${ca_labels}"/></option>26
		</select>
	<td>
</tr>

<tr>
	<td class='LABEL' align ='right' width='20%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/>&nbsp;</td>
	<td class=label width="25%" nowrap>
	<select name ='gender' >
	<option value="M"><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
	<option value="F"><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
	</select>
	</td>
	<td colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td  align='center' colspan='4' ><input type='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Calculate.label","ca_labels")%>' onClick='calculateIBW(this.form)' class="BUTTON" ></td>
</tr>

</table>
<table width ='100%' height='10%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>
<tr>
	<td align="right" width='30%' class ='LABEL'><fmt:message key="eCA.IBW.label" bundle="${ca_labels}"/>&nbsp;</td>
	<td align="left" nowrap><input type='text' name ='IBW' readonly value=""></td>
</tr>
</table>
<%/*****************************/%>		
<table width ='100%' height='10%' border=0 cellpadding=0 cellspacing=0 align=center RULES=NONE>	
<tr>
	<th align=left>&nbsp;<fmt:message key="eCA.FormulaAdopted.label" bundle="${ca_labels}"/>&nbsp;&nbsp;:&nbsp;&nbsp;<%=formula_ref_desc%></th>
</tr>
<tr>
<td class='LABEL' align="left"> &nbsp;&nbsp;&nbsp;<%=formula_detail%>&nbsp;&nbsp;&nbsp;
<!--<b>Adults:</b><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Male:&nbsp;&nbsp;50 kg +2.3 kg for every inch (2.54 cm) over 5 ft (152 cm)

<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Female:&nbsp;&nbsp;
45.5kg +2.3 kg for every inch (2.54 cm) over 5 ft (152 cm)
<br><br>
<b>Children 1 ? 18 yrs:</b>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Height less than 5 ft (152 cm) tall:<br> 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;IBW=2.05 x e^(0.02 x ht)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ht in cm
<br><br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Height greater than 5 ft (152 cm) tall:<br> 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Male:&nbsp;&nbsp;39 + 2.27 x (Ht ? 60)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Ht in inches
<br> 	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Female:&nbsp;&nbsp;42.2 + 2.27 x (Ht ? 60)&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Ht in inches
<br>
e = 2.71828182845 -->

</td>
</tr>
</table>
<input type='hidden' name='formula_ref_id' id='formula_ref_id' value="<%=formula_ref_id%>">
</form>
</BODY>
</HTML>
<%
}
catch(Exception e)
{	
	e.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

