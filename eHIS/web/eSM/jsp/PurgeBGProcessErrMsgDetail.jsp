<!DOCTYPE html>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
	<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
        <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
		<Script src="../../eCommon/js/CommonCalendar.js" language="javascript"></Script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language='javascript' src='../../eSM/js/PurgeBGProcessErrMsg.js'></script>
		<script src='../../eCommon/js/showModalDialog.js' language='javaScript'></script>

		<script>

		function callproc()
		{
		//alert("inside");
         if(document.forms[0].process_id.value=="")
		{  
			var msg=getMessage("PROC_ID_NOT_BLANK",'SM');
			alert(msg);
			return false
		}
	   
	
			
		}
	
    

function CheckPositiveNumber1(obj) {
	if ( obj.value!=null && trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0)
		{		
	}
	else {
  		if ( obj.value.length > 0 ) {
  			alert(getMessage('ONLY_POSITIVE_NUM','SM'));
  			obj.select();
  			obj.focus();
  		}
  		else if ( obj.value.length == 0 );
  	
  	}
}
function focobj()
{

document.forms[0].process_id.focus();
}



		</script>
</head>
<%
        request.setCharacterEncoding("UTF-8");
String proc_id=request.getParameter("proc_id");
String locale		= (String)session.getAttribute("LOCALE");


if(proc_id==null) proc_id="";

//String proc_name="";
//String next_execution_date="";
//String interval="";
String dat="";
String id="";

String sql="";
//String mode="insert";
//String dis_submit="disabled";
//String dis_submit1="disabled";

String sys_Date="";
//String to_date="";
//String from_date="";

Connection con=null;
java.sql.Statement stmt=null;
ResultSet rs=null;

//CallableStatement  cs = null;

try{
	con = ConnectionManager.getConnection(request);
			
	stmt = con.createStatement();	
	String syssql = "select to_char(sysdate,'dd/mm/yyyy hh24:mi')  from dual";
	ResultSet rssql=stmt.executeQuery(syssql) ;
	if(rssql!=null)
	{
	 while(rssql.next())
	 {
		sys_Date = rssql.getString(1);
		
	 }
	}
	if(rssql!=null)rssql.close();
	if(stmt!=null)stmt.close();

	
	


	
%>
<body  onLoad='focobj()' onKeyDown = 'lockKey()' onmousedown='CodeArrest()'>
<form name='PurgeProcess' id='PurgeProcess' action="../../servlet/eSM.PurgeBGProcessErrMsgServlet" method=post target=messageFrame>
	
	<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
	<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
		<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
		<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
		<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
		<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
		

<table border='0' cellspacing=0 cellpadding=0 width='100%' align='right' border='1'>

	<th width='100%' colspan=6 align=left><fmt:message key="eSM.PurgeProcessDetails.label" bundle="${sm_labels}"/></th>
	<tr>
		<td width='2%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='24%'>&nbsp;</td>
		<td width='2%'>&nbsp;</td>
	</tr>
		<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>

	<tr>
		<td>&nbsp;</td>
		<td class=label><fmt:message key="Common.Process.label" bundle="${common_labels}"/></td>
	<td class="fields"><select name='process_id' id='process_id'>
    				     <option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
    				       <%
    				    		stmt=con.createStatement();
    				    		 sql="select long_desc, proc_id from sm_proc_id where controllable_yn='Y' order by long_desc";

    				    		rs=stmt.executeQuery(sql);
    				    		if(rs!=null)
    				    		{
    				    		   while(rs.next())
    				    		   {
    				    			dat=rs.getString("long_desc");
    				    			id=rs.getString("proc_id");
    				    			out.println("<option value='"+id+ "'>"+dat);
    				    		   }
								}%>
    				    		</select>&nbsp
		
	<img align=center src='../../eCommon/images/mandatory.gif'></img></td>
		
		<td>&nbsp;</td><td>&nbsp;</td><td>&nbsp;</td>
	</tr>
	<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
	<tr>  
		<td>&nbsp;</td>
		<td class=label ><fmt:message key="eSM.PurgePeriod.label" bundle="${sm_labels}"/></td>
		<td class="fields"><input type=text id='from_date' name='from_date' value='' onBlur='if(validDateObj(this,"DMY","<%=locale%>")) DateValidation(this)' size=16 maxlength=16><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick=" document.getElementById('from_date').focus();return showCalendar('from_date')"> 
      <img align=center src='../../eCommon/images/mandatory.gif'></img>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-</td>
		<td class="fields"><input type=text id='to_date' name='to_date' value=''  onBlur='ValidateDateTimesp(forms[0].from_date,this);'size=16 maxlength=16><input type="image" src="../../eCommon/images/CommonCalendar.gif" onClick="document.getElementById('to_date').focus(); return showCalendar('to_date')"> 
      <img align=center src='../../eCommon/images/mandatory.gif'></img></td>
		<td></td><td>&nbsp;</td>
	</tr>
	<tr>
		<td colspan=6>&nbsp;</td>
	</tr>
			<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
			<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
			<tr>
	 <td colspan=6>&nbsp;</td> 
	</tr>
</table>


	
	<input type=hidden id="systemdate1" name='systemdate1' value='<%=sys_Date%>'>
</form>
</body>
<%
		if(stmt!=null) stmt.close();
		if(rs!=null) rs.close();
		
	}
catch(Exception e){out.println(e);}
finally {
		ConnectionManager.returnConnection(con,request);
}	
%>

</html>

