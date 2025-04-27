<!DOCTYPE html>
<!-- Last Modified Date : 9/26/2005 2:47 PM -->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*, webbeans.eCommon.* " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% 
		request.setCharacterEncoding("UTF-8");
		String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src="../../eCommon/js/common.js" language="JavaScript"></script>
		<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		
	</head>
	<BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<%
	String whereClause = request.getParameter("whereclause");
	StringBuffer sbQuery = new StringBuffer();

	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
//	sql="";
	String vagtype = request.getParameter("vag_dely_type");
	vagtype = vagtype.toUpperCase();
	String shortdesc = request.getParameter("short_desc");
	shortdesc = shortdesc.toUpperCase();
	String enabled = request.getParameter("nature");
	

	int andCheck = 0;

	//vagtype=vagtype.toUpperCase();
	
		if ( !(vagtype == null || vagtype.equals("")) )
		{
			sbQuery.append("where upper(vag_dely_type) like '");
			sbQuery.append(vagtype);
			sbQuery.append("%'");
//			sql = "where vag_dely_type like '"+vagtype+"%'";
			andCheck = 1;
		}
	
		if ( !(shortdesc == null || shortdesc.equals("")) )
		{
			if ( andCheck == 1 )
			{	
				sbQuery.append(" and ");
				sbQuery.append("upper(long_desc) like  '");
				sbQuery.append(shortdesc);
				sbQuery.append("%'");
//				sql = sql + " and ";
//				sql = sql + "upper(long_desc) like  '"+shortdesc+"%'" ;
			}
			else
			{
				sbQuery.setLength(0);
				sbQuery.append("where upper(long_desc) like '");
				sbQuery.append(shortdesc);
				sbQuery.append("%'");
//				sql = "where upper(long_desc) like '"+shortdesc+"%'" ;
				andCheck = 1;
			}
		}
	
		
		if ( !(enabled == null || enabled.equals("")) )
		{
/*		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
				sql = "where eff_status='E'";
			else
				sql = sql + " and eff_status='E'";
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0 )
				sql = " where  eff_status='D'";
			else
				sql = sql + " and eff_status='D'";
		}
*/			
		String strEffStatus="";
		if(enabled.equals("E"))
			strEffStatus="E";
		else if(enabled.equals("D"))
			strEffStatus="D";
		
		if(andCheck == 0 ){
			sbQuery.setLength(0);
			sbQuery.append("where eff_status='"+strEffStatus+"'");
		}else if(!enabled.equals("B")){
			sbQuery.append(" and eff_status='"+strEffStatus+"'");
		}

		if ( enabled.equals("B") ){
			//Added on 2/18/2005
			if(andCheck == 0){
				sbQuery.setLength(0);
				sbQuery.append(" where (eff_status='E' or eff_status='D') ");
			}else
				sbQuery.append(" and (eff_status='E' or eff_status='D') ");
			//out.println(sql );
			// sql = sql; nothing is added to get both E and D
		}
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
			sbQuery.append(" order by ");
//			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sbQuery.append(ord[i]);
//					sql=sql+ord[i];
				}else{
					sbQuery.append(ord[i]);
					sbQuery.append(",");
//					sql=sql+ord[i]+",";
				}
			}
		}
	} //end of where clause IF
	else{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
//		sql = whereClause;
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

//Connection conn = (Connection) session.getValue( "connection" ) ;
Connection conn = null;
PreparedStatement pstmt=null;
//ResultSet rset=null;
ResultSet rs=null;
//int maxRecord = 0;
try{
	conn = ConnectionManager.getConnection(request);

/*pstmt = conn.prepareStatement("select count(*) as total from mp_vaginal_dely_type "+sbQuery.toString());
rs = pstmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");
	if(pstmt!=null) 	pstmt.close();
	if(rs!=null)		rs.close();

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");*/

	pstmt = conn.prepareStatement("select vag_dely_type, long_desc, short_desc, eff_status from mp_vaginal_dely_type                       "+sbQuery.toString());
	rs = pstmt.executeQuery();

%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue = "" ;
	  int cnt=0;
	  
while ( i<=end && rs.next())
{
	if(cnt==0)
	{%>
		<p>
		<table align='right'>
		<tr>

		<%
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/VaginalDeliveryTypeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
			%>
				<td align ='right' id='next' style='visibility:hidden'>
			<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/VaginalDeliveryTypeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</p>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%	}
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
		  


	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("vag_dely_type");
	
	out.println("<a href='../jsp/addModifyVaginalDeliveryType.jsp?vag_dely_type="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	out.println("</td><td class='" + classValue + "'>");
	out.println(rs.getString("short_desc") );
	out.println("</td><td align='center' class='" + classValue + "'>");

	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	cnt++;

  }
	 if (cnt==0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	boolean flag = false;
	if ( cnt < 14 || (!rs.next()) ) {
	%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='hidden';
		</script>
	<% flag = true;
			} else {%>
		<script >
		if (document.getElementById('next'))
			document.getElementById('next').style.visibility='visible';
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<%}
  
  
  //endwhile
	if(pstmt!=null) 	pstmt.close();
	if(rs!=null)		rs.close();
}catch(Exception e){out.println("Iam thrown from here"+e.toString());}
finally{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

%>

</td></tr>
</table>
</BODY>
</HTML>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

