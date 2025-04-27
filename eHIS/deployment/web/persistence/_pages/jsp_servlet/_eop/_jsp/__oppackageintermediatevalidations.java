package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __oppackageintermediatevalidations extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/OPPackageIntermediateValidations.jsp", 1739349496135L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<Script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></Script>\n<script language=\'javascript\' src=\'../../eOP/js/ManageSPatQueue.js\'></script>\n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\tif(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'==\'Y\') {\n\t\t\t\talert(getMessage(\'PACKAGE_REVISE_VISIT\',\'OP\'));\n\t\t\t\tvar rowNum=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\';\n\t\t\t\trowNum=parseInt(rowNum);\n\t\t\t\trowNum=rowNum+1;\n\t\t\t\t/*for( k=0;k<6;k++)\n\t\t\t\t\tparent.f_query_add_mod.document.getElementById(\"tb1\").rows(rowNum).cells(k).style.backgroundColor=\"white\";*/\n\t\t\t} else {\n\t\t\t\t//parent.rv.rows=\'42,10%,*,30\';\t\t\t\t\n\t\t\t\tparent.frames[1].document.location.href=\'../../eCommon/jsp/pline.jsp?P_MODULE_ID=OP&P_FUNCTION_ID=REVISE_VISIT&EncounterId=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\';\t\t\t\tparent.frames[2].document.location.href=\"../../eOP/jsp/ReviseVisitMain.jsp?encounter_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&queue_date=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&Patient=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&QStatus=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&ArriveDTime=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&VitalDTime=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&queue_num=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&oper_id=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&bl_interfaced_yn=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&build_episode_rule=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&assign_queue_num_by=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&sys_date=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&status=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\tparent.frames[3].document.location.href=\"../../eCommon/jsp/error.jsp\"\n\t\t\t\tparent.frames[4].document.location.href=\'../../eBL/jsp/BLSessionValuesReset.jsp\'\n\t\t\t}\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t<script>\n\t\t\t\tasync function OPPackageIntermediate(){\n\t\t\t\tif(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'==\'OPCHECKOUTTOOLTIP\'){\n\t\t\t\t\tvar dialogHeight= \"75vh\" ;\n\t\t\t\t\tvar dialogWidth = \"70vw\" ;\n\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\tvar param=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\';\n\t\t\t\t\t//added @ UAT-4\t\t\t\n\t\t\t\t\tif(parent.frames[1].frames[1] && parent.frames[1].frames[2].document.ManagePatQue && parent.frames[1].frames[1] && parent.frames[1].frames[2].document.ManagePatQue.modalWindowOpen){\n\t\t\t\t\t\tparent.frame1.frame2.document.forms[0].modalWindowOpen.value=\"Y\";}\n\t\t\t\t\tvar retVal = await parent.frames[1].window.showModalDialog(\"../../eOP/jsp/PatCheckoutCall.jsp\"+param,arguments,features);\n\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\t\t\t\t\n\t\t\t\t\tif(retVal==undefined)\t{\t\n\t\t\t\t\t\t//added @ UAT-4\n\t\t\t\t\t\t\n\t\t\t\t\t\t/*Below line code was modified by venkatesh.S on 21/Feb/2013 against 38068*/\n\t\t\t\t\t\tif(parent.frames[1].frames[1] && parent.frames[1].frames[2].document.ManagePatQue && parent.frames[1].frames[1] && parent.frames[1].frames[2].document.ManagePatQue.modalWindowOpen) { \n\t\t\t\t\t\t\n\t\t\t\t\t\t\tif(parent.frame1.searchbutton.document.forms[0].refresh.value==getLabel(\"Common.search.label\",\"Common\")){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frame1.frame2.document.forms[0].modalWindowOpen.value=\"N\";\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.click();\n\t\t                        //parent.frame1.ManagePatQueueFrame.rows=\"29%,5%,80%,3%\";\n\t\t                        //parent.frame1.document.getElementById(\"frame1\").style.height=\"38vh\";\n\t\t\t\t\t\t\t\tvar ChkOut=parent.frame1.document.forms[0].ChkOut.value;\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame1\").style.height=\"38vh\";\n\t\t\t\t\t\t\t\tif (ChkOut == \"ChkOut\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame1\").style.height=\"34vh\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"searchbutton\").style.height=\"4vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame2\").style.height=\"50vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"checkbox\").style.height=\"5vh\";\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.value=getLabel(\"Common.search.label\",\"Common\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(parent.frame1.searchbutton.document.forms[0].refresh.value==getLabel(\"eMR.Expand.label\",\"eMR\")){ \n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t \tparent.frame1.searchbutton.document.forms[0].refresh.value=getLabel(\"Common.search.label\",\"Common\");\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.click();\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.value=getLabel(\"eMR.Expand.label\",\"eMR\");\n\t\t\t\t\t\t\t    parent.frame1.frame2.document.forms[0].modalWindowOpen.value=\"N\";\t\n\t\t\t\t\t\t\t    //parent.frame1.ManagePatQueueFrame.rows=\"5.1%,3%,40%,1.5%\"; \n\t\t\t\t\t\t\t    parent.frame1.document.getElementById(\"frame1\").style.height=\"18.5vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"searchbutton\").style.height=\"4vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame2\").style.height=\"65vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"checkbox\").style.height=\"5vh\";\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t}\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t/* end  38068 */\t\t\n\t\t\t\t\t}\n\t\t\t\t}else if(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'==\'OPCHECKOUT\'){\n\t\t\t\t\tvar dialogHeight= \"75vh\" ;\n\t\t\t\t\tvar dialogWidth = \"70vw\" ;\n\t\t\t\t\tvar status = \"no\";\n\t\t\t\t\tvar scroll = \"no\";\n\t\t\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:\"+ status + \"; scroll:\"+ scroll;\n\t\t\t\t\tvar arguments   = \"\" ;\n\t\t\t\t\t//added @ UAT-4\n\t\t\t\t\tif(parent.frame1.frame2 && parent.frame1.frame2.document.ManagePatQue.modalWindowOpen)\n\t\t\t\t\t\tparent.frame1.frame2.document.forms[0].modalWindowOpen.value=\"Y\";\n\t\t\t\t\tretVal = await window.showModalDialog(\"../../eOP/jsp/PatCheckoutCall.jsp?\"+\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',arguments,features);\n\t\t\t\t\t\n\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t\tif(retVal==undefined)\t{\n\t\t\t\t\t\t//added @ UAT-4\n\t\t\t\t\t\t/*Below line code was modified by venkatesh.S on 21/Feb/2013 against 38068*/\n\t\t\t\t\t\tif(parent.frame1.frame2 && parent.frame1.frame2.document.ManagePatQue.modalWindowOpen){\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t    if(parent.frame1.searchbutton.document.forms[0].refresh.value==getLabel(\"Common.search.label\",\"Common\")){\n\t\t\t\t\t\t\t\tparent.frame1.frame2.document.forms[0].modalWindowOpen.value=\"N\";\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.click();\n\t\t                        //parent.frame1.ManagePatQueueFrame.rows=\"29%,5%,80%,3%\";\t\n\t\t                        //parent.frame1.document.getElementById(\"frame1\").style.height=\"38vh\";\n\t\t\t\t\t\t\t\tvar ChkOut=parent.frame1.document.forms[0].ChkOut.value;\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame1\").style.height=\"38vh\";\n\t\t\t\t\t\t\t\tif (ChkOut == \"ChkOut\")\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame1\").style.height=\"34vh\";\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"searchbutton\").style.height=\"4vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame2\").style.height=\"50vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"checkbox\").style.height=\"5vh\";\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.value=getLabel(\"Common.search.label\",\"Common\");\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\tif(parent.frame1.searchbutton.document.forms[0].refresh.value==getLabel(\"eMR.Expand.label\",\"eMR\")){ \n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.value=getLabel(\"Common.search.label\",\"Common\");\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.click();\n\t\t\t\t\t\t\t\tparent.frame1.searchbutton.document.forms[0].refresh.value=getLabel(\"eMR.Expand.label\",\"eMR\");\n\t\t\t\t\t\t\t\tparent.frame1.frame2.document.forms[0].modalWindowOpen.value=\"N\";\t\n\t\t\t\t\t\t\t\t//parent.frame1.ManagePatQueueFrame.rows=\"5.1%,3%,40%,1.5%\"; \n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame1\").style.height=\"18.5vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"searchbutton\").style.height=\"4vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"frame2\").style.height=\"65vh\";\n\t\t\t\t\t\t\t\tparent.frame1.document.getElementById(\"checkbox\").style.height=\"5vh\";\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t/*end 3806*/\n\t\t\t\t}\n\t\t\t\t}OPPackageIntermediate();\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'ALL_ORDERS_NOT_COMPLETED\',\'OP\'));\n\t\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="          \n            \n            \n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
  
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection conn=null;
	conn=ConnectionManager.getConnection(request);
	
	
	/*
	Connection con = null;
	CallableStatement cstmt=null;
	Statement stmt=null;
	ResultSet resultSet=null;
	int episode_id=0;
	int op_episode_visit_num=0;
	*/
	//(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
try{
	
	String called_function=request.getParameter("called_function")==null?"":request.getParameter("called_function");
	 
	
	//String package_bl_install_YN=request.getParameter("package_bl_install_YN")==null?"N":request.getParameter("package_bl_install_YN");
	String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	
	String queue_date=request.getParameter("queue_date")==null?"":request.getParameter("queue_date");
	String QStatus=request.getParameter("QStatus")==null?"":request.getParameter("QStatus");
	String arriveDTime=request.getParameter("arriveDTime")==null?"":request.getParameter("arriveDTime");
	String VitalDtime=request.getParameter("VitalDtime")==null?"":request.getParameter("VitalDtime");
	String queue_num=request.getParameter("queue_num")==null?"":request.getParameter("queue_num");
	String oper_id=request.getParameter("oper_id")==null?"":request.getParameter("oper_id");
	String patient_id=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String rowNum=request.getParameter("rowNum")==null?"":request.getParameter("rowNum");
	String parameters=request.getParameter("parameters")==null?"":request.getParameter("parameters");
	String pat_id =request.getParameter("pat_id")==null?"":request.getParameter("pat_id");
	String pkg_pat_yn =request.getParameter("pkg_pat_yn")==null?"N":request.getParameter("pkg_pat_yn");
	String pkg_enc_yn =request.getParameter("pkg_enc_yn")==null?"N":request.getParameter("pkg_enc_yn");
	
	String bl_interfaced_yn =request.getParameter("bl_interfaced_yn")==null?"N":request.getParameter("bl_interfaced_yn");
	String facilityid=(String)session.getValue("facility_id");
	String build_episode_rule = request.getParameter("build_episode_rule");	
    String assign_queue_num_by = request.getParameter("assign_queue_num_by");	
    String sys_date = request.getParameter("sys_date");	
    String status = request.getParameter("status");	
	 
	 
	//String resultFlag="";
	//String sql="";
	if(called_function.equals("REVISEVISIT")) {
		/*
		sql="select EPISODE_ID,OP_EPISODE_VISIT_NUM from op_current_patient where facility_id='"+facilityid+"' and encounter_id="+encounter_id;
		stmt=con.createStatement();
		resultSet=stmt.executeQuery(sql);
		if(resultSet!=null && resultSet.next()){
			episode_id=Integer.parseInt(resultSet.getString("EPISODE_ID"));
			op_episode_visit_num=Integer.parseInt(resultSet.getString("OP_EPISODE_VISIT_NUM"));
		}
		sql = "SELECT blpackage.get_pkg_pat_yn('"+facilityid+"','"+patient_id+"','"+episode_id+"','"+op_episode_visit_num+"') pat_pakYN FROM dual";
		resultSet=stmt.executeQuery(sql);
		if(resultSet!=null && resultSet.next()){
			resultFlag=resultSet.getString(1);
		}
		*/
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pkg_pat_yn));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rowNum));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(queue_date));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(QStatus));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(arriveDTime));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(VitalDtime));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(oper_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(build_episode_rule));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(assign_queue_num_by));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(status));
            _bw.write(_wl_block23Bytes, _wl_block23);

	} else if(called_function.equals("OPCHECKOUTTOOLTIP") || called_function.equals("OPCHECKOUT")) {
			/*
			resultFlag="N";			
			if(bl_install_yn.equals("Y")){
				String flag="";
				sql="select bl_package_enabled_yn('"+facilityid+"') from dual";
				stmt=con.createStatement();
				resultSet=stmt.executeQuery(sql);
				if(resultSet!=null && resultSet.next()){
					flag=resultSet.getString(1);
				}
				if(flag.equals("Y")){
					sql="select EPISODE_ID,OP_EPISODE_VISIT_NUM from op_current_patient where facility_id='"+facilityid+"' and encounter_id="+encounter_id;
					stmt=con.createStatement();
					resultSet=stmt.executeQuery(sql);
					if(resultSet!=null && resultSet.next()){
						episode_id=Integer.parseInt(resultSet.getString("EPISODE_ID"));
						op_episode_visit_num=Integer.parseInt(resultSet.getString("OP_EPISODE_VISIT_NUM"));
					}
					//sql = "SELECT ORBLPACKAGE.OR_CHECK_PACKAGE_ORDER_COMP_YN('"+facilityid+"','"+encounter_id+"') FROM dual";			
					sql = "SELECT blpackage.Is_pkg_open_for_encounter('"+facilityid+"','"+patient_id+"','O','"+episode_id+"','"+op_episode_visit_num+"') FROM dual";	
					stmt=con.createStatement();
					resultSet=stmt.executeQuery(sql);
					if(resultSet!=null && resultSet.next()){
						resultFlag=resultSet.getString(1);
					}					
				}
			}
			*/
			if(pkg_enc_yn.equals("N")){	
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(called_function));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(parameters));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(called_function));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(parameters));
            _bw.write(_wl_block28Bytes, _wl_block28);
}else{
            _bw.write(_wl_block29Bytes, _wl_block29);
}
		} else if(called_function.equals("CANCELVISIT")) {
			String sql1 = "SELECT count(*) FROM or_order WHERE order_status NOT IN (SELECT order_status_code FROM or_order_status_code WHERE order_status_type IN ('99','93','96')) AND encounter_id= ? AND patient_id = ? AND ordering_facility_id =? ";

			int count = 0 ;			
			PreparedStatement pstmt=null;
			ResultSet rs1=null;
				
			pstmt = conn.prepareStatement(sql1);
			pstmt.setString(1,encounter_id);
			pstmt.setString(2,pat_id);
			pstmt.setString(3,facilityid);
			rs1 = pstmt.executeQuery();			
			if(rs1!=null && rs1.next()) {		 
				count = rs1.getInt(1);				
			} 

			out.println("#"+count);		

			if(pstmt != null) pstmt.close();
			if(rs1  != null) rs1.close();			
		}
}catch(Exception e) { 
	//if(resultSet != null) resultSet.close();
	//if(stmt != null) stmt.close();
	e.printStackTrace();
	
}finally{ 
	if(conn != null) {
		ConnectionManager.returnConnection(conn,request);
	}	
}                           

            _bw.write(_wl_block30Bytes, _wl_block30);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
