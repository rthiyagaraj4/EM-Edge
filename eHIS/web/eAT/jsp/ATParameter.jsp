<!DOCTYPE html>
<html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,java.util.ArrayList" contentType="text/html;charset=UTF-8 " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<script language='javascript' src='../../eAT/js/Atparameter.js'></script>
<head>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
</head>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language='javascript' src='../../eAT/js/Atparameter.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<body>
<br><br><br><br>
<form name="ATParameter_form" id="ATParameter_form"  onload='FocusFirstElement()'  action="../../servlet/eAT.ATParamServlet" method="post"    >  

<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td class=label>
	<fmt:message key="eOT.PreAnaesthesiaNoteType.Label"   bundle="${ot_labels}"/>
	</td>

	<td class="fields">
		<input type="text" name="preanaesthesia_noteType" id="preanaesthesia_noteType" value="" size=20 maxlength=12 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="eOT.IntraAnaesthesiaNoteType.Label"    bundle="${ot_labels}"/>
		 
	</td>
	<td class="fields">
		<input type="text" name="intraanaesthesia_noteType" id="intraanaesthesia_noteType" value="" size=20 maxlength=12 >
		<img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="eOT.PostAnaesthesiaNoteType.Label"    bundle="${ot_labels}"/>
		 
	</td>
	<td class="fields">
		<input type="text" name="postanaesthesia_noteType" id="postanaesthesia_noteType" value="" size=20 maxlength=12 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label>
	<fmt:message key="Common.DiscreteMeasureCode.label"    bundle="${common_labels}"/>
	    
	</td>
	<td class="fields">
		<input type="text" name="discrete_measureCode" id="discrete_measureCode" value="" size=20 maxlength=12 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>


</TABLE>
	
</FORM>
</body>

</html>

