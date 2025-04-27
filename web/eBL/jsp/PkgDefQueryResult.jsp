<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language="javascript" src="../../eBL/js/PkgDef.js"></script>

<%  
	request.setCharacterEncoding("UTF-8"); 
	String sStyle	= 
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT'  onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");	
	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from 			= request.getParameter("from") ;
	String to 				= request.getParameter("to") ;
	String facility_id		= (String)session.getValue("facility_id");
	String locale = (String)session.getAttribute("LOCALE");
	if ( (whereClause == null || whereClause.equals("")) )
	{ 
		String package_code		= request.getParameter("package_code");
		String long_desc		= request.getParameter("long_desc");
		String short_desc= request.getParameter("short_desc");
		/*String blng_grp_desc = request.getParameter("blng_grp_desc");
		String payer_grp_code = request.getParameter("payer_grp_code");
		String payer_grp_desc = request.getParameter("payer_grp_desc");
		String payer_code = request.getParameter("payer_code");
		String payer_desc = request.getParameter("payer_desc");
		String serv_panel_ind = request.getParameter("serv_panel_ind");
		String serv_panel_code = request.getParameter("serv_panel_code");
		String serv_panel_desc = request.getParameter("serv_panel_desc");*/
		
		int andCheck 				= 0;
		// Changing to Upper case and checking
		package_code							= package_code.toUpperCase();

		if( !(facility_id == null || facility_id.equals("")) )
		{
			sql.append(" where operating_facility_id='"+facility_id+"'   ");
			andCheck	=	1;
		}

		if( !(locale == null || locale.equals("")) )
		{
			sql.append(" and language_id='"+locale+"'   ");
			andCheck	=	1;
		}

		if ( !(package_code== null || package_code.equals("")) )
		{
			if(andCheck == 1)
			{
				sql.append(" and PACKAGE_CODE like '"+package_code+"%' ");
			}
			else
			{
				sql.append("where PACKAGE_CODE like '"+package_code+"%' ");
				andCheck = 1;
			}
		}
		if ( !(long_desc == null || long_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(LONG_DESC) like upper('"+long_desc+"%')");
			}
			else
			{
				sql.append(" where upper(LONG_DESC) like upper('"+long_desc+"%')");
				andCheck 	= 1;
			}
		}

		if ( !(short_desc == null || short_desc.equals("")) )
		{
			if ( andCheck == 1 )
			{
				sql.append(" and ");
				sql.append(" upper(SHORT_DESC) like upper('"+short_desc+"%')");
			}
			else
			{
				sql.append(" where upper(SHORT_DESC) like upper('"+short_desc+"%')");
				andCheck 	= 1;
			}
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

	Connection con = null;
	PreparedStatement stmt=null;
	ResultSet rs=null;

	try
	{
		con =  ConnectionManager.getConnection(request);

		StringBuffer strsql2=new StringBuffer();
		strsql2.append("select * from BL_PACKAGE_LANG_VW ");
		strsql2.append(sql.toString());
		stmt = con.prepareStatement(strsql2.toString());
		rs = stmt.executeQuery();
		String classValue = "" ;
		int cnt=0;
		String endOfRes="1";
		if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
		{
			rs.next() ;
		}
		while (i<=end && rs.next())
		{
			if(cnt==0)
			{
%>
<p>
	<table align='right'>
		<tr>
			<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eBL/jsp/PkgDefQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eBL/jsp/PkgDefQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	%>
			</td>
		</tr>
	</table>
	</p>
	<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width='70%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th width='20%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<%
			}
			if ( i % 2 == 0 )
		  		classValue = "QRYEVEN" ;
			else
		  		classValue = "QRYODD" ;

			String str_package_code = rs.getString("PACKAGE_CODE");
			if(str_package_code == null) str_package_code = "&nbsp;";
			String str_long_desc = rs.getString("LONG_DESC");
			if(str_long_desc == null) str_long_desc = "&nbsp;";
			String str_short_desc = rs.getString("SHORT_DESC");
			if(str_short_desc == null) str_short_desc = "&nbsp;";
			
			out.println("<tr><td class='" + classValue + "'>");
			out.println("<a href='../../eBL/jsp/PkgDefDetailMainFrame.jsp?mode=modify&packageCode="+str_package_code+"&longDesc="+str_long_desc+"&shortDesc="+str_short_desc+"' target='PkgDefFrame' >");
			out.println(str_package_code+"</a></td><td  class='" + classValue + "'>");

			out.println(str_long_desc+"</td><td  class='" + classValue + "'>");

			out.println(str_short_desc+"</a></td><td  class='" + classValue + "'>");
			i++;
			cnt++;
		}//endwhile
		if(cnt==0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		if(!rs.next()&&cnt!=0)
		{
			endOfRes="0";
%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
<%
		}
 %>
		</td></tr>
</table>
<br><center>
</center>
<%
		sql.setLength(0);
		strsql2.setLength(0);
	
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		//e.toString();
		//out.println(e.toString());
		e.printStackTrace();
	}
	finally   
	{
		if(con !=null)		 
			ConnectionManager.returnConnection(con,request);
	}
%>

</BODY>
</HTML>

