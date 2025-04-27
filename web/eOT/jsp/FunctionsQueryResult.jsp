<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
<head>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript"  src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">

<%
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" )) ;
    String to = checkForNull(request.getParameter( "to" )) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
    int end =  ( to.equals("") )?14:Integer.parseInt(to);
    String function_id = checkForNull(request.getParameter( "function_id" ));
	String function_desc_sys =checkForNull(request.getParameter( "function_desc_sys" ));
	String function_desc_user = checkForNull(request.getParameter( "function_desc_user" ));
	String url_desc = checkForNull(request.getParameter( "url_desc" ));
	String linked_status_code = checkForNull(request.getParameter( "linked_status_code"));
	String check_for_check_list_compl = checkForNull(request.getParameter( "check_for_check_list_compl"));
	String allow_barcode = checkForNull(request.getParameter( "allow_barcode"));
	String verification_applicable = checkForNull(request.getParameter( "verification_applicable"));
	//String strsql="SELECT A.FUNCTION_ID, A.FUNCTION_DESC_SYS, A.FUNCTION_DESC_USER, A.LINKED_STATUS_CODE, B.STATUS_DESC LINKED_STATUS_DESC, A.CHECK_FOR_CHECK_LIST_COMPL, A.ALLOW_BARCODE, A.VERIFICATION_APPLICABLE, A.URL_DESC FROM OT_FUNCTIONS A, OT_STATUS B WHERE A.LINKED_STATUS_CODE = B.STATUS_CODE (+)";
	String strsql="SELECT A.FUNCTION_ID FUNCTION_ID, A.FUNCTION_DESC_SYS, A.FUNCTION_DESC_USER, A.LINKED_STATUS_CODE,GET_DESC('"+locale+"','OT_STATUS_LANG_VW','STATUS_DESC','STATUS_CODE',A.LINKED_STATUS_CODE) LINKED_STATUS_DESC, A.CHECK_FOR_CHECK_LIST_COMPL, A.ALLOW_BARCODE, A.VERIFICATION_APPLICABLE, A.URL_DESC FROM OT_FUNCTIONS_LANG_VW A, OT_STATUS B WHERE A.LANGUAGE_ID =? AND A.LINKED_STATUS_CODE = B.STATUS_CODE(+) ";

//	String mode="modify";
	String enable_img = "<img src='../../eCommon/images/enabled.gif'></img>";
	String disable_img = "<img src='../../eCommon/images/RRnwd.gif'></img>";
	String check_list_compl="";
	String verification_appl="";
//	String linked_status_desc="";
	String sql="";
	 String classValue= "";
	StringBuffer sbr = new StringBuffer();
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(function_id == null || function_id.equals("")) ){
	        sql = sql + " and upper(a.function_id ) like upper('"+function_id +"%')";
			cnt++;
        }

        if ( !(function_desc_sys == null || function_desc_sys.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.function_desc_sys) like upper('"+function_desc_sys+"%')";
			else{
				sql=sql+" and upper(a.function_desc_sys) like upper('"+function_desc_sys+"%')";
				cnt=1;
			}

        }
	   if ( !(function_desc_user == null || function_desc_user.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.function_desc_user) like upper('"+function_desc_user+"%')";
			else{
				sql=sql+" and upper(a.function_desc_user) like upper('"+function_desc_user+"%')";
				cnt=1;
			}

        }
	
	if ( !(url_desc == null || url_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.url_desc) like upper('"+url_desc+"%')";
			else{
				sql=sql+" and upper(a.url_desc) like upper('"+url_desc +"%')";
				cnt =1;
			}
        }

	if ( !(linked_status_code == null || linked_status_code.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(a.linked_status_code) like upper('"+linked_status_code+"%')";
			else{
				sql=sql+" and upper(a.linked_status_code) like upper('"+linked_status_code +"%')";
				cnt =1;
			}
        }
  if ( !(check_for_check_list_compl == null || check_for_check_list_compl.equals("")) ){
			if(check_for_check_list_compl.equals("N"))
			if(cnt>0)
			   sql = sql+" and nvl(a.check_for_check_list_compl,'N')='N' ";
			else{
				sql=sql+ " and nvl(a.check_for_check_list_compl,'N')='N' ";
				cnt=1;
			}
         }

	if ( check_for_check_list_compl.equals("Y") ){

            if(cnt>0)
			   sql = sql+" and a.check_for_check_list_compl='Y'";
			else
				sql=sql+ "and a.check_for_check_list_compl='Y'";
         }

         

	if ( !(allow_barcode == null || allow_barcode.equals("")) ){
			if(allow_barcode.equals("Y"))
				if(cnt>0)
			   sql = sql+" and a.allow_barcode='Y' ";
			else{
				sql=sql+ " and a.allow_barcode='Y' ";
				cnt=1;
			}
         }

	if ( allow_barcode.equals("N") ){

            if(cnt>0)
			   sql = sql+" and nvl(a.allow_barcode,'N')='N'";
			else
				sql=sql+ "and nvl(a.allow_barcode,'N')='N'";
         }

     if ( !(verification_applicable == null || verification_applicable.equals("")) ){
			if(verification_applicable.equals("Y"))
				if(cnt>0)
			   sql = sql+" and a.verification_applicable='Y' ";
			else{
				sql=sql+ " and a.verification_applicable='Y' ";
				cnt=1;
			}
         }

	if ( verification_applicable.equals("N") ){

            if(cnt>0)
			   sql = sql+" and nvl(a.verification_applicable,'N')='N'";
			else
				sql=sql+ "and nvl(a.verification_applicable,'N')='N'";
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
    //end of where clause IF
    else
         sql = whereClause;

    strsql=strsql+sql;
	Connection conn  =  ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	int maxRecord = 0;
	ResultSet rst = null;
	try{
		
		pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		//getting maximum record
	    rst.last();	maxRecord = rst.getRow();
	    if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			
		}
		//again move the resultset pointer to initial position
		rst.beforeFirst();
%>
<form name='QueryResult' id='QueryResult'>
<table align='right'>
<tr><td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/FunctionsQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/FunctionsQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td></tr>
</table>

<br><br>
<table border="1" class='grid' width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.FunctionID.Label" bundle="${ot_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.SystemDefinedDescription.Label" bundle="${ot_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap >
	<fmt:message key="Common.URL.label" bundle="${common_labels}"/>
</th>
<th class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.LinkedStatus.Label" bundle="${ot_labels}"/>
</th>
<!-- <td class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.CheckForChecklistCompleted.Label" bundle="${ot_labels}"/>
</td>
<td class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.AllowBarcode.Label" bundle="${ot_labels}"/>
</td>
<td class='columnHeaderCenter' nowrap>
	<fmt:message key="eOT.VerificationApplicable.Label" bundle="${ot_labels}"/>
</td>
 -->

<%
   
	if ( start!= 1 ) rst.absolute(start-1);
	int i=start;
	while ( rst.next() && i<=end  ){
		classValue = ( i % 2 == 0 )?"gridData":"gridData"; // changed by yadav
		sbr.append("<tr>");

//FUNCTION_ID, A.FUNCTION_DESC_SYS, A.FUNCTION_DESC_USER, A.LINKED_STATUS_CODE,  ( 1 to 4)
// LINKED_STATUS_DESC, A.CHECK_FOR_CHECK_LIST_COMPL, A.ALLOW_BARCODE, A.VERIFICATION_APPLICABLE, A.URL_DESC (5 to 9)

			sbr.append("<td class='gridData' nowrap><a href='../../eOT/jsp/FunctionsModify.jsp?mode=modify&function_id="+rst.getString(1)+"' target='f_query_add_mod' >"+rst.getString(1)+"</a></td>"); //FUNCTION_ID   class changed by yadav
			sbr.append("<td class='"+classValue+"' nowrap>"+rst.getString(2)+"</td>"); //FUNCTION_DESC_SYS
			sbr.append("<td class='"+classValue+"' nowrap>"+rst.getString(3)+"</td>"); //FUNCTION_DESC_USER
			sbr.append("<td class='"+classValue+"' nowrap>"+checkForNull(rst.getString(9))+"</td>"); //URL_DESC
			sbr.append("<td class='"+classValue+"' nowrap>"+checkForNull(rst.getString(5))+"</td>"); //LINKED_STATUS_DESC
			
			check_list_compl = "Y".equals(checkForNull(rst.getString(6),"N"))?enable_img:disable_img;
	//		sbr.append("<td class='"+classValue+"' nowrap>"+check_list_compl+"</td>");  //CHECK_FOR_CHECK_LIST_COMPL
			
			allow_barcode = "Y".equals(checkForNull(rst.getString(7),"N"))?enable_img:disable_img;
	//		sbr.append("<td class='"+classValue+"' nowrap>"+allow_barcode+"</td>");  //ALLOW_BARCODE

/*			allow_barcode = "Y".equals(checkForNull(rst.getString(7)))?"checked":"";
			sbr.append("<td class='"+classValue+"'> <input type=checkbox name=chk_barcode"+i+" value="+checkForNull(rst.getString(7),"N")+" "+allow_barcode+"></td>");
*/			

			verification_appl = "Y".equals(checkForNull(rst.getString(8),"N"))?enable_img:disable_img;
	//		sbr.append("<td class='"+classValue+"' nowrap>"+verification_appl+"</td>");  //VERIFICATION_APPLICABLE
/*			verification_appl = "Y".equals(checkForNull(rst.getString(8)))?"checked":"";
			sbr.append("<td class='"+classValue+"'> <input type=checkbox name=chk_verification_appl"+i+" value="+checkForNull(rst.getString(8),"N")+" "+verification_appl+"></td>");*/

			sbr.append("</tr>");
			i++;
  }
  out.println(sbr.toString());
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err Msg From FunctionsQueryResult-->"+e);
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
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

