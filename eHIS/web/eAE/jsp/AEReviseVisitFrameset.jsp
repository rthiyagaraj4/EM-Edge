<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
    <meta http-equiv="Expires" content="0">
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
      request.setCharacterEncoding("UTF-8");
	  request= new XSSRequestWrapper(request);
	  response.addHeader("X-XSS-Protection", "1; mode=block");
	  response.addHeader("X-Content-Type-Options", "nosniff");

      String facility_id      = (String) session.getValue("facility_id");
	  String oper_stn_id      = request.getParameter("oper_stn_id");
  
	  String params="&../../eCommon/jsp/commonToolbar.jsp?module_id=AE&function_id=AE_REVISE_VISIT&function_name=Revise%20Attendance%20Details&function_type=F&menu_id=AE_TRANSACTIONS&access=NYYNN";
%>
    <script>
	
	async function setVal(){
        var retVal		 =  new String();
        var encounter_id = "";
        var queue_date   = "";
		var patient_id	 = "";
        var dialogHeight = "30vh" ;
        var dialogWidth  = "50vw" ;
        var dialogTop    = "58";
        var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
        var arguments    = "";
		
        retVal = await window.showModalDialog("../../eAE/jsp/AEPaintSearchVisit.jsp?p_mode=REVISEVISIT&oper_stn_id=<%=oper_stn_id%>",arguments,features);
		
    
        if (retVal=="" || retVal == null)
		{
            parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
		}
        else
        {
            encounter_id    = retVal.substring(0,retVal.indexOf("|"));
            patient_id		= retVal.substring(retVal.indexOf("|")+1);
            document.write("<iframe name='PatientLine' id='PatientLine' src='../../eCommon/jsp/pline.jsp?P_MODULE_ID=AE&P_FUNCTION_ID=AE_REVISE_VISIT&EncounterId="+encounter_id+"&Facility_Id=<%=facility_id%>' frameborder=no scrolling='no' noresize style='height:6vh;width:100vw'></iframe>"+
						  "<iframe name='ReviseVisitFrame2' id='ReviseVisitFrame2' src='../../eAE/jsp/ReviseVisitMain.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&patient_id="+patient_id+"&params=<%= java.net.URLEncoder.encode(params)%>' frameborder=no scrolling='no' noresize style='height:93vh;width:100vw'></iframe>"+
					   ""
                      );
        }  
	 }
	 setTimeout('setVal();',50)
    </script>
   </head></html>

