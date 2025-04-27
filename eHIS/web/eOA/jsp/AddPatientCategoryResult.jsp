<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*,java.text.*, java.net.*,webbeans.eCommon.*,java.util.*,com.ehis.util.*, eCommon.XSSRequestWrapper" %> 
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eOA/js/ClinicAllocation.js' language='javascript'></script>
<script language="JavaScript">
			function call_modify(obj1,obj2)
			{				
				parent.frames[1].document.forms[0].pat_category.value = obj1;
				parent.frames[1].document.forms[0].no_solts.value = obj2;
				parent.frames[1].document.forms[0].Add.value = 'Modify';
				parent.frames[1].document.forms[0].modify.value = 'Y';
				
			}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
String groupvalues=request.getParameter("groupvalues")==null?"":request.getParameter("groupvalues");
String final_alcn_criteria=request.getParameter("final_alcn_criteria")==null?"":request.getParameter("final_alcn_criteria");
StringTokenizer grouptoken=null;
StringTokenizer valuetoken=null;
String no_slots="";
String grp_code="";
String grp_desc="";


if(final_alcn_criteria!=null && !final_alcn_criteria.equals("")){
	groupvalues=final_alcn_criteria;
}
int countToknes=0;
String finalString="";
%>
<body  OnMouseDown="CodeArrest()"onKeyDown = 'lockKey()' >
</body>
<form name='result_form' id='result_form'>
<table border=0 cellpadding=0 cellspacing=0 width='100%' align='center'>
<th>Delete</th><th><fmt:message key="Common.nationality.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Group.label" bundle="${common_labels}"/></th><th><fmt:message key="eOA.NoofSlots.label" bundle="${oa_labels}"/></th>
<%
grouptoken=new StringTokenizer(groupvalues,"|");
while(grouptoken.hasMoreTokens()){%>
<tr>
<%	valuetoken=new StringTokenizer(grouptoken.nextToken(),"$");
	if(valuetoken.hasMoreTokens()){
		grp_code=valuetoken.nextToken();
		no_slots=valuetoken.nextToken();
		grp_desc=valuetoken.nextToken();
		if(countToknes==0){
			if(!grp_code.equals("OTH"))
				finalString=grp_code+"$"+no_slots+"$"+grp_desc;
		}else{
			if(!grp_code.equals("OTH"))
				finalString=finalString+"|"+grp_code+"$"+no_slots+"$"+grp_desc;
		}
		if(!grp_code.equals("OTH")){
		%>
		<td><input type="checkbox" name='delete<%=countToknes%>' id='delete<%=countToknes%>' value='<%=grp_code%>'/></td>

			<td class='LABEL'  name='groupID<%=countToknes%>' width='30%'><a href="javascript:call_modify('<%=grp_code%>','<%=no_slots%>')"><%=grp_desc%></a></td>

		
		<td class='LABEL' name='slot_no<%=countToknes%>'><%=no_slots%></td>
</tr>
	<%}
		}
		if(!grp_code.equals("OTH"))
			countToknes++;
}
grouptoken=null;


%>
</table>
<input type="hidden" name="finalValue" id="finalValue" value="<%=finalString%>">
<input type="hidden" name="countToknes" id="countToknes" value="<%=countToknes%>">
</form>
</html>

