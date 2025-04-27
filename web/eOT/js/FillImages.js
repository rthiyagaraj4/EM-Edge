/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
	/*
	  image_side : L (Left), R(Right), T(Top), D(Down), LO(Left Occlusal), RO(Right Occlusal),BR(Both Rect)
	
	1.Left Rect : cords = 9,9,20,16; width=11;height=8 (surface : Disto Occlusal or Incisal)
		fillRect(imageLayer,9,9,11,8,left_rect_color);

	2.Right Rect : cords = 21,9,32,16; width=11;height=8 (surface : Mesio Occlusal or Incisal)
		fillRect(imageLayer,21,9,11,8,right_rect_color);

	3.Both Rect
		fillRect(imageLayer,9,9,23,8,right_rect_color);

	4.Left : 3,20,7,16,7,8,3,4 (surface : Distal)
		fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),top_polygon_color);

	5.Bottom : 4,21,8,17,32,17,36,21 (surface : palatal or Lingual)
		fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),top_polygon_color);

	6.Right : 33,8,33,16,37,20,37,4 (surface : Mesial)
		fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),top_polygon_color);

	7.Top : 4,3,36,3,35,4,33,6,32,7,8,7 (surface : Labial or Buccal)
		fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),top_polygon_color);

	*/

 function fillCrownImages(imageLayer,image_side,dentalChartFormObj,condition_type,status){
	var fill_color = "";
	var status_int = 0;
	if(status != "E"){
		status_int = parseInt(status);
	}
	if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
		//Selecing the fill color according to the condition_type
		if(condition_type == "PULPINV"){
			fill_color = "red"
			image_side = "BR";
		}
		else if(condition_type == "CARIES"){
			fill_color = "black"
		}
		/*
		else if(condition_type == "CROWN"){
			//image_side = "BR"; //commented on 04/01/08 by Sridevi to show the filling based on the surface selected
			fill_color = "LIGHTGREEN";
		}
		else{
			fill_color = "LIGHTGREEN";
		}
		*/
		//alert(status_int);
		//alert(status);
		if(status_int >= 10 && (status_int < 60 || status_int < 85)){ // planned
			fill_color = "YELLOW";
		}
		else{
			fill_color = "LIGHTGREEN";
		}
		

		// Surface Decoding
		if(image_side == 1){
			image_side  = "T";
		}
		else if(image_side == 2){
			image_side  = "T";
		}
		else if(image_side == 3){
			image_side  = "L";
		}
		else if(image_side == 4){
			image_side  = "R";
		}
		else if(image_side == 5){
			image_side  = "B";
		}
		else if(image_side == 6){
			image_side  = "B";
		}
		else if(image_side == 7){
			image_side  = "BR";
		}
		else if(image_side == 8){
			image_side  = "BR";
		}
		else if(image_side == 9){
			image_side  = "RO";
		}
		else if(image_side == 10){
			image_side  = "LO";
		}
	
	
		//If status is marked as error, filling is done with while color to erase the filing. 
		if(status == 'E'){
			fill_color = "white";
			if(image_side == "BR" ||condition_type == "PULPINV"){
				image_side = "";
				fillRect(imageLayer,9,9,11,7,fill_color);
				fillRect(imageLayer,21,9,11,7,fill_color);
			}
		}
		//Crown and Root filling with co-ordinates.
		if(image_side=="T")
			fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color);
		else if(image_side=="L")
			fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
		else if(image_side=="B")
			fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),fill_color);
		else if(image_side=="R")
			fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
		else if(image_side=="RO")
			fillRect(imageLayer,21,9,11,7,fill_color);
		else if(image_side=="LO")
			fillRect(imageLayer,9,9,11,7,fill_color);
		else if(image_side=="BR"){
			//fillRect(imageLayer,9,9,23,7,fill_color);
			fillRect(imageLayer,9,9,11,7,fill_color);
			fillRect(imageLayer,21,9,11,7,fill_color);
		}
		else if(image_side=="ALL"){
			fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color);
			fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
			fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),fill_color);
			fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);

			fillRect(imageLayer,21,9,11,7,fill_color);
			fillRect(imageLayer,9,9,11,7,fill_color);
		}
	}
		
  }

function getCoordinates(tooth_no,image_side){
	var x1=0;  var y1=0;
	var x2=0;  var y2=0;
	var coordinates = "";
	/*
	//for Upper Arch from left to right				//	FDI Tooth NO
	drawLineForRoot("rootLayer1",20,1,20,30,"red"); //	18 Line Coordinates of R1: 18,0,22,34
	drawLineForRoot("rootLayer4",19,1,22,30,"red"); //	15 
	drawLineForRoot("rootLayer5",19,0,22,30,"red"); //	14 

	drawLineForRoot("rootLayer6",17,1,21,30,"red"); //	13 
	drawLineForRoot("rootLayer7",19,1,19,30,"red"); //	12 
	drawLineForRoot("rootLayer8",19,0,21,30,"red"); //	11 
	drawLineForRoot("rootLayer9",19,0,21,30,"red"); //	21
	drawLineForRoot("rootLayer10",19,0,21,30,"red");//	22 
	drawLineForRoot("rootLayer11",20,0,21,30,"red");//	23
	drawLineForRoot("rootLayer12",20,0,21,30,"red");//	24
	drawLineForRoot("rootLayer13",19,0,21,30,"red");//	25
	drawLineForRoot("rootLayer16",19,0,21,30,"red");//	28

	//for Lower Arch from right to left				//	FDI Tooth NO
	drawLineForRoot("rootLayer20",19,0,21,30,"red");//	35
	drawLineForRoot("rootLayer21",20,0,21,30,"red");//	34
	drawLineForRoot("rootLayer22",20,0,21,30,"red");//	33
	drawLineForRoot("rootLayer23",20,0,21,30,"red");//	32
	drawLineForRoot("rootLayer24",20,0,21,30,"red");//	31
	drawLineForRoot("rootLayer25",20,0,21,30,"red");//	30
	drawLineForRoot("rootLayer26",20,0,21,30,"red");//	29
	drawLineForRoot("rootLayer27",20,0,21,30,"red");//	28
	drawLineForRoot("rootLayer28",20,0,21,30,"red");//	27
	drawLineForRoot("rootLayer29",20,1,19,30,"red");//	26

	drawLineForRoot("rootLayer30",18,2,11,30,"red");//	25
	drawLineForRoot("rootLayer30",25,2,30,30,"red");//	25
	*/
	//Format is x1#y1#x2#y2
	if(tooth_no=="1") coordinates = "20#1#20#29";
	if(tooth_no=="2"){ 
		if(image_side=="11")
			coordinates = "19#3#11#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "21#2#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "19#3#11#29#21#2#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="3"){ 
		if(image_side=="12")
			coordinates = "12#3#12#29"; // Yet to Finalize
		else if(image_side=="13")
			coordinates = "19#3#21#23"; // Yet to Finalize
		else if(image_side=="14")
			coordinates = "29#9#28#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "12#3#12#29#19#3#21#23#29#9#28#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="4" || tooth_no=="33") coordinates = "19#1#22#29";
	if(tooth_no=="5" || tooth_no=="34") coordinates = "19#0#22#29";
	if(tooth_no=="6" || tooth_no=="35") coordinates = "17#1#21#29";
	if(tooth_no=="7" || tooth_no=="36") coordinates = "19#1#19#29";
	if(tooth_no=="8" || tooth_no=="37") coordinates = "21#1#19#29";
	if(tooth_no=="9"  || tooth_no=="38") coordinates = "19#1#21#29";
	if(tooth_no=="10"  || tooth_no=="39") coordinates = "19#0#21#29";
	if(tooth_no=="11" || tooth_no=="40") coordinates = "23#1#18#29";
	if(tooth_no=="12" || tooth_no=="41") coordinates = "21#1#20#29";
	if(tooth_no=="13" || tooth_no=="42") coordinates = "19#0#21#29";

	if(tooth_no=="14"){ 
		if(image_side=="12")
			coordinates = "12#6#10#29"; // Yet to Finalize
		else if(image_side=="13")
			coordinates = "20#3#18#23"; // Yet to Finalize
		else if(image_side=="14")
			coordinates = "30#5#23#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "12#6#10#29#20#3#18#23#30#5#23#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="15"){ 
		if(image_side=="13")
			coordinates = "18#4#15#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "25#6#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#4#15#29#25#6#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="16") coordinates = "19#1#21#29";
	if(tooth_no=="17"){ 
		if(image_side=="11")
			coordinates = "8#5#23#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "24#4#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "8#5#23#29#24#4#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="18"){ 
		if(image_side=="11")
			coordinates = "10#2#19#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "28#2#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#19#29#28#2#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="19"){ 
		if(image_side=="11")
			coordinates = "10#2#15#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "26#2#30#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#15#29#26#2#30#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="20" || tooth_no=="43") coordinates = "18#1#23#29";
	if(tooth_no=="21" || tooth_no=="44") coordinates = "20#2#19#29";
	if(tooth_no=="22" || tooth_no=="45") coordinates = "20#2#19#29";
	if(tooth_no=="23" || tooth_no=="46") coordinates = "18#1#21#29";
	if(tooth_no=="24" || tooth_no=="47") coordinates = "18#1#23#29";
	if(tooth_no=="25" || tooth_no=="48") coordinates = "21#1#17#29";
	if(tooth_no=="26" || tooth_no=="49") coordinates = "20#1#19#29";
	if(tooth_no=="27" || tooth_no=="50") coordinates = "20#1#19#29";
	if(tooth_no=="28" || tooth_no=="51") coordinates = "20#1#19#29";
	if(tooth_no=="29" || tooth_no=="52") coordinates = "22#2#17#29";

	if(tooth_no=="30"){ 
		if(image_side=="11")
			coordinates = "18#3#10#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "29#2#25#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#10#29#29#2#25#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="31"){ 
		if(image_side=="11")
			coordinates = "18#2#12#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "28#2#22#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#2#12#29#28#2#22#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="32"){ 
		if(image_side=="11")
			coordinates = "18#3#13#28"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "28#2#22#28"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#13#28#28#2#22#28"; // Yet to Finalize
		}
	}
	return coordinates;
}
function drawLineForRootImage(imageLayer,image_side,dentalChartFormObj,condition_type,tab_name,tooth_no,status){
	var status_int = 0;
	status_int = parseInt(status);

	if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
		var color = "";
		
		if((tab_name=="DC" || tab_name=="C") && condition_type=="ROOTINV"){
			color="RED";
		}
		else if(condition_type=="ROOTINV"){
			color="RED";
		}
		else if(tab_name=="ET"){
			color="LIGHTGREEN";
		}
		else if(tab_name == "T" && (status_int == 60 || status_int == 85)){
			color="LIGHTGREEN";
		}
		else if((tab_name=="ET" || tab_name=="T") && condition_type=="ROOTTMT"){
			color="LIGHTGREEN";
		}
		

		if(status == 'E'){
			color = "WHITE";
		}
		else if(status_int >= 10 && (status_int < 60 || status_int < 85)){
			color="YELLOW";
		}
		var x1=0;  var y1=0;
		var x2=0;  var y2=0;
		x1=20; y1=1; x2=20; y2=30;
		var coordinates = getCoordinates(tooth_no,image_side);
		//var coordinates = "10#7#12#4#14#6#14#11#14#16#15#20#20#23#22#24#22#29#19#30#16#29#13#30#11#25#10#21#10#15#10#9";
		var corrd_arr = coordinates.split("#");
		x1=parseInt(corrd_arr[0]); 
		y1=parseInt(corrd_arr[1]); 
		x2=parseInt(corrd_arr[2]); 
		y2=parseInt(corrd_arr[3]); 
		
		//if(condition_type=="ROOTINV" || condition_type=="ROOTTMT" || condition_type=="TOOTHTM"){
			if(color != "" && color != null && color != "null" && color != "undefined"){
				drawLineForRoot(imageLayer,x1,y1,x2,y2,color); //	18 Line Coordinates of R1: 18,0,22,34
				drawLineForRoot(imageLayer,(x1+1),y1,(x2+1),y2,color); // Draw an adjacent line to make it dark line
			}
		//}
	}
  }

  function drawCircleForRoot(tooth_no,image_side,dentalChartFormObj,condition_type,tab_name,tooth_no,status){
	  var imageLayer = "rootLayer"+tooth_no;
	  var color = "red";

	  if(status == 'E'){
			color = "WHITE";
		}
	  if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
		  if((tooth_no >= 1 && tooth_no <= 16 ) || (tooth_no >= 33 && tooth_no <= 43)){
			 var coordinates = "7#1#25#8";  // For Upper Arch
		  }
		  else{
			   var coordinates = "7#20#25#12"; // For Lower Arch
		  }
		  var corrd_arr = coordinates.split("#");
		  x1=parseInt(corrd_arr[0]); 
		  y1=parseInt(corrd_arr[1]); 
		  x2=parseInt(corrd_arr[2]); 
		  y2=parseInt(corrd_arr[3]); 

		  
		  drawCircle(imageLayer,x1,y1,x2,y2,color);
		  drawCircle(imageLayer,(x1+1),y1,(x2),y2,color);
		  drawCircle(imageLayer,(x1+2),y1,(x2),y2,color);
	  }

  }
var shapesArray=new Array()

function fillPolygon(imageLayer, xCords,yCords, color,shapeId){
	var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var imageGraphics =new jsGraphics(imageLayer,obj);
	imageGraphics.setColor(color)
	imageGraphics.fillPolygon(xCords,yCords);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}

function clearShape(shapeId){
	shapesArray[shapeId].clear();
}

function fillRect(imageLayer, x,y,height,width,color,shapeId){
	var imageGraphics =new jsGraphics(imageLayer);
	imageGraphics.setColor(color)
	imageGraphics.fillRect(x,y,height,width);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}

function drawLineForRoot(imageLayer,x,y,w,h,color){
	var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var imageGraphics =new jsGraphics(imageLayer,obj);
	imageGraphics.setColor(color)
	imageGraphics.drawLine(x,y,w,h);
	imageGraphics.paint();
}

function drawCircle(imageLayer, x,y,height,width,color,shapeId){
	var imageGraphics =new jsGraphics(imageLayer);
	imageGraphics.setColor(color)
	imageGraphics.drawEllipse(x,y,height,width);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}
