<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String queryString=request.getQueryString();

	String searchTxt="";
%>
<head>
	<%
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onKeyDown='lockKey()' onload="CallDescFrame('N');" >
<script>
	function CheckForSpecChars_event(event){
	if(event.keyCode !='13'){
		var strCheck = '"';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return true;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
			return (event.keyCode -= 32);
		return false ;
	}else{
		return false;
	}
}
	var radioval="D";
	function CallDescFrame(validate){
		var listval=document.forms[0].Search_criteria.value;
		var textbox=document.forms[0].Search_text.value;
		var sensitive_yn=document.forms[0].sensitive_yn.value;
		var notifiable = document.forms[0].opt_notifiable.value;
		
		if(validate=='Y'){
			if(textbox.length!=0&&textbox.length>=3){  //Below line modified for this incident [40470]
					parent.frames[1].location.href='CusticdQueryResult.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+encodeURIComponent(textbox)+'&opt_notifiable='+notifiable;
					document.radio.Search.disabled = true;
			}else{ 
				//	parent.frames[1].location.href='../../eCommon/html/blank.html';
				//	var err_msg =getMessage('SPECIFY_3_CHARS_FOR_SEARCH','MR');
				//	alert(err_msg)
				 /*Above line commented and Below line Added for this incident [40470]*/			
                parent.frames[1].location.href='../../eCommon/html/blank.html';				
				setTimeout("clearText(\""+textbox.length+"\")", 100);
			    //End this incident 40470
				

				}
 		}else if(validate=='N'){ //Below line modified for this incident [40470]
				parent.frames[1].location.href='CusticdQueryResult.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+encodeURIComponent(textbox)+'&opt_notifiable='+notifiable;
				document.radio.Search.disabled = true;

		}
	}

	function storeVal(currad)
	{
		radioval = currad.value
	}
	 
	function Change(obj)
	{
		if(obj.checked)
		   obj.value = 'Y';
		else
		   obj.value = 'N';
	}
/*Below line Added for this incident [40470]*/	
function clearText(textval){ 
	if(textval!=0){
        	var err_msg =getMessage('SPECIFY_3_CHARS_FOR_SEARCH','MR');
	        alert(err_msg)
	}else{
        	var msg = getMessage('SEARCH_TEXT_BLANK','Common');
	        alert (msg);
	}	
}
//End this incident  [40470]

	
	
</script>
<form name="radio" id="radio">
<table align=right border="0" width=100% height=80 cellspacing='0' cellpadding='0'>
<tr width='100'>
	<td colspan="1" class="label"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="D"  checked  onclick='storeVal(this)'>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C" onclick='storeVal(this)'><fmt:message key="Common.code.label" bundle="${common_labels}"/>
	</td>
	<td class="label" colspan="1" >
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
		<select name="Search_criteria" id="Search_criteria">
	<!-- 	<option value="M">Match Word</option> -->
			<option value="C" selected><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><!--Defaulted to "contains" against MO-CRF-20143 on 3rd Oct 2018 by Thamizh selvi-->
			<option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>

		</select>
	</td>
</tr>
<tr>
	<td colspan="1" class="label">
		<B><fmt:message key="Common.RestrictTo.label" bundle="${common_labels}"/></B>&nbsp;&nbsp;<fmt:message key="Common.Notifiable.label" bundle="${common_labels}"/>
		<select name="opt_notifiable" id="opt_notifiable">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			<option value="N" ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
	</td>
	<td class="label">
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Sensitive.label" bundle="${common_labels}"/>
		<select name="sensitive_yn" id="sensitive_yn">
			<option value="" selected>--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
			<option value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
			<option value="N"  ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select>
	</td>
</tr>
<tr>
	<td class='label' colspan=1 ><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
		<input type="text" onkeypress="return CheckForSpecChars_event(event);" name="Search_text" id="Search_text" value='<%=searchTxt%>' width='30%' size='30' maxlength='20'>
	</td>
	<td align="right"  >
		<input type="button" width='6%'  name="Search" id="Search" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="CallDescFrame('Y');" class='button' >
	</td>
</tr>
</table>
</form>
</body>
</html>

