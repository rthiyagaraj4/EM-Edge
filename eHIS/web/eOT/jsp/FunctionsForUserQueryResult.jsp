<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
	<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY class='CONTENT'  OnMouseDown="" onKeyDown="lockKey()">


<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String locale = (String)session.getAttribute("LOCALE");
    String whereClause = request.getParameter("whereclause");
	String from = checkForNull(request.getParameter( "from" ) ) ;
    String to =   checkForNull(request.getParameter( "to" ) ) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
	int end =  ( to.equals("") )?14:Integer.parseInt(to);

    String user_id =checkForNull(request.getParameter( "user_id" ));
	String function_id = checkForNull(request.getParameter( "function_id" ));
    String function_desc_user = checkForNull(request.getParameter( "function_desc_user" ));
    String allow_verif = checkForNull(request.getParameter( "allow_verif" ));
    String sql="";
//    String user_desc="";
//	String mode="modify";
	StringBuffer sbr=new StringBuffer();
	String user_name = "";

	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;
	
	if ( !(user_id == null || user_id.equals("")) )
		
		{
			sql=sql+ " and  A.user_id = '"+user_id+"' ";
			cnt++;
		}


	if ( !(function_id == null || function_id.equals("")) )
		{
		if(cnt>0){
			sql=sql+ " and  A.function_id like'"+function_id+"%'";
		}else{
				sql=sql+" and A.function_id like '"+function_id+"%' ";
				cnt=1;
		}
	} 

/*	if ( !(srl_no == null || srl_no.equals("")) )
		{
		if(cnt>0){
			sql+= "and  A.srl_no like '"+srl_no+"%'";
		}else{
				sql=sql+" and A.srl_no like '"+srl_no+"%'";
				cnt=1;

		}
	} 
	 
*/	
	if ( !(function_desc_user == null || function_desc_user.equals("")) )
		{
			if(cnt>0){
			sql=sql+ " and  upper(C.function_desc_user) like upper('"+function_desc_user+"%')";
			//andCheck = 1;
			}else{
				sql=sql+" and upper(C.function_desc_user) like upper('"+function_desc_user+"%')";
				cnt=1;
			}
		}


	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql=sql+" order by ";
			for ( int i=0;i < ord.length;i++ )
		 	{
			 	if ( i == ord.length - 1 )
				sql=sql+ord[i];
				else
				sql=sql+ord[i]+",";
			}
		}
	}//end of where clause IF

 else
    {
	sql = whereClause;
    }

int i=0;
	Connection 	conn = ConnectionManager.getConnection(request);

PreparedStatement pstmt = null;
ResultSet rst=null;
int maxRecord = 0;

String strsql="SELECT A.USER_ID, B.APPL_USER_NAME, A.FUNCTION_ID,   C.FUNCTION_DESC_USER , NVL(A.ALLOW_VERIFICATION_YN, 'N') FROM OT_USER_FUNCTIONS A, OT_FUNCTIONS_LANG_VW C, SM_APPL_USER B WHERE C.LANGUAGE_ID ='"+locale+"' AND A.FUNCTION_ID = C.FUNCTION_ID AND A.USER_ID = B.APPL_USER_ID" +sql;
try{
		pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	rst = pstmt.executeQuery();
  //getting maximum record
  rst.last();	maxRecord = rst.getRow();
  //out.println(maxRecord);
  if(maxRecord == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			
  }
  //again move the resultset pointer to initial position
  rst.beforeFirst();

%>

<p>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/FunctionsForUserQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/FunctionsForUserQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.userid.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.username.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.FunctionDescription.Label" bundle="${ot_labels}"/>
</th>
<!-- commented by rajesh by vishwa's instruction on 23/03/09 -->
<!-- <td class='columnheadercenter' nowrap> <!-- changed by yadav 
	<fmt:message key="eOT.VerificationAllowed.Label" bundle="${ot_labels}"/>
</td> -->


<%

	String classValue = "" ;
 	if ( start!= 1 ) rst.absolute(start-1);
	 i=start;
	while ( rst.next() && i<=end ){
        classValue = ( i % 2 == 0 )?"gridData":"gridData" ;  // changed by yadav
		user_name = java.net.URLEncoder.encode(rst.getString(2),"UTF-8");
		sbr.append("<tr>");
		sbr.append("<td class='"+classValue+"'>"+rst.getString(1)+"</td>");
		sbr.append("<td class='"+classValue+"'>"+rst.getString(2)+"</td>");
		sbr.append("<td class='gridData'>"+rst.getString(3)+"</td>"); // changed by yadav
		sbr.append("<td class='"+classValue+"'>"+rst.getString(4)+"</td>");
		/*allow_verif = "Y".equals(checkForNull(rst.getString(5)))?"checked":"";
		if(allow_verif.equals("checked"))
			sbr.append("<td class='"+classValue+"'>"+"<img src='../../eCommon/images/enabled.gif'></img>"+"</td>");
	    else
			sbr.append("<td class='"+classValue+"'>"+"<img src='../../eCommon/images/RRnwd.gif'></img>"+"</td>");*/
		sbr.append("</tr>");
		i++;
}
out.println(sbr.toString());
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err Msg From FunctionForUserQueryResult-->"+e);
}finally{
		try{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(conn,request);
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
}

%>
</table>
<center>
</center>
</body>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</HTML>

