<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML><head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	
<%
    request.setCharacterEncoding("UTF-8");
    String whereClause = request.getParameter("whereclause")==null?"":request.getParameter("whereclause");
	String facilityId = (String) session.getValue( "facility_id" ) ;
	StringBuffer  sql=new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	int andCheck = 0;
	if ( (whereClause == null || whereClause.equals("")) )
	{
	String cd    = request.getParameter("area_code")==null ?"":request.getParameter("area_code");
	String desc    = request.getParameter("area_desc")==null ?"":request.getParameter("area_desc");
	String bed_no					= request.getParameter("bed_no")==null ?"":request.getParameter("bed_no");
	String enabled    = request.getParameter("EFF_STATUS")==null ?"":request.getParameter("EFF_STATUS");

	sql.append(" where facility_id  = '"+facilityId+"' ");
	andCheck=1;	

	if ( !(cd == null || cd.equals("")) ){   
		if(andCheck == 1){	
		  sql.append("  and upper(area_code)  like  upper('"+cd+"%')");
		}else	{
		sql.append("where upper(area_code) like upper('"+cd+"%')");
		andCheck = 1;
		}
	}

		if ( !(desc == null || desc.equals("")) )
			{
				if ( andCheck == 1 )
				{	
					sql.append("  and upper(area_desc)  like  upper('"+desc+"%')");
				}
				else
				{
					sql.setLength(0);
		            sql.append("where upper(area_desc)  like upper('"+desc+"%') ");
					andCheck = 1;
				}
			}

        if ( !(bed_no == null || bed_no.equals("")) )
			{
				if ( andCheck == 1 )
				{	
					sql.append("   and upper(bed_no)  like  upper('"+bed_no+"%') ");
					
				}
				else
				{
					sql.setLength(0);
		            sql.append(" where upper(bed_no)  like upper('"+bed_no+"%') ");
					andCheck = 1;
				}
			}

		if ( !(enabled == null || enabled.equals("")) )
		{
		   if ( enabled.equals("E") )
		        {
			if ( andCheck == 0 )
			{
			sql.setLength(0);
		    sql.append(" where EFF_STATUS='E'");
			andCheck =1;
			}			
			else
					{
			sql.append(" and EFF_STATUS='E'");
					}
			}
		   if ( enabled.equals("D") )
			{
			if ( andCheck == 0)
			{
		
			sql.setLength(0);
		    sql.append(" where EFF_STATUS='D'");
			andCheck =1;
			}
			else
			sql.append(" and EFF_STATUS='D'");
		    }
		}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");
	if ( !(ord == null || ord.equals("")) )
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
	}else {
		sql.append(whereClause);

	} //end of where clause IF

	int start = 0 ;
	int end = 0 ;
	int i=1;
	int cnt=0;
	int endOfRes = 1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	end = 14 ;
    else
	end = Integer.parseInt( to ) ;
   Connection conn = ConnectionManager.getConnection(request);
   Statement stmt=null;
   ResultSet rs=null;   
   //int maxRecord = 0;
   try{
	  
   stmt = conn.createStatement();
   /*
   StringBuffer strsql1=new StringBuffer();
  
   strsql1.append("select count(*) as total from mo_bed_for_area_vw "+sql.toString());
   
   rs = stmt.executeQuery(strsql1.toString());
   if (rs.next())
	{	
	maxRecord = rs.getInt("total");
	
	}
	if(maxRecord == 0)
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
    strsql1.setLength(0);
	*/
	
	StringBuffer strsql2=new StringBuffer();
	//if(rs!=null)rs.close();
	strsql2.append("select * from mo_bed_for_area_vw " +sql.toString());
	
    rs = stmt.executeQuery(strsql2.toString());
    strsql2.setLength(0);
	 
	  if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;
	
	  while(i<=end && rs.next()) 
	  {		 
		if(cnt==0)
		{
%>

<P>
<table align='right'>
<tr >
<td>
 <% 
 if ( !(start <= 1) )
	out.println("<A HREF='../../eMO/jsp/BedForAreaQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

 if ( endOfRes == 1 )
	out.println("<A id='nextval' HREF='../../eMO/jsp/BedForAreaQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
 %>
</td>
</tr>
</table>
<br><br>
</P>

 <table border="1" width="100%" cellspacing='0' cellpadding='0'>
 <td class='columnheader'><fmt:message key="Common.AreaCode.label" bundle="${common_labels}"/></td>
 <td class='columnheader'><fmt:message key="eMP.AreaDesc.label" bundle="${mp_labels}"/></td> 
 <td class='columnheader'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
 <td class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<%
		}
 /*
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;
	  }
	  */
  String classValue = "" ;
 
  // while ( rs.next() && i<=end )
  // {
     if ( i % 2 == 0 )
	classValue = "QRYEVEN" ;
	else
	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String code = rs.getString("AREA_CODE");
    String bed_no =rs.getString("BED_NO");
	//String eff_status =rs.getString("EFF_STATUS");
	out.println("<a href='../../eMO/jsp/addModifyBedForArea.jsp?area_code="+URLEncoder.encode(code) +"&bed_no="+URLEncoder.encode(bed_no)+"' target='f_query_add_mod' >");
	out.println(code+"</a></td><td class='" + classValue + "' wrap >");
	out.println( rs.getString("area_desc") );
	out.println("</td><td class='" + classValue + "' wrap >");
    out.println( rs.getString("bed_no") );
    out.println("</td>");
	out.println("<td class='" + classValue + "' align='center' >");
	if ( rs.getString("EFF_STATUS").equals("E") )
	out.print("<img src='../../eCommon/images/enabled.gif'></img>");
	else
	out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	cnt++;

  }//endwhile
  if(cnt == 0)
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");

if( !rs.next() && cnt!=0 )
{
%>
<script>
	document.getElementById("nextval").innerHTML = " ";
</script>
<%
}		
}catch(Exception e){
		e.toString();
		e.printStackTrace();
}
	finally   {
	if(rs!=null)	rs.close();
	if(stmt!=null)	stmt.close();
	ConnectionManager.returnConnection(conn,request);
	}
%>

</td></tr>
</table>
<br><center>
</center>
</BODY>
</HTML>

