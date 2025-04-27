<!DOCTYPE html>
<%@ page import ="java.sql.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
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
    <Script src="../js/CancelVisit.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <%
	  request.setCharacterEncoding("UTF-8");
	  request= new XSSRequestWrapper(request);
	  response.addHeader("X-XSS-Protection", "1; mode=block");
	  response.addHeader("X-Content-Type-Options", "nosniff");
	  
      String facility_id       = (String) session.getValue("facility_id");
      String module_id		   = request.getParameter("module_id");
	  String oper_stn_id       = request.getParameter("oper_stn_id");
    %>
    <script>
	async function AECancelVisitfn(){
	    var retVal =  new String();
	    var encounter_id = "";
	    var queue_date	 = "";
		var patientid	="";
	    var dialogHeight= "70vh" ;
	    var dialogWidth = "50vw" ;
	    var dialogTop = "58";
	    var features  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
	    var arguments = "";
	    retVal = await window.showModalDialog("../../eAE/jsp/AEPaintSearchVisit.jsp?p_mode=CANCELVISIT&module_id=<%=module_id%>&oper_stn_id=<%=oper_stn_id%>",arguments,features);
		
	    if (retVal=="" || retVal == null)
	    	parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
	    else
	    {
			encounter_id    = retVal.substring(0,retVal.indexOf("|"));
            queue_date  = retVal.substring(retVal.indexOf("|")+1);
			queue_date=queue_date.substring(0,queue_date.indexOf("|"));
			patientid=retVal.substring(retVal.lastIndexOf("|")+1);
			document.write("<iframe name='PatientLine' id='PatientLine' src='../../eCommon/jsp/pline.jsp?EncounterId="+encounter_id+"&Facility_Id=<%=facility_id%>' frameborder=no scrolling='no' noresize style='height:10vh;width:100vw'></iframe>"+
			"<iframe name='CancelVisitFrame2' id='CancelVisitFrame2' src='../../eOP/jsp/CancelVisitFrame2.jsp?<%=request.getQueryString()%>&encounter_id="+encounter_id+"&queue_date="+queue_date+"' frameborder=no scrolling='no' noresize style='height:90vh;width:100vw'></iframe>"+
			"");
	    }		

	}
	 AECancelVisitfn();
    </script>
    </head>
</html>

