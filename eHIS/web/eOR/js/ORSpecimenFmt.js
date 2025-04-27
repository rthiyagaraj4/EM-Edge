/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
var remVal;
var rem;


function onClickOfDoc(obj,obj1,obj2){
	obj1 = "["+obj1+"]";		
	var run_seq_exists_yn = "N";
	for(j=1;j<=parent.frameSpecFrmtLst.i ;j++){
		if (obj == "RUN_SEQ" &&  parent.frameSpecFrmtLst.b[j]=="RUN_SEQ")
		{
			run_seq_exists_yn = "Y";
			alert(getMessage("CANNOT_ADD_MORETHAN_ON_RUNSEQ","OR"));				
		}
	}	
	if (run_seq_exists_yn != "Y")
	{
		parent.frameSpecFmtConstMain.frameSpecFmtConst.newTextVal(obj,obj1,obj2);	
	}
	
}

function CheckSpecialChars1(Obj){
        var str = Obj.value;       
		var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==45)||(str.charCodeAt(u)==32));
            else{      
				msg = getMessage("CANNOT_BE_SPECIAL_CHAR","COMMON");				
				alert(msg);
				Obj.focus();
                return false;
            }
        }        
    }

function chkTildeAndGA()
{
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;	
}

var HTMLtext,  j;
var a = new Array(); // refered in next frame
var b = new Array(); // refered in next frame
var c = new Array(); // refered in next frame
var i=0; // refered in next frame
var ii=1; // referred in next frame
var value,element;

function loadSpeciFormat(spec_no_format)
{		
		if(spec_no_format.indexOf('$')==0)
		{
			spec_no_format=spec_no_format.substring(1);
		}			
		var splitformulaVal = spec_no_format.split('$');		
		var splitWithGA;
		var compDesc = "";
		var compSize = "";
	
		var t;		
		for(j=1;j<=splitformulaVal.length;j++)
		{
			var runSeqCode = "";
			element=splitformulaVal[j-1];		
			
			if(element!= '')
			{
				if(element.indexOf('|') != -1)
				{
					splitWithGA = element.split('|');		
					
					if(splitWithGA[0] != '')
					{							
						if(splitWithGA[0]=='DATE_2YMD')
						{
							compDesc="Date (YYMMDD)";
							compSize="6";
						}
							else if(splitWithGA[0]=='SPEC_TYPE')
						{
							compDesc="Specimen Type";
							compSize="4";
						}
							else if(splitWithGA[0]=='DATE_4YMD')
						{
							compDesc="Date (YYYYMMDD)";
							compSize="8";
						}
							else if(splitWithGA[0]=='RUN_SEQ')
						{										
							runSeqCode = splitWithGA[1];								
							compDesc="Running Serial No";
							compSize="10";
						}else if(splitWithGA[0]=='ORD_TYPE')
						{
							compDesc="Order Type";
							compSize="4";
						}else if(splitWithGA[0]=='BY_YR')
						{
							compDesc="By Year(YYYY) ";
							compSize="4";
						}else if(splitWithGA[0]=='BY_YR_JUL')
						{
							compDesc="By Year and Julian Date";
							compSize="8";
						}else if(splitWithGA[0]=='CONST')
						{							
							runSeqCode = splitWithGA[1];	
							compSize=splitWithGA[1].length;
						}
						
						if (runSeqCode != "" && splitWithGA[0]=="RUN_SEQ"){										
							 value=j+"|"+'['+compDesc+']$'+runSeqCode;				
						}else if (splitWithGA[0]=="CONST"){
							 value=j+"|"+runSeqCode;	
							
						}else
							 value=j+"|"+'['+compDesc+']';		
						 
						// value=t+"|"+'['+splitWithGA[0]+']';
						 parent.parent.frameSpecFrmtLst.a[j]=value;
						 parent.parent.frameSpecFrmtLst.b[j]=splitWithGA[0];
						 parent.parent.frameSpecFrmtLst.c[j]=compSize;					
						 t++;
						 parent.parent.frameSpecFrmtLst.i =parent.parent.frameSpecFrmtLst.i +1;					
					}				
				}
				else
				 {
					if(element=='DATE_2YMD')
					{
						compDesc="Date (YYMMDD)";
						compSize="6";
					}
					else if(element=='SPEC_TYPE')
					{
						compDesc="Specimen Type";
						compSize="4";
					}
					else if(element=='DATE_4YMD')
					{
						compDesc="Date (YYYYMMDD)";
						compSize="8";
					}
					else if(element=='RUN_SEQ')
					{										
						compDesc="Running Serial No";
						compSize="10";
					}else if(element=='ORD_TYPE')
					{
						compDesc="Order Type";
						compSize="4";
					}else if(element=='BY_YR')
					{
						compDesc="By Year(YYYY) ";
						compSize="4";
					}else if(element=='BY_YR_JUL')
					{
						compDesc="By Year and Julian Date";
						compSize="8";
					}				
				 value=j+"|"+compDesc; 
				 parent.parent.frameSpecFrmtLst.a[j]=value;
				 parent.parent.frameSpecFrmtLst.b[j]=element;
				 parent.parent.frameSpecFrmtLst.c[j]=compSize;
				parent.parent.frameSpecFrmtLst.i =parent.parent.frameSpecFrmtLst.i +1;
				}
			}
		}

	//}
}

function loadDefault()
{
	var spec_no_frmt_code = parent.parent.frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_frmt_code.value;
	var description = parent.parent.frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.description.value;
	var mode = parent.parent.frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.mode.value;

	parent.parent.frameSpecFmtConstMain.frameSpecFmtConst.location.href ='../../eOR/jsp/ORSpecimenNoFormatConst.jsp?spec_no_frmt_code='+spec_no_frmt_code+'&description='+description+'&mode='+mode;	
}
function retainListValue(obj)
{	
	var arrVal=obj.name;		
	if(arrVal != undefined && obj.value != "")
	{		
		var spli=arrVal.split('|');
		var val=spli[0];										
		parent.parent.frameSpecFrmtLst.a[val]=val+"|[Running Serial No]$"+obj.value			
        var hdnObj = eval(document.getElementById("f_size"+val));
		hdnObj.value = obj.value.length;		
		parent.parent.frameSpecFrmtLst.c[val]=obj.value.length;		
		parent.parent.frameSpecFrmtLst.b[j] ="RUN_SEQ";
	}		
}


function displayValues(spec_no_format){		
	if (spec_no_format != undefined && spec_no_format != "")
	{	
		loadSpeciFormat(spec_no_format);		
	}
	
	if (parent.parent.frameSpecFrmtLst.i !=0){				
			document.getElementById("rese").disabled			= false;
			document.getElementById("remov").disabled			= false;
			document.getElementById("replaceOpt").disabled	= false;
			document.getElementById("replaceRigOpt").disabled = false;
			document.getElementById("replaceRigOpt").checked  = true;
			document.getElementById("replaceLefOpt").disabled = false;
		}	
		HTMLtext='';
		var seqList = parent.parent.frameSpecFrmtLst.document.speciFmtLst.seqList.value;
		for(j=1;j<=parent.parent.frameSpecFrmtLst.i ;j++){
			
			var arrVal=parent.parent.frameSpecFrmtLst.a[j];				
			var arrVal1=parent.parent.frameSpecFrmtLst.b[j];				
			var arrVal2=parent.parent.frameSpecFrmtLst.c[j];				
			var listName = "";
			var listVal = "";
			var seqList1 = "";
			var selectOption = "";
			var seqFrmt = "0";
			if(arrVal!=undefined)
			{	
				var spli=arrVal.split('|');
				var val=spli[1];				
				//2|[Running Serial No]$2
				if (val.length > 18 && val.substring(0,19) == "[Running Serial No]")
				{
					if (val.indexOf("$") > 0)
					{
						var val1=val.split('$');	
						listVal = val1[1];
						listName = parent.parent.frameSpecFrmtLst.a[j].substring(0,21);						
					}else{
						listName = parent.parent.frameSpecFrmtLst.a[j];
					}
					HTMLtext=HTMLtext+" <select id=text"+j+" name="+listName+" onBlur='catchValue(this);' onChange='retainListValue(this)'>";
					HTMLtext=HTMLtext+" <option value=''>--select--</option>";
					if (seqList != undefined && seqList != "")
					{
						seqList1 = seqList.split("|")
						for (var k=0;k<seqList1.length ;k++ )
						{
							var seqList2 = seqList1[k].split("~");
							if (seqList2[2] == listVal){
								selectOption = "selected";
								seqFrmt=seqList2[0]; 								
							}else{
								selectOption = "";								
							}

							HTMLtext=HTMLtext+" <option value='"+seqList2[2]+"' "+selectOption+">"+seqList2[1]+"</option>";
						}
					}								
					HTMLtext=HTMLtext+" </select>";										
					HTMLtext=HTMLtext+" <input type='hidden' name='f_size"+j+"' id='f_size"+j+"' value='"+seqFrmt+ "'>";
					
				}else{
				HTMLtext=HTMLtext+" <input type=text id=text"+j+" name="+parent.parent.frameSpecFrmtLst.a[j]+" value='"+val + "' onClick='selectValue(this);' onBlur='catchValue(this);' readonly size="+val.length+">";				
				HTMLtext=HTMLtext+" <input type='hidden' name='f_size"+j+"' id='f_size"+j+"' value='"+parent.parent.frameSpecFrmtLst.c[j] + "'>";
				}
				HTMLtext=HTMLtext+" <input type='hidden' name='f_code"+j+"' id='f_code"+j+"' value='"+parent.parent.frameSpecFrmtLst.b[j] + "'>";
				
			}
			//alert(" Inside ORSpecimenFmt JS 279 HTMLtext : "+HTMLtext);
		}		
		
		document.getElementById("f").insertAdjacentHTML("beforeend",HTMLtext);
		var o=eval(document.getElementById("text"+parent.parent.frameSpecFrmtLst.ii));
		if(!o){
			var o=eval(document.getElementById("text"+parent.parent.frameSpecFrmtLst.i));
		}
		if(o){			
			if (o.type != "select-one")
			{
				o.select();		
				o.style.background = 'yellow' ; 
				o.style.color = 'black' ;
			}else{
				o.focus();
			}			
			
		}
		else return false;
	//}
}


function catchValue(obj)	
{
	remVal=obj.name;		
	rem=obj.id;	
	if (obj.type != "select-one")
	{
		obj.style.background = 'yellow' ;  
		obj.style.color = 'black' ; 	
	}
	
}

function selectValue(obj)
{	
	if(rem!=undefined)
	{
		/*var a=eval('document.all.'+rem+'.style.background="white"'); 
		var a=eval('document.all.'+rem+'.style.color="black"');  */
        var a=document.getElementById(rem).style.background = "white";
        var a=document.getElementById(rem).style.color = "black";		
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
		parent.parent.frameSpecFrmtLst.i= parent.parent.frameSpecFrmtLst.i-1;
	}
	else
	{
		var spli=remVal.split('|');
		var index=spli[0];
		var ope=spli[1];
		for(j=1;j<=parent.parent.frameSpecFrmtLst.i;j++)
		{
			if (index==j)
			{
				for(k=j;k<parent.parent.frameSpecFrmtLst.i;k++)
				{
					var arrVal=parent.parent.frameSpecFrmtLst.a[k+1];
					var arrVal1=parent.parent.frameSpecFrmtLst.b[k+1];
					var arrVal2=parent.parent.frameSpecFrmtLst.c[k+1];
					var spli=arrVal.split('|');
					var val=spli[1];
					var value=k+'|'+val;
					parent.parent.frameSpecFrmtLst.a[k]=value; 
					parent.parent.frameSpecFrmtLst.b[k]=arrVal1; 
					parent.parent.frameSpecFrmtLst.c[k]=arrVal2; 
				}
				break;
			}
		}
		parent.parent.frameSpecFrmtLst.i=parent.parent.frameSpecFrmtLst.i-1;
	}
	loadDefault();
}

function newTextVal(obj,obj1,obj2)
{
		if(document.getElementById("replaceOpt").checked)
		{			
			if (remVal != undefined)
			{
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var value=index+"|"+obj1;
				var value1=obj;
				var value2=obj2;
				parent.parent.frameSpecFrmtLst.a[index]=value;
				parent.parent.frameSpecFrmtLst.b[index]=value1;
				parent.parent.frameSpecFrmtLst.c[index]=value2;
				parent.parent.frameSpecFrmtLst.ii=index;
			}
		}else if(document.getElementById("replaceRigOpt").checked)
		{	
			parent.parent.frameSpecFrmtLst.i = parent.parent.frameSpecFrmtLst.i+1;	
			if (remVal != undefined)
			{	
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];				
				index=parseInt(index)+1;
				insVal=index+"|"+obj1;								
				insVal1=obj;								
				insVal2=obj2;								
				for(k=parent.parent.frameSpecFrmtLst.i;index<k;k--)
				{				
					var arrVal=parent.parent.frameSpecFrmtLst.a[k-1];								
					var arrVal1=parent.parent.frameSpecFrmtLst.b[k-1];								
					var arrVal2=parent.parent.frameSpecFrmtLst.c[k-1];								
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;					
					parent.parent.frameSpecFrmtLst.a[k]=value;
					parent.parent.frameSpecFrmtLst.b[k]=arrVal1;
					parent.parent.frameSpecFrmtLst.c[k]=arrVal2;
				}				
				parent.parent.frameSpecFrmtLst.a[index]=insVal;				
				parent.parent.frameSpecFrmtLst.b[index]=insVal1;				
				parent.parent.frameSpecFrmtLst.c[index]=insVal2;				
				parent.parent.frameSpecFrmtLst.ii=index; 
			}else{							
				parent.parent.frameSpecFrmtLst.a[1]='1|'+obj1;
				parent.parent.frameSpecFrmtLst.b[1]=obj;
				parent.parent.frameSpecFrmtLst.c[1]=obj2;
				parent.parent.frameSpecFrmtLst.ii=0; 
				
			}

		}else if(document.getElementById("replaceLefOpt").checked)
		{			
			parent.parent.frameSpecFrmtLst.i=parent.parent.frameSpecFrmtLst.i+1;

			if (remVal != undefined)
			{			
				var spli=remVal.split('|');
				var index=spli[0];
				var opeval=spli[1];
				var insVal=index+"|"+obj1;
				var insVal1=obj;
				var insVal2=obj2;
				for(k=parent.parent.frameSpecFrmtLst.i;index<k;k--)
				{
					var arrVal=parent.parent.frameSpecFrmtLst.a[k-1];
					var arrVal1=parent.parent.frameSpecFrmtLst.b[k-1];
					var arrVal2=parent.parent.frameSpecFrmtLst.c[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.frameSpecFrmtLst.a[k]=value;
					parent.parent.frameSpecFrmtLst.b[k]=arrVal1;
					parent.parent.frameSpecFrmtLst.c[k]=arrVal2;
				}
				parent.parent.frameSpecFrmtLst.a[index]=insVal;
				parent.parent.frameSpecFrmtLst.b[index]=insVal1;
				parent.parent.frameSpecFrmtLst.c[index]=insVal2;
				parent.parent.frameSpecFrmtLst.ii=index; 
			}else{
				parent.parent.frameSpecFrmtLst.a[1]='1|'+obj1;					
				parent.parent.frameSpecFrmtLst.b[1]=obj;					
				parent.parent.frameSpecFrmtLst.c[1]=obj2;					
				parent.parent.frameSpecFrmtLst.ii=0; 			
				
			}
		}else
		{			
			parent.parent.frameSpecFrmtLst.i=parent.parent.frameSpecFrmtLst.i+1;
			obj1=parent.parent.frameSpecFrmtLst.i+"|"+obj1;
			obj=parent.parent.frameSpecFrmtLst.i+""+obj;
			obj2=parent.parent.frameSpecFrmtLst.i+""+obj2;
			parent.parent.frameSpecFrmtLst.a[parent.parent.frameSpecFrmtLst.i]=obj1;
			parent.parent.frameSpecFrmtLst.b[parent.parent.frameSpecFrmtLst.i]=obj;
			parent.parent.frameSpecFrmtLst.c[parent.parent.frameSpecFrmtLst.i]=obj2;
			parent.parent.frameSpecFrmtLst.ii=parent.parent.frameSpecFrmtLst.i; 
		}
		loadDefault();
}

function newTextInt(obj){
	
	if(obj.value == null || obj.value=='')
	{
		var msg = getMessage("CA_SEC_FORMULA_VAL","CA");
		alert(msg);
		return false;
	}
		if(document.getElementById("replaceOpt").checked)
		{
			var spli=remVal.split('|');
			var index=spli[0];
			var ope=spli[1];
			var value=index+"|"+obj.value;
			
			parent.parent.frameSpecFrmtLst.a[index]=value;
			parent.parent.frameSpecFrmtLst.b[index]="CONST";
			parent.parent.frameSpecFrmtLst.c[index]=obj.value.length;
			parent.parent.frameSpecFrmtLst.ii=index; //
	}else if(document.getElementById("replaceRigOpt").checked)
	{
			parent.parent.frameSpecFrmtLst.i=parent.parent.frameSpecFrmtLst.i+1;
			if (remVal != undefined)
		   {
				var spli=remVal.split('|');
				var index=spli[0];
				var ope=spli[1];
				index=parseInt(index)+1;
				var insVal=index+"|"+obj.value;
				
				for(k=parent.parent.frameSpecFrmtLst.i;index<k;k--)
				{
					var arrVal=parent.parent.frameSpecFrmtLst.a[k-1];
					var arrVal1=parent.parent.frameSpecFrmtLst.b[k-1];
					var arrVal2=parent.parent.frameSpecFrmtLst.c[k-1];
					var spl=arrVal.split('|');
					var val=spl[1];
					var value=(k)+'|'+val;
					parent.parent.frameSpecFrmtLst.a[k]=value; 
					parent.parent.frameSpecFrmtLst.b[k]=arrVal1; 
					parent.parent.frameSpecFrmtLst.c[k]=arrVal2; 
				}
				parent.parent.frameSpecFrmtLst.a[index]=insVal;
				parent.parent.frameSpecFrmtLst.b[index]="CONST"; 
				parent.parent.frameSpecFrmtLst.c[index]=obj.value.length; 
				parent.parent.frameSpecFrmtLst.ii=index; //

		   }
			else
			{
				
				parent.parent.frameSpecFrmtLst.a[1]='1|'+obj.value;
				parent.parent.frameSpecFrmtLst.b[1]="CONST"; 
				parent.parent.frameSpecFrmtLst.c[1]=obj.value.length;
				parent.parent.frameSpecFrmtLst.ii=0; 						
			}
			
	}else if(document.getElementById("replaceLefOpt").checked)
		{ 
			parent.parent.frameSpecFrmtLst.i=parent.parent.frameSpecFrmtLst.i+1;
			if (remVal != undefined)
		{
			var spli=remVal.split('|');
			var index=spli[0];
			var val=spli[1];
			var insVal=index+"|"+obj.value;
			for(k=parent.parent.frameSpecFrmtLst.i;index<k;k--)
			{
				
				var arrVal=parent.parent.frameSpecFrmtLst.a[k-1];
				var spl=arrVal.split('|');
				var val=spl[1];
				var value=(k)+'|'+val;
				parent.parent.frameSpecFrmtLst.a[k]=value; 
				parent.parent.frameSpecFrmtLst.b[k]=parent.parent.frameSpecFrmtLst.b[k-1]; 
				parent.parent.frameSpecFrmtLst.c[k]=parent.parent.frameSpecFrmtLst.c[k-1]; 
			}
			
			parent.parent.frameSpecFrmtLst.a[index]=insVal;
			parent.parent.frameSpecFrmtLst.b[index]="CONST";
			parent.parent.frameSpecFrmtLst.c[index]=obj.value.length; 
			parent.parent.frameSpecFrmtLst.ii=index; //
		}
		else
			{
				parent.parent.frameSpecFrmtLst.a[1]='1|'+obj.value;
				parent.parent.frameSpecFrmtLst.b[1]="CONST";
				parent.parent.frameSpecFrmtLst.c[1]=obj.value.length; 
				parent.parent.frameSpecFrmtLst.ii=0; 							
			}
	}else{
			parent.parent.frameSpecFrmtLst.i=parent.parent.frameSpecFrmtLst.i+1;
			var value=parent.parent.frameSpecFrmtLst.i+"|"+obj.value;
			parent.parent.frameSpecFrmtLst.a[parent.parent.frameSpecFrmtLst.i]=value;
			parent.parent.frameSpecFrmtLst.b[parent.parent.frameSpecFrmtLst.i]="CONST";
			parent.parent.frameSpecFrmtLst.c[parent.parent.frameSpecFrmtLst.i]=obj.value.length;
			parent.parent.frameSpecFrmtLst.ii=parent.parent.frameSpecFrmtLst.i; //
	}
	loadDefault();
  //}
}

function onReset(){
	var retVal = "";
	retVal=confirm(getMessage("RESET_DOC_REF_STR","CA"));
	if (retVal==true){		
		parent.parent.frameSpecFrmtLst.i=0;
	    parent.parent.frameSpecFrmtLst.location.href='../../eOR/jsp/ORSpecimenNoFormatList.jsp';
	    parent.parent.frameSpecFmtConstMain.location.href='../../eOR/jsp/ORSpecimenNoFormatConstMain.jsp';
	}else{
		return false;
	}
}

function dummy()
{
	parent.frameSpecFmtConstMain.frameSpecFmtConst.location.href = '../../eOR/jsp/ORSpecimenNoFormatConst.jsp';
}
function clearVal()
{
	document.forms[0].constVal.value='';
}

/*function apply()
{		
	var fields = new Array (frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_frmt_code,frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.description);

	var names = new Array (getLabel("Common.code.label",'common'),getLabel("Common.description.label",'common'));

	if(checkFieldsofMst( fields, names, messageFrame))
	{
		var textCount = frameSpecFrmtLst.i;
	    var tempText;
	    var tempTextValue = "";
	    var tempTextSize = 0;
	    for(var v=1;v<=parseInt(textCount,10);v++)
		{
			if (frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("text")+v != null)
			{	
				
				tempText = frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("text")+v.value;	
alert("	tempText value :"+tempText);			
				tempObj = frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("text")+v;
			
				tempCode = frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("f_code")+v.value;
				tempSize = frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("f_size")+v.value;
				
				tempTextSize = tempTextSize+parseInt(tempSize);
				
				if(tempTextValue == "")
				{
					
					if(tempText.indexOf('[')==-1)
					{
						
						if (tempObj.type=="select-one")					{	
							tempCode=tempCode+'|'+tempText;							
						}else if (tempCode=="CONST")	
							tempCode=tempCode+'|'+tempText;
						else{														
							tempCode=tempCode;
						}
					}
					tempTextValue = tempCode;
					tempTextValue = tempTextValue.replace('[',"");
					tempTextValue = tempTextValue.replace(']',"");
				}
				else
				{
					if(tempText.indexOf('[')==-1)
					{
						
						if (tempObj.type=="select-one")		{				
							tempCode=tempCode+'|'+tempText;							
					}else if (tempCode=="CONST")	
							tempCode=tempCode+'|'+tempText;
						else{							
							tempCode=tempCode;
							
							}	
					}
					
					tempTextValue = tempTextValue +"$"+ tempCode;
					tempTextValue = tempTextValue.replace('[',"");
					tempTextValue = tempTextValue.replace(']',"");
				}
           }
		   
		}
		
		if(tempTextValue.length <= 0)
		{
			var labelVal = getLabel("eOR.SpecimenNoFormat.label",'OR');
			var msg = getMessage("CAN_NOT_BE_BLANK","common");
			msg = msg.replace('$',labelVal);			
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0';
		}
		else if(parseInt(tempTextSize) >15)
		{
			var labelVal = getLabel("eOR.SpecimenNoFormat.label",'OR')
			var msg = getMessage("REMARKS_CANNOT_EXCEED","common");
			msg = msg.replace('$',labelVal);
			msg = msg.replace('#',15);
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+msg+'&err_value=0';
		}
		else
		{								
			
			frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_format.value = tempTextValue;
		//	frameSpecFmtConst.document.SpecFmtConstFrm.document_type.value = frameDocRefFmtHeader.document.DocRefFmtHdrfrm.document_type.value; 
			frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_frmt_code.disabled=false;
			frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.action='../../servlet/eOR.SpecimenNoFmtServlet';
		    frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.target='messageFrame';
			frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.method='post';
			frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.submit();
		}
	}		
}
*/
function apply() {		//added by Anbarasi
    var fields = new Array(
        frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_frmt_code,
        frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.description
    );

    var names = new Array(
        getLabel("Common.code.label", 'common'),
        getLabel("Common.description.label", 'common')
    );

    if (checkFieldsofMst(fields, names, messageFrame)) {
        var textCount = frameSpecFrmtLst.i;
        var tempText;
        var tempTextValue = "";
        var tempTextSize = 0;

        for (var v = 1; v <= parseInt(textCount, 10); v++) {
            var tempObj = frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("text" + v);
            if (tempObj != null) {	
                tempText = tempObj.value || ''; // Ensure tempText is a valid string
                //alert("tempText value :" + tempText);			
                
                var tempCode = frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("f_code" + v).value;
                var tempSize = frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById("f_size" + v).value;
                
                tempTextSize += parseInt(tempSize);
                
                if (tempTextValue == "") {
                    if (tempText.indexOf('[') == -1) {
                        if (tempObj.type == "select-one" || tempCode == "CONST") {
                            tempCode = tempCode + '|' + tempText;							
                        }
                    }
                    tempTextValue = tempCode;
                    tempTextValue = tempTextValue.replace('[', "").replace(']', "");
                } else {
                    if (tempText.indexOf('[') == -1) {
                        if (tempObj.type == "select-one" || tempCode == "CONST") {
                            tempCode = tempCode + '|' + tempText;							
                        }
                    }
                    tempTextValue = tempTextValue + "$" + tempCode;
                    tempTextValue = tempTextValue.replace('[', "").replace(']', "");
                }
            }
        }

        if (tempTextValue.length <= 0) {
            var labelVal = getLabel("eOR.SpecimenNoFormat.label", 'OR');
            var msg = getMessage("CAN_NOT_BE_BLANK", "common");
            msg = msg.replace('$', labelVal);			
            messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=' + msg + '&err_value=0';
        } else if (parseInt(tempTextSize) > 15) {
            var labelVal = getLabel("eOR.SpecimenNoFormat.label", 'OR');
            var msg = getMessage("REMARKS_CANNOT_EXCEED", "common");
            msg = msg.replace('$', labelVal).replace('#', 15);
            messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=' + msg + '&err_value=0';
        } else {								
            frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_format.value = tempTextValue;
            frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_frmt_code.disabled = false;
            frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.action = '../../servlet/eOR.SpecimenNoFmtServlet';
            frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.target = 'messageFrame';
            frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.method = 'post';
            frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.submit();
        }
    }
}


function reset()
{		
		frameSpecFrmtLst.location.href = '../../eOR/jsp/ORSpecimenNoFormatList.jsp';
		frameSpecFmtConstMain.frameSpecFmtConst.location.href = '../../eOR/jsp/ORSpecimenNoFormatConst.jsp';	
		frameSpecFmtConstMain.frameSpecFmtResult.location.href = '../../eOR/jsp/ORSpecimenNoFormatResults.jsp';	
/*		frameSpecFmtConstMain.frameSpecFmtConst.document.getElementById('f').innerHTML = "";	
		frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_frmt_code.disabled = false;	
		frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.spec_no_frmt_code.value = "";	
		frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.description.value = "";	
		frameSpecFrmtLst.ii=0;
		frameSpecFrmtLst.i=0;	
		frameSpecFrmtLst.a=new Array();		
		frameSpecFrmtLst.c=new Array();			
		frameSpecFrmtLst.b =new Array();		*/
		
		//frameSpecFmtConstMain.frameSpecFmtConst.document.SpecFmtConstFrm.reset();	
}

function onSuccess()
{	
	frameSpecFrmtLst.location.href = '../../eOR/jsp/ORSpecimenNoFormatList.jsp';
	frameSpecFmtConstMain.frameSpecFmtConst.location.href = '../../eOR/jsp/ORSpecimenNoFormatConst.jsp';
	frameSpecFmtConstMain.frameSpecFmtResult.location.href = '../../eOR/jsp/ORSpecimenNoFormatResults.jsp';
}

function loadSpecimenFormat(spec_no_frmt_code, description, spec_no_format,mode)
{
	parent.parent.frameSpecFrmtLst.ii=0;
	parent.parent.frameSpecFrmtLst.i=0;	
	
	parent.parent.frameSpecFmtConstMain.frameSpecFmtConst.location.href ='../../eOR/jsp/ORSpecimenNoFormatConst.jsp?spec_no_frmt_code='+spec_no_frmt_code+'&description='+description+'&spec_no_format='+spec_no_format+'&mode='+mode;	
}
function CheckSpecialChars(Obj){
        var str = Obj.value;       
		var strCheck = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_- "
	;
        for (u=0;u<str.length;u++){
            if (((str.charCodeAt(u)>=48) && (str.charCodeAt(u)<=57))||((str.charCodeAt(u)>=65) && (str.charCodeAt(u)<=90))||((str.charCodeAt(u)>=97) && (str.charCodeAt(u)<=122))||(str.charCodeAt(u)==95)||(str.charCodeAt(u)==45)||(str.charCodeAt(u)==32));
            else{      
				msg = getMessage("CANNOT_BE_SPECIAL_CHAR","COMMON");
				alert(msg+" Other than -_");
				Obj.focus();
                return false;
            }
        }        
    }

	function allowAlphaNumeric(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_- ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	return true ;
}

