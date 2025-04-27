async function switchLanguage(obj, obj1,obj2,obj3){
			
			var  langListSize=parseInt(obj1);					
			if(langListSize ==1)	{				

				var cur_lang_id = document.getElementById("cur_lang_id").value;
				var opt_lang_id = document.getElementById("opt_lang_id").value;						
							
				var where_to= confirm("All Open Patient Chart will be refreshed and data will be \nlost if language is Switched. \nDo you want to Continue?");
				if(where_to==true){					
					var switchlang = opt_lang_id;
					var xmlHttp=  new XMLHttpRequest() ;
					
					xmlStr	="<root></root>" ;
					var xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open( "POST", "../../eCommon/jsp/UpdateLang.jsp?language_id="+opt_lang_id+"&called_from=CA_PATIENT_CHART",false);
					xmlHttp.send( xmlDoc ) ;
					responseText=xmlHttp.responseText;
					responseText = trimString(responseText)

					document.getElementById("cur_lang_id").value = opt_lang_id;
					document.getElementById("opt_lang_id").value = cur_lang_id;			

				newLanguage();
				}
				
			}
			else{					
					var dialogHeight= "25" ;
					var dialogWidth	= "30" ;
					var dialogTop	= "200" ;
					var dialogLeft	= "300" ;
					var status = "no";					
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+"; scroll=auto; status:no";
					var arguments	= "" ;	
					
					retVal =await window.showModalDialog("../../eCommon/jsp/SwitchLanguage.jsp?module_id=SM&function_id=SWITCH_LANG&function_name=Switch Language&function_type=F&access=NYNNY&persFrom=HomeSummary&CALLED_FROM=CA_PATIENT_CHART",arguments,features);
					
					if(retVal=='Success')
						newLanguage();
					
				
			}			
}


function newLanguage(){

			var ref = firstwindow.top.content.CommonToolbar;
			var pat_info_temp = new Array();
			var pat_info_backup = new Array();
			pat_info_backup = ref.pat_info;

			var j=0 ;
			var pat_info_len;
			if( pat_info_backup != null)
				pat_info_len = pat_info_backup.length;

		if(pat_info_backup != null)
		{
		  for(var i=0;i<pat_info_len;i++)
		  {
			 if(!pat_info_backup[i].window_obj.closed  )
				{
				  pat_info_temp[j] = pat_info_backup[i]
				  j++
				}
			}
		}		
		for(var i=0;i<pat_info_temp.length;i++)
			{				
				pat_info_temp[i].window_obj.frames[0].location.reload();
				//pat_info_temp[i].window_obj.frames[0].location.href=pat_info_temp[i].window_obj.frames[0].location.href;
				//pat_info_temp[i].window_obj.frames[1].frames[1].location.reload();
			//	pat_info_temp[i].window_obj.location.reload();
		       for (var j = 0;j< pat_info_temp[i].window_obj.frames[1].frames[3].length;j++ )
		       {
				  
				   var frameObj = eval("pat_info_temp[i].window_obj.frames[1].frames[3].frames("+j+")");
				   if (pat_info_temp[i].window_obj.frames[1].frames[2].name == "matFrame")
				   {
					    pat_info_temp[i].window_obj.frames[1].frames[2].location.reload();
				   }				  
				   pat_info_temp[i].window_obj.frames[1].frames[3].location.reload();
		       }			
							
			}
}
