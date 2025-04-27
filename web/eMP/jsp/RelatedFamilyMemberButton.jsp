<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
  <%
     String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");
	 %>
     <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	 <Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
	 <script language='javascript' src='../../eCommon/js/dchk.js' ></script>
	 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	 <script>
	function onSuccess()
	{
	alert(getMessage('RECORD_MODIFIED','SM'));
	window.close();
	}

	function recordData()
	{
		 cnt =parent.frames[0].document.forms[0].cnt.value
		 var checkedCode="";
		 for(i=0;i<cnt;i++)
		 {
				checkedCode=checkedCode+eval("parent.frames[0].document.forms[0].pat_id"+i+".value")+"|"
				parent.frames[0].document.forms[0].related_pat_ids.value=checkedCode
		}
		
		parent.frames[0].document.forms[0].submit();
	}
	</script>
	<form>
	<table  width='100%'cellpadding='0' cellspacing='0' align='center' border='0' height='100%'>
	<tr>
		<td  align='center' style="background-color:white" >
			<input type="button" name="record" id="record" class='BUTTON' value='<fmt:message key="Common.confirm.label" bundle="${common_labels}"/>' onclick="recordData()">&nbsp;
			<input type="button" name="Close" id="Close" class='BUTTON' value=' <fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="window.close();">
		</td>
	</tr>
	</form>

