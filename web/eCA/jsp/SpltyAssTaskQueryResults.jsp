<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<HTML><head>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head><BODY  class='CONTENT' onLoad='ClearMsg()' onMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<%   
   request.setCharacterEncoding("UTF-8");
	String whereClause		= request.getParameter("whereclause");
	String module_id		= request.getParameter("module");
	String event_id		= request.getParameter("event_id");
	String event_desc		= request.getParameter("event_desc");
	String category		= request.getParameter("category");
	String taskType		= request.getParameter("taskType");
	StringBuffer sql		=new StringBuffer();
	String from 			= request.getParameter("from") ; 
	String to 				= request.getParameter("to") ;
	String mode = "delete";
	String module_name=null;
	String eventId=null;
	String category1=null;
	String category2=null;
	String taskType1=null;
	String taskType2=null;
	String taskcode=null;
	String taskdesc=null;
	String eventDesc=null;
	PreparedStatement ps1 = null;
	ResultSet rs1 = null;
	String sql1="";
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

	 	if ( !(event_id == null || event_id.equals("")) )
	 {

			sql.append(" and upper(EVENT_CODE) LIKE Upper('"+event_id+"%') ");


	 }
	   	if ( !(event_desc == null || event_desc.equals("")) )
	 {

			sql.append(" and upper(SPLTY_EVENT_DESC) LIKE Upper('"+event_desc+"%') ");


	 }


	 	if ( !(category == null || category.equals("")) )
	 {
		   if(category.equals("A")){
			//sql.append("  AND upper(A.MODULE_ID) LIKE Upper('%') ");
		 }else{
			sql.append(" and upper(CATEGORY) LIKE Upper('"+category+"%') ");
		 }
	 }	 
	   	if ( !(taskType == null || taskType.equals("")) )
	 {

			sql.append(" and upper(ASS_TYPE) LIKE Upper('"+taskType+"%') ");

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
	  strsql2.append("SELECT B.MODULE_NAME,A.EVENT_CODE,A.CATEGORY,A.MODULE_ID, A.ASS_TYPE ,ASS_ACTION_CODE,C.SPLTY_EVENT_DESC FROM CA_PAT_SPLTY_ASS_TASK A ,SM_MODULE B,CA_SPLTY_EVENT C WHERE A.MODULE_ID=B.MODULE_ID and A.EVENT_CODE=C.SPLTY_EVENT_CODE");
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
	out.println("<A HREF='../../eCA/jsp/SpecialityTasksQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eCA/jsp/SpecialityTasksQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	
	<TH class='COLUMNHEADERCENTER'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></TH>
	<TH class='COLUMNHEADERCENTER'><fmt:message key="eCA.SpecialityEvent.label" bundle="${ca_labels}"/></TH>
	<TH class='COLUMNHEADERCENTER'><fmt:message key="eCA.SpecialityEventDesc.label" bundle="${ca_labels}"/></TH>
	<TH class='COLUMNHEADERCENTER'><fmt:message key="Common.category1.label" bundle="${common_labels}"/></TH>
	<TH class='COLUMNHEADERCENTER'><fmt:message key="eCA.TaskType.label" bundle="${ca_labels}"/></TH>
	 <TH class='COLUMNHEADERCENTER'><fmt:message key="eCA.TaskDesc.label" bundle="${ca_labels}"/></TH>
<%}
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;

	module_name=(rs.getString(1)==null)?"":rs.getString(1); 
  	eventId=(rs.getString(2)==null)?"":rs.getString(2); 
  	eventDesc=(rs.getString("SPLTY_EVENT_DESC")==null)?"":rs.getString("SPLTY_EVENT_DESC"); 
  	category1=(rs.getString(3)==null)?"":rs.getString(3);
  	taskcode=(rs.getString(6)==null)?"":rs.getString(6);
	
	if(category1.equals("M"))
	  category2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mother.label","common_labels");
	 else	  if(category1.equals("F"))
	 category2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Foetus.label","ca_labels");
	 else
	  	 category2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NonSpecific.label","ca_labels");
	taskType1=(rs.getString(5)==null)?"":rs.getString(5);
	if(taskType1.equals("N"))
	 taskType2=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.note.label","common_labels");
	else
	  taskType2= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels");

		try{
			  //Connection con = null;
	          
			 if(taskType1.equals("N"))
		     sql1 = "SELECT  NOTE_TYPE_DESC  FROM ca_note_type WHERE eff_status='E'  and NOTE_TYPE=?";
			 else
			 sql1 = "SELECT SHORT_DESC   FROM ca_chart WHERE eff_status='E' and CHART_ID=?";

		     ps1 = con.prepareStatement(sql1);
			 ps1.setString(1,taskcode.trim());
		     rs1 = ps1.executeQuery();
			 if(rs1.next())
			{
			 if(taskType1.equals("N"))
			 taskdesc=rs1.getString("NOTE_TYPE_DESC");
			 else
			   taskdesc=rs1.getString("SHORT_DESC");
			}
			 if(rs1 != null) rs1.close();
		     if(ps1 != null) ps1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
			/*   try{
			 sql1 = "SELECT  SPLTY_EVENT_DESC  FROM CA_SPLTY_EVENT WHERE eff_status='E' and SPLTY_EVENT_CODE=?";
			 ps1 = con.prepareStatement(sql1);
			 ps1.setString(1,eventId);
		     rs1 = ps1.executeQuery();
			 if(rs1.next())
			{
			   eventDesc=rs1.getString("SPLTY_EVENT_DESC");
			}
			 if(rs1 != null) rs1.close();
		     if(ps1 != null) ps1.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}	 */

	%>

		<tr>
			<td class='<%=classValue%>'><%=module_name%></td>
		<%	out.println("<td class='"+classValue+"'> <a href='../../eCA/jsp/SpltyAssTaskAddModify.jsp?module="+rs.getString(4)+ "&mode="+mode+"&eventId="+eventId+"&category1="+category1+"&taskType1="+taskType1+"&taskcode="+taskcode+"'>"+eventId+"</a></td>");	%>
			<td class='<%=classValue%>'><%=eventDesc%></td>
			<td class='<%=classValue%>'><%=category2%></td>
			<td class='<%=classValue%>'><%=taskType2%></td>
			<td class='<%=classValue%>'><%=taskdesc%></td>
		</tr>
<%	i++;
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

