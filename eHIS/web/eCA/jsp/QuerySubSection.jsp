<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<head>
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<!-- <modifeid by Arvind @06-12-2008> -->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	</style>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
    String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    StringBuffer sql =new StringBuffer();
    String section_code  = request.getParameter("mainSectionCode");
    String section_desc = request.getParameter("mainSectionDesc");
    String subsection_code = request.getParameter("subSectionCode");
    String subsection_desc = request.getParameter("subSectionDesc");
	String seq_num = request.getParameter("seq_num");
	String section_code_display = "";
	String section_desc_display = "";
	String subsection_code_display = "";
	String subsection_desc_display = "";
	String seq_num_display = "";
    String ord[] = request.getParameterValues("orderbycolumns");
	String classValue= "";
	Connection con = null;
	PreparedStatement stmt=null,stmt1=null,ps=null;
	StringBuffer strsql =new StringBuffer();
	StringBuffer strsql1 =new StringBuffer();

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	int maxRecord = 0;
	ResultSet rset=null,rs=null;
    int start = 0 ;
    int end = 0 ;
    int i=1;
	int cnt=0;
	if(section_code  == null)
	{
		section_code  = "";
	}
	else
	{
		section_code = section_code.toUpperCase();
	}
	if(section_desc  == null)
	{
		section_desc  = "";
	}
	else
	{
		section_desc = section_desc.toUpperCase();
	}	
    if ((whereClause == null || whereClause.equals("")) )
		{
			if ( !(section_code == null || section_code.equals("")) )
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" where upper(header_sec_hdg_code) like upper('"+section_code +"%')");
				cnt++;
			}
			if ( !(section_desc == null || section_desc.equals("")) )
			{
				if(cnt>0)
					sql.append(" and upper(header_sec_hdg_desc) like '"+section_desc+"%'");
				else
				{
					sql.append(" where upper(header_sec_hdg_desc) like '"+section_desc+"%'");
					cnt=1;
				}
			}
		   if ( !(subsection_code == null || subsection_code.equals("")) )
			{
				if(cnt>0)
					sql.append(" and  upper(child_sec_hdg_code) like upper('"+subsection_code+"%')");
				else
				{
					sql.append(" where  upper(child_sec_hdg_code) like upper('"+subsection_code+"%')");
					cnt=1;
				}
			}
			if ( !(subsection_desc == null || subsection_desc.equals("")) )
			{
				if(cnt>0)
					sql.append(" and upper(child_sec_hdg_desc) like upper('"+subsection_desc+"%')");
				else
				{
					sql.append(" where upper(child_sec_hdg_desc) like upper('"+subsection_desc +"%')");
					cnt=1;
				}
			}
		//appending order by clause
		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");
			for (i=0;i < ord.length;i++ )
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
    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;
    if ( to == null )
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;
try
{
	con  =  ConnectionManager.getConnection(request);
	ps = con.prepareStatement("delete from   ca_subsection_link  where child_seq_num is null");
	ps.executeUpdate();
	con.commit();
	strsql.append("select count(*) as total from ca_subsection_link_vw ");
	strsql.append(sql.toString());
	//out.println(sql);
	strsql1.append("SELECT header_sec_hdg_code,header_sec_hdg_desc||nvl2(HEADER_SEC_HDR_META_DESC,'-'||HEADER_SEC_HDR_META_DESC,NULL) header_sec_hdg_desc ,child_sec_hdg_code,  child_sec_hdg_desc||nvl2(child_SEC_HDR_META_DESC,'-'||CHILD_SEC_HDR_META_DESC,NULL) child_sec_hdg_desc, child_seq_num FROM  ca_subsection_link_vw ");
	strsql1.append(sql.toString());
	stmt = con.prepareStatement(strsql.toString());
	rs = stmt.executeQuery();
	rs.next();
	maxRecord = rs.getInt("total");
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	stmt1=con.prepareStatement(strsql1.toString());
	rset = stmt1.executeQuery();
%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center' >
<tr>
<td class='white' width='88%'></td> 
<td class='label' align='right' width='4%' nowrap>
<%
	if ( !(start <= 1) )
		out.println("<A class='gridLink'  href='../../eCA/jsp/QuerySubSection.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	if ( !( (start+pageCnt) > maxRecord ) )
		out.println("&nbsp;<A class='gridLink'  href='../../eCA/jsp/QuerySubSection.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>

<table class='grid'  width="100%" cellspacing='0' cellpadding='3' align='center'  >
<tr align='left'>
<th class='columnheadercenter' width='20%'><fmt:message key="eCA.MainSectionCode.label" bundle="${ca_labels}"/></th>
<th class='columnheadercenter' width='30%'><fmt:message key="eCA.MainSectionDesc.label" bundle="${ca_labels}"/></th>
<th class='columnheadercenter' width='20%'><fmt:message key="eCA.SubSectionCode.label" bundle="${ca_labels}"/></th>
<th class='columnheadercenter' width='30%'><fmt:message key="eCA.SubSectionDescription.label" bundle="${ca_labels}"/></th>
<th class='columnheadercenter' width='20%'><fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/></th>
</tr>
<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
      while ( rset.next() && i<=end  ) {
		if ( i % 2 == 0 )
            classValue = "QRYEVEN" ;
        else
            classValue = "QRYODD" ;
	section_code = rset.getString("header_sec_hdg_code");
	section_desc=rset.getString("header_sec_hdg_desc");
	subsection_code= rset.getString("child_sec_hdg_code");
	subsection_desc= rset.getString("child_sec_hdg_desc");
	seq_num= rset.getString("child_seq_num");
	section_code_display = section_code;
	section_desc_display = section_desc;
	subsection_code_display = subsection_code;
	subsection_desc_display = subsection_desc;
	seq_num_display = seq_num;
	section_code = java.net.URLEncoder.encode(section_code);
	section_desc = java.net.URLEncoder.encode(section_desc);
	subsection_code = java.net.URLEncoder.encode(subsection_code);
	subsection_desc = java.net.URLEncoder.encode(subsection_desc);
	seq_num = java.net.URLEncoder.encode(seq_num);
%>
<tr>
		<!--<td align=='left' class=' <%= classValue %>'><a href='../../eCA/jsp/addSubSection.jsp?slSec_hdg_code=<%=section_code %>&sec_hdg_desc=<%= section_desc%>&sub_sec_code=<%=subsection_code%>&sub_sec_desc=<%=subsection_desc%>&seq_num=<%=seq_num%>' target='f_query_add_mod' ><%= section_code_display %></a></td>-->
		<td align=='left' class='gridData'  ><%=section_code_display%></td>
		<td class='gridData'><%= section_desc_display %></td>
		<td class='gridData'><!-- <a href='../../eCA/jsp/addSubSection.jsp?slSec_hdg_code=<%= section_code %>&sec_hdg_desc=<%= section_desc%>&sub_sec_code=<%=subsection_code%>&sub_sec_desc=<%=subsection_desc%>&seq_num=<%=seq_num%>' target='f_query_add_mod' > --><%= subsection_code_display %><!-- </a> --></td>
		<td class='gridData'><%= subsection_desc_display %></td>
		<td class='gridNumericData' align='right'><%= seq_num_display%></td>
</tr>
<%
		i++;
  }
	if(rset != null) rset.close();
	if(rs != null)rs.close();
	if(ps != null)ps.close();
	if(stmt != null) stmt.close();
	if(stmt1 != null) stmt1.close();
}	
catch(Exception e)
{
	//out.println("Exception in Main Block :"+e.toString());//COMMON-ICN-0181
      e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con !=null)ConnectionManager.returnConnection(con,request);
}
%>
</table>
</center>
<br><center>
</center>
</BODY>
</HTML>

