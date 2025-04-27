<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" language="java" import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.*,java.util.*"%>
<html>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var temparr = new Array();
		var count = 0;
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		var sec_hdg_cd=new Array();
		var logic_seq_no=new Array();

		function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			/*
					Access is in the order - insertaccess,updateaccess,queryaccess,deleteaccess,printaccess
			*/

			if (val=='Duration_Type'){
				parent.frames[1].location.href='DurationType.jsp?module_id=OR&function_id=DurationType&function_name='+encodeURIComponent(getLabel("Common.DurationType.label","common"))+'&function_type=f&access=NYNNN';
			
			}
			if (val=='Frequency'){
				parent.frames[1].location.href='Frequency.jsp?module_id=OR&function_id=Frequency&function_name='+encodeURIComponent(getLabel("Common.Frequency.label","common"))+'&function_type=f&access=YYYNN';
			
			}
			
			if (val=='Schedule_Frequency'){
				parent.frames[1].location.href='ScheduleFrequency.jsp?module_id=OR&function_id=Schedule_Frequency&function_name='+encodeURIComponent(getLabel("eAM.FrequencySchedule.label","am"))+'&function_type=f&access=YYYNN';
			
			}
			

	

		}



	async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		
		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body style="background-color:dimgray;" onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()" >
	<form name="MPMasterMenu_form" id="MPMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>

		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Duration_Type')"><fmt:message key="Common.DurationType.label" bundle="${common_labels}"/></td>
		</tr>
		
		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Frequency')"><fmt:message key="Common.Frequency.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onClick='chcol(this)'>
			<td class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Schedule_Frequency')"><fmt:message key="eAM.FrequencySchedule.label" bundle="${am_labels}"/></td>
		</tr>
		 <tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr> 

	</table>

	</body>
	</form>
</html>

