<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String errorModify=request.getParameter("errorModify")==null?"N":request.getParameter("errorModify");
	
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");

	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
 <script language="javascript" src="../../eCommon/js/common.js" ></script>
 <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCA/js/PatAllergy.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rset=null;
		String rec_exist="";
		String sql="";
		try
		{
//			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			con=ConnectionManager.getConnection(request);
		
			sql="select ALLERGY_TYPE_CODE, error_yn, ALLERGY_class,close_date,error_Remarks,error_marked_date from pr_allergy where  ERROR_YN='Y' and patient_id=?";

		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,patient_id);
		rset=pstmt.executeQuery();

		if (rset.next())
			rec_exist=rset.getString(2);
	
		if(rset!=null) rset.close();
		if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
		//out.println("Exception "+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	  if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
<table border='0' cellpadding='3' cellspacing='0' width="90%" align='center' >
<tr>
	<td align='left' class='white'>

			<%	if (rec_exist.equals("Y")) 
				{
					%>
 					<input type='button' name='btnView' id='btnView' onclick="showErrorList();" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorDocuments.label","ca_labels")%>"  class='button'>
					<%
				}
			%>

			<% if(errorModify.equals("Y")) 
			{ 
				%>
					<input type='button' align='left' name='error' id='error' onclick="markError()" class='button' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.MarkError.label","common_labels")%>" >					
				<%
			}%>
			</td>
			<td align='right' class='white'>
				<input type='button' align='right' name='record' id='record' onclick="apply()" class='BUTTON' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>">
				<input type='button' align='right' name='clear' id='clear' onclick="clearform()" class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'>
				<input type='button' align='right' name='cancel' id='cancel' onclick="cancel()" class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>'>
			</td>
		</tr>
	</table>
	<form>
	 	 <input type=hidden name=patient_id value='<%=patient_id%>'>
	</form>
</body>
</html>

