/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
		var previous=null; 
		var clicked =new Array(30);
		var previousIndex=0
		var prev=0;
		var prevcol='MENUSUBLEVELCOLOR';
		for(i=0;i<30;i++)
			clicked[i]=false;
		function mouseClickChangeMenuColor(tblrow,index)
		{
			if(previous!=null)
				previous.cells(0).className='MENUSUBLEVELCOLOR';
			tblrow.cells(0).className='MENUSELECTEDCOLOR';
			previous=tblrow;
			clicked[previousIndex]=false
			clicked[index]=true;
			previousIndex=index;
		}
		function swapPictureOnClick(obj,divTag)
		{
			var innerText=obj.innerText;
			if (innerText=="+") 
				obj.innerText="-"
			else
				obj.innerText="+";

			if(divTag.style.display=="inline")
				divTag.style.display="none";
			else
				divTag.style.display="inline";
		}
	function showFunction(function_id)
		{
			eval("parent.frames[1].location.href='"+subfunctions[function_id]+"'");
		}
	function chcol(ro)
		{
				document.getElementById("t").rows(prev).cells(0).className=prevcol
				prevcol=ro.cells(0).className
				ro.cells(0).className="MENUSELECTEDCOLOR"
				prev=ro.rowIndex;
		}
	function callJSPs(val)
		{
		
			// Link for SS
			if(val == 'SterilizationType')
				parent.frames[1].location.href = '../../eSS/jsp/SterilizationType.jsp?module_id=SS&function_id=SS_STERILIZATION_TYPE&function_name='+encodeURIComponent(getLabel("eSS.SterilizationType.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'SurgeryType')
				parent.frames[1].location.href = '../../eSS/jsp/SurgeryType.jsp?module_id=SS&function_id=SS_SURGERY_TYPE&function_name='+encodeURIComponent(getLabel("eSS.SurgeryType.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'ServiceLocation')
				parent.frames[1].location.href = '../../eSS/jsp/ServiceLocation.jsp?module_id=SS&function_id=SS_SERVICE_LOCATION&function_name='+encodeURIComponent(getLabel("eSS.ServiceLocation.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'Autoclave_Washing_Unit')
				parent.frames[1].location.href = '../../eSS/jsp/AutoclaveWashingUnit.jsp?module_id=SS&function_id=SS_AUTOCLAVE_WASH_UNIT&function_name='+encodeURIComponent(getLabel("eSS.AutoclaveWashingUnit.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'Autoclave_Washing_Test')
				parent.frames[1].location.href = '../../eSS/jsp/AutoclaveWashingTest.jsp?module_id=SS&function_id=SS_AUTOCLAVE_WASH_TEST&function_name='+encodeURIComponent(getLabel("eSS.AutoclaveWashingTest.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'WriteoffReason')
				parent.frames[1].location.href = '../../eSS/jsp/WriteOffReason.jsp?module_id=SS&function_id=SS_WRITE_OFF_REASON&function_name='+encodeURIComponent(getLabel("eSS.WriteoffReason.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'UsageType')
				parent.frames[1].location.href = '../../eSS/jsp/UsageType.jsp?module_id=SS&function_id=SS_USAGE_TYPE&function_name='+encodeURIComponent(getLabel("eSS.UsageType.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'SubClassification')
				parent.frames[1].location.href = '../../eSS/jsp/SubClassification.jsp?module_id=SS&function_id=SS_SUB_CLASSIFICATION&function_name='+encodeURIComponent(getLabel("eSS.SubClassification.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'SterilizationProcessStage')
				parent.frames[1].location.href = '../../eSS/jsp/SterilizationProcessStage.jsp?module_id=SS&function_id=SS_STER_PROCESS_STAGE&function_name='+encodeURIComponent(getLabel("eSS.SterilizationProcessStage.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'WashingType')
				parent.frames[1].location.href = '../../eSS/jsp/WashingType.jsp?module_id=SS&function_id=SS_WASHING_TYPE&function_name='+encodeURIComponent(getLabel("eSS.WashingType.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'StatisticalGroup')
				parent.frames[1].location.href = '../../eSS/jsp/StatisticalGroup.jsp?module_id=SS&function_id=SS_STAT_GROUP&function_name='+encodeURIComponent(getLabel("eSS.StatisticalGroup.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'CSSDStore')
				parent.frames[1].location.href = '../../eSS/jsp/Store.jsp?module_id=SS&function_id=SS_STORE&function_name='+encodeURIComponent(getLabel("eSS.CSSDStore.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'CSSDItem')
				parent.frames[1].location.href = '../../eSS/jsp/Item.jsp?module_id=SS&function_id=SS_ITEM&function_name='+encodeURIComponent(getLabel("eSS.CSSDItem.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'CSSDGroup')
				parent.frames[1].location.href = '../../eSS/jsp/Group.jsp?module_id=SS&function_id=SS_GROUP&function_name='+encodeURIComponent(getLabel("eSS.CSSDGroup.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'SterilizationCost')
				parent.frames[1].location.href = '../../eSS/jsp/SterilizationCost.jsp?module_id=SS&function_id=SS_STERILIZATION_COST&function_name='+encodeURIComponent(getLabel("eSS.SterilizationCost.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'AlternateGroup')
				parent.frames[1].location.href = '../../eSS/jsp/AlternateGroup.jsp?module_id=SS&function_id=SS_ALTERNATE_GROUP&function_name='+encodeURIComponent(getLabel("eSS.AlternateGroup.label","SS"))+'&function_type=C&access=YYYNN';
			if(val == 'GroupforStore')
				parent.frames[1].location.href = '../../eSS/jsp/GroupForStore.jsp?module_id=SS&function_id=SS_GROUP_FOR_STORE&function_name='+encodeURIComponent(getLabel("eSS.GroupforStore.label","SS"))+'&function_type=C&access=YYYNN';
			
		}
