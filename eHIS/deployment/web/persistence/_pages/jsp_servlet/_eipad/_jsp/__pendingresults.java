package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.ORReviewResult.ORReviewResultHome;
import eOR.Common.OrRepository;
import com.ehis.eslp.ServiceLocator;
import eIPAD.pendingresults.PrevResultDateContainer;
import eIPAD.pendingresults.PrevResultCountResponse;
import eIPAD.pendingresults.PreviousResultsResponse;
import eIPAD.pendingresults.PreviousResultsRequest;
import eIPAD.pendingresults.ResultDetail;
import eIPAD.pendingresults.ResultCategory;
import java.util.Map.Entry;
import eIPAD.pendingresults.PendingResultForPatient;
import eIPAD.pendingresults.PatientDetail;
import eIPAD.pendingresults.PendingResultsResponse;
import eIPAD.pendingresults.PendingResults;
import eCommon.Common.CommonBean;
import eIPAD.pendingresults.PendingResultsRequest;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __pendingresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/eipad/jsp/PendingResults.jsp", 1709118029818L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1_0 ="\n<!DOCTYPE html>\n<html>\n<head>\n\n<title>Pending Results Page</title>\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> \n\n<link rel=\"stylesheet\" href=\"../css/iPadPendingResultCriteria.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script>  \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script> \n<script type=\"text/javascript\">\nvar bShCriteria = true;\n\tfunction showCriteria() {\n\t\t$(\'#searchCriteriaDiv\').slideToggle(\'fast\');\n\t\tif (bShCriteria) {\n\t\t\tbShCriteria = false;\n\t\t\tdocument.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-Up-Arrow.png\";\n\t\t} else {\n\t\t\tbShCriteria = true;\n\t\t\tdocument.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-down-Arrow.png\";\n\t\t}\n\t}\n\t\n\tfunction clearValues(){\n\t\tdocument.getElementById(\"PatientIdText\").value = \"\";\n\t\tvar periodComp = document.getElementById(\"PeriodComp\");\n\t\tif(periodComp){\n\t\t\t// sets the selection to \"LOW\"\n\t\t\tperiodComp.selectedIndex = 2;\n\t\t}\n\t\t\n\t\tvar normalcyComp = document.getElementById(\"NormalcyComp\");\n\t\tif(normalcyComp){\n\t\t\t// sets the select to \"--- Select ---\"\n\t\t\tnormalcyComp.selectedIndex = 0;\n\t\t}\n\t}\n\t\n\tfunction searchPendingResults(){\n\t\t// get the selected period and set it to the hidden component\n\t\tvar periodComp = document.getElementById(\"PeriodComp\");\n\t\tvar selectedFromPeriod;\n\t\tif(periodComp){\n\t\t\tselectedFromPeriod = periodComp.options[periodComp.selectedIndex].value;\n\t\t}\n\t\t// set the selected from period in the hidden text field also\n\t\tvar hdnFromPeriod = document.getElementById(\"hdnFromPeriod\");\n\t\tif(hdnFromPeriod){\n\t\t\thdnFromPeriod.value = selectedFromPeriod;\n\t\t}\n\t\t// the below code to also consider to period is only\n\t\t// to maintain uniformity - to period is not of use\n\t\t// presently\n\t\tvar hdnToPeriod = document.getElementById(\"hdnToPeriod\");\n\t\tvar toPeriod;\n\t\tif(hdnToPeriod){\n\t\t\ttoPeriod = hdnToPeriod.value;\n\t\t}\n\t\t\n\t\t// set the flag that search button is clicked\n\t\tvar hdnSearchClicked = document.getElementById(\"hdnSearchClicked\");\n\t\tif(hdnSearchClicked){\n\t\t\thdnSearchClicked.value = \"Y\";\n\t\t}\n\t\t\n\t\t// get the selected normalcy and set it to the hidden component\n\t\tvar normalcyComp = document.getElementById(\"NormalcyComp\");\n\t\tvar hdnNormalcyComp = document.getElementById(\"hdnNormalcyVal\");\n\t\tif(normalcyComp){\n\t\t\tvar selectedNormalcy = normalcyComp.options[normalcyComp.selectedIndex].value;\n\t\t\tif(hdnNormalcyComp){\n\t\t\t\thdnNormalcyComp.value = selectedNormalcy;\n\t\t\t}\n\t\t}\n\t\t\n\t\t// get the patient id from the text and set it to the hidden component\n\t\tvar patientIdComp = document.getElementById(\"PatientIdText\");\n\t\tvar hdnPatientComp = document.getElementById(\"hdnPatientId\");\n\t\tif(patientIdComp){\n\t\t\tvar patientId = patientIdComp.value;\n\t\t\tif(hdnPatientComp){\n\t\t\t\thdnPatientComp.value = patientId;\n\t\t\t}\n\t\t}\n\t\t\n\t\t// need to get groupby, and task applicability now\n\t\tvar hdnGroupbyComp = document.getElementById(\"hdnGroupby\");\n\t\tvar groupbyVal;\n\t\tif(hdnGroupbyComp){\n\t\t\tgroupbyVal = hdnGroupbyComp.value;\n\t\t}\n\t\t\n\t\tvar hdnTaskApplicability = document.getElementById(\"hdnGetTaskApplicability\");\n\t\tvar taskApplicabilityVal;\n\t\tif(hdnTaskApplicability){\n\t\t\ttaskApplicabilityVal = hdnTaskApplicability.value;\n\t\t}\n\t\t\n\t\tvar hdnCompleteReviewClicked = document.getElementById(\"hdnForwardReviewClicked\");\n\t\tif(hdnCompleteReviewClicked){\n\t\t\thdnCompleteReviewClicked.value = \"\";\n\t\t}\n\t\t\n\t\t// get the form and set the source url\n\t\tvar pendingResultsForm = document.getElementById(\"PendingResultsForm\");\n\t\tif(pendingResultsForm){\n\t\t\tparent.removeSpinner();\n\t\t\tpendingResultsForm.action = \"PendingResults.jsp?hdnFromPeriod=\"+selectedFromPeriod+\"&hdnToPeriod=\"+toPeriod+\"&hdnNormalcyVal=\"+selectedNormalcy+\"&hdnGetTaskApplicability=\"+taskApplicabilityVal+\"&hdnGroupby=\"+groupbyVal;\n\t\t\tpendingResultsForm.submit();\t\n\t\t\tparent.removeSpinner();\n\t\t}\n\t}\n\t\n\tfunction Practitioner(strCode,strDesc)\n\t {\n\t\t //alert(\"code =\"+strCode+\" pracid=\"+strDesc);\n\t\t document.getElementById(\"hdnPractCode\").value = strCode; \n\t\t document.getElementById(\"hdnPractDesc\").value  = strDesc;\n\t\t \n\t\t  $(\"#PendingResultsForm\").toggle(\"fast\");\n\t\t  $(\"#Dialog\").toggle(\"fast\");\n\t\t  scrolTop();\n\t\t  document.getElementById(\"srchFrame\").src = \"\";\n\t\t  \n\t\t  forwardResult();\n\t }\n\t\n\t function showPractitioner()\n\t  {  parent.removeSpinner();\n\t\t document.getElementById(\"srchFrame\").src = \"Practitioner.jsp\";\n\t\t  $(\"#PendingResultsForm\").toggle(\"fast\");\n\t\t  $(\"#Dialog\").toggle(\"fast\");\n\t }\n\t \n\t function scrolTop()\n\t {\n\t\t  //alert(\"helloj\");\n\t\t window.parent.scrolTop();\n\t }\n\t \n\t function showPreviousResults(rowCounter){\n\t\t//alert(\"row counter =\"+rowCounter); \n\t\tvar url=\"PreviousResults.jsp\";\n\t\tvar parameters =\"\";\n\t\tvar periodComp = document.getElementById(\"PeriodComp\");\n\t\tvar selectedFromPeriod;\n\t\tif(periodComp){\n\t\t\tselectedFromPeriod = periodComp.options[periodComp.selectedIndex].value;\n\t\t\tparameters += \"hdnSelectedPeriod=\"+selectedFromPeriod;\n\t\t}\n\t\t\n\t\t// set the selected from period in the hidden text field also\n\t\tvar hdnFromPeriod = document.getElementById(\"hdnFromPeriod\");\n\t\tif(hdnFromPeriod){\n\t\t\thdnFromPeriod.value = selectedFromPeriod;\n\t\t\tparameters += \"&hdnFromPeriod=\"+selectedFromPeriod;\n\t\t}\n\t\t\n\t\t// the below code to also consider to period is only\n\t\t// to maintain uniformity - to period is not of use\n\t\t// presently\n\t\tvar hdnToPeriod = document.getElementById(\"hdnToPeriod\");\n\t\tvar toPeriod;\n\t\tif(hdnToPeriod){\n\t\t\ttoPeriod = hdnToPeriod.value;\n\t\t\tparameters += \"&hdnToPeriod=\"+toPeriod;\n\t\t}\n\t\t\n\t\t// set the flag that search button is clicked\n\t\tvar hdnSearchClicked = document.getElementById(\"hdnSearchClicked\");\n\t\tif(hdnSearchClicked){\n\t\t\tparameters += \"&hdnSearchClicked=\"+hdnSearchClicked.value;\n\t\t}\n\t\t\n\t\t// get the selected normalcy and set it to the hidden component\n\t\tvar normalcyComp = document.getElementById(\"NormalcyComp\");\n\t\tvar hdnNormalcyComp = document.getElementById(\"hdnNormalcyVal\");\n\t\tif(normalcyComp){\n\t\t\tvar selectedNormalcy = normalcyComp.options[normalcyComp.selectedIndex].value;\n\t\t\tparameters += \"&hdnCANormalcyInd=\"+selectedNormalcy;\n\t\t\tparameters += \"&hdnNormalcyVal=\"+selectedNormalcy;\n\t\t}\n\t\t\n\t\t// get the patient id from the text and set it to the hidden component\n\t\tvar patientIdComp = document.getElementById(\"PatientIdText\");\n\t\tif(patientIdComp){\n\t\t\tvar patientId = patientIdComp.value;\n\t\t\tparameters += \"&hdnPatient_Id=\"+patientId;\n\t\t}\n\t\t\n\t\t// need to get groupby, and task applicability now\n\t\tvar hdnGroupbyComp = document.getElementById(\"hdnGroupby\");\n\t\tif(hdnGroupbyComp){\n\t\t\tparameters += \"&hdnGroupby=\"+hdnGroupbyComp.value;\n\t\t}\n\t\t\n\t\tvar hdnTaskApplicability = document.getElementById(\"hdnGetTaskApplicability\");\n\t\tif(hdnTaskApplicability){\n\t\t\tparameters += \"&hdnGetTaskApplicability=\"+hdnTaskApplicability.value;\n\t\t}\n\t\t\n\t\tvar practDescComp = document.getElementById(\"hdnPractDesc\");\n\t\tif(practDescComp){\n\t\t\tparameters += \"&hdnPractDesc=\"+practDescComp.value;\n\t\t}\n\t\t\n\t\tvar practCode = document.getElementById(\"hdnPractCode\")\t\n\t\tif(practCode){\n\t\t\tparameters += \"&hdnPractCode=\"+practCode.value;\n\t\t}\n\t\t\n\t\t//alert(\'parameters before patientid =\'+parameters);\n\t\tvar patient_IdComp = document.getElementById(\"hdnPatientId\"+rowCounter);\n\t\tif(patient_IdComp){\n\t\t\tparameters += \"&hdnPatientid=\"+patient_IdComp.value;\n\t\t}\n\t\t\n\t\tvar eventClassComp = document.getElementById(\"hdnEventClass\"+rowCounter);\n\t\tif(eventClassComp){\n\t\t\tparameters += \"&hdnEventClass=\"+eventClassComp.value;\n\t\t}\n\t\t\n\t\tvar eventCodeComp = document.getElementById(\"hdnEventCode\"+rowCounter);\n\t\tif(eventCodeComp){\n\t\t\tparameters += \"&hdnEventCode=\"+eventCodeComp.value;\n\t\t}\n\t\t\n\t\tvar eventGroupComp = document.getElementById(\"hdnEventGroup\"+rowCounter);\n\t\tif(eventGroupComp){\n\t\t\tparameters += \"&hdnEventGroup=\"+eventGroupComp.value;\n\t\t}\n\t\t\n\t\tvar histRectTypeComp = document.getElementById(\"hdnHistRectType\"+rowCounter);\n\t\tif(histRectTypeComp){\n\t\t\tparameters += \"&hdnHistRectType=\"+histRectTypeComp.value;\n\t\t}\n\t\t\n\t\tvar normalcyIndComp = document.getElementById(\"hdnNormalcyIndicator\"+rowCounter);\n\t\tif(normalcyIndComp){\n\t\t\tparameters +=\"&hdnNormalcyIndicator=\"+normalcyIndComp.value;\n\t\t}\n\t\t\n\t\tvar encounterIdComp = document.getElementById(\"hdnEncounterId\"+rowCounter);\n\t\tif(encounterIdComp){\n\t\t\tparameters += \"&hdnEpisodeId=\"+encounterIdComp.value;\n\t\t}\n\t\t\n\t\t// passing the patient class as \"IP\" as of now as this\n\t\t// is not present in the previous results\n\t\tparameters += \"&hdnPatClass=IP\";\n\t\t\n\t\t// finally also pass the row counter\n\t\t//parameters += \"&hdnRowCounter=\"+rowCounter;\n\t\twindow.parent.showPreviousResults(url,parameters);\n\t }\n\t\n\t  function CloseSearchCriteria(){\n\t\t  $(\"#PendingResultsForm\").toggle(\"fast\");\n\t\t  $(\"#Dialog\").toggle(\"fast\");\n\t\t  document.getElementById(\"srchFrame\").src = \"\";\n\t  }\n\t\n\t  function completeReview(){\n\t\t  var totalRecordComp = document.getElementById(\"hdnTotalRecords\");\n\t\t  var totalRecords;\n\t\t  var totalRecordsInt;\n\t\t  if(totalRecordComp){\n\t\t\t  totalRecords = totalRecordComp.value;\n\t\t\t  totalRecordsInt = parseInt(totalRecords);\n\t\t  }\n\t\t  //alert(\'total records=\'+totalRecordsInt);\n\t\t  \n\t\t  var checkComp;\n\t\t  var checkedCompCount = 0;\n\t\t  var selectedRows = \"\";\n\t\t  for(count=1;count<=totalRecordsInt;count++){\n\t\t\t  checkComp = document.getElementById(\"check\"+count);\n\t\t\t  if(checkComp){\n\t\t\t\t  if(checkComp.checked){\n\t\t\t\t\t  if(checkedCompCount > 0){\n\t\t\t\t\t\t  selectedRows += \",\"+count;  \n\t\t\t\t\t  }else{\n\t\t\t\t\t\t  selectedRows += \"\"+count;\n\t\t\t\t\t  }\n\t\t\t\t\t  checkedCompCount++;\n\t\t\t\t  }\n\t\t\t  }\n\t\t  }\n\t\t  \n\t\t  if(checkedCompCount == 0){\n\t\t\t  alert(\'Check Atleast One Event\');\n\t\t\t  return false;\n\t\t  }\n\t\t  \n\t\t  var selectedRowsComp = document.getElementById(\"hdnSelectedRows\");\n\t\t  if(selectedRowsComp){\n\t\t\t  selectedRowsComp.value = selectedRows;\n\t\t  }\n\t\t  \n\t\t  // this should be deleted after the entire code for complete review\n\t\t  // is done\n\t\t  //return false;\n\t\t  \n\t\t  var completeReviewComp = document.getElementById(\"hdnCompleteReviewClicked\");\n\t\t  if(completeReviewComp){\n\t\t\t  completeReviewComp.value = \"Y\";\n\t\t  }\n\t\t  \n\t\t  var confirmFlag = confirm(\"Do you want to complete the review of Selected Pending Results\");\n\t\t  if(confirmFlag){\n\t\t\t  var pendingResultsForm = document.getElementById(\"PendingResultsForm\");\n\t\t\t  if(pendingResultsForm){\n\t\t\t\t  pendingResultsForm.submit();\n\t\t\t  }  \n\t\t  }else{\n\t\t\t  return false;\n\t\t  }\n\t\t  \n\t  }\n\t  \n\t  function forwardResult(){\n\t\t  var totalRecordComp = document.getElementById(\"hdnTotalRecords\");\n\t\t  var totalRecords;\n\t\t  var totalRecordsInt;\n\t\t  if(totalRecordComp){\n\t\t\t  totalRecords = totalRecordComp.value;\n\t\t\t  totalRecordsInt = parseInt(totalRecords);\n\t\t  }\n\t\t  //alert(\'total records=\'+totalRecordsInt);\n\t\t  \n\t\t  var checkComp;\n\t\t  var checkedCompCount = 0;\n\t\t  var selectedRows = \"\";\n\t\t  for(count=1;count<=totalRecordsInt;count++){\n\t\t\t  checkComp = docu";
    private final static byte[]  _wl_block1_0Bytes = _getBytes( _wl_block1_0 );

    private final static java.lang.String  _wl_block1_1 ="ment.getElementById(\"check\"+count);\n\t\t\t  if(checkComp){\n\t\t\t\t  if(checkComp.checked){\n\t\t\t\t\t  if(checkedCompCount > 0){\n\t\t\t\t\t\t  selectedRows += \",\"+count;  \n\t\t\t\t\t  }else{\n\t\t\t\t\t\t  selectedRows += \"\"+count;\n\t\t\t\t\t  }\n\t\t\t\t\t  checkedCompCount++;\n\t\t\t\t  }\n\t\t\t  }\n\t\t  }\n\t\t  \n\t\t  if(checkedCompCount == 0){\n\t\t\t  alert(\'Check Atleast One Event\');\n\t\t\t  return false;\n\t\t  }\n\t\t  \n\t\t  var selectedRowsComp = document.getElementById(\"hdnSelectedRows\");\n\t\t  if(selectedRowsComp){\n\t\t\t  selectedRowsComp.value = selectedRows;\n\t\t  }\n\t\t  \n\t\t  // this should be deleted after the entire code for complete review\n\t\t  // is done\n\t\t  //return false;\n\t\t  \n\t\t  var completeReviewComp = document.getElementById(\"hdnCompleteReviewClicked\");\n\t\t  if(completeReviewComp){\n\t\t\t  completeReviewComp.value = \"N\";\n\t\t  }\n\t\t  \n\t\t  var forwardReviewComp = document.getElementById(\"hdnForwardReviewClicked\");\n\t\t  if(forwardReviewComp){\n\t\t\t  forwardReviewComp.value = \"Y\";\n\t\t  }\n\t\t  \n\t\t  var confirmFlag = confirm(\"Do you want to Forward the selected Results\");\n\t\t  if(confirmFlag){\n\t\t\t  var pendingResultsForm = document.getElementById(\"PendingResultsForm\");\n\t\t\t  if(pendingResultsForm){\n\t\t\t\t  pendingResultsForm.submit();\n\t\t\t  }  \n\t\t  }else{\n\t\t\t  return false;\n\t\t  }\n\t\t  \n\t  }\n\t  \n\t  function selectAllRecords(){\n\t\t  var totalRecordComp = document.getElementById(\"hdnTotalRecords\");\n\t\t  var totalRecords;\n\t\t  var totalRecordsInt;\n\t\t  if(totalRecordComp){\n\t\t\t  totalRecords = totalRecordComp.value;\n\t\t\t  totalRecordsInt = parseInt(totalRecords);\n\t\t  }\n\t\t  \n\t\t  var checkComp;\n\t\t  var checkedCompCount = 0;\n\t\t  var selectedRows = \"\";\n\t\t  for(count=1;count<=totalRecordsInt;count++){\n\t\t\t  checkComp = document.getElementById(\"check\"+count);\n\t\t\t  if(checkComp){\n\t\t\t\t  checkComp.checked = true;\n\t\t\t  }\n\t\t  }\n\t\t  \n\t\t  // now check the check box shown at patient level\n\t\t  var totalPatientCountComp = document.getElementById(\"hdnPatientCounter\");\n\t\t  var totalPatientCountStr;\n\t\t  var totalPatientCount = 0;\n\t\t  if(totalPatientCountComp){\n\t\t\t  totalPatientCountStr = totalPatientCountComp.value;\n\t\t\t  totalPatientCount = parseInt(totalPatientCountStr);\n\t\t  }\n\t\t  \n\t\t  for(cnt=1;cnt<=totalPatientCount;cnt++){\n\t\t\t  patientChkbox = document.getElementById(\"checkb\"+cnt);\n\t\t\t  if(patientChkbox){\n\t\t\t\t  patientChkbox.checked = true;\n\t\t\t  }\n\t\t  }\n\t\t  \n\t  }\n\t  \n\t  function selectPatientCategories(){\n\t\t  var totalPatientCountComp = document.getElementById(\"hdnPatientCounter\");\n\t\t  var totalPatientCountStr;\n\t\t  var totalPatientCount = 0;\n\t\t  if(totalPatientCountComp){\n\t\t\t  totalPatientCountStr = totalPatientCountComp.value;\n\t\t\t  totalPatientCount = parseInt(totalPatientCountStr);\n\t\t  }\n\t\t  // iterate through the patients\n\t\t  var patientChkbox;\n\t\t  var recordRunningStr;\n\t\t  var recordRunningTemp = 0;\n\t\t  var recordRunningCounter = 0;\n\t\t  var checkStatus;\n\t\t  for(cnt=1;cnt<=totalPatientCount;cnt++){\n\t\t\t  patientChkbox = document.getElementById(\"checkb\"+cnt);\n\t\t\t  if(patientChkbox){\n\t\t\t\t  recordRunningStr = patientChkbox.value;\n\t\t\t\t  recordRunningTemp = parseInt(recordRunningStr);\n\t\t\t\t  checkStatus = patientChkbox.checked;\n\t\t\t\t \n\t\t\t\t  var chkbox;\n\t\t\t\t  for(ind = (recordRunningCounter + 1); ind <= (recordRunningCounter + recordRunningTemp);ind++){\n\t\t\t\t\t  chkbox = document.getElementById(\"check\"+ind);\n\t\t\t\t\t  if(chkbox){\n\t\t\t\t\t\t  chkbox.checked = checkStatus;\n\t\t\t\t\t  }\n\t\t\t\t  }\n\t\t\t\t  recordRunningCounter += recordRunningTemp;\n\t\t\t  }\n\t\t\t  \n\t\t  }\n\t\t  \n\t  }\n\t  \n\t  function DisplayOrHideDetails(HeaderName,objImg)\n\t  {\n\t  \t\n\t  \t var imgPath = objImg.src; \n\t  \t if( imgPath.indexOf(\"Expanded\") != -1 )\n\t  \t\t {\n\t  \t\t objImg.src = \"../images/More group icon main.png\";\n\t  \t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'none\');\n\t  \t\t }\n\t  \t else\n\t  \t\t {\n\t  \t\t objImg.src = \"../images/Expanded Group Icon Main.png\";\n\t  \t\t\t$(\"[data-class = \'\" + HeaderName + \"\']\").css(\'display\',\'block\');\n\t  \t\t }\n\t  \t var src = \"../images/Expanded group Icon.png\";\n\t  \t// $(\"[data-image = \'\" + HeaderName + \"\']\").css(\'background\', \'url(\' + src + \')\'); \n\t  \t$(\"[data-image = \'\" + HeaderName + \"\']\").attr(\"src\" , src);\n\t  \t\n\t  }\n\t  \n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n\n<section id=\"page1\" data-role=\"page\"  style=\"padding:0px;width:100%;background:#ffffff\"> \n<form name=\'PendingResultsForm\' id=\'PendingResultsForm\' method=\'post\' id=\"PendingResultsForm\" style = \"width:100%\">\n<!--  <div style=\"width:100%;height:auto\"></div> -->\n\t  <div id = \"divSrch\"  data-role =\"none\" class=\"searchStyle\" onclick = \"showCriteria()\">\n\t\t  <!--  <span class = \"spanDvsrch\">Search</span> -->\n\t\t <!--    <img src = \"Heading-Panel-down-Arrow.png\" class = \"imgg\"></img>  -->\n\t\t <table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  <tr style = \"height:100%;width:100%\">\n\t\t\t    <td style = \"width:95%\">\n\t\t\t         <span class = \"searchTextStyle\">Search</span>\n\t\t\t    </td>\n\t\t\t    <td style = \"width:5%\" align = \"center\" valign = \"center\">\n\t\t\t        <img src = \"../images/Heading-Panel-down-Arrow.png\" id = \"imgCriteria\"></img> \t\n\t\t\t    </td>\n\t\t\t  </tr>\n\t\t    </table>\t  \n\t  </div>\n\t  <div style=\"width : 100%;height : 1px;background : #333333;\" data-role =\"none\"></div>\n\t  <div id=\"searchCriteriaDiv\" data-role =\"none\"  style = \"height:auto;padding:0px;background:#ffffff;\" >\n\t\t\t<table style=\"width: 100%;\">\n\t\t\t\t<tr style=\"height: 30px; width: 100%\">\n\t\t\t\t\t<td align=\"left\" width=\"33%\"><span class=\"labelStyle\">Patient\n\t\t\t\t\t\t\tId</span></td>\n\t\t\t\t\t<td align=\"left\" width=\"33%\"><span class=\"labelStyle\">Select\n\t\t\t\t\t\t\tPeriod</span></td>\n\t\t\t\t\t<td align=\"left\" width=\"33%\"><span class=\"labelStyle\">Normalcy\n\t\t\t\t\t\t\tIndicator</span></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr style=\"height: 35px; width: 100%\">\n\t\t\t\t\t<td align=\"left\" width=\"33%\"><input type=\"Text\"\n\t\t\t\t\t\tid=\"PatientIdText\" data-role = \"none\" class=\"textBoxStyle\" value=\"";
    private final static byte[]  _wl_block1_1Bytes = _getBytes( _wl_block1_1 );

    private final static java.lang.String  _wl_block2 ="\"/></td>\n\t\t\t\t\t<td width=\"33%\"><select id=\"PeriodComp\" data-role=\"none\"\n\t\t\t\t\t\tclass=\"cmbFilterBy\" onchange=\"\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t\t\t\t<option value=\"LOD\" selected=\"selected\">Last One Day</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t\t<option value=\"LOD\">Last One Day</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t\t<option value=\"LTD\" selected=\"selected\">Last Three Days</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t<option value=\"LTD\">Last Three Days</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t\t\t<option value=\"LOW\" selected=\"selected\">Last One Week</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t<option value=\"LOW\">Last One Week</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t<option value=\"LOM\" selected=\"selected\">Last One Month</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<option value=\"LOM\">Last One Month</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<option value=\"LOY\" selected=\"selected\">Last One Year</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<option value=\"LOY\">Last One Year</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t\t\t\t\t</select></td>\n\t\t\t\t\t<td width=\"33%\"><select id=\"NormalcyComp\" data-role=\"none\"\n\t\t\t\t\t\tclass=\"cmbFilterBy\" onchange=\"\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t<option value=\"S\">All</option>\n\t\t\t\t\t\t\t<option value=\"A\">Abnormal</option>\n\t\t\t\t\t\t\t<option value=\"C\">Critical</option>\n\t\t\t\t\t\t\t<option value=\"N\">Normal</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<option value=\"S\">All</option>\n\t\t\t\t\t\t\t<option value=\"A\" selected=\"selected\">Abnormal</option>\n\t\t\t\t\t\t\t<option value=\"C\">Critical</option>\n\t\t\t\t\t\t\t<option value=\"N\">Normal</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t<option value=\"S\">All</option>\n\t\t\t\t\t\t\t<option value=\"A\" >Abnormal</option>\n\t\t\t\t\t\t\t<option value=\"C\" selected=\"selected\">Critical</option>\n\t\t\t\t\t\t\t<option value=\"N\">Normal</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t<option value=\"S\">All</option>\n\t\t\t\t\t\t\t<option value=\"A\" >Abnormal</option>\n\t\t\t\t\t\t\t<option value=\"C\">Critical</option>\n\t\t\t\t\t\t\t<option value=\"N\" selected=\"selected\">Normal</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t</select></td>\n\n\t\t\t\t</tr>\n\t\t\t\t<tr style=\"height: 5px;\">\n\t\t\t\t\t<td width=\"33%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"33%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"33%\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr style=\"height: 35px;\">\n\t\t\t\t\t<td width=\"33%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"33%\">&nbsp;</td>\n\t\t\t\t\t<td width=\"33%\">\n\t\t\t\t\t\t<table width=\"100%\" border=\"0\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\"9%\">&nbsp;</td>\n\t\t\t\t\t\t\t\t<td width=\"45%\"><input type=\"button\" value=\"Search\"\n\t\t\t\t\t\t\t\t\tid=\"Search\" data-role = \"none\" class=\"searchbuttonStyle\" onclick=\"searchPendingResults()\" /></td>\n\t\t\t\t\t\t\t\t<td width=\"46%\"><input type=\"button\" value=\"Clear\"\n\t\t\t\t\t\t\t\t\tid=\"Clear\" data-role = \"none\" class=\"searchbuttonStyle\" onclick=\"clearValues()\"/></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\t\t\n\t  \t<input type=\"hidden\" name=\"hdnFromPeriod\" id=\"hdnFromPeriod\" id=\"hdnFromPeriod\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" />\n\t\t<input type=\"hidden\" name=\"hdnToPeriod\" id=\"hdnToPeriod\" id=\"hdnToPeriod\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" />\n\t\t<input type=\"hidden\" name=\"hdnNormalcyVal\" id=\"hdnNormalcyVal\" id=\"hdnNormalcyVal\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"hdnPatientId\" id=\"hdnPatientId\" id=\"hdnPatientId\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnSearchClicked\" id=\"hdnSearchClicked\" id=\"hdnSearchClicked\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnGroupby\" id=\"hdnGroupby\" id=\"hdnGroupby\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" id=\"hdnCANormalcyInd\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnGetTaskApplicability\" id=\"hdnGetTaskApplicability\" id=\"hdnGetTaskApplicability\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" id=\"hdnSelectedPeriod\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnPractDesc\" id=\"hdnPractDesc\" id=\"hdnPractDesc\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"hdnPractCode\" id=\"hdnPractCode\" id=\"hdnPractCode\" value=\"\"/>\n\t\t<input type=\"hidden\" name=\"hdnCompleteReviewClicked\" id=\"hdnCompleteReviewClicked\" id=\"hdnCompleteReviewClicked\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnForwardReviewClicked\" id=\"hdnForwardReviewClicked\" id=\"hdnForwardReviewClicked\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n\t\t<input type=\"hidden\" name=\"hdnSelectedRows\" id=\"hdnSelectedRows\" id=\"hdnSelectedRows\" value=\"\"/>\n\t\n\t<div id=\"resultPageHeader\" style=\"width: 100%\" class=\"resultPageHeader\">\n\t\t<table style=\"height: 100%; width: 100%\" cellpadding=\"0\"\n\t\t\tcellspacing=\"0\" border=\"0\">\n\t\t\t<tr style=\"height: 100%; width: 100%\">\n\t\t\t\t<td style=\"width: 55%\"><span class=\"resultTextStyle\">\n\t\t\t\tPending\tResults Review</span></td>\n\t\t\t\t<td style=\"width: 12%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\ttype=\"button\" value=\"Select All\" data-role = \"none\" class=\"buttonStyle\" onclick=\"selectAllRecords()\"/></td>\n\t\t\t\t<td style=\"width: 12%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\ttype=\"button\" value=\"Forward\" data-role = \"none\" class=\"buttonStyle\" onclick=\"showPractitioner()\"/></td>\n\t\t\t\t<td style=\"width: 18%\" align=\"right\" valign=\"center\"><input\n\t\t\t\t\ttype=\"button\" value=\"Complete Review\" data-role = \"none\" class=\"buttonStyle\" onclick=\"completeReview()\"/></td>\n\t\t\t\t<td style=\"width: 2%\">&nbsp;</td>\n\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\t\n\t<div id=\"mainResults\" style=\"width: 100%; height:100%;background:#ffffff;\" >\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not complete the review.\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not complete the review. Error in getting result from EJB layer \");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not forward the result.\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Successfully forwarded the result.\");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t<script>\n\t\t\t\talert(\"Could not forward the result. Error in getting result from EJB layer \");\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\n\t\t\t<input type=\"hidden\" id=\"hdnTotalRecords\" name=\"hdnTotalRecords\" id=\"hdnTotalRecords\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"/>\n\t\t\t\n\t\t\t\t<table style=\"width: 100%; border: 1px solid #afb0b0\" border=\"0\"\n\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t<tr class=\'trResultsHeader\'>\n\t\t\t\t\t<td style=\'width: 4%\' align=\"center\" valign=\"middle\"><img\n\t\t\t\t\t\tsrc=\"../images/More group icon main.png\"\n\t\t\t\t\t\tonclick=\"DisplayOrHideDetails(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' , this)\"></img></td>\n\t\t\t\t\t<td style=\'width: 96%\' align=\'left\'>\n\t\t\t\t\t\t<table style=\"width: 100%;\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td style=\'width: 25%\' align=\'left\'>\n\t\t\t\t\t\t\t\t<span\n\t\t\t\t\t\t\t\t\tclass=\"spWidHeaderAllergies\"><b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</b></span>\n\t\t\t\t\t\t\t\t&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t<span\n\t\t\t\t\t\t\t\t\tclass=\"spWidHeaderAllergies\"><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></span>\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td style=\"width:6%\" align=\"center\">\n\t\t\t\t\t\t\t\t\t<span>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t</span>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\n\t\t\t\t<div data-role=\"none\" data-class=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" style=\"display:none\">\n\t\t\t\t\t<table style=\"width: 100%; border: 1px solid #afb0b0\" border=\"0\"\n\t\t\t\t\tcellspacing=\"0\" cellpadding=\"0\">\n\n\t\t\t\t\t\t<tr class=\"trAllergySummary\">\n\t\t\t\t\t\t\t<td style=\'width: 4%; height:100%\' align=\"center\" valign=\"middle\">\n\t\t\t\t\t\t\t\t<input type=\"checkbox\" id=\"checkb";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" name=\"checkb";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" onclick=\"selectPatientCategories()\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\"/>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<td style=\'width: 96%\' align=\'left\'>\n\t\t\t\t\t\t\t\t<table style=\"width: 100%;border: 1px solid #48d1d8;\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<table style=\"width: 100%;\" border=\"0\" cellspacing=\"0\"\n\t\t\t\t\t\t\t\t\tcellpadding=\"0\">\n\t\t\t\t\t\t\t\t\t\t<tr style=\"width: 100%;\" class=\"resultCategoryHeader\">\n\t\t\t\t\t\t\t\t\t\t<td style=\"width: 2%\" align=\"center\">\n\t\t\t\t\t\t\t\t\t\t&nbsp;\t\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td style=\'width: 35%\' align=\'left\'>\n\t\t\t\t\t\t\t\t\t\t\t<span class=\"resultCategoryStyle\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t\t\t\t\t\t</span>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<input type=\"hidden\" name=\"hdnPatientId";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"hdnPatientId";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnEventClass";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"hdnEventClass";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnEventCode";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"hdnEventCode";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnEventGroup";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" id=\"hdnEventGroup";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnHistRectType";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" id=\"hdnHistRectType";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnNormalcyIndicator";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" id=\"hdnNormalcyIndicator";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnControlSysId";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"hdnControlSysId";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnAccessionNum";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" id=\"hdnAccessionNum";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" />\n\t\t\t\t<input type=\"hidden\" name=\"hdnReviewRemarks";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\" id=\"hdnReviewRemarks";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" value=\"\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnReviewType";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"hdnReviewType";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnCreationDateTime";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"hdnCreationDateTime";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnControlSysEventCode";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"hdnControlSysEventCode";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"hdnEncounterId";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"hdnEncounterId";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"/>\n\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t<td>\t\n\t\t\t\t <div data-role = \"none\" data-class = \"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" style = \"display:block\" data-childrows = \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n     \t\t\t\t <table style = \"width:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n     \t\t\t\t\t<tr class = \"trResultDetails\" >\n       \t\t\t\t\t\t \n        \t\t\t\t\t<td style = \'width:100%\'>\n          \n          \t\t\t\t\t <table style= \'width:100%;height:100%\' border = \"0\" cellspacing = \'0\' cellpadding = \'0\' class = \"tbResultDetails\">\n             \t\t\t\t\t <tr style = \'width:100%;height:100%\'>\n                \t\t\t\t\n               \t\t\t\t\t <td style = \'width:100%;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="background:#cccccc;";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="background:#ffffff;";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' valign = \"center\">\n\t\t\t\t\t\t\t\t \t<table style = \'width:100%;height:100%\' border = \'0\' cellspacing = \'0\' cellpadding = \'0\'>\n                      \t\t\t\t<tr style = \'width:100%;height:100%\'>\n                      \t\t\t\t\t<td style = \'width:5%\'>\n                      \t\t\t\t\t\t<input type=\"checkbox\" id=\'check";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' name=\'check";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' value=\"\"/>\n                      \t\t\t\t\t</td>\n                      \t\t\t\t\t<td style =\"width:50%\" align=\"left\">\n                      \t\t\t\t\t\t<table style = \'width:100%;height:100%\' border = \'0\' cellspacing = \'0\' cellpadding = \'0\'>\n                      \t\t\t\t\t\t\t<tr>\n                      \t\t\t\t\t\t\t\t<td width=\"100%\">\n                      \t\t\t\t\t\t\t\t<span class=\"resultStyle\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</span>\n                      \t\t\t\t\t\t\t\t</td>                      \t\t\t\t\t\t\t\t\n                      \t\t\t\t\t\t\t</tr>\n                      \t\t\t\t\t\t\t<tr>\n                      \t\t\t\t\t\t\t\t<td width=\"100%\">\n                      \t\t\t\t\t\t\t\t<span class=\"resultStyle\">\n                      \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n                      \t\t\t\t\t\t\t\t</span>\n                      \t\t\t\t\t\t\t\t</td>\n                      \t\t\t\t\t\t\t</tr>\n                      \t\t\t\t\t\t</table>\t\n                      \t\t\t\t\t</td>\n                      \t\t\t\t\t<td style=\"width:6%\" align=\"center\">\n                      \t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n                      \t\t\t\t\t\t<a href=\"\" onclick=\"showPreviousResults(\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\')\" ><img src=\"../images/More.png\"  ></img></a>\n                      \t\t\t\t\t";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\t\n                      \t\t\t\t\t</td>\n                      \t\t\t\t</tr>\n                      \t\t\t\t</table>\n                      \t\t\t</td>\n                      \t\t\t</tr>\n                      \t\t\t</table>\t\n                      \t\t\t\n                      \t\t</td>\n                      \t\t</tr>\n                      \t</table>\t\t\t \n                       </div>\n                       \n                     </td>  \n                     </tr>   \n        \t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t</table>               \n                   </td>\t\t\t\n\t\t\t\t</tr>\t\t\t\t\n\t\t\t</table>\n\t\t</div>\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\n\t</div>\n\t\n\t<input type=\"hidden\" id=\"hdnPatientCounter\" name=\"hdnPatientCounter\" id=\"hdnPatientCounter\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\"/>\n\t\n\t</form>\n\t\n\t <div data-role=\"none\" id=\'Dialog\' style=\"width:100%; height:auto;display:none;background:#ffffff;\">\n    \t <iframe src = \"\" width = \"100%\" height = \"1000px\" scrolling = \"yes\" id=\"srchFrame\" frameborder=\"0\"></iframe>  \n\t </div>\n\t\n\t</section>\n\t\n<script>\nwindow.onload = initializefunction();\nfunction initializefunction(){\n\t//searchPendingResults();\n}\n\nfunction changeOrientation(orient)\n{\n}\n\n</script>\t\n\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

	// from and to period is not useful as of now but having such
	// properties in the request helps when the from and to time period
	// components are introduced
	String fromPeriod = request.getParameter("hdnFromPeriod");
	fromPeriod = CommonBean.checkForNull(fromPeriod,
			IPADConstants.LAST_ONE_WEEK);
	if (fromPeriod.trim().equals("")) {
		fromPeriod = IPADConstants.LAST_ONE_WEEK;
	}

	String toPeriod = request.getParameter("hdnTPeriod");
	toPeriod = CommonBean.checkForNull(toPeriod);

	String selectedPeriod = request.getParameter("hdnSelectedPeriod");//hdnSelectedPeriod
	selectedPeriod = CommonBean.checkForNull(selectedPeriod,
			IPADConstants.LAST_ONE_WEEK);

	String searchClicked = request.getParameter("hdnSearchClicked");
	if (searchClicked == null || searchClicked.trim().equals("")) {
		searchClicked = "Y";
	}

	String normalcy = "";
	String patientId = "";
	// if search button is clicked then this page is reloaded
	// hence the need to set the patient id and the normalcy
	// comes in this case only
	if ("Y".equalsIgnoreCase(searchClicked)) {
		// changed to get the patient id from the patient text
		patientId = request.getParameter("hdnPatientId");
		patientId = CommonBean.checkForNull(patientId);
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	} else {
		normalcy = request.getParameter("hdnNormalcyVal");
		normalcy = CommonBean.checkForNull(normalcy, "Z");
	}

	String groupby = request.getParameter("hdnGroupby");
	groupby = CommonBean.checkForNull(groupby);
	//String caNormalcyInd = request.getParameter("normalcy_ind");
	//caNormalcyInd = CommonBean.checkForNull(caNormalcyInd,"Z");
	String getTaskApplicability = request
			.getParameter("hdnGetTaskApplicability");
	getTaskApplicability = CommonBean
			.checkForNull(getTaskApplicability);

	// this will store the complete review clicked status
	String completeReviewClicked = request
			.getParameter("hdnCompleteReviewClicked");
	completeReviewClicked = CommonBean.checkForNull(
			completeReviewClicked, "N");

	// this will store the forward review clicked status
	String forwardReviewClicked = request
			.getParameter("hdnForwardReviewClicked");
	forwardReviewClicked = CommonBean.checkForNull(
			forwardReviewClicked, "N");

	String selectedRows = request.getParameter("hdnSelectedRows");
	selectedRows = CommonBean.checkForNull(selectedRows);

            _bw.write(_wl_block1_0Bytes, _wl_block1_0);
            _bw.write(_wl_block1_1Bytes, _wl_block1_1);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block2Bytes, _wl_block2);

								if (IPADConstants.LAST_ONE_DAY.equals(fromPeriod)) {
							
            _bw.write(_wl_block3Bytes, _wl_block3);

								} else {
							
            _bw.write(_wl_block4Bytes, _wl_block4);

								}
								if (IPADConstants.LAST_THREE_DAYS.equals(fromPeriod)) {
							
            _bw.write(_wl_block5Bytes, _wl_block5);

								} else {
							
            _bw.write(_wl_block6Bytes, _wl_block6);

								}
								if (IPADConstants.LAST_ONE_WEEK.equals(fromPeriod)) {
							
            _bw.write(_wl_block7Bytes, _wl_block7);

								} else {
							
            _bw.write(_wl_block8Bytes, _wl_block8);

								}

								if (IPADConstants.LAST_ONE_MONTH.equals(fromPeriod)) {
							
            _bw.write(_wl_block9Bytes, _wl_block9);

								} else {
							
            _bw.write(_wl_block10Bytes, _wl_block10);

								}

								if (IPADConstants.LAST_ONE_YEAR.equals(fromPeriod)) {
							
            _bw.write(_wl_block11Bytes, _wl_block11);

								} else {
							
            _bw.write(_wl_block12Bytes, _wl_block12);

								}
							
            _bw.write(_wl_block13Bytes, _wl_block13);

								if ("".equals(normalcy.trim()) || "S".equals(normalcy.trim())
										|| "Z".equals(normalcy.trim())) {
							
            _bw.write(_wl_block14Bytes, _wl_block14);

								} else if ("A".equals(normalcy.trim())) {
							
            _bw.write(_wl_block15Bytes, _wl_block15);

								} else if ("C".equals(normalcy.trim())) {
							
            _bw.write(_wl_block16Bytes, _wl_block16);

								} else if ("N".equals(normalcy.trim())) {
							
            _bw.write(_wl_block17Bytes, _wl_block17);

								}
							
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fromPeriod));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(toPeriod));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(searchClicked));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(groupby));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(normalcy));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(getTaskApplicability));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(selectedPeriod));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(completeReviewClicked));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(forwardReviewClicked));
            _bw.write(_wl_block28Bytes, _wl_block28);

		PendingResultsResponse pendingResultsResponse = null;
		Map<PatientDetail, PendingResultForPatient> pendingResultMap = null;
		int recordCounter = 1;
		// this will contain the total records obtained
		int totalRecords = 0;
		// code should be put here to complete the review if
		// user has clicked on complete review button
		// same way handle the forward to practitioner request
		if ("Y".equalsIgnoreCase(completeReviewClicked)) {
			String hist_rec_type = "";
			String contr_sys_id = "";
			String contr_sys_event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				contr_sys_event_code = request
						.getParameter("hdnControlSysEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				create_date_time = request
						.getParameter("hdnCreationDateTime" + token);
				review_remarks = request
						.getParameter("hdnReviewRemarks" + token);

				record = new String[7];
				record[0] = hist_rec_type;
				record[1] = contr_sys_id;
				record[2] = contr_sys_event_code;
				record[3] = accession_num;
				record[4] = review_type;
				record[5] = create_date_time;
				record[6] = review_remarks;

				// this is the key used in the desktop application
				// and only this key is understood by the ejb
				dataMap.put("review_data" + selectionCounter, record);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
								+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						contr_sys_event_code = request
								.getParameter("hdnControlSysEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						create_date_time = request
								.getParameter("hdnCreationDateTime" + token);
						review_remarks = request
								.getParameter("hdnReviewRemarks" + token);
	
						record = new String[7];
						record[0] = hist_rec_type;
						record[1] = contr_sys_id;
						record[2] = contr_sys_event_code;
						record[3] = accession_num;
						record[4] = review_type;
						record[5] = create_date_time;
						record[6] = review_remarks;
	
						// this is the key used in the desktop application
						// and only this key is understood by the ejb
						dataMap.put("review_data" + selectionCounter, record);
	
						selectionCounter++;
					}
				}
			}

			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_DELETE", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_DELETE"));
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT", OrRepository
						.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT"));
				sqlMap.put(
						"SQL_OR_RESULT_REVIEW_REVIEWED_PRACT",
						OrRepository
								.getOrKeyValue("SQL_OR_RESULT_REVIEW_REVIEWED_PRACT"));
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("insert", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				
            _bw.write(_wl_block29Bytes, _wl_block29);
		
					}
				}else{
				
            _bw.write(_wl_block30Bytes, _wl_block30);

				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		// this code is for forward functionality
		if ("Y".equalsIgnoreCase(forwardReviewClicked)) {

			String hist_rec_type = "";
			String contr_sys_id = "";
			String event_code = "";
			String accession_num = "";
			String review_type = "";
			String create_date_time = "";
			String review_remarks = "";
			String normalcy_ind = "";

			String practitionerId = (String) session
					.getValue("ca_practitioner_id");
			StringTokenizer stTokenizer = new StringTokenizer(selectedRows,
					",");
			String token = null;
			String record[] = null;
			int selectionCounter = 0;
			Map<String, Object> dataMap = new HashMap<String, Object>();
			// this list will have the details of all the records
			// being forwarded
			List<Map<String,String>> forwardPractDetailsList = new ArrayList<Map<String,String>>();
			// Map will have the details about one record being forwarded
			Map<String,String> forwardPractDetailsMap = new HashMap<String,String>();
			
			int commaIndex = selectedRows.indexOf(",");
			if(commaIndex < 0 && !selectedRows.trim().equals("")){
				token = selectedRows;
				hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
				contr_sys_id = request.getParameter("hdnControlSysId"
						+ token);
				event_code = request
						.getParameter("hdnEventCode" + token);
				accession_num = request.getParameter("hdnAccessionNum"
						+ token);
				review_type = request.getParameter("hdnReviewType"
						+ token);
				normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
				
				forwardPractDetailsMap.put("hist_rec_type", hist_rec_type);
				forwardPractDetailsMap.put("contr_sys_id", contr_sys_id);
				forwardPractDetailsMap.put("accession_num", accession_num);
				forwardPractDetailsMap.put("review_type", review_type);
				forwardPractDetailsMap.put("event_code", event_code);
				forwardPractDetailsMap.put("normalcy_ind", normalcy_ind);
				
				forwardPractDetailsList.add(forwardPractDetailsMap);
				selectionCounter++;
			}
			else{
				if (stTokenizer != null) {
					while (stTokenizer.hasMoreTokens()) {
						token = stTokenizer.nextToken();
						token = token.trim();
	
						// now get the individual fields
						hist_rec_type = request.getParameter("hdnHistRectType"
						+ token);
						contr_sys_id = request.getParameter("hdnControlSysId"
								+ token);
						event_code = request
								.getParameter("hdnEventCode" + token);
						accession_num = request.getParameter("hdnAccessionNum"
								+ token);
						review_type = request.getParameter("hdnReviewType"
								+ token);
						normalcy_ind = request.getParameter("hdnNormalcyIndicator"+token);
						
						selectionCounter++;
					}
				}
			}

			// now form the forward practitioner id list
			List<String> forwardPractIdList = new ArrayList<String>();
			// get the practitioner id to forward the result
			// from the request parameter
			// presently the assumption is that this parameter will contain
			// only one practitioner id - in future, multiple practitioner
			// id selection can be also be supported by setting
			// a comma separated string in the parameter
			String forwardPractId = request.getParameter("hdnPractCode");
			forwardPractIdList.add(forwardPractId);
			dataMap.put("forwardPract_id",forwardPractIdList);
			
			// this is the key used in the desktop application
			// and only this key is understood by the ejb
			dataMap.put("forwardPractHash", forwardPractDetailsList);
			// now set the practitioner id, login id and the total count
			// in this case, login id and practitioner id are the same
			dataMap.put("pract_id", practitionerId);
			dataMap.put("login_by_id", practitionerId);
			// no need to send the total count as it is not needed
			//dataMap.put("totalCount", "" + selectionCounter);

			Map<String, String> sqlMap = new HashMap<String, String>();
			try {
				sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT",
						OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT") );
	            sqlMap.put("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK",
	            		OrRepository.getOrKeyValue("SQL_OR_RESULT_REVIEW_INSERT_FORWARD_PRACT_DUPCHK") );
			} catch (Exception e) {
				e.printStackTrace();
				// nothing much can be done here
				
            _bw.write(_wl_block31Bytes, _wl_block31);

			}
			// get the properties to be passed to EJB from session
			Properties jdbc_props = (Properties) session.getValue("jdbc");
			dataMap.put("properties", jdbc_props);

			Object home = null;
			Object busObj = null;
			Object argArray[] = null;
			Map<String, Object> map = new HashMap<String, Object>();
			try{
				home = ServiceLocator.getInstance().getHome(
						OrRepository.getOrKeyValue("OR_REVIEW_RESULT_JNDI"),
						ORReviewResultHome.class, true);
				busObj = (home.getClass().getMethod("create", null))
						.invoke(home, null);

				argArray = new Object[2];
				argArray[0] = dataMap;
				argArray[1] = sqlMap;
				Class[] paramArray = new Class[2];
				paramArray[0] = dataMap.getClass();
				paramArray[1] = sqlMap.getClass();
				map = (HashMap) (busObj
						.getClass().getMethod("modify", paramArray)).invoke(
						busObj, argArray);

				(busObj.getClass().getMethod("remove", null)).invoke(busObj,
						null);
				
				Object result = map.get("result");
				if(result instanceof Boolean){
					if(!((Boolean)result).booleanValue()){
				
            _bw.write(_wl_block31Bytes, _wl_block31);
		
					}else{
				
            _bw.write(_wl_block32Bytes, _wl_block32);
		
					}
				}else{
				
            _bw.write(_wl_block33Bytes, _wl_block33);

				}
				
				// set the search clicked so that new set of pending results
				// are fetched from db
				if("Y".equalsIgnoreCase(searchClicked)){
					searchClicked = "Y";
				}
			}catch(Exception ex){
				ex.printStackTrace();	
			}
			
		}

		int patientCounter = 0;
		
		if ("Y".equalsIgnoreCase(searchClicked)) {
			PendingResultsRequest pendingResultsRequest = new PendingResultsRequest();
			pendingResultsRequest.setRequest(request);
			pendingResultsRequest.setSession(session);
			pendingResultsRequest.setNormalcyIndicator(normalcy);
			pendingResultsRequest.setLocale(IPADConstants.LOCALE);

			PendingResults beanInst = new PendingResults();
			pendingResultsResponse = beanInst
					.getPendingResults(pendingResultsRequest);
			pendingResultMap = pendingResultsResponse
					.getPendingResultsMap();
			totalRecords = pendingResultsResponse.getTotalRecords();

			if (pendingResultMap == null || pendingResultMap.isEmpty()) {
	
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block35Bytes, _wl_block35);

					} else {
							Set<Entry<PatientDetail, PendingResultForPatient>> entrySet = pendingResultMap
									.entrySet();
							Iterator<Entry<PatientDetail, PendingResultForPatient>> iterator = entrySet
									.iterator();
							Entry<PatientDetail, PendingResultForPatient> entry = null;
							PatientDetail patientDetail = null;
							String patientDetailString = null;
							// this var is used as the parameter
							// passed to the expand or hide js function parameter
							// basically this var will contain the patient name
							// without single quote
							String patDtlStrForDisplay = null;
							int pendingResultCount = 0;

							
							
							PendingResultForPatient pendingResultForPatient = null;
							Map<ResultCategory, List<ResultDetail>> pendingResultMapForPatient = null;
							ResultCategory resultCategory = null;
							Entry<ResultCategory, List<ResultDetail>> resultCatEntry = null;
							while (iterator.hasNext()) {
								
								// increment the patient counter
								patientCounter++;
								
								entry = iterator.next();
								patientDetail = entry.getKey();
								patientDetailString = patientDetail.getPatientName();
								
								// code added to fix the bug where if the patient name
								// itself contains a single quote then the 
								// javascript function called to expand or hide does not
								// work - in fact the js function itself is not being called
								patDtlStrForDisplay = "";
								int charIndex = 0;
								int oldIndex = 0;
								while(true){
									charIndex = patientDetailString.indexOf("'",charIndex);
									if(charIndex < 0){
										break;
									}
									if(oldIndex < charIndex){
										oldIndex++;
									}
									patDtlStrForDisplay += patientDetailString.substring(oldIndex, charIndex);
									oldIndex = charIndex;
									charIndex++;
								}
								if(oldIndex > 0){
									patDtlStrForDisplay += patientDetailString.substring(oldIndex+1);	
								}else{
									patDtlStrForDisplay += patientDetailString;
								}
								
								
								patientDetailString += " ";
								patientDetailString += patientDetail.getAge();
								patientDetailString += ",";
								patientDetailString += patientDetail.getSex();
								patientDetailString += "    ";
								//patientDetailString += patientDetail.getPatientId();

								pendingResultForPatient = entry.getValue();
								pendingResultCount = pendingResultForPatient
										.getPendingRecordCountForPatient();
				
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patDtlStrForDisplay));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patientDetailString));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(patientDetail.getPatientId()));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pendingResultCount));
            _bw.write(_wl_block41Bytes, _wl_block41);

					pendingResultMapForPatient = pendingResultForPatient
										.getPendingResultMapForPatient();
								Set<Entry<ResultCategory, List<ResultDetail>>> resultCatSet = pendingResultMapForPatient
										.entrySet();
								Iterator<Entry<ResultCategory, List<ResultDetail>>> resultCatItr = resultCatSet
										.iterator();
								List<ResultDetail> resultDetailList = null;
								while (resultCatItr.hasNext()) {
									resultCatEntry = resultCatItr.next();
									resultCategory = resultCatEntry.getKey();
									//pendingResultCount = pendingResultForPatient.getPatientRecordCountForCategory(resultCategory);

									resultDetailList = resultCatEntry.getValue();
									if (resultDetailList != null
											&& !resultDetailList.isEmpty()) {
				
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(patDtlStrForDisplay));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(patientCounter));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(resultDetailList.size()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(resultCategory.getCategory()));
            _bw.write(_wl_block47Bytes, _wl_block47);

								
									String eventName = null;
									final String REPORTEDBY = "Reported by";
									final String AT = "at";
									String practitioner = null;
									String reportedTime = null;
									StringBuffer resultBuff = new StringBuffer();
									String resultNum = "";
									String resultNumUom = "";
									String completeResult = "";
									String notesType = null;
									String normalLow = "";
									String normalHigh = "";
									String resultStr = "";
									int recordIndex = 0;

									String patient_Id = null;
									String eventClass = null;
									String eventGroup = null;
									String eventCode = null;
									String histRecType = null;
									String normalcyInd = null;
									// extra parameters needed for processing
									String sysId = null;
									String accessionNum = null;
									String createDateTime = null;
									String reviewType = null;
									String controlSysEventCode = null;
									String encounterId = null;

									// iterate through the records and show the results
									for (ResultDetail resultDetail : resultDetailList) {

										patient_Id = resultDetail.getPatientId();
										patient_Id = CommonBean.checkForNull(patient_Id);
										eventClass = resultDetail.getEventClass();
										eventClass = CommonBean.checkForNull(eventClass);
										eventGroup = resultDetail.getEventGroup();
										eventGroup = CommonBean.checkForNull(eventGroup);
										eventCode = resultDetail.getEventCode();
										eventCode = CommonBean.checkForNull(eventCode);
										histRecType = resultDetail
												.getHistoryRecType();
										normalcyInd = resultDetail.getNormalcyInd();
										normalcyInd = CommonBean
												.checkForNull(normalcyInd);

										sysId = resultDetail.getSysId();
										sysId = CommonBean.checkForNull(sysId);

										accessionNum = resultDetail
												.getAccessionNum();
										accessionNum = CommonBean
												.checkForNull(accessionNum);

										createDateTime = resultDetail
												.getCreateDateTime();
										createDateTime = CommonBean
												.checkForNull(createDateTime);
										createDateTime = DateUtils
												.convertDate(createDateTime,
														"DMYHM", "en", "en");

										reviewType = resultDetail.getReviewType();
										reviewType = CommonBean
												.checkForNull(reviewType);

										controlSysEventCode = resultDetail
												.getContrSysEventCode();
										controlSysEventCode = CommonBean
												.checkForNull(controlSysEventCode);
										
										encounterId = resultDetail.getEncounterId();
										encounterId = CommonBean.checkForNull(encounterId);

										// this code will form the result string 
										// which needs to be shown in the GUI
										resultBuff.delete(0, resultBuff.length());
										eventName = resultDetail.getEventName();
										practitioner = resultDetail.getReportedBy();
										reportedTime = resultDetail.getReportedAt();
										resultBuff.append(eventName).append("- ");
										resultBuff.append(REPORTEDBY).append(" ");
										resultBuff.append(practitioner).append(" ");
										resultBuff.append(AT).append(" ");
										resultBuff.append(reportedTime);

										notesType = resultDetail.getNotesType();
										resultStr = resultDetail.getResultStr();
										resultNum = resultDetail.getResultNum();
										resultNumUom = resultDetail
												.getResultNumUom();
										normalLow = resultDetail.getNormalLow();
										normalHigh = resultDetail.getNormalHigh();
										if ("NUM".equalsIgnoreCase(notesType)) {
											completeResult = resultNum
													+ "&nbsp;&nbsp;" + resultNumUom
													+ "&nbsp;&nbsp;" + "("
													+ normalLow + "-" + normalHigh
													+ ")";
										} else if ("STR"
												.equalsIgnoreCase(notesType)) {

										}
							
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(patient_Id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(eventClass));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(eventCode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(eventGroup));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(histRecType));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(normalcyInd));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(sysId));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(accessionNum));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(reviewType));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(createDateTime));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(controlSysEventCode));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(resultCategory.getCategory()));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(resultCategory.getCategory()));
            _bw.write(_wl_block77Bytes, _wl_block77);
if ((recordIndex % 2) == 0) {
            _bw.write(_wl_block78Bytes, _wl_block78);
} else {
            _bw.write(_wl_block79Bytes, _wl_block79);
}
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(resultBuff.toString()));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(completeResult));
            _bw.write(_wl_block84Bytes, _wl_block84);

                      						// TODO
       												// need to get the count of previous results
       												PreviousResultsRequest previousResultsRequest = new PreviousResultsRequest();
       												previousResultsRequest.setRequest(request);
       												previousResultsRequest.setSession(session);
       												previousResultsRequest
       														.setPatientId(patient_Id);
       												previousResultsRequest
       														.setLocale(IPADConstants.LOCALE);
       												previousResultsRequest
       														.setEventClass(eventClass);
       												previousResultsRequest
       														.setEventCode(eventCode);
       												previousResultsRequest
       														.setEventGroup(eventGroup);
       												previousResultsRequest
       														.setHistRectType(histRecType);
       												previousResultsRequest.setMaskDates(true);

       												PrevResultCountResponse prevResultCountResponse = beanInst
       														.getPreviousResultsCount(previousResultsRequest);
       												List<PrevResultDateContainer> previousResultsCountList = prevResultCountResponse
       														.getPrevResultDateContainerList();
       												if (previousResultsCountList != null
       														&& !previousResultsCountList
       																.isEmpty()) {
                      					
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(recordCounter));
            _bw.write(_wl_block86Bytes, _wl_block86);

                      						}
                      					
            _bw.write(_wl_block87Bytes, _wl_block87);

           								recordIndex++;
           														// this is a global counter
           								recordCounter++;
           						}
           				
            _bw.write(_wl_block88Bytes, _wl_block88);

							}
						}
					}

				}
			}
				
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(patientCounter ));
            _bw.write(_wl_block90Bytes, _wl_block90);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
