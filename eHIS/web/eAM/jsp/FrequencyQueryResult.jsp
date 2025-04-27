<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
	
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*, java.text.*,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<HTML>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
	</head>
	<BODY class='CONTENT'  OnMouseDown="CodeArrest()"  onKeyDown="lockKey()"  >

 <%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String freq_desc_loc_lang="";
	String repeat_value="";
	String interval_value="";
	String repeat_durn_type="";
	String interval_durn_type="";
	String start_time_round="";
	String start_time_assign="";
	StringBuffer sbQuery = new StringBuffer();
	String freq_code="";	
	String freq_desc="";	
	String freq_desc1="";	
	String freq_desc2="";	
	String freq_nature="";	
	String scheduled_yn="";	
	String eff_status="";	
    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	if ( (whereClause == null || whereClause.equals("")) )
	{
		freq_code		  = request.getParameter("freq_code");
		freq_desc		  = request.getParameter("freq_desc");
		freq_nature		  = request.getParameter("freq_nature");
		scheduled_yn		  = request.getParameter("scheduled_yn");;
		eff_status		  = request.getParameter("eff_status");
		if(freq_code.equals("")||freq_code == null)	freq_code = "";else freq_code = freq_code.toUpperCase();
		if(freq_desc.equals("")||freq_desc == null)	freq_desc = "";	else	freq_desc = freq_desc.toUpperCase();
		if(freq_nature.equals("''")||freq_nature.equals("")||freq_nature == null)	freq_nature = "";else	freq_nature = freq_nature.toUpperCase();
		if(scheduled_yn.equals("")||scheduled_yn == null)	scheduled_yn = "";	else	scheduled_yn = scheduled_yn.toUpperCase();
		if(eff_status.equals("")||eff_status == null)	eff_status = "";	else		eff_status = eff_status.toUpperCase();
   
		int cnt=0;
		if(!(freq_code == null || freq_code.equals("")))
        {
			sbQuery.append(" where upper(freq_code ) like upper('"+freq_code +"%')");
			cnt++;
        }
		else
			sbQuery=sbQuery;
        if (!(freq_desc.equals("") || freq_desc == null))
        {
			if(cnt>0)
				sbQuery.append(" and upper(freq_desc) like  upper('"+freq_desc+"%')");
			else
			{
				sbQuery.append(" where upper(freq_desc) like upper('"+freq_desc+"%')");
				cnt = 1 ;
			}
        }
		 if(!(freq_nature.equals("")||freq_nature == null))
		 {
			if(cnt>0)
				sbQuery.append("and freq_nature like '"+freq_nature+"%'");
			else
			{
				sbQuery.append(" where freq_nature like '"+freq_nature+"%'");
				cnt = 1 ;
			}
		}
		else
		{
			sbQuery=sbQuery;
		}
		if(!(scheduled_yn.equals("") || scheduled_yn == null))
		{
			if(scheduled_yn.equals("Y"))
			{
				if(cnt>0)
					sbQuery.append(	" and scheduled_yn like '"+scheduled_yn+"%'");
				else
				{
					sbQuery=sbQuery;
					sbQuery.append(	" where scheduled_yn like '"+scheduled_yn+"%'");	
					cnt = 1 ;
				}
			}
			else if(scheduled_yn.equals("N")) 
			{
				if(cnt>0)
					sbQuery.append(	" and scheduled_yn like '"+scheduled_yn+"%'");
				else
				{
					sbQuery.append(" where scheduled_yn like '"+scheduled_yn+"%'");
					cnt = 1 ;
				}
			}
		}
		else
		{
			sbQuery=sbQuery;
		}
		if(!(eff_status.equals("") || eff_status == null))
		{
			if(eff_status.equals("E"))
			{
				if(cnt>0)
					sbQuery.append("and eff_status='E'");
				else
					sbQuery.append(" where  eff_status='E'");
			}
			if(eff_status.equals("D"))
			{
				if(cnt>0)
					sbQuery.append(" and eff_status='D'");
				else
					sbQuery.append(" where  eff_status='D'");
			}
			if(eff_status.equals("B"))
			{
				sbQuery=sbQuery;
			}
		}
		String ord[] = request.getParameterValues("orderbycolumns");
		if(!(ord .equals("") || ord == null))
		{
			sbQuery.append(" order by ");
			for(int i=0;i<ord.length;i++)
			{
				if(i==ord.length-1)
					sbQuery.append(ord[i]);
				else
						sbQuery.append(ord[i]+",");
			}
		}
	} //end of where clause IF
    else
	{sbQuery.setLength(0);
		sbQuery.append(whereClause);	
	}  // sql = whereClause;
		
	String slClassValue="";		
	
	// Modified by Sangeetha on 3rd jul 2017 for ML-MMOH-CRF-0345.2
	String strsql1="select freq_code,freq_desc,print_desc_1,print_desc_2,freq_desc_loc_lang,Decode(freq_nature,'I', 'Interval','F','Frequency','P','PRN','C','Continous','O','One Time','Y', 'Cycle Frequency') Freq_Nature, eff_status ,repeat_value,repeat_durn_type,interval_value,interval_durn_type,scheduled_yn,start_time_assign,start_time_round from AM_FREQUENCY   "+sbQuery.toString();

	Connection conn  =  ConnectionManager.getConnection(request);
	Statement stmt=null;
	Statement stmt1=null;
	ResultSet rset=null,rs=null;
	try	
	{
		int maxRecord = 0;
		int start = 0 ;
		int end = 0 ;
		int i=1;
		String from = request.getParameter("from") ;
		String to = request.getParameter("to") ;
	    if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
	    if ( to == null )
		    end = 14 ;
		else
			end = Integer.parseInt( to ) ;
		
	

		stmt=conn.createStatement();
		rs = stmt.executeQuery(strsql1);

		if(start != 1)
		for( int j=1; j<start; i++,j++ )
		rs.next() ;

		while( i<=end && rs.next() )
	{
			if(maxRecord==0)
		{

%>

<P>
<table align='right'>
<tr>

<%
	if(!(start <= 1))
	    out.println("<td align ='right' id='prev'><A HREF='FrequencyQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

	//if(!((start+14) > maxRecord ))
		out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='FrequencyQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");  

%>
	</tr>
</table>
<br><br>
</p>
<table cellpadding=0 cellspacing=0 border=1 width='98%'>
	<th class='columnheader' ><fmt:message key="Common.FrequencyCode.label" bundle="${common_labels}"/></th>
	<th class='columnheader' ><fmt:message key="Common.FrequencyDescription.label" bundle="${common_labels}"/></th>
	<th class='columnheader' ><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;1</th>
	<th class='columnheader' ><fmt:message key="Common.print.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;2</th>
	<th class='columnheader' ><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></th>
	<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>  

<% }
	
		freq_code	= rs.getString("freq_code");
		freq_desc   = rs.getString("freq_desc");
		freq_desc1   = rs.getString("print_desc_1");
		freq_desc2   = rs.getString("print_desc_2");
		if (freq_desc1==null)freq_desc1="";
		if (freq_desc2==null)freq_desc2="";
		
		freq_nature	= rs.getString("freq_nature");
		eff_status  = rs.getString("eff_status");

		freq_desc_loc_lang = rs.getString("freq_desc_loc_lang");
		scheduled_yn = rs.getString("scheduled_yn");
		repeat_value = rs.getString("repeat_value");
		interval_value = rs.getString("interval_value");
		repeat_durn_type = rs.getString("repeat_durn_type");
		interval_durn_type = rs.getString("interval_durn_type");
		start_time_round = rs.getString("start_time_round");
		start_time_assign = rs.getString("start_time_assign");
		if(i % 2 == 0){
			slClassValue = "QRYEVEN";
		}
		else
		{
			slClassValue = "QRYODD";
		}

%>
	<tr>
		<td class='<%=slClassValue%>'>
		<A href='../../eAM/jsp/FrequencyAddModify.jsp?mode=modify&freq_code=<%=freq_code%>&freq_desc=<%=freq_desc%>&freq_nature=<%=freq_nature%>&eff_status=<%=eff_status%>&start_time_assign=<%=start_time_assign%>&start_time_round=<%=start_time_round%>&interval_durn_type=<%=interval_durn_type%>&repeat_durn_type=<%=repeat_durn_type%>&interval_value=<%=interval_value%>&repeat_value=<%=repeat_value%>&scheduled_yn=<%=scheduled_yn%>&freq_desc_loc_lang=<%=freq_desc_loc_lang%>'><%=freq_code%></A> 
		</td> 
		<td class='<%= slClassValue %>'><%=freq_desc%></td>
		<td class='<%= slClassValue %>'>&nbsp;<%=freq_desc1%></td>
		<td class='<%= slClassValue %>'>&nbsp;<%=freq_desc2%></td>
		<td align=left class='<%=slClassValue%>'><%=freq_nature%></td>
			<td align=center class='<%= slClassValue %>'>
			<%if(scheduled_yn.equalsIgnoreCase("Y")){%><img src='../../eCommon/images/enabled.gif'></img><%}else{%><img src='../../eCommon/images/disabled.gif'></img><%}%>
			<td align=center class='<%= slClassValue %>'>
			<%if(eff_status.equalsIgnoreCase("E")){%><img src='../../eCommon/images/enabled.gif'></img><%}else{%><img src='../../eCommon/images/disabled.gif'></img><%}%>
		</td>

	</tr>
<%
	//	ilRow ++;
		i++;
		maxRecord++;
	}//end of while

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>



<%}

	
	if(rs!=null) rs.close();
	if(rset!=null) rset.close();
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
}
catch(Exception e )
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	
	ConnectionManager.returnConnection(conn,request);
	ConnectionManager.returnConnection(conn,request);
}	
%>
</body>
</html>

