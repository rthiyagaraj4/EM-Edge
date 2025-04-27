 //********************************************************************************************
function loopFrame(len)
{
	var ret = '';
	for(q=0;q<len;q++)
	{
		ret = 'parent.'+ret; 
		
	}
	return ret;
}
//********************************************************************************************
function getFrameObject(name)
{
	var len = 0;
	var iterateFrame = ''; 
	for(w=1;w<=3;w++)
	{
		len = parseInt(eval(loopFrame(w)+'frames.length'));
																	    
		for(p=0;p<len;p++)
		{
			
			iterateFrame = eval(loopFrame(w)+'frames('+p+')');
																			    
			
			if (iterateFrame.name==name)
			{
				return(iterateFrame);
			}	
		}
	}
	return(null);

}

//JAVASCRIPT FUNCTION APPLY()
//********************************************************************************************
function apply()
{
	if(window.f_query_add_mod.disp_list.document.forms[0])
	{

	try
		{
			var option = window.hr_menu_bar.document.forms[0].option.value;

		}
		catch(e)
		{
		}
		//ALERT FOR EVENT

			if(option=='event')
			{
				var message_type;
				var stnd_code;
				var fun_id;
/*				if(window.f_query_add_mod_add.document.forms[0] != 'undefined')
				{
				}
				else
				{
*/					if(window.f_query_add_mod.disp_list.document.forms[0])
					{
						message_type=window.f_query_add_mod.disp_list.document.forms[0].msg_text.value;
						stnd_code = window.f_query_add_mod.disp_list.document.forms[0].stnd_code.value;		  
						
						var  funIdElement = window.f_query_add_mod.head_frame.document.getElementById("fun_id");

						if (typeof(v) != 'undefined' && funIdElement != null)
						{
							fun_id = window.f_query_add_mod.head_frame.document.forms[0].fun_id.value;	
						}						    
						
						window.f_query_add_mod.disp_list.document.forms[0].action="../../eXH/jsp/EventListForMessageUpdt.jsp?message_type="+message_type+"&stnd_code="+stnd_code+"&fun_id="+fun_id+"&action_type=R";	
						window.f_query_add_mod.disp_list.document.forms[0].submit();
										   
					}
					else {												    
						alert(getMessage('XH1008','XH')); 						   		 
						window.f_query_add_mod.focus();
					 } 
				/*}		*/														  
			}																			   
		//END EVENT
		//ALERT FOR SEGMENT
			if(option=='segment')
			{
				if(window.f_query_add_mod.disp_list.document.forms[0])
				{
					stnd_code = window.f_query_add_mod.disp_list.document.forms[0].stnd_code.value;
				
					window.f_query_add_mod.disp_list.document.forms[0].action="../../eXH/jsp/SegmentTypeUpdate.jsp?&stnd_code="+stnd_code+"&action_type=R";	
					window.f_query_add_mod.disp_list.document.forms[0].submit();
				}
			}
		
		//END SEGMENT
		//ALERT FOR EVENTWISE_SEGMENT
		
																					  
			if(option=='eventwise_segment')
			{
				var event_type;
				var stnd_code;
				if(window.f_query_add_mod.disp_list.document.forms[0])													     
				{
					event_type=window.f_query_add_mod.disp_list.document.forms[0].event_type.value;
					stnd_code = window.f_query_add_mod.disp_list.document.forms[0].stnd_code.value;
					window.f_query_add_mod.disp_list.document.forms[0].action="../../eXH/jsp/SegmentListForEventUpdt.jsp?event_type="+event_type+"&stnd_code="+stnd_code+"&action_type=R";	
					window.f_query_add_mod.disp_list.document.forms[0].submit();
				}
				else {								   
					alert(getMessage('XH1011','XH'));
					window.f_query_add_mod.focus();
				 }

			}
	//END EVENTWISE_SEGMENT
	}
	else
	{

	}
		window.commontoolbarFrame.document.location.reload();
}


//JAVASCRIPT FUNCTION RESET()
//********************************************************************************************
function reset()
{

	var option = window.hr_menu_bar.document.forms[0].option.value;

	if(option=='segment')
	{
	
		if(window.frames[2].frames[1].document.forms[0])
		{
			
	//	window.frames[2].frames[1].document.forms[0].reset();
		window.frames[2].frames[1].document.location.href="../../eCommon/html/blank.html";
		window.frames[2].frames[0].document.location.href="../../eCommon/html/blank.html";
		}
		
	}	
	else{
		if(window.f_query_add_mod.disp_list.document.forms[0])
		{
		window.frames[2].frames[1].document.location.href="../../eCommon/html/blank.html";
		window.frames[2].frames[0].document.location.href="../../eCommon/html/blank.html";
			
		//f_query_add_mod.disp_list.document.forms[0].reset();
		}
	   }
	   load_frame();
}
//********************************************************************************************
function load_frame()
{

var tab1=window.frames[1].document.getElementById("eventwise_segment");
var tabspan1=window.frames[1].document.getElementById("eventwise_segment_tabspan");
var tab2=window.frames[1].document.getElementById("segment");
var tabspan2=window.frames[1].document.getElementById("segment_tabspan");
var tab3=window.frames[1].document.getElementById("event");
var tabspan3=window.frames[1].document.getElementById("event_tabspan");

tab1.className='tabA';
tabspan1.className='tabAspan';
tab2.className='tabA';
tabspan2.className='tabAspan';
tab3.className='tabClicked';
tabspan3.className='tabSpanclicked';
window.frames[1].document.getElementById("option").value="event";
window.frames[2].location.href ='../../eXH/jsp/EventTypeMessageTypeMain.jsp';
window.frames[3].location.href='../../eCommon/jsp/MstCodeError.jsp';


}
  function callJSPs(str,event_type,fun_id)										  							   
{			
												   
		
	if(fun_id=='' || fun_id==null)
	{
			   
		
	/*	var tab1=document.getElementById("eventwise_segment");
		var tabspan1=document.getElementById("eventwise_segment_tabspan");
		var tab2=document.getElementById("segment");
		var tabspan2=document.getElementById("segment_tabspan");
		var tab3=document.getElementById("event");
		var tabspan3=document.getElementById("event_tabspan");		  */
		var tab1=document.getElementById("eventwise_segment");
		var tabspan1=document.getElementById("eventwise_segment_tabspan");
		var tab2=document.getElementById("segment");
		var tabspan2=document.getElementById("segment_tabspan");
		var tab3=document.getElementById("event");						 
		var tabspan3=document.getElementById("event_tabspan");
		if(str=='event')
		{
		tab1.className='tabA';					 
		tabspan1.className='tabAspan';
		tab2.className='tabA';
		tabspan2.className='tabAspan';
		tab3.className='tabClicked';
		tabspan3.className='tabSpanclicked';
		document.forms[0].option.value="event";

		 if(document.forms[0].fun_id.value!==''||document.forms[0].fun_id.value!==null)		  
		{
			
			parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeMessageTypeMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.frames[1].document.forms[0].standard_code.value;	 
		}
		else
		{
			parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeMessageTypeMain.jsp';
		}


//		parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}

		if(str=='segment')
		{

		

		tab1.className='tabA';
		tabspan1.className='tabAspan';
		tab2.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab3.className='tabA';
		tabspan3.className='tabAspan';									   
		document.forms[0].option.value="segment";
		 if(document.forms[0].fun_id.value!==''||document.forms[0].fun_id.value!==null) 
		{
			parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeSegmentTypeMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.frames[1].document.forms[0].standard_code.value;	
		 }
		else
		{
		parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeSegmentTypeMain.jsp';
		}

//			parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}

		if(str=='eventwise_segment')
		{
		tab1.className='tabClicked';
		tabspan1.className='tabSpanclicked';
		tab2.className='tabA';
		tabspan2.className='tabAspan';									 
		tab3.className='tabA';																	   
		tabspan3.className='tabAspan';
		document.forms[0].option.value="eventwise_segment";

		if(document.forms[0].fun_id.value!==''||document.forms[0].fun_id.value!==null)
		{ 
			
			parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeEventwiseSegmentMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.frames[1].document.forms[0].standard_code.value+'&segment_type='+event_type;			 
		}
		else
		{
		parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeEventwiseSegmentMain.jsp';
		}
//		parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
		parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}
	}
	 else
	 {
				
			var tab1=parent.parent.frames[1].document.getElementById("eventwise_segment");
			var tabspan1=parent.parent.frames[1].document.getElementById("eventwise_segment_tabspan");
			var tab2=parent.parent.frames[1].document.getElementById("segment");
			var tabspan2=parent.parent.frames[1].document.getElementById("segment_tabspan");
			var tab3=parent.parent.frames[1].document.getElementById("event");						 
			var tabspan3=parent.parent.frames[1].document.getElementById("event_tabspan");
			if(str=='eventwise_segment')
			{
				tab1.className='tabClicked';
				tabspan1.className='tabSpanclicked';
				tab2.className='tabA';
				tabspan2.className='tabAspan';
				tab3.className='tabA';																	   
				tabspan3.className='tabAspan';
				parent.parent.frames[1].document.forms[0].option.value="eventwise_segment";
				parent.parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeEventwiseSegmentMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.parent.frames[1].document.forms[0].standard_code.value+'&event_type='+event_type;
				parent.parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
				parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
			}
			 else if(str=='segment')
			 {
				tab1.className='tabA';											   
				tabspan1.className='tabAspan';
				tab2.className='tabClicked';
				tabspan2.className='tabSpanclicked';
				tab3.className='tabA';
				tabspan3.className='tabAspan';
				parent.parent.frames[1].document.forms[0].option.value="eventwise_segment";
				parent.parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeSegmentTypeMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.parent.frames[1].document.forms[0].standard_code.value+'&Segment_type='+event_type;	  
				parent.parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
				parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
			 }
		}
	}	


function callJSPs1(str,event_type,fun_id)										  							   
{			
	
 
	if(fun_id=='' || fun_id==null)
	{
			   
	
	/*	var tab1=document.getElementById("eventwise_segment");
		var tabspan1=document.getElementById("eventwise_segment_tabspan");
		var tab2=document.getElementById("segment");
		var tabspan2=document.getElementById("segment_tabspan");
		var tab3=document.getElementById("event");
		var tabspan3=document.getElementById("event_tabspan");		  */
		var tab1=parent.parent.frames[1].document.getElementById("eventwise_segment");
		var tabspan1=parent.parent.frames[1].document.getElementById("eventwise_segment_tabspan");
		var tab2=parent.parent.frames[1].document.getElementById("segment");
		var tabspan2=parent.parent.frames[1].document.getElementById("segment_tabspan");
		var tab3=parent.parent.frames[1].document.getElementById("event");						 
		var tabspan3=parent.parent.frames[1].document.getElementById("event_tabspan");
		if(str=='event')
		{
		tab1.className='tabA';					 
		tabspan1.className='tabAspan';
		tab2.className='tabA';
		tabspan2.className='tabAspan';
		tab3.className='tabClicked';
		tabspan3.className='tabSpanclicked';
		parent.parent.frames[1].document.forms[0].option.value="event";

		 if(document.forms[0].fun_id.value!==''||document.forms[0].fun_id.value!==null)		  
		{
			
			parent.parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeMessageTypeMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.parent.frames[1].document.forms[0].standard_code.value;	 
		}
		else
		{
			parent.parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeMessageTypeMain.jsp';
		}


		parent.parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}

		if(str=='segment')
		{
		tab1.className='tabA';
		tabspan1.className='tabAspan';
		tab2.className='tabClicked';
		tabspan2.className='tabSpanclicked';
		tab3.className='tabA';
		tabspan3.className='tabAspan';
		parent.parent.frames[1].document.forms[0].option.value="segment";
		 if(document.forms[0].fun_id.value!==''||document.forms[0].fun_id.value!==null) 
		{
			 parent.parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeSegmentTypeMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.parent.frames[1].document.forms[0].standard_code.value;	
		 }
		else
		{
			parent.parent.f_query_add_mod.location.href ='../../eXH/jsp/EventTypeSegmentTypeMain.jsp';
		}

			parent.parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
			parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}

		if(str=='eventwise_segment')
		{
		tab1.className='tabClicked';
		tabspan1.className='tabSpanclicked';
		tab2.className='tabA';
		tabspan2.className='tabAspan';									 
		tab3.className='tabA';																	   
		tabspan3.className='tabAspan';
		parent.parent.frames[1].document.forms[0].option.value="eventwise_segment";

		if(document.forms[0].fun_id.value!==''||document.forms[0].fun_id.value!==null)
		{ 
			
		   parent.parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeEventwiseSegmentMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.parent.frames[1].document.forms[0].standard_code.value+'&segment_type='+event_type;
		}
		else
		{
			parent.parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeEventwiseSegmentMain.jsp';
		}
		parent.parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
		parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}
	}
	 else
	 {
				
			var tab1=parent.parent.frames[1].document.getElementById("eventwise_segment");
			var tabspan1=parent.parent.frames[1].document.getElementById("eventwise_segment_tabspan");
			var tab2=parent.parent.frames[1].document.getElementById("segment");
			var tabspan2=parent.parent.frames[1].document.getElementById("segment_tabspan");
			var tab3=parent.parent.frames[1].document.getElementById("event");						 
			var tabspan3=parent.parent.frames[1].document.getElementById("event_tabspan");
			if(str=='eventwise_segment')
			{
				tab1.className='tabClicked';
				tabspan1.className='tabSpanclicked';
				tab2.className='tabA';
				tabspan2.className='tabAspan';
				tab3.className='tabA';																	   
				tabspan3.className='tabAspan';
				parent.parent.frames[1].document.forms[0].option.value="eventwise_segment";
				parent.parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeEventwiseSegmentMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.parent.frames[1].document.forms[0].standard_code.value+'&event_type='+event_type;
				parent.parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
				parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
			}
			 else if(str=='segment')
			 {
				tab1.className='tabA';											   
				tabspan1.className='tabAspan';
				tab2.className='tabClicked';
				tabspan2.className='tabSpanclicked';
				tab3.className='tabA';
				tabspan3.className='tabAspan';
				parent.parent.frames[1].document.forms[0].option.value="eventwise_segment";
				parent.parent.f_query_add_mod.location.href='../../eXH/jsp/EventTypeSegmentTypeMain.jsp?&function_type=F&access=NYNNN&rule=L&home_required_yn=N&fun_id='+parent.parent.frames[1].document.forms[0].fun_id.value+'&profile_id='+parent.parent.frames[1].document.forms[0].profile_id.value+'&stnd_code='+parent.parent.frames[1].document.forms[0].standard_code.value+'&Segment_type='+event_type;	  
				parent.parent.f_query_add_mod_add.location.href='../../eCommon/html/blank.html';
				parent.parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
			 }
		}
	}																				 
												 						  
