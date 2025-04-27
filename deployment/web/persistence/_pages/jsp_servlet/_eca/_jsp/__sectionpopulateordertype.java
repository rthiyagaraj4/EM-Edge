package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __sectionpopulateordertype extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/SectionPopulateOrderType.jsp", 1709116305042L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<script> \n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_type_label1\").innerText =\'Adverse Event Type\';\n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label\").innerText =\' \';\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="<script> \n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_type_label\").innerText =getLabel(\"Common.OrderType.label\",\"COMMON\");\n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label\").innerText =\' \';\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script> \n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_type_label1\").innerText =getLabel(\"eCA.NoteGroup.label\",\"CA\");\n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label\").innerText =getLabel(\"Common.NoteType.label\",\"COMMON\");\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script> \n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_type_label1\").innerText =getLabel(\"Common.OrderType.label\",\"COMMON\");\n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label\").innerText =getLabel(\"Common.ordercatalog.label\",\"COMMON\");\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<script> \n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_type_label\").innerText =getLabel(\"Common.Future.label\",\"COMMON\")+\" \"+getLabel(\"Common.EventType.label\",\"COMMON\");\n\t\t\t//parent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label\").innerText =getLabel(\"Common.Section.label\",\"CA\");\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<script> \n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_type_label\").innerText =getLabel(\"Common.OrderType.label\",\"COMMON\");\n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label\").innerText =getLabel(\"Common.ordercatalog.label\",\"COMMON\");\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<script> \n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_type_label\").innerText =getLabel(\"Common.diagnosis.label\",\"COMMON\")+\" \"+getLabel(\"Common.Set.label\",\"COMMON\");\n\t\t\t//parent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label1\").innerText =getLabel(\"Common.encounter.label\",\"COMMON\")+\" \"+getLabel(\"Common.Stage.label\",\"COMMON\");\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<script>\n\t\t\tvar element = parent.MultiOrdSelAdd.document.createElement(\'OPTION\');\n\t\t\telement.text = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\telement.value= \"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<script>\n\t\t\tvar element = parent.MultiOrdSelAdd.document.createElement(\'OPTION\');\n\t\t\telement.text = \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t<script>\n\t\t\tvar element = parent.MultiOrdSelAdd.document.createElement(\'OPTION\');\n\t\t\telement.text = getLabel(\"eCA.FutureAppointments.label\",\"CA\");\n\t\t\telement.value= \"FA\";\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type.value=\'FA\';\n\n\t\t\telement = parent.MultiOrdSelAdd.document.createElement(\'OPTION\');\n\t\t\telement.text = getLabel(\"Common.FutureOrders.label\",\"CA\");\n\t\t\telement.value= \"FO\";\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type.value=\'FO\';\n\n\t\t\telement = parent.MultiOrdSelAdd.document.createElement(\'OPTION\');\n\t\t\telement.text = getLabel(\"eCA.FutureReferrals.label\",\"CA\");\n\t\t\telement.value= \"FR\";\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type_comp.add(element);\n\t\t\tparent.MultiOrdSelAdd.document.forms[0].ord_type.value=\'FR\';\n\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<script>\n\t\t\tparent.MultiOrdSelAdd.document.getElementById(\"ord_catlog_label1\").innerText =getLabel(\"Common.encounter.label\",\"COMMON\")+\" \"+getLabel(\"Common.Stage.label\",\"COMMON\");\n\t\t</script>\n\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<script>\n</script>\n<body class=message  OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n</body>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
	String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale			= (String) p.getProperty("LOCALE");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs   = null;
	String sql_query = "", order_type = "", short_desc = "";
	String order_category = request.getParameter("order_category")==null?"":request.getParameter("order_category");
	try
	{


		con = ConnectionManager.getConnection(request);
		
		if(order_category.equals("ALGY"))
		{
		
            _bw.write(_wl_block8Bytes, _wl_block8);

			sql_query="select adv_event_type_code order_type,short_desc short_desc from mr_adv_event_type where eff_status='E' ORDER BY 2";
		}
		else if(order_category.equals("BLTF"))//
		{
			order_type="ALL";
			short_desc ="ALL";
			
            _bw.write(_wl_block9Bytes, _wl_block9);


		}
		else if(order_category.equals("CLNT"))//
		{
			//sql_query="select a.NOTE_TYPE order_type,a.NOTE_TYPE_DESC short_desc from CA_NOTE_TYPE a where eff_status='E' ORDER BY 2";
			sql_query="select a.NOTE_GROUP order_type,a.NOTE_GROUP_DESC short_desc from CA_NOTE_GROUP a where eff_status='E' ORDER BY 2";
		
            _bw.write(_wl_block10Bytes, _wl_block10);

		}
		else if(order_category.equals("RXIN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'RX' and od.LANGUAGE_ID= ?";
		
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(order_category.equals("DIET"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'DS' and od.LANGUAGE_ID= ?";

			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(order_category.equals("FEVT"))//
		{
			order_type="APPOINTMENT";
			short_desc ="APPOINTMENT";

		
            _bw.write(_wl_block12Bytes, _wl_block12);

			
		}
		else if(order_category.equals("LBIN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'LB' and od.LANGUAGE_ID= ?";
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(order_category.equals("MEDN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'PH' and od.LANGUAGE_ID= ?";
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(order_category.equals("RDIN"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'RD' and od.LANGUAGE_ID= ?";
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(order_category.equals("NBDT"))//
		{
			order_type="ALL";
			short_desc ="ALL";
		
            _bw.write(_wl_block13Bytes, _wl_block13);

		}
		else if(order_category.equals("PTCR"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'PC' and od.LANGUAGE_ID= ?";
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(order_category.equals("DIAG"))//
		{
			sql_query="select TERM_SET_ID order_type ,TERM_SET_DESC short_desc from MR_TERM_SET  where EFF_STATUS='E'  ORDER BY 2";
			
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		else if(order_category.equals("SUNT"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'OT' and od.LANGUAGE_ID= ?";
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
		else if(order_category.equals("TRET"))//
		{
			sql_query="select od.ORDER_TYPE_CODE order_type ,od.SHORT_DESC short_desc from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= 'TR' and od.LANGUAGE_ID= ?";
			
            _bw.write(_wl_block11Bytes, _wl_block11);

		}

		//sql_query="select od.ORDER_TYPE_CODE ,od.SHORT_DESC from OR_ORDER_TYPE_LANG_VW od where od.ORDER_CATEGORY= ? and od.LANGUAGE_ID= ? ";
		
		//if(!(order_category.equals("BLTF")||order_category.equals("FEVT")||order_category.equals("NBDT")))
		if((order_category.equals("RXIN")||order_category.equals("DIET")||order_category.equals("LBIN")||order_category.equals("MEDN")||order_category.equals("RDIN")||order_category.equals("PTCR")||order_category.equals("SUNT")||order_category.equals("TRET")||order_category.equals("ALGY")||order_category.equals("CLNT")||order_category.equals("DIAG") ))
		{
			stmt = con.prepareStatement(sql_query);
		}
		//if(!(order_category.equals("ALGY")||order_category.equals("CLNT")||order_category.equals("BLTF")|| order_category.equals("FEVT") || order_category.equals("NBDT")  || order_category.equals("DIAG")|| order_category.equals("DIAG")  ))
		if((order_category.equals("RXIN")||order_category.equals("DIET")||order_category.equals("LBIN")||order_category.equals("MEDN")||order_category.equals("RDIN")||order_category.equals("PTCR")||order_category.equals("SUNT")||order_category.equals("TRET")))
		{
			stmt.setString(1,locale);
		}
		if((order_category.equals("RXIN")||order_category.equals("DIET")||order_category.equals("LBIN")||order_category.equals("MEDN")||order_category.equals("RDIN")||order_category.equals("PTCR")||order_category.equals("SUNT")||order_category.equals("TRET")||order_category.equals("ALGY")||order_category.equals("CLNT")||order_category.equals("DIAG") ))
		{
			
			rs = stmt.executeQuery();

		while(rs.next())
		{
			order_type	= rs.getString("order_type");
			short_desc		= rs.getString("short_desc");
			if((order_type == null) || order_type.equals("null"))order_type="";
			if((short_desc == null) || short_desc.equals("null"))short_desc="";
			
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block17Bytes, _wl_block17);

		}
		
		if(rs != null) rs.close();
		if(stmt != null)stmt.close();
		}
		if(order_category.equals("BLTF")||order_category.equals("NBDT")){
		
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(short_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
		if(order_category.equals("FEVT")){
		
            _bw.write(_wl_block20Bytes, _wl_block20);
}
		if(order_category.equals("DIAG")){
		
            _bw.write(_wl_block21Bytes, _wl_block21);
}

	}
	catch(Exception e)
	{
		//out.println("Exception in main try"+e);//COMMON-ICN-0181
	    e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con, request);
	}
	

            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
