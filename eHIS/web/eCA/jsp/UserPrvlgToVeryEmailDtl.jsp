<!DOCTYPE html>
<%@ page import="java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
eCA.UserPrvlgToVeryEmailBean UserPrvlgToVeryEmailBean = null;

UserPrvlgToVeryEmailBean = (eCA.UserPrvlgToVeryEmailBean)getObjectFromBean("UserPrvlgToVeryEmailBean","eCA.UserPrvlgToVeryEmailBean",session);
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String from = request.getParameter("from");
String to = request.getParameter("to");
String module_id = request.getParameter("module_id") == null ? "" : request.getParameter("module_id");
String report_id = request.getParameter("report_id") == null ? "" : request.getParameter("report_id");
String searchBy = request.getParameter("searchBy") == null ? "D" : request.getParameter("searchBy");
String searchText = request.getParameter("searchText") == null ? "" : request.getParameter("searchText");
String searchCriteria = request.getParameter("searchCriteria") == null ? "" : request.getParameter("searchCriteria");
ArrayList userList = UserPrvlgToVeryEmailBean.getUserList();
StringBuffer sqlTemp = new StringBuffer();

if(searchCriteria.equals("S")) //if search value is equal to 'Starts with'
{
	if(!searchText.equals("%"))
		searchText = searchText  + "%";
}
else if(searchCriteria.equals("E")) //if search value is equal to 'Ends with'
{
	if(!searchText.equals("%"))
		searchText = "%" + searchText;
}
else //if search value is equal to 'Contains'
{
	if(!searchText.equals("%"))
		searchText = "%" + searchText + "%" ;
}
if(searchBy.equals("D"))
{
	sqlTemp.append(" and UPPER(appl_user_name) like upper(?) order by appl_user_name ");
}
else
{
	sqlTemp.append( " and UPPER(appl_user_id) like upper(?) order by appl_user_id ");
}

int start = 0;
int end = 0;
int i=1;
if (from == null)
	start = 1 ;
else
	start = Integer.parseInt(from);
if (to == null )
	end = 14 ;
else
	end = Integer.parseInt(to) ;
		
int maxRecord = 0;

Connection con = null;
PreparedStatement ps = null;
ResultSet res = null;
StringBuffer sql = new StringBuffer("select appl_user_id appl_user_id, appl_user_name appl_user_name from sm_appl_user ");
sql.append("where eff_status='E' ");
sql.append(sqlTemp.toString());

try
{
	con = ConnectionManager.getConnection(request);

	ps = con.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	ps.setString(1,searchText);
	res = ps.executeQuery();
	while(res.next())
	{
			maxRecord++;
	}
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCA/js/UserPrvlgToVeryEmail.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<form name="UserPrvlgToVeryEmailDtlForm" id="UserPrvlgToVeryEmailDtlForm" action="../../servlet/eCA.UserPrvlgToVeryEmailServlet" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding=3 width='95%' align='center'>
<tr>
<td class='white' width='88%'></td> 
<td  width='25%' nowrap>
<%
if ( !(start <= 1) )
	{
out.println("<A HREF='../../eCA/jsp/UserPrvlgToVeryEmailDtl.jsp?from="+(start-14)+"&to="+(end-14)+"&module_id="+module_id+"&report_id="+report_id+"&searchBy="+searchBy+"&searchText="+URLEncoder.encode(searchText)+"&searchCriteria="+URLEncoder.encode(searchCriteria)+"'"+" text-decoration='none' class='gridLink' style='visibility:visible'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	}
	else
	{
		out.println("<label class='gridLink' style='visibility:hidden'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	
	}

if ( !( (start+14) > maxRecord ) )
	{
	out.println("&nbsp;<A HREF='../../eCA/jsp/UserPrvlgToVeryEmailDtl.jsp?from="+(start+14)+"&to="+(end+14)+"&module_id="+module_id+"&report_id="+report_id+"&searchBy="+searchBy+"&searchText="+URLEncoder.encode(searchText)+"&searchCriteria="+URLEncoder.encode(searchCriteria)+"'"+" text-decoration='none' class='gridLink' style='visibility:visible'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
	else
	{
		out.println("&nbsp;<label class='gridLink' style='visibility:hidden'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	}
%>
</td>
</tr>
</table>
<table class='grid' width='95%' align='center'>
<tr>
<th><fmt:message key='Common.userid.label' bundle='${common_labels}'/></th>
<th><fmt:message key='Common.username.label' bundle='${common_labels}'/></th>
<th><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/></th>
</tr>
<%					
String user_id = "";
String user_name = "";
String classValue = "gridData";
String chkUnchkSel = "";
				
try
{
	res.beforeFirst();
	if (start != 1)
	for(int j=1; j<start; i++,j++)
		res.next();
	while(res.next() && i <= end){
		/*if(i % 2 == 0) classValue = "QRYEVEN";
		else classValue = "QRYODD";*/

		user_id = res.getString(1) == null ? "" : res.getString(1);
		user_name = res.getString(2) == null ? "" : res.getString(2);

		if(userList.contains(user_id)) chkUnchkSel = " checked ";
		else chkUnchkSel = "";

		out.println("<tr>");
		out.println("<td class='"+classValue+"'>"+user_id);
		out.println("<td class='"+classValue+"'>"+user_name);
		out.println("</td><td align='center' class='"+classValue+"' ><input type='checkbox' onclick='addIDToBean(this,\""+user_id+"\")' "+chkUnchkSel+">");
		out.println("</tr>");
		i++;
	}
	if(res != null) res.close();
	
}catch(Exception e){
	
	//out.println("Exception at try of UserPrvlgToVeryEmailDtl.jsp -"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();
}
	if(res != null) res.close();
	if(ps != null) ps.close();
}catch(Exception ee){
	
//out.println("Exception at try-main of UserPrvlgToVeryEmailDtl.jsp -"+ee.toString());//COMMON-ICN-0181		
ee.printStackTrace();
}finally{
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
</table>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
<input type='hidden' name='report_id' id='report_id' value='<%=report_id%>'>
</form>
</body>
</html>
<%putObjectInBean("UserPrvlgToVeryEmailBean",UserPrvlgToVeryEmailBean,session);%>



