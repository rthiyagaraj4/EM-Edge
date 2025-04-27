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
   PreparedStatement  pstmt = null;
   ResultSet rs1= null;
	String whereClause		= request.getParameter("whereclause");
	String module_id		= request.getParameter("module_id");
	String outcome_code		= request.getParameter("outcome_code");
	String outcome_desc		= request.getParameter("outcome_desc");
	String outcome_type		= request.getParameter("outcome_type");
	StringBuffer sql		=new StringBuffer();
	String from 			= request.getParameter("from") ; 
	String to 				= request.getParameter("to") ;
	String module_id1=null;
	String outcome_code1=null;
	String outcome_desc1=null;
	String outcome_type1=null;
	String ageGroupCode="";
	String  agegroupDes="";
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

	 	if ( !(outcome_code == null || outcome_code.equals("")) )
	 {

			sql.append(" and upper(OUTCOME_CODE) LIKE Upper('"+outcome_code+"%') ");


	 }

	 	if ( !(outcome_desc == null || outcome_desc.equals("")) )
	 {

			sql.append(" and upper(OUTCOME_DESC) LIKE Upper('"+outcome_desc+"%') ");

	 }

	 	if ( !(outcome_type == null || outcome_type.equals("")) )
	 {
		if(outcome_type.equals("A")){
			//sql.append(" and upper(OUTCOME_TYPE) LIKE Upper('%') ");
		}else{
			sql.append(" and upper(OUTCOME_TYPE) LIKE Upper('"+outcome_type+"%') ");
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
	  strsql2.append("SELECT OUTCOME_CODE,B.MODULE_NAME,OUTCOME_DESC,OUTCOME_TYPE,AGE_GROUP FROM CA_SPLTY_OUTCOME A,SM_MODULE B  WHERE A.MODULE_ID=B.MODULE_ID ");
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
	out.println("<A HREF='../../eCA/jsp/SpecialityOutcomeQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

  if (endOfRes.equals("1"))
	out.println("<A id='nextvalue' HREF='../../eCA/jsp/SpecialityOutcomeQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
	
%>
</td>
</tr>
</table>
</p>
<br><br>
<table  width="100%" class='grid' >
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADERCENTER'><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></td>
<%}
	 if ( i % 2 == 0 )
		  	classValue = "gridData" ;
	 else
		  	classValue = "gridData" ;

	outcome_code1	=(rs.getString(1)==null)?"":rs.getString(1);
	module_id1=(rs.getString(2)==null)?"":rs.getString(2); 
  	outcome_desc1=(rs.getString(3)==null)?"":rs.getString(3); 
  	outcome_type1=(rs.getString(4)==null)?"":rs.getString(4); 
  	ageGroupCode=(rs.getString("AGE_GROUP")==null)?"":rs.getString("AGE_GROUP"); 
	 try{
			 
			 String sql1 = "Select   SHORT_DESC  from  AM_AGE_GROUP where AGE_GROUP_CODE=?";
			 pstmt = con.prepareStatement(sql1);
			 pstmt.setString(1,ageGroupCode);
		     rs1= pstmt.executeQuery();
			 if(rs1.next())
				 agegroupDes=rs1.getString("SHORT_DESC");
			 else
				agegroupDes="&nbsp;";
			 if(rs1 != null) rs1.close();
		     if(pstmt != null) pstmt.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
			}
	out.println("<tr><td class='" + classValue + "'>"+module_id1+"</td>");
	out.println("<td class='" + classValue + "'>");	
	out.println("<A href='../../eCA/jsp/SpecialityOutcomeAddModify.jsp?mode=MODIFY&outcome_code="+outcome_code1+"' class='gridLink'>"+outcome_code1+"</A></td>");

	out.println("<td class='" + classValue + "'>"+outcome_desc1+"</td>");
	if(outcome_type1.equals("E")){
	outcome_type1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Event.label","common_labels");
	}else if(outcome_type1.equals("O")){
	outcome_type1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.others.label","common_labels");
	}
	out.println("<td class='" + classValue + "'>"+agegroupDes+"</td>");
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
		e.toString();
		//out.println(e.toString());//common-icn-0181
     }
	finally   
	{
		 
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
    }
%>

</BODY>
</HTML>

