<!DOCTYPE html>
 <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>


<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link></head><BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%

		request.setCharacterEncoding("UTF-8");
	//String facilityId					= (String) session.getValue( "facility_id" ) ;
	String whereClause				= request.getParameter("whereclause");

	StringBuffer sql									=new StringBuffer();														//Variable that holds where clause for that's dynamically constructed
	String from								= request.getParameter( "from" ) ;		//Variable that contains the number from which the display of the record starts
	String to									= request.getParameter( "to" ) ;			//Variable that contains the number from which the display of the record ends
	
	String  menu_admin_id="";
	//String  menu_admin_id1="";
	String  menu_admin_name	="";
	String resp_group_id="";
	//String resp_group_id1="";
	String resp_group_name="";
	String eff_date_from="";
	String eff_date_to="";
	String eff_status="";

//	Connection con = (Connection) session.getValue( "connection" ) ;
	Connection con=null;
	try{
	con = ConnectionManager.getConnection(request);

	Statement stmt=null;
	ResultSet rs=null;
	//stmt = con.createStatement();
	//String facilityid=(String)session.getValue("facility_id");

	if ( (whereClause == null || whereClause.equals("")) )
	{
		/*
			Parameter variable definition starts here
			variables that holds the data/values coming from the criteria screen
		*/
		menu_admin_id=request.getParameter("menu_admin_id");
		menu_admin_name=request.getParameter("menu_admin_name");
		resp_group_id	=request.getParameter("resp_group_id");
		resp_group_name=request.getParameter("resp_group_name");
		eff_status=request.getParameter("eff_status");
		/*Parameter variable definition ends here*/

		int andCheck						 = 0;

		if(menu_admin_id!=null && !menu_admin_id.equals(""))
		{
			sql.append(" where upper(menu_admin_id) like  upper('"+menu_admin_id+"%') ");
			andCheck = 1;
		}

		if(menu_admin_name!=null && !menu_admin_name.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append( " and ");
				sql.append(" upper(menu_admin_name)  like  upper('"+menu_admin_name+"%') ") ;
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(menu_admin_name)  like upper('"+menu_admin_name+"%') ");
				andCheck = 1;
			}

		}

		if(resp_group_id!=null && !resp_group_id.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(resp_group_id) like  upper('"+resp_group_id+"%')" );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append( " where upper(resp_group_id) like upper('"+resp_group_id+"%')") ;
				andCheck = 1;
			}
		}

		if(resp_group_name!=null && !resp_group_name.equals(""))
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(resp_group_name)  like  upper('"+resp_group_name+"%') ") ;
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append( " where upper( resp_group_name)  like upper('"+resp_group_name+"%') ") ;
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
				sql.append( " and eff_status='E'");
		}
	   if ( eff_status.equals("D") )
	   {
			if ( andCheck == 0 )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where  eff_status='D'");
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


	String endOfRes = "1";
	int cnt=0;

	try
	{
		/*String strsql1="select count(*) as total from sm_menu_admin_vw "+sql.toString();
		//out.println(strsql1);
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql1);
		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0)
	
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();*/
		
		String strsql2="select menu_admin_id,menu_admin_name,resp_group_id,resp_group_name,to_char(eff_date_from,'dd/mm/yyyy') eff_date_from1 , to_char(eff_date_to,'dd/mm/yyyy') eff_date_to1, eff_status from sm_menu_admin_vw  "+sql.toString();
		//out.println(strsql2);
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);
		String resp_id="";
		if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

		while (i<=end && rs.next()){
				if (cnt == 0){
	%>

		<P>
		<table align='right'>
			<tr>
				<td>
					<%
					if ( !(start <= 1) )
					{%>
						<A HREF='../../eSM/jsp/MenuadminQueryResult.jsp?from=<%=(start-14)%>&to=<%=(end-14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
					<%}
				if ( endOfRes.equals("1") )
					{%>
						<A id='nextval' name='nextval' HREF='../../eSM/jsp/MenuadminQueryResult.jsp?from=<%=(start+14)%>&to=<%=(end+14)%>&whereclause=<%=URLEncoder.encode(sql.toString())%>' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
					<%}%>
				</td>
			</tr>
		</table>
		<br><br>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th><fmt:message key="eSM.MenuAdminID.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.MenuAdminName.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.ResponsibilityGroupID.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.ResponsibilityGroupName.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.EffectiveFromDate.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.EffectiveToDate.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
			</tr>
	<%	}


				String classValue = "" ;

				
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;

						menu_admin_id=rs.getString("menu_admin_id");
						menu_admin_name=rs.getString("menu_admin_name");
						resp_group_id	=rs.getString("resp_group_id");
						resp_group_name=rs.getString("resp_group_name");

						eff_date_from=rs.getString("eff_date_from1");
						if( eff_date_from==null) eff_date_from="";
						else eff_date_from = DateUtils.convertDate(eff_date_from,"DMY","en",localeName);
						
						eff_date_to=rs.getString("eff_date_to1");
						if( eff_date_to==null) eff_date_to="";
						else eff_date_to = DateUtils.convertDate(eff_date_to,"DMY","en",localeName);

						eff_status=rs.getString("eff_status");
						resp_id =rs.getString("resp_group_id");
						if(resp_id == null) resp_id="";
						%>
						<tr>
						<td class='<%=classValue%>'><a  href='../../eSM/jsp/AddModifyMenuAdmin.jsp?menu_admin_id=<%=menu_admin_id%>&menu_admin_name=<%=java.net.URLEncoder.encode(menu_admin_name)%>' target='f_query_add_mod' >
						<%=menu_admin_id%></a></td>
						<td class='<%=classValue%>'> 
						<%//<a  href='../jsp/AddModifyMenuAdmin.jsp?menu_admin_id="+menu_admin_id+"&menu_admin_name="+java.net.URLEncoder.encode(menu_admin_name)+"'  target='f_query_add_mod' >");%>

						<%=menu_admin_name%></a></td>
						<td class='<%= classValue%>'> 
						<%=resp_id%>
						</td>
						<td class='<%=classValue%>'> 
						<%// <a  href='../../eSM/jsp/AddModifyMenuAdmin.jsp?menu_admin_id="+menu_admin_id+"&menu_admin_name="+java.net.URLEncoder.encode(menu_admin_name)+"'  target='f_query_add_mod' >");%>
						<%=resp_group_name%></a></td><%
						/*out.println("<td class='" + classValue + "'>");
						out.println(eff_date_from+"</td>");
						out.println("<td class='" + classValue + "'>");
						out.println(eff_date_to+"</td>");*/
						%>
						<td class='<%=classValue%>'><%=eff_date_from%>&nbsp;</td>
						<td class='<%=classValue%>'><%=eff_date_to%>&nbsp;</td>
						
						<td class='<%=classValue%>' align='center'>
						<%
						if(eff_status.equals("E"))
					{%>
							<img src='../../eCommon/images/enabled.gif'></img>
						<%}else
						{%>
							<img src='../../eCommon/images/disabled.gif'></img>
						<%}%>
						</td></tr>
						<%
						i++;
						cnt++;
					}
				if( cnt == 0 )
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

	if(!rs.next() && cnt!=0 )
	{
		 endOfRes = "0";		
	%>
	<script>
		document.getElementById('nextval').innerHTML=" ";
		//document.getElementById('nextval').style.visibility='hidden';
	</script>

<% }
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					//endwhile
			}
			catch(Exception e)
			{
				out.print("here3"+e.toString());
			}
			finally
			{
					
			}
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

