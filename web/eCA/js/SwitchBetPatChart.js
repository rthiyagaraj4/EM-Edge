/** Added by Nijitha S on 27/08/2012 for //IN32540 IE 9 Issue in Switching Between Patient Chart Windows*/

async function showPatientInfo(patient_id,episode_id,child_window,visit_id,queryStringForChart)
{
		var ref = top.content.CommonToolbar;// IE 9 Issue Fix
		var pat_info_temp = new Array();
		var pat_info_backup = new Array();
		pat_info_backup = ref.pat_info;
		if(ref.pat_info.length == 0 && child_window != "N")
		{		
			pat_info_backup = top.opener.top.content.CommonToolbar.pat_info;
		
		}
		
		var j=0 ;
		var pat_info_len=0;
		if( pat_info_backup != null){
			pat_info_len = pat_info_backup.length;
		}
		if(pat_info_backup != null)
		{
		  for(var i=0;i<pat_info_len;i++)
		  {
			  
			 if(!pat_info_backup[i].window_obj.closed  )
				{
				  pat_info_temp[j] = pat_info_backup[i];
				  j++;
				}
			}
		}
		//ref.pat_info = pat_info_temp;
		pat_info_backup = pat_info_temp;
		
		if(pat_info_backup != null)
		{
			pat_info_len = pat_info_backup.length;
			if(pat_info_len > 1)
			{
				var j=0;
				pat_info_temp = new Array();
				
				for(var i=0;i<pat_info_len;i++)
				{
					if(pat_info_backup[i].winname!=null && pat_info_backup[i].winname !=top.name )
					{
						pat_info_temp[j] = pat_info_backup[i];
						j++;
					}
				}
			}
	   }	
	  
		if(pat_info_backup != null)
		{		
			pat_info_len = pat_info_backup.length;
			if(pat_info_len > 1)
			{
				var dialogHeight= 1 ;
				if(pat_info_temp.length > 4)
					dialogHeight = pat_info_temp.length*2;
				var dialogWidth = "80vw" ;
				var dialogTop = "117" ;
				var dialogLeft = "50" ;
				var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:"+dialogTop+";dialogLeft:"+dialogLeft+";status=no;scroll=no;";
				if (child_window == "Y") {
				pat_info_temp[pat_info_temp.length] = "CY";
				}
				retVal = await window.showModalDialog("ShowPatients.jsp?queryStringForChart="+queryStringForChart+"&child_window="+child_window+"&patientID="+patient_id+"&episodeID="+episode_id+"&visitID="+visit_id,pat_info_temp,features);
				if(retVal != "CD" )
				{					
					if(retVal != null )
					{
						for(var i=0;i<pat_info_temp.length;i++)
						{
							if(pat_info_temp[i].winname == retVal)
							{		
								pat_info_temp[i].window_obj.focus();
								break;
							}
						}
					}
				}
				else
				{				
					top.opener.document.focus() ;
				}
			}
			else
			{
				if(pat_info_len == 1) 
				{
					 if(child_window =="Y"){
						  top.opener.document.focus();
						   }
					else
					{
						pat_info_temp[0].window_obj.focus();
						}
				}
				else
					alert(getMessage("NO_PATIENT_SELECTED","CA"));
			}	
		} 
}