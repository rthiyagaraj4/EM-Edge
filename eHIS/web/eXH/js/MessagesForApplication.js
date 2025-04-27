 //APPLICATION ADDMODIFY APPLY() METHOD
function apply()
{ 
	var option=window.f_query_add_mod.head_frame.document.forms[0].option.value;
	var appl_id=window.f_query_add_mod.head_frame.document.forms[0].appli.value;
	var fields = new Array ( f_query_add_mod.head_frame.document.forms[0].appln_name) ;
	var names = new Array (getLabel("Common.Application.label","common"));

			if(!f_query_add_mod.head_frame.checkFields( fields, names, messageFrame))
			{

			}
			//ELSE CONDITION .......OPTION MSESSAGE TYPE
			else
			{
			if(option=='msg_type')
			{
				if(window.f_query_add_mod.disp_list.list_frame.document.forms[0])
                {
					var status = window.f_query_add_mod.disp_list.list_frame.document.forms[0].status.value;
					var message_type=window.f_query_add_mod.disp_list.list_frame.document.forms[0].message_type.value;
					var stnd_code=window.f_query_add_mod.disp_list.list_frame.document.forms[0].stnd_code.value;
					window.f_query_add_mod.disp_list.list_frame.document.forms[0].action="../../eXH/jsp/MsgForApplEventTypeUpdt.jsp?message_type="+message_type+"&appl_id="+appl_id+"&stnd_code="+stnd_code+"&status="+status+"&action_type=R";		
					window.f_query_add_mod.disp_list.list_frame.document.forms[0].submit();
				}
				else
				{
					alert(getMessage( 'XH1008','XH'));
					window.f_query_add_mod.disp_list.list_frame.focus();				
				}
			}
			//OPTION APPLICATIONWISE SEGMENT 
			if(option=='app_wise_segment')
			{    
				 var flag=false;
				if(window.f_query_add_mod.disp_list.list_frame.document.forms[0])
                {
					var cou=parseInt(window.f_query_add_mod.disp_list.list_frame.document.forms[0].count.value);
				 
					for(var i=0;i<cou;i++)
					{
						if(window.f_query_add_mod.disp_list.list_frame.document.getElementById("in_use"+i).checked==true)
						{
							 if(window.f_query_add_mod.disp_list.list_frame.document.getElementById("profile"+i).value==''||window.f_query_add_mod.disp_list.list_frame.document.getElementById("profile"+i).value==null)
							{
								flag=true;
							
							}
						}
					}

					if(flag==true)
					{
						alert(getMessage('XH0072','XH'));						
					}
					else
					{
						var status = window.f_query_add_mod.disp_list.list_frame.document.forms[0].status.value;
						var event_type=window.f_query_add_mod.disp_list.list_frame.document.forms[0].event_type.value;
						var stnd_code=window.f_query_add_mod.disp_list.list_frame.document.forms[0].stnd_code.value;
						var appl_id=window.f_query_add_mod.disp_list.list_frame.document.forms[0].appl_id.value;
						window.f_query_add_mod.disp_list.list_frame.document.forms[0].action="../../eXH/jsp/MsgForApplSegmentTypeUpdt.jsp?event_type="+event_type+"&appl_id="+appl_id+"&stnd_code="+stnd_code+"&status="+status+"&action_type=R";		
						window.f_query_add_mod.disp_list.list_frame.document.forms[0].submit();
					}


			
				}
				else
				{
					alert(getMessage( 'XH1011','XH'));
					window.f_query_add_mod.disp_list.list_frame.focus();				
				}
			}
		}	
	
	window.commontoolbarFrame.document.location.reload();
}

//*******************************************************************************************
//function reset
//*******************************************************************************************

function reset()
{
	/*if(window.f_query_add_mod.disp_list.list_frame)
	{
		if(window.f_query_add_mod.disp_list.list_frame.document.forms[0])
			window.f_query_add_mod.disp_list.list_frame.document.forms[0].reset();
	}  */

	if(window.f_query_add_mod.head_frame.document.forms[0])
	{
	   window.f_query_add_mod.head_frame.document.forms[0].reset();
	   window.f_query_add_mod.head_frame.document.location.href='../../eXH/jsp/MsgForApplSelectApplMaster.jsp';
	   window.f_query_add_mod.disp_list.document.location.href='../../eCommon/html/blank.html';
	}
}

//*******************************************************************************************
//function searchProfile
//*******************************************************************************************

async function searchProfile(segment_type,event_type_code,whichelement)
{





	document.getElementById("_field"+whichelement).value="Y";
	var flag = true;
			var checkinuse=parent.frames[1].document.getElementById(segment_type+event_type_code+"_inuse1");

            


			   if(flag)
	{
				   var tdesc="";
            var tcode="";

//			var confTyp_val=this.document.forms[0].config_type.value;
//			if(confTyp_val!=""){
                
            var retVal =new String();
            var argumentArray  = new Array() ;
            var dataNameArray  = new Array() ;
            var dataValueArray = new Array() ;
            var dataTypeArray  = new Array() ; 
			var tit = "Profile";
  //          alert(parent.frames[1].document.forms[0].name);
			var target=parent.frames[1].document.getElementById(segment_type+event_type_code+"_profile_desc");
			var profile_id=parent.frames[1].document.getElementById(segment_type+event_type_code+"_profile_id");

			sql="SELECT profile_id code,short_desc description FROM XH_STANDARD_PROFILE WHERE UPPER(profile_id) LIKE UPPER(?) AND UPPER(short_desc) LIKE UPPER(?) ORDER BY 1  ";

	//		alert("sql : "+sql); 

            argumentArray[0] = sql;
            argumentArray[1] = dataNameArray ;
            argumentArray[2] = dataValueArray ;
            argumentArray[3] = dataTypeArray ;
	        argumentArray[4] = "1,2";
            argumentArray[5] = target.value;
            argumentArray[6] = DESC_LINK  ;
            argumentArray[7] = DESC_CODE ; 
         
            retVal = await CommonLookup( tit, argumentArray );
			if(checkinuse.checked==true)
				{
				if(retVal=='' || retVal==null||retVal=='undefine')
				{

                     parent.frames[1].document.getElementById(segment_type+event_type_code+"_profile_desc").focus();
				}
				}
            if(retVal != null && retVal != "" ){
	            var ret1=unescape(retVal);
                arr=ret1.split(",");
                target.value=arr[1];
                profile_id.value=arr[0];
				
            }
            else{
                target.value=tdesc; 
                profile_id.value=tcode;
            }
	}
}// End of searchProfile
