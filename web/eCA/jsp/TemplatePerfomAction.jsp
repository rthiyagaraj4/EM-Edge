<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
</head>
<body class="message" onKeyDown="lockKey()">
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<%
	
	String firstComponent		= request.getParameter("firstComponent")==null?"":request.getParameter("firstComponent");
	String secondComponent	= request.getParameter("secondComponent")==null?"":request.getParameter("secondComponent");
	String formulaResultUnit		= request.getParameter("formulaResultUnit")==null?"":request.getParameter("formulaResultUnit");
	String formulaCompID		= request.getParameter("formulaCompID")==null?"":request.getParameter("formulaCompID");
	String formula_result_type	= request.getParameter("formula_result_type")==null?"":request.getParameter("formula_result_type");
	String formula_operator		= request.getParameter("formula_operator")==null?"":request.getParameter("formula_operator");
	//out.println(firstComponent + "=" + secondComponent + "=" + formulaResultUnit + "=" + formulaCompID + "=" + formula_result_type + "=" + formula_operator);
	if(!firstComponent.equals("") && !secondComponent.equals(""))
	{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		
		StringBuffer qry = new StringBuffer();
		String formulaResult = "";
		try
		{		
			con = ConnectionManager.getConnection(request);
			if(formula_result_type.equals("N"))
			{
				if(formulaResultUnit.equals("Years"))
					qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))/12) FROM DUAL");
				else if (formulaResultUnit.equals("Months"))
					qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))) FROM DUAL");
				else if(formulaResultUnit.equals("Weeks"))
					qry.append("SELECT  trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))/7) FROM DUAL");
				else if(formulaResultUnit.equals("Days"))
					qry.append("SELECT trunc(TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI')) FROM DUAL");
				else if(formulaResultUnit.equals("Hours"))
					qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*24) FROM DUAL");
				else if(formulaResultUnit.equals("Minutes"))
					qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*1440) FROM DUAL");

				stmt = con.prepareStatement(qry.toString());
				stmt.setString(1, firstComponent);
				stmt.setString(2, secondComponent);
				rs = stmt.executeQuery();
				if(rs.next())
					formulaResult = rs.getString(1);

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
			}
			else if(formula_result_type.equals("D"))
			{
				if(formulaResultUnit.equals("Minutes") || formulaResultUnit.equals("Hours") || formulaResultUnit.equals("Days") || formulaResultUnit.equals("Weeks"))
				{
					qry.append("select to_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')");
					if(formula_operator.equals("MINUS"))
						qry.append("-");
					else
						qry.append("+");
					qry.append(" ? * DECODE(?,'Minutes',(1/1440),'Hours',(1/24),'Days',1,'Weeks',7,0 ), 'DD/MM/YYYY hh24:mi') from dual");
				}
				else
				{
					qry.append("SELECT  to_char(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");
					if(formula_operator.equals("MINUS"))
						qry.append("-");
					else
						qry.append("+");
					qry.append("? *(decode(?,'Years',12,1)) ),'dd/mm/yyyy hh24:mi') FROM DUAL");
				}				
				stmt = con.prepareStatement(qry.toString());
				stmt.setString(1, firstComponent);
				stmt.setString(2, secondComponent);
				stmt.setString(3, formulaResultUnit);				
				rs = stmt.executeQuery();
				if(rs.next())
					formulaResult = rs.getString(1);
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();				
				int index = formulaResult.lastIndexOf("00:00");
				if(index != -1)
				{
					StringBuffer temp = new StringBuffer(formulaResult);
					formulaResult = temp.substring(0, 10);
				}				
			}
			//out.println("formulaResult=" + formulaResult);
			out.println("<script>");
			out.println("if(parent.RecClinicalNotesTemplateFrame != null){");
			out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}else{");
			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}");
			out.println("</script>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception --->" + e);//COMMON-ICN-0181
		}
		finally
		{
			if(con != null)
				ConnectionManager.returnConnection(con,request);
		}
	}	
%>
</body>
</html>

