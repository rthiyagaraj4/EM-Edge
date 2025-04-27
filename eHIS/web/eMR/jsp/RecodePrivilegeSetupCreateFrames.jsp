<!DOCTYPE html>

<!--
*	Copyright © iSoft Solutions (P) Ltd.
*	Created By		:	Anjanyeya Reddy M 
	Module			:   eMR
	Function		:  Recode Set Up Creating frames also
*	Created On		:	18 Dec 2008
-->
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ 
page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.net.URLEncoder,webbeans.eCommon.ConnectionManager" 
%>
<html>
	<head>
 	<script language='javascript' src='../../eMR/js/RecodePrivilegeSetup.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>

	 
	</head>
	<%
	String flag="";
	flag=checkForNull(request.getParameter("flag"));

	String _update_mode_yn=checkForNull(request.getParameter("update_mode_yn"));
	String _stage_code=checkForNull(request.getParameter("stage_code"));
	//String _specific_ind=checkForNull(request.getParameter("specific_ind"));
	
	/*
      This method used for the DB values displyed into user interfaces.
	*/
	
	String _stage_desc="";
	int _serial_no=0;
	String _colour_ind="";
	String _text_colour_ind="";
	String _specific_ind="";
	int _cf_pr_fr_recode_dys_fm_vstcmpl=0;
	int _cf_pr_fr_recode_dys_fm_disc=0;
	String _action_if_not_done="";
	String _allow_authorization_yn="";
	String confirm_not_appl="" ; // added by mujafar for ML-MMOH-CRF-0878
	//String _term_set_appl_yn="";
	//String _term_code_appl_yn="";
	//String _term_desc_appl_yn="";
	String _diag_class_appl_yn="";
	String _accuracy_appl_yn="";
	String _severity_appl_yn="";
	String _priority_appl_yn="";
	String _onset_type_appl_yn="";
	String _onset_date_appl_yn="";
	String _applicable_side_appl_yn="";
	String _status_appl_yn="";
	String _as_on_date_appl_yn="";
	String _remarks_appl_yn="";


	String _user_name="";
	String _appl_user_id="";
	String _authorize_yn="";
	String _spec_user_id="";
	String code_xtn_appl_yn="";//Added on 12/23/2009 for SRR-303.1
	String laterality_appl_yn="";//Added on 12/23/2009 for SRR-303.1
	String proc_remarks_appl_yn="";//Added on 12/23/2009 for SRR-303.1
	String proc_status_appl_yn="";//Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
	String enc_stage_yn="";  /* HAS-CRF-300 */
	String chife_compln_yn=""; /* HAS-CRF-300 */
	String notify_yn=""; /* HAS-CRF-300 */

	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
	String inpatient_appl="";
	String daycare_appl="";
	/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */

	int record_Count=0;
	StringBuffer _getdbV_sql=new StringBuffer();
	Connection conn =null;
   try{
	            conn  =  ConnectionManager.getConnection(request);
				PreparedStatement _stmt = null;
				PreparedStatement _stmtSPC = null;
				ResultSet _rset=null;
				ResultSet _rset_SPC=null;
				
			/*IN019167 , Wednesday, February 10, 2010 , to validate MR Parameter*/
			_stmt = conn.prepareStatement("select 1 from mr_param ") ;
			_rset = _stmt.executeQuery();
			if(_rset.next())
			{
			
				if(!_update_mode_yn.equals("")){				

				if(_getdbV_sql.length() > 0) _getdbV_sql.delete(0,_getdbV_sql.length());
				_getdbV_sql.append("SELECT * from MR_RECODE_PRIVI_SETUP WHERE STAGE_NO="+_stage_code+"");
					_stmt = conn.prepareStatement(_getdbV_sql.toString());
					_rset = _stmt.executeQuery();
					while(_rset.next()){
						_stage_desc										= _rset.getString("stage_desc");
						_serial_no											= _rset.getInt("STAGE_NO");
						_colour_ind										= _rset.getString("COLOUR_IND");
						_text_colour_ind								= _rset.getString("TEXT_COLOUR_IND");
						_cf_pr_fr_recode_dys_fm_vstcmpl	= _rset.getInt("CF_PR_FR_RECODE_DYS_FM_VSTCMPL");
						_cf_pr_fr_recode_dys_fm_disc		= _rset.getInt("CF_PR_FR_RECODE_DYS_FM_DISC");
						_action_if_not_done							= _rset.getString("ACTION_IF_NOT_DONE");
						_allow_authorization_yn					= _rset.getString("ALLOW_AUTHORIZATION_YN");
						if(_allow_authorization_yn.equals("Y"))
							flag="";
						else
							flag="d";
						
						confirm_not_appl  = _rset.getString("CONFIRM_APPL"); // added by mujafar for ML-MMOH-CRF-0878
						
						_diag_class_appl_yn				=	_rset.getString("DIAG_CLASS_APPL_YN");
						_accuracy_appl_yn				=	_rset.getString("ACCURACY_APPL_YN");
						_severity_appl_yn				=	_rset.getString("SEVERITY_APPL_YN");
						_priority_appl_yn					=	_rset.getString("PRIORITY_APPL_YN");
						_onset_type_appl_yn			=	_rset.getString("ONSET_TYPE_APPL_YN");
						_onset_date_appl_yn			=	_rset.getString("ONSET_DATE_APPL_YN");
						_applicable_side_appl_yn		=	_rset.getString("APPLICABLE_SIDE_APPL_YN");
						_status_appl_yn					=	_rset.getString("STATUS_APPL_YN");
						_as_on_date_appl_yn			=	_rset.getString("AS_ON_DATE_APPL_YN");
						_remarks_appl_yn				=	_rset.getString("REMARKS_APPL_YN");
						_specific_ind						=	_rset.getString("SPECIFIC_IND");
						proc_remarks_appl_yn			=	_rset.getString("PROC_REMARKS_APPL_YN");
						code_xtn_appl_yn				= _rset.getString("CODE_EXTENSION_APPL_YN");
						laterality_appl_yn					= _rset.getString("LATERALITY_APPL_YN");
						proc_status_appl_yn			= _rset.getString("PROC_STATUS_APPL_YN");//Added On 2/15/2010 for SRR-CRF-303.2(IN015597)
						enc_stage_yn				= _rset.getString("ENC_STAGE_YN");/* HAS-CRF-300 */
						chife_compln_yn			= _rset.getString("CHIFE_COMP_YN");/* HAS-CRF-300 */
						notify_yn					= _rset.getString("NOTIFIY_YN");/* HAS-CRF-300 */

						/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
						inpatient_appl = _rset.getString("inpatient_appl_yn")==null? "N":_rset.getString("inpatient_appl_yn");
						daycare_appl= _rset.getString("daycare_appl_yn")==null? "N":_rset.getString("daycare_appl_yn");
						/*Added by KAMATCHI S for ML-MMOH-CRF-1581 */
						
						/*
						implemeter the logic for the specindicator
						*/
						String facilityId = (String)session.getValue("facility_id");
						if(_specific_ind.equals("SPC")){
							if(_getdbV_sql.length() > 0) _getdbV_sql.delete(0,_getdbV_sql.length());
							_getdbV_sql.append("SELECT A.APPL_USER_ID,A.FACILITY_ID,A.AUTHORIZE_YN, B.APPL_USER_NAME FROM MR_RECODE_PRIVI_SETUP_DTL A, SM_APPL_USER B WHERE A.APPL_USER_ID = B.APPL_USER_ID AND A.STAGE_NO ="+_stage_code+" AND FACILITY_ID='"+facilityId+"' ORDER BY 1");
							
								_stmtSPC = conn.prepareStatement(_getdbV_sql.toString());
								_rset_SPC= _stmtSPC.executeQuery();
								while(_rset_SPC.next()){
										_user_name		=_rset_SPC.getString("APPL_USER_NAME");
										_appl_user_id	=_rset_SPC.getString("APPL_USER_ID");
										_user_name = _user_name.replaceAll("\'", "%27");//Added for ML-MMOH-SCF-2337 by Ajay Hatwate
										_authorize_yn	=_rset_SPC.getString("AUTHORIZE_YN");	_spec_user_id=_spec_user_id+_appl_user_id+"`"+_user_name+"`"+_authorize_yn+"~";
								}
//								if(_rset_SPC!=null)_rset_SPC=null;
//								if(_stmtSPC!=null)_stmtSPC=null;
							   if(_rset_SPC!=null)_rset_SPC.close();
								if(_stmtSPC!=null)_stmtSPC.close();
						}
					}
						if(_rset!=null)_rset.close();
						if(_stmt!=null)_stmt.close();
					//if(conn!=null)conn=null;
			}else{
				if(_getdbV_sql.length() > 0) _getdbV_sql.delete(0,_getdbV_sql.length());
				_getdbV_sql.append("SELECT count(*) count from MR_RECODE_PRIVI_SETUP ");
				_stmt = conn.prepareStatement(_getdbV_sql.toString());
					_rset = _stmt.executeQuery();
					while(_rset.next())
						record_Count=_rset.getInt("count");
						if(_rset!=null)_rset.close();
					    if(_stmt!=null)_stmt.close();
					   //if(conn!=null)conn=null;
					   

				
				}
  %>
	
	
   <frameset rows='31,0,35,35'> <!-- modified by mujafar for ML-MMOH-CRF-0878 -->
	<frame name='MasterFrame' src='../../eMR/jsp/addModifyRecodePrivilegeSetup.jsp?record_Count=<%=record_Count%>&_spec_user_id=<%=java.net.URLEncoder.encode(_spec_user_id,"UTF-8")%>&_update_mode_yn=<%=_update_mode_yn%>&_stage_desc=<%=_stage_desc%>&_serial_no=<%=_serial_no%>&_colour_ind=<%=_colour_ind%>&_text_colour_ind=<%=_text_colour_ind%>&_cf_pr_fr_recode_dys_fm_vstcmpl=<%=_cf_pr_fr_recode_dys_fm_vstcmpl%>&_cf_pr_fr_recode_dys_fm_disc=<%=_cf_pr_fr_recode_dys_fm_disc%>&_action_if_not_done=<%=_action_if_not_done%>&_allow_authorization_yn=<%=_allow_authorization_yn%>&_confirm_not_appl=<%=confirm_not_appl%>&_specific_ind=<%=_specific_ind%>' frameborder=0 scrolling='no'>
	<frame name='HeaderFrame' src='../../eMR/jsp/RecodePrivilegeSetupUserHeader.jsp?' frameborder=0 scrolling='no'>
   <!-- Below lines enc_stage_yn,chife_compln_yn and notify_yn added by Venkatesh.S against HAS-CRF-300 -->
   <!--  inpatient_appl,daycare_appl added by KAMATCHI S for ML-MMOH-CRF-1581 -->
	<frame name='Criteria' src='../../eMR/jsp/RecodePrivilegeSetupCriteriaDetail.jsp?record_Count=<%=record_Count%>&_update_mode_yn=<%=_update_mode_yn%>&_diag_class_appl_yn=<%=_diag_class_appl_yn%>&_accuracy_appl_yn=<%=_accuracy_appl_yn%>&_severity_appl_yn=<%=_severity_appl_yn%>&_priority_appl_yn=<%=_priority_appl_yn%>&_onset_type_appl_yn=<%=_onset_type_appl_yn%>&_onset_date_appl_yn=<%=_onset_date_appl_yn%>&_applicable_side_appl_yn=<%=_applicable_side_appl_yn%>&_status_appl_yn=<%=_status_appl_yn%>&_as_on_date_appl_yn=<%=_as_on_date_appl_yn%>&_remarks_appl_yn=<%=_remarks_appl_yn%>&code_xtn_appl_yn=<%=code_xtn_appl_yn%>&laterality_appl_yn=<%=laterality_appl_yn%>&proc_remarks_appl_yn=<%=proc_remarks_appl_yn%>&proc_status_appl_yn=<%=proc_status_appl_yn%>&enc_stage_yn=<%=enc_stage_yn%>&chife_compln_yn=<%=chife_compln_yn%>&notify_yn=<%=notify_yn%>&inpatient_appl=<%=inpatient_appl%>&daycare_appl=<%=daycare_appl%>' frameborder=0 scrolling='no'>
	
	<frameset cols='50,50'>
		<frame name='RecordFrame' src='../../eMR/jsp/RecodePrivilegeSetupUserDetail.jsp?flag=<%=flag%>&_confirm_not_appl=<%=confirm_not_appl%>&_allow_authorization_yn=<%=_allow_authorization_yn%>&record_Count=<%=record_Count%>&_update_mode_yn=<%=_update_mode_yn%>&_spec_user_id=<%=java.net.URLEncoder.encode(_spec_user_id,"UTF-8")%>&_specific_ind=<%=_specific_ind%> ' frameborder=0 scrolling='no' noresize > <!-- added by mujafar for ML-MMOH-CRF-0878 -->
		<frame name='DetailFrame' src='../../eMR/jsp/RecordPriviegeStageDetailForm.jsp' frameborder=0 scrolling='yes' noresize>
	</frameset>
	<frame name='dummy' src='../../eMR/jsp/RecodePrivilegeSetupUserHeader.jsp?' frameborder=0 scrolling='no'>
	
	
</frameset>
	<%
			 }
				else
				{
					out.println("<script>alert(getMessage('MR_PARAM_NOT_DEFINED','MR'));</script>");
				}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally{
			ConnectionManager.returnConnection(conn,request);
			
		}
	
	%>
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
