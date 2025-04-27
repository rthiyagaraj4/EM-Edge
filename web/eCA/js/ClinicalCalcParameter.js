function loadFormulae(obj)
{

	deleteFormulae(parent.frames[1].document.forms[0].clin_formula);
	
	var calc_id = obj.value;
	if(obj.value!="")
	{
		var xmlDoc="";
		var xmlHttp = new XMLHttpRequest();
		xmlStr	="<root><SEARCH " ;
		xmlStr +=" /></root>" ;
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		xmlHttp.open( "POST","../../eCA/jsp/ClinicalCalcFormulaIntermediate.jsp?&calc_id="+calc_id, false);
		xmlHttp.send(xmlDoc);
		responseText=xmlHttp.responseText;
		eval(responseText);
	}
	else
	{
		parent.frames[2].location.href='../../eCommon/html/blank.html';
	}

	parent.frames[3].location.href='../../eCommon/jsp/MstCodeError.jsp';


}

function deleteFormulae(field)
{
	var selected = field;
	while ( selected.options.length > 0 )
		selected.remove(selected.options[0]);
	var opt		=	parent.frames[1].document.createElement("Option");
	opt.text	=	"----"+getLabel("Common.defaultSelect.label","COMMON")+"----" ;
	opt.value	=	"";
	field.add(opt);
}


function loadSelFormulae(obj)
{
	var formula_ref_id = obj.value;
	parent.frames[2].location.href='../../eCA/jsp/ClinicalCalcSelectedFormulaList.jsp?formula_ref_id='+formula_ref_id;
}

function apply()
{
	
	var calc_id = top.content.frames[1].document.forms[0].clin_calc.value;
	var clin_formula = top.content.frames[1].document.forms[0].clin_formula.value;
	
	 var fields = new Array (
							top.content.frames[1].document.forms[0].clin_calc,
							top.content.frames[1].document.forms[0].clin_formula
		                    );

	var names = new Array ( 
							getLabel("eCA.ClinicalCalculations.label",'CA'),
	                        getLabel("eCA.FormulaeToBeUsed.label",'CA')
													   );

	if(checkFieldsofMst( fields, names, top.content.messageFrame)) 
	{
     
		ClinicalCalcSelectFrame.document.forms[0].submit();

	}

}


function onSuccess()
{
	document.frames[1].location.href="../../eCA/jsp/ClinicalCalcSelectFormula.jsp";
	document.frames[2].location.href="../../eCA/jsp/ClinicalCalcSelectedFormulaList.jsp";

}


function reset(){
  deleteFormulae(ClinicalCalcSelectFrame.document.forms[0].clin_formula);
  ClinicalCalcSelectFrame.document.forms[0].reset();
 ClinicalCalcSelectedFrame.location.href='../../eCommon/html/blank.html';
 // ClinicalCalcSelectedFrame.document.forms[0].reset();	
}
