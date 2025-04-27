<!DOCTYPE html>
<%--Author  Arvind Singh Pal Created on 4/9/2009 --%>

<%@ page import ="webbeans.eCommon.*,java.sql.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>

<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
	<script language='javascript' src='../js/AlertCateg.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;

	PreparedStatement stmt1 = null;
	ResultSet rs1 = null;

	String SpecSql = "";
	String mode = "";
	

	String sql = "";
	String alert_categ_code="";
	String alert_categ_desc ="";
	
	
	
	

	
	String disl = "";
	String id_disl = "";

	mode=request.getParameter("mode");
	
	if(mode=="insert" || mode.equals("insert") || mode == null) 
		{
			mode="insert";
			//enabled_checked = "checked";
			
		}
		else
		{
			mode="modify";
		}	
	try
	{
		con	= ConnectionManager.getConnection();

			if(mode.equals("modify"))
			{
				id_disl = "readOnly";
				alert_categ_code = (request.getParameter("alert_categ_code")==null)?"":request.getParameter("alert_categ_code");
								
				sql = "select alert_categ_code,alert_categ_desc from ca_alert_categ  where alert_categ_code = ?";
		
				stmt=con.prepareStatement(sql);
				stmt.setString(1,alert_categ_code);
				rs=stmt.executeQuery();
				if(rs!=null)
				{
					
					while(rs.next())
					{

						alert_categ_desc = rs.getString("alert_categ_desc");
						if(alert_categ_desc==null || alert_categ_desc.equals("null"))
							alert_categ_desc="";
						

					}
					if(stmt!=null) stmt.close();
					if(rs!=null) rs.close();
					}			
			}
%>

</head>


<body OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">

<form name= 'AlertCategForm' action="../../servlet/eCA.AlertCategoryServlet" method="post" target="messageFrame">

<table border=0 cellpadding=3 cellspacing=0 width='75%' align=center >
<br><br><br><br><br><br><br><br><br><br>
	
	<tr>
			<td class=label ><fmt:message key="eCA.AlertCategoryCode.label" bundle="${ca_labels}"/></td>
			<td class='fields'><input type='text' name='alert_categ_code' id='alert_categ_code' size='10' maxlength='6' onBlur='ChangeUpperCase(this)' onkeypress="return CheckForSpecChars(event)" value=<%=alert_categ_code%>  <%=id_disl%>><img src='../../eCommon/images/mandatory.gif'></td> 
	</tr>
	<tr>
			<td class='label' width='18%'><fmt:message key='eCA.AlertCategoryDescription.label' bundle='${ca_labels}'/></td>
			<td class='fields'><input type='text' name='alert_categ_desc' id='alert_categ_desc' size='50' maxlength='50' value='<%=alert_categ_desc%>' <%=disl%>><img src='../../eCommon/images/mandatory.gif'></td> 
	</tr>
	
</table>
<%
		
	}catch(Exception e)
			{
				//out.println("Exception in try :"+e);//COMMON-ICN-0181
                                   e.printStackTrace();//COMMON-ICN-0181
			}
	finally
			{
					
				if(con!=null)ConnectionManager.returnConnection(con,request);
			}	
%>


<input type='hidden' name='mode' id='mode' value="<%=mode%>" ></input>
<input type='hidden' name='flag' id='flag' value="" ></input>
</form>
</body>

</html>

