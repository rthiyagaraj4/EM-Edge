<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<HTML>
<head>
	<script language='javascript' src='../../eCA/js/RiskFactorGroup.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%
    request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String term_set_id  = request.getParameter("term_set_id") == null? "" : request.getParameter("term_set_id").trim() ;
    String term_set_code = request.getParameter("term_set_code") == null? "" : request.getParameter("term_set_code").trim() ;
	
	term_set_code = term_set_code.toUpperCase();
	System.out.println("28. CAHealthRiskFactorsForDiseaseQueryResult.jsp TERM SET ID " + term_set_id );
	
	System.out.println(" 29. CAHealthRiskFactorsForDiseaseQueryResult.jsp TERM SET CODE " +  term_set_code);
	
	
   
    String risk_grp_type= request.getParameter("risk_grp_type");
	if ( (whereClause == null || whereClause.equals("")) )
    {	
		if ( !(term_set_id == null || term_set_id.equals("")) )
        {	 
			sql.append(" where upper(GD.TERM_SET_ID) like upper('"+term_set_id+"%')");
        }

        if ( !(term_set_code == null || term_set_code.equals("")) )
        {		if(term_set_id == null || term_set_id.equals("")){
					sql.append(" where upper(GD.TERM_SET_CODE) like upper('"+term_set_code+"%')");
				}
				else
				{
					sql.append(" and upper(GD.TERM_SET_CODE) like upper('"+term_set_code+"%')");
				}	
        }  
	/*	if ( !(risk_grp_type == null || risk_grp_type.equals("")) )
		{	if((term_set_code == null || term_set_code.equals("")) && (term_set_id == null || term_set_id.equals("")))
			{
				 if( risk_grp_type.equals("I") )
					   sql.append(" where RISK_GRP_TYPE='I'");
				 
				 if ( risk_grp_type.equals("G") )
					   sql.append(" where RISK_GRP_TYPE='G'");
			}
			else {
				 if( risk_grp_type.equals("I") )
					   sql.append(" and RISK_GRP_TYPE='I'");
				 
				 if ( risk_grp_type.equals("G") )
					   sql.append(" and RISK_GRP_TYPE='G'");
			}
	   } */
    
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

    }else
		 sql.append(whereClause);

    int start = 0 ;
    int end = 0 ;
    int i=1;

    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null ){
		String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
		end =  Integer.parseInt(MstQryPageCnt);
	}
    else
        end = Integer.parseInt( to ) ;

Connection conn  = null;
PreparedStatement pstmt;
ResultSet rs = null;

int maxRecord = 0;
System.out.println(" WHERE CONDITON " + sql.toString());  
//String strsql1="SELECT distinct GD.TERM_SET_ID,GD.TERM_SET_CODE, decode(GD.RISK_GRP_TYPE, 'I','Individual','G','Group') RISK_GRP_TYPE,(SELECT TERM_SET_DESC FROM mr_term_set WHERE term_set_id = gd.TERM_SET_ID) term_set_desc, (SELECT short_desc FROM mr_term_code WHERE term_set_id = gd.TERM_SET_ID and term_code = gd.TERM_SET_CODE) diag_code_desc FROM CA_DIAG_RISK_FACTOR GD " +sql.toString();
//String strsql1="SELECT GD.TERM_SET_ID,GD.TERM_SET_CODE,decode(GD.RISK_GRP_TYPE, 'I','Individual','G','Group') RISK_GRP_TYPE,(SELECT TERM_SET_DESC FROM mr_term_set WHERE term_set_id = gd.TERM_SET_ID) term_set_desc, (SELECT short_desc FROM mr_term_code WHERE term_set_id = gd.TERM_SET_ID and term_code = gd.TERM_SET_CODE) diag_code_desc FROM CA_DIAG_RISK_FACTOR GD " +sql.toString();
String strsql1="SELECT GD.TERM_SET_ID,(SELECT TERM_SET_DESC FROM mr_term_set WHERE term_set_id = gd.TERM_SET_ID) term_set_desc,GD.TERM_SET_CODE, (SELECT short_desc FROM mr_term_code WHERE term_set_id = gd.TERM_SET_ID and term_code = gd.TERM_SET_CODE) diag_code_desc,GD.RISK_GRP_TYPE,GD.RISK_FACTOR, case when RISK_GRP_TYPE = 'G' then  (select RISK_FACTOR_DESC from CA_GROUP_RISK_FACTOR_TYPE where  RISK_FACTOR_GROUP = RISK_FACTOR) when RISK_GRP_TYPE = 'I' then (select RISK_FACTOR_DESC from CA_RISK_FACTOR_TYPE where  RISK_FACTOR_TYPE = RISK_FACTOR) END risk_factor_desc FROM CA_DIAG_RISK_FACTOR GD  " +sql.toString();

System.out.println(" STRING SQL  " +  strsql1);
try
{
	conn 	= ConnectionManager.getConnection(request);
	pstmt	= conn.prepareStatement(strsql1,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	rs		= pstmt.executeQuery();
	
	while(rs.next())
	{
		maxRecord++;
	}
	if(maxRecord == 0)
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
	}
	%>
	<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
		<tr>
			<td class='white' width='100%'></td> 
			<td  width='25%' nowrap>
			<%
				String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
				int pageCnt = Integer.parseInt(MstQryPageCnt);
			if ( !(start <= 1) )
				out.println("<A class='gridLink' HREF='../../eCA/jsp/CAHealthRiskFactorsForDiseaseQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

			if ( !( (start+pageCnt) > maxRecord ) )
				out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/CAHealthRiskFactorsForDiseaseQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
			</td>
		</tr>
	</table>

	<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
	<tr>			
		<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='15%'>Term Set Desc</td>
		<td class='COLUMNHEADERCENTER' width='12%'><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADERCENTER' width='28%'>Diagnosis Desc</td>
		<td class='COLUMNHEADERCENTER' width='12%'><fmt:message key="eCA.riskfactor.label" bundle="${ca_labels}"/></td> 
		<td class='COLUMNHEADERCENTER' width='18%'><fmt:message key="eCA.riskfactor.label" bundle="${ca_labels}"/> Desc</td> 
		<td class='COLUMNHEADERCENTER' width='5%'><fmt:message key="Common.type.label" bundle="${common_labels}"/></td> 
	</tr>
	<%
	rs.beforeFirst();

	if ( start != 1 )
		for( int j=1; j<start; i++,j++ )
			rs.next() ;
	String classValue= " ";
	while ( rs.next() && i<=end  ){
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr>");
		//out.println("<td class='gridData'>");
			String term_set_id_	=(rs.getString("TERM_SET_ID")==null)?"":rs.getString("TERM_SET_ID");
			String term_set_desc_	=(rs.getString("term_set_desc")==null)?"":rs.getString("term_set_desc");
			String term_set_code_	 =(rs.getString("TERM_SET_CODE")==null)?"":rs.getString("TERM_SET_CODE");		
			String diag_code_desc_	=(rs.getString("diag_code_desc")==null)?"":rs.getString("diag_code_desc");
			String risk_grp_type_		=(rs.getString("RISK_GRP_TYPE")==null)?"":rs.getString("RISK_GRP_TYPE");
			String	risk_fact_code_	=(rs.getString("RISK_FACTOR")==null)?"":rs.getString("RISK_FACTOR");
			String risk_fact_desc_	=(rs.getString("risk_factor_desc")==null)?"":rs.getString("risk_factor_desc");
			if(risk_grp_type_.equals("I")) {
				risk_grp_type_ = "Individual";
			}
			else {
				risk_grp_type_ = "Group";
			}	
//out.println("<a class='gridLink' href='../../eCA/jsp/AddModifyHealthRiskFactorsForDisease.jsp?mode=2&term_set_id="+ URLEncoder.encode(term_set_id_)+"&term_set_desc="+ URLEncoder.encode(term_set_desc_)+"&term_set_code="+ URLEncoder.encode(term_set_code_)+"&diag_code_desc="+ URLEncoder.encode(diag_code_desc_)+"'target='f_query_add_mod' >");
		out.println("<td class='gridData'>");
		//out.println(term_set_id_ + "</a></td>");
		out.println(term_set_id_ + "</td>");
		out.println("<td class='gridData'>");
		out.println(term_set_desc_);
		out.println("</td>");
		out.println("<td class='gridData'>");
		out.println(term_set_code_);
		out.println("</td>");
		out.println("<td class='gridData'>");
		out.println(diag_code_desc_);
		out.println("</td>");
		out.println("<td class='gridData'>");	 
		out.println(risk_fact_code_); 
		out.println("</td>");
		out.println("<td class='gridData'>");	 
		out.println(risk_fact_desc_); 
		out.println("</td>");
		out.println("<td class='gridData'>");	 
		out.println(risk_grp_type_); 
		out.println("</td>");
		out.println("</tr>"); 
		
		i++;
	} 
	%>
	</table>
	<br>
	<center>
	<%
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

}catch(Exception e){
	//out.println("Exception from CAHealthRiskFactorsForDiseaseQueryResult JSP : "+e.getMessage());//COMMON-ICN-0181
	e.printStackTrace();	
}finally{
	if (conn != null) 
		ConnectionManager.returnConnection(conn,request);
}

%>
	</center>
</BODY>
</HTML>

