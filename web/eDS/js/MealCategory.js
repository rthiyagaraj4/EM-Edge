	var rows = new Array();
	
	function apply() {
		var frm=f_query_add_mod.document.forms[0];
		var frmName = f_query_add_mod.MealCategoryAdd.document.forms[0].name;
		if(frmName=="mealClass_form"){			
				f_query_add_mod.MealCategoryAdd.document.forms[0].submit();
		}
		else if(frmName=="mealAttendents"){
			var kitchenArr = new Array();
			var tbl = f_query_add_mod.MealCategoryAdd.document.getElementById("listContentTable");
			var rowCount = tbl.rows.length;
			for(j=2;j<=rowCount;j++){
				var k = j-1;
				var arrI = j-2;
				kitchenArr[arrI]=tbl.rows[k].cells[0].innerText+":::"+tbl.rows[k].cells[1].innerText+":::"+tbl.rows[k].cells[2].innerText;
			}
			for(var i=0;i<kitchenArr.length;i++){
				var input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "nutRow"+i);
				input.setAttribute("value", kitchenArr[i]);
				f_query_add_mod.MealCategoryAdd.document.getElementById("mealAttendents").appendChild(input);
			}
			frm = f_query_add_mod.MealCategoryAdd.document.forms[0];
			frm.action = '../../servlet/eDS.MealCategoryServlet?Nutrients=yes&totalRow='+i+'&NutrientsValue='+kitchenArr;
			frm.submit();
		}

	}
	
	
	
	function query() {
		var formObj = document.forms[0];
		var params = formObj.params.value;
		commontoolbarFrame.document.forms[0].apply.disabled=true;
		f_query_add_mod.location.href="../../eDS/jsp/MealCategoryQueryCriteria.jsp?"+params;
	}	
 	 
	 function reset(){
	 
		if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MealCategoryAddModify.jsp") != -1){ //Modified against CRF-0678 Linked Issue-063658
		if(f_query_add_mod.document.location.href.indexOf("MealCategoryMain.jsp") != -1)//Modified against CRF-0678 Linked Issue-063658
				  return false;
			 else
				 f_query_add_mod.document.location.reload();
		 }
		 else if(window.parent.parent.frames[2].frames[1].document.location.href.indexOf("MealCategoryQueryCriteria.jsp") != -1)//Modified against CRF-0678 Linked Issue-063658
		 {
			 f_query_add_mod.document.forms[0].reset();
		 }
	}
		
	function setFieldToUpperCase(obj) {
		obj.value = obj.value.toUpperCase();
		return obj;
	}
	// added by N Munisekhar on 21-May-2013 against [IN39893]
	function checkNumber(){
	 obj =  String.fromCharCode(window.event.keyCode);
		var alphaFilter =/^[0-9]+$/;

		//if (!(alphaFilter.test(obj))||((obj.charCodeAt(0)==48)&&(document.mealAttendents.noAttendents.value.length==0))){ 
		if (!(alphaFilter.test(obj))){
			alert(getMessage("NUM_ALLOWED", "SM"));
		    window.event.keyCode = 27;
		
		}
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
		var formObj = document.forms[0];
		var params = formObj.params.value;
		if(f_query_add_mod.MealCategoryAdd.document.forms[0].mode.value=="insert")
			f_query_add_mod.MealCategoryAdd.location.href="../../eDS/jsp/FeedTypeAddModify.jsp?"+params+"&mode=insert";
		else
			f_query_add_mod.MealCategoryAdd.location.reload();

	}
	
	function cancelRecord(){
		document.mealAttendents.forUpdate.value = 'no';
		document.getElementById("nursing_Unit").disabled = false;
		var nursingUnit = document.mealAttendents.nursing_Unit.value;
		var patirntOrder = document.mealAttendents.patient_Order.value;
		var noAttendents = document.mealAttendents.noAttendents.value;
		
		var rowCount = document.getElementById("listContentTable").rows.length-1;
		var totRows = document.getElementById("totalRows").value;
		if(rowCount>0){
			for(i=1;i<=rowCount;i++){
				var hdnI = i-1;
				selectedText = document.getElementById("listContentTable").rows[i].cells[0].innerText;
				if(selectedText == nursingUnit){
					
					if(i<=totRows){
						document.getElementById("listContentTable").rows[i].cells[0].innerText = selectedText;
						document.getElementById("listContentTable").rows[i].cells[0].style.color = '#FF0000';
						document.getElementById("listContentTable").rows[i].cells[1].style.color = '#FF0000';
						document.getElementById("listContentTable").rows[i].cells[2].style.color = '#FF0000';
						var hdntxt = "nutMode"+hdnI;
						document.getElementById(hdntxt).value='D';
					}
					else{
						document.getElementById("listContentTable").deleteRow(i);
						var rowCnt = document.getElementById("listContentTable").rows.length;
						if(rowCnt>1){
							var l = i+1;
							for(j=l;j<=rowCnt;j++){
								var k = j-1;
								nursingUnit = document.getElementById("listContentTable").rows[k].cells[0].innerText;						
								document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+nursingUnit+"</a>";
							}
						}
					}
					
					return true;
				}
				document.mealAttendents.nursing_Unit.value = "";
				 document.mealAttendents.noAttendents.value = 0;
			}
		}
		document.mealAttendents.nursing_Unit.value = "";
		 document.mealAttendents.noAttendents.value = 0;
	}
	
	
	function selectRecord1() {
		var fields = new Array (document.mealAttendents.nursing_Unit,document.mealAttendents.noAttendents);
		var nurLabel=getLabel("eOT.NursingUnit.Label","ot");
		//var noALabel=getLabel("eOT.NoOfAttendent.Label","ot");//Commented for ML-MMOH-CRF-406
		var Attendent_Label_Name=document.mealAttendents.Attendent_Label_Name.value;//ML-MMOH-CRF-406
		var noALabel=Attendent_Label_Name;
		var names = new Array ( nurLabel,noALabel);
		if(checkFieldsofMst( fields, names, parent.parent.messageFrame)){
			document.getElementById("nursing_Unit").disabled = false;
			var rowCount = 0;
			rowCount = document.getElementById("listContentTable").rows.length;
			var nursingUnit = document.mealAttendents.nursing_Unit.value;
			var patirntOrder = "";
			var noAttendents = document.mealAttendents.noAttendents.value;
			
			if(noAttendents == 0) //IN::39893
			{
				alert('No of Attendent should be greater than Zero');
				return false;
			}
			
			if(document.mealAttendents.patient_Order.checked){
				patirntOrder = "on";
			}
			else{
				patirntOrder = "off";
			}
			
			
			if(rowCount>1){
				for(j=2;j<=rowCount;j++){
					var k = j-1;
					var selectedText = document.getElementById("listContentTable").rows[k].cells[0].innerText;
					if(nursingUnit == selectedText){
						if(document.mealAttendents.forUpdate.value == 'yes'){
							document.getElementById("listContentTable").rows[k].cells[0].innerHTML = "<a href='javascript:callfn12("+j+");'>"+nursingUnit+"</a>";
							document.getElementById("listContentTable").rows[k].cells[2].innerText = noAttendents;
							
							 if(patirntOrder == "on"){
								 document.getElementById("listContentTable").rows[k].cells[1].innerText = "Y";
							 }
							 else{
								 document.getElementById("listContentTable").rows[k].cells[1].innerText = "N";
							 }
							
							 document.mealAttendents.nursing_Unit.value = "";
							 document.mealAttendents.noAttendents.value = 0;
							 document.mealAttendents.patient_Order.checked = false;
						}
						else{
							alert('Record already exists');
						}
						document.mealAttendents.forUpdate.value = 'no';
						return true;
					}
					
				}
			}
			
			document.mealAttendents.forUpdate.value = 'no';
			var newRow = document.all("listContentTable").insertRow();
			 var newCell = newRow.insertCell();
			 rowCount = document.getElementById("listContentTable").rows.length;
			 var fncal = "javascript:callfn12("+rowCount+");"
			 //newCell.innerHTML = "<a href='javascript:callfn12("+nursingUnit+");'>"+nursingUnit+"</a>";
			 newCell.innerHTML = "<a href='"+fncal+"'>"+nursingUnit+"</a>";   
			 newCell = newRow.insertCell();
			 if(patirntOrder == "on"){
				 newCell.innerHTML = "Y";
			 }
			 else{
				 newCell.innerHTML = "N";
			 }
			    
			 newCell = newRow.insertCell();
			 newCell.innerHTML = noAttendents;
			 
			 var input = document.createElement("input");
			input.setAttribute("type", "hidden");
			var iCnt = rowCount-2;
			input.setAttribute("name", "nutMode"+iCnt);
			input.setAttribute("value", "I");
			document.getElementById("mealAttendents").appendChild(input);
						 
			 document.mealAttendents.nursing_Unit.value = "";
			 document.mealAttendents.noAttendents.value = 0;
			 document.mealAttendents.patient_Order.checked = false;
		}
	}
	
	function callfn12(obj){
		obj = obj-1;
		
		

					var cell1 = document.getElementById("listContentTable").rows[obj].cells[0].innerText;
					var cell2 = document.getElementById("listContentTable").rows[obj].cells[1].innerText;
					var cell3 = document.getElementById("listContentTable").rows[obj].cells[2].innerText;


		document.mealAttendents.nursing_Unit.value = cell1;
		document.mealAttendents.noAttendents.value = cell3;
		document.mealAttendents.forUpdate.value = 'yes';
		
		if(cell2=='Y'){
			document.getElementById("patient_Order").checked = true;
		}
		else{
			document.getElementById("patient_Order").checked = false;
		}
		document.getElementById("nursing_Unit").disabled = true;
	}
