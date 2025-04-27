<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,eCommon.Common.*,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../../eOT/js/ChecklistItems.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!--body onLoad="parent.commontoolbarFrame.document.forms[0].apply.disabled=false;makeListMandatory();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'-->
<body onLoad="makeListMandatory();" OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

String checklist_item_code = checkForNull(request.getParameter( "checklist_item_code" ));
String flag=checkForNull(request.getParameter( "flag" ));
//out.println("<script>alert('"+flag+"')</script>");
String mode=checkForNull(request.getParameter("mode"));
String emty = "".intern();

String chk_checked="checked";
String chk_value="E";
String chk_checked1="checked";
String chk_value1="Y";
String disable_flag=emty;
String checklist_item_code_disable=emty;
String listVal="C";
String description=emty;
String checklist_type=emty;
String list_desc=emty;
String accept_remarks_yn=emty;
String item_level=emty;
String list_id1=emty;
String list_desc1=emty;
String list_id=emty;
String status=emty;
String sql=emty;
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
//if(mode.equals("modify"))
//{
	try{
		con=ConnectionManager.getConnection(request);
		//sql=sql="SELECT CHECKLIST_ITEM_CODE, DESCRIPTION, DECODE(CHECKLIST_TYPE,'C', 'Check Box', 'L', 'List Item', 'E', 'Label'), LIST_ID, ACCEPT_REMARKS_YN, ITEM_LEVEL, nvl(STATUS,'E') status FROM OT_CHECKLIST_ITEMS where CHECKLIST_ITEM_CODE= ? ";

		//sql="SELECT CHECKLIST_ITEM_CODE, DESCRIPTION, DECODE(CHECKLIST_TYPE,'C', 'Check Box', 'L', 'List Item', 'E', 'Label'), LIST_ID, ACCEPT_REMARKS_YN, ITEM_LEVEL, nvl(STATUS,'E') status FROM OT_CHECKLIST_ITEMS_LANG_VW where CHECKLIST_ITEM_CODE= ? and language_id=? ";

	//Modified by rajesh for scf-2596 spr-7083
		sql="SELECT CHECKLIST_ITEM_CODE, DESCRIPTION, DECODE(CHECKLIST_TYPE,'C', 'Check Box', 'L', 'List Item', 'E', 'Label'), LIST_ID, GET_DESC(?,'OT_CHKLIST_LISTVAL_HDR_LANG_VW','LIST_DESC','LIST_ID',LIST_ID) LIST_DESC,ACCEPT_REMARKS_YN, ITEM_LEVEL, nvl(STATUS,'E') status FROM OT_CHECKLIST_ITEMS_LANG_VW where CHECKLIST_ITEM_CODE= ? and language_id=? ";
         
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		stmt.setString(2,checklist_item_code);
		stmt.setString(3,locale);
		rs=stmt.executeQuery();
        if(rs!=null && rs.next()){
			checklist_item_code=checkForNull(rs.getString(1));
			description=checkForNull(rs.getString(2));
            checklist_type=checkForNull(rs.getString(3));
			list_id1=checkForNull(rs.getString(4));
			list_desc1=checkForNull(rs.getString(5));
			accept_remarks_yn=checkForNull(rs.getString(6));
			item_level=checkForNull(checkForNull(rs.getString(7)));
			status=checkForNull(rs.getString(8));
       }
	   if(accept_remarks_yn.equals("Y")){
		      chk_checked1="checked";
			  chk_value1="Y";
		}else{
		   chk_checked1="";
		   chk_value1="N";
		}

        if(status.equals("E")){
			chk_checked="checked";
			disable_flag="";
		}else{
			chk_checked="";
			disable_flag="disabled";
			chk_value="D";
		}
		checklist_item_code_disable="disabled";	
}catch(Exception e4){
	e4.printStackTrace();
	//out.println("CheckListItemsAddModify.jsp"+e4);
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e1)
			{
				e1.printStackTrace();
				//out.println("Exception is "+e1);
			}
		
		}
//}

%>
<form name="checkListItems_form" id="checkListItems_form"  onload='FocusFirstElement()'  action="../../servlet/eOT.ChecklistItemsServlet" method="post" target="messageFrame"> 
<br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='100%'  align=center>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="eOT.ChecklistItem.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="checklist_item_code" id="checklist_item_code" value="<%=checklist_item_code%>" size=4 maxlength=4   onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr>

	<td class=label>
		<fmt:message key="Common.description.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="text" name="description" id="description" value="<%=description%>"  size=60 maxlength=60 >
		<img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr>
	<td class=label>
		<fmt:message key="eOT.ChecklistType.Label" bundle="${ot_labels}"/>
	</td>
	<td class="fields">
	<select name="checklist_type" id="checklist_type" onChange='makeListMandatory();'>
	<%if(mode.equals("modify"))
	{
		if(checklist_type.equals("Check Box"))
		{%>
			<option value="C" selected>
			<fmt:message key="Common.CheckBox.label" bundle="${common_labels}"/>
			</option> 
			<option value="L">
			<fmt:message key="Common.ListItem.label" bundle="${common_labels}"/> 
			</option>
			<option value="E">
			<fmt:message key="Common.Label.label" bundle="${common_labels}"/> 
			</option>
	
		<%}else if(checklist_type.equals("List Item"))
			{%>
			 <option value="L" selected>
			 <fmt:message key="Common.ListItem.label" bundle="${common_labels}"/>
	         </option>
			 <option value="C">
			 <fmt:message key="Common.CheckBox.label" bundle="${common_labels}"/>  
			 </option>
	         <option value="E">
			 <fmt:message key="Common.Label.label" bundle="${common_labels}"/>
			 </option>
         <%}else if(checklist_type.equals("Label"))
         {%>
			 <option value="E" selected>
			 <fmt:message key="Common.Label.label" bundle="${common_labels}"/>
			 </option>
	         <option value="C">
			 <fmt:message key="Common.CheckBox.label" bundle="${common_labels}"/>  
			 </option>
	         <option value="L">
			 <fmt:message key="Common.ListItem.label" bundle="${common_labels}"/>
			 </option>
			<%}
		}
		  else{
			  %>
				  <option value="C" selected>
				  <fmt:message key="Common.CheckBox.label" bundle="${common_labels}"/> 
				  </option>
	              <option value="L">
				  <fmt:message key="Common.ListItem.label" bundle="${common_labels}"/> 
				  </option>
	              <option value="E">
				  <fmt:message key="Common.Label.label" bundle="${common_labels}"/> 
				  </option>
				<%}%>

			</select><img src='../../eCommon/images/mandatory.gif'>
			<fmt:message key="Common.ListID.label" bundle="${common_labels}"/>
		
	<%
	  if(mode.equals("insert"))
	  {
		  %>
	<select name="list_id" id="list_id" <%=flag%> >
	<option value="">
		<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
	</option>
      
<%
 try{
		con=ConnectionManager.getConnection(request);
		//sql="SELECT LIST_DESC, LIST_ID FROM OT_CHECKLIST_LISTVALS_HDR ORDER BY 1";
		sql="SELECT LIST_DESC, LIST_ID FROM OT_CHKLIST_LISTVAL_HDR_LANG_VW where language_id= ? ORDER BY 1";
		stmt=con.prepareStatement(sql);
		stmt.setString(1,locale);
		rs=stmt.executeQuery();
		while(rs.next())
		{
            list_desc=rs.getString("list_desc");
			list_id=rs.getString("list_id");
			%>
		<option value="<%=list_id%>" ><%=list_desc%>
		</option>
<%}
	}catch(Exception e2){
		e2.printStackTrace();
		//out.println("ChecklistItemsAddModify.jsp"+e2);
	}finally{
		try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e3){
			e3.printStackTrace();
			//out.println("Exception is "+e3);
		}
	}
	}else if (mode.equals("modify"))
	  {
		if(checklist_type.equals("Check Box") || checklist_type.equals("Label") ){
	%>
			<select name="list_id" id="list_id" >
		<option value="">
			<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>
		</option>
	<%	

			try{
				con=ConnectionManager.getConnection(request);
				//sql="SELECT LIST_DESC, LIST_ID FROM OT_CHECKLIST_LISTVALS_HDR ORDER BY 1";
				sql="SELECT LIST_DESC, LIST_ID FROM OT_CHKLIST_LISTVAL_HDR_LANG_VW where language_id= ? ORDER BY 1";
				stmt=con.prepareStatement(sql);
				stmt.setString(1,locale);
				rs=stmt.executeQuery();
				while(rs.next()){
					list_desc=rs.getString("list_desc");
					list_id=rs.getString("list_id");
					if(list_id.equals(list_id1)){
				%>
				  <option value="<%=list_id%>" selected><%=list_desc%></option>
			<%}else{
		  %> 
				  <option value="<%=list_id%>"><%=list_desc%></option>
			  <%}
			}//end of while
			}catch(Exception e2){
				e2.printStackTrace();
				//out.println("exp"+e2);
			}finally{
				try{
					if(stmt!=null) stmt.close();
					if(rs!=null)rs.close();
					ConnectionManager.returnConnection(con);
				}catch(Exception e3){
					e3.printStackTrace();
					//out.println("Exception in Chekclist Add modify E1 "+e3);
				}		
			}//end of finally
	}else if(checklist_type.equals("List Item")){     
	%>
			<select name="list_id" id="list_id">
				  <option value=""><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>				
	<%
		try{
			con=ConnectionManager.getConnection(request);
			//sql="SELECT LIST_DESC, LIST_ID FROM OT_CHECKLIST_LISTVALS_HDR ORDER BY 1";
			sql="SELECT LIST_DESC, LIST_ID FROM OT_CHKLIST_LISTVAL_HDR_LANG_VW where language_id=? ORDER BY 1";
			stmt=con.prepareStatement(sql);
			stmt.setString(1,locale);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				list_desc=rs.getString("list_desc");
				list_id=rs.getString("list_id");
				if(list_id.equals(list_id1)){
				%>
				  <option value="<%=list_id%>" selected><%=list_desc%></option>
			<%}else{
		  %> 
				  <option value="<%=list_id%>"><%=list_desc%></option>
			  <%}
			}//end of while

		}catch(Exception e2){
			e2.printStackTrace();
			//out.println("Exception in Chekclist Add modify E2 "+e2);
		}finally{
			try{
				if(stmt!=null)	stmt.close();
				if(rs!=null)	rs.close();
				ConnectionManager.returnConnection(con);
			}catch(Exception e3){
				e3.printStackTrace();
				//out.println("Exception in Chekclist Add modify E3  "+e3);
			}			
		}//end of finally
     }//end of inner else
}//end of else if
%></select><img src='../../eCommon/images/mandatory.gif'>
  
</td>
</tr>
<tr> 
<% if(mode.equals("insert"))
{%>
    <td class=label>
		<fmt:message key="eOT.AcceptRemarks.Label" bundle="${ot_labels}"/>?
	</td>
    <td class="fields">
		<input type="checkbox" name="accept_remarks_yn" id="accept_remarks_yn" onClick='acceptRemarksYN();' value='<%=chk_value1%>' >
	</td>
<%} else if(mode.equals("modify"))
	{ %>
	   <td class=label>
		<fmt:message key="eOT.AcceptRemarks.Label" bundle="${ot_labels}"/>?
		</td>
   <td class="fields">
		<input type="checkbox" name="accept_remarks_yn" id="accept_remarks_yn" onClick='acceptRemarksYN();' value='<%=chk_value1%>' <%=chk_checked1%> >
	</td>
<% } %>

</tr>
<tr>
    <td class=label>
		<fmt:message key="Common.ItemLevel.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
	<select name="item_level" id="item_level">
	<% if(mode.equals("modify"))
	{
		
			if(item_level.equals("1"))
			{
				%>

						<option value='1' selected>1</option>
						<option value='2'>2</option>
						<option value='3'>3</option>
						<option value='4'>4</option>
			<%
			}else if(item_level.equals("2"))
				 {
				%>

						<option value='2'selected>2</option>
						<option value='1'>1</option>
						<option value='3'>3</option>
						<option value='4'>4</option>
			<%
				 }else if(item_level.equals("3"))
					 {
                       %>
                        <option value='3' selected>3</option>
						<option value='1'>1</option>
						<option value='2'>2</option>
						<option value='4'>4</option>
			<%
			    }else if(item_level.equals("4"))
				 {
				%>

						<option value='4' selected>4</option>
						<option value='1'>1</option>
						 <option value='2'>2</option>
				         <option value='3'>3</option>
				<% }else if(item_level.equals("null") || item_level.equals(""))
					 {%>
						 <option value='' selected></option>
						 <option value='1'>1</option>
						 <option value='2'>2</option>
				         <option value='3'>3</option>
				         <option value='4'>4</option>
			<%}

	}else if(mode.equals("insert"))
			{%>
			    
				<option value='1' selected>1</option>
				<option value='2'>2</option>
				<option value='3'>3</option>
				<option value='4'>4</option>
				
				<%}%>
				
</select><img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>

<tr>
	<td class=label>
		<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
	</td>
	<td class="fields">
		<input type="checkbox" name="status" id="status" onClick='setCheckValue();' value='<%=chk_value%>' <%=chk_checked%> >
	</td>
</tr>
<tr>
	<td width='35%'></td>
	<td width='65%'></td>
</tr>
</table>
<input type="hidden" name='mode' id='mode' value='<%=mode%>'>
<input type="hidden" name='checklist_item_code1' id='checklist_item_code1' value="<%=checklist_item_code%>">
<input type="hidden" name='description1' id='description1' value="<%=description%>">

<input type="hidden" name='list_id1' id='list_id1' value=<%=list_id%>>
<input type="hidden" name='flag' id='flag' value="<%=flag%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>


