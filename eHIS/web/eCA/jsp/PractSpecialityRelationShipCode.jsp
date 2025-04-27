<!DOCTYPE html>
<%@ page import="java.sql.*, java.io.*, webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" language="java" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>

		
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
		<script src="../../eCommon/js/common.js"			language="javascript"></script>
		<script src='../../eCommon/js/CommonLookup.js'		language=javascript></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<form name ="resultForm" method ="post" action ="../../servlet/eCA.PractSpecialtyRelationServlet" target="messageFrame">
<BR>
<%
	Connection con = null;	
	PreparedStatement psn = null;
	ResultSet rsn = null;

	try
	{
		int id = 0;		
		String Concatenated = "";
		String specialtyCode = request.getParameter("specialty_code")==null ? "" : request.getParameter("specialty_code");
		con = ConnectionManager.getConnection(request);
	
		psn = con.prepareStatement("SELECT A.PRACT_RELN_ID \"PRACT_RELN_ID\", A.PRACT_RELN_NAME \"long_desc\", NVL ((SELECT 1  FROM CA_PP_RELN_FOR_SPLTY  WHERE RELN_ID = A.PRACT_RELN_ID   AND SPECIALITY_CODE = ? AND RELN_CATEGORY = 'IE'), '0' ) 		ASSOCIATED_RELATION   FROM CA_PRACT_RELN A  WHERE A.EFF_STATUS = 'E' AND A.IP_ATTEND_PHYS_YN = 'Y' order by PRACT_RELN_NAME");
		
		psn.setString(1,specialtyCode);
		rsn = psn.executeQuery();
	%>
	<input type ="hidden" name="specialty_code" id="specialty_code" value="<%=specialtyCode%>">
	<table width="90%" border=0 cellspacing=0 cellpadding=3 align='center'>	
			<td class='COLUMNHEADERCENTER' width ="50%"><fmt:message key="eCA.AttendingRelationship.label" bundle="${ca_labels}"/></td>	
			<td class='COLUMNHEADERCENTER' width ="50%"><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></td>	
			<tr>		
					<td class="label"><fmt:message key="eCA.IPEnc.label" bundle="${ca_labels}"/></td>
					<td class="fields" >
					<select name="IPEnc" id="IPEnc">	
					<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
					
					<%						
					while(rsn.next())		
					{
						id				= Integer.parseInt(rsn.getString("ASSOCIATED_RELATION"));
						Concatenated	= rsn.getString("PRACT_RELN_ID") +":" + rsn.getString("ASSOCIATED_RELATION");
					
						if( id != 0)
							out.println("<option value ='"+Concatenated+"' selected>"+rsn.getString("long_desc")+"</option>");
						else
							out.println("<option value ='"+Concatenated+"'>"+rsn.getString("long_desc")+"</option>");
					}
	%>
					</select>	
					</td>
			</tr>
			<tr>		
<%
		if(rsn!=null)rsn.close();
		if(psn!=null)psn.close();
		
		psn = con.prepareStatement("SELECT A.PRACT_RELN_ID PRACT_RELN_ID, A.PRACT_RELN_NAME long_desc, NVL ((SELECT 1 FROM CA_PP_RELN_FOR_SPLTY            WHERE RELN_ID = A.PRACT_RELN_ID  AND SPECIALITY_CODE = ?  AND RELN_CATEGORY = 'IA'), '0') ASSOCIATED_RELATION  FROM CA_PRACT_RELN A WHERE A.EFF_STATUS = 'E' AND A. IP_ADMIT_PHYS_YN = 'Y' order by PRACT_RELN_NAME");
		psn.setString(1,specialtyCode);
		rsn = psn.executeQuery();
	
%>
		<td class="label"><fmt:message key="eCA.IPAdmit.label" bundle="${ca_labels}"/></td>
		<td class="fields" ><select name="IPAdmit" id="IPAdmit">	
							<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
<%							
							while(rsn.next())		
							{
								id = Integer.parseInt(rsn.getString("ASSOCIATED_RELATION"));
								Concatenated = rsn.getString("PRACT_RELN_ID") +":" + rsn.getString("ASSOCIATED_RELATION");
							
									if( id != 0)
										out.println("<option value ='"+Concatenated+"' selected>"+rsn.getString("long_desc")+"</option>");
									else
										out.println("<option value ='"+Concatenated+"' >"+rsn.getString("long_desc")+"</option>");
							}
%>
							</select>
		</td>
		</tr>
		<tr>		
					<td class="label"><fmt:message key="eCA.OPVisit.label" bundle="${ca_labels}"/></td>
					 
	<%
		if(rsn!=null)rsn.close();
		if(psn!=null)psn.close();

		psn = con.prepareStatement("SELECT A.PRACT_RELN_ID PRACT_RELN_ID, A.PRACT_RELN_NAME long_desc, NVL ((SELECT 1 FROM CA_PP_RELN_FOR_SPLTY              WHERE RELN_ID = A.PRACT_RELN_ID  AND SPECIALITY_CODE = ? AND RELN_CATEGORY = 'OP'), '0') ASSOCIATED_RELATION  FROM CA_PRACT_RELN A WHERE A.EFF_STATUS = 'E' AND A. OP_ATTEND_PHYS_YN = 'Y' order by PRACT_RELN_NAME");
		psn.setString(1,specialtyCode);
		rsn = psn.executeQuery();
%>
		<td class="fields" >			
		<select name="OPVisit" id="OPVisit">
		<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
<%						
		while(rsn.next())		
		{
			id = Integer.parseInt(rsn.getString("ASSOCIATED_RELATION"));
			Concatenated = rsn.getString("PRACT_RELN_ID") +":" + rsn.getString("ASSOCIATED_RELATION");
			
			if( id != 0)
				out.println("<option value ='"+Concatenated+"' selected>"+rsn.getString("long_desc")+"</option>");
			else
				out.println("<option value ='"+Concatenated+"' >"+rsn.getString("long_desc")+"</option>");
		}
	%>
						</select>
					</td>
				
			</tr>
			<tr>		
					<td class="label"><fmt:message key="eCA.AccidentEmergency.label" bundle="${ca_labels}"/></td>
					
<%
		if(rsn!=null)rsn.close();
		if(psn!=null)psn.close();

		psn = con.prepareStatement("SELECT A.PRACT_RELN_ID PRACT_RELN_ID, A.PRACT_RELN_NAME long_desc,NVL ((SELECT 1 FROM CA_PP_RELN_FOR_SPLTY           WHERE RELN_ID = A.PRACT_RELN_ID AND SPECIALITY_CODE = ? AND RELN_CATEGORY = 'EM'),  '0' ) ASSOCIATED_RELATION  FROM CA_PRACT_RELN A WHERE A.EFF_STATUS = 'E' AND A. AE_ATTEND_PHYS_YN = 'Y' order by PRACT_RELN_NAME");
		psn.setString(1,specialtyCode);
		rsn = psn.executeQuery();
%>
		<td class="fields" >
		<select name="AE" id="AE">
		<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
<%		while(rsn.next())		
								{
									id = Integer.parseInt(rsn.getString("ASSOCIATED_RELATION"));
									Concatenated = rsn.getString("PRACT_RELN_ID") +":" + rsn.getString("ASSOCIATED_RELATION");
									if( id != 0)
									{
										
										out.println("<option value ='"+Concatenated+"' selected>"+rsn.getString("long_desc")+"</option>");
									}
									else
									{
										out.println("<option value ='"+Concatenated+"' >"+rsn.getString("long_desc")+"</option>");
									}
								}
%>
						</select>

					</td>
				
			</tr>
			<tr>		
					<td class="label"><fmt:message key="Common.daycare.label" bundle="${common_labels}"/></td>
					 
<%
		if(rsn!=null)rsn.close();
		if(psn!=null)psn.close();

		psn = con.prepareStatement("SELECT A.PRACT_RELN_ID PRACT_RELN_ID, A.PRACT_RELN_NAME long_desc, NVL ((SELECT 1 FROM CA_PP_RELN_FOR_SPLTY              WHERE RELN_ID = A.PRACT_RELN_ID  AND SPECIALITY_CODE = ? AND RELN_CATEGORY = 'DC'), '0') ASSOCIATED_RELATION  FROM CA_PRACT_RELN A WHERE A.EFF_STATUS = 'E' AND A. DC_ATTEND_PHYS_YN = 'Y' order by PRACT_RELN_NAME ");
		psn.setString(1,specialtyCode);
		rsn = psn.executeQuery();
%>
<td class="fields" >
<select name="DayCare" id="DayCare">	
							<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
	<%						while(rsn.next())		
								{
									id = Integer.parseInt(rsn.getString("ASSOCIATED_RELATION"));
									Concatenated = rsn.getString("PRACT_RELN_ID") +":" + rsn.getString("ASSOCIATED_RELATION");
									if( id != 0)
									{
										
										out.println("<option value ='"+Concatenated+"' selected>"+rsn.getString("long_desc")+"</option>");
									}
									else
									{
										out.println("<option value ='"+Concatenated+"' >"+rsn.getString("long_desc")+"</option>");
									}
								}
%>
						</select>
					</td>
				
			</tr>
			<tr>		
					<td class="label"><fmt:message key="eCA.ReferralRelation.label" bundle="${ca_labels}"/></td>
					 
<%
		if(rsn!=null)rsn.close();
		if(psn!=null)psn.close();

		psn = con.prepareStatement("SELECT A.PRACT_RELN_ID PRACT_RELN_ID, A.PRACT_RELN_NAME long_desc,NVL ((SELECT 1 FROM CA_PP_RELN_FOR_SPLTY             WHERE RELN_ID = A.PRACT_RELN_ID AND SPECIALITY_CODE = ?  AND RELN_CATEGORY = 'RF'), '0') ASSOCIATED_RELATION  FROM CA_PRACT_RELN A  WHERE A.EFF_STATUS = 'E' AND A. REFERAL_RELN_YN = 'Y' order by PRACT_RELN_NAME ");
		psn.setString(1,specialtyCode);
		rsn = psn.executeQuery();
%>
		<td class="fields" >						
		<select name="Ref_rel" id="Ref_rel">	
							<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
	<%						while(rsn.next())		
								{
									id = Integer.parseInt(rsn.getString("ASSOCIATED_RELATION"));
									Concatenated = rsn.getString("PRACT_RELN_ID") +":" + rsn.getString("ASSOCIATED_RELATION");
									if( id != 0)
									{
										
										out.println("<option value ='"+Concatenated+"' selected>"+rsn.getString("long_desc")+"</option>");
									}
									else
									{
										out.println("<option value ='"+Concatenated+"' >"+rsn.getString("long_desc")+"</option>");
									}
								}
%>
						</select>
					</td>
				
			</tr>
			<tr>		
					<td class="label"><fmt:message key="eCA.NurseRelation.label" bundle="${ca_labels}"/></td>
					 
				<%
		if(rsn!=null)rsn.close();
		if(psn!=null)psn.close();

		psn = con.prepareStatement("SELECT A.PRACT_RELN_ID PRACT_RELN_ID, A.PRACT_RELN_NAME long_desc, NVL ((SELECT 1 FROM CA_PP_RELN_FOR_SPLTY              WHERE RELN_ID = A.PRACT_RELN_ID AND SPECIALITY_CODE = ?  AND RELN_CATEGORY = 'NS'),'0') ASSOCIATED_RELATION  FROM CA_PRACT_RELN A WHERE A.EFF_STATUS = 'E' AND A. ATTEND_NURSE_RELN_YN= 'Y' order by PRACT_RELN_NAME ");
		psn.setString(1,specialtyCode);
		rsn = psn.executeQuery();
%>
		<td class="fields" >							
		<select name="NR" id="NR">	
							<option value="">---------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
	<%						while(rsn.next())		
								{
									id = Integer.parseInt(rsn.getString("ASSOCIATED_RELATION"));
									Concatenated = rsn.getString("PRACT_RELN_ID") +":" + rsn.getString("ASSOCIATED_RELATION");
									if( id != 0)
									{
										
										out.println("<option value ='"+Concatenated+"' selected>"+rsn.getString("long_desc")+"</option>");
									}
									else
									{
										out.println("<option value ='"+Concatenated+"' >"+rsn.getString("long_desc")+"</option>");
									}
								}
%>
						</select>
					</td>
				
			</tr>
			
		</table>	
		<center>
		</form>


</BODY>
<%
	if(rsn != null) rsn.close();
	if(psn != null) psn.close();
	}
catch(Exception e)
	{
			//out.println(e);//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
			con.rollback();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con);

	}
%>
</HTML>

