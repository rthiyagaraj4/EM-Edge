<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eMM.*, eMM.Common.* ,webbeans.eCommon.*, java.sql.*, java.util.Properties, java.util.ArrayList,java.util.HashMap,  eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<% 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
	   ("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
    <script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eCommon/js/common.js' ></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js' ></script>
	<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
	<script language="javascript" src='../../eMM/js/UserAccessForMaterialGroup.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<%
	String search = request.getParameter("search")==null?"":request.getParameter("search");
	String mode = request.getParameter("mode")==null?"":request.getParameter("mode");

	int from = Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
	int to = Integer.parseInt(request.getParameter("to")==null?"0":request.getParameter("to"));
	String bean_id="UserAccessForMaterialGroupBean";
	String bean_name="eMM.UserAccessForMaterialGroupBean";
	String selected="";
	String  material_group_code="";
	String selValue="";
	ArrayList materialGroupList = null;
	UserAccessForMaterialGroupBean bean			= (UserAccessForMaterialGroupBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);
	String user_id = request.getParameter("user_id");
	String highlight = "";

	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
		bean.setMode(mode);
		bean.setUser_id(user_id);
		String classValue = "";
		String eff="";

	if(search.equals("new")){
		bean.clear();
		materialGroupList = (ArrayList)bean.getMaterialGroupList();
		
	
	}
	else
		materialGroupList = bean.getmaterialGroupList();
	
	int maxRecord = (materialGroupList.size() / 5);
	
	if(maxRecord <= to)
		to = maxRecord-1;
	int index=(from*5);
	int count=from;

if(materialGroupList==null || materialGroupList.size()==0){%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
					history.go(-1);
			</script>
			<%}	
%>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="disableCreate()">
		<form name='formUserAccessForMaterialGroup' id='formUserAccessForMaterialGroup'>
			<table  width='90%' border=0 >
				<tr>
					<td class='NONURGENT' align="right">
						<input type=hidden name='from' id='from' value='<%=from%>'>
						<input type=hidden name='to' id='to' value='<%=to%>'>
<%
						if(from > 0) {
%>
							<a href='javascript:submitPrevNext(<%=(from-15)%>,<%=(from-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type=hidden name='prevPage' id='prevPage' value='prev'>
<%
						}
						if(!((from+15) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(from+15)%>,<%=(from+29)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type=hidden name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
			</table>
			<table border="1" align="left" width="100%" cellpadding="0" cellspacing="0">
				<tr>
					<th width='70%'><fmt:message key="eMM.MaterialGroup.label" bundle="${mm_labels}"/></th>
					<th width='20%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
				</tr>
<%

				while(count <= to){
					material_group_code = (String)materialGroupList.get(index++);
					eff=(String)materialGroupList.get(index+2);
						if( (count+1)%2 == 0)  
						classValue="QRYODD";
					else
						classValue="QRYEVEN";

					if(eff.equals("E"))
						highlight = "DATAHIGHLIGHT";
					else
						highlight = "";
%>
					<tr>
						<input type='hidden' name='material_group_<%=count%>' id='material_group_<%=count%>' value='<%=material_group_code%>'>
						<td class='<%=classValue%>' width='70%'>&nbsp;<font class='<%=highlight%>'>  <%=materialGroupList.get(index++)%></font></td>
<%
						if(((String)materialGroupList.get(++index)).equals("E")){
							selected="checked";
							selValue = "Y";
							
						}
						else{
							selected="";
							selValue = "N";
							highlight = "";
						}
%>						<td class='<%=classValue%>' width='20%' ><input type='checkbox' name='check<%=count%>' id='check<%=count%>'  value='<%=selValue%>'  onclick="userGroupCheck(this, '<%=material_group_code%>');" <%=selected%> ></td>
					</tr>
<%
					index+=2;
					count++;
				}
%>
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode%>'>
			<input type='hidden' name='bean_id' id='bean_id' value='<%=bean_id%>'>
			<input type='hidden' name='bean_name' id='bean_name' value='<%=bean_name%>'>
			<input type="hidden" name="user_id" id="user_id" value="<%=user_id%>"> 
			<input type='hidden' name='language_id' id='language_id' value="<%=locale%>">
			<input type="hidden" name="total_item_class" id="total_item_class" value="<%=maxRecord%>">
			<input type="hidden" name="canProcess" id="canProcess" value="">
			<input type="hidden" name="total" id="total" value="">
		</form>
	</body>

<% putObjectInBean(bean_id,bean,request);%>
</html>

