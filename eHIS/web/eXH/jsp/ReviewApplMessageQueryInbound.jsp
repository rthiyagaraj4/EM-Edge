<!DOCTYPE html>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<HTML>
<HEAD>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% String locale = ((String)session.getAttribute("LOCALE"));	%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="JavaScript">
//function load_tree
function load_tree()
{
	parent.messageFrame.location.href ='../../eCommon/jsp/MstCodeError.jsp';
	var index=this.document.forms[0].appl_name.options.selectedIndex;
  	this.document.forms[0].appdes.value=this.document.forms[0].appl_name.options[index].text;
	var fields = new Array ( this.document.forms[0].appl_name) ;
	
	var names = new Array ( getLabel("eXH.Application.Label","XH"));
	var messageFrame=parent.messageFrame;
	if(!checkFields( fields, names, messageFrame))
    {
  
    }
    else{
		
	this.document.forms[0].action='../../eXH/jsp/ReviewApplMessageInboundMenu.jsp';
	parent.result.location.href='../../eCommon/html/blank.html';
	this.document.forms[0].target='header';
	this.document.forms[0].submit();
    }

}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onLoad="setValues();" >
 <%
		 Connection con=null;
		try
			{
				con=ConnectionManager.getConnection();
			}  catch(Exception e1)
			{ 
				System.out.println("(ReviewApplMessageQueryInbound.jsp:Exception-1) :"+e1.toString());
			 }


			String queryApplication="SELECT DISTINCT(A.APPLICATION_NAME) ,A.APPLICATION_ID FROM  XH_APPLICATION_LANG_VW A WHERE A.LANGUAGE_ID='"+locale+"'";
			ResultSet result=null;
			Statement stmt=null;
			stmt =con.createStatement();
 %>
<form name="application_review_msg_query_form" id="application_review_msg_query_form">
<input type='hidden' name='mode' id='mode' value='F'>
<input type='hidden' name='appdes' id='appdes'>
<input type='hidden' name='facdes' id='facdes'>
<input type='hidden' name='messagedes' id='messagedes'>
<input type='hidden' name='eventdes' id='eventdes'>
<table cellspacing=0 cellpadding=0 width='100%' border=0 align=center>
<tr>
	<td width='10%'></td>
	<td width='40%'></td>
	<td width='20%'></td>
	<td width='30%'></td>
</tr>

<tr><td class=label ><fmt:message key="eXH.Application.Label" bundle="${xh_labels}"/></td>
<td align=left><select name=appl_name >
<option value=''>---------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>------------</option>

<%
	try
	{
		result=stmt.executeQuery(queryApplication);
		while(result.next())
		{
%>
    <option value ='<%=result.getString(2)%>'
		><%=result.getString(1)%></option>
			
<%
		}
if(result!=null)result.close();
if(stmt!=null)stmt.close();
%>
<select> <img src='../../eCommon/images/mandatory.gif' align=middle></td>
<%
	}catch(Exception e1)
	    {
			System.out.println("(ReviewApplMessageQueryInbound.jsp:Exception-2) :"+e1.toString());
		}
		finally{

		try{ 		
	 ConnectionManager.returnConnection(con);
   }catch(Exception e)
   {
	out.println("Exception is "+e);
	}
		
		}
%>

<td class=label ><fmt:message key="eXH.ClientId.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name =client_id size=11> </td></tr>
	
<tr>
<td class=label ><fmt:message key="eXH.MessageDate.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name =msg_date size=11> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('msg_date','dd/mm/y');" Onblur="javascript:checkDate()"></td>
<td class=label ><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
<td align=left><input type=text name =msg_id size=10></td>

</tr>
<tr>
<td class=label ><fmt:message key="eXH.MessageStatus.Label" bundle="${xh_labels}"/></td>
<td align=left><select name=msg_status >
<option value=''>------<fmt:message key="eXH.Select.Label" bundle="${xh_labels}"/>-------</option>
<option value='A'><fmt:message key="eXH.All.Label" bundle="${xh_labels}"/></option>
<option value='P' ><fmt:message key="eXH.Pending.Label" bundle="${xh_labels}"/></option>
<option value='S'><fmt:message key="eXH.Sucessfull.Label" bundle="${xh_labels}"/></option>
<option value='C'><fmt:message key="eXH.Accepted.Label" bundle="${xh_labels}"/></option>
<option value='R'><fmt:message key="eXH.Rejected.Label" bundle="${xh_labels}"/></option></select> </td>
<td colspan=3>&nbsp;</td>
</tr>
<tr >
<td colspan=4 class= 'BUTTON'><input class='BUTTON' type="button"  name=search value='<fmt:message key="eXH.Search.Label" bundle="${xh_labels}"/>' onClick="load_tree();"></td>
</tr>
</table>
</form>	
</BODY>
</HTML>

