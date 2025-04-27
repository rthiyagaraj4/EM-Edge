<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
24/05/2018		IN065341	Prakash C	25/05/2018		Ramesh G		ML-MMOH-CRF-0115
--------------------------------------------------------------------------------------------------------
*/
%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	
	<%
	request.setCharacterEncoding("UTF-8");
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String name=(String)session.getValue("practitioner_name");
	String facility_id=(String) session.getValue("facility_id");
	
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String alternate_id=request.getParameter("altID1")==null?"":request.getParameter("altID1");
	String nationality_id=request.getParameter("nationalityId")==null?"":request.getParameter("nationalityId");
	String called_from="CDR";
	
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
				 sql="select a.product_id,a.VERSION_NO,b.FACILITY_NAME FROM  sm_installation a,SM_FACILITY_PARAM_LANG_VW b WHERE LANGUAGE_ID = ? and facility_id= ?";
				 
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
			}
	
	%>
	<head>
		<title><%=productName %>ver<%=versionNum%> - [ <%=name%> - <%=facilityName%> ]</title>
		<script src="../../eCommon/js/CommonLookup.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language='javascript'></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe name="viewframe" id="viewframe"src="../../eCA/jsp/CentralizedDBSearchCriteria.jsp?patient_id=<%=patient_id%>&alternate_id=<%=alternate_id%>&nationality_id=<%=nationality_id%>&called_from=<%=called_from%>" scrolling='no' frameborder=0 noresize style='height:9%;width:100vw'></iframe>
		<iframe name="resultframe" id="resultframe" scrolling='auto' frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' scrolling='auto' frameborder=0 style='height:1%;width:100vw'></iframe>		
	
</html>

