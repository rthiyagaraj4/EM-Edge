<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eAM/js/ReferralIDNumbering.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%
	request.setCharacterEncoding("UTF-8");
	String  year="";
	String next="";
	String s="";
	String s1="";
	String fnval="insert";
	Connection conn = null;
	try{
		conn=ConnectionManager.getConnection(request);

	PreparedStatement stmt=null;
	ResultSet rset=null;
	String facilityid=(String)session.getValue("facility_id");
	try
	{
		String code=request.getParameter("year_num");
		if(code!=null)
		{
	    		fnval="modify";
	    		s1="readonly";
	    		stmt = conn.prepareStatement("select year_num,next_referral_num from am_ref_id_num_for_fcy where year_num=? and facility_id=?");
	    		stmt.setInt(1,Integer.parseInt(code));
	    		stmt.setString(2,facilityid);

	   		rset=stmt.executeQuery();

	   		if(rset != null)
	    		{
			   rset.next();
			   year = String.valueOf(rset.getInt("year_num"));
			   next = String.valueOf(rset.getInt("next_referral_num"));
		   		}
	}

		
		if(rset!=null)	rset.close();
		if(stmt!=null) stmt.close();
}
catch(Exception e)	{e.printStackTrace();}

%>
</head>
	<body   OnMouseDown='CodeArrest()' onLoad="Focusing('year_num')" onKeyDown = 'lockKey()'>
	<div align='center'>
		<form name='ReferralIDNumbering_form' id='ReferralIDNumbering_form' action='../../servlet/eAM.ReferralIDNumberingServlet' method='post' target='messageFrame'>
		<BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR><BR>
			<table border='0' cellpadding='0' cellspacing='0' width='50%'>
			<tr><td colspan='4'>&nbsp;</td></tr>
    				<tr>
    				<td>&nbsp;</td>
    				     <td width='50%' class='label'><fmt:message key="Common.year.label" bundle="${common_labels}"/></td>
    				     <td width='50%' align='left' colspan='2'>&nbsp;&nbsp;
    				     <input type='text' name='year_num' id='year_num' value='<%=year%>' size='4' maxlength='4' size='4' onKeyPress='return  allowValidNumber(this,event,4,0);' <%=s1%> >&nbsp;<img align="center" src='../../eCommon/images/mandatory.gif'></img> </td>
    				</tr>
					<tr><td colspan='4'>&nbsp;</td></tr>
    				<tr>
    				    				<td>&nbsp;</td>
    				     <td width='50%'  class='label'><fmt:message key="eAM.NextReferralNumber.label" bundle="${am_labels}"/></td>
      				     <td width='50%' align='left' colspan='2'>&nbsp;&nbsp;
                                     <input type='text' name='next_referral_num' id='next_referral_num' value='<%=next%>' size='8'   maxlength='8' style='{ font-size: ;}' onblur='CheckNum(this);'onKeyPress='return  allowValidNumber(this,event,8,0);' <%=s%> >&nbsp;<img align="center"  src='../../eCommon/images/mandatory.gif'>
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

