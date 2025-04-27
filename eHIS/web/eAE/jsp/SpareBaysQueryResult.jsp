<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%  

request.setCharacterEncoding("UTF-8"); 
String sStyle	= 
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");
	String whereClause		= request.getParameter("whereclause");
	StringBuffer sql=new StringBuffer();
	String from 			= request.getParameter("from") ;
	String to 				= request.getParameter("to") ;
	String facility_id		= (String)session.getValue("facility_id");
	if ( (whereClause == null || whereClause.equals("")) )
	{ 
		 String cd				  	= request.getParameter("clinic_code");
		 String clinic_desc		= request.getParameter("clinic_desc");
		 String bay_no				= request.getParameter("bay_no");
        String bay_type			= request.getParameter("BAY_TYPE_DESC");
		String pseudo_bay		= request.getParameter("SPARE_BAY_YN");
		 String enabled			= request.getParameter("eff_status");

		
		 int andCheck 				= 0;
		 // Changing to Upper case and checking
		 cd							= cd.toUpperCase();
		 bay_no						= bay_no.toUpperCase();
		

        if( !(facility_id == null || facility_id.equals("")) )
	 {
	  sql.append(" where facility_id='"+facility_id+"'   ");
	  andCheck	=	1;
	 }

	 if ( !(cd== null || cd.equals("")) )
		 {
			  if(andCheck == 1)
			 {
				  sql.append(" and CLINIC_CODE like '"+cd+"%' ");
             }
			 else
			 {
				 sql.append("where CLINIC_CODE like '"+cd+"%' ");
				 andCheck = 1;
			 }
		 }
		 if ( !(clinic_desc == null || clinic_desc.equals("")) )
		 {
		    if ( andCheck == 1 )
			{
				  sql.append(" and ");
				  sql.append(" upper(CLINIC_DESC) like upper('"+clinic_desc+"%')");
			}
			else
			{
				 sql.append(" where upper(CLINIC_DESC) like upper('"+clinic_desc+"%')");
				 andCheck 	= 1;
			}
		 }
		 if ( !(bay_no == null || bay_no.equals("")) )
	 	{
	 	    if ( andCheck == 1 )
	 	    {
	 	          sql.append(" and ");
	 	     	  sql.append(" BAY_NO like'"+bay_no+"%'");
	 	    }
	 	    else
	 	    {
				sql.append(" where BAY_NO like '"+bay_no+"%'");
				andCheck = 1;
	 	    }
	 }

	 if ( !(bay_type == null || bay_type.equals("")) )
	 	{
	 	    if ( andCheck == 1 )
	 	    {
	 	          sql.append(" and ");
	 	     	  sql.append(" BAY_TYPE_DESC like'"+bay_type+"%'");
	 	    }
	 	    else
	 	    {
				sql.append(" where BAY_TYPE_DESC like '"+bay_type+"%'");
				andCheck = 1;
	 	    }
	 }

			if ( !(pseudo_bay == null || pseudo_bay.equals("")) )
	     {
   	        if ( pseudo_bay.equals("Y") )
            {
				if ( andCheck == 0 ) 
				 {
					sql.append(" where SPARE_BAY_YN='Y'");
					andCheck = 1;
				}
				else
					 sql.append(" and SPARE_BAY_YN='Y'");
			}
   			if ( pseudo_bay.equals("N") )
			{
			  if ( andCheck == 0 ) 
			   {
					sql.append(" where  SPARE_BAY_YN='N'");
					andCheck = 1; 
				}
	          else
				  sql.append(" and SPARE_BAY_YN='N'");
	       }
   			if ( pseudo_bay.equals("B") )
   			{
   	   		} 			
	    }



	
	
	if ( !(enabled == null || enabled.equals("")) )
	{
   		if ( enabled.equals("E") )
		{
			if ( andCheck == 0 ) 
			{
				sql.append(" where EFF_STATUS='E'");
				andCheck = 1;
			}
			else
				sql.append(" and EFF_STATUS='E'");
		}
   		if ( enabled.equals("D") )
		{
			if ( andCheck == 0 ) 
			{
				sql.append(" where  EFF_STATUS='D'");
				andCheck = 1; 
			}
			else
				sql.append(" and EFF_STATUS='D'");
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
				strsql2.append("select * from AE_SPARE_BAYS_VW ");
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
  
 while (i<=end && rs.next()){
	if(cnt==0){
%>
<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../../eAE/jsp/SpareBaysQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eAE/jsp/SpareBaysQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

	%>
	</td>
	</tr>
	</table>
	</p>
	<br><br>
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th width='5%'><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
	<th width='25%'><fmt:message key="Common.LocationDescription.label" bundle="${common_labels}"/></th>
	<th width='10%'><fmt:message key="eAE.BedBayNo.label" bundle="${ae_labels}"/></th>
   <th width='10%'><fmt:message key="eAE.BedBayType.label" bundle="${ae_labels}"/></th>
	<th width='10%'><fmt:message key="eAE.PseudoBedBay.label" bundle="${ae_labels}"/></th>
	<th width='5%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%}
 
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;
	out.println("<tr><td class='" + classValue + "'>");
	String clinic_code = rs.getString("CLINIC_CODE");
	String bay_no = rs.getString("BAY_NO");
	String bay_typ = rs.getString("BAY_TYPE_DESC");
	String pseudo_bayyn = rs.getString("SPARE_BAY_YN");


	out.println("<a href='../../eAE/jsp/addModifySpareBays.jsp?clinic_code="+URLEncoder.encode(clinic_code)+"&bay_no="+URLEncoder.encode(bay_no)+"' target='f_query_add_mod' >");

	out.println(clinic_code+"</a></td><td class='" + classValue + "'>");
	String clinic_desc = rs.getString("CLINIC_DESC");
	if(clinic_desc == null) clinic_desc = "";
	out.println(clinic_desc+"</td><td class='" + classValue + "'>");
	out.println(bay_no+"</td><td class='" + classValue + "'>");
    out.println(bay_typ+"</td><td class='" + classValue + "'>");
	out.println(pseudo_bayyn+"</td><td align='center' class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/disabled.gif'></img>");
	i++;
	cnt++;
 }//endwhile
 if(cnt==0)
	 out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
 if(!rs.next()&&cnt!=0){
	endOfRes="0";%>
	<script>
		document.getElementById("nextvalue").innerHTML=" ";
	</script>
	<%}
 %>
</td></tr>
</table>
<br><center>
</center>
<%
sql.setLength(0);
//strsql1.setLength(0);
strsql2.setLength(0);

if(rs!=null)	rs.close();
if(stmt!=null)	stmt.close();

 }catch(Exception e)
     {
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

