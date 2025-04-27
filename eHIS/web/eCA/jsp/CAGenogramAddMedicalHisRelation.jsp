<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
17/09/2013	IN043384		Ramesh G		Add Medical History In Remarks enter more text Add We get SQL Exception Error
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
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
<form name='genogramAddMedicalHisRelationFrm' id='genogramAddMedicalHisRelationFrm' action='../../servlet/eCA.CAGenogramServlet' method='post' target='messageFrame' >
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>					
		<tr height="60%">
			<td valign="top">
				<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>						
					<tr>
						<td class='label' width='30%'>Medical History Type</td> 
						<td class="fields" width='70%'>
							<SELECT name="emoRelationTypeId" id="emoRelationTypeId" style="width:230px;" onChange="clearMsg();"><!--getRelationComboValues(this,'RELATION'); removed  -->
								<OPTION value="">--------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</OPTION>
								<%
									Connection			con			=	null;
									PreparedStatement	pstmt		=	null;
									ResultSet			rs			=	null;
									String 				query		=	null;
										
									try{
										con		=	ConnectionManager.getConnection(request);
										query	=	" SELECT RELTN_ID,RELTN_DESC FROM CA_GENO_RELTN_MAST WHERE RELTN_TYPE_ID='MH' AND EFF_STATUS='E' ORDER BY RELTN_DESC";

										pstmt	=	con.prepareStatement(query);											
										rs		=	pstmt.executeQuery();
																					
										while(rs.next()){												
										%>	
											<OPTION value="<%=rs.getString("RELTN_ID")==null?"":(String)rs.getString("RELTN_ID") %>"><%=rs.getString("RELTN_DESC")==null?"":(String)rs.getString("RELTN_DESC") %></OPTION>
											
										<%
										}											
											
									}catch(Exception e){
											//out.println("Exception@1: "+e);//common-icn-0181
											e.printStackTrace();//COMMON-ICN-0181
									}finally{
										if(rs!=null) rs.close();
										if(pstmt!=null) pstmt.close();
										if(con!=null) ConnectionManager.returnConnection(con,request);
									}
								%>									
							</SELECT>
							<img id="relst" src='../../eCommon/images/mandatory.gif' style="display;"></img>
						</td>						
					</tr>
					
					<tr>
						<td class="label" width='30%' >Remarks</td>
						<td class="fields" width='70%'>
							<!-- <textarea   name="relationRemarks" value="" rows="4"  cols="30" ></textarea> //IN043384 -->
							<textarea   name="relationRemarks" value="" rows="4" onkeypress="if (this.value.length > 249) { return false; }" onblur="controlLength(this);" cols="30" ></textarea>
						</td>
					</tr>	
					<tr>
						<td class='label' width='30%'>&nbsp;</td>
						<td  width='70%'>
							<INPUT TYPE="button" value='Add' class='button' onClick='addNewMedHisEmoRelation()'>
							<INPUT TYPE="button" value='Clear' class='button' onClick='clearMedHisReln()'>
						</td>						
					</tr>
				</table>
				<input type="hidden" name="fromRelationId" id="fromRelationId" value=""/>
				<input type="hidden" name="mode" id="mode" value="AddMedHistory">
				<input type="hidden" name="genoId" id="genoId" value="">
				<input type="hidden" name="srlNo" id="srlNo" value="">
				<input type="hidden" name="totalRelations" id="totalRelations" value="">
				<input type="hidden" name="removeRelations" id="removeRelations" value="">
				<input type="hidden" name="mhRelationId" id="mhRelationId" value="MH">
				
			</td>
		</tr>
	</table>
</form>
</body>
</html>

