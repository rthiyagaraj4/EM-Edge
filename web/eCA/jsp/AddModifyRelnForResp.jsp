<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Connection con=null;
	
	String pract_reln_id="";
	String dis="";
	String mode="";
	String resp_id_ref="";
	String pract_reln_id_ref="";

	String resp_id		=	request.getParameter("resp_id");      
	
	pract_reln_id		=	request.getParameter("pract_reln_id");
	
	resp_id_ref= resp_id ;
	pract_reln_id_ref=pract_reln_id;

	if(resp_id==null) 
	{
		resp_id="";
		mode="insert";
	}
	else
		mode="modify";

	try
	{
		con=ConnectionManager.getConnection(request);
	
		if(!mode.equals("insert"))
			dis="disabled";	
	%>
<html>
<head>
	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
	<script src="../../eCommon/js/common.js"			language="javascript"></script>
	<script src='../../eCommon/js/CommonLookup.js'		language='javascript'  ></script>
	<script src='../js/RelnforResp.js'					language='javascript' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' onload='FocusFirstElement()'>
<form name="RelnForResp_form" id="RelnForResp_form" action="../../servlet/eCA.RelnForRespServlet" method="post" target='messageFrame'>

<br><br><br><br><br><br><br><br>
	<input type=hidden name=can_asgn_val value='N'>
	<input type=hidden name=can_hold_val value='N'>
	<input type=hidden name=can_terminate_val value='N'>

<table border=0 cellspacing=0 cellpadding=3 width='60%' align=center>

<%
		PreparedStatement stmt2=null;
		ResultSet rs2=null;

		String id2="";
		String dat2="";

		try
		{
			String  sql2=" Select resp_name,resp_id from sm_resp where resp_id = ? ";
			stmt2=con.prepareStatement(sql2);
			stmt2.setString(1,resp_id);
			rs2=stmt2.executeQuery();
		
			if(rs2!=null)
			{
				while(rs2.next())
				{
					dat2=rs2.getString(1);
					id2=rs2.getString(2);
				}
			}
			
		}
		catch(Exception e)
		{
			//out.println("Exception in AddModifyRelnForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	%>

	<tr>
		<td class='label' ><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='text' name='resp_name' id='resp_name'  <%=dis%> value="<%=dat2%>" size="30" maxlength="30" OnChange='resetValues()'  onBlur='checkResponsibility(this);'><input type='hidden' name='resp_id' id='resp_id' value="<%=id2%>" size="4" maxlength="4" ><input type='button' name='resp_desc_search' id='resp_desc_search' value='?' <%=dis%> class='button' onClick='resetValues();checkResponsibility(this);'>
			<img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	
<%
		PreparedStatement stmt1=null;
		ResultSet rs1=null;

		String id="";
		String dat="";
		
		try
		{
			String  sql1=" Select pract_reln_name, pract_reln_id from ca_pract_reln where pract_reln_id = ?";
			stmt1=con.prepareStatement(sql1);
			stmt1.setString(1,pract_reln_id);
			rs1=stmt1.executeQuery();
		
			if(rs1!=null)
			{
				while(rs1.next())
				{
					dat=rs1.getString(1);
					id=rs1.getString(2);
				}
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in AddModifyRelnForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	%>

	<tr>
		<td class='label' ><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			<input type='text' name='pract_reln_name' id='pract_reln_name'  <%=dis%> value="<%=dat%>" size="30" maxlength="30" OnChange='resetValues()'  onBlur='checkRelationship(this);'  ><input type='hidden' name='pract_reln_id' id='pract_reln_id' value="<%=id%>" size="4" maxlength="4" ><input type='button' name='reln_desc_search' id='reln_desc_search' value='?' <%=dis%> class='button' onClick='resetValues();checkRelationship(this);'>
			<img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	
	<%

		PreparedStatement stmt3=null;
		ResultSet rs3=null;

		String canhold_flg = "";
		String canasgn_flg = "";
		String canterminate_flg = "";
		String dat1=""; 
		String dat3="";
		String canterminate = "";

		try
		{
			String  sql3=" Select can_hold_yn, can_assign_yn, can_terminate_yn  from ca_pract_reln_for_resp where resp_id= ? AND pract_reln_id = ? ";
					
			stmt3=con.prepareStatement(sql3);
			stmt3.setString(1,resp_id_ref);
			stmt3.setString(2,pract_reln_id_ref);
			rs3=stmt3.executeQuery();

			if(rs3!=null)
			{
				while(rs3.next())
				{
					dat1=(rs3.getString(1)==null)?"N":rs3.getString(1);
					
					if(dat1.equals("Y"))
						canhold_flg="checked";
					else
						canhold_flg="";
					
					dat3=(rs3.getString(2)==null)?"N":rs3.getString(2);
					
					if(dat3.equals("Y"))
						canasgn_flg="checked";
					else
						canasgn_flg="";

					canterminate = (rs3.getString(3)==null)?"N":rs3.getString(3);
					
					if(canterminate.equals("Y"))
						canterminate_flg="checked";
					else
						canterminate_flg ="";					
				}
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in AddModifyRelnForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
%>

<tr>
	<td width='35%' class ='label' ><fmt:message key="eCA.CanHold.label" bundle="${ca_labels}"/></td>
	<td width='65%' class='fields'><input type ='checkbox'  name ='canHold' <%=canhold_flg%>></td>
</tr>
<tr>
	<td width='35%' class ='label'><fmt:message key="eCA.CanAssign.label" bundle="${ca_labels}"/></td>
	<td width='65%' class='fields'><input type ='checkbox'  name ='canAssign' <%=canasgn_flg%>></td>
</tr>
<tr>
	<td  width='35%' class ='label'><fmt:message key="eCA.CanTerminate.label" bundle="${ca_labels}"/></td>
	<td width='65%' class='fields'><input type ='checkbox'  name ='canTerminate' <%=canterminate_flg%>></td>
</tr>
</table>
<input type=hidden name=mode value='<%=mode%>'>
<input type=hidden name=resp_id1 value='<%=resp_id%>'>
</form>
</body>
</html>
<%			
			if(rs1!=null) rs1.close();
			if(rs2!=null) rs2.close();
			if(rs3!=null) rs3.close();
			if(stmt1!=null) stmt1.close();
			if(stmt2!=null) stmt2.close();
			if(stmt3!=null) stmt3.close();
}
catch(Exception e)
{
	//out.println("Exception in AddModifyRelnForResp.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{	
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

