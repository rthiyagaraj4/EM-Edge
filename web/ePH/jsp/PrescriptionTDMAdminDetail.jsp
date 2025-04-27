<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale		= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT> 
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PrescriptionTDM.js"></SCRIPT>
	</HEAD>
<%
	try{
		String patient_id		= request.getParameter("patient_id");
		String encounter_id		= request.getParameter("encounter_id");
		String patient_class	= request.getParameter("patient_class");
        String actual_patient_class	= request.getParameter("actual_patient_class");//Added  for AMS-SCF-0424 and ML-MMOH-SCF-0500
		String location_code	= request.getParameter("location_code");
		String pract_id			= request.getParameter("pract_id");
		String location_type	= request.getParameter("location_type");
		String strOrderNo		= request.getParameter("order_no");
		String strOrderLineNum	= request.getParameter("ord_line_num");
		String strExistenceYn	= request.getParameter("ExistenceYn");
		String strDrugCode		= request.getParameter("drug_code");
		String drug_desc		= request.getParameter("drug_desc");
		String ord_date			= request.getParameter("ord_date");
		String strOrder_id			= request.getParameter("strOrder_id");
		String flag				= request.getParameter("flag")==null?"":request.getParameter("flag");
		String bean_id			= "@PrescriptionTDMBean"+patient_id+encounter_id;
		String bean_name		= "ePH.PrescriptionTDMBean";
		String facility_id					= (String) session.getValue("facility_id");
		String strPrevDate		= "";
		String disabled="";
		String checked="";
		String strOrderNo1="";
		String enable_disable ="disabled";
		String  classvalue		= "";
		String peak_option="";
		String trough_option="";
		String random_option="";
		String extended_option="";
		String st1		=	"";
		String st2		=	"";
		ArrayList alOrdDetl		= new ArrayList();
		ArrayList alSampleTypes		= new ArrayList();
		Hashtable htLabTest		= new Hashtable();
		PrescriptionTDMBean bean	= (PrescriptionTDMBean)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		bean.setPatientId(patient_id);
		if(strExistenceYn.equals("Y")){
			strOrderNo1=strOrderNo;
			strOrderNo=strOrder_id;
		}
		bean.setOrderId(strOrderNo);
		bean.setOrderLineNum(strOrderLineNum);
		bean.setDrugCode(strDrugCode);
		alOrdDetl = bean.getOrderDetails();
		bean.setPatientDetails();
		bean.getLabTests1(strDrugCode);
		alSampleTypes=bean.getSampleTypeDescription(strDrugCode);
		
		if(alSampleTypes.size()==4)	{
			if(((String)alSampleTypes.get(0)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(0)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(0)).equals("R")) random_option="R";
			if(((String)alSampleTypes.get(0)).equals("E")) extended_option="E";
			if(((String)alSampleTypes.get(1)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(1)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(1)).equals("R"))  random_option="R";
			if(((String)alSampleTypes.get(1)).equals("E")) extended_option="E";
			if(((String)alSampleTypes.get(2)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(2)).equals("P"))  peak_option="P";
			if(((String)alSampleTypes.get(2)).equals("R")) random_option="R";
			if(((String)alSampleTypes.get(2)).equals("E"))  extended_option="E";
			if(((String)alSampleTypes.get(3)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(3)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(3)).equals("R")) random_option="R";
			if(((String)alSampleTypes.get(3)).equals("E")) extended_option="E";
		}
		if(alSampleTypes.size()==3){
			if(((String)alSampleTypes.get(0)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(0)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(0)).equals("R")) random_option="R";
			if(((String)alSampleTypes.get(0)).equals("E")) extended_option="E";
			if(((String)alSampleTypes.get(1)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(1)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(1)).equals("R"))  random_option="R";
			if(((String)alSampleTypes.get(1)).equals("E")) extended_option="E";
			if(((String)alSampleTypes.get(2)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(2)).equals("P"))  peak_option="P";
			if(((String)alSampleTypes.get(2)).equals("R")) random_option="R";
			if(((String)alSampleTypes.get(2)).equals("E"))  extended_option="E";
		}
		if(alSampleTypes.size()==2){
			if(((String)alSampleTypes.get(0)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(0)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(0)).equals("R")) random_option="R";
			if(((String)alSampleTypes.get(0)).equals("E")) extended_option="E";
			if(((String)alSampleTypes.get(1)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(1)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(1)).equals("R"))  random_option="R";
			if(((String)alSampleTypes.get(1)).equals("E")) extended_option="E";
		}
		if(alSampleTypes.size()==1){
			if(((String)alSampleTypes.get(0)).equals("T")) trough_option="T";
			if(((String)alSampleTypes.get(0)).equals("P")) peak_option="P";
			if(((String)alSampleTypes.get(0)).equals("R")) random_option="R";
			if(((String)alSampleTypes.get(0)).equals("E")) extended_option="E";
		}
		if(alSampleTypes.size()==0)	{
			peak_option="P";
			trough_option="T";
			random_option="R";
			extended_option="E";
%>
			<script>chkTdmAttributes()</script>
<%
		}
%>
		<body onMouseDown="" onKeyDown="lockKey()">
			<FORM name="formTDMAdminDetls" id="formTDMAdminDetls" >
<%
				if(( strExistenceYn.equals("N") || strExistenceYn.equals("Y") )&&(flag.equals("D"))){
%>		  
					<table cellpadding=0 cellspacing=0 width="100%" border="3">
<%
						int nCtr = 0;
						int nAlSize = 0;
						nAlSize = alOrdDetl.size();
						String strOrdDate		= "";
						String strOrdTime		= "";
						String strOrdDose		= "";
						String sch_date_time	= "";
						String open_tdm_order_id	= "";
						String trough_value="";
						String random_value="";
						String peak_value="";
						String extended_value="";
						int nOrdCtr = 0;
						for(nCtr = 0; nCtr < nAlSize; nCtr+=5){
							if(nOrdCtr % 2 == 0)
								classvalue = "QRYEVEN" ;
							else
								classvalue = "QRYODD" ;

							nOrdCtr++;

							strOrdDate		= (String) alOrdDetl.get(nCtr);
							strOrdTime		= (String) alOrdDetl.get(nCtr+1);
							strOrdDose		= (String) alOrdDetl.get(nCtr+2);
							sch_date_time	= (String) alOrdDetl.get(nCtr+3);
							open_tdm_order_id	= CommonBean.checkForNull((String) alOrdDetl.get(nCtr+4));
							if(strPrevDate != null && !(strPrevDate.equals(strOrdDate) )){
%>
								<tr  ><th colspan =5 align ="left" style = "font-size:11">&nbsp;&nbsp;<%=strOrdDate%></th></tr>
<%
								strPrevDate = strOrdDate;
							}
%>
							<input type="hidden" name="open_tdm_order_id<%=nOrdCtr%>" id="open_tdm_order_id<%=nOrdCtr%>" value="<%=open_tdm_order_id%>">
<%
							if(trough_option.equals("T")) 
								trough_value="Y";
							else
								trough_value="N";
%>
							<input type="hidden" name="trough_option_yn_<%=nOrdCtr%>" id="trough_option_yn_<%=nOrdCtr%>" value="<%=trough_value%>">
<%
							if(trough_option.equals("T")){
%>	
								<tr>
								<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "20%"><%=strOrdTime%><input type="hidden" name="sch_date_time1<%=nOrdCtr%>" id="sch_date_time1<%=nOrdCtr%>" value="<%=sch_date_time%>">
									<input type="hidden" name="enable_checkT<%=nOrdCtr%>" id="enable_checkT<%=nOrdCtr%>" value="">
								</td>
								<!-- //Added code for UOM Code/Description conversion for incident num:21621 -->
<%
								StringTokenizer st =new StringTokenizer(strOrdDose.toString(), " ");  
								while (st.hasMoreTokens()){
									 st1 = st.nextToken();
									 st2 = st.nextToken();
								}
%> 
								 <TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width="18%"><%=st1%>  <%=bean.getUomDisplay(facility_id,st2)%>&nbsp;</td>	 <TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type="checkbox" name="samp_type11_<%=nOrdCtr%>" id="samp_type11_<%=nOrdCtr%>" Value="T"  onClick="settroughPrePostDose(this,<%=nOrdCtr%>);cleartroughCmbs(<%=nOrdCtr%>);gettroughLabTests(this,<%=nOrdCtr%>)" >&nbsp;&nbsp;<fmt:message key="ePH.Trough.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<!-- <select style = "font-size:11" name ="samp_type1_<%=nOrdCtr%>" onchange ="setPrePostDose(this,<%=nOrdCtr%>);clearCmbs(<%=nOrdCtr%>);getLabTests(this,<%=nOrdCtr%>)">
									<option value = "">&nbsp;---Select---&nbsp;</option>
									<option value = "P">Peak&nbsp;&nbsp;</option>
									<option value = "T">Trough&nbsp;&nbsp;</option>
									<option value = "R">Random&nbsp;&nbsp;</option>
									</select> -->
									<select style = "font-size:11" name = "when_doseAB0_<%=nOrdCtr%>" onchange = "">
									<option value = "B"><fmt:message key="ePH.BeforeDose.label" bundle="${ph_labels}"/></option>
									<option value = "A"><fmt:message key="ePH.AfterDose.label" bundle="${ph_labels}"/></option>	 
									</select>
								</td>
								 <TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type ="text" style = "font-size:11" name ="samp_type5_<%=nOrdCtr%>" id ="samp_type5_<%=nOrdCtr%>" size = "2" maxlength ="5" >
									<select style = "font-size:11" name = "samp_type6_<%=nOrdCtr%>" id = "samp_type6_<%=nOrdCtr%>" onchange = "">
										<option value = "">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
										<option value = "M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>	 
										<option value = "H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option> 
										<option value = "D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
									</select>
									<label style = "font-size:11" id ="samp_type7_<%=nOrdCtr%>" width = "18%"  readonly>
								</td>
								 <TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "25%">
									<select style = "font-size:11" name = "lab_test1_<%=nOrdCtr%>" onchange ="" >
									<option value = "">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
									Enumeration enLabTest1 = htLabTest.keys();
									String strCode1 = "";
									String strDesc1 = "";
									while (enLabTest1.hasMoreElements() ){
										strCode1 = (String) enLabTest1.nextElement();
										strDesc1 = (String) htLabTest.get(strCode1);
%>
										<OPTION value="<%=strCode1%>"><%=strDesc1%></OPTION> 
<%
									}
%>
									</select>
								</td>
								</tr>
<%
							}
							if(peak_option.equals("P")) { 
								peak_value="Y";
							}
							else{
								peak_value="N";
							}
%>
							<input type="hidden" name="peak_option_yn_<%=nOrdCtr%>" id="peak_option_yn_<%=nOrdCtr%>" value="<%=peak_value%>">
<%
							if(peak_option.equals("P")) { 
%>  
								<tr>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "20%">
<%
										if(trough_option.equals("")){
%>
											<%=strOrdTime%>
<%
										}
%>
										<input type="hidden"   name="sch_date_time4<%=nOrdCtr%>" id="sch_date_time4<%=nOrdCtr%>"  value="<%=sch_date_time%>">
										<input type="hidden" name="enable_checkP<%=nOrdCtr%>" id="enable_checkP<%=nOrdCtr%>" value=""> 
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width="18%">
<%
									if(trough_option.equals("")){
%>
										<%=strOrdDose%>
<%	
									}
%>
									&nbsp;</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type="checkbox" name ="samp_type41_<%=nOrdCtr%>" Value="P"  onClick="setPrePostDose(this,<%=nOrdCtr%>);clearCmbs(<%=nOrdCtr%>);getLabTests(this,<%=nOrdCtr%>)" >&nbsp;&nbsp;<option value = "P"><fmt:message key="ePH.Peak.label" bundle="${ph_labels}"/></option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  
									<!--<select style = "font-size:11" name ="samp_type1_<%=nOrdCtr%>" onchange ="setPrePostDose(this,<%=nOrdCtr%>);clearCmbs(<%=nOrdCtr%>);getLabTests(this,<%=nOrdCtr%>)">
										<option value = "">&nbsp;---Select---&nbsp;</option>
										<option value = "P">Peak&nbsp;&nbsp;</option>
										<option value = "T">Trough&nbsp;&nbsp;</option>
										<option value = "R">Random&nbsp;&nbsp;</option>	 
									</select> -->  
									<select style = "font-size:11" name = "when_doseAB1_<%=nOrdCtr%>" onchange = "">
										<option value = "A"><fmt:message key="ePH.AfterDose.label" bundle="${ph_labels}"/></option>
										<option value = "B"><fmt:message key="ePH.BeforeDose.label" bundle="${ph_labels}"/></option>
									</select>
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type ="text" style = "font-size:11" name ="samp_type42_<%=nOrdCtr%>" size = "2" maxlength ="5" >
										<select style = "font-size:11" name = "samp_type43_<%=nOrdCtr%>" onchange = "">
										<option value = "">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
										<option value = "M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>	 
										<option value = "H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option> 
										<option value = "D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
										</select>
										<label style = "font-size:11" id ="samp_type44_<%=nOrdCtr%>" width = "18%"  readonly>
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "25%">
										<select style = "font-size:11" name = "lab_test4_<%=nOrdCtr%>" onchange ="" > 
										<option value = "">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option> 
<%
										Enumeration enLabTest = htLabTest.keys();
										String strCode = "";
										String strDesc = "";
										while (enLabTest.hasMoreElements() ){
											strCode = (String) enLabTest.nextElement();
											strDesc = (String) htLabTest.get(strCode);
%>
											<OPTION value="<%=strCode%>"><%=strDesc%></OPTION> 
<%
										}
%> 
										</select>
									</td>
								</tr>			
<%
							}
							if(random_option.equals("R")) 
								random_value="Y";
							else
								random_value="N";
%>
							<input type="hidden" name="random_option_yn_<%=nOrdCtr%>" id="random_option_yn_<%=nOrdCtr%>" value="<%=random_value%>">
<%
							if(random_option.equals("R")){ 
%> 
								<tr>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "20%"><%if(trough_option.equals("")&& peak_option.equals("")){%><%=strOrdTime%><%}%><input type="hidden" name="sch_date_time2<%=nOrdCtr%>" id="sch_date_time2<%=nOrdCtr%>" value="<%=sch_date_time%>">
									<input type="hidden" name="enable_checkR<%=nOrdCtr%>" id="enable_checkR<%=nOrdCtr%>" value="">
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width="18%"><%if(trough_option.equals("")&& peak_option.equals("")){%><%=strOrdDose%><%}%>&nbsp;</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type="checkbox" name=samp_type21_<%=nOrdCtr%>   Value="R" onClick="setrandomPrePostDose(this,<%=nOrdCtr%>);clearrandomCmbs(<%=nOrdCtr%>);getrandomLabTests(this,<%=nOrdCtr%>)" >&nbsp;&nbsp;<fmt:message key="ePH.Random.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
									<!--<select style = "font-size:11" name ="samp_type1_<%=nOrdCtr%>" onchange ="setPrePostDose(this,<%=nOrdCtr%>);clearCmbs(<%=nOrdCtr%>);getLabTests(this,<%=nOrdCtr%>)">
										<option value = "">&nbsp;---Select---&nbsp;</option>
										<option value = "P">Peak&nbsp;&nbsp;</option>
										<option value = "T">Trough&nbsp;&nbsp;</option>
										<option value = "R">Random&nbsp;&nbsp;</option>	
									</select> -->
									<select style = "font-size:11" name = "when_doseAB2_<%=nOrdCtr%>" onchange = "">
										<option value = "">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
										<option value = "B"><fmt:message key="ePH.BeforeDose.label" bundle="${ph_labels}"/></option>
										<option value = "A"><fmt:message key="ePH.AfterDose.label" bundle="${ph_labels}"/></option>	 
									</select>
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type ="text" style = "font-size:11" name ="samp_type8_<%=nOrdCtr%>" size = "2" maxlength ="5" >
										<select style = "font-size:11" name = "samp_type9_<%=nOrdCtr%>" onchange = "">
											<option value = "">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
											<option value = "M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>	 
											<option value = "H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option> 
											<option value = "D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
										</select>
										<label style = "font-size:11" id ="samp_type10_<%=nOrdCtr%>" width = "18%"  readonly>
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "25%">
										<select style = "font-size:11" name = "lab_test2_<%=nOrdCtr%>" onchange ="" >
										<option value = "">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
										Enumeration enLabTest2 = htLabTest.keys();
										String strCode2 = "";
										String strDesc2= "";
										while (enLabTest2.hasMoreElements() ){
											strCode2 = (String) enLabTest2.nextElement();
											strDesc2 = (String) htLabTest.get(strCode2);
%>
											<OPTION value="<%=strCode2%>"><%=strDesc2%></OPTION> 
<%
										}
%>
										</select>
									</td>
								</tr>	
<%
							}
							if(extended_option.equals("E")) 
								extended_value="Y";
							else
								extended_value="N";
%>
							<input type="hidden" name="extended_option_yn_<%=nOrdCtr%>" id="extended_option_yn_<%=nOrdCtr%>" value="<%=extended_value%>">
<%
							if(extended_option.equals("E")){ 
%>
								<tr> 
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "20%">
<%
									if(trough_option.equals("")&& peak_option.equals("")&& random_option.equals("")){
%>
										<%=strOrdTime%>
<%
									}
%>
										<input type="hidden"  name="sch_date_time3<%=nOrdCtr%>" id="sch_date_time3<%=nOrdCtr%>"   value="<%=sch_date_time%>">
										<input type="hidden" name="enable_checkE<%=nOrdCtr%>" id="enable_checkE<%=nOrdCtr%>" value=""> 
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width="18%">
<%
									if(trough_option.equals("")&& peak_option.equals("")&& random_option.equals("")){
%>
										<%=strOrdDose%>
<%
									}
%>
									&nbsp;</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%">
										<input type="checkbox" name="samp_type31_<%=nOrdCtr%>" id="samp_type31_<%=nOrdCtr%>"   Value="E" <%=disabled%>   <%=checked%>  onClick="setextendedPrePostDose(this,<%=nOrdCtr%>);clearextendedCmbs(<%=nOrdCtr%>); getextendedLabTests(this,<%=nOrdCtr%>)" >&nbsp;&nbsp;<fmt:message key="ePH.Extended.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;
										<!-- <select style = "font-size:11" name ="samp_type1_<%=nOrdCtr%>" onchange ="setPrePostDose(this,<%=nOrdCtr%>);clearCmbs(<%=nOrdCtr%>);getLabTests(this,<%=nOrdCtr%>)">
											<option value = "">&nbsp;---Select---&nbsp;</option>
											<option value = "P">Peak&nbsp;&nbsp;</option>
											<option value = "T">Trough&nbsp;&nbsp;</option>
											<option value = "R">Random&nbsp;&nbsp;</option>
										</select> --> 
										<select style = "font-size:11" name = "when_doseAB3_<%=nOrdCtr%>" onchange = "">
											<option value = "B"><fmt:message key="ePH.BeforeDose.label" bundle="${ph_labels}"/></option>
											<option value = "A"><fmt:message key="ePH.AfterDose.label" bundle="${ph_labels}"/></option>
										</select>
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type ="text" style = "font-size:11" name ="samp_type12_<%=nOrdCtr%>" size = "2" maxlength ="5" >
										<select style = "font-size:11" name = "samp_type13_<%=nOrdCtr%>" onchange = "">
										<option value = "">--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
										<option value = "M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>	 
										<option value = "H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option> 
										<option value = "D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
										</select>
										<label style = "font-size:11" id ="samp_type14_<%=nOrdCtr%>" width = "18%"  readonly>
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "25%">
										<select style = "font-size:11" name = "lab_test3_<%=nOrdCtr%>" onchange ="" >
										<option value = "">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
										Enumeration enLabTest3 = htLabTest.keys();
										String strCode3 = "";
										String strDesc3= "";
										while (enLabTest3.hasMoreElements() ){
											strCode3 = (String) enLabTest3.nextElement();
											strDesc3 = (String) htLabTest.get(strCode3);
%>
											<OPTION value="<%=strCode3%>"><%=strDesc3%></OPTION> 
<%
										}
%>
										</select>
									</td>
								</tr>	
<%
							}
						}
%>
						</table>
						<input type ="hidden" name = "bean_id"			 value = "<%=bean_id%>">
						<input type ="hidden" name = "bean_name"		 value = "<%=bean_name%>">
						<input type ="hidden" name = "drug_code"         value = "<%=strDrugCode%>">
						<input type ="hidden" name = "reason"	         value = "">
						<input type ="hidden" name = "clinical_comments" value = "">
						<input type ="hidden" name = "smoking_yn"		 value = "">
						<input type ="hidden" name = "alcohol_yn"		 value = "">
						<input type ="hidden" name = "pregnant_yn"		 value = "">
						<input type ="hidden" name = "patient_class"	 value= "<%=patient_class%>">
						<input type ="hidden" name = "actual_patient_class"	 value= "<%=actual_patient_class%>"><!-- //Added  for AMS-SCF-0424 and ML-MMOH-SCF-0500 -->

						<input type ="hidden" name = "patient_id"	 value= "<%=patient_id%>">
						<input type ="hidden" name = "strOrderNo"	 value= "<%=strOrderNo1%>">
						<input type ="hidden" name = "parent_strOrderNo"	 value= "<%=strOrderNo%>">
						<input type ="hidden" name = "strOrderLineNum"		     value= "<%=strOrderLineNum%>">
						<input type ="hidden" name = "mode_value"		     value= "I">
												
						<input type ="hidden" name = "location_code"	 value= "<%=location_code%>">
						<input type ="hidden" name = "location_type"	 value= "<%=location_type%>">
						<input type ="hidden" name = "pract_id"			 value= "<%=pract_id%>">
						<input type ="hidden" name = "drug_desc"		 value= "<%=drug_desc%>">
						<input type ="hidden" name = "ord_date"			 value= "<%=ord_date%>">
						<input type ="hidden" name = "row_cnt"		     value= "<%=nOrdCtr%>"> 
						<input type ="hidden" name = "encounter_id"		 value= "<%=encounter_id%>">
						<input type ="hidden" name = "flag"		     value= "<%=flag%>">
						<input type ="hidden" name = "mode" value="<%=CommonRepository.getCommonKeyValue( "MODE_INSERT" )%>">
<%
					}
					 if((flag.equals("P"))){
%>		  
						<FORM name="formTDMAdminDetls" id="formTDMAdminDetls">
							<table cellpadding=0 cellspacing=0 width="100%" border="1">
<% 
							int nOrdCtr = 0;
							String sysdate          =	bean.getsysdate();	 
								if(nOrdCtr % 2 == 0)
									classvalue = "QRYEVEN" ;
								else
									classvalue = "QRYODD" ;
								nOrdCtr++;
%>
								<tr>
									<TD  class = "<%=classvalue%>" align ="left" style = "font-size:11" width = "20%">&nbsp;&nbsp;<input type="text" style = "font-size:11" name="sch_time<%=nOrdCtr%>" id="sch_time<%=nOrdCtr%>" size="4"value="" onblur="timechk(this)">
									 <input type="hidden" name="sch_date_time<%=nOrdCtr%>" id="sch_date_time<%=nOrdCtr%>" value="">
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%">
									  <select style = "font-size:11" name ="samp_type1_<%=nOrdCtr%>"  id ="samp_type1_<%=nOrdCtr%>" onchange ="setPrePostDose(this,<%=nOrdCtr%>);clearCmbs(<%=nOrdCtr%>);getLabTests(this,<%=nOrdCtr%>)" disabled>
										<option value = "">&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;</option>
										<option value = "P"><fmt:message key="ePH.Peak.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</option>
										<option value = "T"><fmt:message key="ePH.Trough.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</option>
										<option value = "R"selected><fmt:message key="ePH.Random.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</option>
									   </select>
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "18%"><input type ="text" style = "font-size:11" name ="samp_type2_<%=nOrdCtr%>" id ="samp_type2_<%=nOrdCtr%>" size = "2" maxlength ="5" VALUE='1'>
										   <select style = "font-size:11" name = "samp_type3_<%=nOrdCtr%>" id = "samp_type3_<%=nOrdCtr%>" onchange = "">
												<option value = "M"><fmt:message key="Common.Minutes.label" bundle="${common_labels}"/></option>	 
												<option value = "H"><fmt:message key="Common.hours.label" bundle="${common_labels}"/></option> 
												<option value = "D"><fmt:message key="Common.days.label" bundle="${common_labels}"/></option>
											</select>
											<label style = "font-size:11" id ="samp_type4_<%=nOrdCtr%>" name ="samp_type4_<%=nOrdCtr%>" width = "18%"  readonly>
											
									</td>
									<TD  class = "<%=classvalue%>" align ="centre" style = "font-size:11" width = "25%">
										<select style = "font-size:11" name = "lab_test_<%=nOrdCtr%>" id = "lab_test_<%=nOrdCtr%>" onchange ="" >
										<option value = "">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
										Enumeration enLabTest4 = htLabTest.keys();
										String strCode4 = "";
										String strDesc4 = "";
										while (enLabTest4.hasMoreElements()){
											strCode4 = (String) enLabTest4.nextElement();
											strDesc4 = (String) htLabTest.get(strCode4);
%>
											<OPTION value="<%=strCode4%>"><%=strDesc4%></OPTION> 
<%
										}
%>
										</select>
									</td>
								</tr>			
							</table>
							<input type ="hidden" name = "bean_id"	id = "bean_id"			 value = "<%=bean_id%>">
							<input type ="hidden" name = "bean_name" id = "bean_name"		 value = "<%=bean_name%>">
							<input type ="hidden" name = "drug_code" id = "drug_code"         value = "<%=strDrugCode%>">
							<input type ="hidden" name = "reason"	 id = "reason"         value = "">
							<input type ="hidden" name = "clinical_comments"  id = "clinical_comments" value = "">
							<input type ="hidden" name = "smoking_yn" id = "smoking_yn"		 value = "">
							<input type ="hidden" name = "alcohol_yn"  id = "alcohol_yn"		 value = "">
							<input type ="hidden" name = "pregnant_yn"  id = "pregnant_yn"		 value = "">
							<input type ="hidden" name = "patient_class"  id = "patient_class"	 value= "<%=patient_class%>">
                            <input type ="hidden" name = "actual_patient_class"  id = "actual_patient_class"	 value= "<%=actual_patient_class%>"><!-- //Added  for AMS-SCF-0424 and ML-MMOH-SCF-0500 -->
							<input type ="hidden" name = "patient_id"  id = "patient_id"	 value= "<%=patient_id%>">
							<input type ="hidden" name = "strOrderNo"  id = "strOrderNo"	 value= "<%=strOrderNo%>">
							<input type ="hidden" name = "location_code"  id = "location_code"	 value= "<%=location_code%>">
							<input type ="hidden" name = "location_type"  id = "location_type"	 value= "<%=location_type%>">
							<input type ="hidden" name = "pract_id"	  id = "pract_id"			 value= "<%=pract_id%>">
							<input type ="hidden" name = "drug_desc"	  id = "drug_desc"	 value= "<%=drug_desc%>">
							<input type ="hidden" name = "ord_date"	  id = "ord_date"			 value= "<%=ord_date%>">
							<input type ="hidden" name = "row_cnt"	  id = "row_cnt"		     value= "<%=nOrdCtr+1%>"> 
							<input type ="hidden" name = "encounter_id"	  id = "encounter_id"		 value= "<%=encounter_id%>">
							<input type ="hidden" name = "sys_date"	  id = "sys_date"		     value= "<%=sysdate%>">
							<input type ="hidden" name = "strOrderNo11"	 id = "strOrderNo11"		     value= "<%=strOrderNo%>">
							<input type ="hidden" name = "strOrderLineNum11"	id = "strOrderLineNum11"		     value= "<%=strOrderLineNum%>">
							<input type ="hidden" name = "patient_id11"	  id = "patient_id11"		     value= "<%=patient_id%>">
							<input type ="hidden" name = "encounter_id11"	 id = "encounter_id11"		     value= "<%=encounter_id%>">
							<input type ="hidden" name = "flag"	 id = "flag"	     value= "<%=flag%>">
							<input type ="hidden" name = "mode"    id = "mode"  value="<%=CommonRepository.getCommonKeyValue( "MODE_INSERT" )%>">
<%
						 }
%>
			</FORM>
		</body>
<%
		if(strExistenceYn.equals("Y") && flag.equals("D")) {
%>
			<script language='javascript'>
				getUpdatedVales();
				obj=parent.f_tdm_buttons.formTDMPrescriptionButtons;
				obj.CLEAR.disabled=false;
				obj.RECORD.disabled=false;  
			</script>
<%
			enable_disable ="";
		}
		if(strExistenceYn.equals("N")&&(flag.equals("D"))){
%>
			<script language='javascript'>
				obj=parent.f_tdm_buttons.formTDMPrescriptionButtons;
				parent.f_tdm_buttons.formTDMPrescriptionButtons.CLEAR.disabled=false;
				obj.RECORD.disabled=false;
			</script>
<%			enable_disable ="";
		
		}
		if(flag.equals("P")){
%>
			<script language='javascript'>
				getLabTests(document.formTDMAdminDetls.samp_type1_1,'1');
				obj=parent.f_tdm_buttons.formTDMPrescriptionButtons;
				obj.CLEAR.disabled=false;
				obj.RECORD.disabled=false;
				setsystime();
			</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			enable_disable ="";
		}
%>
		<script>callButtonpage('<%=enable_disable%>');	</script>
<%
		 putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</HTML>

