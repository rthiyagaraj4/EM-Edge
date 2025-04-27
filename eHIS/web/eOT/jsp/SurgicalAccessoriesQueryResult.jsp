<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.Common.*,eCommon.XSSRequestWrapper" %>                            
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
                   

<HTML>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
		<script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
		<script Language="JavaScript" src="../../eOT/js/SurgicalAccessories.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 

</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	try
	{
   
	String whereClause = checkForNull(request.getParameter("whereclause"));
	String from = request.getParameter( "from" ) ;
    String to =request.getParameter( "to" ) ;
    String sql = " ";

    String applicability = checkForNull(request.getParameter( "applicability" ));
	String speciality_code =checkForNull(request.getParameter( "speciality_code" ));
	String oper_cat_code =checkForNull(request.getParameter( "oper_cat_code" ));
	 String oper_cat_desc = checkForNull(request.getParameter( "oper_cat_desc" ));
	String oper_sub_cat_code =checkForNull(request.getParameter( "oper_sub_cat_code" ));
	String oper_sub_cat_desc =checkForNull(request.getParameter( "oper_sub_cat_desc" ));
	String oper_code =checkForNull(request.getParameter( "oper_code" ));
	String oper_desc =checkForNull(request.getParameter( "oper_desc" ));
	String speciality_desc="";
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(applicability == null || applicability.equals(""))){
			if(applicability.equals("ALL")){
				sql="";
			}else{
				sql = sql + " and A.APPLICABILITY='"+applicability+"'";
				cnt++;
			}
        }
        if ( !(speciality_code == null || speciality_code.equals("")) ){
			if(cnt>0){
				sql = sql + " and A.SPECIALITY_CODE ='"+speciality_code+"'";
			}else{
				sql=sql+" and A.SPECIALITY_CODE ='"+speciality_code+"'";
				cnt=1;
			}

        }
		 if ( !(oper_cat_code == null || oper_cat_code.equals("")) ){
			if(cnt>0){
				sql = sql + " and upper(A.OPER_CAT_CODE) like upper('%"+oper_cat_code+"%')";
			}else{
				sql=sql+" and upper(A.OPER_CAT_CODE) like upper('%"+oper_cat_code+"%')";
				cnt=1;
			}

        }
		if ( !(oper_cat_desc == null || oper_cat_desc.equals("")) ){
			if(cnt>0){
				sql = sql + " and A.OPER_CAT_CODE IN (SELECT OPER_CAT_CODE FROM OT_OPER_CATEGORY WHERE UPPER(LONG_DESC) LIKE UPPER('%"+oper_cat_desc+"%'))";
			}else{
				sql=sql+" and A.OPER_CAT_CODE IN (SELECT OPER_CAT_CODE FROM OT_OPER_CATEGORY WHERE UPPER(LONG_DESC) LIKE UPPER('%"+oper_cat_desc+"%'))";
				cnt=1;
			}

        }

		if ( !(oper_sub_cat_code == null || oper_sub_cat_code.equals("")) ){
			if(cnt>0){
				sql = sql + " and upper(A.OPER_SUB_CAT_CODE) like upper('%"+oper_sub_cat_code+"%')";
			}else{
				sql=sql+"  and upper(A.OPER_SUB_CAT_CODE) like upper('%"+oper_sub_cat_code+"%')";
				cnt=1;
			}

        }

		if ( !(oper_sub_cat_desc == null || oper_sub_cat_desc.equals("")) ){
			if(cnt>0){
				sql = sql + " and A.OPER_SUB_CAT_CODE IN (SELECT OPER_SUB_CAT_CODE FROM OT_OPER_SUB_CATEGORY WHERE UPPER(LONG_DESC) LIKE UPPER('%"+oper_cat_desc+"%'))";
		}else{
				sql=sql+" and A.OPER_SUB_CAT_CODE IN (SELECT OPER_SUB_CAT_CODE FROM OT_OPER_SUB_CATEGORY WHERE UPPER(LONG_DESC) LIKE UPPER('%"+oper_cat_desc+"%'))";
				cnt=1;
			}

        }

		if ( !(oper_code == null || oper_code.equals("")) ){
			if(cnt>0){
				sql = sql + " and A.OPER_CODE='"+oper_code+"'";
			}else{
				sql=sql+"  and and A.OPER_CODE='"+oper_code+"'";
				cnt=1;
			}

        }

		if ( !(oper_desc == null || oper_desc.equals("")) ){
			if(cnt>0){
				sql = sql + " and A.OPER_CODE IN (SELECT OPER_CODE FROM OT_OPER_MAST  WHERE UPPER(LONG_DESC) LIKE UPPER('"+oper_desc+"%'))";
			}else{
				sql=sql+" and A.OPER_CODE IN (SELECT OPER_CODE FROM OT_OPER_MAST  WHERE UPPER(LONG_DESC) LIKE UPPER('"+oper_desc+"%'))";
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

    } //end of where clause IF
    else
            sql = whereClause;

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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
int maxRecord = 0;
ResultSet rset=null;
ResultSet rs = null;

	try{
		
		//		String strsql="SELECT A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC, A.OPER_CODE, E.SHORT_DESC FROM OT_OPER_SURGICAL_ACCESSORIES A, AM_SPECIALITY B, OT_OPER_CATEGORY C, OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+) AND A.OPER_CODE=E.OPER_CODE(+)"+sql;

		String aopr=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllOperations.label","common_labels");
		String sspl=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecificSpecialty.label","common_labels");
		String ssub=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SpecificOperationSubCategoryWithinSpeciality.Label","ot_labels");
		String sopr=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecificOperation.label","common_labels");
		String scat=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SpecificOperationCategoryWithinSpeciality.Label","ot_labels");                       
         
		 //Commented against MMS-QH-CRF-0199 UserStory  4
		/*String strsql="SELECT DISTINCT decode(A.APPLICABILITY,'AOPR','"+aopr+"','SSPL','"+sspl+"','SSUB','"+ssub+"','SOPR','"+sopr+"','SCAT','"+scat+"',A.APPLICABILITY) APPLICABILITY_DESC,A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC, A.OPER_CODE, E.SHORT_DESC  FROM OT_OPER_SURGICAL_ACCESSORIES A, AM_SPECIALITY B, OT_OPER_CATEGORY C,  OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E  WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+)  AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+)  AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE(+) AND A.OPER_CAT_CODE = D.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+)  AND A.OPER_CODE=E.OPER_CODE(+)"+sql;*/
		
		//Added  against MMS-QH-CRF-0199 UserStory  4
		String strsql="SELECT DISTINCT decode(A.APPLICABILITY,'AOPR','"+aopr+"','SSPL','"+sspl+"','SSUB','"+ssub+"','SOPR','"+sopr+"','SCAT','"+scat+"',A.APPLICABILITY) APPLICABILITY_DESC,A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC, A.OPER_CODE, E.LONG_DESC  FROM OT_OPER_SURGICAL_ACCESSORIES A, AM_SPECIALITY B, OT_OPER_CATEGORY C,  OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E  WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+)  AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+)  AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE(+) AND A.OPER_CAT_CODE = D.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+)  AND A.OPER_CODE=E.OPER_CODE(+)"+sql;

		//String strsql1="SELECT A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC, A.OPER_CODE, E.SHORT_DESC FROM OT_OPER_SURGICAL_ACCESSORIES A, AM_SPECIALITY B, OT_OPER_CATEGORY C, OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+) AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+) AND A.OPER_CODE=E.OPER_CODE(+) "+sql;
		
        	//Commented against MMS-QH-CRF-0199 UserStory  4
		/*String strsql1="SELECT DISTINCT decode(A.APPLICABILITY,'AOPR','"+aopr+"','SSPL','"+sspl+"','SSUB','"+ssub+"','SOPR','"+sopr+"','SCAT','"+scat+"',A.APPLICABILITY) APPLICABILITY_DESC,A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC sub_catg_longDesc, A.OPER_CODE, E.SHORT_DESC mastShortDesc  FROM OT_OPER_SURGICAL_ACCESSORIES A, AM_SPECIALITY B, OT_OPER_CATEGORY C,  OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E  WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+)  AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+)  AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE(+) AND A.OPER_CAT_CODE = D.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+)  AND A.OPER_CODE=E.OPER_CODE(+)"+sql;	//049252*/
		
		//Added  against MMS-QH-CRF-0199 UserStory  4
		String strsql1="SELECT DISTINCT decode(A.APPLICABILITY,'AOPR','"+aopr+"','SSPL','"+sspl+"','SSUB','"+ssub+"','SOPR','"+sopr+"','SCAT','"+scat+"',A.APPLICABILITY) APPLICABILITY_DESC,A.APPLICABILITY, A.SPECIALITY_CODE, B.SHORT_DESC, A.OPER_CAT_CODE, C.LONG_DESC, A.OPER_SUB_CAT_CODE, D.LONG_DESC sub_catg_longDesc, A.OPER_CODE, E.LONG_DESC mastShortDesc  FROM OT_OPER_SURGICAL_ACCESSORIES A, AM_SPECIALITY B, OT_OPER_CATEGORY C,  OT_OPER_SUB_CATEGORY D, OT_OPER_MAST E  WHERE A.SPECIALITY_CODE=B.SPECIALITY_CODE(+)  AND A.OPER_CAT_CODE=C.OPER_CAT_CODE(+)  AND A.SPECIALITY_CODE = D.OPER_GROUP_CODE(+) AND A.OPER_CAT_CODE = D.OPER_CAT_CODE(+) AND A.OPER_SUB_CAT_CODE=D.OPER_SUB_CAT_CODE(+)  AND A.OPER_CODE=E.OPER_CODE(+)"+sql;	//049252
		stmt = conn.prepareStatement(strsql);
        rs = stmt.executeQuery();
       int total=0;
		while(rs.next())
		{
			total++;
		}

		maxRecord = total;
		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg From SurgicalAccessoriesQueryResult.jsp : "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/SurgicalAccessoriesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/SurgicalAccessoriesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table  class='grid' border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
		<fmt:message key="Common.Applicability.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
		<fmt:message key="Common.category1.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
		<fmt:message key="eOT.SubCategory.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap>  <!-- changed by yadav -->
		<fmt:message key="Common.operation.label" bundle="${common_labels}"/>
</th>


<%
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
	String classValue= " ";
		while ( rset.next() && i<=end  )
		{
/*
			if  i % 2 == 0)
				classValue = "gridData" ; // changed by yadav
			else
*/
			classValue = "gridData" ; // changed by yadav
			out.println("<tr><td align='left' class='" + classValue + "'>");
			speciality_desc = rset.getString(4);
			if(speciality_desc == null || speciality_desc.equals("null"))
				speciality_desc="&nbsp;";
			oper_cat_desc=rset.getString(6);
			if(oper_cat_desc==null || oper_cat_desc.equals("null"))
				oper_cat_desc="&nbsp;";
			oper_sub_cat_desc=rset.getString(8);
			if(oper_sub_cat_desc==null || oper_sub_cat_desc.equals("null"))
				oper_sub_cat_desc="&nbsp;";
			oper_desc=rset.getString(10);
			if(oper_desc==null || oper_desc.equals("null"))
				oper_desc="&nbsp;";
			String mode="modify";
			out.println("<a href='../../eOT/jsp/SurgicalAccessoriesFrameForCreate.jsp?update_mode_yn="+mode+"&applicability="+rset.getString(2)+"&speciality_code="+rset.getString(3)+"&oper_cat_code="+rset.getString(5)+"&oper_sub_cat_code="+rset.getString(7)+"&oper_code="+rset.getString(9)+"' target='f_query_add_mod' >");
			out.println(rset.getString(1)+"</a></td>");
			out.println("<td class='" + classValue+"'>"+speciality_desc+"</td>");
			out.println("<td class='" + classValue+"'>"+oper_cat_desc+"</td>");
			out.println("<td class='" + classValue+"'>"+oper_sub_cat_desc+"</td>");
			out.println("<td class='" + classValue+"'>"+oper_desc+"</td>");
			i++;
		}
%>

</tr>
</table>
</center>

<br><center>

<%
	if(stmt!=null)	stmt.close();
			if(stmt1!=null)	stmt1.close();
			if(rs!=null)	rs.close();
			if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
	}
	catch(Exception e)
	{
		e.printStackTrace();
		//System.err.println("here "+e);
	}
%>

</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

