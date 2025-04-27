<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------
19/08/2014	  IN050582 		Nijitha S										MO-GN-5452
02/06/2020	  IN073070		SIVABAGYAM M		02/06/2020		RAMESH G		SS-SCF-0789
15/03/2021		15911		Durga Natarajan		15/03/2021		RAMESH G		ALPHA-CA-Text Block Label Name 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCA/js/TextBlock.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<HTML>
	<head>
	
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- Added by Arvind @ 08-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	

</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<br>
<%
Connection conn  = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt  = null;
ResultSet rset = null;
ResultSet rs = null;

try{
	conn  =  ConnectionManager.getConnection(request);
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql =new StringBuffer();
    int andCheck = 0;
	String procedure_yn="";
	String eff_status = "";//IN050582

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

    
    String text_blk_id  = request.getParameter("text_blk_id");
    	if(text_blk_id == null) text_blk_id ="";

    	
    String service_code = request.getParameter("service_code");
    	if(service_code == null) service_code ="";
    	
    String service_desc = request.getParameter("service_desc");
    	if(service_desc == null) service_desc ="";    	
    
    text_blk_id   = text_blk_id.toUpperCase();
    service_code  = service_code.toUpperCase();
    //service_desc = service_desc.toUpperCase(); //IN073070
	
	        
    if ( (whereClause == null || whereClause.equals("")) )
    {
	if ( !(text_blk_id == null || text_blk_id.equals("")) )
	{
		//sql = sql + " where text_blk_id like '"+text_blk_id+"%'";
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" where text_blk_id like ?");
		text_blk_id = text_blk_id+"%";
		andCheck = 1;
	}
	
	if ( !(service_code == null || service_code.equals("")) )
	{
		if ( andCheck == 1 )
		{
			sql.append(" and ");
			sql.append("service_code like  ? ");
			service_code = service_code+"%";
		}
		else
		{
			sql.append(" where service_code like ? ");
			service_code = service_code+"%";
			andCheck = 1;
		}
	}
	if ( !(service_desc == null || service_desc.equals("")) )
	{
		if ( andCheck == 1 )
		{
			sql.append(" and ");
			sql.append("service_desc like  ?");
			service_desc = service_desc+"%";
		}
		else
		{
			sql.append(" where service_desc like ?" );
			service_desc = service_desc+"%";
			andCheck = 1;
		}
 	}

    

    //appending order by clause
    String ord[] = request.getParameterValues("orderbycolumns");

    if ( !(ord == null || ord .equals("")) )
    {
        sql.append(" Order by ");
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
            sql.append(whereClause);
            
           
    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;



	int maxRecord = 0;



StringBuffer strsql=new StringBuffer();
strsql.append("select count(*) as total from ca_text_blk_by_serv_pract_vw ");
strsql.append(sql.toString());

StringBuffer strsql1=new StringBuffer();
strsql1.append("select * from  ca_text_blk_by_serv_pract_vw  ");
strsql1.append(sql.toString());
//out.println("SQL>> : "+sql); 
//out.println("<br>"+strsql);
//out.println("*"+service_desc+"*");
pstmt	      = conn.prepareStatement(strsql.toString());

int colIndex = 0;
String sqlstr	=sql.toString();	
sqlstr=sqlstr.toLowerCase();
whereClause	=	sqlstr;
sqlstr = sqlstr.substring(0,sqlstr.indexOf("order by"));
if(sqlstr.indexOf("text_blk_id")!=-1)
	pstmt.setString(++colIndex,text_blk_id) ;
if(sqlstr.indexOf("service_code")!=-1)
	pstmt.setString(++colIndex,service_code);
if(sqlstr.indexOf("service_desc")!=-1)
	pstmt.setString(++colIndex,service_desc);   

rs  = pstmt.executeQuery();

rs.next();

maxRecord = rs.getInt("total");              

if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
}

colIndex = 0;

pstmt1	      = conn.prepareStatement(strsql1.toString());
if(sqlstr.indexOf("text_blk_id")!=-1)
	pstmt1.setString(++colIndex,text_blk_id) ;
if(sqlstr.indexOf("service_code")!=-1)
	pstmt1.setString(++colIndex,service_code);
if(sqlstr.indexOf("service_desc")!=-1)
	pstmt1.setString(++colIndex,service_desc);   


rset = pstmt1.executeQuery();

%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td> 
<td  align='right' width='12%'>
<%
	//out.println("SQL APP : "+sql);
if ( !(start <= 1) ){
	//IN073070 Start.
   // out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultTextBlock.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(whereClause) + "'" + " text-decoration='none'>Prev</A>");
	out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultTextBlock.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&text_blk_id="+URLEncoder.encode(text_blk_id)+"&service_code="+URLEncoder.encode(service_code)+"&service_desc="+URLEncoder.encode(service_desc)+"&whereclause=" + URLEncoder.encode(whereClause) + "'" + " text-decoration='none'>Prev</A>");
	//IN073070 End.
	}
if ( !( (start+pageCnt) > maxRecord ) ){
	//IN073070 Start.
   // out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/QueryResultTextBlock.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>Next</A>");
	out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/QueryResultTextBlock.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&text_blk_id="+URLEncoder.encode(text_blk_id)+"&service_code="+URLEncoder.encode(service_code)+"&service_desc="+URLEncoder.encode(service_desc)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>Next</A>");
	// IN073070 End.
	}	
%>
</td>
</tr>
</table>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<td class='COLUMNHEADERCENTER' width="25%"><fmt:message key="eCA.TextBlockID.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER' width="25%"><fmt:message key="Common.ServiceCode.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width="25%"><fmt:message key="eCA.ServiceName.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER' width="25%"><fmt:message key="eCA.ProcedureApplicable.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER' width="25%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td><!--IN050582--><!-- 15911 Bundle changed from ca to common -->


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
    
    		out.println("<tr><td class='" + classValue + "'>");
	
    		text_blk_id 	= rset.getString("text_blk_id");
    			if(text_blk_id == null) text_blk_id ="";
    		service_code	= rset.getString("service_code");
    			if(service_code == null) service_code ="&nbsp;";
    		service_desc	= rset.getString("service_desc");
    			if(service_desc == null) service_desc ="&nbsp;";
			procedure_yn	= rset.getString("APPLICABLE_CATEGORY");
    			if(procedure_yn == null) procedure_yn ="&nbsp;";
			eff_status      = rset.getString("EFF_STATUS");//IN050582
		out.println("<a class='gridLink'  href='../../eCA/jsp/AddModifyTextBlock.jsp?text_blk_id="+ text_blk_id+"&eff_status="+eff_status+"' target='f_query_add_mod' >");//IN050582
    		out.println(text_blk_id+"</a></td><td class='" + classValue + "'>");
    //		out.println("<a href='../../eCA/jsp/AddModifyTextBlock.jsp?text_blk_id="+ text_blk_id +"' target='f_query_add_mod' >");    		
    		out.println(service_code+"</td><td class='" + classValue + "'>");
   // 		out.println("<a href='../../eCA/jsp/AddModifyTextBlock.jsp?text_blk_id="+ text_blk_id +"' target='f_query_add_mod' >");
		out.println(service_desc+"</td><td class='" + classValue + "'>");
		 if ( procedure_yn.equalsIgnoreCase("P") )
	        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
		else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		//out.println(procedure_yn+"</td><td class='" + classValue + "'>");
		//IN050582 Starts
		if ( eff_status.equalsIgnoreCase("E") )
	        out.println("<td class='" + classValue + "'><img src='../../eCommon/images/enabled.gif'></img></TD>");
		else
			out.println("<td class='" + classValue + "'><img src='../../eCommon/images/RRnwd.gif'></img></TD>");
		out.println("</td>");
		//IN050582 Ends
		i++;
	}
%>

</td></tr>
</table>
</center>

<br><center>
<%
	if(rs != null) rs.close();
	if(rset != null) rset.close();
	if(pstmt != null) pstmt.close();
	if(pstmt1 != null) pstmt1.close();
}
catch(Exception e){
	//out.println("err"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
finally
{
	if(conn!=null)ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</BODY>
</HTML>

