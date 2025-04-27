<!DOCTYPE html>
 <%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
    request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
    //ends
	String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>-->
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNStdRegimen.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>




</head>
<%
	String params			= request.getQueryString() ;
	
	String bean_id	= "TPNNonStandardRegimenBean";
	String bean_name	 = "ePH.TPNNonStandardRegimenBean";
	String facility_id		= (String) session.getValue("facility_id");
	TPNNonStandardRegimenBean bean = (TPNNonStandardRegimenBean) getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(locale);

	String bean_id2				= "TPNRegimenBean";
	String bean_name2			= "ePH.TPNRegimenBean";
	TPNRegimenBean bean2	= (TPNRegimenBean)getBeanObject(bean_id2,bean_name2,request) ;
	bean2.setLanguageId(locale);
	
	HashMap record2=new HashMap(); 
	String tpn_screening_type="";
	String note_type="";
	String accession_num="";
	String encounter_id		= request.getParameter("encounter_id");
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");//added for MMS-QH-CRF-0048 [IN:037704]
	record2=bean2.ChkAdMixture();
	tpn_screening_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_TYPE"));
    note_type=CommonBean.checkForNull((String)record2.get("TPN_SCREENING_FORM_ID"));
	   
	if(tpn_screening_type.equals("N")){
		HashMap record3=new HashMap();
		record3=bean2.ChkScreeningDetails(facility_id,encounter_id,note_type);
		accession_num=CommonBean.checkForNull((String)record3.get("ACCESSION_NUM"));
	}

	//ArrayList consResults=bean.getTPNGroups();
	String mode="MODE_INSERT";
	
	String location_type		= request.getParameter("location_type");
	String location_code		= request.getParameter("location_code");
	String take_home_medication = request.getParameter("take_home_medication");
	String priority				= request.getParameter("priority");
	String iv_prep_yn			= "7";
	if(priority==null) 
		priority="";

	ArrayList ord_disp_location  = (ArrayList) bean.getOrderDispenseLocationForTPN(location_type,location_code,take_home_medication,priority,iv_prep_yn,"",patient_id,encounter_id);// "",patient_id,encounter_id added for MMS-QH-CRF-0048 [IN:037704]

	String dflt_disp_locn	= "";
	if(ord_disp_location != null & ord_disp_location.size()>0){
		dflt_disp_locn	= (String)ord_disp_location.get(2); 
		if(dflt_disp_locn == null) 
			dflt_disp_locn ="";
	}

%>
<!--<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">-->
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form>
	<table width="100%">
	<TR>
		<TD align="left" class="label" >&nbsp;&nbsp;<fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>
		<b><label class="label" id="dflt_disp_locn_lbl" name="dflt_disp_locn_lbl" >&nbsp;<%=dflt_disp_locn%><label></b>
		</TD>
		<TD align="right" >
			<INPUT TYPE="button"  class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="callCancel()" >	
			<INPUT TYPE="button" class="button" name="Release" id="Release" value='<fmt:message key="ePH.ReleaseRx.label" bundle="${ph_labels}"/>' onClick="apply('<%=encounter_id%>','<%=accession_num%>','<%=tpn_screening_type%>');">	
			</TD></TR>
	</TABLE>
			
</form>
<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">

</body>
</html>

