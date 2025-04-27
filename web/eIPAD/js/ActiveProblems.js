function authorizeUser(){
    datastring = $("#problemsDiagnosisForm").serialize();
    //alert(datastring);
    $.ajax({
            type:'POST', 
            url: path+"/mobile/chartsummary/AuthorizeSensitiveDiagnosis", 
            data: datastring,
            success: function(response) {
                //alert("Success " + response);
				var trimResponse = $.trim(response);
                if(trimResponse.valueOf()=='SUCCESS'){
                	parent.closeAuthorizePrompt();
					$("#ProblemsDiagnosisWidgetframe").load( path + "/mobile/chartsummary/ProblemsDiagnosisView?authorized=Y",function(){
						scrollerRefresh(CSMainScroll);
					});
	
                }
                else{
                	parent.showPwdValError();
                }
            //$('#ContactForm').find('.form_result').html(response);
			},
			error: function (xhr, ajaxOptions, thrownError) {
				parent.showPwdValError();
			}
			//end ajax options
    });//end ajax
    return false;
    
	//alert("authorize user");
	
	
}

function openAuthorizePrompt(){
	parent.openAuthorizePrompt();
}
