<!DOCTYPE html>
<%/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?             created
14/12/2012	    IN030460 			Karthi L	  	CRF-019 Update PR_Diagnosis table when we modify any patient high risk data when the close date 
02/01/2013	  	IN037071 			Karthi L	  	to control update same high risk condition when try to close one.
20/01/2012		CHL-CRF [IN035950]	Ramesh G	CHL-CRF [IN035950]										
---------------------------------------------------------------------------------------------------------------
*/ %>
<%@ page import ="java.sql.*,java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
<script src='../../eCA/js/PatHighRisk.js' language='javascript'></SCRIPT>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>


<%
	Properties p = (Properties)session.getValue("jdbc");
	String locale= (String) p.getProperty("LOCALE");
	Connection con=null;
	PreparedStatement pstmt=null;
	PreparedStatement stmt=null;
	ResultSet rset=null ;
	String dat="";
	String highriskcode="";
	String highriskdesc="";
	String onsetdate="";
	String onsetdate1="";
	String fnval="insert";
	String ID="";
	String sel="";
	String remarks="";
	String closedate="";
	String srlno="";

	String agey="";
	String agem="";
	String aged="";

	//java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String facilityId = (String) session.getValue( "facility_id" ) ;
	//String fid=p.getProperty( "login_user" ) ;

//	SimpleDateFormat dateFormat = new SimpleDateFormat( "dd/MM/yyyy" ) ;
   	String currentdate 		= "";

	currentdate		= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);

	onsetdate1=currentdate;
	closedate=currentdate;
	

	highriskcode=request.getParameter("high_risk_code");
	srlno = request.getParameter("srl_no");

	String patient_id = request.getParameter("Patient_Id");
	String encounter_id = request.getParameter("Encounter_Id");
	String practitioner_id = request.getParameter("Practitioner_Id");
	String clinic_code = request.getParameter("Clinic_Code");
	String locn_type = request.getParameter("Location_Type");
	String dob = request.getParameter("dob");
	int ocr_srl_no = 0; // added for CRF-019 -30460
	String trm_set_id = ""; // added for CRF-019 -30460
	String trm_code = ""; // added for CRF-019 -30460
	
	String p_called_from_widget = request.getParameter("p_called_from_widget")==null?"":(String)request.getParameter("p_called_from_widget");//CHL-CRF [IN035950]

	try
	{
	con=ConnectionManager.getConnection(request);
	if(highriskcode!=null )
	{
		fnval="modify";
		//pstmt=con.prepareStatement("Select short_desc, to_char(onset_date,'dd/mm/yyyy') d, to_char(close_date,'dd/mm/yyyy') d1, remarks from pr_high_risk_condition_vw where high_risk_code = ? and srl_no = ? and patient_id = ?");

	//	pstmt=con.prepareStatement("Select MR_GET_DESC.MR_HIGH_RISK(a.high_risk_code,?,'2') short_desc , to_char(a.onset_date,'dd/mm/yyyy') d, to_char(a.close_date,'dd/mm/yyyy') d1, a.remarks,occur_srl_no, from PR_HIGH_RISK_CONDITION a Where a.high_risk_code = ? and a.srl_no = ? and a.patient_id = ? "); commented for CRF-019 -30460
		pstmt=con.prepareStatement("Select MR_GET_DESC.MR_HIGH_RISK(a.high_risk_code,?,'2') short_desc , to_char(a.onset_date,'dd/mm/yyyy') d, to_char(a.close_date,'dd/mm/yyyy') d1, a.remarks,a.occur_srl_no, a.term_set_id, a.term_code from PR_HIGH_RISK_CONDITION a Where a.high_risk_code = ? and a.srl_no = ? and a.patient_id = ? "); // added for CRF-019 -30460
		pstmt.setString(1,locale);
		pstmt.setString(2,highriskcode);
		pstmt.setString(3,srlno);
		pstmt.setString(4,patient_id);

		rset=pstmt.executeQuery();
		rset.next();
		highriskdesc=rset.getString("short_desc");
		onsetdate=rset.getString("d");
		remarks=rset.getString("remarks")==null?"":rset.getString("remarks");
		ocr_srl_no = rset.getInt("occur_srl_no"); // added for CRF-019 -30460
		trm_set_id = rset.getString("term_set_id")==null?"":rset.getString("term_set_id"); // added for CRF-019 -30460
		trm_code = rset.getString("term_code")==null?"":rset.getString("term_code"); // added for CRF-019 -30460
		
		if(!onsetdate.equals("&nbsp;") )
			onsetdate = com.ehis.util.DateUtils.convertDate(onsetdate,"DMY","en",locale);

		if(rset!=null)	rset.close();
		if(pstmt!=null)	pstmt.close();

		
	}

%>

	</head>
	<body   class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'  onload='FocusFirstElement()'>
			<!-- <form name='highrisk_form' id='highrisk_form' action='../../servlet/eCA.PatHighRiskServlet?P_patient_id=<%=patient_id%>&P_practitioner_id=<%=practitioner_id%>&P_facility_id=<%=facilityId%>&P_locn_code=<%=clinic_code%>&P_locn_type=<%=locn_type%>&P_encounter_id=<%=encounter_id%>' method='post' target='messageFrame'> commented for CRF-019 - 30460--> 
			
			<form name='highrisk_form' id='highrisk_form' action='../../servlet/eCA.PatHighRiskServlet?P_patient_id=<%=patient_id%>&P_practitioner_id=<%=practitioner_id%>&P_facility_id=<%=facilityId%>&P_locn_code=<%=clinic_code%>&P_locn_type=<%=locn_type%>&P_encounter_id=<%=encounter_id%>&termSetId=<%=trm_set_id%>&termCode=<%=trm_code%>&occurSrlNo=<%=ocr_srl_no%>&srlno=<%=srlno%>' method='post' target='messageFrame'> <!-- modified for CRF-019 -30460, 37071 -->
			<table border='0' cellpadding='3' cellspacing='0' width="75%"  align = 'center'>

			<tr>
				<td class='label'  width='25%'><fmt:message key="Common.HighRiskConditions.label" bundle="${common_labels}"/></td>
    				     <td  width='75%' class ='fields'>
    				     <% if(fnval.equals("modify"))
    				     {
    				     	out.println("<input type='text' name='t' id='t' width=15 size=15 value='"+highriskdesc+"' readonly>");
    				     	out.println("<img src='../../eCommon/images/mandatory.gif'align='center'>");
    				    	out.println("<input type='hidden' name='high_risk_code' id='high_risk_code' value='"+highriskcode+"'>");

    				     }
    				     else
							 {%>
						 <select name='high_risk_code' id='high_risk_code'>
						 <option value='' >&nbsp;&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------&nbsp;&nbsp;</option>
    				     <%
							//stmt=con.prepareStatement("Select high_risk_code, short_desc from mr_high_risk where eff_status='E' order by short_desc");
							
							stmt=con.prepareStatement("Select high_risk_code, short_desc from mr_high_risk_lang_vw where eff_status='E' and language_id = ? order by short_desc");
							stmt.setString(1,locale);
							rset=stmt.executeQuery();
							if(rset!=null)
							{
							   while(rset.next())
							   {
								dat=rset.getString("short_desc");
								ID=rset.getString("high_risk_code");
								if(ID.equals(highriskcode))
								  sel="selected";
								else
									sel="";
								out.println("<option value='"+ID+ "' "+sel+">"+dat+"</option>");

							    }%>
    				    		  </select><img src='../../eCommon/images/mandatory.gif'align='center'>
    				  <%}
    				    	
								if(rset!=null)rset.close();
								if(stmt!=null)stmt.close();
							}%>

    				   </td> 
						   		   </tr>

						   <tr>
						   <td class=label width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
						   <td width='75%' class='fields'>
							<textarea name="remarks" rows="3" cols="60" maxlength='200' onKeyPress='checkMaxLimit(this,200);'    onBlur="makeValidString(this);checkMaxLimitOnBlur(this,200);" ><%=remarks%></textarea>
						   </td>
						   </tr>
						
						<%
/*
						stmt=con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy') d from dual ");
    				    rset=stmt.executeQuery();
    				    rset.next();
						*/
    				    currentdate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
    				     %>
    				    <input type='hidden' name='sys_date' id='sys_date' value='<%=currentdate%>'>

						 <% if (!fnval.equals("modify")){  %>		 
							 <script language=javascript>

							 </script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



    				  <tr>
    				      <td  class='label' width='25%'><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td><!--validate_date(sys_date,onset); validate_onsetdate(this); -->
						  <td class='fields'  width='75%'>
								<input type='text' name='onset' id='onset' value='<%=onsetdate1%>' size='10' maxlength='10'     OnBlur='CheckDate(this);isVaidwithSysDate(this,"DMY","<%=locale%>");calcage(this,ServerDate,onset);reset_date1(this)' >
								<input type='image' src="../../eCommon/images/CommonCalendar.gif"  onclick="document.getElementById('formAction').value = document.getElementById('highrisk_form').action; return showCalendarValidate('onset');"><img id="date_indicator" src='../../eCA/images/mc_history.gif' style="display:none" height='15'><img align='center'  src='../../eCommon/images/mandatory.gif'>
								<input type='hidden' name='onset_date' id='onset_date' value='<%=onsetdate1%>'>
						(&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.Last.label" bundle="${common_labels}"/>&nbsp;
								<input type = "checkbox" name = "date_type" onclick = "enableDate()"><input type='hidden' name='date_type1' id='date_type1' value='A'>&nbsp;
								<input type="text" name="b_days" id="b_days" maxlength="2" size="2" value='<%=aged%>'   
								onKeyPress='return(ChkNumberInput(this,event,0))'
								Onblur= 'CheckForNumber_L(this,onset);checkDays(this,onset);new_calci(this,"DMY","<%=locale%>",onset)'   tabIndex='4'>D&nbsp;

								<input type="text" name="b_months" id="b_months" maxlength="2" value='<%=agem%>' size="2" 
							  	onKeyPress='return(ChkNumberInput(this,event,0))'
								Onblur='CheckForNumber_L(this,onset);checkMonth(this,onset);new_calci(this,"DMY","<%=locale%>",onset)'   tabIndex='3'>M&nbsp;
								
									
								<input type="text" name="b_age" id="b_age" maxlength="3" size="3" value='<%=agey%>'    
								onKeyPress='return(ChkNumberInput(this,event,0))'
								Onblur='CheckForNumber_L(this,onset);checkYear();new_calci(this,"DMY","<%=locale%>",onset)'   tabIndex='2'>Y&nbsp;)
																
								
								&nbsp;&nbsp;<input type='hidden' name='ServerDate' id='ServerDate' value='<%=onsetdate1%>'>
								<script>
									//alert(document.forms[0].date_type.checked);
									if(document.forms[0].date_type.checked == false)
									{
										document.forms[0].b_days.disabled = true;
										document.forms[0].b_months.disabled = true;
										document.forms[0].b_age.disabled = true;
									}
								</script>
						</td>
					</tr>
					  <% } %>
					 <% if (fnval.equals("modify")) { %>
						 <tr>

    				      <td  class='label' ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></td>
						  <td class ='label'>
						<input type='text' name='onset' id='onset' value='<%=onsetdate%>' size='10' maxlength='10' readonly >
						<input type='hidden' name='onset_date' id='onset_date' value='<%=onsetdate%>'> </td>
					</tr>
						<tr>	
    				      <td  class='label' ><fmt:message key="eCA.CloseDate.label" bundle="${ca_labels}"/></td><!--check(this); -->

							<td  class=label class ='fields'>
							<input type='text' name='close' id='close' value='<%=closedate%>' size='10' maxlength='10'  Onblur='CheckDate(this);isBetweenCurrDate("<%=onsetdate%>","<%=currentdate%>",this,"DMY","<%=locale%>");calcage(this,ServerDate1,close);reset_date(this)'> 
							<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="document.getElementById('formAction').value = document.getElementById('highrisk_form').action; return showCalendarValidate('close');"><!-- <img align='center'  src='../../eCommon/images/mandatory.gif'> -->
						   <input type='hidden' name='close_date' id='close_date' value='<%=closedate%>'> 
								(&nbsp;<fmt:message key="Common.Before.label" bundle="${common_labels}"/>
								<input type="text" name="b_days1" id="b_days1" maxlength="2" size="2" value='<%=aged%>'  
								onKeyPress='return(ChkNumberInput(this,event,0))'
							   Onblur='CheckForNumber_L(this,close);checkDays(this,close);new_calci1(this,"DMY","<%=locale%>",close)'   tabIndex='4'>D&nbsp;

								<input type="text" name="b_months1" id="b_months1" maxlength="2" value='<%=agem%>' size="2"  
								onKeyPress='return(ChkNumberInput(this,event,0))'
								Onblur= 'CheckForNumber_L(this,close);checkMonth(this,close);new_calci1(this,"DMY","<%=locale%>",close)'   tabIndex='3'>M&nbsp;
								
								<input type="text" name="b_age1" id="b_age1" maxlength="3" size="3" value='<%=agey%>' 
							 	onKeyPress='return(ChkNumberInput(this,event,0))'
							Onblur='CheckForNumber_L(this,close);new_calci1(this,"DMY","<%=locale%>",close)'   tabIndex='2'>Y&nbsp;)
									
								&nbsp;
								
								<input type='hidden' name='ServerDate1' id='ServerDate1' value='<%=currentdate%>'>
									</td>
							</tr>
						   
					 <%
					       	}
					    	
								if(rset!=null)	rset.close();
								if(stmt!=null)	stmt.close();
								
							
							} catch(Exception e){
									e.printStackTrace() ;
							}
							  finally
							  {	
								 if(con!=null) ConnectionManager.returnConnection(con,request);
							  }%>
				<tr ALIGN = 'RIGHT'>	
					<TD></TD>
					<td >
							 <input type='button' name='Record' id='Record' onclick="apply()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")%>' class = 'button'>&nbsp;
							 <input type='button' name='clear' id='clear' onclick="clearform()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' class = 'button'>&nbsp;
							 <% if("".equals(p_called_from_widget)){%> 
							 <input type='button' name='cancel' id='cancel' onclick="cancel1()" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' class = 'button'>
							 <% }%> 
					 </td>
				</tr>
							  			

			</table> 
		<input type='hidden' name='text5' id='text5' value=''>
		<input type='hidden' name='text6' id='text6' value=''>
		<input type='hidden' name='text7' id='text7' value=''>
		<input type='hidden' name='text8' id='text8' value=''>
		<input type='hidden' name='text9' id='text9' value=''>
		<input type='hidden' name='text10' id='text10' value='<%=closedate%>'>
		<input type='hidden' name='function' id='function' value='<%=fnval%>'>
		<input type='hidden' name='function_name' id='function_name' value='<%=fnval%>'>
		<input type='hidden' name='Patient_Id' id='Patient_Id' value='<%=patient_id%>'>
		<input type='hidden' name='Encounter_Id' id='Encounter_Id' value='<%=encounter_id%>'>
		<input type='hidden' name='Clinic_Code' id='Clinic_Code' value='<%=clinic_code%>'>
		<input type='hidden' name='Location_Type' id='Location_Type' value='<%=locn_type%>'>
		<input type='hidden' name='Practitioner_Id' id='Practitioner_Id' value='<%=practitioner_id%>'>
		<input type='hidden' name='dob' id='dob' value='<%=dob%>'>
		<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
		<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='<%=p_called_from_widget%>'> <!-- //CHL-CRF [IN035950]-->
		
		<!-- //Added by marwan-EDGE work to hold the form action value, to reset it before form submission-->
		<input type='hidden' name='formAction' id='formAction' value=''> 
	</form>
</body>
</html>

