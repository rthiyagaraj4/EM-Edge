function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/Responsibility_Form.jsp" ;
	
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}


function query() {	
	f_query_add_mod.location.href ="../../eSM/jsp/ResponsibilityQueryPage.jsp?function=Responsibility";
}

function apply() {
	

	if(f_query_add_mod.document.responsibility_form!=null)
	{
if(f_query_add_mod.document.responsibility_form.eff_status.checked==false)
 {
	f_query_add_mod.document.responsibility_form.resp_name.disabled= false;
	f_query_add_mod.document.responsibility_form.resp_group_id.disabled= false;
	f_query_add_mod.document.responsibility_form.menu_id.readonly= false;
	f_query_add_mod.document.responsibility_form.ora_role_id.disabled= false;
	f_query_add_mod.document.responsibility_form.remarks.disabled= false;
	f_query_add_mod.document.responsibility_form.eff_date_from.disabled=false;
	f_query_add_mod.document.responsibility_form.eff_date_from1.disabled=false;
	f_query_add_mod.document.responsibility_form.eff_date_to.disabled=false;
	f_query_add_mod.document.responsibility_form.eff_date_to1.disabled=false;

 }

 if(f_query_add_mod.document.responsibility_form.menu_id_desc.value!=='')
{
	hideUserdesktop1(f_query_add_mod.document.responsibility_form.menu_id_desc,f_query_add_mod.document.responsibility_form.menu_id)
}

if (f_query_add_mod.document.responsibility_form.function_name.value=="modify")
 {
	f_query_add_mod.document.responsibility_form.menuid_t.value=f_query_add_mod.document.responsibility_form.menu_id.value;
	f_query_add_mod.document.responsibility_form.resp_group_id1.value=f_query_add_mod.document.responsibility_form.resp_group_id.value;
	f_query_add_mod.document.responsibility_form.ora_role_id1.value=f_query_add_mod.document.responsibility_form.ora_role_id.value;
}

if(f_query_add_mod.CheckMaxLen1(getLabel("Common.remarks.label","Common"),f_query_add_mod.document.responsibility_form.remarks,200,messageFrame)) 
{
	var fields = new Array (
f_query_add_mod.document.responsibility_form.resp_id,
	f_query_add_mod.document.responsibility_form.resp_name,
	f_query_add_mod.document.responsibility_form.menu_id,
	f_query_add_mod.document.responsibility_form.ora_role_id	
	);	

	
	var names = new Array (getLabel("Common.identification.label","Common"), 
	getLabel("Common.name.label","Common"),
	getLabel("Common.menu.label","Common"),
	getLabel("Common.Role.label","Common"));	

	var name = new Array ( getLabel("Common.identification.label","Common")  );	
	var field = new Array ( f_query_add_mod.document.responsibility_form.resp_id );	
	var transform = new Array (  f_query_add_mod.document.responsibility_form,
	f_query_add_mod.document.responsibility_form.eff_date_from,
	f_query_add_mod.document.responsibility_form.eff_date_from1,
	f_query_add_mod.document.responsibility_form.eff_date_to,
	f_query_add_mod.document.responsibility_form.eff_date_to1
	);	
//Added for the Incident No : 32478 by Maheshwaran K as on 29/05/2012	
//Start
var frmdate=f_query_add_mod.document.responsibility_form.eff_date_from1.value;
var todate=f_query_add_mod.document.responsibility_form.eff_date_to1.value;
//End
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 	{
		if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))		{
		//Commented for the Incident No : 32478 by Maheshwaran K as on 29/05/2012
		//Change the method from "DateTransform" to "doDateCheckMst"
			//if(f_query_add_mod.DateTransform(transform,messageFrame)) 			{	
			if(f_query_add_mod.doDateCheckMst(frmdate,todate,messageFrame)) 		{	
			var fn_status = f_query_add_mod.document.responsibility_form.function_name.value ;
			if(f_query_add_mod.document.responsibility_form.desktop_code.value!='') {
					//desktop_code_valid1();
					if(f_query_add_mod.document.responsibility_form.desktop_summary_type.value=='C')
						{
						if(f_query_add_mod.document.responsibility_form.flagg.value=='N')
							{
						    alert(getMessage("MISMATCH_CLINICIAN_MENU","SM"));
							f_query_add_mod.document.responsibility_form.desktop_code.value="";
							f_query_add_mod.document.responsibility_form.dektop_id_desc.value="";
							f_query_add_mod.document.forms[0].dektop_id_desc.focus();
							messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';						
							return false;
							}
						else
							{
							f_query_add_mod.document.responsibility_form.action='../../servlet/eSM.ResponsibilityServlet';
							f_query_add_mod.document.responsibility_form.submit();
							
							}
						 }
					else
						{
						f_query_add_mod.document.responsibility_form.action='../../servlet/eSM.ResponsibilityServlet';
						f_query_add_mod.document.responsibility_form.submit();
					
						}
				}else
					{
					f_query_add_mod.document.responsibility_form.action='../../servlet/eSM.ResponsibilityServlet';
					
					f_query_add_mod.document.responsibility_form.submit();
					}
				}	
			}
		}
	}


if(f_query_add_mod.document.responsibility_form.eff_status.checked==false)
{
	f_query_add_mod.document.responsibility_form.resp_name.disabled= true;
	f_query_add_mod.document.responsibility_form.resp_group_id.disabled= true;
	f_query_add_mod.document.responsibility_form.menu_id.readonly= true;
	f_query_add_mod.document.responsibility_form.ora_role_id.disabled= true;
	f_query_add_mod.document.responsibility_form.remarks.disabled= true;
	f_query_add_mod.document.responsibility_form.eff_date_from.disabled=true;
	f_query_add_mod.document.responsibility_form.eff_date_from1.disabled=true;
	f_query_add_mod.document.responsibility_form.eff_date_to.disabled=true;
	f_query_add_mod.document.responsibility_form.eff_date_to1.disabled=true;
}
	/* removed*/
   }else{
		frames[0].location.reload();
		return false;
	  }
}

function onSuccess() 
{
	
	f_query_add_mod.document.location.reload();
}

function reset() {
		
			if(f_query_add_mod.document.forms[0])
						 f_query_add_mod.document.location.reload();
		
		
}



		async function populateDesktop(obj,target,target_id)
			{
				var sql="";
				var retVal			= new String();
				var argumentArray	= new Array() ;
				var dataNameArray	= new Array() ;
				var dataValueArray	= new Array() ;
				var dataTypeArray	= new Array() ;

				var tit=getLabel('Common.code.label','Common');

				
				
				sql="select DESKTOP_SUMMARY_ID code, DESKTOP_SUMMARY_NAME description from SM_DESKTOP_SUM_HDR where eff_status = 'E'  and upper(DESKTOP_SUMMARY_ID) like upper(?) and upper(DESKTOP_SUMMARY_NAME) like upper(?)"

				//sql="select desktop_code code, desktop_name description from sm_desktop_setup where eff_status = 'E'  and upper(desktop_code) like upper(?) and upper(desktop_name) like upper(?)"
				
				argumentArray[0]=sql;
				argumentArray[1]=dataNameArray;
				argumentArray[2]=dataValueArray;
				argumentArray[3]=dataTypeArray;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=DESC_LINK;
				argumentArray[7]=DESC_CODE;
				retVal= await CommonLookup(tit,argumentArray);

				if(retVal!=null && retVal!=""){
					var ret1=unescape(retVal);
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else{
					target.value="";
					target_id.value="";
				}
				}
	
	function validate_from_date(obj)
			{
				if(document.forms[0].function_name.value=="insert")
				{
					if(obj.value.length>0)
					if(validDateObj(obj,"DMY",localeName))
				    {
						
					   DateValidation(obj);
					}
				}
				else if(document.forms[0].function_name.value=="modify")
				{
					if(document.forms[0].old_eff_date_from.value=="")
					{
						if(obj.value.length>0)
						{
							if(validDateObj(obj,"DMY",localeName))
							{
							   DateValidation(obj);
							}		
						}
					}
					else
					{
						if(obj.value.length<=0)
						{
							validDateObj(obj,"DMY",localeName);
						}
						else
						{
							if(validDateObj(obj,"DMY",localeName))
							{
							   DateValidation(obj);
							}					
						}
					}
				}
				if(document.forms[0].eff_date_from1.value!="" && document.forms[0].eff_date_to1.value!="")
					{
							 if(!(isBefore(document.forms[0].eff_date_from1.value,document.forms[0].eff_date_to1.value,"DMY",localeName)))
								{
									   alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
									   document.forms[0].eff_date_to1.value='';
										document.forms[0].eff_date_to1.select();
										document.forms[0].eff_date_to1.focus();						
								}	
					}
			}

			function validate_to_date(obj)
			{
				if(document.forms[0].function_name.value=="insert")
				{
				 if(validDateObj(obj,"DMY",localeName))
				  {
					if(DateValidation(obj)!=false){

					if(document.forms[0].eff_date_from1.value!="" && document.forms[0].eff_date_to1.value!="")
					{
							 if(!(isBefore(document.forms[0].eff_date_from1.value,document.forms[0].eff_date_to1.value,"DMY",localeName)))
								{
									   alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
									   obj.value='';
										obj.select();
										obj.focus();						
								}	
					}
					else
					{
						if(obj.value.length<0)
						{
							validDateObj(obj,"DMY",localeName);
							DateValidation(obj);
						}
					}
				  }
				  }
				}
				else if(document.forms[0].function_name.value=="modify")
				{
					
					if(document.forms[0].eff_date_from1.value=="")
					{
						if(obj.value.length>0)
						{
							if(validDateObj(obj,"DMY",localeName))
							{
							   DateValidation(obj);
							}
						}
					}
					else
					{
						if(validDateObj(obj,"DMY",localeName))
							{
						    if(DateValidation(obj)!=false){
							if(!(isBefore(document.forms[0].eff_date_from1.value,document.forms[0].eff_date_to1.value,"DMY",localeName)))
								{
									    alert(getMessage("TO_DT_GR_EQ_FM_DT","SM"));
									    obj.value='';
										obj.select();
										obj.focus();						
								}
							}
							}
					}
				}
			}

function DateValidation(obj)
{
	
	var msg="";

	if(obj.name=="eff_date_from1")
	   msg = getMessage("FROM_DATE_LESS_SYSDATE","SM");
	if(obj.name=="eff_date_to1")
	   msg = getMessage("TO_DATE_LESS_SYSDATE","SM");
	if(!(isAfterNow(obj.value,"DMY",localeName)))
	{
		obj.focus();
		obj.select();
		obj.value='';
		alert(msg);
		return false;
	}
}

	function callnew(obj)
			{
			document.forms[0].menuid_t.value=obj.value;
			}

	function CheckMaxLen1(lab,obj,max,messageFrame) {
			if(obj.value.length > max) {
				msg=getMessage("REMARKS_NOT_EXCEED_200_CH",'SM');
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg ;
				return false;
			} else return true;
	}

				function change() {
				 if (responsibility_form.eff_status.checked == true)
				{
					 responsibility_form.eff_status.value="E";
				}
				 else
				{
					responsibility_form.eff_status.value="D";
				}
			  }

			function PopMenuName(){
							var MenuName;
							var MenuId;
							var  HTMLVal = new String();
							clear_list(parent.frames[1].document.forms[0].menu_id);

								 MenuName = document.responsibility_form.resp_group_id.value;
								
								 var function_name = document.responsibility_form.function_name.value;
								 if (function_name=="modify"){
								 MenuId = document.responsibility_form.menuid.value;
								 desk_code1 = document.responsibility_form.desk_code1.value;
								 }

							if (MenuName != null || MenuName != '')
							{
						
								HTMLVal = "<html><head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body onKeyDown = 'lockKey()'><form name='dum_form1' id='dum_form1' method='post' action='../../eSM/jsp/RespGetValMenu.jsp'><input type='hidden' name='role_type' id='role_type' value=''><input type='hidden' name='MenuName' id='MenuName' value='"+MenuName+"'><input type='hidden' name='Menu_id' id='Menu_id' value='"+MenuId+"'></form></body></html>";
								parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
								parent.messageFrame.document.forms[0].submit();

							}
	
							}

			
			function populateDesktopBlur(obj,target,target_id){
				if(target.value!=""){					
					populateDesktop(obj,target,target_id);
					
				}else{
					target_id.value="";
				}


			}


			function populateMenuBlur(obj,target,target_id){
				if(target.value!=""){					
					populateMenu(obj,target,target_id);
					
				}else{
					target_id.value="";
				}

			}

			
			async function populateMenu(obj,target,target_id)
			{
	
				var sql="";
				var retVal			= new String();
				var argumentArray	= new Array() ;
				var dataNameArray	= new Array() ;
				var dataValueArray	= new Array() ;
				var dataTypeArray	= new Array() ;
				var tit=getLabel('Common.menu.label','Common');
				sql="select menu_id code,menu_NAME description from sm_menu_hdr where root_menu_yn='Y'  and (ADHOC_MENU_YN='N' OR TRUNC(SYSDATE) BETWEEN Nvl(ADHOC_MENU_EFF_FROM,TRUNC(SYSDATE)) AND NVL(ADHOC_MENU_EFF_TO ,TRUNC(SYSDATE))) and upper(menu_id) like upper(?) and upper(menu_name) like upper(?) ";
				
				argumentArray[0]=sql;
				argumentArray[1]=dataNameArray;
				argumentArray[2]=dataValueArray;
				argumentArray[3]=dataTypeArray;
				argumentArray[4]="1,2";
				argumentArray[5]=target.value;
				argumentArray[6]=DESC_LINK;
				argumentArray[7]=DESC_CODE;
				retVal=await CommonLookup(tit,argumentArray);

				if(retVal!=null && retVal!=""){
					var ret1=unescape(retVal);
					
					arr=ret1.split(",");
					target.value=arr[1];
					target_id.value=arr[0];
				}else{
					target.value="";
					target_id.value="";
				}
		       }

    function hideUserdesktop1(obj,target_id)
	{
	var menu=obj.value;
	var menuid=target_id.value;

   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY class='message' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eSM/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='menuid' id='menuid' value='"+menuid+"'></form></BODY></HTML>";
   parent.frames[2].frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
   parent.frames[2].frames[2].document.form1.submit();


	}



     function hideUserdesktop(obj,target_id)
	{
	var menu=obj.value;
	var menuid=target_id.value;

  removeitems(document.forms[0].menu_id);

 
   HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><BODY class='message' onKeyDown = 'lockKey()'><form name='form1' id='form1' method='post' action='../../eSM/jsp/GetUserDesktopValue.jsp'><input type='hidden' name='menuid' id='menuid' value='"+menuid+"'></form></BODY></HTML>";
   parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
   parent.messageFrame.document.form1.submit();

	}
	 function removeitems(obj)
{
    var len=obj.length;
    var i=1;
    while(i<len)
    {
        len=obj.length
        obj.remove(i)
    }
}

			function clear_list(obj)
			{			
						while ( obj.options.length > 0 )
						obj.remove(obj.options[0]);
			}
			
			function clearMenu()
			{
			document.forms[0].menu_id_desc.value='';
			document.forms[0].menu_id.value='';
			}
			
	function desktop_code_valid()
	{
      if(document.responsibility_form.desktop_code.value!='')
	{
	 var desktop_code=document.responsibility_form.desktop_code.value;
	 var Menu_id=document.responsibility_form.menu_id.value;
	 var flagg =document.responsibility_form.flagg.value;
	 var HTMLVal = new String();		
	 var process_id="Desktop_code1";
     HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eSM/jsp/ResponsibilityValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='"+process_id+"'><input type='hidden' name='desktop_code' id='desktop_code' value='"+desktop_code+"'><input type='hidden'  name='Menu_id' id='Menu_id' value='"+Menu_id+"'></form></BODY></HTML>";
    parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.messageFrame.document.form1.submit(); 
		}
	}


	function desktop_code_valid1()
	{
      if(f_query_add_mod.document.responsibility_form.desktop_code.value!='')
	{
	 var desktop_code=f_query_add_mod.document.responsibility_form.desktop_code.value;
	 var Menu_id=f_query_add_mod.document.responsibility_form.menu_id.value;
	 var flagg=f_query_add_mod.document.responsibility_form.flagg.value;
	 var HTMLVal = new String();		
	 var process_id="Desktop_code1";
  	 HTMLVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><BODY class='message' onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eSM/jsp/ResponsibilityValidation.jsp'><input type='hidden' name='process_id' id='process_id' value='"+process_id+"'><input type='hidden' name='desktop_code' id='desktop_code' value='"+desktop_code+"'><input type='hidden'  name='Menu_id' id='Menu_id' value='"+Menu_id+"'></form></BODY></HTML>";
    parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
    parent.messageFrame.document.form1.submit(); 
		}
	}

