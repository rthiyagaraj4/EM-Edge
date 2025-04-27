<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHSelectQuery,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% //String locale = ((String)session.getAttribute("LOCALE"));	%>
<HTML>
<%
/*	Connection con = null;
	ArrayList arrRow = null,arrCol=null,arrRow1=null;
	XHSelectQuery xhSelect = null;
	String strApplicationId = "";
	Statement stmt = null;
	ResultSet rs  = null;
	String selected = "selected";
	String defaultval = "";
*/
	String filter_yn="";  
%>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>
<script language="JavaScript" src='../../eXH/js/Filterlayer.js'> </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='' action=''>
 <table cellspacing='0' cellpadding='0' width='100%' border=0 align='center'>
  <tr><td>
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Group">
				<a onclick="callJSPs('filterruletab')" class="tabA" id='filterruletab' >
					<span class="tabAspan" id="filterruletab_tabspan"><fmt:message key="eXH.Group.label" bundle="${xh_labels}"/></span>
				</a>
			 </li>
			 <li class="tablistitem" title="Level">
				<a onclick="callJSPs('segmentruletab')" class="tabA" id="segmentruletab" >
					<span class="tabAspan" id="segmentruletab_tabspan"><fmt:message key="eXH.GroupwiseFilterLevel.label" bundle="${xh_labels}"/></span>
				</a>
		  
       </ul>
	 </td>
   </tr>
</table>
	
<input type='hidden' name='jspmode' id='jspmode'>
<input type='hidden' name='filter_yn' id='filter_yn' value='<%=filter_yn%>'>
</form>	
</BODY>
</HTML>

