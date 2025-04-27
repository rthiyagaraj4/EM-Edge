<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import="java.util.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>



<%
try
{

	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String code_indicator = (request.getParameter("code_indicator")==null?"":request.getParameter("code_indicator"));
	String diag_desc = (request.getParameter("diag_desc")==null?"":request.getParameter("diag_desc"));
	String title = (request.getParameter("title")==null?"":request.getParameter("title"));
	String p_diag_code = (request.getParameter("p_diag_code")==null?"":request.getParameter("p_diag_code"));
	String p_diag_scheme_desc = (request.getParameter("p_diag_scheme_desc")==null?"":request.getParameter("p_diag_scheme_desc"));
	String Encounter_Id = (request.getParameter("Encounter_Id")==null?"":request.getParameter("Encounter_Id"));
	String p_auth_yn = (request.getParameter("p_auth_yn")==null?"":request.getParameter("p_auth_yn"));
	String cause_indicator = (request.getParameter("cause_indicator")==null?"":request.getParameter("cause_indicator"));
	String Age = (request.getParameter("Age")==null?"":request.getParameter("Age"));
	String Sex = (request.getParameter("Sex")==null?"":request.getParameter("Sex"));
	String Dob = (request.getParameter("Dob")==null?"":request.getParameter("Dob"));

	String currConVals = (request.getParameter("currConVals")==null?"":request.getParameter("currConVals"));
	String convals = (request.getParameter("convals")==null?"":request.getParameter("convals"));
	
	String disable_delete = (currConVals.equals("")?"disabled":"");
	StringTokenizer strToken = new StringTokenizer(currConVals, "~");
	String diag_code = "";
	String curr_diag_desc = "";
	String mode = (request.getParameter("mode")==null?"":request.getParameter("mode"));;
	String p_scheme = (request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme"));;

	String associate_codes  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	
	String param_diag_code  = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");

	String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");

	
	if(!associate_codes.equals(""))
		convals = associate_codes;

	while(strToken.hasMoreTokens())
	{
		diag_code = java.net.URLEncoder.encode((String)strToken.nextToken());
		curr_diag_desc = java.net.URLEncoder.encode((String)strToken.nextToken());
	}

	%>
	<SCRIPT LANGUAGE="JavaScript">

	async function SearchDiagCode()
	{
		
		var dialogHeight= "27.22vh" ;
		var dialogWidth = "44vw" ;
		var status = "no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal = await window.showModalDialog("TermCodeSearchMainFrame.jsp?term_set_id=<%=term_set_id%>&Dob=<%=Dob%>&Age=<%=Age%>&Sex=<%=Sex%>&code_indicator=<%=code_indicator%>",arguments,features);

		//retVal = window.showModalDialog("PaintConsultationFrame.jsp?<%=request.getQueryString()%>",arguments,features);
		
		if(retVal != null)
		{
			document.forms[0].diag_code.value = retVal;
			document.forms[0].diag_code.onblur();
		}
	}
	function doSelect(val)
	{
		var diag_code = document.AddAssociateCodeAddModifyForm.diag_code.value;
		var diag_desc = document.AddAssociateCodeAddModifyForm.diag_desc.value;
		var mode = document.AddAssociateCodeAddModifyForm.mode.value;
			
		 if(val == 'A')
		{
			if(document.AddAssociateCodeAddModifyForm.diag_code.value == '' || document.AddAssociateCodeAddModifyForm.diag_desc.value == '' )
			{
				alert(getMessage('ASS_DIAG_IN_SUF_DATA','MR'));
			}	
			else
			{
				var convals_array = document.AddAssociateCodeAddModifyForm.convals.value.split('|');	
				if(convals_array.length >= 1)
				{
					for(i=0;i<convals_array.length;i++)
					{
						var temp_conval = convals_array[i].split('|');
						for(j=0;j<temp_conval.length;j++)
						{
							var temp_conval_code = temp_conval[j].split('~');
							if(temp_conval_code[0] == diag_code)
							{
								
								var msg=getMessage('AM0141','AM');
								msg= msg.replace('ID',getLabel("Common.Associate.label","Common")+' '+getLabel("Common.code.label","Common"));
								alert(msg);
								document.AddAssociateCodeAddModifyForm.diag_code.value='';
								document.AddAssociateCodeAddModifyForm.diag_desc.value='';
								document.AddAssociateCodeAddModifyForm.diag_code.focus();

								return false;
							}
						}
					}
				}				
				var convals = document.AddAssociateCodeAddModifyForm.convals.value;
				if(document.AddAssociateCodeAddModifyForm.convals.value != "")
					convals +=  "|";
				convals += escape(diag_code) + "~" + escape(diag_desc);
				document.AddAssociateCodeAddModifyForm.convals.value = convals;
			
				//parent.AddAssociateCodeListFrame.location.href = "../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title="+encodeURIComponent('<%=title%>')+"&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=param_diag_code%>&convals=" + convals;
				parent.AddAssociateCodeListFrame.location.href = "../../eMR/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title="+encodeURIComponent('<%=title%>')+"&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=param_diag_code%>&term_set_id=<%=term_set_id%>&convals=" + convals;
				document.AddAssociateCodeAddModifyForm.diag_code.value = "";
				document.AddAssociateCodeAddModifyForm.diag_desc.value = "";
				
			}
			document.AddAssociateCodeAddModifyForm.flag_to_add.value = '';
		}
		else if(val == 'DELETE')
		{
			
			var delconvals = "";
			var del_code = document.AddAssociateCodeAddModifyForm.diag_code.value;
			var convals_array = document.AddAssociateCodeAddModifyForm.convals.value.split('|');
				if(convals_array.length > 0)
				{
					for(i=0;i<convals_array.length;i++)
					{
						
						var temp_conval = convals_array[i].split('|');
						for(j=0;j<temp_conval.length;j++)
						{
							var temp_conval_code = temp_conval[j].split('~');
							if(temp_conval_code[0] != del_code)
								delconvals +=temp_conval[j]+"|";
						}
					}
				}	
				
			
			//parent.AddAssociateCodeListFrame.location.href = "../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title="+encodeURIComponent('<%=title%>')+"&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=param_diag_code%>&convals=" + delconvals;

			parent.AddAssociateCodeListFrame.location.href = "../../eMR/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title="+encodeURIComponent('<%=title%>')+"&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=param_diag_code%>&term_set_id=<%=term_set_id%>&convals=" + delconvals;
			document.AddAssociateCodeAddModifyForm.convals.value =delconvals ;
			document.AddAssociateCodeAddModifyForm.diag_code.value = "";
			document.AddAssociateCodeAddModifyForm.diag_desc.value = "";

		}
		else if(val == 'CANCEL')
		{
			window.returnValue = document.AddAssociateCodeAddModifyForm.convals.value;
			parent.window.close();
		}
		else if(val == 'CLEAR')
		{
			document.AddAssociateCodeAddModifyForm.diag_code.value = "";
			document.AddAssociateCodeAddModifyForm.diag_desc.value = "";
		}
		else if(val == 'OK')
		{			
			window.returnValue = document.AddAssociateCodeAddModifyForm.convals.value;
			window.close();
		}
		else if(val == 'TEMP')
		{			
			if(document.AddAssociateCodeAddModifyForm.flag_to_add.value == 'Y')
				doSelect('A');
			else
				document.AddAssociateCodeAddModifyForm.flag_to_add.value = 'Y';			
		}
	}
	function getDiagDescription(obj)
	{
		if(obj.value != "")
		{
			obj.value = obj.value.toUpperCase();
			var diag_code = obj.value;

			
			var HTMLVal = "<form name='getDiagVal' id='getDiagVal' action='../../eMR/jsp/AddAssociateCodeValidate.jsp'>";
			HTMLVal += "<input type='hidden' name='term_set_code' id='term_set_code' value ='" + diag_code + "'>";
			HTMLVal += "<input type='hidden' name='term_set_id' id='term_set_id' value ='<%=term_set_id%>'>";
			HTMLVal += "<input type='hidden' name='Sex' id='Sex' value ='<%=Sex%>'>";
			HTMLVal += "<input type='hidden' name='Dob' id='Dob' value ='<%=Dob%>'>";
			HTMLVal += "<input type='hidden' name='code_indicator' id='code_indicator' value ='<%=code_indicator%>'>";
			HTMLVal += "<input type='hidden' name='mode' id='mode' value ='Externalcause'>";
			HTMLVal += "</form>";

			parent.messageFrame.document.body.insertAdjacentHTML('beforeend',HTMLVal);
			//parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.document.getDiagVal.submit();

			
		}
		
	}
	async function showLongDescription()
	{
		var dialogHeight= "20vh" ;
		var dialogWidth = "23vw" ;
		var a = document.AddAssociateCodeAddModifyForm.long_desc.value;
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
		await window.showModalDialog("../../eMR/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
	}
	//-->
	</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
	<BODY onKeyDown='lockKey()'>
		<form name="AddAssociateCodeAddModifyForm" id="AddAssociateCodeAddModifyForm">
	<br>				
			<table border='0' cellpadding='0' cellspacing='0' width='80%' align='center'>				
				<tr>
					<td width='15%'>&nbsp;</td>
					<td width='85%'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label" align = "right" width='30%'>
						&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;
					</td>
					<td align = left class="label" >
						<input type="text" name = "diag_code" value = "<%=java.net.URLDecoder.decode(diag_code)%>" onblur = "getDiagDescription(this)" maxlength='5' size='5'>
						<input type="button" name="question" id="question" value= "?" class="button" onclick = 'SearchDiagCode()'>
						<img src='../../eCommon/images/mandatory.gif'></img>					
					</td>
				</tr>
				<!-- <tr>
					<td colspan=2>
					&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>   -->
				<tr>
					<td class="label" align = right>
						&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;
					</td>
					<td align = left class="label">
						<input type="text" name = "diag_desc" value="<%=java.net.URLDecoder.decode(curr_diag_desc)%>" readonly >
						<input type="button" name="exclamation" id="exclamation" value= "!" class="button" disabled onclick="showLongDescription()">
					</td>
				</tr>
				
				<tr>
					<td width='15%'>&nbsp;</td>
					<td width='85%'>&nbsp;</td>
				</tr>
				<tr>
					<td class='button' colspan=2>
						<input type="button" class=BUTTON name="Select" id="Select" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick="doSelect('TEMP')">&nbsp;&nbsp;
						<input type="button" class=BUTTON name="Delete" id="Delete" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.delete.label","common_labels")%>' onClick="return doSelect('DELETE')" <%=disable_delete%>>&nbsp;&nbsp;					
						<input type="button" class=BUTTON name="Ok" id="Ok" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick="doSelect('OK')">&nbsp;&nbsp;
						<input type="button" class=BUTTON name="Clear" id="Clear" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="doSelect('CLEAR')">&nbsp;&nbsp;
						<input type="button" class=BUTTON name="Cancel" id="Cancel" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick="doSelect('CANCEL')">&nbsp;&nbsp;
						</td>
					</tr>
			</table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="convals" id="convals" value="<%=convals%>">
			<input type="hidden" name="long_desc" id="long_desc" value="">
			<input type="hidden" name="flag_to_add" id="flag_to_add" value="">
		</form>
	</BODY>
	</HTML>
<%}
catch(Exception e)
{
	//out.println("Exception in AddAssociateCodeAddModify.jsp" + e.toString());
	e.printStackTrace();
}
%>
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

