<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date	Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------
09/05/2017	IN064173		Krishna Gowtham		09/05/2017	Ramesh G		Alpha - CA-Record Clinical Note System displays HTML Tags in Long Text Component 																			when New Born Result is linked.
------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title></title>
		<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="Javascript" src="../../eCA/js/RecClinicalNotesLinkBirthDetail.js">
	    </script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String dispResLinkHYMLYN="";//IN064173
	try
	{
		con =  ConnectionManager.getConnection(request);

		String patient_id = java.net.URLDecoder.decode(request.getParameter("patient_id")==null?"":request.getParameter("patient_id"));
		String encounter_id	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String facility_id = (String)session.getValue("facility_id");
		String p_encounter_id = "";
		String sel = "";
		String sql = "";
		String born_exists = "";
		String label = "", wtd = "10%";
		String disable = "";
		int i = 0;
		int count = 0;
	
		dispResLinkHYMLYN = (request.getParameter("dispResLinkHYMLYN")==null)?"":request.getParameter("dispResLinkHYMLYN");//IN064173
		String countsql = "SELECT COUNT(*) as total FROM mp_birth_register_vw where patient_id = ? ";
		pstmt = con.prepareStatement(countsql);
		pstmt.setString(1,patient_id);
		rs = pstmt.executeQuery();
		if(rs.next())
			count = rs.getInt("total");
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		countsql = "SELECT 'Y' FROM mp_birth_register_vw where MOTHER_ENCOUNTER_ID = ? ";
		pstmt = con.prepareStatement(countsql);
		pstmt.setString(1,encounter_id);
		rs = pstmt.executeQuery();
		if(rs.next())
			born_exists = rs.getString(1) == null ? "" : rs.getString(1);
		
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

%>
<body onScroll="scrollTitle()" onKeyDown="lockKey()">
	<form name="RecClinicalNotesLinkBornEnctrForm" id="RecClinicalNotesLinkBornEnctrForm">
		
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr>
			<td width='100%' class='CAGROUP' align='center'><b><font size='2'><fmt:message key="Common.searchresult.label" bundle="${common_labels}"/></b></td>
		</tr>
		</table><br>
<%
		if(count == 0)
		{
			sql = "select distinct MOTHER_ENCOUNTER_ID from mp_birth_register_vw where ENCOUNTER_FACILITY_ID = ? and MOTHER_PATIENT_ID = ? and MOTHER_ENCOUNTER_ID is not null order by 1 desc";
		}
		else
		{
			sql = "select distinct MOTHER_ENCOUNTER_ID from mp_birth_register_vw where ENCOUNTER_FACILITY_ID = ? and PATIENT_ID = ? and MOTHER_ENCOUNTER_ID is not null order by 1 desc";
		}
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,patient_id);
		rs = pstmt.executeQuery();

		if(count > 0)
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Mother.label","common_labels")+ " " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
			wtd = "15%";
			disable = "disabled";
		}
		else
		{
			label = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.encounter.label","common_labels");
			wtd = "10%";
			disable = "";
		}
%>
		
		<table border="0" cellpadding="0" cellspacing="0" width="100%" align="center">
		<tr>
			<td width='30%'>&nbsp;</td>
			<td class='label' width='<%=wtd%>'><b><%=label%></b></td>
			<td class='fields'><select name='enc_id' id='enc_id' onchange="loadResult(this);" <%=disable%>>
<%
			while(rs.next())
			{
				p_encounter_id = rs.getString(1) == null ? "" : rs.getString(1);
				if(born_exists.equals("Y"))
				{
					if(p_encounter_id.equals(encounter_id))
						sel = "selected";
					else
						sel = "";
				}
				else
				{
					if(i == 0)
					{
						sel = "selected";
						encounter_id = p_encounter_id;
					}
					else
						sel = "";
				}
%>
				<option value="<%=p_encounter_id%>" <%=sel%>><%=p_encounter_id%> </option>
<%
				i++;
			}
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();

			if(i == 0)
			{
%>
				<option value="">-----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----------</option>
<%
			}
%>
			</select>
			</td>
		</tr>
		
		</table>
		<input type='hidden' name='qs' id='qs' value='<%=request.getQueryString()%>'>
		<input type="hidden" name="dispResLinkHYMLYN" id="dispResLinkHYMLYN" value="<%=dispResLinkHYMLYN%>"><!--IN064173-->
	</form>
</body>
<script>
	parent.RecClinicalNotesLinkBornMainFrame.location.href = "../../eCA/jsp/RecClinicalNotesLinkBirthDetailsMain.jsp?<%=request.getQueryString()%>"+"&mother_encounter_id="+"<%=encounter_id%>";
</script>
<%
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
%>
</html>


