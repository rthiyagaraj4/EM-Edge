function changeLabel(str){
			var formObj = document.forms[0];
			var target_obj1 = formObj.base_chart1;
			var target_obj2 = formObj.eval_chart;
			var target_obj3 = formObj.base_chart2;
			var label= "BaselineChart";
			var label1= getLabel("eOH.DefaultSelect.Label","OH");
			var label2= "EvaluationChart";
			if(str=="BB"){
				formObj.chkacrchart.checked=true;
				formObj.chkacrchart.disabled=true;
			}else{
				formObj.chkacrchart.checked=false;
				formObj.chkacrchart.disabled=false;
			}
			switch(str){
				case "BB":document.getElementById('chart1').innerText=label+'1';
							document.getElementById('chart2').innerText=label+'2';
							document.getElementById('chart3').innerText=label+'3';
							formObj.perio_chart.value="";
							removeAll(target_obj2);
							removeAll(target_obj1);
							removeAll(target_obj3);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
				case "BE":	document.getElementById('chart1').innerText=label;
							if(formObj.chart_cmpre.value==2){
								document.getElementById('chart2').innerText=label2;
							}else{
								document.getElementById('chart2').innerText=label2+'1';
							}
							document.getElementById('chart3').innerText=label2+'2';
							formObj.perio_chart.value="";
							removeAll(target_obj2);
							removeAll(target_obj1);
							removeAll(target_obj3);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
				case "EE": 

						    document.getElementById('chart1').innerText=label2+'1';
						    document.getElementById('chart2').innerText=label2+'2';
						    document.getElementById('chart3').innerText=label2+'3';
							formObj.perio_chart.value="";
							removeAll(target_obj1);
							removeAll(target_obj3);
							removeAll(target_obj2);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
			}

		}

//Created by rajesh for OnChange of Compare Chart.. hiding/display the 3 chart comparision

	function enableChart(){
		var formObj=document.forms[0];
		/*var label= getLabel("eOH.BaselineChart.Label","OH");
		var label1= getLabel("eOH.DefaultSelect.Label","OH");
		var label2= getLabel("eOH.EvaluationChart.Label","OH");*/
		var label= "BaselineChart";
		var label2= "EvaluationChart";
		var target_obj1 = formObj.base_chart1;
		var target_obj2 = formObj.eval_chart;
		var target_obj3 = formObj.base_chart2;
		var eval_type = getRadioButtonValues(formObj.evaluation);
		formObj.perio_chart.value="";
		var chart_cmpre=formObj.chart_cmpre.value;
		removeAll(target_obj1);
		removeAll(target_obj3);
		removeAll(target_obj2);
		if(chart_cmpre==3){
			document.getElementById("chart3").style.display='Inline';
			document.getElementById("chart3_value").style.display='Inline';
			document.getElementById("evaluation").checked=true;
			switch(eval_type){
				case "BB":  document.getElementById('chart1').innerText=label+'1';
							document.getElementById('chart2').innerText=label+'2';
							document.getElementById('chart3').innerText=label+'3';
							formObj.perio_chart.value="";
							removeAll(target_obj2);
							removeAll(target_obj1);
							removeAll(target_obj3);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
				case "BE":	document.getElementById('chart1').innerText=label;
							document.getElementById('chart2').innerText=label2+'1';
							document.getElementById('chart3').innerText=label2+'2';
							formObj.perio_chart.value="";
							removeAll(target_obj2);
							removeAll(target_obj1);
							removeAll(target_obj3);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
				case "EE": 

						    document.getElementById('chart1').innerText=label2+'1';
						    document.getElementById('chart2').innerText=label2+'2';
						    document.getElementById('chart3').innerText=label2+'3';
							formObj.perio_chart.value="";
							removeAll(target_obj1);
							removeAll(target_obj3);
							removeAll(target_obj2);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
			}
		}else if(chart_cmpre==2){
			document.getElementById('chart2').innerText=label2;
			document.getElementById("chart3_value").style.display='None';
			document.getElementById("chart3").style.display='None';
		//	document.getElementById("chart3_color").style.display='None';
			switch(eval_type){
				case "BB":document.getElementById('chart1').innerText=label+'1';
							document.getElementById('chart2').innerText=label+'2';
							//document.getElementById('chart3').innerText=label+'3';
							formObj.perio_chart.value="";
							removeAll(target_obj2);
							removeAll(target_obj1);
							removeAll(target_obj3);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
				case "BE":	document.getElementById('chart1').innerText=label;
							document.getElementById('chart2').innerText=label2;
							//document.getElementById('chart3').innerText=label2+'2';
							formObj.perio_chart.value="";
							removeAll(target_obj2);
							removeAll(target_obj1);
							removeAll(target_obj3);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
				case "EE": 

						    document.getElementById('chart1').innerText=label2+'1';
						    document.getElementById('chart2').innerText=label2+'2';
						    //document.getElementById('chart3').innerText=label2+'3';
							formObj.perio_chart.value="";
							removeAll(target_obj1);
							removeAll(target_obj3);
							removeAll(target_obj2);
							parent.perioChartRecordFrame.location.href="../../eCommon/html/blank.html";
							break;
			}


		}

	}

	function populateEvaluationListItem(){

			var formObj = document.forms[0];
			var eval_type = getRadioButtonValues(formObj.evaluation);
			if(eval_type=="BB"){
				checkBaselineChart();
			}else if(eval_type=="BE"){
				checkBaselineChart();
			}else if(eval_type=="EE"){
				checkEvaluationlineChart();
			}  
		}
	
	function checkBaselineChart(){
		var formObj = document.forms[0];
		var target_obj = formObj.eval_chart;
		var target_obj2 = formObj.base_chart2;
		var chrt_code =formObj.base_chart1.value;
		var no_of_charts =formObj.chart_cmpre.value;
		var chart_code = chrt_code.split("@@")[0];
		var chart_num = chrt_code.split("@@")[1];
		var patient_id = formObj.patient_id.value;
		var facility_id = formObj.facility_id.value;
		var eval_type = getRadioButtonValues(formObj.evaluation);
		var across_chart_yn = (formObj.chkacrchart.checked)?"Y":"N";
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params="";
		if(eval_type=="BB"){
		params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=BothBaseLineList&chart_code="+chart_code;
		}else{
		params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=EvaluationList&chart_code="+chart_code+"&chart_num="+chart_num+"&across_chart_yn="+across_chart_yn+"&eval_type="+eval_type+"&populate_list=2";
		}
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","PerioCompareChartValidation.jsp?"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		if(eval_type!="BB" && no_of_charts==3){
			removeAll(target_obj2);
			removeAll(target_obj);
			populateList(target_obj,retVal);	
			populateList(target_obj2,retVal);
		}else if(eval_type!="BB" && no_of_charts==2){
			removeAll(target_obj2);
			removeAll(target_obj);
			populateList(target_obj,retVal);	
			populateList(target_obj2,retVal);
		}
	}

	function checkEvaluationlineChart(){
			var formObj = document.forms[0];
			var target_obj = formObj.eval_chart;
			var target_obj2 = formObj.base_chart2;
			var chrt_code =formObj.base_chart1.value;
			var no_of_charts =formObj.chart_cmpre.value;
			var chart_code = chrt_code.split("@@")[0];
			var chart_num = chrt_code.split("@@")[1];
			var patient_id = formObj.patient_id.value;
			var facility_id = formObj.facility_id.value;
			var eval_type = getRadioButtonValues(formObj.evaluation);
			var across_chart_yn = (formObj.chkacrchart.checked)?"Y":"N";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params="";
			if(eval_type=="BB"){
			params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=BothBaseLineList&chart_code="+chart_code;
			}else{
			params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=EvaluationList&chart_code="+chart_code+"&chart_num="+chart_num+"&across_chart_yn="+across_chart_yn+"&eval_type="+eval_type+"&populate_list=2";
			}
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCompareChartValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(eval_type!="EE" && no_of_charts==3){
				removeAll(target_obj2);
				removeAll(target_obj);
				populateList(target_obj,retVal);	
				populateList(target_obj2,retVal);
			}else if(eval_type!="EE" && no_of_charts==2){
				removeAll(target_obj2);
				removeAll(target_obj);
				populateList(target_obj,retVal);	
				populateList(target_obj2,retVal);
			}
	}

		function populateBothEvalListItem(){
			var formObj = document.forms[0];
			var target_obj1 = formObj.base_chart1;
			var target_obj2 = formObj.eval_chart;
			var target_obj3 = formObj.base_chart2;
			//var chart_code =(formObj.base_chart.value).split("@@")[0];
			//var chart_num=(formObj.base_chart.value).split("@@")[1];
			var chart_code =formObj.perio_chart.value ;
			var patient_id = formObj.patient_id.value;
			var facility_id = formObj.facility_id.value;
			var eval_type = getRadioButtonValues(formObj.evaluation);
			var across_chart_yn = (formObj.chkacrchart.checked)?"Y":"N";
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=EvaluationList&chart_code="+chart_code+"&across_chart_yn="+across_chart_yn+"&eval_type="+eval_type+"&populate_list=1";
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCompareChartValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			removeAll(target_obj1);
			removeAll(target_obj2);
			removeAll(target_obj3);
			populateList(target_obj1,retVal);
			populateList(target_obj2,retVal);
			if(formObj.chart_cmpre.value==3){
				populateList(target_obj3,retVal);
			}
		}
	
		function removeAll(obj){
			var len = obj.length;
			for (var i=len;i>-1;i--){
				obj.remove(i); 
			}
			var tp = "---"+getLabel("Common.defaultSelect.label","Common")+"---"; 
			var opt  	= eval("document.createElement(\"OPTION\")") ;
			opt.text 	= tp ;
			opt.value 	= "" ;
			obj.add(opt) ;
		}

		function clearList(obj){
			var len = obj.length;
			for (var i=len;i>-1;i--){
				obj.remove(i); 
			}
		}

	function copyBaseLineChartList(){
		var formObj = document.forms[0];
		var orig_obj = formObj.base_chart1;
		var target_obj1 = formObj.base_chart2;
		var len = orig_obj.length;
		for (var k=0;k<len;k++){
			addListOptions(target_obj1,orig_obj.options[k].value,orig_obj.options[k].text);
		}
	}

	function addListOptions(obj,code,desc){
			var element 	= document.createElement('OPTION') ;
			element.value 	=  code ;
			element.text 	= desc ;
			obj.add(element);	
		}
		
		function populateList(obj,str){
			if(str.length>1){
				var arr = str.split("~");
				for(var i=0;i<arr.length-1;i++){
					var code_desc_arr = arr[i].split("##");
					addListOptions(obj,code_desc_arr[0],code_desc_arr[1]);
				}
			}
		}
 
		function trimString(str){
			  return str.replace(/^\s+|\s+$/g,"");
		}

		function refresh(){
			parent.parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
			var formObj = document.forms[0];
			var no_of_charts=formObj.chart_cmpre.value;
			var obj1=formObj.base_chart1;
			var obj2=formObj.eval_chart;
			var obj3=formObj.base_chart2;
			formObj.no_of_charts.value=no_of_charts;
			if(no_of_charts==2){
				formObj.selected_val1.value=formObj.base_chart1.options[obj1.selectedIndex].text;
				formObj.selected_val2.value=formObj.eval_chart.options[obj2.selectedIndex].text;
			}else if(no_of_charts==3){
				formObj.selected_val1.value=formObj.base_chart1.options[obj1.selectedIndex].text;
				formObj.selected_val2.value=formObj.eval_chart.options[obj2.selectedIndex].text;
				formObj.selected_val3.value=formObj.base_chart2.options[obj3.selectedIndex].text;
			}
			var eval_type = getRadioButtonValues(formObj.evaluation);
			parent.perioChartMainDummyFrame.document.forms[0].main_chart_num.value = ""; // Clearing the chart_num ecah time whicen u refresh..This is to get the fresh chart_num whenever u insert record..
			var messageFrame = parent.parent.messageFrame;
			var baselinechrt_title	="";
			var evalchrt_title		="";
			var evalchrt_title1		="";
			if(formObj != null){
				var numbering_system_title=getLabel("eOH.NumberingSystem.Label","OH");
			if(no_of_charts==2){
				if(eval_type=="BE"){
					baselinechrt_title=getLabel("eOH.BaselineChart.Label","OH");
					evalchrt_title=getLabel("eOH.EvaluationChart.Label","OH");
				}else if(eval_type=="EE"){
					baselinechrt_title=getLabel("eOH.EvaluationChart.Label","OH")+"1";
					evalchrt_title=getLabel("eOH.EvaluationChart.Label","OH")+"2";
				}else if(eval_type=="BB"){
					baselinechrt_title=getLabel("eOH.BaselineChart.Label","OH")+"1";
					evalchrt_title=getLabel("eOH.BaselineChart.Label","OH")+"2";
				}
			}else{
				if(eval_type=="BE"){
					baselinechrt_title=getLabel("eOH.BaselineChart.Label","OH");
					evalchrt_title=getLabel("eOH.EvaluationChart.Label","OH")+"1";
					evalchrt_title1=getLabel("eOH.EvaluationChart.Label","OH")+"2";
				}else if(eval_type=="EE"){
					baselinechrt_title=getLabel("eOH.EvaluationChart.Label","OH")+"1";
					evalchrt_title=getLabel("eOH.EvaluationChart.Label","OH")+"2";
					evalchrt_title1=getLabel("eOH.EvaluationChart.Label","OH")+"3";
				}else if(eval_type=="BB"){
					baselinechrt_title=getLabel("eOH.BaselineChart.Label","OH")+"1";
					evalchrt_title=getLabel("eOH.BaselineChart.Label","OH")+"2";
					evalchrt_title1=getLabel("eOH.BaselineChart.Label","OH")+"3";
				}

			}
			var chart_title=getLabel("Common.Chart.label","Common");
				
			var fields ="";
			var names ="";
			if(no_of_charts==2){				
				fields = new Array (formObj.perio_numbering_system,formObj.perio_chart,formObj.base_chart1,formObj.eval_chart);
				names = new Array ( numbering_system_title,chart_title,baselinechrt_title,evalchrt_title);
			}else if(no_of_charts==3){				
				fields = new Array (formObj.perio_numbering_system,formObj.perio_chart,formObj.base_chart1,formObj.eval_chart, formObj.base_chart2);
				names = new Array ( numbering_system_title,chart_title,baselinechrt_title,evalchrt_title,evalchrt_title1);
			}
			if(checkFieldsofMst( fields, names, messageFrame) && checkDuplicateComparison()){	
				changeNumberingSystem();
			}

				
			}
			
		}


		function getRadioButtonValues(rbgrp){
			var rbgroup_value ="";
			for (var i=0;i<rbgrp.length;i++){ 
				if (rbgrp[i].checked){ 
					rbgroup_value = rbgrp[i].value; 
				} 
			}
			return rbgroup_value;
	   }

		function changeNumberingSystem(){ // This function is to rebuild the query without tooth_numbering_system parameter...
			var formObj = document.forms[0];
			var main_tab = "";
			var perio_numbering_system = formObj.perio_numbering_system.value; // OnChange parameter
			var tooth_numbering_system = formObj.tooth_numbering_system.value; //Form params..
			var oh_chart_level = formObj.oh_chart_level.value; //Form params..
			var basechart = formObj.base_chart1.value; //Form params..
			var no_of_charts =formObj.chart_cmpre.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//var params = "";
			var params = "oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","CommonValidation.jsp?func_mode=selectUserPrefferences&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var retVal=localTrimString(retVal);
			if(retVal.length > 1){
				retVal_arr = retVal.split("##");
				//if(retVal_arr[0] == "" && (tooth_numbering_system == null || tooth_numbering_system == "null")){ // Loding page for the first time and there thee is no record in OH_USER_PREFERENCES table
				if( (retVal_arr[0] == null || retVal_arr[0] == "null" || retVal_arr[0] == "") && (tooth_numbering_system == null || tooth_numbering_system == "null" || tooth_numbering_system=="")){ // Loding page for the first time and there thee is no record in OH_USER_PREFERENCES table
					tooth_numbering_system = retVal_arr[1];
					formObj.tooth_numbering_system.value = retVal_arr[1];
					formObj.perio_numbering_system.value = retVal_arr[1];
				}
				//else if(retVal_arr[0] != "" && (tooth_numbering_system == null || tooth_numbering_system == "null" || tooth_numbering_system == "")){ // Loding page for the first time and there thee is a record in OH_USER_PREFERENCES table
				else if( retVal_arr[0] != null && retVal_arr[0] != "null" && retVal_arr[0] != "" && (tooth_numbering_system == null || tooth_numbering_system == "null" ||tooth_numbering_system == "")){ // Loding page for the first time and there thee is a record in OH_USER_PREFERENCES table
					tooth_numbering_system = retVal_arr[0];
					formObj.tooth_numbering_system.value = retVal_arr[0];
					formObj.perio_numbering_system.value = retVal_arr[0];
				}
				else{ // Loding page when you click on the refresh button and tooth_numbering_system is not null
					if(tooth_numbering_system != perio_numbering_system){
						var copy_as_defult  = confirm(getMessage("APP-OH00032","OH"))
						if(copy_as_defult){ // If you want to set this numbering system as default numbering system

							// Insert a record in to OH_USER_PREFERENCES table
							var xmlDoc = "" ;
							var xmlHttp = new XMLHttpRequest();
							var params = "tooth_numbering_system="+perio_numbering_system;
							var xmlStr ="<root><SEARCH ";
							xmlStr +=" /></root>";
							xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
							xmlHttp.open("POST","CommonValidation.jsp?func_mode=updateUserPrefferences&"+params,false);
							xmlHttp.send(xmlDoc);
							var retVal = trimString(xmlHttp.responseText);
							var retVal=localTrimString(retVal);
							if(retVal != 0){
								formObj.tooth_numbering_system.value = perio_numbering_system;
								tooth_numbering_system = perio_numbering_system;
							}
						}
						else{ //If you dont want to set this numbering system as default numbering system
							formObj.tooth_numbering_system.value = perio_numbering_system;
							tooth_numbering_system = perio_numbering_system;
						}
					}
			
				}
				
			}

			if(parent.frames[1].EvaluationChart != null && parent.frames[1].EvaluationChart != "null" && parent.frames[1].EvaluationChart != undefined && parent.frames[1].EvaluationChart != "undefined" ){
				if(parent.frames[1].EvaluationChart.className == "tabClicked"){
					main_tab = "EvaluationChart";
				}
				else if(parent.frames[1].Compare.className == "tabClicked"){
					main_tab = "Compare";
				}
				else{
					main_tab = "BaselineChart";
				}
			}
			
			//var params_str = formObj.params.value;
			//var params_str = parent.frames[2].document.forms[0].ca_params.value //PerioChartMain
			var params_str = parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
			var chart_flag = formObj.chart_flag.value;
			var quadrant = formObj.quadrant.value;
			//var quadrant = getRadioButtonValues(formObj.quadrant);
			var eval_type = getRadioButtonValues(formObj.evaluation);
			var across_chart_yn = (formObj.chkacrchart.checked)?"Y":"N";
			//var eval_type = formObj.evaluation.value;
			var chart_code = formObj.perio_chart.value;
			var eval_chart1=formObj.base_chart1.value;
			var eval_chart2=formObj.eval_chart.value;
			var eval_chart3=formObj.base_chart2.value;
			var eval_chart3_temp=eval_chart3.split("@@");
			var eval_chart_num3 = eval_chart3_temp[1];
			var eval_chart_line_num3=eval_chart3_temp[2];
			var chart_compare=formObj.chart_cmpre.value;
			var numbering_system=formObj.perio_numbering_system.value;
			var selected_val1=formObj.selected_val1.value;
			var selected_val2=formObj.selected_val2.value;
			var selected_val3=formObj.selected_val3.value;
			var eval_chart1temp=eval_chart1.split("@@")
			var eval_chart_num1 = eval_chart1temp[1];
			var eval_chart_line_num1=eval_chart1temp[2];
			var eval_chart2_temp=eval_chart2.split("@@");
			var eval_chart_num2 = eval_chart2_temp[1];
			var eval_chart_line_num2=eval_chart2_temp[2];
			var arr_date1=(formObj.base_chart1.options[formObj.base_chart1.selectedIndex].text).split("-");
			//var eval_chart_date1=arr_date1[2]+"/"+getMonth(arr_date1[3]);
			var eval_chart_date1=arr_date1[2]+"/"+getMonth(arr_date1[3]);
			var arr_date2=(formObj.eval_chart.options[formObj.eval_chart.selectedIndex].text).split("-");
			//var eval_chart_date2=arr_date2[3]+"/"+getMonth(arr_date2[4]);
			var eval_chart_date2=arr_date2[2]+"/"+getMonth(arr_date2[3]);
			var patient_id = formObj.patient_id.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			//Passed oh_chart_level for IN021300 by Sridevi Joshi on 5/11/2010
			var params = "numbering_system="+tooth_numbering_system+"&patient_id="+patient_id+"&chart_flag="+chart_flag+"&oh_chart_level="+oh_chart_level;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","buildPerioParameters.jsp?func_mode=buildPerioParameters&"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			var ret_params=localTrimString(retVal);
			//params=params_str+ret_params+"&perio_arch="+perio_arch+"&perio_chart="+perio_chart+"&main_tab="+main_tab+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&chart_num="+chart_num; //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.
			//params=params_str+ret_params+"&perio_arch="+perio_arch+"&perio_chart="+perio_chart+"&main_tab="+main_tab+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&chart_num="+chart_num;  //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.
			params=params_str+ret_params+"&main_tab="+main_tab+"&eval_type="+eval_type+"&quadrant="+quadrant+"&chart_code="+chart_code+"&eval_chart_line_num1="+eval_chart_line_num1+"&eval_chart_line_num2="+eval_chart_line_num2+"&numbering_system="+numbering_system+"&across_chart_yn="+across_chart_yn+"&eval_chart_date1="+eval_chart_date1+"&eval_chart_date2="+eval_chart_date2+"&eval_chart_num1="+eval_chart_num1+"&eval_chart_num2="+eval_chart_num2+"&eval_chart_num3="+eval_chart_num3+"&eval_chart_line_num3="+eval_chart_line_num3+"&chart_compare="+chart_compare+"&selected_val1="+selected_val1+"&selected_val2="+selected_val2+"&selected_val3="+selected_val3+"&no_of_charts="+no_of_charts+"&oh_chart_level="+oh_chart_level; //Main_tab value is the value of the tab (Condition or Treatment) which will be in clicked position when you click on the refresh button.
			//formObj.params.value = params;
			//var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value

			//params =ret_params+ "&main_tab="+main_tab+"&eval_type="+eval_type+"&quadrant="+quadrant+"&chart_code="+chart_code+"&chart_num="+chart_num+"&eval_chart_line_num1="+eval_chart_line_num1+"&eval_chart_line_num2="+eval_chart_line_num2+"&numbering_system="+numbering_system+"&patient_id="+patient_id+"permanent_deciduous_flag="+permanent_deciduous_flag
			if(main_tab == "EvaluationChart"){
				//parent.frames[2].location.href="../../eOH/jsp/OHTrmtDentalChartFrame.jsp?"+params;
				//parent.frames[1].location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
			}
			else if(main_tab == "Compare"){
				//parent.frames[2].location.href="../../eOH/jsp/PeriodontalSummaryFrame.jsp?"+params;
				//parent.frames[1].location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				
			}
			else{
				//parent.frames[1].location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params;
				parent.perioChartRecordFrame.location.href="../../eOH/jsp/PerioChartLoadParamsFrame.jsp?"+params; 
				//parent.frames[2].location.href="../../eOH/jsp/PerioBaselineChart.jsp?"+params;
			}
		}


function getMonth(str){
	var mnth = new Array("JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC");
	var mnth_1 = new Array("01","02","03","04","05","06","07","08","09","10","11","12");
	var indx=0;
	for(i in mnth){
		if (mnth[i]==str){
			indx =mnth_1[i];
			break;
		}
	}
	return indx;

}
//Created by rajesh for CRF-491 on 10-01-2010
function populateBothBaseLineChart(){
			var formObj = document.forms[0];
			var target_base = formObj.base_chart2;
			var target_obj1 = formObj.base_chart1;
			var target_obj2 = formObj.eval_chart;
			var chart_code =(formObj.perio_chart.value).split("@@")[0];
			var patient_id = formObj.patient_id.value;
			var facility_id = formObj.facility_id.value;
			var no_of_charts = formObj.chart_cmpre.value;
			var radio_group = formObj.evaluation;
			var cmp_type= getRadioButtonValues(radio_group);
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=BothBaseLineList&chart_code="+chart_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCompareChartValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
//			removeAll(target_obj1);
//			removeAll(target_obj2);
			if(no_of_charts=="2"){
				removeAll(target_obj1);
				removeAll(target_obj2);
				populateList(target_obj1,retVal);
				populateList(target_obj2,retVal); 
			}else{
				removeAll(target_base);
				removeAll(target_obj1);
				removeAll(target_obj2);
				populateList(target_base,retVal);
				populateList(target_obj1,retVal);
				populateList(target_obj2,retVal); 
			}
}

function populateBaseLineChartTemp(){
			var formObj = document.forms[0];
			var target_base = formObj.base_chart;
			var target_obj1 = formObj.base_chart1;
			var target_obj2 = formObj.eval_chart;
			var chart_code =(formObj.perio_chart.value).split("@@")[0];
			var patient_id = formObj.patient_id.value;
			var facility_id = formObj.facility_id.value;
			var radio_group = formObj.evaluation;
			var cmp_type= getRadioButtonValues(radio_group);
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=BothBaseLineListTemp&chart_code="+chart_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCompareChartValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			return retVal
}

function PopulateBaseLineChart(){
	
			var baselinevalues=populateBaseLineChartTemp();
			var formObj = document.forms[0];
			var chart_nos=formObj.chart_cmpre.value;
			var target_base = formObj.base_chart1;
			var target_obj1 = formObj.base_chart2;
			var target_obj2 = formObj.eval_chart;
			var chart_code =(formObj.perio_chart.value).split("@@")[0];
			var patient_id = formObj.patient_id.value;
			var facility_id = formObj.facility_id.value;
			var radio_group = formObj.evaluation;
			var cmp_type= getRadioButtonValues(radio_group);
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest();
			var params = "patient_id="+patient_id+"&facility_id="+facility_id+"&func_mode=BaseLineList&chart_code="+chart_code;
			var xmlStr ="<root><SEARCH ";
			xmlStr +=" /></root>";
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			xmlHttp.open("POST","PerioCompareChartValidation.jsp?"+params,false);
			xmlHttp.send(xmlDoc);
			var retVal = trimString(xmlHttp.responseText);
			if(cmp_type=="EE"){
				removeAll(target_obj1);
				//populateList(target_obj1,retVal);
				removeAll(target_base);
				
				populateList(target_base,retVal);
			}else if(cmp_type=="BE"){
				removeAll(target_obj1);
				removeAll(target_obj2);
				removeAll(target_base);
				populateList(target_base,baselinevalues);
	//			if(chart_nos==3){
	//				populateList(target_obj1,baselinevalues);
	//			}
			}
}


function assignValueToCell	 (td_id,val,cut_off){
	if(parseInt(val)>=parseInt(cut_off)){
	    document.getElementById(td_id).innerHTML="<font size='2.5' color='red'>"+val+"</font>";;

	}else{
	document.getElementById(td_id).innerHTML=val;
	}
	//document.getElementById(td_id).innerHTML="<font size='2.5' color='red'>"+val+"</font>";;
}

function checkDuplicateComparison(){
	var messageFrame = parent.parent.messageFrame;
	var flag="";

	var msg = getMessage("APP-OH00055","OH");//"Duplicate Chart Comparison Not Allowed...";
	var formObj=document.forms[0];
	var chart_compare = formObj.chart_cmpre.value;
	var target_obj1 = formObj.base_chart1.value;
	var target_obj2 = formObj.eval_chart.value;
	var target_obj3 = formObj.base_chart2.value;
	var param = formObj.params.value;
	var quadrant = formObj.quadrant.value;
	var tooth_numbering_system = formObj.tooth_numbering_system.value;
	var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
	var params=param+"&quadrant="+quadrant+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag=P";
	if(chart_compare==2){
		if(target_obj1==target_obj2){
		flag=true;	
		}
	}else if(chart_compare==3)
	{
		if(target_obj1==target_obj2 || target_obj2==target_obj3 || target_obj3==target_obj1){
			flag=true;	
		}
	}
	if(flag){
		messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg;
	//	parent.frames[3].frames[0].perioChartRecordDetails.location.href="../../eOH/jsp/PerioCompareChartingComponents.jsp?"+params;
	//	parent.frames[3].frames[0].perioChartDisplay.location.href="../../eOH/jsp/PerioCompareChartDisplay.jsp?"+params;
		return false;
	}else{
		return true;
	}

}

function getSelectedChkBox(arrObj) {
		var getstr = "";
		var cnt = 0;
		for (i=0; i<arrObj.length; i++) {
           if (arrObj[i].type == "checkbox") {
               if (arrObj[i].checked) {
					cnt++;
					if(cnt==1)
						getstr+= "'"+arrObj[i].value+"'";
					else
						getstr+= ",'"+arrObj[i].value+"'";
				}
		   }
		}
		return getstr;
}


function callChartDisplay(){//on click on compare button
		var messageFrame = parent.parent.parent.messageFrame;
		var formObj =parent.parent.parent.frames[2].document.forms[0];
		var eval_type = getRadioButtonValues(formObj.evaluation);
		if(formObj != null){
			var numbering_system_title=getLabel("eOH.NumberingSystem.Label","OH");
			var chart_title=getLabel("Common.Chart.label","Common");
		if(eval_type=="BE"){
			var baselinechrt_title=getLabel("eOH.BaselineChart.Label","OH");
			var evalchrt_title=getLabel("eOH.EvaluationChart.Label","OH");
		}else{
			var baselinechrt_title=getLabel("eOH.EvaluationChart.Label","OH")+"1";
			var evalchrt_title=getLabel("eOH.EvaluationChart.Label","OH")+"2";
		}
			var fields = new Array (formObj.perio_numbering_system,formObj.perio_chart,formObj.base_chart1,formObj.eval_chart);
			var names = new Array ( numbering_system_title,chart_title,baselinechrt_title,evalchrt_title);
		}
		if(!checkFieldsofMst( fields, names, messageFrame)){
				return false;
		}
		var arrObj = document.all['comp'].elements;
		var getstr =getSelectedChkBox(arrObj);
		if(getstr.length==0){
			var msg = getMessage("APP-OH00054","OH");
			alert(msg);
			return false
		}
		var tooth_numbering_system = formObj.tooth_numbering_system.value; //Form params..
		var oh_chart_level = formObj.oh_chart_level.value; //Added by Sridevi on 5/12/2010 for IN021300
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var basechart = formObj.base_chart1.value; 
		var params_str = parent.parent.parent.perioChartMainDummyFrame.document.forms[0].ca_params.value //PerioChartMain
		//var quadrant = getRadioButtonValues(formObj.quadrant);
		var quadrant = formObj.quadrant.value;
		var chart_code = formObj.perio_chart.value;
		var eval_chart1=formObj.base_chart1.value;
		var eval_chart2=formObj.eval_chart.value;
		var no_of_charts = formObj.no_of_charts.value;
		var eval_chart3="";
		var eval_chart_num3="";
		var eval_chart_line_num3="";
		if(no_of_charts=="3"){
		eval_chart3=formObj.base_chart2.value;
		eval_chart_num3 = eval_chart3.split("@@")[1];
		eval_chart_line_num3=eval_chart3.split("@@")[2];
		}

		var numbering_system=formObj.perio_numbering_system.value
		var chart_flag="";
		var selected_val1 = formObj.selected_val1.value;
		var selected_val2 = formObj.selected_val2.value;
		var selected_val3 = formObj.selected_val3.value;
		//var chart_num = eval_chart1.split("@@")[1];
		var eval_chart_num1=eval_chart1.split("@@")[1];
		var eval_chart_line_num1=eval_chart1.split("@@")[2];
		var eval_chart_num2 = eval_chart2.split("@@")[1];
		var eval_chart_line_num2=eval_chart2.split("@@")[2];
		var arr_date1=(formObj.base_chart1.options[formObj.base_chart1.selectedIndex].text).split("-");
		var eval_chart_date1=arr_date1[2]+"/"+getMonth(arr_date1[3]);
		var arr_date2=(formObj.eval_chart.options[formObj.eval_chart.selectedIndex].text).split("-");
		
		var eval_chart_date2=arr_date2[2]+"/"+getMonth(arr_date2[3]);
		var patient_id = formObj.patient_id.value;
		//var params = params_str+"&numbering_system="+tooth_numbering_system+"&patient_id="+patient_id+"&components="+getstr;
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		//Passed oh_chart_level for IN021300 by Sridevi Joshi on 5/11/2010
		var params = "numbering_system="+tooth_numbering_system+"&patient_id="+patient_id+"&chart_flag="+chart_flag+"&oh_chart_level="+oh_chart_level;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","buildPerioParameters.jsp?func_mode=buildPerioParameters&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		var ret_params=localTrimString(retVal);
//		var params =params_str+ret_params+"&numbering_system="+tooth_numbering_system+"&main_tab=Compare&eval_type="+eval_type+"&quadrant="+quadrant+"&chart_code="+chart_code+"&eval_chart_line_num1="+eval_chart_line_num1+"&eval_chart_line_num2="+eval_chart_line_num2+"&numbering_system="+numbering_system+"&components="+getstr+"&eval_chart_num1="+eval_chart_num1+"&eval_chart_num2="+eval_chart_num1+"&eval_chart_date1="+eval_chart_date1+"&eval_chart_date2="+eval_chart_date1+"&patient_id="+patient_id+"&permanent_deciduous_flag=P";
		var params =params_str+ret_params+"&numbering_system="+tooth_numbering_system+"&main_tab=Compare&eval_type="+eval_type+"&quadrant="+quadrant+"&chart_code="+chart_code+"&eval_chart_line_num1="+eval_chart_line_num1+"&eval_chart_line_num2="+eval_chart_line_num2+"&eval_chart_line_num3="+eval_chart_line_num3+"&numbering_system="+numbering_system+"&components="+getstr+"&eval_chart_num1="+eval_chart_num1+"&eval_chart_num2="+eval_chart_num2+"&eval_chart_num3="+eval_chart_num3+"&eval_chart_date1="+eval_chart_date1+"&eval_chart_date2="+eval_chart_date1+"&patient_id="+patient_id+"&permanent_deciduous_flag=P"+"&selected_val1="+selected_val1+"&selected_val2="+selected_val2+"&selected_val3="+selected_val3+"&no_of_charts="+no_of_charts+"&chart_compare="+no_of_charts+"&oh_chart_level="+oh_chart_level;
		parent.frames[1].location.href="../../eOH/jsp/PerioCompareChartDisplay.jsp?"+params;

}


		function localTrimString(sInString){
		  return sInString.replace(/^\s+|\s+$/g,"");
		}


		function PopulateListItem(){
			var formObj = document.forms[0];
			var eval_type = getRadioButtonValues(formObj.evaluation);
			switch(eval_type){
				case "BB" : populateBothBaseLineChart(); break;
				case "BE" : PopulateBaseLineChart(); break;
				case "EE" : populateBothEvalListItem(); break;
			}
		}

	async function showGraphDialog(){
		var formObj =parent.parent.parent.frames[2].document.forms[0];
		var permanent_deciduous_flag = formObj.permanent_deciduous_flag.value;
		var tooth_numbering_system = formObj.tooth_numbering_system.value;
		var basechart = formObj.base_chart1.value; 
		var no_of_charts = formObj.no_of_charts.value;
		var eval_chart2="";
		var eval_chart_num3="";
		var eval_chart_line_num3="";
		if(no_of_charts=="3"){
		eval_chart2=formObj.base_chart2.value;
		eval_chart_num3 = eval_chart2.split("@@")[1];
		eval_chart_line_num3=eval_chart2.split("@@")[2];
		}
		var eval_chart=formObj.eval_chart.value;
		var eval_type = getRadioButtonValues(formObj.evaluation);
		var selected_val1 = formObj.selected_val1.value;
		var selected_val2 = formObj.selected_val2.value;
		var selected_val3 = formObj.selected_val3.value;
		var chart_code = formObj.perio_chart.value;
		var quadrant = formObj.quadrant.value;
		//var perio_arch = (quadrant=="1"||quadrant=="4")?"U":"L";
		var perio_arch = (quadrant=="1"||quadrant=="2")?"U":"L";
		var patient_id = formObj.patient_id.value;
		var eval_chart_num1=basechart.split("@@")[1];
		var eval_chart_line_num1=basechart.split("@@")[2];
		var eval_chart_num2 = eval_chart.split("@@")[1];
		var eval_chart_line_num2=eval_chart.split("@@")[2];
		var arr_date1=(formObj.base_chart1.options[formObj.base_chart1.selectedIndex].text).split("-");
		//var eval_chart_date1=arr_date1[2]+"/"+getMonth(arr_date1[3]);//commented for CRF#0423
		var eval_chart_date1=(arr_date1[4])+"/"+(arr_date1[5])+"/"+(arr_date1[6]);
		var arr_date2=(formObj.eval_chart.options[formObj.eval_chart.selectedIndex].text).split("-");
		//var eval_chart_date2=arr_date2[2]+"/"+getMonth(arr_date2[3]);
		var eval_chart_date2=(arr_date2[4])+"/"+(arr_date2[5])+"/"+(arr_date2[6]);

	//chart_num,chart_line_num,chart_code,perio_arch,tooth_numbering_system,permanent_deciduous_flag
	/*var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;*/
	//var params = 'patient_id='+patient_id+"&chart_code="+chart_code+'&chart_num1='+eval_chart_num1+'&chart_line_num1='+eval_chart_num1+"&chart_num2="+eval_chart_num2+"&chart_line_num2="+eval_chart_line_num2+"&perio_arch="+perio_arch+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag=P&eval_type="+eval_type;
	//var url	= "../../eOH/jsp/PerioTestGraph.jsp?"+params;
	var params = 'patient_id='+patient_id+"&chart_code="+chart_code+'&chart_num1='+eval_chart_num1+'&chart_line_num1='+eval_chart_line_num1+"&chart_num2="+eval_chart_num2+"&chart_line_num2="+eval_chart_line_num2+"&chart_num3="+eval_chart_num3+"&chart_line_num3="+eval_chart_line_num3+"&perio_arch="+perio_arch+"&tooth_numbering_system="+tooth_numbering_system+"&permanent_deciduous_flag=P&eval_type="+eval_type+"&eval_chart_date1="+eval_chart_date1+"&eval_chart_date2="+eval_chart_date2+"&selected_val1="+selected_val1+"&selected_val2="+selected_val2+"&selected_val3="+selected_val3+"&no_of_charts="+no_of_charts+"&quadrant="+quadrant;
	var url	= "../../eOH/jsp/PerioCompareGraphFrames.jsp?"+params;
	var dialogHeight= "50vh" ;
	var dialogWidth	= "60vw" ;
	var dialogTop ="125";
	var dialogLeft ="525";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll:no	; status:" + status;
	//var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll:auto; status:" + status;
	await window.showModalDialog(url,arguments,features);
	//window.open(url,arguments,features);*/
}

function clearAllSelect(){
	var formObj =document.forms[0];
	removeAll(formObj.base_chart1); 
	removeAll(formObj.eval_chart);
	formObj.perio_chart.value="";
}
