

var path;
	var currentWeek
	var firstDate;
	var firstDay
	var currMonth;
	var month;
	var year;
	var startDate;
	var lastDay;
	var lastDay
	var endDate;
	var hdnOrderBy = "null";
	$(document).ready(
			function() {
				parent.setIframeHeight();
				function loadDate() {
					currentWeek = $('#calender').data("currentWeek");
					todayWeekNo = currentWeek.todayWeekNo;
					currentWeekNo = currentWeek.currentWeekNo;
					firstDay = currentWeek.firstDay;
					firstDate = firstDay.getDate();
					currMonth = currentWeek.currentMonth;
					month = currMonth + 1;
					year = currentWeek.currentYear;
					startDate = firstDate + '/' + month + '/' + year;
					lastDay = currentWeek.seventhDay;
					lastDate = lastDay.getDate();
					if (lastDate < 7) {
						month = currMonth + 2;
					}
					endDate = lastDate + '/' + month + '/' + year;
				 $("#DiarViewFrame").load(path + "/mobile/DiaryViewDetail?startDate="+ startDate + "&endDate=" + endDate+ "&hdnOrderBy=" + hdnOrderBy); 

				}

				function openDiaryViewDetail() {
					loadDate();
				}

				path = $('#hdnPath').val();
				$('#calender').weekWidget({
					callBackForNext : openDiaryViewDetail,
					callBackForPrev : openDiaryViewDetail,
					callBackForToday : openDiaryViewDetail,
					callBackForSelect : openDiaryViewDetail
				});

				loadDate();
			});

	document.addEventListener('touchmove', function(e) {
		e.preventDefault();
	}, false);


  //scroller func
	//variables for setting the content frame height according to the device
	//below values are header footer heights
	
	var header_borderheight;
	var content_height;
	var scroller_height;
var date = new Date();

	var scrollContent1;
	function loaded1() {
		 setTimeout(function() {
			scrollContent1 = new iScroll('divcnt',{
				
				onScrollEnd: function(e) {
					
					var a = $('#calender').data('setDate');
					var year =parseInt($(this).data('year'));
					datenum = $(this).data("datenum"); 
					var	month =parseInt($(this).data('mthno'));
			   		var dateNo =$(this).data('dateno');
			   		
					
					
			   		
					var scrolledDate ;
			    	$.each($(".dateSeperator"), function() { 
			    		var headerSet = false;
			    	    if($(this).offset().top - $("#calendar").innerHeight() >=  0 && !headerSet){
			    	    	//$("#header").html($(this).html());
			    	    	
			    	    	 curDate =$(this).data('bookingdate');
			    	    	 //alert(curDate);
			    	    	 //apptDate = StringToDate(curDate);
			    	         //alert (apptDate);
					 
					  /*var dateno = curDate.getDate();
				   		var mth = curDate.getMonth();
				   		var year = curDate.getFullYear(); 
	    					 scrolledDate = new Date(year,mth,dateno,0,0,0,0);*/
	    					
			    	    	 
			    	    	 /*a(apptDate);*/
	    					 
	    					//$("#currentdate").html(curDateScrolled);
			    	    	headerSet = true;
			    	    	
			    	    }
			    	});
			       
			    }  
			});
		}, 100); 

	}

	document.addEventListener('touchmove', function(e) {
		e.preventDefault();
	}, false);

	document.addEventListener('DOMContentLoaded', loaded1, false);

	function changeOrientation(orient, HFheight) {
		//here the heights of the diary view contents frame and the height of the scrolling portion are set
		header_borderheight = $("#DiaryHeader").height()+$("#calender").height();
		diary_headerHeight = $("#DiaryHeader").height();
		content_height = parent.getTotalPageDivHeight() - diary_headerHeight - HFheight - 5; //5px bottom margin
		scroller_height = parent.getTotalPageDivHeight() - header_borderheight - HFheight - 5; //5px bottom margin
		document.getElementById("divcnt").style.height = scroller_height + "px";
		document.getElementById("DiaryViewContents").style.height = content_height + "px";
		
	//	(typeof scrollContent1.refresh === "function" ) || scrollContent1.refresh();
	}

	function fnOrderBy(orderByVal) {
		hdnOrderBy = orderByVal;
		/* document.getElementById("hdnOrderBy").value = orderByVal; */
		$("#DiarViewFrame").load(
				path + "/mobile/DiaryViewDetail?startDate=" + startDate
						+ "&endDate=" + endDate + "&hdnOrderBy=" + hdnOrderBy);
	}
	
	
	
	
	/*Dairy view deatil ka javascript*/
	
	$(document).ready(function() {
		if(scrollContent1){
			scrollContent1.refresh();
			scrollContent1.scrollTo(0,0,0);
		}/* else{
			alert("scroller is null");
		} */
		
	});
	var currentExpanded = "";
	function expandedView(count)
	{
		if(currentExpanded !="" && currentExpanded != count)
		{
			$('.expandedView'+currentExpanded).toggle();
			$('.collapsedView'+currentExpanded).toggle();
		}
		$('.expandedView'+count).toggle();
		$('.collapsedView'+count).toggle();
		if($('.expandedView'+count).is(':visible'))
		{
			currentExpanded = count;	
		}
		else
			currentExpanded = "";
		if(scrollContent1){
			scrollContent1.refresh();
			
		}
		
		 
	}

	/*function to convert string to date*/
	
	function StringToDate(string){
		var d = new Date();
		//var str='01/07/2013 11:18:13';
		var datenum,month,year;
		var hr=0, min=0, sec=0;
		var datetimearr = string.split("-");
		if(datetimearr[0]){
			/*var datearr = datetimearr[0].split("/");*/
			if(datetimearr[0])
				year = parseInt(datetimearr[0]);
			if(datetimearr[1])
				month = parseInt(datetimearr[1]);
			if(datetimearr[2])
				datenum = parseInt(datetimearr[2]);
		}
		/*if(datetimearr[1]){
			var timearr = datetimearr[1].split(":");
			if(timearr[0])
				hr = parseInt(timearr[0]);
			if(timearr[1])
				min = parseInt(timearr[1]);
			if(timearr[2])
				sec = parseInt(timearr[2]);
		}*/
		
		d.setDate(datenum);
		d.setMonth(month);
		d.setFullYear(year);
		//if(hr!=0)
		d.setHours(hr);
		//if(min!=0)
		d.setMinutes(min);
		//if(sec!=0)
		d.setSeconds(sec);
		return d;
	}
	