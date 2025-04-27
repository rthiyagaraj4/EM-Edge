<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,java.text.DecimalFormat, eCommon.Common.*,eCommon.XSSRequestWrapper"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
<%
	try{
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String bean_id	="PresRemarkForDrugBean";
		String bean_name	="ePH.PresRemarkForDrugBean";
		PresRemarkForDrugBean bean = (PresRemarkForDrugBean)getBeanObject(bean_id,bean_name ,request);	
		
		String drugSearch="";
		String drug_code=request.getParameter("drug_code");
		drugSearch=request.getParameter("drugSearch");
		
		String classValue="";
		String routeCode = request.getParameter("routecode");
		String formCode = request.getParameter("formcode");
		String params = "";
		bean.setLanguageId(locale);

		String drug_desc="";
		String drug_type_code="";
		String sel="";
		String selected="";
		String selValue="";
		
		String mode="";
		String drugdesc="";
		String drugcode="";
		String effstatus="";
		String effstatus_chk="";
		String remarks_code="";
		String default_remark_yn="";
		String default_remark_yn1="";
		String DefaultselValue="";
		String DefaultselCheck="";
		String DefaultselDis="";
		String db_action="";
		String eefault="";
		String umode="";
		String remarks_desc="";
		boolean selectall=true;
		boolean disableflag=false;
		String disabled="";

		int from = Integer.parseInt(request.getParameter("from")==null?"0":request.getParameter("from"));
		int to = Integer.parseInt(request.getParameter("to")==null?"10":request.getParameter("to"));

		String search = request.getParameter("search")==null?"":request.getParameter("search");
		mode = request.getParameter("mode")==null?"":request.getParameter("mode");
		ArrayList remarksSearchResults=new ArrayList();
		ArrayList remarksCodeList = new ArrayList();

		if(search.equals("new")){
			bean.clear();
			remarksSearchResults=bean.getRemarksResult(drug_code,drugSearch,formCode,routeCode,locale);
			disableflag=true;
		}
		remarksCodeList = bean.getRemarksCodeList();
		if(mode.equalsIgnoreCase("2")){
			remarksCodeList.clear();
			remarksSearchResults=bean.getRemarksResult(drug_code,drugSearch,formCode,routeCode,locale);
			remarksCodeList = bean.getDefaultRemark(drug_code);
		}
		int recCount=0;
		int codeCnt=0;
		int cnt1=0;
		int cntValue=0;
		String eff_status="";
		String default_value="";
		String eff_status_selected="";
		String default_value_selected="";
		String val="";
		String modeOpn="I";
		String defaultRoute="";
		String defaultRemarkRoute="";
		int maxRecord = remarksSearchResults.size();
		int codeListMaxRecord =remarksCodeList.size(); 
		bean.setMode(mode);
		bean.setLanguageId(locale);
%>	
		<head>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
			<script language="JavaScript" src="../js/PhCommon.js"></script>
			<script language="JavaScript" src="../js/PresRemarkForDrug.js"></script>
			<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
			<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
			<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<body onMouseDown="" onKeyDown="lockKey()">

			<form name="PresRemarkForDrugDetailForm" id="PresRemarkForDrugDetailForm">
				<table cellpadding="0" cellspacing="0" width="100%" align="center"
					border="1">
					<tr>
						<td class="COLUMNHEADER" colspan="2"></td>
					</tr>

					<tr>
						<td class="COLUMNHEADER" width='60%'><fmt:message key="ePH.DrugPrescriptionRemarks.label" bundle="${ph_labels}"/> 
						</td>
						<td class="COLUMNHEADER" width='15%'><fmt:message key="Common.Route.label"
							bundle="${ph_labels}" /></td>

						<td class="COLUMNHEADER" width='15%'><fmt:message
							key="ePH.DefaultRemark.label" bundle="${ph_labels}" /></td>

						<td class="COLUMNHEADER" width='10%'><fmt:message key="ePH.Select.label"
							bundle="${ph_labels}" /></td>
					</tr>
					<tr>
<%
					disabled = bean.getRouteCode();
					defaultRemarkRoute = bean.getDefaultRemarkRoute(drug_code);
					String route_color= "", fntColor="",backgrndColor="" ;// added for CRF RUT-CRF-0034.1[IN:037389]-start
					if((disabled.equals("%"))||(disabled.equalsIgnoreCase(defaultRemarkRoute))||(defaultRemarkRoute.equalsIgnoreCase(""))){
						disabled="";
					}
					else 
						disabled = "disabled='disabled'";
					for(int remarksCnt=0; remarksCnt < maxRecord; remarksCnt+=9){
						 if( (recCount)%2 == 0)  
							classValue="QRYODD";
						else
							classValue="QRYEVEN";
%>
							</tr>
							<tr>
<%
							remarks_code=(String)remarksSearchResults.get(remarksCnt+1) ; 
							route_color=(String)remarksSearchResults.get(remarksCnt+8); // added for CRF RUT-CRF-0034.1[IN:037389] -start
							if(route_color!= null && !route_color.equals("")){
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}// added for CRF RUT-CRF-0034.1[IN:037389]-end
%>
							<td class='QRYODD' >&nbsp;<%=remarksSearchResults.get(remarksCnt+2)%></td>
							<td class='<%=classValue%>' style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'>&nbsp;<%=remarksSearchResults.get(remarksCnt+7)%></td>
<%
							if (remarksCodeList.contains(remarks_code))	{
								modeOpn = "U";						
								while(cnt1<codeListMaxRecord){
									fntColor= "";
									backgrndColor= "";
									if((remarksCodeList.get(cnt1++).toString().equalsIgnoreCase(remarks_code))  ){
										default_value=remarksCodeList.get(cnt1++).toString();
										eff_status=remarksCodeList.get(cnt1++).toString();
										remarksSearchResults.set(remarksCnt+4,default_value) ;
										remarksSearchResults.set(remarksCnt+5,eff_status) ;
										remarksSearchResults.set(remarksCnt+6,modeOpn) ;
										bean.setRemarksSearchList(remarksSearchResults);
										break;
									}
									else{
										cnt1+=2;//using 2 instead of 3 for SKR-SCF-1053[IN051947]
									}
								}
							}
							if(default_value.equalsIgnoreCase("Y"))
							   default_value_selected="checked";
							else
								default_value_selected="";

							if(eff_status.equalsIgnoreCase("E"))
							   eff_status_selected="checked";
							else
								eff_status_selected="";
%>
							<td class='<%=classValue%>'  ><input type='checkbox' <%= disabled %> name='DefaultRemark<%=recCount%>' value='<%=default_value%>' <%=default_value_selected%>		onClick="remarksDefaultCheck(this,'<%=remarks_code%>','<%=recCount%>')"></td><!--using recCount instead of remarksCnt SKR-SCF-1053[IN051947] -->
							<td class='<%=classValue%>'><input type='checkbox' name='Remarks<%=recCount%>' id='Remarks<%=recCount%>' value='<%=eff_status%>' <%=eff_status_selected%> onClick="remarksCheck(this,'<%=remarks_code%>','<%=recCount%>')"></td>
							<td><input type="hidden" name="modeOpn<%=recCount%>" id="modeOpn<%=recCount%>"value="<%=modeOpn%>"></td>
<%
							recCount++;
							default_value ="N";
							eff_status= "D";
							modeOpn="I";
						    cnt1=0;//added for SKR-SCF-1053[IN051947]
						}	
						bean.setRemarksSearchList(remarksSearchResults);
						remarksCodeList.clear();
%>
					</tr>
					<input type="hidden" name="remarksCnt" id="remarksCnt" value='<%=recCount%>'>
					<input type="hidden" name="Drug_code" id="Drug_code" value='<%=drug_code%>'>
					<input type="hidden" name="DrugSearch" id="DrugSearch" value='<%=drugSearch%>'>
					<input type="hidden" name="remarks_code" id="remarks_code" value='<%=remarks_code%>'>
					<input type="hidden" name="Drugcode" id="Drugcode" value='<%=drugcode%>'>
					<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
					<input type="hidden" name="mode" id="mode" value='<%=mode%>'>
					<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
					<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				</table>
			</form>
		</body>
<% 
		putObjectInBean(bean_id,bean,request); 
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

