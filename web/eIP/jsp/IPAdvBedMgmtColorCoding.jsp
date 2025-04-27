<!DOCTYPE html>
<!DOCTYPE>
<%@page import="eIP.advbedmgmt.common.resourcebundle.BundleManager"%>
<%@page import="eCommon.Common.CommonBean"%>
<%@page import="eIP.advbedmgmt.common.model.BedLegend"%>
<%@page import="java.util.List"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.response.BedLegendResponse"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.bc.BedLegendBC"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.BedLegendConstants"%>
<%@page import="eIP.advbedmgmt.common.model.BedStatusEnum"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="eIP.advbedmgmt.common.bedlegend.request.BedLegendRequest"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" import="java.io.*,java.sql.*,java.util.*,java.net.*,java.text.*,eMP.PatSearch.*,webbeans.eCommon.*, javax.naming.*,javax.ejb.*,java.rmi.*,javax.rmi.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=8" >
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtSetupStyle.css"/>
		<script src='../../eIP/js/IPAdvBedMgmtSetup.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<script type="text/javascript" src="../../eIP/html/JQuery/jquery-ui-1.8.21.custom.min.js"></script>
		<script type="text/javascript" src="../../eIP/html/JQuery/ColorCoding/jquery.layout-latest.js"></script>
		<script type="text/javascript" src="../../eIP/html/JQuery/ColorCoding/farbtastic.js"></script>
		<link rel="stylesheet" href="../../eIP/html/JQuery/ColorCoding/farbtastic.css" type="text/css" />
		
		<style type="text/css">			
			.colorpickerDiv{
				float:left;
				border:0px solid black;
			}
			.colorPickTextId{
				margin-left:10%;
				width:100%;
			}
			.TextId{
				width:100%;				
			}
			.colorPickId{
				top:80%;
				margin-left:10%;
				margin-top:10%;
				margin-top:10%;
			}	
		</style>
		<script type="text/javascript">
			$(document).ready(function () {
				$('body').layout({ applyDefaultStyles: true });
				$('#colorpicker').farbtastic('#color');
				$('.color_pick_bed').click(function (event){
					var $target = $(event.target); // the element that fired the original click event
					$('#color').val($(this).css('backgroundColor'));
					$('#color').focus();
					$('#color').trigger('keyup');
					$("input[id=selectedElem]").val($(this).attr('id'));
					var selectedElem = $('input[id=selectedElem]').val();
					var elementColor = $('#' + selectedElem + 'Text').css('color');
					if(elementColor =='white'){
						document.getElementById("textcolor").item[0].checked=true;
						//document.getElementById("textcolor").item(0).selected=true;
					}else if(elementColor =='black'){
						document.getElementById("textcolor").item[1].checked=true;
					}
					event.stopPropagation();
				});
				$('#room').click(function (event){
					var $target = $(event.target); // the element that fired the original click event
					$('#color').val($(this).css('backgroundColor'));
					$('#color').focus();
					$('#color').trigger('keyup');
					$("input[id=selectedElem]").val($(this).attr('id'));
					document.getElementById("textcolor").item[0].checked=false;
					document.getElementById("textcolor").item[1].checked=false;
					event.stopPropagation();
				});
			});
			function submitColorCoding(){

				
				if(($("#bedWidth").val()>=150 && $("#bedWidth").val()<=300) && ($("#bedHeight").val()>=90 && $("#bedHeight").val()<=200)){
					$.post("../../servlet/eIP.IPAdvBedMgmtSetupServlet",
						{ 
							operation: "colorCoding",
							bedDfltWidth:$("#bedWidth").val(),
							bedDfltHeight:$("#bedHeight").val(),
							room:$(".clrpick_clr_disp").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							admittedBed:$("#ADMITTED").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							admittedBedText:$("#ADMITTED_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							admissionInitiatedBed:$("#ADMISSION_INITIATED").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							admissionInitiatedBedText:$("#ADMISSION_INITIATED_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							abscondBed:$("#ABSCOND").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							abscondBedText:$("#ABSCOND_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							blockedBed:$("#BLOCKED").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							blockedBedText:$("#BLOCKED_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							blockedOverrideableBed:$("#BLOCKED_OVERRIDEABLE").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							blockedOverrideableBedText:$("#BLOCKED_OVERRIDEABLE_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							bookedBed:$("#BOOKED").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							bookedBedText:$("#BOOKED_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							dischargedBed:$("#DISCHARGED").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							dischargedBedText:$("#DISCHARGED_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							dischargeInitiatedBed:$("#DISCHARGE_INITIATED").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							dischargeInitiatedBedText:$("#DISCHARGE_INITIATED_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							infantBed:$("#INFANT").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							infantBedText:$("#INFANT_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							leaveBed:$("#LEAVE").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							leaveBedText:$("#LEAVE_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							transferOutBed:$("#TRANSFER_OUT").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							transferOutBedText:$("#TRANSFER_OUT_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							transferInitBed:$("#TRANSFER_INIT").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							transferInitBedText:$("#TRANSFER_INIT_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							vacantBed:$("#VACANT").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							vacantBedText:$("#VACANT_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							transferAcceptedBed:$("#TRANSFER_ACCEPTED").css('backgroundColor').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							}),
							transferAcceptedBedText:$("#TRANSFER_ACCEPTED_Text").css('color').replace(/^rgb\((\d+),\s*(\d+),\s*(\d+)\)$/, function(_, r, g, b) {
							    return [r, g, b].map(function(x) {
							        return ('0' + parseInt(x, 10).toString(16)).slice(-2);
							    }).join('');
							})
							
						},
						function(data, textStatus)
						{
							parent.blank.location.href="../../eIP/jsp/IPAdvBedMgmtCriteria.jsp";
							location.href = "../../eCommon/html/blank.html";
							//alert(data+'||'+textStatus);
							if(data.length > 0){
								parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("BED_DIM_SAVE_FAILURE","IP")+"&err_value=0";
							}else{
								parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_MODIFIED","SM")+"&err_value=0";	
							}
						}
						);
				}else{
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("BED_WIDTH_HEIGHT_RANGE","IP")+"&err_value=0";
				}
				return false;
			}
			
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<!--Below code was modified  on 08-JAN-2013 against [IN037130] -->
	<body id="bedMgmtColorBody" onKeyDown = "lockKey()" >
		<%
			Connection con	= null;
			PreparedStatement	pstmt	= null;
			ResultSet rSet	= null;
			String bedWidth="";
			String bedHeight="";
			try{
				con = ConnectionManager.getConnection(request);
				HashMap dataMap=eIP.IPAdvBedMgmtConfigBean.getBedConfSetupData(con);
				bedWidth=(String)dataMap.get("bed_img_width");
				bedWidth	= bedWidth==null?"":bedWidth;
				bedHeight=(String)dataMap.get("bed_img_height");
				bedHeight	= bedHeight==null?"":bedHeight;
				String room_clr=(String)dataMap.get("room_clr");


				BedLegendRequest bedLegendRequest = new BedLegendRequest();
				ApplicationContext context = new ClassPathXmlApplicationContext(GBMConstants.SPRING_BEANS_XML_NAME);
				BedLegendBC bcInst = (BedLegendBC)context.getBean(BedLegendConstants.LEGEND_BC_NAME);
				BedLegendResponse bedLegendResponse = bcInst.getBedLegend(bedLegendRequest);
				
			%>
		<div class="ui-layout-center">
			<div id='dfltdtls_container' class='dfltdtls_container'>
				<div id='dfltdtls' class='dfltdtls'>
					<table style="width:100%;border:1px">
						<tr><td class='label'>Details(in Pixels)</td><td class='label'>Width(Min/Max)</td><td class='label'>Height(Min/Max)</td></tr>
						<tr><td class='label'><fmt:message key="eIP.Beds.label" bundle="${ip_labels}"/></td><td><input type="text" id="bedWidth" name="bedWidth" id="bedWidth" value="<%=bedWidth%>" size='5'/><span class='label'>(150/300)</span></td><td><input type="text" id="bedHeight" name="bedHeight" id="bedHeight" value="<%=bedHeight%>" size='5'/><span class='label'>(90/200)</span></td></tr>
					</table>
				</div>
			</div>
			<div class="clrpick_container" id="clrpick_container">
				<div id='room'  name='room' class='clrpick_clr_disp' style='background-color:<%=room_clr%>'> <span id='roomText'>Room Name</span>
					<div id='clr_pick_beds' class='clr_pick_beds'><p></p>
						<%
						BedStatusEnum legendIdentifier = null;
						if(bedLegendResponse.isSuccessful()){
							List<BedLegend> legends = bedLegendResponse.getLegends();
							String color = "";
							String desc = "";
							String txtcolor	= "";
							
							
							for(BedLegend bedLegend:legends){	
							color = bedLegend.getLegendColor();
							desc = bedLegend.getLegendDescription();
							txtcolor	= bedLegend.getTextColor();
							legendIdentifier	= (BedStatusEnum)bedLegend.getLegendIdentifier();
						%>
							<div id="<%=legendIdentifier%>" class='color_pick_bed' style="background-color:#<%=color%>;"><p id='<%=legendIdentifier%>_Text' style='color:#<%=txtcolor%>'><%=desc%></p></div>

						<%
							
							}
						}
						%>
	
					</div>
					
				</div>
				<div id="colorpickerDiv" class='colorpickerDiv'>
						<div id='colorPickTextId' class='colorPickTextId'>
							<!--<span id='TextId'></span><br>
							<input type="hidden" id="color" name="color" id="color" value="#123456" />
							<span id='TextId'>TextColor</span><br>-->
							<input type="hidden" id="color" name="color" id="color" value="#123456" /><br>
							Text Color<input type="radio" name="textcolor" id="textcolor" value="W" onclick="updateTextColor('W')">White
							<input type="radio" name="textcolor" id="textcolor" value="B" onclick="updateTextColor('B')">Black
						</div>
						<div id='colorPickId' class='colorPickId'>
							<div id="colorpicker"></div>
						</div>
					</div>
				
			</div>
			
			
		</div>
		<input type='hidden' id='selectedElem' name='selectedElem' id='selectedElem' value=''>
		<%
			if(rSet!=null)rSet.close();
			if(pstmt!=null)pstmt.close();
		}catch(Exception ex){
			ex.printStackTrace();
			try{
				con.rollback();
			}catch(Exception e){
				e.printStackTrace();
			}
		}finally{
			try{
				if(rSet!=null)rSet.close();
				if(pstmt!=null)pstmt.close();
			}catch(Exception e){
				e.printStackTrace();
			}
			if(con!=null)ConnectionManager.returnConnection(con,request);
		}
		%>
	</body>
	<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
</html>

