<!DOCTYPE html>

<!--saved on 27th Oct 2005 -->
<!--
Developed by    : P.Sudhakaran.
Module/Function : OP/IP Prescription Transaction calling from CA
-->
<html>
<%-- JSP Page specific attributes start --%>
<%/*
---------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------------------------------------------------------  
23/02/2018  IN066779       Sharanraj    23/02/2018       Chandra            ML-MMOH-CRF-1000.1
08/06/2020  IN:072715      B Haribabu                                                  GHL-ICN-0071  
---------------------------------------------------------------------------------------------------------------------------------------------------------- 
*/ %>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<%
try{
	String params = request.getQueryString() ;
	String patient_id=request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id");
	String patient_class = request.getParameter("patient_class");
	//String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
	//String bean_name	= "ePH.PrescriptionBean_1";
	String bean_id					= "@PrescriptionBean_1"+patient_id+encounter_id;
	String bean_name				= "ePH.PrescriptionBean_1";
	PrescriptionBean_1 bean			= (PrescriptionBean_1)getBeanObject( bean_id, bean_name, request );
	String presBean_id			= "@PrescriptionBean"+patient_id+encounter_id;//Adding start for TH-KW-CRF-0007
	String presBean_name		= "ePH.PrescriptionBean";
	PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );//Adding end for TH-KW-CRF-0007
	String Consumable_bean_id				= "@ConsumableOrderBean"+patient_id+encounter_id;
	String Consumable_bean_name				= "ePH.ConsumableOrderBean";
	ConsumableOrderBean Consumable_bean		= (ConsumableOrderBean)getBeanObject( Consumable_bean_id,Consumable_bean_name, request );
	Consumable_bean.clear();
	
	//Added for IN:072715 start
	String ext_beanid = "@ExternalProductLinkBean";
	String ext_beanname = "ePH.ExternalProductLinkBean";
	ExternalProductLinkBean ext_beanObj = (ExternalProductLinkBean)getBeanObject(ext_beanid,ext_beanname,request);
	ext_beanObj.clear();
	//Added for IN:072715 end
	
	String or_bean_name	="eOR.OrderEntryBean";
	String or_bean_id="@orderentrybean"+patient_id+encounter_id;
	OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
	String or_mode= (String) orbean.getAmendOrder();
	String iv_prep_yn = request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String p_called_from_ca	= request.getParameter("p_called_from_ca")==null?"": request.getParameter("p_called_from_ca"); //Added for ML-BRU-SCF-0098 [IN031837] -moved from PrescriptionHeader_2.jsp HSA-CRF-0147.1 [IN:049419]-RameshGoli
	bean.setCalledFromAmend(p_called_from_ca); //Added for ML-BRU-SCF-0098 [IN031837] -moved from PrescriptionHeader_2.jsp HSA-CRF-0147.1 [IN:049419]-RameshGoli
	
	/*IN066779 starts*/
		String IVbean_id					= "@IVPrescriptionBean"+patient_id+encounter_id;
		String IVbean_name				= "ePH.IVPrescriptionBean";
		IVPrescriptionBean IVbean			= (IVPrescriptionBean)getBeanObject( IVbean_id, IVbean_name, request );
		IVbean.setCalledFromAmend(p_called_from_ca);
		
		String Oncobean_id					= "@OncologyRegimenBean"+patient_id+encounter_id;
		String Oncobean_name				= "ePH.OncologyRegimenBean";
		OncologyRegimenBean Oncobean			= (OncologyRegimenBean)getBeanObject( Oncobean_id, Oncobean_name, request );
	/*IN066779 ends*/
	
%>
	<head>
		<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale = (String) session.getAttribute("LOCALE");
		bean.setLanguageId(locale);
		orbean.setLanguageId(locale);
		IVbean.setLanguageId(locale);//IN066779
		Oncobean.setLanguageId(locale);//IN066779
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../../ePH/js/IVPrescription.js"></script> 
	</head>
<%
	String called_from		=	orbean.getCalledFromFunction(); //added for Bru-HIMS-CRF-400 [IN:044502]
	if(called_from.equals("RENEW_ORDER")){ 
%>
	<!-- 	<frameset rows="50,*" > -->
			<iframe name="f_header" id="f_header" frameborder="0" scrolling="no"  noresize src="../../ePH/jsp/PrescriptionHeader_2.jsp?<%=params%>"  style='height:19vh;width:97vw'></iframe>
			<iframe name="f_options"  id="f_options" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/IVPrescriptionOptions.jsp?iv_prep_yn=+<%=iv_prep_yn%>&patient_id=+<%=patient_id%>&act_patient_class=<%=patient_class%>&encounter_id=+<%=encounter_id%>" style='height:9vh;width:100vw'></iframe>
						<iframe name="f_detail" id="f_detail" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style='height:74vh;width:72vw'></iframe>
						<iframe name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/IVPrescriptionButtons.jsp?iv_prep_yn=+<%=iv_prep_yn%>" style='height:12vh;width:100vw'></iframe>
		<!-- 	<frameset cols="27%,*" id="PrescriptionDetailFrameSet" name="PrescriptionDetailFrameSet"> -->
				<iframe name="f_prescription" id="f_prescription" scrolling="no" noresize src="../../eCommon/html/blank.html" class="CATHIRDWORKAREA" style='height:73vh;width:26vw'></iframe>
				<iframe name="f_options"  id="f_options" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/IVPrescriptionOptions.jsp?iv_prep_yn=+<%=iv_prep_yn%>&patient_id=+<%=patient_id%>&act_patient_class=<%=patient_class%>&encounter_id=+<%=encounter_id%>" style='height:9vh;width:100vw'></iframe>
						<iframe name="f_detail" id="f_detail" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style='height:74vh;width:72vw'></iframe>
						<iframe name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/IVPrescriptionButtons.jsp?iv_prep_yn=+<%=iv_prep_yn%>" style='height:12vh;width:100vw'></iframe>
			<!-- 	<frameset rows="*,10.5" > -->
					<iframe name="f_detail" id="f_detail" frameborder="0" scrolling="no"  src="../../eCommon/html/blank.html" style='height:74vh;width:72vw'></iframe>
					<iframe name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" class="FR_BORDER2" style='height:12vh;width:100vw'></iframe>
		<!-- 		</frameset> -->
			<!-- </frameset> -->
		<!-- </frameset> -->
<%
	} //added for Bru-HIMS-CRF-400 [IN:044502]-end
	else if(or_mode!=null && or_mode.equals("existing_order")){
		//if(iv_prep_yn==null || iv_prep_yn.equals("")){	
		String order_id=request.getParameter("order_id")==null?"":(String)request.getParameter("order_id");//Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli -end
		if(!"".equals(order_id) &&  !bean.getCalledFromAmend().equals("PH") ){
			ArrayList reason_val	= new ArrayList();
			reason_val.add(order_id);
			reason_val.add("");
			reason_val.add((String)orbean.getAmend_reason());
			bean.clearAmendReason(order_id);
			bean.setAmendReason(order_id,reason_val);
		} //Added for HSA-CRF-0147.1 [IN:049419]-RameshGoli-end
		/*IN066779 starts*/
		 if(iv_prep_yn.equals("1")|| iv_prep_yn.equals("2") || iv_prep_yn.equals("3")|| iv_prep_yn.equals("4") || iv_prep_yn.equals("5")){
				ArrayList reason_val1	= new ArrayList();
				reason_val1.add(order_id);
				reason_val1.add("");
				reason_val1.add((String)orbean.getAmend_reason());
				IVbean.clearAmendReason1(order_id);
				IVbean.setAmendReason1(order_id,reason_val1);
		 }
		
		 else if(iv_prep_yn.equals("9") || iv_prep_yn.equals("0")){
			 ArrayList reason_val2	= new ArrayList();
			 reason_val2.add(order_id);
			 reason_val2.add("");
			 reason_val2.add((String)orbean.getAmend_reason());
			 Oncobean.clearAmendReason1(order_id);
			 Oncobean.setAmendReason1(order_id,reason_val2);
		 }
		/*IN066779 Ends*/
		bean.setAuditTrailReqYN((String)orbean.getAmend_auditTrailYN());
%>
		<!-- <frameset rows="10%,*" > -->
		<div style="display:flex ; flex-direction: column;" >
			<iframe name="f_header" id="f_header" frameborder="0" scrolling="no"  noresize src="../../ePH/jsp/PrescriptionHeader_2.jsp?<%=params%>"  style='height:7vh;width:97vw'></iframe>
<%
				if(iv_prep_yn!=null && !iv_prep_yn.equals("")){    
					if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4") || iv_prep_yn.equals("5")){
%>
					<!-- <frameset rows="8%,80%,*" > -->
						<iframe name="f_options"  id="f_options" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/IVPrescriptionOptions.jsp?iv_prep_yn=+<%=iv_prep_yn%>&patient_id=+<%=patient_id%>&act_patient_class=<%=patient_class%>&encounter_id=+<%=encounter_id%>" style='height:9vh;width:100vw'></iframe>
						<iframe name="f_detail" id="f_detail" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" style='height:74vh;width:72vw'></iframe>
						<iframe name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/IVPrescriptionButtons.jsp?iv_prep_yn=+<%=iv_prep_yn%>" style='height:12vh;width:100vw'></iframe>
					<!-- </frameset> -->	
<%
				}
				else if(iv_prep_yn.equals("7") || iv_prep_yn.equals("8")){
%>
					<!-- <FRAMESET ROWS="39,*" FRAMESPACING="0"> -->
						<IFRAME NAME="f_tpnregimenselect" id="f_tpnregimenselect" FRAMEBORDER="0" SCROLLING="no" NORESIZE  src="../../eCommon/html/blank.html" style='height:9vh;width:100vw'></IFRAME>   
						<!-- //src="../../ePH/jsp/TPNRegimenOptions.jsp?iv_prep_yn=+<%=iv_prep_yn%>&patient_id=+<%=patient_id%>&patient_class=<%=patient_class%>&encounter_id=+<%=encounter_id%>" > -->
						<IFRAME NAME="f_tpnregimen" id="f_tpnregimen" FRAMEBORDER="0" SCROLLING="no" NORESIZE	src="../../eCommon/html/blank.html" style='height:89vh;width:100vw'></IFRAME>
						<!-- /*src="../../ePH/jsp/TPNRegStdRegFrames.jsp?iv_prep_yn=+<%=iv_prep_yn%>"> -->
					<!-- </FRAMESET> -->
<%	
				}
				else if(iv_prep_yn.equals("9") || iv_prep_yn.equals("0")){
%>
					<!-- <FRAMESET  FRAMESPACING="0"> -->
						<IFRAME NAME="oncology_detail" id="oncology_detail" FRAMEBORDER="0" SCROLLING="no" NORESIZE src="../../eCommon/html/blank.html" style='height:9vh;width:100vw'></IFRAME>
					<!-- </FRAMESET> -->
<% 
				}
				else if(iv_prep_yn.equals("6")){
%>
					<!-- <FRAMESET  FRAMESPACING="0"> -->
						<IFRAME NAME="f_compound" id="f_compound" FRAMEBORDER="0" SCROLLING="no" NORESIZE src="../../eCommon/html/blank.html" style='height:9vh;width:100vw'></IFRAME>
					<!-- </FRAMESET> -->
<%
				}
			}
			else{
%>
				<!-- <div style="display:flex; height: 93vh;">
						<iframe name="f_prescription" id="f_prescription" scrolling="no" noresize src="../../eCommon/html/blank.html" class="CATHIRDWORKAREA" ></iframe> 
				<div id="PrescriptionDetailFrameSet" name="PrescriptionDetailFrameSet" style="display:flex; flex-direction: column;height: 93vh;">
						<iframe style="height: 87vh; width: 73vw;" name="f_detail" id="f_detail" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" ></iframe>
						<iframe style="height: 5vh; width: 73vw;" name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" class="CATHIRDWORKAREA"></iframe>
 -->
 				<div style="display:flex; height: 93vh; width: 99vw;">
    <iframe name="f_prescription" id="f_prescription" scrolling="no" noresize src="../../eCommon/html/blank.html" class="CATHIRDWORKAREA"></iframe> 
    <div id="PrescriptionDetailFrameSet" name="PrescriptionDetailFrameSet" style="display:flex; flex-direction: column; height: 93vh; width: 100%;">
        <iframe style="height: 87vh; width: 100%;" name="f_detail" id="f_detail" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html"></iframe>
        <iframe style="height: 5vh; width: 100%;" name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" class="CATHIRDWORKAREA"></iframe>
    </div>
</div>
 				
<%
		}
%>
		<!-- </frameset> -->
<%
		/*}else if(iv_prep_yn!= null && iv_prep_yn.equals("N")){
			out.println("<script>reloadScreens('4','"+patient_id+"','"+encounter_id+"','','OP','"+order_id+"')</script>");
		}*/
	}
	else{	
		bean.clear();
		presBean.clear();//Adding  for TH-KW-CRF-0007
%>
<div style="display:flex ; flex-direction: column;" > 
<!-- <frameset rows="77,*" > -->
<iframe style="height: 19vh; width: 100vw;" name="f_header"  id="f_header" frameborder="0" scrolling="no" noresize src="../../ePH/jsp/PrescriptionHeader_1.jsp?<%=params%>" ></iframe>
<div style="display:flex; height: 80vh;">
<!-- <frameset cols="27%,*" id="PrescriptionDetailFrameSet" name="PrescriptionDetailFrameSet"> -->
<iframe name="f_prescription" id="f_prescription" scrolling="no" noresize src="../../eCommon/html/blank.html" class="CATHIRDWORKAREA" ></iframe>
<div id="PrescriptionDetailFrameSet" name="PrescriptionDetailFrameSet" style="display:flex; flex-direction: column;height: 75vh;">
<!-- <frameset rows="*,23.5" > -->
<iframe style="height: 70vh; width: 73vw;" name="f_detail" id="f_detail" frameborder="0" scrolling="auto"  src="../../eCommon/html/blank.html" ></iframe>
<iframe style="height: 7vh; width: 80vw;" name="f_button" id="f_button" frameborder="0" scrolling="no" noresize src="../../eCommon/html/blank.html" class="FR_BORDER2"></iframe>
<!-- </frameset> -->
</div>
<!-- </frameset> -->
</div>
<!-- </frameset> -->
</div>
<%
	}
	putObjectInBean(or_bean_id,orbean,request); 
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(presBean_id,presBean,request);//Adding  for TH-KW-CRF-0007
	putObjectInBean(Consumable_bean_id,Consumable_bean,request);
	putObjectInBean(ext_beanid,ext_beanObj,request);//Added for IN:072715
}
catch(Exception e){
	e.printStackTrace();
}
%>
</html>
