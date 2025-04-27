<!DOCTYPE html>
<%@ page import= "java.text.*,java.sql.Types,java.sql.Statement,java.sql.CallableStatement,java.sql.Connection,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>
<html>
	<head>
<% String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language=JavaScript src="../../eCommon/js/menu.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>

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
		function chcol(ro){      
			document.getElementById("t").rows(prev).cells(0).className=prevcol
			prevcol=ro.cells(0).className
			ro.cells(0).className="MENUSELECTEDCOLOR"
			prev=ro.rowIndex;				
		}

		function callJSPs(val){
			var setupparametersforfacility_function_name = encodeURIComponent(getLabel("eOT.SetupParametersForFacility.Label","OT"));

			var formObj = document.forms[0];
			var ca_module_yn = formObj.ca_module_yn.value;
			if(val == 'SetUpParameterforFacility'){
				parent.frames[1].location.href = '../../eOH/jsp/OHParameterForFacility.jsp?module_id=OH&function_id=OHParametersforFacility&function_name='+setupparametersforfacility_function_name+'&function_type=F&access=NYNNN';
			}
			/*
			if(val == 'BuildHistory'){
				parent.frames[1].location.href = '../../eOH/jsp/OHHistTemp.jsp?module_id=OH&function_id=OHParametersforFacility&function_name='+setupparametersforfacility_function_name+'&function_type=F&access=NYNNN';
			}	
			*/
	}
	
	</script>
	</head>
<% 
	String expand=request.getParameter("expand");
	if( expand == null) 
		expand="CCCC";
	String facility_id  = (String) session.getValue("facility_id");

	Connection con=null;
	CallableStatement cstmt = null;
	String modules_list = "";
	String ca_module_yn="";

	try{
		con = ConnectionManager.getConnection(request);
	// Check for CA Module Existence
		cstmt=con.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
	}catch(Exception e){
		out.println(e);
	}finally { 
		if(cstmt !=null) cstmt.close();
		ConnectionManager.returnConnection(con,request);
	}

%>

	<body style="background-color:dimgray;"  OnMouseDown='CodeArrest()' onKeyDown="lockKey()" >
	<form name="OTAdminMasterMenu_form" id="OTAdminMasterMenu_form">
	<input type="hidden" name='menu_values' id='menu_values'>
	<input type="hidden" name='ca_module_yn' id='ca_module_yn' value="<%=ca_module_yn%>">
	
	<table cellspacing=1 cellpadding=3  width='100%' border=0 id='t'>		
	<tr>
		<td class='CAGROUP' ><b><fmt:message key="Common.setup.label" bundle="${common_labels}"/></b></td>
	</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('SetUpParameterforFacility')">
				<fmt:message key="eOT.SetupParametersForFacility.Label" bundle="${ot_labels}"/> 
			</td
		</tr>
		<tr onclick='chcol(this)'>
			<td  class='MENUSUBLEVELCOLOR' onClick="javascript:callJSPs('BuildHistory')">
Build History
			</td>
		</tr>
	<tr onclick='chcol(this)'>
	<tr>
		<td class='ECMENUHIGHERLEVELCOLOR' ><a href=javascript:goHomePage() style='color:white;'><b>
			<fmt:message key="Common.menu.label" bundle="${common_labels}"/></b></a>
		</td>
	</tr>
	</table>

	</body>
	</form>
</html>

