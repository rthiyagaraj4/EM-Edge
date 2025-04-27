<!DOCTYPE html>
 
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,webbeans.eCommon.*,java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
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
	

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispMedication.js"></SCRIPT>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<title><fmt:message key="ePH.DispensingMedicationLogin.label" bundle="${ph_labels}"/></title>
</HEAD>
<%
try{
	
Connection conn	= null;
Boolean isSite_integration_em_bd_pyxis	= false;
conn = ConnectionManager.getConnection(request);
///*   Added  by Himanshu For MMS-DM-CRF-0232
isSite_integration_em_bd_pyxis =  eCommon.Common.CommonBean.isSiteSpecific(conn,"PH","PH_INTEGRATION_EM_BD_PYXIS");


	//String disp_locn_details	= request.getParameter("disp_locn_details");
	String selectDispLocation	=	null;
	String disp_locn_details	=  "";
	String function_id			= request.getParameter("function_id");
	String homepage			= request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String store_code			= request.getParameter("store_code")==null?"": request.getParameter("store_code"); //Added for Bru-HIMS-CRF-073 [IN:029939]
	String facility_id			= (String) session.getValue("facility_id");
	//disp_locn_details=java.net.URLDecoder.decode(disp_locn_details,"UTF-8");

	String bean_id   = "DispMedicationBean" ;
	String bean_name = "ePH.DispMedicationBean";
	DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	//Added By Shaiju H for UAT 3
	ArrayList result = bean.checkToProceed(facility_id.trim(),"DispMedication");
	if(result.size()>0) {
		disp_locn_details =(String)result.get(0);
	}
	String sAllStagesBeanId   = "DispMedicationAllStages" ;
	String sAllStagesBeanName = "ePH.DispMedicationAllStages";
	DispMedicationAllStages allStagesBean = (DispMedicationAllStages)getBeanObject( sAllStagesBeanId, sAllStagesBeanName, request ) ;
	allStagesBean.setLanguageId(locale);
	allStagesBean.checkforbillinginterface();
	//String source = bean.getSource();
	String normalLogin		=	"Y";
	String password			=	"";
	String passwordDisable	=	"";
	String strPrevDispCatg  =	"";
	if(!(bean.getDispStage()).equals("")){
		normalLogin		= "N";
		password		= bean.getPassword();
		passwordDisable = "disabled";
	}
	//commented during PE By Naveen  added in setBDecimalAllowedParamYN of Dispmedication allstages bean
	//bean.setIncludeZeroAllocQtyItems();
	//allStagesBean.setNoOfDecimals();
	allStagesBean.setBDecimalAllowedParamYN();
	bean.setDispLocnDetails(disp_locn_details);
//commented during PE By Naveen nad added in getDispStagesApplicable of Dispmedication bean
	//allStagesBean.setEditDispLabelAfterDisp(facility_id);
	StringTokenizer stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
	int no_of_disp_locns = stdisp_locn_details.countTokens();
	String disableDispLocn = "", curr_enc_financial_dtl_yn="";
	if(no_of_disp_locns==1){
		disableDispLocn = "disabled";
	}
	else{
		disableDispLocn = "";
	}
	if(homepage.equals("Y")){ //Added for Bru-HIMS-CRF-073 [IN:029939]
		bean.setDispLocnCode(store_code);
	}
	Hashtable param_legends = bean.getLegendsFromParam();
%>
<body onMouseDown="" onKeyDown="lockKey()" onload="focusInToPassword('<%=normalLogin%>')">
<form name="frmDispMedicationLogin" id="frmDispMedicationLogin">
<table cellpadding="2" cellspacing="0" width="100%" align="center" border="0" >
<tr><td colspan="2">&nbsp;</tr>
<tr>
	<td  class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;
		<input type="user_name" name="user_name" id="user_name" size="35" maxlength="60" value="<%=bean.getUserName()%>" readOnly>
	</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
	<td>&nbsp;&nbsp;
		<input type="password" name="password" id="password" size="35" maxlength="60" value="<%=password%>" <%=passwordDisable%> onKeyPress="uppercase()"   autocomplete="off"> <!--41741 autocomplete="off"-->
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr>
	<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
	<td >&nbsp;&nbsp;
		<select name="disp_locn" id="disp_locn" id="disp_locn" onChange="getDrugCatg(this);getDefaultDispStage();showFillCriteria(disp_locn_category,disp_stage);"  <%=disableDispLocn%>>
		<%	
			if (no_of_disp_locns > 1){
		%>
			<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
				//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
				if (isSite_integration_em_bd_pyxis){
				if(bean.getDispLocnCode().equals("all"))
				{
					selectDispLocation="selected";
				}else {
					selectDispLocation="";
				}
				%>
						<option value="all" <%=selectDispLocation%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<%}//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 ends
		
			}
			String disp_locn			=	null;
			
			StringTokenizer st_disp_locn =	null;
			String strdisp_locn_code	=	null;
			String disp_locn_name		=	null;

			while (stdisp_locn_details.hasMoreTokens()){
				disp_locn			= stdisp_locn_details.nextToken();
				selectDispLocation	= "";
				st_disp_locn		= new StringTokenizer(disp_locn,",");
				strdisp_locn_code	= st_disp_locn.nextToken();
				if((strdisp_locn_code).equals(bean.getDispLocnCode())){
					selectDispLocation="selected";
				}else if(bean.getDispLocnCode().equals("all"))
				{
					
				}
				else{
					selectDispLocation="";
				}
				disp_locn_name = st_disp_locn.nextToken();
				st_disp_locn.nextToken();
%>
				<option value="<%=strdisp_locn_code%>" <%=selectDispLocation%> ><%=disp_locn_name%></option>
<%
			}
			stdisp_locn_details = new StringTokenizer(disp_locn_details,"|");
			while (stdisp_locn_details.hasMoreTokens()){
				disp_locn			= stdisp_locn_details.nextToken();
				selectDispLocation	= "";
				st_disp_locn		= new StringTokenizer(disp_locn,",");
				strdisp_locn_code	= st_disp_locn.nextToken();
				st_disp_locn.nextToken();
				st_disp_locn.nextToken();
				curr_enc_financial_dtl_yn = st_disp_locn.nextToken();
				System.err.println(curr_enc_financial_dtl_yn+"curr_enc_financial_dtl_yn");
				//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 Started
				
%>
				<input type='hidden' name='dispFinDtl_<%=strdisp_locn_code%>' id='dispFinDtl_<%=strdisp_locn_code%>' value='<%=curr_enc_financial_dtl_yn%>'>
<%
			if (isSite_integration_em_bd_pyxis){
				String all="all";
				%>
					<input type='hidden' name='dispFinDtl_<%=all%>' id='dispFinDtl_<%=all%>' value='<%=curr_enc_financial_dtl_yn%>'>
				<%
				}//added By Himanshu Saxena for MMS-DM-CRF-0232 on 10-10-23 ends
			}
			// objects nullified after usage
			st_disp_locn		=	null;
		%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>	
</tr>
<tr>
	<td  class="label"><fmt:message key="Common.category1.label" bundle="${common_labels}"/></td>
	<%
		String disableDispLocnCatg="";
		if(normalLogin.equals("N")){
			//disableDispLocnCatg = "disabled";
		}
		String inpatient ="";
		String outpatient = "";
	%>
	<td  >&nbsp;&nbsp;
		<select name="disp_locn_category" id="disp_locn_category" id="disp_locn_category" onChange="getApplicableDispStages(this.value);getDefaultDispStage();showFillCriteria(disp_locn_category,disp_stage);" <%=disableDispLocnCatg%>>
		<!-- <option value="">---Select---</option> -->
		<!--Below Condition is added by sureshkumar T for the SRR20056-SCF-7894[Inc : 29225 ] up to 167 Line Num -->
		<%
			if(normalLogin.equals("N")){
				strPrevDispCatg = bean.getDispLocnCatg();
			}
			if(strPrevDispCatg!=null && strPrevDispCatg.equals("O")){
%>
				<option value="I"><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
				<option value="O" selected><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
<%
			} 
			else {
%>
				<option value="I" selected><fmt:message key="Common.inpatient.label" bundle="${common_labels}"/></option>
				<option value="O" ><fmt:message key="Common.Outpatient.label" bundle="${common_labels}"/></option>
<%
			}
%>
		</select>
		<img src="../../eCommon/images/mandatory.gif" align="center"></img>
	</td>
</tr>
<tr>
<%
		String disableDispStage="";
%>
	<td  class="label"><fmt:message key="ePH.DispenseStages.label" bundle="${ph_labels}"/></td> 
	<td  >&nbsp;&nbsp;
		<select name="disp_stage" id="disp_stage" id="disp_stage" <%=disableDispStage%> onChange="showFillCriteria(disp_locn_category,this)">
		<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
			String strDispStage="";
			if(normalLogin.equals("N")){
				strDispStage= bean.getDispStage();
				if(strDispStage.equals("F")){
%>
					<option value="F" selected><%=param_legends.get("F")%></option>
<%
				}
				else if (strDispStage.equals("V")){
%>
					<option value="V" selected><%=param_legends.get("V")%></option>
<%
				}
				else if (strDispStage.equals("A")){
%>
					<option value="A" selected><%=param_legends.get("A")%></option>
<%
				}
				else if (strDispStage.equals("B")){
%>
					<option value="B" selected><%=param_legends.get("B")%></option>
<%
				}
				else if (strDispStage.equals("D")){
%>			
					<option value="D" selected><%=param_legends.get("D")%></option>
<%
				}
				else if (strDispStage.equals("AS")){
%>
					<option value="AS" selected><fmt:message key="ePH.AllStages.label" bundle="${ph_labels}"/></option>
<%
				}
			}
%>
					</select>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>
				<tr style="display:none" id="fill_list_id">
					<td  class="label">
						<%=param_legends.get("F")%>&nbsp;&nbsp;
					</td>
					<td class="label"  >&nbsp;&nbsp;
						<input type="radio" name="chk_fill_list" id="chk_fill_list" checked value="AF"><fmt:message key="ePH.Against.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
						<input type="radio" name="chk_fill_list" id="chk_fill_list" value="WF"><fmt:message key="ePH.Without.label" bundle="${ph_labels}"/><%=param_legends.get("F")%> <fmt:message key="Common.List.label" bundle="${common_labels}"/>
					</td>
				</tr>
				<tr style="display:none" id="deliver_list_id">
					<td  class="label">
						<%=param_legends.get("D")%>&nbsp;&nbsp;
					</td>
					<td class="label"  >&nbsp;&nbsp;
						<input type="radio" name="chk_deliver_fill_list" id="chk_deliver_fill_list" checked value="DWF"><fmt:message key="ePH.Against.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
						<input type="radio" name="chk_deliver_fill_list" id="chk_deliver_fill_list" value="DF"><fmt:message key="ePH.Without.label" bundle="${ph_labels}"/><%=param_legends.get("F")%><fmt:message key="Common.List.label" bundle="${common_labels}"/>
					</td>
				</tr>
				</tr>
				<tr><td colspan="2">&nbsp;</tr>
				<tr>
					<td  colspan="2" class="white" align="right">
						<input type="button" class="BUTTON" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="showQueryCriteria()">	
						<input type="button" class="BUTTON" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="goHome()">&nbsp;&nbsp;&nbsp;
					</td>	
				</tr>
			</TABLE>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
			<input type="hidden" name="isSite_integration_em_bd_pyxis" id="isSite_integration_em_bd_pyxis" id="isSite_integration_em_bd_pyxis" value="<%=isSite_integration_em_bd_pyxis%>">
			
			<Script>
				// added by gangadharan for SRR20056-SCF-7232 & Incident no. 27232 
				if("<%=bean.getDispLocnCode()%>" != "")
					//added by strPrevDispCatg sureshkumar t SRR20056-SCF-7894 & Inc No : 29225
					getDrugCatg(document.frmDispMedicationLogin.disp_locn, '<%=strPrevDispCatg%>');											
			</script>
		</form>
	</body>
	<script language="javascript">
<%
		//getApplicableDispStages(document.getElementById("disp_locn_category").value); // commented for IN[032458]
		if(disableDispLocn.equals("disabled")){	
%>
			getDrugCatg(document.frmDispMedicationLogin.disp_locn, '<%=strPrevDispCatg%>')//added by strPrevDispCatg sureshkumar t SRR20056-SCF-7894 & Inc No : 29225
<%
		}
		if(normalLogin.equals("N")){
%>
			getApplicableDispStages(document.getElementById("disp_locn_category").value); //moved from above for IN[032458]
			//getDrugCatg(document.getElementById("disp_locn"));
			//showFillCriteria(document.getElementById("disp_locn_category"),document.getElementById("disp_stage"));
<%
			if(((bean.getDispStage()).equals("F") )&&((bean.getDispLocnCatg()).equals("I"))){
				if((bean.getFillList()).equals("AF")||(bean.getFillList()).equals("DWF")){
%>
					document.getElementById("deliver_list_id").style.display = "none";
					document.getElementById("fill_list_id").style.display = "inline";
					document.querySelectorAll('#chk_fill_list')[0].selected = true;
					window.dialogHeight="14";
<%			
				}
				else if((bean.getFillList()).equals("WF")||(bean.getFillList()).equals("DF")){
%>          
					document.getElementById("deliver_list_id").style.display = "none";
					document.getElementById("fill_list_id").style='display';
					document.querySelectorAll('#chk_fill_list')[1].selected = true;
					window.dialogHeight="14";
<%
				}
			}
			else if((bean.getDispStage()).equals("D")&&((bean.getDispLocnCatg()).equals("I"))){
				if((bean.getFillList()).equals("DWF")){
%>
					document.getElementById("fill_list_id").style.display = "none";
					document.getElementById("deliver_list_id").style='display';
					document.querySelectorAll('#chk_deliver_fill_list')[0].selected = true;
					window.dialogHeight="14";
<%			
				}
				else if((bean.getFillList()).equals("DF")){
%>
					document.getElementById("fill_list_id").style.display = "none";
					document.getElementById("deliver_list_id").style='display';
					document.querySelectorAll('#chk_deliver_fill_list')[1].selected = true;
					window.dialogHeight="14";
<%
				}
			}
		}
		else{   
%>
			//added by strPrevDispCatg sureshkumar t SRR20056-SCF-7894 & Inc No : 29225
			getDrugCatg(document.getElementById("disp_locn"),'<%=strPrevDispCatg%>');
			//showFillCriteria(document.getElementById("disp_locn_category"),document.getElementById("disp_stage"))
<%
		}
		if(bean.getDispStage()!=""){
%>
			document.getElementById("disp_stage").value='<%=bean.getDispStage()%>';
<%
		}
		if(disableDispLocn.equals("disabled")){	//if block added for MMS-SCF-0448 [IN:052251]
%>	
			getDefaultDispStage();
<%
		}
%>
		showFillCriteria(document.getElementById("disp_locn_category"),document.getElementById("disp_stage"));
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</html>

<%
	putObjectInBean(bean_id,bean,request);

}catch(Exception e) {
	e.printStackTrace();
}
%>

