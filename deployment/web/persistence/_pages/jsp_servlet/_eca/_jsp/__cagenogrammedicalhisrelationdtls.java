package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __cagenogrammedicalhisrelationdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAGenogramMedicalHisRelationDtls.jsp", 1709115527919L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n<html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCA/js/CAPatientGenogram.js\"></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\" ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style>\n\t\t.gridData1\n\t\t{\n\t\t\tbackground-color: #FFFFFF;\n\t\t\theight:18px;\n\t\t\tfont-family: Verdana, Arial, Helvetica, sans-serif;\n\t\t\tfont-size: 8pt;\n\t\t\tcolor: #000000;\n\t\t\tfont-weight:normal;\n\t\t\ttext-align:center;\n\t\t\tpadding-left:10px;\n\t\t\tpadding-right:10px;\n\t\t\tvertical-align:middle;\n\t\t\tborder-bottom:1px;\n\t\t\tborder-top:0px;\n\t\t\tborder-left:0px;\n\t\t\tborder-right:0px;\n\t\t\tborder-style:solid;\n\t\t\tborder-color:#EEEEEE;\n\t\t}\n\t</style>\n</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\'genogramMedicalHisRelationDtlsFrm\' id=\'genogramMedicalHisRelationDtlsFrm\'>\n\t<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" align=center>\n\t\t<tr height=\"100%\">\n\t\t\t<td>\t\t\t\t\n\t\t\t\t<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" align=center>\t\t\t\t\t\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td class=\'columnHeadercenter\'>Medical History</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<DIV style=\"width:100%;height:160;border:1px solid red;overflow:auto\">\n\t\t\t\t\t\t\t\t<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" id=\"displayTable\" align=center>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<th class=\'columnHeadercenter\'  width=\"20%\">Medical History Type</th>\n\t\t\t\t\t\t\t\t\t\t<!-- <th class=\'columnHeadercenter\'   width=\"20%\">Relationship </th> -->\n\t\t\t\t\t\t\t\t\t\t<th class=\'columnHeadercenter\'  width=\"40%\">Remarks </th>\n\t\t\t\t\t\t\t\t\t\t<th class=\'columnHeadercenter\'  width=\"10%\">Select </th>\n\t\t\t\t\t\t\t\t\t</tr>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t<tr bgcolor=\"#FF0000\"  >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="1\' ><input type=\"checkbox\" name=\"selectRelation";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"selectRelation";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></td>\n\t\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"totalRelations\" id=\"totalRelations\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</DIV>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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

/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
19/09/2013	IN043568		Ramesh G		Add Medical History In Remarks there is no wrapping of text entered
--------------------------------------------------------------------------------------------------------------------
*/

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
            _bw.write(_wl_block5Bytes, _wl_block5);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String fromRelationId = request.getParameter("fromRelationId")==null?"":request.getParameter("fromRelationId");
	String toRelationId = request.getParameter("toRelationId")==null?"":request.getParameter("toRelationId");
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE"); 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

										Connection			con			=	null;
										PreparedStatement	pstmt		=	null;
										ResultSet			rs			=	null;
										String 				query		=	null;
										int count =0;
										try{
											con				=	ConnectionManager.getConnection(request);

											query	=	"select a.reltn_id reltn_id, a.reltn_desc RELTN_TYPE_DESC,b.relation_remarks relation_remarks  FROM ca_geno_reltn_mast a, ca_genogram_relation b  WHERE a.reltn_type_id = b.relation_type_id AND a.reltn_id = b.relation_id AND b.relation_type_id ='MH'  AND b.from_genoid = ? ";
											System.out.println("CAGenogramSEIRelationDtls.jsp====query======>"+query);
											System.out.println("CAGenogramSEIRelationDtls.jsp====fromRelationId======>"+fromRelationId);
											
											pstmt			=	con.prepareStatement(query);
											pstmt.setString(1,fromRelationId);
											rs				=	pstmt.executeQuery();
											String className="gridData";
											String tempValue=""; //IN043568
											while(rs.next()){												
											
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(className));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("RELTN_TYPE_DESC")==null?"":(String)rs.getString("RELTN_TYPE_DESC") ));
            _bw.write(_wl_block11Bytes, _wl_block11);

														//IN043568 Start.
														String remarks =rs.getString("RELATION_REMARKS")==null?"":(String)rs.getString("RELATION_REMARKS");
														if(remarks.length() > 80)
															tempValue = "<a  href='javascript:ShowComments(\"MH\",\""+fromRelationId+"\",\""+(rs.getString("RELTN_ID")==null?"":(String)rs.getString("RELTN_ID"))+"\")'><font size='1' color='blue'><i>"+remarks.substring(0,80)+"...</i></a>";
														else
															tempValue =remarks;
														//IN043568 End.
													
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(className));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(tempValue ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(className));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(count));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(rs.getString("RELTN_ID")==null?"":(String)rs.getString("RELTN_ID") ));
            _bw.write(_wl_block17Bytes, _wl_block17);

												count++;
											}											
											
										}catch(Exception e){
										//	out.println("Exception@1: "+e);//COMMON-ICN-0181
                                                                                        e.printStackTrace();//COMMON-ICN-0181
										}
										finally
										{
											if(rs!=null) rs.close();
											if(pstmt!=null) pstmt.close();
											if(con!=null) ConnectionManager.returnConnection(con,request);
										}
									
									
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(count));
            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
