//this function is used to get the correct frame reference
//use  Reference whenever u want to refer the message frame

function getMessageFrame()
{
	if(top.content!=null){
		return top.content.messageFrame;
	}else{
		return top.messageframe;
	}
}
var messageFrameReference = getMessageFrame();
function create() {
	f_query_add_mod.location.href = "../../eCA/jsp/TemplateComponentAddModify.jsp?mode=insert" ;
}

function query() {
	f_query_add_mod.location.href ="../../eCA/jsp/TemplateComponentQueryCriteria.jsp";
}


function apply()
{
	
	if(!chkMinMax())
		return false;

	var	comp_length = f_query_add_mod.document.TemplateComponent_form.len;

	if(f_query_add_mod.checkLength(comp_length)==false)
		return false;

	if(	chkALLValues()==false)
		return false;


	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	var fieldsforspchar = new Array( f_query_add_mod.document.TemplateComponent_form.comp_id);
	var namesforspchar = new Array("Component ID");

	var fields = new Array (f_query_add_mod.document.TemplateComponent_form.comp_id,
							f_query_add_mod.document.TemplateComponent_form.comp_prompt,
							f_query_add_mod.document.TemplateComponent_form.long_desc,
							f_query_add_mod.document.TemplateComponent_form.short_desc,
							f_query_add_mod.document.TemplateComponent_form.comp_type,
							f_query_add_mod.document.TemplateComponent_form.accept_option
						);
	var names = new Array (	getLabel("Common.identification.label","COMMON"),
							getLabel("eCA.PromptText.label","CA"),				
							getLabel("Common.longdescription.label","COMMON"),
						    getLabel("Common.shortdescription.label","COMMON"),
							getLabel("Common.ComponentType.label","COMMON"),
							getLabel("Common.AcceptOption.label","COMMON")
							);

	if(f_query_add_mod.SpecialCharCheck(fieldsforspchar,namesforspchar,messageFrame,"M", error_page))
	{
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			var type = f_query_add_mod.document.TemplateComponent_form.comp_type.value;
			var option = f_query_add_mod.document.TemplateComponent_form.accept_option.value;
			if(type=="P")
			{
				fields = new Array (f_query_add_mod.document.TemplateComponent_form.paragraphDef);
				names = new Array (	getLabel("Common.ParagraphDefinition.label","COMMON"));
				if(f_query_add_mod.checkFields( fields, names, messageFrame))
				{
					f_query_add_mod.document.TemplateComponent_form.submit();
				}
			}
			else if(type=="L" && option=='R')
			{
				
				fields = new Array (f_query_add_mod.document.TemplateComponent_form.alpha_info_values);
				
				names = new Array (	getLabel("Common.AlphaInfo.label","COMMON"));
				if(f_query_add_mod.checkFields( fields, names, messageFrame))
				{
					
					f_query_add_mod.document.TemplateComponent_form.submit();
				}
			}
			else if(type=="I" || type=='N')
			{
				//checking the valid default value added in case of Decimal or numeric fields
				if(validateNumber(f_query_add_mod.document.TemplateComponent_form.default_val,"Apply"))
				{					
					f_query_add_mod.document.TemplateComponent_form.submit();
				}
			}
			else
			{
				f_query_add_mod.document.TemplateComponent_form.submit();
			}
		}
	}
}

function onSuccess() {
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		create();
	else
         f_query_add_mod.location.reload();
}

/*function reset() {
	if(f_query_add_mod.document.forms[0].name == "TemplateComponent_form") 
	{
		f_query_add_mod.document.TemplateComponent_form.reset() ;
		if(f_query_add_mod.document.TemplateComponent_form.mode.value!="update")
			f_query_add_mod.document.getElementById("alpha_info").style.visibility = 'hidden';
	}

	else 
		f_query_add_mod.document.query_form.reset() ;
}*/
function reset()
{
	
		if(f_query_add_mod.document.forms[0]!=null){
	if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"|| f_query_add_mod.document.forms[0].mode.value=="update")
			
				f_query_add_mod.location.href='../../eCA/jsp/TemplateComponentAddModify.jsp';
	}
	else
		f_query_add_mod.location.href='../../eCA/jsp/TemplateComponentQueryCriteria.jsp';
}
}


function validateNumber(obj,calledFrom)//Check for Integer and Decimal
{
	
	var ref = null;
	var messageRef = null;
	if(calledFrom=="Apply")
	{
		ref = f_query_add_mod.document.forms[0];
		messageRef = messageFrame;
	}
	else
	{
		ref = document.forms[0];
		messageRef = parent.messageFrame;
	}
	//messageRef.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;
	if(ref.comp_type.value == "N" || ref.comp_type.value == "I")
	{			
		//if(CheckNum(obj))
		{
					var n = obj.value;
					var num = n.length;
					var frac = 0;

					if((n.indexOf(".")) >= 0)
					{
								var arr =  new Array();
								arr = n.split(".");
								num = arr[0].length;
								frac = arr[1].length;
								num += frac
					}

					var maxlen	 = eval(ref.max.value)
					var minlen	 = eval(ref.min.value)
					var preci	 = eval(ref.decimal.value)

					if(maxlen!=0 && parseFloat(obj.value) > parseFloat(maxlen) )
					{
						var error = getMessage('INVALID_DFLT_VAL','CA');
						obj.select();
						obj.focus();
						messageRef.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
						return false;
					}
					else if(minlen!=0 && parseFloat(obj.value) < parseFloat(minlen))
					{
						var error = getMessage('INVALID_DFLT_VAL','CA');
						obj.select();
						obj.focus();
						messageRef.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
						return false;
					}
				/*	else if((preci==0 || preci==null ) && (n.indexOf(".") >= 0))
					{
						alert(parent.getMessage('INVALID_PRECISION'));
						obj.select();
						obj.focus();
						return false;
					}*/
					else if (preci!=null && preci!=0 && frac > preci )
					{
						var error = getMessage('INVALID_PRECISION','CA');
						obj.select();
						obj.focus();
						messageRef.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
						return false;
					}
					else
					{
						return true;
					}
		}
		//else
			//return false;
	}
	messageRef.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;
	return ;			
}

async function getAlphaInfo(obj)	 ///function to show modal dailog for List
{
	if(obj.value=='Alpha Info')
	{
		var compid = self.document.forms[0].comp_id.value
		var dialogHeight ='12' ;
		var dialogWidth = '40' ;
		var dialogTop	= '350';
		var dialogLeft = '157' ; 

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var arguments = "";
		var convals = parent.frames[1].document.forms[0].alpha_info_values.value;

		var retVals =await window.showModalDialog("../../eCA/jsp/TemplateComponent.jsp?from=A&comp_id="+compid+"&con_vals="+escape(convals),arguments,features);

		if(retVals !=null)
			parent.frames[1].document.forms[0].alpha_info_values.value=retVals;
		
	}
	else if(obj.value=='Definition')
	{
		var compid = self.document.forms[0].comp_id.value
		var dialogHeight ='11' ;
		var dialogWidth = '40' ;
		var dialogTop	= '220';
		var dialogLeft = '157' ; 

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		
		//var paraDefinition = parent.frames[1].document.forms[0].paragraphDef.value;
		var action_url = "../../eCA/jsp/TemplateParagraphMain.jsp?comp_id="+compid;

		//var retVals = window.showModalDialog("../../eCA/jsp/TemplateParagraphMain.jsp?comp_id="+compid,arguments,features);
		//alert(paragraphWindowRef);
		var clipBoardVal=obj.createTextRange();
		clipBoardVal.select();
		clipBoardVal.execCommand("copy","","");

		paragraphWindowRef = window.open(action_url,null,"height=320,width=630,top=220,left=150,status=NO,toolbar=no,menubar=no,location=no");
		document.forms[0].eff_status.focus();
		//if(retVals !=null)
			//parent.frames[1].document.forms[0].paragraphDef.value=retVals;
	}
	else if(obj.value == 'Define Grid')
	{
		var gridID = self.document.forms[0].comp_id.value;
		var griddesc = self.document.forms[0].short_desc.value;
		var grid_max_columns_allowed = self.document.forms[0].grid_max_columns_allowed.value;
		if(gridID == "" || griddesc == "")
		{
			alert(getMessage("GRIDID_DESC_VALID","CA"));
			return;
		}
		var short_desc = escape(self.document.forms[0].short_desc.value);
		var gridComponentDefinition = document.TemplateComponent_form.gridComponentDefinition.value;
		var dialogHeight ='29' ;
		var dialogWidth = '50' ;
		var dialogTop	= '98';
		var dialogLeft = '157' ; 
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var action_url = "../../eCA/jsp/TemplateGridMain.jsp?gridID="+gridID + "&gridComponentDefinition=" + escape(gridComponentDefinition) + "&grid_desc=" + short_desc + "&grid_max_columns_allowed=" + grid_max_columns_allowed;
		var retVal_grid =await window.showModalDialog(action_url, arguments, features);		
		//window.open(action_url,null,"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");		
		if(retVal_grid != null )
			if(retVal_grid != "")
				document.TemplateComponent_form.gridComponentDefinition.value = retVal_grid;
	}
	else if(obj.value == "Define Matrix")
	{
		var matrixID = self.document.TemplateComponent_form.comp_id.value;
		var matrixdesc = self.document.TemplateComponent_form.short_desc.value;
		var matrix_max_columns_allowed = self.document.TemplateComponent_form.matrix_max_columns_allowed.value;
		var matrixComponentDefinition = self.document.TemplateComponent_form.matrixComponentDefinition.value;
		if(matrixID == "" || matrixdesc == "")
		{
			alert(getMessage("MATRIXID_DESC_VALID","CA"));
			return;
		}
		var total_colSpan = 0;		
		if(total_colSpan > 5)
		{
			alert(getMessage("INVALID_MATRIX_COLUMN_VALUES","CA"));
			return;
		}
		var dialogHeight ='30' ;
		var dialogWidth = '60' ;
		var dialogLeft = '40';
        var dialogTop  = '85';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var action_url = "../../eCA/jsp/TemplateMatrixComponentMain.jsp?matrixID=" + matrixID + "&matrixDesc=" + escape(matrixdesc) + "&matrix_max_columns_allowed=" + matrix_max_columns_allowed + "&matrixComponentDefinition=" + matrixComponentDefinition;
		//alert(action_url + "=" + features + "=" + matrixComponentDefinition + "=");
		var retVal_matrix = window.showModalDialog(action_url, "", features);
		//window.open(action_url,null,"height=430,width=790,top=100,left=0,status=NO,toolbar=no,menubar=no,location=no");
		if(retVal_matrix != null)
			self.document.TemplateComponent_form.matrixComponentDefinition.value = retVal_matrix;
	}
}
function chkMinMax() //Check between min and max
{
	var obj = f_query_add_mod.document.forms[0] ;
	var error = getMessage("INVALID_VALUE","CA");
	error=error.replace('$','Minimun Value');
	//var error = getMessage("INVALID_MIN_VAL");
	
	if(obj.min.value != "" && obj.max.value != "")
	{
	   if(parseFloat(obj.min.value) > parseFloat(obj.max.value))
		{
			obj.min.focus();
			obj.min.select();
			messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			return false ;
		}
	}

	return true ;
}


function chkALLValues()//On apply all the lengths and  values are checked once again
{
	
	var obj = f_query_add_mod.document.forms[0] ;
	var error = getMessage("DEFAULT_VAL_LEN","CA");
	if(obj.len.value !=0 && obj.len.value != "" && obj.len.value != null) //IF LENGTH IS ENTERDED ---chk for the length of default feild	
	{											
		if(obj.comp_type.value != 'N') //If comp_type is not numeric
		{
			if(obj.default_val.value.length > parseFloat(obj.len.value)) //CHKS WHETHER THE LENGTH of min,max & Default ENTERED IS WITHIN THE MAX ALLOWABLE LENGTH
			{
				obj.default_val.select();
				obj.default_val.focus();
				messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
				return false ;
			}
			if(obj.max.value.length > parseFloat(obj.len.value)) //CKS WHETHER THE LEN OF mAX LENGTH FEILD IS WITH IN THE THE ALLOWABLE LENGTH
			{
						var error = getMessage("MAXIMUM_DIGITS","CA") + " :"  + obj.len.value;//"INVALID_MAX_LENGTH";//TO BE ADDDED
						obj.max.select();
						obj.max.focus();
						messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
						return false ;
			}

			if(obj.min.value.length > parseFloat(obj.len.value)) //CKS WHETHER THE LEN OF min LENGTH FEILD IS WITH ID\N THE THE ALLOWABLE LENGTH
			{
						var error = getMessage("MAXIMUM_DIGITS","CA") + " :"  + obj.len.value;//TO BE ADDED
						obj.min.select();
						obj.min.focus();
						messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
						return false ;
			}
		}
		else //cks for min and max length when Comp_type is Decimal numeric
		{		
			if( obj.max.value.length > parseFloat(obj.len.value) && (obj.decimal.value == "" || obj.decimal.value == null)) //CKS WHETHER THE LEN OF mAX LENGTH FEILD IS WITH IN THE THE ALLOWABLE LENGTH
			{
						var error = getMessage("MAXIMUM_DIGITS","CA") + " :"  + obj.len.value;
						obj.max.select();
						obj.max.focus();
						messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
						return false ;
			}
			if(obj.min.value.length > parseFloat(obj.len.value) && (obj.decimal.value == "" || obj.decimal.value == null)) //CKS WHETHER THE LEN OF min LENGTH FEILD IS WITH ID\N THE THE ALLOWABLE LENGTH
			{
						var error = getMessage("MAXIMUM_DIGITS","CA") + " :"  + obj.len.value;//TO BE ADDED
						obj.min.select();
						obj.min.focus();
						messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
						return false ;
			}			
		}
		}
		else
		{
			//LENGTH IS NOT ENTERED BUT THE PRECISON IS STILL THERE THAN
			if(obj.decimal.value.length > 0 && obj.comp_type.value == "N")
			{
					var error =getMessage("INVALID_PRECISION","CA");
					obj.decimal.select();
					obj.decimal.focus();
					messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
					return false ;
						
			}
		}	
	//chks for the decimal points for DEFAULT VALUE
	if(obj.comp_type.value == "I" || obj.comp_type.value == "N")
	{
		var  arr	= new Array();
		var  num	= 0;
		var  frac	= 0;
		var dec = obj.decimal.value ;
		var len = obj.len.value ;
		if((dec !="" || dec!=null) && (len !="" || len != null))
		{
				if(!chkprec(obj.min))//chs whether min value entered is  proper
				return false;
				if(!chkprec(obj.max))//chs whether max value entered is  proper
				return false;
		}
		if((obj.default_val.value.indexOf(".")) > 0) //ONLY IF THE DEFAULT LENGTH HAVE DIGIT
		{
			arr = obj.default_val.value.split(".");
			num = arr[0].length;
			frac= arr[1].length;
			if(obj.decimal.value == "" || obj.decimal.value == null)//CKS WHETHER DEFALUT FEILD HAS DIGITS AFTER DECIMAL EVEN IF PRESICION IS NOT MENTIONED
			{				
				if(frac > 0)
				{
					var error = getMessage("INVALID_DFLT_VAL","CA");
					obj.default_val.select();
					obj.default_val.focus();
					messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
					return false ;
				}			
			}
			if(num > (parseFloat(obj.len.value)-parseFloat(obj.decimal.value)))//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER DIGITS BEFORE  DECIMAL POINTS
			{
		
				var error = getMessage("INVALID_DFLT_VAL","CA");
				obj.default_val.select();
				obj.default_val.focus();
				messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
				return false ;
			}
			if(frac > parseFloat(obj.decimal.value))//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER DIGITS AFTER THE DECIMAL POINTS
			{
				var error = getMessage("INVALID_DFLT_VAL","CA");
				obj.default_val.select();
				obj.default_val.focus();
				messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
				return false ;
			}
			if(parseFloat(obj.default_val.value.length) >  9 )//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER LENGTH
			{			
					var error = getMessage("INVALID_DFLT_VAL","CA");
					obj.default_val.select();
					obj.default_val.focus();
					messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
					return false ;
			}
		 }
		 else //if no precesion is mentioned
		 {
			 
			if(obj.default_val.value.length > parseFloat(obj.len.value)|| obj.default_val.value.length > 9 )//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER LENGTH
			{
					var error = getMessage("INVALID_DFLT_VAL","CA");
					obj.default_val.select();
					obj.default_val.focus();
					messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
					return false ;
			}
		 }
	}
	return true ;
}


function	chkprec(objARGS) //This function can chk proper digits is entered before and after decimal points
	{
		var  arr		= new Array();
		var  num		= 0;
		var  frac		= 0;  
		var  flag		= true;

		var obj			= f_query_add_mod.document.forms[0] ;

		if((objARGS.value.indexOf(".")) > 0) //ONLY IF THE VALUE ENTERED HAVE DIGITS
			{			
					arr = objARGS.value.split(".");
					num = arr[0].length;
					frac= arr[1].length;

					if(num > (parseFloat(obj.len.value)-parseFloat(obj.decimal.value)))//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER DIGITS BEFORE  DECIMAL POINTS
						flag = false;
					
					if(frac > parseFloat(obj.decimal.value))//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER DIGITS AFTER THE DECIMAL POINTS
						flag = false;
		
						if(!flag)
						{
							var error = getMessage("INVALID_VAL_ENTERED","CA") + " :"+objARGS.name + "Field";//getMessage("INVALID_DFLT_VAL");
							objARGS.select();
							objARGS.focus();
							messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
							return false ;
						}
		
					return true;
		}

			return true;
	
	}


function onSuccess() {

//	f_query_add_mod.location.href = "../../eCA/jsp/TemplateComponentAddModify.jsp?mode=insert" ;
	f_query_add_mod.location.reload();
}
async function callComponent()
{
	
	var action_url='../../eCA/jsp/CAComponentLookUpMain.jsp';
	var retVal	=	"";//= 	new String();
	var dialogHeight= "90vh" ;
	var dialogWidth	= "45vw" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	retVal =await window.showModalDialog("../../eCA/jsp/CAComponentLookUpMain.jsp?calledFrom=PF",arguments,features);
	
	if(retVal!=null)
	{		
		//self.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd","$$$"+retVal[0]+"###");
		//self.RTEditor0.focus();
		//alert(document.forms[0].component);
		//document.forms[0].compDefinition.insertAdjacentText("BeforeEnd"," $$$"+retVal[0]+"###");
		compDefinition.focus();
		compDefinition.document.execCommand("paste",""," $$$"+retVal[0]+"###");
		//document.forms[0].compDefinition.focus();		
	}	
}
function callForPreview(calledFrom)
{
	parent.frameSetId.rows="46%,49%,5%";
	//top.opener.window.paragraphWindowRef.dialogHeight();
	//alert(top.opener.window.paragraphWindowRef.dialogHeight);
	//parent.window.height=290;
	document.compDefinitionForm.calledFrom.value=calledFrom;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
	var txtRange =	compDefinition.document.body.createTextRange();
	document.compDefinitionForm.paragraphDef.value=txtRange.text;
	document.compDefinitionForm.submit();
}
function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}


//Function for TemplateComponent.jsp-start

function callOnUnload()
{

	var n = parent.frames[0].document.getElementById("total_rows").value;
	var retdata = "";

	for(var i=0; i<n ; i++)
	{
		var val1 = eval("parent.frames[0].document.getElementById("order_seq_no")"+i);
		var val2 = eval("parent.frames[0].document.getElementById("list_item_id")"+i);
		var val3 = eval("parent.frames[0].document.getElementById("list_item_text")"+i);
		var val4 = eval("parent.frames[0].document.getElementById("dflt_yn")"+i);
		//var val5 = eval("parent.frames[0].document.getElementById("deleted")"+i);

		var temp	=val1.innerText + 
					"~"+val2.innerText+
					 "~"+val3.innerText+
					 "~"+val4.innerText +"`";//+val5.innerText+"`";
		retdata +=temp;
	}
	parent.window.returnValue = retdata;
	parent.window.close();
}

//Function for TemplateComponent.jsp-end




//Functions for TemplateComponentAddModify.jsp-start

function checkLength(objLength)
{
	setMaxMinLength();
	setDefaultLength();
	if(chkLength(objLength)==false)
	{
		return false;
	}
}
function CheckLastChar(obj)
{
	var codeVal = obj.value;
	if(codeVal!=""){
		if(isNaN(codeVal.charAt(codeVal.length-1)))
		{
			return true;
		}
		else
		{
			alert(getMessage("LAST_CHAR_NOT_NUMBER","CA"));
			obj.focus();
			obj.select();
			return false;
		}
	}

}
function chkMode(obj)
{
	chkModeDefault(obj);
	chkModePrecision(obj);
	chkModeMax(obj);
	chkModeLength(obj);
	chkModeMin(obj);
	chkModeUnit(obj)
	showGif(obj);
	setAcceptOptionReadOnly(obj);
}


/***************************SETS THE MODE OF THE TEXT FEILDS**********************************/

function chkModeDefault(obj) //check Mode of default check box
{	
 
	if( obj.value == "I" || obj.value == "N" || obj.value == "A" || obj.value == "H"	)	
	{
		if(document.TemplateComponent_form.mode.value != "update")
		{
			document.TemplateComponent_form.default_val.value	 = "";
		}
		if(document.TemplateComponent_form.eff_status_value.value =="D")
			document.TemplateComponent_form.default_val.disabled   = true;
		else
			document.TemplateComponent_form.default_val.disabled = false ;
	}
	else
	{
		document.TemplateComponent_form.default_val.value	 = "";
		document.TemplateComponent_form.default_val.checked	 = false; 
		document.TemplateComponent_form.default_val.disabled = true;
	}
}

function chkModePrecision(obj)//SETS Mode of PRECISION box
	{
		if( obj.value == "N" )	
		{
			if(document.TemplateComponent_form.mode.value != "update")
			{
				document.TemplateComponent_form.decimal.value	= "" ;								
			}
			if(document.TemplateComponent_form.eff_status_value.value =="D")
				document.TemplateComponent_form.decimal.disabled   = true;
			else
				document.TemplateComponent_form.decimal.disabled = false ;
		}
		else
		{
			document.TemplateComponent_form.decimal.value	= "" ;								
			document.TemplateComponent_form.decimal.disabled = true ;								

		}
	}


function chkModeMax(obj) //SETS Mode of MAX box
	{
	if( obj.value == "I" || obj.value == "N")	
	 {
		if(document.TemplateComponent_form.mode.value != "update")
			{
			document.TemplateComponent_form.max.value = "" ;
			}
		if(document.TemplateComponent_form.eff_status_value.value =="D")
			document.TemplateComponent_form.max.disabled   = true;
		else
			document.TemplateComponent_form.max.disabled = false
	 }
	else
		{
			document.TemplateComponent_form.max.value = "" ;
			document.TemplateComponent_form.max.disabled = true ;
		}
	}

function chkModeMin(obj) //SETS Mode of MIN box
	{
	if( obj.value == "I" || obj.value == "N")	
		{
			if(document.TemplateComponent_form.mode.value != "update")
			{
			document.TemplateComponent_form.min.value = "" ;
			}
			if(document.TemplateComponent_form.eff_status_value.value =="D")
				document.TemplateComponent_form.min.disabled   = true;
			else
				document.TemplateComponent_form.min.disabled = false
		}
	else
		{
			document.TemplateComponent_form.min.value = "" ;
			document.TemplateComponent_form.min.disabled = true ;
		}
	}
function chkModeUnit(obj) //SETS Mode of Unit box
	{
	if( obj.value == "I" || obj.value == "N" || obj.value == "A")	
		{
			if(document.TemplateComponent_form.mode.value != "update")
			{
			document.TemplateComponent_form.unit.value = "" ;
			}
			if(document.TemplateComponent_form.eff_status_value.value =="D")
				document.TemplateComponent_form.unit.disabled   = true;
			else
				document.TemplateComponent_form.unit.disabled = false
		}
	else
		{
			document.TemplateComponent_form.unit.value = "" ;
			document.TemplateComponent_form.unit.disabled = true ;
		}
	}



function showGif(obj) //SETS Mode of GIF BUTTON box
{
	if(obj !=null)	
	{
		if(obj.value == 'L')
		{
			document.getElementById("alpha_info").value= 'Alpha Info';
			document.getElementById("alpha_info").style.visibility = 'visible'
		}
		else if(obj.value == 'P')
		{
			document.getElementById("alpha_info").value= 'Definition';
			document.getElementById("alpha_info").style.visibility = 'visible'
		}
		else if(obj.value == 'R')
		{
			document.getElementById("alpha_info").value = 'Define Grid';
			document.getElementById("alpha_info").style.visibility = "visible";
		}
		else if(obj.value == 'X')
		{
			document.getElementById("alpha_info").value = 'Define Matrix';			
			document.getElementById("alpha_info").style.visibility = "visible";
		}
		else
		{			
			document.getElementById("alpha_info").style.visibility = 'hidden'
		}
	}
}


function chkModeLength(obj)  //sets mod eof the length field
{
	if( obj.value == "I" || obj.value == "N" || obj.value == "H" || obj.value == "F")
	{
		
		if(obj.value == "I" || obj.value == "N" )	
		document.TemplateComponent_form.len.maxLength		= 1;
		else
		document.TemplateComponent_form.len.maxLength		= 4;

		if(document.TemplateComponent_form.mode.value != "update")
		{
			document.TemplateComponent_form.len.value= "" ;
		}
		if(document.TemplateComponent_form.eff_status_value.value =="D")
			document.TemplateComponent_form.len.disabled   = true;
		else
			document.TemplateComponent_form.len.disabled   = false;
	}
	else
	{
		document.TemplateComponent_form.maxLength			= 4;
		document.TemplateComponent_form.len.value			= "" ;
		document.TemplateComponent_form.len.disabled		= true ;
	}
}
function setAcceptOptionReadOnly(obj)
{
	if(obj.value == "A" || obj.value == "P" || obj.value == "R" || obj.value == "X")
	{
		document.TemplateComponent_form.accept_option.options(3).selected=true;
		document.TemplateComponent_form.accept_option.value='D';
		document.TemplateComponent_form.accept_option.disabled=true;
	}
	else
	{
		if(document.TemplateComponent_form.mode.value != "update")
		{
			document.TemplateComponent_form.accept_option.options(0).selected=true;
			document.TemplateComponent_form.accept_option.disabled=false;
		}
	}
}



function chkLength(obj)
{
	 var componentType  = 	document.TemplateComponent_form.comp_type.value ;

	 var enteredValue   =   parseInt(obj.value);

	if(componentType == "I" || componentType == "N")	
	{
	if(enteredValue > 9)
		{
			obj.select();
			obj.focus();
			var error = getMessage("SINGLE_DIGIT_FOR_NUM","CA");
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
			return false;
		}
	}

	if(componentType == "H" || componentType == "F" )	
	{
	if(enteredValue > 4000 )
		{
			obj.select();
			obj.focus();
			var error = getMessage("OBJ_CANNOT_EXCEED","Common");
			error = error.replace('$',4000);
			
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0"  ;
			return false;
		}
	}
	return true;
}

/***************************SETS MODE FUNCTION ENDS HERE**********************************/

function chkPrecision(obj)	 //T0 check precisioc entered is lesser than length entered
{
	if(obj.value == "" || obj.value == null)
		return ;

	if((document.getElementById("len").value == "")&& obj.value != "")
		{	
			obj.focus();
			obj.select();
			//var error =getMessage("","");
			var error =	"APP-CA0105 Please Enter the Length before entering Precision";
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0"  ;
			return ;
		}

	

	if(parseInt(obj.value) >= parseInt(document.getElementById("len").value))
		{
			obj.focus();
			obj.select();
			var error = getMessage("INVALID_PRECISION","CA");
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0"  ;
			return ;
		}
		parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0"  ;
		return true;
}

function setDefaultLength()//sets length of default text BOx  depending upon the entered length
{
	if(document.getElementById("len").value != "" && document.getElementById("len").value != null && document.getElementById("len").value != 0 )
		{
			if(document.getElementById("comp_type").value == "N" && document.getElementById("decimal").value != "" )
			{
				document.getElementById("default_val").maxLength = (parseFloat(document.getElementById("len").value)  +  1);
			}
			else
			{
				document.getElementById("default_val").maxLength = parseFloat(document.getElementById("len").value);
			}
		}
		else // if length feild is empty than
			{
				if(document.getElementById("comp_type").value == "N" || document.getElementById("comp_type").value == "I")
				{
					var lengthEntered = 9;//DEFAULT LENGTH

					if(document.getElementById("comp_type").value == "N" )
					var lengthEntered = 9;//DEFAULT LENGTH
					
					document.getElementById("default_val").maxLength = parseInt(lengthEntered);
							
				}
				else //if comp_type is long text or sort text
				{
				  if(document.getElementById("comp_type").value == "F" || document.getElementById("comp_type").value == "H")
					{
						var lengthEntered = 60;//DEFAULT LENGTH
						document.getElementById("default_val").maxLength = parseInt(lengthEntered);	
					}
								
				}
				
			}
}//end of fun



function setMaxMinLength()		  //set length of max and min field
{
	 var lengthEntered		=  document.getElementById("len").value ;
	 var precisionEntered	=  document.getElementById("decimal").value ;


	 if((lengthEntered != "") && (precisionEntered != ""))
		{		
			document.getElementById("max").maxLength = parseInt(lengthEntered) + 1;
			document.getElementById("min").maxLength = parseInt(lengthEntered) + 1;
		}
	 else if((lengthEntered != "") && (precisionEntered == ""|| precisionEntered==0))
		{		
			document.getElementById("max").maxLength = parseFloat(lengthEntered);
			document.getElementById("min").maxLength = parseFloat(lengthEntered);
		}
	else
		{
			lengthEntered = 9;//DEFAULT LENGTH
			document.getElementById("max").maxLength = parseInt(lengthEntered);
			document.getElementById("min").maxLength = parseInt(lengthEntered);
		}
	return true;
}

function chkMiinMax()//check the between Min and Max
{
	
	var obj = document.forms[0] ;
	
	var error = getMessage("INVALID_MIN_VAL","CA");
	
	if(obj.min.value != "" && obj.max.value != "")
	{
	   if(parseFloat(obj.min.value) > parseFloat(obj.max.value))
		{
			obj.min.focus();
			obj.min.select();
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			return false ;
		}
	}

	return true ;
}



function setLength(obj,obj1)
{
	var componentType  = 	document.TemplateComponent_form.comp_type.value ;
	if(componentType == "N" || componentType == "I")
	{
		if(!allowValidNumber(obj,obj1,0))
			return false;
	}
	if(componentType == "N")	
	{
		var mode = 2;
		var len = document.getElementById("len").value;
		var dec = document.getElementById("decimal").value;
		if(len == "" || len ==null)
			len = 9 ;
		if(dec == "" || dec ==null)
		{
			dec = 0 ;
			mode= 0;
		}
		allowValidNumber(obj,obj1,(parseFloat(len)-parseFloat(dec)),mode);
	}
}

function checkForValidColumnPosition(obj, index)
{
	var total_cols = 0;
	var matrix_cols = document.templateComponentRowColDefForm.matrix_cols.value;
	for(var i=0;i<matrix_cols;i++)
	{
		var obj = eval("document.templateComponentRowColDefForm.matrixColSpan" + i);
		total_cols += parseInt(obj.value);
	}
	var fluctuation = (matrix_cols - total_cols);	
	if(fluctuation < 0)//the colspan has been increased
	{
		for(var i = (matrix_cols-1) ; i>=0 ; i--)
		{			
			var obj = eval("document.templateComponentRowColDefForm.matrixColSpan" + i);
			if(parseInt(obj.value) != 0 && i != index)
			{
				obj.value = parseInt(obj.value) - 1;
				fluctuation++;
			}
			if(fluctuation == 0)
				break;
		}
	}
	else if(fluctuation > 0)//the colspan has been decreased
	{
		for(var i = 0 ; i<matrix_cols ; i++)
		{
			var obj = eval("document.templateComponentRowColDefForm.matrixColSpan" + i);
			if(i != index)
			{
				obj.value = parseInt(obj.value) + 1;
				fluctuation--;
			}
			if(fluctuation == 0)
				break;
		}
	}	
}

function checkValue(obj, val, prompt)
{
	if(obj.value > val)
	{
		error = ('APP-CA1053 ' + prompt + ' cannot be more than ' + val + '...');
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		obj.select();
		obj.focus();		
		return;
	}	
	else
	{
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;	
	}
	if(prompt == "Matrix Columns")
	{
		var no_of_cols = parseInt(obj.value);
		var colspanHTML = "";
		for(var i=0;i<no_of_cols;i++)
		{
			colspanHTML += "&nbsp;&nbsp;<input type='text' size='1' maxlength='1' onKeyPress='return(ChkNumberInput(this,event,0))' name='matrixColSpan" + i + "' id='matrixColSpan" + i + "' value=\"1\" >";
		}
		document.getElementById("matrix_colSpan_def").style.display = "inline";
		document.getElementById("matrix_colSpan_row_def").innerHTML = colspanHTML;		
	}
}

//Functions for TemplateComponentAddModify.jsp-end



//Functions for TemplateParagraphMaster.jsp-start

function instantiateEditor()
	{
		var html = "";
		html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>";
		html +="<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>";
		html +="<body onKeyDown='lockKey()' style=\"font:10pt arial\">";
		html +="</body>";
		compDefinition.document.open();
		compDefinition.document.write(html);
		compDefinition.document.close();
		compDefinition.document.designMode = "ON";
		
		setTimeout("call();",200);
	}
	function call()
	{
		compDefinition.document.execCommand("formatBlock","","Address");
		var def=callOnLoad();
		compDefinition.document.body.insertAdjacentHTML("afterbegin","<ADDRESS>&nbsp;</ADDRESS>");	
		compDefinition.document.body.focus();
		compDefinition.document.execCommand("paste","",def);
			
	}
	function callOnLoad()
	{//parent.frames[1].document.forms[0].paragraphDef.value;
		var def=top.opener.window.document.TemplateComponent_form.paragraphDef.value;
		return def;
		//document.compDefinitionForm.compDefinition.value=window.dialogArguments;
		//document.compDefinitionForm.compDefinition.focus();

	}
	function callOnChange()
	{
		window.height='145';
		parent.previewFrame.location.href="../../eCommon/html/blank.html";
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		parent.frameSetId.rows="100%,0%,0%";
	}
	function callOnSave()
	{
		//window.returnValue=document.compDefinitionForm.compDefinition.value;
		var txtRange =	compDefinition.document.body.createTextRange();
		top.opener.window.document.TemplateComponent_form.paragraphDef.value=txtRange.text;				
		callForPreview('SAVE');		
		//parent.window.close();
	}


//Functions for TemplateParagraphMaster.jsp-end



//Functions for TemplateComponentAlphaInfoAddModify.jsp-start

function doSelect(val)
	{
		if(val == 'S')
		{
			if(document.getElementById("ORDER_SEQ_NO").value == '' || document.getElementById("LIST_ITEM_ID").value == '' || 				document.getElementById("LIST_ITEM_TEXT").value == '' )
					alert(parent.getMessage('MANDATORY_FIELDS','CA'));
				else if(sortOrderChk() == false)
				{
					alert(parent.getMessage('UNIQUIE_SORT_ORDER','CA'));
					document.getElementById("ORDER_SEQ_NO").select();
					document.getElementById("ORDER_SEQ_NO").focus();
				}
				else if(oneDefaultChk() == false)
				{
					alert(parent.getMessage('ONE_DEFAULT','CA'));
					document.getElementById("default_yn").focus();
				}
				else if(listIDChk() == false)
				{
					alert(parent.getMessage('UNIQ_LIST_ID','CA'));//Message to be added
					document.getElementById("LIST_ITEM_ID").focus();
				}
				else
				{
					var prevconvals = parent.frames[0].document.getElementById("prev_con_vals").value;
					var convals =document.getElementById("ORDER_SEQ_NO").value+"~"+document.getElementById("LIST_ITEM_ID").value+"~"+document.getElementById("LIST_ITEM_TEXT").value+"~"+(document.getElementById("default_yn").checked==true?"Y":"N");

					if(document.getElementById("mode").value == 'insert')
					{
						convals = prevconvals+convals+"`";
						parent.frames[0].location.href = "../../eCA/jsp/TemplateComponentAlphaInfoResult.jsp?from=A&con_vals="+
						escape(convals);
						clearFields();
					}
					else 
					{
						var rownum = document.getElementById("row_num").value;
													
						var obj = eval("parent.frames[0].document.getElementById("order_seq_no")"+rownum);
						obj.innerText= document.getElementById("ORDER_SEQ_NO").value;
				
						obj = eval("parent.frames[0].document.getElementById("list_item_id")"+rownum);
						obj.innerHTML= "<a href='javascript:showDetails(\""+escape(convals)+"\",\""+rownum+"\",\"A\");'>"+document.getElementById("LIST_ITEM_ID").value+"</a>";
											
						obj = eval("parent.frames[0].document.getElementById("list_item_text")"+rownum);
						obj.innerText= document.getElementById("LIST_ITEM_TEXT").value;
				
						obj = eval("parent.frames[0].document.getElementById("dflt_yn")"+rownum);
						obj.innerText= (document.getElementById("default_yn").checked==true?"Y":"N");
						//obj = eval("parent.frames[0].document.getElementById("deleted")"+rownum);
						//obj.innerText= (document.getElementById("delete_yn").checked==true?"Y":"N");
						
						clearFields();
					}
				}
			}//end of select if
			else if(val=='O')
			{
				var n = parent.frames[0].document.getElementById("total_rows").value;
				var retdata = '';
				for(var i=0; i<n ; i++)
				{
					var val1 = eval("parent.frames[0].document.getElementById("order_seq_no")"+i);
					var val2 = eval("parent.frames[0].document.getElementById("list_item_id")"+i);
					var val3 = eval("parent.frames[0].document.getElementById("list_item_text")"+i);
					var val4 = eval("parent.frames[0].document.getElementById("dflt_yn")"+i);
					//var val5 = eval("parent.frames[0].document.getElementById("deleted")"+i);

					var temp	=val1.innerText + 
								"~"+val2.innerText+
								 "~"+val3.innerText+
								 "~"+val4.innerText +"`";//+val5.innerText+"`";


			
					retdata +=temp;
				}

				parent.window.returnValue = retdata;
				parent.window.close();
			}
			else if(val =='CL')
			{
				clearFields();
			}
			else if(val=='D')
			{
				
				var rows = parent.frames[0].document.getElementById("total_rows").value;
				var seqNo = parent.frames[1].document.getElementById("ORDER_SEQ_NO").value;
				if(seqNo == ""){
					return false;
				}

				var check =0;
				for(var n=0;n<rows;n++)
				{
					var obj = eval("parent.frames[0].document.getElementById("order_seq_no")"+n);
					//alert('Loop seqNo:'+obj.innerText);
					if(obj.innerText == seqNo){
						
						break;
					}else{
						check++;
					}
				}
				if(parseInt(check)==parseInt(rows)){
					alert(getMessage("SEL_RECORD_FOR_DELETION","CA"));
					return false;
				}
				var prevconvals = parent.frames[0].document.getElementById("prev_con_vals").value;
				
				parent.frames[0].location.href = "../../eCA/jsp/TemplateComponentAlphaInfoResult.jsp?from=D&con_vals="+
						escape(prevconvals)+"&seqNoDelete="+seqNo;				
				//alert('You Can Delete.');
				clearFields();
			}
			else
			{
				parent.window.close();
			}
		}

		function sortOrderChk() //to check unique value of the sort
		{
	
			var rows = parent.frames[0].document.getElementById("total_rows").value;
			for(var n=0;n<rows;n++)
			{
				var obj = eval("parent.frames[0].document.getElementById("order_seq_no")"+n);
			if(!( document.getElementById("mode").value  != 'insert' &&  document.getElementById("row_num").value == n ) )
				{
				if(document.getElementById("ORDER_SEQ_NO").value == obj.innerText)
					return false;
				}
			}
			return true;
		}


		function listIDChk() //to check unique value of the sort
		{
		
				var rows = parent.frames[0].document.getElementById("total_rows").value;
				for(var n=0;n<rows;n++)
				{
					var obj = eval("parent.frames[0].document.getElementById("list_item_id")"+n);
					if(!( document.getElementById("mode").value  != 'insert' &&  document.getElementById("row_num").value == n )) 
					{
						if(document.getElementById("LIST_ITEM_ID").value == obj.innerText)
						return false;
					}
				}
				return true;
		}
	
		function oneDefaultChk()  //to check  default value is checked only once
		{
			var rows = parent.frames[0].document.getElementById("total_rows").value;
			var counter=0;
			
			for(var n=0;n<rows;n++)
			{
				var obj = eval("parent.frames[0].document.getElementById("dflt_yn")"+n);
				//var objDelete = eval("parent.frames[0].document.getElementById("deleted")"+n);
				var temp = document.getElementById("default_yn").checked==true?"Y":"N" ;
				//var check =document.getElementById("delete_yn").checked==true?"Y":"N";

				if(!( document.getElementById("mode").value  != 'insert' &&  document.getElementById("row_num").value == n) )
				{
					if(temp == 'Y' && obj.innerText == 'Y'){
							return false;
					}
				}
			}
			return true;
		}
		
		function clearFields()
		{
			document.getElementById("ORDER_SEQ_NO").value = '';
			document.getElementById("LIST_ITEM_ID").value = '';
			document.getElementById("LIST_ITEM_TEXT").value = '';
			document.getElementById("default_yn").checked = false;
			//document.getElementById("delete_yn").checked = false;
			document.getElementById("Delete").disabled = true;
			document.getElementById("mode").value = 'insert'
		}

		function allowValidInput()
		{
			//alert(window.event.keyCode);
			if(window.event.keyCode==126) return false;
			if(window.event.keyCode==96) return false;
			if(window.event.keyCode==38) return false;
		}

//Functions for TemplateComponentAlphaInfoAddModify.jsp-end



//Functions for TemplateComponentAlphaInfoResult.jsp-start

function showDetails(vals,rownum,from)
{
	if(from == 'A'){
		
		parent.frames[1].location.href = "../../eCA/jsp/TemplateComponentAlphaInfoAddModify.jsp?con_vals="+escape(vals)+"&row_num="+rownum;
	}
	}
	function defaultCheck(){
	if(oneDefaultChk()==false){
	alert(parent.getMessage('ONE_DEFAULT','CA'));
	return false;
	}
	}
	function oneDefaultChk()  //to check  default value is checked only once
	{
	var rows = parent.frames[0].document.getElementById("total_rows").value;
	for(var n=0;n<rows;n++)
	{
		var obj = eval("parent.frames[0].document.getElementById("dflt_yn")"+n);
		var temp = parent.frames[1].document.getElementById("default_yn").checked==true?"Y":"N" ;


		if(!( parent.frames[1].document.getElementById("mode").value  != 'insert' &&   parent.frames[1].document.getElementById("row_num").value == n) )
		{
			if(obj.innerText == 'Y'){
				return false;
			}
		}
	}
	return true;
	}

//Functions for TemplateComponentAlphaInfoResult.jsp-end

