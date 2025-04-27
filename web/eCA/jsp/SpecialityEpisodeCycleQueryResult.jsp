<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
 int pageCnt = Integer.parseInt(MstQryPageCnt);
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%   
   request.setCharacterEncoding("UTF-8");
	String whereClause		= request.getParameter("whereclause");
	String module_id		= request.getParameter("module_id");
	String speps_desc		= request.getParameter("speps_desc");
	String sptltevnt_desc		= request.getParameter("sptltevnt_desc");
	StringBuffer sql		=new StringBuffer();
	String from 			= request.getParameter("from") ; 
	String to 				= request.getParameter("to") ;
	String episode_modname=null;
	String episode_desc=null;
	String episodeevnt_desc=null;
	String episode_mod_id=null;
	if ( (whereClause == null || whereClause.equals("")) ){
		 // Changing to Upper case and checking





	if ( !(module_id == null || module_id.equals("")) )
	 {
		if(module_id.equals("A")){
			//sql.append("  AND upper(A.MODULE_ID) LIKE Upper('%') ");
		}else{
		sql.append("  AND upper(A.MODULE_ID) LIKE Upper('"+module_id+"%') ");
		}

	 }

	 	if ( !(speps_desc == null || speps_desc.equals("")) )
	 {

			sql.append(" and upper(SPLTY_EPISODE_DESC) LIKE Upper('"+speps_desc+"%') ");


	 }

	 	if ( !(sptltevnt_desc == null || sptltevnt_desc.equals("")) )
	 {

			sql.append(" and upper(SPLTY_TITLE_EVENT_DESC) LIKE Upper('"+sptltevnt_desc+"%') ");

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
	  	end = pageCnt ;
	else
		end = Integer.parseInt( to ) ;

		Connection con = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;

	try
	{
      con =  ConnectionManager.getConnection(request);
	  StringBuffer strsql2=new StringBuffer();
	  strsql2.append("SELECT B.MODULE_NAME,SPLTY_EPISODE_DESC,SPLTY_TITLE_EVENT_DESC,A.MODULE_ID FROM CA_SPLTY_EPISODE_CYCLE A ,SM_MODULE B  WHERE A.MODULE_ID=B.MODULE_ID ");
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
	out.println("<A HREF='../../eCA/jsp/SpecialityTasksQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eCA/jsp/SpecialityTasksQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table  width="100%" class='grid'>
	<TH class='COLUMNHEADERCENTER'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></TH>
	<TH class='COLUMNHEADERCENTER'><fmt:message key="eCA.EpisodeDescription.label" bundle="${ca_labels}"/></TH>
	<TH class='COLUMNHEADERCENTER'><fmt:message key="eCA.EventTitleDescription.label" bundle="${ca_labels}"/></TH>

<%}
	 if ( i % 2 == 0 )
		  	classValue = "gridData" ;
	 else
		  	classValue = "gridData" ;

	episode_modname=(rs.getString(1)==null)?"":rs.getString(1); 
  	episode_desc=(rs.getString(2)==null)?"":rs.getString(2); 
  	episodeevnt_desc=(rs.getString(3)==null)?"":rs.getString(3); 
  	episode_mod_id=(rs.getString(4)==null)?"":rs.getString(4); 

	out.println("<tr><td class='" + classValue + "'>"+episode_modname+"</td>");
	out.println("<td class='" + classValue + "'>");	
	out.println("<A href='../../eCA/jsp/SpecialityEpisodeCycleAddModify.jsp?mode=MODIFY&episode_mod_id="+episode_mod_id+"' class='gridLink'>"+episode_desc+"</A></td>");

	out.println("<td class='" + classValue + "'>"+episodeevnt_desc+"</td>");
	out.println("</tr>");

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
		e.printStackTrace() ;
     }
	finally   
	{
		 
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

