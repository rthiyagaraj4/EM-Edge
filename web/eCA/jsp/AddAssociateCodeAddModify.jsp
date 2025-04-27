<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
try
{
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
	String curr_long_desc = "";
	String mode = (request.getParameter("mode")==null?"":request.getParameter("mode"));;
	String p_scheme = (request.getParameter("p_scheme")==null?"":request.getParameter("p_scheme"));;

	String associate_codes  = request.getParameter("associate_codes")==null?"":request.getParameter("associate_codes");
	String param_diag_code  = request.getParameter("diag_code")==null?"":request.getParameter("diag_code");
	if(!associate_codes.equals(""))
		convals = associate_codes;

	while(strToken.hasMoreTokens())
	{
		diag_code = java.net.URLEncoder.encode((String)strToken.nextToken());
		curr_diag_desc = java.net.URLEncoder.encode((String)strToken.nextToken());
        if(strToken.hasMoreTokens())
		curr_long_desc = java.net.URLEncoder.encode((String)strToken.nextToken());
	}

	%>
	<SCRIPT LANGUAGE="JavaScript">
	<!--
	async function SearchDiagCode()
	{
		var dialogHeight= "27.22" ;
		var dialogWidth = "44" ;
		var status = "no";
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
		retVal =await window.showModalDialog("PaintConsultationFrame.jsp?<%=request.getQueryString()%>",arguments,features);
		if(retVal != null)
		{
			document.forms(0).diag_code.value = retVal;
			document.forms(0).diag_code.onblur();
		}
	}
	function doSelect(val)
	{
		var diag_code = document.AddAssociateCodeAddModifyForm.diag_code.value;
		var diag_desc = document.AddAssociateCodeAddModifyForm.diag_desc.value;
		var long_desc = document.AddAssociateCodeAddModifyForm.long_desc.value;
		var mode = document.AddAssociateCodeAddModifyForm.mode.value;
		if(val == 'A')
		{
			if(document.AddAssociateCodeAddModifyForm.diag_code.value == '' || document.AddAssociateCodeAddModifyForm.diag_desc.value == '' )
			{
				alert(getMessage('ASS_DIAG_IN_SUF_DATA','CA'));
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
								alert(getMessage('ASS_DIAG_UNIQUE_CHK','CA'));

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
				convals += escape(diag_code) + "~" + escape(diag_desc)+"~"+escape(long_desc);
				document.AddAssociateCodeAddModifyForm.convals.value = convals;
				
				parent.AddAssociateCodeListFrame.location.href = "../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title=<%=title%>&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=param_diag_code%>&convals=" + convals;
				document.AddAssociateCodeAddModifyForm.diag_code.value = "";
				document.AddAssociateCodeAddModifyForm.diag_desc.value = "";
				document.AddAssociateCodeAddModifyForm.long_desc.value = "";
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
			parent.AddAssociateCodeListFrame.location.href = "../../eCA/jsp/AddAssociateCodeListOfValues.jsp?code_indicator=<%=code_indicator%>&diag_desc=<%=diag_desc%>&title=<%=title%>&p_diag_code=<%=p_diag_code%>&p_diag_scheme_desc=<%=p_diag_scheme_desc%>&Encounter_Id=<%=Encounter_Id%>&p_auth_yn=<%=p_auth_yn%>&cause_indicator=<%=cause_indicator%>&Age=<%=Age%>&Sex=<%=Sex%>&Dob=<%=Dob%>&p_scheme=<%=p_scheme%>&diag_code=<%=param_diag_code%>&convals=" + delconvals;
			
			document.AddAssociateCodeAddModifyForm.convals.value =delconvals ;
			document.AddAssociateCodeAddModifyForm.diag_code.value = "";
			document.AddAssociateCodeAddModifyForm.diag_desc.value = "";
			document.AddAssociateCodeAddModifyForm.long_desc.value = "";

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
			document.AddAssociateCodeAddModifyForm.long_desc.value = "";
		}
		else if(val == 'OK')
		{			
			window.returnValue = document.AddAssociateCodeAddModifyForm.convals.value;
			window.close();
		}
		else if(val == 'TEMP')
		{		
			document.AddAssociateCodeAddModifyForm.exclamation.disabled=true;
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
			var HTMLVal = "<html>";
			HTMLVal += "<head>";
			HTMLVal += "<body>";
			HTMLVal += "<form name='getDiagValForm' action='../../eCA/jsp/AddAssociateCodeGetDiagVal.jsp'>";
			HTMLVal += "<input type='hidden' name='diag_code' value ='" + escape(diag_code) + "'>";
			HTMLVal += "<input type='hidden' name='p_scheme' value ='<%=p_scheme%>'>";
			HTMLVal += "<input type='hidden' name='Sex' value ='<%=Sex%>'>";
			HTMLVal += "<input type='hidden' name='Dob' value ='<%=Dob%>'>";
			HTMLVal += "<input type='hidden' name='code_indicator' value ='<%=code_indicator%>'>";
			HTMLVal += "</form>";
			HTMLVal += "</body>";
			HTMLVal += "</head>";
			HTMLVal += "</html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.getDiagValForm.submit();
		}
	}
	function showLongDescription()
	{
		var dialogHeight= "20" ;
		var dialogWidth = "23" ;
		var a = document.AddAssociateCodeAddModifyForm.long_desc.value;
		
		var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no";
		window.showModalDialog("../../eCA/jsp/PatProblemDialogLongDesc.jsp?longDesc="+a,"",features);
	}
	//-->
	</SCRIPT>
	</HEAD>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
		<form name="AddAssociateCodeAddModifyForm" id="AddAssociateCodeAddModifyForm">
		
	<br>				
			<table border='0' cellpadding='3' cellspacing='0' width='80%' align='center'>				
				
				<tr>
					<td class="label"  width='30%'>
						&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;
					</td>
					<td class="fields" >
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
					<td class="label" >
						&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;
					</td>
                    <%
						String dis="disabled";
						if(mode.equals("modify"))
                        dis="";  
						%>
					<td class="fields">
						<input type="text" name = "diag_desc" value="<%=java.net.URLDecoder.decode(curr_diag_desc)%>" readonly >
						<input type="button" name="exclamation" id="exclamation" value= "!" class="button" <%=dis%> onclick="showLongDescription()">
					</td>
				</tr>
				
				<!-- <tr>
					<td width='15%'>&nbsp;</td>
					<td width='85%'>&nbsp;</td>
				</tr> -->
				<tr>
					<td align=right colspan=2>
						<input type="button" class=BUTTON name="Select" id="Select" value=' <fmt:message key="Common.Add.label" bundle="${common_labels}"/> ' onClick="doSelect('TEMP')">&nbsp;&nbsp;
						<input type="button" class=BUTTON name="Delete" id="Delete" value=' <fmt:message key="Common.delete.label" bundle="${common_labels}"/> ' onClick="return doSelect('DELETE')" <%=disable_delete%>>&nbsp;&nbsp;					
						<input type="button" class=BUTTON name="Ok" id="Ok" value=' <fmt:message key="Common.ok.label" bundle="${common_labels}"/> ' onClick="doSelect('OK')">&nbsp;&nbsp;
						<input type="button" class=BUTTON name="Clear" id="Clear" value=' <fmt:message key="Common.clear.label" bundle="${common_labels}"/> ' onClick="doSelect('CLEAR')">&nbsp;&nbsp;
						<input type="button" class=BUTTON name="Cancel" id="Cancel" value=' <fmt:message key="Common.cancel.label" bundle="${common_labels}"/> ' onClick="doSelect('CANCEL')">&nbsp;&nbsp;
						</td>
					</tr>
			</table>
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="convals" id="convals" value="<%=convals%>">
			<input type="hidden" name="long_desc" id="long_desc" value="<%=curr_long_desc%>">
			<input type="hidden" name="flag_to_add" id="flag_to_add" value="">
		</form>
	</BODY>
	</HTML>
<%}
catch(Exception e)
{
	//out.println("Exception in AddAssociateCodeAddModify.jsp" + e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
%>

