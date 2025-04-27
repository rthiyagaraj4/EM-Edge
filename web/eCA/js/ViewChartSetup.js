function resetValues()
{
	parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
}
function create(){
	viewChartHeaderFrame.document.location.href='../../eCA/jsp/ViewChartHeader.jsp';
	viewChartListFrame.location.href = '../../eCA/jsp/blank.jsp';
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
}
function apply(){
	if(viewChartListFrame.document.ViewChartComponentListForm!=null){		
		var noOfRows = parseInt(viewChartListFrame.document.ViewChartComponentListForm.noOfRows.value);	
		if(noOfRows==0){
			var errorMsg = getMessage("CHART_CANNOT_BLANK","CA");
			messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
		}else{
			var i=0;
			var errResult="";
			for(i=0;i < noOfRows ;i++){				
				var format = eval("viewChartListFrame.document.ViewChartComponentListForm.r"+i+"format");				
				var rowId = 'r'+i;
				var desMes = viewChartListFrame.document.getElementById(rowId+'t3').innerHTML;
				
				//if(format.value == ""){
				//	errResult=errResult+"\n"+"Select "+desMes+" Chart Component Foramt[Graph or Table].";
					//format.select();
					//break;
				//}		
				if(format.value == "G"){
					var disOrder = eval("viewChartListFrame.document.ViewChartComponentListForm.r"+i+"DisOrder");				
					if(trimString(disOrder.value)==""){
						errResult=errResult+"\n"+"Enter Display Order Value for "+desMes+".";
					}
					var xScal =  eval("viewChartListFrame.document.ViewChartComponentListForm.r"+i+"t6XS");
					var yScal =  eval("viewChartListFrame.document.ViewChartComponentListForm.r"+i+"t7YS");
					var minY =  eval("viewChartListFrame.document.ViewChartComponentListForm.r"+i+"t8minY");
					var maxY =  eval("viewChartListFrame.document.ViewChartComponentListForm.r"+i+"t9maxY");
					
					if(xScal.value==""){
						errResult=errResult+"\n"+"Enter  X Scale Value for "+desMes+".";						
					}
					if(yScal.value==""){
						errResult=errResult+"\n"+"Enter Y Scale Value for "+desMes+".";						
					}
					if(minY.value==""){
						errResult=errResult+"\n"+"Enter Min Y Value for "+desMes+".";						
					}
					if(maxY.value==""){
						errResult=errResult+"\n"+"Enter Max Y Value for "+desMes+".";						
					}
					
				}else if (format.value == "T"){
					var disOrder = eval("viewChartListFrame.document.ViewChartComponentListForm.r"+i+"DisOrder");				
					if(trimString(disOrder.value)==""){
						errResult=errResult+"\n"+"Enter Display Order Value for "+desMes+".";
					}

				}
			}
			if(errResult!=""){
					alert(errResult);
					messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
			}else{
				viewChartListFrame.document.ViewChartComponentListForm.action='../../servlet/eCA.ViewChartSetupServlet';
				viewChartListFrame.document.ViewChartComponentListForm.target='messageFrame';
				viewChartListFrame.document.ViewChartComponentListForm.method='post';
				viewChartListFrame.document.ViewChartComponentListForm.submit();
			}
		}
	}else { messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0'; 
		return false; 
	}
}
function onSuccess(){
	viewChartHeaderFrame.location.href = '../../eCA/jsp/ViewChartHeader.jsp';
	viewChartListFrame.location.href = '../../eCA/jsp/blank.jsp';
}

async function callFunction(sql,title,target)
{
	//alert(sql);
	var serviceVal   ="";
	var search_desc	= "";
	var argArray = new Array();
	var namesArray = new Array();
	var valuesArray = new Array();
	var datatypesArray = new Array();
	argArray[0] = sql;
	argArray[1] = namesArray;
	argArray[2] = valuesArray;
	argArray[3] = datatypesArray;
	argArray[4] = "1,2";
	argArray[5] = trimString(target.value);
	argArray[6] = DESC_LINK;
	argArray[7] = CODE_DESC;
	retArray = await CommonLookup(title, argArray);
	return retArray;
 }


function getChartCode(objCode)
{
	if(objCode.name=='chartDesc')
	{
		if((objCode.value) == "null" || (objCode.value ==""))
		{
				return false;			
		}
		else
		{
			chartCode(objCode);
		}
	}
	else if(objCode.name=='cmnlookupChart')
	{
		chartCode(objCode);
	}
}
function chartCode(objCode)
{	
		var chart = objCode.value;
		parent.messageFrame.location.href = '../../eCommon/jsp/MstCodeError.jsp';
		var HtmlVal = "<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></head><script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><body onKeyDown='lockKey()' class=MESSAGE><form name='tempformforlookup' id='tempformforlookup' method='post' action='ViewChartIntermediate.jsp'><input type=hidden name='chartCode' id='chartCode' value='"+chart+"'></form></body></html>";
		parent.blankFrame.document.write(HtmlVal);
		parent.blankFrame.document.tempformforlookup.submit();
	
}

function dispDesc()
{
	
	if(document.ViewChartHeaderForm.viewChartSearch.value!=""){
		var searchChId = document.ViewChartHeaderForm.viewChartSearch.value;

		parent.viewChartListFrame.document.location.href = '../../eCA/jsp/ViewChartComponentList.jsp?viewChartSearch='+searchChId;
		parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num=';
	}
	else{
		var errorMsg = getMessage("CHART_CANNOT_BLANK","CA");
		parent.viewChartListFrame.document.location.href = '../../eCommon/html/blank.html';
		parent.messageFrame.document.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+errorMsg;
	}
}

