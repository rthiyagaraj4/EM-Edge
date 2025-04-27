<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %> 
<%@ include file="../../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
response.setHeader("Access-Control-Allow-Origin", "*"); 
	String path = request.getContextPath();
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String locale = p.getProperty("LOCALE");
	String added_by_id			= p.getProperty("login_user");//login_by_id			
	String added_at_ws_no		= p.getProperty("client_ip_address");//login_at_ws_no
	String params = request.getQueryString();
	String[] url = params.split("url=");
	String patient_id = request.getParameter("patientid");
	String encounterid = request.getParameter("encounterid");
	String facility_id = request.getParameter("facilityid");
	String p_report_id = request.getParameter("p_report_id");
	String approval_num = request.getParameter("approval_num");
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	eCA.CAInsurenceAuthorizationFormsBean bean = (eCA.CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	ArrayList<String> formData = bean.getFormData(patient_id,encounterid,facility_id);
	System.out.println("formData: " + formData);
	String disable_flag = "disabled";
%>
<html>
<head>
	<meta charset="utf-8">
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/kendo.common.min.css" />
	<link rel="stylesheet" href="<%=path%>/eIPAD/css/kendo.default.min.css" />
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<script src="<%=path%>/eIPAD/kendo.web.min.js"></script>
	 
	<style type="text/css">
		body {
			margin: 10px;
		}

		#somediv {
			position: fixed;
			display: none;
			width: 100%;
			height: 100%;
			top: 0;
			left: 0;
			right: 0;
			bottom: 0;
			background-color: rgba(0,0,0,0.5);
			z-index: 2;
			cursor: pointer;
		}
		
		.CNButtonContainer {
margin-right: 10px;
display: table;
width: 42px;
cursor:pointer;
}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			init();
			viewImage('<%=patient_id%>','<%=encounterid%>','<%=p_report_id%>');
			$("#pdfIframe").attr('src','<%=path%>/eIPAD/js/pdfjs/web/viewer.html?file=<%=request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath()%>/eIPAD/jsp/InsuranceAuthorization/IAGetPdf.jsp');
		});
		function signClick() {
			document.getElementById("somediv").style.display = "block";
			var canvas = document.getElementById('can');
			var ctx = canvas.getContext('2d');
			ctx.fillStyle = 'white';
			ctx.fillRect(0, 0, canvas.width, canvas.height);
		}
		function off() {
			document.getElementById("somediv").style.display = "none";
		}
	</script>
	
	<script language="JavaScript" src="<%=path %>/eIPAD/js/IALoginUI.js"></script>
</head>
<body>
	<form>
		<div id='somediv' style="display:none;">
			<div>
				<canvas id="can" width="800" height="200" class="center" style="border: 2px solid; background-color:#ffffff;"></canvas>
				<canvas id="blank" style='display:none'></canvas>
			</div>
			<div>
				<input type="button" class="k-button" value="Save" id="btn" size="30" onclick="off();saveData('<%=patient_id%>','<%=facility_id%>','<%=encounterid%>','<%=p_report_id%>','<%=added_by_id%>','<%=added_at_ws_no%>', '<%=approval_num%>');">
				<input type="button" class="k-button" value="Clear" id="btn" size="30" onclick="clearSign()">
				<input type="button" class="k-button" value="Close" id="btn" size="30" onclick="off()">	
			</div>
		</div>
		<div style="display:table;width:100%;height:80%;">
			<div style="display:table-row;width:100%;height:auto;"  align="right">
			  	<div style="width:7%;height:auto;" class="CNButtonContainer CNButtonItemTheme">
            		<img src="<%=path%>/eIPAD/images/sign25x25.png" onclick="signClick();"/>
			  	</div>
			</div>
			<div style="display:table-row;width:100%;height:auto;">
				<div style="display: table-cell;width:100%;height:100%;">
				<%
					String encURL = url[1].replace("+", "%2B");
				
				%>
        			<iframe id="pdfIframe" src="" style="height:100%;width:100%"></iframe>
        			 <%-- <iframe id="pdfIframe" src="<%=url[1] %>" style="height:100%;width:100%"></iframe> --%>
        			<%-- <iframe id="pdfIframe" src="http://docs.google.com/gview?embedded=true&url=<%=encURL %>" style="height:500px;width:500px></iframe> --%>
				</div>
			</div>
		</div>
		<input type="hidden" id="path_value" value="<%=path %>">
		<script type="text/javascript">
			var canvas, ctx, flag = false, prevX = 0, currX = 0, prevY = 0, currY = 0, dot_flag = false;
			var x = 0, y = 2;
			function init() {
				canvas = document.getElementById('can');
				ctx = canvas.getContext("2d");
				w = canvas.width;
				h = canvas.height;
				canvas.addEventListener("mousemove", function(e) {
					findxy('move', e)
				}, false);
				canvas.addEventListener("mousedown", function(e) {
					findxy('down', e)
				}, false);
				canvas.addEventListener("mouseup", function(e) {
					findxy('up', e)
				}, false);
				// Set up touch events for mobile, etc
				canvas.addEventListener("touchstart", function (e) {
					mousePos = getTouchPos(canvas, e);
					var touch = e.touches[0];
					var mouseEvent = new MouseEvent("mousedown", {
						clientX: touch.clientX,
						clientY: touch.clientY
					});
					canvas.dispatchEvent(mouseEvent);
				}, false);
				canvas.addEventListener("touchend", function (e) {
					var mouseEvent = new MouseEvent("mouseup", {});
					canvas.dispatchEvent(mouseEvent);
				}, false);
				canvas.addEventListener("touchmove", function (e) {
					var touch = e.touches[0];
					var mouseEvent = new MouseEvent("mousemove", {
						clientX: touch.clientX,
						clientY: touch.clientY
					});
					canvas.dispatchEvent(mouseEvent);
				}, false);
			}

			function draw() {
				ctx.beginPath();
				ctx.moveTo(prevX, prevY);
				ctx.lineTo(currX, currY);
				ctx.strokeStyle = x;
				ctx.lineWidth = y;
				ctx.stroke();
				ctx.closePath();
			}
	
			function clearSign() {
				ctx.clearRect(0, 0, w, h);
				var canvas = document.getElementById('can');
				ctx.fillStyle = 'white';
				ctx.fillRect(0, 0, canvas.width, canvas.height);
			}
			
			function findxy(res, e) {
				if (res == 'down') {
					prevX = currX;
					prevY = currY;
					currX = e.clientX - canvas.offsetLeft;
					currY = e.clientY - canvas.offsetTop;
					flag = true;
					dot_flag = true;
					if (dot_flag) {
						ctx.beginPath();
						ctx.fillStyle = x;
						ctx.fillRect(currX, currY, 2, 2);
						ctx.closePath();
						dot_flag = false;
					}
				}
				if (res == 'up') {
					flag = false;
				}
				if (res == 'move') {
					if (flag) {
						prevX = currX;
						prevY = currY;
						currX = e.clientX - canvas.offsetLeft;
						currY = e.clientY - canvas.offsetTop;
						draw();
					}
				}
			}
	
			// Get the position of a touch relative to the canvas
			function getTouchPos(canvasDom, touchEvent) {
				var rect = canvasDom.getBoundingClientRect();
				return {
					x: touchEvent.touches[0].clientX - rect.left,
					y: touchEvent.touches[0].clientY - rect.top
				};
			}
			
			function viewImage(patient_id,encounter_id,p_report_id) {
				xmlStr = "<root><SEARCH ";
				xmlStr += " patient_id=\"" +patient_id+ "\"";
				xmlStr += " encounter_id=\"" +encounter_id+ "\"";
				xmlStr += " p_report_id=\"" +p_report_id+ "\"";
				xmlStr += " /></root>";
				var xmlDoc;
				var xmlHttp;
				xmlHttp = new XMLHttpRequest();
				var oParser = new DOMParser();
				xmlDoc = oParser.parseFromString(xmlStr,"text/xml");
				xmlHttp.open("POST", contextPath+"/eIPAD/jsp/InsuranceAuthorization/IAIntermediateValidate.jsp", false);
				xmlHttp.send(xmlDoc);
				responseText = xmlHttp.responseText ;
				eval(responseText);
			}
			
			function testView(data){
				var imageURL = "data:image/jpeg;base64,"+data;
				//document.getElementById("canvasimg").src = imageURL;
				//document.getElementById("canvasimg").style.display = "inline"; 
				//document.getElementById("canvasimg").src = imageURL;
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</form>
</body>
</html>

