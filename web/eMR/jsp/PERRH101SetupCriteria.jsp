<!DOCTYPE html>
<!--Created by Afruddin on 28-jun-2020 for ML-MMOH-CRF-1527-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,org.json.simple.*,java.util.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %> 
<html>

<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eMR/js/PERRH101Setup.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<%
		Connection con = null;
		String locale					= (String)session.getAttribute("LOCALE");
		String facility_id				= checkForNull((String)session.getValue("facility_id"));
        
        
			
		try
		{
			con		= ConnectionManager.getConnection(request);	

			request.setCharacterEncoding("UTF-8");
			
				
			String PAT_CAT_CODE ="";		
			String SHORT_DESC ="";	
			String RH_PAT_CAT_CODE ="";	
			String RH_CAT_CODE="";
			String ArmySelected="";
			String FamArmySelected="";
			String VetArmySelected="";
			String PublicSelected="";
		
	        JSONArray patCategoryjsonArr = new JSONArray();
		    patCategoryjsonArr = eMR.MRCommonBean.getPatientCategory(con);
			int noOfRecords = patCategoryjsonArr.size();
			
            JSONArray rhCategoryjsonArr = new JSONArray();
            rhCategoryjsonArr = eMR.MRCommonBean.getRhcategory(con,facility_id);
			
			
			
			int rhcatsize=rhCategoryjsonArr.size();
            
			   
		%>
</head>

<body OnMouseDown="CodeArrest()" >

<form name='PERRH101SetupCriteriaForm' id='PERRH101SetupCriteriaForm' action="../../servlet/eMR.PERRH101SetupServlet" method='post' target='messageFrame'>
              <br>
			  <br>
			  <%
	    if(noOfRecords == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
		}
		else{
	                    
%>
                       <table cellspacing='0' cellpadding='0' align='center' width='60%' border='1' style='margin-left:5px;'>
				
						
						<tr>		
							<td width='20%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='20%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;</td>
							<td width='20%' height="20" class="columnheadercenter" style="background-color: black; color: white;" align='center' nowrap><fmt:message key="eMR.RH101PatientCategory.label" bundle="${mr_labels}"/>&nbsp;</td>
                    <%
						 
								
						
                        

						for(int i = 0 ; i < patCategoryjsonArr.size() ; i++) 
						{
						JSONObject PatCatObj	= (JSONObject)patCategoryjsonArr.get(i);
						PAT_CAT_CODE	= (String) PatCatObj.get("PAT_CAT_CODE");
						SHORT_DESC		= (String) PatCatObj.get("SHORT_DESC");
                        ArmySelected = "";
						FamArmySelected = "";
						VetArmySelected = "";
						PublicSelected = "";
					
                       
					%>
						<%for(int j = 0 ; j < rhCategoryjsonArr.size() ; j++) 
						{

						JSONObject RHCatObj	= (JSONObject)rhCategoryjsonArr.get(j);
						RH_PAT_CAT_CODE	= (String) RHCatObj.get("PAT_CAT_CODE");
						RH_CAT_CODE		= (String) RHCatObj.get("RH_CAT_CODE");
								
						
							

						if(PAT_CAT_CODE.equals(RH_PAT_CAT_CODE))
							{
							
							

								if(RH_CAT_CODE.equals("A")){
									ArmySelected = "Selected";
								}else
								{
									ArmySelected = "";
								}
								if(RH_CAT_CODE.equals("FA")){
									FamArmySelected = "Selected";
								}else
								{
									FamArmySelected = "";
								}

								if(RH_CAT_CODE.equals("VA")){
									VetArmySelected = "Selected";
								}else
								{
									VetArmySelected = "";
								}

								if(RH_CAT_CODE.equals("P")){
									PublicSelected = "Selected";
								}else
								{
									PublicSelected = "";
								}

							}
						
							
						}%>
                 
				        <tr>
							
							<td width='20%' nowrap class='label' ><%=PAT_CAT_CODE%></td>
							<td width='20%' nowrap class='label' ><%=SHORT_DESC%></td>
                            <td  class='label' width='10%' align='right'>
							  
			               <select name='rh_cate_code<%=i%>' id='rh_cate_code<%=i%>'>
					       <option value=''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
					       <option value="A" <%=ArmySelected%>><fmt:message key="Common.Army.label" bundle="${common_labels}"/></option>
					       <option value="FA" <%=FamArmySelected%>><fmt:message key="Common.FamilyArmy.label" bundle="${common_labels}"/></option>
						   <option value="VA" <%=VetArmySelected%>><fmt:message key="Common.VeteranArmy.label" bundle="${common_labels}"/></option>
						   <option value="P" <%=PublicSelected%>><fmt:message key="Common.Public.label" bundle="${common_labels}"/></option>
				           </select>
                           
			    </td>
				        <input type ='hidden' name ="PAT_CAT_CODE<%=i%>" value ='<%=PAT_CAT_CODE%>'>
						 
						</tr>
                       

						
						
					<%	}%>

						</table>
						
			<%
			            }
                        %>	
						  <input type ='hidden' name ='maxrecord' value ='<%=noOfRecords%>'>
</form>

</body>

<%			
		}catch(Exception e)
		{
			//out.println(e);
			e.printStackTrace();
		}
		finally
		{
			ConnectionManager.returnConnection(con,request);
		}
%>

</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

