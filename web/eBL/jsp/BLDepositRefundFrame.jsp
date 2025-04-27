
<!--
---------------------------------------------------------------------------------------------------------------
Sr No        Version           TFS/Incident        SCF/CRF            		 Developer Name
--------------------------------------------------------------------------------------------------------
1            V220412            30399          MMS-ME-SCF-0064-TF               Mohanapriya K
--------------------------------------------------------------------------------------------------------
-->
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*,eCommon.Common.*,org.apache.commons.codec.binary.Base64" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	try
	{
			
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String params = request.getQueryString();
		con	=	ConnectionManager.getConnection(request);

	//	 System.err.println("params BLEnterReceiptRefundFrame.jsp?"+params);   //Associate Package [IN:049347] session clearance   
		
	 	//added by Vijay for bill generation patient deposit collection  	
	
		String called_from=request.getParameter("called_from");
		System.out.println("called_from:: "+called_from);
	// ends --- 
	
	
		String modeOfCall= (request.getParameter("modeOfCall")==null)?"":request.getParameter("modeOfCall");
		if(modeOfCall.equals("Subscription")){
			session.removeAttribute("PACKAGE_SUBSCRIPTION_ASSOCIATION_ENCOUNTERS");
		}
//		String title = request.getParameter("title");	
		
		//con	=	ConnectionManager.getConnection(request);

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";
//		System.err.println("strloggeduser" +strloggeduser);

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
//		System.err.println("strclientip "+strclientip);

		//V220412 Starts
		String patient_id	="";
		String encounter_id	="";
		
		if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
			patient_id	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
			encounter_id	= new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
		}else{
			patient_id	= request.getParameter("patient_id");
			encounter_id	= request.getParameter("encounter_id");
		}
		//V220412 Ends
		
		System.out.println("pid,BLDepositRefundFrame.jsp="+patient_id);
		if(patient_id==null) patient_id="";	

		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";	
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";	

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";	
	
		if(encounter_id==null) encounter_id="";	

		String for_pline = "Facility_Id="+facilityid+"&Patient_Id="+patient_id;
		System.err.println("for_pline:"+for_pline);

		//String function_id="rcpt_rfnd";	
//for pkg deposit
	
/****added for package biling********************/
		String function_id = request.getParameter("function_id");	
		if(function_id==null) function_id="rcpt_rfnd";

		String pkgCode = request.getParameter("pkgCode");	
		if(pkgCode==null) pkgCode="";
		//String function_id="rcpt_rfnd";	
//end pkg dep
		
		
		String strbilldoctypecode="";String strbilldocnum="";String strslmtidno="";	String strslmtpayername="";String strcashcountercode="";	String strblnggrpid="";				String strbillpayableamt="";
		//String strunknownpatientyn = "";

		pstmt = con.prepareStatement( " select nvl(pat_dtls_unknown_yn,'N'),NATIONAL_ID_NO, PATIENT_NAME from mp_patient where patient_id = '" + patient_id + "'" );
		rs = pstmt.executeQuery();	
		if ( rs.next() && rs != null ) 
		{ 	
			//strunknownpatientyn =  rs.getString(1);
			strslmtidno  =   rs.getString(2);			
			strslmtpayername =  rs.getString(3);
		}
		System.err.println("Output after query : "+strslmtpayername+", "+strslmtidno);
//		String collect_dep_amt_in_adv_yn="";
	/*try{

		String query_date=" select COLLECT_DEP_DURING_ADM_YN from bl_ip_nursing_unit_type where NURSING_UNIT_TYPE_CODE = (Select nursing_unit_type_code from ip_nursing_unit where nursing_unit_code='CARD' and facility_id='"+facilityid+"') ";
		PreparedStatement pst2=con.prepareStatement(query_date);
		ResultSet rst2 = pst2.executeQuery();
		if (rst2!=null)
		{
		   if (rst2.next())
		   {
				 collect_dep_amt_in_adv_yn = rst2.getString(1);
		   }
		}

		if (rst2 != null)   rst2.close();
		if (pst2 != null)   pst2.close();
		System.err.println("collect deposit :"+collect_dep_amt_in_adv_yn);
	
	}catch(Exception ee)
	{
		System.err.println("Error from collect deposit"+ee);
	}*/
	%>
		<script>
				
		</script>
<HTML>
<head>
	<title>
	 <%
//for package billing
		if(function_id.equals("PKG_BILLING"))
		{			
%>
			 <fmt:message key="eBL.DEPOSIT.label" bundle="${bl_labels}"/>	
<%		}else{
%>
		 <fmt:message key="eBL.DepositReceipt.label" bundle="${bl_labels}"/>
<%
			}
%>

	</title>
</head>

<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>	
		<!--<script language="javascript" src="../../eBL/js/BLEnterServiceRequest.js"></script>	-->
		<script language="javascript" src="../../eBL/js/BLDepositReceipt.js"></script>
        <script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>





	 <!-- <iframe name='pat_banner_frame' id='pat_banner_frame' SRC="../../eBL/jsp/BLPatBanner.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style='height:7%;width:100vw'></iframe> 	-->
		<!-- <iframe name='pat_banner_frame' id='pat_banner_frame' SRC="../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient_id%>" frameborder=0 scrolling='no' noresize style='height:40%;width:100vw'></iframe> -->	
			<iframe name='pline' id='pline' frameborder='0'	src="../../eCommon/jsp/pline.jsp?Patient_Id=<%=patient_id%>&episodetype=<%=episode_type%>&episodeid=<%=episode_id%>&visitid=<%=visit_id%>"  scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
			<iframe name='details_frame' id='details_frame' SRC="../../eBL/jsp/BLDepositRefund.jsp?<%=params%>&called_from=<%=called_from%>" frameborder=0 scrolling='no' noresize style='height:34vh;width:100vw'></iframe> 		
			<iframe SRC="../../eBL/jsp/BLBillSlmtType.jsp?function_id=<%=function_id%>&billdoctypecode=<%=strbilldoctypecode%>&billdocnum=<%=strbilldocnum%>&billpayableamt=<%=strbillpayableamt%>&facilityid=<%=facilityid%>&loggeduser=<%=strloggeduser%>&patientid=<%=patient_id%>&episodetype=<%=episode_type%>&episodeid=<%=episode_id%>&visitid=<%=visit_id%>&slmtidno=<%=strslmtidno%>&slmtpayername=<%=strslmtpayername%>&cashcounter=<%=strcashcountercode%>&strblnggrpid=<%=strblnggrpid%>" NAME="BillSlmtTypeFrame" frameborder=0 noresize scrolling='yes' style='height:40vh;width:100vw'></iframe> 	
			<iframe SRC="../../eCommon/html/blank.html"	  name="" id="" frameborder=0 noresize scrolling='no'style='height:6vh;width:100vw'></iframe> 	
			<iframe name='details_frame' id='details_frame' SRC="../../eBL/jsp/BLDepositReceiptRefund.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe> 
			<iframe SRC="../../eCommon/html/blank.html"	  name="submit_frame" id="submit_frame" frameborder=0 noresize scrolling='yes' style='height:6vh;width:100vw'></iframe>	

<%

	}
	catch(Exception ee)
	{
		//out.println("from main :"+ee);
		ee.printStackTrace();
	}
	finally
	{
		if(con!=null) 
			ConnectionManager.returnConnection(con, request);
		if (rs != null)   rs.close();
		if (pstmt != null) pstmt.close();		 
	}
%>
</HTML>

