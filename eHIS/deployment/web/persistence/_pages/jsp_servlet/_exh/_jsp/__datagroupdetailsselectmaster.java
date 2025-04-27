package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHDBAdapter;

public final class __datagroupdetailsselectmaster extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/DataGroupDetailsSelectMaster.jsp", 1709122320461L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML> \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<HEAD>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\" ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\" ></script>\n<script language=\"javascript\" src=\"../../eXH/js/DataGroupIdDetails.js\" ></script> \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\">\n/*\n//function onSelectDataGroup\nfunction onSelectDataGroup(obj)\n{\n\tdocument.forms[0].action=\"../../eXH/jsp/.jsp?message_type=\"+obj.value;\n\tdocument.forms[0].submit();\n\tparent.parent.messageFrame.location.href=\"../../eCommon/jsp/MstCodeError.jsp\";\n}\n*/\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</HEAD>\n<BODY  leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<form name=\"Datagroupdetails_setup_form\" id=\"Datagroupdetails_setup_form\" target=\'messageFrame\' method=\'post\' action=\'../../servlet/eXH.DataGroupDetailsAddModifyServlet\'>\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td width=\'40%\'></td>\n\t<td width=\'60%\'></td>\n</tr>\n\n<tr>\n<td class=label >Data</td> \n\n<td class=\'fields\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<tr>\n<td class=label >Application ID</td>\n<td align=left><input type=text id=\"application_name\"  name =application_name value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' size=25> <input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=ApplicationSearch value=\'?\'    onClick=\"searchApplication();\">\n<input type=\"hidden\" name=\"application_id\" id=\"application_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"><img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n<tr>\n<td class=label >Facility ID</td>\n<td align=left><input type=text id=\"facility_name\"  name =facility_name size=25 value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' > <input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=FacilitySearch value=\'?\'    onClick=\"searchFacility()\">\n<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"><img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n<tr>\n<td class=label >Message Type</td>\n<td align=left><input type=text id=\"mesg_type\"  name =mesg_type size=25 value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' > <input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=MessageTypeSearch value=\'?\'    onClick=\"searchMessageType()\">\n<input type=\"hidden\" name=\"mesg_type_id\" id=\"mesg_type_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"><img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n<tr>\n<td class=label >Event Type</td>\n<td align=left><input type=text id=\"event_type\"  name =event_type size=25 value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' > <input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=EventTypeSearch value=\'?\'    onClick=\"searchEventType()\">\n<input type=\"hidden\" name=\"event_type_id\" id=\"event_type_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"><img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n<tr>\n<td class=label >Segment Type</td>\n<td align=left><input type=text id=\"segment_type\"  name =segment_type size=25 value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  > <input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=SegmentTypeSearch value=\'?\'    onClick=\"searchSegmentType()\">\n<input type=\"hidden\" name=\"segment_type_id\" id=\"segment_type_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"><img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n<tr>\n<td class=label >Protocol Link ID</td>\n<td align=left><input type=text id=\"protocol_linkName\"  name =protocol_linkName size=25 value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' > <input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=ProtocolLinkSearch value=\'?\'    onClick=\"searchProtocolLink()\">\n<input type=\"hidden\" name=\"protocol_link_id\" id=\"protocol_link_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"><img src=\'../../eCommon/images/mandatory.gif\' align=middle></td>\n<td> </td><td> </td>\n</tr>\n\n\n<tr>\n\t<td width=\'40%\'></td>\n\t<td width=\'60%\'></td>\n</tr>\n</table>\n\t\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\n<input type=\"hidden\" name=\"act_mode\" id=\"act_mode\" value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\n</form>\n</BODY>\n</HTML> \n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
 
Connection con=null;
Statement stmt = null;
ResultSet rs  = null;
String defaultval = "";

            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);


String application_id=""; 
String facility_id=""; 
String mesg_type_id=""; 
String event_type_id=""; 
String segment_type_id="";
String protocol_link_id="";

String dg_code="";
String application_name=""; 
String facility_name=""; 
String mesg_type=""; 
String event_type=""; 
String segment_type="";
String protocol_linkName="";


String mode			=	request.getParameter("mode");

if(mode.equals("U"))
{
	dg_code=request.getParameter("dg_code");
	defaultval=request.getParameter("dg_code");
	
	application_name=request.getParameter("application_name");
	facility_name=request.getParameter("facility_name");
	mesg_type=request.getParameter("mesg_type");
	event_type=request.getParameter("event_type");
	segment_type=request.getParameter("segment_type");
	protocol_linkName=request.getParameter("protocol_linkName");
	//language_id=request.getParameter("lang_id");
}

application_id		=	request.getParameter("application_id");
facility_id			=	request.getParameter("facility_id");
mesg_type_id		=	request.getParameter("mesg_type_id");
event_type_id		=	request.getParameter("event_type_id");
segment_type_id		=	request.getParameter("segment_type_id");
protocol_link_id	=	request.getParameter("protocol_link_id");


            _bw.write(_wl_block6Bytes, _wl_block6);

try
{
con=ConnectionManager.getConnection();
//String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP WHERE //LANGUAGE_ID='"+locale+"' ORDER BY 2";
String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP ORDER BY 2";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(application_name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(application_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facility_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(mesg_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(mesg_type_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(event_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(event_type_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(segment_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(segment_type_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(protocol_linkName));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(protocol_link_id));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
catch(Exception e1){
		System.out.println("(DataGroupDetailsSelectMaster.jsp:Excetion-1)"+e1.toString());
}
finally{

		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
