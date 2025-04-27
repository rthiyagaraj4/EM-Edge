package jsp_servlet._eoh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import eOH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __ohdiaglinkedconditions extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoh/jsp/OHDiagLinkedConditions.jsp", 1709119348833L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n\t<head>\n        <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\t\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n  <body OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n  <form name=\"OHDiagLinkedConditions\" id=\"OHDiagLinkedConditions\"   method=\"post\" target=\"messageFrame\">\n      <table align=\'center\' cellpadding=\'3\' cellspacing=\'0\' border=\'1\' width=\'100%\'>\n             ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td width=\"10%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t\t<td width=\"10%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t<td width=\"10%\" align=\'left\' class=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</table>\n             <table align=\'center\' cellpadding=\'3\' cellspacing=\'0\' border=\'0\' width=\'100%\'>\n\t\t\t\t\t <tr>\n\t\t\t\t\t    <td width=\"15%\" colspan=\"2\" class=\"button\"><input type=\"button\" class=\"button\" name=\"close\" id=\"close\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' onclick=\"parent.window.close();\"> \n\t\t\t\t\t</td></tr>\n\t\t   </table>\n\t\t</form>\n </body> </html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String facility_id = "";
		String encounter_id = "";
		String chart_num = "";

        String locale = (String)session.getAttribute("LOCALE"); 
		String patient_id = checkForNull(request.getParameter("patient_id"));
	    String tooth_numbering_system = checkForNull(request.getParameter("tooth_numbering_system"));
		String accession_num = checkForNull(request.getParameter("accession_num"));
		String term_code = checkForNull(request.getParameter("term_code"));
		String term_set_id = checkForNull(request.getParameter("term_set_id"));

		StringTokenizer accession_num_token = new StringTokenizer(accession_num,"||");
		while(accession_num_token.hasMoreTokens()){
			facility_id		=accession_num_token.nextToken();
			encounter_id	=accession_num_token.nextToken();
			chart_num	=accession_num_token.nextToken();
		}
		
		String site_type = "";
		String area = "";
		String surface_desc = "";
	    String condition_type = "";
		String condition_desc = "";
		String site_type_desc = "";
		int row_count = 0;
		String classValue = "";
		
		//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
		String oh_chart_level = "";
		//

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	try{
			con=ConnectionManager.getConnection(request);
            if(tooth_numbering_system.equals("")){
				//Added by Sharon Crasta on 7/28/2009 for IN009739(SRR20056-CRF-0457)
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			
				pstmt = con.prepareStatement("SELECT CHART_LEVEL FROM OH_PARAM");
				rs = pstmt.executeQuery();
				while (rs != null && rs.next()){
					oh_chart_level = checkForNull(rs.getString("CHART_LEVEL"));
				}

				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(oh_chart_level.equals("E")){
				    pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM");
				}else{//End
					pstmt=con.prepareStatement("SELECT TOOTH_NUMBERING_SYSTEM FROM OH_PARAM_FOR_FACILITY WHERE FACILITY_ID = ?");
					pstmt.setString(1,facility_id);
				}
				rs=pstmt.executeQuery();
				while(rs.next()){
					tooth_numbering_system = checkForNull(rs.getString("tooth_numbering_system"));
				}
			}


            _bw.write(_wl_block7Bytes, _wl_block7);

                            if(rs != null) rs.close();
							if(pstmt != null) pstmt.close();
                           
							//pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC FROM OH_RESTORATIVE_CHART_DTL A,  OH_DIAG_COND_LINK E WHERE A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CONDITION_CODE = E.CONDITION_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' ORDER BY A.CONDITION_TYPE");
							pstmt=con.prepareStatement("SELECT A.CONDITION_TYPE, (SELECT F.CONDITION_TYPE_DESC FROM OH_CONDITION_TYPE_LANG_VW F WHERE A.CONDITION_TYPE = F.CONDITION_TYPE AND F.LANGUAGE_ID = ?) CONDITION_TYPE_DESC, A.SITE_TYPE, (SELECT G.SITE_DESC FROM OH_SITE_TYPE_LANG_VW G WHERE G.SITE_TYPE = A.SITE_TYPE AND LANGUAGE_ID = ?) SITE_TYPE_DESC,(SELECT K.NS_TOOTH_NO FROM OH_TOOTH_BY_NUMBERING_SYSTEM K WHERE K.TOOTH_NO = A.TOOTH_NO AND K.NUMBERING_SYSTEM = ?) TOOTH_NO, (SELECT C.ARCH_DESC FROM OH_ARCH_LANG_VW C WHERE C.ARCH_ID=A.ARCH_SNO AND C.LANGUAGE_ID = ? AND NUMBERING_SYSTEM = ?) ARCH_DESC, (SELECT D.QUADRANT_DESC FROM OH_QUADRANT_LANG_VW D WHERE D.QUADRANT_SNO=A.QUADRANT_SNO AND D.LANGUAGE_ID = ? AND D.NUMBERING_SYSTEM = ? AND ROWNUM = '1') QUADRANT_DESC, (SELECT L.SURFACE_NAME FROM OH_SURFACE_LANG_VW L WHERE L.SURFACE_CODE = A.SURFACE_CODE AND L.LANGUAGE_ID = ?) SURFACE_NAME, (SELECT B.CONDITION_DESC FROM OH_CONDITION_LANG_VW B WHERE A.CONDITION_CODE = B.CONDITION_CODE AND B.LANGUAGE_ID = ?) CONDITION_DESC FROM OH_RESTORATIVE_CHART_DTL A,  OH_DIAG_COND_LINK E WHERE A.PATIENT_ID = E.PATIENT_ID AND A.CHART_NUM = E.CHART_NUM AND A.CHART_LINE_NUM = E.CHART_LINE_NUM AND A.CONDITION_CODE = E.CONDITION_CODE AND A.OPERATING_FACILITY_ID = ? AND A.PATIENT_ID = ? AND A.CHART_NUM = ? AND A.TREATMENT_CONDITION = 'C' AND E.TERM_CODE = ? AND E.TERM_SET_ID = ? AND NVL(A.STATUS,'X') != 'E' ORDER BY A.CONDITION_TYPE");
						
							pstmt.setString(1,locale);//LANGUAGE_ID
			                pstmt.setString(2,locale);//LANGUAGE_ID
							pstmt.setString(3,tooth_numbering_system);//NUMBERING_SYSTEM
							pstmt.setString(4,locale);//LANGUAGE_ID
							pstmt.setString(5,tooth_numbering_system);//NUMBERING_SYSTEM
							pstmt.setString(6,locale);//LANGUAGE_ID
							pstmt.setString(7,tooth_numbering_system);//LANGUAGE_ID
							pstmt.setString(8,locale);//LANGUAGE_ID
							pstmt.setString(9,locale);//LANGUAGE_ID
							pstmt.setString(10,facility_id);//OPERATING_FACILITY_ID
							pstmt.setString(11,patient_id);//PATIENT_ID
							pstmt.setString(12,chart_num);//CHART_NUM
							pstmt.setString(13,term_code);//CHART_NUM
							pstmt.setString(14,term_set_id);//CHART_NUM
						    rs=pstmt.executeQuery();
							while(rs.next()){
								row_count++;
								condition_type = checkForNull(rs.getString("CONDITION_TYPE"));
					            condition_desc = checkForNull(rs.getString("CONDITION_DESC"));
								site_type_desc = checkForNull(rs.getString("SITE_TYPE_DESC"));
								site_type = checkForNull(rs.getString("SITE_TYPE"));
                               
								if(site_type.equals("ARCH")){
									area = checkForNull(rs.getString("ARCH_DESC"));
								}
								else if(site_type.equals("QUAD")){
									area = checkForNull(rs.getString("QUADRANT_DESC"));
								}
								else{
									area = checkForNull(rs.getString("TOOTH_NO"));
								}

								surface_desc = checkForNull(rs.getString("SURFACE_NAME"));

								if ( row_count % 2 == 0 )
                                         classValue = "QRYEVEN" ;
                               else
				                    	classValue = "QRYODD" ;

                             
						
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(checkForNull(rs.getString("CONDITION_TYPE_DESC"))));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(condition_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(site_type_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(area));
            _bw.write(_wl_block11Bytes, _wl_block11);

										if(surface_desc.equals("")){
									
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block13Bytes, _wl_block13);

										}else{
									
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(surface_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

										}
									
            _bw.write(_wl_block14Bytes, _wl_block14);

							}
						
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

   }catch ( Exception e ) {
			   e.printStackTrace() ;
    }finally {
	        try{
		         if(rs!=null) rs.close();
		         if(pstmt!=null) pstmt.close();
		          if(con!=null) 
			            ConnectionManager.returnConnection(con,request);
	                 }catch(Exception es){es.printStackTrace();}
      }
 
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
