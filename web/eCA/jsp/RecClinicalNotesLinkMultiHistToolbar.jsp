<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

	<%
		request.setCharacterEncoding("UTF-8");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

		//patient_id			=	(request.getParameter("patient_id")==null)	?	""	:	request.getParameter("patient_id");

	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesLinkRep.js'></script>
	<script language='javascript' src='../../eCA/js/RecClinicalNotesPart1.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function returnDataSel()
	{
	
		//var returnValue='';
		var count='';
		if(parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm!=null)
			{	count=parseInt(parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.count.value);
		//returnValue=parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.return_str.value ;
		
		//if(returnValue=='')
		if(count==0)
		  alert(getMessage("MIN_ONE_ITEM_SEL_REQ","CA"));
		else
		{		
		  parent.window.returnValue ="Y";
		  parent.window.close();
	    }
			}
	}
	function winClose()
	{
		
		if(parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm)
		{
			parent.window.returnValue ="Y";
		}
		else
		{
			parent.window.returnValue ="N";
		}
			
		/*	var patient_id = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.patient_id.value;
			var encounter_id = parent.RecClinicalNotesLinkMultiHistDetFrame.document.RecClinicalNotesLinkMultiHistDetForm.encounter_id.value;
			
			
			var mode ="removeAll";
			var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/IeStyle.css' type='text/css' /></HEAD><BODY CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='RecClinicalNotesLinkMultiHistIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"&mode="+mode+"'></form></BODY></HTML>";
			//	+"&sec_hdg_code="+sec_hdg_code+"&child_sec_hdg_code="+child_sec_hdg_code +"&histdatatype="+histdatatype+"&Histrectype="+histrectype+"&Contrsysid="+contr_sys_id+"&Contrsyseventcode="+contr_sys_event_code+"&Accessionnum="+encodeURIComponent(accessionnum,"UTF-8")+"&result_disp="+result_disp+"&hist_rec_type_desc="+hist_rec_type_desc+"&event_date_time="+event_date_time+"&mode="+mode+"
			parent.messageFrame.document.write(HTMLVal);
			parent.messageFrame.document.forms[0].submit();
		
		} */
		//parent.window.returnValue ="Y";
		parent.window.close();

	}
	
	</script>
	
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()"  class='CONTENT' >
	<center>
	<form name='RecClinicalNotesLinkMultiHistToolbarForm' id='RecClinicalNotesLinkMultiHistToolbarForm'  method=post>
	<p align='left'>
		<table border='0' cellpadding='3' cellspacing='0' width='100%' height='100%' align='center'>
		<tr>
		<td align='right'>
			<input type='BUTTON' class='BUTTON' name='select' id='select' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")%>' onClick="returnDataSel();" >
			<input type='BUTTON' class='BUTTON' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>' onClick='winClose();' >
		</td>
		</tr>
		</table>
	</p>
	</form>
	</center>
</body>
</html>

