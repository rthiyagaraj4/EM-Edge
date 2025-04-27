<!DOCTYPE html>
<html>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<head>
<%
          request.setCharacterEncoding("UTF-8");
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function fetchVals1()
{
	var Obj=document.forms[0].tableid;

	if(Obj.value !='')
	{
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.document.frames[1].document.location.href='../../eSM/jsp/RecordTransTitle.jsp?tableid='+parent.document.frames[0].document.forms[0].tableid.value;
	parent.document.frames[2].document.location.href='../../eSM/jsp/RecordTransResult.jsp?tableid='+parent.document.frames[0].document.forms[0].tableid.value+"&moduled_id="+parent.document.frames[0].document.forms[0].module_id.value+"&criteria_String="+document.forms[0].criteria.value;
	
	}
	else
	{
	var  error = getMessage("CAN_NOT_BE_BLANK",'Common');
	error = error.replace("$",getLabel('Common.defaultSelect.label','Common'))
	alert(error);
	document.forms[0].tableid.focus();
	parent.parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	parent.document.frames[1].document.location.href='../../eCommon/html/blank.html';
	parent.document.frames[2].document.location.href='../../eCommon/html/blank.html';
	
	
	}
}
</script>
<%
	Connection con = null;
	Statement stmt=null;
	try{
	con = ConnectionManager.getConnection(request);
	
	ResultSet rs=null ;

	String tableid="";
	String tabledesc="";
	String module_id="";
	String sql="";

	stmt=con.createStatement();
		%>
	<body  onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'; OnMouseDown="CodeArrest()">
		<form name='RecordTransForm1' id='RecordTransForm1'  target='messageFrame'>
			<table border='0' cellpadding='0' cellspacing='0' width='100%'>
		<tr><td colspan='5'>&nbsp;</td></tr>	    		
		<tr>
    				     <td  class='label'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
    				     <td>&nbsp;&nbsp;<select name='tableid' id='tableid' >
    				     <option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				 <%
				     try{
				     	sql="select module_id,table_id,table_desc from sm_record_trans_hdr";
				        rs=stmt.executeQuery(sql) ;

				        if(rs!=null)
					    {
					      while(rs.next())
					  	   {
					  		tableid=rs.getString("table_id");
					  		module_id=rs.getString("module_id");
					   		tabledesc=rs.getString("table_desc");
					         out.println("<option value='"+tableid+ "' >"+tabledesc);
    				       }
    				     }
						 if(rs!=null)rs.close();
						 if(stmt!=null)stmt.close();
    				   }
    				    	catch(Exception e){out.println(e.toString());}
				        %>
    				     </select>&nbsp<img align='center' src='../../eCommon/images/mandatory.gif'></img>
    				   </td><td class = label><fmt:message key="Common.description.label" bundle="${common_labels}"/>
    				    <td>&nbsp;&nbsp;<input type = text name = criteria value = '' maxlength = 60 size= 30>
						<input type = button class = button value = 'Select' onClick=fetchVals1()>
    				</tr>           
<tr><td colspan='5'>&nbsp;</td></tr>
<input type='hidden' name='module_id' id='module_id' value='<%=module_id%>'>
						</form>
</body>
</html>
 <%
	}catch(Exception e){}
finally{
	if(stmt!=null) stmt.close();
if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

