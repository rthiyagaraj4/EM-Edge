<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="eCA.*,eOR.*,eOR.Common.*,java.sql.*, java.util.*, java.text.*,eCommon.Common.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String	sys_date_time					=	com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	String mode	= request.getParameter("mode")==null?"":request.getParameter("mode");
	
	String bean_id="@cagenogrambean"+patient_id;
	String bean_name="eCA.CAGenogramBean";
	
	CAGenogramBean bean			= new CAGenogramBean() ;
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCA/js/CAPatientGenogram.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js" />
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<style>
		.gridDataSelect
		{
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #FFFFFF;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
			border-bottom:1px;
			border-top:0px;
			border-left:0px;
			border-right:0px;	
			background-color: #2E9AFE;	
			border-style:solid;
			border-color:#EEEEEE;
		}
		.gridDataUpdate
		{
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #FFFFFF;
			font-weight:normal;
			text-align:left;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
			border-bottom:1px;
			border-top:0px;
			border-left:0px;
			border-right:0px;	
			background-color: #FF8000;	
			border-style:solid;
			border-color:#EEEEEE;
		}
	</style>
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()"> 
<form name='genogramAddFamilyDtlsFrm' id='genogramAddFamilyDtlsFrm' action='../../servlet/eCA.CAGenogramServlet' method='post' target='messageFrame' >
	<table cellpadding=3 cellspacing=0 border=4 width="100%" align=center>
		<tr>
			<td>				
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
					<tr>
						<td class='label'><fmt:message key="eCA.GenogramOfOtherFamilyMemberExists.label" bundle="${ca_labels}"/>
							  
							&nbsp;&nbsp;
							<input type="radio" id="fmExistY" name="fmExists" id="fmExists" value="Y" onclick="changeFMExist('Y')" /> Yes
							&nbsp;&nbsp;
							<input type="radio" id="fmExistN"  name="fmExists" id="fmExists" value="N" checked onclick="changeFMExist('N')"/> No
						</td>
					</tr>
					<tr>
						<td class='label'><fmt:message key="eCA.NonPatientID.label" bundle="${ca_labels}"/>
							&nbsp;&nbsp;
							<input type="text" name="geno_person_desc" id="geno_person_desc" id="patId" value=""  onBlur="genoPatientDetails();" disabled />&nbsp;<input type="button" id="patId_" name="" id="" onclick="genoPatientDetails();" value="?" disabled />
							<input type="hidden" name="geno_person_id" id="geno_person_id" value="">
							&nbsp;
							<img src='../../eCommon/images/mandatory.gif'>
						</td>
					</tr>
										<tr>
						<td class='columnHeadercenter'><fmt:message key="eCA.FamilyMembers.label" bundle="${ca_labels}"/></td>
					</tr>
					<tr>
						<td>
							<DIV style="width:100%;height:160;border:1px solid red;overflow:auto">
								<table cellpadding=3 cellspacing=0 border=0 width="100%" id="displayTable" align=center>
									<tr>
										<th class='columnHeadercenter' width="5%">&nbsp;</th>
										<th class='columnHeadercenter' width="10%"><fmt:message key="eCA.PatientID.label" bundle="${ca_labels}"/> </th>
										<th class='columnHeadercenter' width="20%"><fmt:message key="eCA.PatientName.label" bundle="${ca_labels}"/> </th>
										<th class='columnHeadercenter' width="10%"><fmt:message key="eCA.Age.label" bundle="${ca_labels}"/> </th>
										<th class='columnHeadercenter' width="10%"><fmt:message key="eCA.Gender.label" bundle="${ca_labels}"/> </th>
										<th class='columnHeadercenter' width="15%"><fmt:message key="eCA.DeceasedDateTime.label" bundle="${ca_labels}"/> </th>
										<th class='columnHeadercenter' width="10%"><fmt:message key="eCA.Relation.label" bundle="${ca_labels}"/> </th>
										<th class='columnHeadercenter' width="20%"><fmt:message key="eCA.RelationWith.label" bundle="${ca_labels}"/> </th>
									</tr>
									<%
										Connection			con			=	null;
										PreparedStatement	pstmt		=	null;
										ResultSet			rs			=	null;
										String 				query		=	null;
										int totalRecords=1;
										String totalGridPatIds ="";
										String selectNonPatID  = "";
										String selectNonPatName = "";
										String selectNonPatSex	= "";
										String selectSrlNo		="";
										String genoId		   = "";
										try{
											con				=	ConnectionManager.getConnection(request);
											//bean.insertPatDtls(request);											
											query	=	" SELECT A.GENO_ID,A.SRL_NO,A.PATIENT_ID,A.NON_PATIENT_ID,A.NAME,A.SEX,DECODE(A.SEX, 'M', 'Male', 'F', 'Female', 'U', 'Unknown') SEX_DESC,A.DATE_OF_BIRTH,CA_GET_AGE(A.DATE_OF_BIRTH,SYSDATE,'YMD') AGE,A.DECEASED_YN,TO_CHAR(A.DECEASED_DATE,'DD/MM/YYYY') DECEASED_DATE,A.DECEASED_REMARKS,(SELECT RELTN_DESC FROM CA_GENO_RELTN_MAST WHERE RELTN_TYPE_ID=C.RELATION_TYPE_ID AND RELTN_ID=C.RELATION_ID) RELATION ,(SELECT NAME FROM CA_GENOGRAM_ATTRIBUTE D WHERE D.NON_PATIENT_ID=C.FROM_GENOID) RELATIONWITH FROM CA_GENOGRAM_ATTRIBUTE A INNER JOIN CA_GENOGRAM_ATTRIBUTE B ON A.GENO_ID = B.GENO_ID LEFT JOIN CA_GENOGRAM_RELATION C ON A.GENO_ID = C.GENO_ID AND B.GENO_ID=C.GENO_ID AND A.SRL_NO=C.SRL_NO AND A.NON_PATIENT_ID=C.TO_GENOID AND C.REL_REV_FLAG ='N' WHERE B.PATIENT_ID=? ORDER BY A.SRL_NO";

											pstmt			=	con.prepareStatement(query);
											pstmt.setString(1,patient_id);
											
											rs				=	pstmt.executeQuery();
											String className="gridData";											
											while(rs.next()){
												if(patient_id.equals(rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID"))){
													className="gridDataSelect";
													selectNonPatID 		= rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID");
													selectNonPatSex 	= rs.getString("SEX")==null?"":(String)rs.getString("SEX"); 
													genoId				=	rs.getString("GENO_ID")==null?"":(String)rs.getString("GENO_ID");
													selectNonPatName 	= rs.getString("NAME")==null?"":(String)rs.getString("NAME");
													selectSrlNo	 		= rs.getString("SRL_NO")==null?"":(String)rs.getString("SRL_NO");
												}else{
													className="gridData";
												}
											
											%>	
												<tr bgcolor="#FF0000" onclick="selectRow('<%=totalRecords%>')" ondblclick="selectRowValues('<%=totalRecords%>')" >
													<td class='<%=className%>' >
													<%
													if(patient_id.equals(rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID"))){ 
														if("M".equals(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))){
													%>
															<img src='../../eCA/images/IndexPatient_M.PNG'>
													<%
														}else if("F".equals(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))){
													%>
															<img src='../../eCA/images/IndexPatient_F.PNG'>
													<%	
														
														}else if("U".equals(rs.getString("SEX")==null?"":(String)rs.getString("SEX"))){
													%>
															<img src='../../eCA/images/IndexPatient_U.PNG'>
													<%	
														
														}
													}
													%>
													&nbsp;</td>
													<td class='<%=className%>' ><%=rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID") %>&nbsp;</td>
													<td class='<%=className%>' ><%=rs.getString("NAME")==null?"":(String)rs.getString("NAME") %>&nbsp;</td>
													<td class='<%=className%>' ><%=rs.getString("AGE")==null?"":(String)rs.getString("AGE") %>&nbsp;</td>
													<td class='<%=className%>' ><%=rs.getString("SEX_DESC")==null?"":(String)rs.getString("SEX_DESC") %>&nbsp;</td>
													<td class='<%=className%>' ><%=rs.getString("DECEASED_DATE")==null?"":(String)rs.getString("DECEASED_DATE") %>&nbsp;</td>
													<td class='<%=className%>' ><%=rs.getString("RELATION")==null?"":(String)rs.getString("RELATION") %>&nbsp;</td>
													<td class='<%=className%>' ><%=rs.getString("RELATIONWITH")==null?"":(String)rs.getString("RELATIONWITH") %>&nbsp;</td>
													<input type="hidden" id="gridNonPatId<%=totalRecords%>" name="gridNonPatId<%=totalRecords%>" value="<%=rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID") %>"/>
													<input type="hidden" id="gridGenoId<%=totalRecords%>" name="gridGenoId<%=totalRecords%>" value="<%=rs.getString("GENO_ID")==null?"":(String)rs.getString("GENO_ID") %>"/>
													<input type="hidden" id="gridSrlNo<%=totalRecords%>" name="gridSrlNo<%=totalRecords%>" value="<%=rs.getString("SRL_NO")==null?"":(String)rs.getString("SRL_NO") %>"/>
													<input type="hidden" id="gridNonPatSex<%=totalRecords%>" name="gridNonPatSex<%=totalRecords%>" value="<%=rs.getString("SEX")==null?"":(String)rs.getString("SEX") %>"/>
													<input type="hidden" id="gridNonPatName<%=totalRecords%>" name="gridNonPatName<%=totalRecords%>" value="<%=rs.getString("NAME")==null?"":(String)rs.getString("NAME") %>"/>
												</tr>
											<%
												totalRecords++; 												
												
												if(!"".equals(rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID"))){
													if(!"".equals(totalGridPatIds))
														totalGridPatIds = totalGridPatIds+","+(rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID"));
													else
														totalGridPatIds = totalGridPatIds +(rs.getString("PATIENT_ID")==null?"":(String)rs.getString("PATIENT_ID"));
												}
											}
											
											if(totalRecords>1){
												%>
													<script>
														document.getElementById("fmExistY").disabled = true;
														document.getElementById("fmExistN").disabled = true;
														
													</script>
												<%
											}else{
												%>
													<script>
														document.getElementById("fmExistY").disabled = false;
														document.getElementById("fmExistN").disabled = false;
														
													</script>
												<%
											}
										}catch(Exception e){
											//out.println("Exception@1: "+e);//COMMON-ICN-0181
                                                                                          e.printStackTrace();//COMMON-ICN-0181
										}
										finally
										{
											if(rs!=null) rs.close();
											if(pstmt!=null) pstmt.close();
											if(con!=null) ConnectionManager.returnConnection(con,request);
										}
									
									%>									
								</table>
							</DIV>
						</td>
					</tr>
				</table>
			</td>
		</tr>			
		
					
					<input type="hidden" name="selectNonPatID" id="selectNonPatID" value="<%=selectNonPatID%>"/>
					<input type="hidden" name="genoId" id="genoId" value="<%=genoId%>">
					<input type="hidden" name="selectNonPatSex" id="selectNonPatSex" value="<%=selectNonPatSex%>"/>
					<input type="hidden" name="selectSrlNo" id="selectSrlNo" value="<%=selectSrlNo%>"/>
					<input type="hidden" name="selectNonPatName" id="selectNonPatName" value="<%=selectNonPatName%>"/>
					<input type="hidden" id="totalRecords" name="totalRecords" id="totalRecords" value="<%=totalRecords%>" />
					<input type="hidden" name="indexPatId" id="indexPatId" value="<%=patient_id%>" />
					<input type="hidden" name="totalGridPatIds" id="totalGridPatIds" value="<%=totalGridPatIds%>"> 
					
					
					<input type="hidden" name="nonPatID" id="nonPatID" value=""/>
					
					
					
				
			
	</table>
	 <script>
		function assignAddFamilPage(){
			parent.genogramAddFamilyMemberFram.location.href='../../eCA/jsp/CAGenogramAddFamily.jsp?<%=request.getQueryString()%>';
		}
		//call after page loaded
		window.onload=assignAddFamilPage ; 
		</script>
</form>
</body>
</html>

