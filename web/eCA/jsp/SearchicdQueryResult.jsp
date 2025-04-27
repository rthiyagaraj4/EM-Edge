<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String queryString=request.getQueryString();
	String searchTxt="";

%>
<head>
	
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	
	<script src="../../eCA/js/PatProblem.js" language="javascript"></script>
	<script src="../../eCA/js/RecClinicalNotesLinkDiag.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown="lockKey()">
<script>

	var radioval="D";
	function CallDescFrame(){
		var listval=document.forms[0].Search_criteria.options.value;
		var textbox=document.forms[0].Search_text.value;
		var sensitive_yn=document.forms[0].sensitive_yn.value;
		var notifiable=document.forms[0].opt_notifiable.value;
		if(textbox != ""){
				parent.frames[1].location.href='SearchicdcodeQueryResultCtl.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+textbox+'&notifiable_yn='+notifiable;
			 	//parent.frames[2].location.href='SearchicdcodeQueryResult.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+textbox+'&notifiable_yn='+notifiable;

				document.radio.Search.disabled=true;
		}else{
			var msg = getMessage('SEARCH_TEXT_BLANK','Common');
			alert (msg);
		}
	}

	function storeVal(currad){
		radioval = currad.value
	}
	 
	function Change(obj){
		if(obj.checked)	   obj.value = 'Y';
		else	   obj.value = 'N';
	}

</script>

<form name="radio" id="radio">
<table align=cneter border="0" width=100% cellspacing='0' cellpadding='3'>
<tr width='100'>
	<td colspan='2' class="label">
		<fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'><fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class="label" colspan="1" width = '25%'>
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>	
	</td>
	<td class ='fields' >
		<select name="Search_criteria" id="Search_criteria">
			<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td colspan="1" class="label" width = '25%'>
		<B><fmt:message key="Common.RestrictTo.label" bundle="${common_labels}"/></B>&nbsp;<fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/>&nbsp;
		
	</td>
	<td class='fields' width = '25%'><select name="opt_notifiable" id="opt_notifiable">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			<option value="N" ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
	</td>
	<td class="label"  width = '25%'>
		<fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/></td>
	<td class ='fields' width = '25%'>
		<select name="sensitive_yn" id="sensitive_yn">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td class='label' colspan=1  width = '25%'><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td>
	<td class = fields width = '25%' nowrap>
		<input class = fields' type="text"  name="Search_text" id="Search_text" value='<%=searchTxt%>' width=30% align="left" size='20' maxlength='20' onkeypress="return CheckForSpecCharsNoCaps(event);">
		<img src='../../eCommon/images/mandatory.gif' align='center'></img>
	</td>
	<td colspan = 2 width = '50%' align = 'right'>
		<input type="button" width='6%' align="left" name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="CallDescFrame(this)" class='button' >
	</td>
</tr>
</table>
</form>
</body>
</html>

