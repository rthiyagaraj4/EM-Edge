<!DOCTYPE html>
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection conlCon		= null;
	PreparedStatement pstmt = null;
	ResultSet rslRst		= null;
%>
<html>
<head>
	<title>Allowed Doc Types</title>

<style>
 table {
	        
            width: 60%;
            border-collapse: collapse;
             margin: 20px auto;       
            border: 1px solid #ddd;
			
        }
        th, td {
            border: 1px solid #ddd;
        }
</style>	
<%
request.setCharacterEncoding("UTF-8");	
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/AllowedDocTypes.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' OnScroll="scrollTitle()">
<form name='allowed_doc_form' id='allowed_doc_form' action='../../servlet/eCA.AllowedDocTypesServlet' method='post' target='messageFrame'>
<div id='divDataTitle' style="display: flex; justify-content: center; margin-top: 15vh;">
<br><br><br><br><br>
<!-- <table cellpadding='3' cellspacing='0' border='1' width='90%'  align=center> -->
<table class='grid' align=center >

<tr>
	<td class='COLUMNHEADERCENTER' width="80%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER' width="20%"><fmt:message key="eCA.Allowed.label" bundle="${ca_labels}"/></td>
</tr>

</div>
<!-- <table cellpadding='3' cellspacing='0' border='1' width='90%'  align=center> -->

<% int ilCount=0;
	int  ilRow=0;

try
{	
	String obj_type_desc					= "";
	String applicable_yn						= "";
	String obj_type						= "";
	//String slClassValue						="";
	String slClassValue						="gridData";
	
	
	String sql = "select obj_type_desc ,applicable_yn ,obj_type from ca_appl_linked_obj_type order by 1";
	
	conlCon = ConnectionManager.getConnection(request);
	pstmt = conlCon.prepareStatement(sql);
	rslRst = pstmt.executeQuery();
	
	
if(rslRst.next())
{
	do
	{
		obj_type_desc			 = (rslRst.getString("obj_type_desc")==null)?"":rslRst.getString("obj_type_desc");
		
		applicable_yn			 = (rslRst.getString("applicable_yn")==null)?"":rslRst.getString("applicable_yn");
		
		obj_type				 = (rslRst.getString("obj_type")==null)?"":rslRst.getString("obj_type");
		

           /* if(ilRow % 2 == 0)
			{
                slClassValue = "QRYEVEN";
            }else
			{
                slClassValue = "QRYODD";
            }*/
			ilRow ++;
%>
		
<tr>
	<td width='80%'  class='<%=slClassValue %>'><%=obj_type_desc%></td>
	<td < width='20%' class='<%=slClassValue %>'><input type='checkbox'  value="Y" name= 'applicable_yn<%=ilCount%>' <% if(applicable_yn.equals("Y")){ out.println("checked");}%> ></td>
	<input type='hidden' name='obj_type<%=ilCount%>' id='obj_type<%=ilCount%>' value="<%=obj_type%>">
</tr>

<%
		ilCount++;
	}
	while(rslRst.next());
}
ilCount = ilCount-1;

%>
</table>
<input type='hidden' name='count' id='count' value="<%= ilCount %>">
</form>

</body>
</html>
	<%
	if(rslRst!=null) rslRst.close();
	if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Exception in AllowedDocTypesAddModify.jsp :"+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(conlCon != null)ConnectionManager.returnConnection(conlCon,request);
}
%>

