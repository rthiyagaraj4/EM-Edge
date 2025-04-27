<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCA.*,eCommon.XSSRequestWrapper" %>

<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<Script src ="../../eCommon/js/CommonLookup.js" language ="JavaScript"></Script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/HealthRiskFactorsForDisease.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
 function enable_txt(obj){
		if(obj.value!='00')		        
		  document.forms[0].search_txt.disabled=false;		 		
		else
		{
			document.forms[0].search_txt.disabled=true;
			document.forms[0].search_txt.value="";
		}
	}
</script>
	
<%
	Connection con = null;
	ResultSet termcodeRs			= null;
	PreparedStatement termcodeStmt	= null;
	String locale					= (String)session.getAttribute("LOCALE");
	String Practitioner_Id			= (String)session.getAttribute("ca_practitioner_id");
	String termcodeSql				= "";
	String termsetid				= "";
	String termsetdesc				= "";
	String globaluser 				= "";
//	String dat="";
	String facility="";
//	String pract="";
//	String en="";
//	String id="";
	String rfiReadOnlyYN = "";
	int rowID = 0;
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String mode	   = request.getParameter("mode").trim();
	String tableID = "risk_fact_disease";
	System.out.println(" MODE " + mode);
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	globaluser = (String)p.getProperty("login_user");
	String risk_grp_type_ind = "";
	/* HealthRiskFactorsBean beanObj = new HealthRiskFactorsBean();
	String mod_term_set_id =  request.getParameter("term_set_id") == null? "" : request.getParameter("term_set_id").trim() ;
	String mod_term_set_desc = request.getParameter("term_set_desc") == null? "" : request.getParameter("term_set_desc").trim() ;
	String mod_diag_code =  request.getParameter("term_set_code") == null? "" : request.getParameter("term_set_code").trim() ;
	String mod_diag_desc =  request.getParameter("diag_code_desc") == null? "" : request.getParameter("diag_code_desc").trim() ;
	String risk_grp_type_desc = "";
	
	String checkedYN = "";
	String mandatoryYN = "";
	ResultSet resultSet = null;
	
	System.out.println(" 1 " + mod_term_set_id  + " 2 " + mod_term_set_desc +" 3 " + mod_diag_code + " 4 " + mod_diag_desc ); */
	con = ConnectionManager.getConnection(request);
	if(mode.equals("2")) {
	/*	resultSet = beanObj.getRiskFactDiseaseDetails(mod_term_set_id, mod_diag_code, risk_grp_type_ind, con);
		System.out.println(" 72 RESULT SET CREATED " + resultSet);
		rfiReadOnlyYN		= "ReadOnly"; */
		rowID = 0; 
	}
	else {
		rowID = -1;
	} 
	 
	
	
	String facilityid=(String)session.getValue("facility_id") ;

	facility=request.getParameter("facility_id")==null ||  request.getParameter("facility_id").equals("") ?facilityid:request.getParameter("facility_id");
	//pract=request.getParameter("practitioner_id")==null ?"":request.getParameter("practitioner_id");

	try
	{
	//con = ConnectionManager.getConnection(request);
	
	
%> 


	
	</head>

	<body  OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()' onload = 'showOtherFields(<%=mode%>)'>
		<form name='HealthRiskFactorsForDisease' id='HealthRiskFactorsForDisease' action='../../servlet/eCA.RiskFactorsForDiseaseServlet' method='post' target='messageFrame'>
			<br>
			<table border='0' cellpadding='0' cellspacing='0' align='center' width='75%'>				
				<tr>
					<td colspan='4' >&nbsp;</td>
				</tr>
    			<tr>
    				<TD class='label'   width='20%' ><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/></TD>
					<TD class='fields'  width='80%' colspan="3">
						<SELECT name="terminology_set" id="terminology_set" onchange = 'showOtherFields(<%=mode%>);refreshFields();' >
							<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
							<%
							try
							{
								
							//	con = ConnectionManager.getConnection(request);
								termcodeSql = "select term_set_id,mr_get_desc.mr_term_set(term_set_id,'"+locale+"',1)term_set_desc from MR_TERM_SET where eff_status='E' order by term_set_desc";
								termcodeStmt = con.prepareStatement(termcodeSql);
								termcodeRs = termcodeStmt.executeQuery();
								if(termcodeRs!=null)
								{
									while(termcodeRs.next())
									{
										termsetid = termcodeRs.getString("term_set_id");
										termsetdesc = termcodeRs.getString("term_set_desc");
										out.println("<option value='"+termsetid+"'>"+termsetdesc+"</option>");
									}
									if(termcodeRs!=null) termcodeRs.close();
									if(termcodeStmt!=null) termcodeStmt.close();
								}

							}
							catch (Exception e)
							{
								//out.println(e.toString());//common-icn-0181
								e.printStackTrace();
							}
							finally
							{
								if(termcodeRs!=null) termcodeRs.close();
								if(termcodeStmt!=null) termcodeStmt.close();
							}
						%>
						</SELECT>
						<img src='../../eCommon/images/mandatory.gif'></img>
					</TD>   		
				</tr>	
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr id = 'diag_diplay' style = "display:none" >
					<td class='label'  width='25%' ><fmt:message key="Common.DiagnosisCode.label" bundle="${common_labels}"/> </td>
					<td class='fields' width='40%'><input type="text" name="diagprob_desc" id="diagprob_desc" value="" readonly size='50'  maxlength = '100' onblur = 'show_window();getRiskFactorsDiseaseData();'  ><input type='button' class='button' value='?' onclick='show_window()' name = 'diagprob_button'><img  src='../../eCommon/images/mandatory.gif'>
					<input type="hidden"  name = "diagprob_code" value=""> </td>
				</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr id = 'search_diplay' style = "display:none" >
					<td class='label'  width='20%' ><fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td class='fields' colspan="3" width='80%'>
						<SELECT name="search_by_" id="search_by_">
							<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>	
							<option value="I"><fmt:message key="Common.Individual.label" bundle="${common_labels}"/></option>
							<option value="G"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></option>
						</SELECT>
					</td>
					
				</tr>
				<tr>
					<td colspan='4' >&nbsp;</td>
				</tr>
				<tr id = 'search_diplay1' style = "display:none" >					
					<td class='label'  width='20%' ><fmt:message key="eCA.riskfactor.label" bundle="${ca_labels}"/></td>
					<td class='fields'  width='70%'>
						<input type="text"  name="risk_factor_desc_" id="risk_factor_desc_" value="" size='50'  maxlength = '100'  onblur = 'riskFactorsearchOnClick(risk_factor_desc_);'  >
						<input type='button' class='button' value='?'onclick = 'riskFactorsearchOnClick(risk_factor_desc_);'/> 
						<input type="hidden" name="risk_factor_code_" id="risk_factor_code_" value=""/> 
						<input type="button" value="Add" onClick="addRiskFactorsCode('risk_fact_disease',<%=mode%>)"/>
						
					</td>
						
				</tr>
				<tr>
					<td colspan='4' >&nbsp;</td>
				</tr>
				<tr id = 'search_data' style = "display:none" >
					<td colspan="4" >
						<DIV style="width:100vw;height:50vh;overflow:auto">
							<table id = 'risk_fact_disease' cellpadding='0' cellspacing='0' ">
								<tr>
									<th width="25%" class='columnHeadercenter'><fmt:message key="Common.type.label" bundle="${common_labels}"/></th>
									<th width="45%" class='columnHeadercenter'><fmt:message key="eCA.riskfactor.label" bundle="${ca_labels}"/>s &nbsp;<img src='../../eCommon/images/mandatory.gif'></th>
									<th width="25%" class='columnHeadercenter'><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/> Y/N</th>
									<th width="15%" class='columnHeadercenter' align="center">
										<input type="button" name="removeButton" id="removeButton" value="Remove" onClick="deleteRow('risk_fact_disease',<%=mode%>)" /> 
									</th>
								</tr>
							</table>
						</DIV>
					</td>
				</tr>
			</table>
			
    <% 
	 }
	  catch(Exception e){
		//  out.print(e);//COMMON-ICN-0181
		  e.printStackTrace();//COMMON-ICN-0181

		  }
	  finally
	  {
		 try
		{
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		ConnectionManager.returnConnection(con,request);
	  }%>

<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">			
<input type="hidden" name="termsetid" id="termsetid" value="<%=termsetid%>">	
<input type="hidden" name="Practitioner_Id" id="Practitioner_Id" value="<%=Practitioner_Id%>">	
<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
<input type="hidden" name="rowID" id="rowID" value="<%=rowID %>" />  
<input type="hidden" name="tableID" id="tableID" value="<%=tableID %>" />
<input type="hidden"  name = "risk_grp_type_ind" value =  "<%= risk_grp_type_ind %>" >
</form>
</body>
</html>

