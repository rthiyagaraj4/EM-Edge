package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import eXH.XHDBAdapter;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __apibasedinboundsearchresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/APIbasedInboundSearchResult.jsp", 1742454154759L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n<script language=\'javascript\' src=\'../../eXH/js/APIBasedInbound.js\'></script>  \n<script Language=\"JavaScript\"  src=\"../../eCommon/js/common.js\" ></script>\n<script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\nfunction dsbl_elment_Val(obj,srl_no){\n\tif(obj.value!=\"\"){\n//\t    alert(\"elmnt Pos :   \"+obj.value+\", srl_no : \"+srl_no);\n\t\teval(\"document.forms[0].element_val_\"+srl_no).disabled = true;\n\t}\n\telse{\n\t\teval(\"document.forms[0].element_val_\"+srl_no).disabled = false;\n\t}\n}\n\nfunction dsbl_elment_Pos(obj,srl_no){\n\tif(obj.value!=\"\"){\n//\t\talert(\"elmnt Val :   \"+obj.value+\", srl_no : \"+srl_no);\n\t\tdocument.getElementById(srl_no+\'_element_pos\').disabled = true;\n\t}\n\telse{\n\t\tdocument.getElementById(srl_no+\'_element_pos\').disabled = false;\n\t}\n}\n\n</script>\n\n\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"APIBasedSearchResult\" id=\"APIBasedSearchResult\" method=\"POST\" action=\'\' target=\"\" >\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table border=1 cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script>\nalert(getMessage(\'XH1021\',\'XH\'));\n</script>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr>\n<!--\t<td colspan=\"6\" align=\"right\" class=\"CAGROUP\" >  -->\n\t<td colspan=\"5\" align=\"right\" class=\"CAGROUP\" > \n\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</A>\n\t<A class=\'label\'  onClick=\"funAction(\'N\')\" style=\'cursor:pointer\' >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</A>\n\t</td>\n\t</tr>\n\n<tr>\n\t<td class=\'COLUMNHEADER\'  width=\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'20%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td class=\'COLUMNHEADER\'  width=\'50%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n</tr>\n\n\n\n\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n\t<tr>\n\t<td ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="  align=\"left\" >\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</b>\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" align=\"left\"> \n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n\t<td ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</td>\n\n\t<td ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" align=center ><input type=\"text\" id=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="_element_pos\" name=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="_element_pos\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" onchange=\"dsbl_elment_Val(this,\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\');\">\n\t\t\t<input style=\"background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;\" type=\"button\"  name=ElementSearch id=ElementSearch value=\'?\'    onClick=\"searchElement(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\');\">\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="_element_id\" name=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="_element_id\" value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' ></td>\t\n\t<td ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" align=center ><input type=\"text\" name=\'element_val_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'element_val_";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" onchange=\"dsbl_elment_Pos(this,\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\');\"></td>\t\n\n\t</tr>\n\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t</table>\n\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'U\' >\n\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'\'>\n\n\n\t<input type=\'hidden\' name=\'application_id\' id=\'application_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'event_type_id\' id=\'event_type_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'segment_type_id\' id=\'segment_type_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'inboundapi_id\' id=\'inboundapi_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'application_name\' id=\'application_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'facility_name\' id=\'facility_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'event_type\' id=\'event_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'segment_type\' id=\'segment_type\' value=\'\'>\n\t<input type=\'hidden\' name=\'inboundapi_name\' id=\'inboundapi_name\' value=\'\'>\n\n\t<input type=\'hidden\' name=\'arg_serial_no\' id=\'arg_serial_no\' value=\'\'>\n\t<input type=\'hidden\' name=\'arg_id\' id=\'arg_id\' value=\'\'>\n\t<input type=\'hidden\' name=\'arg_name\' id=\'arg_name\' value=\'\'>\n\t<input type=\'hidden\' name=\'element_pos\' id=\'element_pos\' value=\'\'>\n\t<input type=\'hidden\' name=\'element_val\' id=\'element_val\' value=\'\'>\n\n\t<input type=\'hidden\' name=\'appl_id\' id=\'appl_id\' value=";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =">\n\t<input type=\'hidden\' name=\'fac_id\' id=\'fac_id\' value=";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n\t<input type=\'hidden\' name=\'evnt_id\' id=\'evnt_id\' value=";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =">\n\t<input type=\'hidden\' name=\'sgmnt_id\' id=\'sgmnt_id\' value=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =">\n\t<input type=\'hidden\' name=\'inb_api\' id=\'inb_api\' value=";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n\n\t<input type=\'hidden\' name=\'frmSrl_no\' id=\'frmSrl_no\' value=";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\t\n\n</form>\n</html>\n\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


			boolean boolToggle =  true;	
			String strTDClass = "";
			// #MOD#03
			String qry_id = "APIBASEDINBOUND";			
			Connection conn = null;
			String whereClause = "WHERE  ";

			String appl_id = "";
			String fac_id = "";
			String evnt_id = "";
			String sgmnt_id = "";
			String inb_api = "";

			String s_no  = "";

			String elmntPos = "";
			String elmntVal = "";
			String dsblPos  = "";
			String dsblVal  = "";

			String frmSrl_no = "";
			int i = 1;

	//		System.out.println("APIResult "+whereClause);
			try
			{

				appl_id = request.getParameter("appl_id");
					//System.out.println("appl_id : "+appl_id);
				fac_id  = request.getParameter("fac_id");
					//System.out.println("fac_id : "+fac_id);
				evnt_id = request.getParameter("evnt_id");
					//System.out.println("evnt_id : "+evnt_id);
				sgmnt_id  = request.getParameter("sgmnt_id");
					//System.out.println("sgmnt_id : "+sgmnt_id);
				inb_api   = request.getParameter("inb_api");
					//System.out.println("inb_api : "+inb_api);

				if(!(appl_id.equals(" "))){					
				  whereClause =whereClause + " A.APPLICATION_ID = NVL('#appl_id',A.APPLICATION_ID)";
 				} 

				if(!(fac_id.equals(" "))){					
				  whereClause =whereClause + " AND A.FACILITY_ID = NVL('#fac_id',A.FACILITY_ID)";
 				} 

				if(!(evnt_id.equals(" "))){					
				  whereClause =whereClause + " AND A.EVENT_TYPE = NVL('#evnt_id',A.EVENT_TYPE)";
 				} 
				
				if(!(sgmnt_id.equals(" "))){					
				  whereClause =whereClause + " AND A.SEGMENT_ID = NVL('#sgmnt_id',A.SEGMENT_ID)";
 				} 
				
				if(!(inb_api.equals(" "))){					
				  whereClause =whereClause + " AND A.INBOUND_API = NVL('#inb_api',A.INBOUND_API)";
 				} 

				whereClause = whereClause+" AND A.ELEMENT_POSITION=B.ELEMENT_ID(+)  ORDER BY a.sno";

				//System.out.println("APIbasedInboundQueryResult WhrCls : "+whereClause);

				request.setAttribute(XHQueryRender.strQueryId,qry_id);
				// #MOD#04
				//System.out.println("APIbasedInboundSearchResult qry id : "+qry_id);

				request.setAttribute(XHQueryRender.col,"6");
			    request.setAttribute(XHQueryRender.whereClause,whereClause);
				conn = ConnectionManager.getConnection(request);
				HashMap resultsQry = XHQueryRender.getResults(request,session,conn);
				ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
				ArrayList arrCol = null;
				boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
				boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
				String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				if (boolPrevious == true)
				{
					strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
				}
				else
				{
					strPrevious = " ";
				}
				if (boolNext== true)
				{
						strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
				}
				else
				{
					strNext  = " ";
				}
		
            _bw.write(_wl_block8Bytes, _wl_block8);

if(arrRow.size()==0)
{

            _bw.write(_wl_block9Bytes, _wl_block9);
 } else { 
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strPrevious ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strNext ));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

	for (int j=0; j<arrRow.size();j++)
	{
		arrCol = (ArrayList)arrRow.get(j);
		if (boolToggle == true)
		{
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
		}
		else
		{
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}
			
			dsblPos = "";
			dsblVal = "";

			s_no = 	XHDBAdapter.checkNull((String)arrCol.get(0));
			if(i==1){
					frmSrl_no = s_no;
					i++;
			}
			elmntPos = XHDBAdapter.checkNull((String)arrCol.get(5));
			elmntVal = XHDBAdapter.checkNull((String)arrCol.get(4));

			if(!elmntPos.equals("")){
			     dsblVal = "disabled";
			}
			else if (!elmntVal.equals("")){
				dsblPos =  "disabled";
			}
	
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(""+XHDBAdapter.checkNull((String)arrCol.get(1))));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(""+arrCol.get(2) ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(elmntPos));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dsblPos));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(3))));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(elmntVal));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(dsblVal));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(s_no));
            _bw.write(_wl_block37Bytes, _wl_block37);

	}
}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
}
	catch(Exception e1)
	{
		out.println("Error="+e1);
	}
	finally
	{
		ConnectionManager.returnConnection(conn);
	}
	
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(appl_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(evnt_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sgmnt_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(inb_api));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(frmSrl_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SerialNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ArgID.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ArgName.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ElementPos.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ElementVal.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }
}
