<!DOCTYPE html>
<!DOCTYPE>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.lang.*,java.text.*,java.util.*,webbeans.eCommon.*" %>

<%
	String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	String facility_id		= (String)session.getAttribute("facility_id");
%>
<html> 
	<head>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<link rel="stylesheet" type="text/css" href="../../eIP/html/JQuery/base/jquery.ui.resizable.css"/>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtSetupStyle.css"/>
		<script src='../../eIP/js/IPAdvBedMgmtSetup.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
		
		<script type="text/javascript">
			$(document).ready(function(){
				$('.floorsetup').resizable({
					handles:  'e,s'
				});
			});
			window.onresize=function(){
				//alert(document.documentElement.clientWidth)
				if(document.documentElement.clientWidth > 1160){
					$('#floorWrapper').width(1160);
				}else{
					$('#floorWrapper').width(document.documentElement.clientWidth-10);
				}
				if(document.documentElement.clientHeight > 600){
					$('#floorWrapper').height(600);
				}else{
					$('#floorWrapper').height(document.documentElement.clientHeight-10);
				}				
			};
			function submitFloorLayout(){ 
				if($("#countId").val()>0 && ($("#floorWidthId").val()>$('#floor').width()||$("#floorHeightId").val()>$('#floor').height())){					
					alert(getMessage("ROOMS_CONF_FLOOR_REDUCE","IP"));					//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("ROOMS_CONF_FLOOR_REDUCE","IP")+"&err_value=1";
					//parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_MODIFIED","SM")+"&err_value=0";
				}else{
					$.post("../../servlet/eIP.IPAdvBedMgmtSetupServlet",
					{
						operation: "floorLayout",
						floorWidth:$("#floor").width(),
						floorHeight:$("#floor").height(),
						nursingUnit:parent.blank.bedMgmtSetupForm.nursing_unit.value
					},
					function(data, textStatus)
					{
						//alert("APP-SM0069 Operation Completed Successfully ....");
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_MODIFIED","SM")+"&err_value=0";
						parent.blank.location.href="../../eIP/jsp/IPAdvBedMgmtCriteria.jsp";
						location.href = "../../eCommon/html/blank.html";
						
					}
					);
				}
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		HashMap floorLayoutmap=new HashMap();
		String floorWidth="0";
		String floorHeight="0";
		String count="0";
			try{
				con=ConnectionManager.getConnection(request);
				floorLayoutmap=eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,facility_id,nursingUnit);
				floorWidth=(String)floorLayoutmap.get("floor_width");
				floorHeight=(String)floorLayoutmap.get("floor_height");
				count=(String)floorLayoutmap.get("count"); 
				floorLayoutmap.clear();
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(con != null)  ConnectionManager.returnConnection(con,request);
			}
		%>
	<body onMouseDown="CodeArrest()" onKeyDown = "lockKey()">
		<form name='floorLayOutMgmt' id='floorLayOutMgmt' method='post'>
			<div id='floorsetupMain' class='floorsetupMain'>
			<div class='floorWrappersetup' id="floorWrapper">
				<%if(floorWidth.equals("0") || floorHeight.equals("0")){%>
					<div class="floorsetup" id="floor">
				<%}else{%>
					<div class="floorsetup" id="floor" style="width:<%=floorWidth%>px; height:<%=floorHeight%>px;">
				<%}%>				
				</div>
			</div>
			<div>
			<input type='hidden' id='floorWidthId' name='floorWidth' id='floorWidth' value='<%=floorWidth%>'>
			<input type='hidden' id='floorHeightId' name='floorHeight' id='floorHeight' value='<%=floorHeight%>'>
			<input type='hidden' id='countId' name='count' id='count' value='<%=count%>'>
		</form>
	</body>
</html>

