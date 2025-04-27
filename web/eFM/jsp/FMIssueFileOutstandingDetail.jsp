<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.io.*, java.text.*,webbeans.eCommon.*,eFM.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="FMIssueFileAddBean" scope="session" class="eFM.FMIssueFileAddBean"/>
<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/

String issue_file_refresh_interval	= (request.getParameter("issue_file_refresh_interval")=="" || request.getParameter("issue_file_refresh_interval")==null)?"":request.getParameter("issue_file_refresh_interval"); 
String isRefreshIntervalAvailable	= checkForNull(request.getParameter("isRefreshIntervalAvailable"),"false");
String isAutoPopulateAvailable		= checkForNull(request.getParameter("isAutoPopulateAvailable"),"false");
/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/

%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js' ></script>	
	<script language='javascript' src='../../eCommon/js/tableheaderscroll.js'></script><!-- Supporting Js File For Fixed Header with scroll.... -->
	<!-- Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start -->
	<script>
		<%if(!issue_file_refresh_interval.equals("") && isRefreshIntervalAvailable.equals("true")){ %>
			
				refreshparam=<%=issue_file_refresh_interval%>*60*1000;
				self.setInterval('parent.parent.frames[2].document.forms[0].okbutton.click()',refreshparam);
			
		<%}%>
		window.onload=function(){
			if(document.getElementById("TableData")!=null && document.getElementById("count").value > 0)			
				fxheaderInit('TableData',210);
			else
				document.getElementById("reqfileheader").style.display='none';
		};
	</script>
	<!-- Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End -->
</head>
<%
	Connection con			 = null;	
	PreparedStatement pstmt	 = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs			 = null;
	ResultSet rs1			 = null;

	String facility_id				= (String) session.getValue("facility_id");

	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String ReqOn				= request.getParameter("ReqOn");
	String RequestedOn		= "";
	String Req_by				= "";
	String Req_no				= "";
	String Req_by_name		= "";
	String  Reqlocndesc ="";
	//String Reqno				= request.getParameter("Reqno");
	String Reqfacilityid			= request.getParameter("Reqfacilityid");
	String Reqfacilityname	= request.getParameter("Reqfacilityname");
	String Reqfslocncode		= request.getParameter("Reqfslocncode");
	String Reqfslocndesc		= request.getParameter("Reqfslocndesc");
	String Reqfslocnidentity	= request.getParameter("Reqfslocnidentity");
	String Reqlocnismrlocnyn= request.getParameter("Reqlocnismrlocnyn");
	String Narrationcode		= request.getParameter("Narrationcode");
	String Narrationdesc		= request.getParameter("Narrationdesc");
	String NoOfdays			= request.getParameter("NoOfdays");
	
	String s_file_type			= request.getParameter("s_file_type");
	String file_type_appl_yn	= request.getParameter("file_type_yn");
	String Reqfslocnid			= request.getParameter("Reqfslocnid");
	 String file_no_concat                = request.getParameter("file_no_concat");
     String volume_no_concat= request.getParameter("volume_no_concat");
	 String file_type_desc="";
	 if(file_no_concat==null) file_no_concat="";
	if(volume_no_concat==null) volume_no_concat="";
	
	String classValue			= "";
	String checkStatus			= "";
	String req_remarks		= "";
	String volume_no			= "";
	String file_type				= "";
	String file_status				= "";
	String iss_date_time			= "";
	String chkVal				= "Y";
	//String p_concat_string ="";
	String Remarks				= 
	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
	String classVal				= "mediumaquamarine";

	String checkValue			= "checked";
	/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
	if(isAutoPopulateAvailable.equals("true")){
		checkValue				= "";
	}
	/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
	
	String patient_id = "";
   	String nat_id="";
	String alt_id="";
	String disp_id="";
	String  requesting_from_desc="";//added for MMS-QH-CRF-0146.1 [IN:045787]
	String req_pract="";//added for MMS-QH-CRF-0146.1 [IN:045787]
	String Patient_Line="";
   ArrayList inselm;
	inselm = new ArrayList();

	int i				= 1;
	int temp			= 1;
	 
	String concat_str="";
	String concat_str1="";
	boolean file_exist = false, p_same_file_no_exist = false;
	boolean file_found = false;
	try
	{
		con = ConnectionManager.getConnection(request);		


		s_file_type	= ((s_file_type == null) || (s_file_type.equals("null"))) ? "" : s_file_type;
			if(resLocnIdentities == null || resLocnIdentities.equals("null")) resLocnIdentities = "N";

		if(Reqfslocnid == null || Reqfslocnid.equals("null")) Reqfslocnid = "";
		
		if((file_type_appl_yn == null) || (file_type_appl_yn.equals("")) || (file_type_appl_yn.equals("null")))
		{
			file_type_appl_yn = "N";
		}

%>
	
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
	<form name='IssueOutstandingDetail' id='IssueOutstandingDetail' method='post' target='messageFrame' action='../../eFM/jsp/FMIssueFilesUpdateBean.jsp'>
		<div id="reqfileheader" style="COLOR:#444444;FONT-SIZE: 8pt;FONT-WEIGHT: bolder ;"><fmt:message key="eFM.RequestedFiles.label" bundle="${fm_labels}"/></div>
		<table border="1" width="100%"  style='border-spacing:0px ;border-collapse: collapse;' id='TableData'>
						<%
					
			  sortFMFilesIssueCart(FMIssueFileAddBean);
	        	  ArrayList ArrFileCart	= (ArrayList) FMIssueFileAddBean.getPresCart();
	      				
					int cnt=0;
					
	webbeans.eFM.FMFilesIssueDetail fissuebean = new webbeans.eFM.FMFilesIssueDetail();
	
	
	 for(cnt=0;cnt < ArrFileCart.size();cnt++)
	 {
	    fissuebean	=	FMIssueFileAddBean.getIssuesfromCart(cnt);
			  
		  if( cnt% 2 == 0) classValue = "QRYEVEN" ;
	     	else classValue = "QRYODD" ;
			String mlc_yn = "";
			String ReqCommVal = "";

						if (cnt== 0)
						{%>
							
							<tr>
							<%	if(file_type_appl_yn.equals("N")) { %>
								<td  width='30%' class='COLUMNHEADER'><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
								<td width='25%' class='COLUMNHEADER'><fmt:message key="eFM.RequesterDetails.label" bundle="${fm_labels}"/></td>
								<td width='5%' class='COLUMNHEADER'><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
						<% } else if (file_type_appl_yn.equals("Y")) { %>
								<td width='30%' class='COLUMNHEADER'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
								<td width='25%' class='COLUMNHEADER'><fmt:message key="eFM.RequesterDetails.label" bundle="${fm_labels}"/></td>
								<td width='5%' class='COLUMNHEADER'><fmt:message key="eFM.FileTypeVolumeNo.label" bundle="${fm_labels}"/></td>
						<% } %>
							<td width='12%' class='COLUMNHEADER'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
							<td width='5%' class='COLUMNHEADER'><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></td>
							<td width='19%' class='COLUMNHEADER'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
							<td width='5%' class='COLUMNHEADER'><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></td>
							<td width='5%' class='COLUMNHEADER'><fmt:message key="eFM.FileRequiredOn.label" bundle="${fm_labels}"/></td>
							<td width='10%' class='COLUMNHEADER'><fmt:message key="Common.Issue.label" bundle="${common_labels}"/>?</td></tr>
							</tr>
							<%
						}
						if(i % 2 == 0) classValue = "QRYEVEN" ;
						else classValue = "QRYODD" ;
						
						ReqOn				=checkForNull(fissuebean.getRet_Date_Time());						
						RequestedOn		= checkForNull(fissuebean.getRequest_Date_Time());
						
						ReqOn				= DateUtils.convertDate(ReqOn,"DMYHM","en",localeName); // incident [46675]
						//RequestedOn		= DateUtils.convertDate(RequestedOn,"DMY","en",localeName); //this line commented for this incident [40681]
						
						Reqfacilityid			= checkForNull(fissuebean.getReq_Facility_Id());
						Reqfacilityname	= checkForNull( fissuebean.getReq_Facility_Name());
						Reqfslocncode		= checkForNull( fissuebean.getRec_Locn_Code());
						Reqlocndesc     =checkForNull(fissuebean.getIndex_Value());
						Reqfslocndesc		= checkForNull( fissuebean.getRec_Name_Desc());
						Reqfslocnidentity	= checkForNull( fissuebean.getRec_Locn_Identity());
				     	Narrationcode		= checkForNull(fissuebean.getNarration_Code());
						Narrationdesc		= checkForNull(fissuebean.getMovement_Narration());
						Reqfslocnid			= checkForNull( fissuebean.getRequesting_From());
						Reqlocnismrlocnyn = checkForNull(fissuebean.getRec_MR_Location());
						String cuurIden = checkForNull(fissuebean.getIss_Locn_Identity());
						if(cuurIden == null || cuurIden.equals("null")){
						cuurIden="";}
						String currStatus = checkForNull( fissuebean.getThird_Party_Name());
						if(currStatus == null || currStatus.equals("null")){
						currStatus="";}					
						String currLocn = checkForNull(fissuebean.getIss_Locn_Code());
						if(currLocn == null || currLocn.equals("null")){
						currLocn="";}
						String permLocn = checkForNull(fissuebean.getSrc_User_Id());
						if(permLocn == null || permLocn.equals("null")){
						permLocn="";}
						req_remarks		= checkForNull( fissuebean.getReq_Remarks());
						if(req_remarks ==null) req_remarks="";
						String locn_iden_desc = "";
						String RemarksValue  =fissuebean.getReq_Remarks();	
						
						if(RemarksValue==null) RemarksValue="";

						if(!RemarksValue.equals("")) 
							ReqCommVal = RemarksValue;
						else if(!req_remarks.equals(""))
							ReqCommVal = req_remarks;						

						Req_by_name = checkForNull(fissuebean.getRec_Name_Desc());
						Req_by = checkForNull(fissuebean.getRec_Name());
						Req_no = checkForNull(fissuebean.getReq_No());

						patient_id = checkForNull(fissuebean.getPatient_Id());
					  	Patient_Line=fissuebean.getPatient_Line();
						mlc_yn =fissuebean.getMLC_Check() == null?"N":fissuebean.getMLC_Check();		


						nat_id= fissuebean.getCarried_By()==null?"":fissuebean.getCarried_By();
						
						disp_id=nat_id;
						if(nat_id.equals(""))
						{
						 	disp_id=alt_id;
						}
                 		switch(cuurIden.charAt(0))
						{
							case 'D' : locn_iden_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); 
								break;
							case 'T' : locn_iden_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); 
								break;
							case 'C' : locn_iden_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;
							case 'N' : locn_iden_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;
							case 'X' : locn_iden_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;
							case 'E' : locn_iden_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;
							case 'Y' : locn_iden_desc =  com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
							default : locn_iden_desc = "";
						}
						//added for MMS-QH-CRF-0146.1 [IN:045787]
                 		requesting_from_desc=checkForNull( fissuebean.getRequesting_From_Desc());
                 		req_pract=checkForNull( fissuebean.getReq_Pract());
					if(!(requesting_from_desc.equals("")) && !(req_pract.equals("")))
							req_pract =  " / " +req_pract;
						
						volume_no	=	checkForNull( fissuebean.getVolume_No());
						file_type	=	checkForNull(fissuebean.getFile_Type());
                   		file_type_desc=checkForNull(fissuebean.getFile_Typedesc());
						if((file_type_desc == null) || (file_type_desc.equals("null"))) file_type_desc	= "&nbsp;";
						else file_type_desc = file_type_desc + " / ";

						if((volume_no == null) || (volume_no.equals("null"))) volume_no	= "&nbsp;";
			
					
						if(currStatus.equals("I") && currLocn.equals(permLocn))
						{
								
							temp = 1;
							/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
							//checkValue = "checked";
							if(!isAutoPopulateAvailable.equals("true")){
								checkValue = "checked";
							}
							/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
							checkStatus = "";
							chkVal = "Y";
							Remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
						}
						else
						{
							
							temp = 1;
							
							
							/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
								//checkValue = "unchecked";
								if(!isAutoPopulateAvailable.equals("true")){
									checkValue = "unchecked";
								}
								/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
							
							checkStatus = "disabled";
							chkVal = "N";
						}
						file_exist = FMIssueFilesCart.FileNoExist(Req_no,fissuebean.getFile_No(),volume_no);
						file_found = FMIssueFilesCart.SameFileNoExist(fissuebean.getFile_No());
						
										
						if(file_exist)
						{
							/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
							//checkValue = "checked";
							if(!isAutoPopulateAvailable.equals("true")){
								checkValue = "checked";
							}
							/*Modified For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
							checkStatus = "disabled";
							chkVal = "Y";
						}
						if(!file_exist)
						{
							p_same_file_no_exist = FMIssueFilesCart.SameFileNoExist(fissuebean.getFile_No());
							if(p_same_file_no_exist)
							{
								checkValue = "";
								checkStatus = "disabled";
								chkVal = "N";
							}
						}
								
						concat_str1=patient_id+file_type+volume_no;
												

						if(!p_same_file_no_exist) {

							StringTokenizer st = new StringTokenizer(concat_str,"~");

							while(st.hasMoreTokens()) {
								
								String element = st.nextToken();
								if(concat_str1.equals(element) && (currStatus.equals("I"))) {
									
									checkValue  = "";
									checkStatus = "";
									chkVal = "N";
									inselm.add(element);
								} 

								
						   } 
					   }

					   if(concat_str.equals(""))
							concat_str = concat_str1;
					   else 
							concat_str = concat_str+"~"+concat_str1;

					   String FileNoValue =  fissuebean.getFile_No();
					   if(FileNoValue == null || FileNoValue.equals("null")) FileNoValue = "";

			
						%>
						<tr>
						<%
					
						if(file_type_appl_yn.equals("N")) {	%>
							<td class=<%=classValue%>><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="parent.callPatDetails('<%=patient_id%>')">&nbsp;+&nbsp;</A><font size='1'><b><%=FileNoValue%> </b></font> <br>&nbsp;&nbsp;&nbsp; <font size='1'> <%=Patient_Line%>, <%=disp_id%><br><fmt:message key="eFM.RequestedFrom.label" bundle="${fm_labels}"/> <%=Reqlocndesc%>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<%=Req_by_name%></font></td>
							<!--added for MMS-QH-CRF-0146.1 [IN:045787]-->
						   <td class="<%=classValue%>" align="CENTER"><font size='1'><%=requesting_from_desc%><%=req_pract%></font></td>
						   <td class="<%=classValue%>" align="CENTER"><font size='1'><%=volume_no%></font></td>
					<% } else if(file_type_appl_yn.equals("Y"))	{ %>
						   <td class=<%=classValue%>><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="parent.callPatDetails('<%=patient_id%>')">&nbsp;+&nbsp;</A><font size='1'></font>&nbsp;<font size='1'> <%=Patient_Line%>, <%=disp_id%><br><fmt:message key="eFM.RequestedFrom.label" bundle="${fm_labels}"/> <%=Reqlocndesc%>&nbsp;<fmt:message key="Common.by.label" bundle="${common_labels}"/>&nbsp;<%=Req_by_name%></font></td>
						   <!--added for MMS-QH-CRF-0146.1 [IN:045787]-->
						  <td class="<%=classValue%>" align="CENTER"><font size='1'><%=requesting_from_desc%><%=req_pract%></font></td>
						   <td class="<%=classValue%>" align="CENTER"><font size='1'><%=file_type_desc%><%=volume_no%></font></td>

					<% } %> 

<%
     file_status=currStatus;
	if(!file_status.equals(""))
		{
			switch(file_status.charAt(0))
			{
				case 'T' : file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

				case 'I' : file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

				case 'L' : file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

				case 'A' : file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

				case 'O' : file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

				case 'E' : file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;

				case 'R' : file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;
			}
		}

	
%>
					<td class=<%=classValue%>><font size='1'> <%=file_status%></font></td>
					<td class=<%=classValue%>><font size='1' color='red'>
					<%
					 					
				   if(req_remarks.equals("") && RemarksValue.equals("")) 
				   {						out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font></td>");
				   }
				   else if(RemarksValue.equals(""))
				   {
											
						%>
						<a href='javascript:GetShowRemarks("ReqComm<%=i%>","<%=req_remarks%>","R")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td> 
						<%  
					}
					else
						{
						
						%>
                          <a href='javascript:GetShowRemarks("ReqComm<%=i%>","<%=RemarksValue%>","R")'><fmt:message key="Common.view.label" bundle="${common_labels}"/>&nbsp; <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a></font></td>
						<%}
					if ((fissuebean.getIss_MR_Location()==null) || (fissuebean.getIss_MR_Location().equals("")))
					{
						%>
					   <td class="<%=classValue%>"><font size='1'> <%=fissuebean.getIss_Locn_Desc()%><br>&nbsp;&nbsp;&nbsp; (<%=locn_iden_desc%>)</font></td>
				<%	}
					else
					{
						iss_date_time=fissuebean.getIss_MR_Location(); 						
						//iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName); //this line commented for the incident [46675]
						
						%>
					   <td class="<%=classValue%>" onMouseOver="displayToolTipDataChange('DATACHANGE','File Issued on<br> <%=iss_date_time%>');" onMouseOut="disasbleToolTipDataChange('DATACHANGE');"><font size='1'> <%=fissuebean.getIss_Locn_Desc()%><br>&nbsp;&nbsp;&nbsp; (<%=locn_iden_desc%>)</font></td>
						<%
					}
					%>
				   <td id='remarks<%=i%>' class=<%=classValue%> ><font size='1'>
					<%
				
						%>
			<a href='javascript:GetShowRemarks("txtComm<%=i%>","","IR","issuefile")'><fmt:message key="Common.EnterRemarks.label" bundle="${common_labels}"/></a>
					   </font></td>						
						<%
					//}
					   %>
						   <td class=<%=classValue%>><font size='1'>&nbsp;<input type='hidden' name="file_required_on<%=i%>" id="file_required_on<%=i%>" value="Y"><%=ReqOn%></td>
					  <%
					if(temp == 2)
					{
						
						out.println("<td align='center' id='chbox"+i+"' class='"+classValue+"'>");
					}
					else if(file_exist)
					{
						out.println("<td align='center' style='background-color:"+classVal+"'>");
					}
					else
					{										
						out.println("<td align='center' id='chbox"+i+"' class='"+classValue+"'>");
					}
					
					%>
					
					<input type='checkbox' name="chk<%=i%>" id="chk<%=i%>"  <%=checkStatus%> <%=checkValue%> value='<%=chkVal%>' onClick="setVal(this,<%=i%>);"> 
					<%					
					if(mlc_yn.equals("Y"))
					{
						out.println("&nbsp;<img src='../../eFM/images/stop.gif' align='center'></img>");
						%><input type='hidden' name="mlc_check<%=i%>" id="mlc_check<%=i%>" value="Y"><%
					}else{
						%><input type='hidden' name="mlc_check<%=i%>" id="mlc_check<%=i%>" value="N"><%	
					}
					%>
					</td>
					<%
					if(checkValue.equals("checked"))
					{
						%><input type='hidden' name="select<%=i%>" id="select<%=i%>" value="Y"><%
					}
					else
					{
						%><input type='hidden' name="select<%=i%>" id="select<%=i%>" value="N"><%	
					}
					%>						
					</tr>
					<input type='hidden' name='Req_locn_code<%=i%>' id='Req_locn_code<%=i%>' value='<%=Reqfslocncode%>'>
					<input type='hidden' name='Req_by<%=i%>' id='Req_by<%=i%>' value='<%=Req_by%>'>
					<input type='hidden' name='Req_by_name<%=i%>' id='Req_by_name<%=i%>' value='<%=Req_by_name%>'>
					<input type='hidden' name='Req_no<%=i%>' id='Req_no<%=i%>' value='<%=Req_no%>'>
					<input type="hidden" name='fileno<%=i%>' id='fileno<%=i%>' value='<%=FileNoValue%>'>
					<input type="hidden" name='file_type<%=i%>' id='file_type<%=i%>' value='<%=file_type%>'>
					<input type="hidden" name='file_typedesc<%=i%>' id='file_typedesc<%=i%>' value='<%=file_type_desc%>'>
					<input type="hidden" name='volume_no<%=i%>' id='volume_no<%=i%>' value='<%=volume_no%>'>
					<input type="hidden" name='patient<%=i%>' id='patient<%=i%>' 	value='<%=patient_id%>'>
					<input type="hidden" name="pline<%=i%>" id="pline<%=i%>" value="<%=Patient_Line%>">
					<input type="hidden" name='filestatus<%=i%>' id='filestatus<%=i%>' value='<%=currStatus%>'>
					<input type="hidden" name='currlocn<%=i%>' id='currlocn<%=i%>' value='<%=currLocn%>'>
					<input type="hidden" name='currlocndesc<%=i%>' id='currlocndesc<%=i%>' value='<%=fissuebean.getIss_Locn_Desc()%>'>
					<input type="hidden" name='currlocniden<%=i%>' id='currlocniden<%=i%>' value='<%=cuurIden%>'>
					<input type="hidden" name='currmrlocnyn<%=i%>' id='currmrlocnyn<%=i%>' value='<%=Reqlocnismrlocnyn%>'>
					<input type="hidden" name='currfacility<%=i%>' id='currfacility<%=i%>' value='<%=facility_id%>'>
					<input type="hidden" name='txtComm<%=i%>' id='txtComm<%=i%>'>
					<input type="hidden" name='ReqComm<%=i%>' id='ReqComm<%=i%>' value = '<%=ReqCommVal%>'>
					<input type="hidden" name='Requested_on<%=i%>' id='Requested_on<%=i%>' value='<%=RequestedOn%>'>
					<input type='hidden' name='Reqfslocnid<%=i%>' id='Reqfslocnid<%=i%>' value='<%=Reqfslocnid%>'>	
					<input type='hidden' name='Req_fac_id<%=i%>' id='Req_fac_id<%=i%>' value='<%=Reqfacilityid%>'>
					<input type='hidden' name='Req_fac_name<%=i%>' id='Req_fac_name<%=i%>' value='<%=Reqfacilityname%>'>
					
					<!--Added by Shanthi on 17-2-2012 for the issue - 27189 -->
					<input type='hidden' name='Req_locn_identity<%=i%>' id='Req_locn_identity<%=i%>' value='<%=Reqfslocnidentity%>'>

					<input type='hidden' name='rem_recnum_<%=i%>' id='rem_recnum_<%=i%>' value=''>
					<%
					i++;
					
				}
     		if(rs!=null)	rs.close();
				if(rs1!=null)	rs1.close();				
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				%>
				<SCRIPT LANGUAGE="JavaScript">
				//Below Condition added by Dharma for ML-MMOH-CRF-1415
				if(parent.parent.frames[2].document.getElementById("patient_id")){
					parent.parent.frames[2].document.getElementById("patient_id").value='';
					parent.parent.frames[2].document.getElementById("patient_id").focus();
				}
				if(parent.parent.frames[2].document.getElementById("FileType"))
		        {
					parent.parent.frames[2].document.getElementById("FileType").innerHTML='<input type="text" name="file_type" id="file_type" onBlur="" readonly>';
				}
				if(parent.parent.frames[2].document.getElementById("volno")) {
					parent.parent.frames[2].document.getElementById("volno").innerHTML='<select name="volume_no" id="volume_no"><option value="">-'+getLabel('Common.defaultSelect.label','common')+'-</option></select>';
				}
				if(parent.parent.frames[2].document.getElementById("file_no"))
					parent.parent.frames[2].document.getElementById("file_no").value = "";
													
				
				</SCRIPT>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



				<%
			}catch(Exception e)
				{
					out.println("Exception e :"+e);
					e.printStackTrace();
				}
			finally
			{				
				ConnectionManager.returnConnection(con,request);
			 			}
			%>
		</table>
		<input type='hidden' name='ManualReq' id='ManualReq' value='N'>
		<input type='hidden' name='count' id='count' value='<%=(i-1)%>'>
		<input type='hidden' name='iss_count' id='iss_count' value=''>
		<input type='hidden' name='Req_on' id='Req_on' value='<%=ReqOn%>'>
		
		
		<input type='hidden' name='Req_locn_desc' id='Req_locn_desc' value='<%=Reqfslocndesc%>'> 
		<!-- Commented by Shanthi on 17-02-2012 for incident no.27189 -->	
        <!-- <input type='hidden' name='Req_locn_identity' id='Req_locn_identity' value='<%=Reqfslocnidentity%>'>  -->
		<input type='hidden' name='Req_locn_mrlocn_yn' id='Req_locn_mrlocn_yn' value='<%=Reqlocnismrlocnyn%>'> 
		
		<input type='hidden' name='Narration_code' id='Narration_code' value='<%=Narrationcode%>'>
		<input type='hidden' name='Narration_desc' id='Narration_desc' value='<%=Narrationdesc%>'>
		<input type='hidden' name='No_Of_Days' id='No_Of_Days' value='<%=NoOfdays%>'>
		<input type='hidden' name='Issue_user_id' id='Issue_user_id' value=''>
		<div name="tooltiplayer" id="tooltiplayer" style="position:absolute; width:20%; visibility:hidden;" bgcolor="blue">
		<table id="tooltiptable" cellpadding=0 cellspacing=0 border="0" width="auto" height="100%" align="center">
			<tr><td width="100%" id="t"></td></tr>
		</table>
		</div>	 
	</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}

public boolean sortFMFilesIssueCart(eFM.FMIssueFileAddBean FMIssueFileAddBean) throws Exception
	{
				
		String	file_no	=	"", next_file_no		=	"";
		String volume_no="",next_volume_no="";
		boolean	isSorted		=	true;
		ArrayList ArrFileCart						= (ArrayList) FMIssueFileAddBean.getPresCart();
		webbeans.eFM.FMFilesIssueDetail fissuebean	= new webbeans.eFM.FMFilesIssueDetail();
		webbeans.eFM.FMFilesIssueDetail fissuebean2 = new 	
		webbeans.eFM.FMFilesIssueDetail();
		
		
		try
		{
			for( int i=0; i<ArrFileCart.size(); i++ )
			{
				for(int j=0; j<ArrFileCart.size()-1-i;j++)
				{
					fissuebean	=	FMIssueFileAddBean.getIssuesfromCart(j);
					     file_no =    (String) fissuebean.getFile_No();
						 
					     volume_no =    (String) fissuebean.getVolume_No();
							fissuebean2	=	FMIssueFileAddBean.getIssuesfromCart(j+1);
				               next_file_no  =   (String) fissuebean2.getFile_No();
							   
					  next_volume_no=   (String) fissuebean2.getVolume_No();
					if(file_no.compareToIgnoreCase(next_file_no)>0)
					{
	    FMIssueFileAddBean.updIssuestoCart(fissuebean2.cloneFMFilesIssueDetail(), j);
		FMIssueFileAddBean.updIssuestoCart(fissuebean.cloneFMFilesIssueDetail(), j+1);
					}
				}
			}
		
		for( int i=0; i<ArrFileCart.size(); i++ )
			{
				for(int j=0; j<ArrFileCart.size()-1-i;j++)
				{
					fissuebean	=	FMIssueFileAddBean.getIssuesfromCart(j);
					      file_no =    (String) fissuebean.getFile_No();
					     volume_no =    (String) fissuebean.getVolume_No();
						fissuebean2	=	FMIssueFileAddBean.getIssuesfromCart(j+1);
				          next_file_no  =   (String) fissuebean2.getFile_No();
					  next_volume_no=   (String) fissuebean2.getVolume_No();
					if(file_no.equals(next_file_no))
					{
					if( volume_no.compareToIgnoreCase(next_volume_no)>0)
					{
	    FMIssueFileAddBean.updIssuestoCart(fissuebean2.cloneFMFilesIssueDetail(), j);
		FMIssueFileAddBean.updIssuestoCart(fissuebean.cloneFMFilesIssueDetail(), j+1);
					}
					}
				}
			}
		
		
		}catch(Exception e){isSorted = false;}
		return isSorted;
	}

%>

