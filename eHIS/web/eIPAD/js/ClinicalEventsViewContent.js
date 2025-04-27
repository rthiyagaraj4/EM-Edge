$(document).ready(function() {
	
    path = $('#hdnPath').val();
    parent.setOnLoadContentPaneHeight();
    
	
	CEMainScroll = new IScroll('#ChartSummaryMainWrapper', {
            scrollX: false,
        scrollY: true,
        scrollbars: true,
        interactiveScrollbars: true,
        click: true,
        useTransition: false,
        bindToWrapper: true,
        mouseWheel: true ,
        disableMouse: false,
    disablePointer: true
    });

	function setHeightAndBase(){
		var fromTopValues=0;
		$("div[data-notes]").each( function (index, value) {
			var dataNotes =$(this).attr('data-notes');
            var headerID = dataNotes;
			var headerTop= $("#"+headerID).height();
	        $(this).attr('data-start', fromTopValues);
            fromTopValues=fromTopValues+headerTop;
            $(this).attr('data-height', headerTop);
            $(this).attr('data-end', fromTopValues);
        });
	}
	
	function getMinMaxDate(){
		var visibleDatesArr=[];
				
		$("div[data-notes]").each( function (index, value) {			
			var divDisp = $(this).attr('data-disp');
			var divPos = $(this).attr('data-positions');
			if(divDisp == "display"){
				visibleDatesArr.push(divPos);
			}
		});	
		return visibleDatesArr;
	}
	
	function scrollToAnElement(vals){
	var visibleDatesArr = getMinMaxDate();
	var minValue=visibleDatesArr[0];
	var maXvalue=visibleDatesArr[visibleDatesArr.length-1];
		
	$("div[data-notes]").each( function (index, value) {
	        var data_start =$(this).attr('data-start');
			var data_end =$(this).attr('data-end');
			var divDisp = $(this).attr('data-disp');
			var divPos = $(this).attr('data-positions');
			var divHeight=  $(this).attr('data-height');
			var divPos = $(this).attr('data-positions');
			var divDate = $(this).attr('data-date');
	         if(minValue==index){
	
	         loadDataOnEnd(divDate,divPos,"min",minValue,maXvalue,vals);
	
	       }
	
	});
	
	
	
	       
	
	
	
	}
	function removeAttribute(){

	
	$("div[data-notes]").each( function (index, value) {			
			var divRem = $(this).attr('data-removed');
			var divHeig = $(this).attr('data-previous');
			
			if(divRem == "yes"){
				$(this).removeAttr('data-removed');
				$(this).removeAttr('data-previous');
			}
		});	
	}
	function updatePosition(){
		var vals=(-1)*(CEMainScroll.y);
		 removeAttribute();
		var visibleDatesArr = getMinMaxDate();
		var minValue=visibleDatesArr[0];
		var maXvalue=visibleDatesArr[visibleDatesArr.length-1];
		
		
        console.log("minValue:", minValue);
		console.log("maXvalue:", maXvalue);
		
		$("div[data-notes]").each( function (index, value) {
			var data_start =$(this).attr('data-start');
			var data_end =$(this).attr('data-end');
			var divDisp = $(this).attr('data-disp');
			var divPos = $(this).attr('data-positions');
			
			
			var divHeight=  $(this).attr('data-height');
			
			//SECTION 
            if((parseInt(data_start)<parseInt(vals))&& (parseInt(vals)< parseInt(data_end))){
			
			var divPos = $(this).attr('data-positions');
			var divDate = $(this).attr('data-date');
				
			if(visibleDatesArr.indexOf(divPos)!=-1){
				
				console.log("came inside 1"+divDate+"minValue::"+minValue+"maXvalue::"+maXvalue);
				$('.dayWiseWrap').removeClass('selectedDate');
                $("#"+divDate).toggleClass('selectedDate');
				datePanelWrap.scrollToElement(".selectedDate", 1);
				}
				
			}
				
			//LOAD
			    if(parseInt(divHeight)<parseInt(400)){
					
					data_start=parseInt(data_start)-parseInt(1070);
				}
				
				console.log("data_start:" +data_start+ "data_end::"+data_end+"vals" +vals); 
   			
			if((parseInt(data_start)<parseInt(vals))&& (parseInt(vals)< parseInt(data_end))){
			
				console.log("you are in div number::"+$(this).attr('data-positions'));
				var divPos = $(this).attr('data-positions');
				var divDate = $(this).attr('data-date');
				
			console.log("you are in div number::"+$(this).attr('data-positions')+":::::::"+divDate);
	     var scrolls=CEMainScroll.y;
				if(minValue==divPos){
			
					loadDataOnEnd(divDate,divPos,"min",minValue,maXvalue,vals);
				}

				if(maXvalue==divPos){
				
					loadDataOnEnd(divDate,divPos,"max",minValue,maXvalue,vals);
				}
				//console.log("dONS"+visibleDatesArr.indexOf(divPos));
				
				
				
				
				
			}
			if(data_start==undefined ||data_end ==undefined ){
		          setHeightAndBase();
		 }
		});
		
		//reached top
		
		if(vals==0){
		
		
	scrollToAnElement(vals);

		
		
		}
		 
	}
	
	
	CEMainScroll.on('scrollEnd', updatePosition);  
  

   
	
	

	
	
	
	



});



	


