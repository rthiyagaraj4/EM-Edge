<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*, java.util.*, java.net.*,java.text.*, webbeans.eCommon.*" %>
<html>
</head>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		function reset()
		{
			if(parent.frames[2].frames[1].document.repDRMergedPatientIDs)
			{
				parent.frames[2].frames[1].document.repDRMergedPatientIDs.reset() ;
			}
		}

		function chkGrtr(obj1,obj2)
		{
			if(obj1.value!='' && obj2.value!='')	
			{
				if(isBefore(obj1.value,obj2.value,"DMY",localeName)==false)
				{
					var str = getLabel("Common.to.label","Common")+" "+getLabel("eDR.ReplacementDate.label","DR");
					var str1 = getLabel("eDR.ReplacementDate.label","DR");

					var error=getMessage("REMARKS_MUST_GR_EQUAL","COMMON");
					error=error.replace("$",str);
					error=error.replace("#",str1);
					messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error ;
					return false;
				}
				else 
					return true;
			}

			return true;
		}

		function run()
		{
			var obj = query_criteria.document.forms[0];
			if(parent.frames[2].frames[1].document.repDRMergedPatientIDs)
			{		 
				//if(parent.frames[2].frames[1].doDateCheck( parent.frames[2].frames[1].document.repDRMergedPatientIDs.p_fm_replace_date, parent.frames[2].frames[1].document.repDRMergedPatientIDs.p_to_replace_date, messageFrame ) )
				
				if(chkGrtr(parent.frames[2].frames[1].document.repDRMergedPatientIDs.p_fm_replace_date1, parent.frames[2].frames[1].document.repDRMergedPatientIDs.p_to_replace_date1) == true)
				{	
					query_criteria.document.repDRMergedPatientIDs.action="../../eCommon/jsp/report_options.jsp"; 
					query_criteria.document.repDRMergedPatientIDs.target="messageFrame"
					obj.submit() ; 
					
				}
			}
		}
	</script>
</head>
<%
	request.setCharacterEncoding("UTF-8");
	String url		= "../../eCommon/jsp/commonToolbar.jsp?";
	String params	= request.getQueryString();
	String source	= url + params;
%>
	<%-- <iframe name='commontoolbarFrame' id='commontoolbarFrame' scrolling='no' noresize src=<%= source %> style='height:8vh;width:100vw' frameborder="0"></iframe>
	<iframe name='query_criteria' id='query_criteria' scrolling='no' noresize src='../../eDR/jsp/MergedPatientIDsReportForm.jsp' style='height:83vh;width:100vw' frameborder="0"></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp'  noresize scrolling='auto' style='height:9vh;width:100vw' frameborder="0"></iframe> --%>
	
	<frameset rows='42,*,50'> 
		<frame name='commontoolbarFrame' frameborder=0 scrolling='no' noresize src=<%= source %>>
		<frame name='query_criteria' frameborder='0' scrolling='no' noresize src='../../eDR/jsp/MergedPatientIDsReportForm.jsp'>
		<frame name='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder='0' noresize scrolling='auto'>
	</frameset>
</html>

