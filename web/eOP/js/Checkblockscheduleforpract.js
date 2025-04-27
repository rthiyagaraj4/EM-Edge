//Added for JD-CRF-0183 [IN:041353] By Dharma on 25th Nov 2013 

function FNCheckBlockScheduleForPract(p_queue_date,pract_id,p_queue_time,frames_list,function_name,cl_code){
	 if(function_name=='assign_reassign'){
		 document.forms[0].is_prac_blocked.value 	= "";
	 }else if(function_name=='revisevisit'){
		 f_query_add_mod.document.forms[0].is_prac_blocked.value	= "";
	 }else{
		 frames_list.document.forms[0].is_prac_blocked.value	= "";
	 }

	$.ajax({  
	     url:'../../eOP/jsp/Checkblockscheduleforpract.jsp',  
	     type:'post',  
	     data:{'pract_id':pract_id,'block_date':p_queue_date,'block_time':p_queue_time,'cl_code':cl_code},
	     dataType: 'json',
	     async:false,// preventing other events on the page from firing
	     success: function(data) {
	    	 if(data.isJsonResults){
	    		 if(function_name=='assign_reassign'){
		    		 document.forms[0].is_prac_blocked.value	= data.isJsonResults;
		    		 document.forms[0].Systime.value			= data.block_time;
	    		 }else if(function_name=='revisevisit'){
	    			 f_query_add_mod.document.forms[0].is_prac_blocked.value	= data.isJsonResults;
	    			 f_query_add_mod.document.forms[0].Systime.value			= data.block_time;
	    		 }else{
	    			 frames_list.document.forms[0].is_prac_blocked.value	= data.isJsonResults;
	    		 }
	    	 }
	     },
	     error: function(jqXHR, textStatus, errorThrown) {
	         //alert("incoming Text " + jqXHR.responseText);
		
	     }
	 });
	
}


