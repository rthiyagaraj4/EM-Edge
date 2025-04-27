<!DOCTYPE html>
<%@page import="java.util.*, ePO.*, ePO.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head> 
<%
		request.setCharacterEncoding("UTF-8");
		String locale = (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eMM/js/PoCommon.js"></script>
	<script language="JavaScript" src="../js/MasterType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();' >
<%
	String disabled				=	"" ;
	String mode					=	request.getParameter( "mode" );
	String bean_id				=	"multipleInsertMasterTypeBean";
	String bean_name			=	"ePO.MultipleInsertMasterTypeBean";
	String master_type			=	"";	

	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals( (String)CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;

	MultipleInsertMasterTypeBean bean = (MultipleInsertMasterTypeBean)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));	
	bean.clear() ;
	bean.initialize();
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode( mode ) ;

	if ( mode.equals((String) CommonRepository.getCommonKeyValue( "MODE_MODIFY") )) {
		//bean.loadData();
		 disabled = "disabled";
		 master_type					=	request.getParameter( "master_type" ) ;;
		 bean.setMasterType(master_type);
	}
	
%>
		
<form name="formMaster_type" id="formMaster_type" action="../../ePO/jsp/AddMasterType.jsp" method="post"  target="master_type_detail">
<br>
<br><br>
<table cellpadding=0 cellspacing=0 width="50%" align=center> 
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td  class="label" width='35%'><fmt:message key="ePO.MasterType.label" bundle="${po_labels}"/></td>
	<td  class="fields"  colspan="2">&nbsp;&nbsp;<select name="master_type" id="master_type" onchange="changetype()" <%=disabled%> <%=bean.getMasterType()%>><option value="" >&nbsp;&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;&nbsp;</option>
	<%
	
	ArrayList	arrStore		=	null;
	HashMap		hmStore			=	null;	
	String  master_type_code = "",	desc		=	"";
	String master_type_select				=	"";

	arrStore		=	bean.getMasterTypeList();
	int arrLength	=	arrStore.size();
	for(int i=0;i<arrLength; i++)
	{
		hmStore      		=	(HashMap) arrStore.get(i);
		master_type_code	=	(String)hmStore.get("type");

		desc				=	(String)hmStore.get("desc");
		if(master_type_code.trim().equals(master_type.trim()))
		{
			master_type_select	=	"Selected";
		}
		else
			master_type_select	=	"";

		%>
			<option value="<%=master_type_code%>" <%=master_type_select%> ><%=desc%></option>
		<%
	}
	%>
	</select><img src="../../eCommon/images/mandatory.gif"></img></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden"	name="dept_no_0" id="dept_no_0" value="">
</form>
<%
putObjectInBean(bean_id,bean,request);
%>
</body>

</html>

