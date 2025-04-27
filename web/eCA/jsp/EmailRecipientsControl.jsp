<!DOCTYPE html>
  <%@ page import="java.sql.*,webbeans.eCommon.*,java.io.*" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<HTML>
<HEAD>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<title>Email Recipients</title>
<%	
	java.sql.Connection		con = null;
	java.sql.PreparedStatement pstmt = null;
	java.sql.ResultSet		rs = null;		
	
	String recipients_id= request.getParameter("recipients_id") == null ? "": request.getParameter("recipients_id") ;  //Bru-HIMS-CRF-024 [Ramesh]
	String[] temp=recipients_id.split(",");
	StringBuffer sb=new StringBuffer();
	for(int i=0;i<temp.length;i++){
		 sb.append("'"+temp[i]+"'");			
		 if( (i+1)!=temp.length)
			 sb.append(",");
	}
	if((sb.toString()).equals(""))
		sb.append("''");
	int i=0;
%>
<SCRIPT>
function colseWindow(){
	window.close();
}
function clearRecipientIds(){
	var en=document.forms[0].elements["recipintId"];
	if((en.length)==undefined){
		document.forms[0].recipintId.checked = false;
	}else{
		for(var i=0;i<en.length;i++){
			en[i].checked=false;
		}
	}
}
function applyRecipientIds(){
	var en=document.forms[0].elements["recipintId"];	
	var recipintIdlist="";
	if((en.length)==undefined){
		if(document.forms[0].recipintId.checked)
			recipintIdlist = document.forms[0].recipintId.value;
	}else{		
		for(var i=0;i<en.length;i++){
			if(en[i].checked){
				if(recipintIdlist!="")
					recipintIdlist=recipintIdlist+",";
				recipintIdlist=recipintIdlist+en[i].value;
			}
		}
	}
	if(recipintIdlist!=""){
		window.returnValue = recipintIdlist;
		window.close();
	}else{
		alert("Please select any one Recipient.");
	}
}
</SCRIPT>
</HEAD>
<BODY>
	<form name="" id="" method="post">
	<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" height="100%" align='center'>
		<TR height="90%">
			<TD>
				<DIV style="width:100%; height:100%; overflow: auto;">
				<TABLE border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
					<TR>
						<TH align="center" >Recipient Name</TH>
						<TH align="center" >Email Id</TH>
						<TH align="center" >Select</TH>
					</TR>
					<%							
						String sql ="SELECT B.MAILER_ID,B.MAILER_NAME,B.EMAIL_ID,NVL((SELECT 'Y' FROM  SM_REGD_MAILING_LST A WHERE A.MAILER_ID IN("+sb.toString()+") AND A.MAILER_ID=B.MAILER_ID),'N') STATUS FROM SM_REGD_MAILING_LST B WHERE B.EFF_STATUS='E'";
						try{
							con	= ConnectionManager.getConnection(request);
							pstmt	= con.prepareStatement(sql);							
							rs = pstmt.executeQuery();
							
							if(rs!=null){
								while(rs.next()){
									String mailerId = rs.getString("MAILER_ID")==null?"":(String)rs.getString("MAILER_ID");
									String mailerName = rs.getString("MAILER_NAME")==null?"":(String)rs.getString("MAILER_NAME");
									String emailId = rs.getString("EMAIL_ID")==null?"":(String)rs.getString("EMAIL_ID");
									String status =  rs.getString("STATUS")==null?"":(String)rs.getString("STATUS");
									 %>
									 <TR>
										<TD class='gridData'><%=mailerName%></TD>
										<TD class='gridData'><%=emailId %></TD>
										<TD class='gridData' align="center"><input type="checkbox" name="recipintId" id="recipintId" value="<%=mailerId%>" <%if("Y".equals(status)){%>checked<%}%>/></TD>										
									</TR>
									 <%
									 i++;
								}
							}
							if(i==0){
								%>
								<TR><TD colspan="3">&nbsp;</TD></TR>
								<TR><TD colspan="3">&nbsp;</TD></TR>
								<TR><TD colspan="3" align="center">Email Recipients Not available.</TD></TR>
								<TR><TD colspan="3">&nbsp;</TD></TR>
								<TR><TD colspan="3">&nbsp;</TD></TR>
								<%
							}
							if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
							
						}catch(Exception e){
								e.printStackTrace();
								//out.println("Exception from EmailRecipientsControl.jsp " + e.toString());//COMMON-ICN-0181
						}finally{
								if(con != null) ConnectionManager.returnConnection(con, request);
						} 
						
					%>
					
				</TABLE>
				</DIV>
			</TD>
		</TR>
		<TR height="10%">
			<TD align="right" >
				<input type="button" value="Apply" onClick="javascript:applyRecipientIds();" <%if(i==0){%>disabled <%}%>/>&nbsp;&nbsp;<input type="button" value="Clear" onClick="javascript:clearRecipientIds();" <%if(i==0){%>disabled <%}%>/>&nbsp;&nbsp;<input type="button" value="Close" onClick="javascript:colseWindow();" />
			</TD>
		</TR>
	</TABLE>
	</form>
</BODY>	
</HTML>

