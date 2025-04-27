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

public final class __disdatachartingtools extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/DisDataChartingTools.jsp", 1709115798841L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script><!--IN050523 moved to line no 29 from 32-->\n\t\t<script src=\'../../eCA/js/DisDataCharting.js\' language=\'javascript\'></SCRIPT>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<!--<Script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n--><!--IN050523 commented-->\n\t\t</head>\n\n\t<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<form name=\"F\" id=\"F\">\n\t\t\t    <table cellpadding=3 cellspacing=0 width=\"100%\">\n\t\t\t    <tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<td align=left>\n\n    ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<input type=\'button\' name=\'btnAmeRep\' id=\'btnAmeRep\' onclick=\"ameRep();\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"  class=\'button\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'btnView\' id=\'btnView\' onclick=\"showErrorList();\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\"  class=\'button\'></td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t\t       <td align=right>\n\t\t\t\t\t\t<!-- IN037701 Start-->\n\t\t\t     \t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<input type=\'button\' name=\'add\' id=\'add\' onclick=\"discrete_add(\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\');\"  value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" class=\'button\'>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\n\t\t\t\t\t\t\t\t<input type=\'button\' name=\'record\' id=\'record\' onclick=\"apply(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"  class=\'button\'>\n\t\t\t\t\t\t\t\t<input type=\'button\' name=\'reset\' id=\'reset\' onclick=\"resetFormSPC(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'  class=\'button\'>\n\t\t\t\t     \t\t\t<input type=\'button\' name=\'cancel\' id=\'cancel\' onclick=\"cancelform(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' class=\'button\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t<!--IN037701 end-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t\t<input type=\'button\' name=\'upd\' id=\'upd\' onclick=\"update();\"  value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"  class=\'button\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t<!-- IN037701 Added if condition Start-->\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t\t\t\t<input type=\'button\' name=\'record\' id=\'record\' onclick=\"apply(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'reset\' id=\'reset\' onclick=\"resetForm(\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'  class=\'button\'>\n\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'cancel\' id=\'cancel\' onclick=\"cancelform(\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t<input type=\'button\' name=\'cancel\' id=\'cancel\' onclick=\"cancelform1(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t<!-- IN037701 Added if condition End-->\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t    </table>\n\n\t\t\t\t<input type=\'hidden\' name=\'query_string\' id=\'query_string\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n\t\t\t \t <input type=hidden name=patient_id value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t \t <input type=hidden name=module_id value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t\t \n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

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
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name      		Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           									created
03/06/2014	  	IN037701		Chowminya		 								SKR-CRF-0036
18/06/2014		IN049742		Chowminya		 								Alpha	CRF linked
12/08/2014		IN050523		Vijayakumar K					Ramesh G		PA - PAS -  ICN - OP-OP Transaction -Manage Patient Queue -
																				Record Vital Signs - Script error is displaying
-------------------------------------------------------------------------------------------------------------------------------------
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

			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
			String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

			String qs = request.getQueryString();

			String facilityid = (String) session.getValue("facility_id");
			String episodeid = request.getParameter("episode_id")==null?"":request.getParameter("episode_id");
			String amerepMode = request.getParameter("amerepMode")==null?"N":request.getParameter("amerepMode");
			String amendMode = request.getParameter("amendMode")==null?"":request.getParameter("amendMode");
			String replaceMode = request.getParameter("replaceMode")== null?"":request.getParameter("replaceMode");
			String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String resp_id = (String)session.getValue("responsibility_id");
			String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
			String module_id = request.getParameter("module_id")==null?"":request.getParameter("module_id");
			String called_from		=	request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");//IN037701
			String battey_id		=	request.getParameter("battey_id")==null?"":request.getParameter("battey_id");//IN037701
			String applied="";
			String rec_exist="";
			String newIns="";
			Connection con = null;
			PreparedStatement pstmt1=null;
			PreparedStatement  pstmt=null;
			ResultSet rs1=null;
			ResultSet rs=null;

			try{
				con = ConnectionManager.getConnection(request);

				/////
				
				String sql1= "select 1 from ca_encntr_discr_msr where FACILITY_ID=? and ENCOUNTER_ID   =? and rownum=1";
				 pstmt1=con.prepareStatement(sql1);
				pstmt1.setString(1,facilityid);
				pstmt1.setString(2,episodeid);
				 rs1 = pstmt1.executeQuery();
				if(rs1.next()){
					newIns="Y";
				}

				String sql="SELECT GET_TASK_APPLICABILITY('MARK_VITAL_ERROR',NULL,?,?,?,?,?), nvl((SELECT 'Y' FROM CA_ENCNTR_DISCR_MSR WHERE PATIENT_ID=? AND ERROR_YN='Y' AND ROWNUM=1),'N') ERR_EXIST   FROM DUAL";

			 pstmt=con.prepareStatement(sql);

				pstmt.setString(1,resp_id);
				pstmt.setString(2,reln_id);
				pstmt.setString(3,facilityid);
				pstmt.setString(4,episodeid);
				pstmt.setString(5,patient_id);
				pstmt.setString(6,patient_id);
				 rs=pstmt.executeQuery();

				if (rs.next()){
					applied=rs.getString(1);
					rec_exist=rs.getString(2);
				}
				if( rs!=null) rs.close();
				if (pstmt!=null) pstmt.close();
				if(rs1!=null) rs1.close();
				if(pstmt1!=null) pstmt1.close();
			}catch ( Exception e){
				//out.println("Error " +e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}finally {
						if(con!=null)ConnectionManager.returnConnection(con,request);
					}
    
            _bw.write(_wl_block8Bytes, _wl_block8);
if(module_id.equals("")){
            _bw.write(_wl_block9Bytes, _wl_block9);
				
						if(applied!=null && applied.equals("A")){
									if(!amendMode.equals("Y") && !replaceMode.equals("Y") && newIns.equals("Y")){
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.AmendError.label","ca_labels")));
            _bw.write(_wl_block11Bytes, _wl_block11);
}

									if (rec_exist.equals("Y")) {
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.ViewErrorList.label","ca_labels")));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
						}
					}
    
            _bw.write(_wl_block14Bytes, _wl_block14);
 if ("CA_SPC".equals(called_from)){
							//IN049742 Added if condition Start	
							if("Y".equals(newIns)){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(battey_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiscreteMeasure.label","common_labels")));
            _bw.write(_wl_block18Bytes, _wl_block18);
 } //IN049742 End 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
 } 
            _bw.write(_wl_block25Bytes, _wl_block25);
 if (replaceMode.equals("Y")){ 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Update.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
 } 
            _bw.write(_wl_block28Bytes, _wl_block28);
 if(!"CA_SPC".equals(called_from)){
						if (!replaceMode.equals("Y")){ 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.record.label","common_labels")));
            _bw.write(_wl_block27Bytes, _wl_block27);
 } 
						}
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(!"CA_SPC".equals(called_from)){
						if (amerepMode.equals("N")){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
}else{ 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")));
            _bw.write(_wl_block24Bytes, _wl_block24);
}
						}
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(qs));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
