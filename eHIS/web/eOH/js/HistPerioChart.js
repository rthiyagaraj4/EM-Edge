async function viewPerioHistory(chart_num,chart_line_num,perio_chart,patient_id,called_from){
	alert("viewPerioHistory");
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&called_from="+called_from;

	var url	= "../../eOH/jsp/OHPerioHistory.jsp?"+params;
	
	var dialogHeight= "40vh" ;
	var dialogWidth	= "65vw" ;
	var dialogTop ="215";
	var dialogLeft ="29";
	var status = "no";
	var arguments	= "" ;
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +"  ;dialogTop:" + dialogTop +"  ;dialogLeft:" + dialogLeft + ";scroll=auto; status:" + status;
	await window.showModalDialog(url,arguments,features);
	
}

function loadSurfaceValuesForHistory(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
	var baseline_active_yn = formObj.baseline_active_yn.value;
	var baseline_closed_yn = formObj.baseline_closed_yn.value;
	var oh_chart_level = formObj.oh_chart_level.value;
		/*
		//To get the components recorded for a chart
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "perio_chart="+perio_chart;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getChartComponents&"+params,false);
		xmlHttp.send(xmlDoc);
		var component_codes_str = trimString(xmlHttp.responseText); //Components Codes
		*/
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&tab_code=BC"+"&oh_chart_level="+oh_chart_level;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllDetailRecords&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		/*
		if(retVal.length >1){
			var retVal_arr = retVal.split("~");
			for(i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
					var component_codes_arr = component_codes_str.split("~");
					for(k=0;k<component_codes_arr.length-1;k++){
						var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
						var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
						var td_id_val = component_codes_arr[k]+code_desc_arr[1];

						if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
							document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
							document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

							document.getElementById(td_id_B).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
							document.getElementById(td_id_P).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						}

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />";
							}
						}
					}
				}
				else if(code_desc_arr[0] == "LOC"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];
					if(code_desc_arr[8] == "1"){
						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/LOC.gif' />";
							}
						}
					}
					else{
						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
							}
						}
					}
				}else if(code_desc_arr[0] == "FUIN"){
					if(code_desc_arr[8] == "1"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc1.gif' />";
							}
						}
					}
					else if(code_desc_arr[8] == "2"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc2.gif' />";
							}
						}
					}
					else if(code_desc_arr[8] == "3"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc3.gif' />";
							}
						}
					}
				}
				else{
					var element_B_id = code_desc_arr[0]+code_desc_arr[1]+"B";
					var element_P_id = code_desc_arr[0]+code_desc_arr[1]+"P";
					var element_val_id = code_desc_arr[0]+code_desc_arr[1];
						var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
						tab_data1 = tab_data1+ "<tr>";
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
						tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
						tab_data1 = tab_data1+"</tr>";
						tab_data1 = tab_data1+"</table>"
						var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
						tab_data2 = tab_data2+ "<tr>";
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
						tab_data2 = tab_data2+"</tr>";
						tab_data2 = tab_data2+"</table>"

					if(document.getElementById(element_B_id) != null && document.getElementById(element_B_id) != "null" && document.getElementById(element_B_id) != "undefined" && document.getElementById(element_B_id) != undefined){
						document.getElementById(element_B_id).style.backgroundColor = 'white';
						document.getElementById(element_P_id).style.backgroundColor = 'white';
						document.getElementById(element_B_id).innerHTML = tab_data1;
						document.getElementById(element_P_id).innerHTML = tab_data2;
					}

					if(document.getElementById(element_val_id) != null && document.getElementById(element_val_id) != "null" && document.getElementById(element_val_id) != "undefined" && document.getElementById(element_val_id) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(element_val_id).innerHTML = code_desc_arr[8];
						}
					}
				}
			}
		}
		*/
		return retVal;
}
function loadSurfaceStaticValuesForHistory(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
	var baseline_active_yn = formObj.baseline_active_yn.value;
	var baseline_closed_yn = formObj.baseline_closed_yn.value;
	var baseline_closed_yn = formObj.baseline_closed_yn.value;
	var retVal = formObj.hist_image_values.value;

		//To get the components recorded for a chart
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "perio_chart="+perio_chart;
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getChartComponents&"+params,false);
		xmlHttp.send(xmlDoc);
		var component_codes_str = trimString(xmlHttp.responseText); //Components Codes

		/*
		
		var xmlDoc = "" ;
		var xmlHttp = new XMLHttpRequest();
		var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&baseline_active_yn="+baseline_active_yn+"&baseline_closed_yn="+baseline_closed_yn+"&tab_code=BC";
		var xmlStr ="<root><SEARCH ";
		xmlStr +=" /></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllDetailRecords&"+params,false);
		xmlHttp.send(xmlDoc);
		var retVal = trimString(xmlHttp.responseText);
		*/
		//var retVal = formObj.hist_image_values.value;
		//retVal= unescape("BOP%23%2317%23%231%23%231%23%231%23%231%23%231%23%231%23%23%7EBOP%23%2318%23%231%23%231%23%231%23%231%23%231%23%231%23%23%7E");
		if(retVal.length >1){
			var retVal_arr = retVal.split("~");
			for(i=0;i<retVal_arr.length-1;i++){
				var code_desc_arr = retVal_arr[i].split("##");
				if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
					var component_codes_arr = component_codes_str.split("~");
					for(k=0;k<component_codes_arr.length-1;k++){
						var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
						var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
						var td_id_val = component_codes_arr[k]+code_desc_arr[1];

						if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
							//document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
							//document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

							document.getElementById(td_id_B).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
							document.getElementById(td_id_P).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						}

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />";
							}
						}
					}
				}
				else if(code_desc_arr[0] == "LOC"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];
					if(code_desc_arr[8] == "1"){
						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/LOC.gif' />";
							}
						}
					}
					else{
						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
							}
						}
					}
				}else if(code_desc_arr[0] == "FUIN"){
					if(code_desc_arr[8] == "1"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc1.gif' />";
							}
						}
					}
					else if(code_desc_arr[8] == "2"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc2.gif' />";
							}
						}
					}
					else if(code_desc_arr[8] == "3"){
						var td_id_val = code_desc_arr[0]+code_desc_arr[1];

						if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
							if(code_desc_arr[8] != ""){
								document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc3.gif' />";
							}
						}
					}
				}
				else{

					//Added by Sharon Crasta on 5/27/2009 for IN010915
					var cut_off = "";
					var xmlDoc = "" ;
					var xmlHttp = new XMLHttpRequest();
					var params = "chart_code="+perio_chart+"&component_code="+code_desc_arr[0];
					var xmlStr ="<root><SEARCH ";
					xmlStr +=" /></root>";
					xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
					xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getCutOffValues&"+params,false);
					xmlHttp.send(xmlDoc);
					cut_off = trimString(xmlHttp.responseText);
					//

					var element_B_id = code_desc_arr[0]+code_desc_arr[1]+"B";
					var element_P_id = code_desc_arr[0]+code_desc_arr[1]+"P";
					var element_val_id = code_desc_arr[0]+code_desc_arr[1];
					 //Commented and Added by Sharon Crasta on 5/27/2009 for IN010915
					/*var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
					tab_data1 = tab_data1+ "<tr>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
					tab_data1 = tab_data1+"</tr>";
					tab_data1 = tab_data1+"</table>"
					var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
					tab_data2 = tab_data2+ "<tr>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
					tab_data2 = tab_data2+"</tr>";
					tab_data2 = tab_data2+"</table>"*/
				  
					var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
					tab_data1 = tab_data1+ "<tr>";
					if (parseInt(code_desc_arr[2])>=parseInt(cut_off)){		
							tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[2]+"</td>";
					}else{
							tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
					}
					if (parseInt(code_desc_arr[3])>=parseInt(cut_off)){		
							tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[3]+"</td>";
					}else{
							tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
					}
					if (parseInt(code_desc_arr[4])>=parseInt(cut_off)){		
							tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[4]+"</td>";
					}else{
							tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
					}
									
					tab_data1 = tab_data1+"</tr>";
					tab_data1 = tab_data1+"</table>"
				
					var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" >';
					tab_data2 = tab_data2+ "<tr>";
					if (parseInt(code_desc_arr[5])>=parseInt(cut_off)){		
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[5]+"</td>";

				   }else{
					   tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
				   }
					if (parseInt(code_desc_arr[6])>=parseInt(cut_off)){		
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[6]+"</td>";
					}else{
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
					}
					if (parseInt(code_desc_arr[7])>=parseInt(cut_off)){		
						tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[7]+"</td>";
					}else{
						tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
					}

					tab_data2 = tab_data2+"</tr>";
					tab_data2 = tab_data2+"</table>"
					//

					if(document.getElementById(element_B_id) != null && document.getElementById(element_B_id) != "null" && document.getElementById(element_B_id) != "undefined" && document.getElementById(element_B_id) != undefined){
						//document.getElementById(element_B_id).style.backgroundColor = 'white';
						//document.getElementById(element_P_id).style.backgroundColor = 'white';
						document.getElementById(element_B_id).innerHTML = tab_data1;
						document.getElementById(element_P_id).innerHTML = tab_data2;
					}

					if(document.getElementById(element_val_id) != null && document.getElementById(element_val_id) != "null" && document.getElementById(element_val_id) != "undefined" && document.getElementById(element_val_id) != undefined){
						if(code_desc_arr[8] != ""){
							//Added by Sharon Crasta on 5/27/2009 for IN010915
							if(code_desc_arr[8] >= cut_off){
								document.getElementById(element_val_id).innerHTML = "<font size='2.5' color='red'>"+code_desc_arr[8]+"</font>";
							}else{
								document.getElementById(element_val_id).innerHTML = code_desc_arr[8];
							}
						}
					}
				}
			}
		}
}
function loadEvalSurfaceValuesForHistory(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
/*
	//To get the components recorded for a chart
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "perio_chart="+perio_chart;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getChartComponents&"+params,false);
	xmlHttp.send(xmlDoc);
	var component_codes_str = trimString(xmlHttp.responseText); //Components Codes
	*/
	
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&eval_active_yn=N&tab_code=EC";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllDetailRecords&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	/*
	if(retVal.length >1){
		var retVal_arr = retVal.split("~");
		for(i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
				var component_codes_arr = component_codes_str.split("~");
				for(k=0;k<component_codes_arr.length-1;k++){
					var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
					var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
					var td_id_val = component_codes_arr[k]+code_desc_arr[1];

					if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
						document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
						document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

						document.getElementById(td_id_B).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						document.getElementById(td_id_P).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
					}

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						}
					}
				}
			}
			else if(code_desc_arr[0] == "LOC"){
				var td_id_val = code_desc_arr[0]+code_desc_arr[1];
				if(code_desc_arr[8] == "1"){
					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/LOC.gif' />";
						}
					}
				}
				else{
					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
						}
					}
				}
			}else if(code_desc_arr[0] == "FUIN"){
				if(code_desc_arr[8] == "1"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc1.gif' />";
						}
					}
				}
				else if(code_desc_arr[8] == "2"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc2.gif' />";
						}
					}
				}
				else if(code_desc_arr[8] == "3"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc3.gif' />";
						}
					}
				}
			}
			else{
				var element_B_id = code_desc_arr[0]+code_desc_arr[1]+"B";
				var element_P_id = code_desc_arr[0]+code_desc_arr[1]+"P";
				var element_val_id = code_desc_arr[0]+code_desc_arr[1];
					var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
					tab_data1 = tab_data1+ "<tr>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
					tab_data1 = tab_data1+"</tr>";
					tab_data1 = tab_data1+"</table>"

					var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
					tab_data2 = tab_data2+ "<tr>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
					tab_data2 = tab_data2+"</tr>";
					tab_data2 = tab_data2+"</table>"

				if(document.getElementById(element_B_id) != null && document.getElementById(element_B_id) != "null" && document.getElementById(element_B_id) != "undefined" && document.getElementById(element_B_id) != undefined){
					document.getElementById(element_B_id).style.backgroundColor = 'white';
					document.getElementById(element_P_id).style.backgroundColor = 'white';
					document.getElementById(element_B_id).innerHTML = tab_data1;
					document.getElementById(element_P_id).innerHTML = tab_data2;
				}

				if(document.getElementById(element_val_id) != null && document.getElementById(element_val_id) != "null" && document.getElementById(element_val_id) != "undefined" && document.getElementById(element_val_id) != undefined){
					if(code_desc_arr[8] != ""){
						if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
							document.getElementById(element_val_id).innerHTML = "<font size='4' color='red'>X</font>";
						}
						else{
							document.getElementById(element_val_id).innerHTML = code_desc_arr[8];
						}
					}
				}
			}
		}
	}
	*/
	return retVal;
}
function loadEvalSurfaceStaticValuesForHistory(){
	var formObj = document.forms[0];
	var patient_id = formObj.patient_id.value;
	var chart_num = formObj.chart_num.value;
	var chart_line_num = formObj.chart_line_num.value;
	var perio_chart = formObj.perio_chart.value;
	var perio_chart = formObj.perio_chart.value;
	var retVal = formObj.hist_image_values.value;

	//To get the components recorded for a chart
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "perio_chart="+perio_chart;
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getChartComponents&"+params,false);
	xmlHttp.send(xmlDoc);
	var component_codes_str = trimString(xmlHttp.responseText); //Components Codes
	/*
	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest();
	var params = "patient_id="+patient_id+"&chart_num="+chart_num+"&chart_line_num="+chart_line_num+"&perio_chart="+perio_chart+"&eval_active_yn=N&tab_code=EC";
	var xmlStr ="<root><SEARCH ";
	xmlStr +=" /></root>";
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getAllDetailRecords&"+params,false);
	xmlHttp.send(xmlDoc);
	var retVal = trimString(xmlHttp.responseText);
	*/
	if(retVal.length >1){
		var retVal_arr = retVal.split("~");
		for(i=0;i<retVal_arr.length-1;i++){
			var code_desc_arr = retVal_arr[i].split("##");
			if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
				var component_codes_arr = component_codes_str.split("~");
				for(k=0;k<component_codes_arr.length-1;k++){
					var td_id_B = component_codes_arr[k]+code_desc_arr[1]+"B";
					var td_id_P = component_codes_arr[k]+code_desc_arr[1]+"P";
					var td_id_val = component_codes_arr[k]+code_desc_arr[1];

					if(document.getElementById(td_id_B) != null && document.getElementById(td_id_B) != "null" && document.getElementById(td_id_B) != "undefined" && document.getElementById(td_id_B) != undefined){
						//document.getElementById(td_id_B).style.backgroundColor = '#E2E3F0';
						//document.getElementById(td_id_P).style.backgroundColor = '#E2E3F0';

						document.getElementById(td_id_B).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						document.getElementById(td_id_P).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
					}

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/MissingTeeth.gif' />"
						}
					}
				}
			}
			else if(code_desc_arr[0] == "LOC"){
				var td_id_val = code_desc_arr[0]+code_desc_arr[1];
				if(code_desc_arr[8] == "1"){
					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/LOC.gif' />";
						}
					}
				}
				else{
					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "&nbsp;&nbsp;";
						}
					}
				}
			}else if(code_desc_arr[0] == "FUIN"){
				if(code_desc_arr[8] == "1"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc1.gif' />";
						}
					}
				}
				else if(code_desc_arr[8] == "2"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc2.gif' />";
						}
					}
				}
				else if(code_desc_arr[8] == "3"){
					var td_id_val = code_desc_arr[0]+code_desc_arr[1];

					if(document.getElementById(td_id_val) != null && document.getElementById(td_id_val) != "null" && document.getElementById(td_id_val) != "undefined" && document.getElementById(td_id_val) != undefined){
						if(code_desc_arr[8] != ""){
							document.getElementById(td_id_val).innerHTML = "<img src='../../eOH/images/Furc3.gif' />";
						}
					}
				}
			}
			else{
				var element_B_id = code_desc_arr[0]+code_desc_arr[1]+"B";
				var element_P_id = code_desc_arr[0]+code_desc_arr[1]+"P";
				var element_val_id = code_desc_arr[0]+code_desc_arr[1];
				//Commented and Added by Sharon Crasta on 5/27/2009 for IN010915
				/*var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
				tab_data1 = tab_data1+ "<tr>";
				tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
				tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
				tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
				tab_data1 = tab_data1+"</tr>";
				tab_data1 = tab_data1+"</table>"

				var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
				tab_data2 = tab_data2+ "<tr>";
				tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
				tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
				tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
				tab_data2 = tab_data2+"</tr>";	 
				tab_data2 = tab_data2+"</table>" */

				var cut_off = "";
				var xmlDoc = "" ;
				var xmlHttp = new XMLHttpRequest();
				var params = "chart_code="+perio_chart+"&component_code="+code_desc_arr[0];
				var xmlStr ="<root><SEARCH ";
				xmlStr +=" /></root>";
				xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
				xmlHttp.open("POST","../../eOH/jsp/HistCommonValidation.jsp?func_mode=getCutOffValues&"+params,false);
				xmlHttp.send(xmlDoc);
				var cut_off = trimString(xmlHttp.responseText);

				var tab_data1 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
				tab_data1 = tab_data1+ "<tr>";
				if (parseInt(code_desc_arr[2])>=parseInt(cut_off)){		
					tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[2]+"</td>";
				}else{
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[2]+"</td>";
				}
				if (parseInt(code_desc_arr[3])>=parseInt(cut_off)){		
					tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[3]+"</td>";
				}else{
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[3]+"</td>";
				}
				if (parseInt(code_desc_arr[4])>=parseInt(cut_off)){		
					tab_data1 = tab_data1+"<td nowrap><font color='red'>"+code_desc_arr[4]+"</td>";
				}else{
					tab_data1 = tab_data1+"<td nowrap>"+code_desc_arr[4]+"</td>";
				}

				tab_data1 = tab_data1+"</tr>";
				tab_data1 = tab_data1+"</table>"

				var tab_data2 = '<table width="100%" cellpadding =0 cellspacing=2 border ="0" align="center">';
				tab_data2 = tab_data2+ "<tr>";
				if (parseInt(code_desc_arr[5])>=parseInt(cut_off)){		
					tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[5]+"</td>";
				}else{
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[5]+"</td>";
				}
				if (parseInt(code_desc_arr[6])>=parseInt(cut_off)){		
					tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[6]+"</td>";
				}else{
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[6]+"</td>";
				}
				if (parseInt(code_desc_arr[7])>=parseInt(cut_off)){		
					tab_data2 = tab_data2+"<td nowrap><font color='red'>"+code_desc_arr[7]+"</td>";

				}else{
					tab_data2 = tab_data2+"<td nowrap>"+code_desc_arr[7]+"</td>";
				}

				tab_data2 = tab_data2+"</tr>";
				tab_data2 = tab_data2+"</table>";
				//
				if(document.getElementById(element_B_id) != null && document.getElementById(element_B_id) != "null" && document.getElementById(element_B_id) != "undefined" && document.getElementById(element_B_id) != undefined){
					//document.getElementById(element_B_id).style.backgroundColor = 'white';
					//document.getElementById(element_P_id).style.backgroundColor = 'white';
					document.getElementById(element_B_id).innerHTML = tab_data1;
					document.getElementById(element_P_id).innerHTML = tab_data2;
				}

				if(document.getElementById(element_val_id) != null && document.getElementById(element_val_id) != "null" && document.getElementById(element_val_id) != "undefined" && document.getElementById(element_val_id) != undefined){
					if(code_desc_arr[8] != ""){
						if(code_desc_arr[0] == "MITH" && code_desc_arr[8] == "1"){
							document.getElementById(element_val_id).innerHTML = "<font size='4' color='red'>X</font>";
						}
						else{
							//Commented and Added by Sharon Crasta on 5/27/2009 for IN010915
							//document.getElementById(element_val_id).innerHTML = code_desc_arr[8];
							if (code_desc_arr[8] >= cut_off){
								document.getElementById(element_val_id).innerHTML = "<font size='2.5' color='red'>"+code_desc_arr[8]+"</font>";
							}else{
								document.getElementById(element_val_id).innerHTML = code_desc_arr[8];
							}
							//
						}
					}
				}
			}
		}
	}
}
