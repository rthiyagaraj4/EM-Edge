<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% 	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(	String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");
	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" )) ;
    String to = checkForNull(request.getParameter( "to" )) ;
	int start = ( from.equals("") )?1:Integer.parseInt(from);
    int end =  ( to.equals("") )?14:Integer.parseInt(to);
    String oper_group_code= checkForNull(request.getParameter( "oper_group_code" ));
	String oper_cat_code =checkForNull(request.getParameter( "oper_cat_code" ));
	String oper_sub_cat_code =checkForNull(request.getParameter( "oper_sub_cat_code" ));
	String long_desc =checkForNull(request.getParameter( "long_desc" ));
	String enabled = checkForNull(request.getParameter( "status"),"E");
	String enable_img = "<img src='../../eCommon/images/enabled.gif'></img>";
	String disable_img = "<img src='../../eCommon/images/RRnwd.gif'></img>";
	String status_img ="";
	//String speciality_desc="";
	//String oper_cat_desc="";
	String sql = " ";
	StringBuffer sbr=new StringBuffer();
	String classValue="";

	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=1;

		if ( !(oper_group_code == null || oper_group_code.equals("")) ){

	       // sql = sql + " and upper(c.oper_group_code ) like '"+oper_group_code +"%' ";
	        sql = sql + " and upper(a.oper_group_code ) like '"+oper_group_code +"%' ";
			cnt++;
        }

		if ( !(oper_cat_code == null || oper_cat_code.equals("")) ){

			if(cnt>0)
			//	sql = sql + " and c.oper_cat_code like '"+oper_cat_code+"%' ";
				sql = sql + " and a.oper_cat_code like '"+oper_cat_code+"%' ";

        }

        if ( !(oper_sub_cat_code == null || oper_sub_cat_code.equals("")) ){

			if(cnt>0)
				//sql = sql + " and upper(c.oper_sub_cat_code) like upper('"+oper_sub_cat_code+"%') ";
				sql = sql + " and upper(a.oper_sub_cat_code) like upper('"+oper_sub_cat_code+"%') ";

        }
		 if ( !(long_desc == null || long_desc.equals("")) ){

			if(cnt>0)
				//sql = sql + " and upper(c.long_desc) like upper('"+long_desc+"%')";
				sql = sql + " and upper(a.long_desc) like upper('"+long_desc+"%')";
			else{
				sql=sql+" where upper(long_desc) like upper('"+long_desc+"%')";
				cnt=1;
			}
        }
		
	 

	
	if ( !(enabled == null || enabled.equals("")) ){
         if( enabled.equals("E") ){

			if(cnt>0)
			  // sql = sql+" and nvl(c.status,'E')='E'";
			   sql = sql+" and nvl(a.status,'E')='E'";
			else{
				//sql=sql+ " where  nvl(c.status,'E')='E'";
				sql=sql+ " where  nvl(a.status,'E')='E'";
				cnt=1;
			}
         }

		 if ( enabled.equals("D") ){

            if(cnt>0)
			//   sql = sql+" and c.status='D'";
			   sql = sql+" and a.status='D'";
			else
				//sql=sql+ "where  c.status='D'";
				sql=sql+ "where  a.status='D'";
         }

         if ( enabled.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
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

    } //end of where clause IF
    else
            sql = whereClause;

		//String strsql="select c.oper_group_code,b.short_desc speciality_desc, c.oper_cat_code,a.long_desc oper_cat_desc, c.oper_sub_cat_code, c.long_desc, nvl(c.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b, OT_OPER_SUB_CATEGORY c where c.oper_group_code = b.speciality_code and c.oper_cat_code = a.oper_cat_code"+sql;
		//String strsql="select c.oper_group_code,b.short_desc speciality_desc, c.oper_cat_code,a.long_desc oper_cat_desc, c.oper_sub_cat_code, c.long_desc, nvl(c.status,'E') status from  OT_OPER_CATEGORY a, am_speciality b, OT_OPER_SUB_CATEGORY_LANG_VW c where c.oper_group_code = b.speciality_code and c.oper_cat_code = a.oper_cat_code AND c.LANGUAGE_ID=? "+sql;

		//String strsql="SELECT a.oper_group_code,get_desc(?,'AM_SPECIALITY_LANG_VW','long_desc','SPECIALITY_CODE',a.oper_group_code) speciality_desc, a.oper_cat_code, get_desc(?,'OT_OPER_CATEGORY_LANG_VW','long_desc','OPER_CAT_CODE',a.oper_cat_code) OPER_CAT_DESC, c.oper_sub_cat_code, get_desc(?,'OT_OPER_SUB_CATEGORY_LANG_VW','long_desc','OPER_SUB_CAT_CODE',  c.oper_sub_cat_code) OPER_SUB_CAT_DESC, NVL(c.status,'E') status FROM  OT_OPER_CATEGORY a, AM_SPECIALITY b,  OT_OPER_SUB_CATEGORY c where c.oper_group_code = b.speciality_code and c.oper_cat_code = a.oper_cat_code"+sql;
	//String strsql="SELECT A.OPER_GROUP_CODE, C.LONG_DESC SPECIALITY_DESC, A.OPER_CAT_CODE, B.LONG_DESC OPER_CAT_DESC,   A.OPER_SUB_CAT_CODE, A.LONG_DESC OPER_SUB_CAT_DESC, NVL(A.STATUS,'E') STATUS FROM OT_OPER_SUB_CATEGORY_LANG_VW A, OT_OPER_CATEGORY_LANG_VW B, AM_SPECIALITY_LANG_VW C WHERE A.OPER_GROUP_CODE  = C.SPECIALITY_CODE AND  A.OPER_CAT_CODE  = B.OPER_CAT_CODE AND  A.LANGUAGE_ID =  ? AND   A.LANGUAGE_ID= B.LANGUAGE_ID AND  A.LANGUAGE_ID= C.LANGUAGE_ID "+ sql;

	String strsql="SELECT A.OPER_GROUP_CODE, C.LONG_DESC SPECIALITY_DESC, A.OPER_CAT_CODE, B.LONG_DESC OPER_CAT_DESC,   A.OPER_SUB_CAT_CODE, A.LONG_DESC OPER_SUB_CAT_DESC, NVL(A.STATUS,'E') STATUS FROM OT_OPER_SUB_CATEGORY_LANG_VW A, OT_OPER_CATEGORY_LANG_VW B, AM_SPECIALITY_LANG_VW C WHERE A.OPER_GROUP_CODE  = C.SPECIALITY_CODE AND A.OPER_GROUP_CODE = B.OPER_GROUP_CODE AND  A.OPER_CAT_CODE  = B.OPER_CAT_CODE AND  A.LANGUAGE_ID =  ? AND   A.LANGUAGE_ID= B.LANGUAGE_ID AND  A.LANGUAGE_ID= C.LANGUAGE_ID "+ sql;
	
	Connection conn  =  null;
	PreparedStatement pstmt = null;
	ResultSet rst=null;
	int maxRecord = 0;
//	int i=0;
	try{
		conn  =  ConnectionManager.getConnection(request);	
		pstmt = conn.prepareStatement(strsql,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		pstmt.setString(1,locale);
	//	pstmt.setString(2,locale);
	//	pstmt.setString(3,locale);
		rst = pstmt.executeQuery();
		//getting maximum record
	    rst.last();	maxRecord = rst.getRow();
	    if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
			
		}
		//again move the resultset pointer to initial position
		rst.beforeFirst();
%>
<P>
<form name='QueryResult' id='QueryResult'>

<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/OperationSubCategoriesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap > <!-- changed by yadav -->
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap > <!-- changed by yadav -->
	<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap > <!-- changed by yadav -->
	<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter'  nowrap > <!-- changed by yadav -->
<fmt:message key="Common.description.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th> 

<%
   
    /*oper_group_code = rset.getString(1);
    speciality_desc = rset.getString(2);
	oper_cat_code=rset.getString(3);
    oper_cat_desc=rset.getString(4);
	oper_sub_cat_code=rset.getString(5);
    long_desc= rset.getString(6);
	enabled = rset.getString(7);
	*/


	if ( start!= 1 ) rst.absolute(start-1);
	int i=start;

	while ( rst.next() && i<=end  ){
		classValue = ( i % 2 == 0 )?"gridData":"gridData" ; // changed by yadav
		sbr.append("<tr>");

			//sbr.append("<td class='"+classValue+"'><a href='../../eOT/jsp/OperationSubCategoriesAddModify.jsp?mode=modify&speciality_code="+rst.getString(1)+"&speciality_desc="+rst.getString(2)+"&oper_cat_code="+rst.getString(3)+"&oper_cat_desc="+rst.getString(4)+"&oper_sub_cat_code="+rst.getString(5)+"&oper_sub_cat_desc="+rst.getString(6)+" ' target='f_query_add_mod' >"+rst.getString(2)+"</a></td>");
			sbr.append("<td class='"+classValue+"'><a href='../../eOT/jsp/OperationSubCategoriesAddModify.jsp?mode=modify&speciality_code="+rst.getString(1)+"&oper_cat_code="+rst.getString(3)+"&oper_cat_desc="+rst.getString(4)+"&oper_sub_cat_code="+rst.getString(5)+"&oper_sub_cat_desc="+rst.getString(6)+" ' target='f_query_add_mod' >"+rst.getString(2)+"</a></td>");
			
			sbr.append("<td class='"+classValue+"'>"+rst.getString(4)+"</td>");
			sbr.append("<td class='"+classValue+"'>"+rst.getString(5)+"</td>");
			sbr.append("<td class='"+classValue+"'>"+checkForNull(rst.getString(6))+"</td>");
			status_img = "E".equals(checkForNull(rst.getString(7)))?enable_img:disable_img;
			sbr.append("<td class='"+classValue+"'>"+status_img+"</td>");
			sbr.append("</tr>");

	//String mode="modify";
	//out.println("<a href='../../eOT/jsp/OperationSubCategoriesAddModify.jsp?mode="+mode+"&oper_group_code="+oper_group_code+"&oper_cat_code="+oper_cat_code+"&oper_sub_cat_code="+oper_sub_cat_code+"' target='f_query_add_mod' >");
	

   // out.println(speciality_desc+"</a></td>");

    //out.println("<td class='" + classValue+"'>"+oper_cat_desc+"</td>");
    //out.println("<td class='" + classValue+"'>"+oper_sub_cat_code+"</td>");
    //out.println("<td class='" + classValue+"'>"+long_desc+"</td>");

	/*out.println("<td class='" + classValue + "' align='center'>");
    if ( rset.getString("status").equals("E") || rset.getString("status").equals("null"))
	    out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else 
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");
	//out.println("<td class='" + classValue + "' align='center'>"); */
	
	i++;
	} 
	out.println(sbr.toString());
	}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Err Msg From OperationSubCategoriesQueryResult-->"+e);
}finally{
		try{
			if(pstmt!=null)	pstmt.close();
			if(rst!=null)	rst.close();
			ConnectionManager.returnConnection(conn,request);
			sbr.setLength(0);
		}catch(Exception e){e.printStackTrace();}
}

%>

</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

