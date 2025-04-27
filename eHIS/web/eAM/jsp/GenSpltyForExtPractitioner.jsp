<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*,javax.servlet.jsp.*,java.util.*"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='Javascript'></script>
<script src='../../eAM/js/PractForExternalReferral.js' language='Javascript'></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="JavaScript">
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body CLASS="MESSAGE" onKeyDown = 'lockKey()'>
<form >
<%
	request.setCharacterEncoding("UTF-8");
	//webbeans.op.PatientData patdata = new webbeans.op.PatientData();
	Connection			con			=	null;
	Statement			stmt		=	null;
	PreparedStatement pstmt = null;
	ResultSet			rset		=	null;
	con					=	ConnectionManager.getConnection(request);
	String Referral_Source = request.getParameter("Ref_Src");

	String Splty_code = "";
	String Splty_desc = "";
	String sql = "";

		if(!Referral_Source.equals(""))
		{
			try
			{

			sql	="select a.SPECIALTY_CODE code, b.short_desc description from AM_REFERRAL_FOR_SPECIALTY a, AM_SPECIALITY b where a.REFERRAL_CODE =? AND a.SPECIALTY_CODE = b.SPECIALITY_CODE order by 2" ;

			//stmt	=	con.createStatement();
			//rset	=	stmt.executeQuery(sql);
			
			pstmt   = con.prepareStatement(sql);
			pstmt.setString	(	1,	Referral_Source		);
			rset		 = pstmt.executeQuery();

			out.println("<script>var obj =parent.frames[0].document.forms[0].splty_code;</script>");


			if(rset != null)
			{
				while(rset.next())
				{
					Splty_code = rset.getString("code");
					Splty_desc = rset.getString("description");					
				%>
					<script>
						var opt= parent.frames[0].document.createElement('Option');
							 opt.text="<%=Splty_desc%>"; 
							 opt.value="<%=Splty_code%>";
							 obj.add(opt);
						</script>

				<%}
				if(rset !=null) rset.close(); 
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				}
			}
			//while loop
			catch(Exception e)
				{
					
			 }//if rset not null
		}
		ConnectionManager.returnConnection(con,request);
%>
<input type='hidden' name='Spltydesc' id='Spltydesc' value=''>

</form>
</body>
</html>

