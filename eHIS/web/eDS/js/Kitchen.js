	
	function create() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		f_query_add_mod.location.href="../../eDS/jsp/KitchenAddModify.jsp?"+params+"&mode=insert";
	}
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var frmName = f_query_add_mod.KitchenAdd.document.forms[0].name;

		if(frmName=="kitchen_form"){
			var fields = new Array (f_query_add_mod.KitchenAdd.document.forms[0].kitchen_Code,f_query_add_mod.KitchenAdd.document.forms[0].long_Desc,f_query_add_mod.KitchenAdd.document.forms[0].short_Desc);
			var kitchen=getLabel("eOT.KitchenCode.Label","ot");
			var longDesc=getLabel("eOT.LongDescription.Label","ot");
			var shortDesc=getLabel("eOT.ShortDescription.Label","ot");
			
			var names = new Array ( kitchen,longDesc,shortDesc);
			if(checkFieldsofMst( fields, names, messageFrame)) 
				{	
					f_query_add_mod.KitchenAdd.document.forms[0].submit();
				}
		}
		else if(frmName=="KitchenAreaForm"){

			var formObj1=f_query_add_mod.KitchenAdd.KitchenAreaPopulate;
			var formObj=f_query_add_mod.KitchenAdd.KitchenAreaAdd;
//			var fields = new Array (formObj1.document.getElementById("kitchenArea"),formObj.document.getElementById("kitchen_Code"),formObj.document.getElementById("long_Desc"),formObj.document.getElementById("short_Desc"));
			var fields = new Array (formObj1.document.getElementById("kitchenArea"));
			
			var nutLabel = getLabel("eOT.KitchenCode.Label","ot");
			/*var kitchenAreaLabel = getLabel("eOT.KitchenAreaCode.Label","ot");
			var longDesc=getLabel("eOT.LongDescription.Label","ot");
			var shortDesc=getLabel("eOT.ShortDescription.Label","ot");*/
			
//			var names = new Array (nutLabel,kitchenAreaLabel,longDesc,shortDesc);
			var names = new Array (nutLabel);

			if(checkFieldsofMst( fields, names, messageFrame)) 
			{	
				var kitchenArr = new Array();
				var tbl = f_query_add_mod.KitchenAdd.KitchenAreaPopulate.document.getElementById("listContentTable");

				var foodItmCode = f_query_add_mod.KitchenAdd.KitchenAreaPopulate.document.getElementById("kitchenArea").value;
				var rowCount = tbl.rows.length;

				if(rowCount <=1) {
					var error = getMessage("ATLEAST_ONE_SELECTED","common");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=" + error;
					return false;
				}
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var arrI = j-2;
					kitchenArr[arrI]=tbl.rows[k].cells[0].innerText+":::"+tbl.rows[k].cells[1].innerText+":::"+tbl.rows[k].cells[2].innerText+":::"+tbl.rows[k].cells[3].innerHTML.replace(/[\n\t]/g, "");
				}

				for(var i=0;i<kitchenArr.length;i++){
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutRow"+i);
					input.setAttribute("value", kitchenArr[i]);
					f_query_add_mod.KitchenAdd.KitchenAreaPopulate.document.getElementById("kitchenArea_form").appendChild(input);
				}
				frm = f_query_add_mod.KitchenAdd.KitchenAreaPopulate.document.forms[0];
				frm.action = '../../servlet/eDS.KitchenServlet?Nutrients=yes&totalRow='+i+'&NutrientsValue='+kitchenArr+'&foodItmCode='+foodItmCode;
				frm.submit();
			}
			
		}
	}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/KitchenQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
		 if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("KitchenAddModify.jsp") != -1){

			 if(f_query_add_mod.document.location.href.indexOf("KitchenMain.jsp") != -1)
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("KitchenQueryCriteria.jsp") != -1)
		 {
			 f_query_add_mod.document.forms[0].reset();
		 }
	}
		
	function setFieldToUpperCase(obj) {
		obj.value = obj.value.toUpperCase();
		return obj;
	}
	
	function checkAlpha(event){
		var strCheck = '~!@#$%^&*()+=`{}|[]<>"\'';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  
		if (strCheck.indexOf(key) != -1) return false;  
		return true ;
	}
	
	function onSuccess()
	{
		var formObj =document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.KitchenAdd.document.forms[0].mode.value=="insert")
			f_query_add_mod.location.href="../../eDS/jsp/KitchenAddModify.jsp?"+params+"&mode=insert";
		else
			f_query_add_mod.KitchenAdd.location.reload();

	}
	
	function getKitchenAreas(obj){
		document.location.href='../../eDS/jsp/KitchenAreaPopulate.jsp?kitchen_code='+obj.value+'&kitchen='+obj.value;
		/*var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest() ;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		var param="func_mode=getKitchenAreas&kitchen_code="+obj.value;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eDS/jsp/DLCommonValidation.jsp?"+param,false);
		xmlHttp.send(xmlDoc);
		var retVal = localTrimString(xmlHttp.responseText);	
		alert('retVal'+retVal);
		var indItems = retVal.split("???");
		alert('indItems'+indItems);
		alert('len'+indItems.length);
		var kitchenItems = "";
		var rowCount = document.getElementById("listContentTable").rows.length;
		if(rowCount>1){
			for (var i=rowCount;i>=2;i--){
				document.all("listContentTable").deleteRow(i-1);
			}
		}
		if(indItems!=''){
			alert('Not null');
		for(var i=0; i<indItems.length; i++){
			var newRow = document.all("listContentTable").insertRow();
			kitchenItems = indItems[i].split(":::");
			var cnt = i+2;
			for(var j=0;j<kitchenItems.length;j++){
				var newCell = newRow.insertCell();
				if(j==0){
					newCell.innerHTML = "<a href='javascript:callfn12("+cnt+");'>"+ kitchenItems[j]+"</a>";
					var input = document.createElement("input");
					input.setAttribute("type", "hidden");
					input.setAttribute("name", "nutMode"+i);
					input.setAttribute("value", "U");
					parent.KitchenAreaPopulate.document.getElementById("kitchenArea_form").appendChild(input);
				}
				else if((j==1)||(j==2)){
					newCell.innerText = kitchenItems[j];
				}
				else{
					if(kitchenItems[j] == 'E'){
						newCell.innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
					}
					else{
						newCell.innerHTML = "<img src='../../eCommon/images/RRnwd.gif'></img>";
					}
				
				}
				//document.getElementById("listContentTable").rows[i].cells[j].innerText = kitchenItems[j];
			}
		}
		}
		/*for(var i=0; i<retVal.length;i++){
			alert(retVal[i]);
		}*/
	}
	
	function localTrimString(sInString) {
		  //sInString = sInString.replace( /^\s+/g, "" );// strip leading space
		  //return sInString.replace( /\s+$/g, "" );// strip trailing space
		  return sInString.replace(/^\s+|\s+$/g,"");
		}
	
	function selectRecord1() {
		var fields = new Array (document.getElementById("kitchen_Code"),document.getElementById("long_Desc"),document.getElementById("short_Desc"));
		var kitchenLabel=getLabel("eOT.KitchenAreaCode.Label","ot");
		var longLabel=getLabel("eOT.LongDescription.Label","ot");
		var shortLabel=getLabel("eOT.ShortDescription.Label","ot");
		
		var names = new Array ( kitchenLabel,longLabel,shortLabel);
		if(checkFieldsofMst( fields, names, parent.parent.parent.messageFrame)){
			document.getElementById("kitchen_Code").disabled = false;
			var rowCount = 0;
			rowCount = parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows.length;
			var kitchen = document.kitchenAreaAdd.kitchen_Code.value;
			var longDesc = document.kitchenAreaAdd.long_Desc.value;
			var shortDesc = document.kitchenAreaAdd.short_Desc.value;
			var patirntOrder = "";
			if(document.kitchenAreaAdd.enabled_Yn.checked){
				patirntOrder = "on";
			}
			else{
				patirntOrder = "off";
			}
			
			if(rowCount>1){
				/*if(rowCount==2){
					if(parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[1].cells[0].innerText==''){
						parent.KitchenAreaPopulate.document.all("listContentTable").deleteRow(1);
						rowCount = rowCount-1;
					}
				}*/
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var selectedText = parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[k].cells[0].innerText;
					if(kitchen == selectedText){
						if(document.kitchenAreaAdd.forUpdate.value == 'yes'){
							parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+kitchen+"</a>";
							parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[k].cells[1].innerText = longDesc;
							parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[k].cells[2].innerText = shortDesc;
							 if(patirntOrder == "on"){
								 parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[k].cells[3].innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
							 }
							 else{
								 parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[k].cells[3].innerHTML = "<img src='../../eCommon/images/RRnwd.gif'></img>";
							 }
							 document.kitchenAreaAdd.kitchen_Code.value = "";
							 document.kitchenAreaAdd.long_Desc.value = "";
							 document.kitchenAreaAdd.short_Desc.value = "";
						}
						else{
							alert('Record already exists');
						}
						document.kitchenAreaAdd.forUpdate.value = 'no';
						return true;
					}
					
				}
			}
			
			document.kitchenAreaAdd.forUpdate.value = 'no';
			var newRow = parent.KitchenAreaPopulate.document.all("listContentTable").insertRow();
			 var newCell = newRow.insertCell();
			 rowCount = parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows.length;
			 var fncal = "javascript:callfn12("+rowCount+");"
			 //newCell.innerHTML = "<a href='javascript:callfn12("+nursingUnit+");'>"+nursingUnit+"</a>";
			 newCell.innerHTML = "<a href='"+fncal+"'>"+kitchen+"</a>";   
			 
			 newCell = newRow.insertCell();
			 newCell.innerHTML = longDesc;
			 
			 newCell = newRow.insertCell();
			 newCell.innerHTML = shortDesc;
			 
			 newCell = newRow.insertCell();
			 if(patirntOrder == "on"){
				 newCell.innerHTML = "<img src='../../eCommon/images/enabled.gif'></img>";
			 }
			 else{
				 newCell.innerHTML = "<img src='../../eCommon/images/RRnwd.gif'></img>";
			 }
			    
			var input = document.createElement("input");
			input.setAttribute("type", "hidden");
			var iCnt = rowCount-2;
			input.setAttribute("name", "nutMode"+iCnt);
			input.setAttribute("value", "I");
			parent.KitchenAreaPopulate.document.getElementById("kitchenArea_form").appendChild(input);

			 document.kitchenAreaAdd.kitchen_Code.value = "";
			 document.kitchenAreaAdd.long_Desc.value = "";
			 document.kitchenAreaAdd.short_Desc.value = "";
		}
		
		
	}
	
	function callfn12(obj){
		obj = obj-1;
		
		

					var cell1 = document.getElementById("listContentTable").rows[obj].cells[0].innerText;
					var cell2 = document.getElementById("listContentTable").rows[obj].cells[1].innerText;
					var cell3 = document.getElementById("listContentTable").rows[obj].cells[2].innerText;
					var cell4 = document.getElementById("listContentTable").rows[obj].cells[3].innerHTML;
					if(cell4.indexOf("enabled.gif")!=-1){
						parent.KitchenAreaAdd.document.getElementById("enabled_Yn").checked = true;
					}
					else{
						parent.KitchenAreaAdd.document.getElementById("enabled_Yn").checked = false;
					}
		parent.KitchenAreaAdd.document.getElementById("kitchen_Code").value = cell1;
		parent.KitchenAreaAdd.document.getElementById("long_Desc").value = cell2;
		parent.KitchenAreaAdd.document.getElementById("short_Desc").value = cell3;
		parent.KitchenAreaAdd.document.getElementById("forUpdate").value = 'yes';
		parent.KitchenAreaAdd.document.getElementById("kitchen_Code").disabled = true;
	}
	
	function cancelRecord(){
		document.kitchenAreaAdd.forUpdate.value = 'no';
		document.getElementById("kitchen_Code").disabled = false;
		var kitchen = document.kitchenAreaAdd.kitchen_Code.value;
		var longDesc = document.kitchenAreaAdd.long_Desc.value;
		var shortDesc = document.kitchenAreaAdd.short_Desc.value;
		var patirntOrder = document.kitchenAreaAdd.enabled_Yn.value;

		
		var rowCount = parent.KitchenAreaPopulate.document.all("listContentTable").rows.length-1;
		var totRows = parent.KitchenAreaPopulate.document.getElementById("totalRows").value;
		if(rowCount>0){
			for(i=1;i<=rowCount;i++){
				var hdnI = i-1;
				selectedText = parent.KitchenAreaPopulate.document.all("listContentTable").rows[i].cells[0].innerText;
				if(selectedText == kitchen){
					if(i<=totRows){
						parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[i].cells[0].innerText = selectedText;
						parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[i].cells[0].style.color = '#FF0000';
						parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[i].cells[1].style.color = '#FF0000';
						parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[i].cells[2].style.color = '#FF0000';
						parent.KitchenAreaPopulate.document.getElementById("listContentTable").rows[i].cells[3].style.color = '#FF0000';
						var hdntxt = "nutMode"+hdnI;
						parent.KitchenAreaPopulate.document.getElementById(hdntxt).value='D';
					}
					else{
						parent.KitchenAreaPopulate.document.all("listContentTable").deleteRow(i);
						var rowCnt = parent.KitchenAreaPopulate.document.all("listContentTable").rows.length;
						if(rowCnt>1){
							var l = i+1;
							for(j=l;j<=rowCnt;j++){
								var k = j-1;
								kitchen = parent.KitchenAreaPopulate.document.all("listContentTable").rows[k].cells[0].innerText;
								parent.KitchenAreaPopulate.document.all("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+kitchen+"</a>";
							}
						}
					}

					document.kitchenAreaAdd.kitchen_Code.value = "";
					 document.kitchenAreaAdd.long_Desc.value = "";
					 document.kitchenAreaAdd.short_Desc.value = "";
					return true;
				}
				document.kitchenAreaAdd.kitchen_Code.value = "";
				 document.kitchenAreaAdd.long_Desc.value = "";
				 document.kitchenAreaAdd.short_Desc.value = "";
			}
		}
		document.kitchenAreaAdd.kitchen_Code.value = "";
		 document.kitchenAreaAdd.long_Desc.value = "";
		 document.kitchenAreaAdd.short_Desc.value = "";
	}
