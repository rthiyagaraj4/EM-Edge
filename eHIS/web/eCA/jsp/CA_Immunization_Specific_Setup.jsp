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
	
		    if(val == 'Vaccine'){					
				parent.frames[1].location.href = '../../eCA/jsp/Vaccine.jsp?module_id=CC&function_id=Vaccine&function_name='+encodeURIComponent(getLabel("Common.Vaccine.label","COMMON"))+'&function_type=F&access=YYYNN';
			}
			if(val == 'SiteForVaccine'){
				parent.frames[1].location.href = '../../eCA/jsp/SitesForVaccine.jsp?module_id=CA&function_id=SiteForVaccine&function_name=Site For Vaccine&function_type=F&access=YYNNN';
			}
			  if(val == 'VaccineCategory'){
				parent.frames[1].location.href = '../../eCA/jsp/VaccineCategory.jsp?module_id=CA&function_id=VaccineCategory&function_name=Vaccine Category&function_type=F&access=YYYNN';
			}
			  if(val == 'VaccinesForCategory'){
				parent.frames[1].location.href = '../../eCA/jsp/VaccinesForCategory.jsp?module_id=CA&function_id=VaccinesForCategory&function_type=F&function_name=Vaccines For Category&access=YYNNN';
			}
			

}
	
	
		/**/

/*

function openwinnowin(mID,funName,fileName,str)
{
	var W = 400 ;
	var H = 100 ;	

	r = ",resizable=1"
	s = ",width="+W+",height="+H;

	var windowW = W;
	var windowH = H;
	var windowX = Math.ceil( (window.screen.width  - windowW) / 2 );
	var windowY = Math.ceil( (window.screen.height - windowH) / 2 );
	
	splashWin = window.open('','HelpWindow','fullscreen=1,toolbar=0,location=0,directories=0,status=0,menubar=0,scrollbars=no'+r+s)

	splashWin.resizeTo( Math.ceil( W )       , Math.ceil( H ) )
	splashWin.moveTo  ( Math.ceil( windowX ) , Math.ceil( windowY ) )

	splashWin.document.open("text/html", "replace");
	splashWin.document.write(str);
	splashWin.document.help_form.submit();
	splashWin.document.close();
	splashWin.focus();
	eval("HelpWindow"+"=splashWin")
}

*/

	async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		//retVal = window.showModalDialog('change_functionality.jsp',arguments,features);
		
		retVal	=await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}

	</script>

	</head>

	<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" style="background-color:dimgray;">
	<form name="CCMasterMenu_form" id="CCMasterMenu_form">
	<input type=hidden name='menu_values' id='menu_values'>
	<table cellspacing=1 cellpadding=2 width='100%' border=0 id='t'>
 		<tr>
            <td class='CAGROUP' ><b><fmt:message key="eCA.LOCATIONACCESS.label" bundle="${ca_labels}"/></b></td>
        </tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('Vaccine')"><fmt:message key="Common.Vaccine.label" bundle="${common_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SiteForVaccine')"><fmt:message key="eCA.SiteForVaccine.label" bundle="${ca_labels}"/></td>
		</tr>		
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('VaccineCategory')"><fmt:message key="eCA.VaccineCategory.label" bundle="${ca_labels}"/></td>
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('VaccinesForCategory')"><fmt:message key="eCA.VaccinesForCategory.label" bundle="${ca_labels}"/></td>
		</tr> 	

		<tr onclick='chcol(this)'>
		<tr>
			<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b><fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a></td>
		</tr>

	</table>

	</body>
	</form>
</html>

