<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           	created
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

04/05/2015  IN053425		NijithaS										ML-BRU-SCF-1544  
----------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*, java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<title><fmt:message key="eCA.RelatedPatientHistoryCriteria.label" bundle="${ca_labels}"/></title>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


	// added by Arvind @ 28-11-08 

	String imgUrl="";

	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
			 //end

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> 
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<!-- <script language='javascript' src='../../eCommon/js/dchk.js'></script> -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>	
	<script type="text/javascript" src='../../eCommon/js/CommonCalendar.js'></script>
	<script language='javascript' src='../../eCA/js/RelatedPatientHist.js'></script>
	<script src="../../eCommon/js/DateUtils.js" language="javascript"></script>
	
	<script language=javascript src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='RelPatHistCriteriaForm' id='RelPatHistCriteriaForm'>
<%
	//String queryString=request.getQueryString();

	
	Connection			con		=	null;
	PreparedStatement	pstmt	=	null;
	ResultSet			rs		=	null;

	String sqlSpec = "";
	String spl_code= "";
	String spl_desc= "";
	String toDate="";
    String dfltdat="";
	String note_type		="";
    String note_type_desc="";

	try
	{
		con				=	ConnectionManager.getConnection(request);
 
    String patient_id		= (request.getParameter("patient_id")==null)?"":request.getParameter("patient_id");
	String encounter_id		= (request.getParameter("encounter_id")==null)?"":request.getParameter("encounter_id");
    String	facilityId 	= (String) session.getValue( "facility_id" )==null ? "" : (String) session.getValue( "facility_id" ) ;
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

	String arr[]={"","",""};
	//int count = 0;
	String dfltspl="";
	String dfltage="";
	String dfltyears="";
	String dfltmonths="";
	String dfltdays="";
	String term_set_id="";
	String term_set_desc=""; ///request.getParameter("Dob")
	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	String age =(request.getParameter("Age")==null)?"":request.getParameter("Age");
	String sex1 =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	String Practitioner_Id =(request.getParameter("Practitioner_Id")==null)?"":request.getParameter("Practitioner_Id");
	//String Encounter_Id =(request.getParameter("Encounter_Id")==null)?"":request.getParameter("Encounter_Id");
	String speciality_code =(request.getParameter("speciality_code")==null)?"":request.getParameter("speciality_code");

	
	try
	{
		if(!patient_id.equals("") && !facilityId.equals("") && !encounter_id.equals("") )
		{
		/*	String dfltdiagSql="select diag_code||'-'||DIAG_DESC Diag from pr_diagnosis where patient_id=? and ONSET_FACILITY_ID = ? and ONSET_ENCOUNTER_ID=? and term_set_id=?  ";


			pstmt = con.prepareStatement(dfltdiagSql);
			pstmt.setString(1,patient_id);
			pstmt.setString(2,facilityId);
			pstmt.setString(3,encounter_id);
			rs = pstmt.executeQuery();

			while(rs.next() && count < 3)
			{
				arr[count]=(rs.getString("Diag")==null)?"":rs.getString("Diag");
			//	out.println("<script>alert('diag"+arr[count]+"');</script>");
				count++;
			}

			if(rs!=null) rs.close();
  		    if(pstmt!=null) pstmt.close(); */

			String dfltageSql="SELECT SPECIALTY_CODE,GET_AGE(B.DATE_OF_BIRTH) Age FROM PR_ENCOUNTER A, MP_PATIENT B WHERE A.FACILITY_ID=? AND ENCOUNTER_ID=? AND B.PATIENT_ID=A.PATIENT_ID";

			pstmt = con.prepareStatement(dfltageSql);
			
			pstmt.setString(1,facilityId);
			pstmt.setString(2,encounter_id);
			rs = pstmt.executeQuery();

			if(rs.next())
			{
				dfltspl=(rs.getString("SPECIALTY_CODE")==null)?"":rs.getString("SPECIALTY_CODE");
				dfltage=(rs.getString("Age")==null)?"":rs.getString("Age");
               //out.println("<script>alert('dfltspl"+dfltspl+"dfltage"+dfltage+"');</script>");
			}
			if(!dfltage.equals(""))
            {
			//	dfltage = "25D";
				if(dfltage.indexOf("Y")>0)
				dfltyears = dfltage.substring(0,dfltage.indexOf("Y"));
				if(dfltage.indexOf("M")>0)
                dfltmonths = dfltage.substring(dfltage.indexOf("Y")+1,dfltage.indexOf("M"));
				if(dfltage.indexOf("D")>0)
                dfltdays = dfltage.substring(0,dfltage.indexOf("D"));

				//out.println("<script>alert('dfltyears"+dfltyears+"dfltmonths"+dfltmonths+"dfltdays"+dfltdays+"');</script>");


			}

		}

	}
	catch(Exception e)
	{
		//out.println("Exception@1: "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
	if(rs!=null) rs.close();
  	if(pstmt!=null) pstmt.close();	

	} 
	
/*
	try
	{
		String sysdateSql="select to_char(sysdate,'dd/mm/yyyy') toDate,to_char(sysdate-30,'dd/mm/yyyy') dfldat from dual";

			pstmt = con.prepareStatement(sysdateSql);
			rs = pstmt.executeQuery();

			if(rs.next())
			{
				toDate=rs.getString(1);
				dfltdat=rs.getString(2);

			}
	}
	catch(Exception e)
	{
		out.println("Exception@1: "+e);
	}
	finally
	{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	}
	*/
	toDate	=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	dfltdat	=	com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,30,"d");

%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
<tr>
    
	<td class="label"  width="20%" ><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
	<td class="fields" width="30%" ><SELECT name="view" id="view">
	<option value='A' selected ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<option value='S'><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/></option>
	</SELECT>
	</td>
    <td class='label' width='25%'><fmt:message key="Common.RestrictTo.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%' ><SELECT name="rest" id="rest">
	<option value='F' selected><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>
	<option value='E'><fmt:message key="Common.enterprise.label" bundle="${common_labels}"/></option>
	</SELECT>
	</td>   
     
</tr>
<tr>
   
   <td class=label width="20%" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
  
 <!--  <td class='fields' width="25%"><select name='spl' id='spl'  onChange='' >
	<option value=''>-----------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------------</option>
	<%
             sqlSpec = "SELECT SPECIALITY_CODE,SHORT_DESC FROM AM_SPECIALITY WHERE EFF_STATUS='E' ORDER BY SHORT_DESC";

					  try
						{
						  pstmt = con.prepareStatement(sqlSpec);
						  rs = pstmt.executeQuery();
						  while(rs!=null && rs.next())
						  {
							spl_code=rs.getString(1);
							spl_desc=rs.getString(2);
							if(spl_code.equals(dfltspl))
                            out.println("<option value='"+spl_code+"' selected>"+spl_desc+"</option>");
							else
							out.println("<option value='"+spl_code+"'>"+spl_desc+"</option>");
						  }
						}//try 
						catch(Exception eg)
						{
						   out.println("Exception="+eg.toString());
						}
						finally
						{
						   if(rs!=null) rs.close();	
						   if(pstmt!=null) pstmt.close();
						}		
					%>
	</select>
    </td> -->
	<td class ='fields' width='25%'>
	<input type='text' name='spl_Desc' id='spl_Desc' value='' size='20' maxlength='20'onBlur="getSpeciality(this)"><input type='hidden'  name='spl' id='spl' value=''><input type='Button' name='practCodeButton' id='practCodeButton' class='button' value='?' onClick='showSpeciality()'></td>

	<td class='label' width='25%'>

	<fmt:message key="Common.gender.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	<SELECT name="sex" id="sex">
	<option value=''>-------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------</option>
	<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
	<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
	<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
	</SELECT>
	</td>

	<!-- <td class='fields' >1. 
	 <input type="text" name="diag" id="diag" value="<%=arr[0]%>" size='35' maxlength='100' onBlur='' onKeyPress='' readOnly><input type="button" value="?" class="button" onClick='calllookup(diag)' name='searchdiag' id='searchdiag'><img src="../../eCommon/images/mandatory.gif"></img>
	 </td> -->
	
    </tr>
    
	 <tr>

     <td class='label' width='20%' ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
     <td class='fields' width="25%" >
     <input type="text" name="b_age" id="b_age" maxlength="3" size="3" value='<%=dfltyears%>'  onBlur='CheckForNumber_Lnew(this);' tabIndex='6'>
	 Y
	 <input type="text" name="b_months" id="b_months" maxlength="2" value='<%=dfltmonths%>' size="2" onBlur='CheckForNumber_Lnew(this);checkMonthnew(this);'  tabIndex='5'>
	 M
	 
	 <input type="text" name="b_days" id="b_days" maxlength="2" size="2" value='<%=dfltdays%>'   onBlur='CheckForNumber_Lnew(this);checkDaysnew(this);' tabIndex='4'>
	 D
	 
	 &nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	 </td><td class='fields' width="25%">
	 <input type="text" name="b_age2" id="b_age2" maxlength="3" size="3" value='<%=dfltyears%>'  onBlur='CheckForNumber_Lnew(this);' tabIndex='6'>
	 Y
		
     <input type="text" name="b_months2" id="b_months2" maxlength="2" value='<%=dfltmonths%>' size="2" onBlur='CheckForNumber_Lnew(this);checkMonthnew(this);'  tabIndex='5'>
	 M
     
	 <input type="text" name="b_days2" id="b_days2" maxlength="2" size="2" value='<%=dfltdays%>' onBlur='CheckForNumber_Lnew(this);checkDaysnew(this);' tabIndex='4'>
	 D
	 </td> 
	 <!-- <td class='label' width='25%'>
    <fmt:message key="Common.status.label" bundle="${common_labels}"/> 
	<SELECT name="status" id="status" class='fields'>
	<option value=''>---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---</option>
	<option value='A'><fmt:message key="eCA.Alive.label" bundle="${ca_labels}"/></option>
	<option value='D'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></option>
	</SELECT>

	</td> -->
       
    </tr>
    
	<tr >
	<td class="label" width="20%"  ><fmt:message key="eCA.PeriodRange.label" bundle="${ca_labels}"/></td>
	<td class="fields" ><input type='text' name='from_date' id='from_date' value="<%=dfltdat%>" size='10' maxLength='10'  onBlur='CheckDate(this);fromDateChecknew(this,"DMY","<%=locale%>");toDateChecknew(this,to_date,"DMY","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date')"><img src="../../eCommon/images/mandatory.gif" ></img>
&nbsp;-&nbsp;<input type='text' name='to_date' id='to_date' value="<%=toDate%>" size='10' maxLength='10' onBlur='CheckDate(this);fromDateChecknew(this,"DMY","<%=locale%>");toDateChecknew(from_date,this,"DMY","<%=locale%>")'><input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date')"><img src="../../eCommon/images/mandatory.gif"  ></img>
	</td>
	<td class='label' width='25%'>
    <fmt:message key="Common.status.label" bundle="${common_labels}"/> </td>
	<td class='fields' width="25%"><SELECT name="status" id="status">
	<option value=''>---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---</option>
	<option value='A'><fmt:message key="eCA.Alive.label" bundle="${ca_labels}"/></option>
	<option value='D'><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></option>
	</SELECT>

	</td>
	
	<td  width="20%" >
	<td class='fields' style='display:none'>								   
	    <INPUT name="byselect" id="byselect"  TYPE="radio" VALUE="byDia" CHECKED onClick="hideShowRowDoC()"><fmt:message key="eCA.ByDiagnosis.label" bundle="${ca_labels}"/> 
		<INPUT name="byselect" id="byselect"  TYPE="radio" VALUE="byDoc" onClick="hideShowRowDoC()" > <fmt:message key="eCA.ByDocument.label" bundle="${ca_labels}"/> 
	</td>
	</td>		
	</tr>
	<tr>
	<td id="SearchLabel"  style='display:none' class='label' width="20%"><fmt:message key="eCA.SearchWord.label" bundle="${ca_labels}"/></td>
	<td id="SearchWord" style='display:none' class='fields'>
	<input type="text" name="docName" id="docName" maxlength='20' value=''><img src="../../eCommon/images/mandatory.gif" ></img></td>
	<td id="NoteLabel" style='display:none' class="LABEL" ><fmt:message key="Common.NoteType.label" bundle="${common_labels}"/> </td>     
	<td id="NoteField" style="display:none" class='fields'><input type='text'  name='note_type_desc' id='note_type_desc' value="<%=note_type_desc%>" size="20"   onBlur='getnotetype(this)' >
	<input type='button' name='note_type_search' id='note_type_search' value='?' class='button' onClick='getnotetype(this);'><input type='hidden' name='note_type' id='note_type' value="<%=note_type%>"></td>
	</tr>

	<tr id='diagnosis'><td class='label' width="25%" ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>:</td>
     <td class='fields' nowrap colspan='4'>
	 <select name="code_set" id="code_set"  onChange="clearDiag(this);" ><option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
	<%
	String diagset_qry ="select a.term_set_id,term_set_desc from MR_TERM_SET a where eff_status = 'E' ";

	 try
		{
		  pstmt = con.prepareStatement(diagset_qry);
		  rs = pstmt.executeQuery();
		  while(rs!=null && rs.next())
		  {
			term_set_id   =rs.getString(1);
			term_set_desc =rs.getString(2);
			out.println("<option value='"+term_set_id+"' >"+term_set_desc+"</option>");
							
		  }
		  if(rs!=null) 
			  rs.close();
		  if(pstmt!=null) 
			  pstmt.close();
		}//try 
		catch(Exception eg)
		{
		   out.println("Exception="+eg.toString());
		}


	%>
	
	
	</select><img src="../../eCommon/images/mandatory.gif"></img>
	 
	 1.<input type="text" name="diag" id="diag" value="<%=arr[0]%>" size='25' maxlength='100' onBlur='' onKeyPress='' readOnly><input type="button" value="?" class="button" onClick='calllookup(diag)' name='searchdiag' id='searchdiag' disabled ><img src="../../eCommon/images/mandatory.gif"></img>
	 2.<input type="text" name="diag2" id="diag2" value="<%=arr[1]%>" size='25' maxlength='100' onBlur='' onKeyPress='' readOnly><input type="button" value="?" class="button" onClick='calllookup(diag2)' name='searchdiag2' id='searchdiag2' disabled>
	3.<input type="text" name="diag3" id="diag3" value="<%=arr[2]%>" size='25' maxlength='100' onBlur='' onKeyPress='' readOnly><input type="button" value="?" class="button" onClick='calllookup(diag3)' name='searchdiag3' id='searchdiag3' disabled>
    
	Other Diagnosis
					<input class = 'fields' type='checkbox' name='otherdiag' id='otherdiag' value='N' onClick='enableOtherDiag(this)' ></input><!--IN053425-->
    </td>
	</tr>
  
  <tr>
    
	<td class='label' ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
	<td class='fields' >
	<SELECT name="group" id="group">
	<option value='1'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></option>
	<option value='4'><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
	<option value='8'><fmt:message key="Common.DispType.label" bundle="${common_labels}"/></option>
	</SELECT>	</td>		
	<td class='label' ></td>
    <td  align='right'>
	<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="return showSearch()">
    <input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  onClick="clearPage()">
    </td>
    </tr>
    
	
   </table>

   <!-- added by arvind @ 28-11-08 -->

				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>

				<!-- end -->

  <input type='hidden' name='operation_mode' id='operation_mode'	value=''>
  <input type='hidden' name='query_string' id='query_string'	value="">
  <input type='hidden' name='facilityid' id='facilityid'	value='<%=facilityId%>'>
  <input type='hidden' name='patient_id' id='patient_id'	value='<%=patient_id%>'>
  <input type='hidden' name='dob' id='dob'	value='<%=dob%>'>
  <input type='hidden' name='age' id='age'	value='<%=age%>'>
  <input type='hidden' name='sex1' id='sex1'	value='<%=sex1%>'>
  <input type='hidden' name='Practitioner_Id' id='Practitioner_Id'	value='<%=Practitioner_Id%>'>
  <input type='hidden' name='Encounter_Id' id='Encounter_Id'	value='<%=encounter_id%>'>
  <input type='hidden' name='speciality_code' id='speciality_code'	value='<%=speciality_code%>'>
  <input type=hidden value='<%=locale%>' name='locale'>

</form>
</center>
<%
	}
catch(Exception e)
{
	out.println("Exception @ RelatedPatientHistCriteria.jsp"+e.toString());
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con, request);
}
%>
</body>
</html>

