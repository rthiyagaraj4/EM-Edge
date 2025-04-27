package jsp_servlet._eipad._jsp._chartwidgets._clinicalevents;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLEventTabSingle;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLTabSub;
import eIPAD.chartsummary.CLEventHistory.healthobject.CLTab;
import eIPAD.chartsummary.CLEventHistory.request.ClinicalEventsFilterRequest;
import eCA.GetDynamicComponents;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDataFieldsItem;
import java.util.ArrayList;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventHistDataResponse;
import eIPAD.chartsummary.CLEventHistory.bc.ClinicalEventsBC;
import eIPAD.chartsummary.common.response.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.Locale;
import java.util.Arrays;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.lang.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;
import eIPAD.pendingresults.*;

public final class __clinicaleventselectedview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalevents/ClinicalEventSelectedView.jsp", 1669269483979L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n\r\n<!DOCTYPE html>\r\n<html>\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\r\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" /> \r\n\r\n\r\n</head>\r\n<body>\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<div id=\"clinicalEventPreviewPane\" class=\"table clinicalEventPreviewPaneCss ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="_";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\t\r\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t \r\n\t<div class=\"row\">\r\n        <div class=\"cell\" style=\"width:100%;height:auto;\">\r\n            <div class=\"clinicalEventPreviewWrapper\" data-role=\"none\">\r\n               <div style=\"float: left; width: calc(100% - 45px);\">\r\n                  <div style=\"display: table;\"  data-role=\"none\">\r\n                     <div style=\"display: table-row;\" data-role=\"none\">\r\n                        <div class=\"clinicalEventPreviewHeader\" data-role=\"none\">\r\n                           ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n                        </div>\r\n                     </div>\r\n                  </div>\r\n                  <div style=\"display: table;\"  data-role=\"none\">\r\n                     <div style=\"display: table-row;\" data-role=\"none\">\r\n                        <div class=\"clinicalEventPreviewEID\" data-role=\"none\">\r\n                           <span style=\"font-size: 11px;color: #7393a4;\">Encounter Id :\r\n                           </span>\r\n                           <span style=\"font-size: 12px;color: #032b3f;\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n                           </span>\r\n                        </div>\r\n                     </div>\r\n                  </div>\r\n               </div>\r\n               <div style=\"float: left; width: 45px;\">\r\n                  <div class=\"clinicalEventPreviewPatientClass\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</div>\r\n               </div>\r\n               <div style=\"clear: both;\"></div>\r\n            </div>\r\n        </div>\r\n    </div>\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="  \r\n<div id=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" \r\ndata-iscrollId=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" class=\"row eventsHeaderCss\">\r\n   <div style=\"width: auto;position: absolute;\">\r\n   <ul style=\"white-space: nowrap;padding-left:0px;padding-bottom:0px;margin-bottom: 0px;\">\r\n   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t   <li class=\"defaultHeader\" id=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="_list\" data-ids=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="_list\" data-default=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" data-currentSection=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" data-allSection=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" onclick=\"onClickHeader(this)\">\r\n\t\t  <div class=\"listContainer\">\r\n\t\t     <div class=\"listHeading\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</div> \r\n\t\t     <div class=\"listCount\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</div>\r\n\t\t  </div>\r\n\t   </li>\r\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\r\n  </ul>\r\n  </div>\t\r\n</div>\r\n</div>\r\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\r\n<div style=\"background: #f5f7fb;height: auto;width: 99.7%;display:none;margin-top:5px;\" id=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\r\n <div class=\"clinicalNoteEventContent\" style=\"display: table;width: 99%;margin-right: 5px;margin-left: 5px;margin-top: 2px;margin-bottom: 3px;\" data-role=\"none\">\r\n                  <div style=\"display: table-row;width: 100%;height: 30px;\" data-role=\"none\">\r\n                     <div class=\"clinicalEventContainerCell\" data-role=\"none\">\r\n                        <div class=\"clinicalEventTimer\" style=\"padding-top: 1px !important;\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\r\n                        </div>                  \r\n                     </div>                    \r\n                     <div style=\"display: table-cell;vertical-align: middle;color: #696969; font-size: 13px;font-weight: bold;font-family: arial;\">\r\n                     ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n                     </div>                     \r\n                  </div>\r\n             </div> \r\n   <div class=\"table\" style=\"width:100%;height:100%;table-layout: fixed;\">\r\n   <div class=\"row\" style=\"width:100%;height:100%;\">\r\n      <div id=\"pat";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" data-htm=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" class=\"cell\" style=\"position: relative;width:100%;height:100%;\">            \r\n          <div  style=\"height: auto;width:auto;border :1px solid #0d7ba0;background: #ffffff;word-break: break-word;text-align: justify;margin-left: 8px;margin-bottom: 4px;margin-right: 4px;overflow: hidden;\" class=\"clinicalEventHTMLContainer\"  data-role=\"none\">\r\n            ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n            </div>   \r\n     </div>\r\n  </div>\r\n</div>\r\n</div>\r\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  \r\n  <div style=\"background: #f5f7fb;display:none;width:99.7%;margin-top:5px;\" id=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\r\n     <div class=\"cell\" style=\"width:100%;height:auto;\">\r\n        <div class=\"clinicalEventContainerWrapper\" data-num=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" data-role=\"none\">\r\n           <div class=\"clinicalNoteEventContent\" style=\"display: table;width: 99.7%;margin-left: 5px;margin-top: 2px;margin-bottom: 3px;\" data-role=\"none\">\r\n              <div class=\"clinicalEventContainerRow60px\" data-role=\"none\">\r\n                 <div class=\"clinicalEventContainerCell\" style=\"background-color:#f5f7fb;\" data-role=\"none\">\r\n                    <div class=\"clinicalEventTimer\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n                    </div>\r\n                    <div style=\"text-align: -webkit-center;\">\r\n                       <hr id=\"num_";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" class=\"CNVerticalLine\"/>\r\n                    </div>\r\n                 </div>\r\n                 <div class=\"clinicalEventContainerData\" data-role=\"none\">\r\n                    <div style=\"display: table;width: 100%;\">\r\n                       <div class=\"clinicalEventContainerRow30px\" data-role=\"none\">\r\n                          <div class=\"clinicalEventContainerDataInnerCell\" data-role=\"none\">\r\n                             ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\r\n                          </div>\r\n                       </div>\r\n                       <div class=\"clinicalEventContainerRow30px\" data-role=\"none\">\r\n                          <div style=\"display: table-cell;width: 100%;\">\r\n                             <div style=\"display: table;width: 100%;\">\r\n                                <div class=\"clinicalEventContainerRow30px\" data-role=\"none\">\r\n                                   <div class=\"clinicalEventContainerCellDataLeft\" data-role=\"none\">\r\n                                     ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\t\r\n\t\t\t\t\t\t\t\t\t  <div style=\"display:inline-block;width: 30px;vertical-align: middle;text-align: center;padding-bottom: 0px;\"> \r\n                                   \t\t\t\t\t\t\t\t  \r\n                                      ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\r\n                                         <img src=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="/eIPAD/images/IND_CriticallyHigh24x24.png\"/>\r\n                                       ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="/eIPAD/images/IND_CriticallyLow24x24.png\"/>\r\n                                       ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="/eIPAD/images/IND_Abnormal24x24.PNG\"/>\r\n                                       ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="/eIPAD/images/IND_Critical24x24.PNG\"/>\r\n                                       ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="/eIPAD/images/IND_Low24x24.png\"/>\r\n                                       ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="/eIPAD/images/IND_High24x24.png\"/>\r\n                                       ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="/eIPAD/images/IND_NORMAL24x24.png\"/>                                        \r\n                                       ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="                                         \r\n                                      </div>\r\n\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\r\n\t\t\t\t\t\t\t\t\t  <div style=\"display:none;width: 30px;vertical-align: middle;text-align: center;padding-bottom: 0px;\"> \r\n                                      </div>\r\n\t\t\t\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="   \r\n\t\t\t\t\t\t\t\t\t  \r\n\t\t\t\t\t\t\t\t\t  \r\n                                      <div style=\"display:inline-block;font-size: 13px;font-family: arial;padding-top: 8px;padding-left: 5px;\">\r\n                                         <span style=\"color: #5f5f5f;font-weight: bold;\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</span>\r\n                                         <span style=\"color: #a6a6a6;font-weight: normal;\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</span>\r\n                                      </div>\r\n                                   </div>\r\n                                   <div class=\"clinicalEventContainerCellDataRight\" data-role=\"none\">\r\n                                   ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\r\n                                      <span>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" - ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" </span> \r\n                                      <span>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</span>\r\n                                     ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\r\n                                   </div>\r\n                                </div>\r\n                             </div>\r\n                          </div>\r\n                       </div>\r\n                 ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\r\n                       <div class=\"clinicalEventContainerRow30px\"  data-role=\"none\">\r\n                          <div class=\"clinicalEventContainerDataInnerCell\" style=\"font-weight: normal !important;\" data-role=\"none\">\r\n                             <div id=\"clinicalEventContainerSizing\" style=\"word-wrap:break-word;\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</div>\r\n                          </div>\r\n                       </div>\r\n                      ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =" \r\n                    </div>\r\n                 </div>\r\n              </div>\r\n           </div>\r\n        </div>\r\n     </div>\r\n  </div> \r\n </div>     \r\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="   \r\n <div style=\"background: #f5f7fb;display:none;width:99.7%;margin-top:5px;\" id=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\r\n     <div class=\"cell\" style=\"width:100%;height:auto;\">\r\n        <div  class=\"clinicalEventContainerWrapper\" data-str=";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" data-role=\"none\">\r\n           <div class=\"clinicalNoteEventContent\" style=\"display: table;width: 99.7%;margin-left: 5px;margin-top: 2px;margin-bottom: 3px;\" data-role=\"none\">\r\n              <div class=\"clinicalEventContainerRow60px\" data-role=\"none\">\r\n                 <div class=\"clinicalEventContainerCell\" data-role=\"none\">\r\n                    <div class=\"clinicalEventTimer\">";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\r\n                    </div>\r\n                    <div style=\"text-align: -webkit-center;\">\r\n                       <hr id=\"str_";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\r\n                          </div>\r\n                       </div>\r\n                       <div class=\"clinicalEventContainerRow30px\" data-role=\"none\">\r\n                          <div style=\"display: table-cell;width: 100%;\">\r\n                             <div style=\"display: table;width: 100%;\">\r\n                                <div class=\"clinicalEventContainerRow30px\" data-role=\"none\">\r\n                                   <div class=\"clinicalEventContainerCellDataLeft\" data-role=\"none\">\r\n                                       ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\r\n\t\t\t\t\t\t\t\t\t     <div class=\"numericStringFormat\"> \r\n                                         <img src=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="/eIPAD/images/IND_CriticallyHigh24x24.png\"/>\r\n\t\t\t\t\t\t\t\t\t\t </div>\r\n                                       ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\r\n\t\t\t\t\t\t\t\t\t     <div class=\"numericStringFormat\">  \r\n                                         <img src=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="/eIPAD/images/IND_CriticallyLow24x24.png\"/>\r\n\t\t\t\t\t\t\t\t\t\t </div>\r\n                                       ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="/eIPAD/images/IND_Abnormal24x24.PNG\"/>\r\n\t\t\t\t\t\t\t\t\t\t </div>\r\n                                       ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="/eIPAD/images/IND_Critical24x24.PNG\"/>\r\n\t\t\t\t\t\t\t\t\t\t </div>\r\n                                       ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="/eIPAD/images/IND_Low24x24.png\"/>\r\n\t\t\t\t\t\t\t\t\t\t </div>\r\n                                       ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="/eIPAD/images/IND_High24x24.png\"/>\r\n\t\t\t\t\t\t\t\t\t\t </div>\r\n                                       ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\r\n\t\t\t\t\t\t\t\t\t   <div class=\"numericStringFormat\"> \r\n                                         <img src=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="/eIPAD/images/IND_NORMAL24x24.png\"/>   \r\n                                        </div>\t\t\t\t\t\t\t\t\t\t \r\n                                       ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\r\n                                      <div style=\"display:inline-block;padding:5px;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;color: #5e6466;\">\r\n                                         <span>";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</span>\r\n                                      </div>\r\n                                   </div>\r\n                                </div>\r\n                             </div>\r\n                          </div>\r\n                       </div>\r\n                    </div>\r\n                 </div>\r\n              </div>\r\n           </div>\r\n        </div>\r\n     </div>\r\n  </div> \r\n  </div>   \r\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\r\n</body>\r\n";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\r\n\r\n<style>\r\n.activeHeader{\r\n\t\r\n\tpadding-left: 15px;\r\n\tpadding-right: 15px;\r\n\tpadding-bottom: 11.5px;\r\n\tfont-size: 14px;\r\n\tfont-family: arial;\r\n\tcolor: #2c80a3;\r\n\tfont-weight: bold;\r\n\tdisplay: inline-block;\r\n\tlist-style-type: none;\r\n\tborder-bottom: 3px solid #2c80a3;\r\n}\r\n.defaultHeader{\r\n\tpadding-left: 15px;\r\n\tpadding-right: 15px;\r\n\tpadding-bottom: 11.5px;\r\n\tfont-family: arial;\r\n\tfont-size: 14px;\r\n\tcolor: #032b3f;\r\n\tfont-weight: bold;\r\n\tdisplay: inline-block;\r\n\tlist-style-type: none;\r\n}\r\n</style>\r\n\r\n<script>\r\nvar headerTabScroll;\r\nfunction assignheaderTabScroll() {\r\n\t$(\"div[data-iscrollId]\").each(function() {\r\n\t\tvar iscrollIds = $(this).attr(\'data-iscrollId\');\r\n\t\theaderTabScroll = new IScroll(\'#\'+iscrollIds, { \r\n\t\tscrollX: true, \r\n\t\tscrollY: false, \r\n\t\tscrollbars: false,\r\n\t\tinteractiveScrollbars: true,\r\n\t\tclick: true,\r\n\t\tuseTransition: false,\r\n\t\tbindToWrapper: true\r\n\t});\r\n\t\tif(headerTabScroll!=null){\r\n\t\t\theaderTabScroll.refresh();\r\n\t\t}\r\n\t});\t \r\n\t\r\n\t\r\n\t\r\n}\r\n\r\nfunction showRecords(){\r\n\t $(\"li[data-default]\").each(function() {\r\n\t\t   var initRecord = $(this).attr(\'data-default\');     \r\n           \r\n\t\t   if(initRecord==\"start\"){        \t   \r\n        \t var allOpenIds=   $(this).attr(\'data-currentSection\');\r\n        \t var list_ids = $(this).attr(\'data-ids\');\r\n        \t var currentSelection = allOpenIds.split(\",\");\t\t\t\r\n\t\t\t $(\"#\"+list_ids).removeClass(\'defaultHeader\');\r\n\t         $(\"#\"+list_ids).addClass(\'activeHeader\');\r\n        \t \r\n\t         for(var p=0;p<currentSelection.length;p++){\r\n        \t\tvar currentSingleId= currentSelection[p];        \t\t\r\n        \t\t$(\'#\'+currentSingleId).css(\'display\',\'table\');  \r\n        \t}     \t\r\n           }        \r\n\t});\r\n\tsetHeightAndBase();\t\t\r\n}\r\n\r\nfunction showClinicalTimeLine(){\r\n\t $(\"div[data-str]\").each(function() {\r\n\t\t var titleValue = $(this).attr(\'data-str\');\t\t   \r\n         var timerHRLine = $(this).height()-31;     \r\n         $(\"#str_\"+titleValue).height(timerHRLine); \r\n\t});\t \r\n\t $(\"div[data-num]\").each(function() {\r\n\t\t var titleValue = $(this).attr(\'data-num\');\r\n\t\t var timerHRLine = $(this).height()-31;\r\n         $(\"#num_\"+titleValue).height(timerHRLine); \r\n\t});\t\r\n}\r\n\r\n$(document).ready(function(){\t\t\t\t\r\n\t$(\'.clinicalEventHTMLContainer\').find(\'td\').css({\"vertical-align\":\"top\"});\r\n\tshowRecords();\r\n\tshowClinicalTimeLine();\r\n\tassignheaderTabScroll();\t\r\n});\r\n\r\nvar previouslySelectedHeader=\"\";\r\n\r\nfunction onClickHeader(current){\r\n    var all_ids = $(current).attr(\'data-allsection\');\r\n\tvar list_ids = $(current).attr(\'data-ids\');\r\n\tvar newValues = [];\r\n\tnewValues = all_ids.split(\',\');\r\n    \t\r\n\tfor(var i=0;i<newValues.length;i++){\r\n\t\tvar currentIds = newValues[i];\t\r\n\t\t$(\"#\"+currentIds).css(\'display\',\'none\');\t\t\t\r\n\t\tvar string = currentIds,\r\n          substring = \"_list\";        \r\n\t\tvar checkString = string.indexOf(substring) > -1;\r\n\t\t\r\n\t\tif(!checkString){\r\n\t\t  $(\"#\"+currentIds+\"_list\").removeClass(\'activeHeader\');\r\n\t\t  $(\"#\"+currentIds+\"_list\").addClass(\'defaultHeader\');\r\n\t\t}\r\n\t\t\r\n\t}\t\r\n\tvar allOpenIds = $(current).attr(\'data-currentsection\');\r\n    var currentSelection = allOpenIds.split(\",\");\r\n    \r\n    for(var p=0;p<currentSelection.length;p++){\r\n        var currentSingleId= currentSelection[p];\t\t\r\n\t\tif(currentSingleId!=\"\"){\t\t\r\n\t\t\t$(\'#\'+currentSingleId).css(\'display\',\'table\');  \t\r\n\t\t}        \r\n    }\r\n    \r\n    showClinicalTimeLine();\r\n\tCEMainScroll.refresh();\t\r\n\tsetHeightAndBase();\r\n\r\n\tif(previouslySelectedHeader != null && previouslySelectedHeader != \"\"){\r\n\t\t$(\"#\"+previouslySelectedHeader).removeClass(\'activeHeader\');\r\n\t    $(\"#\"+previouslySelectedHeader).addClass(\'defaultHeader\');\r\n\t}\r\n\t\t\r\n\t$(\"#\"+list_ids).removeClass(\'defaultHeader\');\r\n\t$(\"#\"+list_ids).addClass(\'activeHeader\');\t\r\n\tpreviouslySelectedHeader = list_ids;\r\n}\r\n\r\nshowRecords();\r\n\r\n</script>\r\n</html>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);


String lastEventAcces="";
String lastEventType="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");

ClinicalEventsBC bc= new ClinicalEventsBC();
String dates = request.getParameter("date");
String pos = request.getParameter("pos");
String[] dateformat = dates.split("\\-");

if(dateformat[1].length()==2){
	dates = dateformat[2]+"/"+dateformat[1]+"/"+dateformat[0];
}else{
	dates = dateformat[2]+"/0"+dateformat[1]+"/"+dateformat[0];
}

String originalDate = request.getParameter("date");

String selectedEncId = request.getParameter("selected_encd");

String startFilterDate = request.getParameter("startFilterDate");
String endFilterDate = request.getParameter("endFilterDate");
String PCFilter = request.getParameter("PCFilter");
String HTFilter = request.getParameter("HTFilter");

ClinicalEventsFilterRequest eventsReq = new ClinicalEventsFilterRequest();
eventsReq.setPatientContext(patContext);
eventsReq.setSelectedDate(dates);

if(!selectedEncId.equalsIgnoreCase("")){
String[] encounterArray = selectedEncId.split(",");

ArrayList encList = new ArrayList(Arrays.asList(encounterArray));	
eventsReq.setEncounterIdList(encList);
}else{
	ArrayList encList = new ArrayList();
	eventsReq.setEncounterIdList(encList);
}

if(!startFilterDate.equalsIgnoreCase("")){

eventsReq.setFromDate(startFilterDate);
}else{
	eventsReq.setFromDate(startFilterDate);
	
}

if(!endFilterDate.equalsIgnoreCase("")){

eventsReq.setToDate(endFilterDate);
}else{
	
	eventsReq.setToDate(endFilterDate);
}

if(!PCFilter.equalsIgnoreCase("")){

eventsReq.setPatientClass(PCFilter);
}else{
	
	eventsReq.setPatientClass(PCFilter);
}

if(!HTFilter.equalsIgnoreCase("")){

eventsReq.setHistoryType(HTFilter);
}else{
	
	eventsReq.setHistoryType(HTFilter);
}
String lastEventAccestab="";
String lastEventTypetab="";
ArrayList<String> allTab=null;
ArrayList<String> allTabUniqueIds=null;
ArrayList<String> uniqueListIds=null;
ArrayList<String> allUniqueIds=null;
allTab =new ArrayList<String>();
allTabUniqueIds =new ArrayList<String>();
uniqueListIds = new ArrayList<String>();
allUniqueIds =new ArrayList<String>();

ArrayList<CLEventTabSingle> CLEventsHistoryTabArrayList =new ArrayList<CLEventTabSingle>();

ArrayList<String> allIds= new ArrayList<String>();

ArrayList<String> allIdsIndu= new ArrayList<String>();

ClinicalEventHistDataResponse getHits=bc.getDatewiseSelectedEventsHistory(eventsReq);
ArrayList<ClinicalEventDataFieldsItem> eventsList = getHits.getEventDataList();

ArrayList<CLTab> allEvents= new ArrayList<CLTab>();

String lastEventAccestabs="";
String lastEventTypetabs="";

for(int m=0;m< eventsList.size();m++){
	ClinicalEventDataFieldsItem items=eventsList.get(m);
	String eventTypeHeader = items.getHistRecTypeDesc();
	String eventCategory = items.getEventClassDesc();
	String eventTypeHeaderCode = items.getHistRecType();
	String eventCategoryCode = items.getEventClass();
	
 CLTab tab =new CLTab();
 tab.setDate(originalDate);
 tab.setMainItem(eventTypeHeader);
 tab.setSubItem(eventCategory);
 tab.setSubItemPos(m);
 tab.setHeadCode(eventCategoryCode);
 
 if(!lastEventAccestabs.equalsIgnoreCase(eventTypeHeader)){
	 
	 tab.setStart("start");
 }else{
	 
	 tab.setStart("middle");
 }
 
 lastEventAccestabs=eventTypeHeader;
 allEvents.add(tab);
	
}

ArrayList<CLTabSub> allSubIds=null;
for(int z=0;z< eventsList.size();z++){
	
	ClinicalEventDataFieldsItem items=eventsList.get(z);	
	String eventTypeHeader = items.getHistRecTypeDesc();
	String eventCategory = items.getEventClassDesc();
	String eventTypeHeaderCode = items.getHistRecType();
	String eventCategoryCode = items.getEventClass();
	eventCategoryCode = eventCategoryCode.replaceAll("[-+.^:,$]","");
	
	ArrayList<ArrayList<String>> allEventsRealtedid= new ArrayList<ArrayList<String>>();	
	ArrayList<String> allCurrentEventIds= new ArrayList<String>();
	if(eventTypeHeader!=null){	
		allSubIds =new ArrayList<CLTabSub>();
		for(int f=0;f<allEvents.size();f++){
			String eventCategoryCode1 = items.getEventClass();
			eventCategoryCode1 = eventCategoryCode.replaceAll("[-+.^:,$]","");
			
			 CLTab tab =allEvents.get(f);
			 String mainTitle=tab.getMainItem();
			 String subTitle=tab.getSubItem();
			 String start=tab.getSubItem();
			 int subPos=tab.getSubItemPos();
			 String headCode=tab.getHeadCode();
			 headCode = headCode.replaceAll("[-+.^:,$]","");
			 String unique= originalDate+"_"+eventTypeHeaderCode+"_"+headCode+"_"+f;
			 if(mainTitle.equalsIgnoreCase(eventTypeHeader)){				 
				 CLTabSub sub= new CLTabSub();
				 sub.setHeadInfo(mainTitle);
				 sub.setSubInfo(subTitle);
				 sub.setPos(f);
				 sub.setStart(start);
				 sub.setUniqueId(unique);
				 allSubIds.add(sub);				 
			 }			
		}
	}	
	CLEventTabSingle singleTabItem =new CLEventTabSingle();	
	singleTabItem.setDate(originalDate);

    if(!lastEventAccestab.equalsIgnoreCase(eventTypeHeader)){		
	    singleTabItem.setIsStart("start");
	}else{	
		singleTabItem.setIsStart("middle");
	}
    lastEventAccestab=eventTypeHeader;	
	ArrayList<String> removeDup =new ArrayList<String>();
    
	for(int d=0;d<allSubIds.size();d++){
		CLTabSub subInfo=allSubIds.get(d);
		removeDup.add(subInfo.getSubInfo());
	}
	LinkedHashSet<String> listToSet = new LinkedHashSet<String>(removeDup);
	ArrayList<String> listWithoutDuplicates = new ArrayList<String>(listToSet);
		
	singleTabItem.setTabAllvalues(listWithoutDuplicates);
	for(int k=0;k<listWithoutDuplicates.size();k++){
		String allSeclectionId="";
		String allSeclectionUniqueId="";
		ArrayList<String> addUnique =new ArrayList<String>();
				    
		for(int e=0;e<allSubIds.size();e++){					
			CLTabSub subInfo=allSubIds.get(e);
				if(subInfo.getSubInfo().equalsIgnoreCase(listWithoutDuplicates.get(k))){
					allSeclectionUniqueId=allSeclectionUniqueId+subInfo.getUniqueId();
					addUnique.add(subInfo.getUniqueId());					 
					allCurrentEventIds.add(subInfo.getUniqueId());
				} 
			}
			allEventsRealtedid.add(addUnique);
		}		 
		singleTabItem.setTabSelectionValues(allEventsRealtedid);		 
		singleTabItem.setTabValues(allCurrentEventIds);
		CLEventsHistoryTabArrayList.add(singleTabItem);
}

for(int i=0;i< eventsList.size();i++){	
    ClinicalEventDataFieldsItem items=eventsList.get(i);	
    String eventTypeHeaderCode = items.getHistRecType();
    String eventCategoryCode = items.getEventClass();	

    eventCategoryCode = eventCategoryCode.replaceAll("[-+.^:,$]","");

    String eventTypeHeader = items.getHistRecTypeDesc() != null  ? items.getHistRecTypeDesc() : "";	
    String eventCategory = items.getEventClassDesc() != null  ? items.getEventClassDesc() : "";
    String clinicalNoteType = items.getEventDesc() != null  ? items.getEventDesc() : "";
    String histData=items.getHistDataType();
    String histDataCode=items.getHistRecType();
    String data = "";
    String dateHeader = dates;
    CLEventTabSingle tabs=CLEventsHistoryTabArrayList.get(i);


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(histDataCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(request.getParameter("date")));
            _bw.write(_wl_block4Bytes, _wl_block4);

	if(!lastEventAcces.equalsIgnoreCase(eventTypeHeader)){
		lastEventType ="";		
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eventTypeHeader));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(items.getEncounterId()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(items.getPatient_class() ));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
}
   lastEventAcces=eventTypeHeader; 
   if("start".equalsIgnoreCase(tabs.getIsStart())){

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(eventTypeHeaderCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventCategoryCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(i));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(eventTypeHeaderCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventCategoryCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(i));
            _bw.write(_wl_block11Bytes, _wl_block11);
	
	ArrayList<String> allTabEvents= tabs.getTabAllvalues();
		CLEventTabSingle singleTabItem = tabs;		
		for(int h=0;h<allTabEvents.size();h++){
			String defalutLoad="";			
			if(h==0){				
				 defalutLoad="start";				 
			}else{				
				defalutLoad="middle";
			}			 
			ArrayList<ArrayList<String>> currentSelection =singleTabItem.getTabSelectionValues();
			ArrayList<String> allSection =singleTabItem.getTabValues();			 
			ArrayList<String>  currentSingleSelection =currentSelection.get(h);
			String categoryIds = currentSingleSelection.get(0);
			String listString1 = "";

			for (String s : currentSingleSelection)
			{
			    listString1 += s + ",";
			}			 
			String listString2 = "";
			for (String s : allSection){
			    listString2 += s + ",";
			}	
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(categoryIds));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(categoryIds));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(defalutLoad ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(listString1 ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(listString2 ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(allTabEvents.get(h)));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(currentSingleSelection.size()));
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
   }	
  
            _bw.write(_wl_block20Bytes, _wl_block20);

if(histData.equalsIgnoreCase("HTM") || histData.equalsIgnoreCase("HTML")){
	lastEventAcces=eventTypeHeader;	
	lastEventType =eventCategory ;			
	PreparedStatement  pstmt1=null;
	ResultSet  rs1=null;
	String locale=patContext.getLocale();		
	Connection  con = null;
	String footer_code = null;//IN030859
	String report_header_code = null;//IN030859		
	PreparedStatement  pstmt2 = null;
	ResultSet  rs2 =	null;
	String performed_by_id	=	"" ;
	String patient_class =	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String facility_name =	"" ;
	String visit_adm_date	=	"" ;
	String attending_practitioner	=	"" ;
	String admitting_practitioner	=	"" ;
	String bed_number	=	"" ;
	String performing_phy_name	=	"" ;
	String age	=	"" ;
	String gender	=	"" ;
	String patient_name	=	"" ;
	String speciality_name	=	"" ;
	String printDateTime	=	"" ;
	String site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String pract_sign = "";
	String query_privilege_type	=	"" ;
	String url1					=	"";
	String url						=	"";
	String		episode_type	=	"" ;
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	String accessionnum="";
	String extimageobjid="";
	String acc_for_notefooter="";
	String patientid="";
	String requrl = request.getRequestURL().toString();
	String requri = request.getRequestURI();
    url = requrl.substring( 0, requrl.indexOf(requri) ) + request.getContextPath();
    url1  	=		url + "/eCA/html/RecClinicalNotesTemplateDispayView.xsl";
	
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String eventdatetime="";
	String encounter_id = items.getEncounterId();
	String enc_id = items.getEncounterId();
	String enctr_id = items.getEncounterId();
	String fac_id=items.getFacilityId();
	String contr_mod_accession_num="";		
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	HashMap<String,String> paramMap = null;
	extimageobjid="";
	eventdatetime=items.getEventDateTimeStr();		
	accessionnum=items.getAccessionNum();
	patientid=patContext.getPatientId();
	String cal_eventdate 		= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en","en");//IN040090
	String eventdatetime_th	= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en",locale);
	con =  ConnectionManager.getConnection(request);
	try
	{
		if(	episode_type.equals("O") )
		{
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //uncommentted - [IN033977 for IN040199] //IN045646 get_desc for specialty_name changed from 2 to 1
		}
		else
		{ 
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //uncommentted - [IN033977 for IN040199] //IN045646 get_desc for specialty_name changed from 2 to 1
		}	
		pstmt1	=	con.prepareStatement(query_privilege_type);	
		pstmt1.setString	(	1,	locale	);
		pstmt1.setString	(	2,	locale	);
		pstmt1.setString	(	3,	locale	);
		pstmt1.setString	(	4,	locale	);
		pstmt1.setString	(	5,	performed_by_id	);
		pstmt1.setString	(	6,	locale	);
		pstmt1.setString	(	7,	locale	);			
		pstmt1.setString	(	8,	locale	);			
		pstmt1.setString	(	9,	locale	);			
		pstmt1.setString	(	10,	locale	);			
		pstmt1.setString	(	11,	items.getFacilityId()	);//IN033489
		pstmt1.setString	(	12,	items.getEncounterId());	
		rs1		=	pstmt1.executeQuery();	
		if(rs1.next())
		{
			patient_class	=	rs1.getString("patient_class") == null ? "" : rs1.getString("patient_class");
			facility_name			=	rs1.getString("facility_name") == null ? "" : rs1.getString("facility_name");
			visit_adm_date			=	rs1.getString("visit_adm_date")==null?"":rs1.getString("visit_adm_date");
			med_service			=	rs1.getString("service_name")==null?"":rs1.getString("service_name");
			discharge_date		=	rs1.getString("DISCHARGE_DATE_TIME")==null?"":rs1.getString("DISCHARGE_DATE_TIME");
			attending_practitioner	=	rs1.getString("attending_practitioner")==null?"":rs1.getString("attending_practitioner");
			admitting_practitioner	=	rs1.getString("admitting_practitioner")==null?"":rs1.getString("admitting_practitioner");
			bed_number	=	rs1.getString("bed_number")==null?"":rs1.getString("bed_number");	  //--[IN:029839]--
			performing_phy_name	=	rs1.getString("performed_by_name")==null?"":rs1.getString("performed_by_name");
			age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
			gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");
			location_code			=	rs1.getString("location_code")==null?"":rs1.getString("location_code");
			patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
			speciality_name			=	rs1.getString("specialty_name")==null?"":rs1.getString("specialty_name");
			printDateTime			=	rs1.getString("print_date_time")==null?"":rs1.getString("print_date_time");
			site_name			=	rs1.getString("site_name")==null?"":rs1.getString("site_name");
		}
		if(gender.equals("M"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if (gender.equals("F"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		else 
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			if(discharge_date==null)
			{
				discharge_date="";
			}
			if(patient_class.equals("OP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			else if(patient_class.equals("IP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			else if(patient_class.equals("EM"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			else if(patient_class.equals("DC"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs1!=null)	rs1.close();
		if(pstmt1!=null)	pstmt1.close();
	}
					try
					{
						String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
						pstmt2	= con.prepareStatement(head_foot_qry);
						pstmt2.setString(1,items.getContr_sys_event_code());
						rs2 = pstmt2.executeQuery();
						
						while(rs2.next())
						{
							footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
							report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
						}
					}
					catch(Exception ee)
					{
						out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
						ee.printStackTrace();
					}
					finally
					{
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();
					}
					 String sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;						
					try
					{
						pstmt2	= con.prepareStatement(sect_template_query);
						pstmt2.setString(1,report_header_code);
						rs2 = pstmt2.executeQuery();
						if(rs2.next())
						{
							clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");							
							if(clob_notes_content!=null)
							{
								try
								{
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content = new String(arr_notes_content);
									bf_content_reader.close();
									if(section_content == null)
										section_content = "";
								}
								catch(Exception e)
								{
									out.println("Exception@1-readCLOB : "+e);
									e.printStackTrace();
								}
							}
						}
					}
					catch(Exception eee)
					{
						out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
						eee.printStackTrace();
					}
					finally
					{
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();						
					}
	
					if(!accessionnum.equals(""))
					{
						try
						{
							String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

							pstmt2	= con.prepareStatement(athorise_by_qry);
							pstmt2.setString(1,locale);
							pstmt2.setString(2,locale);
							pstmt2.setString(3,locale);
							pstmt2.setString(4,locale);
							if(accessionnum.contains("!"))
								acc_for_notefooter = extimageobjid;
							else
								acc_for_notefooter = accessionnum;
							pstmt2.setString(5,acc_for_notefooter);
							pstmt2.setString(6,patientid);
							rs2 = pstmt2.executeQuery();
							while(rs2.next())
							{
								authorized_by		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
								last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
								doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996						
							}
						}
						catch (Exception roro )

						{
							out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());
							roro.printStackTrace();
						}
						finally 
						{
							if(rs2 != null) rs2.close();
							if(pstmt2 != null) pstmt2.close();							
						}
					}									
					encounter_id1 = enc_id ;
					if(enc_id.equals("0"))
					{
						encounter_id1 ="";
					}
		
					if(!visit_adm_date.equals(""))
					{
						visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
					}
		
					if(!discharge_date.equals(""))
					{
						discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
					}
					htParameter.put("V$ATT_PRACT", attending_practitioner);
					htParameter.put("V$ADM_PRACT", admitting_practitioner);
					htParameter.put("V$BED_NUM", bed_number);	//---[IN:029839]---
					htParameter.put("V$PT_SPLTY", speciality_name);
					if(patient_name.trim().equals(""))
						htParameter.put("V$PT_NAME", default_pat_name);
					else
						htParameter.put("V$PT_NAME", patient_name);
					htParameter.put("V$PT_ID", patientid);
					htParameter.put("V$SEX", Sex);
					htParameter.put("V$AGE", age);
					htParameter.put("V$ENC_ID", enctr_id);//IN031989
					htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
					htParameter.put("V$DIS_DT", discharge_date); //discharge_date
					htParameter.put("V$MED_SERV", med_service);
					htParameter.put("V$DOC_REF_H", doc_ref_id);
					htParameter.put("V$PT_LOCN", location_code); //patient_loc
					htParameter.put("V$PT_CLASS", patient_class);//patient_class
					StringBuffer section_content_new = new StringBuffer(section_content);
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}

	if(!section_content_new.toString().equals(""))
	{
		//***************************** [CRF-118] Start *****************************					
		eCA.GetDynamicComponents dynamicCompDetails = new GetDynamicComponents();
		HashMap paramHash=new HashMap();
		Hashtable tempParameter=new Hashtable();
		paramHash.put("#p_patient_id#",patientid);
		paramHash.put("#p_encounter_id#",enctr_id);		
		paramHash.put("#p_accNum#",accessionnum);
		paramHash.put("#p_locale#",locale);
		paramHash.put("#p_eventDate#",cal_eventdate);//IN039562//IN040090
		paramHash.put("#p_facility_id#",fac_id);	
		paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 		
		tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
		if(tempParameter.size()>0){					
		htParameter.putAll(tempParameter);
		}
		//*****************************[CRF-118] Ends *****************************
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}

	if(!(sectionContentUpdatedXML.toString().equals("")))
	{								
		section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);	
	}	
	section_content= "";	
	try
	{	
		pstmt2	= con.prepareStatement(sect_template_query);
		pstmt2.setString(1,footer_code);
		rs2 = pstmt2.executeQuery();
		if(rs2.next())
		{
			clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
			if(clob_notes_content!=null)
			{
				try
				{
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
				
					if(section_content == null)
					section_content = "";
				}
				catch(Exception e)
				{
					out.println("Exception@1-readCLOB : "+e);
					e.printStackTrace();
				}
			}
		}
	}

	catch(Exception eee)
	{
		out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
		eee.printStackTrace();
	}
	finally
	{
		if(rs2 != null) rs2.close();
		if(pstmt2 != null) pstmt2.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(!printDateTime.equals(""))
	{
		printDateTime =	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
	}
	htParameter=new Hashtable();
	htParameter.put("V$CUR_USR", patContext.getLoggedInUser());
	htParameter.put("V$AT_PRACT", authorized_by);
	htParameter.put("V$LT_MODI_USR", last_amended_by);
	htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
	htParameter.put("V$DOC_REF_F", doc_ref_id);
	htParameter.put("V$LT_PT_P_C_D", pract_sign);
	section_content_new = new StringBuffer(section_content);	
	if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
	{													
		eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
		HashMap paramHash=new HashMap();
		Hashtable tempParameter=new Hashtable();
	
		paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
		paramHash.put("#p_accNum#",accessionnum);
		paramHash.put("#p_locale#",locale);
		paramHash.put("#p_pract_id#",patContext.getClinicianId());
		tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);	
		if(tempParameter.size()>0)
		{					
			htParameter.putAll(tempParameter);
		}
	}
	sectionContentUpdatedXML = new StringBuffer();
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",footer_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}
	if(!(sectionContentUpdatedXML.toString().equals("")))
	{									
		section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
	}	
	String  resultstr= items.getResultStr(); 
    if(resultstr==null){	
	  resultstr="";
    }
	StringBuffer displaydata = null;
	
	if(!section_content_rpt.equals(""))
	{
		data= "<table  cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>";//IN030859
	}
	else{
		data= "";//IN030859		
	}
	String displaydataTemp=items.getHistData();
	if(!resultstr.equals("") ||!displaydataTemp.equals("") )
	{
		data=data+"<PRE style='word-wrap:break-word;'>"+resultstr+"</PRE>  <table  cellpadding='0' cellspacing='4' width='100%'><tr><td>"+displaydataTemp+"</td></tr></table><BR>";
	}
	else{
		data= data;//IN030859		
	}
	if(!section_content_ftr.equals(""))
	{
	data= data+"<table cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>";//IN030859
	}
	else{
		data= data;//IN030859		
	}
	Date dat= items.getEventDateTime();
	String hrs = "";
	if(dat.getHours() != 0){
		if(dat.getHours() < 10){
			hrs = "0"+dat.getHours(); 
		}
		else{
			hrs =""+dat.getHours(); 
		}
	}
	else{
		    hrs="00";
	}
	String mns = "";
	if(dat.getHours() != 0){
		if(dat.getMinutes() < 10){
			mns = "0"+dat.getMinutes(); 
		}
		else{
			mns =""+dat.getMinutes(); 
		}
	}
	else{
		    mns="00";
	}
	String eventTime = hrs+":"+mns;

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(originalDate));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventTypeHeaderCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventCategoryCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(eventTime));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinicalNoteType));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            out.print( String.valueOf(request.getParameter("date")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            out.print( String.valueOf(request.getParameter("date")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(data));
            _bw.write(_wl_block27Bytes, _wl_block27);
 } 
else if(histData.equalsIgnoreCase("NUM")){	

String encounterID =items.getEncounterId() != null  ? items.getEncounterId() : "";
String criticality = items.getNormalcyInd() != null  ? items.getNormalcyInd() : "";
String deciresult = items.getDeciresult() != null  ? items.getDeciresult() : "";

String encounterType = items.getPatient_class() != null  ? items.getPatient_class() : "";
Date dat= items.getEventDateTime();
String hrs = "";
if(dat.getHours() != 0){
	if(dat.getHours() < 10){
		hrs = "0"+dat.getHours(); 
	}
	else{
		hrs = ""+dat.getHours(); 
	}
}
else{
	hrs="00";
}
String mns = "";
if(dat.getHours() != 0){
	if(dat.getMinutes() < 10){
		mns = "0"+dat.getMinutes(); 
	}
	else{
		mns = ""+dat.getMinutes(); 
	}
}
else{
	    mns="00";
}
String eventTime = hrs+":"+mns;
String resultUnit = items.getResultNumUom() != null  ? items.getResultNumUom() : "";
String resultNormalRangeLow =items.getNormalLow() != null  ? items.getNormalLow() : "";
String resultNormalRangeHigh =items.getNormalHigh() != null  ? items.getNormalHigh() : "";
String resultNormalUnit = items.getResultNumUom() != null  ? items.getResultNumUom() : "";

 String numResult=items.getResult_Number_values()  != null  ? items.getResult_Number_values() : "";  
 String numberRes = numResult.replace("&nbsp;","");
   lastEventType=eventCategory; 
   String displaydata=items.getHistData();
	data="";
	String  resultstr= items.getResultStr(); 
	if(resultstr==null){		
		resultstr="";
	}
	Clob note;
	
	note=items.getNote();
	StringBuffer displaydatas= new StringBuffer();
	
				if(note!=null)
				{
					java.io.BufferedReader	r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;	
					while((line=r.readLine()) != null) displaydatas.append(line+"\n");
				}

	if(displaydata.length() >0)
	{
		String displaydataTemp = ((String)(displaydatas.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","")).trim();
		data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+displaydataTemp+"</PRE>";
		if(resultstr!=null && !resultstr.equals("")){
			data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+resultstr+"</PRE><BR>";
		} 
	}
	else{
		data=resultstr+" "+displaydatas.toString();
	}
 
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(originalDate));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventTypeHeaderCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventCategoryCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            out.print( String.valueOf(request.getParameter("date")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(eventTime));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            out.print( String.valueOf(request.getParameter("date")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clinicalNoteType));
            _bw.write(_wl_block33Bytes, _wl_block33);
 if(!criticality.equals("")){ 
            _bw.write(_wl_block34Bytes, _wl_block34);
 if(criticality.equals("G")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);
 } else if(criticality.equals("S")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block37Bytes, _wl_block37);
 } else if(criticality.equals("A")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block38Bytes, _wl_block38);
 } else if(criticality.equals("C")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block39Bytes, _wl_block39);
 } else if(criticality.equals("L")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block40Bytes, _wl_block40);
 } else if(criticality.equals("H")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block41Bytes, _wl_block41);
 } else if(criticality.equals("N")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block42Bytes, _wl_block42);
 } 
            _bw.write(_wl_block43Bytes, _wl_block43);
 }
									  else{ 
            _bw.write(_wl_block44Bytes, _wl_block44);
 } 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(numberRes));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(resultUnit));
            _bw.write(_wl_block47Bytes, _wl_block47);
 if(!resultNormalRangeLow.equals("")){
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(resultNormalRangeLow));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(resultNormalRangeHigh));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(resultNormalUnit));
            _bw.write(_wl_block51Bytes, _wl_block51);
 } 
            _bw.write(_wl_block52Bytes, _wl_block52);
 

                 String remStr = data;
                 remStr = remStr.replace("&nbsp;","");
                   if(!remStr.equalsIgnoreCase(" ")){
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(data));
            _bw.write(_wl_block54Bytes, _wl_block54);
 } 
            _bw.write(_wl_block55Bytes, _wl_block55);


} else if(histData.equalsIgnoreCase("STR") ||  histData.equalsIgnoreCase("TXT") ){
	
	String criticality = items.getNormalcyInd() != null  ? items.getNormalcyInd() : ""; 
		
	String convertedHTML3 = items.getEventDesc();
	String convertedHTML4 = items.getEncounterId();	
	String convertedHTML5 = items.getResultStr();
	String encounterType = items.getPatient_class() != null  ? items.getPatient_class() : "";
	Date dat= items.getEventDateTime();
	String hrs = "";
	if(dat.getHours() != 0){
		if(dat.getHours() < 10){
			hrs = "0"+dat.getHours(); 
		}
		else{
			hrs =""+dat.getHours(); 
		}
	}
	else{
		    hrs="00";
	}
	String mns = "";
	if(dat.getHours() != 0){
		if(dat.getMinutes() < 10){
			mns = "0"+dat.getMinutes(); 
		}
		else{
			mns =""+dat.getMinutes(); 
		}
	}
	else{
		    mns="00";
	}
	String eventTime = hrs+":"+mns;

   lastEventType=eventCategory;  
   
   String displaydata=items.getHistData();
	data="";
	String  resultstr= items.getResultStr(); 
	if(resultstr==null){		
		resultstr="";
	}
	Clob note;
	
	note=items.getNote();
	StringBuffer displaydatas= new StringBuffer();
	
				if(note!=null)
				{
					java.io.BufferedReader	r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;	
					while((line=r.readLine()) != null) displaydatas.append(line+"\n");
				}

	if(displaydata.length() >0)
	{
		String displaydataTemp = ((String)(displaydatas.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","")).trim();
		if(resultstr!=null && !resultstr.equals("")){
			data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+resultstr+"</PRE><BR>";
		} 
		data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+displaydataTemp+"</PRE>";
	}
	else{
		data=resultstr+" "+displaydatas.toString();
	}
 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(originalDate));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventTypeHeaderCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(eventCategoryCode));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            out.print( String.valueOf(request.getParameter("date")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(eventTime));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            out.print( String.valueOf(request.getParameter("date")));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(convertedHTML3));
            _bw.write(_wl_block60Bytes, _wl_block60);
 if(!criticality.equals("")){ 
										 if(criticality.equals("G")){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block62Bytes, _wl_block62);
 } else if(criticality.equals("S")){ 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block64Bytes, _wl_block64);
 } else if(criticality.equals("A")){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block65Bytes, _wl_block65);
 } else if(criticality.equals("C")){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block66Bytes, _wl_block66);
 } else if(criticality.equals("L")){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block67Bytes, _wl_block67);
 } else if(criticality.equals("H")){ 
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block68Bytes, _wl_block68);
 } else if(criticality.equals("N")){ 
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block70Bytes, _wl_block70);
 }
									   }
									   
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( data ));
            _bw.write(_wl_block72Bytes, _wl_block72);

}
            _bw.write(_wl_block73Bytes, _wl_block73);
 
}

            _bw.write(_wl_block74Bytes, _wl_block74);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
