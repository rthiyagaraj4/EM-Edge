<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
22/01/2019	IN069244		Ramya Maddena		  25/01/2019		Ramesh Goli	   MMS-KH-CRF-0005.1
31/05/2021  IN017999        Chandrashekar A                                        AAKH-CRF-0132.1 
13-10-2023                  Srinivasa N T         16-10-2023        Ramesh Goli    AAKH-CRF-0165
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="JavaScript" src="../js/VitalSign.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	    
		<%
		Connection con = null;
		
		String short_desc1="";
		String recordeddate="";
		String discr_msr_id1="";
		String bean_id="CAVitalSignBean";
       		String bean_name="eCA.CAVitalSignBean";
		String mode="";
	        eCA.CAVitalSignBean bean = (eCA.CAVitalSignBean)getBeanObject(bean_id,bean_name,request);
		
		mode = request.getParameter("mode") == null ? "insert" : request.getParameter("mode");
		discr_msr_id1 =request.getParameter("discr_msr_id1")==null?"":request.getParameter("discr_msr_id1");
		String from_date =request.getParameter("From_date")==null?"":request.getParameter("From_date");
		String to_date =request.getParameter("To_date")==null?"":request.getParameter("To_date");
		String patient_id =request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String Patient_class =request.getParameter("Patient_class")==null?"":request.getParameter("Patient_class");
		String encounter_id =request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String graphMode=request.getParameter("graphMode")==null?"":request.getParameter("graphMode");
		String bed_no=request.getParameter("bed_no")==null?"":request.getParameter("bed_no");//Added for IN017999
		StringBuffer totalDiscrId = new StringBuffer();
		int totDiscCount =0;
		String classValue ="";
	  
		try
		{
			con	= ConnectionManager.getConnection(request);	
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
boolean siteUom =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","UOM_DETAILS");//AAKH-CRF-0165
//System.out.println("siteUom----VitalSignResult.jsp---->"+siteUom);
		%>
	</head>
     	 <body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>		
		   <form name = 'VitalSignResultForm'  method="post" target="messageFrame">
            <%
			HashMap<String,String> valueIndicator = bean.getValueIndication();
			LinkedHashMap<String,ArrayList<String[]>> resultData = bean.getDiscreteCompResult(from_date,to_date,patient_id,encounter_id,bed_no);//Added for IN017999
			
			if(resultData.size() == 0)
		    {
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
				out.println("parent.VitalSignButtonFrm.location.href = \"../../eCA/jsp/blank.jsp?totDiscCount=0\"");
				out.println("</script>");
		    }else{
		    	
			%>
				<table cellspacing='0' cellpadding='0' align='center' width='98%' border='0' >
					<tr>
						<td class="columnheader"  width='34%'  nowrap><fmt:message key="Common.recordeddatetime.label" bundle="${common_labels}"/></td>
						<td class="columnheader"  width='33%'  nowrap><fmt:message key="Common.Value.label" bundle="${common_labels}"/></td>
						<% if(siteUom){ %>
						<td class='columnHeadercenter'  border='20%'><fmt:message key="Common.Units.label" bundle="${common_labels}"/></td>
						<%} %>
						<td class='columnheader' width='13%' nowrap><fmt:message key="Common.selectall.label" bundle="${common_labels}"/>
							<input type=checkbox id='select_all' name='select_all' id='select_all' onClick='clickAll(this)'><BR>
						</td>
					</tr>
				<%
						for(Map.Entry<String,ArrayList<String[]>> entry :resultData.entrySet()){
						
						ArrayList<String[]> child = entry.getValue();
						classValue="CAFLOWSHEETLEVEL3" ;	
						
						String discr_msr_id=entry.getKey();
						String[] str = child.get(0);
						short_desc1=str[1];
						if(totDiscCount==0)
							totalDiscrId.append(discr_msr_id);
						else
							totalDiscrId.append(','+discr_msr_id);
						totDiscCount++;
					%>		
						<tr>
							<td align="left" width='34%'  valign="middle"  class="<%=classValue%>"><font size='1'><%=short_desc1%></font>
								<input type='checkbox' width='5%' valign="center" name ="M<%=discr_msr_id%>" id='M<%=discr_msr_id%>' onClick="selectGrp(this,'<%=discr_msr_id%>')">
							</td>
							<td  width='33%' class="<%=classValue%>">&nbsp;</td>
							<td  width='33%' class="<%=classValue%>">&nbsp;</td>
							<td  width='33%' class="<%=classValue%>">&nbsp;</td>
						</tr>
						<%
						int i=0;
						for(String[] arr : child){
							String[] inner  = new String[2];
							inner = arr[0].split("#");
							recordeddate = inner[0];
							System.out.println("date--"+recordeddate);
							String value 		= inner[1];
							String indicator	= inner[2];
							String units = inner[3];
							String image=valueIndicator.get(indicator);
						%>
						<tr>
							<td align="left" id="<%=recordeddate%>_<%=i%>">&nbsp;&nbsp;&nbsp;&nbsp;<%=recordeddate%></td>
							<td align="left" >
								<%if(null!=image && !"".equals(image.trim())){%>
									<img src="..\..\eCA\images\<%=image%>" />
								<%}%>&nbsp;&nbsp;<%=value%></td>
							<% if(siteUom){ %>
							<td align="left">
								<%=units%>
							</td>
							<%}%>
							<td align="left" >
								<input type='checkbox' name ="C<%=discr_msr_id%><%=i%>" id='C<%=discr_msr_id%>' value="" onClick='selectEvent(this,"<%=discr_msr_id%>")'>
								<input type='hidden' name='CR<%=discr_msr_id%>_<%=i%>' id='CR<%=discr_msr_id%>_<%=i%>' id='CR<%=discr_msr_id%>_<%=i%>' value="<%=recordeddate%>" />
							</td>
						</tr>
						
						<%i++;
						}
						%>
						<input type="hidden" name="MV<%=discr_msr_id%>" id="MV<%=discr_msr_id%>" id="MV<%=discr_msr_id%>" value="<%=i %>"/>
						<% 
					}
					%>
  				</table>
					<input type=hidden name='encounter_id' id='encounter_id' value='<%=encounter_id%>'>
					<input type=hidden name='totalDiscrIds' id='totalDiscrIds' value='<%=totalDiscrId.toString()%>'>
					<input type=hidden name='Patient_class' id='Patient_class' value='<%=Patient_class%>'>
					<input type=hidden name='graphMode' id='graphMode' value='<%=graphMode%>'>
					<input type=hidden name='selectedChartDetails' id='selectedChartDetails' value=''> <!-- IN072777-->
					<input type=hidden name='bed_no' id='bed_no' value='<%=bed_no%>'><!-- added for IN017999 --> 
					<input type=hidden name='patient_id' id='patient_id' value='<%=patient_id%>'><!-- added for IN017999 --> 
				</form>
				<script>
				parent.VitalSignDetals.location.href = "../../eCA/jsp/VitalSignApplicableChartDetails.jsp";
				parent.VitalSignButtonFrm.location.href = "../../eCA/jsp/VitalSignButtons.jsp?totDiscCount=<%=totDiscCount%>&graphMode=<%=graphMode%>";
				</script>
		<%}%>	
        </body>
		<%	
		}
		catch(Exception e)
		{
			//out.println(e);//COMMON-ICN-0181
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
	private String checkForNull(String inputString,String defaultValue)
	{
		return (inputString==null)	?	defaultValue :	inputString;
	}
%>

