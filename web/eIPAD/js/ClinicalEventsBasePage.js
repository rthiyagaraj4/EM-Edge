
$(document).ready(function(){
	path = $('#hdnPath').val();
	parent.setOnLoadContentPaneHeight();
	datePanelWrap = new IScroll('#datePanelWrap', { scrollbars: true, click: true,  mouseWheel: true, disableMouse: false, disablePointer: true } );
	accNumArrEvents =$('.selectedDate input').val().split(',');
	
	$(document).on('click','.dayWiseWrap',function(){
		$('.dayWiseWrap').removeClass('selectedDate');
		$(this).toggleClass('selectedDate');
		
		var accNumArrEvents =$(this).find('input').val().split(',');
		loadAllNotes(accNumArrEvents)
		
	});
	loadAllNotes(accNumArrEvents);
	function loadAllNotes(accNumArrEvents){
		$('.notesViewWrapper .notes').html('');
		for(var i=0;i<accNumArrEvents.length;i++)
		{
			accNumArrEvents[i].replace('$','%');	
			$('.notesViewWrapper .notes').append('<div class="note'+i+'"></div>');
		}
		var interval = setInterval(function(){loadNotes()}, 500);
		function loadNotes(){
			if($(".notesViewWrapper .notes .note0").length > 0){
				clearInterval(interval);
					for(var i=0;i<accNumArrEvents.length;i++)
					{
						accNumArrEvents[i].replace('$','%');	
						$(".notesViewWrapper .notes .note"+i).load(path+'/eIPAD/jsp/chartwidgets/clinicalevents/ClinicalEventHistoryFullView.jsp?accession_num='+accNumArrEvents[i],function(){
							CEMainScroll.refresh();	
						});
						
					}
			}
		}
		
	}
	
});




