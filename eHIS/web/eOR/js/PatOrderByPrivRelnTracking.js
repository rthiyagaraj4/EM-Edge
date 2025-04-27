/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function dummy(){}
	function hideToolTip(obj,imgObj,row)	
	{
		dynamichide(obj, window.event,row);
	}


	function callMouseOver(obj)	
	{
		currClass = obj.className ;
		obj.className = 'selectedcontextMenuItem';

	}

	function callOnMouseOut(obj)
	{
		obj.className = 'contextMenuItem';
	}


	
	function displayToolTip(val,ord_cat,orderId,sex,patient_id,order_line_num,orderctlHDR,imgObj)
	{
		
		callMouseOverOnTD(orderctlHDR,imgObj);
		buildTable (val,ord_cat,orderId,sex,patient_id,order_line_num,orderctlHDR);		
	}
	
	function buildTable(val,ord_cat,orderId,sex,patient_id,order_line_num,orderctlHDR) 
	{
	    var rowval   = val.split (",");
		var row      = ("View,ViewReplacedOrder,ViewOriginalOrder");
		rowval1      = row.split(",");
		var tab_dat  = "<table id='tooltiptable1' class='contextMenu' width='100%' height='100%' align='center'>"
		for( var i=0; i<rowval.length; i++ ) {
			
			var colval  = rowval[i];
			var colval1 = rowval1[i];
			if (colval != "" )
			{
				tab_dat     += "<tr>"
				tab_dat     += "<td class = 'contextMenuItem' nowrap id='mouse' onMouseOver='callMouseOver(this)' onMouseOut='callOnMouseOut(this);'><a class= 'contextMenuLink' href=javascript:callMenuFunctions('"+colval1+"','"+escape(ord_cat)+"','"+orderId+"','"+sex+"','"+patient_id+"','"+order_line_num+"')>"+colval+" </a></td>"
				tab_dat     += "</tr> "
			}
		}
		tab_dat     += "</table> "
		document.getElementById("t").innerHTML = tab_dat;
		var orderctlHDR1 = orderctlHDR.id;

        var element = document.getElementById(orderctlHDR1);
		var wdth = element.offsetWidth;
		var hght1 = element.offsetHeight;
		/*var wdth = eval("document.all."+orderctlHDR1).offsetWidth;
		var hght1 = eval("document.all."+orderctlHDR1).offsetHeight;*/		
		
		var wdth1 = getPos(orderctlHDR).x +wdth;
		var hght = getPos(orderctlHDR).y ;	

		bodwidth  = document.body.offsetWidth
		bodheight = document.body.offsetHeight
	
		var z = bodwidth- (event.x + wdth);	
		
		var x 	  = event.x;
		var y 	  = event.y;	

		x 	  = x + (document.getElementById("tooltiplayer").offsetWidth);
		y 	  = hght + (document.getElementById("tooltiplayer").offsetHeight);	

		if(x<bodwidth)
		{
			x= wdth1;			
		}
		else
		{			
			x = getPos(orderctlHDR).x;
		}
		if(y<bodheight)
		{			
			y = hght;
			
		}
		else
		{
			y = y - (document.getElementById("tooltiplayer").offsetHeight*2) + hght1 ;	
		}
		document.getElementById("tooltiplayer").style.posLeft= x;
		document.getElementById("tooltiplayer").style.posTop = y;
		document.getElementById("tooltiplayer").style.visibility='visible';
	}

	
