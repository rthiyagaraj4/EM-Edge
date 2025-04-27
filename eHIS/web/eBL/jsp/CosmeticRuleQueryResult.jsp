<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>

<HTML>
	<head>
	<%!
	private String trimString(String input){
		String output = "";
		if(input == null){
			input = "";
		}
		else{
			output = input.trim();
		}
		return output;
	}
	
	private String checkForNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
	%>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
String mode="modify";
PreparedStatement stmt = null;
PreparedStatement stmt1 = null;
ResultSet rset=null;
ResultSet rs = null;
Connection conn = null;

try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
    String from = request.getParameter( "from" ) ;
    String to = request.getParameter( "to" ) ;
    String sql = " ";
    String patientClass = trimString(request.getParameter("patientClass"));
	String ruleCode = trimString(request.getParameter("ruleCode"));
	String blngGroupCode = trimString(request.getParameter("blngGroupCode"));
	String custGrpCode = trimString(request.getParameter("custGrpCode"));
	String custCode = trimString(request.getParameter("custCode"));
	String policyCode = trimString(request.getParameter("policyCode"));
	String status = "";
	String seqNo = "";
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if (!"".equals(patientClass) && !"**".equals(patientClass)){
	        sql = sql + " and upper(PATIENT_CLASS) like upper('"+patientClass+"')";
			cnt++;
        }

		if(!"".equals(ruleCode)){
			sql=sql+" and upper(RULE_CODE) like upper('"+ruleCode+"')";
			cnt++;
		}

		if(!"".equals(blngGroupCode)){
			sql=sql+" and upper(BILLING_GROUP_CODE) like upper('"+blngGroupCode+"')";
			cnt++;
		}
		
		if(!"".equals(custGrpCode)){
			sql=sql+" and upper(CUSTOMER_GROUP_CODE) like upper('"+custGrpCode+"')";
			cnt++;
		}
		
		if(!"".equals(custCode)){
			sql=sql+" and upper(CUSTOMER_CODE) like upper('"+custCode+"')";
			cnt++;
		}
		
		if(!"".equals(policyCode)){
			sql=sql+" and upper(POLICY_TYPE_CODE) like upper('"+policyCode+"')";
			cnt++;
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

conn  =  ConnectionManager.getConnection(request);


int maxRecord = 0;


	try{
		
		String strsql="select count(*) as total "+
				"from BL_SERV_RULE_CODE_HDR  "+
				"where operating_facility_id = '"+facility_id+"' "+sql;
		String strsql1=	"select SEQ_NO,RULE_CODE,PATIENT_CLASS,BILLING_GROUP_CODE,CUSTOMER_GROUP_CODE, "+
				"CUSTOMER_CODE,POLICY_TYPE_CODE,NVL(STATUS,'D') STATUS "+
				"from BL_SERV_RULE_CODE_HDR  "+
				"where operating_facility_id = '"+facility_id+"'  "+sql;

		System.err.println("strsql1->"+strsql1);
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
		System.err.println("Exception in inside try block of CosmeticRuleQueryResult "+e);
	}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eBL/jsp/CosmeticRuleQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eBL/jsp/CosmeticRuleQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.RuleCode.label" bundle="${bl_labels}"/>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.PatientClass.label" bundle="${bl_labels}"/>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.BillingGroup.label" bundle="${bl_labels}"/>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.CUSTOMER_GROUP.label" bundle="${bl_labels }"></fmt:message>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.Customer.label" bundle="${bl_labels }"></fmt:message>
</td>
<td class="columnheadercenter" nowrap> 
	<fmt:message key="eBL.POLICY_TYPE.label" bundle="${bl_labels}"/>
</td>

<%
	int mOrder = 0;
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ;  
                else
            classValue = "gridData" ; 
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");
    
	ruleCode = rset.getString("RULE_CODE");
	patientClass =rset.getString("PATIENT_CLASS");
	blngGroupCode = rset.getString("BILLING_GROUP_CODE");
	custGrpCode =rset.getString("CUSTOMER_GROUP_CODE");
	custCode = rset.getString("CUSTOMER_CODE");
	policyCode=rset.getString("POLICY_TYPE_CODE");
    status = rset.getString("STATUS");
	seqNo = rset.getString("SEQ_NO");
    

	out.println("<a href='../../eBL/jsp/CosmeticRuleMainFrame.jsp?mode=modify&seqNo="+ seqNo+
				"' target='CosmeticRuleFrame' >");
    out.println(ruleCode+"</a></td>");
		
    out.println("<td class='" + classValue+"' nowrap>"+checkForNull(patientClass)+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+checkForNull(blngGroupCode)+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+checkForNull(custGrpCode)+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+checkForNull(custCode)+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+checkForNull(policyCode)+"</td>");
    
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%

}
catch(Exception e)
{
	System.err.println("Exception in CosmeticRuleQueryResult -> "+e);
}
finally{
	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
	if(rset!=null) rset.close();
	ConnectionManager.returnConnection(conn,request);
}
%>

</center>
</form>
</BODY>
</HTML>

