<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
Connection conn=null;
try
{

	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql =new StringBuffer();
    String sec_hdg_code  = request.getParameter("sec_hdg_code");
    String sec_hdg_desc1  = request.getParameter("sec_hdg_desc");
    String sec_hdg_desc  = "";
    String image_ref_desc  = "";

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(sec_hdg_code == null)
	{
		sec_hdg_code  = "";
	}
	else
	{
		sec_hdg_code = sec_hdg_code.toUpperCase();
	}
    
	String image_ref = request.getParameter("image_ref");
	if(image_ref == null)
	{
		image_ref = "";
	}
	else
	{
		image_ref = image_ref.toUpperCase();
	}

	String default_yn = request.getParameter("default_yn");
	if(default_yn == null)
	{
		default_yn = "";
	}
	else
	{
		if(!default_yn.equals("Y"))
			default_yn = "";
		else
			default_yn = "Y";
	}

    if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(sec_hdg_code == null || sec_hdg_code.equals("")) )
		{
			
			sql.append(" and A.sec_hdg_code  like upper('"+sec_hdg_code +"%')");
	
		}
		if ( !(sec_hdg_desc1 == null || sec_hdg_desc1.equals("")) )
		{
			
			sql.append(" and B.sec_hdg_desc  like '"+sec_hdg_desc1 +"%'");
	
		}
		
		if ( !(image_ref == null || image_ref.equals("")) )
		{
			
			sql.append(" and A.image_ref like '"+image_ref+"%'");
			
		}	
		if ( !(default_yn == null || default_yn.equals("")) )
		{
			sql.append(" and default_yn = '"+default_yn+"'");

		}	
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append("a."+ord[i]);
			else
				sql.append("a."+ord[i]+",");
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


PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		conn  =  ConnectionManager.getConnection(request);

		StringBuffer strsql=new StringBuffer();
		strsql.append("select count(*) as total from ca_section_image_link a , ca_section_hdg b, CA_NOTE_IMAGE_LIST C WHERE C.IMAGE_REF=A.IMAGE_REF AND B.sec_hdg_code=A.sec_hdg_code ");
		strsql.append(sql.toString());
		StringBuffer strsql1=new StringBuffer();
		strsql1.append("select a.sec_hdg_code, a.image_ref, a.default_yn, B.SEC_HDG_DESC, C.IMAGE_REF_DESC from  ca_section_image_link a, ca_section_hdg b, CA_NOTE_IMAGE_LIST C WHERE C.IMAGE_REF=A.IMAGE_REF AND B.sec_hdg_code=A.sec_hdg_code ");
		strsql1.append(sql.toString());
		//out.println(strsql1);
		stmt = conn.prepareStatement(strsql.toString());
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		stmt1=conn.prepareStatement(strsql1.toString());
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		//out.println("sdfsadfs "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultImageForSection.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultImageForSection.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<td class = 'COLUMNHEADERCENTER' width=''><fmt:message key="eCA.SectionHeading.label" bundle="${ca_labels}"/></td><!--20%-->
<td class = 'COLUMNHEADERCENTER' width=''><fmt:message key="eCA.ImageReference.label" bundle="${ca_labels}"/></td><!--30%-->
<td class = 'COLUMNHEADERCENTER' width=''><fmt:message key="Common.Default.label" bundle="${common_labels}"/></td> <!--30%-->
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
		out.println("<tr><td align=='left' class='" + classValue + "'>");
		sec_hdg_code = rset.getString(1);
		image_ref = rset.getString(2);
		default_yn = rset.getString(3);
		sec_hdg_desc= rset.getString(4);
		image_ref_desc= rset.getString(5);
		out.println("<a class='gridLink'  href='../../eCA/jsp/AddModifyImageForSection.jsp?sec_hdg_code="+ sec_hdg_code+"&sec_hdg_desc="+sec_hdg_desc+"&image_ref=" +image_ref+"&image_ref_desc=" +image_ref_desc+"' target='f_query_add_mod' >");
		out.println(sec_hdg_desc+"</a></td>");
		out.println("<td class='" + classValue + "'>");
		out.println( image_ref_desc );
		out.println("</td>");
		out.println("<td class='" + classValue + "'>");
		if ( default_yn.equals("Y") )
		    out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	    else
			out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
		out.println("</td>");

		i++;
	} %>
</td></tr>
</table>
</center>
<br><center>
<%
		if(rs != null) rs.close();
		if(rset != null) rset.close();
		if(stmt != null) stmt.close();
		if(stmt1 != null) stmt1.close();

}
catch(Exception e)
{
	//out.println("here "+e);
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}

%>
</center>
</BODY>
</HTML>

