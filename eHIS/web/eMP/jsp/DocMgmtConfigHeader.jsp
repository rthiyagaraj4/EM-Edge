<!DOCTYPE html>
<!--
Created By: D. Sethuraman
-->
<%@ page language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,eMP.*,eCommon.Common.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title></title>
		<%
			Connection conn	= null; //Added by Bhuvaneshwari for SM-MO-CRF-20154.2 on 19/0612019
			
			try{

				conn = ConnectionManager.getConnection(request);  //Added by Bhuvaneshwari for SM-MO-CRF-20154.2 on 19/0612019

				request.setCharacterEncoding("UTF-8");	
				String mode = request.getParameter("mode");			

				String sFacilityId = "";
				
				String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
				Properties p = (Properties)session.getValue("jdbc");
				String locale	= (String) p.getProperty("LOCALE");
				

				//sFacilityId = (request.getParameter("facilityID")==null)? "":request.getParameter("facilityID");	
				/*
				if (sFacilityId == "")
					sFacilityId	= (String)session.getValue("facility_id");
				*/

				List<FacilityDetailsBean> oFacDetailsList = null;
				FacilityDetailsBean sFacDetailsBean = null;
				String sFacDetails = "";
				int ntypeListSize = 0;
				boolean isAlFacility = false;
				
				DocumentConfigOption docConfigOption = new DocumentConfigOption(); 		
				
				oFacDetailsList = new ArrayList<FacilityDetailsBean>();
				sFacDetailsBean = new FacilityDetailsBean();
				
				//sFacDetailsBean.setRequest(request);
				//sFacDetailsBean.setsFacilityId(sFacilityId);
				//oFacDetailsList = docConfigOption.getFacilityDetails(sFacDetailsBean);		

				oFacDetailsList = docConfigOption.getFacilityDetails(sFacilityId);	
				
				isAlFacility = CommonBean.isSiteSpecific(conn, "SM","ALLFACILITY" ); //Added by Bhuvaneshwari for SM-MO-CRF-20154.2 on 19/0612019
				
				
				ntypeListSize = oFacDetailsList.size();
				if (ntypeListSize>0){
					if(isAlFacility) //Added by Bhuvaneshwari for SM-MO-CRF-20154.2 on 19/0612019
					{
						sFacDetails = "<Option value='A*'>All Facilities</option>";
					}

						for (int i=0;i<ntypeListSize;i++){
							sFacDetailsBean = oFacDetailsList.get(i);
							sFacDetails = sFacDetails + "<Option value="+sFacDetailsBean.getsFacilityId()+">" +sFacDetailsBean.getsFacilityName()+ "</option>";
						}
					
				}

				
				
			%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<Script src ='../../eCommon/js/CommonLookup.js'></Script>
		
		<script language='javascript' src='../../eMP/js/DocMgmtConfig.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'DocMgmtConfigHeaderForm'>
			<table class='grid' align="center" border="1" cellpadding="1" cellspacing="1"
			style="width: 800px;">
				<tr>
					
					<td class=label ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
					<td class='fields' >&nbsp;<select name='facility_id' id='facility_id'  onchange='resetFrames(this),changeFacility(this)'>
							<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
							<%=sFacDetails%>
						</select>
						<img src='../../eCommon/images/mandatory.gif'>
					</td>											
					<td align='right' colspan ='2'><input type='button' class='button' name='search' id='search' 
													value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' 
													onclick="loadFrames();">
					</td>
				</tr>				
			</table>
			<input type='hidden' name='mode' id='mode' value='<%=mode %>'>
			<input type ="hidden" name ="facilityId" value="">
<%
}catch(Exception e1)
			{
			 out.println("(DocMgmtConfigHeader.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			       if (conn != null)
				       ConnectionManager.returnConnection(conn);
			}
%>
		</form>
	</body>	
</html>

