<!DOCTYPE html>
<!--
   
   Developed By : Venkatesh.S
   Date         : 28-Nov-2013    
   Against      : Bru-HIMS-CRF-348 [IN038247] 
 
 -->
<HTML>
<HEAD>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eMO/js/MOEmbalmRegistration.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
 <%      webbeans.op.PatientData patdata = new  webbeans.op.PatientData();
         String url 					 = "../../eCommon/jsp/commonToolbar.jsp?" ;
		 String params 					 = request.getQueryString() ;
    	 String source 					 = url + params ;
		 String Patient_ID				 = request.getParameter("Patient_ID")==null?"":request.getParameter("Patient_ID");
		 String srl_no 					 = request.getParameter("srl_no")==null?"":request.getParameter("srl_no");
		 String app_id  				 = request.getParameter("app_id")==null?"":request.getParameter("app_id");
		 String mode  				     = request.getParameter("mode")==null?"":request.getParameter("mode");
		 Connection  con 				 = null;
	     con							 = ConnectionManager.getConnection(request);	
         String facilityid 				 = (String) session.getValue("facility_id");	
         String pat_status				 = "";		 
         patdata.setFacility_id(facilityid);
		 
         pat_status 						 = patdata.CheckStatus(con,Patient_ID);
	     
		  if(con!=null) ConnectionManager.returnConnection(con,request);  
      
		  
 %>
 <%if(pat_status.equals("DECEASED")){%>
<frameset rows='7,80' >		
     <frame name='pline' id='pline' src="../../eCommon/jsp/pline.jsp?Patient_ID=<%=Patient_ID%>" frameborder=0 noresize scrolling="no" > 
	<frame name='embalm_details_frame' id='embalm_details_frame'   src="../../eMO/jsp/addModifyEmbalmReg.jsp?<%=request.getQueryString()%>"   frameborder=no marginheight=0 marginwidth=0 scrolling=auto >
	 
	<%}else{%>
	  <script>
	      var pat_status ='<%=pat_status%>'
		     if(pat_status=='INVALID_PATIENT'){
	        var msg = getMessage("INVALID_PATIENT","MP");
	        alert(msg);
			 parent.frames[0].location.reload(); 
			} else{ 
			 //getMessage("ENTER_DECEASED","MO")
			alert(getMessage("ENTER_DECEASED","MO"));
			parent.embalm_criteria.location.reload();
			}
	   </script>
	 <%}%>
</HTML>

