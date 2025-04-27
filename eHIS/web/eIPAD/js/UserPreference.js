

 var activeIncativeListScroller;
 
 /*

 
 allPrefernces_id.add("Latestvitals");
 allPrefernces_id.add("Allergies");
 allPrefernces_id.add("Proceduredetails");
 allPrefernces_id.add("ActiveProblem");
 allPrefernces_id.add("ClinicalNotes");
 allPrefernces_id.add("Results");
 allPrefernces_id.add("PendingOrders");
 allPrefernces_id.add("CurrentMedication");


 
 if(cuurentItem=="Latestvitals"){
 //wid_vitals
 
 }else if(cuurentItem=="Allergies"){
 //wid_allergy
 }else if(cuurentItem=="Proceduredetails"){
 //wid_procedure
 }else if(cuurentItem=="ActiveProblem"){
 //wid_problems
 }else if(cuurentItem=="ClinicalNotes"){
 //wid_notes
 }else if(cuurentItem=="Results"){
 //wid_results
 }else if(cuurentItem=="PendingOrders"){
 //wid_pendingorders
 }else if(cuurentItem=="CurrentMedication"){
 //wid_medications
 }
 
 
 */
 
 function movetoSelectedWidgets(selectedItem){
 
 console.log("selectedItem::"+selectedItem);
 scrollToWidget(selectedItem);
 
 
 }
 
 
 function arrayPositions(){
 var positionOfList=[];
 
// positionOfList.push();
 
 positionOfList.push("VITALS");
 positionOfList.push("ALLERGY");
 positionOfList.push("PROCEDURE");
 positionOfList.push("PROBLEMS");
 positionOfList.push("NOTES");
 positionOfList.push("RESULTS");
 positionOfList.push("PENDINGORDERS");
 positionOfList.push("MEDICATIONS");
 
 
 return positionOfList;
 
 
 }
 
 function activeIncativeScroll() {
 //alert("calleds");
        activeIncativeListScroller = new IScroll('#widgetListWarpper', {
            scrollX: false,
            scrollY: true,
            interactiveScrollbars: true,
            click: true,
            useTransition: false,
            hideScrollbar: true,
            scrollbars: true,
            bindToWrapper: true,
            fadeScrollbars: true
        });
    }
    
function restoreClick(mode){
		
		$("#userPrefernceMainWrapper").load(path + '/eIPAD/jsp/chartwidgets/userpreference/WidgetOrderPreference.jsp?mode=restore',
 	      function(res){ 
				//alert(res);
				updateWidgetItemsCount();
				
	           addDragElement();
	
		
		//activeIncativeScroll();
           }
	        );
		
		
	}
	
function checkForCount(){
var addedCount=[];
$("#sortable-handlers div").sort(function(a, b) {
 // return parseInt(a.id) - parseInt(b.id);
}).each(function() {
  var elem = $(this);
  
 var ids= $(elem).attr('data-id');
 
 var visible= $(elem).attr('data-visible');
 
 console.log("all is well "+visible);
 if(visible=="Y"){
 
  addedCount.push(ids);
 }

});

return addedCount;
}
	
function clickMinus(hiddenId){
var visibleCount=checkForCount();

console.log("visible length::"+visibleCount.lenght);

if(visibleCount.length!=1){
console.log("hiddenId::"+hiddenId);

$("#"+hiddenId).attr("data-visible","N");

$("#"+hiddenId).hide();
			
$("#"+hiddenId+"_E").show();	


}else{

	//alert("atleast one widget has to be in chart summary");
	$("#transactionMessageContent_userpref").html("Atleast one widget has to be in active");
	//$("#transactionMessageContent_userpref").append("Atleast one widget has to be in active");
			
	$("#transactionMsg_userpref").attr("class" , "formValErrorTheme CSTransactionMessage");
	//showTransactionMessage();
	$("#transactionMsg_userpref").show();
	setTimeout(function(){
		$("#transactionMsg_userpref").hide();
	},5000);
	$("#transactionMsg_userpref").bind('click',function(){
		$(this).hide();
	});

}
	
			
			}
			
			
function clickADD(hiddenId){


console.log("hiddenId::"+hiddenId);
var Id = hiddenId.split("_");
addAtLast(Id[0]);

//$("#"+Id).show();
			
$("#"+Id[0]).attr("data-visible","Y");
$("#"+hiddenId).hide();		
			
			}
			
			
function addAtLast(currentId){
			
$("#sortable-handlers div").sort(function(a, b) {
 // return parseInt(a.id) - parseInt(b.id);
}).each(function() {
  var elem = $(this);
  
 var ids= $(elem).attr('data-id');
  console.log("currentId:"+currentId+"ids:"+ids);
 
  if(currentId==ids){

  console.log(elem);
  elem.remove();
  $(elem).appendTo("#sortable-handlers");
  $("#"+ids).show();
  }
 
});
			
			
			
	}
		

function closeUserEditSummary(){
//alert("called here");

userPreferedClick();
	//$("#userPrefernceMainWrapper").hide();
	CSMainScroll.enable();
}		
    
function closeUserSummary(){
//alert("called here");


	$("#userPrefernceMainWrapper").hide();
	CSMainScroll.enable();
}


function mappinguserOrder(orderList){

console.log("orderList::"+JSON.stringify(orderList));

var getArraysPot=arrayPositions();
var queryStr="?";
for(var i= 0; i< getArraysPot.length; i++){

var cuurentItem=getArraysPot[i];

var pos = orderList.indexOf(cuurentItem);

if(parseInt(pos)!=-1){
pos=parseInt(pos)+parseInt(1)
}


 
 if(cuurentItem=="VITALS"){
 //wid_vitals
 queryStr+="wid_vitals="+pos;
 }else if(cuurentItem=="ALLERGY"){
 //wid_allergy
 queryStr+="&wid_allergy="+pos;
 }else if(cuurentItem=="PROCEDURE"){
 //wid_procedure
 queryStr+="&wid_procedure="+pos;
 }else if(cuurentItem=="PROBLEMS"){
 //wid_problems
 queryStr+="&wid_problems="+pos;
 }else if(cuurentItem=="NOTES"){
 //wid_notes
 queryStr+="&wid_notes="+pos;
 }else if(cuurentItem=="RESULTS"){
 //wid_results
 queryStr+="&wid_results="+pos;
 }else if(cuurentItem=="PENDINGORDERS"){
 //wid_pendingorders
 queryStr+="&wid_pendingorders="+pos;
 }else if(cuurentItem=="MEDICATIONS"){
 //wid_medications
 queryStr+="&wid_medications="+pos;
 }

}
return queryStr;
 console.log("final query string=="+queryStr);


}

function confirmUserSummary(){
//alert("confirm");
var orderList=getListOfOrders();
console.log("orderList::"+orderList);
var userPreferedOrder=mappinguserOrder(orderList);
saveUserPreferences(userPreferedOrder);
closeUserSummary();

//userPreferedClick();

}

function saveUserPreferences(order){
	
	$.ajax({
            type:'POST', 
            url: path+"/mobile/chartsummary/WidgetOrderPreference"+order, 
            //data: order,
            success: function(response) {
                openChartSummaryFrame();
			},
			error: function (xhr, ajaxOptions, thrownError) {
				
			}
			//end ajax options
    });//end ajax
	
	
	
}


function addDragElement(){
	
	$("#sortable-handlers").kendoSortable({
                      //  handler: ".MenuItemDragIconEdit",
                        hint:function(element) {
                            return element.clone().addClass("hint");
                        },
							container: $(".MenuListItem")
                    });
	
	
}


function CallEditSummary(){

$("#userPrefernceMainWrapper").load(path + '/eIPAD/jsp/chartwidgets/userpreference/WidgetOrderPreference.jsp?mode=Edit',
 	      function(res){ 
				
				updateWidgetItemsCount();
		/*		
	$("#sortable-basic").kendoSortable({
	    
        hint:function(element) {
            return element.clone().addClass("hint");
        },
        placeholder:function(element) {
            return element.clone().addClass("placeholder").text("");
        },
		container: $(".MenuListItem")
        
    });	
	*/
	addDragElement();
		
		//activeIncativeScroll();
           }
	        );


}


function userPreferedClick()
{
	
//alert("called here");



$("#userPrefernceMainWrapper").css("display","table-row");
CSMainScroll.refresh();
CSMainScroll.scrollTo(0, 0, 0);

//CSMainScroll.scrollToElement(".userPrefernceMainWrapper", 1);

CSMainScroll.disable();

$("#userPrefernceMainWrapper").load(path + '/eIPAD/jsp/chartwidgets/userpreference/WidgetOrderPreference.jsp?mode=Normal',
 	      function(res){ 
		  updateWidgetItemsCount();
				//alert(res);
		
		
		//activeIncativeScroll();
           }
	        );
			
}

			
function getListOfOrders(){
			
			//alert("calleds");
			var allUserSelectedOrder=[];
			
			  $(".sortable").each(function(index, value) {

          
			console.log( "bill::"+ $(this).attr('data-usercode'));
			if($(this).attr('data-visible')=="Y"){
			
			allUserSelectedOrder.push($(this).attr('data-usercode'));
			}
          

        });
		return allUserSelectedOrder;
			
			}
			
			


$(document).ready(function() {
	//alert("called here");
	
	//$("#userPrefernceMainWrapper").hide();
	
   
	updateWidgetItemsCount();
	//activeIncativeScroll();
});


function scrollToWidget(widgetname){
	CSMainScroll.scrollToElement("."+widgetname , 1 );
	$("#userPrefernceMainWrapper").hide();
}
