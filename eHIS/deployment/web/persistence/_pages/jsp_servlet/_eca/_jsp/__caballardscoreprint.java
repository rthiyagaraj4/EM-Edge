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

public final class __caballardscoreprint extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CABallardScorePrint.jsp", 1737107795095L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<html xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>EM</title>\n<link rel=\'StyleSheet\' href=\'../html/CABallardScore.css\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../js/CABallardScore.js\'></script>\n<script language=\'javascript\' src=\'../js/json2.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script>\n\n\n</script>\n</head>\n\n<body>\n<form name=\'BallardScorePrintForm\' id=\'BallardScorePrintForm\' method =\'post\' target=\'messageFrame\' >\n  <!--div style=\"max-width:1200px\"-->\n    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n      <tr>\n        <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n          <tr><td colspan=\"2\" align=\"center\">&nbsp;</td>\n          <tr>\n          \t<td colspan=\"2\" align=\"center\"><h1>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</h1></td>\n          </tr>\n          <tr>\n          \t<td colspan=\"2\" align=\"center\"><h2>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</h2></td>\n          </tr>\n          <tr><td colspan=\"2\" align=\"center\">&nbsp;</td>\n          <tr>\n            <td width=\"50%\" align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n              <tr>\n                <td width=\"158\" align=\"left\" valign=\"top\" class=\"Em_L_title_lab\">Patient ID</td>\n                <td width=\"674\" align=\"left\" valign=\"top\"><strong>: &nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</strong></td>\n              </tr>\n              <tr><td colspan=\"2\">&nbsp;</td></tr>\n              <tr>\n                <td align=\"left\" valign=\"top\" class=\"Em_L_title_lab\">Patient Name</td>\n                <td align=\"left\" valign=\"top\"><strong>:  &nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</strong></td>\n              </tr>\n              <tr><td colspan=\"2\">&nbsp;</td></tr>\n            </table></td>\n            <td width=\"50%\" align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n              <tr>\n                <td width=\"180\" align=\"left\" valign=\"top\" class=\"Em_L_title_lab\">Recorded Date</td>\n                <td width=\"653\" align=\"left\" valign=\"top\"><strong>: &nbsp; ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</strong></td>\n              </tr>\n              <tr><td colspan=\"2\">&nbsp;</td></tr>\n              <tr>\n                <td align=\"left\" valign=\"top\" class=\"Em_L_title_lab\">Practitioner Name</td>\n                <td align=\"left\" valign=\"top\"><strong>: &nbsp; ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12_0 ="</strong></td>\n              </tr>\n              <tr><td colspan=\"2\">&nbsp;</td></tr>\n            </table></td>\n          </tr>\n        </table></td>\n      </tr>\n      \n      <tr>\n        <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n            <tr>\n              <td width=\"70%\" align=\"center\" valign=\"top\" class=\"EM_TableAcontainer\">\n              <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"EM_A_Border\">\n                  <tr>\n                    <td align=\"right\" valign=\"top\">\n                    <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" style=\"border-bottom:1px solid #9dbbc3\">\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_Title labelhold\" style=\"color:#000\" id=\"td\">Score</td>\n                          <td id=\"td\" align=\"center\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_TableACell_Width\" style=\"color:#000\" >-1</td>\n                          <td id=\"td\" align=\"center\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_TableACell_Width\" style=\"color:#000\" >0</td>\n                          <td id=\"td\" align=\"center\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_TableACell_Width\" style=\"color:#000\" >1</td>\n                          <td id=\"td\" align=\"center\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_TableACell_Width\" style=\"color:#000\" >2</td>\n                          <td id=\"td\" align=\"center\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_TableACell_Width\" style=\"color:#000\" >3</td>\n                          <td id=\"td\" align=\"center\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_TableACell_Width\" style=\"color:#000\" >4</td>\n                          <td id=\"td\" align=\"center\" valign=\"middle\"class=\"EM_Col_B1 EM_Cell_height EM_TableACell_Width\" style=\"color:#000\" >5</td>\n                        </tr>\n                        <tr>\n                          <td colspan=\"8\" align=\"left\" valign=\"middle\" bgcolor=\"#dbe6e8\" class=\"EM_Sub_Header EM_Cell_height EM_TableAcontainerborder\">Neuromuscular Maturity</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_Title labelhold\">Posture</td>\n                          <td id=\"PO-1\" align=\"center\" valign=\"middle\" class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\">&nbsp;</td>\n                          <td id=\"PO0\" align=\"center\" valign=\"middle\" class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PO\',\'0\',\'Col_A\');\"><img src=\"../../eCA/images/Posture_0.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PO1\" align=\"center\" valign=\"middle\" class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PO\',\'1\',\'Col_A\');\"><img src=\"../../eCA/images/Posture_1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PO2\" align=\"center\" valign=\"middle\" class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PO\',\'2\',\'Col_A\');\"><img src=\"../../eCA/images/Posture_2.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PO3\" align=\"center\" valign=\"middle\" class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PO\',\'3\',\'Col_A\');\"><img src=\"../../eCA/images/Posture_3.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PO4\" align=\"center\" valign=\"middle\" class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PO\',\'4\',\'Col_A\');\"><img src=\"../../eCA/images/Posture_4.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PO5\" align=\"center\" valign=\"middle\" class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" value=\"\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_Title labelhold\">Square window(wrist)</td>\n                          <td id=\"SQ-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SQ\',\'-1\',\'Col_B\');\"><img src=\"../../eCA/images/SquareW_-1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SQ0\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SQ\',\'0\',\'Col_B\');\"><img src=\"../../eCA/images/SquareW_0.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SQ1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SQ\',\'1\',\'Col_B\');\"><img src=\"../../eCA/images/SquareW_1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SQ2\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SQ\',\'2\',\'Col_B\');\"><img src=\"../../eCA/images/SquareW_2.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SQ3\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SQ\',\'3\',\'Col_B\');\"><img src=\"../../eCA/images/SquareW_3.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SQ4\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SQ\',\'4\',\'Col_B\');\"><img src=\"../../eCA/images/SquareW_4.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SQ5\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_Title labelhold\">Arm recoil</td>\n                          <td id=\"AR-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\">&nbsp;</td>\n                          <td id=\"AR0\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'AR\',\'0\',\'Col_A\');\"><img src=\"../../eCA/images/Armrecoil_0.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"AR1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'AR\',\'1\',\'Col_A\');\"><img src=\"../../eCA/images/Armrecoil_1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"AR2\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'AR\',\'2\',\'Col_A\');\"><img src=\"../../eCA/images/Armrecoil_2.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"AR3\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'AR\',\'3\',\'Col_A\');\"><img src=\"../../eCA/images/Armrecoil_3.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"AR4\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'AR\',\'4\',\'Col_A\');\"><img src=\"../../eCA/images/Armrecoil_4.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"AR5\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_Title labelhold\">Popliteal angle</td>\n                          <td id=\"PA-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PA\',\'-1\',\'Col_B\');\"><img src=\"../../eCA/images/Popliteal_-1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PA0\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PA\',\'0\',\'Col_B\');\"><img src=\"../../eCA/images/Popliteal_0.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PA1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PA\',\'1\',\'Col_B\');\"><img src=\"../../eCA/images/Popliteal_1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PA2\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PA\',\'2\',\'Col_B\');\"><img src=\"../../eCA/images/Popliteal_2.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PA3\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PA\',\'3\',\'Col_B\');\"><img src=\"../../eCA/images/Popliteal_3.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PA4\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PA\',\'4\',\'Col_B\');\"><img src=\"../../eCA/images/Popliteal_4.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"PA5\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'PA\',\'5\',\'Col_B\');\"><img src=\"../../eCA/images/Popliteal_5.PNG\" width=\"90\" height=\"55\" /></td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_Title labelhold\">Scarf sign</td>\n                          <td id=\"SS-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SS\',\'-1\',\'Col_A\');\"><img src=\"../../eCA/images/Scraf_-1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SS0\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SS\',\'0\',\'Col_A\');\"><img src=\"../../eCA/images/Scraf_0.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SS1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SS\',\'1\',\'Col_A\');\"><img src=\"../../eCA/images/Scraf_1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SS2\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SS\',\'2\',\'Col_A\');\"><img src=\"../../eCA/images/Scraf_2.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SS3\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SS\',\'3\',\'Col_A\');\"><img src=\"../../eCA/images/Scraf_3.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SS4\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'SS\',\'4\',\'Col_A\');\"><img src=\"../../eCA/images/Scraf_4.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"SS5\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_TableA";
    private final static byte[]  _wl_block12_0Bytes = _getBytes( _wl_block12_0 );

    private final static java.lang.String  _wl_block12_1 ="Cell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_Title labelhold \">Heel to ear</td>\n                          <td id=\"HE-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'HE\',\'-1\',\'Col_B\');\"><img src=\"../../eCA/images/Heel_-1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"HE0\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'HE\',\'0\',\'Col_B\');\"><img src=\"../../eCA/images/Heel_0.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"HE1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'HE\',\'1\',\'Col_B\');\"><img src=\"../../eCA/images/Heel_1.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"HE2\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'HE\',\'2\',\'Col_B\');\"><img src=\"../../eCA/images/Heel_2.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"HE3\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'HE\',\'3\',\'Col_B\');\"><img src=\"../../eCA/images/Heel_3.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"HE4\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\" onClick=\"calScore(\'NE\',\'HE\',\'4\',\'Col_B\');\"><img src=\"../../eCA/images/Heel_4.PNG\" width=\"90\" height=\"55\" /></td>\n                          <td id=\"HE5\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td colspan=\"8\" align=\"left\" valign=\"middle\" bgcolor=\"#dbe6e8\" class=\"EM_Sub_Header EM_Cell_height EM_TableAcontainerborder\">Physical Maturity</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_Title labelhold\">Skin</td>\n                          <td id=\"SK-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'SK\',\'-1\',\'Col_A\');\">Sticky, friable, transparent</td>\n                          <td id=\"SK0\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'SK\',\'0\',\'Col_A\');\">Gelatinous, red, translucent</td>\n                          <td id=\"SK1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'SK\',\'1\',\'Col_A\');\">Smooth, pink, visible veins</td>\n                          <td id=\"SK2\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'SK\',\'2\',\'Col_A\');\">Superficial peeling and/or rash; few veins</td>\n                          <td id=\"SK3\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'SK\',\'3\',\'Col_A\');\">Cracking, pale areas; rare veins</td>\n                          <td id=\"SK4\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'SK\',\'4\',\'Col_A\');\">Parchment, deep cracking; no vessels</td>\n                          <td id=\"SK5\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'SK\',\'5\',\'Col_A\');\">Leathery, cracked wrinkled</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_Title labelhold\">Lanugo</td>\n                          <td id=\"LA-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'LA\',\'-1\',\'Col_B\');\">None</td>\n                          <td id=\"LA0\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'LA\',\'0\',\'Col_B\');\">Sparse</td>\n                          <td id=\"LA1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'LA\',\'1\',\'Col_B\');\">Abundant</td>\n                          <td id=\"LA2\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'LA\',\'2\',\'Col_B\');\">Thinning</td>\n                          <td id=\"LA3\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'LA\',\'3\',\'Col_B\');\">Bald areas</td>\n                          <td id=\"LA4\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'LA\',\'4\',\'Col_B\');\">Mostly bald</td>\n                          <td id=\"LA5\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_Title labelhold\">Plantar surface</td>\n                          <td id=\"PS-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'PS\',\'-1\',\'Col_A\');\">Heel-toe<br>\n                            40-50 mm: -1<br>\n                           &lt; 40 mm: -2 </td>\n                          <td id=\"PS0\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'PS\',\'0\',\'Col_A\');\">>50 mm, no crease</td>\n                          <td id=\"PS1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'PS\',\'1\',\'Col_A\');\">Faint red marks</td>\n                          <td id=\"PS2\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'PS\',\'2\',\'Col_A\');\">Anterior transverse crease only</td>\n                          <td id=\"PS3\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'PS\',\'3\',\'Col_A\');\">creases anterior 2/3</td>\n                          <td id=\"PS4\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'PS\',\'4\',\'Col_A\');\">Creases over entire sole</td>\n                          <td id=\"PS5\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_Title labelhold\">Breast</td>\n                          <td id=\"BR-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'BR\',\'-1\',\'Col_B\');\">Imperceptible</td>\n                          <td id=\"BR0\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'BR\',\'0\',\'Col_B\');\">Barely perceptible</td>\n                          <td id=\"BR1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'BR\',\'1\',\'Col_B\');\">Flat areola, no bud</td>\n                          <td id=\"BR2\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'BR\',\'2\',\'Col_B\');\">Stippled areola, 1-2 mm bud</td>\n                          <td id=\"BR3\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'BR\',\'3\',\'Col_B\');\">Raised areola, 3-4 mm bud</td>\n                          <td id=\"BR4\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'BR\',\'4\',\'Col_B\');\">Full areola, 5-10 mm bud</td>\n                          <td id=\"BR5\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_Title labelhold\">Eye/Ear</td>\n                          <td id=\"EE-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'EE\',\'-1\',\'Col_A\');\">Lids fused<br>\n                            loosely: -1 <br>\n                            tightly: -2</td>\n                          <td id=\"EE0\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'EE\',\'0\',\'Col_A\');\">Lids open; pinna flat; stays folded</td>\n                          <td id=\"EE1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'EE\',\'1\',\'Col_A\');\">Slightly curved pinna; soft; slow recoil</td>\n                          <td id=\"EE2\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'EE\',\'2\',\'Col_A\');\">Well curved pinna; soft but ready recoil</td>\n                          <td id=\"EE3\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'EE\',\'3\',\'Col_A\');\">Formed and firm, instant recoil</td>\n                          <td id=\"EE4\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'EE\',\'4\',\'Col_A\');\">Thick cartilage, ear stiff</td>\n                          <td id=\"EE5\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height EM_Title labelhold\">Genitals(Male)</td>\n                          <td id=\"GM-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GM\',\'-1\',\'Col_B\');\">Scrotum flat, smooth</td>\n                          <td id=\"GM0\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GM\',\'0\',\'Col_B\');\">Scrotum empty, faint rugae</td>\n                          <td id=\"GM1\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GM\',\'1\',\'Col_B\');\">Testes in upper canal, rare rugae</td>\n                          <td id=\"GM2\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GM\',\'2\',\'Col_B\');\">Testes descending, few rugae</td>\n                          <td id=\"GM3\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GM\',\'3";
    private final static byte[]  _wl_block12_1Bytes = _getBytes( _wl_block12_1 );

    private final static java.lang.String  _wl_block12_2 ="\',\'Col_B\');\">Testes down, good rugae</td>\n                          <td id=\"GM4\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GM\',\'4\',\'Col_B\');\">Testes pendulous, deep rugae</td>\n                          <td id=\"GM5\" align=\"center\" valign=\"middle\"class=\"EM_Col_B EM_Cell_height  EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                        <tr>\n                          <td align=\"left\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height EM_Title labelhold\">Genitals(Female)</td>\n                          <td id=\"GF-1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GF\',\'-1\',\'Col_A\');\">Clitoris prominent, labia flat</td>\n                          <td id=\"GF0\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GF\',\'0\',\'Col_A\');\">Clitoris prominent, small labia minora</td>\n                          <td id=\"GF1\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GF\',\'1\',\'Col_A\');\">Clitoris prominent, enlarging minora</td>\n                          <td id=\"GF2\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GF\',\'2\',\'Col_A\');\">Majora and minora equally prominent</td>\n                          <td id=\"GF3\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GF\',\'3\',\'Col_A\');\">Majora large, minora small</td>\n                          <td id=\"GF4\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\" onClick=\"calScore(\'PM\',\'GF\',\'4\',\'Col_A\');\">Majora cover clitoris and minora</td>\n                          <td id=\"GF5\" align=\"center\" valign=\"middle\"class=\"EM_Col_A EM_Cell_height  EM_TableACell_Width\">&nbsp;</td>\n                        </tr>\n                      </table>\n                      <input type=\"hidden\" id=\"NE\" name=\"NE\" id=\"NE\" value=\"\"/>\n                      <input type=\"hidden\" id=\"PO\" name=\"PO\" id=\"PO\" value=\"\"/>\n                      <input type=\"hidden\" id=\"SQ\" name=\"SQ\" id=\"SQ\" value=\"\"/>\n                      <input type=\"hidden\" id=\"AR\" name=\"AR\" id=\"AR\" value=\"\"/>\n                      <input type=\"hidden\" id=\"PA\" name=\"PA\" id=\"PA\" value=\"\"/>\n                      <input type=\"hidden\" id=\"SS\" name=\"SS\" id=\"SS\" value=\"\"/>\n                      <input type=\"hidden\" id=\"HE\" name=\"HE\" id=\"HE\" value=\"\"/>\n                      <input type=\"hidden\" id=\"PM\" name=\"PM\" id=\"PM\" value=\"\"/>\n                      <input type=\"hidden\" id=\"SK\" name=\"SK\" id=\"SK\" value=\"\"/>\n                      <input type=\"hidden\" id=\"LA\" name=\"LA\" id=\"LA\" value=\"\"/>\n                      <input type=\"hidden\" id=\"PS\" name=\"PS\" id=\"PS\" value=\"\"/>\n                      <input type=\"hidden\" id=\"BR\" name=\"BR\" id=\"BR\" value=\"\"/>\n                      <input type=\"hidden\" id=\"EE\" name=\"EE\" id=\"EE\" value=\"\"/>\n                      <input type=\"hidden\" id=\"GM\" name=\"GM\" id=\"GM\" value=\"\"/>\n                      <input type=\"hidden\" id=\"GF\" name=\"GF\" id=\"GF\" value=\"\"/>\n                      <input type=\"hidden\" id=\"TT\" name=\"TT\" id=\"TT\" value=\"\"/></td>\n                  </tr>\n                </table>\n                </td>\n              <td width=\"30%\" id=\"\" align=\"center\" valign=\"top\" class=\"EM_TableBcontainer\">\n              <table width=\"98%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"EM_L_Total_count\" style=\"border-right:2px solid #9dbbc3\">\n                  <tr>\n                    <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                        <tr>\n                          <td align=\"left\" valign=\"top\"><div class=\"EM_L_header EM_L_Total_count\">\n                              <table width=\"140\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                                <tr>\n                                  <td align=\"center\" valign=\"middle\" class=\"EM_Sub_Header\">&nbsp;</td>\n                                </tr>\n                                <tr>\n                                  <td align=\"center\" valign=\"middle\" class=\"EM_Sub_Header\">Neuromuscular</td>\n                                </tr>\n                                <tr>\n                                  <td id=\"NESCORE\" height=\"80\" align=\"center\" valign=\"middle\" class=\"EM_L-Count\">&nbsp;</td>\n                                </tr>\n                              </table>\n                            </div></td>\n                          <td align=\"left\" valign=\"top\"><div class=\"EM_L_header EM_L_Total_count\">\n                              <table width=\"140\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                                <tr>\n                                  <td align=\"center\" valign=\"middle\" class=\"EM_Sub_Header\">&nbsp;</td>\n                                </tr>\n                                <tr>\n                                  <td align=\"center\" valign=\"middle\" class=\"EM_Sub_Header\">Physical</td>\n                                </tr>\n                                <tr>\n                                  <td id=\"PMSCORE\" height=\"80\" align=\"center\" valign=\"middle\" class=\"EM_L-Count\">&nbsp;</td>\n                                </tr>\n                              </table>\n                          </div></td>\n                      </tr>\n                      </table></td>\n                  </tr>\n                  <tr>\n                    <td align=\"center\" valign=\"middle\"><div class=\"EM_L_Total_count\">\n                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                          <tr>\n                            <td align=\"center\" valign=\"middle\">Total Score</td>\n                          </tr>\n                          <tr>\n                            <td id=\"TOTALSCORE\" height=\"60\" align=\"center\" valign=\"middle\" class=\"EM_L-Count\">&nbsp;</td>\n                          </tr>\n                        </table>\n                      </div></td>\n                  </tr>\n                  <tr>\n                    <td align=\"left\" valign=\"top\"><div class=\"EM_L_Guide\">\n                        <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                          <tr>\n                            <td align=\"left\" valign=\"top\" bgcolor=\"#dbe6e8\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                                <tr>\n                                  <td colspan=\"5\" align=\"center\" class=\"Em_L_border_Top\"><!--   /* Font Definitions */   @font-face  \t{font-family:\"Cambria Math\";  \tpanose-1:2 4 5 3 5 4 6 3 2 4;}  @font-face  \t{font-family:Calibri;  \tpanose-1:2 15 5 2 2 2 4 3 2 4;}   /* Style Definitions */   p.MsoNormal, li.MsoNormal, div.MsoNormal  \t{margin-top:0in;  \tmargin-right:0in;  \tmargin-bottom:8.0pt;  \tmargin-left:0in;  \tline-height:107%;  \tfont-size:11.0pt;  \tfont-family:\"Calibri\",sans-serif;}  .MsoChpDefault  \t{font-family:\"Calibri\",sans-serif;}  .MsoPapDefault  \t{margin-bottom:8.0pt;  \tline-height:107%;}   /* Page Definitions */   @page WordSection1  \t{size:8.5in 11.0in;  \tmargin:1.0in 1.0in 1.0in 1.0in;}  div.WordSection1  \t{page:WordSection1;}  --> \n                                    Maturity Rating</td>\n                                </tr>\n                                <tr>\n                                  <td width=\"24%\" align=\"center\" valign=\"middle\" class=\"Em_L_border\">Score</td>\n                                  <td width=\"24%\" align=\"center\" valign=\"middle\" class=\"Em_L_border1\"> weeks</td>\n                                  <td width=\"4%\" align=\"center\" valign=\"middle\" bgcolor=\"#9dbbc3\" class=\"Em_L_border2\" \tstyle\"border-right: 2px solid #9dbbc3;\">&nbsp;</td>\n                                  <td width=\"24%\" align=\"center\" valign=\"middle\" class=\"Em_L_border\">Score</td>\n                                  <td width=\"24%\" align=\"center\" valign=\"middle\" class=\"Em_L_border1\"> weeks</td>\n                                </tr>\n                              </table></td>\n                          </tr>\n                          <tr>\n                            <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n                                <tr>\n                                  <td width=\"24%\" align=\"center\" valign=\"top\" class=\"Em_L_title\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"11\">\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">-10</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">-5</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">0</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">5</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">10</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">15</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">20</td>\n                                      </tr>\n                                  </table></td>\n                                  <td width=\"24%\" align=\"center\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"11\">\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">20</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">22</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">24</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">26</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">28</td>\n                                      </tr>\n                                      <tr>\n";
    private final static byte[]  _wl_block12_2Bytes = _getBytes( _wl_block12_2 );

    private final static java.lang.String  _wl_block12_3 ="                                        <td align=\"center\" valign=\"middle\">30</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">32</td>\n                                      </tr>\n                                  </table></td>\n                                  <td width=\"4%\" align=\"center\" valign=\"top\" bgcolor=\"#9dbbc3\" style=\"\tborder-right: 2px solid #9dbbc3;\">&nbsp;</td>\n                                  <td width=\"24%\" align=\"center\" valign=\"top\" class=\"Em_L_title\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"11\">\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">25</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">30</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">35</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">40</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">45</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">50</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">&nbsp;</td>\n                                      </tr>\n                                  </table></td>\n                                  <td width=\"24%\" align=\"center\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"11\">\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">34</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">36</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">38</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">40</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">42</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">44</td>\n                                      </tr>\n                                      <tr>\n                                        <td align=\"center\" valign=\"middle\">&nbsp;</td>\n                                      </tr>\n                                  </table></td>\n                                </tr>\n                              </table></td>\n                          </tr>\n                        </table>\n                    </div></td>\n                  </tr>\n                </table></td>\n            </tr>\n          </table></td>\n      </tr>\n      \n      <tr>\n        <td align=\"left\" valign=\"top\">&nbsp;</td>\n      </tr>\n      <tr>\n        <td align=\"left\" valign=\"top\"><table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"EM_Tablecontainer page\"\t>\n            <tr>\n              <td  align=right class=\"EM_L-Count1\"></td>\n              <td align=\"center\">&nbsp;</td>\n              <td></td>\n            </tr>\n            <tr>\n              <td  align=right class=\"EM_L-Count1\"></td>\n              <td align=\"center\">&nbsp;</td>\n              <td></td>\n            </tr>\n            <tr>\n              <td  align=right class=\"EM_L-Count1\"></td>\n              <td align=\"center\">&nbsp;</td>\n              <td></td>\n            </tr>\n            <tr>\n              <td  align=right class=\"EM_L-Count1\"></td>\n              <td align=\"center\">&nbsp;</td>\n              <td></td>\n            </tr>\n            <tr>\n              <td  align=right class=\"EM_L-Count1\"></td>\n              <td align=\"center\">&nbsp;</td>\n              <td></td>\n            </tr>\n            <tr>\n              <td width=\"42%\"  align=right class=\"EM_L-Count1\"></td>\n              <td width=\"35%\" align=\"center\" class=\"EM_Title\" style=\"font-size:14px; font-weight:bold\"> (";
    private final static byte[]  _wl_block12_3Bytes = _getBytes( _wl_block12_3 );

    private final static java.lang.String  _wl_block13 =" ) </td>\n              <td width=\"23%\"></td>\n            </tr>\n            <tr>\n              <td width=\"42%\" align=right class=\"EM_L-Count1\"></td>\n              <td width=\"35%\" align=\"center\" class=\"EM_Title\" style=\"font-size:14px; font-weight:bold\"> Signed By.</td>\n              <td width=\"23%\"></td>\n            </tr>\n        </table></td>\n      </tr>\n    </table>\n    \n  <!--/div-->\n  <input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"/>\n  <input type=\"hidden\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"/>\n  <!--IN067564 starts -->\n  <input type=\"hidden\" name=\"isAuditYN\" id=\"isAuditYN\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"/>\n  <input type=\"hidden\" name=\"Recorded_date\" id=\"Recorded_date\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n  <!--IN067564  ends-->\n  <SCRIPT>\n // displayRecordScore(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\',\'Print\');commented for IN067564\n\tdisplayRecordScore(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\',\'Print\',\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\n\t//window.print();//IN067564\n\tvar printWindow = window;\n\tsetTimeout(function() {  window.close(); printWindow.print() }, ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =");\n</SCRIPT>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );
	
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
Date       		Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/02/2018		IN063837		Ramesh Goli											ML-MMOH-CRF-0812
10/09/2018		IN067564		Ramya Maddena		10/09/2018		Ramesh Goli		ML-MMOH-CRF-1186
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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
//IN067564 starts
String Recorded_date = request.getParameter("Recorded_date")==null?"":request.getParameter("Recorded_date");
String isAuditYN = request.getParameter("isAuditYN")==null?"":request.getParameter("isAuditYN");
//IN067564 ends
String facility_id = (String)session.getAttribute("facility_id");
String login_practitioner_id	= (String) session.getValue("ca_practitioner_id");
java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
String locale = (String) p.getProperty("LOCALE");
String bean_id="@caballardscore"+patient_id;
String bean_name="eCA.CABallardScoreBean";
int note_print_time_interval	=	1500;
eCA.CABallardScoreBean beanObj = (eCA.CABallardScoreBean)getObjectFromBean(bean_id,bean_name,session);
JSONObject jsonObj = beanObj.getBallardScoreHeaderDetails(request, patient_id,facility_id,locale,login_practitioner_id,isAuditYN,encounter_id,Recorded_date);//IN067564
note_print_time_interval=Integer.parseInt((String)jsonObj.get("NOTE_PRINT_TIME_INTERVAL"));

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(jsonObj.get("SITE_NAME") ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(jsonObj.get("FACILITY_NAME") ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(jsonObj.get("PATIENT_NAME") ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(jsonObj.get("EVENT_DATE_TIME") ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(jsonObj.get("PRACTITIONER_NAME") ));
            _bw.write(_wl_block12_0Bytes, _wl_block12_0);
            _bw.write(_wl_block12_1Bytes, _wl_block12_1);
            _bw.write(_wl_block12_2Bytes, _wl_block12_2);
            _bw.write(_wl_block12_3Bytes, _wl_block12_3);
            out.print( String.valueOf(jsonObj.get("LOGIN_PRACTITIONER_NAME") ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(isAuditYN));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(Recorded_date));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(isAuditYN));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(Recorded_date));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(note_print_time_interval ));
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
