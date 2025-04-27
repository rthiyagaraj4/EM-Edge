package jsp_servlet._eipad._jsp._chartwidgets._clinicalevents;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventFieldItem;
import eIPAD.chartsummary.CLEventHistory.response.ClinicalEventsFieldResponse;
import eIPAD.chartsummary.CLEventHistory.daoimpl.ClinicalEventsDAOImpl;
import eIPAD.chartsummary.CLEventHistory.dao.ClinicalEventsDAO;
import eIPAD.chartsummary.clinicalnotes.daoimpl.ClinicalNotesDAOImpl;
import eIPAD.chartsummary.common.healthobject.PatContext;
import java.util.*;
import eIPAD.chartsummary.clinicalnotes.response.*;
import eIPAD.chartsummary.clinicalnotes.healthobject.*;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import java.util.ResourceBundle;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;
import eIPAD.chartsummary.encounterlist.healthobject.EncounterHO;
import com.google.gson.Gson;;

public final class __clinicaleventssfs extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalevents/ClinicalEventsSFS.jsp", 1709118014131L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 ="\n\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=4.0, user-scalable=no\" />\n\n<link rel=\"stylesheet\" href=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="/eIPAD/css/SlideSFS.css\" />\n<!-- <script src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/js/ClinicalEventsSFS.js\"></script> -->\n<script src=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eIPAD/js/iscroll5/iscroll.js\"></script>\n\t\n<!-- main table STARTS -->\n<div class=\"table\" id=\"CNFilterHeader\">\n    <div class=\"row\" ><!-- MR1 -->\n        <div class=\"cell\">\n            <div class=\"table\" style=\"width:100%;\">\n                <div class=\"row SLSfsHeader SLSfsHeaderTheme\">\n                    <div class=\"cell SLSfsHeaderText SLSfsHeaderTextTheme\">SEARCH / FILTER</div>\n                    <div class=\"cell SLSfsHeaderCell\" id=\"refMain\" onclick=\"refreshMain()\"><img src = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/Reload24x24.png\" /></div>\n                    <div class=\"cell SLSfsHeaderCell\"  onclick=\"hideSlideSFS()\"><img src = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/CloseSearch24x24.png\" /></div>\n                </div>\n            </div>\n        </div>\n    </div>\n    \n    ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    <div class=\"row\" id=\"CNFilterContent\"> <!-- MR2 -->\n\t <div class=\"SFSContent\">\n        <div class=\"cell\">\n           \n                <div id=\"SLSfsWrapperMain\">\n                    <div id=\"SLSfsScrollerMain\">\n                        <div class=\"table\" id=\"SLSfsMainTable\" >\n\n\t\t\t\t\t\t\t<!-- Encounter selection STARTS -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\n                            <div class=\"table filterTextWrap\">\n                               <div class=\"row\" id=\"headingEC\" style=\"height:40px\">\n                                <div class=\"cell\">\n\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'EC\')\" style=\"width:100%; height:40px;\">\n                                            <div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >ENCOUNTER</div>\n                                            <div class=\"cell SLSfsHeaderCellTab SLSfsarrow\" id=\"arrowEC\" ><img  src =\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eIPAD/images/DownarrowSFS.png\" /></div>\n                                        </div>\n                                    </div>\n                                </div>\n                            </div>\n                            <div class=\"row\" id=\"contentEC\">\n                                <div class=\"cell\">\n                                    <div class=\"SLSfsNormalView\" id=\"dataEC\">\n\t\t\t\t\t<div id=\"SLSfsWrapperEC\" style=\"background-color: #ffffff;\">\n\t\t\t\t\t\t<div id=\"SLSfsScrollerEC\">\n\t\t\t\t\t\t\t<div class=\"table\" id=\"listEC\" style=\"width:100%; height:100%;\">\n                                                            <input type = \"hidden\" name =\"hdnCurrentEncID\" id =\"hdnCurrentEncID\" value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"/>\n                                                            ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="                                                            \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"listItemEC\" style=\"width:100%; height:40px;\" onclick=\"chooseEncounterFilter(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\',\'clinicalEvents\')\">\n                                                                <div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"\">\n                                                                    <div class=\"\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell\" style=\"vertical-align:middle\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"ipOPText\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n                                                                        <div class=\"cell\">\n                                                                            <p class=\"SFSEncounterId\" >EN ID ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</p>\n                                                                            <p class=\"SFSEncounterDate\" >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" &nbsp ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</p>\n                                                                        </div>\n                                                                    </div>\n                                                                </div>                                                                \n                                                                <div class=\"cell SLSfsListTick SLSfsListTickTheme\"><div class=\"SLSfsTickVisible SLSfsTickVisibleTheme SLSfsCircleVisibleTheme\" id=\"SLSfsTickEN";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" style=\"display:none\"></div></div>\n                                                            </div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"hdnEncIDs\" id =\"hdnEncIDs\" value = \"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"SelectedhdnEncIDs\" id =\"SelectedhdnEncIDs\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\n                                                    </div>\n                                            </div>\n                                        </div>\n                                    </div>\n                                </div>\n                            </div>\n                            </div>\n                            <!-- Encounter selection ENDS -->\n                            <!-- TimeFrame STARTS -->\n                            ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n                            <div class=\"table filterTextWrap\">\n                            <input type = \"hidden\" name =\"hdnDateArrCount\" id =\"hdnDateArrCount\" value = \'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'/>\n                            <input type = \"hidden\" name =\"hdnEncArrCount\" id =\"hdnEncArrCount\" value = \'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'/>\n                            <input type = \"hidden\" name =\"hdnEncounterDate\" id =\"hdnEncounterDate\" value = \'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'/>\n                            <input type = \"hidden\" name =\"hdnEncounterEnc\" id =\"hdnEncounterEnc\" value = \'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'/>\n                            <div class=\"row\" id=\"headingTF\">\n                                <div class=\"cell\">\n                                    <div class=\"table\">\n                                        <div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'TF\')\">\n                                            <div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >TIME FRAME</div>\n                                            <div class=\"cell SLSfsHeaderCellTab \" id=\"arrowTF\" ><img  src =\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/eIPAD/images/DownarrowSFS.png\" /></div>\n                                        </div>\n                                    </div>\n                                </div>\n                            </div>\n                            <div class=\"row\" id=\"contentTF\">\n                                <div class=\"cell\">\n                                    <div class=\"SLSfsNormalView\" id=\"dataTF\">\n                                        <div id=\"SLSfsWrapperTF\"> \n                                            <div id=\"SLSfsScrollerTF\">\n                                                 \n\t\t\t\t\t    <div class=\"table\" id=\"listTF\" style=\"width:100%; height:100%;\">\n                                                    <div class=\"listItemTF\">\n                                                        <div class=\"cell timeFrameSlider\"><div id=\"dateSlider\"><input/> <input/></div></div>\n                                                        <div class=\"rangeLabels\">\n                                                            <span class=\"startLabel\"></span>\n                                                            <span class=\"endLabel\">Today</span>\n                                                        </div>\n                                                        <div class=\"selectedDates\">\n                                                             <input data-role=\"datepicker\" data-bind=\"value:datepickerStartValue, events:{change:selectedDatesChanged}\"/>\n                                                             <input data-role=\"datepicker\"  data-bind=\"value:datepickerEndValue, events:{change:selectedDatesChanged}\"/>\n                                                             <div class=\"timeFrameSearch\" onclick=\"SearchByTimeFrame()\">\n                                                                <div class=\"WidgetButtonTheme\" id=\"btnsfs\">\n                                                                      <img src=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/eIPAD/images/Search18x18.png\" width=\"16px\" ;=\"\" height=\"16px\" style=\"padding-top: 3px;\">\n                                                                 </div>\n                                                            </div>\n                                                                \n                                                        </div>\n                                                    </div>\n                                               </div>\n                                              </div>\n                                        </div>\n                                    </div>\n                                </div>\n                            </div>\n                            </div>\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"Selectedhdnstart\" id =\"Selectedhdnstart\" />\n\t\t\t\t\t\t\t<input type = \"hidden\" name =\"Selectedhdnend\" id =\"Selectedhdnend\" />\n                            <!-- TimeFrame ENDS -->\n                            \n                             <!-- Patient Class STARTS -->\n                            ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t\t\t\t<div class=\"table filterTextWrap\">\n\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingPC\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" onclick=\"CNFilterSectionToggle(\'PC\')\" style=\"width:100%; height:40px;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >PATIENT CLASS</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab \" id=\"arrowPC\" ><img  src =\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="/eIPAD/images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<div class=\"row\" id=\"contentPC\">\n\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataPC\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperPC\" style=\"background-color: #ffffff;\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerPC\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" id=\"listPC\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"PC_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" class=\"listItemPC\" style=\"width:100%; height:40px;\" onclick=\"CNFilterShowTick(\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\',\'PC\')\" data-speccode=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' data-specdesc=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"textPC\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTick SLSfsListTickTheme\" id=\"divPC\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="><div class=\"SLSfsTickVisible SLSfsTickVisibleTheme \" id=\"SLSfsTickPC";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" style=\"display:none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t<input type = \"hidden\" name =\"Selectedhdnpc\" id =\"Selectedhdnpc\" />\t\t\t\t\t\n\t\t\t\t\t\t\t<!-- Patient Class  AncServ ENDS -->\n\t\t\t\t\t\t\t<!-- History Type STARTS -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t\t<div class=\"table filterTextWrap\">\n\t\t\t\t\t\t\t\t<div class=\"row\" id=\"headingHT\" style=\"height:40px\">\n\t\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t\t<div class=\"table\" style=\"width:100%;height:40px\">\n\t\t\t\t\t\t\t\t\t\t\t<div class=\"row SLSfsCategoryBlock\" style=\"width:100%; height:40px;\" onclick=\"CNFilterSectionToggle(\'HT\')\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsDivText SLSfsDivTextTheme\" >HISTORY TYPE</div>\n\t\t\t\t\t\t\t\t\t\t\t<!--<span class=\"clearFilter\" onclick=\"refreshFilter(\'HT\',event)\">CLEAR</span><span class=\"searchByEvents\" onclick=\"searchByEventType(event)\"><img  src =\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="/eIPAD/images/SearchGray16x16.png\" /></span> -->\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsHeaderCellTab \" id=\"arrowHT\" ><img  src =\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="/eIPAD/images/DownarrowSFS.png\" /></div>\n\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t<div class=\"row\" id=\"contentHT\">\n\t\t\t\t\t\t\t\t<div class=\"cell\">\n\t\t\t\t\t\t\t\t\t<div class=\"SLSfsNormalView\" id=\"dataHT\">\n\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsWrapperHT\" style=\"height:100%; width:100%; background-color: #ffffff;\">\n\t\t\t\t\t\t\t\t\t\t\t<div id=\"SLSfsScrollerHT\">\n\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"table\" id=\"listHT\" style=\"width:100%; height:100%;\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div id=\"HT_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" class=\"listItemHT\" style=\"width:100%; height:40px;\" onclick=\"CNFilterShowTick(\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',\'HT\')\" data-speccode=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class= \"cell SLSfsViewItemText SLSfsViewItemTextTheme\" id=\"textHT";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"cell SLSfsListTick SLSfsListTickTheme\" id=\"divHT";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t<div class=\"SLSfsTickVisible SLSfsTickVisibleTheme\" id=\"SLSfsTickHT";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" style=\"display:none\"></div></div>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t\t \t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\t\t\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t  \t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t<input type = \"hidden\" name =\"SelectedhdnHT\" id =\"SelectedhdnHT\" />\n\t\t\t\t\t\t\t<!-- History Type ENDS -->\n\t\t\t\t\t\t\t</div>\n                        </div>\n                    </div>\n                </div>\n            </div>\n            \n        </div>\n    </div>\n</div>\n<script>\ndocument.addEventListener(\'touchmove\', function(e) {\n    e.preventDefault();\n}, false);\n$.extend($.expr[\":\"], { //search as you type\n    \"containsIN\": function(elem, i, match, array) {\n        return (elem.textContent || elem.innerText || \"\").toLowerCase().indexOf((match[3] || \"\").toLowerCase()) >= 0;\n    }\n});\n\nvar SLSfsScrollMain;\nvar SLSfsScrollHT;\nvar SLSfsScrollPC;\nvar SLSfsScrollEC;\n\nvar arrHT = [];\nvar arrPC = [];\n\nvar i;\nvar j = 0;\nvar selectedDateArr = [];\nvar finalEndDate;\nvar finalStartDate;\n\n/*\n$(\"#searchInputSFSHT\").keyup(function() {\n    var rows = $(\"#listHT\").find(\".listItemPC\").hide();    \n    if (this.value.length) {\n        var data = this.value.split(\" \");\n        $.each(data, function(i, v) {\n            var val = v.toLowerCase();\n            rows.filter(\":containsIN(\'\" + val + \"\')\").show();\n        });\n    } else rows.show();\n});\n*/\n\nfunction CNFilterLoaded() {\n    SLSfsScrollMain = new IScroll(\'#SLSfsWrapperMain\', {\n        scrollbars: true,\n        click: true,\n        mouseWheel: true\n    });\n    SLSfsScrollEC = new IScroll(\'#SLSfsWrapperEC\', { scrollbars: true, click: true,  mouseWheel: true } );\t\n    SLSfsScrollHT = new IScroll(\'#SLSfsWrapperHT\', { scrollbars: true, click: true,  mouseWheel: true } );\n    SLSfsScrollPC = new IScroll(\'#SLSfsWrapperPC\', { scrollbars: true, click: true,  mouseWheel: true } );\t\n}\n\nfunction hideSlideSFS() {\n    $(\'#EventsSideSFS\').hide();\n\t$(\'#EventsMainViewContent\').show();//added\n    $(\'#ChartSummaryBlock\').css({\n        \'width\': \'100%\'\n    });\n    $(\"#SlideOpener\").show();\n    $(\'.eventsMainPanel\').show();\n    $(\'.FilterOpenMsg\').hide();\n    setHeightAndBase();\n    CEMainScroll.refresh();\n}\n\n$(document).on(\"swipeleft\", \"#SLSfsWrapperMain\", function(e) {\n    hideSlideSFS();\n});\n\nfunction refreshMain() {\n\n\t\n\t $(\'#SelectedhdnEncIDs\').val(\"\");\n\t $(\'#Selectedhdnstart\').val(\"\");\n\t $(\'#Selectedhdnend\').val(\"\");\n\t $(\'#Selectedhdnpc\').val(\"\");\n\t $(\'#SelectedhdnHT\').val(\"\");\n\t    \n\t    \n    if (SLSfsScrollHT != undefined)\n        SLSfsScrollHT.refresh();\n\n    if (SLSfsScrollPC != undefined)\n        SLSfsScrollPC.refresh();\n\n\t$(\"#listHT\").find(\".listItemHT\").show();\n\t$(\"#listPC\").find(\".listItemPC\").show();\n\t$(\".SLSfsTickVisible\").hide();\n\t$(\".SLSfsAfterSelectionTheme\").hide();\n\tchooseEncounterFilter(\"\", \'clinicalEvents\');\n}\n\nfunction CNFilterShowTick(val, type) {    \n    if (type == \"HT\") {\n\t\tarrHT = [];\n\t\tif ($(\"#SLSfsTickHT\" + val).is(\":visible\")) {\n\t\t\t$(\"#SLSfsTickHT\" + val).hide();\n\n        } else {\n\t\t\tarrHT.push(val);\n\t\t\t$(\'div[id^=\"SLSfsTickHT\"]\').hide();//added\n\t\t\t$(\"#SLSfsTickHT\" + val).show();\n\t\t}\n\t}\n\tif (type == \"PC\") {\n\t\tarrPC = [];\n        if ($(\"#SLSfsTickPC\" + val).is(\":visible\")) {\n            $(\"#SLSfsTickPC\" + val).hide();\n            $(\'div[id^=\"SLSfsTickPC\"]\').hide();\n\t\t}else{\n\t\t\tarrPC.push(val);\n\t\t\t$(\'div[id^=\"SLSfsTickPC\"]\').hide();\n\t\t\t$(\"#SLSfsTickPC\" + val).show();\n\t\t}\n\t}\n\t$(\"#Selectedhdnpc\").val(arrPC);\n\t$(\"#SelectedhdnHT\").val(arrHT);\n\tclinicalEventsFilter(finalStartDate,finalEndDate,arrHT, arrPC);\t\n\t if (SLSfsScrollHT != undefined)\n        SLSfsScrollHT.refresh();\n\n    if (SLSfsScrollPC != undefined)\n        SLSfsScrollPC.refresh();\n}\n\nfunction searchByEventType(event) {\n    event.stopPropagation();\n    clinicalEventsFilter(arrHT, arrPC);\n}\nfunction CNFilterSectionToggle(current) {\t\n    $(\"#content\" + current).toggle();\n    $(\"#textBox\" + current).toggle();\n    $(\"#ViewMore\" + current).toggle();\n\t\n    if ($(\"#content\" + current).is(\":visible\")) {\t\t\n\t\t$(\"#arrow\" + current).addClass(\'SLSfsarrow\');\n    } else {\n\t\t$(\"#arrow\" + current).removeClass(\'SLSfsarrow\');\n    }\n\t\n\tSLSfsScrollMain.refresh();\n\t\n\tif(SLSfsScrollEC != null){\n\tSLSfsScrollEC.refresh();}\n\t\n\tif(SLSfsScrollPC != null){\n\t\tSLSfsScrollPC.refresh();}\n\t \n\tif(SLSfsScrollHT != null){\n\t\tSLSfsScrollHT.refresh();}\n}\n\nfunction removeInblockItem(val, type) {\n    if (type == \"HT\") {\n        $(\"#inBlockItem\" + val).remove();\n        $(\"#SLSfsTickHT\" + val).hide();\n        var index = arrHT.indexOf(val);\n        arrHT.splice(index, 1);\n        if (arrHT.length < 1) {\n            $(\"#NTAfterSel\").hide();\n            $(\"#AfterSelectionHT\").html(\'\');\n            SLSfsScrollHT.refresh();\n        }\n    }\n    if (type == \"PC\") {\n        $(\"#inBlockItem\" + val).remove();\n        $(\"#SLSfsTickPC\" + val).hide();\n        var index = arrPC.indexOf(val);\n        arrPC.splice(index, 1);\n        if (arrPC.length < 1) {\n            $(\"#PCAfterSel\").hide();\n            $(\"#AfterSelectionPC\").html(\'\');\n            SLSfsScrollPC.refresh();\n        }\n    }\n\n    clinicalEventsFilter(arrHT, arrPC);\n}\n/*refresh filetr*/\nfunction refreshFilter(current, event) {\n    event.stopPropagation();\n    if (current == \'HT\') {\n        arrHT = [];\n        $(\'div[id^=\"SLSfsTickHT\"]\').hide();\n        $(\"#AfterSelectionHT\").html(\'\');\n        SLSfsScrollHT.refresh();\n    }\n\n    clinicalEventsFilter(arrHT, arrPC);\n}\n\n/*time frame slider start*/\n\nvar dateArrayStr = $(\"#hdnEncounterDate\").val();\nvar dateArrSize = $(\"#hdnDateArrCount\").val();\ndateArray = $.parseJSON(dateArrayStr);\nvar encArrSize = $(\"#hdnEncArrCount\").val();\nvar datePos = dateArrSize - 1;\nvar encPos = encArrSize - 1;\nvar cuurentDate = new Date();\nvar currDate = new Date();\nvar startDate = dateArray[datePos].split(\" \")[0].split(\"/\");\nvar prevDate = new Date();\nprevDate.setDate(startDate[0]);\nprevDate.setMonth(startDate[1] - 1);\nprevDate.setYear(startDate[2]);\nprevDate.setHours(0, 0, 0);\ncuurentDate.setHours(0, 0, 0);\nparent.setTimeFrame = function() {\n        $(\'.startLabel\').text(kendo.toString(prevDate, \'d MMM yyyy\'));\n        var viewModel = kendo.observable({\n            selectedStartDate: prevDate,\n            selectedEndDate: cuurentDate,\n            datepickerStartValue: prevDate,\n            datepickerEndValue: cuurentDate,\n            selectedDateRange: [],\n            pickerStartTime: \'\',\n            pickerEndTime: \'\',\n            selectedDatesChanged: function() {\n                //to set slider on select date picker\n                if (viewModel.selectedEndDate.getTime() <= viewModel.datepickerStartValue.getTime()) {\n                    alert(\"start date should be less than current date\");\n                    viewModel.set(\'datepickerStartValue\', viewModel.selectedStartDate);\n                    viewModel.set(\"pickerStartTime\", viewModel.selectedStartDate.getTime());\n                }\n                if (viewModel.selectedStartDate.getTime() > viewModel.datepickerEndValue.getTime()) {\n                    alert(\"end date should not be less than start date\");\n                    viewModel.set(\'datepickerEndValue\', viewModel.selectedEndDate);\n                    viewModel.set(\"pickerEndTime\", viewModel.selectedEndDate.getTime())\n                }\n                if (viewModel.selectedStartDate.getTime() <= viewModel.datepickerStartValue.getTime()) {\n                    //does not allow to select lesser date of start date\n                    viewModel.pickerStartTime = viewModel.datepickerStartValue.getTime();\n                } else {\n                    alert(\"select correct daterange\");\n                    viewModel.set(\'datepickerStartValue\', viewModel.selectedStartDate);\n                    viewModel.set(\"pickerStartTime\", viewModel.selectedStartDate.getTime());\n\n                }\n                if (viewModel.selectedEndDate.getTime() >= viewModel.datepickerEndValue.getTime()) {\n                    //does not allow to select greater date of end date\n                    viewModel.pickerEndTime = viewModel.datepickerEndValue.getTime();\n                } else {\n                    alert(\"select correct daterange\");\n                    viewModel.set(\'datepickerEndValue\', viewModel.selectedEndDate);\n                    viewModel.set(\"pickerEndTime\", viewModel.selectedEndDate.getTime())\n                }\n                viewModel.updateDateSlider();\n            },\n            dateStart: \'\',\n            dateEnd: \'\',\n            dateRangeChanged: function() {\n\n                var dateRange = $(\"#dateSlider\").data(\"kendoRangeSlider\").value();\n                var startdate = kendo.toString(new Date(dateRange[0]), \'d MMM yyyy\');\n                var enddate = kendo.toString(new Date(dateRange[1]), \'d MMM yyyy\');\n                viewModel.set(\'dateStart\', startdate);\n                viewModel.set(\'dateEnd\', enddate);\n                viewModel.set(\'selectedDateRange\', dateRange);\n                //to set datepicker on drag \n                viewModel.set(\'datepickerStartValue\', new Date(dateRange[0]));\n                viewModel.set(\'datepickerEndValue\', new Date(dateRange[1]));\n            },\n            updateDateSlider: function() {\n                if (viewModel.selectedStartDate <= viewModel.selectedEndDate) {\n                    // reinitialize the date slider, since sliders do not support dynamic changes\n                    var slider = $(\"#dateSlider\").data(\"kendoRangeSlider\");\n                    if (slider) {\n                        var wrapper = slider.wrapper;\n                        var element = slider.element;\n                        slider.destroy();\n                        wrapper.before(element.show());\n                        wrapper.remove();\n                    }\n                    $(\"#dateSlider\").kendoRangeSlider({\n                        largeStep: 86400000,\n                        smallStep: 86400000,\n                        min: viewModel.selectedStartDate.getTime(),\n                        max: viewModel.selectedEndDate.getTime(),\n                        tickPlacement: \'none\',\n                        value: [viewModel.selectedStartDate.getTime(), viewModel.selectedEndDate.getTime()],\n                        selectionStart: (viewModel.pickerStartTime == \'\') ? viewModel.selectedStartDate.getTime() : viewModel.pickerStartTime,\n                        selectionEnd: (viewModel.pickerEndTime == \'\') ? viewModel.selectedEndDate.getTime() : viewModel.pickerEndTime,\n                        tooltip: {\n                            template: kendo.template(\'#=kendo.toString(new Date(selectionStart), \\\'M/d/yyyy\\\' ) # to #=kendo.toString(new Date(selectionEnd), \\\'M/d/yyyy\\\' ) #\')\n                        },\n                        change: viewModel.dateRangeChanged\n                    });\n\n                    viewModel.resizeSliders();\n                    viewModel.dateRangeChanged();\n                }\n            },\n            resizeSliders: function() {\n                // resize the sliders to fill the container\n                var sliders = $(\"[data-role=\'rangeslider\']\");\n                sliders.each(function(index, ele) {\n                    var slider = $(ele).getKendoRangeSlider();\n                    slider.wrapper.css(\"width\", \"100%\");\n                });\n            }\n        });\n\n        kendo.bind(\'body\', viewModel);\n        viewModel.updateDateSlider();\n        viewModel.resizeSliders();\n    }\n    //search by time frame\n\n\nfunction SearchByTimeFrame() {\n    var dateRange = $(\"#dateSlider\").data(\"kendoRangeSlider\").value();\n    var startdate = kendo.toString(new Date(dateRange[0]), \'d MMM yyyy\');\n    var enddate = kendo.toString(new Date(dateRange[1]), \'d MMM yyyy\');\n    var startDateformat = kendo.toString(new Date(startdate), \'yyyy/MM/dd\');\n    var startDateformatfinal = startDateformat.split(\'\\/\');\n    finalStartDate = startDateformatfinal[0] + \'-\' + startDateformatfinal[1] + \'-\' + startDateformatfinal[2];\n\n    var endDateformat = kendo.toString(new Date(enddate), \'yyyy/MM/dd\');\n    var endDateformatfinal = endDateformat.split(\'\\/\');\n    finalEndDate = endDateformatfinal[0] + \'-\' + endDateformatfinal[1] + \'-\' + endDateformatfinal[2];\n\t$(\'#Selectedhdnstart\').val(finalStartDate);\n\t$(\'#Selectedhdnend\').val(finalEndDate);\n\tarrPC.length=0;\n\tarrHT.length=0;\n\tEncountersInRange(finalStartDate, finalEndDate,arrPC,arrHT);\t\n}\n\n$(document).ready(function() {\n\n    CNFilterLoaded();\n    parent.setTimeFrame();\n    //arrow setting intial for EC\n\n    if ($(\"#contentEC\").is(\":visible\")) {\n        $(\"#arrowEC\").addClass(\'SLSfsarrow\');\n    }\n\n    $(document).on(\"click\", \"#SlideOpener\", function() {\n\n    });\n\n    $(\"#contentTF\").hide();\n    $(\"#contentPC\").hide();\n    $(\"#contentHT\").hide();\n    $(\"#textBoxHT\").hide();\n\n\tif(SLSfsScrollEC != null){\n\t\tSLSfsScrollEC.on(\'beforeScrollStart\', function () {\n\t\t\tSLSfsScrollMain.disable();\n\t\t});\n\t\tSLSfsScrollEC.on(\'scrollEnd\', function () {\n\t\t\tSLSfsScrollMain.enable();\n\t\t});\n\t}\n\t\n\tif(SLSfsScrollPC != null){\n\t\tSLSfsScrollPC.on(\'beforeScrollStart\', function() {\n\t\t\tSLSfsScrollMain.disable();\n\t\t});\n\n\t\tSLSfsScrollPC.on(\'scrollEnd\', function() {\n\t\t\tSLSfsScrollMain.enable();\n\t\t});\n\t}\n\t\n\tif(SLSfsScrollHT != null){\n\t\tSLSfsScrollHT.on(\'beforeScrollStart\', function() {\n\t\t\tSLSfsScrollMain.disable();\n\t\t});\n\t\tSLSfsScrollHT.on(\'scrollEnd\', function() {\n\t\t\tSLSfsScrollMain.enable();\n\t\t});\n\t}\t\n\n    $(\'#SLSfsWrapperMain\').on(\'touchstart click\', function() {\n        SLSfsScrollMain.enable();\n    });\n});\n</script>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
    
	PatContext patientContext = (PatContext)session.getAttribute("PatientContext"); //Patient context to bring data stored in session
	Gson gson = new Gson();
	String jsonFieldResDate = "";
	String jsonFieldResEnc = "";   
    
            _bw.write(_wl_block9Bytes, _wl_block9);
EncounterListResponse allEncountersResp = (EncounterListResponse)request.getAttribute("EncounterListResponse");
							ArrayList<EncounterHO> allEncArrayList = new ArrayList<EncounterHO>();
							EncounterHO currentEncounter = new EncounterHO();
							if(allEncountersResp!=null && allEncountersResp.isSuccessResponse() && !allEncountersResp.isEmptyDataResponse()){
								allEncArrayList = allEncountersResp.getEncounterList();
								currentEncounter = allEncArrayList.get(0);
							}
                            
                            String selectedEncounter = "";
                            boolean secondaryEncSelected = false;
                            int selectedEncIndex = 0;
                            if(patientContext.getSelectedEncounterId()!= null && !patientContext.getSelectedEncounterId().equals("")){
                                selectedEncounter = patientContext.getSelectedEncounterId();
                                secondaryEncSelected = true;
							}
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(currentEncounter.getEncounterId()));
            _bw.write(_wl_block12Bytes, _wl_block12);
String shdnEncIDs="";
							    if(allEncArrayList!=null && allEncArrayList.size()>0){
                                                                for(int i=0;i<allEncArrayList.size();i++){
                                                                    EncounterHO iEncounter = allEncArrayList.get(i);															
								    shdnEncIDs=shdnEncIDs+iEncounter.getEncounterId()+",";
                                                                    if(secondaryEncSelected && selectedEncounter.equals(iEncounter.getEncounterId())){
                                                                        selectedEncIndex = i;
									}
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(iEncounter.getPatientClass()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(iEncounter.getFromDate() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(iEncounter.getToDate()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(iEncounter.getEncounterId()));
            _bw.write(_wl_block19Bytes, _wl_block19);
}}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(shdnEncIDs));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(shdnEncIDs));
            _bw.write(_wl_block22Bytes, _wl_block22);

                            ArrayList<String> dateArray = new ArrayList<String>();
                            ArrayList<String> encArray = new ArrayList<String>();
                            
                            for(int i=0;i<allEncArrayList.size();i++){ 
                            EncounterHO EncounterLst = allEncArrayList.get(i);
                            dateArray.add(EncounterLst.getFromDate());
                            encArray.add(EncounterLst.getEncounterId());
                            }
                            int hdnDateArrCount = dateArray.size();
                            int hdnEncArrCount = encArray.size();
                            jsonFieldResDate = gson.toJson(dateArray);
                            jsonFieldResEnc = gson.toJson(encArray);
                            
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(hdnDateArrCount));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(hdnEncArrCount));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(jsonFieldResDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(jsonFieldResEnc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block29Bytes, _wl_block29);
	ClinicalEventsDAO daoImpl= new ClinicalEventsDAOImpl();
                            ClinicalEventsFieldResponse  patientClassResp=   daoImpl.getEventsPatientClassList(patientContext);
                            
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
if(patientClassResp.isSuccessResponse() && !patientClassResp.isEmptyDataResponse()){
															ArrayList<ClinicalEventFieldItem> fieldItems = patientClassResp.getFieldItems();
															for(int i=0;i<fieldItems.size();i++) {
																ClinicalEventFieldItem patientClassItems=fieldItems.get(i);
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(patientClassItems.getCode()));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( patientClassItems.getCode()));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( patientClassItems.getCode()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( patientClassItems.getDesc()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( patientClassItems.getCode()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(patientClassItems.getDesc()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( patientClassItems.getCode()));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( patientClassItems.getCode()));
            _bw.write(_wl_block40Bytes, _wl_block40);
}}
            _bw.write(_wl_block41Bytes, _wl_block41);
								
							ClinicalEventsFieldResponse  histTypeResp=   daoImpl.getEventHistoryTypeList(patientContext);
							
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block44Bytes, _wl_block44);
if(histTypeResp.isSuccessResponse() && !histTypeResp.isEmptyDataResponse()){
															ArrayList<ClinicalEventFieldItem> fieldItems = histTypeResp.getFieldItems();															
															for(int i=0;i<fieldItems.size();i++) {
																ClinicalEventFieldItem careItem = fieldItems.get(i);
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(careItem.getCode()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(careItem.getCode()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(careItem.getCode()));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(careItem.getDesc()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( careItem.getCode()));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( careItem.getDesc() ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( careItem.getCode()));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( careItem.getCode()));
            _bw.write(_wl_block52Bytes, _wl_block52);
}}
            _bw.write(_wl_block53Bytes, _wl_block53);
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
