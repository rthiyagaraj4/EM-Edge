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

public final class __capatientgenogramtranbtn extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CAPatientGenogramTranBtn.jsp", 1709115570324L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCA/js/CAPatientGenogram.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n<form name=\'genogramTranbtnFrm\' id=\'genogramTranbtnFrm\'>\n\t<table cellpadding=3 cellspacing=0 border=0 width=\"100%\" align=center>\n\t\t<tr>\n\t\t\t<td valign=\"top\" align=\"left\" width=\"56%\">\n\t\t\t\t\n\t\t\t\t\t\t<!--<TR height=\"25px\">\n\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"10%\"><image src=\"../../eCA/images/test.png\"></TD>\n\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"23%\">Male/Female/Unknown</TD>\n\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"10%\"><image src=\"../../eCA/images/test.png\"></TD>\n\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"23%\">Index Patient Male/Female</TD>\n\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"10%\"><image src=\"../../eCA/images/test.png\"></TD>\n\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"23%\">Deseased Patient Male/Female/Unkown</TD>\n\t\t\t\t\t\t</TR> -->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t\t\t<div style=\"width:100%;height:85px;border:1px solid black;overflow:auto\">\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<TABLE cellpadding=1 cellspacing=0 border=0 width=\"100%\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t\t\t<TR height=\"25px\">\n\t\t\t\t\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"10%\"><image src=\"../../eCA/images/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"></TD>\n\t\t\t\t\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"23%\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</TD>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t\t<TD class=\"gridData\" width=\"10%\"><image src=\"../../eCA/images/";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\n\t\t\t</td>\n\t\t\t<td align=\"right\" width=\"44%\">\n\t\t\t\t<img src=\"../../eCA/images/FamilyMember.png\"  style=\"width:108px;height:87px;cursor: hand;\"  onClick=\"addFamilyMember()\"  /> \n\t\t\t\t<img  src=\"../../eCA/images/EmotionalRelationships.png\"  style=\"width:255px;height:87px;cursor: hand;\" onClick=\'addSEIRelation()\' />\n\t\t\t\t<img  src=\"../../eCA/images/MedicalHistory.png\"  style=\"width:119px;height:87px;cursor: hand;\" onClick=\'addMedicalHistory()\'  />\n\t\t\t\t<input type=\"hidden\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" name=\"patient_id\"/>\n\t\t\t</td>\n\t\t</tr>\n\n\t</table>\n</form>\n</body>\n</html>\n\n";
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

/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name        	Description
--------------------------------------------------------------------------------------------------------------------
06/09/2013	IN030457		Ramesh G		Bru-HIMS-CRF-016
06/09/2013	IN030458		Ramesh G		Bru-HIMS-CRF-017
 
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
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String drawRelationString =  request.getParameter("drawRelationString")==null?"":request.getParameter("drawRelationString");
	
	String[] totalList = drawRelationString.split("\\|");
	StringBuffer totalListbf= new StringBuffer();
	for(int k=0;k<totalList.length;k++){
		totalListbf.append("'"+((String)totalList[k])+"'");
		if(k!=(totalList.length)-1)
			totalListbf.append(",");
	}
	Connection			con			=	null;
	PreparedStatement	pstmt		=	null;
	ResultSet			rs			=	null;
	String 				query		=	null;
								

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
							
							try{
								con		=	ConnectionManager.getConnection(request);
								query	=	" SELECT RELTN_DESC,RELTN_IMG_NAME FROM CA_GENO_RELTN_MAST WHERE RELTN_ID IN("+totalListbf.toString()+")ORDER BY RELTN_DESC";

								pstmt	=	con.prepareStatement(query);											
								rs		=	pstmt.executeQuery();
								
								int i=0;
								int q = 0;
									while(rs.next()){	
										if(i==0){											
											if(q==0){
											
            _bw.write(_wl_block8Bytes, _wl_block8);

											}
											
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf((rs.getString("RELTN_IMG_NAME")==null?"":(String)rs.getString("RELTN_IMG_NAME"))));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((rs.getString("RELTN_DESC")==null?"":(String)rs.getString("RELTN_DESC"))));
            _bw.write(_wl_block11Bytes, _wl_block11);

											q++; 
											i++;
										}else{
											
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((rs.getString("RELTN_IMG_NAME")==null?"":(String)rs.getString("RELTN_IMG_NAME"))));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((rs.getString("RELTN_DESC")==null?"":(String)rs.getString("RELTN_DESC"))));
            _bw.write(_wl_block11Bytes, _wl_block11);

											i++;
											if(i==3){
											
            _bw.write(_wl_block13Bytes, _wl_block13);

												i=0;
											}
										}
									
									}
									if(q>0){
									
            _bw.write(_wl_block14Bytes, _wl_block14);

									}								
									
							}catch(Exception e){
									//out.println("Exception@1: "+e);//COMMON-ICN-0181
									e.printStackTrace();//COMMON-ICN-0181
							}finally{
								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();
								if(con!=null) ConnectionManager.returnConnection(con,request);
							}
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(patient_id));
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
