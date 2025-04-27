package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfindetails8 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinDetails8.jsp", 1709114330745L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<!-- The following changes are done for Internationalisation Process\nAdded by Manivel Natarajan on 10/Aug/2006\n-->\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n  ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<html>\n  \t<head>\n\t<!--\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>\n\t\t-->\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- The following changes are done for Internationalisation Process\nCommented by Manivel Natarajan on 10/Aug/2006 -->\n<!--\t\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script> -->\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t\t<script language=\'javascript\' src=\'../js/AddModifyPatFinDetails.js\'></script>\n            <script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\n\n\t\t\t<script language=\'javascript\'>\n\t\t\t<!--\n\t\t\t\n\t\t\tfunction showCalendar_loc(Val1, Val2)\n\t\t\t{\t\n\t\t\t\tif (Val2.disabled == true)\t\t\n\t\t\t\t{\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\treturn showCalendar(Val1);\n\t\t\t\t}\n\t\t\t}\n\n\t\t\t//-->\n\t\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n  \t</head>\n  ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<body onLoad=\'disableAllElements()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<body onLoad=\'disableMappingItems()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\"> \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<form name=\'PatFinCase4.1Form\' id=\'PatFinCase4.1Form\' method=\'post\' action=\'\'  scrolling=no >\n<!-- The following changes are done for Internationalisation Process\nCellpadding changed from 1 to 3 & align is removed by Manivel Natarajan on 10/Aug/2006 -->\n\t<table align=\'center\' border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\'>\n\t\n\t<tr>\n<!--\n\t\t\t<td width=\"\" align=\"right\" class=\"label\">Instrument Ref</td>\n-->\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n<!--\n\t\t\t<td width=\"\" align=\"left\" colspan=\'2\'>&nbsp;<input type=\'text\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' size=\'15\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<!--\n\t\t\t<td width=\"\" align=\"left\" colspan=\'2\'>&nbsp;<input type=\'text\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' size=\'15\' maxlength=\'20\'>&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'></td>\n-->\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'cash_insmt_ref2\' id=\'cash_insmt_ref2\' size=\'20\' maxlength=\'20\'><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n<!--\t\t<td width=\"\" align=\"right\" class=\"label\">Instrument Date</td> -->\n\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<!--\t\t<td width=\"\" align=\"left\" colspan=\'2\'> -->\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' size=\'15\' maxlength=\'15\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'onBlur=\'return CheckDate(this);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'cash_insmt_date2\',document.forms[0].cash_insmt_date2);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n<!--\t\t<td width=\"\" align=\"left\" colspan=\'2\'> -->\n\t\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'cash_insmt_date2\' id=\'cash_insmt_date2\' size=\'15\' maxlength=\'15\' onBlur=\'return CheckDate(this);\'><img src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar_loc(\'cash_insmt_date2\',document.forms[0].cash_insmt_date2);\"><img src=\'../../eCommon/images/mandatory.gif\'></td>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t</tr>\n<!--\n\t\t</tr>\n\t\t<tr> -->\n\t\t<tr>\n<!--\t\t\t<td width=\"\" align=\"right\" class=\"label\">Instrument Remarks</td> -->\n\t\t\t\t<td width=\"25%\" class=\"label\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n<!--\t\t<td width=\"\" align=\"left\" colspan=6>&nbsp;<input type=\'text\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'></td> -->\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'></td>\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n<!--\t\t<td width=\"\" align=\"left\" colspan=6>&nbsp;<input type=\'text\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' size=\'20\' maxlength=\'20\'></td> -->\n\t\t\t<td width=\"25%\" class=\'fields\' ><input type=\'text\' name=\'cash_insmt_rmks2\' id=\'cash_insmt_rmks2\' size=\'20\' \tmaxlength=\'20\'></td>\n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<td width=\"25%\" class=\"label\"></td>\n\t\t<td width=\"25%\" class=\"label\"></td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<!-- The following changes are done for Internationalisation Process\nblank row removed by Manivel Natarajan on 10/Aug/2006 -->\n<!--\n\t<tr>\n\t\t<td colspan=15>&nbsp;</td></tr>\n\t\t\t<tr>\n\t\t<td colspan=15>&nbsp;</td></tr>\n\t\t\t<tr>\n\t\t<td colspan=15>&nbsp;</td></tr>\n-->\n\t<tr>\n\t\t<td colspan=15>&nbsp;</td>\n\t</tr>\n\t\n\t<tr>\n\t\t<td colspan=15>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=15>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=15>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=15>&nbsp;</td>\n\t</tr>\n\t</table>\t\n\t<input type=hidden name=\"bl_data_from_repos_yn\" id=\"bl_data_from_repos_yn\" value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\t\n\t<input type=hidden name=\"items_disabled\" id=\"items_disabled\" value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\t\n\t<input type=hidden name=\"calling_module_id\" id=\"calling_module_id\" value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\t\n\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\n\t</body>\n\t</form>\n\t</html>\n\t\t\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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

	    Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	//The following changes are done for Internationalisation Process
	//Added by Manivel Natarajan on 10/Aug/2006
		request.setCharacterEncoding("UTF-8");
  	try
  	{
		
		//con = (Connection) session.getValue("connection" );
		con	=	ConnectionManager.getConnection(request);
		//unused variable, commented on 09/06/05
		//String nd_settlement_ind ="";
		//String nd_adm_rec_flag ="";
		String /*slmt_type_code="",*/ cash_slmt_flag="" /*, cust_code1=""*/;
//		System.out.println("Inside 8:"+(String)request.getParameter("billing_group"));
		String mcash_insmt_ref2="",mcash_insmt_date2="",mcash_insmt_rmks2="";
		String cash_set_type2= request.getParameter("cash_set_type2");
		if( cash_set_type2 == null) cash_set_type2="";
		String billing_mode = request.getParameter("billing_mode");
		if(billing_mode==null) billing_mode = "Add";
		String operation = request.getParameter("operation");
		if(operation==null) operation = "Insert";

		String  payerGrpBySetup= request.getParameter("payerGrpBySetup");
			if(payerGrpBySetup==null ) payerGrpBySetup = "";	

		String sel_frm_prev_enc=request.getParameter("sel_frm_prev_enc");
		if(sel_frm_prev_enc==null || sel_frm_prev_enc.equals("")) sel_frm_prev_enc = "N";

		String strRepositoryYN =	request.getParameter("bl_data_from_repos_yn");
		String strItemsDisabled = request.getParameter("items_disabled");
		String strModuleId = request.getParameter("calling_module_id");

		if (strRepositoryYN == null)
		{
			strRepositoryYN = "";
		}

		if (strItemsDisabled ==null)
		{
			strItemsDisabled = "";		
		}
		if (strModuleId ==null)
		{
			strModuleId = "";		
		}	
		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
			mcash_insmt_ref2 = request.getParameter("cash_insmt_ref2");
			mcash_insmt_date2 = request.getParameter("cash_insmt_date2");
			mcash_insmt_rmks2 = request.getParameter("cash_insmt_rmks2");
		}

	//	out.println("blng_grp_id in jsp4"+blng_grp_id);

		String query_cash_slmt_type="Select cash_slmt_flag from bl_slmt_type where slmt_type_code='"+cash_set_type2+"'";

		
		stmt=con.createStatement();
		rs=stmt.executeQuery(query_cash_slmt_type);
		if(rs != null)
		{
			while(rs.next())
			{
				cash_slmt_flag=rs.getString("cash_slmt_flag");
			}
		}
		if(rs != null) rs.close();
		
	
		//if(nd_settlement_ind.equals("C") && nd_adm_rec_flag.equals("0") && (!(cash_slmt_flag.equals("C"))))
		//	{
		//		out.println("cash_slmt_flag"+cash_slmt_flag);
		//	}
		
            _bw.write(_wl_block7Bytes, _wl_block7);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


if(operation.equals("Update"))
{

	if(!("Y").equalsIgnoreCase(payerGrpBySetup)){
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	}
	else{
	
            _bw.write(_wl_block11Bytes, _wl_block11);

	}

}
else if (strRepositoryYN.equals("Y") && strModuleId.equals("MP") )
{

            _bw.write(_wl_block12Bytes, _wl_block12);

}
else
{
	

            _bw.write(_wl_block13Bytes, _wl_block13);

}


            _bw.write(_wl_block14Bytes, _wl_block14);

	if(!(cash_slmt_flag.equals("Y")))
	{
	
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
		
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mcash_insmt_ref2));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(mcash_insmt_ref2));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}
		else
		{
		
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mcash_insmt_date2));
            _bw.write(_wl_block23Bytes, _wl_block23);

		}
		else
		{
		
            _bw.write(_wl_block24Bytes, _wl_block24);

		}
		
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

		if((billing_mode.equals("Modify")) || (operation.equals("Update")))
		{
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(mcash_insmt_rmks2));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(mcash_insmt_rmks2));
            _bw.write(_wl_block28Bytes, _wl_block28);

		}
		else
		{
		
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
		
            _bw.write(_wl_block30Bytes, _wl_block30);

		}
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(strRepositoryYN));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strItemsDisabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(strModuleId));
            _bw.write(_wl_block34Bytes, _wl_block34);
  } 
	catch(Exception e )
	{ 
		out.println(e);
	}
	finally
	{
		if(stmt != null) stmt.close();
		ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INSTR_REF.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INSTR_DATE.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INSTR_REMARK.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
