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
	//Commented the below code against MO-CRF-20143 on 4th Oct 2018 by Thamizh selvi 
	/*String dfltSearchYn	= request.getParameter("dfltSearchYn")==null?"C":request.getParameter("dfltSearchYn");
	
	String selectC = "";
	String selectS = "";

	if(dfltSearchYn.equals("S"))
		selectC = "selected";
	else 
		selectS = "selected";
	*/
	
%>
<head>
	
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>

function CheckForSpecChars_event(event){
	if(event.keyCode!='13'){
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
	</script> 
</head>
<script>

	var radioval="D";
	function CallDescFrame(){
		var listval=document.forms[0].Search_criteria.value;
		var textbox=document.forms[0].Search_text.value;
		var sensitive_yn=document.forms[0].sensitive_yn.value;
		var notifiable=document.forms[0].opt_notifiable.value;
		/*
		if(textbox.indexOf("'")!=-1)
		{			
			textbox = textbox.replace("'","''");
		}
		*/
		
		if(textbox != ""){
			if(textbox.length!=0&&textbox.length>=3){
						parent.frames[1].location.href='SearchicdcodeQueryResultCtl.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+encodeURIComponent(textbox)+'&notifiable_yn='+notifiable;
					//modified incident [IN:040385]
					//parent.frames[2].location.href='SearchicdcodeQueryResult.jsp?<%=queryString%>&Search_By='+radioval+'&Search_Criteria='+listval+'&sensitive_yn='+sensitive_yn+'&Search_Text='+textbox+'&notifiable_yn='+notifiable;
						document.radio.Search.disabled=true;
			}else{
				parent.codedesc.document.location='../../eCommon/html/blank.html';
				parent.prevnextframe.document.location='../../eCommon/html/blank.html';
				
				//var err_msg =getMessage('SPECIFY_3_CHARS_FOR_SEARCH','MR');
				//alert(err_msg)
				/*Above line commented and Below line Added for this incident [40470]*/	
				parent.frames[1].location.href='../../eCommon/html/blank.html';
				parent.frames[2].location.href='../../eCommon/html/blank.html';
				setTimeout("clearText(\""+textbox.length+"\")", 100);
				//End this incident 40470
			}
		}else{
				//var msg = getMessage('SEARCH_TEXT_BLANK','Common');
				//alert (msg);	
                /*Above line commented and Below line Added for this incident [40470]*/				
				parent.codedesc.document.location='../../eCommon/html/blank.html';
				parent.prevnextframe.document.location='../../eCommon/html/blank.html';
				parent.frames[1].location.href='../../eCommon/html/blank.html';
				parent.frames[2].location.href='../../eCommon/html/blank.html';				
				setTimeout("clearText(\""+textbox.length+"\")", 100);
			    //End this incident 40470
				
		}
	}

	function storeVal(currad){
		radioval = currad.value
	}
	 
	function Change(obj){
		if(obj.checked)	   obj.value = 'Y';
		else	   obj.value = 'N';
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
<body onKeyDown='lockKey()' >

<form name="radio" id="radio" >
<table align=cneter border="0" width=98% cellspacing='0' cellpadding='3'>
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
			<option value="C" selected><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option><!--Defaulted to "contains" against MO-CRF-20143 on 4th Oct 2018 by Thamizh selvi-->
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
		<input class = fields' type="text"  name="Search_text" id="Search_text" onkeypress="return CheckForSpecChars_event(event)" value='<%=searchTxt%>' width=30% align="left" size='20' maxlength='20' >
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

