<!DOCTYPE html>
<!--Added Against AMS-CRF-0112-->
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<% request.setCharacterEncoding("UTF-8");	%>
<HTML>
<HEAD>
<script type="text/javascript" src="../../eDS/js/PlaceDietOrder.js"></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script type="text/javascript" src="../../eDS/js/DSCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script lanaguage='javascript'>
	function SpecialCharRestrictionNew(event){
		var strCheck = '%"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) 
		{
			window.event.keyCode = 27;
			return false;  
		}
		return true ;
	}

	function windowClosing()
	{
		var size=document.forms[0].size.value;
		var txtremarks=document.forms[0].txtCheck.value;
		if(txtremarks.length > size){
			window.returnValue=txtremarks.substring(0,size);
	     		window.close();
		}
		else{
			var remarks = txtremarks;
			window.returnValue=remarks;
			window.close();
		}
	}

	function setValue(){
		window.returnValue='CL_REM';
		window.close();
	}

	function localTrimString(sInString) {
	  sInString = sInString.replace( /^\s+/g, "" );// strip leading
	  return sInString.replace( /\s+$/g, "" );// strip trailing
	}

	function replaceGreaterThan(obj){
		obj.value = obj.value.replace(/>/,""); 
	}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<% 
		String title=checkForNull(request.getParameter("heading"));
		String remarks=checkForNull(request.getParameter("remarks"));
		String size=checkForNull(request.getParameter("size"));
		remarks = java.net.URLDecoder.decode(remarks,"UTF-8");//IN052628 //IN056028
		if(remarks.equals("undefined") )
			remarks = "";
		String readOnly="";
		String disabled="";
		String readOnlyYN=checkForNull(request.getParameter("readOnlyYN"));
		if(readOnlyYN.equals("Y")){	   
			readOnly="readOnly";
			disabled = "disabled";
		}
		String patient_id = request.getParameter("patient_id"); 	
	 %>
<TITLE><%=title%></title>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</HEAD>

<BODY class="MESSAGE" OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<form>
<table  cellspacing='0'>
<tr>
	<td>		
	<textarea name='txtCheck'  rows='5' cols='67' <%=readOnly%> onkeyup="textAreaLimit1(this,150);" onkeypress="SpecialCharRestrictionNew(event)" onBlur="makeValidString(this)" id='remarks_txt'><%=remarks%></textarea>
	</td>
</tr>
<tr>
	<td class='MESSAGE' align='center'>
		<input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='windowClosing();' <%=disabled%>>		
	</td>
</tr>
</table>
  <input type="hidden" name='patient_id' id='patient_id' value="<%=patient_id%>" >
  <input type="hidden" name="remarks" id="remarks" value="<%=remarks%>" > 
  <input type='hidden' name='size' id='size' value="<%=size%>" >
</form>
</body>
</HTML>

