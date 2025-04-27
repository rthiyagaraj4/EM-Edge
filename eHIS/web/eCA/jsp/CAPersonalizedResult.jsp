<!DOCTYPE html>

<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language=javascript src='../../eCA/js/CAPersonalizedHomePage.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<HTML>
	<head>
	
	<%
		request.setCharacterEncoding("UTF-8");	
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
PreparedStatement pstmt2 = null;
PreparedStatement pstmt  = null;
ResultSet rset = null;
ResultSet rset1 = null;
ResultSet rset2 = null;
ResultSet rset3 = null;
ResultSet rs = null;

try{
	String practDesc="";
	String practName="";
	String sumDesc="";
	String sqlStr="";
	conn  =  ConnectionManager.getConnection(request);
	String whereClause = request.getParameter("whereclause");	
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql =new StringBuffer();
    int andCheck = 0;
	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

    
    String pract_type  = request.getParameter("pract_type");
    	if(pract_type == null) pract_type ="";

    	
    String qry_sub = request.getParameter("practitioner_id");
    	if(qry_sub == null) qry_sub ="";

		
    	
    String desk_sub = request.getParameter("DESKTOP_SUMMARY_ID");
    	if(desk_sub == null) desk_sub ="";    	
    
    pract_type   = pract_type.toUpperCase();
    qry_sub  = qry_sub.toUpperCase();
    desk_sub = desk_sub.toUpperCase();
	
	        
    if ( (whereClause == null || whereClause.equals("")) )
    {
	if ( !(pract_type == null || pract_type.equals("")) )
	{
		//sql = sql + " where text_blk_id like '"+text_blk_id+"%'";
		if(sql.length() > 0) sql.delete(0,sql.length());
		sql.append(" where pract_type like ?");
		pract_type = pract_type+"%";
		andCheck = 1;
	}
	
	if ( !(qry_sub == null || qry_sub.equals("")) )
	{
		if ( andCheck == 1 )
		{
			sql.append(" and ");
			sql.append("PRACTITIONER_ID like  ? ");
			qry_sub = qry_sub+"%";
		}
		else
		{
			sql.append(" where PRACTITIONER_ID like ? ");
			qry_sub = qry_sub+"%";
			andCheck = 1;
		}
	}
	if ( !(desk_sub == null || desk_sub.equals("")) )
	{
		if ( andCheck == 1 )
		{
			sql.append(" and ");
			sql.append("DESKTOP_SUMMARY_ID like  ?");
			desk_sub = desk_sub+"%";
		}
		else
		{
			sql.append(" where DESKTOP_SUMMARY_ID like ?" );
			desk_sub = desk_sub+"%";
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
strsql.append("select count(*) as total from SM_PERSONALIZED_HOME_PAGE ");
strsql.append(sql.toString());

//out.println("strsql ="+strsql.toString()+"=");
//out.println("qry_sub ="+qry_sub+"=");
//out.println("desk_sub ="+desk_sub+"=");

StringBuffer strsql1=new StringBuffer();
strsql1.append("select * from  SM_PERSONALIZED_HOME_PAGE  ");
//strsql1.append("SELECT a.PRACT_TYPE,NVL (d.DESC_USERDEF,d.DESC_SYSDEF)PRACT_TYPE_DESC,a.PRACTITIONER_ID,c.PRACTITIONER_NAME,a.DESKTOP_SUMMARY_ID, b.DESKTOP_SUMMARY_NAME  FROM SM_PERSONALIZED_HOME_PAGE a,SM_DESKTOP_SUM_HDR b,AM_PRACTITIONER c,AM_PRACT_TYPE d WHERE a.DESKTOP_SUMMARY_ID=b.DESKTOP_SUMMARY_ID AND a.PRACTITIONER_ID=c.PRACTITIONER_ID AND a.PRACT_TYPE=d.PRACT_TYPE");
strsql1.append(sql.toString());
pstmt	      = conn.prepareStatement(strsql.toString());

int colIndex = 0;
String sqlstr	=sql.toString();	
sqlstr=sqlstr.toLowerCase();
whereClause	=	sqlstr;
sqlstr = sqlstr.substring(0,sqlstr.indexOf("order by"));

if(sqlstr.indexOf("pract_type")!=-1)
	pstmt.setString(++colIndex,pract_type) ;
if(sqlstr.indexOf("practitioner_id")!=-1)
	pstmt.setString(++colIndex,qry_sub);
if(sqlstr.indexOf("desktop_summary_id")!=-1)
	pstmt.setString(++colIndex,desk_sub);

rs  = pstmt.executeQuery();

rs.next();

maxRecord = rs.getInt("total");              

if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
}

colIndex = 0;

pstmt1	      = conn.prepareStatement(strsql1.toString());

if(sqlstr.indexOf("pract_type")!=-1)
	pstmt1.setString(++colIndex,pract_type) ;
if(sqlstr.indexOf("practitioner_id")!=-1)
	pstmt1.setString(++colIndex,qry_sub);
if(sqlstr.indexOf("desktop_summary_id")!=-1)
	pstmt1.setString(++colIndex,desk_sub);   


rset = pstmt1.executeQuery();

%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td> 
<td  align='right' width='12%'>
<%
	
if ( !(start <= 1) )
    out.println("<A class='gridLink'  href='../../eCA/jsp/CAPersonalizedResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(whereClause) + "'" + " text-decoration='none'>Prev</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/CAPersonalizedResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(whereClause)+"'"+" text-decoration='none'>Next</A>");
%>
</td>
</tr>
</table>

<table class='grid' border='1' width="100%"  align='center'>
<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER'><fmt:message key="eCA.Desktop.label" bundle="${ca_labels}"/></td>



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
	
    		pract_type 	= rset.getString("PRACT_TYPE");
    			if(pract_type == null) pract_type ="";
    		qry_sub	= rset.getString("PRACTITIONER_ID");
			
    			if(qry_sub == null) qry_sub ="&nbsp;";
    		desk_sub	= rset.getString("DESKTOP_SUMMARY_ID");
    			if(desk_sub == null) desk_sub ="&nbsp;";

			sqlStr="SELECT PRACT_TYPE,NVL (DESC_USERDEF,DESC_SYSDEF) PRACT_TYPE_DESC FROM AM_PRACT_TYPE WHERE PRACT_TYPE=?";
			pstmt2 = conn.prepareStatement(sqlStr);
			pstmt2.setString(1,pract_type);
			rset1 = pstmt2.executeQuery();
			if(rset1.next())
				practDesc=rset1.getString("PRACT_TYPE_DESC");
			if(practDesc == null) practDesc ="";
			
			if(pstmt2!=null)pstmt2.close();
			if(rset1!=null)rset1.close();
			if(qry_sub.equals("*ALL")){
				practName="ALL";			
			}
			else
			{
				sqlStr="SELECT PRACTITIONER_ID,PRACTITIONER_NAME FROM AM_PRACTITIONER WHERE PRACTITIONER_ID=?";
				pstmt2 = conn.prepareStatement(sqlStr);
				pstmt2.setString(1,qry_sub);
				rset2 = pstmt2.executeQuery();
				if(rset2.next())
					practName=rset2.getString("PRACTITIONER_NAME");
			}
				if(practName == null) practName ="&nbsp;";
				if(pstmt2!= null) pstmt2.close();
			
				sqlStr="SELECT DESKTOP_SUMMARY_ID, DESKTOP_SUMMARY_NAME FROM SM_DESKTOP_SUM_HDR WHERE DESKTOP_SUMMARY_ID=?";
				pstmt2 = conn.prepareStatement(sqlStr);
				pstmt2.setString(1,desk_sub);
				rset3 = pstmt2.executeQuery();
				if(rset3.next())
					sumDesc=rset3.getString("DESKTOP_SUMMARY_NAME");
				if(sumDesc == null) sumDesc ="&nbsp;";
				if(pstmt2!= null) pstmt2.close();
			    if(rset3!= null) rset3.close();	
				
		out.println("<a class='gridLink'  href='../../eCA/jsp/CAPersonalizedPractLookup.jsp?pract_type="+ pract_type+"&pract_id="+qry_sub+"' target='frame3' >");
    		out.println(practDesc+"</a></td><td class='" + classValue + "'>");
    		out.println(practName+"</td><td class='" + classValue + "'>");
		out.println(sumDesc+"</td>");
		i++;
	}
	
	
%>
</table>
</center>

<br><center>
<%
	if(rs!= null) rs.close();
	if(rset!= null) rset.close();	
	if(rset2!= null) rset2.close();	
	if(pstmt!= null) pstmt.close();
	if(pstmt1!= null) pstmt1.close();
}
catch(Exception e)
{
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

