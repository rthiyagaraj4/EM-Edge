package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blsurgeryaddlchargebtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLSurgeryAddlChargeBtn.jsp", 1709114607086L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLSurgeryAddlchargeDtl.js\"></script>\n\t\t</head>\n ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<script>\n\t function putdeci(object)\n\t{\n\tvar decimal=document.forms[0].noofdecimal.value;\n\tif(object.value!=\'\')\n\t{\n\t\tputDecimal(object,17,decimal);\n\t}\n\t\n\t}\n\tfunction total_amt()\n\t{\t    \n\t\tvar tot_disc_amt=0.0;\n\t\tvar cat_tot_disc_amt=0.0;\n\t\tvar tot_net_amt=0.0;\n\t\tvar tot_gross_amt=0.0;\n\t\tvar cat_tot_net_amt=0.0;\n\t\tvar tot_patient_payable=0.00;\n\t\tvar cat_tot_patient_payable=0.00;\n\t\tvar cat_gross_amt=0.00;\n\t\tvar a_disc_amt=new Array();var a_net_amt=new Array();var a_pat_pay=new Array();var a_gross_amt=new Array();\n\t\tvar tot_records=parent.frames[1].document.forms[0].totalRecords.value;\t\t\n\t\t\n\t\tif(tot_records!=0)\n\t\t{\t\t\n\t\t\t\t\t\n\n\t\t\tvar ord_catlog_count=parent.frames[1].document.forms[0].ord_tot_rec.value;\n\t\t\tfor(var i=0;i<ord_catlog_count;i++)\n\t\t\t{\n\t\t\t\tvar order_serv_cnt = eval(\"parent.frames[1].document.forms[0].order_serv_cnt_\"+i);\n\t\t\t\tvar order_serv_cnt_tt = eval(order_serv_cnt.value)+1;\n\t\t\t\tfor(var j=0;j<order_serv_cnt_tt;j++)\n\t\t\t\t{\t\t\n\t\t\t\t\tif(j==0)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar disc_amt = eval(\"parent.frames[1].document.forms[0].disc_amt_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\ta_disc_amt[j]=disc_amt.value;\n\n\t\t\t\t\t\tvar net_amt = eval(\"parent.frames[1].document.forms[0].net_amt_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\ta_net_amt[j]=net_amt.value;\n\n\t\t\t\t\t\tvar pat_pay_amt = eval(\"parent.frames[1].document.forms[0].pat_pay_amt_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\ta_pat_pay[j]=pat_pay_amt.value;\n\n\t\t\t\t\t\tvar gross_amt = eval(\"parent.frames[1].document.forms[0].gross_amt_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\ta_gross_amt[j]=gross_amt.value;\n\n\t\t\t\t\t\tcat_tot_disc_amt=parseFloat(cat_tot_disc_amt)+parseFloat(a_disc_amt[j]);\n\t\t\t\t\t\tcat_tot_net_amt=parseFloat(cat_tot_net_amt)+parseFloat(a_net_amt[j]);\n\t\t\t\t\t\tcat_tot_patient_payable=parseFloat(cat_tot_patient_payable)+parseFloat(a_net_amt[j]);\n\t\t\t\t\t\tcat_gross_amt=parseFloat(cat_gross_amt)+parseFloat(a_gross_amt[j]);\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\n\t\t\t\t\tif(j!=0)\n\t\t\t\t\t{\t\n\t\t\t\t\t\tvar selected_row = eval(\"parent.frames[1].document.forms[0].selected_row_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\tif (selected_row.value==\"Y\")\n\t\t\t\t\t\t{\t\t\t\t\n\t\t\t\t\t\t\tvar disc_amt = eval(\"parent.frames[1].document.forms[0].disc_amt_\"+i+\"_\"+j);\n\t\t\t\t\t\t\ta_disc_amt[j]=disc_amt.value;\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\ttot_disc_amt = parseFloat(tot_disc_amt) + parseFloat(a_disc_amt[j]);\n\n\t\t\t\t\t\t\tvar net_amt = eval(\"parent.frames[1].document.forms[0].net_amt_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\t\ta_net_amt[j]=net_amt.value;\n\t\t\t\t\t\t\ttot_net_amt =  parseFloat(tot_net_amt) + parseFloat(a_net_amt[j]);\n\t\t\n\t\t\t\t\t\t\tvar pat_pay_amt = eval(\"parent.frames[1].document.forms[0].pat_pay_amt_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\t\ta_pat_pay[j]=pat_pay_amt.value;\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\ttot_patient_payable =  parseFloat(tot_patient_payable) + parseFloat(a_pat_pay[j]);\n\n\t\t\t\t\t\t\tvar gross_amt = eval(\"parent.frames[1].document.forms[0].gross_amt_\"+i+\"_\"+j);\t\t\t\t\t\t\n\t\t\t\t\t\t    a_gross_amt[j]=gross_amt.value;\n\t\t\t\t\t\t\ttot_gross_amt = parseFloat(tot_gross_amt) + parseFloat(a_gross_amt[j]);\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\ttot_disc_amt = parseFloat(tot_disc_amt) + parseFloat(cat_tot_disc_amt);\n\t\t\ttot_net_amt = parseFloat(tot_net_amt) + parseFloat(cat_tot_net_amt);\n\t\t\ttot_patient_payable = parseFloat(tot_patient_payable) + parseFloat(cat_tot_patient_payable);\n\n\t\t\ttot_gross_amt = parseFloat(tot_gross_amt) + parseFloat(cat_gross_amt);\n\n\t\t\t\t\t\n\t\t\tparent.frames[1].document.forms[0].disc_amt.value=tot_disc_amt;\n\t\t\tvar temp_disc=eval(\"parent.frames[1].document.forms[0].disc_amt\")\n\t\t\tputdeci(temp_disc);\n\n\t\t\tparent.frames[1].document.forms[0].net_amt.value=tot_net_amt;\n\t\t\tvar temp_net=eval(\"parent.frames[1].document.forms[0].net_amt\")\n\t\t\tputdeci(temp_net);\n\n\t\t\tparent.frames[1].document.forms[0].patient_payable.value=tot_patient_payable;\n\t\t\tvar temp_pat_pay=eval(\"parent.frames[1].document.forms[0].patient_payable\")\n\t\t\tputdeci(temp_pat_pay);\n\n\t\t\tparent.frames[1].document.forms[0].gross_amt.value=tot_gross_amt;\n\t\t\tvar temp_gross_amt=eval(\"parent.frames[1].document.forms[0].gross_amt\")\n\t\t\tputdeci(temp_gross_amt);\n\t\t}\n\t}\nfunction submit_val()\n\t{\n\t\tvar tot_records=parent.frames[1].document.forms[0].totalRecords.value;\n\t\tif(tot_records!=0)\n\t\t{\n\t\t\tvar ord_catlog_count=parent.frames[1].document.forms[0].ord_tot_rec.value;\n\t\t\tvar a_serv_code = new Array();\n\t\t\tvar order_serv_cnt_t = new Array();\n\t\t\tvar a_order_cat_code = new Array();\n\t\t\tvar a_selected_row = new Array();\n\t\t\tvar a_pract_id = new Array();\n\t\t\tvar a_cat_pract_id = new Array();\n\t\t\tfor(var i=0;i<ord_catlog_count;i++)\n\t\t\t{\n\t\t\t   var order_serv_cnt = eval(\"parent.frames[1].document.forms[0].order_serv_cnt_\"+i);\n\t\t\t\tvar order_serv_cnt_tt = eval(order_serv_cnt.value)+1;\n\t\t\t\t//var order_serv_cnt_tt = eval(order_serv_cnt.value);\n\t\t\t\t\t\n\t\t\t\tfor(var j=0;j<order_serv_cnt_tt;j++)\n\t\t\t\t{\t\t\n\t\t\t\t\t/*if(j==0)\n\t\t\t\t\t{\n\t\t\t\t\t\tvar cat_pract_id = eval(\"parent.frames[1].document.forms[0].pract_name_\"+i+\"_\"+j);\n\t\t\t\t\t\ta_cat_pract_id = cat_pract_id.value;\n\t\t\t\t\t\t\n\t\t\t\t\t\tif(cat_pract_id.value==\"\")\n\t\t\t\t\t\t{\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\talert(getMessage(\'BL9889\',\'BL\'));\t\t\t\n\t\t\t\t\t\t\treturn;\n\t\t\t\t\t\t}\n\t\t\t\t\t}  */\n\t\t\t\t//\tif(j!=0)\n\t\t\t\t//\t{\n\t\t\t\t\t\tvar blng_serv_code = eval(\"parent.frames[1].document.forms[0].blng_serv_code_\"+i+\"_\"+j);\n\t\t\t\t\t\ta_serv_code = blng_serv_code.value;\n\t\t\t\t\t\tvar selected_row = eval(\"parent.frames[1].document.forms[0].selected_row_\"+i+\"_\"+j);\n\t\t\t\t\t\tif (selected_row.value==\"Y\")\n\t\t\t\t\t\t{\n\t\t\t\t\t\t\tvar pract_id = eval(\"parent.frames[1].document.forms[0].pract_name_\"+i+\"_\"+j);\n\t\t\t\t\t\t\ta_pract_id = pract_id.value;\t\n\t\t\t\t\t\t\tif(pract_id.value==\"\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\talert(getMessage(\'BL9889\',\'BL\'));\t\n\t\t\t\t\t\t\t\treturn false;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t}\n\t\t\t\t//\t}\n\t\t\t\t}\n\t\t\t}\n\t\t\tparent.frames[1].document.forms[0].action=\"../../eBL/jsp/BLAddlSurgerySubmit.jsp\";\n\t\t\tparent.frames[1].document.forms[0].submit();\t\t\t\t\t\n\t\t}\n\t}\n\t\tfunction close_view_window()\n\t\t{\n\t\t\tparent.window.close();\n\t\t}\n</script>\n<body onLoad=\'total_amt()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form>\n\t<!--<table cellpadding=3 cellspacing=0  width=\"100%\">\n\t\t\t<tr>\n\t\t\t<td width=\'6%\'  class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'16%\'  class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'8%\'  class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'16%\'  class=\'label\'><div align=\'right\'><b>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</b></div></td>\n\t\t\t<td width=\'8%\' class=\'fields\'><input type=\'text\' name=\'gross_amt\' id=\'gross_amt\' size=\'10\' maxlength=\'30\' \n\t\t\tvalue=\'\' readonly style=\'text-align:right\' ></td>\n\t\t\t <td width=\'8%\'  class=\'label\'>&nbsp;</td>\n\t\t\t<td width=\'8%\' class=\"fields\"><input type=\'text\' name=\'disc_amt\' id=\'disc_amt\' size=\'10\' maxlength=\'30\' \n\t\t\tvalue=\'\' readonly style=\'text-align:right\' ></td>\n\t\t\t\t\n\t\t\t<td width=\'8%\' class=\"fields\">\t<input type=\'text\' name=\'net_amt\' id=\'net_amt\' size=\'10\'  maxlength=\'30\' value=\'\' readonly \t\t\tstyle=\'text-align:right\'></td>\n\n\t\t\t<td width=\'8%\' class=\"fields\"><input type=\'text\' name=\'patient_payable\' id=\'patient_payable\' size=\'10\'  maxlength=\'30\' value=\'\' readonly style=\'text-align:right\'></td>\n\n\t\t\t <td width=\'14%\'  class=\'label\'>&nbsp;</td>\n\t\n\t\t\t</tr>\t\n  </table>-->\n<table cellpadding=3 cellspacing=0  width=\"100%\">\n<tr>\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t <td width=\"25%\"  class=\'labels\'>&nbsp;</td>\n\t <td width=\"25%\"  class=\'labels\'>&nbsp;</td>\n\t <td width=\"25%\"  class=\'labels\'>&nbsp;</td>\n\t<td width=\"25%\"  class=\'labels\'><INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"    ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" onClick=\'submit_val()\' >\n\t<input type=\'button\'  name=\"cancel_button\" id=\"cancel_button\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" class=\'button\' onClick=\'close_window()\'></td>\t\t\n\t</td>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n     <td width=\"25%\"  class=\'labels\'>&nbsp;</td>\n\t <td width=\"25%\"  class=\'labels\'>&nbsp;</td>\n\t <td width=\"25%\"  class=\'labels\'>&nbsp;</td>\n\t<td width=\"25%\"  class=\'labels\'><INPUT TYPE=\"button\"  class=\"BUTTON\" VALUE=\"    ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onClick=\'close_view_window()\' >\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</tr>\n</table>\n\t\t<input type=\'hidden\' name=\'noofdecimal\' id=\'noofdecimal\' value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" >\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	Connection con = null; 
	PreparedStatement pstmt = null;
	ResultSet rscurr=null;
	try
	{
		//HttpSession httpSession = request.getSession(false);
		//Properties p = (Properties)httpSession.getValue("jdbc");	
		//String locale	= (String)session.getAttribute("LOCALE");
		con	=	ConnectionManager.getConnection(request);	

		String function_id = request.getParameter("function_id");
			if(function_id == null) function_id="EDIT";

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		int noofdecimal=2;
		try
		{		
			pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rscurr = pstmt.executeQuery();	
			while(rscurr.next())
			{
				noofdecimal  =  rscurr.getInt(1);		
			}
			rscurr.close();
			pstmt.close();
		}
		catch(Exception e)
		{
			System.out.println("rscurr="+e.toString());
		}

            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
    if(function_id.equals("EDIT"))
		{

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	else{

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);

	}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}
	catch(Exception e) 
	{
		System.out.println("btn="+e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con, request);
	}		

            _bw.write(_wl_block16Bytes, _wl_block16);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
}
