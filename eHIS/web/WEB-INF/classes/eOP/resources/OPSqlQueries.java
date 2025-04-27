package eOP.resources;

import java.util.*;

public class OPSqlQueries extends ListResourceBundle implements java.io.Serializable{

	public Object[][] getContents() {
         return contents;
     }

	static final Object[][] contents = {

			{"OPINTERNALREP_1","select distinct report_id, SM_GET_DESC.SM_REPORT(module_id,report_id,?,'1') report_desc, 1 no_of_copies,  module_id from op_online_report_vw where OPERATING_FACILITY_ID=? and (clinic_code=? or clinic_code ='*All') and (VISIT_TYPE_CODE=? OR VISIT_TYPE_CODE='*A') order by 2"},

			{"OPINTERNALREP_2","select distinct report_id, SM_GET_DESC.SM_REPORT(module_id,report_id,?,'1') report_desc, 1 no_of_copies,  module_id from op_online_report_vw where OPERATING_FACILITY_ID=? and (clinic_code=? or clinic_code ='*All') and (VISIT_TYPE_CODE=? OR VISIT_TYPE_CODE='*A') and report_id not in ('FMFLRQSL','OPRNTFMR') order by 2"},

			{"OPINTERNALREP_3","select distinct report_id, SM_GET_DESC.SM_REPORT(module_id,report_id,?,'1') report_desc, 1 no_of_copies,  module_id from op_online_report_vw where OPERATING_FACILITY_ID=? and (clinic_code=? or clinic_code ='*All') and (VISIT_TYPE_CODE=? OR VISIT_TYPE_CODE='*A') and report_id not in ('FMFLRQSL','OPRNTFMR','MPBFLLBL') order by 2"}
	};			
}		
