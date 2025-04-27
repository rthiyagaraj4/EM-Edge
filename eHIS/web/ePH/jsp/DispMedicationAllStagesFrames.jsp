<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
<head>
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
<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script><!-- Added for  Bru-HIMS-CRF-081 [IN:029947]-->
<script>
	var heightarr = new Array();

<%
	String params	=	request.getQueryString();
	String disp_stage = request.getParameter("disp_stage");
	
	String	bean_id				=	"DispMedicationAllStages" ;
	String	bean_name			=	"ePH.DispMedicationAllStages";	
	DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
		bean.setLanguageId(locale);

	String	bean_id_1				=	"DispMedicationBean" ;
	String	bean_name_1			    =	"ePH.DispMedicationBean";	
	DispMedicationBean bean_1 = (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
		//bean_1.setLanguageId(locale);
    String billing_interface_yn		=	bean.getBLInterfaceYN();//checkforbillinginterface();
    String ws_type=bean_1.getWsType();
	String fill_list = bean_1.getFillList().trim();
	
	if(ws_type==null)ws_type="";
	String iv_prep_yn=ws_type;
	if( disp_stage.equals("A")||disp_stage.equals("F") ){
		if(iv_prep_yn.equals("2") || iv_prep_yn.equals("4")){
			bean_1.setAdmixtureType("I");
		}
		else if(iv_prep_yn.equals("6")){
			bean_1.setAdmixtureType("I");
		}
		else if(iv_prep_yn.equals("0")){
			bean_1.setAdmixtureType("C");
		}
		else if(iv_prep_yn.equals("8")){
			bean_1.setAdmixtureType("TA");
		}
		else {
			if(iv_prep_yn != null && iv_prep_yn.equals("7") )
				bean_1.setAdmixtureType("TD");
		}
	}
	String order_id = request.getParameter("order_id");
    bean_1.setOrderID(order_id.trim());

	String rows="10%,*,10%";	
	if(billing_interface_yn.equals("Y")){
		if( disp_stage.equals("V")){
			System.out.println("LINE 69");
			%>

			heightarr[0]="0vh";
			heightarr[1]="70vh";
			heightarr[2]="0vh";
			heightarr[3]="10vh";
			<%
			//rows="0%,*,0%,10%";
		}
		else if( disp_stage.equals("AS") ){
			System.out.println("LINE 73");
			%>

			heightarr[0]="5vh";
			heightarr[1]="70vh";
			heightarr[2]="0vh";
			heightarr[3]="10vh";
			<%
			//rows="5%,*,0%,10%";
		}
		else
		{
			%>

			heightarr[0]="10vh";
			heightarr[1]="70vh";
			heightarr[2]="10vh";
			<%
            //rows="10%,*,10%";
		}
	}
	else{
		if( disp_stage.equals("V")){
			System.out.println("LINE 81");
			%>

			heightarr[0]="0vh";
			heightarr[1]="70vh";
			heightarr[2]="0vh";
			heightarr[3]="10vh";
			<%
			//rows="0%,*,0%,10%";
		}
		else if (disp_stage.equals("AS") ){
			System.out.println("LINE 85");
			%>

			heightarr[0]="10vh";
			heightarr[1]="70vh";
			heightarr[2]="0vh";
			heightarr[3]="10vh";
			<%
			//rows="10%,*,0%,10%";
		}
	}	
%>
</script>
</head>
<%-- <frameset rows="88%,*" name='DispMedicationAllStagesFrame'>	<!--  Added for  Bru-HIMS-CRF-081 [IN:029947] ---> 
<frameset id="dispmednframeset2" name="dispmednframeset2" rows="100%" cols="100%,0%">	<!--  Added for  Bru-HIMS-CRF-081 [IN:029947] --->
	<frameset id="dispmednframeset" name="dispmednframeset" rows="<%=rows%>" >
		<frame name="f_disp_medication_header" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationHeader.jsp?<%=params%>&iv_prep_yn=<%=ws_type%>&billing_interface_yn=<%=billing_interface_yn%>">
<%
		if(disp_stage.equals("AS")){
%>
			<frame name="f_disp_medication_all_stages" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
			<frame name="f_disp_medication_interactions" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
<%
		}
		else if(disp_stage.equals("V")){
%>
			<frame name="f_disp_medication_verification" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationVerification.jsp?<%=params%>">
			<frame name="f_disp_medication_interactions" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
<%
		}
		else if((ws_type.equals("I")||ws_type.equals("C"))&&(disp_stage.equals("A") ||disp_stage.equals("F"))){
%>
			<frame name="f_disp_medication_allocation" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationAllocation.jsp?<%=params%>">
<%
		}
		else if(disp_stage.equals("A")){
			 if(bean_1.getFillingStatus().equals("B")){
%>
			<frame name="f_disp_medication_allocation" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationAllocation.jsp?<%=params%>">
<%
		}
		else{
%>
			<frame name="f_disp_medication_allocation" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
<%
			}
		}
		else if(disp_stage.equals("F")){
			if(bean_1.getFillingStatus().equals("A") &&(!bean_1.getDispLocnCatg().equals("I"))|| fill_list.equals("AF") ){

%>
			<frame name="f_disp_medication_filling" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationFilling.jsp?<%=params%>">
<%
			}
			else{
%>
				<frame name="f_disp_medication_filling" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html">
<%
				}
			}
			else if(disp_stage.equals("D")){
%>
				<frame name="f_disp_medication_delivery" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationDelivery.jsp?<%=params%>">
<%
			}
%>
			</frameset> <!--  Added for Bru-HIMS-CRF-081 [IN:029947] -->
			<frameset id="dispmednframeset3" name="dispmednframeset3">
				<frame name="f_disp_medication_drug_profile"  frameborder="0" scrolling="auto" src="../../eCommon/html/blank.html">
			</frameset> <!--  Added forBru-HIMS-CRF-081 [IN:029947] -->
			<frame name="f_disp_medication_all_stages_legends" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"> 
		</frameset>	
	</frameset>   <!--  Added forBru-HIMS-CRF-081 [IN:029947] --> --%>
<body>
<div  name='DispMedicationAllStagesFrame'>	<!--  Added for  Bru-HIMS-CRF-081 [IN:029947] ---> 
  <div id="dispmednframeset2" name="dispmednframeset2">	<!--  Added for  Bru-HIMS-CRF-081 [IN:029947] --->
	<div id="dispmednframeset" name="dispmednframeset"  >
		<iframe name="f_disp_medication_header" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/DispMedicationHeader.jsp?<%=params%>&iv_prep_yn=<%=ws_type%>&billing_interface_yn=<%=billing_interface_yn%>"></iframe>
<%
		if(disp_stage.equals("AS")){
%>
			<iframe name="f_disp_medication_all_stages" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></iframe>
			<iframe name="f_disp_medication_interactions" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></iframe>
<%
		}
		else if(disp_stage.equals("V")){
%>
			<iframe name="f_disp_medication_verification" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationVerification.jsp?<%=params%>"></iframe>
			<iframe name="f_disp_medication_interactions" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></iframe>
<%
		}
		else if((ws_type.equals("I")||ws_type.equals("C"))&&(disp_stage.equals("A") ||disp_stage.equals("F"))){
%>
			<iframe name="f_disp_medication_allocation" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationAllocation.jsp?<%=params%>"></iframe>
<%
		}
		else if(disp_stage.equals("A")){
			 if(bean_1.getFillingStatus().equals("B")){
%>
			<iframe name="f_disp_medication_allocation" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationAllocation.jsp?<%=params%>"></iframe>
<%
		}
		else{
%>
			<iframe name="f_disp_medication_allocation" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></iframe>
<%
			}
		}
		else if(disp_stage.equals("F")){
			if(bean_1.getFillingStatus().equals("A") &&(!bean_1.getDispLocnCatg().equals("I"))|| fill_list.equals("AF") ){

%>
			<iframe name="f_disp_medication_filling" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationFilling.jsp?<%=params%>"></iframe>
<%
			}
			else{
%>
				<iframe name="f_disp_medication_filling" frameborder="0" scrolling="auto" noresize src="../../eCommon/html/blank.html"></iframe>
<%
				}
			}
			else if(disp_stage.equals("D")){
%>
				<iframe name="f_disp_medication_delivery" frameborder="0" scrolling="auto" noresize src="../../ePH/jsp/DispMedicationDelivery.jsp?<%=params%>"></iframe>
<%
			}
%>
		</div> <!--  Added for Bru-HIMS-CRF-081 [IN:029947] -->
			<div id="dispmednframeset3" name="dispmednframeset3" style="display:none">
				<iframe name="f_disp_medication_drug_profile"  frameborder="0" scrolling="auto" src="../../eCommon/html/blank.html"></iframe>
			</div> <!--  Added forBru-HIMS-CRF-081 [IN:029947] -->
			<iframe name="f_disp_medication_all_stages_legends" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style="height:17vh;width:99vw;"></iframe>
		</div>	
	</div>   <!--  Added forBru-HIMS-CRF-081 [IN:029947] -->
	<script>
		let parentElement = document.getElementById('dispmednframeset');  // Replace 'parent' with your actual parent element's ID

// Get all the iframe child elements using getElementsByTagName
let iframes = parentElement.getElementsByTagName('iframe');

// Convert HTMLCollection to an array (optional)
let iframeArray = Array.from(iframes);

for(i=0;i<iframeArray.length;i++){
	iframeArray[i].style.height=heightarr[i];
	iframeArray[i].style.width="99vw";
}
	
	</script>
</body>	
</html>
<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>
