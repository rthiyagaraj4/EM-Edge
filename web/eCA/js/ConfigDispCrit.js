
function create()
{
	ConfigDispCritHdr.location.href='../../eCA/jsp/ConfigDispCritHdr.jsp';
	ConfigDispCritList.location.href="../../eCommon/html/blank.html";
}

function apply()
{	
	if( ConfigDispCritHdr.document.formConfigDispFlds != null)
	{
		var resultLnkType = ConfigDispCritHdr.document.formConfigDispFlds.resultLnkType.value;
		
		if(resultLnkType != '' && resultLnkType != null)
		{
			var apl = ConfigDispCritHdr.document.formConfigDispFlds.applicable.value;
			if(apl == 'NA')
			{
				var check = window.confirm(getMessage("CONFIRM_DEFAULT_YN","CA"));
				if(check)
				{
					ConfigDispCritHdr.document.formConfigDispFlds.submit();
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
			else if(apl == 'A')
			{
				ConfigDispCritHdr.document.formConfigDispFlds.submit();
			}
			ConfigDispCritHdr.location.href='../../eCA/jsp/ConfigDispCritHdr.jsp';
			ConfigDispCritList.location.href="../../eCommon/html/blank.html";
		}
		else
		{
			var msg = getMessage("CAN_NOT_BE_BLANK","COMMON");
			msg = msg.replace("$", getLabel("eCA.ResultCategory.label",'CA'));
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
			return false;
		}	
	}
	else
	{
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		return false;
	}
}


function reset()
{
	ConfigDispCritHdr.location.reload();
	ConfigDispCritList.location.href="../../eCommon/html/blank.html";
}
function changeColor(cnt, obj, rowCount)
{	
	var firstValue = document.formConfigDispFlds.firstPos.value;
	var resCategory = document.formConfigDispFlds.resCategoryKey.value;
	var mode = document.formConfigDispFlds.mode.value;
	var rCount = parseInt(rowCount);


	if( firstValue == "")
	{
		//var temp = document.getElementById("tblResultLinked").rows(rCount).cells.length;
		var temp = eval(document.getElementById("numRows"+rowCount));
		var temp1 = temp.cells.length;

		if(firstValue == "")
		{
			for(var i=0;i<temp1;i++)
			{
				temp.cells[i].className = 'FIRSTSELECTED';
			}
		}
		document.formConfigDispFlds.firstPos.value = cnt;
	}
	else if(resCategory == 'FEVT' &&  firstValue != cnt)
	{
		var sql = "SELECT RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, FIELD_REF_DESC,DEFAULT_ORDER_SEQ, MANDATORY_YN FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=? ORDER BY DEFAULT_ORDER_SEQ";
		parent.ConfigDispCritList.location.href="../../eCA/jsp/ConfigDispCritList.jsp?resCategory="+resCategory+"&pos1="+firstValue+"&pos2="+cnt+"&strSql="+sql+"&resSubCategory="+obj+"&mode="+mode+"&pageReload=reload";
	
	}
	else if(firstValue != cnt)
	{
		parent.ConfigDispCritList.location.href="../../eCA/jsp/ConfigDispCritList.jsp?resCategory="+obj+"&mode="+mode+"&pos1="+firstValue+"&pos2="+cnt+"&pageReload=reload";
	}
}

function displayCongifDispFlds(obj)
{
		if(obj.value !='' && obj.value != null)
		{
			if(obj.value == 'FEVT')
			{
				document.getElementById('tdResultLinkedSub').style.display ='inline';
				document.getElementById('mhdTdResultLinkedSub').style.display ='none';//Added for ML-MMOH-CRF-1759
				document.getElementById('listResultLinkedSub').selectedIndex = 0;
		//		document.getElementById('listResultLinkedSub').style.display ='inline';
				parent.ConfigDispCritList.location.href="../../eCommon/html/blank.html";	
			}
			else if(obj.value == 'MHD'){//Added for ML-MMOH-CRF-1759 Start
				document.getElementById('mhdTdResultLinkedSub').style.display ='inline';
				document.getElementById('tdResultLinkedSub').style.display ='none';
				document.getElementById('mhdListResultLinkedSub').selectedIndex = 0;
				parent.ConfigDispCritList.location.href="../../eCommon/html/blank.html";			
			}//Added for ML-MMOH-CRF-1759 End
			else
			{
				parent.ConfigDispFldsIntermediate.location.href="../../eCA/jsp/ConfigDispFldsIntermediate.jsp?fillBean=filldata&resCategory="+obj.value;
				document.getElementById('tdResultLinkedSub').style.display ='none';
				document.getElementById('mhdTdResultLinkedSub').style.display ='none';//Added for ML-MMOH-CRF-1759
		//		document.getElementById('listResultLinkedSub').style.display ='none';
			}
			parent.messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp';
		}
		else
		{
			parent.ConfigDispCritList.location.href="../../eCommon/html/blank.html";	
		}
}

function checkApplicable(obj)
{
	document.formConfigDispFlds.applicable.value = obj.value;
	if(obj.value == 'A')
	{
		document.getElementById("formConfigDispFlds").resultLnkType.disabled= false;
		document.getElementById("formConfigDispFlds").listResultLinkedSub.disabled= false;
	}
	else
	{
		document.getElementById("formConfigDispFlds").resultLnkType.disabled= true;
		document.getElementById("formConfigDispFlds").listResultLinkedSub.disabled= true;
	}

}

function getSelected(obj)
{
	if(!obj.value=='')
	{
		var sql = "SELECT RESULT_CATEGORY, RESULT_SUB_CATEGORY, FIELD_REF, FIELD_REF_DESC,MANDATORY_YN FROM CA_LINK_CATEG_FIELD_LIST WHERE RESULT_CATEGORY =? AND RESULT_SUB_CATEGORY=? ORDER BY DEFAULT_ORDER_SEQ";
		var resCategory = document.getElementById("resultLnkType").value;
		
		parent.ConfigDispFldsIntermediate.location.href="../../eCA/jsp/ConfigDispFldsIntermediate.jsp?resCategory="+resCategory+"&resSubCategory="+obj.value+"&configStrSql="+sql+"&fillBean=filldata";
	}else
	{
		parent.ConfigDispCritList.location.href="../../eCommon/html/blank.html";		
	}
}


function addSelected(obj, key, cnt)
{
	if(obj.checked == true)
	{
		parent.ConfigDispFldsIntermediate.location.href="../../eCA/jsp/ConfigDispFldsIntermediate.jsp?key="+unescape(key)+"&mode=ADD&fieldCount="+cnt;
	}
	else
	{
		parent.ConfigDispFldsIntermediate.location.href="../../eCA/jsp/ConfigDispFldsIntermediate.jsp?key="+unescape(key)+"&mode=REMOVE";	
	}	
	
}
