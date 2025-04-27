<!DOCTYPE html>



<%@ page import ="java.sql.*, java.util.*, webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<jsp:useBean id="accessRightRecSet" class="webbeans.eCommon.RecordSet" scope="session"/> 

<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>

<%
Connection con =null;
Statement stmt = null;

PreparedStatement pstmt = null;
ResultSet rs=null;	
ResultSet rs1=null;	
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
try{
 
 con = ConnectionManager.getConnection(p);
 
	String doctype="";
	String modid="";
	String  modname="";
	
	String sql1="";
	String sql="";
	String SELECT_CHECK_BOX="";
	

	
	String chkAttribute = "";
  	
	String module_name="";
	String mode="";
	ArrayList select=new ArrayList();
	
%>

<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eSM/js/DocumentType.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	


</head>
<body  OnMouseDown="CodeArrest()" onKeyDown='lockKey();' >
<form name="documenttype_form1" id="documenttype_form1" action="../../servlet/eSM.DocumentTypeServlet" method="post" target="messageFrame">
 <%doctype=request.getParameter("DOC_TYPE_CODE")==null?"":request.getParameter("DOC_TYPE_CODE");
	String operation1		= request.getParameter("operation")==null?"":request.getParameter("operation");
	
if(!doctype.equals("")){
	mode="2";
	

 sql1 = "SELECT A.MODULE_ID module_id, B.MODULE_NAME module_name, 'Y' SELECT_CHECK_BOX FROM SY_DOC_TYPE_MASTER_DTL A, SM_MODULE B WHERE A.DOC_TYPE_CODE = '"+doctype+"' AND A.MODULE_ID=B.MODULE_ID UNION SELECT MODULE_ID, MODULE_NAME, 'N' SELECT_CHECK_BOX FROM SM_MODULE WHERE INSTALL_YN='Y' AND MODULE_ID NOT IN (SELECT MODULE_ID FROM SY_DOC_TYPE_MASTER_DTL WHERE DOC_TYPE_CODE = '"+doctype+"')order by 2";
 if(con!=null)
	{
	 
   pstmt = con.prepareStatement(sql1);
   rs1 = pstmt.executeQuery();
	while(rs1.next())
	{
		modid=rs1.getString("module_id"); 
		modname=rs1.getString("module_name");
		SELECT_CHECK_BOX=rs1.getString("SELECT_CHECK_BOX");
		
		select.add(SELECT_CHECK_BOX);
		
	}
	}
	
}
	%> 
	

 
<table border='1' cellpadding='0' cellspacing='0' width='95%' align='center'>
		<tr>
		
		<th class='columnheader' ><div   width='25%'  class='myClass'><fmt:message key="Common.ModuleName.label" bundle="${common_labels}"/></div></th>
       <th class='columnheader' ><div   width='25%'  class='myClass'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></div></th>
		</tr>
		<%

		
	
	 
	 sql="select module_id,module_name from sm_module  where INSTALL_YN='Y' order by 2";

	

	
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql);

	int i = 0;
	int cnt=1;

	
	
	while(rs.next())
	{
			
		 String mod =  rs.getString("module_id")==null?"":rs.getString("module_id");

		 if(accessRightRecSet.containsObject(mod))
			chkAttribute = "CHECKED";
		 else
			chkAttribute="";

		
		
		 String classValue = "" ;
		 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ; 
		module_name=rs.getString("module_name")==null ? "":rs.getString("module_name");
		out.println("<tr><td class='" + classValue + "'>");
		out.println(module_name);
		out.println("</td>");
		if(mode.equals("2"))
		{
		if(select.get(i).equals("Y"))
		{
		out.println("<td align='center' class='" + classValue + "'><input type='checkbox' "+chkAttribute+"  onClick='clickVal(this)' name='select"+i+"' id='select"+i+"' checked disabled>");
		}else
		{
			out.println("<td align='center' class='" + classValue + "'><input type='checkbox' "+chkAttribute+"  onClick='clickVal(this)' name='select"+i+"' id='select"+i+"'>");

		}
		}
		else
		{
			out.println("<td align='center' class='" + classValue + "'><input type='checkbox' "+chkAttribute+"  onClick='clickVal(this)' name='select"+i+"' id='select"+i+"'>");
		}

		out.println("<input type='hidden' name='module_id"+i+"' id='module_id"+i+"' value='"+mod+"'>");

		  out.println("</tr> ");
		i++;
		cnt++;
    
}

	 if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	} 
	
	 
	%> 

		
</table>
<input type="hidden" name="sStyle" id="sStyle" value="<%=sStyle%>">
 

		
		
<input type='hidden' name='insert_vals' id='insert_vals' value="" >
		<input type='hidden' name='update_vals' id='update_vals' value="" >
		<input type='hidden' name='delete_vals' id='delete_vals' value="" >
		<input type='hidden' name='basedon' id='basedon' value="" >
		<input type='hidden' name='doctype' id='doctype' value="" >
		<input type='hidden' name='longdescription' id='longdescription' value="" >
		<input type='hidden' name='shortdescription' id='shortdescription' value="" >
		<input type='hidden' name='eff_status1' id='eff_status1' value="" >
		<input type='hidden' name='startdocnum' id='startdocnum' value="" >
		<input type='hidden' name='nextdoctype' id='nextdoctype' value="" >
		<input type='hidden' name='entitymode' id='entitymode' value="" >
		<input type='hidden' name='autoprint' id='autoprint' value="" >
		<input type='hidden' name='cnt' id='cnt' value="<%=cnt%>" >
		<input type='hidden' name='operation' id='operation' value="<%=operation1%>" >
		
</form>
<%


}

catch(Exception e)
	{
//	out.println(e.getMessage());
	e.printStackTrace();
	}


	finally
	{
	try
	{
	if (stmt != null) stmt.close();
	if (rs != null)   rs.close();
	ConnectionManager.returnConnection(con,request);
	}

	catch(Exception exp)
	{
		//out.println(exp.toString());
		exp.printStackTrace();
	}
	}		

%>


</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>



