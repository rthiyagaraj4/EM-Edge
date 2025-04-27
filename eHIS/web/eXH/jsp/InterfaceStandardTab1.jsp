<!DOCTYPE html>
<HTML>
<HEAD>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language='JavaScript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language='JavaScript' src='../../eXH/js/Validate.js'></script>

<script language='JavaScript' src='../../eXH/js/InterfaceStandards1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY  leftmargin=0 topmargin=0  bgcolor=''  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>

<form name="MasterMenu_form" id="MasterMenu_form" action='' method='get' target='messageFrame'>

		<table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
        <tr><td>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title='<fmt:message key="Common.Usage.label" bundle="${common_labels}"/>'>
				<a onclick="callJSPs('tab11')" class="tabA" id='tab11' >
					<span class="tabAspan" id="tab1_tabspan"><fmt:message key="eXH.ControlStructure.Label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			 <li class="tablistitem" title='<fmt:message key="eXH.TableValues.Label" bundle="${xh_labels}"/>'>
				<a onclick="callJSPs('tab12')" class="tabA" id="tab12" >
					<span class="tabAspan" id="tab2_tabspan"><fmt:message key="Common.Profile.label" bundle="${common_labels}"/></span>
				</a>
		   </li>
		   <ul>
	 </td>
   </tr>
</table>
		<input type='hidden' name='tab' id='tab' value='element'/>
		<input type='hidden' name='action_type' id='action_type' value='R'/>
		

</form>	
</BODY>
</HTML>


