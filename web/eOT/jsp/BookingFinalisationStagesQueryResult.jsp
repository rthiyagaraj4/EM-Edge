<!DOCTYPE html>
<%@ 
page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.*" 
%>

<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<HTML>
	<head>
	<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = ((String)session.getAttribute("LOCALE"));	

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
        String from = request.getParameter( "from" ) ;
        String to = request.getParameter( "to" ) ;
        String sql = " ";

        String stage_code= request.getParameter("stage_code")==null?"":request.getParameter( "stage_code" );
	String pre_stage_desc =request.getParameter("pre_stage_desc")==null?"":request.getParameter( "pre_stage_desc" );
	String post_stage_desc =request.getParameter("post_stage_desc")==null?"":request.getParameter( "post_stage_desc" );
	String specific_ind =request.getParameter("specific_ind")==null?"":request.getParameter( "specific_ind" );
        String pac_stage_yn =request.getParameter("pac_stage_yn")==null?"":request.getParameter( "pac_stage_yn" );
	
    if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(stage_code == null || stage_code.equals("")) ){
	        sql = sql + " where upper(STAGE_CODE) like upper('"+stage_code +"%')";
			cnt++;
        }

        if ( !(pre_stage_desc == null || pre_stage_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(pre_stage_desc) like upper('"+pre_stage_desc+"%')";
			else{
				sql=sql+" where upper(pre_stage_desc) like upper('"+pre_stage_desc+"%')";
				cnt=1;
			}

        }
        
        if ( !(post_stage_desc == null || post_stage_desc.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(post_stage_desc) like upper('"+post_stage_desc+"%')";
			else{
				sql=sql+" where upper(post_stage_desc) like upper('"+post_stage_desc+"%')";
				cnt=1;
			}

        }
 	
	if ( !(specific_ind == null || specific_ind.equals("")) ){
			if(cnt>0)
				sql = sql + " and upper(specific_ind) like upper('"+specific_ind+"%')";
			else{
				sql=sql+" where upper(specific_ind) like upper('"+specific_ind+"%')";
				cnt=1;
			}

        }
		if ( !(pac_stage_yn == null || pac_stage_yn.equals("")) ){
         if( pac_stage_yn.equals("Y") ){

			if(cnt>0)
			   sql = sql+" and nvl(pac_stage_yn,'Y')='Y' ";
			else{
				sql=sql+ " where  nvl(pac_stage_yn,'Y')='Y' ";
				cnt=1;
			}
         }

		 if ( pac_stage_yn.equals("N") ){

            if(cnt>0)
			   sql = sql+" and nvl(pac_stage_yn,'Y')='N'";
			else{
				sql=sql+ " where  nvl(pac_stage_yn,'Y')='N'";
				cnt = 1;
			}
         }

         if ( pac_stage_yn.equals("B") ){
//               sql = sql; //nothing is added to get both E and D
         }
	   	}
    //appending order by clause
	if(cnt>0)
		sql = sql+" AND LANGUAGE_ID='"+locale+"' ";
	else
		sql=sql+ " where  LANGUAGE_ID='"+locale+"' ";
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
		
		String strsql="select count(*) as total from OT_BOOKING_FIN_STAGES_LANG_VW  "+sql;
		//String strsql1="SELECT STAGE_CODE, PRE_STAGE_DESC, POST_STAGE_DESC, SPECIFIC_IND, nvl(PAC_STAGE_YN,'Y') PAC_STAGE_YN FROM OT_BOOKING_FIN_STAGES "+sql;
		
		String strsql1="SELECT STAGE_CODE, PRE_STAGE_DESC, POST_STAGE_DESC, SPECIFIC_IND, nvl(PAC_STAGE_YN,'Y') PAC_STAGE_YN FROM OT_BOOKING_FIN_STAGES_LANG_VW "+sql;
		stmt = conn.prepareStatement(strsql);
        rs = stmt.executeQuery();
              
		rs.next();
		maxRecord = rs.getInt("total");
		if(maxRecord == 0){
	     out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}	
		stmt1=conn.prepareStatement(strsql1);
		rset = stmt1.executeQuery();
	}catch(Exception e){
		e.printStackTrace();
		//out.println("sdfsadfs "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eOT/jsp/BookingFinalisationStagesQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eOT/jsp/BookingFinalisationStagesQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding=3 align='center'>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="Common.StageCode.label" bundle="${common_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.PreStageDescription.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.PostStageDescription.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.SpecificIndicator.Label" bundle="${ot_labels}"/>
</th>
<th class='columnheadercenter' nowrap> <!-- changed by yadav -->
	<fmt:message key="eOT.PreAnaesthesiaStage.Label" bundle="${ot_labels}"/>
</th>
<%

   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";

while ( rset.next() && i<=end  ){
    if ( i % 2 == 0 )
                    classValue = "gridData" ; // changed by yadav
                else
               classValue = "gridData" ; // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "'>");

    stage_code = rset.getString(1);
    pre_stage_desc=rset.getString(2);
    post_stage_desc=rset.getString(3);
    specific_ind=rset.getString(4);
    pac_stage_yn=rset.getString(5);
    
	String mode="modify";
	out.println("<a href='../../eOT/jsp/BookingFinalisationStagesFrameForCreate.jsp?update_mode_yn="+mode+"&stage_code="+stage_code+"&specific_ind="+specific_ind+"' target='f_query_add_mod' >");
    out.println(stage_code +"</a></td>");
  
   out.println("<td class='" + classValue +"'>"+pre_stage_desc+"</td>");
   out.println("<td class='"+ classValue +"'>"+post_stage_desc+"</td>");
   out.println("<td class='"+ classValue +"'>"+specific_ind+"</td>");
   
   
   out.println("<td class='" + classValue + "' align='center'>");
    if ( pac_stage_yn.equals("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td>");

	//out.println("<td class='" + classValue + "' align='center'>");
	   
	i++;
} %>

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
%>
</center>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

