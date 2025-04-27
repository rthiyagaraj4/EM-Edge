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
	String module_id		= request.getParameter("module_id");
	String sptask_code		= request.getParameter("sptask_code");
	String sptask_desc		= request.getParameter("sptask_desc");
	String sptask_type		= request.getParameter("sptask_type");
	StringBuffer sql		=new StringBuffer();
	String from 			= request.getParameter("from") ; 
	String to 				= request.getParameter("to") ;
	String task_modname=null;
	String task_code=null;
	String task_desc=null;
	String task_type=null;
	String task_type_desc=null;
	String task_extbl_name=null;
	String task_actn_code=null;
	String task_actn_desc=null;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		 // Changing to Upper case and checking





	if ( !(module_id == null || module_id.equals("")) )
	 {
		if(module_id.equals("A")){
			//sql.append("  AND upper(A.MODULE_ID) LIKE Upper('%') ");
		}else{
		sql.append("  AND upper(A.MODULE_ID) LIKE Upper('"+module_id+"%') ");
		}

	 }

	 	if ( !(sptask_code == null || sptask_code.equals("")) )
	 {

			sql.append(" and upper(SPLTY_TASK_CODE) LIKE Upper('"+sptask_code+"%') ");


	 }

	 	if ( !(sptask_desc == null || sptask_desc.equals("")) )
	 {

			sql.append(" and upper(SPLTY_TASK_DESC) LIKE Upper('"+sptask_desc+"%') ");

	 }

	 	if ( !(sptask_type == null || sptask_type.equals("")) )
	 {
		if(sptask_type.equals("A")){
			//sql.append(" and upper(OUTCOME_TYPE) LIKE Upper('%') ");
		}else{
			sql.append(" and upper(SPLTY_TASK_TYPE) LIKE Upper('"+sptask_type+"%') ");
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
	  strsql2.append("SELECT SPLTY_TASK_CODE,B.MODULE_NAME,SPLTY_TASK_DESC,SPLTY_TASK_TYPE,EXECUTABLE_NAME,ACTION_CODE,(CASE SPLTY_TASK_TYPE WHEN 'NT' THEN (SELECT NOTE_TYPE_DESC FROM CA_NOTE_TYPE WHERE NOTE_TYPE=A.ACTION_CODE) WHEN 'NG' THEN (SELECT NOTE_GROUP_DESC FROM CA_NOTE_GROUP WHERE NOTE_GROUP=A.ACTION_CODE) WHEN 'CH' THEN (SELECT SHORT_DESC FROM ca_chart WHERE Chart_id=A.ACTION_CODE) WHEN 'CT' THEN(SELECT APPL_TASK_DESC  FROM CA_APPL_TASK WHERE APPL_TASK_ID=A.ACTION_CODE) ELSE NULL END) ACTION_DESC FROM CA_SPLTY_TASKS A ,SM_MODULE B  WHERE A.MODULE_ID=B.MODULE_ID ");
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
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
	<td class='COLUMNHEADERCENTER'><fmt:message key="eSM.Executable.label" bundle="${sm_labels}"/> <fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
<%}
	 if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	 else
		  	classValue = "QRYODD" ;

	task_code	=(rs.getString(1)==null)?"":rs.getString(1);
	task_modname=(rs.getString(2)==null)?"":rs.getString(2); 
  	task_desc=(rs.getString(3)==null)?"":rs.getString(3); 
  	task_type=(rs.getString(4)==null)?"":rs.getString(4); 
  	task_extbl_name=(rs.getString(5)==null)?"":rs.getString(5);
  	task_actn_code=(rs.getString(6)==null)?"":rs.getString(6);
  	task_actn_desc=(rs.getString(7)==null)?"":rs.getString(7);
	if(task_type.equals("CT")){
	task_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Clinician.label","common_labels");
	}else if(task_type.equals("NT")){
	task_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NoteType.label","common_labels");
	}else if(task_type.equals("NG")){
	task_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoteGroup.label","ca_labels");
	}else if(task_type.equals("FX")){
	task_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Fixed.label","common_labels");
	}else if(task_type.equals("CH")){
	task_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels");
	}else if(task_type.equals("HD")){
	task_type_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Header.label","common_labels");
	}else
	task_type_desc="";
	out.println("<tr><td class='" + classValue + "'>"+task_modname+"</td>");
	out.println("<td class='" + classValue + "'>");	
	out.println("<A href='../../eCA/jsp/SpecialityTasksAddModify.jsp?mode=MODIFY&sptask_code="+task_code+"'>"+task_code+"</A></td>");

	out.println("<td class='" + classValue + "'>"+task_desc+"</td>");
	if(task_type.equals("E")){
	task_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Event.label","common_labels");
	}else if(task_type.equals("O")){
	task_type =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
	}
	out.println("<td class='" + classValue + "'>"+task_type_desc+"</td>");
	out.println("<td class='" + classValue + "'>"+task_extbl_name+"</td>");
	out.println("<td class='" + classValue + "'>"+task_actn_desc+"</td>");
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

