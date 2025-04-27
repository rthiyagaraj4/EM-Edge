<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           								created
04/04/2014	ICN_ADHOC_024	Nijitha										Unable to get data from query results when clinck on flowsheet id with special charts
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.util.*,java.sql.*,java.net.*,java.text.*, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	 <%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//		Properties p = (Properties)session.getValue("jdbc");
//		String locale	= (String) p.getProperty("LOCALE");
	%>
	<!-- Added by Arvind @ 07-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<form>
<%
	Connection con			=	null ;
	String whereClause		=	"";

	String menu_id			=	"";
	String long_desc		=	"";
	String short_desc		=	"";
	String eff_status		=	"";
	StringBuffer sql				=	new StringBuffer();

	String mode				=	"";
	try	
	{
			 mode="modify";
			whereClause= request.getParameter("whereclause");
			if(whereClause==null) whereClause="";
			String from = request.getParameter( "from" ) ;
		    String to = request.getParameter( "to" ) ;
            menu_id=request.getParameter("id");
			//out.println("menu_id="+menu_id);
			if( menu_id == null)
			 menu_id = "";
			short_desc=request.getParameter("short_desc");
			if(short_desc == null)
				short_desc="";
			eff_status=request.getParameter("eff_status");
			if( eff_status == null)
				eff_status = "";
			long_desc=request.getParameter("long_desc");
			if(long_desc == null)
				long_desc="";
	if ((whereClause == null || whereClause.equals("null") || whereClause.equals("") ))
	{
        int cnt=0;
	    if( !(menu_id == null || menu_id.equals("null") || menu_id.equals("") ) )
		{
		    sql.append( " where upper(FLOW_SHEET_ID) like upper('"+menu_id+"%') ");
			cnt++;
		}//menu_id
	if( !(short_desc == null  || short_desc.equals("null") || short_desc.equals("")) )
		{
			if(cnt>0)
			{
				 sql.append( "and upper(SHORT_DESC) like upper('"+short_desc+"%')");
			}
			else
			{
				sql.append( " where upper(SHORT_DESC) like  upper('"+short_desc+"%')");
				cnt = 1;
			}
		}//short_desc

if( !(long_desc == null  || long_desc.equals("null") || long_desc.equals("")) )
		{
			if(cnt>0)
			{
				sql.append(" and upper(LONG_DESC) like upper('"+long_desc+"%')");
			}
			else
			{
				sql.append(" where upper(LONG_DESC) like  upper('"+long_desc+"%')");
				cnt = 1;
			}
		}//long_desc
		 if (!(eff_status == null || eff_status.equals("null") || eff_status.equals("") ) )
		{
			if( eff_status.equals("E") )
			{
  				if(cnt>0)
				{
					sql.append(" and eff_status='E' ");
				}
				else
				{
					sql.append( " where eff_status='E'" );
				}
			}
			if (eff_status.equals("D") )
			{
				if(cnt>0)
				{
					sql.append(" and eff_status='D' ");
				}
				else
				{
					sql.append(" where  eff_status='D' ");
				}
			}
		}//eff_status

String ord[] = request.getParameterValues("orderbycolumns");
if ( !(ord == null  || ord .equals("null") || ord .equals("")) )
	{
				sql.append(" order by ");
				for ( int i=0;i < ord.length;i++ )
				{
					if ( i == ord.length - 1 )
					{
						sql.append(ord[i]);
					}
					else
					{
						sql.append(ord[i]+",");
					}
				}			
}//if ord

} //if of where clause
else
	{
		sql = new StringBuffer(whereClause);
	}

	int start = 0 ;
    int end = 0 ;
    int i=1;

		if ( from == null)
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

	    if ( to == null)
		    end = 14 ;
		else
			end = Integer.parseInt( to ) ;	

	PreparedStatement stmt,stmt1 =null;
	int maxRecord =	 0;
	ResultSet rset=null;
	ResultSet rs=null;
	  
	try{
	    con  = ConnectionManager.getConnection(request);
		
		String strsql="select count(*) as total from CA_FLOW_SHEET"+sql.toString();

		String strsql1="select flow_sheet_id,short_desc,long_desc,eff_status from CA_FLOW_SHEET";

		stmt = con.prepareStatement(strsql);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		
		if(rs != null)rs.close();
		if(stmt != null)stmt.close();
	
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
	
	stmt1=con.prepareStatement(strsql1+sql.toString());
	rset = stmt1.executeQuery();
	}//try
	catch (Exception e)
	{
		//out.println("Exception :"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	%>
<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='95%'></td>
<td  align='right' width='5%' nowrap>
<%
if ( !(start <= 1) )
    out.println("<A  class='gridLink' HREF='../../eCA/jsp/FlowSheetComponentResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+" </A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A class='gridLink' HREF='../../eCA/jsp/FlowSheetComponentResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+" </A>");
	
%>
</td></tr>
</table>

<table class='grid' border='1' width='100%' cellpadding='3' cellspacing='0' align='center' >
	<th class='columnHeadercenter' width='20%' align="left"><fmt:message key="eCA.FlowSheetID.label" bundle="${ca_labels}"/></th>
	<th class='columnHeadercenter' width='20%' align="left"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
	<th class='columnHeadercenter' width='30%' align="left"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
	<th class='columnHeadercenter' width='20%' align="left"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%
	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
      {
          if ( i % 2 == 0 )
            classValue = "gridData" ;
            else
            classValue = "gridData" ;
	
	menu_id	=(rset.getString(1)==null)?"":rset.getString(1);
	short_desc=(rset.getString(2)==null)?"":rset.getString(2);
	long_desc=(rset.getString(3)==null)?"":rset.getString(3);
	eff_status	=(rset.getString(4)==null)?"":rset.getString(4);
	out.println("<tr><td align='left' class='" + classValue + "'>");
	//out.println("<a class='gridLink' href='../../eCA/jsp/FlowSheetComponent.jsp?mode="+mode+"&menu_id="+menu_id+"&short_desc="+short_desc+"&long_desc="+long_desc+"&eff_status="+eff_status+"' target='f_query_add_mod'>");//ICN_ADHOC_024
	out.println("<a class='gridLink' href='../../eCA/jsp/FlowSheetComponent.jsp?mode="+mode+"&menu_id="+java.net.URLEncoder.encode(menu_id,"UTF-8")+"&short_desc="+short_desc+"&long_desc="+long_desc+"&eff_status="+eff_status+"' target='f_query_add_mod'>");//ICN_ADHOC_024
    out.println(menu_id+"</a></td>");
	out.println("<td class='" + classValue + "' >"+short_desc+"</td>");
    out.println("<td class='" + classValue + "'>"+long_desc+"</td>"); 
	out.println("<td class='" + classValue + "' >");
    if (eff_status.equals("E"))
		  {
			out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		  }
    else
	  {
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	  }
	out.println("</td>");
	out.println("</td></tr>");
	i++;

}
if(rset != null)rset.close();
if(stmt1 != null)stmt1.close();
%>
</table>
<%
	} catch (Exception e)
	{
		//out.println("Exception :"+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}

	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</body>
</html>

