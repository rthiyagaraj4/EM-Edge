package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import eXH.EClaimsERATransaction;
import eXH.XHUtil;

public final class __medieratransactionresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MediERATransactionResult.jsp", 1743586936028L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<HEAD>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t   \n<style>\n.left_child{\t\n\toverflow-y:auto;\n }\n\n #header-fixed {\n    position: fixed;\n    top: 0px; display:none;\n    background-color:white;\n}\n</style>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n\n<script language=\"javascript\">\n\nfunction funSubmit()\n{\n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.action = \'../../eXH/jsp/MediERATransactionResult.jsp\';\n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.target=\"resultFrame\";\n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.submit();\n}\n\nfunction funAction(typ)\n{  \n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.action_type.value = typ;\n\tfunSubmit();\n}\n\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\t\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXH/jsp/MediERATransactionResult.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\n\nasync function checkEligibility(obj)\n{\t\n\tvar checkType = \"\";\n\t\n\tvar checkTypeButtons = document.getElementsByName(\'CheckType\');\n\n\n\t//var request_status = obj.getAttribute(\'request_status\');\n    var trans_num = obj.getAttribute(\'trans_num\');\n\t//var event_type = document.forms[0].event_type.value;\n\t//var check_type = obj.getAttribute(\'check_type\');\n\t//var eligibility_status_type = obj.getAttribute(\'request_status\');\n    \n\tvar dialogHeight = \"30vh\";    // have to remove \n\tvar dialogWidth  = \"60vw\";\n\tvar dialogTop    = \"130\";\n\tvar title=\"Patient Eligibility Check \";\n\ttitle=encodeURIComponent(title);\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\tvar params= \"trans_num=\"+trans_num;\n\tvar arguments = new Array();\n\tvar url = \"../../eXH/jsp/MediQueryResponsePopUp.jsp?\" +params;\n\t\n\tvar retVal =await window.showModalDialog(url,arguments,features);\n      \n}\nfunction Process(){\n  var checkType = \"\";\n\tvar patientData=\"\";\n\tvar checkedValue = null; \n\tvar checkBoxes = document.getElementsByName(\'checkbox\');\n\tvar selectedIndex = 0;\n\tvar count = 0;\n\tvar trans_Id = \"\";\n\tvar responseMessage = \"\";\n\tvar authnum = \"\";\n\tvar destcode = \"\";\n\n\tvar responseMessage = \"\", validate = \"\";\n    \n\tfor(var i = 0; i < checkBoxes.length; i++){\n\t\tif(checkBoxes[i].checked){\n\t\t\tcheckedValue = checkBoxes[i].value;\n\t\t\tselectedIndex = i;\n\t\t\tcount++;\n\t\t\n\t\t}\n\t}\n\tif(count == 0 || checkedValue == null)\n\t{\n         alert(\"APP-XH0070 Please select at least one File.\");\n\t\t return;\n\t}\n    for(var i = 0; i < checkBoxes.length; i++){\n\t\tif(checkBoxes[i].checked){\n\t\t\tcheckedValue = checkBoxes[i].value;\n\t\t\t    responseMessage = ERATransaction(checkedValue);\n\t\t}\n\t}\n\n\tvar responseData = \"\";\n\tresponseData = responseMessage.split(\"$!^\");\n\n\tif (responseData.length > 0)\n\t{\n\t\tif (responseData[0] == \"E\")\n\t\t{\n\t\t\talert(responseData[3]);\n\t\t\treturn;\n\t\t}\n\t}\n\talert(\"APP-XH0070 Selected ERA Files has been processed. Please check the status.\");\n\n}\nfunction ERATransaction(dataElements)\n{\n    var responseMsg=\"\";\n\tvar data1=true;\n\t$.ajax({\n\t\turl: \'../../servlet/eXH.InvokeMedikreditApplication\',\n\t\ttype: \'POST\',\n\t\tcache: false,\n\t\t\n\t\tdata: {\n\t\t\t\tcallType: \'ECLAIMSERA\',\n\t\t\t\tparamString: dataElements\n\t\t},\n\t\tsuccess: function (data1) {\n\t\t\tresponseMsg = data1;\n\t\t},\t\t\n\t\tdataType: \'text\',\n\t\tasync: false\n\t});\n\treturn responseMsg;\n\n} \n\nfunction includeBoxChecked() {\n\n\tif (document.forms[0].includeMastercheckbox.checked == true) {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = true;\n\t\t\t}\n\t\t} else if (document.forms[0].gatewayservers.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = true;\n\t\t}\n\t}\n\telse {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = false;\n\t\t\t}\n\t\t} else if (document.forms[0].includeCheckbox.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = false;\n\t\t}\n\t}\n\treturn true;\n}\nfunction CheckAll()\n{\n\tvar checkBoxes = document.getElementsByName(\'checkbox\');\n\tif(document.getElementById(\"allCheck\").checked==true)\n\t{\n\t\tfor(var i = 0; i < checkBoxes.length; i++)\n\t\t{\n\t\t\tcheckBoxes[i].checked=true;\n\t    } \n\t}\n\telse\n\t{\n\t\tfor(var i = 0; i < checkBoxes.length; i++)\n\t\t{\n\t\t\tcheckBoxes[i].checked=false;\n\t    } \n\t}\n\t\n\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" >\n\t<form name=\"PAYER_CHECK_QUERY_FORM\" id=\"PAYER_CHECK_QUERY_FORM\" method=\"POST\" action=\'\'  >\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t\t\t<script>\n\t\t\t\talert(\'APP-002415 Query caused no records to be retrieved\');\n\t\t\t\thistory.go(-1);\n\t\t\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1 >\n\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"27\" class=\"COLUMNHEADER\" align=\'center\'>List of ERA Files</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t\n\t\t               <td align=\"right\" class=\"CAGROUP\" > \n\t\t                   <input class=\'BUTTON\' type=\"button\"  ID=\"search\" name=search value=\'Process Files\' onClick=\"Process()\">\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t   <td align=\"right\" class=\"CAGROUP\"></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\n\t\t\t\t<div id=\"left_child\" class=\"left_child\">\n\t\t\t\t\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' border=1 align=center>\t\n\t\t\t\t\t\t<tr style=\"position:fixed;\">\n\t\t\t\t\t        <td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</font><input type=\'checkbox\' id=\'allCheck\' name=\'allCheck\' id=\'allCheck\' value=\'allCheck\' onClick=\'CheckAll()\'>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'40%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'40%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t       \n\t\t\t\t\t\t</tr>\n\t\t\t\t\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String order = "";
		String orderBy = "";
		String action_type=null;
		Connection conn = null;
		Statement stmt=null;
		ResultSet rset=null ;
		String event_type = "";
		String dest_code = "";
        String checkboxvalue = "";
		String Checkboxname = "";

		String rs_filename="", rs_size = "";
        String rs_date = "",rs_path = "";
         
		HttpSession httpSession = request.getSession(false);
		String loginfacility = (String) session.getValue("facility_id");
		String user_id	= (String)session.getValue("login_user") ;
		Properties p=( java.util.Properties ) session.getValue( "jdbc" ) ;
		String AddedAtWsNo     =  p.getProperty("client_ip_address");

		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

		/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

		boolean  boolToggle = true;
		String strTDClass = "";
		String whereClause = "";
		int totalRecords=0;


		try
		{ 
            EClaimsERATransaction ecliams = new EClaimsERATransaction();
			ArrayList arrRow =(ArrayList)ecliams.FetchFiles("ECLAIMPROF1","ECLAIMS"); 

			ArrayList arrCol = null;
			//if(isDebugYN)System.out.println("boolPrevious...."+boolPrevious);
			//if(isDebugYN)System.out.println("boolNext...."+boolNext);

			if(arrRow.size()==0)
			{
				
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
			else
			{
				
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

						System.out.println("Before getting details....."+arrRow.size());
						Map cmp = new HashMap();

						totalRecords=0;

						//billDetailsRowCount = arrRow.size();
						int j = 0;

						for (j=0; j<arrRow.size();j++)
						{
							arrCol = (ArrayList)arrRow.get(j);
							rs_filename = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);
							rs_date = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
							rs_size = arrCol.get(2).equals("null")?"":(String)arrCol.get(2)+" Bytes";
							rs_path = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);

							checkboxvalue = "<REQUEST>ERA$!^<REQUEST_TYPE>ERARES$!^<USER>"+user_id+"$!^<WS_NO>"+AddedAtWsNo+"$!^<FACILITY_ID>"+loginfacility+"$!^<FILE_DIR>"+rs_path+"$!^<FILE_NAME>"+rs_filename+"$!^<TRANS_ID>XXX$!^";

				            Checkboxname = "Check-"+j;
							out.println("<tr width='100%' id = 'trGrpHeader"+j+"' >");	
							out.println("<td class='gridData' align='center'><input type='checkbox'  name='secChk"+j+"' id='secChk"+j+"' value='"+checkboxvalue+"' > </td>");	
							out.println("<td width='300' style='display:block' class='gridData' ><img src='../../eXH/images/file.png' style='width:20px; height: 20px;' alt='File' align='left'/>"+rs_filename+"</td>");
							out.println("<td width='300' style='display:block' class='gridData'>"+rs_date+"</td>");
							
							out.println("</tr>");
								
						

							//checkboxvalue =rs_patient_id+"$!^"+rs_sex+"$!^"+rs_family_name+"$!^"+rs_episode_id+"$!^"+rs_encounter_id+"$!^"+rs_patient_class+"$!^"+rs_visit_adm_date_time+"$!^"+rs_visit_adm_type+"$!^"+rs_service_code+"$!^"+rs_discharge_date_time+"$!^"+rs_operating_facility_id+"$!^"+rs_doc_type_code+"$!^"+rs_doc_num+"$!^"+rs_doc_date+"$!^"+rs_bill_from_date+"$!^"+rs_bill_to_date+"$!^"+rs_visit_id+"$!^"+rs_cust_code+"$!^"+rs_blng_grp_id+"$!^";

						}
							   
						
						
            _bw.write(_wl_block12Bytes, _wl_block12);

				}
				if(arrRow!=null) arrRow.clear();
				if(arrCol!=null) arrCol.clear();
				

			}catch(Exception e1)
				{
				 out.println("(MediERATransactionResult.jsp:Exception) "+e1);
				 e1.printStackTrace(System.err);
				}
				finally
				{
				ConnectionManager.returnConnection(conn);
				}
	
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FileName.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.modifieddatetime.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
