<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
19/09/2013	IN043568		Ramesh G		Add Medical History In Remarks there is no wrapping of text entered
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
	String fromRelationId = request.getParameter("fromRelationId")==null?"":request.getParameter("fromRelationId");
	String toRelationId = request.getParameter("toRelationId")==null?"":request.getParameter("toRelationId");
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
<form name='genogramMedicalHisRelationDtlsFrm' id='genogramMedicalHisRelationDtlsFrm'>
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		<tr height="100%">
			<td>				
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>					
					<tr>
						<td class='columnHeadercenter'>Medical History</td>
					</tr>
					<tr>
						<td>
							<DIV style="width:100%;height:160;border:1px solid red;overflow:auto">
								<table cellpadding=3 cellspacing=0 border=0 width="100%" id="displayTable" align=center>
									<tr>
										<th class='columnHeadercenter'  width="20%">Medical History Type</th>
										<!-- <th class='columnHeadercenter'   width="20%">Relationship </th> -->
										<th class='columnHeadercenter'  width="40%">Remarks </th>
										<th class='columnHeadercenter'  width="10%">Select </th>
									</tr>									
									<%
										Connection			con			=	null;
										PreparedStatement	pstmt		=	null;
										ResultSet			rs			=	null;
										String 				query		=	null;
										int count =0;
										try{
											con				=	ConnectionManager.getConnection(request);

											query	=	"select a.reltn_id reltn_id, a.reltn_desc RELTN_TYPE_DESC,b.relation_remarks relation_remarks  FROM ca_geno_reltn_mast a, ca_genogram_relation b  WHERE a.reltn_type_id = b.relation_type_id AND a.reltn_id = b.relation_id AND b.relation_type_id ='MH'  AND b.from_genoid = ? ";
											System.out.println("CAGenogramSEIRelationDtls.jsp====query======>"+query);
											System.out.println("CAGenogramSEIRelationDtls.jsp====fromRelationId======>"+fromRelationId);
											
											pstmt			=	con.prepareStatement(query);
											pstmt.setString(1,fromRelationId);
											rs				=	pstmt.executeQuery();
											String className="gridData";
											String tempValue=""; //IN043568
											while(rs.next()){												
											%>	
												<tr bgcolor="#FF0000"  >
													<td class='<%=className%>' ><%=rs.getString("RELTN_TYPE_DESC")==null?"":(String)rs.getString("RELTN_TYPE_DESC") %>&nbsp;</td>
													<%
														//IN043568 Start.
														String remarks =rs.getString("RELATION_REMARKS")==null?"":(String)rs.getString("RELATION_REMARKS");
														if(remarks.length() > 80)
															tempValue = "<a  href='javascript:ShowComments(\"MH\",\""+fromRelationId+"\",\""+(rs.getString("RELTN_ID")==null?"":(String)rs.getString("RELTN_ID"))+"\")'><font size='1' color='blue'><i>"+remarks.substring(0,80)+"...</i></a>";
														else
															tempValue =remarks;
														//IN043568 End.
													%>
													<td class='<%=className%>' ><%=tempValue %>&nbsp;</td>
													<td class='<%=className%>1' ><input type="checkbox" name="selectRelation<%=count%>" id="selectRelation<%=count%>" value="<%=rs.getString("RELTN_ID")==null?"":(String)rs.getString("RELTN_ID") %>"></td>
												</tr>
											<%
												count++;
											}											
											
										}catch(Exception e){
										//	out.println("Exception@1: "+e);//COMMON-ICN-0181
                                                                                        e.printStackTrace();//COMMON-ICN-0181
										}
										finally
										{
											if(rs!=null) rs.close();
											if(pstmt!=null) pstmt.close();
											if(con!=null) ConnectionManager.returnConnection(con,request);
										}
									
									%>
									<input type="hidden" name="totalRelations" id="totalRelations" value="<%=count%>">
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

