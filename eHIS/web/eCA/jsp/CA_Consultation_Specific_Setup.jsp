<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head> 
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String license_rights = "";
if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
{
	license_rights= "FULL";
}
else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
{
	license_rights= "BASIC";
}
else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
{
	license_rights= "MINI";
}

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'> </script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  

	<style>
		A:active{ 
			COLOR: white; 
		}
	</style>
	
	<script>
		var temparr = new Array();
		var count = 0;
		var prev=1;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){				
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/
	
		    if(val == 'SpltyForConsultation'){						
				parent.frames[1].location.href = '../../eCA/jsp/CASpltyForConsultation.jsp?module_id=CA&function_id=SpltyForConsultation&function_name='+encodeURIComponent(getLabel("eCA.SpltyForConsultOrderable.label","CA"))+'&function_type=F&access=YYNNN';
			}
			if(val == 'PractForConsultation'){
				parent.frames[1].location.href = '../../eCA/jsp/CAPractForConsultation.jsp?module_id=CA&function_id=PractForConsultation&function_name='+encodeURIComponent(getLabel("eCA.PractForConsultOrderable.label","CA"))+'&function_type=F&access=YYNNN';
			}
			  if(val == 'ConsultationParam'){
				parent.frames[1].location.href = '../../eCA/jsp/CAConsultationParam.jsp?module_id=CA&function_id=ConsultationParam&function_name='+encodeURIComponent(getLabel("eCA.ConsultationParam.label","CA"))+'&function_type=F&access=NYNNN';
			}		  						

}	

	</script>

	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" style="background-color:dimgray;">
	<form name="CA_Consultation_MasterMenu_form" id="CA_Consultation_MasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
 		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.ConsultationSetup.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SpltyForConsultation')"><fmt:message key="eCA.SpltyForConsultOrderable.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('PractForConsultation')"><fmt:message key="eCA.PractForConsultOrderable.label" bundle="${ca_labels}"/></td>
		</tr>		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('ConsultationParam')"><fmt:message key="eCA.ConsultationParam.label" bundle="${ca_labels}"/></td>
		</tr>			
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

	</table>

	</body>
	</form>
</html>

