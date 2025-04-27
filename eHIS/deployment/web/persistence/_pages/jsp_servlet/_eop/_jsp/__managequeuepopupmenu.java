package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import javax.servlet.jsp.JspWriter;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __managequeuepopupmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/ManageQueuePopupMenu.jsp", 1729065199931L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n    <head>\n\t \t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n       <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n       <script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n       <script language=\'javascript\' src=\'../../eOP/js/ManageSPatQueue.js\'></script>\n    </head>\n\t<body  onKeyDown = \'lockKey();\'>\n\n  \n    ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n      <script>\n\t  /*  Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013 */\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' cellpadding=0 cellspacing=0 border=\'0\'   class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\t    tab_dat     += \"<tr>\";\n      </script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013 */\n\t\t\t\t\t/*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n                    tab_dat     += \"<tr>\";\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\\\"\"+escape(\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\")+\"\\\",\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'\"+escape(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')+\"\',\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\")+\"\\\",\\\"\"+escape(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\'Allergy\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'\',\'\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');>\"+getLabel(\'Common.RecordAllergy.label\',\'Common\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n               </script>\n                ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/\n\t\t\t\t\t/*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'Arrived\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');>\"+getLabel(\'eOP.arrived.label\',\'OP\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n\t\t\t\t    </script>\n                ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t<script>\n                /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/\n                /*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n\t\t\t\t\n\t                tab_dat     += \"<tr>\";\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'Record\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');>\"+getLabel(\'eOP.recordvitalsigns.label\',\'OP\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n\n                    </script>\n                ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<script>\n                    /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/\n                    /*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n\t                tab_dat     += \"<tr>\";\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'Assign\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\');>\"+getLabel(\'eOP.assignpractitioner.label\',\'OP\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n                    </script>\n                ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/\n\t\t\t\t\t/*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n\t                tab_dat     += \"<tr>\";\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\',\'ReAssign\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');>\"+getLabel(\'eOP.reassignpractitioner.label\',\'OP\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n\n                    </script>\n                ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'Start\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');>\"+getLabel(\"Common.StartConsult.label\",\'Common\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n\n                    </script>\n                ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n                \t<script>\n\t\t\t\t\ttab_dat     += \"<tr>\";\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\',\'QueueNoUpdate\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\');>\"+getLabel(\"eOP.UpdateQueueNumber.label\",\'OP\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\',\'Revert\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');>\"+getLabel(\"eOP.ReverttoCheckin.label\",\'OP\')+\"</a></td>\";\t\n\t\t\t\t\ttab_dat     += \"</tr>\";\n\n                    </script>\n                ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t<script>\n\t           \n\t\t\t       /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/\n\t\t\t       /*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n\n\n\t\t\t\t\t/*Modified by Dharma on Feb 27th 2015 against ML-BRU-SCF-1540 [IN:053334] Start */\n\t\t\t\t    tab_dat     += \"<tr>\";\n\t\t\t\t\t//tab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\\\"\"+escape(\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\')+\"\\\",\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\',\'Patient\',\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\');>\"+getLabel(\'Common.patientchart.label\',\'common\')+\"</a></td>\";\t\n\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\');>\"+getLabel(\'Common.patientchart.label\',\'common\')+\"</a></td>\";\n\t\t\t\t\t/*Modified by Dharma on Feb 27th 2015 against ML-BRU-SCF-1540 [IN:053334] End */\n\t\t\t\t\ttab_dat     += \"</tr>\";\n\n                    </script>\n                ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t/* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/\n\t\t\t\t\t /*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n\t                    tab_dat     += \"<tr>\";\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\',\'multirefreg\',\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');>Multi Consult Orders</a></td>\";\t\n\t\t\t\t\t    tab_dat     += \"</tr>\";\n\n                    </script>\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t    /* Below lines class values moidified by Venkatesh.S  against  Bru-HIMS-CRF-303 [IN035021] on 02-April-2013*/  \n\t\t\t\t\t    /*Below line modifie for this CRF Bru-HIMS-CRF-133*/\n\t                    tab_dat     += \"<tr>\";\n\t\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a href=javascript:CallFunction(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',\'Check\',\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');>\"+getLabel(\'Common.CheckOut.label\',\'Common\')+\"</a></td>\";\t\n\t\t\t\t\t    tab_dat     += \"</tr>\";\n\n                    </script>\n                ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n            <script>\n\t\t\t   \n\t\t   tab_dat     += \"</table>\";\n\t\t\t\n\t\t\t   \n\t\t\t   parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t   /*Below line modified by Venkatesh.S on 04/FEB/2012 against Bru-HIMS-CRF-179 [IN030297] */\n\t\t\t   parent.frames[1].frame2.document.getElementById(\"t\").innerHTML = tab_dat;\n\t\t\t   /*end Bru-HIMS-CRF-179 [IN030297] */\n            </script>\n           ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n            <script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="parent.commontoolbarFrame.location.href=\"../../eCommon/jsp/commonToolbar.jsp?menu_id=OP&module_id=OP&function_id=MANAGE_PAT_QUEUE&function_name=Manage Patient Queue&function_type=F&access=NNNNN&home_required_yn=N&call_from=CA\";\n\t\t\t\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\n\t\t\t   tab_dat     += \"</table>\";\n\t\t\t\n\t\t\t   parent.messageFrame.location.href=\"../../eCommon/jsp/error.jsp?err_num=\";\n\t\t\t   parent.frames[1].frames[1].PatQ.document.getElementById(\"t\").innerHTML = tab_dat;\n\t\t\t\t\n            </script>\n            ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n</body>  \n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
  
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
	    response.addHeader("X-XSS-Protection", "1; mode=block");
	    response.addHeader("X-Content-Type-Options", "nosniff");
        //Connection con=null;
        //Added by Ajay Hatwate for MMS-DM-CRF-0210.1
        java.util.Properties p;
    	p = (java.util.Properties) session.getValue( "jdbc" ) ;
    	String logged_in_user = p.getProperty( "login_user" ) ;
    	//End of MMS-DM-CRF-0210.1
        try{       
		//con=ConnectionManager.getConnection(request);
        String EncounterId=request.getParameter("Encounter_Id");
		String queue_status=request.getParameter("p_queue_status");
		String attend_practitioner_id  =request.getParameter("pract_id");
		
		String episode_id	= request.getParameter("episode_id")==null?"":request.getParameter("episode_id");// Added for MMS-QH-CRF-0126 [IN:041880]
		String op_episode_visit_num	= request.getParameter("op_episode_visit_num")==null?"":request.getParameter("op_episode_visit_num");// Added for MMS-QH-CRF-0126 [IN:041880]
		
		/*Below line added for this CRF Bru-HIMS-CRF-133*/
		String curr_locntype = request.getParameter("curr_locntype")==null?"":request.getParameter("curr_locntype");
		String curr_locncode = request.getParameter("curr_locncode")==null?"":request.getParameter("curr_locncode");
		String isPatientEncMovement	= request.getParameter("isPatientEncMovement")==null?"":request.getParameter("isPatientEncMovement");
		String Sydate = request.getParameter("Sydate")==null?"":request.getParameter("Sydate");
	
		//End this CRF Bru-HIMS-CRF-133
		
		String assign_care_locn_type =request.getParameter("curr_loc_type");
		String assign_care_locn_code =request.getParameter("locn_code");
		String PreviousDay = request.getParameter("previous_day");
		if(PreviousDay == null || PreviousDay.equals("null") || PreviousDay.equals(""))
			PreviousDay = "0";
		if(PreviousDay.equals("1"))		PreviousDay = "-1";
		if(PreviousDay.equals("0"))		PreviousDay = "+0";
		String patient_id=request.getParameter("patient_id");
		String visit_adm_type=request.getParameter("visit_adm_type");
		//String locn_code=request.getParameter("locn_code");
		//String curr_loc_type=request.getParameter("curr_loc_type");
		//String pract_id=request.getParameter("pract_id");
	//	String p_queue_status=request.getParameter("p_queue_status");
		//String bl_install_yn= ((String)session.getValue( "bl_operational" ))==null?"N":((String)session.getValue( "bl_operational" )) ;
		
		String p_patient_class=request.getParameter("p_patient_class");
		String CARE_LOCN_TYPE_IND=request.getParameter("CARE_LOCN_TYPE_IND");
		String sex=request.getParameter("sex");
		String dob=request.getParameter("DATE_OF_BIRTH");
		String room_num=request.getParameter("room_num");
		String p_status = request.getParameter("p_status");
        p_status=java.net.URLDecoder.decode(p_status,"UTF-8");
		String dt=request.getParameter("dt");
		String appt_id=request.getParameter("appt_id");
		String p_queue_date=request.getParameter("p_queue_date");
		String arrival_date=request.getParameter("arrival_date");
		String curr_locn=request.getParameter("curr_locn");		
		String calling_module=request.getParameter("calling_module")==null?"":request.getParameter("calling_module");
		//String package_bl_install_YN=request.getParameter("package_bl_install_YN")==null?"N":request.getParameter("package_bl_install_YN");

		String pkg_pat_yn = request.getParameter("pkg_pat_yn")==null?"N":request.getParameter("pkg_pat_yn");
		String pkg_enc_yn = request.getParameter("pkg_enc_yn")==null?"N":request.getParameter("pkg_enc_yn");
		
		curr_locn=java.net.URLDecoder.decode(curr_locn,"UTF-8");
		String curr_locn_type_desc=request.getParameter("curr_locn_type_desc")==null?"":request.getParameter("curr_locn_type_desc");
		curr_locn_type_desc=java.net.URLDecoder.decode(curr_locn_type_desc,"UTF-8");
		String VISIT_ADM_TYPE_IND=request.getParameter("VISIT_ADM_TYPE_IND");
		String appt_case_yn=request.getParameter("appt_case_yn");
		String ARRIVE_DATE_TIME=request.getParameter("ARRIVE_DATE_TIME");
		String VITAL_SIGNS_DATE_TIME=request.getParameter("VITAL_SIGNS_DATE_TIME");
		String other_res_class=request.getParameter("other_res_class");
		if(other_res_class == null) other_res_class="";
		String other_res_code=request.getParameter("other_res_code");
		if(other_res_code == null) other_res_code="";
		String queue_num=request.getParameter("queue_num");
		if(queue_num == null) queue_num="";
		String appt_walk_ind=request.getParameter("appt_walk_ind");
		if(appt_walk_ind == null) appt_walk_ind="";
		String queue_id=request.getParameter("queue_id");
		if(queue_id == null) queue_id="";
		String callfrom =request.getParameter("callfrom");
		if(callfrom == null) callfrom="";
		//int episode_id=0;
		//int op_episode_visit_num=0;
		//String resultFlag="N";
  
	    String mode="";
		String ca_install_yn = request.getParameter("caInsYn") == null?"N":request.getParameter("caInsYn");
        String check_out_yn="N";
		String allergy_yn = request.getParameter("allergy_yn") == null?"":request.getParameter("allergy_yn");
		String OsVal = request.getParameter("OsVal_chkout") == null?"":request.getParameter("OsVal_chkout");

		 
		String isQMSapplicable=request.getParameter("isQMSapplicable");//added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 24-05-2023 Started-->

		
		
		
            try
            {
                //PreparedStatement pstmt=null;
				//ResultSet rs=null;
       
				if(!(attend_practitioner_id==null ||attend_practitioner_id.equals("*ALL")))
                    mode="R";
                  else
                    mode="A";

				/*
				            
				String sql_new = "Select AM_OPER_STN_ACCESS_CHECK('"+facilityid+"','"+userid+"','X','','CHECKOUT_PAT_YN') OsVal, (select install_yn from sm_module where module_id ='CA') install_yn, GET_TASK_APPLICABILITY('ALLERGIES', NULL, '"+resp_id+"', NULL) allergy_yn FROM dual" ;         
        
               pstmt=con.prepareStatement(sql_new);
               rs=pstmt.executeQuery();
               rs.next();
	           OsVal=rs.getString("OsVal");
			   ca_install_yn = rs.getString("install_yn");
			   allergy_yn = rs.getString("allergy_yn");	
			  
			   if(bl_install_yn.equals("Y") && package_bl_install_YN.equals("Y")){
				   sql_new =" select EPISODE_ID,OP_EPISODE_VISIT_NUM from op_current_patient where facility_id='"+facilityid+"' and encounter_id="+EncounterId;  
					pstmt=con.prepareStatement(sql_new);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next()){
						episode_id=Integer.parseInt(rs.getString("EPISODE_ID"));
						op_episode_visit_num=Integer.parseInt(rs.getString("OP_EPISODE_VISIT_NUM"));
					}
					sql_new ="SELECT blpackage.get_pkg_pat_yn('"+facilityid+"','"+patient_id+"','"+episode_id+"','"+op_episode_visit_num+"') pat_pakYN FROM dual"; 
					pstmt=con.prepareStatement(sql_new);
					rs=pstmt.executeQuery();
					if(rs!=null && rs.next()){
						resultFlag=rs.getString(1);
					}
				}
				*/
        
			if((!OsVal.equals("1")) && (!OsVal.equals("2")) && (!OsVal.equals("3")) && (!OsVal.equals("4")))
	        {
			   check_out_yn="Y";
			   
            }

			/*
			if(pstmt!=null ) pstmt.close();	
			if (rs != null)  rs.close();
			*/


            _bw.write(_wl_block7Bytes, _wl_block7);
 // if( queue_status .equals("01") || ( ( queue_status.equals("02") /*|| queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06") ) &&  (! assign_care_locn_type.equals(current_locn_type) || !assign_care_locn_code.equals(current_locn_code))*/)  )
                

                
			 
				if(allergy_yn.equals("A"))
				{	
					
				if( (queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06"))  && ca_install_yn.equals("Y")) // Added
				// for
				// Excluding
				// Record
				// Vital
				// Signs
				// option
				// for
				// Previous
				// Days
				// Visits.
                {			

				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block17Bytes, _wl_block17);

                       // MenuElements.append("Record Vital Signs"+";");
				}
                }	
						
				
				if(queue_status .equals("01"))
                {  
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(CARE_LOCN_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block20Bytes, _wl_block20);
}
                
					
				
				if( (queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06")) && PreviousDay.equals("+0") && ca_install_yn.equals("Y")) // Added
				// for
				// Excluding
				// Record
				// Vital
				// Signs
				// option
				// for
				// Previous
				// Days
				// Visits.
                {
				
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block23Bytes, _wl_block23);

                       // MenuElements.append("Record Vital Signs"+";");
                }
                if((attend_practitioner_id==null || attend_practitioner_id.equals("*ALL"))  && ( ( queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("03") ) ) )
                {
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block26Bytes, _wl_block26);


                       // MenuElements.append("Assign Practitioner"+";");
                }
                if(!(attend_practitioner_id==null || attend_practitioner_id.equals("*ALL")) && (queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("03") ) )
                {
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block29Bytes, _wl_block29);


                        // MenuElements.append("Re-Assign Practitioner"+";");
                }
                if(!(attend_practitioner_id ==null || attend_practitioner_id.equals("*ALL")) && (queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("05") || queue_status.equals("06")))
                {
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block31Bytes, _wl_block31);


                       // MenuElements.append("Start Consultation"+";");
                }
              //<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Started-->
           	 if(isQMSapplicable.equals("true")){
               if(queue_status.equals("02") && CARE_LOCN_TYPE_IND.equals("C"))
				 
                {
                	
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block34Bytes, _wl_block34);
 }
                }
                //<!--added by Himanshu Saxena for ML-BRU-CRF-0628.11 on 22-05-2023 Ends-->
				if(queue_status.equals("02") || queue_status.equals("03"))
				{
				
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block36Bytes, _wl_block36);


						// MenuElements.append("Revert to Check-in"+";");
				}

				if((queue_status.equals("02") || queue_status.equals("03") || queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06")) && ca_install_yn.equals("Y") && (!attend_practitioner_id.equals("*ALL")))
				{
				
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(logged_in_user));
            _bw.write(_wl_block42Bytes, _wl_block42);


						// MenuElements.append("Patient Chart"+";");
				}
				//added as part of package billing Starts
				if((queue_status.equals("01") || queue_status.equals("02") || queue_status.equals("04")) && pkg_pat_yn.equals("Y")){
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block45Bytes, _wl_block45);
}
					//added as part of package billing ends
                if(queue_status.equals("04") || queue_status.equals("05") || queue_status.equals("06"))
                {

                if(check_out_yn.equals("Y")){
				
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(queue_status));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(EncounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(assign_care_locn_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(visit_adm_type));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(PreviousDay));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_class));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(URLEncoder.encode(arrival_date)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_status));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(URLEncoder.encode(dt)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_queue_date));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(curr_locn_type_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(VISIT_ADM_TYPE_IND));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_case_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(ARRIVE_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(URLEncoder.encode(VITAL_SIGNS_DATE_TIME)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_class));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(other_res_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(appt_walk_ind));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(queue_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(callfrom));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pkg_pat_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pkg_enc_yn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(episode_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(op_episode_visit_num));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locntype));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_locncode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(isPatientEncMovement));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(Sydate));
            _bw.write(_wl_block48Bytes, _wl_block48);

					}
           }
		  
		   if(callfrom.equals("S")){
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
            _bw.write(_wl_block50Bytes, _wl_block50);

					if(calling_module.equals("CA"))
					{				
            _bw.write(_wl_block51Bytes, _wl_block51);

					}
				
            _bw.write(_wl_block52Bytes, _wl_block52);
 }
			}
            catch(Exception e){e.printStackTrace();}
       }catch(Exception e) {}
finally{	
	//if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block53Bytes, _wl_block53);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
