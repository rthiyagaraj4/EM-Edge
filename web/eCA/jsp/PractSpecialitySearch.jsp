<!DOCTYPE html>
<%@ page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager" language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<%
	request.setCharacterEncoding("UTF-8");	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		/** added by kishore kumar n on 08/12/2009  */
	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
	 /** ends here*/
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language=javascript   src='../../eCommon/js/CommonLookup.js'></script>
		<script language=javascript   src='../../eCA/js/PractSpecialityRelation.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()">
<form name ="specialtySearchForm" target="specialtySearch">
<%
/*
	Connection con = null;	
	PreparedStatement psn = null;
	ResultSet rsn = null;

	try
	{
		con = ConnectionManager.getConnection(request);
		psn = con.prepareStatement("SELECT SPECIALITY_CODE, LONG_DESC SPECIALITY_DESC FROM AM_SPECIALITY WHERE EFF_STATUS='E' ORDER BY SPECIALITY_DESC ");				
		
		 rsn = psn.executeQuery();
		 */
%>
		<center>
		<table width =100% height ="44"  cellpadding = 3 cellspacing=0 align='center'>	
			<tr>		
				<td  class ='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
				<td class='fields'><input type='text' name='spec_name' id='spec_name' value="" onBlur='getSpecialty(this);'  ><input type='hidden' name='specialtySearch' id='specialtySearch' value=""  ><input type='button' name='spec_desc_search' id='spec_desc_search' value='?' class='button' onClick='getSpecialty(this);'>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td >
					<input type="button" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="getValue()">
				</td>
		</tr>
		</table>
			<!-- added by kishore kumar n on 08/12/2009  -->
			<%if(!imgUrl.equals("")){ %>
				 <img src='<%=imgUrl%>' width='100%' height='15'/> 
			<%}%>
				<!--ends here -->		
		</form>
	<%
/*
		if(rsn != null) rsn.close();
		if(psn != null) psn.close();
}
catch(Exception e)
{
	out.println(e);
	con.rollback();
}
finally
{	
	if(con!=null)ConnectionManager.returnConnection(con,request);
}
*/
	%>
</BODY>
</HTML>

