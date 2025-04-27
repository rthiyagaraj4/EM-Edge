<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script> 
<% 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	int divcnt = 2;
	String nextrecord ="N";
	String prevflg =request.getParameter( "prevflg" );
	if(prevflg == null)
	prevflg="true";
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
    out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' ");

	String whereClause = request.getParameter("whereclause");
	
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	/*Added by lakshmanan for security issue ID 174153177 on 05-09-2023 start */
	java.util.HashMap psthashmap		=	new java.util.HashMap() ;
	int psthmcount=0;
	/*Added by lakshmanan for security issue ID 174153177 on 05-09-2023 end */

	if ( (whereClause == null || whereClause.equals("")) )
	{
//	sql = "";
	String cd = request.getParameter("ETHNIC_GROUP_CODE");
	cd = cd.toUpperCase();
	String longdesc = request.getParameter("LONG_DESC");
	longdesc = longdesc.toUpperCase();
	String enabled = request.getParameter("nature");

	String subcd = request.getParameter("RACE_CODE");
	subcd = subcd.toUpperCase();
	String sublongdesc = request.getParameter("RACE_LONG_DESC");
	sublongdesc = sublongdesc.toUpperCase();

	int andCheck = 0;
	

	if ( !(cd == null || cd.equals("")) )
	{
		sbQuery.append("where ETHNIC_GROUP_CODE like ? ");
		psthashmap.put(++psthmcount,cd+"%");
		//sbQuery.append(cd);
		//sbQuery.append("%'");
//		sql = "where ETHNIC_GROUP_CODE like '"+cd+"%'";
		andCheck = 1;
	}
	if ( !(longdesc == null || longdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,longdesc+"%");
			//sbQuery.append(longdesc);
			//sbQuery.append("%'" );
//			sql = sql + " and ";
//			sql = sql + "upper(LONG_DESC) like  '"+longdesc+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,longdesc+"%");
			//sbQuery.append(longdesc);
			//sbQuery.append("%'" );
//			sql = "where upper(LONG_DESC) like '"+longdesc+"%'" ;
			andCheck = 1;
		}
	}
	if ( !(subcd == null || subcd.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(RACE_CODE) like ? ");
			psthashmap.put(++psthmcount,subcd+"%");
			//sbQuery.append(subcd);
			//sbQuery.append("%'");
//			sql = sql + " and ";
//			sql = sql + "upper(RACE_CODE) like  '"+subcd+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(RACE_CODE) like ? ");
			psthashmap.put(++psthmcount,subcd+"%");
			//sbQuery.append(subcd);
			//sbQuery.append("%'");
//			sql = "where upper(RACE_CODE) like '"+subcd+"%'" ;
			andCheck = 1;
		}
	}

	if ( !(sublongdesc == null || sublongdesc.equals("")) )
	{
		if ( andCheck == 1 )
		{	
			sbQuery.append(" and ");
			sbQuery.append("upper(RACE_LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,sublongdesc+"%");
			//sbQuery.append(sublongdesc);
			//sbQuery.append("%'" );
//			sql = sql + " and ";
//			sql = sql + "upper(RACE_LONG_DESC) like  '"+sublongdesc+"%'" ;
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(RACE_LONG_DESC) like ? ");
			psthashmap.put(++psthmcount,sublongdesc+"%");
			//sbQuery.append(sublongdesc);
			//sbQuery.append("%'");
//			sql = "where upper(RACE_LONG_DESC) like '"+sublongdesc+"%'" ;
			andCheck = 1;
		}
	}

	if ( !(enabled == null || enabled.equals("")) )
	{
		//Added by Sabarinathan S on 2/17/2005		
		if(!enabled.equals("B")){
			if(andCheck == 0){
				sbQuery.setLength(0);
				sbQuery.append("where  ");
			}else
				sbQuery.append(" and ");
			sbQuery.append("eff_status=? ");
			psthashmap.put(++psthmcount,enabled);
		}else if(enabled.equals("B")){
			if(andCheck == 1)	
				sbQuery.append(" and (eff_status='E' or eff_status='D')");
			else{
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E' or eff_status='D'");				
			}
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
	  	end = 42 ;
	else
		end = Integer.parseInt( to ) ;

//Connection conn = (Connection) session.getValue( "connection" ) ;

Connection conn = null;

PreparedStatement pstmt=null;
ResultSet rs=null;
//int maxRecord = 0;
try{
	 conn = ConnectionManager.getConnection(request);
/*try{
	pstmt = conn.prepareStatement("select count(*) as total from MP_ETHNIC_GROUP_VW "+sbQuery.toString());
	rs = pstmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
}catch(Exception e) { out.println(e.toString());}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}

if (maxRecord==0) 			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");*/
try{
	pstmt =conn.prepareStatement("select * from MP_ETHNIC_GROUP_VW "+sbQuery.toString()); 
	int pstcount=1;
	while ( pstcount<=psthashmap.size()) {
	pstmt.setString(pstcount,(String) psthashmap.get(pstcount));
	pstcount++;
	}
	psthashmap.clear();
	psthmcount=0;
	rs = pstmt.executeQuery();

%>



<%
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;
    String classValue = "" ;
	String race_long_desc = "";
	int cnt=0;

while (i<=(end+1) && rs.next() )
//while (rs.next())
{
	

	if(i<=end)
	{
	
	if(cnt==0)
	{%>
		<P>
		
		<table align='right'>
		<tr>
	<!-- 	<td align ='right' id='prev' style='visibility:hidden'> -->
		<%
		//if ( start == 1 )
		//{
			out.println("<td align ='right' id='prev' style='visibility:hidden'><A HREF='#' id='prev1' style='cursor: pointer' onclick='onld1('prev')'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		//}
		//else
		//{
		//	out.println("<td align ='right' id='prev' ><A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" id='prev1' style='cursor: pointer' onclick='onld1('prev')'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");
		//}
		//	out.println("<td align ='right' id='prev'><A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		%></td>
			<td align ='right'  style='visibility:hidden'>
		<%
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='#'  style='cursor: pointer' id='next1'  onclick='onld1('next')' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			//out.println("<A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
		</tr>
		</table>
			<BR><BR>
		</P>

		<center>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th width='10%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th width='25%'><fmt:message key="Common.race.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
		<th width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		</table>
		<div id='page1' style="display:'none'">
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<%}
	if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
		classValue = "QRYODD" ;
	race_long_desc = rs.getString("RACE_LONG_DESC")==null?"":rs.getString("RACE_LONG_DESC");
	out.println("<tr><td align='left' width='10%' class='" + classValue + "'>");
	String code = rs.getString("ETHNIC_GROUP_CODE");

	out.println("<a href='../../eMP/jsp/EthnicSubGroupModify.jsp?ETHNIC_GROUP_CODE="+ code + "' target='f_query_add_mod' >");
	out.println(code+"</a></td><td width='30%' class='" + classValue + "'>");
	out.println( rs.getString("LONG_DESC") );
	out.println("</td><td width='25%' class='" + classValue + "'>");
	out.println(rs.getString("SHORT_DESC") );
	out.println("</td><td  width='25%' class='" + classValue + "'>");
	out.println(" "+race_long_desc+" ");
	out.println("</td><td width='10%' class='" + classValue + "' align='center'>");
	/*if ( rs.getDate("eff_date_from") != null )
	{
	 java.util.Date date = rs.getDate("eff_date_from");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 String dateString = formatter.format(date);
	 out.println(dateString);
	 dateString = null;
	 formatter = null;
	}
	else
	{
	     out.println("&nbsp;");
	}
	out.println("</td><td class='" + classValue + "'>");

	if ( rs.getDate("eff_date_to") != null )
	{
	 java.util.Date date1 = rs.getDate("eff_date_to");
	 SimpleDateFormat formatter = new SimpleDateFormat ("dd/MM/yyyy");
	 String dateString = formatter.format(date1);
	 out.println(dateString);
	}
	else
	{
	        out.println("&nbsp;");
	}
	out.println("</td><td align='center' class='" + classValue + "'>");
*/
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	
	cnt++;
	if(cnt%14 == 0 && (cnt+start-1) != end)
	{%>
		</table>
		</div>
		<div id='page<%=divcnt%>' style="display:'none'">
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<% divcnt++;	
	}
	}
	else
	{
		nextrecord="Y";
	}
	i++;
} 

%>
</div>
<%
		if (cnt==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			boolean flag = false;
			if ( cnt < 14 || (!rs.next()) ) {
			%>
				<script >
			//	if (document.getElementById("next"))
				//	document.getElementById("next").style.visibility='hidden';
				</script>
			<% flag = true;
					} else {%>
				<script >
			//	if (document.getElementById("next"))
				//	document.getElementById("next").style.visibility='visible';
				</script>
			<%}%>

</td></tr>
</table>
</center>

<br><center>
<SCRIPT LANGUAGE="JavaScript">
var divno;
if('<%=prevflg%>'=='true')
{
divno =1;
}
else
{
	divno ='<%=divcnt-1%>';
}
var divcntlc=1;
var totaldivs='<%=divcnt-1%>';

function onld1(choice1)
{
	var choice=choice1;
	//alert('onld');
	//alert('divno'+divno);
	//alert('next:'+document.getElementById("next1").href);
	var check=1;
	var check1=1;
	if(choice=='next')
	{
		//eval("document.getElementById("page")"+divno+".style.visibility='hidden'");
		if(eval(document.getElementById('page'+divno)))
		eval(document.getElementById('page'+divno).style.display='none');
		divno=parseInt(divno) + 1;
		divcntlc=parseInt(divcntlc) + 1;
		if(eval(document.getElementById('page'+divno)))
		eval(document.getElementById('page'+divno).style.display='inline');
		check=parseInt(divno) + 1;
		check1=parseInt(divno) - 1;
	}
	if(choice=='prev')
	{
		if(eval(document.getElementById('page'+divno)))
		eval(document.getElementById('page'+divno).style.display='none');
		divno=parseInt(divno) - 1;
		divcntlc=parseInt(divcntlc) - 1;
		if(eval(document.getElementById('page'+divno)))
		eval(document.getElementById('page'+divno).style.display='inline');
		check1=parseInt(divno) - 1;
		check=parseInt(divno) + 1;
		
	}
	if(choice=='first')
	{
		if('<%=prevflg%>'=='true')
		{
		document.getElementById("page1").style.display='inline';
		}
		else
		{
			eval(document.getElementById('page'+<%=divcnt-1%>).style.display='inline');
		}

		if('<%=start%>'==1)
		{
		document.getElementById("prev").style.visibility='hidden';
		}
		check=parseInt(divno) + 1;
		check1=parseInt(divno) - 1;
	}
	
		if(eval(document.getElementById('page'+check)))
		{
			document.getElementById("next").style.visibility='visible';
		}
		else
		{
			if('<%=nextrecord%>'=='N' )
			{
			document.getElementById("next").style.visibility='hidden';
			}
			else
			{
				document.getElementById("next").style.visibility='visible';
			}
		}
		if(eval(document.getElementById('page'+check1))
		{
			document.getElementById("prev").style.visibility='visible';
		}
		else
		{	
			if('<%=start%>'==1)
			{
			document.getElementById("prev").style.visibility='hidden';
			}
			else
			{
				document.getElementById("prev").style.visibility='visible';
			}
			
		}
		prevnextlink(choice);
//alert('<%=nextrecord%>');

}

function prevnextlink(choice)
{	
	if(choice=='first')
	{
		if('<%=start%>'!=1 && (divno==1 || divno==0))
		{
		document.getElementById('prev').innerHTML="<A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=<%=(start-42)%>&to=<%=(end-42)%>&prevflg=false&whereclause=<%=URLEncoder.encode(sbQuery.toString())%>' text-decoration='none'>"+getLabel('Common.previous.label','common')+"</A>";
		}
		else
		{
			document.getElementById('prev').innerHTML="<A HREF='#' onclick='onld1('prev')' text-decoration='none'>"+getLabel('Common.previous.label','common')+"</A>";
		}
	
		if('<%=prevflg%>'=='true')
		{
		document.getElementById('next').innerHTML="<A HREF='#' style='cursor: pointer' onclick='onld1('next')' text-decoration='none'>"+getLabel('Common.next.label','common')+"</A>";
		}
		else
		{
			document.getElementById('next').innerHTML="<A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=<%=(start+42)%>&to=<%=(end+42)%>&prevflg=true&whereclause=<%=URLEncoder.encode(sbQuery.toString())%>' text-decoration='none'>"+getLabel('Common.next.label','common')+"</A>";
		}
	
	}
	else if(choice=='next' || choice=='prev')
	{
		if(divno=='<%=divcnt-1%>' && '<%=nextrecord%>'!='N')
		{
			document.getElementById("next").innerHTML="<A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=<%=(start+42)%>&to=<%=(end+42)%>&prevflg=true&whereclause=<%=URLEncoder.encode(sbQuery.toString())%>' text-decoration='none'>"+getLabel('Common.next.label','common')+"</A>";
		}
		else
		{
			document.getElementById("next").innerHTML="<A HREF='#' onclick='onld1('next')' text-decoration='none'>"+getLabel('Common.next.label','common')+"</A>"
		}
	/*}
	else if(choice=='prev')
	{*/
//		if(divno==1 && '<%=prevflg%>'=='true')
		if(divno==1)
		{
			document.getElementById('prev').innerHTML="<A HREF='../../eMP/jsp/EthnicSubGroupQueryResult.jsp?from=<%=(start-42)%>&to=<%=(end-42)%>&prevflg=false&whereclause=<%=URLEncoder.encode(sbQuery.toString())%>' text-decoration='none'>"+getLabel('Common.previous.label','common')+"</A>";
		}
		else
		{
			document.getElementById('prev').innerHTML="<A HREF='#' onclick='onld1('prev')' text-decoration='none'>"+getLabel('Common.previous.label','common')+"</A>";
		}
	}
//	alert(document.getElementById("prev").innerHTML);
	//alert(document.getElementById("next").innerHTML);
}
</SCRIPT>

<SCRIPT LANGUAGE="JavaScript">
	onld1('first');
</SCRIPT>
<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>



	<%

}catch(Exception e) { 
	//out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174222042 on 05-09-2023
	}
finally
{
	if (pstmt != null) pstmt.close();
	if (rs != null) rs.close();
}
}catch(Exception e) { 
	// out.println(e.toString());
	e.printStackTrace(); // Added by lakshmanan for security issue ID 174222043 on 05-09-2023
	}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}


%>

</center>
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

