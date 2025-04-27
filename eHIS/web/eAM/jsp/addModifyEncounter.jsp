<!DOCTYPE html>
<%--
	FileName	: addModifyEncounter.jsp
	Version	    : 3	
	Modified On	: 21-2-2005
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<!--<link rel='stylesheet' type='text/css' href='/eCIS/op/test/ecis.css'>-->
<script src='../../eCommon/js/common.js' language='javascript'></script>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eAM/js/OPEncounter.js' language='javascript'></script>
<SCRIPT LANGUAGE="JavaScript">
function checkZero(obj)
{
	if(parseInt(obj.value)==0){
		alert(getMessage("INVALID_POSITIVE_NUMBER",'Common'));
		obj.select();
		obj.focus();
	}
}
function CheckYear(Obj) {
	var val = Obj.value;
	var Year = Obj.value;	
	if ((trimCheck(val)==false && isNaN(val) && val >=0 )
	||( Year.length < 4 && Year.length > 0)
	||(Year.length == 4 && isNaN(val) == true) )
	{
		alert(getMessage("VALID_YEAR_CHECK","AM"));
		Obj.select();
		Obj.focus();
	}
}

</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	//String datefr="";
	//String dateto="";
	//String eff_status="";
	String next="";
	String s="";
	String s1="";
	//String chk="checked";
	String fnval="insert";
	Connection conn = null;
	try{
		conn=ConnectionManager.getConnection(request);

	PreparedStatement stmt=null;
	ResultSet rset=null;
	String facilityid=(String)session.getValue("facility_id");
	try
	{
		//String code=request.getParameter("year");
		//if(code!=null)
		//{	    		
	    	stmt = conn.prepareStatement("select * from pr_enc_id_num_for_fcy where facility_id=?");
	    	stmt.setString(1,facilityid);

	   	    rset=stmt.executeQuery();

			if (rset.next())
			{
			   //year = String.valueOf(rset.getInt("year_num"));
			   next = String.valueOf(rset.getInt("next_num"));
			   fnval="modify";
	    	   s1="readonly";
			   //eff_status=rset.getString("eff_status");
		   	}
	//}
}
catch(Exception e)	{e.printStackTrace();}
finally
{
	if(stmt!=null) stmt.close();
	if(rset!=null)	rset.close();
}
%>
</head>
	<body   OnMouseDown='CodeArrest()' onLoad='FocusFirstElement()' onKeyDown = 'lockKey()' >
	<div align='center'>
		<form name='encounter_form' id='encounter_form' action='../../servlet/eAM.OPEncounterServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<table border='0' cellpadding='0' cellspacing='0' width='40%'>
			<tr><td colspan='4'>&nbsp;</td></tr>
    				
    				<tr>
    				    				<td>&nbsp;</td>
    				     <td width='40%' align='right' class='label'><fmt:message key="eAM.NextNumber.label" bundle="${am_labels}"/></td>
      				     <td width='60%' align='left' colspan='2'>&nbsp;&nbsp;
                                     <input type='text' name='next_num' id='next_num' value='<%=next%>' size='8'   maxlength='8' style='{ font-size: ;}' onKeyPress='return  allowValidNumber(this,event,8,0);' <%=s%> onBlur="checkZero(this);CheckNum(this)" >&nbsp;<img align="center"  src='../../eCommon/images/mandatory.gif'>
                                      </tr>
                       <tr><td colspan='4'>&nbsp;</td></tr>
			</table>
		</div>
		<input type='hidden' name='hh' id='hh' value='<%=next%>'></td>&nbsp;
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
		</form>
</body>
</html>
<%
	}catch(Exception e){}
finally
{
if(conn!=null)
	ConnectionManager.returnConnection(conn,request);
}
%>

