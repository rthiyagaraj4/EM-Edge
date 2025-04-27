package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __startconsultationdialog extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/StartConsultationDialog.jsp", 1709116370949L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<script>\nfunction confirmationYes()\n{\n\treturnValue = \"PCWE\"+\"#\"+\"Yes\"\n\twindow.close();\n\treturn returnValue;\n}\t\n\nfunction confirmationNo()\n{\n\tvar returnVal;\n\t//alert(document.getElementById(\"patChartCalledFrm\").value+\"=>\"+document.getElementById(\"MNG_PAT_QUEUE_CHART_TYPE\").value);\n\tif(document.getElementById(\"patChartCalledFrm\").value==\'OP\' && document.getElementById(\"MNG_PAT_QUEUE_CHART_TYPE\").value==\'RUNTIME\')\n\t{\n\t\t//alert(\'1\');\n\t\tdocument.getElementById(\"chartTypeDtlRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"chartTypeHdrRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"okCancelRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"startConsBtnRow\").style.display=\'none\'\n\t\tdocument.getElementById(\"startConsRow\").style.display=\'none\'\n\t}\n\t//IN065070 starts\n\telse if(document.getElementById(\"patChartCalledFrm\").value==\'AE\' && document.getElementById(\"AE_CURR_EMR_PATIENT_CHART_TYPE\").value==\'RUNTIME\')\n\t{\n\t\t//alert(\'1\');\n\t\tdocument.getElementById(\"chartTypeDtlRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"chartTypeHdrRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"okCancelRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"startConsBtnRow\").style.display=\'none\'\n\t\tdocument.getElementById(\"startConsRow\").style.display=\'none\'\n\t}\n\t//else if(document.getElementById(\"patChartCalledFrm\").value==\'\' && document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value==\'RUNTIME\')\n\telse if(document.getElementById(\"patChartCalledFrm\").value==\'\' && document.getElementById(\"patient_class\").value==\'OP\' && document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value==\'RUNTIME\')\n\t{\n\t\t//alert(\'2\');\n\t\tdocument.getElementById(\"chartTypeDtlRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"chartTypeHdrRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"okCancelRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"startConsBtnRow\").style.display=\'none\'\n\t\tdocument.getElementById(\"startConsRow\").style.display=\'none\'\t\n\t}\n\telse if(document.getElementById(\"patChartCalledFrm\").value==\'\' &&  document.getElementById(\"patient_class\").value==\'AE\' && document.getElementById(\"AE_PATLIST_BY_LOCN_CHART_TYPE\").value==\'RUNTIME\')\n\t{\n//IN065070 Ends\n\t\t//alert(\'2\');\n\t\tdocument.getElementById(\"chartTypeDtlRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"chartTypeHdrRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"okCancelRow\").style.display=\'inline\'\n\t\tdocument.getElementById(\"startConsBtnRow\").style.display=\'none\'\n\t\tdocument.getElementById(\"startConsRow\").style.display=\'none\'\t\n\t}\n\telse\n\t{\n\t\tif(document.getElementById(\"patChartCalledFrm\").value==\'\')\n\t\t{\n\t\t\t//alert(\'1\');\n\t//IN065070 starts\n\t\t\tif(document.getElementById(\"patient_class\").value==\'OP\')\n\t\t\t{\n\t\t\t\tif(document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value==\'PCWE\')\n\t\t\t\t{\n\t\t\t\t\treturnValue = \"PCWE\"+\"#\"+\"No\"\n\t\t\t\t}\n\t\t\t\telse if(document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value==\'PCWOE\')\n\t\t\t\t{\n\t\t\t\t\treturnValue = \"PCWOE\"+\"#\"+\"No\"\n\t\t\t\t}\t\n\t\t\t}else (document.getElementById(\"patient_class\").value==\'AE\')\n\t\t\t{\n\t\t\t\tif(document.getElementById(\"AE_PATLIST_BY_LOCN_CHART_TYPE\").value==\'PCWE\')\n\t\t\t\t{\n\t\t\t\t\treturnValue = \"PCWE\"+\"#\"+\"No\"\n\t\t\t\t}\n\t\t\t\telse if(document.getElementById(\"AE_PATLIST_BY_LOCN_CHART_TYPE\").value==\'PCWOE\')\n\t\t\t\t{\n\t\t\t\t\treturnValue = \"PCWOE\"+\"#\"+\"No\"\n\t\t\t\t}\n\t\t\t}\n\t//IN065070 Ends\n\t\t}\n\t\telse if(document.getElementById(\"patChartCalledFrm\").value==\'OP\')\n\t\t{\n\t\t\tif(document.getElementById(\"MNG_PAT_QUEUE_CHART_TYPE\").value==\'PCWE\')\n\t\t\t{\n\t\t\t\treturnValue = \"PCWE\"+\"#\"+\"No\"\n\t\t\t}\n\t\t\telse if(document.getElementById(\"MNG_PAT_QUEUE_CHART_TYPE\").value==\'PCWOE\')\n\t\t\t{\n\t\t\t\treturnValue = \"PCWOE\"+\"#\"+\"No\"\n\t\t\t}\n\t\t}\n\t\t//IN065070 starts\n\t\telse if(document.getElementById(\"patChartCalledFrm\").value==\'AE\')\n\t\t{\n\t\t\tif(document.getElementById(\"AE_CURR_EMR_PATIENT_CHART_TYPE\").value==\'PCWE\')\n\t\t\t{\n\t\t\t\treturnValue = \"PCWE\"+\"#\"+\"No\"\n\t\t\t}\n\t\t\telse if(document.getElementById(\"AE_CURR_EMR_PATIENT_CHART_TYPE\").value==\'PCWOE\')\n\t\t\t{\n\t\t\t\treturnValue = \"PCWOE\"+\"#\"+\"No\"\n\t\t\t}\n\t\t}\n\t\t//IN065070 Ends\n\t\twindow.close();\n\t\treturn(returnValue);\n\t\t//confirmationOk();\n\t}\t\n}\n\nfunction selectChartType(obj)\n{\n\tdocument.getElementById(\"userChartType\").value=obj.value;\n}\n\nfunction confirmationOk()\n{\n\tif(document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value==\'RUNTIME\' && (document.getElementById(\"userChartType\").value==\"\"||document.getElementById(\"userChartType\").value==\'undefined\'))\n\t{\n\t\talert(\"APP-CA0372 Please select the Chart Type.\");\n\t\treturn;\n\t}else if(document.getElementById(\"MNG_PAT_QUEUE_CHART_TYPE\").value==\'RUNTIME\' && (document.getElementById(\"userChartType\").value==\"\"||document.getElementById(\"userChartType\").value==\'undefined\'))\n\t{\n\t\talert(\"APP-CA0372 Please select the Chart Type.\");\n\t\treturn;\n\t} //Condition added --[IN032842]\n//IN065070 starts\n\tif(document.getElementById(\"AE_CURR_EMR_PATIENT_CHART_TYPE\").value==\'RUNTIME\' && (document.getElementById(\"userChartType\").value==\"\"||document.getElementById(\"userChartType\").value==\'undefined\'))\n\t{\n\t\talert(\"APP-CA0372 Please select the Chart Type.\");\n\t\treturn;\n\t}else if(document.getElementById(\"AE_PATLIST_BY_LOCN_CHART_TYPE\").value==\'RUNTIME\' && (document.getElementById(\"userChartType\").value==\"\"||document.getElementById(\"userChartType\").value==\'undefined\'))\n\t{\n\t\talert(\"APP-CA0372 Please select the Chart Type.\");\n\t\treturn;\n\t} \n//IN065070 ends\n\tif(document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value!=\'RUNTIME\' && document.getElementById(\"CA_PATLIST_BY_LOCN_CHART_TYPE\").value!= \'null\')\n\t{\n\t\t//returnValue = document.getElementById(\'CA_PATLIST_BY_LOCN_CHART_TYPE\').value+\"#\"+\"No\";//IN032803\n\t\treturnValue = document.getElementById(\'userChartType\').value+\"#\"+\"No\";//IN032803\n\t\twindow.close();\n\t\treturn returnValue;\n\t} else if(document.getElementById(\"MNG_PAT_QUEUE_CHART_TYPE\").value!=\'RUNTIME\' && document.getElementById(\"MNG_PAT_QUEUE_CHART_TYPE\").value!= \'null\')\n\t{\n\t\t//returnValue = document.getElementById(\'MNG_PAT_QUEUE_CHART_TYPE\').value+\"#\"+\"No\";//IN032803\n\t\treturnValue = document.getElementById(\'userChartType\').value+\"#\"+\"No\";//IN032803\n\t\twindow.close();\n\t\treturn returnValue;\n\t} //Condition added --[IN033734]\n\telse\n\t{\n\t\treturnValue = document.getElementById(\"userChartType\").value+\"#\"+\"No\";\n\t\twindow.close();\n\t\treturn returnValue;\n\t}\n}\nfunction confirmationCancel()\n{\n\twindow.close();\n}\n</script>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n<title>\nConfirmation\n</title>\n</head>\n<body>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'confirmForm\' id=\'confirmForm\'>\n<table width=\'100%\'>\n\t<tr id=\'startConsRow\'>\n\t\t<td colspan=\'3\' align=\'center\'>\n\t\tDo you want to start the Consultation?\n\t\t</td>\n\t</tr>\n\t<tr>\n\t<td colspan=\'3\'></td>\n\t</tr>\n\t<tr>\n\t<td colspan=\'3\'></td>\n\t</tr>\n\t<tr id=\'startConsBtnRow\'>\n\t\t<td colspan =\'3\' align=\'center\'>\n\t\t<input class=\'button\' align=\'right\' type=\'button\' name = \'confirmYes\' value=\'Yes\' onclick=\'confirmationYes()\'/>&nbsp;&nbsp;\n\t\t<input class=\'button\' align=\'right\' type=\'button\' name = \'confirmNo\' value=\'No\' onclick=\'confirmationNo()\'/>\n\t\t</td>\n\t\t<td>&nbsp;</td>\n\t</tr>\n\t<tr style=\'display:none\' id=\'chartTypeHdrRow\'>\n\t<td>\n\tSelect the Chart Type <img src=\'../../eCommon/images/mandatory.gif\'>\n\t<td>\n\t</tr>\n\t<tr style=\'display:none\' id=\'chartTypeDtlRow\'>\n\t<td class=\'fields\'>\n\t\t<input type=\'radio\' id = \'chartType\' name=\'chartType\' id=\'chartType\' value = \'PCWE\' onclick=\'selectChartType(this)\'/>Patient Chart with Encounter</br>\n\t\t<input type=\'radio\' id = \'chartType\' name=\'chartType\' id=\'chartType\' value = \'PCWOE\' onclick=\'selectChartType(this)\'/>Patient Chart without Encounter\n\t</td>\n\t</tr>\n\t<tr style=\'display:none\' id=\'okCancelRow\'>\n\t\t<td>\n\t\t</td>\n\t\t<td>\n\t\t<input class=\'button\' align=\'right\' type=\'button\' name = \'confirmYes\' value=\'Ok\' onclick=\'confirmationOk()\'/>&nbsp;&nbsp;\n\t\t<input class=\'button\' align=\'right\' type=\'button\' name = \'confirmNo\' value=\'Cancel\' onclick=\'confirmationCancel()\'/>\n\t\t</td>\n\t\t<td>&nbsp;</td>\n\t</tr>\n</table>\n<input name=\'CA_PATLIST_BY_LOCN\' id=\'CA_PATLIST_BY_LOCN\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'/>\n<input name=\'MNG_PAT_QUEUE\' id=\'MNG_PAT_QUEUE\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'/>\n<input name=\'CA_PATLIST_BY_LOCN_CHART_TYPE\' id=\'CA_PATLIST_BY_LOCN_CHART_TYPE\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'/>\n<input name=\'MNG_PAT_QUEUE_CHART_TYPE\' id=\'MNG_PAT_QUEUE_CHART_TYPE\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'/>\n<!--IN065070 changes starts -->\n<input name=\'AE_CURR_EMR_PATIENT\' id=\'AE_CURR_EMR_PATIENT\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'/>\n<input name=\'AE_CURR_EMR_PATIENT_CHART_TYPE\' id=\'AE_CURR_EMR_PATIENT_CHART_TYPE\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'/>\n<input name=\'AE_CA_PATLIST_BY_LOCN\' id=\'AE_CA_PATLIST_BY_LOCN\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'/>\n<input name=\'AE_PATLIST_BY_LOCN_CHART_TYPE\' id=\'AE_PATLIST_BY_LOCN_CHART_TYPE\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'/>\n<input name=\'patient_class\' id=\'patient_class\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'/>\n<!--IN065070 changes ends -->\n<input name=\'patChartCalledFrm\' id=\'patChartCalledFrm\' type=\'hidden\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'/>\n<input name=\'userChartType\' id=\'userChartType\' type=\'hidden\' value=\'\'/>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100           ?           created
10/07/2012	  IN032842		Chowminya G	    On Consultation Parameter setup  OP Consultation, Patient chart function.	
10/07/2012	  IN033734		Chowminya G	    On Consultation Parameter setup  OP Consultation, Patient chart
											function.related		
13/07/2012	  IN032803		Menaka V		When open Patient Chart without encounter on Manage Patient queue, the system
											still allow to order. Actually, this functionality should allow viewing Patient Chart only.												
---------------------------------------------------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
26/10/2017		IN065070	Raja S		27/10/2017		Ramesh G			ML-MMOH-CRF-0623.1
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Statement stmt=null; 
	ResultSet rst=null;
	Connection con = null;
	String CA_PATLIST_BY_LOCN = "";
	String MNG_PAT_QUEUE ="";
	String CA_PATLIST_BY_LOCN_CHART_TYPE="";
	String MNG_PAT_QUEUE_CHART_TYPE ="";
	//IN065070 starts
	String AE_CURR_EMR_PATIENT ="";
	String AE_CURR_EMR_PATIENT_CHART_TYPE ="";
	String AE_CA_PATLIST_BY_LOCN="";
	String AE_PATLIST_BY_LOCN_CHART_TYPE="";
	String pat_class = request.getParameter("pat_class")==null?"":request.getParameter("pat_class");
	//IN065070 Ends

	String patChartCalledFrm = request.getParameter("patChartCalledFrm")==null?"":request.getParameter("patChartCalledFrm");
	//System.out.println("112,patChartCalledFrm=>"+patChartCalledFrm);
	try
	{				
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		//rst=stmt.executeQuery("SELECT CA_PATLIST_BY_LOCN,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE FROM CA_CONS_PARAM"); //Commented for IN065070
		rst=stmt.executeQuery("SELECT CA_PATLIST_BY_LOCN,MNG_PAT_QUEUE,CA_PATLIST_BY_LOCN_CHART_TYPE,MNG_PAT_QUEUE_CHART_TYPE,AE_CURR_EMR_PATIENT,AE_CURR_EMR_PATIENT_CHART_TYPE,AE_CA_PATLIST_BY_LOCN,AE_PATLIST_BY_LOCN_CHART_TYPE FROM CA_CONS_PARAM");//Modified for IN065070

		while(rst.next())
		{ 
			CA_PATLIST_BY_LOCN= rst.getString("CA_PATLIST_BY_LOCN");
			MNG_PAT_QUEUE= rst.getString("MNG_PAT_QUEUE");
			CA_PATLIST_BY_LOCN_CHART_TYPE= rst.getString("CA_PATLIST_BY_LOCN_CHART_TYPE");
			MNG_PAT_QUEUE_CHART_TYPE= rst.getString("MNG_PAT_QUEUE_CHART_TYPE");
			//IN065070 changes starts
			AE_CURR_EMR_PATIENT= rst.getString("AE_CURR_EMR_PATIENT");
			AE_CURR_EMR_PATIENT_CHART_TYPE= rst.getString("AE_CURR_EMR_PATIENT_CHART_TYPE");
			AE_CA_PATLIST_BY_LOCN=rst.getString("AE_CA_PATLIST_BY_LOCN");
			AE_PATLIST_BY_LOCN_CHART_TYPE=rst.getString("AE_PATLIST_BY_LOCN_CHART_TYPE");
			//IN065070 changes ends
		}
		//System.out.println(CA_PATLIST_BY_LOCN+" "+MNG_PAT_QUEUE+" "+CA_PATLIST_BY_LOCN_CHART_TYPE+" "+MNG_PAT_QUEUE_CHART_TYPE);

		if(rst != null) rst.close();
		if(stmt != null) stmt.close();
	}
	catch(Exception ex)
	{	
		ex.printStackTrace();
	}			
	finally 
	{
		if(rst != null) rst.close();
		if(stmt != null) stmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(CA_PATLIST_BY_LOCN));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(MNG_PAT_QUEUE));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(CA_PATLIST_BY_LOCN_CHART_TYPE));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(MNG_PAT_QUEUE_CHART_TYPE));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(AE_CURR_EMR_PATIENT));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(AE_CURR_EMR_PATIENT_CHART_TYPE));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(AE_CA_PATLIST_BY_LOCN));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(AE_PATLIST_BY_LOCN_CHART_TYPE));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(pat_class));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patChartCalledFrm));
            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
