<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/common.js"></script>
<script src="../../eCommon/js/DateUtils.js"></script>
<script>
function reset() {
	f_query_add_mod.document.reportInsWisePatStatsform.reset() ;
	f_query_add_mod.location.href ='../../eOP/jsp/repInsurWisePatStats.jsp';
}
function run() 
{
var fields = new Array ( f_query_add_mod.document.reportInsWisePatStatsform.p_from_date,f_query_add_mod.document.reportInsWisePatStatsform.p_to_date);
var visitDate=getLabel("eOP.VisitAdmDate.label","op");
var names = new Array(getLabel("Common.from.label","Common")+" "+visitDate,getLabel("Common.to.label","Common")+" "+visitDate);
if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{	
		 	if(validationonRun()){


				var p_from_date				= f_query_add_mod.document.reportInsWisePatStatsform.p_from_date.value;            
				var p_to_date				= f_query_add_mod.document.reportInsWisePatStatsform.p_to_date.value;              
				var p_patient_class			= f_query_add_mod.document.reportInsWisePatStatsform.p_patient_class.value;        
				var p_fm_specialty_code		= f_query_add_mod.document.reportInsWisePatStatsform.p_fm_specialty_code.value;        
				var p_to_specialty_code		= f_query_add_mod.document.reportInsWisePatStatsform.p_to_specialty_code.value;    
				var p_fm_locn_code			= f_query_add_mod.document.reportInsWisePatStatsform.p_fm_locn_code.value;         
				var p_to_locn_code			= f_query_add_mod.document.reportInsWisePatStatsform.p_to_locn_code.value;         
				var p_fm_nursing_code		= f_query_add_mod.document.reportInsWisePatStatsform.p_fm_nursing_code.value;      
				var p_to_nursing_code		= f_query_add_mod.document.reportInsWisePatStatsform.p_to_nursing_code.value;      
				var p_from_pract_id			= f_query_add_mod.document.reportInsWisePatStatsform.p_from_pract_id.value;        
				var p_to_pract_id			= f_query_add_mod.document.reportInsWisePatStatsform.p_to_pract_id.value;          
				var p_from_bl_grp_id		= f_query_add_mod.document.reportInsWisePatStatsform.p_from_bl_grp_id.value;       
				var p_to_bl_grp_id			= f_query_add_mod.document.reportInsWisePatStatsform.p_to_bl_grp_id.value;         
				var p_from_cust_grp_code	= f_query_add_mod.document.reportInsWisePatStatsform.p_from_cust_grp_code.value;   
				var p_to_cust_grp_code		= f_query_add_mod.document.reportInsWisePatStatsform.p_to_cust_grp_code.value;     
				var p_from_cust_code		= f_query_add_mod.document.reportInsWisePatStatsform.p_from_cust_code.value;   
				var p_to_cust_code			= f_query_add_mod.document.reportInsWisePatStatsform.p_to_cust_code.value;     
				var p_policy_type_code		= f_query_add_mod.document.reportInsWisePatStatsform.p_policy_type_code.value;     
				var p_policy_number			= f_query_add_mod.document.reportInsWisePatStatsform.p_policy_number.value; 
				var p_patient_id			= f_query_add_mod.document.reportInsWisePatStatsform.p_patient_id.value;           
				var p_order_by				= f_query_add_mod.document.reportInsWisePatStatsform.p_order_by.value; 

				var p_facility_id			= f_query_add_mod.document.reportInsWisePatStatsform.p_facility_id.value;     
				var p_module_id				= f_query_add_mod.document.reportInsWisePatStatsform.p_module_id.value;   
				var p_report_id				= f_query_add_mod.document.reportInsWisePatStatsform.p_report_id.value;     
				var p_user_name				= f_query_add_mod.document.reportInsWisePatStatsform.p_user_name.value;     
				var p_function_id			= f_query_add_mod.document.reportInsWisePatStatsform.p_function_id.value; 
				var p_function_name			= f_query_add_mod.document.reportInsWisePatStatsform.p_function_name.value;           
				var p_function_type			= f_query_add_mod.document.reportInsWisePatStatsform.p_function_type.value; 

				f_query_add_mod.document.reportInsWisePatStatsform.method	= 'POST';
				f_query_add_mod.document.reportInsWisePatStatsform.action	= '../../eCommon/jsp/report_options.jsp?p_from_date='+p_from_date+'&p_to_date='+p_to_date+'&p_patient_class='+p_patient_class+'&p_fm_specialty_code='+p_fm_specialty_code+'&p_to_specialty_code='+p_to_specialty_code+'&p_fm_locn_code='+p_fm_locn_code+'&p_to_locn_code='+p_to_locn_code+'&p_fm_nursing_code='+p_fm_nursing_code+'&p_to_nursing_code='+p_to_nursing_code+'&p_from_pract_id='+p_from_pract_id+'&p_to_pract_id='+p_to_pract_id+'&p_from_bl_grp_id='+p_from_bl_grp_id+'&p_to_bl_grp_id='+p_to_bl_grp_id+'&p_from_cust_grp_code='+p_from_cust_grp_code+'&p_to_cust_grp_code='+p_to_cust_grp_code+'&p_from_cust_code='+p_from_cust_code+'&p_to_cust_code='+p_to_cust_code+'&p_policy_type_code='+p_policy_type_code+'&p_policy_number='+p_policy_number+'&p_patient_id='+p_patient_id+'&p_order_by='+p_order_by+'&p_facility_id='+p_facility_id+'&p_module_id='+p_module_id+'&p_report_id='+p_report_id+'&p_user_name='+p_user_name+'&p_function_id	='+p_function_id+'&p_function_name='+p_function_name+'&p_function_type='+p_function_type+'';	
				f_query_add_mod.document.reportInsWisePatStatsform.submit() ;
			}
	}
}
function chkGrtr(obj1,obj2)
{
		
		if(isBefore(obj1.value,obj2.value,"DMYHM",localeName)==false)
		{
			var error=getMessage("TO_DT_GR_EQ_FM_DT","SM");
			messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
            return false;
		}
		else 
			return true;
}

function validationonRun(){
if(chkGrtr(f_query_add_mod.document.reportInsWisePatStatsform.p_from_date,
				f_query_add_mod.document.reportInsWisePatStatsform.p_to_date)==true)
			{
			 if(f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common")+" "+getLabel("Common.code.label","Common"),f_query_add_mod.document.forms[0].p_fm_specialty_code,f_query_add_mod.document.forms[0].p_to_specialty_code,messageFrame))
			 if(f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].p_fm_locn_code,f_query_add_mod.document.forms[0].p_to_locn_code,messageFrame))
			 if(f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"),f_query_add_mod.document.forms[0].p_fm_nursing_code,f_query_add_mod.document.forms[0].p_to_nursing_code,messageFrame))
			 if(f_query_add_mod.CheckString(getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].p_from_pract_id,f_query_add_mod.document.forms[0].p_to_pract_id,messageFrame))
			 if(f_query_add_mod.CheckString(getLabel("Common.BillingGroup.label","Common"),f_query_add_mod.document.forms[0].p_from_bl_grp_id,f_query_add_mod.document.forms[0].p_to_bl_grp_id,messageFrame))
			 if(f_query_add_mod.CheckString(getLabel("Common.BillingGroup.label","Common"),f_query_add_mod.document.forms[0].p_from_bl_grp_id,f_query_add_mod.document.forms[0].p_to_bl_grp_id,messageFrame))
			 if(f_query_add_mod.CheckString(getLabel("Common.Customer.label","Common")+" "+getLabel("Common.GroupCode.label","Common"),f_query_add_mod.document.forms[0].p_from_cust_grp_code,f_query_add_mod.document.forms[0].p_to_cust_grp_code,messageFrame))
			 if(f_query_add_mod.CheckString(getLabel("Common.CustomerCode.label","Common"),f_query_add_mod.document.forms[0].p_from_cust_code,f_query_add_mod.document.forms[0].p_to_cust_code,messageFrame))

			 	return true;
			}else{
				return false;
			}

}
</script>
<%
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>

<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eOP/jsp/repInsurWisePatStats.jsp' frameborder=0 style='height:80vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:12vh;width:100vw'></iframe>
	<iframe name='dummyframe' id='dummyframe'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize  style='height:0vh;width:100vw'></iframe>

