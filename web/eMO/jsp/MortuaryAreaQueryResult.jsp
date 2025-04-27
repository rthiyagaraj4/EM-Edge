<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>


<HTML><head>
<%
     String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 request.setCharacterEncoding("UTF-8");

%>

      <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	  <script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	  </head><BODY  class='CONTENT' onLoad='ClearMsg()'  onMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%
	String facilityId = (String) session.getValue( "facility_id" ) ;
	String           whereClause		= request.getParameter("whereclause");
	StringBuffer  sql                       = new StringBuffer() ;
	String            from 					= request.getParameter("from") ;
	String            to 						= request.getParameter("to") ;
	 int andCheck 				= 0;
	
	if ( (whereClause == null || whereClause.equals("")) )
	{
		
		String area_code			= request.getParameter("area_code")==null?"":request.getParameter("area_code");
		
		String Area_Type			= request.getParameter("Area_Type")==null?"":request.getParameter("Area_Type");
		if(Area_Type.equals("A")) Area_Type = "";
		
		String long_desc			= request.getParameter("long_desc");
		String enabled				= request.getParameter("enabled");
		
       
		area_code				= area_code.toUpperCase();
		sql.append(" where facility_id  = '"+facilityId+"' ");
		andCheck=1;	

	     if ( !(area_code== null || area_code.equals("")) )
	     {
				 if ( andCheck == 1 )
				{
				sql.append(" and  AREA_CODE like '"+area_code+"%'");
			    
			//	sql 	= sql + " and ";
				//sql		= sql + "  AREA_CODE like '"+area_code+"%'";
				}
				else
				{
					sql.setLength(0);
					sql.append(" where AREA_CODE like '"+area_code+"%'");
					//sql		= " where AREA_CODE like '"+area_code+"%'";
					andCheck =1;
				}

	    }
 
		 if ( !(Area_Type== null || Area_Type.equals("")) )
	 {
				 if ( andCheck == 1 )
				{
				sql.append(" and  AREA_TYPE like '"+Area_Type+"%'");
			 //	sql 	= sql + " and ";
				//sql		= sql + " AREA_TYPE like '"+Area_Type+"%'";
				}
				else
				{
					sql.setLength(0);
					sql.append("  where AREA_TYPE like '"+Area_Type+"%'");
			//		sql		= "  where AREA_TYPE like '"+Area_Type+"%'";
					andCheck =1;
				}
				 

	 }
	 //out.println("sql is :"+sql);		

	if ( !(long_desc == null || long_desc.equals("")) )
	 	 {
	 	    if ( andCheck == 1 )
	 	    {    sql.append(" and  upper(LONG_DESC) like upper('"+long_desc+"%')" );
	 	          //sql = sql + " and ";
	 	     	  //sql = sql + " upper(LONG_DESC) like upper('"+long_desc+"%')" ;
	 	    }
	 	    else
	 	    {
				sql.setLength(0);
				sql.append("  where upper(LONG_DESC) like upper('"+long_desc+"%')");
		
			//	sql = " where upper(LONG_DESC) like upper('"+long_desc+"%')" ;
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
		    		sql.append("  where EFF_STATUS='E'");
					andCheck = 1;
				}
				else
				sql.append(" and EFF_STATUS='E'" );	 
				
			}
   			if ( enabled.equals("D") )
			{
			  if ( andCheck == 0 ) 
			   {
					sql.setLength(0);
		    		sql.append("  where EFF_STATUS='D'");
				
					
					andCheck = 1; 
				}
	          else
			       sql.append(" and EFF_STATUS='D'" );	 
			  
	       }
   		   
		  //if ( enabled.equals("B") )
   		//	{
   	   		//} 
	   }
		 // out.println(sql);
	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sql.append("  order by ");

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

		Connection con = null;
		Statement stmt=null;
		ResultSet rs=null;
		//int maxRecord = 0;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  stmt = con.createStatement();

	  /*
	  StringBuffer strsql1=new  StringBuffer ();
	  strsql1.setLength(0);
	  strsql1.append("select count(*) as total from MO_AREA "+sql.toString());

      rs = stmt.executeQuery(strsql1.toString());

	 while(rs!=null && rs.next())
		{
		  maxRecord = rs.getInt("total");
        }
      if(rs!=null) rs.close();
	  
	  if (maxRecord== 0)
	  {
	  out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
	  }
	  */
	  StringBuffer strsql2=new StringBuffer();
	  
	  strsql2.append("select * from MO_AREA "+sql.toString());
	//  out.println("strsql2.toString()--->"+strsql2.toString());
	  rs = stmt.executeQuery(strsql2.toString());

	  if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
				rs.next() ;

	  while(i<=end && rs.next()) 
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
out.println("<A HREF='../../eMO/jsp/MortuaryAreaQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");	

  if ( endOfRes==1 )
	out.println("<A id='nextval' HREF='../../eMO/jsp/MortuaryAreaQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>

<th class='columnheader' width='7%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th class='columnheader' width='5%'><fmt:message key="eMO.Capacity.label" bundle="${mo_labels}"/></th>
<th class='columnheader' width='15%'><fmt:message key="eMO.AreaType.label" bundle="${mo_labels}"/></th>
<th class='columnheader' width='5%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
<%
		}

/*
if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  {
	    rs.next() ;
	  }
 */

 String classValue = "" ;

// while ( rs!=null && rs.next() && i<=end ) 
 //{
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	
	
	String area_code = rs.getString("area_code");
	out.println("<a href='../../eMO/jsp/addModifyMortuaryArea.jsp?area_code="+area_code+"' target='f_query_add_mod' >");
	out.println(area_code+"</a></td><td class='" + classValue + "'>");
		
	String long_desc = rs.getString("long_desc");
	out.println(long_desc+"</td><td class='" + classValue + "'>");
	
	String short_desc = rs.getString("short_desc");
	out.println(short_desc+"</td><td class='" + classValue + "'>");
	
	String Capacity = rs.getString("Capacity");
	out.println(Capacity+"</td><td align='left' class='" + classValue + "'>");
				
	if ( rs.getString("AREA_TYPE").equals("S") )
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.StorageArea.label","mo_labels")+"</td><td align='center' class='" + classValue + "'>");
		
	else if ( rs.getString("AREA_TYPE").equals("P") )
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.PostmortemArea.label","mo_labels")+"</td><td align='center' class='" + classValue + "'>");
	else if ( rs.getString("AREA_TYPE").equals("R") )
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMO.ReleaseArea.label","mo_labels")+"</td><td align='center' class='" + classValue + "'>");
	
	else if ( rs.getString("AREA_TYPE").equals("O") )
		out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels")+"</td><td align='center' class='" + classValue + "'>");



	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
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
%>
</td></tr>
</table>
<br><center>
</center>
<%

 }catch(Exception e)
     {
		e.toString();
		out.println(e.toString());
		e.printStackTrace();
     }
	finally   
	{
		 if(stmt!=null)	stmt.close();
		 if(rs!=null)	rs.close();
		 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

