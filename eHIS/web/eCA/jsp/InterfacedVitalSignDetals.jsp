<%
/*	
--------------------------------------------------------------------------------------------------------------
 Date       	Edit History	Name       Rev.Date   	Rev.By    		Description
 --------------------------------------------------------------------------------------------------------------
 ?				?				?			?			?				?
 28/06/2020		IN072777		Ramesh G	01/07/2020	Ramesh Goli		AAKH-CRF-0097.2
 31/05/2021     IN017999        Chandrasekar a                          AAKH-CRF-0132.1 
 ---------------------------------------------------------------------------------------------------------------
 */
%>
<%@ page import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*,com.ehis.util.*,org.json.simple.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% String sStyle = CommonBean.checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script src='../../eCommon/js/dchk.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="JavaScript" src="../../eCA/js/VitalSign.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<style>
		//IN072777 Strt.
		.overFlowDiv{
			width:100%;
			height:100px;
			background-color:White;
			overflow: auto;
			overflow-y: scroll;
			max-width:100%;
			max-height:100px;
			border:none;
		}
		//IN072777 End.
		</style>
	</head>
	<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String bean_id="CAVitalSignBean";
       	String bean_name="eCA.CAVitalSignBean";
		String from_date 	= request.getParameter("From_date")==null?"":request.getParameter("From_date");
		String to_date 		= request.getParameter("To_date")==null?"":request.getParameter("To_date");
		String patient_id 	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		String Patient_class= request.getParameter("Patient_class")==null?"":request.getParameter("Patient_class");
		String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
		String graphMode=request.getParameter("graphMode")==null?"":request.getParameter("graphMode");
		String selectedDiscret = request.getParameter("selectedDiscret")==null?"":request.getParameter("selectedDiscret"); //IN072777
		String bed_no=request.getParameter("bed_no")==null?"":request.getParameter("bed_no");//Added for IN017999
		int totDiscCount 	= 0;
		String classValue 	= "";
		String recordeddate="";
		StringBuffer totalDiscrId = new StringBuffer();
		ArrayList<String[]> chartDetails = new ArrayList<String[]>();  //IN072777 Strt.
		String count=request.getParameter("count")==null?"":request.getParameter("count");
	%>
    <body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>		
		<form name = 'VitalSignResultFormDetals'  method="post" target="messageFrame">
			<%
			try{
				eCA.CAVitalSignBean bean = (eCA.CAVitalSignBean)getBeanObject(bean_id,bean_name,request);
				HashMap<String,String> valueIndicator = bean.getValueIndication();
				LinkedHashMap<String,ArrayList<String[]>> resultData = bean.getDiscreteCompResult(from_date,to_date,patient_id,encounter_id,bed_no);//Added for IN017999
			
				if(resultData.size() == 0){
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));");
					out.println("parent.VitalSignButtonFrm.location.href = \"../../eCA/jsp/blank.jsp?totDiscCount=\"");
					out.println("</script>");
				}else{
					//IN072777 Strt.
					chartDetails=bean.getAppChartDetails(selectedDiscret);  					
					%>
					 <fieldset style="border:1px solid Greay;">
							<legend>Chart Name&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id='select_all' name='select_all' id='select_all' onClick='selectAllChart(this)' /><fmt:message key="Common.selectall.label" bundle="${common_labels}"/></legend>
							<div class="overFlowDiv" id="applCharts">
								<%
								for(int j=0;j<chartDetails.size();j++){
									String[] chartIdVal = chartDetails.get(j);
									String checkedVal = "";
									if("Y".equals(chartIdVal[2]))
										checkedVal="Checked";
								%>
									<input type="checkbox" id="ChartID<%=j%>" Value="<%=chartIdVal[0] %>" <%=checkedVal%>/><%=chartIdVal[1] %><br>
								<%}%>								
								
							</div>
					</fieldset>
					<br>
					<!-- IN072777 End. -->
					<table cellspacing='0' cellpadding='0' align='center' width='100%' border='0' >
					<%
					for(Map.Entry<String,ArrayList<String[]>> entry :resultData.entrySet()){
						ArrayList<String[]> child = entry.getValue();
						classValue="CAFLOWSHEETLEVEL3" ;
						String discr_msr_id=entry.getKey();
						String[] str = child.get(0);
						if(totDiscCount==0)
							totalDiscrId.append(discr_msr_id);
						else
							totalDiscrId.append(','+discr_msr_id);
						totDiscCount++;
						%>
						<tr >
							<td align="left" width="5%"  class="<%=classValue%>" id="<%=discr_msr_id%>">
								<img  src="..\..\eCommon\images\tri.gif" onClick="detailsExpended('<%=discr_msr_id%>')"/>
							</td>
							<td align="left" valign="middle" class="<%=classValue%>" colspan='2'>
								<%=str[1]%>
							</td>
							<td align="left" width="10%"  class="<%=classValue%>">&nbsp;</td>
							<td align="left" width="10%"  class="<%=classValue%>">
								<input type='radio' name ="M<%=discr_msr_id%>" id="M<%=discr_msr_id%>" value="" onClick="detailsExpended('<%=discr_msr_id%>');selectAll('<%=discr_msr_id%>');getChartDetails('<%=discr_msr_id%>');"/>
							</td>
						</tr>
						<%
						
						int i=0;
						for(String[] arr : child){
							String[] inner  = new String[2];
							inner = arr[0].split("#");
							recordeddate = inner[0];							
							String image=valueIndicator.get(inner[2]);
							
							%>
								<tr id="<%=discr_msr_id%>_<%=i%>" style="display:none;">
									<td align="left" width="5%" valign="middle">&nbsp;</td>
									<td align="left" width="45%" valign="middle"><%=inner[0]%></td>
									<td align="left" width="30%" valign="middle">
										<%if(null!=image && !"".equals(image.trim())){%>
											<img src="..\..\eCA\images\<%=image%>" />
										<%}%>
										&nbsp;&nbsp;
										<%=inner[1]%>
									</td>
									<td align="left" width="10%" valign="middle">
										<input type='checkbox' name ="C<%=discr_msr_id%><%=i%>" id="C<%=discr_msr_id%>" value="" onClick="countCheck(this,'<%=discr_msr_id%>','<%=discr_msr_id%>_<%=i%>');" disabled >
										<input type='hidden' name='CR<%=discr_msr_id%>_<%=i%>' id='CR<%=discr_msr_id%>_<%=i%>' id='CR<%=discr_msr_id%>_<%=i%>' value="<%=recordeddate%>" />
										<input type='hidden' name='CV<%=discr_msr_id%>_<%=i%>' id='CV<%=discr_msr_id%>_<%=i%>' id='CV<%=discr_msr_id%>_<%=i%>' value="<%=inner[1]%>" />
									</td>
									<td align="left" width="10%" valign="middle">&nbsp;</td>
								</tr>
							<%
							i++;
						}
						%>
						<input type="hidden" name="<%=discr_msr_id%>Total" id="<%=discr_msr_id%>Total" id="<%=discr_msr_id%>Total" value="<%=i%>"/>
						
						<input type="hidden" name="MV<%=discr_msr_id%>" id="MV<%=discr_msr_id%>" id="MV<%=discr_msr_id%>" value="<%=i%>"/>						
						
						<%
					}
					%>
					</table>
					<input type="hidden" name="preDisMsrId" id="preDisMsrId" id="preDisMsrId" value=""/>
					<input type="hidden" name="totDiscCount" id="totDiscCount" id="totDiscCount" value="<%=totDiscCount%>"/>
					<input type="hidden" name='graphMode' id='graphMode' id='graphMode' value='<%=graphMode%>'/>
					<input type="hidden" name='encounter_id' id='encounter_id' id='encounter_id' value='<%=encounter_id%>'/>
					<input type="hidden" name='totalDiscrIds' id='totalDiscrIds' value='<%=totalDiscrId.toString()%>'/>
					<input type="hidden" name='selectedValues' id='selectedValues' id="selectedValues" value=''/>
					<input type="hidden" name="patient_id" id="patient_id" id="patient_id" value="<%=patient_id%>" />
					<input type="hidden" name="totalCharts" id="totalCharts" id="totalCharts" value="<%=chartDetails.size()%>" />  <!-- IN072777 -->
					<input type=hidden name='selectedChartDetails' id='selectedChartDetails' value=''> <!-- IN072777-->
					<input type="hidden" name='bed_no' id='bed_no' value='<%=bed_no%>'><!-- added for IN017999 -->
					<%
				}
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();
			}
			%>
		</form>
		<script>
		parent.VitalSignButtonFrm.location.href = "../../eCA/jsp/VitalSignButtons.jsp?totDiscCount=<%=totDiscCount%>&graphMode=<%=graphMode%>";	
		parent.VitalSignGraphDetals.location.href = "../../eCA/jsp/blank.jsp";	
		</script>
	</body>
</html>

