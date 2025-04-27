package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCA.*;
import org.json.simple.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __catannerstagingmailprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CATannerStagingMailPrint.jsp", 1709115636997L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n\t<head>\t\n\t\t<link rel=\'StyleSheet\' href=\'../html/CATannerStaging.css\' type=\'text/css\'>\t\n\t\t<script language=\'javascript\' src=\'../js/json2.js\'></script>\t\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../js/CATannerStaging.js\'></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<style type=\"text/css\">\nbody {\n\tmargin-left: 0px;\n\tmargin-top: 0px;\n\tmargin-right: 0px;\n\tmargin-bottom: 0px;\n\tfont-family: Arial, Helvetica, sans-serif;\n\tfont-size: 12px;\n}\n.Hospital_name {\n\tfont-size: 25px;\n\tfont-weight: bold;\n}\n.Hospital_name_sub {\n\tfont-size: 18px;\n\tfont-weight: bold;\n}\n.lablebold {\n\tfont-weight: bold;\n\tpadding-left: 5px;\n}\n.divborder {\n\tborder: 1px solid #ccc;\n}\n.Em_box_Dis {\n\tpadding-left: 5px;\n}\n.Em_box_Select {\n\tborder: 3px solid #000;\n}\n</style>\n\t</head>\n\t<body class=\'CONTENT\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=\'TannerStagingForm\' id=\'TannerStagingForm\' method =\'post\' target=\'messageFrame\'>\n\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n  <tr>\n    <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n        <tr>\n          <td align=\"center\" valign=\"top\" class=\"Hospital_name\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</td>\n        </tr>\n        <tr>\n          <td align=\"center\" valign=\"top\" class=\"Hospital_name_sub\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n        </tr>\n      </table></td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"5\">\n        <tr>\n          <td width=\"7%\" align=\"left\" valign=\"top\" class=\"lablebold\">Patient ID</td>\n          <td width=\"49%\" align=\"left\" valign=\"top\">: &nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n          <td width=\"7%\" align=\"left\" valign=\"top\" class=\"lablebold\">Recorded Date</td>\n          <td width=\"37%\" align=\"left\" valign=\"top\">: &nbsp; ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n        </tr>\n        <tr>\n          <td align=\"left\" valign=\"top\" class=\"lablebold\">Patient Name</td>\n          <td align=\"left\" valign=\"top\">:  &nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n          <td align=\"left\" valign=\"top\" class=\"lablebold\">Practitioner Name</td>\n          <td align=\"left\" valign=\"top\">: &nbsp; ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n        </tr>\n      </table></td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n        <tr>\n          <td width=\"9%\" align=\"left\" valign=\"top\" class=\"divborder lablebold\">Stages of puberty</td>\n          <td width=\"44%\" align=\"left\" valign=\"top\" class=\"divborder lablebold\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n          <td width=\"47%\" align=\"left\" valign=\"top\" class=\"divborder lablebold\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n        </tr>\n        <tr>\n          <td align=\"left\" valign=\"middle\"  class=\"divborder lablebold\">Stage 01</td>\n          <td colspan=\"2\" align=\"left\" valign=\"top\" class=\"divborder\" ><div id=\"SP1\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'SP\',\'1\');\">\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                <tr class=\"Em_box_H\">\n                  <td width=\"9%\" align=\"left\" valign=\"top\"><img src=\"../../eCA/images/B_H_Stage01.PNG\" width=\"144\" height=\"80\" /></td>\n                  <td width=\"37%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Pre-adolescent, testes, scrotum and penis are of about the same size and proportion as in early childhood.</td>\n                  <td width=\"54%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis EM_Leftborder\">Pre-adolescent. The vellus over the pubes is not further developed than that over the abdominal wall, i.e. no pubic hair.</td>\n                </tr>\n              </table>\n            </div></td>\n        </tr>\n        <tr>\n          <td align=\"left\" valign=\"middle\" class=\"divborder lablebold\">Stage 02</td>\n          <td colspan=\"2\" align=\"left\" valign=\"top\" class=\"divborder\" ><div id=\"SP2\" class=\"Em_box\" onClick=\"selectTannerStaging(\'SP\',\'2\');\">\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                <tr class=\"Em_box_H\" >\n                  <td width=\"9%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"../../eCA/images/B_H_Stage02.PNG\" width=\"144\" height=\"80\" /></td>\n                  <td width=\"37%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Enlargement of scrotum and testes. Skin of scrotum reddens and changes in texture. Little or no enlargement of penis at this stage.</td>\n                  <td width=\"54%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis EM_Leftborder\">Sparse growth of long, slightly pigmented downy hair, straight or slightly curled at the base of the penis.</td>\n                </tr>\n              </table>\n            </div></td>\n        </tr>\n        <tr>\n          <td align=\"left\" valign=\"middle\"  class=\"divborder lablebold\">Stage 03</td>\n          <td colspan=\"2\" align=\"left\" valign=\"top\" class=\"divborder\" ><div id=\"SP3\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'SP\',\'3\');\">\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                <tr class=\"Em_box_H\">\n                  <td width=\"9%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"../../eCA/images/B_H_Stage03.PNG\" width=\"144\" height=\"80\" /></td>\n                  <td width=\"37%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Enlargement of the penis which occurs at first mainly in length. Further growth of the testes and scrotum.</td>\n                  <td width=\"54%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis EM_Leftborder\">Considerably darker, coarser and more curled. The hair spreads sparsely over the junction of the pubes.</td>\n                </tr>\n              </table>\n            </div></td>\n        </tr>\n        <tr>\n          <td align=\"left\" valign=\"middle\" class=\"divborder lablebold\">Stage 04</td>\n          <td colspan=\"2\" align=\"left\" valign=\"top\" class=\"divborder\" ><div id=\"SP4\" class=\"Em_box_Select\"  onClick=\"selectTannerStaging(\'SP\',\'4\');\">\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                <tr class=\"Em_box_H\">\n                  <td width=\"9%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"../../eCA/images/B_H_Stage04.PNG\" width=\"144\" height=\"80\" /></td>\n                  <td width=\"37%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Increased size of penis with growth in breadth and development of glans. Testes and scrotum larger, scrotal skin darkened.</td>\n                  <td width=\"54%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis EM_Leftborder\">Hair now adult in type, but area covered is still considerably smaller then in the adult, No spread to the medial surface of thighs.</td>\n                </tr>\n              </table>\n            </div></td>\n        </tr>\n        <tr>\n          <td align=\"left\" valign=\"middle\"  class=\"divborder lablebold\">Stage 05</td>\n          <td colspan=\"2\" align=\"left\" valign=\"top\" class=\"divborder\" ><div id=\"SP5\" class=\"Em_box\"  onClick=\"selectTannerStaging(\'SP\',\'5\');\">\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                <tr class=\"Em_box_H\">\n                  <td width=\"9%\" align=\"center\" valign=\"top\" bgcolor=\"#FFFFFF\"><img src=\"../../eCA/images/B_H_Stage05.PNG\" width=\"144\" height=\"80\" /></td>\n                  <td width=\"37%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis\">Genitalia adult in size and shape.</td>\n                  <td width=\"54%\" align=\"left\" valign=\"top\" class=\"Em_box_Dis EM_Leftborder\">Adult in quantity and type with distribution of the horizontal (or classically feminine) pattern. Spread to medial surface of thighs but not up linea alba or elsewhere above the base of the inverse triangle (spread up linea alba occurs late and is rated stage 6).</td>\n                </tr>\n              </table>\n            </div></td>\n        </tr>\n        \n      </table></td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr>\n        <td align=\"right\" valign=\"middle\">(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" ) </td>\n        <td align=\"right\" valign=\"middle\">&nbsp;</td>\n      </tr>\n      <tr>\n        <td width=\"89%\" align=\"right\" valign=\"middle\">Signed By.</td>\n        <td width=\"11%\" align=\"right\" valign=\"middle\">&nbsp;</td>\n      </tr>\n    </table></td>\n  </tr>\n  <tr>\n    <td align=\"left\" valign=\"top\">&nbsp;</td>\n  </tr>\n</table>\n\t\t\t<!-- </div> -->\n\t\t\t<input type=\"hidden\" name=\"stageOfPuberty\" id=\"stageOfPuberty\" value=\"\"/>\n\t\t\t<input type=\"hidden\" name=\"pubicHair\" id=\"pubicHair\" value=\"\"/>\n\t\t\t<SCRIPT>\t\t\t\n\t\t\t\tselectTannerStaging(\'SP\',\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\',\'D\');\n\t\t\t\twindow.print();\n\t\t\t\tsetTimeout(function() { window.close(); }, ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =");\n\t\t\t</SCRIPT>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/05/2018	IN063838		Ramesh G											ML-MMOH-CRF-0813
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id 		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id 	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String stageOfPuberty 	= request.getParameter("stageOfPuberty")==null?"":request.getParameter("stageOfPuberty");
String facility_id 		= (String)session.getAttribute("facility_id");
String login_practitioner_id	= (String) session.getValue("ca_practitioner_id");
String recorded_date = request.getParameter("recorded_date")==null?"":request.getParameter("recorded_date");//IN067402
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale 			= (String) p.getProperty("LOCALE");
String bean_id			= "@catannerStagingBean"+patient_id;
String bean_name		= "eCA.CATannerStagingBean";
int note_print_time_interval	=	1500;
eCA.CATannerStagingBean beanObj = (eCA.CATannerStagingBean)getObjectFromBean(bean_id,bean_name,session);
//JSONObject jsonObj = beanObj.getBallardScoreHeaderDetails(request, patient_id,facility_id,locale,login_practitioner_id);
JSONObject jsonObj = beanObj.getBallardScoreHeaderDetails(request, patient_id,facility_id,locale,login_practitioner_id,recorded_date);
note_print_time_interval=Integer.parseInt((String)jsonObj.get("NOTE_PRINT_TIME_INTERVAL"));


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(jsonObj.get("SITE_NAME") ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(jsonObj.get("FACILITY_NAME") ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(jsonObj.get("EVENT_DATE_TIME") ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(jsonObj.get("PATIENT_NAME") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(jsonObj.get("PRACTITIONER_NAME") ));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(jsonObj.get("LOGIN_PRACTITIONER_NAME") ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(stageOfPuberty));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(note_print_time_interval ));
            _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.GenitalDevelopment.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.PubicHair.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
