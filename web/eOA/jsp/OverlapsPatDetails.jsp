<!DOCTYPE html>

 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>

	
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
</script>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='1' cellpadding='0' cellspacing='0' width='102%' align='center' >

<%
		Connection con = null;
		Statement	stmt		=null;
		PreparedStatement pstmt=null;
		ResultSet	rs			=null;
		request.setCharacterEncoding("UTF-8");
		String group_id	= request.getParameter("group_id");
		String app_date	= request.getParameter("app_date");
		String prac_id	= request.getParameter("prac_id");
		String classValue="";
		String name	="";
		String pat_id	="";
		String app_no="";
		String fromTime	="";
		String toTime="";
		//String group_Name="";
		int i=0;
		String locale=(String)session.getAttribute("LOCALE");
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
       try{
       con = ConnectionManager.getConnection(request);
	   stmt=con.createStatement();
		//rs = stmt.executeQuery("SELECT APPT_REF_NO,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,PATIENT_NAME,PATIENT_ID  FROM oa_appt where ( TRUNC (appt_date) = TRUNC (to_date('"+app_date+"','dd/mm/yyyy')))");
		String sql1 = "SELECT APPT_REF_NO,nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time,nvl(to_char(appt_slab_to_time,'hh24:mi'),' ') appt_slab_to_time,PATIENT_NAME,PATIENT_ID  FROM oa_appt where ( TRUNC (appt_date) = TRUNC (to_date(?,'dd/mm/yyyy')))";
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1,app_date);
		rs = pstmt.executeQuery();
			if ( rs != null )
			while(rs.next())
			{	
			if ( i % 2 == 0 )
			  classValue = "QRYEVEN" ;
		   else
			  classValue = "QRYODD" ;
			  
		        app_no=rs.getString("APPT_REF_NO");
				name=rs.getString("PATIENT_NAME");
				pat_id=rs.getString("PATIENT_ID");
				fromTime=rs.getString("appt_slab_from_time");
				toTime=rs.getString("appt_slab_to_time");
			
		%>
	<tr>
		<td  class='<%=classValue%>'  nowrap width='15%'><%=app_no%></td>
		<td  class='<%=classValue%>'  nowrap  width='20%' ><%=pat_id%></td>
		<td  class='<%=classValue%>'  wrap  width='20%' ><%=name%></td>
		<td  class='<%=classValue%>'  nowrap  width='10%'><%=fromTime%></td>
		<td  class='<%=classValue%>'  nowrap width='10%' ><%=toTime%></td>
	</tr> 
	<%	
			i++;
		
	}//end of while
			
  //} 

  if(i == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
window.close();</script>
<%}
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}
catch(Exception e)
	{
	//out.println("one L :" +e.toString());
	e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</body>
</html> 

