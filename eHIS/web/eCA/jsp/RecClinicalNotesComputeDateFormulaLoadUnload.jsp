<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------
11/04/2017  IN061905       	DineshT     25/4/2016		Ramesh G   		The Scoring functionality In Notes should work in the 																			similar manner as in Charts i.e on selection of 																				individual variable, the score gets automatically 																				calculated.
15/04/2017	IN063963		DineshT		25/4/2016		Ramesh G 		ML-MMOH-CRF-0557_UT2
08/05/2017	IN063962		Dinesh T									ML-MMOH-CRF-0557_UT1
--------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,java.util.Hashtable" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;

try
{
	java.util.Properties p = (java.util.Properties) session.getValue("jdbc");
	Hashtable hash = (Hashtable)XMLobj.parseXMLString(request) ;

	hash = (Hashtable)hash.get("SEARCH") ;
	String locale = (String) p.getProperty("LOCALE");
	String firstComponent = (String)hash.get("firstComponent");
	String secondComponent = (String)hash.get("secondComponent");
	String formulaResultUnit = (String)hash.get("formulaResultUnit");
	String formula_result_type = (String)hash.get("formula_result_type");
	String formula_operator = (String)hash.get("formula_operator");
	String l_sys_date_time_in_en_yn = (String)hash.get("sysDateTimeInEnYN");//IN063962
	
	StringBuilder qry = new StringBuilder();
	String formulaResult = "";
	String temp_secondComponent ="";
	
	con = ConnectionManager.getConnection(request);

	if(!"".equals(firstComponent) && !"".equals(secondComponent))
	{
		if("N".equals(formula_result_type))
		{
			if("Years".equals(formulaResultUnit))
				qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))/12) FROM DUAL");
			else if ("Months".equals(formulaResultUnit))
				qry.append("SELECT  round(months_between(TO_DATE(?,'DD/MM/YYYY HH24:MI') , TO_DATE(?,'DD/MM/YYYY HH24:MI'))) FROM DUAL");
			else if("Weeks".equals(formulaResultUnit))
				qry.append("SELECT  trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))/7) FROM DUAL");
			else if("Days".equals(formulaResultUnit))
				qry.append("SELECT trunc(TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI')) FROM DUAL");
			else if("Hours".equals(formulaResultUnit))
				qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*24) FROM DUAL");
			else if("Minutes".equals(formulaResultUnit))
				qry.append("SELECT trunc((TO_DATE(?,'DD/MM/YYYY HH24:MI') - TO_DATE(?,'DD/MM/YYYY HH24:MI'))*1440) FROM DUAL");

			//temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");	
			String dateTime[] = secondComponent.split(" ");//IN063962
			if(dateTime.length==1){
				temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMY", locale, "en");
			}else{
				temp_secondComponent = com.ehis.util.DateUtils.convertDate(secondComponent, "DMYHM", locale, "en");
			}

			stmt = con.prepareStatement(qry.toString());
			stmt.setString(1, firstComponent);
			stmt.setString(2, temp_secondComponent);
			rs = stmt.executeQuery();
			
			if(rs.next())
				formulaResult = rs.getString(1)==null?"": rs.getString(1);

			if(rs!=null) 
				rs.close();

			if(stmt!=null) 
				stmt.close();
		}
		else if("D".equals(formula_result_type))
		{
			String dateTime[] = firstComponent.split(" ");//IN063962

			if("Minutes".equals(formulaResultUnit) || "Hours".equals(formulaResultUnit) || "Days".equals(formulaResultUnit) || "Weeks".equals(formulaResultUnit))
			{
				qry.append("select to_CHAR(TO_DATE(?,'DD/MM/YYYY HH24:MI')");

				if("MINUS".equals(formula_operator))
					qry.append("-");
				else
					qry.append("+");

				qry.append(" ? * DECODE(?,'Minutes',(1/1440),'Hours',(1/24),'Days',1,'Weeks',7,0 ), 'DD/MM/YYYY HH24:MI') from dual");
			}
			else
			{
				qry.append("SELECT  to_char(add_months(TO_DATE(?,'DD/MM/YYYY HH24:MI'), ");

				if("MINUS".equals(formula_operator))
					qry.append("-");
				else
					qry.append("+");
				qry.append("? *(decode(?,'Years',12,1)) ),'DD/MM/YYYY HH24:MI') FROM DUAL");
			}

			stmt = con.prepareStatement(qry.toString());
			stmt.setString(1, firstComponent);
			stmt.setString(2, secondComponent);
			stmt.setString(3, formulaResultUnit);				
			rs = stmt.executeQuery();
			
			if(rs.next())
				formulaResult = rs.getString(1);

			if(rs!=null) 
				rs.close();

			if(stmt!=null) 
				stmt.close();
			
			//IN063962, starts
			/*int index = formulaResult.lastIndexOf("00:00");
			if(index != -1)
			{
				StringBuffer temp = new StringBuffer(formulaResult);
				formulaResult = temp.substring(0, 10);
			}*/
			if(dateTime.length == 1)
			{
				formulaResult = formulaResult.substring(0, 10);

				if("Y".equals(l_sys_date_time_in_en_yn))
					formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMY", "en",locale);
			}
			else
			{
				if("Y".equals(l_sys_date_time_in_en_yn))
					formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMYHM", "en",locale);
			}
			//IN063962, ends
		}

		//formulaResult = com.ehis.util.DateUtils.convertDate(formulaResult, "DMY", "en",locale);
		out.println(formulaResult);
	}
}
catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(rs!=null)
		rs.close();

	if(stmt!=null)
		stmt.close();

	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}
%>
