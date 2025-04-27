<!DOCTYPE html>
<%@ page import ="java.util.HashMap,java.util.ArrayList,java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML> 

<HEAD>
<%String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
sStyle = "IeStyle.css";
  

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>								 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>

<script language="JavaScript" src='../../eXH/js/Filtergl.js'> </Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<script>
</script>

 



</HEAD>
<BODY  leftmargin=0 topmargin=0  onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad='filterDetails()'>
<form name="FilterSearchForm" id="FilterSearchForm" target='' action=''>

<%
  String fun_id=XHDBAdapter.checkNull(request.getParameter("fun_id"));
 String filter_desc=XHDBAdapter.checkNull(request.getParameter("filter_desc"));
 String Filter_code=XHDBAdapter.checkNull(request.getParameter("Filter_code"));	  	    
%>
<table cellspacing=0 cellpadding=3 width='100%' >
<tr>


<td class="label"> <fmt:message key="eXH.FilterGroup.Label" bundle="${xh_labels}"/></td>
<td align=left><input type='text' name='Filter_group_desc' id='Filter_group_desc' onBlur="if(this.value!='')searchFiltergroupType();else Filter_group_desc_id.value='' "  value="<%=filter_desc%>">	     
<input class="button" type="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch' value='?'    onClick="searchFiltergroupType();filterDetails();"><img src='../../eCommon/images/mandatory.gif'><input type="hidden" name="Filter_group_desc_id" id="Filter_group_desc_id" value="<%=Filter_code%>"></td>

</tr>
 
</table>

</form>	
</BODY>
</HTML>

