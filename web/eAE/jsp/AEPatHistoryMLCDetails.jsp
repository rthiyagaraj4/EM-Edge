<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8"%>
<html> 
<head>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	request.setCharacterEncoding("UTF-8");
	String mlc_details	=	"";
    String title		= request.getParameter("call_from");
          title			= (title==null)?"":title;

		  if(!title.equals("") && title.equalsIgnoreCase("MLC"))
		      title = "MLC Details";
		  else if(!title.equals("") && title.equalsIgnoreCase("IR"))
			  title = "Incident Remarks";
		 else title ="";
	
	String facilityId			 = (String)session.getValue("facility_id");
	String encid				 =	request.getParameter("encid");
	String sqlMLC				 =	"select medico_legal_details from ae_pat_emergency_detail b where facility_id=? and encounter_id=?";
	sqlMLC=sqlMLC+" AND B.RECORDED_DATE=(SELECT MAX(RECORDED_DATE) FROM AE_PAT_EMERGENCY_DETAIL WHERE facility_id = b.facility_id AND encounter_id = b.encounter_id AND rownum < 2)";
    
	Connection con	=	null;
	PreparedStatement stmt	=	null;
	ResultSet rset	=	null;
	
	try{
                con                  = ConnectionManager.getConnection(request);
				stmt = con.prepareStatement(sqlMLC);
				stmt.setString(1,facilityId);
				stmt.setString(2,encid);
				rset = stmt.executeQuery();
				
				rset.next();
				mlc_details			 = rset.getString(1);
				mlc_details			 = (mlc_details == null)?"":mlc_details;

				if(rset!=null)  rset.close();
				if(stmt!=null)  stmt.close();
					
		%>
<title><%=title%></title>
</head>
<body style='background-color:#E2E3F0;' onKeyDown = 'lockKey()' >
<table width='100%' border='0' cellspacing='0' cellpadding='0' align=center>
	<tr>
		<td align='left' class='label' width='10%'></td>
	</tr>
	<tr>
		<td><textarea rows=8 cols=50 readonly><%=mlc_details%></textarea></td>
	</tr>
</table>
	<center><input type='Button' class='Button' name='Ok' id='Ok' value='  OK  ' onClick='window.close();'></center>	

</body>
<%
    }
    catch(Exception e)
    {
	e.printStackTrace(); 
	}
    finally
    {
        if(con!=null)
	    ConnectionManager.returnConnection(con,request);
    }
%>

</html>

