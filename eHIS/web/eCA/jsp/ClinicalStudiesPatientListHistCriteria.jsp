<!DOCTYPE html>
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

	String imgUrl="";

	if(sStyle.equals("IeStyle.css")){
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	}

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"> 
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src='../../eCommon/js/CommonLookup.js'></script>	
	<script type="text/javascript" src='../../eCommon/js/CommonCalendar.js'></script>
	<script language='javascript' src='../../eCA/js/ClinicalStudiesPatientListHist.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>
<body OnMouseDown='CodeArrest()' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='ClinicalStudiesPatientListHistCriteriaForm' id='ClinicalStudiesPatientListHistCriteriaForm'>
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
	
	String dfltspl="";
	String dfltage="";
	
	String term_set_id="";
	String term_set_desc=""; ///request.getParameter("Dob")
	String dob =(request.getParameter("Dob")==null)?"":request.getParameter("Dob");
	String age =(request.getParameter("Age")==null)?"":request.getParameter("Age");
	String sex1 =(request.getParameter("Sex")==null)?"":request.getParameter("Sex");
	String  practitioner_id=(String)session.getValue("ca_practitioner_id")==null?"":(String)session.getValue("ca_practitioner_id");	
	String speciality_code =(request.getParameter("speciality_code")==null)?"":request.getParameter("speciality_code");
	String login_id = (p.getProperty("login_user")==null)?"":(String)p.getProperty("login_user")  ; 
	
	toDate	=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	dfltdat	=	com.ehis.util.DateUtils.minusDate(toDate,"DMY",locale,30,"d");

%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" align='center'>
	<tr>    
		<td class="label"  width="20%" ><fmt:message key="Common.view.label" bundle="${common_labels}"/></td>
		<td class="fields" width="30%" >
			<SELECT name="view" id="view">
				<option value='A' selected ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
				<option value='S'><fmt:message key="Common.SelfRelated.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<td class='label' width='25%'><fmt:message key="Common.RestrictTo.label" bundle="${common_labels}"/></td>
		<td class='fields' width='25%' >
			<SELECT name="rest" id="rest">
				<option value='<%=facilityId%>' selected><fmt:message key="Common.loginfacility.label" bundle="${common_labels}"/></option>			
				<%
					String temFacilityId="";
					String temFacilityName="";
					try{
						String facilitySql="SELECT FACILITY_ID,FACILITY_NAME FROM SM_FACILITY_FOR_USER_VW WHERE APPL_USER_ID=? AND FACILITY_ID!=? AND TO_DATE (NVL(ACCESS_EFF_DATE_FROM,SYSDATE), 'dd/mm/yyyy') <= TO_DATE (SYSDATE, 'dd/mm/yyyy') AND TO_DATE (NVL(ACCESS_EFF_DATE_TO,SYSDATE), 'dd/mm/yyyy') >= TO_DATE (SYSDATE, 'dd/mm/yyyy')";
						pstmt = con.prepareStatement(facilitySql);
						pstmt.setString(1,login_id);
						pstmt.setString(2,facilityId);
						rs = pstmt.executeQuery();						
						while(rs.next())
						{ 
							temFacilityId = (rs.getString("FACILITY_ID")==null)?"":(String)rs.getString("FACILITY_ID");
							temFacilityName = (rs.getString("FACILITY_NAME")==null)?"":(String)rs.getString("FACILITY_NAME");
							out.println("<option value='"+temFacilityId+"' >"+temFacilityName+"</option>");	
						}						
					}catch(Exception e){
						System.out.println("Exception="+e);
					}	
					if(rs!=null)rs.close();
					if(pstmt!=null)pstmt.close();
				%>
			</SELECT>
		</td> 
	</tr>
	<tr>   
		<td class=label width="20%" ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>  
		<td class ='fields' width='25%'>
			<input type='text' name='spl_Desc' id='spl_Desc' value='' size='20' maxlength='20'onBlur="getSpeciality(this)"><input type='hidden'  name='spl' id='spl' value=''><input type='Button' name='practCodeButton' id='practCodeButton' class='button' value='?' onClick='showSpeciality()'>
		</td>
		<td class='label' width='25%'><fmt:message key="Common.gender.label" bundle="${common_labels}"/> </td>
		<td class='fields' width='25%'>
			<SELECT name="sex" id="sex">
				<option value=''>-------<fmt:message key="Common.all.label" bundle="${common_labels}"/>------</option>
				<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
				<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
				<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>	
    </tr>    
	<tr>
		<td class='label' width='20%' ><fmt:message key="Common.AgeRange.label" bundle="${common_labels}"/></td>
		<td class='fields' width="25%" >
			<input type="text" name="b_age" id="b_age" maxlength="3" size="3" value=''  onBlur='CheckForNumber_Lnew(this);' tabIndex='6'>
			Y
			<input type="text" name="b_months" id="b_months" maxlength="2" value='' size="2" onBlur='CheckForNumber_Lnew(this);checkMonthnew(this);'  tabIndex='5'>
			M	 
			<input type="text" name="b_days" id="b_days" maxlength="2" size="2" value=''   onBlur='CheckForNumber_Lnew(this);checkDaysnew(this);' tabIndex='4'>
			D
			&nbsp;&nbsp;-&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</td>
		<td class='fields' width="25%">
			<input type="text" name="b_age2" id="b_age2" maxlength="3" size="3" value=''  onBlur='CheckForNumber_Lnew(this);' tabIndex='6'>
			Y		
			<input type="text" name="b_months2" id="b_months2" maxlength="2" value='' size="2" onBlur='CheckForNumber_Lnew(this);checkMonthnew(this);'  tabIndex='5'>
			M     
			<input type="text" name="b_days2" id="b_days2" maxlength="2" size="2" value='' onBlur='CheckForNumber_Lnew(this);checkDaysnew(this);' tabIndex='4'>
			D
		</td>
		<td class='label' width='25%'>&nbsp;</td>
    </tr>    
	<tr >
		<td class="label" width="25%"  ><fmt:message key="eCA.PeriodRange.label" bundle="${ca_labels}"/></td>
		<td class="fields" >
			<input type='text' name='from_date' id='from_date' value="<%=dfltdat%>" size='10' maxLength='10'  onBlur='CheckDate(this);fromDateChecknew(this,"DMY","<%=locale%>");toDateChecknew(this,to_date,"DMY","<%=locale%>")'>
			<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('from_date')"><img src="../../eCommon/images/mandatory.gif" ></img>
			&nbsp;-&nbsp;
			<input type='text' name='to_date' id='to_date' value="<%=toDate%>" size='10' maxLength='10' onBlur='CheckDate(this);fromDateChecknew(this,"DMY","<%=locale%>");toDateChecknew(from_date,this,"DMY","<%=locale%>")'>
			<input type='image' src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('to_date')"><img src="../../eCommon/images/mandatory.gif"  ></img>
		</td>
		<td class='label' width='25%'><fmt:message key="Common.status.label" bundle="${common_labels}"/> </td>
		<td class='fields' width="25%">
			<SELECT name="status" id="status">
				<option value=''>---<fmt:message key="Common.all.label" bundle="${common_labels}"/>---</option>
				<option value='O'><fmt:message key="Common.open.label" bundle="${common_labels}"/></option>
				<option value='C'><fmt:message key="Common.close.label" bundle="${common_labels}"/></option>
			</SELECT>
		</td>
		<td class='label' width='25%'>&nbsp;</td>
		
	</tr>
	<tr>
		<td  class='label' width="20%"><fmt:message key="eCA.ResearchPatientCategory.label" bundle="${ca_labels}"/></td>
		<td  class='fields'>
			<select name='resePatCategory' id='resePatCategory' onChange='getReseaFactors()'>
							<option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
							<%
								
    				    		String sqlfac="SELECT RESEARCH_CATEG_ID,RESEARCH_CATEG_DESC FROM CA_RESEARCH_CATEGORY WHERE EFF_STATUS='E'";
    				    		pstmt = con.prepareStatement(sqlfac);
								rs = pstmt.executeQuery();
    				    		if(rs!=null)
    				    		{
    				    		   while(rs.next())
    				    		   {
    				    			String dat=(String)rs.getString("RESEARCH_CATEG_DESC");
    				    			String id=(String)rs.getString("RESEARCH_CATEG_ID");									
    				    			out.println("<option value='"+id+ "'>"+dat);
    				    		   }
								}  
							%>
    				    </select>&nbsp<img src='../../eCommon/images/mandatory.gif'> 
		</td>
		<td  class="LABEL" ><fmt:message key="eCA.ResearchCategoryFactor.label" bundle="${ca_labels}"/> </td>     
		<td  class='fields'>
			
			<select name='reseCategoryFact' id='reseCategoryFact'>
    				   	<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>    				    	
    		</select>&nbsp<img src='../../eCommon/images/mandatory.gif'>
		</td>
	</tr>	
	<tr id='diagnosis'>
		<td class='label' width="25%" ><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/>:</td>
		<td class='fields' nowrap colspan='3'>
			<select name="code_set" id="code_set"  onChange="clearDiag(this);" >
				<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
				<%
				String diagset_qry ="select a.term_set_id,term_set_desc from MR_TERM_SET a where eff_status = 'E' ";
				 try{
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
				}catch(Exception eg){
					out.println("Exception="+eg.toString());
				}
				%>	
			</select> 
			1.<input type="text" name="diag" id="diag" value="<%=arr[0]%>" size='25' maxlength='100' onBlur='' onKeyPress='' readOnly><input type="button" value="?" class="button" onClick='calllookup(diag)' name='searchdiag' id='searchdiag' disabled >
			2.<input type="text" name="diag2" id="diag2" value="<%=arr[1]%>" size='25' maxlength='100' onBlur='' onKeyPress='' readOnly><input type="button" value="?" class="button" onClick='calllookup(diag2)' name='searchdiag2' id='searchdiag2' disabled>
			3.<input type="text" name="diag3" id="diag3" value="<%=arr[2]%>" size='25' maxlength='100' onBlur='' onKeyPress='' readOnly><input type="button" value="?" class="button" onClick='calllookup(diag3)' name='searchdiag3' id='searchdiag3' disabled>
		</td>
	</tr>  
	<tr>    
		<td class='label' ><fmt:message key="Common.groupby.label" bundle="${common_labels}"/></td>
		<td class='fields' >
			<SELECT name="group" id="group">
				<option value='3'><fmt:message key="eCA.RecordedPract.label" bundle="${ca_labels}"/></option>
				<option value='4'><fmt:message key="eCA.ResearchCategory.label" bundle="${ca_labels}"/></option>
			</SELECT>	
		</td>		
		<td class='label' >&nbsp;</td>
		<td  align='right'>
			<input type='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick="return showSearch()">
			<input type='button' name='clear' id='clear' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  onClick="clearPage()">
		</td>
    </tr>
</table>
	<%if(!imgUrl.equals("")){ %>
		 <img src='<%=imgUrl%>' width='100%' height='15'/> 
	<%}%>

  <input type='hidden' name='operation_mode' id='operation_mode'	value=''>
  <input type='hidden' name='query_string' id='query_string'	value="">
  <input type='hidden' name='facilityid' id='facilityid'	value='<%=facilityId%>'>
  <input type='hidden' name='patient_id' id='patient_id'	value='<%=patient_id%>'>
  <input type='hidden' name='dob' id='dob'	value='<%=dob%>'>
  <input type='hidden' name='age' id='age'	value='<%=age%>'>
  <input type='hidden' name='sex1' id='sex1'	value='<%=sex1%>'>
  <input type='hidden' name='practitioner_Id' id='practitioner_Id'	value='<%=practitioner_id%>'>
  <input type='hidden' name='Encounter_Id' id='Encounter_Id'	value='<%=encounter_id%>'>
  <input type='hidden' name='speciality_code' id='speciality_code'	value='<%=speciality_code%>'>
  <input type=hidden value='<%=locale%>' name='locale'>

</form>
</center>
<%
	}
catch(Exception e)
{
	//out.println("Exception @ RelatedPatientHistCriteria.jsp"+e.toString());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null)
		ConnectionManager.returnConnection(con, request);
}
%>
</body>
</html>

