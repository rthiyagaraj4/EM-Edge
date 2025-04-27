<!DOCTYPE html>
<%@ page import ="java.util.Date,java.text.SimpleDateFormat,java.text.ParseException,java.sql.Connection,java.sql.Timestamp,java.sql.PreparedStatement,java.sql.ResultSet,java.util.ArrayList,webbeans.eCommon.ConnectionManager,eOR.OrderEntryBillingQueryBean,eOR.*" contentType=" text/html;charset=UTF-8" %>
<% 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eOH/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	

	Connection con=null;

	PreparedStatement pstmt=null;
	ResultSet rs=null;
	
	String facility_id = (String)session.getValue("facility_id") ;
	String patient_id = request.getParameter( "patient_id" ) ;
	String chart_num = request.getParameter( "chart_num" ) ;
	String oh_chart_level = request.getParameter( "oh_chart_level" ) ;					    
	String other_chart_facility_id = request.getParameter( "other_chart_facility_id" ) ;
	String pontic_tooth = request.getParameter( "pontic_tooth" ) ;
	String numbering_system = request.getParameter( "numbering_system" ) ;

	String title_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOH.PonticToothDtls.Label","oh_labels");  
	String tooth_no = request.getParameter( "tooth_no" ) ;

	String[] pontic_tooth_arr = null;
	String pontic_tooth_val = "";
	String pontic_tooth_checked = "";
	String pontic_tooth_disabled = "";

	String pontic_tooth_val_display = "";

	pontic_tooth_arr = 	pontic_tooth.split(",");
	
			
	if (other_chart_facility_id.equals("")||other_chart_facility_id.equals("null")||other_chart_facility_id.equals(null)){
		other_chart_facility_id=facility_id;
	}

	try{
		con = ConnectionManager.getConnection(request);
%>
	<html>
	<title><%=title_desc%></title>
		<head>
			<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
			<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
			<script language="javascript" src="../../eCommon/js/common.js"></script>
			<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
			<script language="javascript" src="../../eOH/js/OHCommon.js"></script>
			<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<script>
				function ponticToothValues(){
					
					
					var oRows = document.getElementById('pontic_table').getElementsByTagName('tr');
					var iRowCount = oRows.length;

					var oh_chart_level = document.forms[0].oh_chart_level.value;
					var other_chart_facility_id = document.forms[0].other_chart_facility_id.value;
					var patient_id = document.forms[0].patient_id.value;
					var chart_num = document.forms[0].chart_num.value;
					var tooth_no = document.forms[0].tooth_no.value;

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
					xmlHttp.send(xmlDoc);
					var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
					retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);

					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_pontic_tooth = "func_mode=getPonticCutToothValues&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&other_chart_facility_id="+other_chart_facility_id+"&oh_chart_level="+oh_chart_level+"&trmt_category_type=BRIDGE";
					
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_tooth,false);
					xmlHttp.send(xmlDoc);
					var retVal_bridge = trimString(xmlHttp.responseText); 
					retVal_bridge = localTrimString(retVal_bridge);
					if(retVal_bridge.length > 0){
					
						var retVal_pontic = retVal_bridge.split("##");
						var code_desc_arr = retVal_pontic[0].split("$$");
						
						if(code_desc_arr.length > 0){
							for(var k = 0;k <= code_desc_arr.length;k++){
								
								for(var i = 1; i < iRowCount; i++){
									if(code_desc_arr[k] == document.getElementById("pontic_tooth_val"+(i)).value){
										document.getElementById("pontic_tooth_check"+(i)).checked = true;
										document.getElementById("pontic_tooth_check"+(i)).disabled = true;
									}
								}
							}
						}
					}
				   
				}

				function changeLegend(){
					var oRows = document.getElementById('pontic_table').getElementsByTagName('tr');
					var iRowCount = oRows.length;
					var close_legend = getLabel("Common.close.label","common_labels");
					var save_legend = getLabel("Common.record.label","common_labels");
					var flag_legend = false;
					for(var k = 1; k < iRowCount; k++){
						if(document.getElementById("pontic_tooth_check"+(k)).checked && document.getElementById("pontic_tooth_check"+(k)).disabled){
							continue;
						}else{
							flag_legend = true;
							break;
						}
					}
					if(!flag_legend){
						document.getElementById("save_reset_button").innerHTML =  '<input type="button" class="button" id = "save_reset_button" name="save" id="save" align="center" value="'+close_legend+'" onclick ="window.close();">';
					}else{
						document.getElementById("save_reset_button").innerHTML =  '<input type="button" class="button" id = "save_reset_button" name="save" id="save" align="center" value="'+save_legend+'" onclick ="clearImage();">&nbsp;<input type="button" class="button" id = "save_reset_button" name="save" id="save" align="center" value="'+close_legend+'" onclick ="window.close();">';
					}
				}

				function setSeqCheckValue1(rowVal){
					var formObj = document.forms[0];
					var rowForward = rowVal;
					var j = 0;
					
					if(document.getElementById("pontic_tooth_check"+(rowVal)).checked){
						if((document.getElementById("pontic_tooth_check"+(--rowVal)) != null) && (!(document.getElementById("pontic_tooth_check"+(rowVal)).checked))) {
							alert(getMessage("APP-OH000167","OH"));
							document.getElementById("pontic_tooth_check"+(rowForward)).checked = false;
						}
					}
				}
				function setSeqCheckValue2(rowVal){
					var formObj = document.forms[0];
					var rowForward = rowVal;
					if(document.getElementById("pontic_tooth_check"+(++rowVal)) != null){
						if(!(document.getElementById("pontic_tooth_check"+(--rowVal)).checked)){
							if(document.getElementById("pontic_tooth_check"+(++rowVal)).checked){
								alert(getMessage("APP-OH000167","OH"));
								document.getElementById("pontic_tooth_check"+(rowForward)).checked = true;
							}
						}
							
					}
					
				}

				function clearImage(){
					var formObj = document.forms[0];
					var patient_id = formObj.patient_id.value;
					var chart_num = formObj.chart_num.value;
					var oh_chart_level = formObj.oh_chart_level.value;
					var other_chart_facility_id = formObj.other_chart_facility_id.value;
					var tooth_no = formObj.tooth_no.value;

					var pontic_tooth = new Array();
					var pontic_tooth_split_values = new Array();
					var l =0;
					var k =0;
					var oRows = document.getElementById('pontic_table').getElementsByTagName('tr');
					var iRowCount = oRows.length;
					var pontic_tooth_arr = formObj.pontic_tooth_arr;
					var tooth_nos_arr = new Array();
					var tooth_nos = "";
					var j = 0;
					for(i = 1; i < iRowCount; i++){
						//if(document.getElementById("pontic_tooth_check"+(i)).checked && (!document.getElementById("pontic_tooth_check"+(i)).disabled)){
						if(document.getElementById("pontic_tooth_check"+(i)).checked) {
							 tooth_nos_arr[j] =  document.getElementById("pontic_tooth_val"+(i)).value;
						}else{
							continue;
						}
						j++;
					}
					tooth_nos = tooth_nos_arr.join("$$");
				    
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params_bridge_extract = "func_mode=getTrmtCatCode&tooth_no="+tooth_no+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id;
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_bridge_extract,false);
					xmlHttp.send(xmlDoc);
					var retVal_bridge_extract = trimString(xmlHttp.responseText); 
					retVal_bridge_extract = localTrimString(retVal_bridge_extract);
					pontic_tooth = retVal_bridge_extract.split(",") ;
									
					if(tooth_no == (retVal_bridge_extract.substring(retVal_bridge_extract.lastIndexOf("$")+1,retVal_bridge_extract.length))){	// toothno == to the last number in the bridge 
						for(k = pontic_tooth.length-1;k >= 0;k--,l++){

							pontic_tooth_split_values[l] = pontic_tooth[k].substring((pontic_tooth[k].lastIndexOf("$")+1),pontic_tooth[k].length) ;

						} 
					}else{
						for(k = 0; k < pontic_tooth.length;k++,l++){
							pontic_tooth_split_values[l] = pontic_tooth[k].substring((pontic_tooth[k].lastIndexOf("$")+1),pontic_tooth[k].length) ;
						} 
					}
					for(var m =0; m < pontic_tooth_split_values.length; m++){
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params_pontic_update = "func_mode=getMaxChartLineNum&tooth_no="+pontic_tooth_split_values[m]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&trmt_category_type=BRIDGE";
						
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_update,false);
						xmlHttp.send(xmlDoc);
						var retVal_max_chart_line_num = trimString(xmlHttp.responseText); 
						retVal_max_chart_line_num = localTrimString(retVal_max_chart_line_num);
						
						var xmlDoc = "" ;
						var xmlHttp = new XMLHttpRequest();
						var params_pontic_bridge_update = "func_mode=updateCutPonticTooth&tooth_no="+pontic_tooth_split_values[m]+"&patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+retVal_max_chart_line_num+"&oh_chart_level="+oh_chart_level+"&other_chart_facility_id="+other_chart_facility_id+"&tooth_nos="+tooth_nos+"&trmt_category_type=BRIDGE";
						
						var xmlStr ="<root><SEARCH ";
						xmlStr +=" /></root>";
						xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
						xmlHttp.open("POST","DentalTrmtValidation.jsp?"+params_pontic_bridge_update,false);
						xmlHttp.send(xmlDoc);
						var retVal_pontic_bridge_tooth = trimString(xmlHttp.responseText); 
						retVal_pontic_bridge_tooth = localTrimString(retVal_pontic_bridge_tooth);
						
					}
					window.returnValue =  tooth_nos;
					window.close();
				}
				
				
			</script>
		</head>
		<body OnMouseDown='CodeArrest()' onKeyDown="lockKey()" onLoad="ponticToothValues();changeLegend();">
			<form name='PonticToothForm' id='PonticToothForm' method='post' action='' target='messageFrame'>
			<table id='pontic_table' align='center' cellpadding='2' cellspacing='0' border='1' width='106%' style='border:1px solid #666666'>
				<td width="10%" class="CAGROUPHEADING" align="center" nowrap><fmt:message key="eOH.ToothNo.Label" bundle="${oh_labels}"/></td>
				<td width="10%" class="CAGROUPHEADING" align="center" nowrap><fmt:message key="eOH.Select.Label" bundle="${oh_labels}"/></td>
			<%
				
				for(int i = 1; i< pontic_tooth_arr.length-1;i++){
					  pontic_tooth_val = pontic_tooth_arr[i];
					  if(i == 1){
						pontic_tooth_checked = "checked";
						pontic_tooth_disabled = "";

					  }else{
					  	pontic_tooth_checked = "";
					  }
					  //Added by Sharon Crasta on 3/8/2010 for IN019851
					  pstmt = con.prepareStatement("SELECT NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM  WHERE NUMBERING_SYSTEM = ? AND TOOTH_NO = ?");
					  pstmt.setString(1,numbering_system);
					  pstmt.setString(2,pontic_tooth_arr[i]);
					  rs = pstmt.executeQuery();
					  while(rs!= null && rs.next()){
						pontic_tooth_val_display = checkForNull(rs.getString("NS_TOOTH_NO"));
					  
			%>
					<tr><td width="25%" class="field" align="center" nowrap><%=pontic_tooth_val_display%></td>
					<input type="hidden" id="pontic_tooth_val<%=i%>" value="<%=pontic_tooth_val%>" > 
					<td width="25%" align="center"><input type="checkbox" id="pontic_tooth_check<%=i%>"  onClick="setSeqCheckValue1('<%=i%>');setSeqCheckValue2('<%=i%>');" <%=pontic_tooth_checked%> <%=pontic_tooth_disabled%> /></td></tr>
			<%
					  }	//End
				} 
			%>
				
			</table>
			<br></br>
		   <table width='106%'>
			    <tr>
				   	<td class="button" colspan = "4" align="center" id="save_reset_button">
				</tr>
			</table>
			
			<input type="hidden" name='pontic_tooth_arr' id='pontic_tooth_arr' value="<%=pontic_tooth_arr%>" >
			<input type="hidden" name='title_desc' id='title_desc' value="<%=title_desc%>" >
			<input type="hidden" name='patient_id' id='patient_id' value="<%=patient_id%>" >
			<input type="hidden" name='chart_num' id='chart_num' value="<%=chart_num%>" >
			<input type="hidden" name='oh_chart_level' id='oh_chart_level' value="<%=oh_chart_level%>" >
			<input type="hidden" name='other_chart_facility_id' id='other_chart_facility_id' value="<%=other_chart_facility_id%>" >
			<input type="hidden" name='tooth_no' id='tooth_no' value="<%=tooth_no%>" >
			<input type="hidden" name='numbering_system' id='numbering_system' value="<%=numbering_system%>" >
			</form>
		</body>
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

