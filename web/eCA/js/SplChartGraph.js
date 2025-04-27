function create() 
{
	f_query_add_mod.location.href='../../eCA/jsp/SplChartGraphAddModify.jsp?mode=insert';
}

function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/SplChartGraphQueryCriteria.jsp';
}

function checkDuplicate(obj1,obj2)
{
	if(obj1.value==obj2.value)
	{ 
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("XAXIS_YAXIS_DIFFERENT","CA"); 
		obj2.focus();
		return true;
	}
}

function apply()
{
	var mode = f_query_add_mod.document.forms[0].mode;
	var fields = new Array (f_query_add_mod.document.forms[0].spl_chart_type,
							f_query_add_mod.document.forms[0].spl_chart_group,
							f_query_add_mod.document.forms[0].graph_code,
							f_query_add_mod.document.forms[0].graph_desc,
							f_query_add_mod.document.forms[0].x_axis,
							f_query_add_mod.document.forms[0].y_axis
							);

var names = new Array(	f_query_add_mod.getLabel("Common.Chart.label",'COMMON') +
									f_query_add_mod.getLabel("Common.type.label",'COMMON'),
									f_query_add_mod.getLabel("Common.Chart.label",'COMMON')+
									f_query_add_mod.getLabel("Common.Group.label",'COMMON'),
									f_query_add_mod.getLabel("eCA.Graph.label",'CA') +
									f_query_add_mod.getLabel("Common.code.label",'COMMON'),
									f_query_add_mod.getLabel("eCA.Graph.label",'CA') +f_query_add_mod.getLabel("Common.description.label",'COMMON'),	
									"X -" +f_query_add_mod.getLabel("eCA.Axis.label",'CA'),
									"Y -"+f_query_add_mod.getLabel("eCA.Axis.label",'CA'));

	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
	{			
		if(checkDuplicate(f_query_add_mod.document.forms[0].x_axis,f_query_add_mod.document.forms[0].y_axis))
			return;
	
        if(mode != null)
		{
			if(mode.value=='update')
			{
				f_query_add_mod.document.forms[0].spl_chart_type1.value= f_query_add_mod.document.forms[0].spl_chart_type.value;
				f_query_add_mod.document.forms[0].spl_chart_group1.value= f_query_add_mod.document.forms[0].spl_chart_group.value;
				f_query_add_mod.document.forms[0].graph_code1.value= f_query_add_mod.document.forms[0].graph_code.value;
				f_query_add_mod.document.forms[0].graph_desc1.value= f_query_add_mod.document.forms[0].graph_desc.value;
				f_query_add_mod.document.forms[0].x_axis1.value= f_query_add_mod.document.forms[0].x_axis.value;
				f_query_add_mod.document.forms[0].y_axis1.value= f_query_add_mod.document.forms[0].y_axis.value;
				f_query_add_mod.document.forms[0].eff_status1.value= f_query_add_mod.document.forms[0].eff_status.value;
			}
		}

		f_query_add_mod.document.forms[0].submit();
	}
 }


function update_form()
{
	var spl_chart_type = document.forms[0].spl_chart_type.value;
	var graph_code     = document.forms[0].graph_code.value;
	var graph_desc     = document.forms[0].graph_desc.value;
	var eff_status     = document.forms[0].eff_status.value;
	parent.f_query_add_mod.location.href='../../eCA/jsp/SplChartGraphAddModify.jsp?mode=insert&spl_chart_type='+spl_chart_type+'&graph_code='+graph_code+'&graph_desc='+graph_desc+'&eff_status='+eff_status;
}

function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null )
	{
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"){
			var message = getMessage('RECORD_CANNOT_DELETE','CA');	messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray[message];
			}
			else{
				if(window.confirm(getMessage("DELETE_RECORD",'Common')) == true)
				{
					f_query_add_mod.document.splchartgraph_form.mode.value='delete';
					f_query_add_mod.document.splchartgraph_form.submit();     
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
		}
		else
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
	}
} 	


function onSuccess()
{
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/SplChartGraphAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	{   
		f_query_add_mod.location.href='../../eCA/jsp/SplChartGraphAddModify.jsp?mode=update&spl_chart_type='+f_query_add_mod.document.forms[0].spl_chart_type.value+'&graph_code='+f_query_add_mod.document.forms[0].graph_code.value+'&spl_chart_group='+f_query_add_mod.document.forms[0].spl_chart_group.value;
	}
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';


}


function reset()
{
	if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset();

}

function checkForMode(objCheck)
{
	var mode = document.forms[0].mode.value;
	if(objCheck.checked== true)
	{
		document.forms[0].eff_status.value='E';
		document.forms[0].eff_status1.value='E';
	}
	else
	{
		document.forms[0].eff_status.value='D';
		document.forms[0].eff_status1.value='D';
	}
}

function checkForMaxCharacter(objTextArea)
{

	if(objTextArea.value != '')
	{
		if(objTextArea.value.length > 200)
		{
			return false;
		}
			else
			return true;
	}

}

function callOther( obj1, obj2 )
{	
	if(obj1.value !=''){
	if(obj1.value == obj2.value)
			alert(getMessage("XAXI_YAXI_NOT_SAME",'CA'));
	
	}
}
