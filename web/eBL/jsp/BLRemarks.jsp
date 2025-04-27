<!DOCTYPE html>
<!-- NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Starts -->

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.net.URLDecoder" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eBL/js/PolicyDefinition.js"></script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Remarks</title>
<% 
	String patview=checkForNull(request.getParameter("patview"));
	String mode = checkForNull(request.getParameter("mode"));
	String inc_remarks="";
	String payerGroup	=	request.getParameter("payerGroup");
	String payer		=	request.getParameter("payer");
	String policy		=	request.getParameter("policy");
	String remarkHdr="";
	if("N".equals(patview))
	{
		//remarkHdr = java.net.URLDecoder.decode(request.getParameter("remarkHdr"),"UTF-8");
		remarkHdr = request.getParameter("remarkHdr");//23-09-2020
		if(remarkHdr.equals("") || remarkHdr.equals("undefined") || remarkHdr.equals("null"))
		{
			remarkHdr ="";
		}	
	}
%>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
%>
<% 
	if("N".equals(patview)){
%>
<% 
	if("insert".equals(mode)){
%>
<body>
<form>
	<table>
 		<tr>
			<td><textarea name="REMARKS" id="REMARKS" rows=10 cols=50 onkeyup="textAreaLimit1(this,200);" onkeypress="restrictSpecialChars(event)"><%=remarkHdr%></textarea></td>
  		</tr>
  		<tr>
  			<td align="right">
				<input type="button" name="ok" id="ok" value='<fmt:message key="Common.ok.label" bundle="${common_labels}" />' onClick='getRemarks(document.getElementById("REMARKS").value)' class="button" >
				<input name="cancel" id="cancel" type="button" value='<fmt:message key="eBL.Cancel.label" bundle="${common_labels}" />' class="button" onClick="clearTextArea();window.close();" />
			</td>
  		</tr>
	</table>
	<input type="hidden" name="remarks1" id="remarks1" id="remarks1" value="<%=remarkHdr%>" />
</form>
</body>

<script type="text/javascript">
document.getElementById("REMARKS").value = unescape(document.getElementById("remarks1").value);	
</script>
<%}else { 
//ADDED AGAINST INC 73086  5/28/2020
if(remarkHdr.equals("") || remarkHdr.equals("undefined") || remarkHdr.equals("null"))
{
	String sqlINC =	"select remarks from bl_ins_policy_type_hdr where CUST_GROUP_CODE=? and POLICY_TYPE_CODE=? and CUST_CODE=?";
	Connection con	=	null;
	PreparedStatement stmt	=	null;
	ResultSet rset	=	null;	
	try{
			con = ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(sqlINC);
			stmt.setString(1,payerGroup);
			stmt.setString(2,policy);
			stmt.setString(3,payer);
			rset = stmt.executeQuery();
			
			while(rset.next())
			{
				inc_remarks			 = rset.getString(1);					
				inc_remarks			 = (inc_remarks == null)?"":inc_remarks;	
			}

			if(stmt!=null)  stmt.close();
			if(rset!=null)  rset.close();
		}catch(Exception e)
			{
				 e.printStackTrace();
			}
			finally
			{
			   if(con!=null)		
			   ConnectionManager.returnConnection(con,request);
			}			
}
else
	inc_remarks=remarkHdr;  //ADDED AGAINST INC 73086  5/28/2020
%>
<body>
<form>
	<table>
 		<tr>
		<td><textarea name="REMARKS" id="REMARKS" rows=10 cols=50 onkeyup="textAreaLimit1(this,200);" onkeypress="restrictSpecialChars(event)"><%=inc_remarks%></textarea></td>
  		</tr>
  		<tr>
  			<td align="right">
				<input type="button" name="ok" id="ok" value='<fmt:message key="Common.ok.label" bundle="${common_labels}" />' onClick='getRemarks(document.getElementById("REMARKS").value)' class="button" >
				<input name="cancel" id="cancel" type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' class="button" onClick="clearTextArea();window.close();" />
			</td>
  		</tr>
	</table>	
	<input type="hidden" name="remarks1" id="remarks1" id="remarks1" value="<%=inc_remarks%>" /> <!--    ADDED AGAINST INC 73086  5/28/2020 --> 
</form>
</body>
<script type="text/javascript">
	document.getElementById("REMARKS").value = unescape(document.getElementById("remarks1").value);
	//frmPolicyInfo.document.getElementById('blremarks').value  = unescape(document.getElementById("remarks1").value);
	window.frames["PolicyInfoFrame"].document.getElementById("blremarks").value = unescape(document.getElementById("remarks1").value);//19-08-2020
	//var obj=parent.PolicyInfoFrame.frmPolicyInfo;
	//alert(window.frames["PolicyInfoFrame"].document.getElementById("blremarks").value);
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%} %>
<%}else{%>
<%	
	String sqlINC =	"select remarks from bl_ins_policy_type_hdr where CUST_GROUP_CODE=? and POLICY_TYPE_CODE=? and CUST_CODE=?";
	Connection con	=	null;
	PreparedStatement stmt	=	null;
	ResultSet rset	=	null;
	
	try{
			con = ConnectionManager.getConnection(request);
			stmt = con.prepareStatement(sqlINC);
			stmt.setString(1,payerGroup);
			stmt.setString(2,policy);
			stmt.setString(3,payer);
			rset = stmt.executeQuery();
			while(rset.next())
			{
				inc_remarks			 = rset.getString(1);
				inc_remarks			 = (inc_remarks == null)?"":inc_remarks;	
			}
			if(stmt!=null)  stmt.close();
			if(rset!=null)  rset.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		   if(con!=null)		
		   ConnectionManager.returnConnection(con,request);
		}			
%>
<body>
<form>
	<table>
 		<tr>
			<td><textarea name="REMARKS" id="REMARKS" rows=10 cols=50 readonly><%=inc_remarks%></textarea></td>
  		</tr>
  		<tr>
  			<td align="right">				
				<input name="cancel" id="cancel" type="button" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}" />' class="button" onClick="clearTextArea();window.close();" />
			</td>
  		</tr>
	</table>	
</form>
</body>
<%}%>
</head>
</html>
<!-- NMC-JD-CRF-0010.1-15/5/2020-palaniNarayanan Ends -->

