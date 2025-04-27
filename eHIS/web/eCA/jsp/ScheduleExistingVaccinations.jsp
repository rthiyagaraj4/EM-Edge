<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date		Rev.Name	Description
--------------------------------------------------------------------------------------------------------------------------------
?             	100            ?           		created
08/10/2013    	IN035541       Chowminya G									Manage Immunization->System is displaying the Vaccine Category of Age specific 
27/11/2017		IN065683		Dinesh T									Vaccination Schedule getting automatically generated on opening patient chart in CA
24/04/2023		41652			Twinkle			24/04/2023		Ramesh		MMS-JU-CRF-0015.2																
08/09/2023		41654			Twinkle Shah			        Ramesh Goli  MMS-JU-CRF-0015.4															
--------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%-- <%@page import="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8"%>  41654--%>

<%@page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper,java.util.Date,java.text.SimpleDateFormat,java.text.DateFormat" contentType="text/html;charset=UTF-8"%>   <!-- 41654 -->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	%>
<html>
 <%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String facility_id = session.getAttribute("facility_id")==null?"":(String) session.getAttribute("facility_id"); 	
//String query_string = request.getQueryString();

%>


<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
    <script src='../js/ScheduleForVacination.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- 41654 -->
	<style type="text/css">
	a:link {
		COLOR: #000066;
		FONT-WEIGHT: BOLD
	}
	a:visited {
		COLOR: #000066;
		FONT-WEIGHT: BOLD
	}
	a:hover {
		COLOR: #0000FF;
		FONT-WEIGHT: BOLD
	}
	a:active {
		COLOR: #0000FF;
		FONT-WEIGHT: BOLD
	}
</style>  
   <head>
   </head>
   <body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

   <%
	Connection			con		= null;
	PreparedStatement	pstmt	= null;
	ResultSet			rs		= null;
	String patient_id ="";
	String encounter_id ="";
	String Schedule_query ="";
	String vacc_categ_id ="";
	String vacc_categ_desc ="";
	String vacc_categ_desc1 ="";
	String Existing_schedule_query ="";
//	String rowclass ="";
	String vac_sch_ref ="";
	String adhoc_yn ="";
	String allow_multiple_yn =""; //41654
	String sch_created_date =""; //41654
	DateFormat inputFormatter =null; //41654
	Date date =null;                  //41654
	DateFormat outputFormatter =null; //41654
	String sch_created_date1 =""; //41654
	
	String scheduled_user_id =""; //41654
	int edit_Validity_Date; //41654
	String age_specific_yn=""; //41654
	
	String sch_status ="";
	String imVaccPram  = "";
	String height  = "";
	String weight  = "";
	String BMI  = "";
	String height_on_date  = "";
	String weight_on_date  = "";	
	String weight_uom  = "";	
	String height_uom  = "";
//	String vacc_link_days  = "";
	String link_vacc_categ_id  = "";
	
	//41654 start
	String currentDate ="";
	currentDate	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
    //41654 end
	int k=0;

	patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String dob=request.getParameter("Dob") == null ? "" : request.getParameter("Dob");
	String sex=request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
	
	String login_user = (String)session.getValue("login_user");  ///41654
	
	eCA.ScheduleForVaccination schBean = new eCA.ScheduleForVaccination();
	Map<String,List<String>> bmiMap = schBean.getBMI(patient_id,facility_id);
	
	 if(bmiMap != null && bmiMap.size() > 0)
	 {
		 List<String> bmiList =	bmiMap.get("HEIGHT");
		 height  = bmiList.get(0);
		 height_uom  = bmiList.get(1);
		 height_on_date  = bmiList.get(2);
		 bmiList =	bmiMap.get("WEIGHT");		
		 weight  = bmiList.get(0);
		 weight_uom  = bmiList.get(1);
		 weight_on_date  = bmiList.get(2);
		 
		 if(!height.equals("") && !weight.equals("")) {
			BMI=String.valueOf(Double.parseDouble(weight)/((Double.parseDouble(height)/100)*(Double.parseDouble(height)/100)));
			int index	=	BMI.indexOf(".");
			
			if(BMI.length()>=(index+3) ) {
				BMI	=(BMI.substring(0,index+3));
			}
		 } 				
	 }
	%>

	<!-- <form> 41654-->
	<form name = "scheduleExistingVacciForm" action="../../servlet/eCA.ScheduleCategServlet" method="post" target="messageFrame" >  <!-- 41654 -->
		<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center'>
			<tr>
				<td colspan='2'>
					<table class='grid' width='100%'>
						<tr>
							<td class='gridData'>
								<fmt:message key="Common.height.label" bundle="${common_labels}"/>
							</td>
							<td class='gridData'>
								<%if(!height.equals("")){%>
								<%=height%>&nbsp;<%=height_uom%>&nbsp;<fmt:message key="Common.Ason.label" bundle="${common_labels}"/>&nbsp;&nbsp;<%=height_on_date%>
									<%}%>
							</td>							
						</tr>
						<tr>
							<td class='gridData'>
								<fmt:message key="Common.weight.label" bundle="${common_labels}"/>
							</td>
							<td class='gridData'>
								<%if(!weight.equals("")){%>
								<%=weight%>&nbsp;<%=weight_uom%>&nbsp;<fmt:message key="Common.Ason.label" bundle="${common_labels}"/>&nbsp;&nbsp;<%=weight_on_date%>
								<%}%>
							</td>							
						</tr>
						<tr>
							<td class='gridData'>
								<fmt:message key="Common.BMI.label" bundle="${common_labels}"/>
							</td>	
							<td class='gridData'>
								<%=BMI%>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td class='label' nowrap colspan='2'><fmt:message key="Common.create.label" bundle="${common_labels}"/><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></td> </tr>
				<tr>
				<td  class='' nowrap colspan='2'>
				<select name='schedule_categ' id='schedule_categ' onchange='scheduleCodeChange(this)' > 
						<option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
					try
					{
						con = ConnectionManager.getConnection(request);
						String imPramSql = "SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID,?,2)  VACC_CATEG_DESC FROM CA_IM_PAT_VAC_SCH_HDR A WHERE A.VACC_CATEG_ID IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM) AND PATIENT_ID=?  ";
						pstmt = con.prepareStatement(imPramSql);
						pstmt.setString(1, locale);
						pstmt.setString(2, patient_id);
						rs= pstmt.executeQuery();
						
						if(rs .next())
						{
							imVaccPram = rs.getString("VACC_CATEG_DESC")==null?"":rs.getString("VACC_CATEG_DESC");
							vac_sch_ref = rs.getString("VAC_SCH_REF")==null?"":rs.getString("VAC_SCH_REF");							
							link_vacc_categ_id = rs.getString("VACC_CATEG_ID")==null?"":rs.getString("VACC_CATEG_ID");
						}
						

						if(rs != null)
							rs.close();
						if(pstmt != null)
							pstmt.close();
							
						//IN057762 Start.
						//Schedule_query ="Select a.VACC_CATEG_ID, a.SHORT_DESC,a.ADHOC_YN from CA_IM_VAC_CATEG_lang_vw a where a.language_id=? And a.EFF_STATUS = 'E' and a.AGE_SPECIFIC_YN = 'N'  and (a.AGE_GROUP_CODE is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=a.AGE_GROUP_CODE AND   TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN         DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE)     AND  NVL(IA.GENDER,?)=? )) AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR b WHERE PATIENT_ID =? AND b.VACC_CATEG_ID=a.VACC_CATEG_ID AND a.adhoc_yn = 'Y') AND a.VACC_CATEG_ID NOT IN (SELECT c.VACC_CATEG_ID FROM CA_IM_PARAM c) order by A.ADHOC_YN, A.AGE_SPECIFIC_YN" ;//IN065683
						//41652 Start.
						//Schedule_query ="Select a.VACC_CATEG_ID, a.SHORT_DESC,a.ADHOC_YN from CA_IM_VAC_CATEG_lang_vw a where a.language_id=? And a.EFF_STATUS = 'E' and (a.AGE_GROUP_CODE is null or EXISTS ( SELECT 1 FROM AM_AGE_GROUP IA  WHERE IA.AGE_GROUP_CODE=a.AGE_GROUP_CODE AND TRUNC(SYSDATE)-to_date(?,'dd/mm/yyyy') BETWEEN DECODE(IA.AGE_UNIT,'D',IA.MIN_AGE,'M',30*IA.MIN_AGE,'Y',365*IA.MIN_AGE)  AND  DECODE(IA.AGE_UNIT,'D',IA.MAX_AGE,'M',30*IA.MAX_AGE,'Y',365*IA.MAX_AGE) AND NVL(IA.GENDER,?)=? )) AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR b WHERE PATIENT_ID =? AND b.VACC_CATEG_ID=a.VACC_CATEG_ID AND a.ALLOW_MULTIPLE_YN = 'N') AND a.VACC_CATEG_ID NOT IN (SELECT c.VACC_CATEG_ID FROM CA_IM_PARAM c) order by A.ADHOC_YN, A.AGE_SPECIFIC_YN" ;//IN065683
						Schedule_query ="Select a.VACC_CATEG_ID, a.SHORT_DESC,a.ADHOC_YN from CA_IM_VAC_CATEG_lang_vw a where a.language_id=? And a.EFF_STATUS = 'E' and 'Y' = CA_IM_VAC_CATEGORY_YN (a.age_specific_yn ,a.age_group_code ,? ,?) AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR b WHERE PATIENT_ID =? AND b.VACC_CATEG_ID=a.VACC_CATEG_ID AND a.ALLOW_MULTIPLE_YN = 'N') AND a.VACC_CATEG_ID NOT IN (SELECT c.VACC_CATEG_ID FROM CA_IM_PARAM c) order by A.ADHOC_YN, A.AGE_SPECIFIC_YN" ;
						//41652 End.
						//IN057762 End.
						
						pstmt=con.prepareStatement(Schedule_query);
						pstmt.setString(1,locale);
						pstmt.setString(2,dob);
						pstmt.setString(3,sex);
						//pstmt.setString(4,sex); //41652
						//pstmt.setString(5,patient_id); //41652
						pstmt.setString(4,patient_id); //41652
						rs= pstmt.executeQuery();
						while(rs.next())
						{						
							vacc_categ_id =rs.getString("VACC_CATEG_ID");
							vacc_categ_desc =rs.getString("SHORT_DESC");
							adhoc_yn =rs.getString("ADHOC_YN");
							if(adhoc_yn.equals("Y"))
								vacc_categ_desc = vacc_categ_desc+"#";

							out.println("<option value="+vacc_categ_id+"~"+adhoc_yn+">"+vacc_categ_desc+"</option>");
						}
						adhoc_yn = "";
						if(rs!=null)rs.close();
						if(pstmt!=null)pstmt.close();
						//if(con!=null)ConnectionManager.returnConnection(con,request);


					}
					catch(Exception e)
					{
						
						e.printStackTrace();
					}
					
				
				%>
				
				</select><!-- Modified by Arvind --><input type='button' name='goSchedule' id='goSchedule' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Go.label","common_labels")%>' class='button' onClick='getSchedulePopUp();'>
				</td>
			</tr>
		<!-- </table>  -->
		 <tr><td colspan="2">
		<table cellpadding='0' cellspacing='0' border='0' width='100%' align='center' >
			<tr><td class='COLUMNHEADERCENTER' ><fmt:message key="eCA.ExistingSchedules.label" bundle="${ca_labels}"/><td></tr>
			<tr><td class='CAGROUP' background='../../eCA/images/MCT_FullStrip.gif' style='height:28' ><a class='gridLink' id="linkAll" href='javascript:onClick=scheduleResult("ALL","","N","linkAll");' ><fmt:message key="Common.all.label" bundle="${common_labels}"/></a> <td></tr>
			<%if(!imVaccPram.equals("")) {%>
			<tr><td class='CAGROUP' background='../../eCA/images/MCT_FullStrip.gif' style='height:28' ><a class='gridLink' id="linkVACCINE" href='javascript:onClick=scheduleResult("<%=vac_sch_ref%>","<%=link_vacc_categ_id%>","N","linkVACCINE");' ><%=imVaccPram%></a> <td></tr>
			<%}%>
			
			<%   
			try
			{
				//Existing_schedule_query=" SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID,?,2)  VACC_CATEG_DESC,ADHOC_YN ADHOC_YN,sch_created_date,SCH_STATUS  FROM CA_IM_PAT_VAC_SCH_HDR A, CA_IM_VAC_CATEG B   WHERE A. PATIENT_ID = ? AND B.VACC_CATEG_ID=A.VACC_CATEG_ID AND A.VACC_CATEG_ID NOT IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM C WHERE C.VACC_CATEG_ID=A.VACC_CATEG_ID ) UNION ALL SELECT NULL, VACC_CATEG_ID,SHORT_DESC  VACC_CATEG_DESC,ADHOC_YN ,null,null FROM CA_IM_VAC_CATEG_LANG_VW IA WHERE ia.AGE_SPECIFIC_YN = 'Y' AND EFF_STATUS='E' AND LANGUAGE_ID=? AND NOT EXISTS (SELECT 1 FROM CA_IM_PAT_VAC_SCH_HDR WHERE VACC_CATEG_ID=IA.VACC_CATEG_ID AND PATIENT_ID= ? ) AND EXISTS (SELECT 1 FROM CA_IM_VAC_SCH_FOR_CATEG WHERE vacc_categ_id = ia.vacc_categ_id )   ORDER BY ADHOC_YN, SCH_CREATED_DATE desc,3 "; //Commentted [IN035541]
				//Existing_schedule_query=" SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID,?,2)  VACC_CATEG_DESC,ADHOC_YN ADHOC_YN,sch_created_date,SCH_STATUS  FROM CA_IM_PAT_VAC_SCH_HDR A, CA_IM_VAC_CATEG B   WHERE A. PATIENT_ID = ? AND B.VACC_CATEG_ID=A.VACC_CATEG_ID AND A.VACC_CATEG_ID NOT IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM C WHERE C.VACC_CATEG_ID=A.VACC_CATEG_ID )  ORDER BY SCH_CREATED_DATE desc,3 "; //[IN035541  //41654
				Existing_schedule_query="SELECT A.VAC_SCH_REF, A.VACC_CATEG_ID, CA_GET_DESC.CA_IM_VAC_CATEG (A.VACC_CATEG_ID, ?, 2) VACC_CATEG_DESC, ADHOC_YN ADHOC_YN, SCH_CREATED_DATE, SCH_STATUS, B.ALLOW_MULTIPLE_YN ALLOW_MULTIPLE_YN, A.SCHEDULED_USER_ID SCHEDULED_USER_ID,B.AGE_SPECIFIC_YN AGE_SPECIFIC_YN FROM CA_IM_PAT_VAC_SCH_HDR A, CA_IM_VAC_CATEG B WHERE A.PATIENT_ID = ? AND B.VACC_CATEG_ID = A.VACC_CATEG_ID AND A.VACC_CATEG_ID NOT IN (SELECT VACC_CATEG_ID FROM CA_IM_PARAM C WHERE C.VACC_CATEG_ID = A.VACC_CATEG_ID) ORDER BY SCH_CREATED_DATE DESC, 3"; //41654
                				
				pstmt=con.prepareStatement(Existing_schedule_query);
				pstmt.setString(1,locale);
				pstmt.setString(2,patient_id);
				//pstmt.setString(3,locale); //[IN035541]
				//pstmt.setString(4,patient_id);//[IN035541]
				
				rs= pstmt.executeQuery();

				while(rs.next())
				{
					
					vac_sch_ref =rs.getString("VAC_SCH_REF")==null?"":rs.getString("VAC_SCH_REF");
					vacc_categ_id =rs.getString("VACC_CATEG_ID")==null?"":rs.getString("VACC_CATEG_ID");
					vacc_categ_desc1 =rs.getString("VACC_CATEG_DESC");
					sch_status =rs.getString("SCH_STATUS")==null?"C":rs.getString("SCH_STATUS");

					adhoc_yn =rs.getString("ADHOC_YN")==null?"N":rs.getString("ADHOC_YN");
					allow_multiple_yn =rs.getString("ALLOW_MULTIPLE_YN")==null?"N":rs.getString("ALLOW_MULTIPLE_YN"); //41654
					sch_created_date =rs.getString("SCH_CREATED_DATE")==null?"":rs.getString("SCH_CREATED_DATE"); //41654
					scheduled_user_id =rs.getString("SCHEDULED_USER_ID")==null?"N":rs.getString("SCHEDULED_USER_ID"); //41654
					age_specific_yn =rs.getString("AGE_SPECIFIC_YN")==null?"N":rs.getString("AGE_SPECIFIC_YN"); //41654
					
					//start 41654
                    inputFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    date = inputFormatter.parse(sch_created_date);
                    outputFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    sch_created_date1 = outputFormatter.format(date); // Output : 01/20/2012
                    edit_Validity_Date= com.ehis.util.DateUtils.hoursBetween(sch_created_date1,currentDate,"DMYHM",locale);
                    //41654 end
					
					if (adhoc_yn.equals("Y") )
							vacc_categ_desc1=vacc_categ_desc1+"#";
					
					if (sch_status.equals("A"))
					{
					      //out.println("<tr><td background='../../eCA/images/MCT_FullStrip.gif' style='height:28'><a class='gridLink' id='linkSchCateg"+k+"' href='javascript:onClick=scheduleResult(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");' ><b>"+vacc_categ_desc1+"</b></a> <td></tr>");   //41654
				           
					      //start 41654
					          out.println("<tr><td background='../../eCA/images/MCT_FullStrip.gif' style='height:28'><a class='gridLink' id='linkSchCateg"+k+"' href='javascript:onClick=scheduleResult(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");' ><b>"+vacc_categ_desc1+"</b></a>");
					
					          if(edit_Validity_Date < 48 && login_user.equals(scheduled_user_id) && adhoc_yn.equals("N") && age_specific_yn.equals("N"))
					           {
					            out.println("&nbsp;&nbsp;&nbsp;&nbsp;<a class='gridLink'><img style='cursor:pointer;' name='editSchedule' onClick='getSchedulePopUpEdit(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");' alt='Edit Schedule' src='../../eCA/images/undo_05.png'></a>");
					           }
					            out.println("<td></tr>"); 
					       //end 41654
					}
                    else
				          out.println("<tr><td background='../../eCA/images/MCT_FullStrip.gif' style='height:28'><a class='gridLink' id='linkSchCateg"+k+"' href='javascript:onClick=scheduleResult(\""+vac_sch_ref+"\",\""+vacc_categ_id+"\",\""+adhoc_yn+"\",\""+k+"\");'>"+vacc_categ_desc1+"</a> <td></tr>");
					
				k++;
				}

				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(con!=null)ConnectionManager.returnConnection(con,request);

			
			}
			catch(Exception e)
			{
			
				
				e.printStackTrace();
			
			}

			
			%> 
			
		</table>
	 </td></tr>
	</table> 
<input type='hidden' name='query_string' id='query_string' value='<%=request.getQueryString()%>' >
<input type='hidden' value='<%=patient_id%>' name='patient_id' id='patient_id'>
<input type='hidden' value='<%=encounter_id%>' name='encounter_id' id='encounter_id'>
<!-- <input type='hidden' value='' name='allow_multiple_yn' id='allow_multiple_yn'> 41654-->
<input type='hidden' value='<%=allow_multiple_yn%>' name='allow_multiple_yn' id='allow_multiple_yn'> <!-- 41654 -->
<input type='hidden' value='<%=vacc_categ_id%>' name='vacc_categ_id' id='vacc_categ_id'>   <!-- 41654 -->
<input type='hidden' value='<%=vac_sch_ref%>' name='vac_sch_ref' id='vac_sch_ref'>   <!-- 41654 -->

	</form>
  </body>

</html>

