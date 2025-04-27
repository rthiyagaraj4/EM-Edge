<!DOCTYPE html>
<!-- @ The Page is from MP Admin Setup Terminal Digit on change of facility field the MR Section is populated. -->
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<HEAD>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
		 <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
		 <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</link>
	</HEAD>
<body CLASS='MESSAGE' onKeyDown='lockKey();'>
<!-- @ Get The Connection and declare the prepared stmt. -->
<%
	Connection con = null;
	PreparedStatement pstmt1 = null;
	ResultSet rset = null;
%>
<!-- @ Declare the Variables. -->
<%
	String facility = request.getParameter("facility")==null?"":request.getParameter("facility");

	String sqlRelation = null;
	String strRelationShip = null;
	String strRelationShipCode = null;
	int intFlag = 0;
%>
<!-- @ Query For the Relation Ship. -->
<%
sqlRelation = "SELECT mr_section_code, short_name FROM mr_section WHERE facility_id =? order by short_name";
%>
<script>
var n = parent.f_query_add_mod.document.forms[0].mr_section.options.length;		
for(var i=1;i<n;i++)
	{
	parent.f_query_add_mod.document.forms[0].mr_section.remove("mr_section");	
	}
	var tp="";
	</script>	        
<%
try{
		con = ConnectionManager.getConnection(request);
		pstmt1 = con.prepareStatement(sqlRelation);
		pstmt1.setString(1,facility);
		rset = pstmt1.executeQuery();		
		if(rset != null)
			{			
			while(rset.next())
			{
				intFlag = 1;
				strRelationShipCode = rset.getString("mr_section_code");
				strRelationShip = rset.getString("short_name");		
%>
			<script>
				var temp = "<%=strRelationShipCode%>";
				var temp1="<%=strRelationShip%>";
				var opt=parent.f_query_add_mod.document.createElement("OPTION");		
				opt.text=temp1;
				opt.value=temp;			
				parent.f_query_add_mod.document.forms[0].mr_section.add(opt);		
			</script>
<%
			}
		}
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		if(rset != null)rset.close();
		if(pstmt1 != null)pstmt1.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
	
	
%>
<!-- @ if No Records Found. -->
<%
if(intFlag == 0)
	{ %>
	<script>
	var n = parent.f_query_add_mod.document.forms[0].mr_section.options.length;		
	for(var i=0;i<n;i++)
	{
	parent.f_query_add_mod.document.forms[0].mr_section.remove("mr_section");	
	}
	var tp="";
	</script>
	<script>
		var temp = "";
		var temp1="------"+getLabel("Common.defaultSelect.label","Common")+"------";
		var opt=parent.f_query_add_mod.document.createElement("OPTION");		
		opt.text=temp1;
		opt.value=temp;			
		parent.f_query_add_mod.document.forms[0].mr_section.add(opt);		
	</script>
<%
	}
%>
</BODY>
</HTML>

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

