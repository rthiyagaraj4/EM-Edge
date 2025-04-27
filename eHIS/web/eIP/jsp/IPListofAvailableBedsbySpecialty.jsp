<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>	
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function reset()
	{
		f_query_add_mod.document.forms[0].reset();
	}
	function run()
	{
		var fields = new Array(f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_sex_spec_ind);
		var names = new Array(getLabel('Common.gender.label','Common'));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		{
			if( !doDateCheckAlert(f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_dt,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_dt )  )
			{				
					var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");					
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error;					
					return false;
			}
			if( f_query_add_mod.CheckString(getLabel('Common.NursingUnitCode.label','Common'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fm_nursing_unit_code,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_nursing_unit_code, messageFrame )  )
				if( f_query_add_mod.CheckString(getLabel('Common.speciality.label','Common')+" "+getLabel('Common.code.label','Common'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_spl,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_spl, messageFrame )  )
					if( f_query_add_mod.CheckString(getLabel('Common.bedtype.label','Common')+" "+getLabel('Common.code.label','Common'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_bed_type,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_bed_type, messageFrame )  )
						if( f_query_add_mod.CheckString(getLabel('eIP.BedClassCode.label','IP'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fr_bed_class,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_bed_class, messageFrame )  )
							if( f_query_add_mod.CheckString(getLabel('Common.roomno.label','Common'), f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_fm_room_no,f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.p_to_room_no, messageFrame )  )										
										f_query_add_mod.document.IPListofAvailableBedsbySpecialtyform.submit() ;
						
			 }
    }	
	function doDateCheckAlert(from,to)
		{
			var fromdate = from.value ;
			var todate = to.value ;
			var localeName=f_query_add_mod.document.forms[0].p_language_id.value;
			if(fromdate!='' && todate!='')
			{
					var greg_fromDate = convertDate(fromdate,"DMYHM",localeName,"en");
					var greg_toDate = convertDate(todate,"DMYHM",localeName,"en");
					if(isBefore(greg_fromDate,greg_toDate,"DMYHM","en"))
					{						
						return true;
					}
					else 
					{
						return false;					
					}
			}
			else
				return true;

		}
</script>
	
</head>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%= source %> frameborder='0' scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe scrolling="no" name='f_query_add_mod' id='f_query_add_mod' src='../jsp/IPListofAvailableBedsbySpecialty_form.jsp'  frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:40%;width:100vw'></iframe>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

