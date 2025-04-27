<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<HTML>
<HEAD>
</HEAD>
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
		
		<script language='javascript' src='../../eBL/js/BLApprStatusTrackSearch.js'></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
			String userId = (String) session.getAttribute("login_user");
			String responsibility_id=(String)session.getAttribute("responsibility_id");	
			String facility_id  =  (String) session.getValue("facility_id") ;
			System.err.println("userId BLApprStatusTrackMain.jsp=>"+userId);
			System.err.println("responsibility_id "+responsibility_id);
			System.err.println("facility_id "+facility_id);
			System.err.println("request "+session.getAttribute("site_id"));
			
			String validInsUser = "";
			String validFrontUser = "";
			String p_privilege_val = "";
			String p_allowed_yn = "";
			String functionID	= 	"APPR_STATUS_DASHBOARD";
			String privilegeIns	= 	"APPR_STATUS_INS_TEAM";
			String privilegeFront	= 	"APPR_STATUS_FRONT_OFFICE";
			Connection con = null;
			boolean  apprvSts_AAKH= false;
			String apprvSts_AAKHYN = "N";	//V230425-AAKH-CRF-0152
			//NMC-JD-CRF-0102.2
			boolean  PreAuthEclaim = false;
			String PreAuthEclaimYN = "N";	
			
			
			try
			{
				con	=	ConnectionManager.getConnection(request);
				//V230425
				try {
					apprvSts_AAKH = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "APPR_STS_TRACK_FOR_AAKH");
				if (apprvSts_AAKH)
					apprvSts_AAKHYN = "Y";
				else
					apprvSts_AAKHYN = "N";
				  } catch (Exception ex) {
					ex.printStackTrace();
					System.err.println("Exception in apprvSts_AAKH " + ex);
				}
				System.err.println("apprvSts_AAKHYN " + apprvSts_AAKHYN);
				//NMC-JD-CRF-0102.2
				try {
					PreAuthEclaim = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "PREAUTH_ECLAIM_STS_TRCK");
					//PreAuthEclaim = eCommon.Common.CommonBean.isSiteSpecific(con,"BL", "UPLOAD_CLARIFICATION_DOC");
				if (PreAuthEclaim)
					PreAuthEclaimYN = "Y";
				else
					PreAuthEclaimYN = "N";
				  } catch (Exception ex) {
					ex.printStackTrace();
					System.err.println("Exception in PreAuthEclaim " + ex);
				}
				System.err.println("PreAuthEclaim " + PreAuthEclaim);
				
				if(PreAuthEclaim){
					functionID	= 	"EBL_TRANS_PRE_AUTH_CLAIM_STS";
					privilegeIns = 	"PRE_AUTH_ECLAIMS_STATUS";
				}
				//NMC-JD-CRF-0102.2
				//V230425
				CallableStatement cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
				cstmt1.setString(1, facility_id);			
				cstmt1.setString(2, userId);			
				cstmt1.setString(3, responsibility_id);			
				cstmt1.setString(4, functionID);			
				cstmt1.setString(5, privilegeIns);	
				cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
				cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
				cstmt1.execute();	
				p_privilege_val = cstmt1.getString(6);
				p_allowed_yn = cstmt1.getString(7);
				System.err.println("p_privilege_val " + p_privilege_val);
				System.err.println("p_allowed_yn " + p_allowed_yn);
				System.err.println("userId " + userId);
				if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y"))
				{
					validInsUser = "Y";
				}
				else
				{			
					validInsUser="N";
				} 
			
				
				
				if(!apprvSts_AAKH && !PreAuthEclaim){ //to restrict frontuser access for aakh and alna and allow for other -V230425
					cstmt1 = con.prepareCall("{ call BLPOLICYUSERACCESSDTLS.get_bl_privlege_yn(?,?,?,?,?,sysdate,?,?)}");
					cstmt1.setString(1, facility_id);			
					cstmt1.setString(2, userId);			
					cstmt1.setString(3, responsibility_id);			
					cstmt1.setString(4, functionID);			
					cstmt1.setString(5, privilegeFront);	
					cstmt1.registerOutParameter(6, java.sql.Types.VARCHAR);
					cstmt1.registerOutParameter(7, java.sql.Types.VARCHAR);
					cstmt1.execute();	
					p_privilege_val = cstmt1.getString(6);
					p_allowed_yn = cstmt1.getString(7);
					if(p_privilege_val.equals("Y") && p_allowed_yn.equals("Y"))
					{
						validFrontUser = "Y";
					}
					else
					{			
						validFrontUser="N";
					} 
				}
			}
			catch(Exception ee)
			{
				ee.printStackTrace();
			}
			System.err.println("PreAuthEclaimYN main-" + PreAuthEclaimYN);
			System.err.println("validInsUser " + validInsUser);
			String params = request.getQueryString() ;
			if(params==null || params.equals("")) params="";
			String function_id=request.getParameter("function_id");
			if(function_id==null || function_id.equals("")) function_id="";
			
			//validInsUser="Y";
%>
<%if(validInsUser.equals("Y") && PreAuthEclaimYN.equals("Y")){
%>
  <iframe name='commontoolbarFrame' id='commontoolbarFrame' src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>' frameborder=0 scrolling='no' noresize style="height:7vh;width:100vw"></iframe>
		<iframe name='tabFrame' id='tabFrame' src='../../eBL/jsp/PreAuthEclaimStsTab.jsp?<%=params%>&validInsUser=<%=validInsUser%>&PreAuthEclaimYN=<%=PreAuthEclaimYN%>&validFrontUser=<%=validFrontUser%>&apprvSts_AAKHYN=<%=apprvSts_AAKHYN%>' frameborder=0 scrolling='' noresize style="height:5vh;width:100vw"></iframe>
		<iframe name='BLApprStatusTrackQueryFrame' id='BLApprStatusTrackQueryFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize style="height:81vh;width:100vw"></iframe>
		<%-- <iframe name='BLApprStatusTrackQueryFrame' id='BLApprStatusTrackQueryFrame' src='../../eBL/jsp/BLApprStatusTrackQueryFrame.jsp?<%=params%>&validInsUser=<%=validInsUser%>&PreAuthEclaimYN=<%=PreAuthEclaimYN%>' frameborder=0 scrolling='' noresize style="height:10vh;width:100vw"></iframe>
		 --%><!-- <iframe name='dummy' id='dummy' src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize></iframe> 
		<iframe name='dummyFrame' id='dummyFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='' noresize></iframe> 
		 -->
		 <iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style="height:7vh;width:100vw"></iframe>			
		  
	
<%	
}
else if(validInsUser.equals("Y") || validFrontUser.equals("Y") ){%>
   <iframe name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/commonToolbar.jsp?<%=params%>'  frameborder=0  noresize scrolling="no" style="height:7vh;width:100vw">
			<iframe name='BLApprStatusTrackQueryFrame' id='BLApprStatusTrackQueryFrame' src='../../eBL/jsp/BLApprStatusTrackQueryFrame.jsp?<%=params%>&validInsUser=<%=validInsUser%>&validFrontUser=<%=validFrontUser%>&apprvSts_AAKHYN=<%=apprvSts_AAKHYN%>' frameborder=0  noresize style="height:80vh;width:100vw"></iframe>	
			<iframe name='dummy' id='dummy'		src='../../eCommon/html/blank.html' frameborder=0 noresize  style="height:5vh;width:100vw"></iframe>
			<iframe name='dummyFrame' id='dummyFrame'		src='../../eCommon/html/blank.html' frameborder=0 noresize  style="height:5vh;width:100vw"></iframe>
			<iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style="height:5vh;width:100vw"></iframe>	  
	<%}else{%>
	<script>
		alert(getMessage('BL0968','BLEXT'));
		//alert("Privilege is not provided for Login User. Cannot Proceed");
		document.location.href='../../eCommon/jsp/dmenu.jsp';
	</script>
	<% } %>
</HTML>

