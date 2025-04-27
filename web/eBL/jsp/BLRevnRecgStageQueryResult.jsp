<!DOCTYPE html>
<%
/*
Sr No        Version               Incident              SCF/CRF             	Developer Name
1            V200922               74105             NMC-JD-CRF-0011        	 Shikha Seth
2			 V210518			   17598			  Common-ICN-0034			 Mohana Priya K
*/
%>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
	<head>
	<%!
     private String checkForNull(String inputString) {
 		if(inputString == null || "null".equals(inputString)){
 			inputString = "";
 		}
 		return inputString;
 	}
	%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
try{	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String sql = " ";    
    
    String order_category = request.getParameter("order_cat")==null?"":request.getParameter( "order_cat" ).trim().toUpperCase();
    String long_desc =request.getParameter("long_desc")==null?"":request.getParameter( "long_desc" ).trim().toUpperCase();
    String short_desc =request.getParameter("short_desc")==null?"":request.getParameter( "short_desc" ).trim().toUpperCase();
	String order_type_code =request.getParameter("order_type")==null?"":request.getParameter( "order_type" ).trim().toUpperCase();
	String rev_satge =request.getParameter("Revenue_Stage")==null?"":request.getParameter( "Revenue_Stage" ).trim().toUpperCase();

	String eff_from =request.getParameter("p_fm_date")==null?"":request.getParameter( "p_fm_date" ).trim().toUpperCase();
	String eff_to ="";	
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;        

        if ( !(order_category == null || order_category.equals("")) ){
	        sql = sql + "and upper(hdr.order_category) like upper('"+order_category +"%')";
			cnt++;
        }       
       /* if ( !(short_desc == null || short_desc.equals("")) ){
	        sql = sql + "and upper(hdr.short_desc) like upper('"+short_desc +"%')";
			cnt=2;
        }
       if ( !(long_desc == null || long_desc.equals("")) ){
	        sql = sql + "and upper(hdr.long_desc) like upper('"+long_desc +"%')";
			cnt=2;
        }*/
        if ( !(order_type_code == null || order_type_code.equals("") || order_type_code.equals("--SELECT--")) ){
			sql=sql+" and upper(hdr.order_type_code) like '"+order_type_code+"%'";
			cnt=2;
         }
		if ( !(rev_satge == null || rev_satge.equals("")) || rev_satge.equals("--SELECT--")){
			sql=sql+" and upper(hdr.rev_satge) like '"+rev_satge+"%'";
			cnt=2;
         }
		if ( !(eff_from == null || eff_from.equals("")) ){
			//sql=sql+" and hdr.eff_from >=  to_date('"+eff_from+"','DD/MM/YYYY') ";		
			sql=sql+" and ((trunc(to_date('"+eff_from+"','DD/MM/YYYY')) between trunc(hdr.eff_from) and trunc(nvl(hdr.eff_to,sysdate)))or(trunc(hdr.eff_from) > trunc(to_date('"+eff_from+"','DD/MM/YYYY'))))";			
			cnt=2;
         }	 
	}   

	String from=null;
	String to=null;
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

	Connection conn  =  ConnectionManager.getConnection(request);
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	PreparedStatement stmt2 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rs = null;
	ResultSet rs2 = null;

	try{		
		String strsql="SELECT count(*) as total FROM bl_order_revenue_stage hdr where operating_facility_id='"+facility_id+"' "+sql ;
		
		String strsql1="SELECT order_category, long_desc,short_desc, order_type_code,rev_satge, to_char(eff_from,'dd/mm/yyyy') eff_from, to_char(eff_to,'dd/mm/yyyy') eff_to,eff_from eff_from1 FROM "+"bl_order_revenue_stage hdr where operating_facility_id='"+facility_id+"' "+sql +" order by 1,4,eff_from1";
		
		stmt = conn.prepareStatement(strsql);
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		System.err.println("exception occurred "+e);
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
	<tr>
		<td>
		<%
		if ( !(start <= 1) )
			out.println("<A HREF='../../eBL/jsp/BLRevnRecgStageQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eBL/jsp/BLRevnRecgStageQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eDSN.resources.Labels" var="dl_labels"/>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
	<th class="columnheadercenter" nowrap> 
		Order Category
	</th>
	<th class="columnheadercenter" nowrap> 
		Long Desc
	</th>
	<th class="columnheadercenter" nowrap> 
		Short Desc
	</th>
	<th class="columnheadercenter" nowrap> 
		Order Type Code
	</th>
	<th class="columnheadercenter" nowrap> 
		Revenue Stage
	</th>
	<th class="columnheadercenter" nowrap> 
		Eff From
	</th>
	<th class="columnheadercenter" nowrap> 
		Eff to
	</th>

<%
	int mOrder = 0;
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
    
		order_category=checkForNull(rset.getString("order_category"));
		long_desc=checkForNull(rset.getString("long_desc"));
		short_desc=checkForNull(rset.getString("short_desc"));
		order_type_code=checkForNull(rset.getString("order_type_code"));
		rev_satge=checkForNull(rset.getString("rev_satge"));   
		eff_from=checkForNull(rset.getString("eff_from"));   
		eff_to=checkForNull(rset.getString("eff_to"));   
		String order_type_code_desc = "";
		try {
			String strsql2="SELECT long_desc FROM or_order_type where order_type_code='"+order_type_code+"'" ;
			stmt2=conn.prepareStatement(strsql2);
			rs2 = stmt2.executeQuery();
			while (rs2.next())
			{
				order_type_code_desc = checkForNull(rs2.getString(1));
			}
		}catch(Exception e) {
			e.printStackTrace();
			order_type_code_desc = order_type_code;
		}
		
		//V200922 Start
		if (order_type_code_desc == null || order_type_code_desc.equals("")) {
			order_type_code_desc = "**";
		}
		//V200922 End
		
		String rev_satge_desc = "";
		if (rev_satge.equals("BLD")) rev_satge_desc = "Billed";
		if (rev_satge.equals("REG")) rev_satge_desc = "Registered";
		if (rev_satge.equals("CMP")) rev_satge_desc = "Completed";		
				
		String mode="modify";
		out.println("<tr>");	
		out.println("<td class='" + classValue+"' nowrap>"+order_category+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+long_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+short_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+order_type_code_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+rev_satge_desc+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+eff_from+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+eff_to+"</td>");

		i++;
} %>
	</tr>
</table>
<br><center>
<%
		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(stmt2!=null)	stmt2.close(); //V200518
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception e)
	{
		out.println("here "+e);
		e.printStackTrace();
	}
%>
</center>
</form>
</BODY>
</HTML>

