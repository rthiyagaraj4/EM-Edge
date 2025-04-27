<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>  
<%@ page  contentType="text/html;charset=UTF-8"  import ="java.sql.*,webbeans.eCommon.*" %>
<!--
	Developed by	:	Manish Anand
	Created on		:	16-08-2002
	Module			:	eOA
	Function		:	Populate reason list box
-->
<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	 <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='MESSAGE' OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
	<form name='reasonPopulate' id='reasonPopulate'>

<%
request.setCharacterEncoding("UTF-8");
	String reasonType = request.getParameter("reasonType");
	String columnName="";
	String code="";
	String desc="";
	String sql="";
	String locale=(String)session.getAttribute("LOCALE");

	Connection con=null;
	Statement stmt=null;
	ResultSet rs = null;
	try{
		con = ConnectionManager.getConnection(request);
		if ( (reasonType != null) || !(reasonType.equals("")) )
		{
			if(reasonType.equals("B"))
				columnName="block_schedule_yn";
			else if(reasonType.equals("L"))
				columnName="lift_schedule_yn";
			if(reasonType.equals("C"))
				columnName="cancel_schedule_yn";

		//	sql="select contact_reason_code, contact_reason from am_contact_reason where eff_status='E' and "+columnName+"='Y' order by contact_reason";

			sql="select contact_reason_code, contact_reason from am_contact_reason_lang_vw where eff_status='E' and "+columnName+"='Y' and language_id = '"+locale+"' order by contact_reason";
			stmt = con.createStatement() ;
			rs = stmt.executeQuery(sql) ;

			if (rs != null)
			{
				while(rs.next())
				{
					code=rs.getString("contact_reason_code");
					desc=rs.getString("contact_reason");
%>
					<script>
							var element = parent.frames[1].document.createElement('OPTION');
							element.value= "<%=code%>";
							element.text = "<%=desc%>";
							parent.frames[1].document.forms[0].reason.add(element);
					</script>
<%
				}
			}
		}
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();
	}
		
	catch(Exception e){
		//out.println(e.toString());
		e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally{
		
		ConnectionManager.returnConnection(con,request);
	}
%>
	</form>
</body>
</html>

