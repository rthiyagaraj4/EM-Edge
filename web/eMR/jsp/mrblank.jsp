<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,eCommon.XSSRequestWrapper" %>

<%
	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 String f_name= request.getParameter("step_1");
//	 String facility_id      = (String) session.getValue("facility_id");
	 String func=request.getParameter("func");
%>
 
	
<html>
<head>
<%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<script>
function reset()
{
}
async function aa()
{
 if ('<%=f_name%>' == '1')
 {
	var pat_id = await PatientSearch();
	if (pat_id != null)
		parent.f_query_add_mod.document.location.href='../../eMR/jsp/RecordPatAllergyMain.jsp?Patient_Id='+pat_id;	
	else
	        parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
 }
 if('<%=f_name%>' == '2')
  {
    	var pat_id = await PatientSearch();
 	if (pat_id != null)
		parent.f_query_add_mod.document.location.href='../../eMR/jsp/RecordPatHighRiskMain.jsp?Patient_Id='+pat_id;	
	else
	        parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
 }
 if('<%=f_name%>'=='3')
 {
            var retVal =  new String();
	    var encounter_id = "";
	   // var queue_date	 = "";
	    var dialogHeight= "33.8vh" ;
	    var dialogWidth = "50vw" ;
	    var dialogTop = "58";
	    var features  = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;"+"dialogTop:" + dialogTop ;
	    var arguments = "";
	    retVal =await window.showModalDialog("../../op/jsp/PaintSearchVisit.jsp?p_mode=",arguments,features);

	    if (retVal=="" || retVal == null)
	    	parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
	    else
	    {
	    	encounter_id 	= retVal.substring(0,retVal.indexOf("|"));
	    	queue_date 	= retVal.substring(retVal.indexOf("|")+1);
	    	if('<%=func%>'=='PatProb')
			parent.f_query_add_mod.document.location.href='../../eMR/jsp/RecordPatProblemMain.jsp?patient_type=O&encounterid='+encounter_id+'&queuedate='+queue_date;
		if('<%=func%>'=='PatProc')	
		        parent.f_query_add_mod.document.location.href='../../eMR/jsp/RecordPatProcedureMain.jsp?&encounterid='+encounter_id;
	    }			

      }
      if('<%=f_name%>' == '4')
      {
            var pat_id= await PatientSearch();
            if(pat_id != null)
            	parent.f_query_add_mod.document.location.href='../../eMR/jsp/patprobquerymain.jsp?Patient_Id='+pat_id;
            else
	        parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";	
           
     } 
     if('<%=f_name%>' == '5')
     {
            var pat_id= await PatientSearch();
            // console.log(pat_id) ;
            if(pat_id != null)
            {
			parent.patLine.document.location.href='../../eCommon/jsp/pline.jsp?Patient_Id='+pat_id;
            parent.f_query_add_mod.document.location.href='../../eMR/jsp/AddModifyPatBloodGroup.jsp?P_Patient_Id='+pat_id;
            }
            else
	        parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
                
     } 
     if('<%=f_name%>' == '6')
     {
      	var pat_id=await PatientSearch('','','','','','','Y','','','VIEW');
        if(pat_id != null)
                parent.f_query_add_mod.document.location.href='../../eMR/jsp/vwPatFileDetailmain.jsp?Patient_Id='+pat_id;
        else
	        parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
     }    
  	 if('<%=f_name%>' == '7')
	 {
		
		var pat_id= await PatientSearch('','','','','','','','','','CHG_PAT_DTLS');
		 if(pat_id != null)
		 {
			//parent.f_query_add_mod.document.location.href='../../servlet/eMR.PatientFileServlet?Patient_Id='+pat_id+'&operation=create_file_no';
			
			parent.f_query_add_mod.document.location.href='../../eMR/jsp/PatientFile.jsp?Patient_Id='+pat_id;
			parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
		}	
			//parent.f_query_add_mod.document.location.href='/eCIS/servlet/mr.test';
		 else
			parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
 	 }    
     if('<%=f_name%>' == '8')
	 {
		
		var pat_id=await PatientSearch();
		 if(pat_id != null)
			parent.f_query_add_mod.document.location.href='../../eMR/jsp/RecordMajorMedicalEvents.jsp?Patient_Id='+pat_id;
			else
			parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
 	 
	 }    
	      if('<%=f_name%>' == '9')
	 {
		var pat_id=await PatientSearch();
		 if(pat_id != null)
			parent.f_query_add_mod.document.location.href='../../eMR/jsp/RecordOtherMedicalInfo.jsp?Patient_Id='+pat_id;
			 else
			parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
 	 }    
	       if('<%=f_name%>' == '10')
	 {
		var pat_id=await PatientSearch();
		 if(pat_id != null)
			parent.f_query_add_mod.document.location.href='../../eMR/jsp/vwActiveProblemsmain.jsp?Patient_Id='+pat_id;
			 else
			parent.window.location.href = "../../eCommon/jsp/dmenu.jsp";
 	 }

}
</script>

<body class="CONTENT" onLoad='aa()' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
</body>
</html>

