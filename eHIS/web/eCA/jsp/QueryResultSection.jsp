<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../js/Section.js'></script>

<HTML>
	<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- <modifeid by Arvind @06-12-2008> -->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />	

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	Connection conn=null;
	try
	{
		String license_rights = "";

		if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
		{
			license_rights= "FULL";
		}
		else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
		{
			license_rights= "BASIC";
		}
		else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
		{
			license_rights= "MINI";
		}
	String whereClause = request.getParameter("whereclause");
	
	if(whereClause==null) whereClause="";
    
	String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String rec_short_desc = "";
    
	StringBuffer sql=new StringBuffer();
	
	String sec_hdg_code  = request.getParameter("sec_hdg_code");
	String image_linked_yn = (request.getParameter("image_linked_yn")==null?"":request.getParameter("image_linked_yn"));

	if(sec_hdg_code == null)
		sec_hdg_code  = "";
	else
		sec_hdg_code = sec_hdg_code.toUpperCase();
    
	String sec_hdg_desc = request.getParameter("sec_hdg_desc");

	if(sec_hdg_desc == null)
		sec_hdg_desc = "";
	else
		sec_hdg_desc = sec_hdg_desc.toUpperCase();

	String sec_hdr_meta_desc = request.getParameter("sec_hdr_meta_desc");

	if(sec_hdr_meta_desc == null)
		sec_hdr_meta_desc = "";
	else
		sec_hdr_meta_desc = sec_hdr_meta_desc.toUpperCase();

    String content_type				= request.getParameter("content_type")==null?"":request.getParameter( "content_type" );
    String template_type			= request.getParameter("template_type")==null?"":request.getParameter( "template_type" );
    String result_linked_rec_type	= request.getParameter("result_linked_rec_type")==null?"":request.getParameter( "result_linked_rec_type");
    String enabled					= request.getParameter("eff_status")==null?"":request.getParameter( "eff_status");
	String content_type_desc		= "";
	String template_type_desc		= "";

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
		int cnt=0;

		if ( !(sec_hdg_code == null || sec_hdg_code.equals("")) )
		{
	        if(sql.length() > 0) sql.delete(0,sql.length());
			sql.append(" where upper(sec_hdg_code ) like upper('"+sec_hdg_code +"%') and modifiable_yn='Y' ");
			cnt++;
        }

        if ( !(sec_hdg_desc == null || sec_hdg_desc.equals("")) )
		{
			if(cnt>0)
				sql.append(" and upper(sec_hdg_desc) like '"+sec_hdg_desc+"%'");
			else
			{
				sql.append(" where upper(sec_hdg_desc) like '"+sec_hdg_desc+"%'");
				cnt=1;
			}

        }
	   if ( !(content_type == null || content_type.equals("")) ){
			if(cnt>0)
				sql.append(" and content_type like '"+content_type+"%'");
			else
			{
				sql.append(" where content_type like '"+content_type+"%'");
				cnt=1;
			}

        }
		if ( !(template_type == null || template_type.equals("")) ){
			if(cnt>0)
				sql.append(" and template_type like '"+template_type+"%'");
			else
			{
				sql.append(" where template_type like '"+template_type+"%'");
				cnt=1;
			}

        }
	
	if ( !(result_linked_rec_type == null || result_linked_rec_type.equals("")) )
	{
			if(cnt>0)
				sql.append( " and result_linked_rec_type like '"+result_linked_rec_type+"%'");
			else
			{
				sql.append(" where result_linked_rec_type like '"+result_linked_rec_type +"%'");
				cnt =1;
			}
        }
	
	/**/
	if ( !(sec_hdr_meta_desc == null || sec_hdr_meta_desc.equals("")) )
	{
			if(cnt>0)
				sql.append(" and sec_hdr_meta_desc like '"+sec_hdr_meta_desc+"%'");
			else
			{
				sql.append(" where sec_hdr_meta_desc like '"+sec_hdr_meta_desc+"%'");
				cnt =1;
			}
        }
	/**/	
	if ( !(image_linked_yn == null || image_linked_yn.equals("")) )
	{
		if(image_linked_yn.equals("Y"))
		{
			if(cnt>0)
					sql.append(" and image_linked_yn ='Y'");
				else
				{
					sql.append(" where image_linked_yn = 'Y'");
					cnt =1;
				}
		}
		else if(image_linked_yn.equals("N"))
		{
			if(cnt>0)
					sql.append( " and image_linked_yn is null");
				else
				{
					sql.append(" where image_linked_yn is null");
					cnt =1;
				}
		}
	}
	if ( !(enabled == null || enabled.equals("")) )
	{
         if( enabled.equals("E") )
		 {
			if(cnt>0)
			   sql.append(" and eff_status='E'");
			else
			{
				sql.append(" where  eff_status='E'");
				cnt=1;
			}
         }
		 if ( enabled.equals("D") )
		 {
            if(cnt>0)
			   sql.append(" and eff_status='D'");
			else
				sql.append("where  eff_status='D'");
         }

         if ( enabled.equals("B") )
		 {
//               sql = sql; //nothing is added to get both E and D
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

 conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		StringBuffer strsql=new StringBuffer();
		strsql.append("select count(*) as total from ca_section_hdg ");
		strsql.append(sql.toString());

		StringBuffer strsql1=new StringBuffer();
		strsql1.append("select sec_hdg_code,sec_hdg_desc, content_type,template_type, result_linked_rec_type, eff_status, sec_hdr_meta_desc, (SELECT short_desc FROM cr_hist_rec_type WHERE  hist_rec_type = result_linked_rec_type) rec_short_desc, image_linked_yn from  ca_section_hdg ");
		strsql1.append(sql.toString());
		//out.println("sql1  :"+strsql);
		//out.println("<br>sql2  :"+strsql1);

		stmt = conn.prepareStatement(strsql.toString());
		rs = stmt.executeQuery();

		rs.next();
		maxRecord = rs.getInt("total");
		
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));history.go(-1);</script>");
		}
		/*if(maxRecord==0) 
		{
			out.println("<script>alert('no records found');history.back();</script>");
			return;
		}
*/
		stmt1=conn.prepareStatement(strsql1.toString());

	//	out.println("strsql1.toString() = "+strsql1.toString());
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		//out.println("sdfsadfs "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
%>
<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td> 
<td  align='right' width='12%' nowrap>
<%
if ( !(start <= 1) )
    out.println("<A class='gridLink'  href='../../eCA/jsp/QueryResultSection.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause=" + URLEncoder.encode(sql.toString()) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/QueryResultSection.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>


<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<tr>
<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<%if(license_rights.equals("FULL") || license_rights.equals("BASIC")){
	%><td class='COLUMNHEADERCENTER' nowrap><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></td>
<%}%>
<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="eCA.TemplateType.label" bundle="${ca_labels}"/></td> 
<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="eCA.ResultCategory.label" bundle="${ca_labels}"/></td>
<td class='COLUMNHEADERCENTER' nowrap><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td> 

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

    sec_hdg_code = rset.getString(1);
    sec_hdg_desc=rset.getString(2);
    content_type= rset.getString(3);
    template_type= rset.getString(4);
	if(template_type == null) template_type="";
	sec_hdr_meta_desc = rset.getString("sec_hdr_meta_desc");
	rec_short_desc	 = 	rset.getString("rec_short_desc");	
	image_linked_yn = (rset.getString("image_linked_yn")==null?"":rset.getString("image_linked_yn"));	
	
	if(sec_hdr_meta_desc == null || sec_hdr_meta_desc.equals("null")||sec_hdr_meta_desc=="") sec_hdr_meta_desc="&nbsp;";
	if(rec_short_desc == null || rec_short_desc.equals("null") || rec_short_desc == "")rec_short_desc = "&nbsp;";

	if(content_type.equals("F")) content_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FreeFormat.label","common_labels");
	else if(content_type.equals("R")) content_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Resultlinked.label","ca_labels");
	else if(content_type.equals("S")) content_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MainSection.label","ca_labels");
	else if(content_type.equals("T")) content_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.TemplateBased.label","ca_labels");

	if(template_type.equals("H")) template_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteHeader.label","ca_labels");
	else if(template_type.equals("F")) template_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteFooter.label","ca_labels");
	else if(template_type.equals("B")) template_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteBody.label","ca_labels");
	else if(template_type.equals("R")) template_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ReportHeader.label","ca_labels");
	else
	template_type_desc="&nbsp;";
	out.println("<a class='gridLink'  href='../../eCA/jsp/AddModifySection.jsp?sec_hdg_code="+ sec_hdg_code+"' target='f_query_add_mod' onclick='loadConf(\""+content_type+"\")'>");
    out.println(sec_hdg_code+"</a></td><td class='" + classValue + "'>");
   // out.println("<a href='../../eCA/jsp/AddModifySection.jsp?sec_hdg_code="+ sec_hdg_code +"' target='f_query_add_mod' >");
   out.println( rset.getString(2) );
   out.println("</td>");
   if(license_rights.equals("FULL") || license_rights.equals("BASIC"))
   {
	   out.println("<td class='gridData'>"+sec_hdr_meta_desc+"</td>");
   }
   out.println("<td class='gridData'  >"+content_type_desc+"</td>");
   out.println("<td class='gridData'  >"+template_type_desc+"</td>");
   out.println("<td class='gridData'  >"+  rec_short_desc+"</td>");
    // out.println("<a href='../../eCA/jsp/AddModifySection.jsp?sec_hdg_code="+ sec_hdg_code +"' target='f_query_add_mod' >");
   out.println("<td class='" + classValue + "'>");
    if ( rset.getString("eff_status").equals("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	//out.println("<td class='" + classValue + "'>");
	/*if ( image_linked_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");*/

	i++;
} %>

</td></tr>
</table>
</center>

<center>
<%
if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();

}
catch(Exception e)
{
	//out.println("here "+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

finally
{
	if (conn != null)  
	ConnectionManager.returnConnection(conn,request);
}	
%>

</center>
</BODY>
</HTML>

