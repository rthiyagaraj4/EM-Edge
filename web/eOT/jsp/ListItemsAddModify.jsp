<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eOT/js/ListItems.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!--body onload="parent.parent.commontoolbarFrame.document.forms[0].reset.disabled=false;" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
Connection con=ConnectionManager.getConnection(request);;
PreparedStatement stmt=null;
ResultSet rs=null;
String mode=request.getParameter("update_mode_yn");
String list_id = request.getParameter("list_id")==null?"":request.getParameter( "list_id" );
if(list_id.equals("null") || list_id=="null"){
	list_id="";
}
//String disable_flag="";
String list_id_disable="";
String list_description="";
String sql="";
StringBuffer list_id_from_DB=new StringBuffer();
if(mode.equals("modify"))
{
	try{
		
		//sql="SELECT LIST_ID, LIST_DESC FROM OT_CHECKLIST_LISTVALS_HDR WHERE LIST_ID=? ";
		sql="SELECT LIST_ID, LIST_DESC FROM OT_CHKLIST_LISTVAL_HDR_LANG_VW WHERE LIST_ID=? AND LANGUAGE_ID = ?";

		stmt=con.prepareStatement(sql);
		stmt.setString(1,list_id);
		stmt.setString(2,list_id);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next()){
			list_id=rs.getString(1);
			list_description=rs.getString(2);
		}
				
	list_id_disable="disabled";	
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception"+e);
			}
		
		}
}else if(mode.equals("insert")){
   
		try{
		//con=ConnectionManager.getConnection(request);
		sql="SELECT LIST_ID FROM OT_CHECKLIST_LISTVALS_HDR";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
        		
		while(rs!=null && rs.next())
		{
			list_id_from_DB=list_id_from_DB.append(",").append(rs.getString(1));
		}
	}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
	}

%>
<form name="listItemsHdr" id="listItemsHdr"  onload='FocusFirstElement()'  action="" method="" target="messageFrame"> 

<table border=0 cellspacing=0 cellpadding=3 width='60%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>

<tr>
	<td class=label width='25%'><fmt:message key="Common.ListID.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="list_id" id="list_id" value="<%=list_id%>" size=6 maxlength=6  <%=list_id_disable%> onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

<tr>
	<td class=label width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="description" id="description" value="<%=list_description%>"  size=30 maxlength=30 >
	<img src='../../eCommon/images/mandatory.gif'></td>
</tr>


<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='list_id1' id='list_id1' value="<%=list_id%>">
<input type="hidden" name='list_description1' id='list_description1' value="<%=list_description%>">
<input type="hidden" name='list_id_from_DB' id='list_id_from_DB' value="<%=list_id_from_DB%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


