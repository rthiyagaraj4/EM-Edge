<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
--------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
14/12/2012		IN030681		ChowminyaG		ARTIMIS:The formula logic which is used to calculate certain values in the notes is not working
28/04/2017		INC61905		Dinesh T		The Scoring functionality In Notes should work in the similar manner as in 														Charts i.e on selection of individual variable, the score gets automatically 													calculated
--------------------------------------------------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
08/05/2017	IN063962		Dinesh T									ML-MMOH-CRF-0557_UT1
-------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
 String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
 <script src='../../eCommon/js/common.js' language='javascript'></script>
 <script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
</head>
<body class="message" onKeyDown="lockKey()">
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" );
	String  locale = (String) p.getProperty("LOCALE");
	String firstComponent		= request.getParameter("firstComponent")==null?"":request.getParameter("firstComponent");
	String secondComponent	= request.getParameter("secondComponent")==null?"":request.getParameter("secondComponent");
	String formulaResultUnit		= request.getParameter("formulaResultUnit")==null?"":request.getParameter("formulaResultUnit");
	String formulaCompID		= request.getParameter("formulaCompID")==null?"":request.getParameter("formulaCompID");
	String formula_result_type	= request.getParameter("formula_result_type")==null?"":request.getParameter("formula_result_type");
	String mcOnBlur	= request.getParameter("mcOnBlur")==null?"N":request.getParameter("mcOnBlur");
	String formula_operator		= request.getParameter("formula_operator")==null?"":request.getParameter("formula_operator");
	String l_sys_date_time_in_en_yn		= request.getParameter("sysDateTimeInEnYN")==null?"":request.getParameter("sysDateTimeInEnYN");//IN063962

	String temp_secondComponent ="";

	String unit_of_gest_nb = "";
	int ga_weeks = 0;
	int ga_days = 0;
	
	
	//INC61905, starts - Comments : Refreshing the formula component, when the main component value is removed.
	out.println("<script>");
				
	out.println("if(top.content != null && top.content.workAreaFrame.RecClinicalNotesFrame != null){");			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");
	out.println("}else if(parent.RecClinicalNotesTemplateFrame != null){");
	out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");
	out.println("}else if(parent.recMatConsDetailsFrame != null){");
	
	out.println("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");
	out.println("} else if(top.content.workAreaFrame.recMatConsDetailsFrame != null)");
	
	out.println("top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '';");

	out.println("</script>");
	//INC61905, ends
	
	if(!firstComponent.equals("") && !secondComponent.equals(""))
	{
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;		
		//StringBuffer qry = new StringBuffer();
		StringBuilder qry = new StringBuilder();
		String formulaResult = "";
		
		
		try
		{		
		 con = ConnectionManager.getConnection(request);
			
		  if(mcOnBlur.equals("Y"))
		  {
			 String temp2[]= new String[4];
			 String strs[] = formulaCompID.split("%");
			 if(strs.length>0)
			 {
			  int i =0;
			  while(i<2)
			   {
				 temp2 = strs[i].split("~");
				 formulaCompID = temp2[0];	
				 formula_result_type = temp2[1];
				 formulaResultUnit = temp2[2];
				 formula_operator = temp2[3];

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
						formulaResult = rs.getString(1);



					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}
				else if(formula_result_type.equals("D"))
				{
					qry.setLength(0);
					
					//formulaResultUnit = "Weeks";
					firstComponent= secondComponent ;
					secondComponent = "40";

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
						//StringBuffer temp = new StringBuffer(formulaResult);
						StringBuilder temp = new StringBuilder(formulaResult);
						formulaResult = temp.substring(0, 10);
					}				
			    }
			//out.println("formulaResult=" + formulaResult);
				out.println("<script>");
				
				out.println("if(top.content != null && top.content.workAreaFrame.RecClinicalNotesFrame != null){");			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
				out.println("}else if(parent.RecClinicalNotesTemplateFrame != null){");
				out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
				out.println("}else if(parent.recMatConsDetailsFrame != null){");
				
				out.println("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
				out.println("} else if(top.content.workAreaFrame.recMatConsDetailsFrame != null)");
				
				out.println("top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");

				out.println("</script>");

				i++;
			   }
		     }
			

		  }
			else{

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

				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();

				String ges_comp_id ="";
				if (formulaCompID.length() >= 16)
				{
					ges_comp_id = formulaCompID.substring(2,14);
				}

				if(ges_comp_id.equals("MC01GESTNAGE") && !formulaResult.equals(""))
				{												

					String sqlQry = "SELECT NVL(UNIT_OF_GEST_NB,'D')  UNIT_OF_GEST_NB,NVL(max_gestation,0) max_gestation,NVL(min_gestation,0) min_gestation FROM MP_PARAM";
					stmt = con.prepareStatement(sqlQry);
					rs = stmt.executeQuery();
					if(rs.next()){
						unit_of_gest_nb = rs.getString("UNIT_OF_GEST_NB")==null?"D": rs.getString("UNIT_OF_GEST_NB");						
					}
					

					if(unit_of_gest_nb.equalsIgnoreCase("W"))
					{
						ga_weeks = Integer.parseInt(formulaResult)/7;
						ga_days = Integer.parseInt(formulaResult)%7;						
						String weekLabel = "";
						String daysLabel = "";
						if(ga_weeks == 1)
							weekLabel  = ga_weeks + " Week";
						else if(ga_weeks > 1)
							weekLabel  = ga_weeks + " Weeks";

						if(ga_days == 1)
							daysLabel  = ga_days+" Day";
						else if(ga_days > 1)
							daysLabel  = ga_days+" Days";

						if(weekLabel.equals("") && daysLabel.equals(""))
							formulaResult = "0";
						else
							formulaResult =weekLabel+" "+daysLabel;
					}else if(unit_of_gest_nb.equalsIgnoreCase("D")){
							if(Integer.parseInt(formulaResult) == 1)
								formulaResult = formulaResult + " Day";
							else
								formulaResult = formulaResult + " Days";
					}

					if(rs!=null) rs.close();
					if(stmt!=null) stmt.close();
				}

				
			}
			else if(formula_result_type.equals("D"))
			{

				String dateTime[] = firstComponent.split(" ");//IN063962

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
				//out.println("qry ="+qry.toString()+"=");
				//out.println("firstComponent ="+firstComponent+"=");
				//out.println("secondComponent ="+secondComponent+"=");
				stmt = con.prepareStatement(qry.toString());
				stmt.setString(1, firstComponent);
				stmt.setString(2, secondComponent);
				stmt.setString(3, formulaResultUnit);				
				rs = stmt.executeQuery();
				if(rs.next())
					formulaResult = rs.getString(1);
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();				
				//IN063962, starts
				/*int index = formulaResult.lastIndexOf("00:00");
				if(index != -1)
				{
					StringBuffer temp = new StringBuffer(formulaResult);
					formulaResult = temp.substring(0, 10);
				}*/
				if(dateTime.length == 1)
				{
					StringBuilder temp = new StringBuilder(formulaResult);
					formulaResult = temp.substring(0, 10);
					
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
			//-Start -[IN030681] - Updated Artimis 
			%>
			<script>
				if(top.content!=null && top.content.workAreaFrame.RecClinicalNotesFrame != null){
					top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.<%=formulaCompID %>.value= '<%=formulaResult %>';
				}else if(parent.RecClinicalNotesTemplateFrame != null){
					parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm.<%=formulaCompID %>.value= '<%=formulaResult %>';
				}else if(parent.recMatConsDetailsFrame != null){
					parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.<%=formulaCompID %>.value= '<%=formulaResult %>';
				}else if(top.content.workAreaFrame.recMatConsDetailsFrame != null){
					top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm.<%=formulaCompID %>.value= '<%=formulaResult %>';
					// Added by Sridhar Reddy on 19/10/2009 PMG20089-CRF-0690
					var formObj = top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm;
					var nodeList = formObj.elements.length;
					var EddCompID = <%=formulaCompID %>.substring(0,9);			
					for (var i=0; i<nodeList;i++ ){			
						if (formObj.elements[i].type == 'text' && formObj.elements[i].name.length >= 17 &&   formObj.elements[i].name.substring(0,17) == 'C_MC01CORRECTDEDD' && EddCompID=='C_MC01EDD'){		
							formObj.elements[i].value ='<%=formulaResult %>';
						}
					}
				}
			</script>
			<%
			//-End -[IN030681] - Updated Artimis 
			//-Commentted -[IN030681] - Updated Artimis 
			/*out.println("<script>");
			
			out.println("if(top.content != null && top.content.workAreaFrame.RecClinicalNotesFrame != null){");	
			out.println("top.content.workAreaFrame.RecClinicalNotesFrame.RecClinicalNotesSecDetailsFrame.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}else if(parent.RecClinicalNotesTemplateFrame != null){");
			out.println("parent.RecClinicalNotesTemplateFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("}else if(parent.recMatConsDetailsFrame != null){");
			out.println("parent.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			out.println("} else if(top.content.workAreaFrame.recMatConsDetailsFrame != null){");
			out.println("top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm." + formulaCompID + ".value= '" + formulaResult + "';");
			// Added by Sridhar Reddy on 19/10/2009 PMG20089-CRF-0690
			out.println("var formObj = top.content.workAreaFrame.recMatConsDetailsFrame.document.RecClinicalNotesTemplateForm;");
			out.println("var nodeList = formObj.elements.length;");
			out.println("var EddCompID = '"+formulaCompID.substring(0,9)+"'");			
			out.println("for (var i=0; i<nodeList;i++ ){");			
			out.println("if (formObj.elements[i].type == 'text' && formObj.elements[i].name.length >= 17 &&   formObj.elements[i].name.substring(0,17) == 'C_MC01CORRECTDEDD' && EddCompID=='C_MC01EDD'){");			
			out.println("	formObj.elements[i].value ='"+formulaResult+"';}}");	
			
			//End	

			out.println("}");
			out.println("</script>");*/ //-Commentted -[IN030681] - Updated Artimis 
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//out.println("Exception --->" + e);//common-icn-0181
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

