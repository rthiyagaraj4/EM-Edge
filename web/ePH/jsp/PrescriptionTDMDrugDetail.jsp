<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML> 
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" SRC="../../eCommon/js/common.js"></script>
		<!-- <SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT> -->
		<script language="javascript" SRC="../js/PrescriptionTDM.js"></script>
		<script language="JavaScript" src="../../ePH/js/TDMGuidLinesView.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
	<body onMouseDown="" onKeyDown="lockKey()"> 
	<FORM name="formTDMDrugProfile" id="formTDMDrugProfile">
		<table cellpadding=0 cellspacing=0 width="100%"  border="1">
<%
			String flag             = request.getParameter("flag");	
			/*	flag-->   D--->   for Against Drug Profile
				flag-->   P--->   for Against poisonous Drug  	*/
			if(flag.equals("D")){
%>
				<th colspan="9" style="font-size:9" align="left"><fmt:message key="Common.DrugProfile.label" bundle="${common_labels}"/></th>
				<tr></tr><tr></tr>
				<tr>
					<th align = "left" style = "font-size:11" width = "8%"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "20%"><fmt:message key="ePH.Drug/dose.label" bundle="${ph_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "10%">
					<fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "10%">
					<fmt:message key="Common.Route.label" bundle="${common_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "15%"><fmt:message key="ePH.FrequencyDuration.label" bundle="${ph_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "12%"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "12%"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "12%"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "13%"><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
				</tr>
<%
			}
			else{
%>
				<th colspan="9" style="font-size:9" align="left"><fmt:message key="ePH.PoisonousDrug.label" bundle="${ph_labels}"/></th>
				<tr></tr><tr></tr>
				<tr>
					<th align = "left" style = "font-size:11" width = "8%"><fmt:message key="Common.Ordered.label" bundle="${common_labels}"/></th>
					<th align = "center" style = "font-size:11" width = "67%"><fmt:message key="ePH.DrugDescription.label" bundle="${ph_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "10%"><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></th>
					<th align = "left" style = "font-size:11" width = "15%">
					<fmt:message key="Common.Route.label" bundle="${common_labels}"/></th>			
				</tr>
<%
			}
			ArrayList alDrugDetails	= new ArrayList();	
			String patient_id		= request.getParameter("patient_id");
			String encounter_id		= request.getParameter("encounter_id");	
			String location_code	= request.getParameter("location_code");	
			String location_type	= request.getParameter("location_type");	
			String pract_id			= request.getParameter("pract_id");	
			//String flag           = request.getParameter("flag");	
			String bean_id			= "@PrescriptionTDMBean"+patient_id+encounter_id;
			String bean_name		= "ePH.PrescriptionTDMBean";
			String patient_class	= request.getParameter("patient_class");		
			String s1="", s2="", s3="";
			String route_code="", route_color="", fntColor="", backgrndColor="";// added  for CRF RUT-CRF-0034.1[IN:037389]
			try{
				PrescriptionTDMBean bean	= (PrescriptionTDMBean)getBeanObject(bean_id,bean_name,request);
				bean.setLanguageId(locale);
				bean.setPatientId(patient_id);
				if(flag.equals("D")){
					alDrugDetails = bean.getDrugProfile();
					int nCtr = 0;
					int nAlDrugSize = 0;
					int nDrugNos = 0;

					nAlDrugSize = alDrugDetails.size();
					String strOrdNo		="";
					String strOrdLnum	= "";
					String strDrugCode	= "";
					String classvalue  ="";
					String chkdisable  ="", form_code="" ;
					String chk="", loc="",existence_yn="" ;
					StringTokenizer chkexist = null;
					for(nCtr = 0 ; nCtr < nAlDrugSize; nCtr+=13){ // nCtr+=13 --> 12=> 13 for HSA-SCF-0150 [IN:051775]
						strOrdNo	= 	(String)alDrugDetails.get(nCtr+7);
						strOrdLnum	=	(String)alDrugDetails.get(nCtr+8);
						strDrugCode	= 	(String)alDrugDetails.get(nCtr+9);
						chkdisable	= 	(String)alDrugDetails.get(nCtr+10);
						
						route_color =  (String)alDrugDetails.get(nCtr+12);	// added  for CRF RUT-CRF-0034.1[IN:037389]-start
						if(route_color!= null && !route_color.equals("")){
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}
						else{
							fntColor= "";
							backgrndColor= "";
						}// added for CRF RUT-CRF-0034.1[IN:037389]-end
						nDrugNos++;
						if ( nDrugNos % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
						//chkdisable=bean.chkExistence(patient_id,strOrdNo,strDrugCode);
						existence_yn="";
						if(chkdisable.equals("N")){
							existence_yn="N";
							chk="";
%>			
							<tr>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><input type="checkbox" id="chkbox" disabled <%=chk%> align="center" name="ordered_"<%=nDrugNos%> value='Y'>
								<IMG src="../../ePH/images/tdmGuidelines.gif" align="center" nowrap onclick="callWindow('<%=strDrugCode%>','<%=patient_id%>','','D');" style="cursor:pointer"></IMG>
								<input type ="hidden" name ="drug_code_"<%=nDrugNos%> value ="<%=strDrugCode%>">
								</td>
								<td class = '<%=classvalue%>' style = 'font-size:11'>
								<input type ="hidden" name ="existence"<%=nDrugNos%> value ="<%=existence_yn%>">
								<input type ="hidden" name ="ord_no_"<%=nDrugNos%> value ="<%=strOrdNo%>">
								<input type ="hidden" name ="ord_ln_num"<%=nDrugNos%> value ="<%=strOrdLnum%>">

								<a href = "javascript:callAdminDetailForm('<%=strOrdNo%>','<%=strOrdLnum%>','<%=existence_yn%>','<%=strDrugCode%>','<%=(String)alDrugDetails.get(nCtr) %>','<%=strOrdNo%>')" nowrap><%=(String)alDrugDetails.get(nCtr) %></a>

								</td>		
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"nowrap><%=(String)alDrugDetails.get(nCtr+1)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11;color:<%=fntColor%>;background-color:<%=backgrndColor%>" nowrap><%=(String)alDrugDetails.get(nCtr+11)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"nowrap><%=(String)alDrugDetails.get(nCtr+2)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"nowrap><%=(String)alDrugDetails.get(nCtr+3)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"nowrap><%=(String)alDrugDetails.get(nCtr+4)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=(String)alDrugDetails.get(nCtr+5)%></td>
<%
								loc=(String)alDrugDetails.get(nCtr+6) ==null?"":(String)alDrugDetails.get(nCtr+6);
%>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11" nowrap><%=loc%></td>
							</tr>
<%
						}
						else{
							chkexist=new StringTokenizer(chkdisable,"|");
							s1=chkexist.nextToken();
							s2=chkexist.nextToken();
							s3=chkexist.nextToken();
							chk="checked";
%>
							<tr>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><input type="checkbox" id="chkbox" disabled <%=chk%> align="center" name="ordered_"<%=nDrugNos%> value='Y'>
								<IMG src="../../ePH/images/tdmGuidelines.gif" align="center" nowrap onclick="callWindow('<%=strDrugCode%>','<%=patient_id%>','<%=strOrdNo%>','D');" style="cursor:pointer"></IMG>
								<input type ="hidden" name ="drug_code_"<%=nDrugNos%> value ="<%=strDrugCode%>">
								</td>
								<td class = '<%=classvalue%>' style = 'font-size:11'>
								<input type ="hidden" name ="existence"<%=nDrugNos%> value ="<%=s1%>">
								<input type ="hidden" name ="ord_no_"<%=nDrugNos%> value ="<%=s2%>">
								<input type ="hidden" name ="ord_ln_num"<%=nDrugNos%> value ="<%=s3%>">

								<a href = "javascript:callAdminDetailForm('<%=s2%>','<%=s3%>','<%=s1%>','<%=strDrugCode%>','<%=(String)alDrugDetails.get(nCtr) %>','<%=strOrdNo%>')"><%=(String)alDrugDetails.get(nCtr) %></a>
								</td>		
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=(String)alDrugDetails.get(nCtr+1)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11;color:<%=fntColor%>;background-color:<%=backgrndColor%>"><%=(String)alDrugDetails.get(nCtr+11)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=(String)alDrugDetails.get(nCtr+2)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=(String)alDrugDetails.get(nCtr+3)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=(String)alDrugDetails.get(nCtr+4)%></td>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=(String)alDrugDetails.get(nCtr+5)%></td>
<%
								loc=(String)alDrugDetails.get(nCtr+6) ==null?"":(String)alDrugDetails.get(nCtr+6);
%>
								<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=loc%></td>
							</tr>
<%
						}
					}
				 }
				 else{
					 //in case of Random Toxicology
					String form_code   = request.getParameter("form_code");	
					String generic_id  = request.getParameter("generic_id");	

					alDrugDetails = bean.getpoisionousdrug(form_code,generic_id);
					int nCtr = 0;
					int nAlDrugSize = 0;
					int nDrugNos = 0;
					 
					nAlDrugSize = alDrugDetails.size();
					String strOrdNo	= "";
					// String strOrdLnum	= "";
					String strDrugCode	= "";
					String classvalue  = "";
					String orderid="";
					String orderlinenum="";
					String chk="";
					String chkdisable="", existence_yn="";
					for(nCtr = 0 ; nCtr < nAlDrugSize; nCtr+=5){			
						chkdisable=bean.chkExistence(patient_id,strOrdNo,strDrugCode);
						existence_yn="";
						if(chkdisable.equals("N")){
							 existence_yn="N";
							 chk="";
						}
						strDrugCode	= 	(String)alDrugDetails.get(nCtr);
						nDrugNos++;
						if ( nDrugNos % 2 == 0 )
							classvalue = "QRYEVEN" ;
						else
							classvalue = "QRYODD" ;
						
						route_color=(String)alDrugDetails.get(nCtr+4);// added  for CRF RUT-CRF-0034.1[IN:037389]-start
						if(route_color!= null && !route_color.equals("")){  
							if(route_color.length()==12){
								fntColor= route_color.substring(0, 6);
								backgrndColor= route_color.substring(6, 12);
							}
						}// added for CRF RUT-CRF-0034.1 [IN:037389]-end
%>
						<tr>
							<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><input type="checkbox" disabled <%=chk%> align="center" name="ordered_"<%=nDrugNos%> value='Y'>
							<IMG src="../../ePH/images/tdmGuidelines.gif" align="center" nowrap onclick="callWindow('<%=strDrugCode%>','<%=patient_id%>','','R');" style="cursor:pointer"></IMG>
							<input type ="hidden" name ="drug_code_"<%=nDrugNos%> value ="<%=strDrugCode%>">
							<input type ="hidden" name ="existence"<%=nDrugNos%> value ="<%=existence_yn%>">
							</td>
							 <td class = '<%=classvalue%>' style = 'font-size:11'>
							 <a href = "javascript:callAdminDetailForm('<%=orderid%>','<%=orderlinenum%>','<%=existence_yn%>','<%=strDrugCode%>','<%=(String)alDrugDetails.get(nCtr+1) %>','<%=strOrdNo%>')"><%=(String)alDrugDetails.get(nCtr+1) %></a>
							</td> 
							<td class = "<%=classvalue%>" align ="centre" style = "font-size:11"><%=(String)alDrugDetails.get(nCtr+2)%></td>
							<td class = "<%=classvalue%>" align ="centre" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=(String)alDrugDetails.get(nCtr+3)%></td>
						</tr>
<%
					}
				} 
				putObjectInBean(bean_id,bean,request);
			}
			catch (Exception ee){
				ee.printStackTrace();
			}
%>
			</table>
			<input type ="hidden" name ="patient_id"    value = "<%=patient_id%>">
			<input type ="hidden" name ="encounter_id"  value = "<%=encounter_id%>"> 
			<input type="hidden"  name ="patient_class" value=	"<%=patient_class%>">
			<input type="hidden"  name ="location_code" value=	"<%=location_code%>">
			<input type="hidden"  name ="location_type" value=	"<%=location_type%>">
			<input type="hidden"  name ="pract_id"	    value=	"<%=pract_id%>">
			<input type="hidden"  name ="flag"			value=	"<%=flag%>">
		</FORM>
	</body>
</HTML>

