<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>

<HTML><head><%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'  class='CONTENT'> 
	<%
    request.setCharacterEncoding("UTF-8");
	String whereClause				= request.getParameter("whereclause");
	StringBuffer sql									=new StringBuffer();														//Variable that holds where clause for that's dynamically constructed
	String from								= request.getParameter( "from" ) ;		//Variable that contains the number from which the display of the record starts
	String to									= request.getParameter( "to" ) ;			//Variable that contains the number from which the display of the record ends
	
	String resp_group_id="";
	String resp_group_name="";

	String eff_status="";


Connection con=null;
			try{
			con = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rs=null;
	stmt = con.createStatement();
	

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*
			Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		resp_group_id	=request.getParameter("resp_group_id");
		resp_group_name=request.getParameter("resp_group_name");
		
		eff_status=request.getParameter("eff_status");
		/*Parameter variable definition ends here*/
			

		int andCheck						 = 0;

		if(resp_group_id!=null && !resp_group_id.equals(""))
		{
			sql.append(" where upper(resp_group_id) like upper('"+resp_group_id+"%')");
			
			andCheck = 1;
		}

		if(resp_group_name!=null && !resp_group_name.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(resp_group_name) like  upper('"+resp_group_name+"%') " );
				
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(resp_group_name) like upper('"+resp_group_name+"%') ");
				
				andCheck = 1;
			}

		}

		if ( eff_status.equals("E") )
		{
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where eff_status='E'");
				andCheck = 1;
			}
			else
				sql.append(" and eff_status='E'");
		}
	   if ( eff_status.equals("D") )
	   {
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append( " where  eff_status='D'");
				andCheck = 1;
			}
			else
			sql.append(" and eff_status='D'");
		}

		String ord[] = request.getParameterValues("orderbycolumns");
		
		if ( !(ord == null || ord .equals("")) )
		{
			
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]+",");
			}
		}
	}
	else
	{
		sql.append(whereClause);
		
	}
	

	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;


	int cnt = 0;

	try
	{
		/*String strsql1="select count(*) as total from sm_resp_grp "+sql.toString();
		if(stmt!=null)  stmt.close();
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0)*/
		String endOfRes="1";
	
		String strsql2="select * from sm_resp_grp  "+sql.toString();
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);
						if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;

				String classValue = "" ;

				while (i<=end && rs.next()){
					if(cnt==0){
	%>

		<P>
		<table align='right'>
			<tr>
				<td>
					<%
					if ( !(start <= 1) )
		{%>
				<A HREF='../jsp/RespgroupQueryResult.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/>
</A>
			<%}

					if (endOfRes.equals("1") )
			{%>
						<A id='nextval' HREF='../jsp/RespgroupQueryResult.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/>
</A>
			<%}sql.setLength(0);%>	
				</td>
			</tr>
		</table>
		<br><br>
		</P>

		<table border=1 width="100%" cellspacing=0 cellpadding=0>
			<tr>
				<th><fmt:message key="eSM.ResponsibilityGroupID.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.ResponsibilityGroupName.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
	<%}	

						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						resp_group_id	=rs.getString("resp_group_id");
						
						resp_group_name=rs.getString("resp_group_name");
						eff_status=rs.getString("eff_status");
						%>
						<tr>
						<td class='<%=classValue%>'><a  href='../jsp/AddModifyRespgroup.jsp?resp_group_id=<%=resp_group_id%>' target='f_query_add_mod' >
						<%=resp_group_id%></a></td>
						<td class='<%=classValue%>'><a  href='../jsp/AddModifyRespgroup.jsp?resp_group_id=<%=resp_group_id%>' target='f_query_add_mod' >
						<%=resp_group_name%></a></td>
						<td class='<%=classValue%>' align='center'>
						<%
						if(eff_status.equals("E")){
						%>
							<img src='../../eCommon/images/enabled.gif'></img>
						<%
							}
						else{
						%>
							<img src='../../eCommon/images/disabled.gif'></img>
						<%
						}
						%>
						</td>
						</tr>
						<%
						i++;
						cnt++;
					}//endwhile
					if( cnt == 0 )
						out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
					if(!rs.next()&&cnt!=0){
					   endOfRes="0";%>
					   <script>
						   document.getElementById("nextval").innerHTML=" ";
					   </script>
					<% }
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					
			}
			catch(Exception e)
			{
				out.print("here3"+e.toString());
			}
			if(stmt!=null)stmt.close();
			%>

</td></tr>
</table>
</BODY>
</HTML>
<%
	}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(con,request);
}	
%>

