<!DOCTYPE html>
<!--This file is saved on 25/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<Title>TDM Calculator</Title>
<head>
	
<% String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/ADRReporting.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../ePH/js/TDMCalculator.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script> 
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<!--<title>Adverse Drug Reaction</title>!-->
</head>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="formTdmCalc" id="formTdmCalc">
<table align="center"  border="0" colspan=3  width="100%" cellspacing="0"   cellpadding="0" >
<!--
<td class='label'colspan=3>&nbsp;C<sub>post</sub>
<input type='text'  name="Cpost" id="Cpost" size='15'  maxlength="10" >
</td>
</tr>
<tr>

<td class='label' colspan=3>&nbsp;C<sub>pre</sub>&nbsp;
<input type='text'  name="Cpre" id="Cpre"  size='15'  maxlength="10" >
</td>
</tr>
!-->
<tr>
<td align = 'left' width="40%" colspan=1>&nbsp;</td>
<td align = 'left'  colspan=1>&nbsp;</td>
<td class='label' align = 'right'  colspan=1>&nbsp;<label  style='font-size:10;'  id="clk" >&nbsp;</label></td>
</tr>
<tr >
<td align = 'left' width="40%" colspan=1>&nbsp;<SELECT name="result_type" id="result_type" onchange="dispFormula(this)">
			<option value="">-------------Select----------------------</option>
			<option value="KE">Elimination rate constant (hr<sup> -1</sup>)</option>
			<option value="DSGINTVL">Dosing intervals (hrs)</option>
			<option value="DSGHLF">Dosing intervals (1/2 hrs)</option>
			<option value="VLDSN">Volume distribution (L/kg)</option>
			<option value="NWTRGH">new dose (mg) for trough concentration</option>
			<option value="NWPK">new dose (mg) for Peak concentration</option>
			<option value="WTHLDPRE">Withold time (hr) Pre Level </option>
			<option value="WTHLDPOST">Withold time (hr) Post Level </option>
			<!--<option value="WTHLDPREPST">Withold time (hr) Pre & Post Level </option>!-->
			<option value="CRCL">CrCl (ml/min)  </option>
			<option value="CLA">Clearance (L/hr)</option>
			<option value="MINS">Exp Min Serum Conc at steady state (mcg/ml) </option>
			<option value="MAXS">Exp Max Serum Conc at steady state (mcg/ml) </option>
			<option value="DSE">Dose(mg) </option>
			
			</SELECT>
		</td>

		<td  class='label'  align = 'left' colspan=2 >
       <label id="fdisp" style="visibility:hidden;" ></label></td>
&nbsp;</td>
		</td>
		</tr>

<tr>
<td align = 'left' width="40%" colspan=1>&nbsp;</td>
<td align = 'left'  colspan=1>&nbsp;</td>
<td align = 'left'  colspan=1>&nbsp;</td>
</tr>

<tr>
<td align = 'left' width="40%" colspan=1>&nbsp;</td>
<td align = 'right'  colspan=1>&nbsp;<input type='radio' name="male" id="male" style="visibility:hidden" value="" onclick="dispMal(this)" checked></input><label  style='font-size:10;'  id="malelb" style="visibility:hidden;">Male</label>&nbsp;<input type='radio' id="female" name="female" id="female" style="visibility:hidden;" value="" onclick="dispFem(this)"></input><label  style='font-size:9;'  id="femlb" style="visibility:hidden;">Female</label></td>
<td align = 'left'  colspan=1>&nbsp;</td>
</tr>

<div id="divtxt_1"  >

<table align="center"  border="0" colspan=3  width="100%" cellspacing="0"   cellpadding="0" >
<tr>
<td align = 'right' width="40%" colspan=1>&nbsp;</td>
<td align = 'left'  class='label'  colspan=1><label  style='font-size:9;'  id="txtlbl_1" style="visibility:hidden;"></label>&nbsp;<input type='text'  name="txt1" id="txt1"  size='15'  maxlength="15" style="visibility:hidden;" onKeyPress="return allowValidNumber(this,event);"></td>
<td align = 'left' colspan=1>&nbsp;</td>
</tr>
</table>
</div>
<div id="divtxt_2"  >

<table align="center"  border="0" colspan=3  width="100%" cellspacing="0"   cellpadding="0" >

<tr>
<td align = 'right' width="40%" colspan=1>&nbsp;</td>
<td align = 'left'  class='label'  colspan=1><label  style='font-size:9;' id="txtlbl_2" style="visibility:hidden;"></label>&nbsp;<input type='text'  name="txt2" id="txt2"  size='15'  maxlength="15" style="visibility:hidden;" onKeyPress="return allowValidNumber(this,event);">
</td>
<td align = 'left'  colspan=1>&nbsp;</td>
</tr>

</table>
</div>
<div id="divtxt_3"  >



<table align="center"  border="0" colspan=3  width="100%" cellspacing="0"   cellpadding="0" >



<tr>
<td align = 'right' width="40%" colspan=1>&nbsp;</td>
<td align = 'left'  class='label'  colspan=1><label  style='font-size:9;' id="txtlbl_3" style="visibility:hidden;"></label>&nbsp;<input type='text'  name="txt3" id="txt3"  size='15'  maxlength="15" style="visibility:hidden;" onKeyPress="return allowValidNumber(this,event);">
</td>
<td align = 'left'  colspan=1>&nbsp;</td>
</tr>
</table>
</div>

<div id="divtxt_4"  >



<table align="center"  border="0" colspan=3  width="100%" cellspacing="0"   cellpadding="0" >
<tr>
<td align = 'right' width="40%" colspan=1></td>
<td align = 'left'  class='label'  colspan=1><label  style='font-size:9;'  id="txtlbl_4" style="visibility:hidden;"></label>&nbsp;<input type='text' name="txt4" id="txt4"  size='15'  maxlength="15" style="visibility:hidden;" onKeyPress="return allowValidNumber(this,event);">
</td>

<td align = 'left' colspan=1>&nbsp;</td>
</tr>
</table>

</div>

<div id="divtxt_5" >

<table align="center"  border="0" colspan=3  width="100%" cellspacing="0"   cellpadding="0" >
<tr>
<td align = 'right' width="40%" colspan=1></td>
<td align = 'left'  class='label'  colspan=1><label  style='font-size:9;'  id="txtlbl_5" style="visibility:hidden;"></label>&nbsp;<input type='text' name="txt5" id="txt5"  size='15'  maxlength="15" style="visibility:hidden;" onKeyPress="return allowValidNumber(this,event);">
</td>

<td align = 'left' colspan=1>&nbsp;</td>
</tr>
</table>
</div>
<table align="center"  border="0" colspan=3  width="100%" cellspacing="0"   cellpadding="0" >
<tr>
<td  colspan=1 width="40%" >&nbsp;</td>
<td  colspan=1>&nbsp;</td>
<td  colspan=1>&nbsp;</td>
</tr>


		<tr>
		<td align = 'left' width="40%" colspan=1>&nbsp;</td>
        <td align = 'left' colspan=1><input type="button" class="button" value="Calculate" name="Ke" id="Ke" onclick="TdmCalc(this)" style="visibility:hidden;">&nbsp;&nbsp;&nbsp;</td>
		<td align = 'left' colspan=1>&nbsp;</td>
		</tr>

<tr>
<td  colspan=1 width="40%" >&nbsp;</td>
<td  colspan=1>&nbsp;</td>
<td  colspan=1>&nbsp</td>
</tr>

<tr>
<td  colspan=1 width="40%" >&nbsp;</td>
<td class='label' align = 'left'  colspan=1><label  style='font-size:9;'  id="Reslgnd" style="visibility:hidden;"></label><strong><label  style='font-size:12;' id="Keresult" style="visibility:hidden;"></label></strong>&nbsp;&nbsp;<label  style='font-size:9;' id="Resunit" style="visibility:hidden;"></label></td>
<td  colspan=1>&nbsp;</td>
</tr>

<tr>
<td  colspan=1 width="40%" >&nbsp;</td>
<td  colspan=1>&nbsp;</td>
<td  colspan=1>&nbsp;</td>
</tr>

<tr >
<td class='label' align = 'left'  width="40%"  colspan=1><dfn><label  style='font-size:10;' id="footlbl_1" style="visibility:hidden;"></label></dfn></td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
</tr>

<tr >
<td class='label' align = 'left' width="40%"  colspan=1><dfn><label  style='font-size:10;' id="footlbl_2" style="visibility:hidden;"></label></dfn></td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
</tr>

<tr>
<td class='label' align = 'left' width="40%"  colspan=1><dfn><label  style='font-size:10;' id="footlbl_3" style="visibility:hidden;"></label></dfn></td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
</tr>

<tr>
<td class='label' align = 'left' width="40%"  colspan=1><dfn><label  style='font-size:10;' id="footlbl_4" style="visibility:hidden;"> </label></dfn></td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
</tr>

<tr>
<td class='label' align = 'left' width="40%"  colspan=1><dfn><label  style='font-size:10;' id="footlbl_5" style="visibility:hidden;"></label></dfn></td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
<td class='label' align = 'left'  colspan=1>&nbsp;</td>
</tr>



</table>

<input type="hidden" name="Kflag" id="Kflag"	value="">
<input type="hidden" name="Kval" id="Kval"	value="">



</form>
<script type="text/javascript" language="JavaScript">
var int=self.setInterval("getClockTime()",50);
top.resizeBy(-100,-100)

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</body>
</html>


