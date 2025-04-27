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
<head>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String drawRelationString =  request.getParameter("drawRelationString")==null?"":request.getParameter("drawRelationString");
	
	String[] totalList = drawRelationString.split("\\|");
	StringBuffer totalListbf= new StringBuffer();
	for(int k=0;k<totalList.length;k++){
		totalListbf.append("'"+((String)totalList[k])+"'");
		if(k!=(totalList.length)-1)
			totalListbf.append(",");
	}
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	String 				query		=	null;
								
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCA/js/CAPatientGenogram.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name='genogramTranbtnFrm' id='genogramTranbtnFrm'>
	<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
		<tr>
			<td valign="top" align="left" width="56%">
				
						<!--<TR height="25px">
							<TD class="gridData" width="10%"><image src="../../eCA/images/test.png"></TD>
							<TD class="gridData" width="23%">Male/Female/Unknown</TD>
							<TD class="gridData" width="10%"><image src="../../eCA/images/test.png"></TD>
							<TD class="gridData" width="23%">Index Patient Male/Female</TD>
							<TD class="gridData" width="10%"><image src="../../eCA/images/test.png"></TD>
							<TD class="gridData" width="23%">Deseased Patient Male/Female/Unkown</TD>
						</TR> -->
						<%							
							try{
								con		=	ConnectionManager.getConnection(request);
								query	=	" SELECT RELTN_DESC,RELTN_IMG_NAME FROM CA_GENO_RELTN_MAST WHERE RELTN_ID IN("+totalListbf.toString()+")ORDER BY RELTN_DESC";

								pstmt	=	con.prepareStatement(query);											
								rs		=	pstmt.executeQuery();
								
								int i=0;
								int q = 0;
									while(rs.next()){	
										if(i==0){											
											if(q==0){
											%>
											<div style="width:100%;height:85px;border:1px solid black;overflow:auto">					
												<TABLE cellpadding=1 cellspacing=0 border=0 width="100%">
											<%
											}
											%>
											<TR height="25px">
											<TD class="gridData" width="10%"><image src="../../eCA/images/<%=(rs.getString("RELTN_IMG_NAME")==null?"":(String)rs.getString("RELTN_IMG_NAME"))%>"></TD>
											<TD class="gridData" width="23%"><%=(rs.getString("RELTN_DESC")==null?"":(String)rs.getString("RELTN_DESC"))%></TD>
											<%
											q++; 
											i++;
										}else{
											%>
											<TD class="gridData" width="10%"><image src="../../eCA/images/<%=(rs.getString("RELTN_IMG_NAME")==null?"":(String)rs.getString("RELTN_IMG_NAME"))%>"></TD>
											<TD class="gridData" width="23%"><%=(rs.getString("RELTN_DESC")==null?"":(String)rs.getString("RELTN_DESC"))%></TD>
											<%
											i++;
											if(i==3){
											%>
											</TR>
											<%
												i=0;
											}
										}
									
									}
									if(q>0){
									%>
										</TABLE>
										</div>
									<%
									}								
									
							}catch(Exception e){
									//out.println("Exception@1: "+e);//COMMON-ICN-0181
									e.printStackTrace();//COMMON-ICN-0181
							}finally{
								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();
								if(con!=null) ConnectionManager.returnConnection(con,request);
							}
						%>
					
						&nbsp;
				
			</td>
			<td align="right" width="44%">
				<img src="../../eCA/images/FamilyMember.png"  style="width:108px;height:87px;cursor: hand;"  onClick="addFamilyMember()"  /> 
				<img  src="../../eCA/images/EmotionalRelationships.png"  style="width:255px;height:87px;cursor: hand;" onClick='addSEIRelation()' />
				<img  src="../../eCA/images/MedicalHistory.png"  style="width:119px;height:87px;cursor: hand;" onClick='addMedicalHistory()'  />
				<input type="hidden" value="<%=patient_id%>" name="patient_id"/>
			</td>
		</tr>

	</table>
</form>
</body>
</html>

