<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.net.*,webbeans.op.CurrencyFormat, java.io.*, com.ehis.util.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
//Modified by MuthuN against 34961 on 13-9-12
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	PreparedStatement pstmt = null;
//Modified by MuthuN against 34961 on 13-9-12
	Connection con1	= null;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	boolean site3TierAlmoFeature = false;
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	try
	{
			
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		String params = request.getQueryString();

		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";

		String	strloggeduser	=  (String) session.getValue("login_user");	
		if (strloggeduser==null) strloggeduser = "";

		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";

		String patient_id = request.getParameter("patient_id");	
		if(patient_id==null) patient_id="";
		
		String episode_type = request.getParameter("episode_type");	
		if(episode_type==null) episode_type="";
	
		String episode_id = request.getParameter("episode_id");	
		if(episode_id==null) episode_id="";

		String visit_id = request.getParameter("visit_id");	
		if(visit_id==null) visit_id="";
	
		String encounter_id = request.getParameter("encounter_id");	
		if(encounter_id==null) encounter_id="";

		String p_pract_id = request.getParameter("pract_id");	
		if(p_pract_id==null) p_pract_id="";

		String p_locn_code = request.getParameter("locn_code");	
		if(p_locn_code==null) p_locn_code="";

		String p_billgenlater = request.getParameter("billgenlater");	
		if(p_billgenlater==null) p_billgenlater="";

		String p_function_id = request.getParameter("function_id");	
		if(p_function_id==null) p_function_id="";

		String p_module_id = request.getParameter("module_id");	
		if(p_module_id==null) p_module_id="";

		String p_visit_type_code = request.getParameter("visit_type_code");	
		if(p_visit_type_code==null) p_visit_type_code="";

		String p_slmt_reqd_yn = request.getParameter("slmt_reqd_yn");	
		if(p_slmt_reqd_yn==null) p_slmt_reqd_yn="";
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		try {
			con1	=	ConnectionManager.getConnection(request);
			site3TierAlmoFeature = eCommon.Common.CommonBean.isSiteSpecific(con1, "BL","3TIERALMOFEATURE");
			} catch(Exception ex) {
				System.err.println("Error in BLAdhocDiscFrame.jsp for getting site3TierAlmoFeature Connection: "+ex);
				ex.printStackTrace();
			}finally{
				if(con1!=null) {
					ConnectionManager.returnConnection(con1, request);
			}
		}
		//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
		
		//Modified by MuthuN against 34961 on 13-9-12
		String str_reg_facility_id="";
		String str_custmr_id ="";

try	{
				con	=	ConnectionManager.getConnection(request);	
				String sql1="";
		
				sql1 = "select facility_id from pr_encounter where patient_id = ? and encounter_id = ? ";

		System.err.println("87, BLAdhocDiscFrame.jsp==sql1==> select facility_id from pr_encounter where patient_id = '"+patient_id+"' and encounter_id = '"+encounter_id+"'");

		//stmt = con.createStatement();
		/* Fixed SQL Injection for Common-ICN-0222 */
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1, patient_id);
		pstmt.setString(2, encounter_id);
		rs = pstmt.executeQuery();	

		while(rs.next())
		{
		   str_reg_facility_id  =  rs.getString(1);		
		   System.err.println("BLAdhocDiscFrame.jsp==str_reg_facility_id ==>"+str_reg_facility_id);
		}	
		rs.close();
		pstmt.close();			  
		if (str_reg_facility_id==null) str_reg_facility_id = "";
		System.err.println("str_reg_facility_id from query==>"+str_reg_facility_id); 

		sql1 = "select customer_id from sm_site_param ";

		System.err.println("104, BLAdhocDiscFrame.jsp==sql1==> select customer_id from sm_site_param");
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql1);	

		while(rs.next())
		{
		   str_custmr_id  =  rs.getString(1);
		   System.err.println("BLAdhocDiscFrame.jsp==str_custmr_id ==>"+str_custmr_id);
		}	
		rs.close();
		stmt.close();			  
		if (str_custmr_id==null) str_custmr_id = "";				   
		params =params + "&customer_id="+str_custmr_id;
		System.err.println("117, BLAdhocDiscFrame.jsp== params==>"+params);
	}
	catch(Exception e)
	{    
		e.printStackTrace();
		System.err.println("Error while calling BLCOMMON.BL_VALIDATE_UPD_FIN_DTLS :"+e);
	}
	//String for_pline = "Facility_Id="+facilityid+"&Patient_Id="+patient_id+"&EncounterId="+encounter_id+"&visit_id="+visit_id;
	String for_pline ="Facility_Id="+str_reg_facility_id+"&Patient_Id="+patient_id+"&EncounterId="+encounter_id+"&visit_id="+visit_id;	
	//Modified by MuthuN against 34961 on 13-9-12
%>
<HTML>
<head>
<%		/***********Added for ghl-crf-1.2******************************/
		String called_for_reg_chg = request.getParameter("called_for_reg_chg");
		if(called_for_reg_chg == null) called_for_reg_chg="N";
		/***************end*********************************************/
		if(called_for_reg_chg.equals("pat_reg_chr") || p_module_id.equals("MP"))
		{
%>			<title><fmt:message key="eBL.DISC_FOR_REG_CHARGE_DTLS.label" bundle="${bl_labels}"/></title>
<%		}else{
%>			<title><fmt:message key="eBL.DISC_FOR_ENC_CHARGE_DTLS.label" bundle="${bl_labels}"/></title>
<%		} %>
</head>

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
	String height1 ="";
	String height2 ="";
	String height3 ="";
	String height4 ="";
	String height5 ="";
	String height6 ="";

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript"src="../../eCommon/js/ValidateControl.js"></script>	
	<!-- <script language="javascript" src="../../eBL/js/BLEnterServiceRequest.js"></script>	 -->
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<%	//if(str_custmr_id.equals ("ALMO"))
	//Added V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1
	if(str_custmr_id.equals ("ALMO") || site3TierAlmoFeature == true) 
	{
		
		 height1 ="10vh";
		 height2 ="20vh";
		 height3 ="50vh";
		 height4 ="8vh";
		 height5 ="0vh";
		 height6 ="5vh";
		
%>
	
  <!-- <iframeSET rows='7%,40%,40%,10%,0%,3%'> -->
  <%}else{
	  
	    height1 ="10vh";
		height2 ="20vh";
		height3 ="55vh";
		height4 ="20vh";
		height5 ="5vh";
	  %>
 <!--  <iframeSET rows='7%,40%,40%,10%,3%'> -->
    <%} %>
  		
		<iframe name='pat_banner_frame' id='pat_banner_frame' SRC="../../eCommon/jsp/pline.jsp?<%=for_pline%>" frameborder=0 scrolling='no' noresize style="height:<%=height1%>;width:100vw;"></iframe>			
		<iframe name='details_frame' id='details_frame' SRC="../../eBL/jsp/BLAdhocDisc.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style="height:<%=height2%>;width:100vw;"></iframe>		
		<iframe SRC="../../eCommon/html/blank.html"	  NAME="payer_frame" id="payer_frame" frameborder=0 noresize scrolling='no' style="height:<%=height3%>;width:100vw;"></iframe>			

		<iframe name='btn_frame' SRC="../../eBL/jsp/BLAdhocDiscBtn.jsp?<%=params%>" frameborder=0 scrolling='no' noresize style="height:<%=height4%>;width:100vw;"></iframe>

<!--
		<iframe SRC="../../eCommon/html/blank.html"	  NAME="btn_frame" frameborder=0 noresize scrolling='yes'>				
-->
		<iframe SRC="../../eCommon/html/blank.html"	  NAME="submit_frame" id="submit_frame" frameborder=0 noresize scrolling='no' style="height:<%=height5%>;width:100vw;"></iframe>
		<% //Added V200228 SHIKHA against AAKH-CRF-0112  & AAKH-SCF-0404.1
			if(str_custmr_id.equals ("ALMO") || site3TierAlmoFeature == true) { %>
		<iframe SRC="../../eBL/jsp/BLDiscColorBondInd.jsp"	  NAME="color_bond" id="color_bond" frameborder=0 noresize scrolling='no' style="height:<%=height6%>;width:100vw;"></iframe>
		<%} //Ended V200228 SHIKHA against AAKH-CRF-0112 & AAKH-SCF-0404.1 %>
			
 <!--   </FRAMESET>	 -->

<%

	}
	catch(Exception ee)
	{
		ee.printStackTrace();
		out.println("Exception in BLAdhocDiscFrame.jsp:"+ee);
	}
	/*Added by karthik on 2-Jan-2013 for AMS-SCF-0170*/
	finally
	{
		session.setAttribute("str_default_reason_code","");
		session.setAttribute("str_default_reason_desc","");
		if(con!=null) {
			ConnectionManager.returnConnection(con, request);
		}
	}
%>
</HTML>
