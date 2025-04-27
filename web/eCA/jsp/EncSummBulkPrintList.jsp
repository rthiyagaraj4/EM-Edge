<!--[if IE 6]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if IE 7]>  
  <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN">
<![endif]-->  
<!--[if gte IE 7]>  
	<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd"> 
<![endif]-->
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
18/10/2013     		1   		Sethuraman      Created 
-------------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%@ page language="java" import ="webbeans.eCommon.*, eCA.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%	
	request.setCharacterEncoding("UTF-8");		
%>
<!DOCTYPE html>
<html>
	<head>		
		
		<%
			
			String sStyle =
			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			
			EncSummGroup summGrpDetails = new EncSummGroup();		
			
			int nListSize = 0;
					
			String specialtyCode = "", specialtyDesc = "", locnType = "", locnCode = "", locnDesc = "", practId = "";
			String  patientId = "", patientName = "", pracName = "", encounterId = "", searchDate = "", gender = "";	
			
			String prevSpecCode = "", prevLocnCode = "";
			
			specialtyCode = request.getParameter("specialtyCode") == null ? "" : request.getParameter("specialtyCode");
			locnType = request.getParameter("locnType") == null ? "" : request.getParameter("locnType");
			locnCode = request.getParameter("locnCode") == null ? "" : request.getParameter("locnCode");
			practId = request.getParameter("practId") == null ? "" : request.getParameter("practId");
			patientId = request.getParameter("patientId") == null ? "" : request.getParameter("patientId");
			encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
			searchDate = request.getParameter("searchDate") == null ? "" : request.getParameter("searchDate");
			gender = request.getParameter("gender") == null ? "" : request.getParameter("gender");
			
				
		%>
		<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css" />
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCA/js/EncSummBulkPrint.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
		
		
		//appends an "active" class to .popup and .popup-content when the "Open" button is clicked
		$(".open").on("click", function() {
		  $(".popup-overlay, .popup-content").addClass("active");
		});

		//removes the "active" class to .popup and .popup-content when the "Close" button is clicked 
		$(".close, .popup-overlay").on("click", function() {
		  $(".popup-overlay, .popup-content").removeClass("active");
		});

		window.addEventListener("click", function(event) {
			if (event.target == modal) {
				$(".popup-overlay, .popup-content").removeClass("active");
			  }
		});
		  
		
		</script>
		<style>			
			#header-fixed {
			    position: fixed;
			    top: 0px; 
			    display:none;
			    background-color:white;
			    clear:both;
			}
			
			.gridData
			{
				background-color: #FFFFFF;
				height:18px;
				font-family: Verdana, Arial, Helvetica, sans-serif;
				font-size: 8pt;
				color: #000000;
				font-weight:normal;
				text-align:left;
				padding-left:10px;
				padding-right:10px;
				vertical-align:middle;
				border-bottom:1px;
				border-top:0px;
				border-left:0px;
				border-right:0px;
				border-style:solid;
				border-color:#EEEEEE;
			}

			html {
			  font-family: "Helvetica Neue", sans-serif;
			  width: 100%;
			  color: #666666;
			  text-align: center;
			}

			.popup-overlay {
			  /*Hides pop-up when there is no "active" class*/
			  visibility: hidden;
			  position: absolute;
			  background: #ffffff;
			  border: 3px solid #666666;
			  width: 50%;
			  height: 20%;
			  left: 25%;
			}

			.popup-overlay.active {
			  /*displays pop-up when "active" class is present*/
			  visibility: visible;
			  text-align: center;
			}

			.popup-content {
			  /*Hides pop-up content when there is no "active" class */
			  visibility: hidden;
			}

			.popup-content.active {
			  /*Shows pop-up content when "active" class is present */
			  visibility: visible;
			}

			button {
			  display: inline-block;
			  vertical-align: middle;
			  border-radius: 30px;
			  margin: .20rem;
			  font-size: 1rem;
			  color: #666666;
			  background: #ffffff;
			  border: 1px solid #666666;
			}

			button:hover {
			  border: 1px solid #666666;
			  background: #666666;
			  color: #ffffff;
			}
			
		</style>
		
	</head>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name = 'encSummPopUpListForm'>
			<!--Creates the popup body-->
			<div class="popup-overlay">
			  <!--Creates the popup content-->
			  <div class="popup-content">
				<p> <img id="img-prog"  src="../../eCommon/images/processing-gif-transparent-3.gif"></img></p>
				<!--popup's close button-->
				<!--<button class="close">Close</button> -->
			  </div>
			</div>

			<table id="header-fixed" class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'></table>	
			<table class='grid' cellpadding='3' cellspacing='0' border='1' width='100%'  align='center'>
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' colspan='5'><fmt:message key="Common.AllEncounters.label" bundle="${common_labels}"/></td>					
				</tr>
				
			</table>	
			<table id="table-1" class='grid' cellpadding='3' cellspacing='0' border='0' width='100%'  align='center'>
			<thead>
			
				<tr id='trcoll'>
					<td class='COLUMNHEADERCENTER' width="10%" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' width="30%" ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' width="10%" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>					
					<td class='COLUMNHEADERCENTER' width="10%"><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></td>			
					<td class='COLUMNHEADERCENTER' width="10%"><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
					<td class='COLUMNHEADERCENTER' width="20%"><fmt:message key="Common.practitionername.label" bundle="${common_labels}"/></td>							
					<td class='COLUMNHEADERCENTER' width="20%"><fmt:message key="Common.selectall.label" bundle="${common_labels}"/> &nbsp;
						<input type='checkbox' name='selectAllchk' id='selectAllchk' onclick="setEncounter(this);"></td>					
				</tr>
			</thead>
			<tbody>
			
				<%										
					List<PatientEncounterBean> oPatientEncList = null;
					PatientEncounterBean sPatienEncBean = null;					
					
					try
					{
						oPatientEncList = new ArrayList<PatientEncounterBean>();
						sPatienEncBean = new PatientEncounterBean();
						
						sPatienEncBean.setRequest(request);
						sPatienEncBean.setsSpecialtyCode(specialtyCode);
						sPatienEncBean.setsCareLocnType(locnType);
						sPatienEncBean.setsCareLocnCode(locnCode);
						sPatienEncBean.setsPractID(practId);
						sPatienEncBean.setsPatientID(patientId);
						sPatienEncBean.setsEncounterID(encounterId);
						sPatienEncBean.setsVisitDateTime(searchDate);
						sPatienEncBean.setsGender(gender);
						
						oPatientEncList = summGrpDetails.getPatientEncounter(sPatienEncBean);		
						
						nListSize = oPatientEncList.size();	
						
						prevSpecCode = "";
						prevLocnCode = "";
						
						if (nListSize == 0)
						{
							%>	
								<script>
									alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
									parent.EncSummBulkListFrame.location.href = '../../eCommon/html/blank.html';
								</script>
							<%
						}
						
						for (int i=0;i<nListSize;i++){
							
							sPatienEncBean = oPatientEncList.get(i);
							
							specialtyCode = sPatienEncBean.getsSpecialtyCode();
							specialtyDesc = sPatienEncBean.getsSpecialtyDesc();
							locnType = sPatienEncBean.getsCareLocnType();
							locnCode = sPatienEncBean.getsCareLocnCode();
							locnDesc = sPatienEncBean.getsCareLocnDesc();
							practId = sPatienEncBean.getsPatientID();
							patientId = sPatienEncBean.getsPatientID();
							encounterId = sPatienEncBean.getsEncounterID();
							searchDate = sPatienEncBean.getsVisitDateTime();
							gender = sPatienEncBean.getsGender();
							pracName = sPatienEncBean.getsPractName();
							patientName = sPatienEncBean.getsPatientName();
							
							if (!specialtyCode.equalsIgnoreCase(prevSpecCode)){								
								%>												
								<tr>								
									<td colspan='7' class='CAGROUPHEADING'> <%=specialtyCode %> - <%=specialtyDesc %> </td>	
								</tr>	
								<%								
							}
							
							if (!locnCode.equalsIgnoreCase(prevLocnCode)){								
								%>												
								<tr>								
									<td colspan='7' class='CAGROUP'> &nbsp;&nbsp;&nbsp;&nbsp;<%=locnCode %> - <%=locnDesc %> </td>	
								</tr>	
								<%								
							}
							%>		
											
												
							<tr id ='trRowId<%=i %>'>								
								<td style='display:none'> <input type='hidden' name ='patientId<%=i %>' id ='patientId<%=i %>' value = '<%=patientId %>' > </td>
								<td style='display:none'> <input type='hidden' name ='encounterId<%=i %>' id ='encounterId<%=i %>' value = '<%=encounterId %>' > </td>
								<td class='gridData'> &nbsp;&nbsp;&nbsp;&nbsp;<%=patientId %> </td>	
								<td class='gridData'> <%=patientName %> </td>
								<!-- 
								<td class='gridData'> <a href="javascript:viewEncounterSummary('<%=patientId %>','<%=encounterId %>');"><%=encounterId %> </a> </td>								
								 -->
								 <td class='gridData'> <a href="javascript:checkForSummary('<%=patientId %>','<%=encounterId %>');"><%=encounterId %> </a> </td>
								<td class='gridData'> <%=searchDate %> </td>							
								<td class='gridData'> <%=gender %> </td>
								<td class='gridData'> <%=pracName %> </td>
								<td class='gridData'   align='center'> 
									<input type='checkbox' name='secChk<%=i %>' id='secChk<%=i %>' id='secChk<%=i %>'  onclick="setEncounterValue(this,'<%=patientId %>','<%=encounterId %>');">  
								</td>							
							</tr>	
							<%	
							prevSpecCode = specialtyCode;
							prevLocnCode = locnCode;
						}						

					}
					catch(Exception e)
					{
						//out.println("Exception in try of EncSummPopUpList.jsp"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}				
			%>
			</tbody>
			</table>	
			<input type='hidden' name='patientCount' id='patientCount' value='<%=nListSize%>'>	 
			
		</form>		
	</body>
</html>

