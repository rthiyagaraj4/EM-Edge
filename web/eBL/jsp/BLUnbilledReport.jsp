<!DOCTYPE html>
 <!-- 
Sr No        Version           Incident        SCF/CRF             Developer Name
-----------------------------------------------------------------------------------
1            V201103            5475         MOHE-CRF-0050.3      Mohana Priya K
2			 V201124			8638	BL-MOHE-CRF-0050.3 US001/
										01-Unbilled Report 3T        Mohana Priya K
--> 

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*,  "  
contentType="text/html;charset=UTF-8" %> 
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>	
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eBL/js/BLUnbilledReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
</head>

<style>
		thead td, thead td.locked	{ 
		background-color: navy;
		color: white;
		position:relative;}	
		thead td {
		top: expression(document.getElementById("tbl-container").scrollTop-4); 
		z-index: 20;}
		thead td.locked {z-index: 30;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative;
		z-index: 10;}
		td.locked,  th.locked{
		left: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);
		position: relative; 
		z-index: 10;}
		</style>
		
<script>
function mand_fld(){
	var cutoff    = document.forms[0].cut_off_date.value;
		if(cutoff==''){
			document.getElementById("cut_off_date").focus();
			alert(getMessage("BL00948",'BL'));
			return false;
		}else{
			return true;
		}
	}
			
</script>
<%
	response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
	response.setHeader("Pragma","no-cache"); //HTTP 1.0   
	response.setDateHeader ("Expires", 0); //prevents caching at the proxy server 
	String locale					=	"";
	String facilityId			=	"";
	String mode				=	"";
	mode		=	"";
	String isUserCanAcess		=	"";
	String disable="disabled";
	String p_user_name		= (String) session.getValue( "login_user" );
	String value1="N";
	String value2="N";
	try  
	{		 
		locale  = 	(String)session.getAttribute("LOCALE");
		facilityId =   (String) session.getValue( "facility_id" );
		//con=ConnectionManager.getConnection(request);
		isUserCanAcess = (String) (session.getValue("isUserCanAcess")==null?"Y":(session.getValue("isUserCanAcess")));		
%>

<BODY onScroll="processScroll()" onKeyDown= "lockKey();" onMouseDown="CodeArrest();" onSelect="codeArrestThruSelect();" style="padding-left:10px;padding-right:10px;padding-top:5px;" onLoad="focus_val();" >
 <form name="BLUnbilledForm" id="BLUnbilledForm" id="BLUnbilledForm"  action="../../eCommon/jsp/report_options.jsp" target="messageFrame" > 

<TABLE width="100%" CELLSPACING='0' cellpadding='3' align='center'>
<tr>
	<td  class="columnheader" ><fmt:message key="eBL.ReportCriteria.label" bundle="${bl_labels}"/> </td>
</tr>	
</TABLE> 
<br>
<table cellpadding='10' cellspacing='0' width="100%" align="center" border='0'>	
	<tr>
		<td>
		</td>
		<td>
		</td>
	    <td  class="label" width="10%">
			<fmt:message key="eBL.EpisodeType.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<select name="EpisodeType" id="EpisodeType" id="EpisodeType" onClick="mand_fld();" onchange="episodeTpyeChange(this)" style="width: 120px;">       
				<option value="I" >Inpatient</option>
				<option value="D" >Daycare</option>
				<option value="O" selected>Outpatient</option>
				<option value="E" >Emergency</option>
                <option value="R" >Referral</option>
            </select>		
		</td>
	</tr>
	<tr> &nbsp
	</tr>
	<tr>
		<td  class="label" width="10%">
			<fmt:message key="Common.DateFrom.label" bundle="${common_labels}"/>
		</td>
		<td width="10%" class='fields' colspan='2'>
			<input type="text" name="fm_bill_date" id="fm_bill_date" id="fm_bill_date" size="10" maxlength='10' value='' onClick="mand_fld();" onBlur='return checkDateBL(document.forms[0].fm_bill_date);return dateRegEx(this);' >
				&nbsp; <img src="../../eCommon/images/CommonCalendar.gif" onClick="if(mand_fld()){return showCalendar('fm_bill_date');}">
		</td>
        <td  class="label" width="10%">
		 	<fmt:message key="Common.DateTo.label" bundle="${common_labels}"/>
		</td>
		<td>
			<input type="text"  name="to_bill_date" id="to_bill_date"  id="to_bill_date"   size="10" maxlength='10' value='' onClick="mand_fld();" onBlur='return toFromDateChk(document.forms[0].to_bill_date);return dateRegEx(this);' >
				&nbsp; <img src="../../eCommon/images/CommonCalendar.gif" onClick="if(mand_fld()){return showCalendar('to_bill_date');}">
		</td>
	</tr>
	<tr>
		<td  class="label" >
			<fmt:message key="eBL.FrmPatno.label" bundle="${bl_labels}"/>
		</td>
		<td  class='fields' colspan='2'>
			<input type="text" name="Frm_Pat_no" id="Frm_Pat_no" id="Frm_Pat_no"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') PatientLookup(1,Fm_Pat,Frm_Pat_no);else  Fm_Pat_no.value ='';" onClick="mand_fld();" >	
			<input type='button' class='button' name="Patnobut" id="Patnobut" value='?' onClick="if(mand_fld()){ PatientLookup(1,Fm_Pat,Frm_Pat_no);toFromCheck(1);}" />	
			<input type="hidden" name="Fm_Pat" id="Fm_Pat"	 		id="Fm_Pat"		value=""> 			
		</td>
	
		<td class="label"  width="10%">
			<fmt:message key="eBL.ToPatno.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<input type="text" name="To_Pat_no" id="To_Pat_no" id="To_Pat_no"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') PatientLookup(2,To_Pat,To_Pat_no);else To_Pat.value='';"onClick="mand_fld();">	
			<input type='button' class='button' name="topatbut" id="topatbut" value='?' onClick="if(mand_fld()){PatientLookup(2,To_Pat,To_Pat_no);toFromCheck(1);}"  />	
			<input type="hidden" name="To_Pat" id="To_Pat"	 		id="To_Pat"		value=""> 			
		</td> 
	</tr>
	<tr>
		<td  class="label" >
			<fmt:message key="eBL.FrmBillingGrp.label" bundle="${bl_labels}"/>
		</td>
		<td  class='fields' colspan='2'>
			<input type="text" name="Frm_bill_Gp" id="Frm_bill_Gp" id="Frm_bill_Gp"  size="30"  maxlength="50" onload="return toFromCheck(1)" onClick="mand_fld();" onBlur="ChangeUpperCase( this );if(this.value!='') BillGpLookup(1,Bill_Gp,Frm_bill_Gp);else  Bill_Gp.value ='';"  >	
			<input type='button' class='button' name="BillGpbut" id="BillGpbut" value='?' onClick="if(mand_fld()){BillGpLookup(1,Bill_Gp,Frm_bill_Gp);toFromCheck(2);}" />	
			<input type="hidden" name="Bill_Gp" id="Bill_Gp"	 		id="Bill_Gp"		value=""> 			
		</td>
	
		<td class="label"  width="10%">
			<fmt:message key="eBL.ToBillingGrp.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<input type="text" name="To_bill_Gp" id="To_bill_Gp" id="To_bill_Gp"  size="30"  maxlength="50" onClick="mand_fld();" onBlur="ChangeUpperCase( this );if(this.value!='') BillGpLookup(1,to_bill,To_bill_Gp);else  to_bill.value ='';" >	
			<input type="button" class="button" name="tobillbut" id="tobillbut" value="?" onClick="if(mand_fld()){BillGpLookup(2,to_bill,To_bill_Gp);toFromCheck(2);}"  />	
			<input type="hidden" name="to_bill" id="to_bill"	 		id="to_bill"		value=""> 			
		</td> 
	</tr>
	<tr>
		<td  class="label" width="25%">
			<fmt:message key="eBL.FrmCustCode.label" bundle="${bl_labels}"/>
		</td>
		<td  class='fields' colspan='2'>
			<input type="text" name="fm_CustCode" id="fm_CustCode" id="fm_CustCode"  size="30"  maxlength="50"  onBlur="ChangeUpperCase( this );if(this.value!='') CustCodeLookup(1,fm_code,fm_CustCode);else  fm_code.value ='';" onClick="mand_fld();" >	
			<input type='button' class='button' name="custcodebut" id="custcodebut" value='?' onClick="if(mand_fld()){CustCodeLookup(1,fm_code,fm_CustCode);toFromCheck(3);}" />	
			<input type="hidden" name="fm_code" id="fm_code"	 		id="fm_code"		value=""> 			
		</td>
		<td class="label"  width="25%">
			<fmt:message key="eBL.ToCustCode.label" bundle="${bl_labels}"/>
		</td>
		<td>
			<input type="text" name="To_CustCode" id="To_CustCode" id="To_CustCode"  size="30"  maxlength="50" onClick="mand_fld();" onBlur="ChangeUpperCase( this );if(this.value!='') CustCodeLookup(2,To_code,To_CustCode);else  To_code.value ='';"  >	
			<input type='button' class='button' name="custcdebut" id="custcdebut" value='?' onClick="if(mand_fld()){CustCodeLookup(2,To_code,To_CustCode);toFromCheck(3);}"  />	
			<input type="hidden" name="To_code" id="To_code"	 		id="To_code"		value=""> 			
		</td> 
	</tr>
	<tr>
	</tr>
	<tr>
		<td  class="label" >
			<fmt:message key="eBL.CutOffDate.label" bundle="${bl_labels}"/>
		</td>
		<td width="17%" class='fields'>
				<input type="text" name="cut_off_date" id="cut_off_date" id="cut_off_date" size="10" maxlength='10' value='' onBlur='return cut_off(document.forms[0].cut_off_date);return dateRegEx(this);'>
				&nbsp <img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('cut_off_date');"><img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>
	<tr>
		<td colspan='0'>
		</td>
		 <td class="label" colspan='2'>
	   		<input type="checkbox" name="inc_cur_ip_dc_pat" id="inc_cur_ip_dc_pat"  id="inc_cur_ip_dc_pat" onclick="if(mand_fld()){include_cur_pat();}else{document.forms[0].inc_cur_ip_dc_pat.checked=false;}" 
			value="<%=value2 %>" <%=disable%> align="right" />&nbsp;&nbsp;&nbsp;
			<fmt:message key="eBL.inc_cur_IP/DC_Pat.label" bundle="${bl_labels}"/>
	    </td>
	</tr>
	<tr>
		<td colspan='0'>
		</td>
		<td class="label">
			<input type="checkbox" name="inc_Zero_rec" id="inc_Zero_rec"  id="inc_Zero_rec" onclick="if(mand_fld()){include_Zero_rec();}else{document.forms[0].inc_Zero_rec.checked=false;}" 
			value="<%=value1 %>" align="right" />&nbsp;&nbsp;&nbsp;
			<fmt:message key="eBL.Inc_Zero_Rcrds.label" bundle="${bl_labels}"/>
		</td>
	</tr>
	</table>		
		
	<input type='hidden' name='locale' id='locale' 		id='locale'			value="<%=locale%>" 	>
	<input type='hidden' name='facilityId' id='facilityId'	id='facilityId' 	value="<%=facilityId%>" >
	<input type="hidden" name="p_module_id" id="p_module_id" id="p_module_id" 	value="BL"	>
	<input type="hidden" name="p_report_id" id="p_report_id" id="p_report_id"	value="BLRUNBRF" >
	<input type="hidden" name="pgm_id" id="pgm_id" 		id="pgm_id"			value=""	> 		
	<input type="hidden" name="p_session_id" id="p_session_id" 	value="">	
	<input type="hidden" name="p_user_name" id="p_user_name" 	value="<%=p_user_name%>">
	<input type="hidden" name="p_pgm_date" id="p_pgm_date"	   value="">
</form>
</BODY>
<%
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.err.println("Exception in BLUnbilledReport.jsp::"+e);
	}
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
		
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</HTML>

