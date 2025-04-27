<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
<head>
<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null)
		whereClause="";
	StringBuffer sql=new StringBuffer();  
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String Log_user= (String) session.getValue("login_user");
	String Resp="";
	Connection conn= null;
	Statement stmt=null;
	ResultSet rs=null;
	ResultSet rset=null;
	try{
		conn = ConnectionManager.getConnection(request);
		stmt=conn.createStatement();
		int Medadmin=0;

		/*String sql11="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	

		rset=stmt.executeQuery(sql11);
		if (rset !=null){
			while (rset.next()){
				Medadmin=Integer.parseInt(rset.getString(1));
		}
		
		if(rset!=null)	rset.close();
		if(stmt!=null)	stmt.close();
		
		}*/

		sql.append(" where a.resp_group_id  = b.resp_group_id(+) ");	
		if ( (whereClause == null || whereClause.equals("")) ){
			String cd = request.getParameter("menu_id");
			String fnm = request.getParameter("menuname");
			String rootmenuyn = request.getParameter("root_menu_yn");
			String resp_group_id = request.getParameter("resp_group_id");
			String dev_tool = request.getParameter("dev_tool");
					
	/*	if(Medadmin!=0){ 
			
			if(resp_group_id==null || resp_group_id.equals(""))
			{
				sql.append(" and A.RESP_GROUP_ID  in  ( select  RESP_GROUP_ID from sm_menu_Admin where upper(menu_admin_id)=upper('"+Log_user+"' ) ) ");
			}
			else
			{
				sql.append(" and A.RESP_GROUP_ID  in  ( select  RESP_GROUP_ID from sm_menu_Admin where upper(menu_admin_id) =upper('"+Log_user+"' ) ) and A.resp_group_id like  '"+resp_group_id+"%' ");
				
			}
		
		}
		else {*/
		if ( !(resp_group_id == null || resp_group_id.equals("")) ){
			
				sql.append(" and  A.resp_group_id = '"+resp_group_id+"'") ;
			
			}
		//}

		if ( !(cd == null || cd.equals("")) ) {

					sql.append("  and upper(menu_id) like upper('"+cd+"%')");
			}
			if ( !(fnm == null || fnm.equals("")) )
			{
					sql.append(" and upper(menu_name)  like  upper('"+fnm+"%') " );
			}
				
		
			if ( !(rootmenuyn == null || rootmenuyn.equals("")) )
			{
				   if ( rootmenuyn.equals("Y") )
				   {
						sql.append("and  root_menu_yn='Y'");
					}
					if ( rootmenuyn.equals("N") )
					{
						sql.append(" and  root_menu_yn='N'");
					}
			}
			
		
				if ( !(dev_tool == null || dev_tool.equals("")) )
				{
					
					sql.append("and  dev_tool='"+dev_tool+"'");
				}
		
		
		
		//appending order by clause
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
	  } //end of where clause IF
		else
		sql.setLength(0);
		sql.append(whereClause);

		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt(from) ;

		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt(to);
		int cnt = 0;
		String endOfRes="1";

		try{
				stmt = conn.createStatement();
				String sql1="select * from sm_menu_hdr a,sm_resp_grp b "+sql.toString();
				rs = stmt.executeQuery(sql1);
						if ( start != 1 )
				for( int j=1; j<start; i++,j++ )
					 rs.next() ;
				String classValue = "" ;

				 while ( i<=end && rs.next()){
					if(cnt==0){
				%>

				<p>
				<table align='right'>
				<tr>
				<td>
				<%
				if ( !(start <= 1) )
					out.println("<A HREF='../../eSM/jsp/queryMenuHeader.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

				if (endOfRes.equals("1") )
					out.println("<A id='nextval' HREF='../../eSM/jsp/queryMenuHeader.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
					
				%>
				</td>
				</tr>
				</table>
				<br><br>
				</p>

				<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<th><fmt:message key="Common.MenuID.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eSM.MenuName.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.ResponsibilityGroup.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="eSM.ToolUsed.label" bundle="${sm_labels}"/></th>
				<th><fmt:message key="Common.RootMenu.label" bundle="${common_labels}"/></th>
				<%}
							 if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						  else
							classValue = "QRYODD" ;
						  
					
					out.println("<tr><td class='" + classValue + "'>");
					String code = rs.getString("menu_id");
					
					Resp = rs.getString("resp_group_name");
					
					if (Resp==null)Resp="&nbsp;";
						
					out.println("<a href='../jsp/MenuHeader_Form.jsp?menu_id="+ code +"' target='f_query_add_mod' >");
					out.println(code+"</a></td><td class='" + classValue + "'>");
					out.println(rs.getString("menu_name"));
					
					out.println("</td><td align='left' class='" + classValue + "'>");
										
					out.println(Resp+"</td><td class='" + classValue + "'>");
					if(rs.getString("DEV_TOOL").equals("J"))
						out.println("Java");
					else
						out.println("Forms");	
					out.println("</td><td align='center' class='" + classValue + "'>");
					if ( rs.getString("ROOT_MENU_YN").equals("Y") )
						out.println("<img src='../../eCommon/images/enabled.gif'></img>");
					else
						out.println("&nbsp;");
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
				if(rs!=null) 	rs.close();
				if(stmt!=null)	stmt.close();

		}
	catch(Exception e){out.print(e);}
	//Commented on 3/22/2005
/*	finally
	{

	if(stmt!=null)	stmt.close();
	if(rs!=null) 	rs.close();
	}
*/	%>

	</td></tr>
	</table>
	<br><center>
	<%
		}catch(Exception e){out.println(e);}
			finally { 
				ConnectionManager.returnConnection(conn,request);
		}

			
%>

</center>
</BODY>
</HTML>

