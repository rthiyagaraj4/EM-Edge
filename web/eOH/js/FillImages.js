	/*
	  image_side : L (Left), R(Right), T(Top), D(Down), LO(Left Occlusal), RO(Right Occlusal),BR(Both Rect), 
					LI(Left Incisal), RI(Right Incisal)
	
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


 function fillCrownImages(imageLayer,image_side,dentalChartFormObj,condition_type,status,tooth_no,called_from,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,treatments_outcome){
	var fill_color = "";						   
	var status_int = 0;
	var formObj1 = document.forms[0];
	if(formObj1 == "null" || formObj1 == null){ //Added by Sridevi Joshi on 11/30/2009 for IN016115 (16115-2711-8.ppt)
		formObj1 = dentalChartFormObj.document.forms[0];
	}
	var permanent_deciduous_flag="";
	if(condition_type == "CARIES"){
		permanent_deciduous_flag = formObj1.permanent_deciduous_flag.value;
	}else if(condition_type == "CROWN"){
		permanent_deciduous_flag = dentalChartFormObj.document.forms[0].permanent_deciduous_flag.value;
	}	
	if(status != "E" || status != "null" || status != "" || status != null ){
		status_int = parseInt(status);
	}

	if(dentalChartFormObj.document.getElementById(imageLayer)!=null  && dentalChartFormObj.document.getElementById(imageLayer)!="" && dentalChartFormObj.document.getElementById(imageLayer)!="null"){
		//To retrieve the Arch...
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "tooth_no="+tooth_no;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		if(called_from == "SERVLET_RECORD"){
			xmlHttp.open("POST","../eOH/jsp/CommonValidation.jsp?func_mode=getArchSno&"+params,false);
		}
		else{
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=getArchSno&"+params,false);
		}
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var arch_sno = localTrimString(retVal);
		
		//Selecting the fill color according to the condition_type
		
		if(condition_type == "PULPINV"){
			if (treatments_outcome=="F"){
				fill_color = "BROWN"		   
				image_side = "BR";
			}else{
				fill_color = "RED"		   
				image_side = "BR";
			}
		}
		else if(condition_type == "CARIES")
		{
			//fill_color = "black";// commented by parul on 11/08/2009 for CRF 0494 (To change color indicator for caries condition to Blue color )
			if (treatments_outcome=="F"){
				fill_color = "BROWN"		   
			}else{
				fill_color = "blue";
			}
		}
		else{
		//if(condition_type != "PULPINV" && condition_type != "CARIES"){
			if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){ // planned
			
				if (treatments_outcome=="F"){
					fill_color = "BROWN"		   
				}else{
					fill_color = "YELLOW";
				}
			}
			else if(status_int != 85){
				if (treatments_outcome=="F"){
					fill_color = "BROWN"		   
				}else{
					fill_color = "LIGHTGREEN";
				}
			}
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
		
		/*
		if(condition_type != "PULPINV" && condition_type != "CARIES"){
			if(status_int >= 10 && (status_int < 60 || status_int < 85)){ // planned
				fill_color = "YELLOW";
			}
			else{
				fill_color = "LIGHTGREEN";
			}
		}
		*/


		 // Surface Decoding
		/*
		if(image_side == 1){
			image_side  = "T";
		}
		else if(image_side == 2){
			image_side  = "T";
		}
		*/
								   
		if(image_side == 1){	 //Labial
			if(arch_sno == "L"){
				image_side  = "B";
			}
			else if(arch_sno == "U"){
				image_side  = "T";
			}
		}
		else if(image_side == 2){	//Buccal
			if(arch_sno == "L"){
				image_side  = "B";
			}
			else if(arch_sno == "U"){
				image_side  = "T";
			}
		}
		else if(image_side == 3){	//Distal
			image_side  = "L";
		}
		else if(image_side == 4){	//Mesial
			image_side  = "R";
		}
		/*
		else if(image_side == 5){
			image_side  = "B";
		}
		else if(image_side == 6){
			image_side  = "B";
		}
		*/
		else if(image_side == 5){	//Lingual
			if(arch_sno == "L"){
				image_side  = "T";
			}
		}
		else if(image_side == 6){	//Palatal
			if(arch_sno == "U"){
				image_side  = "B";
			}
		}
		else if(image_side == 7){	//Incisal
			image_side  = "BR";
		}
		else if(image_side == 8){	//Occulusal
			image_side  = "BR";
		}
		else if(image_side == 9){	//Mesio Occulusal
			image_side  = "RO";
		}
		else if(image_side == 10){	//Disto Occulusal
			image_side  = "LO";
		}
		//Added By Sharon Crasta on 5/14/2009 for IN010839
		else if(image_side == 15){	//Mesio Incisal
			image_side  = "RI";
		}
		else if(image_side == 16){	//Disto Incisal
			image_side  = "LI";
		}
		//
		if(status != null && status != "null" && status == "E"){
			fill_color = "white";
			if(image_side == "BR" || condition_type == "PULPINV"){
				image_side = "";
				fillRect(imageLayer,9,9,11,7,fill_color);
				fillRect(imageLayer,21,9,11,7,fill_color);
			}
			
		}

		var tooth_no_int = parseInt(tooth_no);
		//Crown and Root filling with co-ordinates.
		if(image_side=="T"){
			fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color);
			//fillPolygon(imageLayer,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7),fill_color,new Array(3,35,34,32,31,7),new Array(2,2,3,5,6,7));
			//fillPolygon(imageLayer,new Array(3,35,34,32,31,7),new Array(2,2,3,5,6,6),fill_color,new Array(4,36,35,33,32,8),new Array(3,3,4,6,7,7));

		}
		else if(image_side=="L"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN
			//if(tooth_no == "9" || tooth_no == "10" || tooth_no == "11" ||tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21" || tooth_no == "22" || tooth_no == "23" || tooth_no == "24"){
			if(permanent_deciduous_flag == "P"){
				
				if(parseInt(tooth_no_int) >= "9" && parseInt(tooth_no_int) <= "24"){
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);	
				}else{
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
								
				}
			}
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "38" && tooth_no_int <= "47") || (tooth_no_int >= "14" && tooth_no_int <= "19")) {
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
				}else{
				//
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
				}
			}
		}
		else if(image_side=="B"){
			fillPolygon(imageLayer,new Array(4,8,32,36),new Array(21,17,17,21),fill_color);
		}
		else if(image_side=="R"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN
			//if(tooth_no == "9" || tooth_no == "10" || tooth_no == "11" ||tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21" || tooth_no == "22" || tooth_no == "23" || tooth_no == "24"){
			 if(permanent_deciduous_flag == "P"){
				if(tooth_no_int >= "9" && tooth_no_int <= "24"){
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
				}else{
				//
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
				}
			}
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "38" && tooth_no_int <= "47")|| (tooth_no_int >= "14" && tooth_no_int <= "19")){
					fillPolygon(imageLayer,new Array(3,7,7,3),new Array(20,16,8,4),fill_color);
				}else{
				//
					fillPolygon(imageLayer,new Array(33,33,37,37),new Array(8,16,20,4),fill_color);
				}
			}
		}else if(image_side=="RO"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN
			//if(tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21"){
			 if(permanent_deciduous_flag == "P"){
				//if(tooth_no_int >= "12" && tooth_no_int <= "21"){
				if((tooth_no_int >= "1" && tooth_no_int <= "5") || (tooth_no_int >= "28" && tooth_no_int <= "32")){
					fillRect(imageLayer,21,9,11,7,fill_color);
				}else{
					fillRect(imageLayer,9,9,11,7,fill_color);		
				}
			}
			
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "41" && tooth_no_int <= "44") || (tooth_no_int >= "14" && tooth_no_int <= "19")){
					fillRect(imageLayer,9,9,11,7,fill_color);
				}else{
				//
					fillRect(imageLayer,21,9,11,7,fill_color);		
				}
			}
		}else if(image_side=="LO"){
			//Added by Sharon Crasta on 3/5/2009 to get the mirror images when the site typ is CROWN		
			//if(tooth_no == "12" || tooth_no == "13" || tooth_no == "14" || tooth_no == "15" || tooth_no == "16" || tooth_no == "17" || tooth_no == "18" || tooth_no == "19" || tooth_no == "20" || tooth_no == "21"){
			 if(permanent_deciduous_flag == "P"){
			//	if(tooth_no_int >= "12" && tooth_no_int <= "21"){
				if((tooth_no_int >= "1" && tooth_no_int <= "5") || (tooth_no_int >= "28" && tooth_no_int <= "32")){
					fillRect(imageLayer,9,9,11,7,fill_color);					
				}
				else{
					fillRect(imageLayer,21,9,11,7,fill_color);		
					}
			}
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "41" && tooth_no_int <= "44")|| (tooth_no_int >= "14" && tooth_no_int <= "19")){
					fillRect(imageLayer,21,9,11,7,fill_color);		
				}else{
				//
					fillRect(imageLayer,9,9,11,7,fill_color);	
				}
			}
		}
		//Added by Sharon Crasta on 5/14/2009 for IN010839
		else if(image_side=="RI"){
			 if(permanent_deciduous_flag == "P"){
				if((tooth_no_int >= "6" && tooth_no_int <= "8")||(tooth_no_int >= "25" && tooth_no_int <= "27")){
					//fillRect(imageLayer,9,9,11,7,fill_color);
					fillRect(imageLayer,21,9,11,7,fill_color);	
				}else{
					//fillRect(imageLayer,21,9,11,7,fill_color);		
					fillRect(imageLayer,9,9,11,7,fill_color);
				}
			}
			if(permanent_deciduous_flag == "D"){
				//if((tooth_no_int >= "35" && tooth_no_int <= "40")||(tooth_no_int >= "45" && tooth_no_int <= "50")){
				if((tooth_no_int >= "35" && tooth_no_int <= "37")||(tooth_no_int >= "48" && tooth_no_int <= "50")){
						//fillRect(imageLayer,9,9,11,7,fill_color);
					fillRect(imageLayer,21,9,11,7,fill_color);		

				}else{
				//
					fillRect(imageLayer,9,9,11,7,fill_color);		
				}
			}
		}else if(image_side=="LI"){
			 if(permanent_deciduous_flag == "P"){
				if((tooth_no_int >= "6" && tooth_no_int <= "8")||(tooth_no_int >= "25" && tooth_no_int <= "27")){ //1st,4th quadrant
					//fillRect(imageLayer,21,9,11,7,fill_color);		
					fillRect(imageLayer,9,9,11,7,fill_color);
				}
				else{
					//fillRect(imageLayer,9,9,11,7,fill_color);
					fillRect(imageLayer,21,9,11,7,fill_color);//2nd,3rd quadrant
				}
			}
			if(permanent_deciduous_flag == "D"){
				if((tooth_no_int >= "35" && tooth_no_int <= "37")||(tooth_no_int >= "48" && tooth_no_int <= "50")){
					//fillRect(imageLayer,21,9,11,7,fill_color);		
					fillRect(imageLayer,9,9,11,7,fill_color);	
				}else{
				//
					fillRect(imageLayer,21,9,11,7,fill_color);	
				}
			}
		}else if(image_side=="BR"){
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
	
		//Added by Sharon Crasta on 11/3/2008 for SCR #6141
		//Added to reload the condition on the tooth once treatment is marked as Error.
		if(status != null && status != "null" && status == "E"){
			// Condition_type is mentioned so that only when the CROWN treatment is marked 
			//as Error E since CARIES and PULPINV can also be marked as E.
			//if(condition_type == "CROWN"){	
				/*
				 var dentalChartFillImagesObj = document.forms[0];
				 var tab_name = dentalChartFillImagesObj.tab_name.value;
				if(tab_name == "ET" || tab_name == "DC"){ // External Treatment and Dental Condition in Condition tab
					dentalChartFillImagesObj = 	parent.parent.frames[1].document.forms[0];
				}
				else {
					dentalChartFillImagesObj = parent.frames[1].document.forms[0];				
				} 	
				//getAllImagesFromDB('fill_images',dentalChartFillImagesObj,tab_name);
				*/
				/* Added by Sridevi Joshi on 18/11/08 for SCR-6141(SRR20056-SCF-2464 )*/

				var formObj = document.forms[0];
				var site_type = "CROWN";//formObj.oh_site.value;
				var tab_name = formObj.tab_name.value;
				var chart_num = formObj.chart_num.value;				
				getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,'',total_SuperKey_count,super_recorded);

				/* end here */
			}
		//}
		//End 
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
		//Commented by Sharon Crasta on 5/14/2009 for IN010839
		/*if(image_side=="11")
			coordinates = "19#3#11#29"; // Yet to Finalize
		else if(image_side=="12")
			coordinates = "21#2#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "19#3#11#29#21#2#27#29"; // Yet to Finalize
		} */
		//
		if(image_side=="12")
			//coordinates = "12#3#12#29"; // Yet to Finalize
			coordinates = "19#22#19#8";
		else if(image_side=="13")
			//coordinates = "19#3#21#23"; // Yet to Finalize
			coordinates = "21#2#27#29";
		else if(image_side=="14")
			//coordinates = "29#9#28#29"; // Yet to Finalize
			coordinates = "19#3#11#29";
		else if(image_side == "ALL"){
			coordinates = "19#22#19#8#21#2#27#29#19#3#11#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="3"){ 
		if(image_side=="12")
			//coordinates = "12#3#12#29"; // Yet to Finalize
			coordinates = "19#3#21#23";
		else if(image_side=="13")
			//coordinates = "19#3#21#23"; // Yet to Finalize
			coordinates = "29#9#28#29";
		else if(image_side=="14")
			//coordinates = "29#9#28#29"; // Yet to Finalize
			coordinates = "12#3#12#29";
		else if(image_side == "ALL"){
			coordinates = "19#3#21#23#29#9#28#29#12#3#12#29"; // Yet to Finalize
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
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="12")
		if(image_side=="14")
			//coordinates = "12#6#10#29"; // Yet to Finalize
			coordinates = "30#5#23#29";
		else if(image_side=="13")
			//coordinates = "20#3#18#23"; // Yet to Finalize
			 coordinates = "12#6#10#29";
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="14")
		else if(image_side=="12")
			//coordinates = "30#5#23#29"; // Yet to Finalize
			coordinates = "20#3#18#23"; 
		else if(image_side == "ALL"){
			coordinates = "30#5#23#29#12#6#10#29#20#3#18#23"; // Yet to Finalize
		}
	}
	if(tooth_no=="15"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="13")
		/*Commented by Sharon Crasta on 5/14/2009 for IN010839*/
		/*if(image_side=="12")
			coordinates = "18#4#15#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="13")
			coordinates = "25#6#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#4#15#29#25#6#27#29"; // Yet to Finalize	*/
		/*End*/
		if(image_side=="12")
			coordinates = "22#24#22#8";
		else if(image_side=="13")
			coordinates = "18#4#15#29";
		else if(image_side=="14")
			coordinates = "25#6#27#29";
		else if(image_side == "ALL"){
			coordinates = "22#24#22#8#18#4#15#29#25#6#27#29"; // Yet to Finalize	
		}
	}
	if(tooth_no=="16") coordinates = "19#1#21#29";
	if(tooth_no=="17"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "8#5#23#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "24#4#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "8#5#23#29#24#4#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="18"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "10#2#19#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
			coordinates = "28#2#27#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#19#29#28#2#27#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="19"){ 
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//if(image_side=="11")
		if(image_side=="17")
			coordinates = "10#2#15#29"; // Yet to Finalize
		//Commented by Sharon on 3/5/2009 to get the mirror image when site type is ROOT
		//else if(image_side=="12")
		else if(image_side=="18")
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
		if(image_side=="18")
			coordinates = "18#3#10#29"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "29#2#25#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#10#29#29#2#25#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="31"){ 
		if(image_side=="18")
			coordinates = "18#2#12#29"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "28#2#22#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#2#12#29#28#2#22#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="32"){ 
		if(image_side=="18")
			coordinates = "18#3#13#28"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "28#2#22#28"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#13#28#28#2#22#28"; // Yet to Finalize
		}
	}

	//Added for IN009202 (SRR20056-CRF-0455) by Sridevi Joshi 15/07/09
	if(tooth_no=="33" || tooth_no=="34"){ 
		if(image_side=="12")
			coordinates = "19#3#21#23";
		else if(image_side=="13")
			coordinates = "29#9#28#29";
		else if(image_side=="14")
			coordinates = "12#3#12#29";
		else if(image_side == "ALL"){
			coordinates = "19#3#21#23#29#9#28#29#12#3#12#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="41" || tooth_no=="42"){ 
		if(image_side=="14")
			coordinates = "30#5#23#29";
		else if(image_side=="13")
			 coordinates = "12#6#10#29";
		else if(image_side=="12")
			coordinates = "20#3#18#23"; 
		else if(image_side == "ALL"){
			coordinates = "30#5#23#29#12#6#10#29#20#3#18#23"; // Yet to Finalize
		}
	}
	if(tooth_no=="43" || tooth_no=="44"){ 
		if(image_side=="17")
			coordinates = "10#2#15#29"; // Yet to Finalize
		else if(image_side=="18")
			coordinates = "26#2#30#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "10#2#15#29#26#2#30#29"; // Yet to Finalize
		}
	}
	if(tooth_no=="51" || tooth_no=="52"){ 
		if(image_side=="18")
			coordinates = "18#3#10#29"; // Yet to Finalize
		else if(image_side=="17")
			coordinates = "29#2#25#29"; // Yet to Finalize
		else if(image_side == "ALL"){
			coordinates = "18#3#10#29#29#2#25#29"; // Yet to Finalize
		}
	}
	return coordinates;
}
function drawLineForRootImage(imageLayer,image_side,dentalChartFormObj,condition_type,tab_name,tooth_no,status,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,treatments_outcome){
	var status_int = 0;
	//if(!isNaN(status)){
		status_int = parseInt(status);
	//}
	//else{
		//status_int = status;
	//}

	if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
		var color = "";
		// treatments_outcome=="F" ,added by parul for CRF-477 & 496 on 10/02/2010
		if((tab_name=="DC" || tab_name=="C") && condition_type=="ROOTINV"){
           if (treatments_outcome=="F"){
			   color="BROWN";
           }else{
			color="RED";
		   }
		}
		else if(condition_type=="ROOTINV"){
			 if (treatments_outcome=="F"){
			   color="BROWN";
           }else{
				color="RED";
		   }
		}
		else if(tab_name=="ET"){
			 if (treatments_outcome=="F"){
			   color="BROWN";
			}else{
				color="LIGHTGREEN";
			 }
		}
		else if(tab_name == "T" && (status_int == 60)){
			 if (treatments_outcome=="F"){
			   color="BROWN";
           }else{
				color="LIGHTGREEN";
		   }
		}
		else if((tab_name=="ET" && condition_type=="ROOTTMT") || (tab_name=="T" && condition_type=="ROOTTMT" && status_int == 60)){
			 if (treatments_outcome=="F"){
				color="BROWN";
			 }else{
				color="LIGHTGREEN";
			 }
		}
		else if(tab_name == "T" && (isNaN(status))){
			 if (treatments_outcome=="F"){
				   color="BROWN";
			 }else{
					color="LIGHTGREEN";
			 }
		}
		/*
		else if((tab_name=="ET" || tab_name=="T") && condition_type=="ROOTTMT"){
			color="LIGHTGREEN";
		}
		*/
		else{
			if(status_int >= 10 && (status_int < 60 || (status_int <= 85 && status_int != 60))){
				 if (treatments_outcome=="F"){
				   color="BROWN";
			   }else{
					color="YELLOW";
			   }
			}
			else if(status_int != 85){
				if (treatments_outcome=="F"){
					color="BROWN";
				}else{
					color = "LIGHTGREEN";
				}
			}
		}

		if(status == 'E'){
		//	color = "WHITE";
			color = null;
		}
	
		var x1=0;  var y1=0;
		var x2=0;  var y2=0;
		x1=20; y1=1; x2=20; y2=30;
				
		var coordinates = getCoordinates(tooth_no,image_side);
		
		var corrd_arr = coordinates.split("#");
		x1=parseInt(corrd_arr[0]); 
		y1=parseInt(corrd_arr[1]); 
		x2=parseInt(corrd_arr[2]); 
		y2=parseInt(corrd_arr[3]); 
		if(color != "" && color != null && color != "null" && color != "undefined"){
			drawLineForRoot(imageLayer,x1,y1,x2,y2,color,status); //	18 Line Coordinates of R1: 18,0,22,34
			drawLineForRoot(imageLayer,(x1+1),y1,(x2+1),y2,color,status); // Draw an adjacent line to make it dark line
		} 
				
		//Added by Sharon Crasta on 11/7/2008 for SCR #6406
		//Added to reload the condition on the tooth once treatment is marked as Error.
		if(status != null && status != "null" && status == "E"){
			/*
			 var dentalChartFillImagesObj = document.forms[0];
			 var tab_name = dentalChartFillImagesObj.tab_name.value;
			if(tab_name == "ET" || tab_name == "DC"){  // External Treatment and Dental Condition in Condition tab
				dentalChartFillImagesObj = 	parent.parent.frames[1].document.forms[0];
			}
			else {
				dentalChartFillImagesObj = parent.frames[1].document.forms[0];				
			} 
			getAllImagesFromDB('fill_images',dentalChartFillImagesObj,tab_name);
			*/

			var formObj = document.forms[0];
			var site_type = "ROOT";//formObj.site.value;
			var tab_name = formObj.tab_name.value;
			var chart_num = formObj.chart_num.value;
			
			getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,'',total_SuperKey_count,super_recorded);
		}
		//End
	}
  }

  function drawCircleForRoot(tooth_no,image_side,dentalChartFormObj,condition_type,tab_name,tooth_no,status,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,treatments_outcome){
	  var imageLayer = "rootLayer"+tooth_no;
	  var color = "";

	  if (treatments_outcome=="F"){//added by parul for CRF-477 & 496 on 10/02/2010
		  color = "BROWN";
	  }else{
		 color = "red";
	  }

	/*  if(status == 'E'){
			color = "WHITE";
		}*/
	 if(status == 'E'){
			//commented by parul on 12/08/2010 for 23183
			color = "null";
		}
	
	  if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
		//  if((tooth_no >= 1 && tooth_no <= 16 ) || (tooth_no >= 33 && tooth_no <= 43)){//commented by parul on 26/04/2010 for IN020918
		  if((tooth_no >= 1 && tooth_no <= 16 ) || (tooth_no >= 33 && tooth_no <= 42)){
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
          
		  
		  drawCircle(imageLayer,x1,y1,x2,y2,color,status);
		  drawCircle(imageLayer,(x1+1),y1,(x2),y2,color,status);
		  drawCircle(imageLayer,(x1+2),y1,(x2),y2,color,status);
	  }

	  if(status != null && status != "null" && status == "E"){
		  var formObj = document.forms[0];
		var site_type = "ROOT";//formObj.site.value;
		//var tab_name = formObj.tab_name.value;
		var chart_num = formObj.chart_num.value;
		getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,'',total_SuperKey_count,super_recorded);
	  }

  }
var shapesArray=new Array()

function fillPolygon(imageLayer, xCords,yCords, color,shapeId){	
	var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var imageGraphics =new jsGraphics(imageLayer,obj);

	imageGraphics.setColor(color)
	imageGraphics.fillPolygon(xCords,yCords);
	//imageGraphics.setColor("white")    
	//imageGraphics.drawPolygon(xCords,yCords);
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

function drawLineForRoot(imageLayer,x,y,w,h,color,status){
	var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var imageGraphics =new jsGraphics(imageLayer,obj);
	if(status!="E"){//condition added by parul on 12/08/2010 for 23183
		imageGraphics.setColor(color) 
	}else{
		imageGraphics.setColor("null") 
	}
//	imageGraphics.setColor(color)
	imageGraphics.drawLine(x,y,w,h);
	imageGraphics.paint();
}


function drawCircle(imageLayer, x,y,height,width,color,shapeId){
	
	var imageGraphics =new jsGraphics(imageLayer);
	if(shapeId!="E"){//condition added by parul on 12/08/2010 for 23183
		imageGraphics.setColor(color) 
	}else{
		imageGraphics.setColor("null") 
	}
	//imageGraphics.setColor(color)    
	imageGraphics.drawEllipse(x,y,height,width);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;
}

function drawCircle1(imageLayer, x,y,radius,color,shapeId){
	var obj = parent.parent.conditionDentalChartDetails || parent.conditionDentalChartDetails || parent.parent.trmtDentalChartDetails || parent.trmtDentalChartDetails;
	var imageGraphics =new jsGraphics(imageLayer,obj);
	if(shapeId!="E"){//condition added by parul on 12/08/2010 for 23183
		imageGraphics.setColor("WHITE") 
	}else{
		imageGraphics.setColor("null") 
	}
	imageGraphics.fillOval(x,y,radius*2,radius*2);
	imageGraphics.setColor(color)    
	imageGraphics.drawOval(x,y,radius*2,radius*2);
	imageGraphics.paint();
	shapesArray[shapeId]=imageGraphics;

}

//added by parul for crf 0483 on 25/08/2009
 function drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name,super_tooth_ref,exfolth_count,retained_tooth_no,total_SuperKey_count,super_recorded,treatments_outcome){
// function drawCircleForCusp(tooth_no,dentalChartFormObj,status,cusptip_ref,surface_code,tab_name){
	  var imageLayer = "toothLayer"+tooth_no;
	  var color ="";
	  if (treatments_outcome=="F"){
		  color = "BROWN";
	  }else{
		 color = "blue";
	  }
	 
	  if(status == 'E'){
			//color = "WHITE";//commented by parul on 12/08/2010 for 23183
			color = "null";
		}
	
if (cusptip_ref.indexOf(",")!=-1){
	var cusptip_ref_arr=cusptip_ref.split(",");
		 for(var i=0;i<cusptip_ref_arr.length;i++){
			 if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
				   if(surface_code=="2" || surface_code=="6" || surface_code=="5"){
					  var coordinates = getCrownCoordinates(cusptip_ref_arr[i],surface_code,tooth_no);
					      if (coordinates!="undefined" && coordinates!=undefined) {
  	
						  var corrd_arr = coordinates.split("#");
						  x1=parseInt(corrd_arr[0]); 
						  y1=parseInt(corrd_arr[1]); 
						  x2=parseInt(corrd_arr[2]); 
						  y2=parseInt(corrd_arr[3]);

						  drawCircle1(imageLayer,x1,y1,x2,color,status);
						//  drawCircle1(imageLayer,(x1+1),y1,(x2),color);
						  
						  if(status != null && status != "null" && status == "E"){
								var formObj = document.forms[0];
								var site_type = "CROWN";//formObj.oh_site.value;
								var tab_name = tab_name;
								var chart_num = formObj.chart_num.value;
								
								getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,'',total_SuperKey_count,super_recorded);
								
							}
					   }
				   }
			 }
		 }
}else{
		 if(cusptip_ref!="" && cusptip_ref!="null" && cusptip_ref!=null){
			  if(dentalChartFormObj.document.getElementById(imageLayer)!=null){
				  if(surface_code=="2" || surface_code=="6" || surface_code=="5"){
					  var coordinates = getCrownCoordinates(cusptip_ref,surface_code,tooth_no);
					  if (coordinates!="undefined" && coordinates!=undefined) {
						  var corrd_arr = coordinates.split("#");
						  x1=parseInt(corrd_arr[0]); 
						  y1=parseInt(corrd_arr[1]); 
						  x2=parseInt(corrd_arr[2]); 
						  y2=parseInt(corrd_arr[3]);				
							drawCircle1(imageLayer,x1,y1,x2,color,status);
						//	drawCircle(imageLayer,x1,y1,x2,y2,color);
							  if(status != null && status != "null" && status == "E"){
								var formObj = document.forms[0];
								var site_type = "CROWN";//formObj.oh_site.value;
								var tab_name = tab_name;
								var chart_num = formObj.chart_num.value;				
								getImageFromDB(tooth_no,site_type,chart_num,tab_name,formObj,dentalChartFormObj,'',super_tooth_ref,exfolth_count,retained_tooth_no,'',total_SuperKey_count,super_recorded);
							}
					  }
				  }
			  }
		 }
	 }
	 
  }
//added by parul for crf 0483 on 25/08/2009
  function getCrownCoordinates(cusptip_ref,surface_code,tooth_no){
		var x1=0;  var y1=0;
		var x2=0;  var y2=0;
	if (tooth_no>=1 && tooth_no<=8){
		if (surface_code=="2"){
			if (cusptip_ref=="3"){
				var coordinates = "-1#-1#3";//for 1st circle
			}else if (cusptip_ref=="1"){
				var coordinates = "34#0#3";//for 2nd circle				
			}else if (cusptip_ref=="5"){
				var coordinates = "17#-1#3";//upper middle circle
			}
		}else if (surface_code=="6"){
			if (cusptip_ref=="4"){
				var coordinates = "-1#18#3";//lower 4th circle
			}else if (cusptip_ref=="2"){
				var coordinates = "34#18#3";//for down circle 3rd
			}else if (cusptip_ref=="7"){
				var coordinates = "16#19#3";//lower middle circle
			}else if (cusptip_ref=="6"){
				var coordinates = "16#19#3";//lower middle circle
			}else if (cusptip_ref=="9"){
				var coordinates = "-1#18#3";//lower middle circle
			}else if (cusptip_ref=="8"){
				var coordinates = "34#18#3";//lower middle circle
			}else if (cusptip_ref=="10"){
				var coordinates = "16#19#3";//lower middle circle
			}
		}
	}else if (tooth_no>=25 && tooth_no<=32){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates = "16#19#3";
			   }else if (cusptip_ref=="3"){
				   var coordinates = "-1#18#3";
			   }else if (cusptip_ref=="1"){
				   var coordinates = "34#18#3";
			   } else if (cusptip_ref=="7") {
				   var coordinates = "16#19#3";
			   }
			}else if (surface_code=="5"){
				 if (cusptip_ref=="4"){
				var coordinates = "-1#0#3";
				 }else  if (cusptip_ref=="2"){
				var coordinates = "34#0#3";
				 }else  if (cusptip_ref=="6"){
				var coordinates = "17#-1#3";
				 }
			}
	}else if (tooth_no>=17 && tooth_no<=25){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates = "16#19#3";
			   }else if (cusptip_ref=="3") {
				   var coordinates = "34#18#3";
			   }
			   else if (cusptip_ref=="1") {
				   var coordinates = "-1#18#3";
			   }else if (cusptip_ref=="7") {
				   var coordinates = "16#19#3";
			   }
			}else if (surface_code=="5"){
				if (cusptip_ref=="4"){
					var coordinates = "34#0#3";
				}else if (cusptip_ref=="2"){
					var coordinates = "-1#0#3";
				}else if (cusptip_ref=="6"){
					var coordinates = "17#-1#3";
				}
			}
	}else if (tooth_no>=9 && tooth_no<=16){
			 if (surface_code=="6"){
				if (cusptip_ref=="7"){
					var coordinates = "16#19#3";
				}else if (cusptip_ref=="4"){
					var coordinates = "34#18#3";
				}else if (cusptip_ref=="2"){
					var coordinates = "-1#18#3";
				}else if (cusptip_ref=="6"){
					var coordinates = "16#19#3";
				}else if (cusptip_ref=="10"){
					var coordinates = "16#19#3";
				}else if (cusptip_ref=="9"){
					var coordinates = "34#18#3";
				}else if (cusptip_ref=="8"){
					var coordinates = "-1#18#3";
				}
			}else if (surface_code="2"){
				if (cusptip_ref=="3"){
					var coordinates = "34#0#3";
				}else if (cusptip_ref=="1"){
					var coordinates = "-1#0#3";
				}else if (cusptip_ref=="6"){
					var coordinates = "17#-1#3";
				}else if (cusptip_ref=="5"){
					var coordinates = "17#-1#3";//upper middle
				}
			}
	}else if (tooth_no>=33 && tooth_no<=41){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates = "17#-1#3";
			   }else if (cusptip_ref=="3"){
				   var coordinates = "-1#0#3";//for 1st circle	
			   }else if (cusptip_ref=="1"){
				   var coordinates =  "34#0#3";//for 2nd circle			
			   }
		}else if (surface_code=="6"){
			   if (cusptip_ref=="10"){
				   var coordinates = "16#19#3";//lower middle circle
			   }else if (cusptip_ref=="9"){
				   var coordinates ="-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="8"){
				   var coordinates ="34#18#3";//for down circle 3rd
			   }
		}
	}else if (tooth_no==51 || tooth_no==52){
			if (surface_code=="2"){
			   if (cusptip_ref=="5"){
				   var coordinates =  "16#19#3";//lower middle circle	
			   }else if (cusptip_ref=="3"){
				   var coordinates = "-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="1"){
				   var coordinates =  "34#18#3";//for down circle 3rd	
			   }else if (cusptip_ref=="7"){
				   var coordinates =  "16#19#3";//lower middle circle	
			   }
		}else if (surface_code=="5"){
			   if (cusptip_ref=="4"){
				   var coordinates = "-1#0#3";//for 1st circle
			   }else if (cusptip_ref=="2"){
				   var coordinates ="34#0#3";//for 2nd circle	
			   }else if (cusptip_ref=="6"){
				   var coordinates ="17#-1#3";//upper middle
			   }
		}
	}else if (tooth_no<=42){
		 if (surface_code=="2"){
			   if (cusptip_ref=="3"){
				   var coordinates ="34#0#3";//for 2nd circle		
			   }else if (cusptip_ref=="1"){
				   var coordinates = "-1#0#3";//for 1st circle
			   }else if (cusptip_ref=="5"){
				   var coordinates ="17#-1#3";//upper middle
			   }
		 }else  if (surface_code=="6"){
			   if (cusptip_ref=="9"){
				   var coordinates = "34#18#3";//for down circle 3rd
			   }else if (cusptip_ref=="8"){
				   var coordinates =  "-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="10"){
				   var coordinates = "16#19#3";//lower middle circle	
			   }
		 }
	}else if (tooth_no==44 || tooth_no==43){
		 if (surface_code=="2"){
			   if (cusptip_ref=="3"){
				   var coordinates ="34#18#3";//for down circle 3rd
			   }else if (cusptip_ref=="1"){
				   var coordinates = "-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="7"){
				   var coordinates =  "16#19#3";//lower middle circle	
			   }else if (cusptip_ref=="5"){
				   var coordinates =  "16#19#3";//lower middle circle	
			   }
		 }else  if (surface_code=="5"){
			   if (cusptip_ref=="6"){
				   var coordinates =  "17#-1#3";//upper middle
			   }else if (cusptip_ref=="8"){
				   var coordinates =  "-1#18#3";//lower 4th circle
			   }else if (cusptip_ref=="4"){
				   var coordinates = "34#0#3";//for 2nd circle		
			   }else if (cusptip_ref=="2"){
				   var coordinates = "-1#0#3";//for 1st circle
			   }
		 }
	}
	    return coordinates;
}
