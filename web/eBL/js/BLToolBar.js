
var column1RowCount = 2;


/**
 * Adds row to the table based on the column no 1,2 or 3
 * @param columnNo
 */
function addRow()
{
	
	var table = getInfoColumnFrame().document.getElementById('Table_Column_Info');
	var rowCount = table.rows.length;	
	
		
	var rowId= rowCount-1; 
	
	if(getInfoColumnFrame().document.getElementById('Seq_No_'+rowId).value == undefined || getInfoColumnFrame().document.getElementById('Seq_No_'+rowId).value == '')
	{
		alert(getMessage("BL00182","BL"));
		return;
	}
	if(getInfoColumnFrame().document.getElementById('ToolBarFuncName_'+rowId).value == undefined || getInfoColumnFrame().document.getElementById('ToolBarFuncName_'+rowId).value == '')
	{
		alert("Column1 cannot be NULL");
		return;
	}
	
	var row = table.insertRow(rowCount);
	var cell;
	
	
	for(var cellNo= 0; cellNo<=6; cellNo++)
	{
		cell=row.insertCell(cellNo);
		cell.innerHTML = getColumnInnerHTML(rowCount,cellNo);		

	}
	
	var rowCount = getInfoColumnFrame().document.getElementById('rowCount');
	rowCount.value = eval(rowCount.value) + 1;	
	
}

/**
 * Inner HTML data based on the CellNo and Column No 
 * @param columnNo
 * @param index
 * @param cellNo
 * @returns {String}
 */
function getColumnInnerHTML(index,cellNo)
{
	var testInnerHTML = '';
	switch(cellNo)
	{
		case 0:
		{
			testInnerHTML = "<input type='text' name='Seq_No_" + index + "' id='Seq_No_" + index + "' maxlength='3' size='2' value='' " +
					"onKeyPress='return(ChkNumberInput(this,event,\"0\"))' onBlur='numberCheck(this,\"N\",\"<%=mode%>\")'/>";
			break;
		}
		case 1:
		{
			testInnerHTML = "<input type='text' name='ToolBarFuncName_" + index + "' id='ToolBarFuncName_" + index + "' maxlength='30' size='10' value='' onblur='searchInfoDetail(" + index + "," + 1 + ");' /> " ; //+
			break;
		}	
		case 2:
		{
			testInnerHTML = "<input type='text' name='LinkingURL_" + index + "' id='LinkingURL_" + index + "' maxlength='30' size='10' value='' onblur='searchStatLeg(" + index +"," + 1 + ");'/> "  +
					"<input type='hidden' name='newRow_" + index + "' id='newRow_" + index + "' value='Y' />" ;
			break;
		}
		
		case 3:
		{
			testInnerHTML = "<input type='text' name='IconDtl_" + index + "' id='IconDtl_" + index + "' maxlength='30' size='10' value='' onblur='iconCheck(this)'/> "  ;
			break;
		}

		case 4:
		{		
			testInnerHTML = "<input type='checkbox' name='" + index + "' id='" + index + "' value='N' />";
			break;
		}
		
	}
	return testInnerHTML;
}
	

/**
 * Shows the tab based on the tabObj
 * @param tabObj
 * @param tabFrame
 */
function changeMainTabClass(tabObj,tabFrame)
{		
	if(tabFrame.document.forms[0]!=null){
		prevTabObj= tabFrame.document.forms[0].prevTabObj.value;		
		if(prevTabObj!=null && prevTabObj!=""){	
			tabFrame.document.getElementById('prevTabObj')).className="tabA"
				tabFrame.document.getElementById(prevTabObj+"span").className="tabAspan"
			}
			tabFrame.document.getElementById('tabObj')).className="tabClicked"			
			tabFrame.document.getElementById(tabObj+"span").className="tabSpanclicked"
			tabFrame.document.forms[0].prevTabObj.value=tabObj
		}		
	
}

/**
 * Loads the tab detail based on last_link value in BLFrame.jsp
 * @param obj
 */
function showMainTabDetails(obj) 
{	
	link	=	obj;
	last_link = document.forms[0].last_link.value;
	
	var mode = "";
	var formatCode = "";
	var formatDesc = "";
	if(last_link == "TOOLBAR_FORMAT")
	{
		mode = parent.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].mode.value;
		formatCode = parent.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].Format_Code.value;
		formatDesc = parent.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].Format_Description.value;
	}
	else if(last_link == "TOOLBAR_ASSOC")
	{
		mode = parent.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].mode.value;
		formatCode = parent.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].Format_Code.value;
		formatDesc = parent.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].Format_Description.value;
	}
	else if(last_link == "STATIC_INFO")
	{
		mode = parent.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].mode.value;
		formatCode = parent.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].Format_Code.value;
		formatDesc = parent.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].Format_Description.value;
	}
	
	if(link == "TOOLBAR_FORMAT")
	{ 
		changeMainTabClass(link,parent.BLToolBarMainTab)
		
		parent.BLToolBarFmtDtlMainFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?from=TOOLBAR_FORMAT&mode="+mode+"&formatCode="+formatCode+"&formatDesc="+formatDesc;

	}
	else if(link == "TOOLBAR_ASSOC")
	{		
		
		changeMainTabClass(link,parent.BLToolBarMainTab);
		parent.BLToolBarFmtDtlMainFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?from=TOOLBAR_ASSOC&mode="+mode+"&formatCode="+formatCode+"&formatDesc="+formatDesc;
	}
	else if(link=="STATIC_INFO"){	
		
		changeMainTabClass(link,parent.BLToolBarMainTab)
		parent.BLToolBarFmtDtlMainFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?from=STATIC_INFO&mode="+mode+"&formatCode="+formatCode+"&formatDesc="+formatDesc;
		
	}
	document.forms[0].last_link.value = link;
			
}


/**
 * Add a row in the BAnner Association page
 */
function addToolBarAssocRow()
{
		
	var table="";
	var rowCount="";
	
	table = getToolBarAssocFrame().document.getElementById('ToolBar_Assoc_Table');
	rowCount = table.rows.length;
	
	//var row = document.createElement('tr'); // create row node
		
	var rowId= rowCount-1; 
	if(getInfoColumnFrame().document.getElementById('Function_Id_'+rowId).value == undefined || getInfoColumnFrame().document.getElementById('Function_Id_'+rowId).value == '')
	{
		alert(getMessage("BL00791","BL"));
		return;
	}
	if(getInfoColumnFrame().document.getElementById('Rights_Type_'+rowId).value == undefined || getInfoColumnFrame().document.getElementById('Rights_Type_'+rowId).value == '')
	{
		alert(getMessage("BL00789","BL"));
		return;
	}
	if(getInfoColumnFrame().document.getElementById('Right_Code_'+rowId).value == undefined || getInfoColumnFrame().document.getElementById('Right_Code_'+rowId).value == '')
	{
		alert(getMessage("BL00790","BL"));
		return;
	}
	if(getInfoColumnFrame().document.getElementById('Effective_From_'+rowId).value == undefined || getInfoColumnFrame().document.getElementById('Effective_From_'+rowId).value == '')
	{
		alert(getMessage("BL8504","BL"));
		return;
	}
	
	var row = table.insertRow(rowCount);
    
	    	
	for(var cellNo= 0; cellNo<=9; cellNo++)
	{
		cell=row.insertCell(cellNo);
		cell.innerHTML = getInnerHTMLForToolBarAssoc(rowCount,cellNo);
		
	}
	
	var rowCount = getInfoColumnFrame().document.getElementById('rowCount');
	rowCount.value = eval(rowCount.value) + 1;	
	
	populateRightCode(rowCount);
}
/**
 * Returns the Inner HTML value based on the cell no
 * @param index
 * @param cellNo
 * @returns {String}
 */
function getInnerHTMLForToolBarAssoc(index,cellNo)
{
	var testInnerHTML = '';
	var OP = getToolBarAssocFrame().OP;
	var IP = getToolBarAssocFrame().IP;
	var DayCare = getToolBarAssocFrame().DayCare;
	var EM = getToolBarAssocFrame().EM;
	var XT = getToolBarAssocFrame().XT;
	
	switch(cellNo)
	{
		case 0:
		{
			testInnerHTML = "<input type='text' name='Function_Id_" + index + "' id='Function_Id_" + index + "' maxlength='10' size='10' value='' readonly='true' /> &nbsp;"  + 
			"<input type='text' name='Function_Description_" + index + "' id='Function_Description_" + index + "' maxlength='30' size='10' value=''  onblur='searchFunctionId(" + index + ");' /> " +
			"<input class='BUTTON' type='button' name='blGrpSearch' id='blGrpSearch' value='?' onClick='searchFunctionId(" + index + ");'>";
			break;
		}	
		case 1:
		{
			testInnerHTML = "<select name='Rights_Type_" +  index + "' id='Rights_Type_" +  index + "' onchange='javascript:populateRightCode(" + index + ")'><option value='U'>User</option><option value='G'>User Group</option><option value='R'>Responsibility</option></select>";
			break;
		}
		case 2:
		{
			testInnerHTML = "<input type='text' name='Right_Code_" + index + "' id='Right_Code_" + index + "' maxlength='30' size='15' value='' onblur='searchRightCode(" + index + ");' /> " +
							"<input class='BUTTON' type='button' name=blGrpSearch value='?' onClick='searchRightCode(" + index + ");' />";
			break;
		}

		
		case 3:
		{
			testInnerHTML = "<input type='text' name='Effective_From_" + index + "' id='Effective_From_" + index + "' maxlength='30' size='10' value='' readonly='true'/> " +
					"<input type='image' id='eff_from_"  + index + "' src='../../eCommon/images/CommonCalendar.gif' onClick=\"" +
							"return showCalendar('Effective_From_" + index + "');\" />" +
							"<input type='hidden' name='newRow_" + index + "' id='newRow_" + index + "' value='Y' />" ;
			break;
		}
		case 4:
		{
			testInnerHTML = "<input type='text' name='Effective_To_" + index + "' id='Effective_To_" + index + "' maxlength='30' size='10' value='' readonly='true'/> " +
					"<input type='image' id='eff_to_"  + index + "' src='../../eCommon/images/CommonCalendar.gif' onClick=\"" +
							"return showCalendar('Effective_To_" + index + "');\" >"
			break;
		}
		case 5:
		{		
			testInnerHTML = "&nbsp";
			break;
		}
	}
	
	return testInnerHTML;
}

/**
 * Adds row in the static information page
 */
function addStatInfoRow()
{
	var tableID = 'Static_Info_Table';
	
	var table="";
	var rowCount="";
	var index="";
	var row="";
	
	table = document.getElementById('"+tableID+"');
	rowCount = table.rows.length;
	
	//var row = document.createElement('tr'); // create row node
	
	var row = table.insertRow(rowCount);
    
	    	
	for(var cellNo= 0; cellNo<=1; cellNo++)
	{
		cell=row.insertCell(cellNo);
		cell.innerHTML = getInnerHTMLForStatInfo(rowCount,cellNo);
		
	}
}
/**
 * Gets the Inner HTML based on the cell no
 * @param index
 * @param cellNo
 * @returns {String}
 */

function getInnerHTMLForStatInfo(index,cellNo)
{
	var testInnerHTML = '';
	switch(cellNo)
	{
		case 0:
		{
			testInnerHTML = "<input type='text' name='Legend_Code_" + index + "' id='Legend_Code_" + index + "' maxlength='30' size='30' value='' readonly='true'/>";
			break;
		}
		case 1:
		{
			testInnerHTML = "<input type='text' name='Description_" + index + "' id='Description_" + index + "' maxlength='30' size='40' value='' onblur='javascript:setStaticInfoChanged(" + index + ")' />" +
					"<input type='hidden' name='RowChanged_" + index + "' id='RowChanged_" + index + "'value='N' />";
			break;
		}	
		case 2:
		{
			testInnerHTML = "&nbsp";
			break;
		}
	}
	
	return testInnerHTML;
}




/**
 * Look up for  Code in  Assoc
 */

function searchToolBarCode(){
    
	var tit	= " Format";
	
	var format_code=parent.BLToolBarAssoc.document.getElementById('Format_Code');
    var format_desc = parent.BLToolBarAssoc.document.getElementById('Format_Description');

	var sql= TOOLBAR_FMT_LKUP_SQL + " WHERE UPPER(FORMAT_CODE) LIKE UPPER(?) AND UPPER(FORMAT_DESCRIPTION) LIKE UPPER(?)  ORDER BY 1 ";  

 
   callCommonLookup(sql, tit, format_code, format_desc);
   
}// End of search  Code

/**
 * Look up for Function id in  Assoc
 */

function searchFunctionId(fieldIndex){
    
	var tit	= "Function Id";
	
	var format_code=parent.BLToolBarAssoc.document.getElementById('Function_Id_' + fieldIndex);
    var format_desc = parent.BLToolBarAssoc.document.getElementById('Function_Description_' + fieldIndex);

	var sql= FUCNT_LKUP_SQL + " WHERE UPPER(FUNCTION_ID) LIKE UPPER(?) AND UPPER(FUNCTION_NAME) LIKE UPPER(?) AND dev_tool = 'J' AND LANGUAGE_ID = '" + localeName + "' ORDER BY 1 ";

 
   callCommonLookup(sql, tit, format_code, format_desc);
   
}// End of search Function id

/**
 * Look up for Info Detail in  Header
 */

function searchInfoDetail(fieldIndex, columnIndex){
    
	var tit	= "Info details";
	
	var info_code=getInfoColumnFrame().document.getElementById('Info_In_Column' + columnIndex + "_"+ fieldIndex);

	var sql = INFO_LKUP_SQL + " WHERE UPPER(INFO_NAME) LIKE UPPER(?) AND UPPER(INFO_DESCRIPTION) LIKE UPPER(?) ORDER BY 1 ";

 
   callCommonLookup(sql, tit, info_code, null);
   
}// End of search Function id

/**
 * Look up for Static Leagen in  Header
 */

function searchStatLeg(fieldIndex, colIndex){
    
	var tit	= "Static Information";
	var codeId = 'Column' + colIndex + '_Static_Legend_' + fieldIndex;
	
	var format_code=getInfoColumnFrame().document.getElementById(codeId);

	var sql = STAT_LEG_LKUP_SQL + " WHERE UPPER(LEGEND_ID) LIKE UPPER(?) AND UPPER(LEGEND_DESC) LIKE UPPER(?) ORDER BY 1 ";

 
   callCommonLookup(sql, tit, format_code, null);
   
}// End of search Static Legend

/**
 * Look up for Right Code
 */

function searchRightCode(fieldIndex){
    
	var tit	= "Billing Group";
	
	
	var rightType = document.getElementById('Rights_Type_' + fieldIndex).value ;
		
	var rightCode = parent.BLToolBarAssoc.document.getElementById('Right_Code_' + fieldIndex)
	
	var sql= "";
	
	if(rightType == 'U')
	{
		sql = getUserSql();
	}
	else if(rightType == 'G')
	{
		sql = getUserGrpSql();
	}
	else if(rightType == 'R')
	{
		sql = getRespSql();
	}

   callCommonLookup(sql, tit, rightCode, null);
   
}// End of Billing Group

/**
 * Return the Right Code look up SQL when RIGHT TYPE IS U
 * @returns {String}
 */
function getUserSql(){
    
	return USR_LKUP_SQL + " WHERE UPPER(bl_user_id) LIKE UPPER(?) AND UPPER(APPL_USER_NAME) LIKE UPPER(?) AND appl_user_id = bl_user_id AND LANGUAGE_ID = '" + localeName + "' ORDER BY 1 ";
}

/**
 * Return the Right Code look up SQL when RIGHT TYPE IS G
 * @returns {String}
 */
function getUserGrpSql(){
    
	return USR_GRP_LKUP_SQL + " WHERE UPPER(USER_GROUP_ID) LIKE UPPER(?) AND UPPER(SHORT_DESC) LIKE UPPER(?) AND LANGUAGE_ID = '" + localeName + "' ORDER BY 1 ";
}

/**
 * Return the Right Code look up SQL when RIGHT TYPE IS R
 * @returns {String}
 */
function getRespSql(fieldIndex){
    
	return RESP_LKUP_SQL + " WHERE UPPER(RESP_ID) LIKE UPPER(?) AND UPPER(RESP_NAME) LIKE UPPER(?) AND LANGUAGE_ID = '" + localeName + "' AND eff_status = 'E' ORDER BY 1 ";

 
   callCommonLookup(sql, tit, blng_grp_id, blng_grp_desc);
   
}// End of Billing Group

/**
 * Look up method to show the Lookup screen
 * @param sql
 * @param tit
 * @param codeTarget
 * @param descTarget
 */
function callCommonLookup(sql, tit, codeTarget, descTarget)
{

	var tdesc="";
    var tcode="";
	var retVal =new String();
    var argumentArray  = new Array() ;
    var dataNameArray  = new Array() ;
    var dataValueArray = new Array() ;
    var dataTypeArray  = new Array() ;
    
	argumentArray[0] = sql;
    argumentArray[1] = dataNameArray ;
    argumentArray[2] = dataValueArray ;
    argumentArray[3] = dataTypeArray ;
    argumentArray[4] = "1,2";
    if(descTarget == null)
    {
    	argumentArray[5] = codeTarget.value;
    }
    else
    {
    	argumentArray[5] = descTarget.value;
    }
    argumentArray[6] = DESC_LINK  ;
    argumentArray[7] = DESC_CODE ;
	retVal = await CommonLookup( tit, argumentArray );
	
    if(retVal != null && retVal != "" )    {
        var ret1=unescape(retVal);
        arr=ret1.split(",");
        
        tcode=arr[0];
        tdesc=arr[1];
    }
    codeTarget.value=tcode;
    if(descTarget != null)
    {
    	descTarget.value=tdesc;
    }
}

/**
 * Reset the right code value ="" when the right type list box value is changed
 * @param index
 */
function populateRightCode(index)
{
	var rightCode = getToolBarAssocFrame().document.getElementById('Right_Code_' + index);
	
	rightCode.value = "";

}

/**
 * set the RowChanged hidden variable to 'y' when row is changed
 * 
 * @param index
 */
function setStaticInfoChanged(index)
{
	var rowValueChanged = document.getElementById('RowChanged_' + index);
	rowValueChanged.value = 'Y';
}

/**
 * populate the combo values on load of the page
 * @param rightType
 * @param episodeType
 * @param index
 */
function setComboValues(rightType,  index)
{
	if(document.getElementById('newRow_' + index).value == "N")
	{
		document.getElementById('Rights_Type_' + index).value = rightType;
//		document.getElementById('Episode_Type_' + index).value = episodeType;
	}
	
}

/**
 * Check for special chrs on keypress
 * @param event
 * @param obj
 * @returns
 */
function CheckForSpecChars_loc(event,obj){
	
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
	if(obj.value.length==0)
	{

		if('_'.indexOf(key)!=-1)
			return false;
	}

    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}


/*Check for special character on Blur of alpha numeric field  */
function specialCharCheck(obj)
{
	if(obj.value != "")
	{
		if(CheckChars(obj))
		{
			//clearBean(obj.value);
			//parent.PkgDefBaseDateMain.baseDateDtl.document.frmPkgDefBaseDate.packageCode.value=obj.value;			
		}
		else
		{		 
			alert (getMessage("BL8510",'BL'));
			obj.value="";
			obj.focus();
		}
	}
}
/*Check for special character on Blur of numeric field  */
function numberCheck(obj,type,mode)
{
	if(obj.value != "")
	{
		if(CheckNum(obj))
		{
			if(type=="M")
				check_months(obj)
			else  if(type=="D")
				check_days(obj)
			else  if(type=="V")
				chkValidDays(obj,mode)
			else  if(type=="P")
				return validPercentage(obj,type)
		}
	}
}

function iconCheck(obj){
	if(obj!=null){
		if(obj.value != ""){
			var icon=obj.value;
			if(icon != ".GIF" && icon != ".JPEG" && icon != ".gif" && icon != ".jpeg"  ){			
				alert (getMessage("BL00805",'BL'));
			obj.value="";
			obj.focus();	
			}
		}
	}
}
	




function deleteRow()
{
	var delDocument = getInfoColumnFrame().document;
	var delSeqNos =  delDocument.getElementById('deleteSeqNos');
	delSeqNos.value = "";
	
	
	var table = delDocument.getElementById('Table_Column_Info');
	rowCount = table.rows.length;
	var rowCountObj= delDocument.getElementById('rowCount');
	
	for(var i=1; i<rowCount; i++)
	{
		var row = table.rows[i];
		alert("row.cells[1]"+row.cells[1]);
		alert("row.cells[2]"+row.cells[2]);
		alert("row.cells[3]"+row.cells[3]);
		alert("row.cells[4]"+row.cells[4]);
		
		
		 var delChekBox = row.cells[4].childNodes[0];

		 var index = eval(delChekBox.name);
		 if(null != delChekBox && true == delChekBox.checked) 
			{
		    	
		    	 var seqNo = delDocument.getElementById('Seq_No_' + index);
		    	 
		    	 delSeqNos.value += seqNo.value + ",";
		    	 table.deleteRow(i);
		    	
		    	 rowCount--;
		         i--;
		         rowCountObj.value = eval(rowCountObj.value) - 1;
			}
	}
	if(delSeqNos.value == "")
	{
		alert("Please select at least one check box");
	}
	
	
	
}

/**
 * validate and submit the page
 */
function apply()
{	
	
	var last_tab=parent.frames[2].BLToolBarFrame.BLToolBarMainTab.document.frmBLToolBarTab.last_link.value;
	
	var err_mss = "";
	if(last_tab == 'TOOLBAR_FORMAT')
	{
	
		err_mss = validateFmtSeln();
			
		if(err_mss=="" )
		{
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].target='messageFrame';
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].method='post';
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].action="../../servlet/eBL.BLToolBarServlet";

			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].submit();
		}
		else
		{						
			parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=' + err_mss;
		}
		
	}
	else if(last_tab == 'TOOLBAR_ASSOC')
	{
		
		err_mss = validateToolBarFmtAssoc();
		if(err_mss=="" )
		{
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].target='messageFrame';
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].method='post';
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].action="../../servlet/eBL.BLToolBarServlet";
			
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].submit();
		}
		else
		{
			parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num=' + err_mss;
		}
	}
	else
	{
		err_mss = validateStaticInfo();
		if(err_mss=="" )
		{
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].target='messageFrame';
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].method='post';
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].action="../../servlet/eBL.BLToolBarServlet";
			
			parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].submit();
		}
		else
		{
			parent.frames[2].frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='  + err_mss;
		}
	}
}

/**
 * load the tab based on the last_link value
 */

function onSuccess()
{
	 last_tab=parent.frames[2].BLToolBarFrame.BLToolBarMainTab.document.frmBLToolBarTab.last_link.value;
	 if(last_tab=='TOOLBAR_FORMAT'){
		if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].mode.value=="insert")	
		{
			//BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?mode=insert";
			BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarMainFrame.jsp?mode=insert&from=TOOLBAR_FORMAT&level=1";
		}
		else
		{
			BLToolBarFrame.document.location.reload();
		}
	}else if(last_tab=='TOOLBAR_ASSOC'){
		if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].mode.value=="insert")	
		{
			//BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?mode=insert";
			BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarMainFrame.jsp?mode=insert&from=TOOLBAR_ASSOC&level=1";
		}
		else
		{
			BLToolBarFrame.document.location.reload();
		}
	}
	else if(last_tab=='STATIC_INFO'){
		if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].mode.value=="insert")	
		{
			//BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?mode=insert";
			BLToolBarFrame.location.href="../../eBL/jsp/BLMainFrame.jsp?mode=insert&from=STATIC_INFO&level=1";
		}
		else
		{
			BLToolBarFrame.document.location.reload();
		}
	}
}

function reset()
{
	 last_tab=parent.frames[2].BLToolBarFrame.BLToolBarMainTab.document.frmBLToolBarTab.last_link.value;
	 if(last_tab=='TOOLBAR_FORMAT'){
		if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.forms[0].mode.value=="insert")	
		{
			//BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?mode=insert";
			BLToolBarFrame.location.href="../../eBL/jsp/BLMainFrame.jsp?mode=insert&from=TOOLBAR_FORMAT&level=1";
		}
		else
		{
			BLToolBarFrame.document.location.reload();
		}
	}else if(last_tab=='TOOLBAR_ASSOC'){
		if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0].mode.value=="insert")	
		{
			//BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?mode=insert";
			BLToolBarFrame.location.href="../../eBL/jsp/BLMainFrame.jsp?mode=insert&from=TOOLBAR_ASSOC&level=1";
		}
		else
		{
			BLToolBarFrame.document.location.reload();
		}
	}
	else if(last_tab=='STATIC_INFO'){
		if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.forms[0].mode.value=="insert")	
		{
			//BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarFrame.jsp?mode=insert";
			BLToolBarFrame.location.href="../../eBL/jsp/BLMainFrame.jsp?mode=insert&from=STATIC_INFO&level=1";
		}
		else
		{
			BLToolBarFrame.document.location.reload();
		}
	}
}

/**
 * Load the query page
 */
function query()
{
	BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarQueryCriteria.jsp"
}

/**
 * Load the create page
 */

function create()
{	
	
	BLToolBarFrame.location.href="../../eBL/jsp/BLToolBarMainFrame.jsp?mode=insert&from=TOOLBAR_FORMAT&level=1";
}

/**
 * validate banner seln
 * @returns {String}
 */
function validateFmtSeln()
{
	
	var err_mess = "";
	var toolBar = eval(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document);
	
	
	if(toolBar.forms[0].Format_Code.value == "")
	{
		err_mess = getMessage("BL00018","BL")+"<br>";
	}
	if(toolBar.forms[0].Format_Description.value == "")
	{
		err_mess += getMessage("BL00002","BL")+"<br>";
	}
	
	table = toolBar.getElementById('Table_Column_Info');
	
	for(i=1;i<=table.rows.length-1;i++)
	{
		
		var seqNoObj = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.getElementById('Seq_No_" + i + "')");
		
		if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.getElementById('Seq_No_'+ i).value == undefined || parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.getElementById('Seq_No_'+ i).value == '')
		{
			err_mess += getMessage("BL00182","BL");
			
		}
		else if(parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.getElementById('ToolBarFuncName_'+i).value == undefined || parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.getElementById('ToolBarFuncName_'+i).value == '')
		{
			err_mess +="Column1 cannot be NULL";
			
		}
		else if(seqNoObj != null)
		{
			if(seqNoObj.value == "")
			{
				err_mess += getMessage("BL00029","BL")+"<br>";
			}
			var infoCol1 = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarHdr.document.getElementById('ToolBarFuncName_" + i + "')");
			
			
			if(infoCol1.value == "" )
			{
				err_mess += getMessage("BL00016","BL")+"<br>";
			}
		}
		else
		{
			break;
		}
	}	
	return err_mess;
}

/**
 * Validate  Fmt Assoc
 * @returns {String}
 */
function validateToolBarFmtAssoc()
{
	var err_mess = "";
	var toolBarForm = parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.forms[0];
	
	if(toolBarForm.Format_Code.value == "")
	{
		err_mess = getMessage("BL00018","BL")+"<br>";
	}
	if(toolBarForm.Format_Description.value == "")
	{
		err_mess += getMessage("BL00002","BL")+"<br>";
	}
	
	table = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.getElementById('ToolBar_Assoc_Table')");
	
	for(i=1;i<=table.rows.length-1;i++)
	{
		var functId = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.getElementById('Function_Id_" + i + "')");
		
		if(functId != null)
		{
			if(functId.value == "")
			{
				err_mess += getMessage("BL00019","BL") + " in the table <br>";
				functId.focus();
			}
			
			var rightsType = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.getElementById('Rights_Type_" + i + "')");
			if(rightsType.value == "" )
			{
				err_mess += getMessage("BL00021","BL") + " in the table <br>";
			}
			
			var rightsCode = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.getElementById('Right_Code_" + i + "')");
			if(rightsCode.value == "" )
			{
				err_mess += getMessage("BL00022","BL") + " in the table <br>";
			}
			
			
			var effFrom = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLToolBarAssoc.document.getElementById('Effective_From_" + i + "')");
			if(effFrom.value == "" )
			{
				err_mess += getMessage("BL00004","BL") + " in the table <br>";
			}
			
		}
		else
		{
			break;
		}
	}	
	return err_mess;
}


/**
 * Validate Static Info
 * @returns {String}
 */
function validateStaticInfo()
{
	var err_mess = "";
	
	table = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.getElementById('Static_Info_Table')");
	
	for(i=1;i<=table.rows.length;i++)
	{
		var functId = eval("parent.frames[2].BLToolBarFrame.BLToolBarFmtDtlMainFrame.BLStatInfo.document.getElementById('Description_" + i + "')");
		
		if(functId != null)
		{
			if(functId.value == "")
			{
				err_mess += getMessage("BL00002","BL") + " in the table <br>";
				functId.focus();
			}
		}
		else
		{
			break;
		}
	}	
	return err_mess;
}

function getNextIndex()
{	

	var table = getInfoColumnFrame().document.getElementById('Table_Column_Info');
	var rowCount = table.rows.length;	
	var row = table.rows[rowCount - 1];
	//alert("rowCount/table/row-----"+rowCount+"/"+table+"/"+row);
	var delChekBox = row.cells[1].childNodes[0];	
	var index = 1;//eval(delChekBox.name);
	
	return index +1;
}

function getInfoColumnFrame()
{
	return eval("parent.frames[0]");
}

function getToolBarAssocFrame()
{
	return eval("parent.frames[0]");
}

function customerGroupCodeLookUp(index)
{
	var customerGroupCode						=   document.getElementById('Customer_Group_Code_'+index); 
	var sql;
	sql											=	CUST_GROUP_CODE_LOOKUP+" '" +document.forms[0].locale.value+"'";
	
	var title									= 	getLabel("eBL.CustomerGroupCode.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	customerGroupCode.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		customerGroupCode.value 				= 	retVal[0];
	}
	else
	{
		customerGroupCode.value			  		=	"";
		
	}
 
    
}

function customerCodeLookUp(index)
{
	
	var customerGroupCode						=   document.getElementById('Customer_Group_Code_'+index); 
	var customerCode							=   document.getElementById('Customer_Code_'+index); 
	var sql;
	sql											=	CUST_CODE_LOOKUP+" '" +customerGroupCode.value+"'";
	
	var title									= 	getLabel("eBL.CustomerCode.label", 'bl');
	var argumentArray  							= 	new Array() ;
	var dataNameArray  							= 	new Array() ;
	var dataValueArray 							= 	new Array() ;
	var dataTypeArray  							= 	new Array() ;
	argumentArray[0]							= 	sql;
	argumentArray[1]   							= 	dataNameArray ;
	argumentArray[2]   							= 	dataValueArray ;
	argumentArray[3]   							= 	dataTypeArray ;
	argumentArray[4]   							= 	"1,2";
	argumentArray[5]   							= 	customerCode.value;
	argumentArray[6]   							= 	DESC_LINK ;
	argumentArray[7]   							= 	DESC_CODE ;
	retVal 										=   CommonLookup( title, argumentArray );
	if(retVal != null && retVal != "")
	{
		customerCode.value 						= 	retVal[0];
	}
	else
	{
		customerCode.value			  			=	"";
		
	}
 
    
}

