package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import eCommon.XSSRequestWrapper;

public final class __mrblank extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/mrblank.jsp", 1743670958210L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n \n\t\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n<Script language=\'javascript\' src=\'../../eCommon/js/common.js\'></Script>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n</head>\n<script>\nfunction reset()\n{\n}\nasync function aa()\n{\n if (\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' == \'1\')\n {\n\tvar pat_id = await PatientSearch();\n\tif (pat_id != null)\n\t\tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/RecordPatAllergyMain.jsp?Patient_Id=\'+pat_id;\t\n\telse\n\t        parent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n }\n if(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' == \'2\')\n  {\n    \tvar pat_id = await PatientSearch();\n \tif (pat_id != null)\n\t\tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/RecordPatHighRiskMain.jsp?Patient_Id=\'+pat_id;\t\n\telse\n\t        parent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n }\n if(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'==\'3\')\n {\n            var retVal =  new String();\n\t    var encounter_id = \"\";\n\t   // var queue_date\t = \"\";\n\t    var dialogHeight= \"33.8vh\" ;\n\t    var dialogWidth = \"50vw\" ;\n\t    var dialogTop = \"58\";\n\t    var features  = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no;\"+\"dialogTop:\" + dialogTop ;\n\t    var arguments = \"\";\n\t    retVal =await window.showModalDialog(\"../../op/jsp/PaintSearchVisit.jsp?p_mode=\",arguments,features);\n\n\t    if (retVal==\"\" || retVal == null)\n\t    \tparent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n\t    else\n\t    {\n\t    \tencounter_id \t= retVal.substring(0,retVal.indexOf(\"|\"));\n\t    \tqueue_date \t= retVal.substring(retVal.indexOf(\"|\")+1);\n\t    \tif(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'==\'PatProb\')\n\t\t\tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/RecordPatProblemMain.jsp?patient_type=O&encounterid=\'+encounter_id+\'&queuedate=\'+queue_date;\n\t\tif(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'==\'PatProc\')\t\n\t\t        parent.f_query_add_mod.document.location.href=\'../../eMR/jsp/RecordPatProcedureMain.jsp?&encounterid=\'+encounter_id;\n\t    }\t\t\t\n\n      }\n      if(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' == \'4\')\n      {\n            var pat_id= await PatientSearch();\n            if(pat_id != null)\n            \tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/patprobquerymain.jsp?Patient_Id=\'+pat_id;\n            else\n\t        parent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\t\n           \n     } \n     if(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' == \'5\')\n     {\n            var pat_id= await PatientSearch();\n            // console.log(pat_id) ;\n            if(pat_id != null)\n            {\n\t\t\tparent.patLine.document.location.href=\'../../eCommon/jsp/pline.jsp?Patient_Id=\'+pat_id;\n            parent.f_query_add_mod.document.location.href=\'../../eMR/jsp/AddModifyPatBloodGroup.jsp?P_Patient_Id=\'+pat_id;\n            }\n            else\n\t        parent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n                \n     } \n     if(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' == \'6\')\n     {\n      \tvar pat_id=await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'Y\',\'\',\'\',\'VIEW\');\n        if(pat_id != null)\n                parent.f_query_add_mod.document.location.href=\'../../eMR/jsp/vwPatFileDetailmain.jsp?Patient_Id=\'+pat_id;\n        else\n\t        parent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n     }    \n  \t if(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' == \'7\')\n\t {\n\t\t\n\t\tvar pat_id= await PatientSearch(\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'CHG_PAT_DTLS\');\n\t\t if(pat_id != null)\n\t\t {\n\t\t\t//parent.f_query_add_mod.document.location.href=\'../../servlet/eMR.PatientFileServlet?Patient_Id=\'+pat_id+\'&operation=create_file_no\';\n\t\t\t\n\t\t\tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/PatientFile.jsp?Patient_Id=\'+pat_id;\n\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t}\t\n\t\t\t//parent.f_query_add_mod.document.location.href=\'/eCIS/servlet/mr.test\';\n\t\t else\n\t\t\tparent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n \t }    \n     if(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' == \'8\')\n\t {\n\t\t\n\t\tvar pat_id=await PatientSearch();\n\t\t if(pat_id != null)\n\t\t\tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/RecordMajorMedicalEvents.jsp?Patient_Id=\'+pat_id;\n\t\t\telse\n\t\t\tparent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n \t \n\t }    \n\t      if(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' == \'9\')\n\t {\n\t\tvar pat_id=await PatientSearch();\n\t\t if(pat_id != null)\n\t\t\tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/RecordOtherMedicalInfo.jsp?Patient_Id=\'+pat_id;\n\t\t\t else\n\t\t\tparent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n \t }    \n\t       if(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' == \'10\')\n\t {\n\t\tvar pat_id=await PatientSearch();\n\t\t if(pat_id != null)\n\t\t\tparent.f_query_add_mod.document.location.href=\'../../eMR/jsp/vwActiveProblemsmain.jsp?Patient_Id=\'+pat_id;\n\t\t\t else\n\t\t\tparent.window.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n \t }\n\n}\n</script>\n\n<body class=\"CONTENT\" onLoad=\'aa()\' OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

	 request.setCharacterEncoding("UTF-8");
	 request= new XSSRequestWrapper(request);
	 response.addHeader("X-XSS-Protection", "1; mode=block");
	 response.addHeader("X-Content-Type-Options", "nosniff");
	 String f_name= request.getParameter("step_1");
//	 String facility_id      = (String) session.getValue("facility_id");
	 String func=request.getParameter("func");

            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(func));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(func));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(f_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
