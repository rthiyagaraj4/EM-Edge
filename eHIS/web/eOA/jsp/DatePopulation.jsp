<!DOCTYPE html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>  
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*,com.ehis.util.*" %>

<html><head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
 <script language="javascript" src="../../eCommon/js/DateUtils.js"></script>

</head>
<body class='message'  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<%
Connection con = null;
Statement stmt = null;
ResultSet rs=null;
String prefstartdate="";
String prefenddate="";
String prefstartdate_disp="";
String prefenddate_disp="";

try{
	request.setCharacterEncoding("UTF-8");	

	con = ConnectionManager.getConnection(request);
	 stmt = con.createStatement();
	 String locale=(String)session.getAttribute("LOCALE");
	String param = request.getParameter("param");
	String no= request.getParameter("no");
	String frmCA=request.getParameter("frmCa");

	stmt = con.createStatement();
	String sql_date="select to_char(sysdate+decode('"+param+"','D',"+no+",'W',"+no+"*7,'M',(add_months(sysdate,"+no+")-sysdate)),'dd/mm/yyyy') from_date,to_char(add_months(sysdate+	(decode('"+param+"','D',"+no+",'W',"+no+"*7,'M',(add_months(sysdate,"+no+")-sysdate))),1),'dd/mm/yyyy')  to_date from dual ";
	rs = stmt.executeQuery(sql_date); 
	while (rs!=null && rs.next()){
		 prefstartdate=rs.getString("from_date");
		 prefenddate=rs.getString("to_date");
	}

prefstartdate_disp=DateUtils.convertDate(prefstartdate,"DMY","en",locale);
prefenddate_disp=DateUtils.convertDate(prefenddate,"DMY","en",locale);


	// If condtion added by Jithesh on 18-Nov-03 to handle from  CA -->

		if(frmCA.equals("N")){%>
				<script language="JavaScript">
				parent.frames[1].frames[1].document.forms[0].prefdate.value='<%=prefstartdate%>';
				parent.frames[1].frames[1].document.forms[0].prefdate1.value='<%=prefstartdate_disp%>';
				parent.frames[1].frames[1].document.forms[0].prefenddate.value='<%=prefenddate%>';
				parent.frames[1].frames[1].document.forms[0].prefenddate1.value='<%=prefenddate_disp%>';


				</script>
		<%}else{%>
				<script language="JavaScript">
				top.content.workAreaFrame.frames[1].document.forms[0].prefdate.value='<%=prefstartdate%>';
				top.content.workAreaFrame.frames[1].document.forms[0].prefdate1.value='<%=prefstartdate_disp%>';
				top.content.workAreaFrame.frames[1].document.forms[0].prefenddate.value='<%=prefenddate%>';
				top.content.workAreaFrame.frames[1].document.forms[0].prefenddate1.value='<%=prefenddate_disp%>';

				</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


			
		<%}
	if(rs !=null) rs.close();
	if(stmt !=null) stmt.close();
	if(stmt !=null) stmt.close();
}catch( Exception e ){
out.println(e.toString());
}
finally
{
	
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>


