//**********************************************************************
function run()
{
  if(f_query_add_mod.document.report_msg_audit_log)
  {
	f_query_add_mod.document.report_msg_audit_log.submit() ;	
  }		
}
//**********************************************************************
function reset()
{
 window.f_query_add_mod.location.href="../../eXH/jsp/ReportMsgAuditLog.jsp";
}
//**********************************************************************
