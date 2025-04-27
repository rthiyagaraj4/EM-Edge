<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>   
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>

<html>
<head>
	 <!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>  -->
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

 
	<script src='../../eCommon/js/common.js' language='javascript'></SCRIPT>
	<script language='javascript' src='../../eOA/js/PractDutyRoster.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	Connection con = null;
	Statement stmt = null;

	String facilityId=(String) session.getValue("facility_id");
	String globaluser = (String)session.getValue("login_user");
	//String oper_stn_access_rule="";
	String oper_stn_id="";

	ResultSet rs=null;
		
	try{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		
		
				String sql2="SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE            		a.facility_id='"+facilityId+"' AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+globaluser+"'	    AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))";
				if (rs!=null) rs.close();
				rs=stmt.executeQuery(sql2);

				if (rs!=null && rs.next()){
					oper_stn_id=rs.getString("oper_stn_id");

				}else{					
					%>
					<script>alert(getMessage('NO_OPER_STN_FOR_USER','Common'));
					//location.href='../../eCommon/jsp/home.jsp';
					document.location.href='../../eCommon/jsp/dmenu.jsp';
					//history.back(1);
					</script>
					<%
				}	
				if (rs!=null) rs.close();
	

		if(rs !=null) rs.close();
		if(stmt !=null) stmt.close();
	}
		catch(Exception es){
		//out.println(es);
		es.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
	}finally{
		ConnectionManager.returnConnection(con,request);
	}
%>


<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:83vh;width:100vw' scrolling='no'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<form>
<input type=text name="oper" id="oper" value="<%=oper_stn_id%>">

</form>
</html>

