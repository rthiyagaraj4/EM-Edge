//developed by venkatesh.d on 5th may 2005 
//this function is used to get the correct frame reference
//use  Reference whenever u want to refer the message frame
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name				Rev.Date   		Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------
21/08/2017		IN064882		Krishna Gowtham		21/08/2017		Ramesh G	GHL-SCF-1225
01/11/2017		IN065595		Krishna Gowtham		01/11/2017		Ramesh G	AM-Common-Discrete Measure
29/06/2023	    45713	         Krishna Pranay		03/07/2023   	Ramesh G	ML-MMOH-SCF-2454
08/01/2025	    68801		Gunasekar R	       23/01/2025  	  Twinkle Shah    ML-MMOH-CRF-0579
-------------------------------------------------------------------------------------------------------------------------------
*/
function getMessageFrame()
{
	if(top.content!=null){
		return top.content.messageFrame;
	}else{
		return top.messageframe;
	}
}

var messageFrameReference = getMessageFrame();
function create() 
{
	f_query_add_mod.location.href = "../../eAM/jsp/DiscrMsrCompAddModify.jsp?mode=insert" ;
}

function query() 
{
	f_query_add_mod.location.href ="../../eAM/jsp/DiscrMsrCompQueryCriteria.jsp?mode=update";
}

function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }
function apply()
{
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	if(!chkMinMax())
		return false;

	var	comp_length = f_query_add_mod.document.TemplateComponent_form.len;

	if(f_query_add_mod.checkLength(comp_length)==false)
		return false;

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fieldsforspchar = new Array( f_query_add_mod.document.TemplateComponent_form.comp_id);
	var namesforspchar = new Array( getLabel("Common.ComponentID.label","Common") );
	
	if(f_query_add_mod.document.TemplateComponent_form.link_yn.checked==true)
	{
		fields = new Array (f_query_add_mod.document.TemplateComponent_form.comp_id,
							f_query_add_mod.document.TemplateComponent_form.long_desc,
							f_query_add_mod.document.TemplateComponent_form.short_desc,
							f_query_add_mod.document.TemplateComponent_form.comp_type,
							f_query_add_mod.document.TemplateComponent_form.service,
                            f_query_add_mod.document.TemplateComponent_form.histype2,
                            f_query_add_mod.document.TemplateComponent_form.std_ref
						);
		names = new Array (	 getLabel("Common.identification.label","Common"),
							 getLabel("Common.longdescription.label","Common"),
							 getLabel("Common.shortdescription.label","Common"),
							 getLabel("Common.ComponentType.label","Common"),
							 getLabel("Common.service.label","Common"),
                             getLabel("Common.HistoryType.label","Common"),
		                     getLabel("eAM.StandardValueReference.label","AM")
							);
	}
	else
	{
		fields = new Array (f_query_add_mod.document.TemplateComponent_form.comp_id,
							f_query_add_mod.document.TemplateComponent_form.long_desc,
							f_query_add_mod.document.TemplateComponent_form.short_desc,
							f_query_add_mod.document.TemplateComponent_form.comp_type,
							f_query_add_mod.document.TemplateComponent_form.service,
                            f_query_add_mod.document.TemplateComponent_form.histype2
                            
						);
		names = new Array (	getLabel("Common.identification.label","Common"),
							 getLabel("Common.longdescription.label","Common"),
							 getLabel("Common.shortdescription.label","Common"),
							 getLabel("Common.ComponentType.label","Common"),
							 getLabel("Common.service.label","Common"),
                             getLabel("Common.HistoryType.label","Common")
		                   
							);
	} 

	
if(f_query_add_mod.document.TemplateComponent_form.link_yn)
	if(f_query_add_mod.document.TemplateComponent_form.link_yn.checked==true)
			 f_query_add_mod.document.TemplateComponent_form.link_yn.value="Y";

	if(f_query_add_mod.SpecialCharCheck(fieldsforspchar,namesforspchar,messageFrame,"M", error_page))
	{
		if(checkFieldsofMst( fields, names, messageFrame))
		{
			var type = f_query_add_mod.document.TemplateComponent_form.comp_type.value;
		//	var option = f_query_add_mod.document.TemplateComponent_form.accept_option.value;
			if(type=="P")
			{
				fields = new Array (f_query_add_mod.document.TemplateComponent_form.paragraphDef);
				names = new Array (	getLabel("Common.ParagraphDefinition.label","Common") );
				if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				{
					f_query_add_mod.document.TemplateComponent_form.confidential.disabled = false;
					f_query_add_mod.document.TemplateComponent_form.submit();
				}
			}
			else if(type=="L" )
			{
				
				fields = new Array (f_query_add_mod.document.TemplateComponent_form.alpha_info_values);
	             f_query_add_mod.document.TemplateComponent_form.alpha_info_values.value=encodeURIComponent(f_query_add_mod.document.TemplateComponent_form.alpha_info_values.value);
				
				names = new Array (	getLabel("Common.AlphaInfo.label","Common") );
				
				if(f_query_add_mod.document.TemplateComponent_form.link_yn.checked==true)
				{	
					f_query_add_mod.document.TemplateComponent_form.confidential.disabled = false;
					f_query_add_mod.document.TemplateComponent_form.submit();
				
				}
				else
				{	
					if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
					{
						f_query_add_mod.document.TemplateComponent_form.confidential.disabled = false;
						f_query_add_mod.document.TemplateComponent_form.submit();
					}
				
				}
				
			}
			else if(type=="I" || type=='N')
			{
				//checking the valid default value added in case of Decimal or numeric fields
				if(validateNumber(f_query_add_mod.document.TemplateComponent_form.default_val,"Apply"))
				{		
                    f_query_add_mod.document.TemplateComponent_form.discr_typeInd.disabled = false;
					f_query_add_mod.document.TemplateComponent_form.confidential.disabled = false;
					
					//if(type=='N') {
						var r_low=f_query_add_mod.document.TemplateComponent_form.ref_low.value;
						var r_high=f_query_add_mod.document.TemplateComponent_form.ref_high.value;
						var c_low=f_query_add_mod.document.TemplateComponent_form.critical_low.value;
						var c_high=f_query_add_mod.document.TemplateComponent_form.critical_high.value;
						var err=false;

						if(r_low=='' && c_low!=''){
							alert('APP-000005 Reference Low not specified');
							f_query_add_mod.document.TemplateComponent_form.ref_low.focus();
							err=true;
						}
						if(! err &&(r_high=='' && c_high!='')){
							alert('APP-000005 Reference High not specified');
							f_query_add_mod.document.TemplateComponent_form.ref_high.focus()
							err=true;
						}

						if(! err &&(parseInt(r_low) > parseInt(r_high))){
							alert(getMessage('REF_LOW_NOT_GREATER_HIGH','AM'));
							f_query_add_mod.document.TemplateComponent_form.ref_low.focus();
							err=true;
						}

						if(! err &&(parseInt(c_low) > parseInt(c_high))){
							alert(getMessage('CRITICAL_LOW_NOT_GREATER_HIGH','AM'));
							f_query_add_mod.document.TemplateComponent_form.critical_low.focus()
							err=true;
						}
						
						if(! err){
							f_query_add_mod.document.TemplateComponent_form.submit();
						}else{
							messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';

							return false;
						}
					//}else{
						//f_query_add_mod.document.TemplateComponent_form.submit();
					//}
				}
			}
			else
			{
				f_query_add_mod.document.TemplateComponent_form.confidential.disabled = false;
                var type = f_query_add_mod.document.TemplateComponent_form.comp_type.value;
				if(type=='X') 
                {
					fields = new Array (f_query_add_mod.document.TemplateComponent_form.matrixComponentDefinition);
				    names = new Array (	getLabel("eAM.DefineMatrix.label","AM") );				   
					if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
				   { 		
                       f_query_add_mod.document.TemplateComponent_form.submit();
                    }
				 }
                 else if(type=='R') 
                 {
					  fields = new Array (f_query_add_mod.document.TemplateComponent_form.gridComponentDefinition);
				      names = new Array (	getLabel("eAM.DefineGrid.label","AM") );				   
				      if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
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
	}


function onSuccess() 
{
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
			f_query_add_mod.document.getElementById('alpha_info').style.visibility = 'hidden';
	}

	else 
		f_query_add_mod.document.query_form.reset() ;
}*/

function reset()
{
	
	if(f_query_add_mod.document.forms[0].mode)
	{
	if(f_query_add_mod.document.forms[0].mode.value != "update")
	{
		
			if(f_query_add_mod.document.forms[0]!=null)
			{
				if(f_query_add_mod.document.forms[0].mode != null)
					{
						
						if(f_query_add_mod.document.forms[0].mode.value=="insert" )
						{
						
							f_query_add_mod.location.href='../../eAM/jsp/DiscrMsrCompAddModify.jsp?mode=insert';
						}
						
					}
				else
					f_query_add_mod.location.href='../../eAM/jsp/DiscrMsrCompAddModify.jsp?mode=insert';
		   }
		  
	}else 
						{
						//	f_query_add_mod.document.forms[0].reset();
							f_query_add_mod.document.location.reload();
						}
	}else
	{
				//f_query_add_mod.document.query_form.reset() ;
				f_query_add_mod.document.location.reload();

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
						var error = getMessage('INVALID_DFLT_VAL','AM');
						obj.value="";
						//obj.select();
						obj.focus();
						messageRef.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;
						return false;
					}
					else if(minlen!=0 && parseFloat(obj.value) < parseFloat(minlen))
					{
						var error = getMessage('INVALID_DFLT_VAL','AM');
						//obj.select();
						obj.value="";
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
						var error = getMessage('INVALID_PRECISION',"AM");
						//obj.select();
						obj.value="";
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
	var status = '';
	
	if(obj.value=='Alpha Info')
	{
		
		var compid = self.document.forms[0].comp_id.value
       if(document.forms[0].ass_score_yn.checked == true) 
		{
			document.forms[0].ass_score_yn.value='Y';
			status=document.forms[0].ass_score_yn.value;
		}
		else
		{
			document.forms[0].ass_score_yn.value='N';
			status=document.forms[0].ass_score_yn.value;
		}
		
		var dialogHeight ='700px' ;
		var dialogWidth = '900px' ;
		var dialogTop	= '315';
		var dialogLeft = '157' ;

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var arguments = "";
		var convals = parent.frames[1].document.forms[0].alpha_info_values.value;
		
		while(convals.indexOf("+")!=-1)
		{
			convals= convals.replace("+","!");
		}
	
		var mode  = 'frommodal';
		if(convals == '')
			mode  = 'frommodal';
		else
			mode  = '';

		var qry="../../eAM/jsp/DiscrMsrCompListMain.jsp?from=A&discr_measure="+compid+"&mode="+mode+"&status="+status+"&con_vals="+encodeURIComponent(convals);

		var retVals = await window.showModalDialog(qry,arguments,features);
		//var retVals = window.showModalDialog('../../eAM/jsp/DiscrMeasureModalFrames.jsp?from=N&discr_measure='+discrmeasure+'&con_vals='+convals+'&max_min_dec='+maxmindec,arguments,features);

		if(retVals !=null)
			parent.frames[1].document.forms[0].alpha_info_values.value=retVals;
	}
	else if(obj.value=='Definition')
{
    var compid = document.getElementById('comp_id').value;
    var dialogHeight ='475px' ;
    var dialogWidth = '775px' ;
    var dialogTop	= '220';
    var dialogLeft = '157' ; 

    var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
    
    var action_url = "../../eAM/jsp/DiscrMsrCompParagraphMain.jsp?comp_id="+compid;

		//var retVals = window.showModalDialog("../../eCA/jsp/TemplateParagraphMain.jsp?comp_id="+compid,arguments,features);
		//var clipBoardVal=obj.createTextRange();
		//clipBoardVal.select();
		//clipBoardVal.execCommand("copy","","");
		var range = document.createRange(obj);
	        //range.selectNode(obj);;
	        const clipBoardVal = range.extractContents();
			document.execCommand("copy");
    //alert(document.getElementById('eff_status'));
    paragraphWindowRef = await window.open(action_url, null, "height=320,width=630,top=220,left=150,status=NO,toolbar=no,menubar=no,location=no");
    document.getElementById('eff_status').focus();
    //if(retVals !=null)
    //parent.frames[1].document.forms[0].paragraphDef.value=retVals;
}

	else if(obj.value == 'Define Grid')
	{	
		var gridID = document.getElementById('comp_id').value;
		var griddesc = self.document.forms[0].short_desc.value;
		var grid_max_columns_allowed = self.document.forms[0].grid_max_columns_allowed.value;
		if(gridID == "" || griddesc == "")
		{
			//alert('APP-AM1058 Please input Grid ID and Short Description before defining... ');
			alert(getMessage("AM0102","AM"));
			return;
		}
		var short_desc = escape(self.document.forms[0].short_desc.value);
		var gridComponentDefinition = document.TemplateComponent_form.gridComponentDefinition.value;
		var dialogHeight ='700px' ;
		var dialogWidth = '900px' ;
		var dialogTop	= '98';
		var dialogLeft = '157' ; 
		//alert("gridID "+gridID+"gridComponentDefinition "+gridComponentDefinition+"short_desc "+short_desc+"grid_max_columns_allowed "+grid_max_columns_allowed);
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var action_url = "../../eAM/jsp/DiscrMsrCompGridMain.jsp?gridID="+gridID + "&gridComponentDefinition=" + escape(gridComponentDefinition) + "&grid_desc=" + short_desc + "&grid_max_columns_allowed=" + grid_max_columns_allowed;
		
		var retVal_grid = await window.showModalDialog(action_url, arguments, features);		
		//window.open(action_url,null,"height=450,width=790,top=120,left=0,status=NO,toolbar=no,menubar=no,location=no");		
		
		if(retVal_grid != null )
			if(retVal_grid != "")
				document.TemplateComponent_form.gridComponentDefinition.value = retVal_grid;
	}
	else if(obj.value == "Define Matrix")
	{ 
		var mode=document.TemplateComponent_form.mode.value;
	
	    var matrixID = self.document.TemplateComponent_form.comp_id.value;
		var matrixdesc = self.document.TemplateComponent_form.short_desc.value;
		var matrix_max_columns_allowed = self.document.TemplateComponent_form.matrix_max_columns_allowed.value;
		var matrixComponentDefinition = self.document.TemplateComponent_form.matrixComponentDefinition.value;

		if(matrixID == "" || matrixdesc == "")
		{
			alert(getMessage("AM0103","AM"));
			return;
		}
		var total_colSpan = 0;		
		if(total_colSpan > 5)
		{
			alert(getMessage("AM0104","AM"));
			return;
		}
		var dialogHeight ='95vh' ;
		var dialogWidth = '75vw' ;
		var dialogLeft = '0px';
        var dialogTop  = '0px';
		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var action_url = "../../eAM/jsp/DiscrMsrCompMatrixMain.jsp?mode=" + mode + "&matrixID=" + matrixID + "&matrixDesc=" + escape(matrixdesc) + "&matrix_max_columns_allowed=" + matrix_max_columns_allowed ;// + "&matrixComponentDefinition=" + matrixComponentDefinition;
		var retVal_matrix = await window.showModalDialog(action_url, "", features);
		//window.open(action_url,null,"height=430,width=790,top=100,left=0,status=NO,toolbar=no,menubar=no,location=no");
		if(retVal_matrix != null)
			self.document.TemplateComponent_form.matrixComponentDefinition.value = retVal_matrix;
	}
}
function chkMinMax() //Check between min and max
{
	var obj = f_query_add_mod.document.forms[0] ;
	var error = getMessage("INVALID_MIN_VAL","AM");
	
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
	var error = getMessage("DEFAULT_VAL_LEN","AM");
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
						var error = getMessage("MAXIMUM_DIGITS","AM") + " :"  + obj.len.value;//"INVALID_MAX_LENGTH";//TO BE ADDDED
						obj.max.select();
						obj.max.focus();
						messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
						return false ;
			}

			if(obj.min.value.length > parseFloat(obj.len.value)) //CKS WHETHER THE LEN OF min LENGTH FEILD IS WITH ID\N THE THE ALLOWABLE LENGTH
			{
						var error = getMessage("MAXIMUM_DIGITS","AM") + " :"  + obj.len.value;//TO BE ADDED
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
						var error = getMessage("MAXIMUM_DIGITS","AM") + " :"  + obj.len.value;
						obj.max.select();
						obj.max.focus();
						messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
						return false ;
			}
			if(obj.min.value.length > parseFloat(obj.len.value) && (obj.decimal.value == "" || obj.decimal.value == null)) //CKS WHETHER THE LEN OF min LENGTH FEILD IS WITH ID\N THE THE ALLOWABLE LENGTH
			{
						var error = getMessage("MAXIMUM_DIGITS","AM") + " :"  + obj.len.value;//TO BE ADDED
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
					var error =getMessage("INVALID_PRECISION","AM");
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
					var error = getMessage("INVALID_DFLT_VAL","AM");
					obj.default_val.select();
					obj.default_val.focus();
					messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
					return false ;
				}			
			}
			if(num > (parseFloat(obj.len.value)-parseFloat(obj.decimal.value)))//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER DIGITS BEFORE  DECIMAL POINTS
			{
		
				var error = getMessage("INVALID_DFLT_VAL","AM");
				obj.default_val.select();
				obj.default_val.focus();
				messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
				return false ;
			}
			if(frac > parseFloat(obj.decimal.value))//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER DIGITS AFTER THE DECIMAL POINTS
			{
				var error = getMessage("INVALID_DFLT_VAL","AM");
				obj.default_val.select();
				obj.default_val.focus();
				messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
				return false ;
			}
			if(parseFloat(obj.default_val.value.length) >  9 )//CKS WHETHER THE LEN OF DEFAULT  FEILD IS HAVING PROPER LENGTH
			{			
					var error = getMessage("INVALID_DFLT_VAL","AM");
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
					var error = getMessage("INVALID_DFLT_VAL","AM");
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
							var error = getMessage("INVALID_VAL_ENTERED","AM") + " :"+objARGS.name + "Field";//getMessage("INVALID_DFLT_VAL");
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
	
	//var action_url='../../eCA/jsp/CAComponentLookUpMain.jsp';
	var retVal	=	"";//= 	new String();
	var dialogHeight= "400px" ;
	var dialogWidth	= "700px" ;
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";status=no;scroll=auto"; 
	retVal = await window.showModalDialog("../../eAM/jsp/DiscrMsrCompLookupMain.jsp?calledFrom=PF",arguments,features);
	if(retVal!=null)
	{   		
		//self.RTEditor0.document.body.insertAdjacentHTML("BeforeEnd","$$$"+retVal[0]+"###");
		//self.RTEditor0.focus();
		//alert(document.forms[0].component);
		//document.forms[0].compDefinition.insertAdjacentText("BeforeEnd"," $$$"+retVal[0]+"###");
		
		compDefinition.document.execCommand("insertText", false, " $$$"+retVal[0]+"###");		
		/*		
		compDefinition.focus();
		compDefinition.document.execCommand("paste",""," $$$"+retVal[0]+"###");		
		*/
		compDefinition.focus();
	}	

}
function callForPreview(calledFrom)
{
	//parent.frameSetId.rows="46%,49%,5%";
	parent.document.getElementById("templateParagraphMasterFrame").style.height="70vh";
	parent.document.getElementById("previewFrame").style.height="100px";
	parent.document.getElementById("messageFrame").style.height="30px";
	//top.opener.window.paragraphWindowRef.dialogHeight();
	//alert(top.opener.window.paragraphWindowRef.dialogHeight);
	//parent.window.height=290;
	document.compDefinitionForm.calledFrom.value=calledFrom;
	parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";	
	
	var contentDoc = document.getElementById('compDefinition').contentWindow.document.body.innerText;	
	document.compDefinitionForm.paragraphDef.value=contentDoc;
	
	//var txtRange =	compDefinition.document.createRange();	
	//document.compDefinitionForm.paragraphDef.value=txtRange.text;
	
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

	var n = parent.frames[0].document.getElementById('total_rows').value;
	var retdata = "";

	for(var i=0; i<n ; i++)
	{
		var val1 = eval(parent.frames[0].document.getElementById('order_seq_no'+i));
		var val2 = eval(parent.frames[0].document.getElementById('list_item_id'+i));
		var val3 = eval(parent.frames[0].document.getElementById('list_item_text'+i));
		var val4 = eval(parent.frames[0].document.getElementById('dflt_yn'+i));
		//var val5 = eval(parent.frames[0].document.getElementById('deleted'+i));

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
		
		if(!isNaN(codeVal.charAt(codeVal.length-1)))
			
		{
			//alert("APP-AM0150-Last character cannot be a Numeric");
			alert(getMessage("AM0105","AM"));
			obj.value="";
			obj.focus();
			//obj.select();
			return false;
		}
		else if(!isNaN(codeVal.charAt(0)) )
         {
			//alert("APP-AM0150-First character cannot be a Numeric");
			alert(getMessage("AM0106","AM"));
			obj.value="";
			obj.focus();
			//obj.select();
			return false;
		}
		else
		{
			return true;
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
	chkCharLimit(obj); //68801
	//setAcceptOptionReadOnly(obj);
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
		if(obj.value == 'L' || obj.value == 'M')
		{
			document.getElementById('alpha_info').value= 'Alpha Info';
			document.getElementById('alpha_info').style.visibility = 'visible'
		}
		else if(obj.value == 'P')
		{
			document.getElementById('alpha_info').value= 'Definition';
			document.getElementById('alpha_info').style.visibility = 'visible'
		}
		else if(obj.value == 'R')
		{
			document.getElementById('alpha_info').value = 'Define Grid';
			document.getElementById('alpha_info').style.visibility = "visible";
		}
		else if(obj.value == 'X')
		{
			document.getElementById('alpha_info').value = 'Define Matrix';			
			document.getElementById('alpha_info').style.visibility = "visible";
		}
		else
		{			
			document.getElementById('alpha_info').style.visibility = 'hidden'
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
			var error = getMessage("SINGLE_DIGIT_FOR_NUM","AM");
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
			var error = getMessage("LENGTH_CANNOT_4000","AM");
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

	if((document.getElementById('len').value == "")&& obj.value != "")
		{	
			obj.focus();
			obj.select();
			//var error =	"APP-CA0105 Please Enter the Length before entering Precision";
			var error = getMessage("AM0153","Common");
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0"  ;
			return ;
		}

	

	if(parseInt(obj.value) >= parseInt(document.getElementById('len').value))
		{
			obj.focus();
			obj.select();
			var error = getMessage("INVALID_PRECISION","AM");
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0"  ;
			return ;
		}
		parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0"  ;
		return true;
}

function setDefaultLength()//sets length of default text BOx  depending upon the entered length
{
	if(document.getElementById('len').value != "" && document.getElementById('len').value != null && document.getElementById('len').value != 0 )
		{
			if(document.getElementById('comp_type').value == "N" && document.getElementById('decimal').value != "" )
			{
				document.getElementById('default_val').maxLength = (parseFloat(document.getElementById('len').value)  +  1);
			}
			else
			{
				document.getElementById('default_val').maxLength = parseFloat(document.getElementById('len').value);
			}
		}
		else // if length feild is empty than
			{
				if(document.getElementById('comp_type').value == "N" || document.getElementById('comp_type').value == "I")
				{
					var lengthEntered = 9;//DEFAULT LENGTH

					if(document.getElementById('comp_type').value == "N" )
					var lengthEntered = 9;//DEFAULT LENGTH
					
					//document.getElementById('default_val').maxLength = parseInt(lengthEntered);
					var defaultVal = document.getElementById('default_val');
if (defaultVal && !isNaN(parseInt(lengthEntered))) {
    defaultVal.maxLength = parseInt(lengthEntered);
}
					

							
				}
				else //if comp_type is long text or sort text
				{
				  if(document.getElementById('comp_type').value == "F" || document.getElementById('comp_type').value == "H")
					{
						var lengthEntered = 60;//DEFAULT LENGTH
						//document.getElementById('default_val').maxLength = parseInt(lengthEntered);
						var defaultVal = document.getElementById('default_val');
if (defaultVal && !isNaN(parseInt(lengthEntered))) {
    defaultVal.maxLength = parseInt(lengthEntered);
}

					}
								
				}
				
			}
}//end of fun



function setMaxMinLength()		  //set length of max and min field
{
	 var lengthEntered		=  document.getElementById('len').value ;
	 var precisionEntered	=  document.getElementById('decimal').value ;


	 if((lengthEntered != "") && (precisionEntered != ""))
		{		
			document.getElementById('max').maxLength = parseInt(lengthEntered) + 1;
			document.getElementById('min').maxLength = parseInt(lengthEntered) + 1;
		}
	 else if((lengthEntered != "") && (precisionEntered == ""|| precisionEntered==0))
		{		
			document.getElementById('max').maxLength = parseFloat(lengthEntered);
			document.getElementById('min').maxLength = parseFloat(lengthEntered);
		}
	else
		{
			lengthEntered = 9;//DEFAULT LENGTH
			document.getElementById('max').maxLength = parseInt(lengthEntered);
			document.getElementById('min').maxLength = parseInt(lengthEntered);
		}
	return true;
}

function chkMiinMax()//check the between Min and Max
{
	
	var obj = document.forms[0] ;
	//var error = 'APP-AM143 Minimum value should be less than maximum value'
	var error = getMessage("INVALID_MIN_VAL","AM");
	//alert(obj.min.value);
    //alert(obj.max.value);
	if(obj.min.value != "" && obj.max.value != "")
	{
	   if(parseFloat(obj.min.value) > parseFloat(obj.max.value)) 
		{
			obj.min.focus();
			obj.min.select();
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			return false ;
		}
		if(parseFloat(obj.min.value) == parseFloat(obj.max.value))
		{
			error = getMessage("AM0173","AM");
			error = error.replace('$',getLabel('eAM.MinValue.label','AM')); 
			error = error.replace('#',getLabel('Common.MaxValue.label','Common')); 
			//alert(error);
		   // obj.max.focus();
			//obj.max.select();
			obj.max.value='';
			obj.max.focus();
			obj.max.select();
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
		var len = document.getElementById('len').value;
		var dec = document.getElementById('decimal').value;
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
	if(obj.value==0 || obj.value=="")
	{		
		error = getMessage("AM0170","AM");
		error = error.replace("$",prompt);
		//error = error.replace("#",val);
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		obj.value="";
		//obj.select();
		obj.focus();		
		return;
	}		
	else if(obj.value > val)
	{
		//error = ('APP-CA1053 ' + prompt + ' cannot be more than ' + val + '...');
		error = getMessage("AM0168","AM");
		error = error.replace("$",prompt);
		error = error.replace("#",val);
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		obj.value="";
		//obj.select();
		obj.focus();		
		return;
	}	
	else
	{				
		document.templateComponentRowColDefForm.matrix_rows.disabled=false;
		document.templateComponentRowColDefForm.matrix_rows.focus();
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;	
	}

	if(prompt == "Matrix Columns")
	{
		var no_of_cols = parseInt(obj.value);
		var colspanHTML = "";
		var length=1;
		if(no_of_cols==1)
  		   length=2;
		else
			length=1;

		for(var i=0;i<no_of_cols;i++)
		{			
			colspanHTML += "<input type='text' size='1' maxlength="+length+" onKeyPress='return(ChkNumberInput(this,event,0))' onblur='CheckZero(this)' name='matrixColSpan" + i + "' id='matrixColSpan" + i + "' value=\"1\" >&nbsp;&nbsp;";
		}
		document.getElementById("matrix_colSpan_def").style="display";
		document.getElementById("matrix_colSpan_row_def").innerHTML = colspanHTML;		
	}
	
}


function checkValRow(obj1)
{
	if(document.templateComponentRowColDefForm.matrix_cols.value!='')
	{
	if(obj1.value==0 || obj1.value==' ')
	{		
		error = getMessage("AM0170","AM");
		error = error.replace("$",'Matrix Rows');
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
		obj1.value="";
		obj1.select();
		obj1.focus();		
		return;
	}
	else
	{
		parent.messageframe.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;	
	}
	}
	
}

//Functions for TemplateComponentAddModify.jsp-end



//Functions for TemplateParagraphMaster.jsp-start

	function instantiateEditor()
	{
		var html = "";
		html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>";
		html +="<body onKeyDown = 'lockKey()' style=\"font:10pt arial\">";
		html +="</body>";
		//compDefinition.document.open();
		//compDefinition.document.write(html);
		//compDefinition.document.close();
		compDefinition.document.open();
		//compDefinition.document.documentElement.innerHTML = html;
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
		//compDefinition.document.execCommand("paste","",def);
		
		compDefinition.document.execCommand("insertText", false, def);	
		
	}
	function callOnLoad()
	{//parent.frames[1].document.forms[0].paragraphDef.value;
		var def=decodeURIComponent(top.opener.window.document.TemplateComponent_form.paragraphDef.value);
		return def;
		//document.compDefinitionForm.compDefinition.value=window.dialogArguments;
		//document.compDefinitionForm.compDefinition.focus();

	}
	function callOnChange()
	{
		window.height='145';
		parent.previewFrame.location.href="../../eCommon/html/blank.html";
		parent.messageFrame.location.href="../../eCommon/jsp/error.jsp";
		parent.document.getElementById("templateParagraphMasterFrame").style.height="30px";
		parent.document.getElementById("previewFrame").style.height="100px";
		parent.document.getElementById("messageFrame").style.height="30px";
		//parent.frameSetId.rows="100%,0%,0%";
	}
	
	/*
	function callOnSave()
	{
		var txtRange =	compDefinition.document.body.createTextRange();
		
	    top.opener.window.document.TemplateComponent_form.paragraphDef.value=txtRange.text;	//45713
		callForPreview('SAVE');		
	}
	*/
	
	function callOnSave()
	{
		var contentDoc = document.getElementById('compDefinition').contentWindow.document.body.innerText;		
		//top.opener.window.document.TemplateComponent_form.paragraphDef.value=contentDoc;	//45713	
		top.opener.window.document.TemplateComponent_form.paragraphDef.value=contentDoc;
		callForPreview('SAVE');	
		parent.window.close();
		
	}





//Functions for TemplateParagraphMaster.jsp-end



//Functions for TemplateComponentAlphaInfoAddModify.jsp-start

function doSelect(val)
	{

		if(val == 'S')
		{
			
			if(document.getElementById('ORDER_SEQ_NO').value == '' || document.getElementById('LIST_ITEM_ID').value == '' || 				document.getElementById('LIST_ITEM_TEXT').value == '' )
					//alert('APP-AM0115 All fields other than Default are mandatory');
			        alert(getMessage("MANDATORY_FIELDS","AM"));
				else if(sortOrderChk() == false)
				{
					//alert('APP-AM0119 Sort Order Must be unique');
					alert(getMessage("UNIQUIE_SORT_ORDER","AM"));
					document.getElementById('ORDER_SEQ_NO').select();
					document.getElementById('ORDER_SEQ_NO').focus();
				}
				else if(oneDefaultChk() == false)
				{
					//alert('APP-AM0120 Only one default value is allowed');
					alert(getMessage("ONE_DEFAULT","AM"));
					document.getElementById('default_yn').focus();
				}
				else if(listIDChk() == false)
				{
					//alert('APP-AM0145 List ID should be unique');
					alert(getMessage("AM0107","AM"));
					document.getElementById('LIST_ITEM_ID').focus();
				}
				else
				{
					
					var prevconvals = parent.frames[0].document.getElementById('prev_con_vals').value;
					var convals =document.getElementById('ORDER_SEQ_NO').value+"~"+document.getElementById('LIST_ITEM_ID').value+"~"+document.getElementById('LIST_ITEM_TEXT').value+"~"+(document.getElementById('default_yn').checked==true?"Y":"N");

					if(document.getElementById('mode').value == 'insert')
					{
						
						convals = prevconvals+convals+"`";
						parent.frames[0].location.href = "../../eAM/jsp/DiscrMsrCompListResult.jsp?from=A&con_vals="+
						escape(convals);
						clearFields();
					}
					else 
					{
						
						var rownum = document.getElementById("row_num").value;
													
						var obj = eval(parent.frames[0].document.getElementById("order_seq_no"+rownum));
						obj.innerText= document.getElementById("ORDER_SEQ_NO").value;
				
						obj = eval(parent.frames[0].document.getElementById("list_item_id"+rownum));
						obj.innerHTML= "<a href='javascript:showDetails(\""+escape(convals)+"\",\""+rownum+"\",\"A\");'>"+document.getElementById("LIST_ITEM_ID").value+"</a>";
											
						obj = eval(parent.frames[0].document.getElementById("list_item_text"+rownum));
						obj.innerText= document.getElementById("LIST_ITEM_TEXT").value;
				
						obj = eval(parent.frames[0].document.getElementById("dflt_yn"+rownum));
						obj.innerText= (document.getElementById("default_yn").checked==true?"Y":"N");
						//obj = eval("parent.frames[0].document.getElementById("deleted")"+rownum);
						//obj.innerText= (document.getElementById("delete_yn").checked==true?"Y":"N");
						
						clearFields();
					}
				}
			}//end of select if
			else if(val=='O')
			{

				var n = parent.frames[0].document.getElementById('total_rows').value;
				var retdata = '';
				for(var i=0; i<n ; i++)
				{
					var val1 = eval(parent.frames[0].document.getElementById("order_seq_no"+i));
					var val2 = eval(parent.frames[0].document.getElementById("list_item_id"+i));
					var val3 = eval(parent.frames[0].document.getElementById("list_item_text"+i));
					var val4 = eval(parent.frames[0].document.getElementById("dflt_yn"+i));
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
				
				var rows = parent.frames[0].document.getElementById('total_rows').value;
				var seqNo = parent.frames[1].document.getElementById('ORDER_SEQ_NO').value;
				if(seqNo == ""){
					return false;
				}

				var check =0;
				for(var n=0;n<rows;n++)
				{
					var obj = eval(parent.frames[0].document.getElementById("order_seq_no"+n));

					if(obj.innerText == seqNo){

						break;
					}else{
						check++;
					}
				}
				if(parseInt(check)==parseInt(rows)){
					//alert('APP-AM0050 Please select the record to delete.');
					alert(getMessage("AM0108","AM"));
					return false;
				}
				var prevconvals = parent.frames[0].document.getElementById('prev_con_vals').value;
				//alert(prevconvals);
				parent.frames[0].location.href = "../../eAM/jsp/DiscrMsrCompListResult.jsp?from=D&con_vals="+
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
	
			var rows = parent.frames[0].document.getElementById('total_rows').value;
			for(var n=0;n<rows;n++)
			{
				var obj = eval(parent.frames[0].document.getElementById("order_seq_no"+n));
			if(!( document.getElementById("mode").value  != 'insert' &&  document.getElementById("row_num").value == n ) )
				{
				if(document.getElementById('ORDER_SEQ_NO').value == obj.innerText)
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
					var obj = eval(parent.frames[0].document.getElementById("list_item_id"+n));
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
				var obj = eval(parent.frames[0].document.getElementById("dflt_yn"+n));
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
			document.getElementById("ORDER_SEQ_NO").value = "";
			document.getElementById("LIST_ITEM_ID").value = "";
			document.getElementById("LIST_ITEM_TEXT").value = "";
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
		
		parent.frames[1].location.href = "../../eAM/jsp/DiscrMsrCompListAddModify.jsp?con_vals="+escape(vals)+"&row_num="+rownum;
	}
	}
	function defaultCheck(){
	if(oneDefaultChk()==false){
	//alert('APP-AM0120 Only one default value is allowed');
	alert(getMessage('ONE_DEFAULT','AM'));
	return false;
	}
	}
	function oneDefaultChk()  //to check  default value is checked only once
	{
	var rows = parent.frames[0].document.getElementById("total_rows").value;
	for(var n=0;n<rows;n++)
	{
		var obj = eval(parent.frames[0].document.getElementById("dflt_yn"+n));
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

function mand1()
{
  if(document.forms[0].link_yn.value='Y')
	
	parent.frames[1].document.forms[0].std_ref.disabled    = false
	
  else
	  parent.frames[1].document.forms[0].std_ref.disabled    = true
}

function mand(obj)
{

if(obj.checked == true)
	{
	document.getElementById("std_ref").disabled = false
    document.forms[0].link_yn.value = 'Y'
	document.forms[0].std_value_ref.style.visibility ="visible";
    document.forms[0].search_ref.disabled  = false
	document.forms[0].Rec_vital.checked =  false	
    document.forms[0].Rec_vital.disabled = true
	document.forms[0].Rec_chart.checked =  false
	document.forms[0].Rec_chart.disabled = true
	document.forms[0].Res_rep.checked =  false
	document.forms[0].Res_rep.disabled = true
   
	document.forms[0].sel_all.checked = false
    document.forms[0].sel_all.disabled = true
	document.getElementById("std_ref").readOnly=false;

		
	}
else
	{
	
	document.forms[0].std_ref.disabled    = true
    document.forms[0].std_ref.value='';
	document.forms[0].std_value_ref.style.visibility ="hidden";
	document.forms[0].stdrefval.value='';
    document.forms[0].link_yn.value = 'N'
    document.forms[0].search_ref.disabled = true 
    document.forms[0].Rec_vital.checked =  true	
    document.forms[0].Rec_vital.disabled = false
	document.forms[0].Rec_chart.checked =  true
	document.forms[0].Rec_chart.disabled = false
	//IN064882 start
	if(document.forms[0].comp_type.value != "H")
	{
		document.forms[0].Res_rep.checked =  true
		document.forms[0].Res_rep.disabled = false
	}//IN064882 ends
	document.forms[0].Note_temp.checked = true
    document.forms[0].Note_temp.disabled = false
	//IN064882 starts
	if(document.forms[0].comp_type.value != "H")
	{
		document.forms[0].sel_all.checked = true
		document.forms[0].sel_all.disabled = false
	}//IN064882 ends
	document.forms[0].std_ref.readOnly=true;
		
	}

 }

 function notman(obj)
 {	 
  if(obj.checked == false)
	  document.getElementById("imgid").style.display = 'none';
  else
	  document.getElementById("imgid").style="display";	  
 }
 //show and init fields

 function enableFields()
{
var compType  = 	document.TemplateComponent_form.comp_type.value ;
if(compType == 'P' || compType == 'R' || compType == 'X' || compType == 'V')
	{
       document.TemplateComponent_form.Rec_vital.checked=false;
	   document.TemplateComponent_form.Rec_vital.disabled=false;
	   document.TemplateComponent_form.Rec_chart.checked=false;
	   document.TemplateComponent_form.Rec_chart.disabled=false;
       document.TemplateComponent_form.Res_rep.checked=false;
	   document.TemplateComponent_form.Res_rep.disabled=false;
	   document.TemplateComponent_form.Note_temp.checked=true;
	   document.TemplateComponent_form.Note_temp.disabled=false;
	   
	}

}
var prevval='';
function showHideFields(val,resetyn,refrange)
{
	if(resetyn == 'Y') //Added by S.Sathish on 10/12/2009 for IN017081
	    parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0" ;
	
	if(val == 'I')
		document.forms[0].decimaldgt.disabled=true;
	else
		document.forms[0].decimaldgt.disabled=false;


	document.forms[0].ref_ranges.selectedIndex=0;
	//document.forms[0].ref_ranges.options(0).selected=true;
	document.getElementById("tr1").style.display= 'none';
	document.getElementById("tr6").style.display= 'none';

	// document.forms[0].include_for_anal_yn.checked = true
	// document.forms[0].include_for_anal_yn.disabled = false
	if(val == 'F')
	{
		document.getElementById("free_text").style="display";
	}
	else
	{
		document.getElementById("free_text").style.display='none';
	}

	if(val=='P'||val=='A'||val=='R'||val=='X'||val=='S')
         document.getElementById("link_yn").checked=false;

	if(val=='T'||val=='D'||val=='E'||val=='C'||val=='L'||val=='H'||val=='F')
		document.getElementById("apptab").width='95.8%'
	else
		document.getElementById("apptab").width='90%' 

	if(val == 'R')
	{
		if(prevval=='T'||prevval=='D'||prevval=='E'||prevval=='C'||prevval=='L'||prevval=='H'||prevval=='F'||prevval=='I'||prevval=='N')
			document.getElementById("apptab").width='90.8%'
	}


	if(val == 'N' || val == 'I' || val == 'A' || val == 'S' )
	{ 
		document.getElementById("trone").style="display";
		document.getElementById("trtwo").style="display";

		if(val=='A' || val=='S')
		{
		document.getElementById("tr2").style.display= 'none';
		document.getElementById("un").style="display";
		document.getElementById("dflt").style.display= 'none';
		}
		else
		{
		document.getElementById("tr2").style="display";
		document.getElementById("un").style="display";
		document.getElementById("dflt").style="display";
		}
		document.getElementById("tr3").style="display";
		document.getElementById("tr4").style="display";
		document.getElementById("tr5").style="display";


		document.getElementById("tr77").style="display";
		document.getElementById("tr11").style="display";
		document.getElementById("tr112").style="display";


		document.getElementById("sp1").style="display";
		document.getElementById("sp2").style="display";

		if(document.forms[0].nu_pre_yn.checked==false)
		{
		if(document.forms[0].mode.value!="update")
		{
           
		document.forms[0].nu_pre_yn.checked=false;  
		document.forms[0].nu_pre_yn.value='N';
		}
		}
	}
	else
	{
	
		
	document.getElementById("sp1").style.display= 'none';
	document.getElementById("sp2").style.display= 'none';
	document.getElementById("trone").style.display= 'none';
	document.getElementById("trtwo").style.display= 'none';
	document.getElementById("tr2").style.display= 'none';
	document.getElementById("un").style.display = 'none';
	document.getElementById("tr3").style.display= 'none';
	document.getElementById("tr4").style.display= 'none';
	document.getElementById("tr5").style.display= 'none';
	//	document.getElementById("tr6").style.display= 'none';
	//	document.getElementById("tr7").style.display= 'none';
	document.getElementById("tr77").style.display= 'none';
	document.getElementById("tr11").style.display= 'none';
	document.getElementById("tr112").style.display= 'none';
	document.getElementById("dflt").style.display= 'none';
	}
	if(val == 'L')
	{
		
	document.getElementById("alpha_info").style.visibility = 'visible';
	document.getElementById("tr9").style="display";
	//                 document.forms[0].ass_score_yn.value='Y' 

	}
	else
	{

	document.getElementById("tr9").style.display= 'none';
	}

    if(val == 'N')
	{
		document.getElementById("tr77").style.visibility = 'visible';
		document.getElementById("tr44").style.visibility = 'visible';
		document.getElementById("tr55").style.visibility = 'visible';
	}
	else
	{
		//document.getElementById("tr77").style.visibility= 'hidden';
		document.getElementById("tr44").style.visibility= 'hidden';
		document.getElementById("tr55").style.visibility= 'hidden';
	}




	if(val == 'T' || val == 'D' || val == 'E' || val == 'C' || val == 'L' || val == 'H' || val == 'F' || val == 'N' || val == 'I' )
	{		
		if(document.forms[0].mode.value != 'update'){
			document.forms[0].link_yn.checked=false;
			document.forms[0].search_ref.disabled=true;
			document.getElementById("tr8").style="display";
			document.forms[0].link_yn.value='N';
			document.forms[0].std_value_ref.style.visibility ="hidden";	
		}
		else{
			if(document.forms[0].link_yn.checked==true)
                 document.forms[0].std_value_ref.style.visibility ="visible";			    
		}

	/*if(document.forms[0].link_yn.value != 'Y')
		{
		
		document.forms[0].link_yn.value='N';
		document.forms[0].link_yn.checked=false;
		}*/
	}
	else
	{
		
	document.getElementById("tr9").style.display= 'none';
		
	document.getElementById("tr8").style.display= 'none';
	//document.forms[0].link_yn.value='N';
	document.getElementById("alpha_info").style.visibility = 'hidden'
	}
	if(refrange == 'M')
	{
		
	document.getElementById("numeric_details").style.visibility = 'visible'
	document.getElementById("tr3").style.display= 'none';
	document.getElementById("tr4").style.display= 'none';
	document.getElementById("tr5").style.display= 'none';
	document.getElementById("un").style.display= 'none';
	document.getElementById("dflt").style.display= 'none';
	//	document.getElementById("para").style.visibility = 'hidden'
	}
	else
		
	document.getElementById("numeric_details").style.visibility = 'hidden'

	if(val == 'P' || val == 'R' || val == 'X' || val == 'M' )
	{
		
	document.forms[0].Rec_vital.checked =  false	
	document.forms[0].Rec_vital.disabled = true

	document.forms[0].Rec_chart.checked =  false
	document.forms[0].Rec_chart.disabled = true

	document.forms[0].Res_rep.checked =  false
	document.forms[0].Res_rep.disabled = true

	document.forms[0].Note_temp.checked = true
	document.forms[0].Note_temp.disabled = false
	
	document.forms[0].sel_all.checked = false
	document.forms[0].sel_all.disabled = true
		
	}
	else if(val == 'I' && resetyn == 'Y')
	{
		document.forms[0].Rec_vital.checked =  true	;
		document.forms[0].Rec_vital.disabled = false;

		document.forms[0].Rec_chart.checked =  true;
		document.forms[0].Rec_chart.disabled = false;

		document.forms[0].Res_rep.checked =  true;
		document.forms[0].Res_rep.disabled = false;
		
		document.forms[0].Note_temp.checked = true;
		document.forms[0].Note_temp.disabled = false;
	
		document.forms[0].sel_all.checked = true;
		document.forms[0].sel_all.disabled = false;
		
		if(val == 'I' && refrange == 'M'){
			document.forms[0].Note_temp.checked = false;
			document.forms[0].Note_temp.disabled = true;
			
			document.forms[0].sel_all.checked = false;
			document.forms[0].sel_all.disabled = true;
		}else{
			document.forms[0].Note_temp.checked = true;
			document.forms[0].Note_temp.disabled = false;
		
			document.forms[0].sel_all.checked = true;
			document.forms[0].sel_all.disabled = false;

		}
	}
	else if(val == 'I' && resetyn == 'N')
	{
		document.forms[0].Rec_vital.checked =  true	;
		document.forms[0].Rec_vital.disabled = false;

		document.forms[0].Rec_chart.checked =  true;
		document.forms[0].Rec_chart.disabled = false;

		document.forms[0].Res_rep.checked =  true;
		document.forms[0].Res_rep.disabled = false;		
		
		if(val == 'I' && refrange == 'M'){
			document.forms[0].Note_temp.checked = false;
			document.forms[0].Note_temp.disabled = true;
			
			document.forms[0].sel_all.checked = false;
			document.forms[0].sel_all.disabled = true;
		}else{
			document.forms[0].Note_temp.checked = true;
			document.forms[0].Note_temp.disabled = false;
		
			document.forms[0].sel_all.checked = true;
			document.forms[0].sel_all.disabled = false;

		}
	}
	else if(val == 'A' || val == 'S')
	{
	
	document.forms[0].Rec_vital.checked =  false	
	document.forms[0].Rec_vital.disabled = true
	document.forms[0].Rec_chart.checked =  true
	document.forms[0].Rec_chart.disabled = false
	document.forms[0].Res_rep.checked =  false
	document.forms[0].Res_rep.disabled = true
		if(refrange == 'M'){
			document.forms[0].Note_temp.checked = false;
			document.forms[0].Note_temp.disabled = true;			
		}else{
			document.forms[0].Note_temp.checked = true;
			document.forms[0].Note_temp.disabled = false;
		
		}   
	
	document.forms[0].sel_all.checked = false
	document.forms[0].sel_all.disabled = true
		
	
	}
	else if (val == 'H')
	{
	//IN065595 start
	/*document.forms[0].Rec_vital.checked =  true	
	document.forms[0].Rec_vital.disabled = false*/
	if(document.forms[0].VS_APPL_YN.value == "Checked"){
		document.forms[0].Rec_vital.checked =  true	
		document.forms[0].Rec_vital.disabled = false
	}
	//IN065595 ends
	/* Commented for IN064882
	document.forms[0].Rec_chart.checked =  false
	document.forms[0].Rec_chart.disabled = true
	*/
	document.forms[0].Res_rep.checked =  false
	document.forms[0].Res_rep.disabled = true
	//IN065595 start
	/*document.forms[0].Note_temp.checked = true
	document.forms[0].Note_temp.disabled = false */
	if(document.forms[0].TM_APPL_YN.value == "Checked"){
		document.forms[0].Note_temp.checked = true
		document.forms[0].Note_temp.disabled = false
	}
	//IN065595 End
	document.forms[0].sel_all.checked = false
	document.forms[0].sel_all.disabled = true
		
	}
	else if(val == 'G')
	{
		
	document.forms[0].Rec_vital.checked =  false	
	document.forms[0].Rec_vital.disabled = true
	document.forms[0].Rec_chart.checked =  true
	document.forms[0].Rec_chart.disabled = false
	document.forms[0].Res_rep.checked =  false
	document.forms[0].Res_rep.disabled = true
	document.forms[0].Note_temp.checked = false
	document.forms[0].Note_temp.disabled = true   
	
	document.forms[0].sel_all.checked = false
	document.forms[0].sel_all.disabled = true
	
	}
	else
	{

	if(document.forms[0].mode.value!="update")
	{
	document.forms[0].Rec_vital.checked =  true	
	document.forms[0].Rec_vital.disabled = false
	document.forms[0].Rec_chart.checked =  true
	document.forms[0].Rec_chart.disabled = false
	document.forms[0].Res_rep.checked =  true
	document.forms[0].Res_rep.disabled = false
		if(val == 'N' && refrange == 'M'){
			document.forms[0].Note_temp.checked = false;
			document.forms[0].Note_temp.disabled = true;
			
			document.forms[0].sel_all.checked = false;
			document.forms[0].sel_all.disabled = true;
		}else{
			document.forms[0].Note_temp.checked = true;
			document.forms[0].Note_temp.disabled = false;
		
			document.forms[0].sel_all.checked = true;
			document.forms[0].sel_all.disabled = false;

		}
			
		}
	}

	prevval = val;
}

			function initFields()
			{			
				document.getElementById("free_text").style.display='none';
				document.getElementById("trone").style.display = 'none';
				document.getElementById("trtwo").style.display= 'none';
				document.getElementById("tr1").style.display= 'none';
				document.getElementById("tr2").style.display= 'none';
				document.getElementById("un").style.display= 'none';
				document.getElementById("tr3").style.display= 'none';
				document.getElementById("tr4").style.display= 'none';
				document.getElementById("tr5").style.display= 'none';
				document.getElementById("tr6").style.display= 'none';
			//	document.getElementById("tr7").style.display= 'none';
			//	document.getElementById("free_text").style.display= 'none';
				document.getElementById("alpha_info").style.visibility = 'hidden';
				document.getElementById("tr8").style.display= 'none';
				document.getElementById("tr9").style.display= 'none';
			//	document.getElementById("tr10").style.display= 'none';
			
				document.getElementById("tr77").style.display= 'none';
				document.getElementById("tr11").style.display= 'none';
				document.getElementById("tr112").style.display= 'none';
				document.getElementById("dflt").style.display= 'none';
			//	document.getElementById("un").style.display= 'none';
				document.forms[0].ass_score_yn.value='N'
                document.forms[0].nu_pre_yn.value='N'
                document.forms[0].link_yn.value='N'

				document.getElementById("sp1").style.display= 'none';
				document.getElementById("sp2").style.display= 'none';
			}


//Functions for TemplateComponentAlphaInfoResult.jsp-end


//Functions for DiscrMeasure

function CheckPositiveNumberLocal(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value > 0) 
	{		
	}
	else {
  		if ( obj.value.length < 0 ) 
		{
  			//alert("APP-SM0050 - Value should be greater than equal to ZERO");
  			
			obj.select();
  			obj.focus();
  		}
  	}
}

function validateMinmax(obj)
{
	if(CheckNum(obj))
	{
		var n = obj.value;
		var num = n.length;
		var maxlen = eval(document.getElementById("maxdgt").value)
		var minlen = eval(document.getElementById("mindgt").value)	

		if(minlen > maxlen){
			//alert('APP-AM0136 Min Digts must be lesser than Max Digits');
			//alert(getMessage('MIN_LESS_THAN_MAX','AM'));
			var error = getMessage('MIN_LESS_THAN_MAX','AM');
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			document.getElementById("mindgt").value="";
			document.getElementById("mindgt").focus();
			return false;
		}	
	
		else 
			return true;
	}
	else
		return false;
}

function validateDeci(obj)
{
	if(CheckNum(obj))
	{		
		var maxlen = eval(document.getElementById("maxdgt").value)
		var minlen = eval(document.getElementById("mindgt").value)
		var preci = eval(document.getElementById("decimaldgt").value)

		 if(preci > (maxlen-minlen)){
			//alert('APP-AM0136 Decimal Digits must be lesser than Max-Min Digits');
			alert(getMessage('INVALID_DEC_VAL','AM'));
			document.getElementById("decimaldgt").value=""
			document.getElementById("decimaldgt").focus();
			return false;
		}
		
		else 
			return true;
	}
	else
		return false;
}

function setNumericFields(val)
			{
				if(val == 'M')
				{
					document.getElementById("ref_low").value = "";
					document.getElementById("ref_high").value = "";
					document.getElementById("critical_low").value = "";
					document.getElementById("critical_high").value = "";
					document.getElementById("default_val").value = "";
					document.getElementById("unit_of_measure").value = "";

					//document.getElementById("tr").style.display= 'none';
					document.getElementById("tr3").style.display= 'none';
					document.getElementById("tr4").style.display= 'none';
					document.getElementById("tr5").style.display= 'none';
					document.getElementById("tr6").style.display= 'none';
					//document.getElementById("tr7").style.display= 'none';

					document.getElementById("numeric_details").style.visibility = 'visible'
					if((document.getElementById("comp_type").value)=='N' || (document.getElementById("comp_type").value)=='I'){
						document.getElementById("sel_all").checked=false;
						document.getElementById("sel_all").disabled=true;
						document.getElementById("Note_temp").checked=false;
						document.getElementById("Note_temp").disabled=true;
					}else if((document.getElementById("comp_type").value)=='A' || (document.getElementById("comp_type").value)=='S'){
						document.getElementById("Note_temp").checked=false;
						document.getElementById("Note_temp").disabled=true;
					}
				}
				else if(val == 'S')
				{
					document.getElementById("tr3").style="display";
					document.getElementById("tr4").style="display";
					document.getElementById("tr5").style="display";
			    //	document.getElementById("tr6").style.display= 'block';
				//	document.getElementById("tr7").style.display= 'block';

					document.getElementById("numeric_details").style.visibility = 'hidden'
					if((document.getElementById("comp_type").value)=='N' || (document.getElementById("comp_type").value)=='I'){
						document.getElementById("sel_all").disabled=false;
						document.getElementById("sel_all").checked=true;
						document.getElementById("Note_temp").disabled=false;
						document.getElementById("Note_temp").checked=true;						
					}else if((document.getElementById("comp_type").value)=='A' || (document.getElementById("comp_type").value)=='S'){
						document.getElementById("Note_temp").disabled=false;
						document.getElementById("Note_temp").checked=true;
					}
				}
			}

async function showNumericDetails()
{
	var discrmeasure = self.document.forms[0].comp_id.value
	if(validateMaxMinDec('BU') == true)
	{
		var dialogHeight ='400px' ;
		var dialogWidth = '700px' ;
		var dialogTop	= '315';
		var dialogLeft = '157' ; 

		var features = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';dialogTop:'+dialogTop+';dialogLeft:'+dialogLeft+'; scroll=yes; status=no';
		var arguments = "";
		var convals = parent.frames[1].document.forms[0].numeric_details_values.value;

		var maxmindec = (document.getElementById("maxdgt").value==''?'0':document.getElementById("maxdgt").value)+"$"+(document.getElementById("mindgt").value==''?'0':document.getElementById("mindgt").value)+"$"+(document.getElementById("decimaldgt").value==''?'0':document.getElementById("decimaldgt").value)
		var retVals = await window.showModalDialog('../../eAM/jsp/DiscrMsrCompNumMain.jsp?from=N&discr_measure='+discrmeasure+'&con_vals='+escape(convals)+'&max_min_dec='+maxmindec,arguments,features);

		if(retVals !=null)
		parent.frames[1].document.forms[0].numeric_details_values.value=retVals;
	}
}

function validateMaxMinDec(val)
{
	var f = '';
	if (val == 'BU')
		f = parent.f_query_add_mod;
	else
		f = f_query_add_mod;
	
	var maxlen = "";
	var minlen  = "";
	var preci = "";
	var dflt_val = "";

	maxlen = document.getElementById("maxdgt").value
	minlen = document.getElementById("mindgt").value
	preci = document.getElementById("decimaldgt").value
	dflt_val = document.getElementById("default_val").value

	
	if( dflt_val  != '' ){
		if(maxlen == '' || minlen =='' ) {
			//alert('APP-AM0131 Max and Min values must be entered');
			alert(getMessage('MAX_MIN_MANDATORY','AM'));
			return false;
		}
	}	

	if(maxlen!=0 && minlen >= 0 && minlen > maxlen){
		//alert('APP-AM0136 Min Digts must be lesser than Max Digits');
		alert(getMessage('MIN_LESS_THAN_MAX','AM'));
		document.getElementById("mindgt").focus();
		return false;
	}
	else if(preci > (maxlen-minlen)){
		//alert('APP-AM0136 Decimal Digits must be lesser than Max-Min Digits');
		alert(getMessage('INVALID_DEC_VAL','AM'));
		document.getElementById("decimaldgt").focus();
		return false;
	}
	else return true;
}

function validateNumber2(obj,From)
{
if(From == 'Num')
	{
	
	if(CheckNum(obj))
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

		var maxlen = eval(document.getElementById("max").value)
		var minlen = eval(document.getElementById("min").value)
		var preci = eval(document.getElementById("decimal").value)
//alert(maxlen+"  "+minlen+"  "+preci+"  "+n.indexOf("."));
		if(maxlen!=0 && minlen!=0 && minlen > maxlen){
			//alert('APP-AM0136 Min Digts must be lesser than Max Digits');
			alert(getMessage('MIN_LESS_THAN_MAX','AM'));
			document.getElementById("min").focus();
			return false;
		}
		else if(preci > (maxlen-minlen)){
			//alert('APP-AM0136 Decimal Digits must be lesser than Max-Min Digits');
			alert(getMessage('INVALID_DEC_VAL','AM'));
			document.getElementById("decimal").focus();
			return false;
		}
		else if(maxlen!=0 && num > maxlen){
			alert(getMessage('MAXIMUM_DIGITS','AM')+' '+maxlen);
			obj.value="";
			obj.focus();
			return false;
		}
		else if(minlen!=0 && num < minlen){
			alert(getMessage('AM0117','AM')+' '+minlen);
			obj.value="";
			obj.focus();

			return false;
		}
		/*else if((preci==0 || preci==null ) && (n.indexOf(".") >= 0))
		{
			alert(parent.getMessage('NO_DECIMAL'));
			obj.focus();
			return false;
		}*/
		else if (preci!=null && preci!=0 && frac > preci ){
			//alert('APP-AM0139 Precision should be less than length');
			alert(getMessage('AM0118','AM'));
			obj.value="";
			obj.focus();
			return false;
		}
		else 
			return true;
	}
	else
		return false;
	}
	else
	{

    if(CheckNum(obj))
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

		var maxlen = eval(document.getElementById("maxdgt").value)
		var minlen = eval(document.getElementById("mindgt").value)
		var preci = eval(document.getElementById("decimaldgt").value)
//alert(maxlen+"  "+minlen+"  "+preci+"  "+n.indexOf("."));
		if(maxlen!=0 && minlen!=0 && minlen > maxlen){
			//alert('APP-AM0136 Min Digts must be lesser than Max Digits');
			alert(getMessage('MIN_LESS_THAN_MAX','AM'));
			document.getElementById("mindgt").focus();
			return false;
		}
		else if(preci > (maxlen-minlen)){
			//alert('APP-AM0136 Decimal Digits must be lesser than Max-Min Digits');
			alert(getMessage('INVALID_DEC_VAL','AM'));
			document.getElementById("decimaldgt").focus();
			return false;
		}
		else if(maxlen!=0 && num > maxlen){
			//alert('APP-AM0107 Maximum number of digits the value can have is'+' '+maxlen);
			alert(getMessage('MAXIMUM_DIGITS','AM')+' '+maxlen);
			obj.value="";
			obj.focus();
			return false;
		}
		else if(minlen!=0 && num < minlen){
			//alert('PP-AM0106 Minimum number of digits the value must have is'+''+minlen);
			alert(getMessage('AM0117','AM')+' '+minlen);
			obj.value="";
			obj.focus();

			return false;
		}
		/*else if((preci==0 || preci==null ) && (n.indexOf(".") >= 0))
		{
			alert(parent.getMessage('NO_DECIMAL'));
			obj.focus();
			return false;
		}*/
		else if (preci!=null && preci!=0 && frac > preci ){
			//alert('APP-AM0139 Precision should be less than length');
			alert(getMessage('AM0118','AM'));
			obj.value="";
			obj.focus();
			return false;
		}
		else 
			return true;
	}
	else
		return false;
   
	}
}
async function getServiceCode3()
	{
		var target			= document.getElementById('std_ref');
		var stdval          = document.getElementById('std_ref').value;
        var val = document.getElementById('comp_type').value;
		var retVal			=  new String();
		var dialogTop	= "35px";
		var dialogHeight		= "400px" ;
		var dialogWidth	= "700px" ;
		var features			= "dialogTop:"+dialogTop+";dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +";status=no" ;
		var arguments			= "" ;
		var search_desc			= "";
		var title			= encodeURIComponent(getLabel("eAM.StandardComp.label","AM"));

		
       

		var sql="Select std_comp_id, std_comp_desc from am_standard_comp where eff_status = 'E' and std_comp_result_type= '"+val+"'";
        
		
		search_code="std_comp_id";
		search_desc="std_comp_desc";
		//retVal='34';
		retVal=await window.showModalDialog('../../eCommon/jsp/GeneralSearch.jsp?SQL='+sql+'&search_code='+search_code+'&search_desc='+search_desc+'&title='+title+'&dispDescFirst=dispDescFirst',arguments,features);
		
		var arr=new Array();
		if (retVal != null && retVal != '' && retVal != "null")
		{

			var retVal=unescape(retVal);

		   	arr=retVal.split("::");
			
		   	document.getElementById('std_ref').value=arr[0];
			
			document.getElementById('stdrefval').value=arr[1];
			document.getElementById('eff_status').focus();
				//document.forms[0].std_ref.focus();
		}
		else
		{
			document.getElementById('std_ref').value="";
			document.getElementById('stdrefval').value="";
			document.getElementById('eff_status').focus();
			//target.focus();
		} 
	}

	function enabcategory(obj)
	{
		//if(obj.checked == false )
		if(document.forms[0].Rec_vital.checked == false || document.forms[0].Rec_chart.checked == false || document.forms[0].Res_rep.checked == false || document.forms[0].Note_temp.checked == false)
		{
			
			document.forms[0].sel_all.checked = false;
			//document.forms[0].Rec_vital.checked =  false
			//document.forms[0].Rec_chart.checked =  false
		    //document.forms[0].Res_rep.checked =  false
		    //document.forms[0].Note_temp.checked = false	
			document.forms[0].sel_all.value='N';
			
			obj.value="N"
		}
		else
		
            document.forms[0].sel_all.checked = true;
		    //document.forms[0].Rec_vital.checked =  true
		    //document.forms[0].Rec_chart.checked =  true
		    //document.forms[0].Res_rep.checked =  true
		    //document.forms[0].Note_temp.checked = true
            document.forms[0].sel_all.value='Y';

			obj.value="Y";
	}


	/*function enabnumeric(obj)
	{
      if(obj.checked == true)
		{
			
			document.forms[0].sel_all.checked = false;
            document.forms[0].sel_all.value='N';
		}
	}*/

	
function checkRec(obj)
{
	
if (obj.value!="")
	{
		var restype=document.forms[0].comp_type.value;
		HTMLVal="<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body class=MESSAGE onKeyDown = 'lockKey()'><form name='discreteMsrCompForm' id='discreteMsrCompForm' method='post' action='DiscrMsrCompStandardRefSearch.jsp'><input type=hidden name='stdref' id='stdref' value='"+obj.value+"'><input type=hidden name='restype' id='restype' value='"+restype+"'></form></body></html>"
		parent.frames[2].document.write(HTMLVal);
		parent.frames[2].document.discreteMsrCompForm.submit();
	}

}

function checkall(obj)
{
	if(obj.checked==true)
	{
		
		document.forms[0].sel_all.value='Y';
		document.forms[0].Rec_vital.checked =  true	
		document.forms[0].Rec_chart.checked =  true
		document.forms[0].Res_rep.checked =  true
		document.forms[0].Note_temp.checked = true
	}
		else
	{
		document.forms[0].sel_all.value='N';
		document.forms[0].Rec_vital.checked =  false	
		document.forms[0].Rec_chart.checked =  false
		document.forms[0].Res_rep.checked =  false
		document.forms[0].Note_temp.checked = false	
	}

}

function show(obj)
{
	var com=document.forms[0].comp_type.value;
	if(obj.value == 'M')
	{
		document.getElementById('un').style.display='none';
		document.getElementById('dflt').style.display='none';
	}
	else
	{
		if(com == 'A' || com == 'S')
		{
			document.getElementById('un').style.display='none';
			document.getElementById('dflt').style.display='none';
		}
		else
		{
			document.getElementById('un').style.display='block';
			document.getElementById('dflt').style.display='block';
		}
	}
}


function asscheck(obj)
{
	if(obj.checked == true)
		document.forms[0].ass_score_yn.value='Y'
	else
		document.forms[0].ass_score_yn.value='N'
}


function chkMiinMax1(obj1,obj2)//check the between Min and Max
{
	//var error = 'APP-AM143 Minimum value should be less than maximum value'
	var error= getMessage('INVALID_MIN_VAL','AM');
	if(obj1.value != "" && obj2.value != "")
	{
	   if(parseFloat(obj1.value) > parseFloat(obj2.value))
		{
			obj1.focus();
			obj1.select();
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			return false ;
		}
	}

	return true ;
}


function validateRefCritical2(obj)
{   //alert('here')
	var str=obj.value;
   	if(!isNaN(str) && str!=''){
	var reflow = eval(document.forms[0].ref_low.value)==null?"":eval(document.forms[0].ref_low.value);
	var refhigh = eval(document.forms[0].ref_high.value)==null?"":eval(document.forms[0].ref_high.value);
	var critlow = eval(document.forms[0].critical_low.value)==null?"":eval(document.forms[0].critical_low.value);
	var crithigh = eval(document.forms[0].critical_high.value)==null?"":eval(document.forms[0].critical_high.value);
	
	
	
	var min = eval(document.forms[0].min.value)==null?"":eval(document.forms[0].min.value);
	var max = eval(document.forms[0].max.value)==null?"":eval(document.forms[0].max.value);

	var msg =  "";

	if(refhigh!=0 && max!=0 && refhigh > max)
	{
		//msg = "APP-AM0111 Reference High should not be greater than Max Value";
		msg = getMessage('AM0120','AM');
		parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		document.forms[0].ref_high.select();
		document.forms[0].ref_high.focus();
		return false;
	}
	else if(reflow!=0 && min!=0 && reflow < min)
	{
		//msg = "APP-AM0111 Reference Low should be greater than Min Value";
		msg = getMessage('AM0121','AM');
		parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		document.forms[0].ref_low.select();
		document.forms[0].ref_low.focus();
		return false;
	}
	else if(crithigh != 0 && max != 0 && crithigh > max)
	{
		//msg = "APP-AM0111 Critical High should be lesser than Max Value";
		msg = getMessage('AM0122','AM');
		document.forms[0].critical_high.select();
		document.forms[0].critical_high.focus();

		parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;

		return false;
	}
	else if(critlow != 0 && min!=0 && critlow < min)
	{
		//msg = "APP-AM0111 Critical low should be greater than Min Value";
		msg = getMessage('AM0123','AM');
		parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		document.forms[0].critical_low.select();
		document.forms[0].critical_low.focus();
		return false;
	}
	//else if((parseFloat(critlow) == parseFloat(crithigh)) && (critlow != "" && crithigh!=""))
		else if((parseFloat(critlow) == parseFloat(crithigh)) )
	{
	
		//msg= "APP-AM0112 Reference Low cannot be greater than Reference High";
		msg = getMessage('AM0173','AM');
		msg = msg.replace('$',getLabel('Common.Critical.label','Common') +" "+getLabel('Common.Low.label','Common'));
		msg = msg.replace('#',getLabel('Common.Critical.label','Common') +" "+getLabel('Common.High.label','Common'));
	    parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		document.forms[0].critical_high.select();
		document.forms[0].critical_high.focus();
		//alert(msg);
		//parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		return false;
	}
	else if(reflow!=0 && refhigh!=0 && reflow > refhigh)
	{
		//msg= "APP-AM0112 Reference Low cannot be greater than Reference High";
		msg = getMessage('REF_LOW_NOT_GREATER_HIGH','AM');
		parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		document.forms[0].ref_high.select();
		document.forms[0].ref_high.focus();
		return false;
	}

	else if((parseFloat(reflow) == parseFloat(refhigh)) )// && (reflow != "" && refhigh!=""))
	{
		//msg= "APP-AM0112 Reference Low cannot be greater than Reference High";
		msg = getMessage('AM0173','AM');
		msg = msg.replace('$',getLabel('eMP.Reference.label','MP') +" "+getLabel('Common.Low.label','Common'));
		msg = msg.replace('#',getLabel('eMP.Reference.label','MP') +" "+getLabel('Common.High.label','Common'));
		parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		document.forms[0].ref_high.select();
		document.forms[0].ref_high.focus();
		return false;
	}

	else if(critlow!=0 && crithigh!=0 && critlow > crithigh)
	{
		//msg = "APP-AM0109 Critical Low cannot be greater than Critical High";
		msg = getMessage('CRITICAL_LOW_NOT_GREATER_HIGH','AM');
		parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
		document.forms[0].critical_high.select();
		document.forms[0].critical_high.focus();
		return false;
	}
	else
	{
		if(critlow!=0 && reflow!=0 && critlow > reflow)
		{
			//msg = "APP-AM0110 Critical Low should be less than Reference Low";
			msg = getMessage('CRITICAL_LOW_LESS_REF_LOW','AM');
			parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0" ;
			document.forms[0].critical_low.select();
			document.forms[0].critical_low.focus();
			return false;
		}
		else if(crithigh!=0 && refhigh!=0 && crithigh < refhigh)
		{
			//msg = "APP-AM0111 Critical High should be greater than Reference High";
			msg = getMessage('CRITICAL_HIGH_GREATER_REF_HIGH','AM');
			parent.frames[2].location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg+"&err_value=0";
			document.forms[0].critical_high.select();
			document.forms[0].critical_high.focus();
			return false;
		}
		
		else 
		{
			parent.frames[2].location.href ="../../eCommon/jsp/MstCodeError.jsp";
			return true;
		}

	}
}
}
function setHistype(obj)
{
	document.forms[0].histype.value=obj.value;
}

function setService(obj)
{
    document.forms[0].service.value=obj.value;
}

function setStd(obj)
{
	if(document.forms[0].std_ref.value != '')
	{
		document.forms[0].link_yn.value='N';
		document.forms[0].link_yn.checked=false;
		document.forms[0].std_ref.value='';
		document.forms[0].stdrefval.value='';
	}
		
}

function setFreeText(obj)
{
    document.forms[0].freetext.value=obj.value;
}

function CheckSpecialChar(obj)
{
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();

	SpChar[0] = '~';
	SpChar[1] = '`';
	SpChar[2] = '!';
	SpChar[3] = '@';
	SpChar[4] = '#';
	SpChar[5] = '$';
	SpChar[6] = '%';
	SpChar[7] = '^';
	SpChar[8] = '&';
	SpChar[9] = '*';
	SpChar[10] = '(';
	SpChar[11] = ')';
	SpChar[12] = '-';
	SpChar[13] = '+';
	SpChar[14] = '=';
	SpChar[15] = '|';
	SpChar[16] = '\\';
	SpChar[17] = '[';
	SpChar[18] = ']';
	SpChar[19] = '{';
	SpChar[20] = '}';
	SpChar[21] = ':';
	SpChar[22] = ';';
	SpChar[23] = '"';
	SpChar[24] = '<';
	SpChar[25] = '>';
	SpChar[26] = '?';
	SpChar[27] = '/';
	SpChar[28] = '\'';
	SpChar[29] = '';
	SpChar[30] = ',';
	SpChar[31] = '.';


	if (fieldval.substr(0,1) == '_' ) 
	{
		to_check = false;
	}
    else
	{
	for(var i=0;i<fieldlen;i++)
	{

		if (fieldval.substr(i,1) == ' ' || fieldval.substr(i,1) == null)
		{
			to_check = false;
		}

		for (var j=0;j<=31;j++)
		{
			if (fieldval.substr(i,1) == SpChar[j])
			{
				to_check = false;
			}
		}
	}
    }
	if (to_check == false)
	{
		//alert("APP-AM0072 Special Characters are not allowed");
		alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
		//obj.select();
		obj.value="";
		obj.focus();
	}
}

function chkspchar(obj)
{
	var key = window.event.keyCode;
	//alert(key);
	if((key ==126 ) ||(key==124) ||(key==36) ) 
	{
				return false;
	}
	else
			return true;
}

function chkchar(obj)
{
	var sp='~|$';
	var charter=obj.value;
	for(var i=0;i<sp.length;i++)
	{
	 if(charter.indexOf(sp.charAt(i))!=-1){
		//alert("APP-AM0072 Special Characters are not allowed");
		alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
		//obj.select();
		obj.value="";
		obj.focus();
	 }
	}
}

function myfocus()
{   
    document.templateComponentRowColDefForm.matrix_cols.focus();
	/*if(document.templateComponentRowColDefForm.mode.value=='insert')
	{	
		if(document.templateComponentRowColDefForm.matrix_rows.value=' ')	 	
			document.templateComponentRowColDefForm.matrix_rows.disabled=true;
	}*/
 
}

function CheckZero(obj)
{	
	if(obj.value==0 && obj.value!="")
	{
	  err = getMessage("AM0170","AM");
	  err = err.replace("$","The value");
	  alert(err);	  
	  obj.value='';
	  obj.focus();
	  return false ;
	 // obj.focus();	  
	}
if(document.forms[0].name!="templateComponentRowColDefForm"){
	 if(document.forms[0].maxdgt.value == document.forms[0].mindgt.value && (document.forms[0].maxdgt.value != "" && document.forms[0].mindgt.value !=""))
		{
			error = getMessage("AM0173","AM");
			error = error.replace('$',getLabel('eAM.MinValue.label','AM')); 
			error = error.replace('#',getLabel('Common.MaxValue.label','Common')); 
			//alert(error);
			//document.forms[0].mindgt.value='';
			//obj.mindgt.focus();
			//obj.mindgt.select();
			parent.messageFrame.location.href ="../../eCommon/jsp/MstCodeError.jsp?err_num=" + error + "&err_value=0" ;	
			
			return false ;
}
}
}

// Added for Discrete Type Indicator :

function beforeGetDiscreteTypeInd(obj,target_name)
{
	 obj.value = trimString(obj.value);
	 if(obj.value == "")
		{
		 document.forms[0].disTypeIndval.value="";
		 document.forms[0].discr_typeInd.value="";
		 return;
		}
		getdiscretetypeind(obj,target_name);
}

//

	async function getdiscretetypeind(desc,code)
	{
		tar=desc.value
		//var locale=document.forms[0].locale.value;
		var retVal =    new String();
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
	    var tit			= getLabel("eAM.DiscreteTypeIndicator.label","AM");
		
		sql="select DISCR_TYPE_ID code, SHORT_DESC description  from AM_DISCR_TYPE where   upper(DISCR_TYPE_ID) like upper(?) and upper(short_desc) like upper(?)";


		argumentArray[0] =sql;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = tar;
		argumentArray[6] = DESC_LINK  ;
		argumentArray[7] = DESC_CODE ;
		retVal = await CommonLookup( tit, argumentArray );
		if(retVal != null && retVal != "" )
		  {
			
		    var ret1=unescape(retVal);
			
			arr=ret1.split(",");
			
		    document.forms[0].discr_typeInd.value=arr[1];
			document.forms[0].disTypeIndval.value=arr[0];
       
			}else
		{
		   document.forms[0].discr_typeInd.value="";
			document.forms[0].disTypeIndval.value="";
		}
				
	
	}
function Chkref_low(){
		if(document.forms[0].ref_low.value==''){
			return false;
		}else{
			return true;
		}
		//trimString
}

function Chkref_high(){
	if(document.forms[0].ref_high.value==''){
		return false;
	}else{
		return true;
	}
		
}

function noteTemplCharAllowed(){ //68801 start
	var char_val  = document.TemplateComponent_form.char_limit.value;
	var compType = document.TemplateComponent_form.comp_type.value
	
	if(compType == 'H'){//short text validation
	if((char_val > 150 || char_val == 0) && char_val != "" ){
		alert(getMessage('MAX_CHARACTER_LIMIT_FOR_SHORT_TEXT','AM'));
		document.TemplateComponent_form.char_limit.value="";
		document.TemplateComponent_form.char_limit.focus();
		return;
	}}
	
	if(compType == 'F'){//long text validation
	if((char_val > 250 || char_val == 0) && char_val != "" ){
		alert(getMessage('MAX_CHARACTER_LIMIT_FOR_LONG_TEXT','AM'));
		document.TemplateComponent_form.char_limit.value="";
		document.TemplateComponent_form.char_limit.focus();
		return;
	}}
}

function chkCharLimit(obj){
	var char_val  = document.TemplateComponent_form.char_limit.value;
	var compType = document.TemplateComponent_form.comp_type.value;
	var dispResLinkHtmlYN = document.TemplateComponent_form.dispResLinkHtmlYN.value;

	if( obj.value == "H" || obj.value == "F")	//F-Long Text,  H-Short Text
	{
		document.getElementById('noteTempCharTr').style.display='inline';
		if(obj.value == "F" && dispResLinkHtmlYN == "Y"){
		  document.TemplateComponent_form.char_limit.disabled = true;
		  }
		else
		  document.TemplateComponent_form.char_limit.disabled = false;
	}
else
	{
		document.getElementById('noteTempCharTr').style.display = 'none';
	}
}


function CheckForNumsAndColon(event) {
	var strCheck = '0123456789';
	var whichCode = (window.Event) ? event.which : event.keyCode;
	key = String.fromCharCode(whichCode); // Get key value from key code
	if (strCheck.indexOf(key) == -1)
		return false; // Not a valid key
	if ((event.keyCode >= 97) && (event.keyCode <= 122))
		return (event.keyCode -= 32);
	return true;
}
//68801 end

