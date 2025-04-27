function fnLogout(userId){
	$.ajax({  
			url:'../../servlet/eSM.UserLogoutServlet',  
			type:'post',  
			data:{'mode':'logout','userId':userId},
			dataType: 'json',
			async: false, 
			success: function(data) {
				if(data.error!=""){
					//alert(data.error)
				}
			}
	});
	
}