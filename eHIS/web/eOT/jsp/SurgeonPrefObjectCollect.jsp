<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<html>
<head>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>		                      
<script language="javascript">
	var rows_for_consumables = new Array();
	var rows_for_equipments = new Array();
	var rows_for_instruments = new Array();
	var rows_for_prosthesis = new Array();
	var rows_for_personnel = new Array();
</script>
<script language="javascript">
	function createXMLHeader(){
		var formObj=parent.frames[0].document.forms[0];
		var  header = "";
	    header+="surgeon_code=\""+formObj.surgeon_code.value+"\""+" ";
		header+="appl_desc=\""+formObj.appl_desc.value+"\""+" ";
		header+="speciality_code=\""+formObj.speciality_code.value+"\""+" ";
		header+="category_code=\""+formObj.category_code.value+"\""+" ";
		header+="subCategory_code=\""+formObj.subCategory_code.value+"\""+" ";
		header+="operation_code=\""+formObj.operation_code.value+"\""+" ";
		return  header;

	}
	function createXMLDetails(rows){
		var table_name="OT_OPER_DR_PREFERENCE";
		var xmlString="";
		var header = createXMLHeader();
		for(j in rows){
			if(rows[j].mode!='L'){
			xmlString+="<OT_OPER_DR_PREFERENCE"+j+" ";
			xmlString+=header;
			switch(rows[j].type){
				case 'E':
					xmlString+="code=\""+rows[j].equipment_code+"\""+" ";
					xmlString+="units=\""+rows[j].no_Of_Units+"\""+" ";
					break;
				case 'I': 
					xmlString+="code=\""+rows[j].instr_code+"\""+" ";
					xmlString+="units=\""+rows[j].no_Of_Units+"\""+" ";				
					break;
				case 'P': 
					xmlString+="code=\""+rows[j].packs_code+"\""+" ";
					xmlString+="units=\""+rows[j].no_Of_Units+"\""+" ";
					break;
				case'R': 
					xmlString+="code=\""+rows[j].role_id+"\""+" ";
					xmlString+="units=\""+rows[j].no_Of_Persons+"\""+" ";
					break;
				case 'S': 
					xmlString+="code=\""+rows[j].prosthesis_code+"\""+" ";
					xmlString+="units=\""+rows[j].no_Of_Units+"\""+" ";
					break;
			}
			xmlString+="type=\""+rows[j].type+"\""+" ";
			xmlString+="mode=\""+rows[j].mode+"\""+" ";
			xmlString+="table_name=\""+table_name+"\""+" />";
		 }
		}
		 return xmlString;
	}

	function formXMLString(){
		 var xmlString = "";
		 xmlString+=(rows_for_consumables.length>0)?createXMLDetails(rows_for_consumables):"";
		 xmlString+=(rows_for_equipments.length>0)?createXMLDetails(rows_for_equipments):"";
		 xmlString+=(rows_for_prosthesis.length>0)?createXMLDetails(rows_for_prosthesis):"";
		 xmlString+=(rows_for_instruments.length>0)?createXMLDetails(rows_for_instruments):"";
		 xmlString+=(rows_for_personnel.length>0)?createXMLDetails(rows_for_personnel):"";
		 return xmlString;
		
	}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ObjectCollectForm" id="ObjectCollectForm">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

