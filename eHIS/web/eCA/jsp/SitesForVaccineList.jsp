<!DOCTYPE html>
<%@ page import ="webbeans.eCommon.*,java.sql.*, java.text.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String operation = request.getParameter("operation") == null ? "" : request.getParameter("operation");
String tempfinalString = "";
//String flag_for_list = request.getParameter("flag_for_list") == null ? "false" : request.getParameter("flag_for_list");
//String tempRowCount = request.getParameter("rowCount") == null ? "0" : request.getParameter("rowCount");
//int tempIntRowCount = Integer.parseInt(tempRowCount);
//String firstPosition = request.getParameter("firstPosition") == null ? "0" : request.getParameter("firstPosition");
//String secondPosition = request.getParameter("secondPosition") == null ? "0" : request.getParameter("secondPosition");
String removeValue = request.getParameter("remove_value") == null ? "0" : request.getParameter("remove_value");
int i=0;
%>
	<!-- Added by Arvind @ 08-12-08 -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../js/SitesForVaccine.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body   OnMouseDown="CodeArrest()" onKeyDown="lockKey()" OnScroll="scrollTitle()" >
	<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
	
<%
	eCA.SitesForVaccineBean sitesbean = (eCA.SitesForVaccineBean)getObjectFromBean("sitesbean","eCA.SitesForVaccineBean",session);
%>
	<form name="sitesForVaccineResultForm" id="sitesForVaccineResultForm">
<div id='divDataTitle' style='postion:relative'>
	 <table border='1' width='100%' id='dataTitleTable' cellpadding='3' cellspacing='0' align='center'>	
			<tr><th class='columnheader' colspan='4' align="left"><fmt:message key="eCA.SelectedSites.label" bundle="${ca_labels}"/></th></tr>
			<tr>
			<th class='columnheadercenter' width='40%'><fmt:message key="Common.Site.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='35%'><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
			<th class='columnheadercenter' width='25%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th></tr>	
	</table>
 </div>

 <% Connection con			= null;
	StringTokenizer tokenizeTilde = null;
	StringTokenizer tokenizePipe = null;
	String finalString = "";
	String classValue = "";
	String description = "";
	String searchText = request.getParameter("siteDesc");	
	//String seq_num = "";
	String siteName = "";
	//String flagY = "";
	String flag1="";
	String defaultY = "";
	String vaccineId = request.getParameter("vaccineId") == null ? "" :  request.getParameter("vaccineId");
	String subString = "";
	int slno = 1;
	int rowCount= 0; 	
	try
	{
		con = ConnectionManager.getConnection(request);
		if(searchText==null || searchText.equals("")||searchText.equals("%"))
				searchText = "%";
		else
			searchText = searchText.toUpperCase() +"%";
 %>
 <table class='grid' align='center'  width="100%"  >
 <%
		if(!operation.equals("split"))
		{		
			
			ArrayList retArray1 = sitesbean.getQueryForSite(vaccineId,searchText,con);
		//	out.println("retArray1  "+retArray1.size());
			if(retArray1 != null)
			{
				if(vaccineId.equals(""))
					{
					%>
					<script>
						getSiteForVaccineOnClick(parent.SitesForVaccineHeaderFrame.document.site_vaccine_form.siteDesc);
					</script>
					<%
					}
				 else
					{
						ArrayList arrayDesc = (ArrayList)retArray1.get(0);
						sitesbean.setConcatenatedString("");
						ArrayList  siteId  = (ArrayList)retArray1.get(1);
						ArrayList defaultId = (ArrayList)retArray1.get(2);
						ArrayList flag = (ArrayList)retArray1.get(3);
						sitesbean.setLength(arrayDesc.size()); 
											
						for(i = 0;i<arrayDesc.size();i++)
						{
							if(((String)flag.get(rowCount)).equals("Y"))
								{
									classValue ="gridData";//(rowCount % 2 ==0) ? "QRYEVEN" : "QRYODD";
									%>					
										<tr id ="trRowId<%=rowCount%>">  
											<td width='40%' class='<%=classValue%>'> 
											<%=(String)arrayDesc.get(rowCount)%>
											</td>	
											<td width='35%'  class='<%=classValue%>'>
											<input type='checkbox' name='defaultYN<%=rowCount%>' id='defaultYN<%=rowCount%>' value='<%=(String)defaultId.get(rowCount)%>' <%if (((String)defaultId.get(rowCount)).equalsIgnoreCase("Y")) out.println("checked");%>>
											</td>									
											<td width='25%'  class='<%=classValue%>'>
											<input type='checkbox' name='selectYN<%=rowCount%>' id='selectYN<%=rowCount%>' value='<%=(String)flag.get(rowCount)%>' OnClick ='removeRow(<%=rowCount%>)' <%out.println("checked");%>>
											</td>									
										</tr>		
										<input type ='hidden' name='siteName<%=rowCount%>' id='siteName<%=rowCount%>' value="<%=(String)siteId.get(rowCount)%>">
										<%	
										rowCount++;					
										slno++;
									}
							}
						}								
				
				} //if(retArray1 != null) Close
		}// if(!operation.equals("split")) Close
		else {
				String tempValue = request.getParameter("tempValue") == null ? "" : request.getParameter("tempValue");
				if(tempValue.equals("temp"))
					{
						finalString = request.getParameter("finalString") == null? "" :request.getParameter("finalString");
					}
				else
					{
								
						finalString = tempfinalString;
					}
                    //out.println("finalString in list" +finalString);
				sitesbean.setConcatenatedString(finalString);
				sitesbean.setLength(0);
				tokenizeTilde = new StringTokenizer(finalString,"~");
				classValue = "gridData";
				while(tokenizeTilde.hasMoreTokens())
				 {
					//classValue = ((rowCount%2)==0 )? "QRYEVEN" : "QRYODD";
					subString = tokenizeTilde.nextToken();
				//	out.println("subString  "+subString.toString());
					tokenizePipe =  new StringTokenizer(subString,"||");
					description =tokenizePipe.nextToken();
					siteName = tokenizePipe.nextToken();
					flag1 =tokenizePipe.nextToken();
					defaultY = tokenizePipe.nextToken();
				//	out.println("defaultY  "+defaultY);
					%>
						<tr id ="trRowId<%=rowCount%>">  
							<td width='40%' class='<%=classValue%>'> 
							<%=description%>
							</td>	
							<td width='35%'  class='<%=classValue%>'>
							<input type='checkbox' name='defaultYN<%=rowCount%>' id='defaultYN<%=rowCount%>' value='<%=defaultY%>' <%if (defaultY.equals("Y")) out.println("checked");%> >
							</td>									
							<td width='25%'  class='<%=classValue%>'>
							<input type='checkbox' name='selectYN<%=rowCount%>' id='selectYN<%=rowCount%>' value='Y' OnClick ='removeRow(<%=rowCount%>)' <%out.println("checked");%>>
							</td>									
						</tr>		
															
						<input type ='hidden' name='siteName<%=rowCount%>' id='siteName<%=rowCount%>' value='<%=siteName%>'>
					<%			rowCount++;		
				   }// while(tokenizeTilde.hasMoreTokens()) Closed
	
		} // else Closed
	%>
	
	</table>
 
	<input type ='hidden' name='finalString' id='finalString' value='<%=finalString%>'>     
	<input type ='hidden' name='array_length' id='array_length' value='<%=rowCount%>'> 
	<input type ='hidden' name='vaccineId' id='vaccineId' value=''> 
	<input type ='hidden' name='operation' id='operation' value=''> 
	<input type ='hidden' name='remove_value' id='remove_value' value='<%=removeValue%>'> 
	<!-- <input type='hidden' name='firstPos' id='firstPos' value=''>
	<input type='hidden' name='secPos' id='secPos' value=''> -->
	<%
	putObjectInBean("sitesbean",sitesbean,session);	


	}
	catch(Exception ee)
	{
		//out.println("Exception in Sites For Vaccine List Block: "+ ee.toString());//COMMON-ICN-0181	
		ee.printStackTrace();
	}
	finally
	{
		if(con != null) ConnectionManager.returnConnection(con);
	}
%>	
</form>
</body>
</html>

