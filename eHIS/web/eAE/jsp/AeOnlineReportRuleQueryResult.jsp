<!DOCTYPE html>
    <script language='javascript' src='../../eCommon/js/common.js'></script>
	<%@ page import = "webbeans.eCommon.ConnectionManager,java.sql.*,java.util.*,java.net.*,java.text.*" contentType="text/html;charset=UTF-8"%>
	<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

	<HTML><head>
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=
     (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head><BODY  class='CONTENT' onLoad='ClearMsg();' onMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>

<%


	Connection conn = null;

    String facilityId=(String)session.getValue("facility_id");
    String whereClause = request.getParameter("whereclause");
    
    if(whereClause==null||whereClause.equals("null"))
       whereClause="";

	StringBuffer sql = new StringBuffer("");
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;

    if ( (whereClause == null || whereClause.equals("")) )
    {
	    String clinicCode = request.getParameter("clinic_code");
		String shortdesc = request.getParameter("clinic_desc");
	    String visitTypeCode = request.getParameter("Visit_Type_Code");
		String VisitTypeShortDesc = request.getParameter("Visit_Type_short_desc");
	    String reportId = request.getParameter("report_id");
		String reportDesc = request.getParameter("report_desc");
	    String printatciyn = request.getParameter("print_at_ci_yn");

		if ( !(clinicCode == null || clinicCode.equals("")) )
        {
			sql.append("and  upper(CLINIC_CODE) like upper('"+clinicCode+"%')");
        }

	    if ( !(shortdesc == null || shortdesc.equals("")) )
        {
	        sql.append("and upper(CLINIC_DESC) like  upper('"+shortdesc+"%')");
        }

	    if ( !(visitTypeCode == null || visitTypeCode.equals("")) )
        {
			sql.append("and  upper(VISIT_TYPE_CODE) like upper('"+visitTypeCode+"%')");
        }

	    if ( !(VisitTypeShortDesc == null || VisitTypeShortDesc.equals("")) )
        {
			sql.append("and  upper(VISIT_TYPE_SHORT_DESC) like upper('"+VisitTypeShortDesc+"%')");
        }

	    if ( !(reportId == null || reportId.equals("")) )
        {
			sql.append("and  upper(REPORT_ID) like upper('"+reportId+"%')");
        }

	    if ( !(reportDesc == null || reportDesc.equals("")) )
        {
			sql.append("and  upper(REPORT_DESC) like upper('"+reportDesc+"%')");
        }

        if(! ( printatciyn == null || printatciyn.equals("") || printatciyn.equals("A") ))
        {
			sql.append("and PRINT_YN='"+printatciyn+"'");
        }  
    
    }

    //appending order by clause
    
	String ord[] = request.getParameterValues("orderbycolumns");
    
    if ( !(ord == null || ord .equals("") || ord.equals("null")) )
    {
		sql.append(" order by ");

        for ( int i=0;i < ord.length;i++ )
        {
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
	        else
		        sql.append(ord[i]+",");
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

	PreparedStatement pstmt=null;
	ResultSet rs=null;

	try
	{
		conn = ConnectionManager.getConnection(request);

		/* The following query is used to search for the records in the database table AE_ONLINE_REPORT_VW  for the corresponding facility id and for 'AE' module along with the clinic Code, visitType, report Id etc. including all or combination of these values ---  Srijagadeesh. */
		
		String strsql2="select  CLINIC_CODE, VISIT_TYPE_CODE, MODULE_ID, REPORT_ID, PRINT_YN, REPORT_DESC, VISIT_TYPE_SHORT_DESC,CLINIC_DESC  from  AE_ONLINE_REPORT_VW where  OPERATING_FACILITY_ID='"+facilityId+"' and module_id in ('AE' ,'MP','OP','FM') "+sql;

	    pstmt = conn.prepareStatement(strsql2);
		rs = pstmt.executeQuery();
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

		<P>
		<table align='right'>
		<tr>
		<td>
<%
		if ( !(start <= 1) )
	    out.println("<A HREF='../../eAE/jsp/AeOnlineReportRuleQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if (endOfRes.equals("1"))
		out.println("<A id='nextvalue' HREF='../../eAE/jsp/AeOnlineReportRuleQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
		</td>
		</tr>
		</table>
		<br><br>
		</P>

		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<th><fmt:message key="Common.locationcode.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.LocationDesc.label" bundle="${common_labels}"/></th> 
			<th><fmt:message key="Common.visittype.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.VisitTypeDescription.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ReportID.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.ReportDesc.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.PrintApplicability.label" bundle="${common_labels}"/></th>

<%}

			    if ( i % 2 == 0 )
			        classValue = "QRYEVEN" ;
			    else
			        classValue = "QRYODD" ;

			    out.println("<tr><td class='" + classValue + "'>");

			    String clinic_Code = rs.getString("CLINIC_CODE");
			    String short_desc = rs.getString("CLINIC_DESC");
			    String visitType_Code = rs.getString("VISIT_TYPE_CODE");
			    String VisitType_ShortDesc = rs.getString("VISIT_TYPE_SHORT_DESC");
			    String report_Id = rs.getString("REPORT_ID");
			    String report_Desc = rs.getString("REPORT_DESC");
			    String Printatciyn = rs.getString("PRINT_YN");


			    out.println("<a href='../../eAE/jsp/addModifyAeOnlineReportRule.jsp?locationcode="+URLEncoder.encode(clinic_Code)+"&locationdesc="+URLEncoder.encode(short_desc)+"&visittype="+URLEncoder.encode(visitType_Code)+"&visittypename="+URLEncoder.encode(VisitType_ShortDesc)+"&reportid="+URLEncoder.encode(report_Id)+"&reportname="+URLEncoder.encode(report_Desc)+"'  target='f_query_add_mod' >");
			    out.println(clinic_Code+"</a></td><td class='" + classValue + "'>");
    
				out.println(short_desc+"</td><td class='" + classValue + "'>");
    
				out.println("<a href='../../eAE/jsp/addModifyAeOnlineReportRule.jsp?locationcode="+URLEncoder.encode(clinic_Code)+"&locationdesc="+URLEncoder.encode(short_desc)+"&visittype="+URLEncoder.encode(visitType_Code)+"&visittypename="+URLEncoder.encode(VisitType_ShortDesc)+"&reportid="+URLEncoder.encode(report_Id)+"&reportname="+URLEncoder.encode(report_Desc)+"'  target='f_query_add_mod' >");
			    out.println(visitType_Code+"</a></td><td class='" + classValue + "'>");
    
				out.println(VisitType_ShortDesc+"</td><td class='" + classValue + "'>");
    
				out.println("<a href='../../eAE/jsp/addModifyAeOnlineReportRule.jsp?locationcode="+URLEncoder.encode(clinic_Code)+"&locationdesc="+URLEncoder.encode(short_desc)+"&visittype="+URLEncoder.encode(visitType_Code)+"&visittypename="+URLEncoder.encode(VisitType_ShortDesc)+"&reportid="+URLEncoder.encode(report_Id)+"&reportname="+URLEncoder.encode(report_Desc)+"'   target='f_query_add_mod' >");
			    out.println(report_Id+"</a></td><td class='" + classValue + "'>");
    
				out.println(report_Desc+"</td><td class='" + classValue + "' align='center'>");
    
				if ( Printatciyn.equals("Y") )
				    out.println("<img src='../../eCommon/images/enabled.gif'></img>");
			    else
			        out.println("<img src='../../eCommon/images/disabled.gif'></img>");
    
			    out.println("</td>");
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
	}catch(Exception e) {e.printStackTrace();}

	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null)    rs.close();
		  ConnectionManager.returnConnection(conn,request); 
	}

%>
</td></tr>
</table>
<br>
</BODY>
</HTML>

