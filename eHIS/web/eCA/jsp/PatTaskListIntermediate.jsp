<!DOCTYPE html>
<%@page import="java.util.*,eCA.PatTaskListRepository,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	<script language="javascript" src="../../eCA/js/PatTaskList.js"></script>
	<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name='patTaskIntermediateForm' id='patTaskIntermediateForm'>

<input type ='hidden' name ='locale' value ='<%=locale%>'>
<%

	ArrayList retArray=null;
	ArrayList arrayDesc = null;
	ArrayList arrayCode=null;

	Properties property = null;
	String flagString = request.getParameter("calledFrom")==null ? "" : request.getParameter("calledFrom");

	try
	{
		property = (java.util.Properties) session.getValue( "jdbc" );
		PatTaskListRepository patTask = new PatTaskListRepository();

		if(flagString.equals("task"))
		{
			String task = request.getParameter("task")==null ? "" :  request.getParameter("task");
			String taskDesc =request.getParameter("taskDesc")==null ? "" :  request.getParameter("taskDesc");
			retArray = patTask.getQueryForTask(property,task,taskDesc);

			if(retArray != null)
			{
				arrayDesc = (ArrayList)retArray.get(0);
				arrayCode = (ArrayList)retArray.get(1);
			
				if(arrayDesc.size()==1)
				{
					out.println("<script>parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskDesc.value='"+(String)arrayDesc.get(0)+"'</script>");
					out.println("<script>parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskCode.value='"+(String)arrayCode.get(0)+"'</script>");
				}
				else
				{
					%>
					<script>
						var locale = document.forms[0].locale.value;
						var task ="<%=task%>";

						if(task=="")
							task = "%"
						else
							task+="%";

						var sql = "SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION_LANG_VW WHERE INTERVENTION_CODE like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS='E' and upper(INTERVENTION_TYPE) like upper('"+task+"') and language_id ='" +locale+"'  ORDER BY SHORT_DESC";

						var target = "<%=taskDesc%>";

						var argArray = new Array();
						var namesArray = new Array();
						var valuesArray = new Array();
						var datatypesArray = new Array();

						argArray[0] = sql;
						argArray[1] = namesArray;
						argArray[2] = valuesArray;
						argArray[3] = datatypesArray;
						argArray[4] = "1,2";
						argArray[5] = target;
						argArray[6] = DESC_LINK;
						argArray[7] = CODE_DESC;
						retArray = CommonLookup(getLabel("Common.Task.label","COMMON"), argArray);

						if(retArray.length != 0)
						{
							parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskDesc.value=retArray[1];
							parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskCode.value=retArray[0];
						}
					</script>
					<%         
				}
		     }
		}
		else if(flagString.equals("task1"))
		{
			String task = request.getParameter("task")==null ? "" :  request.getParameter("task");
			String taskDesc =request.getParameter("taskDesc")==null ? "" :  request.getParameter("taskDesc");
			retArray = patTask.getQueryForTask(property,task,taskDesc);

			if(retArray != null)
			{
				arrayDesc = (ArrayList)retArray.get(0);
				arrayCode = (ArrayList)retArray.get(1);
			
				if(arrayDesc.size()==1)
				{
					out.println("<script>parent.patTaskListAdhocFrame.document.patTaskCriteriaForm.taskDesc.value='"+(String)arrayDesc.get(0)+"'</script>");
					out.println("<script>parent.patTaskListAdhocFrame.document.patTaskCriteriaForm.taskCode.value='"+(String)arrayCode.get(0)+"'</script>");
				}
				else
				{
					%>
					<script>
					var locale = document.forms[0].locale.value;
					var task ="<%=task%>";

					if(task=="")
						task = "%"
					else
						task+="%";
					
					var sql = "SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION_LANG_VW WHERE  INTERVENTION_CODE like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS='E' and upper(INTERVENTION_TYPE) like upper('"+task+"') and language_id ='"+locale+"'  ORDER BY SHORT_DESC";

					var target = "<%=taskDesc%>";

					var argArray = new Array();
					var namesArray = new Array();
					var valuesArray = new Array();
					var datatypesArray = new Array();

					argArray[0] = sql;
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[3] = datatypesArray;
					argArray[4] = "1,2";
					argArray[5] = target;
					argArray[6] = DESC_LINK;
					argArray[7] = CODE_DESC;
					retArray = CommonLookup(getLabel("Common.Task.label","COMMON"), argArray);

					if(retArray.length != 0)
					{
						parent.patTaskListAdhocFrame.document.forms[0].taskDesc.value=retArray[1];
						parent.patTaskListAdhocFrame.document.forms[0].taskCode.value=retArray[0];
					}
					</script>
<%         
				}
			}
		}
		else if(flagString.equals("location"))
		{

			String locationType = request.getParameter("locationType")==null ? "" :request.getParameter("locationType");
			String facility_id =  request.getParameter("facility_id")==null ? "" :request.getParameter("facility_id");
			String locationDesc = request.getParameter("locationDesc")==null ? "" :request.getParameter("locationDesc");
			retArray = patTask.getQueryForLocation(property,locationType,facility_id,locationDesc);
		
			if(retArray != null)
			{
				arrayDesc = (ArrayList)retArray.get(0);
				arrayCode = (ArrayList)retArray.get(1);

				if(arrayDesc.size()==1)
				{
					out.println("<script>parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.locationDesc.value='"+(String)arrayDesc.get(0)+"'</script>");
					out.println("<script>parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.locationCode.value='"+(String)arrayCode.get(0)+"'</script>");
				}
				else
				{
					%>
					<script>
					var locale = document.forms[0].locale.value;
					var sql = "";
					var facility_id = "<%=facility_id%>"

					if("<%=locationType%>"=='C')
						sql = "SELECT CLINIC_CODE code,LONG_DESC description FROM OP_CLINIC_LANG_VW WHERE CLINIC_CODE  like upper(?) and upper(SHORT_DESC) like upper(?)	 AND FACILITY_ID='"+facility_id+"' and EFF_STATUS='E'  AND LANGUAGE_ID = '" +locale+ "' ORDER BY SHORT_DESC";
					else
						sql = "SELECT NURSING_UNIT_CODE code,LONG_DESC description FROM IP_NURSING_UNIT_LANG_VW WHERE NURSING_UNIT_CODE  like upper(?) and upper(SHORT_DESC) like upper(?)	AND FACILITY_ID='"+facility_id+"' and EFF_STATUS='E'  AND LANGUAGE_ID ='"+ locale + "' ORDER BY SHORT_DESC"; 

					var target = "<%=locationDesc%>"
					var argArray = new Array();
					var namesArray = new Array();
					var valuesArray = new Array();
					var datatypesArray = new Array();

					argArray[0] = sql;
					argArray[1] = namesArray;
					argArray[2] = valuesArray;
					argArray[3] = datatypesArray;
					argArray[4] = "1,2";
					argArray[5] = target;
					argArray[6] = DESC_LINK;
					argArray[7] = CODE_DESC;
					retArray = CommonLookup(getLabel("Common.Task.label","COMMON"), argArray );

					if(retArray.length != 0)
					{
						parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.locationDesc.value=retArray[1];
						parent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.locationCode.value=retArray[0];
					}
					</script>
					<%
				}
			}
		}
	}
	catch(Exception ee)
	{
		//out.println("Exception from PatTaskListCriteria.jsp :"+ee.toString());//common-icn-0181
		  ee.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		 retArray.clear();
		 arrayDesc.clear() ;
		 arrayCode.clear();	
	}
%>	
</form>
</body>
</html>

