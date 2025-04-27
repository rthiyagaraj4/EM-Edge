<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>

<%! 
	String encode(String data){	  
		String outDat = "";
		byte byteData[] = data.getBytes();
		for (int i=0; i<byteData.length; i++){
			outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
		}
		return(outDat);
   }
  %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 String imgUrl="";
if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/ListItems.js'></script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.parent.commontoolbarFrame.document.forms[0].apply.disabled=false" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'> <!--Modified Against GHL-SCF-1519-->
<%
	String mode=request.getParameter("update_mode_yn");
	if (mode.equals("modify")){
			mode="U";
	}else {
		mode="I";
	}

String item_desc =""; 
String disable_flag="";
String list_id = checkForNull(request.getParameter("list_id"));
String item_value="";
String default_value_yn="";
String sql="";
//sql="SELECT ITEM_DESC, ITEM_VALUE, DEFAULT_VALUE_YN FROM OT_CHECKLIST_LISTVALS_DTL WHERE LIST_ID = ? ORDER BY 1";
sql="SELECT ITEM_DESC, ITEM_VALUE, DEFAULT_VALUE_YN FROM OT_CHKLIST_LISTVAL_DTL_LANG_VW WHERE LANGUAGE_ID =?  AND LIST_ID = ?  ORDER BY 1";
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
try
{
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql);
	stmt.setString(1,locale);
	stmt.setString(2,list_id);
	rs=stmt.executeQuery();
	int index=0;
	while(rs.next())
	{
		index++;
		item_desc=encode(rs.getString(1));
		item_value=rs.getString(2);	
        default_value_yn=rs.getString(3);
	//	if(default_value_yn==null || default_value_yn.equals("") || default_value_yn.equals("null"))
	//		default_value_yn="";
		out.println("<script>loadDBRows('"+item_desc+"','"+item_value+"','"+default_value_yn+"','"+index+"','L');</script>");
	}
	out.println("<script>refresh()</script>");
	
}catch(Exception e)
{
	e.printStackTrace();
	//System.err.println("Error in Checklist records.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
}
%>

<form name="ListItemsRecordForm" id="ListItemsRecordForm"  onload='FocusFirstElement()'  action="" method="" target=""> 
<table border=0 cellspacing=0 cellpadding=3 width='100%' >
<tr>
	<td class=label width='25%'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="item_description" id="item_description" value="" size=15 maxlength=30  ><img src='../../eCommon/images/mandatory.gif'></td>

	<td class='label' width='25%'><fmt:message key="Common.ItemValue.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="text" name="item_value" id="item_value" value="" size=2 maxlength=2 onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)">
	 <img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<tr>
	
	<td class=label width='25%'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td>
	<td width='25%' class="fields"><input type="checkbox" name="default_value_yn" id="default_value_yn" >
	</td>
	<td></td>
 <td class="fields" >
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type='button' class='button' value='<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>' onClick='addRow();'  <%=disable_flag%> >
		<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='removeRow();' <%=disable_flag%> >
	</td>
</tr>

</table>
<!-- added by Yadav for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<!-- end -->
<input type='hidden' name='recId' id='recId' value=''>
<input type='hidden' name='params' id='params' value='<%=request.getParameter("source")%>'>
<input type='hidden' name='mode' id='mode' value='I'>
<input type='hidden' name='list_id' id='list_id' value="<%=list_id%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


