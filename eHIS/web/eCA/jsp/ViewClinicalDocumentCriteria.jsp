<!DOCTYPE html>

		<!--
		Author	: Arvind Singh Pal
		Purpose : Created For GHL-CRF-0043 
		Date		: 16 November 2009

		-->

<html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>

	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 		
		String patient_id =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");		
		String enc_id  =request.getParameter("enc_id")==null?"":request.getParameter("enc_id");
		if(enc_id.equals("0")) 
				enc_id="";		
		
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>	
  	<script src='../../eCA/js/ViewClinicalDocument.js' language='javascript'></script>  	
	<script src='../../eCA/js/DateCheck.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="showViewResult()";>
<%
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;

	String locale = (String) p.getProperty("LOCALE");	
	String facilityId=(String)session.getAttribute("facility_id");
	
	String fromDate="";
	String toDate="";
	String practtype="";
	String practtypedesc="";
	String encounter_id="";	
	String appl_task_desc="";
	String appl_task_id="";
	String chkSelBox="";
	String patient_class="";
	String visit_status="";
	String ADT_STATUS="";
	String default_enct = "";
	String default_enct1="";
	int cnt=0;

	StringBuffer strt=new StringBuffer();
	StringBuffer strEnt=new StringBuffer();
	StringBuffer strCheck=new StringBuffer();

	Connection con=null;	
	ResultSet rst = null;	
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	PreparedStatement pstmt2=null;
	

	toDate= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);	
	StringBuffer sqlEncounter=new StringBuffer();

	try {
		con=ConnectionManager.getConnection();

	String dateSql="SELECT to_char(min(VISIT_ADM_DATE_TIME),'DD/MM/YYYY HH24:MI') VISIT_ADM_DATE_TIME from pr_encounter WHERE patient_id=? and visit_adm_date_time=(select min(visit_adm_date_time) from pr_encounter where patient_id=? and nvl(visit_status,'01') !='99' and nvl(adt_status,'01') !='09') ";
	try{		
		pstmt1=con.prepareStatement(dateSql);
		pstmt1.setString(1,patient_id);
		pstmt1.setString(2,patient_id);
		rst=pstmt1.executeQuery();

			while(rst.next()) 
			{						
			fromDate=rst.getString("VISIT_ADM_DATE_TIME")==null?"":rst.getString("VISIT_ADM_DATE_TIME");	
			fromDate=com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM","en",locale);
			} 	
			 if(rst!=null) rst.close();	
			 if(pstmt1!=null) pstmt1.close();									
			}
			catch(Exception e)
			{
				out.println("exception in date**"+e);
				e.printStackTrace();
			}
	
%>
	<form name="view_document" id="view_document">

<table  cellpadding=0 cellspacing=0 width="100%" align="center" border=0>
		<tr>			
			<td class="label" width="10%"><fmt:message key="Common.Period.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="fields" width="35%">
				<input type="text" maxlength=16 size="16" value='<%=fromDate%>' name="from_date" id="from_date"  onBlur='dateChange(this,document.view_document.to_date,"<%=locale%>","from_date");'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('from_date');" /> 
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
				<input type="text" maxlength=16 size="16" value='<%=toDate%>' name="to_date" id="to_date" onBlur='dateChange(document.view_document.from_date,this,"<%=locale%>","to_date");	'><img src="../../eCommon/images/CommonCalendar.gif"  onclick="return showCalendarValidate('to_date');" />
				</td>
			<td class="label" width="20%"><fmt:message key="eCA.IncludeNoOfPreviousNotes.label" bundle="${ca_labels}"/></td>
			<td class="fields" width="20%" colspan="2"><input type="text" maxlength=1 size="8" name="indno" id="indno" value="" onblur="allowNumeric(this)"  onkeypress="return checkForNum(event)"></td>
</tr>
 <tr>
	<td class="label" width="20%" ><fmt:message key="eCA.RecordedPractType.label" bundle="${ca_labels}"/></td>
	<td class='fields'>
			<%
					String sqlt = "select pract_type,Desc_Userdef  from am_pract_type where eff_status = 'E' and (trunc(sysdate) between nvl(trunc(eff_date_from),to_date('01/01/1472','dd/mm/rrrr')) and nvl(trunc(eff_date_to),to_date('31/12/5000','dd/mm/rrrr'))) order by Desc_Userdef";

				try{					
					pstmt1 = con.prepareStatement(sqlt);
					rst = pstmt1.executeQuery();					

					strt.append("<select name='pract_type' id='pract_type' onChange='changeFields()'>");	

			strt.append("<option value='all' >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels"));

					while(rst.next()) 
		  			 {						
		  				practtype=rst.getString("pract_type");
		  				practtypedesc=rst.getString("Desc_Userdef");					
		  				strt.append("<option value='"+practtype+"'>"+practtypedesc);
		  			 } 
					 strt.append("</select>");
					if(rst!=null) rst.close();
					if(pstmt1!=null) pstmt1.close();
				}
					catch(Exception e){
						out.println("exception in pract**"+e);
						e.printStackTrace();
				}				
				out.println(strt.toString());
			%>
				
				
	</td>
	<td class="label" ><fmt:message key="eCA.RecordedPract.label" bundle="${ca_labels}"/></td>
	<td class="fields" >
		<input type="text" name="Practitioner_Name" id="Practitioner_Name" maxlength=16 size="16" onblur="fnGetPractitionerId(this)" value=""><input type="button" value="?" class="button" name="btnPract" id="btnPract" onclick="fnGetPractitionerId(this)">		
		<input type ="hidden" name ="p_practitioner_id" id ="p_practitioner_id" value = ''></td>
	</tr>
	<tr>
	<td class="label" ><fmt:message key="eCA.Encounters.label" bundle="${ca_labels}"/></td>
	<td class='fields'>
			<%				

			 sqlEncounter.append("select encounter_id, patient_class,visit_status,adt_status from pr_encounter where PATIENT_ID=? AND nvl(VISIT_STATUS,'01') !='09' AND nvl(ADT_STATUS,'01') !='09' ");

			try{
					if(!fromDate.equals("")){
						sqlEncounter.append("AND VISIT_ADM_DATE_TIME >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
					}
					if(!toDate.equals("")){

						sqlEncounter.append(" AND VISIT_ADM_DATE_TIME <=to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 ");
					}
					sqlEncounter.append(" order by VISIT_ADM_DATE_TIME DESC ");					
					
					pstmt=con.prepareStatement(sqlEncounter.toString());		
					int countP=0;
					pstmt.setString(++countP,patient_id);

					if(!fromDate.equals(""))
						pstmt.setString(++countP,com.ehis.util.DateUtils.convertDate(fromDate,"DMYHM",locale,"en"));

					if(!toDate.equals(""))
						pstmt.setString(++countP,com.ehis.util.DateUtils.convertDate(toDate,"DMYHM",locale,"en"));

					rst=pstmt.executeQuery();
					
					strEnt.append("<select name='encounter' id='encounter' id='encounter'><option value=''> -----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-------");	
					
					
						boolean defaulted1=false;
					if(!enc_id.equals("")){	
						default_enct=enc_id;
						while(rst.next()) 
						{						
							encounter_id=rst.getString("encounter_id");
							if( !defaulted1){
							strEnt.append("<option value='"+enc_id+"' selected='selected'>"+enc_id);							
							defaulted1=true;		
							}
						if(!encounter_id.equals(enc_id)){		
							strEnt.append("<option value='"+encounter_id+"'>"+encounter_id);	
						}
						}
					}			
					
				else{
					//out.println("
					boolean defaulted=true;
					
					int countp=0;
					while(rst.next()) 
					{
						patient_class=rst.getString("patient_class");
						visit_status=rst.getString("visit_status");
						ADT_STATUS=rst.getString("adt_status");
						if(ADT_STATUS==null) 	ADT_STATUS="";						
						if(visit_status==null) 		visit_status="";
						
						encounter_id=rst.getString("encounter_id");
						countp++;
						if(countp==1)
							default_enct1=encounter_id;
							
							if((patient_class.equals("IP") || patient_class.equals("DC"))
								&&(ADT_STATUS.equals("00")||ADT_STATUS.equals("01")||ADT_STATUS.equals("02")||ADT_STATUS.equals("03")||ADT_STATUS.equals("04")||ADT_STATUS.equals("05")||ADT_STATUS.equals("06")||ADT_STATUS.equals("07"))){	
									if(default_enct.equals(""))
									{
										default_enct = encounter_id;										
									}
							}

							else if((patient_class.equals("OP") || patient_class.equals("EM"))
								&&(visit_status.equals("00")||visit_status.equals("01")||visit_status.equals("02")||visit_status.equals("03")||visit_status.equals("04")||visit_status.equals("05")||visit_status.equals("06"))){	
								if(default_enct.equals(""))
								{
									default_enct = encounter_id;										
								}
							}							
							//out.println("<br> default_enct  ------>"+default_enct+"<----     encounter_id ----->"+encounter_id+"<-------");							
							if(!default_enct.equals("") && defaulted)
							{
								defaulted = false;
								strEnt.append("<option value='"+default_enct+"' selected>"+default_enct+"</option>");
							}else{
								
								strEnt.append("<option value='"+encounter_id+"'>"+encounter_id+"</option>");		
							}
					}
				}
					 strEnt.append("</select>");
					

					 if(rst!=null) rst.close();	
					 if(pstmt!=null) pstmt.close();
									
				}
					catch(Exception e){
						out.println("exception in encounter**"+e);
						e.printStackTrace();
				}	
				out.println(strEnt.toString());
			%>	
	</td>	
	</tr>
	
	</table>
	<table cellpadding=0 id='moreCriteria'>
		<tr>
		<td class="label" colspan=4><b><fmt:message key="eCA.ApplicableTask.label" bundle="${ca_labels}"/><b></td>
		</tr>
		<tr>
			
			<%
			 String sqlcheckBoxes="SELECT appl_task_id,appl_task_desc  from ca_appl_task_lang_vw where  NOTE_SPEC_YN='Y' AND language_id=? AND appl_task_id IN ('CLINICAL_NOTES','DISCHARGE_SUMMARY','REFERRAL_LETTER') order by 2 ";			

			try{				
					pstmt2=con.prepareStatement(sqlcheckBoxes);
					pstmt2.setString(1,locale);
					rst=pstmt2.executeQuery();					
					int cnttd=0;
					while(rst.next()) 
		  			 {		
						appl_task_id=rst.getString("appl_task_id")==null?"":rst.getString("appl_task_id");	
		  				appl_task_desc=rst.getString("appl_task_desc")==null?"":rst.getString("appl_task_desc");	

						if(appl_task_id.equals("DISCHARGE_SUMMARY") || appl_task_id.equals("CLINICAL_NOTES") || appl_task_id.equals("MT_CONSULT") || appl_task_id.equals("MC_CONSULT") || appl_task_id.equals("OH"))							
							chkSelBox="checked";
						else
							chkSelBox="";
		  				
						if(cnttd >=4){
							strCheck.append("</tr><tr>");
							cnttd=0;
						}
						strCheck.append("<td class='label'>"+appl_task_desc);
		  				strCheck.append("</td>");						
						strCheck.append("<td><input type='checkbox' name='task_"+cnt+"' id='task_"+cnt+"' "+chkSelBox+" value='"+appl_task_id+"' ></td>");
						cnt++;
						cnttd++;
		  			 } 
					 if(rst!=null) rst.close();
					 if(pstmt2!=null) pstmt2.close();					 					
				}
					catch(Exception e){						
						e.printStackTrace();
				}							
				out.println(strCheck.toString());	
				%>
			
				
		</tr>
	
	</table>

	<table border=0 cellpadding=3 cellspacing=0 width="100%" >
		
	 <tr>				
			<td colspan = 4 width='100%' align ='right'>

			<input type="button" class=button name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Show.label","ca_labels")%>' onClick="showViewResult()">&nbsp;
			<input type="button" class=button name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick="clearViewForm();">
		 <!-- <input type="button" class='button' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.morecriteria.label","common_labels")%>'  name='more' onClick="makeDetailsVisible(this);">  -->
			</td>
		</tr>
		
		</table>
		<input type="hidden" name="facilityId" id="facilityId" value='<%=facilityId%>'>
		<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'>
		<input type="hidden" name="task_cnt" id="task_cnt" value='<%=cnt%>'>
		<input type="hidden" name="enc_id" id="enc_id" value='<%=enc_id%>'>
		<input type="hidden" name="locale" id="locale" value='<%=locale%>'>
		<input type="hidden" name="default_enct" id="default_enct" value='<%=default_enct%>'>
		
		
	</form>
<%}catch(Exception e){
		e.printStackTrace();
	}finally{
		try {
			if(con != null) ConnectionManager.returnConnection(con,request);
		}catch(Exception ee){
			ee.printStackTrace();
		}
	}
	
	 if(default_enct.equals("") )
					{
					 %>
						<SCRIPT LANGUAGE="JavaScript">
							setSelectFirstEncounterID('encounter')
						</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



					 <%
					}
	
	%>		
</body>
</html>

