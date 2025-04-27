<!DOCTYPE html>
  <%@ page import="java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- ****  Modified by kishor kumar n on 04/12/2008 for crf0387 applied new css grid. **** -->
		
		
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   	<%
      	String patient_id = request.getParameter("patient_id");
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) p.getProperty("LOCALE");
		String called_from_ip = request.getParameter("called_from_ip")==null?"N":request.getParameter("called_from_ip");
   	%>
      	<script>
      	var srl_no_array = new Array();
      	var prev=0;
      	var i=0;
      	function rfresh(high_risk_code)
      	{
			if("<%=called_from_ip%>" == "Y"){
				parent.parent.PatAlertQueryResult.location.href='../../eCA/jsp/PatAlertQueryResult.jsp?&call_from=high_risk&srl_no='+srl_no_array[prev]+'&patient_id=<%=patient_id%>'+'&high_risk_code='+high_risk_code+'&called_from_ip=<%=called_from_ip%>';
			}else{
				top.content.workAreaFrame.PatAlertQueryResult.location.href='../../eCA/jsp/PatAlertQueryResult.jsp?&call_from=high_risk&srl_no='+srl_no_array[prev]+'&patient_id=<%=patient_id%>'+'&high_risk_code='+high_risk_code+'&called_from_ip=<%=called_from_ip%>';
			}
      	}

      	function refer(ro)
      	{
      		prev=ro.rowIndex;

      	}
      	</script>
</head>
<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
//	Connection conn = (Connection) session.getValue( "connection" ) ;
    Connection conn=null;
//	Statement stmt		=null;
	PreparedStatement stmt=null;
	ResultSet rs		=null;
	
	String sql="";
	int k=1;
	String radio_par=request.getParameter("radio_par");
	if(radio_par==null)
		radio_par="A";
	if (radio_par.equals("A"))
	{
		sql= " and close_date is null ";
	}
%>

<table name="description" id="description" class='grid' width="100%">
<form name=fr>
<%
try
{
	conn=ConnectionManager.getConnection(request);
		StringBuffer strsql =new StringBuffer();
		strsql.append("Select srl_no,MR_GET_DESC.MR_HIGH_RISK(HIGH_RISK_CODE,?,'1') long_desc,HIGH_RISK_CODE from pr_high_risk_condition_vw where patient_id=?" );
		strsql.append(sql);
		strsql.append(" order by 1");
		stmt = conn.prepareStatement(strsql.toString());
		stmt.setString(1,locale);
		stmt.setString(2,patient_id);
		rs = stmt.executeQuery();

		while(rs.next())
		{
			out.println("<tr onclick='javascript:refer(this)'><td class='gridData'>");
%>
			<script>
		   	srl_no_array[i] = <%=rs.getString("srl_no")%>
		   	i++;
      		</script>
<%
			out.println("<input type='hidden' name='srl_no' id='srl_no' value='"+rs.getString("srl_no")+"'>");
			out.println("<a class='gridLink' href='javascript:rfresh(\""+rs.getString("HIGH_RISK_CODE")+"\")'>");
			out.println(rs.getString("long_desc")+"</a></font></td>");
			k++;
		}

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e)
{
			//out.println("Exception @ PatAlertQueryHighRiskDesc "+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		
}
finally 
{
			
			if (conn != null) ConnectionManager.returnConnection(conn,request); 
}
%>
</form>
</table>
</body>
</html>

