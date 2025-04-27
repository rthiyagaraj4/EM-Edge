<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType=" text/html;charset=UTF-8" %>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>

<%
	Connection con=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql = "";
	String tooth_num = "";

	String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
	String permanent_deciduous_flag = checkForNull(request.getParameter("permanent_deciduous_flag"));
	String site = checkForNull(request.getParameter("site"));
	String arch_quad = checkForNull(request.getParameter("arch_quad"));

%>
<html>
<head>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function setValuesForFromMenu(){
		populateSiteOptions();
		//document.forms[0].oh_site.value = "QUAD";
		document.forms[0].oh_site.value = '<%=site%>';
		getAreaLegend(document.forms[0].oh_site);
		populateArea(document.forms[0].oh_site);
		if(document.forms[0].oh_site.value == "QUAD"){
			document.forms[0].oh_area.value = '<%=arch_quad%>';
		}
	} 
	function clear_list(obj){
		while(obj.options.length > 0){
			obj.remove(obj.options[0]);
		}
	}

	function populateSiteOptions(){
		clear_list(document.forms[0].oh_site); 
		optSel	= document.createElement("OPTION");
		optSel.text = "key='eOH.DefaultSelect.Label' bundle='${oh_labels}'";
		optSel.value= ''; 
		document.forms[0].oh_site.add(optSel);
		optQuad	= document.createElement("OPTION");
		optQuad.text = '<fmt:message key="eOH.Quadrant.Label" bundle="${oh_labels}"/>';
		optQuad.value= 'QUAD'; 
		document.forms[0].oh_site.add(optQuad);
	}

	function getAreaLegend(obj){
		if(obj.value == "QUAD"){
			area_legend = '<fmt:message key="eOH.Quadrant.Label" bundle="${oh_labels}"/>';
			document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img src='../../eCommon/images/mandatory.gif'>"
		}
		else{
			area_legend = '<fmt:message key="Common.area.label" bundle="${common_labels}"/>';
			document.getElementById("area_field").innerHTML ="<select name='oh_area' id='oh_area' onChange='populateSurfaces(this);'><option value=''><fmt:message key='eOH.DefaultSelect.Label' bundle='${oh_labels}'/></option></select><img src='../../eCommon/images/mandatory.gif'>"
		}
		document.getElementById("change_area").innerHTML = area_legend;
}

function populateArea(obj){
	if(obj.value != "THRNG"){
		clear_list(document.forms[0].oh_area); 
		optSel	= document.createElement("OPTION");
		optSel.text = '<fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/>';
		optSel.value= ''; 
		document.forms[0].oh_area.add(optSel);
		var site_type_val = obj.value;
		var tooth_numbering_system = '<%=tooth_numbering_system%>'
		var permanent_deciduous_flag = '<%=permanent_deciduous_flag%>'

		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "site_type_val="+site_type_val+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag="+permanent_deciduous_flag;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","CommonValidation.jsp?func_mode=populateArea&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);

		if(retVal.length>1){
			var retVal_arr = retVal.split("~");
			for(var i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				var element 	= document.createElement('OPTION') ;
				element.value 	= code_desc_arr[0];
				element.text 	= code_desc_arr[1] ;
				document.forms[0].oh_area.add(element);
			}
		}
	}
}

</script>
</head>
<body onload="setValuesForFromMenu();" OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
	<form name="OHPeriodontalConditionForm" id="OHPeriodontalConditionForm">
	<%
	try{
		con = ConnectionManager.getConnection(request);
	%>
		<table width= 95% cellpadding =4 cellspacing=0>
			<tr>
				<td align=left width=20% class='LABEL' nowrap><fmt:message key="Common.Site.label" bundle="${common_labels}"/></td>
				<td align="">
					<select name="oh_site" id="oh_site" onChange="getAreaLegend(this);populateArea(this);">
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td align=left width= 10% class='LABEL' nowrap id="change_area"></td>
				<td align="" id="area_field">
					
				</td>
				
			</tr>
			<tr>
				<td width= 20% class='LABEL' nowrap><fmt:message key="eOH.ConditionType.Label" bundle="${oh_labels}"/></td>
				<td>
					<select name="oh_condition_type" id="oh_condition_type">
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td align=left width= 10% class='LABEL' nowrap><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
				<td align="" colspan=3>
					<select name="oh_status" id="oh_status">
						<option value=""><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<option value="PL"><fmt:message key="eOH.Planned.Label" bundle="${oh_labels}"/></option>
						<option value="PE"><fmt:message key="Common.Performed.label" bundle="${common_labels}"/></option>
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
			</tr>
			<tr>
				<td align=left width= 20% nowrap class='LABEL' nowrap><fmt:message key="eOH.ToothNos.Label" bundle="${oh_labels}"/></td>
				<td align="">
					<select name="oh_tooth_number" id="oh_tooth_number">
						<option value=''><fmt:message key="eOH.DefaultSelect.Label" bundle="${oh_labels}"/></option>
						<%
							//sql="SELECT B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE PERMANENT_DECIDUOUS = ? AND DECODE(?,'UNI',B.UNIVERSAL_QUADRANT, B.FDI_QUADRANT) = ?";
							sql="SELECT B.NS_TOOTH_NO TOOTH_NUM FROM OH_TOOTH A, OH_TOOTH_BY_NUMBERING_SYSTEM B WHERE A.TOOTH_NO = B.TOOTH_NO AND A.PERMANENT_DECIDUOUS = ? AND B.NUMBERING_SYSTEM = ? AND B.NS_QUADRANT = ?";
							pstmt=con.prepareStatement(sql);
							pstmt.setString(1,permanent_deciduous_flag);
							pstmt.setString(2,tooth_numbering_system);
							pstmt.setString(3,arch_quad);

							rs=pstmt.executeQuery();
							while(rs.next()){
								tooth_num = rs.getString("TOOTH_NUM");							
								out.println("<option value='" +tooth_num+ "'>" +tooth_num+ "</option>");								
							}
						%>
						
				 
					</select>
					<img src='../../eCommon/images/mandatory.gif'>
				</td>
				<td align="right">
					<input type="button" name="save" id="save" value="SAVE">
				</td>
				<td>
					<input type="button" name="reset" id="reset" value="RESET">
				</td>
			</tr>
		</table>
	</form>
</html>
<%
}catch ( Exception e ) {
	e.printStackTrace() ;
}finally {
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con!=null) 
			ConnectionManager.returnConnection(con,request);
	   }catch(Exception es){es.printStackTrace();}
}
%>

