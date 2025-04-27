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

			// Link for MM 
			if(val == 'MaterialGroup')
				parent.frames[1].location.href = '../../eMM/jsp/MaterialsGroup.jsp?module_id=MM&function_id=MM_MATERIALS_GROUP&function_name='+encodeURIComponent(getLabel("eMM.MaterialGroup.label","MM"))+'&function_type=C&access=YYYNN';

			if(val == 'UserAccessForMaterialGroup')
				parent.frames[1].location.href = '../../eMM/jsp/UserAccessForMaterialGroup.jsp?module_id=MM&function_id=MM_USER_MATERIAL_GROUP&function_name='+encodeURIComponent(getLabel("eMM.UserAccessForMaterialGroup.label","MM"))+'&function_type=C&access=NYNNN';

			if(val == 'ItemAnalysis')
				parent.frames[1].location.href = '../../eMM/jsp/ItemAnalysis.jsp?module_id=MM&function_id=MM_ITEM_ANALYSIS&function_name='+encodeURIComponent(getLabel("Common.ItemAnalysis.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'ItemClass')
				parent.frames[1].location.href = '../../eMM/jsp/ItemClass.jsp?module_id=MM&function_id=MM_ITEM_CLASS&function_name='+encodeURIComponent(getLabel("Common.ItemClass.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'MMItem')
				parent.frames[1].location.href = '../../eMM/jsp/Item.jsp?module_id=MM&function_id=MM_ITEM&function_name='+encodeURIComponent(getLabel("Common.item.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'MMStore')
				parent.frames[1].location.href = '../../eMM/jsp/Store.jsp?module_id=MM&function_id=MM_STORE&function_name='+encodeURIComponent(getLabel("Common.Store.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'BinLocation')
				parent.frames[1].location.href = '../../eMM/jsp/BinLocation.jsp?module_id=MM&function_id=MM_BIN_LOCATION&function_name='+encodeURIComponent(getLabel("Common.BinLocation.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'TradeNameforItem')
				parent.frames[1].location.href = '../../eMM/jsp/TradeNameForItem.jsp?module_id=MM&function_id=MM_TRADE_NAME_FOR_ITEM&function_name='+encodeURIComponent(getLabel("eMM.TradeNameforItem.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'Supplier')
				parent.frames[1].location.href = '../../eMM/jsp/Supplier.jsp?module_id=MM&function_id=AP_SUPPLIER&function_name='+encodeURIComponent(getLabel("Common.Supplier.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'TransactionRemarks')
				parent.frames[1].location.href = '../../eMM/jsp/TrnRemarks.jsp?module_id=MM&function_id=MM_TRN_REMARKS&function_name='+encodeURIComponent(getLabel("Common.TransactionRemarks.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'ItemUOMDefinition')
				parent.frames[1].location.href = '../../eMM/jsp/ItemUOMDefinition.jsp?module_id=MM&function_id=MM_ITEM_UOM_DEFN&function_name='+encodeURIComponent(getLabel("eMM.ItemUOMDefinition.label","MM"))+'&function_type=C&access=YYYNN';


			// Link for ST
			if(val == 'Machine')
				parent.frames[1].location.href = '../../eST/jsp/Machine.jsp?module_id=ST&function_id=ST_MACHINE&function_name='+encodeURIComponent(getLabel("eMM.Machine.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'STItem')
				parent.frames[1].location.href = '../../eST/jsp/Item.jsp?module_id=ST&function_id=ST_ITEM&function_name='+encodeURIComponent(getLabel("Common.item.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'STStore')
				parent.frames[1].location.href = '../../eST/jsp/Store.jsp?module_id=ST&function_id=ST_STORE&function_name='+encodeURIComponent(getLabel("Common.Store.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'ItemClassforStore')
				parent.frames[1].location.href = '../../eST/jsp/ItemClassForStore.jsp?module_id=ST&function_id=ST_ITEM_CLASS_STORE&function_name='+encodeURIComponent(getLabel("eMM.ItemClassforStore.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'ItemforStore')
				parent.frames[1].location.href = '../../eST/jsp/ItemForStore.jsp?module_id=ST&function_id=ST_ITEM_STORE&function_name='+encodeURIComponent(getLabel("eMM.ItemforStore.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'ParentStoreForStore')
				parent.frames[1].location.href = '../../eST/jsp/ParentStoreForStore.jsp?module_id=ST&function_id=ST_STORE_PARENT_STORE&function_name='+encodeURIComponent(getLabel("eMM.ParentStoreforStore.label","MM"))+'&function_type=C&access=YNNNN';
			if(val == 'AssemblyDetails_MFG Formulary')
				parent.frames[1].location.href = '../../eST/jsp/AssemblyDetail.jsp?module_id=ST&function_id=ST_ASSEMBLY_DTL&function_name='+encodeURIComponent(getLabel("eMM.AssemblyDetails/MFGFormulary.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'PrepareLocation')
				parent.frames[1].location.href = '../../eST/jsp/PrepareLocation.jsp?module_id=ST&function_id=ST_PREPARE_LOCATION&function_name='+encodeURIComponent(getLabel("Common.PrepareLocation.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'ItemStoreBinLocation')
				parent.frames[1].location.href = '../../eST/jsp/ItemStoreBinLocation.jsp?module_id=ST&function_id=ST_ITEM_STORE_BIN&function_name='+encodeURIComponent(getLabel("eMM.ItemStoreBinLocation.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'RepackingGroup')
				parent.frames[1].location.href = '../../eST/jsp/RepackingGroup.jsp?module_id=ST&function_id=ST_REPACKING_GROUP&function_name='+encodeURIComponent(getLabel("Common.RepackingGroup.label","Common"))+'&function_type=C&access=YYYNN';
			if(val == 'AssemblyInstruction')
				parent.frames[1].location.href = '../../eST/jsp/AssemblyInstruction.jsp?module_id=ST&function_id=ST_ASSEMBLY_INSTRUCTION&function_name='+encodeURIComponent(getLabel("eMM.AssemblyInstructions.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'DirectSalesPatient')
				parent.frames[1].location.href = '../../eST/jsp/DirectSalesPatient.jsp?module_id=ST&function_id=ST_DIRECT_SALE_PATIENT&function_name='+encodeURIComponent(getLabel("eMM.DirectSalesPatient.label","MM"))+'&function_type=C&access=YNNNN';
			if(val == 'KitTemplate')
				parent.frames[1].location.href = '../../eST/jsp/KitTemplate.jsp?module_id=ST&function_id=ST_KIT_TEMPLATE&function_name='+encodeURIComponent(getLabel("eMM.KitTemplate.label","MM"))+'&function_type=C&access=YYYNN';
			if(val == 'STTransactionRemarks')
				parent.frames[1].location.href = '../../eST/jsp/TransactionRemarks.jsp?module_id=ST&function_id=ST_TRANSACTION_REMARKS&function_name='+encodeURIComponent(getLabel("Common.TransactionRemarks.label","Common"))+'&function_type=C&access=YNNNY';
		}
