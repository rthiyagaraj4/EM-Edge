<!DOCTYPE html>
<%@page import="eIP.advbedmgmt.setup.beddimension.response.RetrieveDimensionResponse"%>
<%@page import="eIP.advbedmgmt.setup.beddimension.request.RetrieveDimensionRequest"%>
<%@page import="eIP.advbedmgmt.setup.beddimension.bc.BedDimensionBC"%>
<%@page import="eIP.advbedmgmt.setup.beddimension.BedDimensionConstants"%>
<%@page import="eIP.advbedmgmt.GBMConstants"%>
<%@page import="org.springframework.context.support.ClassPathXmlApplicationContext"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*, java.lang.*,java.text.*,java.util.*,webbeans.eCommon.*" %>

	<%
		String nursingUnit=request.getParameter("nursingUnit")==null?"":request.getParameter("nursingUnit");
		String room=request.getParameter("room")==null?"":request.getParameter("room");
		request.setCharacterEncoding("UTF-8");
		Connection con	= null;
		Statement stmt=null;
		PreparedStatement	pstmt	= null;
		ResultSet rs	= null;
		ArrayList unassignedBedList 	= new ArrayList();
		ArrayList assignedBedList 		= new ArrayList();
		ArrayList floorRoomBedList 		= new ArrayList();
		String facility_id		= (String)session.getAttribute("facility_id");
		HashMap ipRoomBedDataMap=new HashMap();
		int bedDfltWidth=0;
		int bedDfltHeight=0;
	%>
<html>
	<head>
		<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
		
		<link rel="stylesheet" type="text/css" href="../../eIP/html/JQuery/base/jquery.ui.resizable.css"/>
		<link type="text/css" rel="stylesheet" href="../../eIP/html/IPAdvBedMgmtSetupStyle.css"/>
		<!--<script src='../../eIP/js/IPNursingUnitRoomLayout.js' language='javascript'></script>-->
		<script src='../../eIP/js/IPAdvBedMgmtSetup.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		
		<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-layout/1.4.3/jquery.layout.min.js" integrity="sha512-ivkojFS3Hd6k9wRLJqWXwOXVWh3Ygr3VKpcxB8m6FCn95pZE2tt0vFP3tTa08OW8PvPLfJk97pk6n3jAyvEA3g==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>			
	
		<script type="text/javascript">
			var bedArray = [];
			var assignedBedArray=[];
			var delBedArray=[];
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
			$(document).ready(function(){
				$('#unassignedbedssbox').height(document.documentElement.clientHeight-2);
				$('#floorWrapper_roombed').css("left", ($('#unassignedbedssbox').width()+5));
				$('#floorWrapper_roombed').width(document.documentElement.clientWidth-($('#unassignedbedssbox').width()+5))
				$('#floorWrapper_roombed').height(document.documentElement.clientHeight-2)
				$("#roomContainer_roombed").children(".assignedBed_roombed").each(function(){
					if(jQuery.inArray($(this).attr("id"), assignedBedArray)=='-1'){
						assignedBedArray.push($(this).attr("id"));
					}
				});
				var floorPos=$('#floor_roombed').offset();
				var roomPos=$('#roomContainer_roombed').offset();
				$('.assignedBed_roombed').draggable({
					helper:'clone',
					appendTo:'#roomContainer_roombed',
					revert: 'invalid',					
					containment: '#roomContainer_roombed',
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
				$('.assignedBed_roombed').resizable({
					handles:  'e,s',
					zIndex: 10000,
					appendTo:'#roomContainer_roombed',
					containment: '#roomContainer_roombed',
					minWidth:150,
					minHeight:90,
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
						var dest = $("#roomContainer_roombed").position();
						divId=$(this).attr("id");
						var divRight=Rx2;
						var divBottom=Ry2;
						if($("#roomContainer_roombed").css('position')=='relative'){
							divRight=Rx2+parseInt(dest.left);
							divBottom=Ry2+parseInt(dest.top);
						}
						var destRightEdge=parseInt(dest.left)+parseInt($("#roomContainer_roombed").width());
						var destBottomEdge=parseInt(dest.top)+parseInt($("#roomContainer_roombed").height());
						if((divRight>destRightEdge)|| (divBottom>destBottomEdge)){
							setBackDiv(divId);
						}else{
							IterateChildren($(this).attr("id"));
						}
					}
				});
				$('.unassignedbed_roombed').draggable({
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
							//$(ui.helper).find('.bedreset_roombed').find('img').show('fast');
						}else if(dropped && (!droppedFit)){
							$(this).draggable('option','revert','invalid');
							$(this).show();
						}else{
							$(this).draggable('option','revert','invalid');
							$(this).show();
						}
					}
				});
				$('#roomContainer_roombed').droppable({
					tolerance: 'fit',
					drop: function(event,ui){
						var droppedLeft=ui.position.left;
						var droppedTop=ui.position.top;
						if(ui.draggable.parent().attr('id')=='unassignedbedssbox'){
							droppedLeft=ui.position.left - (roomPos.left);
							droppedTop=ui.position.top - (roomPos.top);
							droppedLeft=droppedLeft+$('#floorWrapper_roombed').scrollLeft();
							droppedTop=droppedTop+$('#floorWrapper_roombed').scrollTop();
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
							appendTo:'#roomContainer_roombed',
							containment: '#roomContainer_roombed',
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
							appendTo:'#roomContainer_roombed',
							containment: '#roomContainer_roombed',
							minWidth:150,
							minHeight:90,
							start: function(event, ui){
								divWidth=$(this).width();
								divHeight=$(this).height();
							},
							stop: function(event,ui){
								divLeft=0;
								divTop=0;
								divLeft=$(this).position().left;
								divTop=$(this).position().top;
								Rx1=ui.position.left;
								Rx2=ui.position.left + ui.size.width;
								Rx3=ui.position.left;
								Rx4=ui.position.left + ui.size.width;
								Ry1=ui.position.top+ui.size.height;
								Ry2=ui.position.top+ui.size.height;
								Ry3=ui.position.top;
								Ry4=ui.position.top;
								divId=$(this).attr("id");
								var divRight=Rx2;
								var divBottom=Ry2;
								var destRightEdge=parseInt(roomPos.left)+parseInt($("#roomContainer_roombed").width());
								var destBottomEdge=parseInt(roomPos.top)+parseInt($("#roomContainer_roombed").height());
								if((divRight>destRightEdge)|| (divBottom>destBottomEdge)){
									setBackDiv(divId);
								}else{
									IterateChildren($(this).attr("id"));
								}
							}
						});
						$(ui.helper).find('.bedreset_roombed').find('img').remove();
						$('<img/>', {
							src:     '../../eCommon/images/disabled.gif',
							id:"R"+ui.helper.attr("id"),
							//title:   'Delete ' + fotos[f].Title,
							'class': 'icon_delete', // in quotes because class is a reserved js word
							click:   function( e ){
								delBed(($(this).attr('id')).substring(1));
							}
						}).appendTo($(ui.helper).find('.bedreset_roombed'));
						$.ui.ddmanager.current.cancelHelperRemoval = true;	
						ui.helper.css({'position':'absolute','top':droppedTop,'left':droppedLeft});
						ui.helper.appendTo($(this));
					}
				});
			});
			window.onresize=function(){
				$('#floorWrapper_roombed').width(document.documentElement.clientWidth-($('#unassignedbedssbox').width()+5));
			};
			
			function IterateChildren(id){
				$("#roomContainer_roombed").children("div").each(function(){
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
				}
				);
			}
			function setBackDiv(ID){
				var $currDiv = $("#"+ID);
				$currDiv.width(divWidth);
				$currDiv.height(divHeight);
				return false;
			}
			function submitBedLayout(){
				var layOutData="";
				var dest = $("#roomContainer_roombed").offset();
				var droppedCount=0;
				var count=0;				
				var count=0;
				$("#roomContainer_roombed").children("div").each(function(){
					if($(this).attr('id')){
						if(count==0){							
							layOutData=$(this).attr('id')+"~"+($(this).position().left)+"~"+($(this).position().top)+"~"+$(this).width()+"~"+$(this).height();
						}else{
							layOutData=layOutData+"|"+$(this).attr('id')+"~"+($(this).position().left)+"~"+($(this).position().top)+"~"+$(this).width()+"~"+$(this).height();
						}
						count++;
					}
				});
				if(layOutData!=''){
					$.post("../../servlet/eIP.IPAdvBedMgmtSetupServlet",
					{
						operation: "roomBedLayout",
						nursingUnit:parent.blank.document.bedMgmtSetupForm.nursing_unit.value,
						layOutDataInfo:layOutData
					},
					function(data, textStatus)
					{
						parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+getMessage("RECORD_MODIFIED","SM")+"&err_value=0";
						parent.blank.document.bedMgmtSetupForm.room.value='';
						location.href = "../../eCommon/html/blank.html";
						
					} 
					);
				}else{
					alert(getMessage("LAYOUT_NOT_SPC","IP"));
				}
			}
			
			function delBed(obj){				
				if(jQuery.inArray(obj, assignedBedArray)=='-1' || (jQuery.inArray(obj, delBedArray)!='-1')){
					$("#"+obj).remove();
					$("#H"+obj).show();
					$("#H"+obj).attr('id',obj);
				}else{
					$.post("../../servlet/eIP.IPAdvBedMgmtSetupServlet",
					{
						operation: "delBedFromLayout",
						facility_id:document.forms[0].facility_id.value,
						roomNo:document.forms[0].room.value,
						bedNo:obj,
						nursingUnit:document.forms[0].nursingUnit.value
					},
					function(data, textStatus)
					{
						if(textStatus=='success'){
							$('#'+obj).remove();
							delBedArray.push(obj);
							alert(getMessage("RECORD_MODIFIED","SM"));
							//alert(getMessage("BED_DEL_FROM_LT","IP"));							
							d=document.createElement('div');
							$(d).attr('id',obj).addClass('unassignedbed_roombed');							
							$(d).height($("#bedDfltHeight").val());
							$(d).width($("#bedDfltWidth").val());			
							d1=document.createElement('div');
							$(d1).addClass('bedheader_roombed')
							d2=document.createElement('div');
							$(d2).addClass('bedDtls_roombed').html(obj)
							d3=document.createElement('div');
							$(d3).addClass('bedreset_roombed')
							d4=document.createElement('div');
							$(d4).addClass('bedbody_roombed');
							$(d2).appendTo($(d1));
							$(d3).appendTo($(d1));
							$(d1).appendTo($(d));
							$(d4).appendTo($(d));
							$(d).appendTo($("#unassignedbedssbox"));
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
		String floorWidth="0";
		String floorHeight="0";
			try{
				con=ConnectionManager.getConnection(request);
				ipRoomBedDataMap=eIP.IPAdvBedMgmtConfigBean.getIPRoomBedData(con,pstmt,rs,nursingUnit,room,facility_id);

				// get data through BC class
				RetrieveDimensionRequest retrDimRequest = new RetrieveDimensionRequest();
				ApplicationContext context = new ClassPathXmlApplicationContext(
								GBMConstants.SPRING_BEANS_XML_NAME);
				BedDimensionBC bcInst = (BedDimensionBC)context
										.getBean(BedDimensionConstants.BC_IDENTIFIER);
				RetrieveDimensionResponse retrDimResponse = bcInst.getBedDimension(retrDimRequest);
				
				if(retrDimResponse.isSuccessful()){
					bedDfltWidth = retrDimResponse.getWidth();
					bedDfltHeight = retrDimResponse.getHeight();
				}else{
					bedDfltWidth = BedDimensionConstants.DEFAULT_WIDTH;
					bedDfltHeight = BedDimensionConstants.DEFAULT_HEIGHT;
				}
				
				
				/* HashMap sizeInfoMap=eIP.IPAdvBedMgmtConfigBean.getRoomBedSizeData(con,facility_id);
				bedDfltWidth=Integer.parseInt((String)sizeInfoMap.get("bed_img_width"));
				bedDfltHeight=Integer.parseInt((String)sizeInfoMap.get("bed_img_height")); */
				
				unassignedBedList 	= (ArrayList)ipRoomBedDataMap.get("unassignedBedList");
				assignedBedList 	= (ArrayList)ipRoomBedDataMap.get("assignedBedList");
				
				// to get all rooms of nursing unit starts
				stmt=con.createStatement();
				if(rs!=null)rs.close();
				floorRoomBedList=eIP.IPAdvBedMgmtConfigBean.getNursingUnitRoomBedSetupData(con,stmt,rs,nursingUnit,facility_id);
				// to get all rooms of nursing unit ends
				
				floorLayoutmap=eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,facility_id,nursingUnit);
				floorWidth=(String)floorLayoutmap.get("floor_width");
				floorHeight=(String)floorLayoutmap.get("floor_height");
			}catch(Exception ex){
				ex.printStackTrace();
			}finally{
				try{
					if(rs!=null)rs.close();
					if(stmt!=null)stmt.close();
					if(pstmt!=null)pstmt.close();
				}catch(Exception e){
					e.printStackTrace();
				}
				if(con != null)  ConnectionManager.returnConnection(con,request);
			}
		%>
	<body onMouseDown="CodeArrest()" onKeyDown = "lockKey()">
	<form name='bedLayOutMgmt' id='bedLayOutMgmt' method='post'>
	<!--bedDiv0~crdbed|bedDiv1~surbed|bedDiv2|bedDiv3~nrmbed-->
		<div class='unassignedbedssbox' id='unassignedbedssbox'>
			<%
				if(unassignedBedList.size()>0){
					Iterator iterator=unassignedBedList.iterator();
					while(iterator.hasNext()){
						HashMap tempMap = (HashMap)iterator.next();
						String bedNo=(String)tempMap.get("bedNo");
						%>
							<div id="<%=bedNo%>" class="unassignedbed_roombed" name="<%=bedNo%>" style="width:<%=bedDfltWidth%>px; height:<%=bedDfltHeight%>px;"><div class='bedheader_roombed'><div class='bedDtls_roombed'><%=bedNo%></div><div class='bedreset_roombed'></div></div><div class='bedbody_roombed'></div></div>
						<%
					}
				}
			%>			
		</div>
			<div class='floorWrapper_roombed' id="floorWrapper_roombed">
				<div class="floor_roombed" id="floor_roombed" style="width:<%=floorWidth%>px; height:<%=floorHeight%>px;">
				<%

					if(floorRoomBedList.size()>0){
						Iterator iterator=floorRoomBedList.iterator();
						int roomCounter=0;
						while(iterator.hasNext()){
							HashMap tempMap = (HashMap)iterator.next();
							String roomNo=(String)tempMap.get("roomNo");
							String roomName=(String)tempMap.get("roomName");						
							String roomTopPos=(String)tempMap.get("roomTopPos");
							String roomLeftPos=(String)tempMap.get("roomLeftPos");
							String roomWidth=(String)tempMap.get("roomWidth");
							String roomHeight=(String)tempMap.get("roomHeight");
							ArrayList roomBedsList =(ArrayList)tempMap.get("roomBedsList");
							boolean sameRoomFlag=false;
							int roomHeight1=Integer.parseInt(roomHeight)-20;
							if(room.equals(roomNo)){
								sameRoomFlag=true;
							}else{
								sameRoomFlag=false;
							}
							if(sameRoomFlag){
							%>
								<div class="roomContainer_roombed"  style="top:<%=roomTopPos%>px; left:<%=roomLeftPos%>px;width:<%=roomWidth%>px; height:<%=roomHeight%>px;">
									<div class='roomheader_roombed'><div class='roomDtls_roombed'><%=roomName%></div></div>
										<div id="roomContainer_roombed" style="position:relative;height:<%=roomHeight1%>px;">
							<%
							}else{%>
								<div class="roomContainer_roombed"  style="filter:alpha(opacity=25);top:<%=roomTopPos%>px; left:<%=roomLeftPos%>px;width:<%=roomWidth%>px; height:<%=roomHeight%>px;">
									<div class='roomheader_roombed'><div class='roomDtls_roombed'><%=roomName%></div></div>
										<div id="roomContainer_roombed<%=roomCounter%>" style="position:relative;height:<%=roomHeight1%>px;">
							<%}
							if(roomBedsList.size()>0){
								Iterator bedItr=roomBedsList.iterator();
								while(bedItr.hasNext()){
									HashMap roomBedsMap = (HashMap)bedItr.next();
									//System.out.println("roomBedsMap set up:"+roomBedsMap.toString());
									String bedNo=(String)roomBedsMap.get("bedNo");						
									String bedTopPos=(String)roomBedsMap.get("bedTopPos");
									String bedLeftPos=(String)roomBedsMap.get("bedLeftPos");
									String bedWidth=(String)roomBedsMap.get("bedWidth");
									String bedHeight=(String)roomBedsMap.get("bedHeight");
									//System.out.println("IPNursingUnitRoomBedLayout roomNo ="+roomNo+":bedNo="+bedNo+":bedTopPos="+bedTopPos+":bedLeftPos="+bedLeftPos+":bedWidth="+bedWidth+":bedHeight="+bedHeight);
									if(sameRoomFlag){
									%>
										<div id="<%=bedNo%>" class="assignedBed_roombed" style="top:<%=bedTopPos%>px; left:<%=bedLeftPos%>px;width:<%=bedWidth%>px; height:<%=bedHeight%>px;"><div class='bedheader_roombed'><div class='bedDtls_roombed'><%=bedNo%></div><div class='bedreset_roombed'><img id='small' src='../../eCommon/images/disabled.gif' onClick="delBed('<%=bedNo%>')"></img></div></div><div class='bedbody_roombed'></div></div>
									<%
									}else{
										%>
										<div id="<%=bedNo%>" class="assignedBedMask_roombed" style="top:<%=bedTopPos%>px; left:<%=bedLeftPos%>px;width:<%=bedWidth%>px; height:<%=bedHeight%>px;"><div class='bedheader_roombed'><div class='bedDtls_roombed'><%=bedNo%></div><div class='bedreset_roombed'></div></div><div class='bedbody_roombed'></div></div>
									<%
									}
								}//while loop for roomBedsList ends
							}//if condition roomBedsList ends
							%>
								</div>
							</div>
						<%
							roomCounter++;
						}//while loop for floorRoomBedList ends
					}//if condition floorRoomBedList ends
				%>
				</div>
			</div>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'/>
			<input type='hidden' name='nursingUnit' id='nursingUnit' value='<%=nursingUnit%>'/>
			<input type='hidden' name='room' id='room' value='<%=room%>'/>
			<input type='hidden' id='bedDfltWidth' name='bedDfltWidth' id='bedDfltWidth' value='<%=bedDfltWidth%>'/>
			<input type='hidden' id='bedDfltHeight' name='bedDfltHeight' id='bedDfltHeight' value='<%=bedDfltHeight%>'/>
		</form>
		</body>
</html>

