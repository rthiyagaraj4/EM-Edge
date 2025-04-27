package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.DiaryView.bc.DiaryViewBC;
import eIPAD.DiaryView.request.DiaryViewRequest;
import eIPAD.DiaryView.response.DiaryViewResponse;
import eIPAD.chartsummary.common.response.ErrorInfo;
import eIPAD.DiaryView.healthobject.AppointmentBlockItem;
import eIPAD.DiaryView.healthobject.AppointmentDetailItem;
import eIPAD.DiaryView.healthobject.OPApptDetailItem;
import eIPAD.DiaryView.healthobject.OTApptDetailItem;
import eIPAD.DiaryView.healthobject.OTProcDetail;
import eIPAD.DiaryView.response.OTProcDetailResponse;
import java.util.*;
import java.lang.Object;
import java.text.SimpleDateFormat;
import org.joda.time.Period;

public final class __diaryviewdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/DiaryViewDetail.jsp", 1709118026037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="   \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n<script type=\"application/javascript\" src=\"../js/iscroll.js\"></script>\n\n<!-- TODO indent the code completely, add comments to code blocks -->\n<script>\n$(document).ready(function() {\n//TODO move this comment inside the js function\n\t//this piece of code is to add an empty block to the end of the page so that even the last date scrolls to the top when its corresponding date is selected\naddEmptyDiv();\n\t\n});\n/* var currentExpanded = \"\";\nfunction expandedView(count)\n{\n\tif(currentExpanded !=\"\")\n\t{\n\t\t$(\'.expandedView\'+currentExpanded).toggle();\n\t\t$(\'.collapsedView\'+currentExpanded).toggle();\n\t}\n\t$(\'.expandedView\'+count).toggle();\n\t$(\'.collapsedView\'+count).toggle();\n\tif($(\'.expandedView\'+count).is(\':visible\'))\n\t{\n\t\tcurrentExpanded = count;\t\n\t}\n\telse\n\t\tcurrentExpanded = \"\";\n\tif(scrollContent1){\n\t\tscrollContent1.refresh();\n\t}\n} */\n  var currentExpanded ;\nvar prevExpanded;\nfunction expandedView(count)\n{\n\tcurrentExpanded = count;\n\n\tif(prevExpanded !=null)\n\t\t{\n\t\n\t\tif(currentExpanded != prevExpanded)\n\t\t\t{\n\t\t$(\'#OT_DPD_Patient\'+prevExpanded).removeClass(\'OT_DPD_Patient_Exp\').addClass(\'OT_DPD_Patient\');\n\t\t$(\'#DPD_Date-Con\'+prevExpanded).removeClass(\'DPD_Date-Con_Exp\').addClass(\'DPD_Date-Con\');\n\t\t$(\'.expandedView\'+prevExpanded).hide();\n\t\t$(\'#OT_DPD_Patient\'+currentExpanded).removeClass(\'OT_DPD_Patient\').addClass(\'OT_DPD_Patient_Exp\');\t\n\t\t$(\'#DPD_Date-Con\'+currentExpanded).removeClass(\'DPD_Date-Con\').addClass(\'DPD_Date-Con_Exp\')\n\t\t$(\'.expandedView\'+currentExpanded).show();\n\t\t\t}\n\t \telse  \n\t\t\t{\n\t\t\tif($(\'.expandedView\'+currentExpanded).is(\':visible\'))\n\t\t\t\t{\n\t\t\t\t/*  $(\'#OT_DPD_Patient\'+prevExpanded).removeClass(\'OT_DPD_Patient_Exp\').addClass(\'OT_DPD_Patient\');\n\t\t\t\t$(\'#DPD_Date-Con\'+prevExpanded).removeClass(\'DPD_Date-Con_Exp\').addClass(\'DPD_Date-Con\');\n\t\t\t\t$(\'.expandedView\'+prevExpanded).hide();  */\n\t\t\t\t}\n\t\t\telse\n\t\t\t\t{\n\t\t\t\t$(\'#OT_DPD_Patient\'+currentExpanded).removeClass(\'OT_DPD_Patient\').addClass(\'OT_DPD_Patient_Exp\');\t\n\t\t\t\t$(\'#DPD_Date-Con\'+currentExpanded).removeClass(\'DPD_Date-Con\').addClass(\'DPD_Date-Con_Exp\')\n\t\t\t\t$(\'.expandedView\'+currentExpanded).show();\n\t\t\t\t}\n\t\t\t}\t\n\t\t}\n\telse \n\t\t{\n\t\t$(\'#OT_DPD_Patient\'+currentExpanded).removeClass(\'OT_DPD_Patient\').addClass(\'OT_DPD_Patient_Exp\');\t\n\t\t$(\'#DPD_Date-Con\'+currentExpanded).removeClass(\'DPD_Date-Con\').addClass(\'DPD_Date-Con_Exp\');\n\t\t$(\'.expandedView\'+currentExpanded).show();\n\t\t}\n\tprevExpanded = count;\n\n\t\n\t\n\t/* if(prevExpanded != null)\n\t\t{\n\t\t$(\'expandedView\'+prevExpanded).hide();\n\t\t} */\n\n\t\t\n\t//alert(prevExpanded);\n\t\n\t//$(\'.expandedView\'+count).toggle();\n\t/* $(\'.collapsedView\'+count).toggle(); */\n\t/* if($(\'.expandedView\'+count).is(\':visible\'))\n\t{\n\t\tcurrentExpanded = count;\t\n\t}\n\telse\n\t\tcurrentExpanded = \"\"; */\n\t\n\t\n\t\n\t  if(scrollContent1){\n\t\tscrollContent1.refresh();\n\t}  \n\t \n}  \n</script>\n\t\t\t\t\t\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t\t\t\t    \t    <div class=\"center_block Diary_Msg_Box\" >\n\t\t\t\t\t\t   \t\t\t<div style=\"height:1px;background:white\" class=\"dateSeperatorStart\" data-bookingdate=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\" data-datecount=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\" id=\"dateSeperator";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"></div>\n\t\t\t\t\t\t   \t          <div class=\"content\">\n\t\t\t\t\t\t               <div class=\"top_block Calendar_Con_A\">\n\t\t\t\t\t\t                 <div class=\"content\">\n\t\t\t\t\t\t                   <div class=\"top_block Cal_Top_A\">\n\t\t\t\t\t\t                     <div class=\"content\">\n\t\t\t\t\t\t                       <div class=\"background Cal_Right_A\">\n\t\t\t\t\t\t                         <div class=\"right_block Cal_Right_A\">\n\t\t\t\t\t\t                           <div class=\"content\">\n\t\t\t\t\t\t                            <div class=\"top_block Cal_Right_Top_A\">\n\t\t\t\t\t\t                               <div class=\"content\">\n\t\t\t\t\t\t                                 <div class=\"background Date_Num_A\">\n\t\t\t\t\t\t                                   <div class=\"right_block Date_Num_A\">\n\t\t\t\t\t\t                                     <div class=\"content DayNumfont_A\">\n\t\t\t\t\t\t                                      ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n                                  \n                                  0";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n                                  ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n                                  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t                                     </div>\n\t\t\t\t\t\t                                   </div>\n\t\t\t\t\t\t                                 </div>\n\t\t\t\t\t\t                                <div class=\"background Date_Month_A\">\n\t\t\t\t\t\t                                   <div class=\"center_block Date_Month_A\">\n\t\t\t\t\t\t                                     <div class=\"content\">\n\t\t\t\t\t\t                                       <div class=\"top_block Date_Month_Display_A\">\n\t\t\t\t\t\t                                         <div class=\"content Monthfont_A\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =", ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" </div>\n\t\t\t\t\t\t                                       </div>\n\t\t\t\t\t\t                                       <div class=\"center_block Date_day_A\">\n\t\t\t\t\t\t                                         <div class=\"content dayfont_A\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" </div>\n\t\t\t\t\t\t                                       </div>\n\t\t\t\t\t\t                                     </div>\n\t\t\t\t\t\t                                   </div>\n\t\t\t\t\t\t                                 </div>\n\t\t\t\t\t\t                               </div>\n\t\t\t\t\t\t                             </div>\n\t\t\t\t\t\t                           </div>\n\t\t\t\t\t\t                           \n\t\t\t\t\t\t                         </div>\n\t\t\t\t\t\t                       </div>\n\t\t\t\t\t\t                       \n\t\t\t\t\t\t                       <div class=\"center_block Cal_Left_A\">\n\t\t\t\t\t\t                         <div class=\"content\"> </div>\n\t\t\t\t\t\t                       </div>\n\t\t\t\t\t\t                     </div>\n\t\t\t\t\t\t                   </div>\n\t\t\t\t\t\t                   <div class=\"background Cal_Bottom_A\">\n\t\t\t\t\t\t                     <div class=\"center_block Cal_Bottom_A\">\n\t\t\t\t\t\t                       <div class=\"content\"></div>\n\t\t\t\t\t\t                     </div>\n\t\t\t\t\t\t                   </div>\n\t\t\t\t\t\t                 </div>\n\t\t\t\t\t\t               </div>\n\t\t\t\t\t\t             </div>\n\t\t\t\t\t\t           </div>\n\t\t\t\t\t\t           ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t           <div style=\"height:1px;background:white\" class=\"dateSeperatorStart\" data-bookingdate=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"></div>\n\t\t\t\t\t\t          ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t          \n\t\t\t\t\t\t    \t   <div  style=\"height:50px;width:98%; text-align:center;display:block;border:1px; border-style:solid; border-color: #eaeaea;line-height:4\" class=\"Nodata_D\"> No Appointments for This Day</div>\n\t\t\t\t\t\t    \t   \n\t\t\t\t\t\t    \t   \n\t\t\t\t\t\t    \t    ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\n\t\t<div class=\"center_block Diary_Msg_Box\" >\n\t\t<div style=\"height:1px;background:white\" class=\"dateSeperatorStart\" data-bookingdate=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"></div>\n\t          <div class=\"content\">\n            <div class=\"top_block Calendar_Con_A\">\n              <div class=\"content\">\n                <div class=\"top_block Cal_Top_A\">\n                  <div class=\"content\">\n                    <div class=\"background Cal_Right_A\">\n                      <div class=\"right_block Cal_Right_A\">\n                        <div class=\"content\">\n                          <div class=\"background Cal_Right_Bottom_A\">\n                          \n                        </div>\n                          <div class=\"top_block Cal_Right_Top_A\">\n                            <div class=\"content\">\n                              <div class=\"background Date_Num_A\">\n                                <div class=\"right_block Date_Num_A\">\n                                  <div class=\"content DayNumfont_A\">\n                                  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</div>\n                                </div>\n                              </div>\n                             <div class=\"background Date_Month_A\">\n                                <div class=\"center_block Date_Month_A\">\n                                  <div class=\"content\">\n                                    <div class=\"top_block Date_Month_Display_A\">\n                                      <div class=\"content Monthfont_A\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" </div>\n                                    </div>\n                                    <div class=\"center_block Date_day_A\">\n                                      <div class=\"content dayfont_A\"> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </div>\n                                    </div>\n                                  </div>\n                                </div>\n                              </div>\n                            </div>\n                          </div>\n                        </div>\n                        \n                      </div>\n                    </div>\n                    \n                    <div class=\"center_block Cal_Left_A\">\n                      <div class=\"content\"> </div>\n                    </div>\n                  </div>\n                </div>\n                <div class=\"background Cal_Bottom_A\">\n                  <div class=\"center_block Cal_Bottom_A\">\n                    <div class=\"content\"></div>\n                  </div>\n                </div>\n              </div>\n            </div>\n          </div>\n        </div>\n\t\t\t\t\t\t \n\t\t\t   ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t<div style=\"height:1px;background:white\" class=\"dateSeperatorStart\" data-bookingdate=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"></div>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t                        \n\t\t\t    <div class=\"top_block Diary_Content_OP\">\n                <div class=\"content\">\n                  <div class=\"top_block Diary_OP_Header\">\n                    <div class=\"content\">\n                      <div class=\"background D_OP_Icon\">\n                        <div class=\"left_block D_OP_Icon\">\n                          <div class=\"content D_Header_Icon\"> <img src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/eIPAD/images/OP_icon.png\" width=\"25\" height=\"24\"> </div>\n                        </div>\n                      </div>\n                      <div class=\"background D_OP_Right_Col\">\n                        <div class=\"right_block D_OP_Right_Col\">\n                          <div class=\"content\"> </div>\n                        </div>\n                      </div>\n                      <div class=\"background D_OP_Counter\">\n                        <div class=\"right_block D_OP_Counter\">\n                          <div class=\"content\">\n                            <div class=\"top_block D_Con_Total\">\n                              <div class=\"content\"> \n                              \n                              <div class=\"D_C_Box\"> <div class=\"D_C_Box1\"> <i class=\"D_C_Left\"></i> <i class=\"D_C_Center D_H_Count\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</i> <i class=\"D_C_Right\"></i> </div>\n                              \n                              \n                               </div>\n                               </div>\n                            </div>\n                            <div class=\"top_block D_Con_Dur\">\n                              <div class=\"content D_H_Count1\"> \n                              ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =" Hr ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" hrs  ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="  min ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" mins ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n                              </div>\n                            </div>\n                          </div>\n                        </div>\n                      </div>\n                      <div class=\"background D_OP_header\">\n                        <div class=\"center_block D_OP_header\">\n                          <div class=\"content\">\n                            <div class=\"top_block D_OP_Header-Title\">\n                              <div class=\"content D_H_Title\"> Clinic </div>\n                            </div>\n                            <div class=\"top_block D_OP_Header_SubTitle \">\n                              <div class=\"content D_H_SubTitle\"> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" , ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" </div>\n                            </div>\n                          </div>\n                        </div>\n                      </div>\n                    </div>\n                  </div>\n                  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n                  \n                  <div class=\"top_block D_Patient_Details\">\n                    <div class=\"content\">\n                      <div class=\"top_block DPD_Patient\">\n                        <div class=\"content\">\n                        \n                        \n                            <div class=\"left_block DPD_Date-Con\">\n                              <div class=\"content\">\n                                <div class=\"top_block DPD_FTET\">\n                                  <div class=\"content D_H_FTET\">  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =":";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" - ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" </div>\n                                </div>\n                                <div class=\"top_block DPD_Dur\">\n                                  <div class=\"content D_H_Dur\"> ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" Hrs";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="  ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" Min ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" Mins ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="  </div>\n                                </div>\n                                <div class=\"top_block DPD_fl\">\n                                  <div class=\"content D_H_fl\"> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" </div>\n                                </div>\n                              </div>\n                            </div>\n                          </div>\n                          <div class=\"background DPD_Date-Con_bor_OP\">\n                            <div class=\"left_block DPD_Date-Con_bor_OP\">\n                              <div class=\"content\"> </div>\n                            </div>\n                          </div>\n                          \n                          ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n                  \t\t\t\t\t\t\t<div class=\"background OP_OT\">\n\t\t\t\t                                <div class=\"left_block OP_OT\">\n\t\t\t\t                                  <div class=\"content\">\n\t\t\t\t                                  <span class=\"OPOT\"> \n\t\t\t\t                                  <img src=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="/eIPAD/images/OPOT.png\">\n\t\t\t\t                                  </span>\n\t\t\t\t                                   </div>\n\t\t\t\t                                </div>\n\t\t\t\t                              </div>\n\t\t\t\t                            ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n                          \n                          <div class=\"background DPD_Photo\">\n                            <div class=\"right_block DPD_Photo imgPhotoTheme\">\n                            ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n                              <div class=\"content\"> <img src=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="/mobile/PatientImageServlet?PatientId=";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" class=\"photoFrame PatImgTagTheme\"></img> </div>\n                            ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n                            <div class=\"content\"> <img src=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="/eIPAD/images/Photo-4.png %>\" class=\"photoFrame\"></img> </div>\n                            ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n                            </div>\n                          </div>\n                          <div class=\"background DPD_Pat_D\">\n                            <div class=\"center_block DPD_Pat_D\">\n                              <div class=\"content\">\n                                <div class=\"top_block DPD_P_Name\">\n                                  <div class=\"content D_P_Name\"> ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" </div>\n                                </div>\n                                 \n                                <div class=\"top_block DPD_P_ID\">\n                                  <div class=\"content D_P_ID\"> ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =", (";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="),  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" </div>\n                                </div>\n                                \n                              </div>\n                            </div>\n                          </div>\n                         \n                      </div>\n                    </div>\n                    </div>\n                    ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n                  \t\t\t\t\t\t\t <div class=\"top_block Diary_OP_Slot_Header\">\n                        \t\t\t\t\t\t<div class=\"content\">\n                          \t\t\t\t\t\t\t<span class=\"D_H_FTET\">\n                         \t\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n                         \t\t\t\t\t\t\t </span>\n\t\t\t\t\t\t                        </div>\n\t\t\t\t\t\t                      </div>\n\t\t\t\t\t\t                      ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n                  \t\t\t\t\t\t\t\n                  \t\t\t\t\t\t\t<div class=\"top_block D_Patient_Details\">\n\t\t\t\t\t\t                        <div class=\"content\">\n\t\t\t\t\t\t                        ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t                  \t\t\t\t\t\t\t<div class=\"background OP_OT\">\n\t\t\t\t\t                                <div class=\"left_block OP_OT\">\n\t\t\t\t\t                                  <div class=\"content\">\n\t\t\t\t\t                                  <span class=\"OPOT\"> \n\t\t\t\t\t                                  <img src=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="/eIPAD/images/OPOT.png\">\n\t\t\t\t\t                                  </span>\n\t\t\t\t\t                                   </div>\n\t\t\t\t\t                                </div>\n\t\t\t\t\t                              </div>\n\t\t\t\t\t                            ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t                          <div class=\"top_block DPD_Patient\">\n\t\t\t\t\t\t                            <div class=\"content\">\n\t\t\t\t\t\t                              <div class=\"background DPD_Date-Con\">\n\t\t\t\t\t\t                                <div class=\"left_block DPD_Date-Con\">\n\t\t\t\t\t\t                                  <div class=\"content\">\n\t\t\t\t\t\t                                      <div class=\"top_block DPD_fl_Slot\">\n\t\t\t\t\t\t                                      <div class=\"content D_H_fl_slab\"> ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" </div>\n\t\t\t\t\t\t                                    </div>\n\t\t\t\t\t\t                                  </div>\n\t\t\t\t\t\t                                </div>\n\t\t\t\t\t\t                              </div>\n\t\t\t\t\t\t                              <div class=\"background DPD_Date-Con_bor_OP\">\n\t\t\t\t\t\t                                <div class=\"left_block DPD_Date-Con_bor_OP\">\n\t\t\t\t\t\t                                  <div class=\"content\"> </div>\n\t\t\t\t\t\t                                </div>\n\t\t\t\t\t\t                              </div>\n\t\t\t\t\t\t                              <div class=\"background DPD_Photo\">\n\t\t\t\t\t\t                                <div class=\"right_block DPD_Photo imgPhotoTheme\">\n\t\t\t\t\t\t                                  <div class=\"content\">  <img src=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" class=\"photoFrame PatImgTagTheme\"></img> </div>\n\t\t\t\t\t\t                                </div>\n\t\t\t\t\t\t                              </div>\n\t\t\t\t\t\t                              <div class=\"background DPD_Pat_D\">\n\t\t\t\t\t\t                                <div class=\"center_block DPD_Pat_D\">\n\t\t\t\t\t\t                                  <div class=\"content\">\n\t\t\t\t\t\t                                    <div class=\"top_block DPD_P_Name\">\n\t\t\t\t\t\t                                      <div class=\"content D_P_Name\"> ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="  </div>\n\t\t\t\t\t\t                                    </div>\n\t\t\t\t\t\t                                    <div class=\"top_block DPD_P_ID\">\n\t\t\t\t\t\t                                      <div class=\"content D_P_ID\"> ";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" </div>\n\t\t\t\t\t\t                                    </div>\n\t\t\t\t\t\t                                  </div>\n\t\t\t\t\t\t                                </div>\n\t\t\t\t\t\t                              </div>\n\t\t\t\t\t\t                            </div>\n\t\t\t\t\t\t                          </div>\n\t\t\t\t\t\t                        </div>\n\t\t\t\t\t\t                      </div>\n                  \t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n                  </div>\n                </div>\n              </div>\n\n\t\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\t\t\t                        \n\t\t\t                        \n\t\t\t   <div class=\"top_block Diary_Content_OT\">\n                <div class=\"content\">\n                  <div class=\"top_block Diary_OP_Header\">\n                    <div class=\"content\">\n                      <div class=\"background D_OT_Icon\">\n                        <div class=\"left_block D_OT_Icon\">\n                          <div class=\"content D_Header_Icon\"> <img src=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="/eIPAD/images/OT.png\" width=\"25\" height=\"24\"> </div>\n                        </div>\n                      </div>\n                      <div class=\"background D_OT_Right_Col\">\n                        <div class=\"right_block D_OT_Right_Col\">\n                          <div class=\"content\"> </div>\n                        </div>\n                      </div>\n                      <div class=\"background D_OP_Counter\">\n                        <div class=\"right_block D_OP_Counter\">\n                          <div class=\"content\">\n                            <div class=\"top_block D_Con_Total\">\n                              <div class=\"content\">  <div class=\"D_C_Box\"> <div class=\"D_C_Box1\"> <i class=\"D_C_Left\"></i> <i class=\"D_C_Center D_H_Count\">";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</i> <i class=\"D_C_Right\"></i> </div>\n                              \n                              \n                               </div></div>\n                            </div>\n                            <div class=\"top_block D_Con_Dur\">\n                              <div class=\"content D_H_Count1\">\n                               ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" Hrs ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =" min ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n                               </div>\n                            </div>\n                          </div>\n                        </div>\n                      </div>\n                      <div class=\"background D_OP_header\">\n                        <div class=\"center_block D_OP_header\">\n                          <div class=\"content\">\n                            <div class=\"top_block D_OP_Header-Title\">\n                              <div class=\"content D_H_Title\"> Operation Theater </div>\n                            </div>\n                            <div class=\"top_block D_OP_Header_SubTitle \">\n                              <div class=\"content D_H_SubTitle\"> ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =" </div>\n                            </div>\n                          </div>\n                        </div>\n                      </div>\n                    </div>\n                  </div>\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\n\t\t\t\t\t\n\t\t\t\t\t<!-- Test -->\n\t\t\t\t\t\n\t\t\t\t\t\n<!-- Col -->\n<div class=\"collapsedView";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="-";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\"  >\n<div class=\"top_block OT_D_Patient_Details\" onclick = \"expandedView(\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')\" >\n  <div class=\"content\">\n    <div class=\"top_block OT_DPD_Patient\" id = \"OT_DPD_Patient";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n      <div class=\"content\">\n        <div class=\"background DPD_Date-Con\" id=\"DPD_Date-Con";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n          <div class=\"left_block DPD_Date-Con\">\n            <div class=\"content\">\n              <div class=\"top_block DPD_FTET\">\n                <div class=\"content D_H_FTET\"> ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" </div>\n              </div>\n              <div class=\"top_block DPD_Dur\">\n                <div class=\"content D_H_Dur\">\n                  ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n                  ";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" Hrs\n                  ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="  Mins\n                  ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n                </div>\n              </div>\n              <div class=\"top_block DPD_fl\">\n                <div class=\"content OT_D_H_fl\">\n                  ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n                  Elective\n                  ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n                  Emergency\n                  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n                  Urgent\n                  ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n                </div>\n              </div>\n            </div>\n          </div>\n        </div>\n        <div class=\"background DPD_Date-Con_bor_OT\">\n          <div class=\"left_block DPD_Date-Con_bor_OT\">\n            <div class=\"content\"> </div>\n          </div>\n        </div>\n        <div class=\"background DPD_Photo\">\n          <div class=\"right_block DPD_Photo imgPhotoTheme\">\n             ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n          </div>\n        </div>\n        <div class=\"background DPD_Pat_D\">\n          <div class=\"center_block DPD_Pat_D\">\n            <div class=\"content\">\n              <div class=\"left_block OT_DPD_P_Name\">\n                <div class=\"content D_P_Name\"> ";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="  </div>\n              </div>\n              <div class=\"Right_block OT_DPD_P_Name OT_DPD_P_Name_SPC\">\n                <div class=\"content D_P_ID_OT\"> ";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =" </div>\n              </div>\n              <div class=\"left_block OT_DPD_P_ID\">\n                <div class=\"content D_P_ID\"> ";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="), ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =" </div>\n              </div>\n              <div class=\"Right_block OT_DPD_P_ID OT_DPD_P_Name_SPC \">\n                <div class=\"content D_P_ID_OT\"> ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 =" </div>\n              </div>\n            </div>\n          </div>\n        </div>\n        <!-- contents to be shown after click -->\n       <div class=\"expandedView";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 =" \" style=\"display:none;\" >\n        <div class=\"background OT_Div\">\n                                <div class=\"Center_block OT_Div\">\n                                  <div class=\"content OT_DiV_Border \"></div>\n                                </div>\n                              </div>\n                              <div class=\"background DPD_Pat_D_OT \">\n                                <div class=\"center_block DPD_Pat_D\">\n                                  <div class=\"content\">\n                                    <div class=\"left_block OT_DPD_P_SPC\">\n                                      <div class=\"content D_P_Name_OT\"><!--  TODO localize these roles -->\n                                      ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n                  \t\t\t\t\t  as Surgeon\n                  \t\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n                  \t\t\t\tas Assistant Surgeon 1  \n                  \t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n                  \t\t\t\t\tas Assistant Surgeon 2\n                    \t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n \t\t\t\t  \t\t\tas Anesthetist\n \t\t\t\t\t\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="            \n                                  </div>\n                                  \n                                  \n                                   \n                                  ";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n                                    <div class=\"content D_P_Name_OT content D_P_Name_OT_Surgen\">";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</div>\n                                  ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n                                  </div>\n                                  \n                                  <div class=\"Right_block OT_DPD_PAC_Status\">\n                                    <div class=\"content D_P_PAC_OT\">\n                                    <div>\n                                    ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n                                   <span style=\"border-right: #fff 1px solid; color:#0E7206\" >PAC </span>\n                                   ";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n                                \t<span style= \"border-right: #fff 1px solid; color:#c5c5c5\">PAC </span>\n                                \t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n                                   <span style=\"margin-left: 4px;\">  ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =" </span>\n                                   ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =" \n                                    </div>\n                                  \n                                    </div>\n                                   </div>\n                                  </div>\n                                </div>\n                              </div>\n                              </div>\n        \n  \t </div>     \n    </div>\n      \n     \t<div class=\"Center_block OT_DPD_P_Bottom\" >\n    \t\t<div class=\"content OT_DPD_P_Bottom GreenStrip_Sw\"> </div>\n  \t\t</div>\n    </div>\n  </div>\n</div>\n\n<!-- Col End -->\n<!-- EXP -->\n\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n<!-- Exp End -->\n  ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n                </div>\n              </div>\n\t\t\t        ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t <div class=\"center_block Diary_Msg_Box\" >\n\t\t <div style=\"height:1px;background:white\" class=\"dateSeperatorStart\" data-bookingdate=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\"></div>\n\t          <div class=\"content\">\n            <div class=\"top_block Calendar_Con_A\">\n              <div class=\"content\">\n                <div class=\"top_block Cal_Top_A\">\n                  <div class=\"content\">\n                    <div class=\"background Cal_Right_A\">\n                      <div class=\"right_block Cal_Right_A\">\n                        <div class=\"content\">\n                          <div class=\"background Cal_Right_Bottom_A\">\n                          \n                        </div>\n                          <div class=\"top_block Cal_Right_Top_A\">\n                            <div class=\"content\">\n                              <div class=\"background Date_Num_A\">\n                                <div class=\"right_block Date_Num_A\">\n                                  <div class=\"content DayNumfont_A\">\n                                   ";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n                                  </div>\n                                </div>\n                              </div>\n                             <div class=\"background Date_Month_A\">\n                                <div class=\"center_block Date_Month_A\">\n                                  <div class=\"content\">\n                                    <div class=\"top_block Date_Month_Display_A\">\n                                      <div class=\"content Monthfont_A\">";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" </div>\n                                    </div>\n                                    <div class=\"center_block Date_day_A\">\n                                      <div class=\"content dayfont_A\">";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" </div>\n                                    </div>\n                                  </div>\n                                </div>\n                              </div>\n                            </div>\n                          </div>\n                        </div>\n                        \n                      </div>\n                    </div>\n                    \n                    <div class=\"center_block Cal_Left_A\">\n                      <div class=\"content\"> </div>\n                    </div>\n                  </div>\n                </div>\n                <div class=\"background Cal_Bottom_A\">\n                  <div class=\"center_block Cal_Bottom_A\">\n                    <div class=\"content\"></div>\n                  </div>\n                </div>\n              </div>\n            </div>\n          </div>\n        </div>\n \t   <div  style=\"height:50px;width:98%; text-align:center;display:block;border:1px; border-style:solid; border-color: #eaeaea;line-height:4\" class=\"Nodata_D\"> No Appointments for This Day</div><!-- TODO remove inline css -->\n \t   ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="                 \n\t\t\t<div>\n\t\t\t<div  style=\"width:98%; text-align:center;display:block;line-height:10\" class=\"Nodata_D\"> No Appointments for This Week</div><!-- TODO remove inline css and error message should be from response -->\n\t\t\t</div>\n\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="  \n\t\t\t\n\t\t</div> \n\t\t<div id=\"EmptyScrollArea\" style=\"width:100%;height:0px;\"></div>\n\n";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);

/*taken from servlet */
String practitionerId = (String) session.getAttribute("practitioner_id");
String startDt = request.getParameter("startDate");
String endDt = request.getParameter("endDate");
String patCategoryFilter = request.getParameter("hdnOrderBy");
String localLang =(String) session.getAttribute("LOCALE")  ;
String locale = localLang == null? "en" : localLang; 
//String facilityID = (String) session.getAttribute("facility_id");

DiaryViewRequest diaryViewRequest = new DiaryViewRequest();
diaryViewRequest.setPractitionerId(practitionerId);
diaryViewRequest.setStartDate(startDt);
diaryViewRequest.setEndDate(endDt);
diaryViewRequest.setPatCategoryFilter(patCategoryFilter);
diaryViewRequest.setLocale(locale);
DiaryViewBC bc = new DiaryViewBC();
DiaryViewResponse diaryViewResponse = bc.getDiaryViewDetails(diaryViewRequest);
/*end of - taken from servlet */

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); //TODO variable name to be more meaningful and specific
String[] mthNameArr = { "January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};//TODO Months needs top be localized
String[] dayNmArr = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};//TODO to localize
String[] singleDigitNo= {"0","1", "2" , "3", "4", "5", "6","7","8","9"};
Date weekStartDate = null;
Date weekEndDate = null;
Date sysDt = new Date();
String sysDate = null;
Date systemDate = null;
Date weekFirstDate = null;
Date weekDay = null;
Date chckPrevBookingDate = null;
int k= 0;
ArrayList<Date> weekDayList = new ArrayList<Date>();
try{
	weekStartDate = formatter.parse(startDt);
	weekEndDate = formatter.parse(endDt);
	sysDate = formatter.format(sysDt);
	systemDate = formatter.parse(sysDate);
}
catch(Exception e){
	weekStartDate = new Date();
}
Calendar weekDayCal = Calendar.getInstance();
if((systemDate.after(weekStartDate)||systemDate.equals(weekStartDate)) && (systemDate.before(weekEndDate)||systemDate.equals(weekEndDate)))
{ 
	weekFirstDate = systemDate;
	weekDayCal.setTime(systemDate);
	weekDayList.add(weekFirstDate);
}
else
{
	weekFirstDate = weekStartDate;
	weekDayCal.setTime(weekStartDate);
	weekDayList.add(weekFirstDate);
}
   while(weekFirstDate.before(weekEndDate))// to generate the arraylist of all the dates which are present in the current week
 {
	 int i =1;
	 weekDayCal.add(Calendar.DATE, i);
	 weekDay = weekDayCal.getTime();
	 weekDayList.add(weekDay);
	 i++;
	 weekFirstDate = weekDay;
 } 
 Date prevBookingDate = null;// for checking the condition in printing the date seperator. TODO - Make it a date variable - DONE
List<AppointmentBlockItem> apptBlockItemList = null; // TODO , the block logic need to be tested thoroughly with data variance in Date, facility, clinic, op/ot
AppointmentBlockItem diaryBlockItem = null; //TODO - name should be diaryBlockItem  - DONE
String facilityName = null;
String locationName = null;
String speciality = null;
//DiaryViewResponse diaryViewResp = (DiaryViewResponse) request.getAttribute("DVResponse");
apptBlockItemList = diaryViewResponse.getApptBlockItemList();
if (!apptBlockItemList.isEmpty()) { // TODO null check for apptBlockItemList
	for(int i = 0; i < apptBlockItemList.size(); i++){
		diaryBlockItem = apptBlockItemList.get(i);
		int count = diaryBlockItem.getApptDetailCount();
		facilityName = diaryBlockItem.getFaciltityDesc(); 
		String apptType = diaryBlockItem.getAppointmentType(); //TODO variable declarations to be made uniformly -- possibly in the same blocks
		locationName = diaryBlockItem.getLocationDesc();
		speciality = diaryBlockItem.getSpecialityDesc();
		String slotType = "1";
		String slabType = "2"; //TODO what about 3 - Ask Dhivakar and see what's to be done  - DONE
		int hour = diaryBlockItem.getHourCount(); //TODO meaningful variable name
		int min = diaryBlockItem.getMinCount(); //TODO meaningful variable name
		Date bookingDt = diaryBlockItem.getBookingDate();
		Date bookingDate = null;
		String bookDt = null;
				try{
			/* weekStartDate = formatter.parse(startDt);
			weekEndDate = formatter.parse(weekEndDt); */
			bookDt = formatter.format(bookingDt);
			bookingDate = formatter.parse(bookDt);
			
		}
		catch (Exception e)//TODO exception type to be specific
		{
			weekStartDate = new Date();
		}
				Date chckBookingDate = bookingDate;
				
				if(chckBookingDate.equals(chckPrevBookingDate))
				{
					k--;
				}

		int bookingDtNum =bookingDate.getDate();
		//int bookingDtNum =bookingDate.getDate(); //TODO meaningful variable name - DONE
		Calendar bookingDtCal = Calendar.getInstance(); //TODO meaningful variable name - DONE
		//bookingDtCal.setTime(bookingDate);
		bookingDtCal.setTime(bookingDate);
		int bookingDtyear = bookingDtCal.get(Calendar.YEAR); //TODO meaningful variable name -DONE
		int bookingDtmth = bookingDtCal.get(Calendar.MONTH); //TODO meaningful variable name - DONE
		String bookingDtMonthName =  mthNameArr [bookingDtmth];//TODO meaningful variable name -DONE
		
		int bookingDtDay = bookingDtCal.get(Calendar.DAY_OF_WEEK); //TODO meaningful variable name -DONE
		String bookingDtDayName = dayNmArr[bookingDtDay-1]; //TODO meaningful variable name -DONE
		
	
		
		
             while(bookingDate.after(weekDayList.get(k)))
             {
            	 Date weekDate = weekDayList.get(k);
            	 int weekDateNum= weekDate.getDate();
            	 Calendar weekDateCal = Calendar.getInstance();
            	 weekDateCal.setTime(weekDate);
            	 int weekDateYear = weekDateCal.get(Calendar.YEAR);
            	 int weekDateMonth = weekDateCal.get(Calendar.MONTH);
            	 String weekDateMthName = mthNameArr [weekDateMonth];
            	 int weekDateDay = weekDateCal.get(Calendar.DAY_OF_WEEK);
            	 String weekDateDayName = dayNmArr[weekDateDay-1];
						
						    	   if ((!weekDate.equals(systemDate)) && (!weekDate.equals(weekStartDate))  && (!weekDate.equals(prevBookingDate)))
						    	   {
						    		   
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf( formatter.format(weekDate) ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(k));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(k));
            _bw.write(_wl_block8Bytes, _wl_block8);

                                  	if(weekDateNum<10) {
                                  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( weekDateNum ));
            _bw.write(_wl_block10Bytes, _wl_block10);

                                  	}
                                  	else
                                  	{
                                  
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( weekDateNum ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( weekDateMthName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(weekDateYear ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(weekDateDayName ));
            _bw.write(_wl_block15Bytes, _wl_block15);
 } else{
						           
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( formatter.format(weekDate) ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(k));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(k));
            _bw.write(_wl_block17Bytes, _wl_block17);
} 
            _bw.write(_wl_block18Bytes, _wl_block18);
 
						          
						    	    k++;
		}
						       if ((!bookingDate.equals(systemDate)) && (!bookingDate.equals(weekStartDate)) && (!bookingDate.equals(prevBookingDate)))
								{
					
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( formatter.format(bookingDate) ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(k));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(k));
            _bw.write(_wl_block20Bytes, _wl_block20);

                                  	if(bookingDtNum<10) {
                                  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( bookingDtNum ));
            _bw.write(_wl_block10Bytes, _wl_block10);

                                  	}
                                  	else
                                  	{
                                  
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( bookingDtNum ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( bookingDtMonthName ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( bookingDtyear ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( bookingDtDayName ));
            _bw.write(_wl_block23Bytes, _wl_block23);

			  
			   prevBookingDate = bookingDate;
								}	
							
									
									else{ 
									
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( formatter.format(bookingDate) ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(k));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(k));
            _bw.write(_wl_block25Bytes, _wl_block25);
	
									}
						/*    	ArrayList<AppointmentDetailItem> apptDetailItemList = diaryBlockItem.getAppointmentDetail(); */
						   
									
						       
		   			if (apptType.equals("op")) 
		   			{
		   				ArrayList<OPApptDetailItem> oOPapptDetailItemList = diaryBlockItem.getOpapptDetailList();
		  		 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(count));
            _bw.write(_wl_block28Bytes, _wl_block28);
 if(hour != 0 ) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( hour ));
 if(hour == 1) {
            _bw.write(_wl_block30Bytes, _wl_block30);
 } else {  
            _bw.write(_wl_block31Bytes, _wl_block31);
 }} if(min != 0) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( min  ));
 if(min == 1) {
            _bw.write(_wl_block32Bytes, _wl_block32);
 }else
            _bw.write(_wl_block33Bytes, _wl_block33);
 }
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( locationName ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( speciality  ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block36Bytes, _wl_block36);

                  Date slabBookingTime  = null;
					Date prevSlabBookingTime = null;
                  	for (int j = 0; j < oOPapptDetailItemList.size(); j++)
                  	{
                  		OPApptDetailItem apptItem = oOPapptDetailItemList.get(j);
                  					
                  					/* ArrayList<OPApptDetailItem> oOPApptDetailItemList = apptItem.getOpApptDetailItemList();// this will come as null as we not seeting d opaaptlist aply
                  					OPApptDetailItem oOPApptDetailItem = oOPApptDetailItemList.get(j); */
                  					Date startTime = apptItem.getStartTime();
                  					Date endTime= apptItem.getEndTime();
                  					Calendar cal = Calendar.getInstance();
    								cal.setTime(startTime);
    								int stHrs = cal.get(Calendar.HOUR_OF_DAY);
                  					String stHr = Integer.toString(stHrs);
                  					if( Arrays.asList( singleDigitNo).contains(stHr))
    								{
    									stHr = ("0").concat(stHr);
    								}
                  					int stMins = cal.get(Calendar.MINUTE);
                  					String stMin = Integer.toString(stMins);
                  					if( Arrays.asList( singleDigitNo).contains(stMin))
    								{
    									stMin = ("0").concat(stMin);
    								}
    								Calendar calEndTm = Calendar.getInstance(); 
    								calEndTm.setTime(endTime);
    								int endHrs = calEndTm.get(Calendar.HOUR_OF_DAY);
                  					String endHr = Integer.toString(endHrs);
                  					if( Arrays.asList( singleDigitNo).contains(endHr))
    								{
    									endHr = ("0").concat(endHr);
    								}
    								int endMins = calEndTm.get(Calendar.MINUTE);
                  					String endMin = Integer.toString(endMins);
                  					if( Arrays.asList( singleDigitNo).contains(endMin))
    								{
    									endMin = ("0").concat(endMin);
    								}
    								
    								String age= apptItem.getPatientAge();
    								String[] ageYears = age.split(" ");
                  					Date apptDuration = apptItem.getAppointmentDuration();
                  					Calendar calApptDur = Calendar.getInstance(); 
                  					calApptDur.setTime(apptDuration);
                  					int apptDurHr = calApptDur.get(Calendar.HOUR_OF_DAY);
                  					int apptDurMin = calApptDur.get(Calendar.MINUTE);
                  					String opApptType = apptItem.getTimeTableType();
                  					slabBookingTime = startTime;
                  					String patientType= apptItem.getPatientType();
                  					if(opApptType.equals("1")||opApptType.equals("3"))
                  					{
                  						
                  					
                  
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(stHr ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( stMin ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(endHr ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( endMin ));
            _bw.write(_wl_block40Bytes, _wl_block40);
 if(apptDurHr != 0 ) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( apptDurHr ));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(apptDurHr == 1) 
            _bw.write(_wl_block30Bytes, _wl_block30);
 else 
            _bw.write(_wl_block41Bytes, _wl_block41);
  }  
            _bw.write(_wl_block42Bytes, _wl_block42);
 if(apptDurMin != 0) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( apptDurMin  ));
 if(apptDurMin == 1) 
            _bw.write(_wl_block43Bytes, _wl_block43);
 else  
            _bw.write(_wl_block44Bytes, _wl_block44);
 } 
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(apptItem.getVisitDesc() ));
            _bw.write(_wl_block46Bytes, _wl_block46);
 
                        if(patientType.equals("Y"))
                  							{
                  								
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block48Bytes, _wl_block48);
 } 
            _bw.write(_wl_block49Bytes, _wl_block49);

                            if(!(apptItem.getPatientId()).equals(null))
                            {
                            
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(apptItem.getPatientId() ));
            _bw.write(_wl_block52Bytes, _wl_block52);

                            }
                            else
                            {
                            
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block54Bytes, _wl_block54);
} 
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(apptItem.getPatientName()));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(apptItem.getPatientId() ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(apptItem.getPatientSex() ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ageYears[0] ));
            _bw.write(_wl_block59Bytes, _wl_block59);
 } else
                  		if(opApptType.equals("2"))
                  			{
                  			if(!slabBookingTime.equals(prevSlabBookingTime))
  							{
                  							
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(stHr ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( stMin ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(endHr ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( endMin ));
            _bw.write(_wl_block61Bytes, _wl_block61);

						                      prevSlabBookingTime = slabBookingTime;
  							}
  												
            _bw.write(_wl_block62Bytes, _wl_block62);
 
						                        if(patientType.equals("Y"))
	                  							{
	                  								
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block64Bytes, _wl_block64);
 } 
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(apptItem.getVisitDesc() ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(apptItem.getPatientId() ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(apptItem.getPatientName()));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(apptItem.getPatientId() ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(apptItem.getPatientSex() ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(ageYears[0] ));
            _bw.write(_wl_block69Bytes, _wl_block69);
 
                  						}
		   			}
		   			
            _bw.write(_wl_block70Bytes, _wl_block70);

					} 		   			
		   			else  // OT BLOCK 
		   			{
		   				ArrayList<OTApptDetailItem> oOTapptDetailItemList = diaryBlockItem.getOtapptDetailList();
				
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(count));
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(hour != 0 ) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( hour ));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(hour == 1) 
            _bw.write(_wl_block30Bytes, _wl_block30);
 else 
            _bw.write(_wl_block74Bytes, _wl_block74);
 }  
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(min != 0) { 
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( min  ));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(min == 1) 
            _bw.write(_wl_block43Bytes, _wl_block43);
 else 
            _bw.write(_wl_block75Bytes, _wl_block75);
 } 
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( locationName ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(facilityName));
            _bw.write(_wl_block77Bytes, _wl_block77);

						for (int j = 0; j < oOTapptDetailItemList.size(); j++) {
							OTApptDetailItem apptItem = oOTapptDetailItemList.get(j);
							
							/* ArrayList<OTApptDetailItem> oOTApptDetailItemList = apptItem.getOtApptDetailItemList();
          					OTApptDetailItem oOTApptDetailItem = oOTApptDetailItemList.get(j); */
          					
							Date startTime = apptItem.getStartTime();
          					Date endTime= apptItem.getEndTime();
          					Calendar cal = Calendar.getInstance();
							cal.setTime(startTime);
							int stHrs = cal.get(Calendar.HOUR_OF_DAY);
          					String stHr = Integer.toString(stHrs);
          					if( Arrays.asList( singleDigitNo).contains(stHr))
							{
								stHr = ("0").concat(stHr);
							}
          					int stMins = cal.get(Calendar.MINUTE);
          					String stMin = Integer.toString(stMins);
          					if( Arrays.asList( singleDigitNo).contains(stMin))
							{
								stMin = ("0").concat(stMin);
							}
							Calendar calEndTm = Calendar.getInstance(); 
							calEndTm.setTime(endTime);
							int endHrs = calEndTm.get(Calendar.HOUR_OF_DAY);
          					String endHr = Integer.toString(endHrs);
          					if( Arrays.asList( singleDigitNo).contains(endHr))
							{
								endHr = ("0").concat(endHr);
							}
							int endMins = calEndTm.get(Calendar.MINUTE);
          					String endMin = Integer.toString(endMins);
          					if( Arrays.asList( singleDigitNo).contains(endMin))
							{
								endMin = ("0").concat(endMin);
							}
							String age= apptItem.getPatientAge();
							String[] ageYears = age.split(" ");
							Date apptDuration = apptItem.getAppointmentDuration();
          					Calendar calApptDur = Calendar.getInstance();
          					calApptDur.setTime(apptDuration);
          					int apptDurHr = calApptDur.get(Calendar.HOUR_OF_DAY);
          					int apptDurMin = calApptDur.get(Calendar.MINUTE);
          					String operationType= apptItem.getOperationType(); 
          					String specialtyDesc = apptItem.getSpecialityDesc();
          					String locationDesc = apptItem.getLocationDesc();
          					String procedureDetail = apptItem.getProcedureDetail();
          					Date operationDt = diaryBlockItem.getBookingDate();
          					String practRole = apptItem.getPractRole();
					
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(operationDt ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(operationDt ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(operationDt ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(operationDt ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(stHr ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( stMin ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(endHr ));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( endMin ));
            _bw.write(_wl_block84Bytes, _wl_block84);
 if(apptDurHr != 0 ) { 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( apptDurHr ));
            _bw.write(_wl_block29Bytes, _wl_block29);
 if(apptDurHr == 1 )
            _bw.write(_wl_block30Bytes, _wl_block30);
else  
            _bw.write(_wl_block86Bytes, _wl_block86);
 }  
            _bw.write(_wl_block85Bytes, _wl_block85);
 if(apptDurMin != 0) { 
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( apptDurMin  ));
 if(apptDurMin == 1) 
            _bw.write(_wl_block43Bytes, _wl_block43);
else 
            _bw.write(_wl_block87Bytes, _wl_block87);
 } 
            _bw.write(_wl_block88Bytes, _wl_block88);

                                     if(operationType.equals("ST01"))
                                     {
                                  
            _bw.write(_wl_block89Bytes, _wl_block89);

                                     }
                                     else
                                    	 if(operationType.equals("ST02"))
                                    	 {
                                  
            _bw.write(_wl_block90Bytes, _wl_block90);

                                    	 }
                                    	 else
                                    	 {	 
                                  
            _bw.write(_wl_block91Bytes, _wl_block91);

                                    	 }
                                  
            _bw.write(_wl_block92Bytes, _wl_block92);

                            if(!(apptItem.getPatientId()).equals(null))
                            {
                            
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(apptItem.getPatientId() ));
            _bw.write(_wl_block52Bytes, _wl_block52);

                            }
                            else
                            {
                            
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block54Bytes, _wl_block54);
} 
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(apptItem.getPatientName()));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( specialtyDesc ));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(apptItem.getPatientId() ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(apptItem.getPatientSex() ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(ageYears[0] ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( locationDesc ));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(operationDt ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(j ));
            _bw.write(_wl_block99Bytes, _wl_block99);

                                     if(practRole.equals("MS"))
                                     {
                                	  
            _bw.write(_wl_block100Bytes, _wl_block100);

                                    }
                                    	else
                                    	 if(practRole.equals("AS1"))
                                    	 {
                                  	
            _bw.write(_wl_block101Bytes, _wl_block101);

                                    	 }
                                    	 else
                                    		if(practRole.equals("AS2"))
                                    	 {	 
                                  
            _bw.write(_wl_block102Bytes, _wl_block102);

                                    	 }
						 
                   	 					else
                   		 			if(practRole.equals("AN"))
                   	 				{	 
                 				
            _bw.write(_wl_block103Bytes, _wl_block103);

                   	 			}
                           String bookingStage = apptItem.getBookingStage();
                 			
            _bw.write(_wl_block104Bytes, _wl_block104);

                                  // 	calling of procedure detail response to get the procedure detail
                                  /* String bookingNo = apptItem.getBookingNo();
                                  String facilityID = apptItem.getFacilityId();
               					OTProcDetailResponse procDetailResponse = bc.getProcDetails(bookingNo, facilityID, locale);
               					ArrayList<OTProcDetail> procDetailList = new ArrayList<OTProcDetail>();
               					OTProcDetail oProcDetail = new OTProcDetail();
               					procDetailList = procDetailResponse.getOtProcDetailList();  */
               					ArrayList<String> procDetail = apptItem.getProcDetail();
               					if(!procDetail.isEmpty())
               					{
               						for(int m=0;m<procDetail.size();m++)
               						{
               							/* oProcDetail = procDetailList.get(m); */
               						String procedureDetails = procDetail.get(m);
                                  
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( procedureDetails ));
            _bw.write(_wl_block106Bytes, _wl_block106);

               						}
               					}
                                  
            _bw.write(_wl_block107Bytes, _wl_block107);

                                    String PACStatus = apptItem.getPACStatus();
                                    if(PACStatus.equals("PACDONE") )
                                    
            _bw.write(_wl_block108Bytes, _wl_block108);

                                   else
                                	   if(PACStatus.equals("PACORDERED"))
                                	   {
                                	
            _bw.write(_wl_block109Bytes, _wl_block109);
 
                                	   }
                                    if(bookingStage.equals("FN")) {
                                   
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(apptItem.getStatusDesc() ));
            _bw.write(_wl_block111Bytes, _wl_block111);
  } 
            _bw.write(_wl_block112Bytes, _wl_block112);
            _bw.write(_wl_block113Bytes, _wl_block113);

                     	}
                     
            _bw.write(_wl_block114Bytes, _wl_block114);

							  
			        	}  
	k++;		
	chckPrevBookingDate = chckBookingDate;
	}
/* k++; */
while(k<weekDayList.size())
{
	Date weekDate = weekDayList.get(k);
	 int weekDateNum= weekDate.getDate();
	 Calendar weekDateCal = Calendar.getInstance();
	 weekDateCal.setTime(weekDate);
	 int weekDateYear = weekDateCal.get(Calendar.YEAR);
	 int weekDateMonth = weekDateCal.get(Calendar.MONTH);
	 String weekDateMthName = mthNameArr [weekDateMonth];
	 int weekDateDay = weekDateCal.get(Calendar.DAY_OF_WEEK);
	 String weekDateDayName = dayNmArr[weekDateDay-1];

	
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( formatter.format(weekDate) ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(k));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(k));
            _bw.write(_wl_block116Bytes, _wl_block116);

                                  	if(weekDateNum<10) {
                                  
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( weekDateNum ));
            _bw.write(_wl_block10Bytes, _wl_block10);

                                  	}
                                  	else
                                  	{
                                  
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( weekDateNum ));
            _bw.write(_wl_block11Bytes, _wl_block11);
 } 
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf( weekDateMthName ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( weekDateYear ));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf( weekDateDayName ));
            _bw.write(_wl_block119Bytes, _wl_block119);
 
 	   k++;
}
					}
							else
						{
						
			        
            _bw.write(_wl_block120Bytes, _wl_block120);
 }
			
            _bw.write(_wl_block121Bytes, _wl_block121);
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
