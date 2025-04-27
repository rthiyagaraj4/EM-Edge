<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<% 
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8");
    String facility_id = (String)session.getValue( "facility_id" ) ;
%>
<HTML>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
	</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
<%
	try{
	String whereClause = checkForNull(request.getParameter("whereclause"));
    String from = checkForNull(request.getParameter( "from" ),"1") ;
    String to = checkForNull(request.getParameter( "to" ),"14" ) ;
    String sql = " ";
    String component_desc_user_def =  request.getParameter("component_desc_user_def")==null?"":request.getParameter( "component_desc_user_def" ).toUpperCase();
	String ns_tooth_no = request.getParameter("ns_tooth_no")==null?"":request.getParameter( "ns_tooth_no" ).toUpperCase();
	String chart_code = request.getParameter("chart_code")==null?"":request.getParameter( "chart_code" ).toUpperCase();
	String status = checkForNull(request.getParameter( "status"));
    String tooth_numbering_system="";
	  if ( (whereClause == null || whereClause.equals("")) ) {

		int cnt=0;
		if ( !(chart_code == null || chart_code.equals("")) ){
	        sql = sql + " and upper(A.CHART_CODE ) like upper('"+chart_code +"%')";
			cnt++;
        }

		if ( !(component_desc_user_def == null || component_desc_user_def.equals("")) ){
			if(cnt>0)
				sql = sql + " and UPPER(A.COMPONENT_CODE) like upper('"+component_desc_user_def+"%')";
			else{
	        sql = sql + " and upper(A.COMPONENT_CODE ) like upper('"+component_desc_user_def +"%')";
			cnt=1;
			}
        }

        if ( !(ns_tooth_no == null || ns_tooth_no.equals("")) ){
			if(cnt>0){
				//sql = sql + " and UPPER(A.TOOTH_NO) like upper('"+ns_tooth_no+"%')";
				sql = sql + " and A.TOOTH_NO = '"+ns_tooth_no+"'";
			}else{
				//sql=sql+" and UPPER(A.TOOTH_NO) like upper('"+ns_tooth_no+"%')";
				sql=sql+" and A.TOOTH_NO = '"+ns_tooth_no+"'";
				cnt=1;
			}
        }
	   	if ( !(status == null || status.equals("")) ){
		  if( status.equals("Y") ){
			if(cnt>0)
			   sql = sql+" and nvl(required_yn,'Y')='Y' ";
			else{
				sql=sql+ " and  nvl(required_yn,'Y')='Y' ";
				cnt=1;
			}
         }

		 if ( status.equals("N") ){
            if(cnt>0)
			   sql = sql+" and required_yn='N'";
			else
				sql=sql+ "and  required_yn='N'";
         }

         if ( status.equals("B") ){
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

    int start = 0 ;
    int end = 0 ;
    int i=1;
	start = Integer.parseInt( from ) ;
	end = Integer.parseInt( to ) ;

	Connection conn  =  ConnectionManager.getConnection(request);

	PreparedStatement pstmt = null;
	PreparedStatement stmt = null;
	PreparedStatement stmt1 = null;
	int maxRecord = 0;
	ResultSet rset=null;
	ResultSet rst=null;
	ResultSet rs = null;
	String mode = "";
	//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
	String oh_chart_level = "";
	//
	try{
		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		//Based on the Chart Level the paramters need to be taken.
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
		pstmt = conn.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
		rs = pstmt.executeQuery();
		while (rs != null && rs.next()){
			oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
		}

		if(oh_chart_level.equals("E")){
			String sql1="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM";
			pstmt = conn.prepareStatement(sql1);
		}else{//End
			String sql1="SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?";
			conn  =  ConnectionManager.getConnection(request);
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,facility_id);
		}
	    rst = pstmt.executeQuery();
		while(rst.next()){
			tooth_numbering_system=rst.getString("TOOTH_NUMBERING_SYSTEM");
		}
		
		//String strsql="select count(*) as total from OH_PERIODONTAL_CHART_DEF_HDR WHERE LANGUAGE_ID =? "+sql;
		//String strsql1="Select chart_code, long_desc, short_desc, nvl(eff_status,'E') status from OH_PERIODONTAL_CHART_DEF_HDR Where LANGUAGE_ID = ? "+sql;
		String strsql="SELECT COUNT(*) AS TOTAL FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE   A.CHART_CODE = NVL(?,A.CHART_CODE) AND  A.COMPONENT_CODE 		= B.COMPONENT_CODE AND   (A.TOOTH_NO		= '*A'OR     A.TOOTH_NO		= C.TOOTH_NO) AND   C.NUMBERING_SYSTEM	= ? "+sql;
	//	String strsql1="SELECT CHART_CODE, CHART_DESC, NVL(EFF_STATUS,'E') STATUS FROM OH_PERIODONTAL_CHART_DEF_HDR "+sql;
		/*String strsql1="SELECT  B.COMPONENT_DESC_USER_DEF, C.NS_TOOTH_NO, A.REQUIRED_YN FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE        A.CHART_CODE = ? AND A.COMPONENT_CODE = B.COMPONENT_CODE AND   (A.TOOTH_NO = '*A' OR A.TOOTH_NO = C.TOOTH_NO) AND   C.NUMBERING_SYSTEM	= ? "+sql;*/
		String strsql1="SELECT  (SELECT  CHART_DESC  FROM OH_PERIODONTAL_CHART_DEF_HDR WHERE  CHART_CODE= A.CHART_CODE) CHART_DESC ,B.COMPONENT_DESC_USER_DEF, C.NS_TOOTH_NO, A.REQUIRED_YN FROM OH_PERIODONTAL_CHART_DEF_DTL2 A, OH_PERIODONTAL_CHART_COMP B, OH_TOOTH_BY_NUMBERING_SYSTEM C WHERE  A.CHART_CODE = NVL(?,A.CHART_CODE) AND A.COMPONENT_CODE = B.COMPONENT_CODE AND   (A.TOOTH_NO = '*A' OR A.TOOTH_NO = C.TOOTH_NO) AND   C.NUMBERING_SYSTEM	= ? "+sql;
 
//out.println(strsql1);
		stmt = conn.prepareStatement(strsql);
		stmt.setString(1,chart_code);
		stmt.setString(2,tooth_numbering_system);
		rs = stmt.executeQuery();
		rs.next();
		maxRecord = rs.getInt("TOTAL");
		

		if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));history.go(-1);</script>");
		}
		
		stmt1=conn.prepareStatement(strsql1);
		stmt1.setString(1,chart_code);
		stmt1.setString(2,tooth_numbering_system);
		rset = stmt1.executeQuery();
		
	}catch(Exception e){
		System.err.println("Error in PerioToothApplQueryResult.jsp "+e);
		out.println("Error in PerioToothApplQueryResult.jsp "+e);
	}
%>
<P>
<form name='QueryResult' id='QueryResult' >
<table align='right'>
<tr>
<td>
 <%
if ( !(start <= 1) )
	out.println("<A HREF='../jsp/PerioToothApplQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
	out.println("<A HREF='../jsp/PerioToothApplQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

%>
 

</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
    <td class="ColumnHeaderCenter">
		<fmt:message key="Common.ChartID.label" bundle="${common_labels}"/>
	</td> 
	<td class="ColumnHeaderCenter">
		<fmt:message key="Common.Component.label" bundle="${common_labels}"/>
	</td>
		
	<td class="ColumnHeaderCenter">
			<fmt:message key="eOH.ToothApplicable.Label" bundle="${oh_labels}"/>
	</td>

	<td class="ColumnHeaderCenter">
			<fmt:message key="eOH.Required?.Label" bundle="${oh_labels}"/>	
	</td> 
	
	<%
	   if ( start != 1 )
	     for( int j=1; j<start; i++,j++ )
	      rset.next() ;
			String classValue= " ";
		      while ( rset.next() && i<=end  ) {
			    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
					classValue = "QRYODD" ;
				out.println("<tr><td align=='left' class='" + classValue + "'>");
				String chart_desc = rset.getString("CHART_DESC");
				component_desc_user_def = rset.getString("COMPONENT_DESC_USER_DEF");
				ns_tooth_no=rset.getString("NS_TOOTH_NO");
				status= rset.getString("REQUIRED_YN");
				//String mode="modify";
				mode="modify";
			//	out.println("<a href='../../eOH/jsp/PeriodontalChartMain.jsp?mode="+mode+"&Component="+ Component+"' target='f_query_add_mod' >");
			//	out.println(chart_code+"</a></td>");
				out.println(chart_desc+"</td><td class='" + classValue + "'>");
				out.println(component_desc_user_def+"</td><td class='" + classValue + "'>");
				out.println(ns_tooth_no+"</td><td class='" + classValue + "'>");
				
				
				if (  rset.getString("REQUIRED_YN").equals("Y") || rset.getString("REQUIRED_YN").equals("null"))
				   out.println("<img src='../../eCommon/images/enabled.gif'></img>");
				else
					out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
				out.println("</td>");
				
				i++;
			}

%>

</td></tr>
</table>
</center>
<br>
<center>
<%
				if(stmt!=null)	stmt.close();
				if(stmt1!=null)	stmt1.close();
				if(rs!=null)	rs.close();
				if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception e)
		{
			System.err.println("Error in PerioToothApplQueryResult "+e);
			out.println("Error in PerioToothApplQueryResult "+e);
		}
%>
</center>
</form>
</BODY>
</HTML>

