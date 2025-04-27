<!DOCTYPE html>
<!DOCTYPE>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.lang.*,java.text.*,java.util.*,webbeans.eCommon.*" %>
<%
	String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
	request.setCharacterEncoding("UTF-8");
	Connection con	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	ArrayList unassignedRoomList 	= new ArrayList();
	ArrayList assignedRoomList 		= new ArrayList();
	String facility_id		= (String)session.getAttribute("facility_id");
	int roomDfltWidth=0;
	int roomDfltHeight=0;
	String floorWidth="0";
	String floorHeight="0";
%>
<html>
	<head>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		<link rel="stylesheet" type="text/css" href="../../eIP/html/JQuery/base/jquery.ui.resizable.css"/>
		<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>  
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js" ></script>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtSetupStyle.css"/>
		<script src='../../eIP/js/IPAdvBedMgmtSetup.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<style type="text/css">			
			.egrip{
				width: 2px;
				height: 10px;
				background-color: #ffffff;
				border: 1px solid #000000;
				top:45%;
				align:center;
			}
			.sgrip{
				width: 10px;
				height: 2px;
				background-color: #ffffff;
				border: 1px solid #000000;
				align:center;
				left:45%;
			}
		</style>
		<script type="text/javascript">
			var roomArray = [];
			var assignedRoomArray=[];
			var delRoomArray=[];
			var divId;
			var divLeft=0;
			var divTop=0;
			var divHeight=0;
			var divWidth=0;
			var divTotalWidth=0;
			var divTotalHeight=0;
			var Rx1=0;
			var Rx2=0;
			var Rx3=0;
			var Rx4=0;
			var Ry1=0;
			var Ry2=0;
			var Ry3=0;
			var Ry4=0;
			var dropped=false;
			var droppedFit=false;
			var Parent="";
			var Me="";
			var did="";
			var droppedLeft;
			var droppedTop;
			$(document).ready(function(){
				$('#unassignedroomsbox').height(document.documentElement.clientHeight-2);
				$('#floorWrapper_floorroom').css("left", ($('#unassignedroomsbox').width()+5));
				$('#floorWrapper_floorroom').width(document.documentElement.clientWidth-($('#unassignedroomsbox').width()+5));
				$('#floorWrapper_floorroom').height(document.documentElement.clientHeight-2);	
				$("#floor_floorroom").children(".assignedRoom_floorroom").each(function(){
					if(jQuery.inArray($(this).attr("id"), assignedRoomArray)=='-1'){
						assignedRoomArray.push($(this).attr("id"));
					}
				});
				var floorPos=$('#floor_floorroom').offset();				
				var wrapperPos=$(".floorWrapper_floorroom").offset();				
				var floorWidth=document.forms[0].floorWidth.value;
				var floorHeight=document.forms[0].floorHeight.value;
				$('.assignedRoom_floorroom').draggable({
					helper:'clone',
					appendTo:'#floor_floorroom',
					revert: 'invalid',
					containment: '#floor_floorroom',
					start:function(e,ui){
						dropped=false;
						droppedFit=false;
						$(this).hide();
						Parent="";
						Me="";
						did="";
					},
					stop: function(e,ui){
						if(dropped && droppedFit){
							Parent.removeChild(Me);
						}else if(dropped && (!droppedFit)){
							$(this).draggable('option','revert','invalid');
							$(this).show();
						}else{
							$(this).draggable('option','revert','invalid');
							$(this).show();
						}
					}
				}).droppable({
					greedy: true,
					tolerance: 'touch',
					drop: function(event,ui){
						droppedFit=false;
						ui.draggable.draggable('option','revert',true);
					}
				});
				$('.assignedRoom_floorroom').resizable({
					handles:  'e,s',
					zIndex: 10000,
					appendTo:'#floor_floorroom',
					containment: '#floor_floorroom',
					minWidth:160,
					minHeight:120,
					start: function(event, ui){
						divWidth=$(this).width();
						divHeight=$(this).height();						
					},
					stop: function(event,ui){
						divLeft=$(this).position().left;
						divTop=$(this).position().top;
						Rx1=ui.position.left;
						Rx2=parseInt(ui.position.left) + parseInt(ui.size.width);
						Rx3=ui.position.left;
						Rx4=ui.position.left + ui.size.width;
						Ry1=ui.position.top+ui.size.height;
						Ry2=ui.position.top+ui.size.height;
						Ry3=ui.position.top;
						Ry4=ui.position.top;
						var dest = $("#floor_floorroom").position();
						divId=$(this).attr("id");
						var divRight=Rx2;
						var divBottom=Ry2;
						var destRightEdge=parseInt(dest.left)+parseInt($("#floor_floorroom").width());
						var destBottomEdge=parseInt(dest.top)+parseInt($("#floor_floorroom").height());
						IterateChildren($(this).attr("id"));
					}
				});
				$('.unassignedroom_floorroom').draggable({
					helper:'clone',
					appendTo:'body',
					revert: 'invalid',
					start:function(e,ui){
						dropped=false;
						droppedFit=false;
						$(this).hide();
						Parent="";
						Me="";
						did="";
					},
					stop: function(e,ui){
						if(dropped && droppedFit){
							$(this).attr("id","H"+$(this).attr("id"));
							//$(ui.helper).find('.roomClose_floorroom').find('img').show('fast');							
						}else if(dropped && (!droppedFit)){
							$(this).draggable('option','revert','invalid');
							$(this).show();
						}else{
							$(this).draggable('option','revert','invalid');
							$(this).show();
						}
					}
				});
				$('#floor_floorroom').droppable({
					tolerance: 'fit',
					drop: function(event,ui){
						var droppedLeft=ui.position.left;
						var droppedTop=ui.position.top;
						if(ui.draggable.parent().attr('id')=='unassignedroomsbox'){
							droppedLeft=ui.position.left - (wrapperPos.left+2);
							droppedTop=ui.position.top - (wrapperPos.top+2);												
							droppedLeft=droppedLeft+$('#floorWrapper_floorroom').scrollLeft();
							droppedTop=droppedTop+$('#floorWrapper_floorroom').scrollTop();
						}				
						dropped=true;
						droppedFit=true;					
						did=ui.draggable.attr('id');
						Parent=ui.draggable.parent()[0] // add [0] to the end of jQuery object to convert to a normal javascript one.
						Me=ui.draggable[0];
						ui.helper.attr('id',did);
						ui.helper.droppable({
							greedy: true,
							tolerance: 'touch',
							drop: function(event,ui){
								droppedFit=false;
								ui.draggable.draggable('option','revert',true);
							}
						});
						ui.helper.draggable({
							revert: 'invalid', 
							scroll: false,
							appendTo:'#floor_floorroom',
							containment: '#floor_floorroom',
							helper: 'clone',
							zIndex: 10000,
							start : function() {
								Parent="";
								Me="";
								$(this).hide();
							},
							stop: function() {
								if(dropped && droppedFit){
									Parent.removeChild(Me);										
								}else if(dropped && (!droppedFit)){
									$(this).draggable('option','revert','invalid');
									$(this).show();
								}else{
									$(this).draggable('option','revert','invalid');
									$(this).show();
								}
							}
						});
						ui.helper.find('.ui-resizable-handle').remove();
						ui.helper.resizable({
							handles:  'e,s',
							zIndex: 10000,
							appendTo:'#floor_floorroom',
							containment: '#floor_floorroom',
							minWidth:160,
							minHeight:120,
							start: function(event, ui){
								divWidth=$(this).width();
								divHeight=$(this).height();
							},
							stop: function(event,ui){
								divLeft=0;
								divTop=0;
								divLeft=ui.position.left;
								divTop=ui.position.top;
								Rx1=divLeft;
								Rx2=divLeft + ui.size.width;
								Rx3=divLeft;
								Rx4=divLeft + ui.size.width;
								Ry1=divTop+ ui.size.height;
								Ry2=divTop+ ui.size.height;
								Ry3=divTop;
								Ry4=divTop;
								var dest = $("#floor_floorroom").position();
								divId=$(this).attr("id");
								var divRight=Rx2;
								var divBottom=Ry2;
								if($("#floor_floorroom").css('position')=='relative'){
								}
								var destRightEdge=parseInt(floorPos.left)+parseInt(floorWidth);
								var destBottomEdge=parseInt(floorPos.top)+parseInt(floorHeight);
								IterateChildren($(this).attr("id"));
							}
						});
						$(ui.helper).find('.roomClose_floorroom').find('img').remove();
						$('<img/>', {
							src:     '../../eCommon/images/disabled.gif',
							id:"R"+ui.helper.attr("id"),
							//title:   'Delete ' + fotos[f].Title,
							'class': 'icon_delete', // in quotes because class is a reserved js word
							click:   function( e ){
								delRoom(($(this).attr('id')).substring(1));
							}
						}).appendTo($(ui.helper).find('.roomClose_floorroom'));
						$.ui.ddmanager.current.cancelHelperRemoval = true;						
						ui.helper.css({'position':'absolute','top':droppedTop,'left':droppedLeft});
						ui.helper.appendTo($(this));
					}
				});
			});
			window.onresize=function(){
				$('#floorWrapper_floorroom').width(document.documentElement.clientWidth-($('#unassignedroomsbox').width()+5));
			};
			
			function IterateChildren(id){
				$("#floor_floorroom").children("div").each(function(){
					var $currElement=$(this);
					if(id!=$currElement.attr('id')){
						var Dx1=$currElement.position().left;
						var Dx2=$currElement.position().left + $currElement.width();
						var Dx3=$currElement.position().left;
						var Dx4=$currElement.position().left + $currElement.width();
						var Dy1=$currElement.position().top+$currElement.height();
						var Dy2=$currElement.position().top+$currElement.height();
						var Dy3=$currElement.position().top;
						var Dy4=$currElement.position().top;
						if(((Dx1<Rx1 && Rx1<Dx4) && (Dy4<Ry1 && Ry1<Dy1))||((Dx1<Rx2 && Rx2<Dx4) && (Dy4<Ry2 && Ry2<Dy1))||((Dx1<Rx4 && Rx4<Dx4) && (Dy4<Ry4 && Ry4<Dy1))){
							setBackDiv(id);
						}else if((Rx1<Dx1 && Dx1<Rx4) && (Ry3<Dy1 && Dy1<Ry2)){
							setBackDiv(id);
						}else if((Rx1<Dx4 && Dx4<Rx4) && (Ry3<Dy4 && Dy4<Ry2)){
							setBackDiv(id);
						}else if((Ry1==Dy1 && Ry3==Dy3) && (Dx1<Rx2 && Rx2<Dx2)){
							setBackDiv(id);
						}else if((Rx1==Dx1 && Rx2==Dx2) && (Dy3<Ry1 && Ry1<Dy1)){
							setBackDiv(id);
						}else if((Rx1<Dx1 && Dx2<Rx2) && (Dy4<Ry4 && Ry2<Dy2)){
							setBackDiv(id);
						}else if((Dx1<Rx1 && Rx2<Dx2) && (Ry4<Dy4 && Dy2<Ry2)){
							setBackDiv(id);
						}
					}
				});
			}
			function setBackDiv(ID){
				var $currDiv = $("#"+ID);
				$currDiv.width(divWidth);
				$currDiv.height(divHeight);
				return false;
			}
			function submitRoomLayout(){
				var layOutData="";
				var dest = $("#floor_floorroom").offset();
				var droppedCount=0;
				var count=0;
				var updateFlag=true;
				$("#floor_floorroom").children("div").each(function(){
					if(count==0){							
						layOutData=$(this).attr('id')+"~"+($(this).position().left)+"~"+($(this).position().top)+"~"+$(this).width()+"~"+$(this).height();
					}else{
						layOutData=layOutData+"|"+$(this).attr('id')+"~"+($(this).position().left)+"~"+($(this).position().top)+"~"+$(this).width()+"~"+$(this).height();
					}
					var bedCountId="bedCountId"+$(this).attr('id');
					var roomWidthId="roomWidthId"+$(this).attr('id');
					var roomHeightId="roomHeightId"+$(this).attr('id');
					if($("#"+bedCountId).val()>0 && ($("#"+roomWidthId).val() > $(this).width() || $("#"+roomHeightId).val() > $(this).height())){
						updateFlag=false;
					}
					count++;
				});
				if(!updateFlag){
					alert(getMessage("BEDS_CONF_ROOM_REDUCE","IP"));
					return false;
				}
				if(layOutData!=''){
					$.post("../../servlet/eIP.IPAdvBedMgmtSetupServlet",
					{
						operation: "roomLayout",
						nursingUnit:parent.blank.document.bedMgmtSetupForm.nursing_unit.value,
						layOutDataInfo:layOutData
					},
					function(data, textStatus)
					{
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_MODIFIED","SM")+"&err_value=0";
						parent.blank.location.href="../../eIP/jsp/IPAdvBedMgmtCriteria.jsp";
						location.href = "../../eCommon/html/blank.html";
						
					}
					);
				}else{
					alert(getMessage("LAYOUT_NOT_SPC","IP"));
				}
			}
			
			function delRoom(obj){
				if(jQuery.inArray(obj, assignedRoomArray)=='-1' || (jQuery.inArray(obj, delRoomArray)!='-1')){
					$("#"+obj).remove();
					$("#H"+obj).show();
					$("#H"+obj).attr('id',obj);
				}else{
					var name=$("#"+obj).text();
					$.post("../../servlet/eIP.IPAdvBedMgmtSetupServlet",
					{
						operation: "delRoomFromLayout",
						roomNo:obj,
						nursingUnit:parent.blank.bedMgmtSetupForm.nursing_unit.value,
						facility_id:document.roomLayOutMgmt.facility_id.value
					},
					function(data, textStatus)
					{
						if(textStatus=='success'){
							$('#'+obj).remove();
							delRoomArray.push(obj);	
							//alert(getMessage("ROOM_DEL_FROM_LT","IP"));
							alert(getMessage("RECORD_MODIFIED","SM"));
							d=document.createElement('div');
							var roomDfltWidth=160;
							var roomDfltHeight=120;
							d.style.height = roomDfltHeight;
							d.style.width = roomDfltWidth;
							$(d).attr('id',obj).addClass('unassignedroom_floorroom');
							d1=document.createElement('div');
							$(d1).addClass('roomheader_floorroom')
							d2=document.createElement('div');
							$(d2).addClass('roomDtls_floorroom').html(name)
							d3=document.createElement('div');
							$(d3).addClass('roomClose_floorroom')
							d4=document.createElement('div');
							$(d4).addClass('roomDivBody_floorroom');
							$(d2).appendTo($(d1));
							$(d3).appendTo($(d1));
							$(d1).appendTo($(d));
							$(d4).appendTo($(d));
							$(d).appendTo($("#unassignedroomsbox"));
							//$(d).text(name);
							name="";
							$(d).draggable({
								helper:'clone',
								appendTo:'body',
								revert: 'invalid',
								start:function(e,ui){
									dropped=false;
									droppedFit=false;
									$(this).hide();
									Parent="";
									Me="";
									did="";
								},
								stop: function(e,ui){
									if(dropped && droppedFit){
										roomArray.push($(this).attr("id"));
										$(this).attr("id","H"+$(this).attr("id"));
										$.ui.ddmanager.current.cancelHelperRemoval = true;
									}else if(dropped && (!droppedFit)){
										$(this).draggable('option','revert','invalid');
										$(this).show();
									}else{
										$(this).draggable('option','revert','invalid');
										$(this).show();
									}
								}
							});
						}
					});				
				}
			}
		</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		HashMap floorLayoutmap=new HashMap();
			try{
				con=ConnectionManager.getConnection(request);
				stmt=con.createStatement();
				HashMap nursingUnitRoomDataMap=eIP.IPAdvBedMgmtConfigBean.getNursingUnitRoomData(con,facility_id,nursingUnit);
				HashMap sizeInfoMap=eIP.IPAdvBedMgmtConfigBean.getRoomBedSizeData(con,facility_id);
				unassignedRoomList 	= (ArrayList)nursingUnitRoomDataMap.get("unassignedRoomList");
				assignedRoomList 	= (ArrayList)nursingUnitRoomDataMap.get("assignedRoomList");
				//roomDfltWidth=Integer.parseInt((String)sizeInfoMap.get("room_img_width"));
				roomDfltWidth=Integer.parseInt((String)(sizeInfoMap.get("room_dflt_width")==null?"160":sizeInfoMap.get("room_dflt_width")));
				roomDfltHeight=Integer.parseInt((String)(sizeInfoMap.get("room_dflt_height")==null?"120":sizeInfoMap.get("room_dflt_height")));
				if(roomDfltWidth==0){
					roomDfltWidth=160;
				}
				if(roomDfltHeight==0){
					roomDfltHeight=120;
				}
				//roomDfltHeight=Integer.parseInt((String)sizeInfoMap.get("room_img_height"));
				floorLayoutmap=eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,facility_id,nursingUnit);
				floorWidth=(String)floorLayoutmap.get("floor_width");
				floorHeight=(String)floorLayoutmap.get("floor_height");
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
		<form name='roomLayOutMgmt' id='roomLayOutMgmt' method='post'>
		<div class='floorroomContainer' id='mainDiv'>
			<div class='unassignedroomsbox' id='unassignedroomsbox'>
				<%
				if(unassignedRoomList.size()>0){
					Iterator iterator=unassignedRoomList.iterator();
					while(iterator.hasNext()){
						HashMap tempMap = (HashMap)iterator.next();
						String roomNo=(String)tempMap.get("roomNo");
						String roomName=(String)tempMap.get("roomName");
						%>
							<div id="<%=roomNo%>" class="unassignedroom_floorroom" name="<%=roomNo%>" style="width:<%=roomDfltWidth%>px; height:<%=roomDfltHeight%>px;"><div class='roomheader_floorroom'><div class='roomDtls_floorroom'><%=roomName%></div><div class='roomClose_floorroom'></div></div><div class='roomDivBody_floorroom'></div></div>
						<%
					}
				}
				%>			
			</div>
			<div class='floorWrapper_floorroom' id="floorWrapper_floorroom">
				<div class="floor_floorroom" id="floor_floorroom" style="width:<%=floorWidth%>px; height:<%=floorHeight%>px;">	
					<%
					if(assignedRoomList.size()>0){
						Iterator iterator=assignedRoomList.iterator();
						while(iterator.hasNext()){
							HashMap tempMap = (HashMap)iterator.next();
							String roomNo=(String)tempMap.get("roomNo");
							String roomName=(String)tempMap.get("roomName");
							
							String roomTopPos=(String)tempMap.get("roomTopPos");
							String roomLeftPos=(String)tempMap.get("roomLeftPos");
							String roomWidth=(String)tempMap.get("roomWidth");
							String roomHeight=(String)tempMap.get("roomHeight");
							String bedCount=(String)tempMap.get("bedCount");
							%>
								<div id="<%=roomNo%>" class="assignedRoom_floorroom" style="top:<%=roomTopPos%>px; left:<%=roomLeftPos%>px;width:<%=roomWidth%>px; height:<%=roomHeight%>px;"><div class='roomheader_floorroom'><div class='roomDtls_floorroom'><%=roomName%></div><div class='roomClose_floorroom'><img id='small' src='../../eCommon/images/disabled.gif' onClick="delRoom('<%=roomNo%>')"></img></div></div><div class='roomDivBody_floorroom'><!--<div class="ui-resizable-handle ui-resizable-e egrip"></div><div class="ui-resizable-handle ui-resizable-s sgrip"></div>--></div><input type='hidden' name='bedCount<%=roomNo%>' id='bedCount<%=roomNo%>' id='bedCountId<%=roomNo%>' value='<%=bedCount%>'><input type='hidden' name='roomWidth<%=roomNo%>' id='roomWidth<%=roomNo%>' id='roomWidthId<%=roomNo%>' value='<%=roomWidth%>'><input type='hidden' name='roomHeight<%=roomNo%>' id='roomHeight<%=roomNo%>' id='roomHeightId<%=roomNo%>' value='<%=roomHeight%>'></div>
							<%
						}
					}
				%>
				</div>
			</div>
			</div>
			<input type='hidden' name='floorWidth' id='floorWidth' value='<%=floorWidth%>'>
			<input type='hidden' name='floorHeight' id='floorHeight' value='<%=floorHeight%>'>
			<input type='hidden' name='roomDfltWidth' id='roomDfltWidth' value='<%=roomDfltWidth%>'>
			<input type='hidden' name='roomDfltHeight' id='roomDfltHeight' value='<%=roomDfltHeight%>'>
			<input type='hidden' name='facility_id' id='facility_id' id='facility_idId' value='<%=facility_id%>'>
		</form>
	</body>
</html>

