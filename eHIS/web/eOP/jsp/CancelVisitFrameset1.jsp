<!DOCTYPE html>
<!-- 	Function Name Cancel Visit
	Created by M.Sathis Kumar on 28/02/2000 -->

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
    <meta http-equiv="Expires" content="0">
    <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
    <Script src="../js/CancelVisit.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <%
      String facility_id      = (String) session.getValue("facility_id");
    %>
    <script>
	function canvisit()
	{
	    var retVal =  new String();
	    var encounter_id = "";
	    var queue_date	 = "";
		var queue_date1 ="";
		var patientid	="";
		var patientid1 ="";
	    var dialogHeight= "40vh" ;
	    var dialogWidth = "70vw" ;
	    var dialogTop = "0";
	    var features  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
	    var arguments = "";
	    retVal = await window.showModalDialog("../../eOP/jsp/PaintSearchVisit.jsp?p_mode=CANCELVISIT",arguments,features);
		
	    if (retVal=="" || retVal == null)
	    	parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
	    else
	    {
	    	/*encounter_id    = retVal.substring(0,retVal.indexOf("|"));
            queue_date  = retVal.substring(retVal.indexOf("|")+1);
			queue_date=queue_date.substring(0,queue_date.indexOf("|"));
			patientid=retVal.substring(retVal.lastIndexOf("|")+1);*/

			encounter_id    = retVal.substring(0,retVal.indexOf("|"));

            queue_date1  = retVal.substring(retVal.indexOf("|")+1);
			queue_date=queue_date1.substring(0,queue_date1.indexOf("|"));
			patientid1=queue_date1.substring(queue_date1.indexOf("|")+1);
            patientid=patientid1.substring(0,patientid1.indexOf("|"));
			

			document.write("<iframe name='PatientLine' id='PatientLine' src='../../eCommon/jsp/pline.jsp?EncounterId="+encounter_id+"&Facility_Id=<%=facility_id%>' frameborder=no scrolling='no' noresize style='height:10%;width:100vw'></iframe>"+
				"<iframe name='CancelVisitFrame2' id='CancelVisitFrame2' src='../../eOP/jsp/CancelVisitFrame2.jsp?<%=request.getQueryString()%>&encounter_id="+encounter_id+"&queue_date="+queue_date+"' frameborder=no scrolling='no' noresize style='height:90%;width:100vw'></iframe>"+
				"");
	    }
	}
    canvisit();	
    </script>
    </head>
</html>

