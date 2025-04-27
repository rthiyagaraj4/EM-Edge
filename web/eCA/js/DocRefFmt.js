var remVal;
var rem;
function ShowListType()
{
	if(parent.frameDocRefFmtHeader.document.getElementById("document_type").value != '')
	{
		var document_id_value=parent.frameDocRefFmtHeader.document.getElementById("document_type").options[parent.frameDocRefFmtHeader.document.getElementById("document_type").selectedIndex].id;	
		parent.frameDocRefFmtLst.location.href='../../eCA/jsp/DocRefFmtList.jsp?document_id_value='+document_id_value;
	}
	else
	{
		parent.frameDocRefFmtLst.location.href = '../../eCommon/html/blank.html';
		parent.frameDocRefFmtConst.location.href = '../../eCommon/html/blank.html';
	}
}

function onClickOfDoc(obj){
//	alert("rertt"+remVal);
	obj = "["+obj+"]";	
//	alert("obj"+obj);
	//if(remVal=="undefined")
	//{
	  //location.href='../../eCA/jsp/DocRefFmtList.jsp?document_id_value='+obj;
	//}
	parent.frameDocRefFmtConst.newTextVal(obj);
	
}

function chkTildeAndGA()
{
	var text = parseInt(event.keyCode);
	if(text == 126 || text == 96 || text == 39 || text == 91 || text == 93 || text == 60 || text == 62 )
	{
		return false;
	}
}

var HTMLtext,  j;
var a = new Array(); // refered in next frame
var i=0; // refered in next frame
var ii=1; // referred in next frame
var value,element;

function loadForNextFrame()
{
	//alert("chk   "+parent.frameDocRefFmtLst.DocRefFmtLst.hiddenRefFormat.value);
	document_id_value=parent.frameDocRefFmtHeader.document.getElementById("document_type").options[parent.frameDocRefFmtHeader.document.getElementById("document_type").selectedIndex].id;

	if(document_id_value.indexOf('~')==0)
	{
		document_id_value=document_id_value.substring(1);
	}

	
	if(i==0)
	{
		var splitformulaVal = document_id_value.split('~');
		var splitWithGA;
		var t;
		for(j=1;j<=splitformulaVal.length;j++)
		{
			element=splitformulaVal[j-1];	
			if(element!= '')
			{
				if(element.indexOf('`') != -1)
				{
					splitWithGA = element.split('`');
					if(splitWithGA[1] != '')
					{
						if(t >= j) t = t+1;
						else t=j;
						if(splitWithGA[0]=='practitioner_id')
						{
							splitWithGA[0]=getLabel("Common.practitionerid.label",'common');
						}
							else if(splitWithGA[0]=='accession_num')
						{
							splitWithGA[0]=getLabel("eCA.AccessionNum.label",'CA');
						}
							else if(splitWithGA[0]=='date_and_time')
						{
							splitWithGA[0]=getLabel("eCA.DateAndTime.label",'CA');
						}
							else if(splitWithGA[0]=='encounter_id')
						{
							splitWithGA[0]=getLabel("Common.encounterid.label",'common');
						}
						 value=t+"|"+'['+splitWithGA[0]+']';
						 a[t]=value;
						 t++;
						 i=i+1;
						 if(splitWithGA[1]=='practitioner_id')
						{
							splitWithGA[1]=getLabel("Common.practitionerid.label",'common');
						}
							else if(splitWithGA[1]=='accession_num')
						{
							splitWithGA[1]=getLabel("eCA.AccessionNum.label",'CA');
						}
							else if(splitWithGA[1]=='date_and_time')
						{
							splitWithGA[1]=getLabel("eCA.DateAndTime.label",'CA');
						}
							else if(splitWithGA[1]=='encounter_id')
						{
							splitWithGA[1]=getLabel("Common.encounterid.label",'common');
						}
						 value=(t)+"|"+splitWithGA[1];
						 a[t]=value;
						 i=i+1;
					}
					else
					{
						if(t >= j) t = t+1;
						else t=j;
						 if(splitWithGA[0]=='practitioner_id')
						{
							splitWithGA[0]=getLabel("Common.practitionerid.label",'common');
						}
							else if(splitWithGA[0]=='accession_num')
						{
							splitWithGA[0]=getLabel("eCA.AccessionNum.label",'CA');
						}
							else if(splitWithGA[0]=='date_and_time')
						{
							splitWithGA[0]=getLabel("eCA.DateAndTime.label",'CA');
						}
							else if(splitWithGA[0]=='encounter_id')
						{
							splitWithGA[0]=getLabel("Common.encounterid.label",'common');
						}

						 value=t+"|"+'['+splitWithGA[0]+']';
						 a[t]=value;
						 i=i+1;
					}
				}
				else
				 {
					 if(element=='practitioner_id')
					{
						element=getLabel("Common.practitionerid.label",'common');
					}
						else if(element=='accession_num')
					{
						element=getLabel("eCA.AccessionNum.label",'CA');
					}
						else if(element=='date_and_time')
					{
						element=getLabel("eCA.DateAndTime.label",'CA');
					}
						else if(element=='encounter_id')
					{
						element=getLabel("Common.encounterid.label",'common');
					}
				 value=j+"|"+element; 
				 a[j]=value;
				 i=i+1;
				}
			}
		}

	}
}

function loadDefault()
{
	parent.frameDocRefFmtConst.location.href ='../../eCA/jsp/DocRefFmtConstruction.jsp';	
}

function displayValues(){
	//alert('in disp val...'+parent.frameDocRefFmtLst.i);
	//var size = document.DocRefFmtConstruction.size_type.value;
	if (parent.frameDocRefFmtLst.i !=0){
		document.getElementById("rese").disabled			= false;
		document.getElementById("remov").disabled			= false;
		document.getElementById("replaceOpt").disabled	= false;
		document.getElementById("replaceRigOpt").disabled = false;
		document.getElementById("replaceRigOpt").checked  = true;
		document.getElementById("replaceLefOpt").disabled = false;
		var spli ="";
		var val = "";
		var html_size = "";
		var total_size = 0;
		var element1 = "";
		var element2 = "";
		var element3 = "";
		var element4 = "";
		var encounter_id ="";
		var practitioner_id ="";
		var accession_num ="";
		var date_and_time ="";
			
	}
	HTMLtext='';
	for(j=1;j<=parent.frameDocRefFmtLst.i;j++){
		var arrVal=parent.frameDocRefFmtLst.a[j];
		//alert("arrVal   "+arrVal);
		if(arrVal!=undefined)
		{
			spli=arrVal.split('|');
			val=spli[1];
			HTMLtext=HTMLtext+" <input type=text id=text"+j+" name="+parent.frameDocRefFmtLst.a[j]+" id="+parent.frameDocRefFmtLst.a[j]+" value='"+val + "' onClick='selectValue(this);' onBlur='catchValue(this);' readonly size="+val.length+">";
					
			//if(val.indexOf('[') != -1))
			//{
			  // val = val.replace('[',"");
			  // val = val.replace(']',"");
			//}
			element1 = getLabel("Common.encounterid.label",'common');
			element2 = getLabel("Common.practitionerid.label",'common');
			element3 = getLabel("eCA.AccessionNum.label",'CA');
			element4 = getLabel("eCA.DateAndTime.label",'CA');

			encounter_id    = '['+element1+']';
			practitioner_id = '['+element2+']';
			accession_num   = '['+element3+']';
			date_and_time   = '['+element4+']';
			
			if(val == encounter_id)
			{
				html_size = 12;
			}
			else if(val == practitioner_id)
			{
				html_size = 15;
			}
			else if(val == accession_num)
			{
				html_size = 24;
			}
			else if(val == date_and_time)
			{
				html_size = 12;
			}
			else
			{
			 html_size = val.length; 
			}		 
		}
		total_size = total_size + html_size;
	}
	document.getElementById("f").insertAdjacentHTML("BeforeEnd",HTMLtext);
	var o=document.getElementById('text'+parent.frameDocRefFmtLst.i);
	if(!o){
		var o=document.getElementById('text')+parent.frameDocRefFmtLst.i;
	}
	if(o){
		o.select();	
		o.style.background = 'yellow' ; 
		o.style.color = 'black' ;		
	}
	else return false;

	document.getElementById('curr_size').innerHTML = total_size ;
	
}


function catchValue(obj)	
{
	remVal=obj.name;
	rem=obj.id;
	//objplace=obj;
	obj.style.background = 'yellow' ;  
	obj.style.color = 'black' ; 

//	alert("catchValue    "+remVal);
	
}

function selectValue(obj)
{	
	if(rem!=undefined)
	{
		//var a=eval('document.all.'+rem+'.style.background="white"'); 
		//var a=eval('document.all.'+rem+'.style.color="black"');    
		var a = document.getElementById(rem).style.background="white";	
		var a = document.getElementById(rem).style.background="black";			
		obj.style.background="yellow"; 
		obj.style.color="black"; 
	}
	
}

function radioCheck(obj)
{
	if(obj.disabled){
		obj.checked=false;
	}else{
		obj.checked=true;
	}	
}

function removeValue()
{
	if(!remVal)
	{
		parent.frameDocRefFmtLst.i= parent.frameDocRefFmtLst.i-1;
	}
	else
	{
		var spli=remVal.split('|');
		var index=spli[0];
		var ope=spli[1];
		for(j=1;j<=parent.frameDocRefFmtLst.i;j++)
		{
			if (index==j)
			{
				for(k=j;k<parent.frameDocRefFmtLst.i;k++)
				{
					var arrVal=parent.frameDocRefFmtLst.a[k+1];
					var spli=arrVal.split('|');
					var val=spli[1];
					var value=k+'|'+val;
					parent.frameDocRefFmtLst.a[k]=value; 
				}
				break;
			}
		}
		parent.frameDocRefFmtLst.i=parent.frameDocRefFmtLst.i-1;
	}
	loadDefault();
}

function newTextVal(obj2)
{
//	alert("remVal22    "+ remVal);
	

/*	if((remVal == "undefined") &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked))
    {
		alert(getMessage("SELECT_ANY_VALUE","CA"));
	}else
	{*/
		if(document.getElementById("replaceOpt").checked)
		{
			if (remVal != undefined)
			{
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var value=index+"|"+obj2;
				parent.frameDocRefFmtLst.a[index]=value;
				parent.frameDocRefFmtLst.ii=index;
			}
		}else if(document.getElementById("replaceRigOpt").checked)
		{
			parent.frameDocRefFmtLst.i = parent.frameDocRefFmtLst.i +1;
	//		alert(remVal);
			if (remVal != undefined)
			{	
		//		alert("in if  "+remVal);
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				index=parseInt(index)+1;
				insVal=index+"|"+obj2;
				for(k=parent.frameDocRefFmtLst.i;index<k;k--)
				{
					var arrVal=parent.frameDocRefFmtLst.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.frameDocRefFmtLst.a[k]=value;
				}
				parent.frameDocRefFmtLst.a[index]=insVal;
				parent.frameDocRefFmtLst.ii=index; 
			}else{
			//	alert("In else  "+index);
				parent.frameDocRefFmtLst.a[1]='1|'+obj2;
				parent.frameDocRefFmtLst.ii=0; 			
				
			}

		}else if(document.getElementById("replaceLefOpt").checked)
		{
			parent.frameDocRefFmtLst.i=parent.frameDocRefFmtLst.i+1;

			if (remVal != undefined)
			{			
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var insVal=index+"|"+obj2;
				for(k=parent.frameDocRefFmtLst.i;index<k;k--)
				{
					var arrVal=parent.frameDocRefFmtLst.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.frameDocRefFmtLst.a[k]=value;
				}
				parent.frameDocRefFmtLst.a[index]=insVal;
				parent.frameDocRefFmtLst.ii=index; 
			}else{
			//	alert("In else  "+index);
				parent.frameDocRefFmtLst.a[1]='1|'+obj2;
				parent.frameDocRefFmtLst.ii=0; 			
				
			}
		}else
		{
			parent.frameDocRefFmtLst.i=parent.frameDocRefFmtLst.i+1;
			obj2=parent.frameDocRefFmtLst.i+"|"+obj2;
			parent.frameDocRefFmtLst.a[parent.frameDocRefFmtLst.i]=obj2;
			parent.frameDocRefFmtLst.ii=parent.frameDocRefFmtLst.i; 
		}
		loadDefault();
	//}
}

function newTextInt(obj){
	if(obj.value == null || obj.value=='')
	{
		var msg = getMessage("CA_SEC_FORMULA_VAL","CA");
		alert(msg);
		return false;
	}

/*	if(!remVal &&( document.getElementById("replaceOpt").checked || document.getElementById("replaceRigOpt").checked || document.getElementById("replaceLefOpt").checked))
	{
		alert(getMessage("SELECT_ANY_VALUE","CA"));

	}
	else
	{*/
		if(document.getElementById("replaceOpt").checked)
		{
			var spli=remVal.split('|');
			var index=spli[0];
			var ope=spli[1];
			var value=index+"|"+obj.value;
			parent.frameDocRefFmtLst.a[index]=value;
			parent.frameDocRefFmtLst.ii=index; //
	}else if(document.getElementById("replaceRigOpt").checked)
	{
			parent.frameDocRefFmtLst.i=parent.frameDocRefFmtLst.i+1;
			if (remVal != undefined)
		   {
				var spli=remVal.split('|');
				var index=spli[0];
				var ope=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj.value;
				for(k=parent.frameDocRefFmtLst.i;index<k;k--)
				{
					var arrVal=parent.frameDocRefFmtLst.a[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.frameDocRefFmtLst.a[k]=value; 
				}
				parent.frameDocRefFmtLst.a[index]=insVal;
				parent.frameDocRefFmtLst.ii=index; //

		   }
			else
			{
			//	alert("In else  "+index);
				parent.frameDocRefFmtLst.a[1]='1|'+obj.value;
				parent.frameDocRefFmtLst.ii=0; 			
				
			}
			
	}else if(document.getElementById("replaceLefOpt").checked)
		{ 
			parent.frameDocRefFmtLst.i=parent.frameDocRefFmtLst.i+1;
			if (remVal != undefined)
		{
			var spli=remVal.split('|');
			var index=spli[0];
			var val=spli[1];
			var insVal=index+"|"+obj.value;
			for(k=parent.frameDocRefFmtLst.i;index<k;k--)
			{
				var arrVal=parent.frameDocRefFmtLst.a[k-1];
				var spl=arrVal.split('|');
				var val=spl[1];
				var value=(k)+'|'+val;
				parent.frameDocRefFmtLst.a[k]=value; 
			}
			parent.frameDocRefFmtLst.a[index]=insVal;
			parent.frameDocRefFmtLst.ii=index; //
		}
		else
			{
			//	alert("In else  "+index);
				parent.frameDocRefFmtLst.a[1]='1|'+obj.value;
				parent.frameDocRefFmtLst.ii=0; 			
				
			}
	}else{
			parent.frameDocRefFmtLst.i=parent.frameDocRefFmtLst.i+1;
			var value=parent.frameDocRefFmtLst.i+"|"+obj.value;
			parent.frameDocRefFmtLst.a[parent.frameDocRefFmtLst.i]=value;
			parent.frameDocRefFmtLst.ii=parent.frameDocRefFmtLst.i; //
	}
	loadDefault();
  //}
}

function onReset(){
	var retVal = "";
	retVal=confirm(getMessage("RESET_DOC_REF_STR","CA"));
	if (retVal==true){
		parent.frameDocRefFmtLst.i=0;
	    parent.frameDocRefFmtLst.location.href='../../eCA/jsp/DocRefFmtList.jsp';
	}else{
		return false;
	}
}

function dummy()
{
	parent.frameDocRefFmtConst.location.href = '../../eCA/jsp/DocRefFmtConstruction.jsp';
}
function clearVal()
{
	document.forms[0].finVal.value='';
}

function apply()
{
	var fields = new Array (
							frameDocRefFmtHeader.document.DocRefFmtHdrfrm.document_type
							);

	var names = new Array (
						    getLabel("Common.documenttype.label",'common')
							);
	if(frameDocRefFmtHeader.checkFieldsofMst( fields, names, messageFrame))
	{
		var textCount = frameDocRefFmtLst.i;
	    var tempText;
	    var tempTextValue = "";
		var size = frameDocRefFmtConst.document.getElementById("curr_size").innerHTML;
		
		//alert(parseInt(textCount,10));
	    for(var v=1;v<=parseInt(textCount,10);v++)
		{
			if (eval(frameDocRefFmtConst.document.getElementById("text"+v)) != null)
			{			
				tempText = eval(frameDocRefFmtConst.document.getElementById("text"+v)).value;
				if(tempTextValue == "")
				{
					if(tempText.indexOf('[')==-1)
					{
						tempText='~'+tempText;
					}
					tempTextValue = tempText;
					tempTextValue = tempTextValue.replace('[',"~");
					tempTextValue = tempTextValue.replace(']',"`");
				}
				else
				{
					if(tempText.indexOf('[')==-1)
					{
						tempText='~'+tempText;
					}
					tempTextValue = tempTextValue + tempText;
					tempTextValue = tempTextValue.replace('[',"~");
					tempTextValue = tempTextValue.replace(']',"`");
                    
				}
           }
		   
		}
	//	alert("tempTextValue  1  "+tempTextValue);
	//alert(frameDocRefFmtConst.document.DocRefFmtConstruction.all.curr_size.innerHTML);
        
		
		/*if(tempTextValue.length >40)
		{
			var labelVal = getLabel("eCA.RefNumLogic.label",'CA')
			var msg = getMessage("REMARKS_CANNOT_EXCEED","common");
			msg = msg.replace('$',labelVal);
			msg = msg.replace('#',40);
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0';
		}*/
     if(size != null && size != '' && size != 'null')
	 {
		if(size>40)
		{
			var labelVal = getLabel("eCA.RefNumLogic.label",'CA')
			var msg = getMessage("REMARKS_CANNOT_EXCEED","common");
			msg = msg.replace('$',labelVal);
			msg = msg.replace('#',40);
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0';
		}
		else
		{			
					
			frameDocRefFmtConst.document.DocRefFmtConstruction.hiddenRefFormat.value = tempTextValue;
			frameDocRefFmtConst.document.DocRefFmtConstruction.document_type.value = frameDocRefFmtHeader.document.DocRefFmtHdrfrm.document_type.value; 
			
			frameDocRefFmtConst.document.DocRefFmtConstruction.action='../../servlet/eCA.DocRefFmtServlet';
		    frameDocRefFmtConst.document.DocRefFmtConstruction.target='messageFrame';
			frameDocRefFmtConst.document.DocRefFmtConstruction.method='post';
			frameDocRefFmtConst.document.DocRefFmtConstruction.submit();
		}
	  }
	else
	  {
			alert(getMessage("ATLEAST_ONE_FORMAT_COMMIT","CA"));
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0'; 
			return false;
	 }
  }		
}


function reset()
{
	if(frameDocRefFmtHeader.document.DocRefFmtHdrfrm!=null)
	{
		frameDocRefFmtHeader.document.DocRefFmtHdrfrm.reset();
		frameDocRefFmtLst.location.href = '../../eCommon/html/blank.html';
		frameDocRefFmtConst.location.href = '../../eCommon/html/blank.html';
	}
}

function onSuccess()
{
	frameDocRefFmtHeader.location.reload();
	frameDocRefFmtLst.location.href = '../../eCommon/html/blank.html';
	frameDocRefFmtConst.location.href = '../../eCommon/html/blank.html';
}

