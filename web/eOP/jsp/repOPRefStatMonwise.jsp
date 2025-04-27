<!DOCTYPE html>

<%--
Filename		: repOPRefStatMonwise.jsp
Modified On		: 1-3-2005
Version			: 3
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>

<html>

<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
function reset(){
	
	if(f_query_add_mod.document.repOPRefStatMonwiseform){
	f_query_add_mod.document.repOPRefStatMonwiseform.reset() ;
	}
}

function chkGrtrMth(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"MM",localeName)==false)
		{
			var str = getLabel("Common.to.label","Common")+" "+getLabel("Common.month.label","Common");
			var str1 = getLabel("Common.month.label","Common");

			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			error=error.replace("$",str);
			error=error.replace("#",str1);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function chkGrtrYear(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"YY",localeName)==false)
		{
			var str = getLabel("Common.to.label","Common")+" "+getLabel("Common.year.label","Common");
			var str1 = getLabel("Common.year.label","Common");

			var error=getMessage("REMARKS_MUST_GR_EQUAL","common");
			error=error.replace("$",str);
			error=error.replace("#",str1);
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function run() 
{
	
	var fields = new Array( f_query_add_mod.document.repOPRefStatMonwiseform.p_fm_mon,
		f_query_add_mod.document.repOPRefStatMonwiseform.p_to_mon,
		f_query_add_mod.document.repOPRefStatMonwiseform.p_fm_year,
		f_query_add_mod.document.repOPRefStatMonwiseform.p_to_year);
	var names = new Array((getLabel("Common.month.label","Common")+" "+getLabel("Common.from.label","Common")), (getLabel("Common.month.label","Common")+" "+getLabel("Common.to.label","Common")),(getLabel("Common.year.label","Common")+" "+getLabel("Common.from.label","Common")),(getLabel("Common.year.label","Common")+" "+getLabel("Common.to.label","Common")));
	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		var frommon = f_query_add_mod.document.repOPRefStatMonwiseform.p_fm_mon;
		var tomon     = f_query_add_mod.document.repOPRefStatMonwiseform.p_to_mon ;   
		var fromyear = f_query_add_mod.document.repOPRefStatMonwiseform.p_fm_year;
		var toyear     = f_query_add_mod.document.repOPRefStatMonwiseform.p_to_year ;   

		if(fromyear.value == toyear.value)
		{
				  if(chkGrtrMth(frommon,tomon) == true)
				  {
					if(chkGrtrYear(fromyear,toyear) == true)
					{
						if(frommon.value != "" && fromyear.value != "")
							f_query_add_mod.document.repOPRefStatMonwiseform.p_fr_month.value = frommon.value + '/' + fromyear.value ;

						if(tomon.value != "" && toyear.value != "")
							f_query_add_mod.document.repOPRefStatMonwiseform.p_to_month.value = tomon.value + '/' + toyear.value ;
						f_query_add_mod.document.repOPRefStatMonwiseform.submit() ;
					}
				  }		
		}
		else
		{
				if(chkGrtrYear(fromyear,toyear) == true)
				{
					if(frommon.value != "" && fromyear.value != "")
						f_query_add_mod.document.repOPRefStatMonwiseform.p_fr_month.value = frommon.value + '/' + fromyear.value ;

					if(tomon.value != "" && toyear.value != "")
						f_query_add_mod.document.repOPRefStatMonwiseform.p_to_month.value = tomon.value + '/' + toyear.value ;
					f_query_add_mod.document.repOPRefStatMonwiseform.submit() ;
				}
		}

		/*if(frommon.value == "" && fromyear.value != "") 
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.from.label","Common")+""+getLabel("Common.month.label","Common"));
				alert(err);
			return false;
		}

		if(frommon.value != "" && fromyear.value == "")
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.from.label","Common")+""+getLabel("Common.year.label","Common"));
				alert(err);
			return false;
		}
		
		if(tomon.value == "" && toyear.value != "") 
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.to.label","Common")+""+getLabel("Common.month.label","Common"));
				alert(err);
			return false;
		}

		if(tomon.value != "" && toyear.value == "")
		{
			var err = getMessage('CAN_NOT_BE_BLANK','COMMON');
				err = err.replace('$',getLabel("Common.to.label","Common")+""+getLabel("Common.year.label","Common"));
				alert(err);
			return false;
		}

	if(fromyear.value == toyear.value)
    {
	  if( f_query_add_mod.CheckString(getLabel("Common.month.label","Common"), frommon , tomon, messageFrame ) ) 
	  {
		if( f_query_add_mod.CheckString(getLabel("Common.year.label","Common"), fromyear , toyear, messageFrame ) ) 
		{
		if(frommon.value != "" && fromyear.value != "")
			f_query_add_mod.document.repOPRefStatMonwiseform.p_fr_month.value = frommon.value + '/' + fromyear.value ;

		if(tomon.value != "" && toyear.value != "")
			f_query_add_mod.document.repOPRefStatMonwiseform.p_to_month.value = tomon.value + '/' + toyear.value ;
		f_query_add_mod.document.repOPRefStatMonwiseform.submit() ;
		}
	  }		
	}
	else
	{
		if( f_query_add_mod.CheckString(getLabel("Common.year.label","Common"), fromyear , toyear, messageFrame ) ) 
		{
		if(frommon.value != "" && fromyear.value != "")
			f_query_add_mod.document.repOPRefStatMonwiseform.p_fr_month.value = frommon.value + '/' + fromyear.value ;

		if(tomon.value != "" && toyear.value != "")
			f_query_add_mod.document.repOPRefStatMonwiseform.p_to_month.value = tomon.value + '/' + toyear.value ;
		f_query_add_mod.document.repOPRefStatMonwiseform.submit() ;
		}
	}*/
}
}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 scrolling='no' noresize src='<%=source%>' style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod'  noresize  frameborder=no marginheight=0 marginwidth=0 scrolling='no' src='../../eOP/jsp/repOPRefStatMonwiseform.jsp' style='height:79vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
</html>

