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
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
		.gridData1
		{
			background-color: #FFFFFF;
			height:18px;
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 8pt;
			color: #000000;
			font-weight:normal;
			text-align:center;
			padding-left:10px;
			padding-right:10px;
			vertical-align:middle;
			border-bottom:1px;
			border-top:0px;
			border-left:0px;
			border-right:0px;
			border-style:solid;
			border-color:#EEEEEE;
		}
	</style>
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='genogramMedicalHisForMemberDtlsFrm' id='genogramMedicalHisForMemberDtlsFrm'>
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		<tr height="100%">
			<td>				
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>					
					<tr>
						<td class='columnHeadercenter'>Family Members</td>
					</tr>
					<tr>
						<td>
							<DIV style="width:100%;height:160;border:1px solid red;overflow:auto">
								<table cellpadding=3 cellspacing=0 border=0 width="100%" id="displayTable" align=center> 
									<tr>
										<th class='columnHeadercenter' rowspan=2 width="5%">&nbsp;</th>
										<th class='columnHeadercenter' rowspan=2 width="15%">Patient ID </th>
										<th class='columnHeadercenter' rowspan=2 width="30%">Patient Name </th>
										<th class='columnHeadercenter' rowspan=2 width="15%">Age </th>
										<th class='columnHeadercenter' rowspan=2 width="15%">Gender </th>
										<th class='columnHeadercenter' colspan=2 width="20%"> </th>
									</tr>
									<tr>								
										<th class='columnHeadercenter' width="20%"> </th>
										<!-- <th class='columnHeadercenter' width="10%">To </th> -->
									</tr>
									<%
										Connection			con			=	null;
										PreparedStatement	pstmt		=	null;
										ResultSet			rs			=	null;
										String 				query		=	null;										
										try{
											con				=	ConnectionManager.getConnection(request);

											query	=	" SELECT A.GENO_ID, A.SRL_NO, A.PATIENT_ID, A.NON_PATIENT_ID, A.NAME, A.SEX, DECODE(A.SEX,'M','Male','F','Female','U','Unknown') SEX_DESC, A.DATE_OF_BIRTH, CA_GET_AGE(A.DATE_OF_BIRTH,SYSDATE,'YMD') AGE FROM CA_GENOGRAM_ATTRIBUTE A, CA_GENOGRAM_ATTRIBUTE B WHERE A.GENO_ID=B.GENO_ID AND B.PATIENT_ID=?";

											pstmt			=	con.prepareStatement(query);
											pstmt.setString(1,patient_id);
											
											rs				=	pstmt.executeQuery();
											String className="gridData";											
											while(rs.next()){												
											%>	
												<tr bgcolor="#FF0000"  > 
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
													<td class='<%=className%>1' ><input type="radio" name="fromRelation" id="fromRelation" value="<%=rs.getString("GENO_ID")==null?"":(String)rs.getString("GENO_ID") %>|<%=rs.getString("SRL_NO")==null?"":(String)rs.getString("SRL_NO") %>|<%=rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID") %>" onClick="showExistingMedHisRelations();">&nbsp;</td>
													<%-- <td class='<%=className%>1' ><input type="radio" name="toRelation" id="toRelation"   value="<%=rs.getString("GENO_ID")==null?"":(String)rs.getString("GENO_ID") %>|<%=rs.getString("SRL_NO")==null?"":(String)rs.getString("SRL_NO") %>|<%=rs.getString("NON_PATIENT_ID")==null?"":(String)rs.getString("NON_PATIENT_ID") %>" onClick="clickToRelation();">&nbsp;</td> --%>
													
												</tr>
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
									<input type="hidden" name="genoId" id="genoId" value="">
									<input type="hidden" name="srlNo" id="srlNo" value="">
									<input type="hidden" name="fromRelationId" id="fromRelationId" value=""/>
									<input type="hidden" name="toRelationId" id="toRelationId" value=""/>
									<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>"/>
								</table>
							</DIV>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</form>
</body>
</html>

