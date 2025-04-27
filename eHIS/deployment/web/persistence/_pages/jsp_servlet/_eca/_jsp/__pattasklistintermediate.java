package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eCA.PatTaskListRepository;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __pattasklistintermediate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/PatTaskListIntermediate.jsp", 1709116031950L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t<script language=\"javascript\" src=\"../../eCA/js/PatTaskList.js\"></script>\n\t<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\'patTaskIntermediateForm\' id=\'patTaskIntermediateForm\'>\n\n<input type =\'hidden\' name =\'locale\' value =\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar locale = document.forms[0].locale.value;\n\t\t\t\t\t\tvar task =\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\n\t\t\t\t\t\tif(task==\"\")\n\t\t\t\t\t\t\ttask = \"%\"\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\ttask+=\"%\";\n\n\t\t\t\t\t\tvar sql = \"SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION_LANG_VW WHERE INTERVENTION_CODE like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS=\'E\' and upper(INTERVENTION_TYPE) like upper(\'\"+task+\"\') and language_id =\'\" +locale+\"\'  ORDER BY SHORT_DESC\";\n\n\t\t\t\t\t\tvar target = \"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\n\t\t\t\t\t\tvar argArray = new Array();\n\t\t\t\t\t\tvar namesArray = new Array();\n\t\t\t\t\t\tvar valuesArray = new Array();\n\t\t\t\t\t\tvar datatypesArray = new Array();\n\n\t\t\t\t\t\targArray[0] = sql;\n\t\t\t\t\t\targArray[1] = namesArray;\n\t\t\t\t\t\targArray[2] = valuesArray;\n\t\t\t\t\t\targArray[3] = datatypesArray;\n\t\t\t\t\t\targArray[4] = \"1,2\";\n\t\t\t\t\t\targArray[5] = target;\n\t\t\t\t\t\targArray[6] = DESC_LINK;\n\t\t\t\t\t\targArray[7] = CODE_DESC;\n\t\t\t\t\t\tretArray = CommonLookup(getLabel(\"Common.Task.label\",\"COMMON\"), argArray);\n\n\t\t\t\t\t\tif(retArray.length != 0)\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tparent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskDesc.value=retArray[1];\n\t\t\t\t\t\t\tparent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.taskCode.value=retArray[0];\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar locale = document.forms[0].locale.value;\n\t\t\t\t\tvar task =\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\n\t\t\t\t\tif(task==\"\")\n\t\t\t\t\t\ttask = \"%\"\n\t\t\t\t\telse\n\t\t\t\t\t\ttask+=\"%\";\n\t\t\t\t\t\n\t\t\t\t\tvar sql = \"SELECT INTERVENTION_CODE code,SHORT_DESC description FROM CA_INTERVENTION_LANG_VW WHERE  INTERVENTION_CODE like upper(?)  and upper(SHORT_DESC) like upper(?) AND EFF_STATUS=\'E\' and upper(INTERVENTION_TYPE) like upper(\'\"+task+\"\') and language_id =\'\"+locale+\"\'  ORDER BY SHORT_DESC\";\n\n\t\t\t\t\tvar target = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\n\t\t\t\t\tvar argArray = new Array();\n\t\t\t\t\tvar namesArray = new Array();\n\t\t\t\t\tvar valuesArray = new Array();\n\t\t\t\t\tvar datatypesArray = new Array();\n\n\t\t\t\t\targArray[0] = sql;\n\t\t\t\t\targArray[1] = namesArray;\n\t\t\t\t\targArray[2] = valuesArray;\n\t\t\t\t\targArray[3] = datatypesArray;\n\t\t\t\t\targArray[4] = \"1,2\";\n\t\t\t\t\targArray[5] = target;\n\t\t\t\t\targArray[6] = DESC_LINK;\n\t\t\t\t\targArray[7] = CODE_DESC;\n\t\t\t\t\tretArray = CommonLookup(getLabel(\"Common.Task.label\",\"COMMON\"), argArray);\n\n\t\t\t\t\tif(retArray.length != 0)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.patTaskListAdhocFrame.document.forms[0].taskDesc.value=retArray[1];\n\t\t\t\t\t\tparent.patTaskListAdhocFrame.document.forms[0].taskCode.value=retArray[0];\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar locale = document.forms[0].locale.value;\n\t\t\t\t\tvar sql = \"\";\n\t\t\t\t\tvar facility_id = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"\n\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"==\'C\')\n\t\t\t\t\t\tsql = \"SELECT CLINIC_CODE code,LONG_DESC description FROM OP_CLINIC_LANG_VW WHERE CLINIC_CODE  like upper(?) and upper(SHORT_DESC) like upper(?)\t AND FACILITY_ID=\'\"+facility_id+\"\' and EFF_STATUS=\'E\'  AND LANGUAGE_ID = \'\" +locale+ \"\' ORDER BY SHORT_DESC\";\n\t\t\t\t\telse\n\t\t\t\t\t\tsql = \"SELECT NURSING_UNIT_CODE code,LONG_DESC description FROM IP_NURSING_UNIT_LANG_VW WHERE NURSING_UNIT_CODE  like upper(?) and upper(SHORT_DESC) like upper(?)\tAND FACILITY_ID=\'\"+facility_id+\"\' and EFF_STATUS=\'E\'  AND LANGUAGE_ID =\'\"+ locale + \"\' ORDER BY SHORT_DESC\"; \n\n\t\t\t\t\tvar target = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n\t\t\t\t\tvar argArray = new Array();\n\t\t\t\t\tvar namesArray = new Array();\n\t\t\t\t\tvar valuesArray = new Array();\n\t\t\t\t\tvar datatypesArray = new Array();\n\n\t\t\t\t\targArray[0] = sql;\n\t\t\t\t\targArray[1] = namesArray;\n\t\t\t\t\targArray[2] = valuesArray;\n\t\t\t\t\targArray[3] = datatypesArray;\n\t\t\t\t\targArray[4] = \"1,2\";\n\t\t\t\t\targArray[5] = target;\n\t\t\t\t\targArray[6] = DESC_LINK;\n\t\t\t\t\targArray[7] = CODE_DESC;\n\t\t\t\t\tretArray = CommonLookup(getLabel(\"Common.Task.label\",\"COMMON\"), argArray );\n\n\t\t\t\t\tif(retArray.length != 0)\n\t\t\t\t\t{\n\t\t\t\t\t\tparent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.locationDesc.value=retArray[1];\n\t\t\t\t\t\tparent.patTaskListCriteriaFrame.document.patTaskCriteriaForm.locationCode.value=retArray[0];\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block8Bytes, _wl_block8);


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
					
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(task));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(taskDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
         
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
					
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(task));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(taskDesc));
            _bw.write(_wl_block14Bytes, _wl_block14);
         
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
					
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(locationType));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(locationDesc));
            _bw.write(_wl_block18Bytes, _wl_block18);

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

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
