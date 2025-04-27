<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
</head>
<%
	Connection con=null;
	PreparedStatement stmt=null;	
	PreparedStatement stmt1=null;	
	ResultSet rs=null;	
	String  resp_id= request.getParameter("resp_id");

	String  pract_reln_id= request.getParameter("pract_reln_id");
	if(pract_reln_id==null) pract_reln_id="";
	String facility_id=request.getParameter("facility_id");
	if(facility_id==null) facility_id="";

	String	sql=" Select pract_reln_id, pract_reln_name from ca_pract_reln_for_resp_vw where resp_id= ? order by 2 ";
	stmt = con.prepareStatement(sql);
	stmt.setString(1, resp_id);

	String	sql1=" Select a.facility_id, b.facility_name from sm_facility_for_resp a, sm_facility_param b where a.facility_id=b.facility_id  and a.resp_id=? order by 2 ";
	stmt1 = con.prepareStatement(sql1);
	stmt1.setString(1, resp_id);
	String id="";
	String id1="";
	String dat="";
	String dat1="";

	
	try{
		con=ConnectionManager.getConnection(request);		
		rs=stmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				id=rs.getString(1);
				dat=rs.getString(2);%>
				<script>
					var id="<%=id%>";
					var dat="<%=dat%>";
					var opt=parent.document.frames[1].document.createElement("OPTION");
					opt.text=dat;
					opt.value=id;
					<%if(pract_reln_id.equals(id) ) 
					{%>
						opt.selected=true;
					<%}%>
					parent.document.frames[1].document.forms[0].pract_reln_id.add(opt);
				</script>
			<%}
		}
		if(rs!=null)rs.close();
		rs=stmt1.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				id1=rs.getString(1);
				dat1=rs.getString(2);
%>
	<script>
	var id1="<%=id1%>";
	var dat1="<%=dat1%>";
	var opt1=parent.document.frames[1].document.createElement("OPTION");
	opt1.text=dat1;
	opt1.value=id1;
	<%if(facility_id.equals(id1) ) {%>
		opt1.selected=true;
	<%} %>
                      
     parent.document.frames[1].document.forms[0].facility_id.add(opt1);
	</script>
<%
			}
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
	}catch(Exception e){
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		}
	
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>

<body class=message OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
</body>

