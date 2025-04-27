<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>

<html>
<head>
    <meta http-equiv="Expires" content="0">
   <!--  <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
    <Script src="../../eOP/js/CancelVisit.js" language="JavaScript"></Script>
	<Script src="../../eOP/js/ReviseVisit.js" language="JavaScript"></Script>
    <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
      String facility_id      = (String) session.getValue("facility_id");
%>
    <script>
	async function revist()
	{
        var retVal  =  new String();
        var encounter_id = "";
        var queue_date   = "";
		var queue_date1="";
		var patientid    ="";
		var patientid1="";
		
		var QStatus="";
		var ArriveDTime="";
		var QStatus1="";
		var ArriveDTime1="";
		var VitalDTime="";
		var VitalDTime1="";
		var queue_num="";

        var dialogHeight = "42vh" ;
        var dialogWidth  = "70vw" ;
        var dialogTop    = "0";
        var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
        var arguments    = "";
        retVal = await window.showModalDialog("../../eOP/jsp/PaintSearchVisit.jsp?p_mode=REVISEVISIT",arguments,features);
        
		if (retVal=="" || retVal == null)
            parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
        else
        {
            encounter_id    = retVal.substring(0,retVal.indexOf("|"));

            queue_date1  = retVal.substring(retVal.indexOf("|")+1);
			queue_date=queue_date1.substring(0,queue_date1.indexOf("|"));
			patientid1=queue_date1.substring(queue_date1.indexOf("|")+1);
            patientid=patientid1.substring(0,patientid1.indexOf("|"));
			QStatus1=patientid1.substring(patientid1.indexOf("|")+1);
			QStatus=QStatus1.substring(0,QStatus1.indexOf("|"));
			ArriveDTime1=QStatus1.substring(QStatus1.indexOf("|")+1);
			ArriveDTime=ArriveDTime1.substring(0,ArriveDTime1.indexOf("|"));
			VitalDTime1=ArriveDTime1.substring(ArriveDTime1.indexOf("|")+1);
			VitalDTime=VitalDTime1.substring(0,VitalDTime1.indexOf("|"));
			queue_num=VitalDTime1.substring(VitalDTime1.lastIndexOf("|")+1);
            
			document.write("<iframe name='PatientLine' id='PatientLine' src='../../eCommon/jsp/pline.jsp?P_MODULE_ID=OP&P_FUNCTION_ID=REVISE_VISIT&EncounterId="+encounter_id+"&Facility_Id=<%=facility_id%>' frameborder=no scrolling='no' noresize style='height:10vh;width:100vw'></iframe>"+
                       "<iframe name='ReviseVisitFrame2' id='ReviseVisitFrame2' src='../../eOP/jsp/ReviseVisitMain.jsp?encounter_id="+encounter_id+"&queue_date="+queue_date+"&Patient="+patientid+"&QStatus="+QStatus+"&ArriveDTime="+ArriveDTime+"&VitalDTime="+VitalDTime+"&queue_num="+queue_num+"' frameborder=no scrolling='no' noresize style='height:90vh;width:100vw'></iframe>"+
                   ""
                   );
         }
}		 
     revist();   
    </script>
   </head>
   </html>

