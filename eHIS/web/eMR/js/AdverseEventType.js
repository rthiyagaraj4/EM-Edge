function create(){
	frames[1].location.href='../../eMR/jsp/AdverseEventTypeCriteria.jsp';

}
function query()
{
frames[1].location.href='../../eMR/jsp/AdverseEventTypeQueryCriteria.jsp';
}

function checkBoxOnClick(obj)
{
//if(obj.checked)
//{
		//var cnt=frames[1].document.forms[0].count.value;

		/*eval("frames[1].document.forms[0].checkBox"+i).value='E';
		var eff_status=eval("frames[1].document.forms[0].checkBox"+i+".value");
		alert(eff_status);*/
//}
}

function apply()
{
var flag=true;
var submit=true;
var adv_event_ind_final="";
var adv_event_ind ="";
var tosubmit=true;
var next_str="";
frames[1].document.forms[0].fina_val.value="";
	 var fields = new Array (frames[1].document.forms[0].code,
		 frames[1].document.forms[0].short_desc,
		 frames[1].document.forms[0].long_desc);

  /*  var names = new Array ( "Code",
                            "Short Description",
							 "Long Description"
                            );*/
var names = new Array ( getLabel("Common.code.label","Common"),
				getLabel("Common.longdescription.label","Common"),
				getLabel("Common.shortdescription.label","Common")
				);
	if(frames[1].checkFieldsofMst(fields, names, messageFrame)) 
	{


	var cnt=frames[1].document.forms[0].count.value;

		if(frames[1].document.forms[0].ret_value)
	{
	for(var i=0;i<cnt;i++)
	{
		if (frames[1].document.forms[0]["checkBox" + i].checked){
			frames[1].document.forms[0]["checkBox" + i].value = 'E';
			var eff_status = frames[1].document.forms[0]["checkBox" + i].value;
			
			 adv_event_ind = frames[1].document.forms[0]["adv_evnt_ind" + i].value;
			if(adv_event_ind =="")
			{
				tosubmit=false;
			}
			adv_event_ind_final=adv_event_ind_final+adv_event_ind+"@";
			next_str=next_str+adv_event_ind+"$"+eff_status+"@";
			
			frames[1].document.forms[0].fina_val.value=next_str;
		}else
		{
			frames[1].document.forms[0]["checkBox" + i].value = 'D';
		}
	}
	
}else
{
}
if(!tosubmit || frames[1].document.forms[0].fina_val.value =="")
	{
		alert("Applicable Adverse Event Type Indicators cannot be blank");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}else
		{
			
			if(frames[1].document.forms[0].mode.value=='insert')
			{
				frames[1].document.forms[0].submit();
			}else if(frames[1].document.forms[0].mode.value=='modify')
			{
				if(frames[1].document.forms[0].user_define.value=="S")
				{
					alert("System defined cannot be modified");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";

				}else
				{
				frames[1].document.forms[0].submit();
				}
			}
		}

		/*if(frames[1].document.forms[0].allow_one.checked==true)
		{
			flag=true;
		}else if(frames[1].document.forms[0].allow_two.checked==true)
		{
			flag=true;
		}else if(frames[1].document.forms[0].allow_three.checked==true)
		{
			flag=true;
		}else if(frames[1].document.forms[0].allow_four.checked==true)
		{
			flag=true;
		}else
		{
			flag=false;
		}

			if(!flag)
			{
			
				alert("Applicable Adverse Event Type Indicators cannot be blank");
				
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
				submit=false;


			}else
			{

				if(frames[1].document.forms[0].allow_one.checked==true)
				{
					frames[1].document.forms[0].allow_one.value='Y';
				}else
				{
					frames[1].document.forms[0].allow_one.value='N';
				}
				if(frames[1].document.forms[0].allow_two.checked==true)
				{
					frames[1].document.forms[0].allow_two.value='Y';
				}else
				{
					frames[1].document.forms[0].allow_two.value='N';
				}
				if(frames[1].document.forms[0].allow_three.checked==true)
				{
					frames[1].document.forms[0].allow_three.value='Y';
				}else
				{
					frames[1].document.forms[0].allow_three.value='N';
				}
				if(frames[1].document.forms[0].allow_four.checked==true)
				{
					frames[1].document.forms[0].allow_four.value='Y';
				}else
				{
					frames[1].document.forms[0].allow_four.value='N';
				}
				submit=true;
				
			}
			
		if(submit)
		{
			
			if(frames[1].document.forms[0].mode.value=='insert')
			{
				
				frames[1].document.forms[0].submit();
			}else if(frames[1].document.forms[0].mode.value=='modify')
			{
				if(frames[1].document.forms[0].user_define.value=="S")
				{
					alert("System defined cannot be modified");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=0";

				}else
				{
				frames[1].document.forms[0].submit();
				}
			}
		}else
		{
		}*/

			
	
	}
	
}

	
	function medBoard_change() 
	{
	
	 if (document.forms[0].eff_status.checked == true)
		document.forms[0].eff_status.value="E";
	 else
		document.forms[0].eff_status.value="D";
	}
function callcriteria(code,obj)
{
	//alert(code);
parent.frames[1].location.href='../../eMR/jsp/AdverseEventTypeCriteria.jsp?ADV_EVENT_TYPE_CODE='+code+'&mode=modify';
	
}
