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
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String facility_id = (String)session.getAttribute("facility_id");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
</head>
<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
<%
try{
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String sql = " ";
	String payerGroup = request.getParameter("payerCode2")==null?"":request.getParameter( "payerCode2" ).trim().toUpperCase();
	String payer =request.getParameter("payerCode")==null?"":request.getParameter( "payerCode" ).trim().toUpperCase();
	String policyType =request.getParameter("policyTypeCode")==null?"":request.getParameter( "policyTypeCode" ).trim().toUpperCase();
	String payerGroupCode = "";
	String payerCode = "";
	String policyCode = "";
	String startDate = "";
	String endDate = "";
	
	if ( (whereClause == null || whereClause.equals("")) )
    {
	int cnt=0;

		if ( !(payerGroup == null || payerGroup.equals("")) ){
	        sql = sql + " and upper(hdr.CUST_GROUP_CODE) like upper('"+payerGroup +"%')";
			cnt++;
        }

        if ( !(payer == null || payer.equals("")) ){

				sql=sql+" and upper(hdr.CUST_CODE) like '"+payer+"%'";
				cnt=1;
        }
        
        if ( !(policyType == null || policyType.equals("")) ){

				sql=sql+" and upper(hdr.POLICY_TYPE_CODE) like '"+policyType+"%'";
				cnt=2;

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
		
		String strsql="select count(*) as total "+
				"from bl_ins_policy_type_hdr hdr "+
				"where hdr.operating_facility_id = '"+facility_id+"' "+sql;
	/*	String strsql1=	"select hdr.CUST_GROUP_CODE, "+
				"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+
				"hdr.CUST_CODE, "+
				"decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
				"hdr.POLICY_TYPE_CODE, "+
				"(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id )  policy_type,  to_char(hdr.policy_eff_from,'dd/mm/yyyy') effective_from,to_char(hdr.policy_eff_to,'dd/mm/yyyy') effective_to  "+
				"from bl_ins_policy_type_hdr hdr "+
				"where hdr.operating_facility_id = '"+facility_id+"'  "+sql;   */
				
		//Modified against NMC-JD-CRF-0045--14-08-2020
		String strsql1=	"select hdr.CUST_GROUP_CODE, "+
				"decode(hdr.CUST_GROUP_CODE,'**','All Payer Group',(select grp.long_desc from ar_cust_group grp where grp.cust_group_code =  hdr.cust_group_code  )) payer_group, "+
				"hdr.CUST_CODE, "+
				"decode(hdr.CUST_CODE,'**','All Payer',(select cust.long_name from ar_customer cust where  cust.cust_code  = hdr.cust_code )) payer, "+
				"hdr.POLICY_TYPE_CODE, "+
				"decode(hdr.POLICY_TYPE_CODE,'**','All Policy',(select pol.long_desc policy_type from bl_ins_policy_types pol where pol.policy_type_code = hdr.policy_type_code AND pol.operating_facility_id  = hdr.operating_facility_id ))  policy_type,  to_char(hdr.policy_eff_from,'dd/mm/yyyy') effective_from,to_char(hdr.policy_eff_to,'dd/mm/yyyy') effective_to  "+
				"from bl_ins_policy_type_hdr hdr "+
				"where hdr.operating_facility_id = '"+facility_id+"'  "+sql;

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
		//out.println("sdfsadfs "+e);
		e.printStackTrace();
	}
%>
<form name='QueryResult' id='QueryResult'>

<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eBL/jsp/PolicyDefinitionQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause=" + URLEncoder.encode(sql) + "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eBL/jsp/PolicyDefinitionQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>
<fmt:setLocale value="<%=locale %>"/>
<fmt:setBundle basename="eDSN.resources.Labels" var="dl_labels"/>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='0' align='center'>
<th class="columnheadercenter" nowrap style="text-align:left;"> 
	Policy Type Code
</th>
<th class="columnheadercenter" nowrap style="text-align:left;"> 
	Policy Type Description
</th>
<th class="columnheadercenter" nowrap style="text-align:left;"> 
	Payer Group Code
</th>
<th class="columnheadercenter" nowrap style="text-align:left;"> 
	Payer Group Description
</th>
<th class="columnheadercenter" nowrap style="text-align:left;"> 
	Payer Code
</th>
<th class="columnheadercenter" nowrap style="text-align:left;"> 
	Payer Description
</th>

<%
	int mOrder = 0;
   if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
      while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "gridData" ;  // changed by yadav
                else
            classValue = "gridData" ;  // changed by yadav
    out.println("<tr><td align=='left' class='" + classValue + "' nowrap>");
    
	payerGroup = rset.getString("payer_group");
	payerGroupCode=rset.getString("CUST_GROUP_CODE");
	payer = rset.getString("payer");
	payerCode=rset.getString("CUST_CODE");
	policyType = rset.getString("policy_type");
	policyCode=rset.getString("POLICY_TYPE_CODE");
    startDate = rset.getString("effective_from");
    endDate = rset.getString("effective_to");
	
	String mode="modify";
	out.println("<a href='../../eBL/jsp/PolicyDefinitionMainFrame.jsp?mode=modify&payergroupCode="+ payerGroupCode+"&payerCode="+payerCode+"&policyCode="+policyCode+"&startDate="+startDate+"&endDate="+endDate+"' target='PolicyDefinitionMainFrame' >");
    out.println(policyCode+"</a></td>");
    out.println("<td class='" + classValue+"' nowrap>"+policyType+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+payerGroupCode+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+payerGroup+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+payerCode+"</td>");
    out.println("<td class='" + classValue+"' nowrap>"+payer+"</td>");
    
	i++;
} %>

</td></tr>
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
	//out.println("here "+e);
	e.printStackTrace();
}
%>

</center>
</form>
</BODY>
</HTML>

