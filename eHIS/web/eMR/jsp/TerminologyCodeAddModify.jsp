<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eMR
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	11 Jan 2005
--%>
<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>



<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff"); 
Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;
String mode = request.getParameter("mode");
if(mode==null) mode="";

String termcode = request.getParameter("termcode");
if(termcode==null) termcode="";
String termsetid = request.getParameter("termsetid");
if(termsetid==null) termsetid="";
String className= request.getParameter("className");
if(className==null) className = "";


String part_term_code = "";
String codelevel = "";
String codefldlength = "";
String short_desc = "";
String long_desc = "";
String readOnly = "";
String chkede = "checked";
String chkeds = "";
String proc_diad_sel = "";
String proc_diad_sel1 = "";
String proc = "";
String diag = "";
String eff_status = "E";
String select_yn = "Y";
String disable = "";
String disablesel = "";
String codfldlen = "";
String defnlevelSql = "";
String lvldesc = "";
String rdo = "";
//<!--added on 7-5-08-->
String code_indicator = "";
String notifiable_yn  = "";
String sensitive_yn   = "";
String dselect        = "";
String eselect        = "";
String aselect        = "";
String cselect        = "";
String disable_ind    = "";
String dagger_independent_yn    = "";
String dagger_independent_yn_chk    = "";
String dagger_independent_enable    = "disabled";
//added on 9/23/2008
String disable_Sen	  ="";
String disable_Nat	  ="";
String sensitivity_appl_yn	  ="";
String notification_appl_yn	  ="";
//added on 15/10/2008  
String chkAttribute="";
String chkAttribute1="";
String disable_val="disabled";
String highriskcode=""; // Newly added for this CRF [BRU-HIMS-CRF-19.1]
String HIGH_RISK_CODE="";// Newly added for this CRF [BRU-HIMS-CRF-19.1]
String high_risk_long_desc="";// Newly added for this CRF [BRU-HIMS-CRF-19.1]
String locale					= (String)session.getAttribute("LOCALE");// Newly added for this CRF [BRU-HIMS-CRF-19.1]
String high_risk_value=""; // Newly added for this CRF [BRU-HIMS-CRF-19.1]
//
int len = 0;
int codefldlengthInt=30;
codefldlength = request.getParameter("codefldlength");
if(!(codefldlength==null || codefldlength.equals("")))
	codefldlengthInt = Integer.parseInt(codefldlength);
codelevel = request.getParameter("codelevel");
if(codelevel==null) codelevel="";


//3/10/2009 added@3/10/2009

String actual_yn=" " ;
String actualChk=" ";
String potential_yn=" ";
String potentialChk=" ";
String wellness_yn=" ";
String wellnessChk=" ";
int highRiskCnt=0;
Boolean isMultiDescAppl= false; // added by mujafar for ML-MMOH-CRF-1281 START
String multi_desc_yn = "";
String multi_desc_chk="";
String includeynvisibility="visibility=hidden"; // added by mujafar for ML-MMOH-CRF-1281 END

	try
		{
			con = ConnectionManager.getConnection(request);
			isMultiDescAppl = eCommon.Common.CommonBean.isSiteSpecific(con,"MR","ALLOW_MULTI_DESC"); // added by mujafar for ML-MMOH-CRF-1281
			
		String highRiskSql = "select count(*) highRiskCnt from SM_FUNCTION_CONTROL where MODULE_ID='MR' and FUNCTIONALITY_ID='TERM_CD_HG_RSK' and SITE_ID = (select CUSTOMER_ID from SM_SITE_PARAM)  ";
			stmt = con.prepareStatement(highRiskSql);
			rs = stmt.executeQuery();
			if(rs!=null && rs.next()){
				highRiskCnt = rs.getInt("highRiskCnt");
			}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();			
		}catch (Exception e){
			//out.println(e.toString());
			e.printStackTrace();
		}

if(mode.equals("Modify"))
{
	
	//codefldlength = request.getParameter("codefldlength");
	//codelevel = request.getParameter("codelevel");
	disable = "disabled";
	disablesel = "disabled";
	rdo = "ReadOnly";
	disable_val="";
	if(termsetid.equals("ICD10")) // added by mujafar for ML-MMOH-CRF-1281
		includeynvisibility = "visibility=visible";
	
	try
	{
		
		if(codelevel.equals("1"))
		defnlevelSql = "select level_1_code_length,level_1_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("2"))
		defnlevelSql = "select level_2_code_length,level_2_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("3"))
		defnlevelSql = "select level_3_code_length,level_3_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("4"))
		defnlevelSql = "select level_4_code_length,level_4_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("5"))
		defnlevelSql = "select level_5_code_length,level_5_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("6"))
		defnlevelSql = "select level_6_code_length,level_6_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("7"))
		defnlevelSql = "select level_7_code_length,level_7_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("8"))
		defnlevelSql = "select level_8_code_length,level_8_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("9"))
		defnlevelSql = "select level_9_code_length,level_9_desc from mr_term_set where term_set_id=?";
		else if(codelevel.equals("10"))
		defnlevelSql = "select level_10_code_length,level_10_desc from mr_term_set where term_set_id=?";
		stmt = con.prepareStatement(defnlevelSql);
		stmt.setString(1,termsetid);
		rs = stmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{
				codfldlen = rs.getString(1);
				len = Integer.parseInt(codfldlen);
				lvldesc = rs.getString(2)==null?"":rs.getString(2);
			}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
		//String sql = " select TERM_SET_ID,TERM_CODE,CODE_LEVEL, PART_TERM_CODE,LONG_DESC,SHORT_DESC,PROCEDURE_YN,DIAGNOSIS_YN,EFF_STATUS,SELECT_YN from mr_term_code where term_code = ? and term_set_id = ?";

		String sql_term_set = "select notification_appl_yn,sensitivity_appl_yn from mr_term_set where term_set_id = ?";
		stmt = con.prepareStatement(sql_term_set);
		stmt.setString(1,termsetid);
		rs = stmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{
				notification_appl_yn = rs.getString("notification_appl_yn");
				sensitivity_appl_yn = rs.getString("sensitivity_appl_yn");
				
				if(notification_appl_yn.equals("Y"))
					disable_Nat="";
				else
					disable_Nat="disabled";
				if(sensitivity_appl_yn.equals("Y"))
					disable_Sen="";
				else
					disable_Sen="disabled";
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}

		//<!--added on 7-5-08-->
		String sql = " select TERM_SET_ID,TERM_CODE,CODE_LEVEL, PART_TERM_CODE,LONG_DESC,SHORT_DESC,PROCEDURE_YN,DIAGNOSIS_YN,EFF_STATUS,SELECT_YN,SENSITIVE_YN,NOTIFIABLE_YN,CROSS_REF_TYPE,ACTUAL_YN, POTENTIAL_YN, WELLNESS_YN , dagger_independent_yn,HIGH_RISK_CODE,MULTI_DESC_YN from mr_term_code  where term_code = ? and term_set_id = ?"; // added by mujafar for ML-MMOH-CRF-1281
		//

		stmt = con.prepareStatement(sql);
		stmt.setString(1,termcode);
		stmt.setString(2,termsetid);
		rs = stmt.executeQuery();
		if(rs!=null)
		{
			if(rs.next())
			{
				part_term_code = rs.getString("PART_TERM_CODE");
				if(part_term_code==null) part_term_code = "";
				codelevel = rs.getString("CODE_LEVEL");
				termsetid = rs.getString("TERM_SET_ID");
				termcode = rs.getString("TERM_CODE");
				short_desc = rs.getString("SHORT_DESC");
				long_desc = rs.getString("LONG_DESC");
				high_risk_value = rs.getString("HIGH_RISK_CODE");
				if(long_desc==null) long_desc = "";
				proc = rs.getString("PROCEDURE_YN");
				diag = rs.getString("DIAGNOSIS_YN");
				if(proc.equals("Y"))
				{
					proc_diad_sel = "selected";
					proc_diad_sel1 = "";
				}
				else if(diag.equals("Y"))
				{
					proc_diad_sel = "";
					proc_diad_sel1 = "selected";
				}
				else if((proc.equals("N")) && (diag.equals("N")))
				{
					disable = "";
				}


				eff_status = rs.getString("EFF_STATUS");
				if(eff_status.equals("E"))
				{
					chkede = "checked";
					readOnly = "";
					disablesel = "";
				}
				else if(eff_status.equals("D"))
				{
					chkede = "";
					readOnly = "ReadOnly";
					disablesel = "disabled";
				}
				select_yn = rs.getString("SELECT_YN");
				if(select_yn.equals("Y"))
				{
					chkAttribute1 = "checked";
					
				}
				else if(select_yn.equals("N"))
				{
					chkAttribute1 = "";
					
				}
				//added on 7-5-08
				sensitive_yn = rs.getString("SENSITIVE_YN");
				if(sensitive_yn.equals("Y")){
					chkeds = "checked";
					//disable_Sen="";
									
					
				}
				else{
					chkeds = "";
					//disable_Sen="disabled";
					
				}
			
				notifiable_yn = rs.getString("NOTIFIABLE_YN");
				if(notifiable_yn.equals("Y")){
					chkAttribute = "checked";
					//9/24/2008 append code for disable_Nat
					//disable_Nat=" ";
				}
				else{
					chkAttribute = "";
					//9/24/2008 append code for disable_Nat
					//disable_Nat="disabled";
				}
				code_indicator = rs.getString("CROSS_REF_TYPE");
			
				if(code_indicator == null) code_indicator = "";
				
			/*	if(!code_indicator.equals(""))
					disable_ind = "disabled";
				else
					disable_ind = ""; */
			if(diag.equals("Y"))
				{
					if(code_indicator.equals("D"))
					{
						dselect = "selected";
						disable_ind="disabled";
					}
					else if(code_indicator.equals("E"))
						eselect = "selected";
					else if(code_indicator.equals("A"))
					{
						aselect = "selected";
						dagger_independent_enable = "";
					}
					else if(code_indicator.equals("C"))
						cselect = "selected";
				}

				actual_yn = rs.getString("ACTUAL_YN");
				if(actual_yn.equals("Y")){
					actualChk = "checked";					
				}
				else{
					actualChk = "";					
				}
				potential_yn = rs.getString("POTENTIAL_YN");
				if(potential_yn.equals("Y")){
					potentialChk = "checked";					
				}
				else{
					potentialChk = "";					
				}
				wellness_yn = rs.getString("WELLNESS_YN");
				multi_desc_yn= rs.getString("MULTI_DESC_YN"); // added by mujafar for ML-MMOH-CRF-1281 start

				if(multi_desc_yn.equals("Y")){
					multi_desc_chk = "checked";					
				}
				else{
					multi_desc_chk = "";					
				} // added by mujafar for ML-MMOH-CRF-1281 end

				if(wellness_yn.equals("Y")){
					wellnessChk = "checked";					
				}
				else{
					wellnessChk = "";					
				}
				/*Monday, January 25, 2010 SRR20056-CRF-0303.2 [IN:015597]*/
				dagger_independent_yn = rs.getString("dagger_independent_yn");
				if(dagger_independent_yn == null) dagger_independent_yn = "";
					if(dagger_independent_yn.equals("Y"))
					{
						dagger_independent_yn_chk = "checked";
							
					}
					else
					{
						dagger_independent_yn_chk = "";
					}
				

				//
			}
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
		}
	}
	catch (Exception e)
	{
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	//	ConnectionManager.returnConnection(con,request);
	}
}
%>
<SCRIPT LANGUAGE="JavaScript">


async function longdesc()
{	
	var terminology_set = parent.frames[1].document.forms[0].terminology_set.value;
	if(terminology_set !="")
	{
	var retVal =    new String();
	var termcode = document.term_code_addmodify.termcode.value;
	var long_desc = document.term_code_addmodify.long_desc.value;
	var read_only = document.term_code_addmodify.read_only.value;
	var mode = document.term_code_addmodify.mode.value;
	var dialogHeight= "10vh" ;
	var dialogWidth = "25vw" ;
	var status = "no";
	var arguments = "";
	var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog( "../../eMR/jsp/TerminologyCodeLongDescShowModal.jsp?terminology_set="+terminology_set+"&termcode="+termcode+"&mode="+mode+"&read_only="+read_only,arguments,features);
	if(retVal!=undefined)
    {
		document.term_code_addmodify.long_desc.value = retVal;
	}
	}

}
 
function chksrno1(obj)
{
	if(obj.checked)
	{
		obj.value = "E";
	}
	else
	{
		obj.value = "D";
	}
}

function chksrno(obj){

	if(obj.checked){
		obj.value = "Y";
	}else{
		obj.value = "N";
	}
	if('<%=highRiskCnt%>' > 0 && obj.name == 'sensitive'){ //Condtion Added for this incident[IN:036870]
		if(obj.value=='Y' && document.term_code_addmodify.diag.value!="" && document.term_code_addmodify.diag.value=="Y"){ // Condition Newly Added for this CRF [BRU-HIMS-CRF-19.1]*/	
			document.term_code_addmodify.High_risk_cndn_code.value="";  
			document.term_code_addmodify.High_risk_cndn_code.disabled=false;
		}else{
			document.term_code_addmodify.High_risk_cndn_code.value="";
			document.term_code_addmodify.High_risk_cndn_code.disabled=true;
	 } //  Condition Ended for this CRF [BRU-HIMS-CRF-19.1]*/
   }
}

function chkMaxlength()
{
	var val = document.term_code_addmodify.term_code.value;   
	var fldlen = eval(document.term_code_addmodify.codefldlength.value);   
	var len = eval(val.length);   

	
	if(val!="")
	{
		if(len < fldlen)        
		{
		//	document.term_code_addmodify.term_code.focus();
		}
	}
}

function CheckForSpecCharsLocal(event){
    //var strCheck = '.0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ/._';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}
/*function disableFields()
{
	document.term_code_addmodify.term_code.disabled=true;
	document.term_code_addmodify.short_desc.disabled=true;
	document.term_code_addmodify.proc_diag.disabled=true;
	document.term_code_addmodify.selectable.disabled=true;
	document.term_code_addmodify.eff_status.disabled=true;
	document.term_code_addmodify.eff_status.checked=false;
	document.term_code_addmodify.active.disabled=true;
	document.term_code_addmodify.potential.disabled=true;
	document.term_code_addmodify.wellness.disabled=true;
	document.term_code_addmodify.sensitive.disabled=true;
	document.term_code_addmodify.notifiable.disabled=true;
	document.term_code_addmodify.code_indicator.disabled=true;
	
}*/
function checkIndicator(obj)
{
	if(obj.value == 'A')
		document.forms[0].dagger_independent_yn.disabled = false;
	else
	{
		document.forms[0].dagger_independent_yn.disabled = true;
		document.forms[0].dagger_independent_yn.checked  = false;
	}

}
function disIndicator(obj)
{
	if(obj.value == 'P')
	{
		document.forms[0].code_indicator.disabled = true;
		document.forms[0].code_indicator.value    = "";
		document.forms[0].dagger_independent_yn.disabled = true;
		document.forms[0].dagger_independent_yn.checked  = false;
	}
	else
		document.forms[0].code_indicator.disabled = false;


}
function CheckForSpecChars_Sdesc(event)
	{
	var strCheck ='$|@';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1 && whichCode != 92) return true; // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return false ;
}


function windcls()
{   
	var obj = document.termcode_long_desc.long_desc;
	checkForMax(obj,400);
	window.returnValue = obj.value;
	window.close();
}


function checkForMax(obj,ldmaxSize)
{
	var longdesctext=obj.value;
	if(longdesctext.length >= ldmaxSize){
		var error=getMessage('REMARKS_NOT_EXCEED_200_CH','SM');
		error=error.replace('Remarks',getLabel("Common.longdescription.label","Common"));
		error=error.replace('200',ldmaxSize);
		alert(error);
		var revertField = obj.value.slice(0,ldmaxSize);
   		obj.value = revertField;
		obj.focus();
	}
} 

 function notallowenter(event)
{
	if(window.event.keyCode==13)
	{
		return false;
	}
//	return document.termcode_long_desc.long_desc.value.length<400;
} 

</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
<style>
textarea {
  resize: none;
}
</style>
<body OnMouseDown='CodeArrest()' onKeyDown='lockKey()' >
<FORM METHOD=POST target='messageFrame' ACTION="../../servlet/eMR.TerminologyCodeServlet" name='term_code_addmodify' id='term_code_addmodify'>
<TABLE border="0" cellpadding="0" cellspacing="0" width="100%" align='center'>
<TR>
	<td id='classificationlabel' colspan='9' class="COLUMNHEADER"><%=lvldesc%></td>
</TR>
<TR>
	<TD class='label' ><fmt:message key="Common.code.label" bundle="${common_labels}"/></TD>
	<!--<TD class='fields' width='20%'><INPUT TYPE="text" name="term_code" id="term_code" onblur='chkMaxlength()'  onKeyPress="return CheckForSpecChars(event);" maxlength='<%=codefldlengthInt%>' value='<%=part_term_code%>' <%=rdo%> size='<%=len%>'><img src='../../eCommon/images/mandatory.gif'></img>
	<td class='label' width='20%'><A HREF="javascript:longdesc()"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></A>
	<img src='../../eCommon/images/mandatory.gif'></img></TD>-->
	<TD class='fields' >&nbsp;<INPUT TYPE="text" name="term_code" id="term_code" onblur='chkMaxlength()'  onKeyPress="return CheckForSpecCharsLocal(event);" maxlength='<%=codefldlengthInt%>' value='<%=termcode%>' <%=rdo%> size='<%=len%>' <%=disable_val%>><img src='../../eCommon/images/mandatory.gif'></img>
	

    	<TD class='label' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></TD>
	<TD class='fields' >&nbsp;<SELECT name="proc_diag" id="proc_diag" disabled onchange ="disIndicator(this)" <%=disable%>>
			<OPTION value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</OPTION>
			<OPTION value='P' <%=proc_diad_sel%>><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></OPTION>
			<OPTION value='D' <%=proc_diad_sel1%>><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></OPTION>
		</SELECT><img src='../../eCommon/images/mandatory.gif'></img></td>

				<TD class='label' ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></TD>
	<TD class='fields' colspan=3>&nbsp;<INPUT TYPE="text" name="short_desc" id="short_desc" size='40' value="<%=short_desc%>" onblur="makeValidString(this);"  onKeyPress="return CheckForSpecChars_Sdesc(event);" maxlength='100' <%=readOnly%> <%=disable_val%> >	<img src='../../eCommon/images/mandatory.gif'></img></TD>


 
	
</TR>
		<td class='label' nowrap><fmt:message key="eMR.Selectable.label" bundle="${mr_labels}"/></td>
	<!--	<td class='fields' width='10%'><INPUT TYPE="checkbox" name="selectable" id="selectable" <%=chkeds%> <%=disablesel%> onclick="chksrno(this)" value="<%=select_yn%>"></td> -->
		
		<td class='fields'  ><INPUT TYPE="checkbox" name="selectable" id="selectable" <%=chkAttribute1%> <%=disable_val%> onclick="chksrno(this)" value="<%=select_yn%>"></td>
		<td class='label' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		<td class='fields' ><INPUT TYPE="checkbox" name="eff_status" id="eff_status"  <%=chkede%> onclick="chksrno1(this)" value="<%=eff_status%>" <%=disable_val%>></TD>
			<td class='label' ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='fields' >&nbsp;<textarea NAME="long_desc" <%=readOnly%> onkeypress='return notallowenter(event);' 
				onkeydown="checkForMax(this,400);" onblur="makeValidString(this);" ROWS="2" COLS="34"  <%=disable_val%> ><%=long_desc%></textarea><img src='../../eCommon/images/mandatory.gif'></img></TD>


</tr>
<TR>
	<TD CLASS='label' nowrap ><fmt:message key="Common.Potential.label" bundle="${common_labels}"/></TD>
	<TD CLASS='FIELDS' ><INPUT TYPE='CHECKBOX' name='potential' id='potential' SIZE=1 MAXLENGTH=1  VALUE='<%=potential_yn%>'  <%=potentialChk%> <%=disable_val%>  onclick="chksrno(this)"></TD>
	<TD CLASS='label' nowrap ><fmt:message key="Common.Wellness.label" bundle="${common_labels}"/></TD>
	<TD CLASS='FIELDS' ><INPUT TYPE='CHECKBOX' name='wellness' id='wellness' SIZE=1 MAXLENGTH=1  VALUE='<%=wellness_yn%>'  <%=wellnessChk%>  <%=disable_val%> onclick="chksrno(this)"></TD>
	<%
	if(isMultiDescAppl) // added by mujafar for ML-MMOH-CRF-1281 start
	{ 
	%>
	
	<TD CLASS='label'  nowrap ><span id='show_multi_desc' name="show_multi_desc" style ="<%=includeynvisibility%>" ><fmt:message key="eMR.AllowMultiDesc.label" bundle="${mr_labels}"/></span></TD>
	<TD CLASS='FIELDS'   ><span id='show_desc' name="show_desc" style ="<%=includeynvisibility%>" ><INPUT TYPE='CHECKBOX' name='multi_desc' id='multi_desc' SIZE=1 MAXLENGTH=1  VALUE='<%=multi_desc_yn%>'  <%=multi_desc_chk%>  <%=disable_val%> onclick="chksrno(this)"></span></TD>
	
	<%
	}
	else
	{
	%>
	<td colspan=2 class='fields'></td>
	<%
	} // added by mujafar for ML-MMOH-CRF-1281 end
	%>

</TR>
<!--added on 7-5-08 if(mode.equals("Modify")) -->

<tr>
		<TD CLASS='label' nowrap ><fmt:message key="Common.Actual.label" bundle="${common_labels}"/></TD>
		<TD CLASS='FIELDS' ><INPUT TYPE='CHECKBOX' name='active' id='active' SIZE=1 MAXLENGTH=1  VALUE='<%=actual_yn%>'  <%=actualChk%> <%=disable_val%> onclick="chksrno(this)"></TD>


		<td class='label'  nowrap><fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></td>
	
	<!--<td class='fields' width='10%'><input type='checkbox' name='sensitive' id='sensitive' size=1 maxlength=1 <%=chkeds%> value='<%=sensitive_yn%>' <%=disable_Sen%> onclick="chksrno(this)"></td>-->
	<%if(mode.equals("Modify")){%>
	<td class='fields' ><input type='checkbox' name='sensitive' id='sensitive' size=1 maxlength=1 <%=chkeds%> value='<%=sensitive_yn%>' <%=disable_Sen%> onclick="chksrno(this)"></td>
	<%}else{%>

	<td class='fields'><input type='checkbox' name='sensitive' id='sensitive' size=1 maxlength=1 <%=chkeds%> value='<%=sensitive_yn%>' <%=disable_val%> onclick="chksrno(this)"></td>
	<%}%>
	<%if(highRiskCnt > 0){%>
	<!--td colspan=2 class='fields'></td-->
	<td class='label' nowrap>
	<fmt:message key="Common.HighRiskConditions.label" bundle="${common_labels}"/></td><td  class='fields'><SELECT name="High_risk_cndn_code" id="High_risk_cndn_code"  disabled value='<%=high_risk_value%>' onblur="makeValidString(this);">
	<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
	<!-- Above High RISK Condititon Added for this CRF [BRU-HIMS-CRF-19.1]-->
	<%
		
		try
		{
		//	con = ConnectionManager.getConnection(request);
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();		
			highriskcode = "select HIGH_RISK_CODE,LONG_DESC from mr_high_risk_lang_vw where eff_status='E' and LANGUAGE_ID='"+locale+"'order by LONG_DESC";
			stmt = con.prepareStatement(highriskcode);
			rs = stmt.executeQuery();
			if(rs!=null)
			{
				while(rs.next())
				{
					HIGH_RISK_CODE = rs.getString("HIGH_RISK_CODE");
					high_risk_long_desc = rs.getString("LONG_DESC");
					if(high_risk_value != null && high_risk_value.equals(HIGH_RISK_CODE)){
					out.println("<option value='"+HIGH_RISK_CODE+"' selected>"+high_risk_long_desc+"</option>");
					}
					else{
						out.println("<option value='"+HIGH_RISK_CODE+"'>"+high_risk_long_desc+"</option>");
					}
				}
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}

		}
		catch (Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con,request);
		}
	}%>		
	</td>
	<td ></td>
	<td></td>
</tr>


<tr>



	<td class='label'  nowrap><fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/></td>
		<%if(mode.equals("Modify")){%>

			<td class='fields' ><input type='checkbox' name='notifiable' id='notifiable' size=1 maxlength=1  <%=chkAttribute%> value='<%=notifiable_yn%>' <%=disable_Nat%> onclick="chksrno(this)"></td>
		<%}else{%>
	<td class='fields' ><input type='checkbox' name='notifiable' id='notifiable' size=1 maxlength=1  <%=chkAttribute%> value='<%=notifiable_yn%>' <%=disable_val%> onclick="chksrno(this)"></td>
	<%}%>

	<td class='label' nowrap ><fmt:message key="Common.CodeIndicator.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<select name='code_indicator' id='code_indicator' <%if(proc.equals("Y"))%>disabled <%=disable_val%> onchange = "checkIndicator(this)" ><option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>

	<!--<td class='fields' width='20%'><select name='code_indicator' id='code_indicator' <%=disable_ind%>><option value=''>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option> -->



		
				<option value='D' <%=dselect%> ><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/></option> 
				<option value='E' <%=eselect%> ><fmt:message key="eMR.ExternalCause.label" bundle="${mr_labels}"/></option>
				<option value='A' <%=aselect%> ><fmt:message key="eMR.Asterisk.label" bundle="${mr_labels}"/></option>
				<option value='C' <%=cselect%> ><fmt:message key="eMR.Consequence.label" bundle="${mr_labels}"/></option>				
				</select>
	</td>
	<TD CLASS='LABEL' nowrap ><fmt:message key="eMR.Dagger.label" bundle="${mr_labels}"/>&nbsp;<fmt:message key="eMR.independent.label" bundle="${mr_labels}"/></TD><TD CLASS='FIELDS' ><INPUT TYPE='CHECKBOX' name='dagger_independent_yn' id='dagger_independent_yn' SIZE=1 MAXLENGTH=1  VALUE='<%=dagger_independent_yn%>'     onclick="chksrno(this)"  <%=dagger_independent_yn_chk%> <%=dagger_independent_enable%>></TD>
</tr>

</TABLE>
<!-- <INPUT TYPE="hidden" name="long_desc" id="long_desc" value="<%=java.net.URLEncoder.encode(long_desc)%>">  
 -->
<INPUT TYPE="hidden" name="read_only" id="read_only" value="<%=readOnly%>">
<INPUT TYPE="hidden" name="termsetid" id="termsetid" value="<%=termsetid%>">
<INPUT TYPE="hidden" name="codelevel" id="codelevel" value="<%=codelevel%>">
<INPUT TYPE="hidden" name="termcode" id="termcode"  value="<%=termcode%>">
<INPUT TYPE="hidden" name="part_term_code" id="part_term_code" value="<%=part_term_code%>">
<INPUT TYPE="hidden" name="codefldlength" id="codefldlength" value="<%=codefldlengthInt%>">
<INPUT TYPE="hidden" name="mode" id="mode"	  value="<%=mode%>">
<INPUT TYPE="hidden" name="className" id="className" value="<%=className%>">
<INPUT TYPE="hidden" name="disable_val" id="disable_val" value="<%=disable_val%>">
<%/*Hidden field Added for this incident  [IN:036870]*/%>
<INPUT TYPE="hidden" name="proc" id="proc" value="<%=proc%>">
<INPUT TYPE="hidden" name="diag" id="diag" value="<%=diag%>">  
<INPUT TYPE="hidden" name="isMultiDescAppl" id="isMultiDescAppl" value="<%=isMultiDescAppl%>"> <!-- added by mujafar for ML-MMOH-CRF-1281 -->

<script>
if('<%=highRiskCnt%>' > 0) { 
	if('<%=sensitive_yn%>' == "Y" && '<%=diag%>'=="Y"){ //condtion Added for this incident [IN:036870]
		document.term_code_addmodify.High_risk_cndn_code.disabled=false;
	}else{
		document.term_code_addmodify.High_risk_cndn_code.disabled=true;
	}
}
</script>
</FORM>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	
%>

