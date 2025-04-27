<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
     request.setCharacterEncoding("UTF-8");
	 String f_name= request.getParameter("step_1");
	 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
<Script language='javascript' src='../../eCommon/js/showModalDialog.js'></Script>
<Script language='javascript' src='../../eCommon/js/common.js'></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eMP/js/PatientRegistration.js'></script>

</head>
<script>
async function aa()
{
    if ('<%=f_name%>' != '5')
    {   
		var pat_id;
		if ('<%=f_name%>' == '1')
		{
			pat_id = await PatientSearch('','','','','','','Y','','','SUSP');
		}
        else if ('<%=f_name%>' == '2')
			pat_id = await PatientSearch('','','','','','','Y','','','RECD');
		else if ('<%=f_name%>' == '7')
			pat_id = await PatientSearch('','','','','','','Y','','','ACTV');
		else if (('<%=f_name%>' == '6') || ('<%=f_name%>' == '3'))
			pat_id = await PatientSearch('','','','','','','Y','','','VIEW');
		else if (('<%=f_name%>' == '8'))
			pat_id = await PatientSearch('','','','','','','','','','CHG_PAT_DTLS');		
		else if (('<%=f_name%>' == '9'))
				query_search();
		else
			pat_id = await PatientSearch('','','','','','','Y','','','OTHER');
		
		if(pat_id && pat_id != null && pat_id != "")
        {
        
            if ('<%=f_name%>' == '1')
			{				
				parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;	parent.f_query_add_mod.document.location.href='../jsp/SuspendReinstatePatient.jsp?Patient_ID='+pat_id;  
			}

            else if ('<%=f_name%>' == '2')
			{
				parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;
				parent.f_query_add_mod.document.location.href='../../eMP/jsp/RecordRevokeDeath.jsp?Patient_ID='+pat_id;    
			}

            else if ('<%=f_name%>' == '3')
			{
		        //parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;	Friday, April 30, 2010 Venkat s PE_EXE		
				parent.f_query_add_mod.document.location.href='../../eMP/jsp/ViewPatDetailsMain.jsp?function_id=VIEW_PAT_DTLS&Patient_ID='+pat_id;   
			}

            else if ('<%=f_name%>' == '4')
			    parent.f_query_add_mod.document.location.href='../../eMP/jsp/repOnline.jsp?step=2&module_id=MP&patient_ID='+pat_id;    
            
            else if ('<%=f_name%>' == '6')
			{
				parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;
				parent.f_query_add_mod.document.location.href='../../eMP/jsp/ViewPatFamilyMembers1.jsp?Patient_ID='+pat_id;    
			}

            else if ('<%=f_name%>' == '7')
			{	
				parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;
				parent.f_query_add_mod.document.location.href='../../eMP/jsp/ActivateInactivatePatientMain.jsp?Patient_ID='+pat_id;    
			}            
            else if ('<%=f_name%>' == '8'){
				parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;	parent.f_query_add_mod.document.location.href='../jsp/ViewPatDetailsMain.jsp?function_id=CAPTUREPATPHOTO&Patient_ID='+pat_id;   
			}		
			else if ('<%=f_name%>' == '11'){
			    parent.f_query_add_mod.document.location.href='../../eMP/jsp/repPrintPatientLabel.jsp?step=2&module_id=MP&patient_ID='+pat_id;  
			}
			else if ('<%=f_name%>' == '12')
			{ 
				parent.f_query_add_mod.document.location.href='../../eMP/jsp/ChangeHomePhoneNumber.jsp?function_id=CHG_PAT_PHONE&Patient_ID='+pat_id;   
			}
			else if ('<%=f_name%>'=='13') // Added by lakshmanan for ML-MMOH-CRF-1955 US001 on 01-07-2023
			{
				parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;
				parent.f_query_add_mod.document.location.href='../../eMP/jsp/MarkPatientMLCNonMLC.jsp?Patient_ID='+pat_id;
				parent.resultFrame.document.location.href='../../eMR/jsp/vwEncounterDetailResult.jsp?patientid='+pat_id+'&order_by=PATIENT_CLASS&fid=MLC';
			}
			else if('<%=f_name%>' == '14') // Added by Ajay Hatwate for MMS-DM-CRF-0210.1
			{   
				parent.plineFrame.document.location.href='../../eCommon/jsp/pline.jsp?Patient_ID='+pat_id;
				parent.f_query_add_mod.document.location.href='../../eMP/jsp/RestrictReinstatePatientAddModify.jsp?function_id=RESTRICT_REINSTATE_PATIENT&Patient_ID='+pat_id;
			}
			
        }
		
    }
    else if ('<%=f_name%>' == '5')
    {
        var pat_id = await PatientSearch('','','','','','','','','','CHG_PAT_DTLS');
        if (pat_id != null)
        parent.f_query_add_mod.document.location.href='../../eMP/jsp/ChangePatientDetails.jsp?step=2&Patient_ID='+pat_id;  
    }
}   
</script>

<body class="CONTENT" onLoad='aa()' onKeyDown='lockKey();'>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
