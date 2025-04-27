<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper"  %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
	
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/DispLocnTimeTable.js"></script>
	<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	
	
</head>
<!-- <BODY>  -->
<body onMouseDown="" onKeyDown="lockKey()">

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	String facility_id          = (String)session.getValue( "facility_id" );
    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
	
	String bean_id	="DispLocnTimeTableBean";
	String bean_name	="ePH.DispLocnTimeTableBean";
    
	String mode=request.getParameter("mode");
   String code="",desc="";
  DispLocnTimeTableBean bean = (DispLocnTimeTableBean)getBeanObject(bean_id,bean_name ,request);
 
  ArrayList Displist=new ArrayList(); 
  HashMap Displistvalues=new HashMap();
   
  bean.setLanguageId(locale);
  Displist=bean.getDispList(facility_id,locale);
  bean.setMode( mode ) ;
  
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<form name="DispLocnTimeTableHeaderform" id="DispLocnTimeTableHeaderform">
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<tr>
<td  class="label" align="right" ><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/> </td>
                    <td>&nbsp;
                    <select name="DispenseLocation " id="DispenseLocation " onChange="LoadDetail(this,'<%=mode%>');">
					<option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
					<% for(int i=0; i<Displist.size(); i++)
				{
					Displistvalues = (HashMap)Displist.get(i);
					code = (String)Displistvalues.get("code");
                    desc = (String)Displistvalues.get("desc");
			
			%>
            <OPTION value="<%=code%>"><%=desc%></OPTION>
			<%
			
			}
		
			%>
				
  </select>
<img name='mandatory' style="visibility:visible" src="../../eCommon/images/mandatory.gif">

</td>
            <td class="label"></td>
			<td class="label"></td>
</tr>




</table>
<input type="hidden" name="mode" id="mode" VALUE="<%=mode%>">
<input type="hidden" name="language_id" id="language_id" VALUE="<%=locale%>">
<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
</html>

