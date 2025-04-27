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
<script language="JavaScript" src='../../eCommon/js/common.js'> </Script>
<script Language="JavaScript"  src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript" src='../../eXH/js/Validate.js'> </script>								 
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script src='../../eXH/js/FilterLayerReference.js' language='javascript'></script>
<script src='../../eXH/js/FilterCriteriaSettings.js' language='javascript'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY  LEFTMARGIN="0" TOPMARGIN="0" ONMOUSEDOWN="CodeArrest()" onKeyDown='lockKey()' onLoad="searchFiltergroupType();filterDetails();">
<FORM name="FilterSearchForm" id="FilterSearchForm">

<TABLE CELLSPACING=0 CELLPADDING=3 WIDTH='100%' >
<TR>

<TD CLASS="label"><fmt:message key="eXH.FilterGroup.Label" bundle="${xh_labels}"/></TD>
<TD ALIGN="left">
	<INPUT TYPE="text" ID="Filter_group_desc" name="Filter_group_desc" id="Filter_group_desc" onBlur="if(this.value!='')searchFiltergroupType();else Filter_group_desc_id.value='' ">	     
	<INPUT CLASS="button" TYPE="button"  name='ApplictionTypeSearch' id='ApplictionTypeSearch' VALUE='?' onClick="searchFiltergroupType();filterDetails();"> <IMG SRC='../../eCommon/images/mandatory.gif'>
	<INPUT TYPE="hidden" ID="Filter_group_desc_id" name="Filter_group_desc_id" id="Filter_group_desc_id">
</TD>

</TR>
 
</TABLE>

</FORM>	
</BODY>
</HTML>

