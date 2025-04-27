<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
24/05/2018		IN065341	Prakash C	25/05/2018		Ramesh G		ML-MMOH-CRF-0115
19/11/2018		IN068797	Prakash C	19/11/2018		Ramesh G		MMS-DM-SCF-0568
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String name=(String)session.getValue("practitioner_name");
	
	String query_string = request.getQueryString() == null? "" :request.getQueryString();
	String facility_id=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id=request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
	String patient_name=request.getParameter("patient_name")==null?"":request.getParameter("patient_name");
	
	String productName="";
	String versionNum="";
	String facilityName="";
	
	Connection con = null;
	PreparedStatement pstmt 	= null;	
	ResultSet rs=null;

	String sql="";
		try
				{
					con = ConnectionManager.getConnection(request);
				  sql="select a.product_id,a.VERSION_NO,b.FACILITY_NAME FROM  sm_installation  ##REPDB## a,SM_FACILITY_PARAM_LANG_VW ##REPDB##  b WHERE LANGUAGE_ID = ? and facility_id= ?";
				 sql=sql.replaceAll("##REPDB##",RepDb);
				 
				pstmt = con.prepareStatement(sql);
				pstmt.setString( 1 ,locale);
				pstmt.setString( 2 ,facility_id);
				
				rs	= pstmt.executeQuery();
				
				while(rs.next())
					{
						productName=rs.getString( "product_id");
						versionNum=rs.getString( "VERSION_NO");
						facilityName=rs.getString( "FACILITY_NAME");
					}
			}	
			catch(Exception e){
				e.printStackTrace();		
			}
			finally
			{
				if(rs != null) rs.close();
				if(pstmt != null)pstmt.close();
				if(con != null)	con.close();	
				//if(CDRTemp != null)	CDRTemp.close();	
			}
	
	%>
	<head>
		<title><%=productName %>ver<%=versionNum%> - Patient ID : <%=patient_id%> , Encounter ID:<%=encounter_id%> , Patient Name : <%=patient_name%>  [ <%=name%> - <%=facilityName%> ]</title>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language='javascript'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name='content' id='content' src='../../eCA/jsp/ChartSummaryPatient.jsp?<%=query_string%>' frameborder=0  marginheight=0 marginwidth=0 SCROLLING='yes' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
			<iframe name='blankFrameForCharts' id='blankFrameForCharts' src='../../eCommon/html/blank.html' style='height:0%;width:100vw'></iframe>
			<iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' style='height:0%;width:100vw'></iframe><!--IN068797-->
	
</html>

