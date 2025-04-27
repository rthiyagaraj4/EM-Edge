<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String patient_id = request.getParameter("patientId");
if(patient_id == null || patient_id.equals("null"))
patient_id = "";
Connection con = ConnectionManager.getConnection(request);
PreparedStatement pstmt		= null;
ResultSet rs				= null;
PreparedStatement pstmt1	= null;
ResultSet rs1				= null;
String facility_id	= (String) session.getValue( "facility_id" ) ;
String packageCode	= request.getParameter("packageCode");
packageCode			= packageCode==null ?"":packageCode;
String packageSeqNo	= request.getParameter("packageSeqNo");
packageSeqNo		= packageSeqNo==null ?"":packageSeqNo;
String pkgDesc	    = request.getParameter("pkgDesc");
pkgDesc				= pkgDesc==null ?"":pkgDesc;
//System.out.println("pkgDesc :"+pkgDesc);
String encounterId  = "";
String episodeType  = "";
int total = 0;
String sqlCount = "SELECT COUNT (*) total FROM bl_package_encounter_dtls WHERE  operating_facility_id = ? AND patient_id = ? AND package_code = ? AND package_seq_no = ?";
String sql = "SELECT ENCOUNTER_ID, EPISODE_TYPE FROM bl_package_encounter_dtls WHERE  operating_facility_id = ? AND patient_id = ? AND package_code = ? AND package_seq_no = ?";

try
{
	pstmt = con.prepareStatement(sqlCount);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,patient_id);
	pstmt.setString(3,packageCode);
	pstmt.setString(4,packageSeqNo);
	rs = pstmt.executeQuery();	
	if(rs.next())
	{
		total = rs.getInt("total");
		if(total>0)
		{  
			try
			{
				pstmt1 = con.prepareStatement(sql);
				pstmt1.setString(1,facility_id);
				pstmt1.setString(2,patient_id);
				pstmt1.setString(3,packageCode);
				pstmt1.setString(4,packageSeqNo);
				rs1 = pstmt1.executeQuery();
				if(rs1.next())
				{
					encounterId	= rs1.getString("ENCOUNTER_ID");
					episodeType	= rs1.getString("EPISODE_TYPE");	
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception from getting data :"+e);
				e.printStackTrace();
			}
			finally
			{
				if (rs1 != null)   rs1.close();
				if (pstmt1 != null) pstmt1.close();
			}
		}  
	}
}
catch(Exception e)
{
	System.out.println("Exception from count :"+e);
	e.printStackTrace();
}
finally
{
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();
	if (rs != null)   rs.close();
	if (pstmt != null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);

}
String episode_id = encounterId;
if(episode_id == null || episode_id.equals("null"))
episode_id = "";

if(facility_id.equals(""))
facility_id = (String)session.getValue("facility_id") == null ? "" : (String)session.getValue("facility_id");
 			
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
        <script src='../../eCommon/js/common.js' language='javascript'></script>
	    <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	    <script src='../../eMP/js/PatEncBanner.js' language='javascript'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	</head>
	<%
	

	%>
	<body onKeyDown="lockKey()" OnMouseDown='CodeArrest()'>
		<form name='patLineForm' id='patLineForm'>
			<table width='100%' cellspacing='0' cellpadding='0' border='0' height='30' width='1024'>
			<TR> <td id='tdLine1' nowrap>&nbsp;<span class='valueClassRow1' title='packageSeqNo'><%=pkgDesc%>(<%=packageSeqNo%>)</span>&nbsp;
			<%if(total==0){  %>
			<span class='valueClassRow1' title='EncounterId'>Not Associated to any Encounters.</span></td>
			<%}else if(total>1){%>
			<span class='valueClassRow1' title='EncounterId'>Associated to multiple Encounters.</span></td>
			<%}else{%>
			<span class='valueClassRow1' title='EncounterId'>Encounter Id : <%=encounterId%></span>&nbsp;&nbsp;
			<%if(episodeType.equals("O")){%>
			<span class='valueClassRow1' title=''>Episode Type :<fmt:message key='Common.OP.label' bundle='${common_labels}'/></span>
			<%}else  if(episodeType.equals("I")){%>
			<span class='valueClassRow1' title=''>Episode Type :<fmt:message key='Common.IP.label' bundle='${common_labels}'/></span>
			<%}else if(episodeType.equals("D")){	%>
			<span class='valueClassRow1' title=''>Episode Type :<fmt:message key='Common.daycare.label' bundle='${common_labels}'/></span>
			<%}%>
				
			<%}%>	
			</td></tr>
			</table>
		</form>
	</body>
</html>
<script>
	var classValue = "NORMPATLINE";
	if(document.getElementById("tdLine1") != null)
		document.getElementById("tdLine1").className = classValue;
</script>

