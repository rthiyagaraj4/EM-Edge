package jsp_servlet._eca._jsp;

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

public final class __viewauditlogresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewAuditLogResult.jsp", 1733816052511L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n\t<script>\n\t/*function alignWidth()\n\t{\n\t\tvar totalRows =  document.getElementById(\"dataTable\").rows.length;\n\t\tvar counter = totalRows-1;\n\t\tvar temp = document.getElementById(\"dataTitleTable\").rows(0).cells.length;\n\t\tfor(var i=0;i<temp;i++)\n\t\t{\n\t\t\tdocument.getElementById(\"dataTitleTable\").rows(0).cells(i).width=document.getElementById(\"dataTable\").rows(counter).cells(i).offsetWidth;\n\t\t}\n\t}*/\n</script>\n\t\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\n\t\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<script language=\'javascript\' src=\'../js/procedures.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\n<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onScroll=\'scrollTitle()\'>\n\t<form name=\'result_form\' id=\'result_form\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<div id=\'divDataTitle\' style=\'postion:relative\'>\n\t\t\t\t<table border=\'1\' width=\'100%\' id=\'dataTitleTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#ffffff\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'30%\'><font size=1>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'35%\'><font size=1>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" <font size=1>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t<td class=\'COLUMNHEADERCENTER\' width=\'35%\'><font size=1><font size=1>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<table class=\'grid\' border=\'1\' width=\'100%\' id=\'dataTable\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' style=\"border-bottom:#000000\">\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class =\'CAGROUP\' colspan=\'3\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" : ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\'30%\' style=\'word-wrap:break-word\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t<td class=\'gridData\' width=\'35%\' style=\'word-wrap:break-word\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t</tr>\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'gridData\' width=\'30%\' style=\'word-wrap:break-word\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t</table>\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t</form>\n\t<script>//setTimeout(\'alignWidth()\',500);</script>\n</body>\n</html>\n\n";
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

	String Encounter_Id     = request.getParameter("Encounter_Id");				
	String srl_no			= request.getParameter("srl_no");				
	String facility_id		= (String) session.getValue("facility_id");
	
	java.util.Properties p	= (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	
	Connection con = null;
	PreparedStatement stmt = null, pstmt = null;
	ResultSet rs = null, rs1 = null;

	String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try
	{
        con = ConnectionManager.getConnection(request);

		String trans_key = facility_id+"$"+Encounter_Id+"$"+srl_no;
		String prev_modified_date = "";
		String prev_user_name = "";
		String user_name = "";
		String modified_date = "";
		String label_ref = "";
		String column_name = "";
		String ind = "";
		String old_val = "";
		String new_val = "";
		String desc_query = "";

		String sql="SELECT sm_get_desc.sm_appl_user(a.modified_by_id,?,'1') Modified_user_name, to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modifed_date_str, c.column_name, c.label_ref,  b.old_val ,  b.new_val FROM ca_audit_log_trn_hdr a, ca_audit_log_trn_dtl b, ca_audit_log_criteria c WHERE a.trans_key = ? and a.AUDIT_REF_NUMBER = b.AUDIT_REF_NUMBER and b.modi_col_ref = c.column_name order by a.modified_date desc, c.column_order ";

		
		

		stmt = con.prepareStatement(sql);
		stmt.setString(1, locale);
		stmt.setString(2, trans_key);
		rs = stmt.executeQuery();

		if(rs != null)
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

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			while(rs.next())
			{
				user_name = rs.getString(1)== null ? "" : rs.getString(1);
				modified_date = rs.getString(2)== null ? "" : rs.getString(2);
				column_name = rs.getString(3)== null ? "" : rs.getString(3);
				label_ref = rs.getString(4)== null ? "" : rs.getString(4);
				old_val = rs.getString(5)== null ? "" : rs.getString(5);
				new_val = rs.getString(6)== null ? "" : rs.getString(6);

				if(column_name.equals("ASS_PRACTITIONER1") || column_name.equals("ANAESTHETIST1"))
				{
					ind = "1";
				}
				else if(column_name.equals("ASS_PRACTITIONER2") || column_name.equals("ANAESTHETIST2"))
				{
					ind = "2";
				}
				else if(column_name.equals("ASS_PRACTITIONER3") || column_name.equals("ANAESTHETIST3"))
				{
					ind = "3";
				}
				else
					ind = "";

				if(!label_ref.equals(""))
				{
					if(label_ref.startsWith("eCA"))
					{
						label_ref = com.ehis.util.BundleMessage.getBundleMessage(pageContext,label_ref,"common_labels");
					}
					else if(label_ref.startsWith("Common"))
					{
						label_ref = com.ehis.util.BundleMessage.getBundleMessage(pageContext,label_ref,"common_labels");
					}
					label_ref = label_ref+ind;
				}

				if(column_name.equals("LATERALITY_IND"))
				{
					if(!old_val.equals(""))
					{
						if(old_val.equals("L"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
						else if(old_val.equals("R"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Right.label","ca_labels");
						else if(old_val.equals("B"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
						else if(old_val.equals("N"))
							old_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else
							old_val = "";
					}
					if(!new_val.equals(""))
					{
						if(new_val.equals("L"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Left.label","common_labels");
						else if(new_val.equals("R"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Right.label","ca_labels");
						else if(new_val.equals("B"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
						else if(new_val.equals("N"))
							new_val = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
						else
							new_val = "";
					}
				}
				
				if(column_name.equals("PROC_PERF_LOCN_CODE"))
				{
					desc_query = "select OP_GET_DESC.OP_CLINIC(?,?,?,'2') locn_desc from dual";

					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,old_val);
						pstmt.setString(3,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,new_val);
						pstmt.setString(3,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}
				
				if(column_name.startsWith("ASS_PRACTITIONER"))
				{
					desc_query = "select AM_GET_DESC.AM_PRACTITIONER(?,?,'1') from dual";
					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,old_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,new_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}

				if(column_name.startsWith("ANAESTHETIST") || column_name.equals("SCRUB_NURSE"))
				{
					desc_query = "Select b.practitioner_name from am_pract_for_facility A, AM_PRACTITIONER_LANG_VW B where a.facility_id= ? and a.eff_status='E' and b.pract_type = ? and a.practitioner_id = b.practitioner_id and b.practitioner_id = ? and b.language_id = ? ";

					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						if(column_name.startsWith("ANAESTHETIST"))
							pstmt.setString(2,"AN");
						else if(column_name.equals("SCRUB_NURSE"))
							pstmt.setString(2,"NS");
						pstmt.setString(3,old_val);
						pstmt.setString(4,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,facility_id);
						if(column_name.startsWith("ANAESTHETIST"))
							pstmt.setString(2,"AN");
						else if(column_name.equals("SCRUB_NURSE"))
							pstmt.setString(2,"NS");
						pstmt.setString(3,new_val);
						pstmt.setString(4,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}
				
				if(column_name.equals("ANAESTHESIA_CODE"))
				{
					desc_query = "Select AM_GET_DESC.AM_ANAESTHESIA(?,?,'1') from dual";
					if(!old_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,old_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								old_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
					if(!new_val.equals(""))
					{
						pstmt = con.prepareStatement(desc_query);
						pstmt.setString(1,new_val);
						pstmt.setString(2,locale);

						rs1 = pstmt.executeQuery();

						if(rs1 != null)
						{
							if(rs1.next())
								new_val = rs1.getString(1) == null ? "" : rs1.getString(1);
						}
						if(rs1 != null) rs1.close();
						if(pstmt != null) pstmt.close();
					}
				}

				if(old_val.equals(""))
					old_val = "&nbsp;";
				if(new_val.equals(""))
					new_val = "&nbsp;";

				if(!prev_user_name.equals(user_name) || !prev_modified_date.equals(modified_date))
				{
	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(modified_date));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(label_ref));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(old_val));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(new_val));
            _bw.write(_wl_block18Bytes, _wl_block18);

					prev_user_name = user_name;
					prev_modified_date = modified_date;
				}
				else
				{
	
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(label_ref));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(old_val));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(new_val));
            _bw.write(_wl_block18Bytes, _wl_block18);

				}
			}
	
            _bw.write(_wl_block20Bytes, _wl_block20);

		}
		if(rs!=null)    rs.close();
		if(stmt!=null)  stmt.close();
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{
	   if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block21Bytes, _wl_block21);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Field.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Modified.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Value.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.user.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
