function NotyMessage(type, text) 
{		
           /*
		   noty({  
			   "text":text,
			   "layout":"bottomRight",
			   "type":type,
			   "animateOpen":{  
				  "height":"toggle"
			   },
			   "animateClose":{  
				  "height":"toggle"
			   },
			   "speed":500,	
			   "timeout": 5000,
			   "closeButton":false,
			   "closeOnSelfClick":true,
			   "closeOnSelfOver":false,
			   "modal":false,
			   "onShow":"",
			   "onClose":""
			}); 	
			*/
		
			var n = noty({
				text        : text,
                type        : type,				
				dismissQueue: true,
    			progressBar : false,
				timeout     : 5000,
				layout      : 'bottomRight',
				closeWith   : ['click'],
                theme       : 'relax',
				animation: {
					 open: {height: 'toggle'},
					close: {height: 'toggle'},
					easing: 'swing',
					speed: 500 // opening & closing animation speed
				}
			});
}


function NotyConfirmMessage(type, text) 
{		
   noty({
	  text: 'Do you want to continue?',
	  layout: 'bottomRight',
	  buttons: [
		{addClass: 'btn btn-primary', text: 'Ok', onClick: function($noty) {
			// this = button element
			// $noty = $noty element	
				
			notyOkMessage("true");	
			$noty.close();	
		  }
		},
		{addClass: 'btn btn-danger', text: 'Cancel', onClick: function($noty) {					
			notyCancelMessage();	
			$noty.close();
		  }
		}
	  ]
	});			

}

