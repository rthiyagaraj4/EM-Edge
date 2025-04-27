package jsp_servlet._eipad._jsp._chartwidgets._userpreference;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.constants.WidgetItems;
import eIPAD.HealthObjects.PatientContext;
import eIPAD.chartsummary.common.response.WidgetOrderResponse;
import eIPAD.chartsummary.common.bc.WidgetOrderBC;
import java.util.ArrayList;

public final class __widgetorderpreference extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/userpreference/WidgetOrderPreference.jsp", 1709116950989L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<div class=\"widgetTableUser\">\n<div class=\"mainwidget\" >\n<div class=\"widgetBackGroundLayer\">\n</div>\n<div class=\"widgetListWarpper\" id=\"widgetListWarpper\" style=\"\">\n<div class=\"widgetListWarppers\" id=\"widgetListWarppers\" style=\"\">\n<div class=\"widgetHeader\">\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<div class=\"widgetHeaderRows\">\n\n<div class=\"widgetHeadercellLable\" >\nWidget List\n</div>\n<div class=\"widgetHeadercellButton\" style=\"text-align:right;\">\n   <div class=\"userPrefWidgetButtonTheme\" style=\"float:right;\" data-role=\"none\" onclick=\"CallEditSummary()\">\n    <img style=\"height:27px;\" src=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="/eIPAD/images/ModifiedW24x24.png\">\n   </div>\n</div>\n\n\n\n</div>\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n<div class=\"widgetHeaderRows\">\n    <div class=\"widgetHeadercellLableEdit\" >\n     Widget List\n    </div>\n    <div class=\"widgetHeadercellButton\">\n            <div class=\"userPrefWidgetButtonTheme\" style=\"float:left;\" data-role=\"none\" onclick=\"restoreClick(\'Edit\')\">\n               <img src=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="/eIPAD/images/Reload24x24.png\" style=\"height:16px;padding:5px;\">\n            </div>\n\t\t\t<div style=\"float:left;width:5px;height:28px;\">\n\t\t\t</div>\n            <div class=\"userPrefWidgetButtonTheme\" style=\"float:left;\" data-role=\"none\" onclick=\"confirmUserSummary()\">\n               <img src=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eIPAD/images/CS_Ok16x16.png\" style=\"height:16px;padding:5px;\">\n            </div>\n\t\t\t<div style=\"float:left;width:5px;height:28px;\">\n\t\t\t</div>\n            <div class=\"userPrefWidgetButtonTheme\" style=\"float:left;\" data-role=\"none\" onclick=\"closeUserEditSummary()\">\n               <img src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eIPAD/images/CS_Close16x16.png\" style=\"height:16px;padding:5px;\">\n\t\t\t</div> \n            <div style=\"clear: both;\"></div>\t\t\t\n\t</div>\n</div>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</div>\n\n<div id=\"allActiveAndIncative\" class=\"allActiveAndIncative\">\n\n<div class=\"activeList\">\n\n<!-- table -->\n<div class=\"MenuList\" >\n\n<div class=\"MenuListItemLable\" >\n<div class=\"MenuListItemLableCell\" >\nACTIVE WIDGETS\n</div>\n</div>\n\n<!-- table row -->\n<div class=\"MenuListItem\" >\n\n <div id=\"sortable-handlers\">\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n \n ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n <div class=\"sortableNormal\" style=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" onclick=\"movetoSelectedWidgets(\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\');\"  data-usercode=\" ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \">\n                    <!-- table cell drag icon area -->\n\n<div class=\"MenuItemTable\">\n<div class=\"MenuItemRow\">\n<div class=\"MenuItemDragIcon\" >\n<div class=\"dynamicImage\"> \n\n\n<img src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/eIPAD/images/";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"> \n</div>\n\n</div>\n\n<!-- table cell lable area -->\n\n<div class=\"MenuItemlabelIcon\" >\n\n\n\n<div >\n   \n  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="  \n</div>\n\n</div>\n\n<!-- table cell Count Minus area -->\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<div class=\"MenuItemCountMinus\" >\n\n<div style=\"background-color:#23789e;text-align: center;-webkit-border-radius: 11px;height: 25px;width: 36px;float: right;\">\n    <div id=\"countDisplay";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"  class=\"DisplayStyle\">0</div>\n</div>\n\n<div style=\"clear: both;\"></div>\n\n</div>\n  ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</div>\n        \n        </div>\n        \n                    \n</div>\n  \n \n  \n   \n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n <div class=\"sortable\" style=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  id=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" data-id=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" data-visible=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"  data-usercode=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"> \n                    <!-- table cell drag icon area -->\n\n<div class=\"MenuItemTableEdit\">\n<div class=\"MenuItemRowEdit\">\n<div class=\"MenuItemDragIconEdit\" >\n\n\n\n<div class=\"dragImageEdit\"> \n\n</div>\n<div class=\"dynamicImageEdit\"> \n<img src=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"> \n</div>\n\n</div>\n\n<!-- table cell lable area -->\n\n<div class=\"MenuItemlabelIconEdit\" >\n\n\n\n<div >\n   \n  ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="  \n</div>\n\n</div>\n\n<!-- table cell Count Minus area -->\n\n<div class=\"MenuItemCountMinusEdit\" >\n\n<div class=\"userMinusImageEdit\" onclick=\"clickMinus(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\');\">\n    \n               \n</div>\n\n<div style=\"clear: both;\"></div>\n\n</div>\n\n</div>\n        \n        </div>\n        \n                    \n</div>\n ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" \n\n    ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="                 \n  </div>\n                \n                \n\n\n\n</div>\n\n\n</div>\n\n</div>\n\n<div class=\"inactiveList\">\n\n\n\n<!-- table -->\n<div class=\"MenuList\" >\n\n<div class=\"MenuListItemLable\" >\n\n<div class=\"MenuListItemLableCell\" >\nINACTIVE WIDGETS\n</div>\n</div>\n\n<!-- table row -->\n<div class=\"MenuListItem\" >\n\n <div id=\"sortable-basic-Inactive\">\n ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\n\n ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n <div class=\"sortableNormal\"  style=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"    data-usercode=\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="  \n</div>\n\n</div>\n\n<!-- table cell Count Minus area -->\n<!--\n\n<div class=\"MenuItemCountMinus\" >\n\n<div style=\"\n    position: relative;\n    background-color:#23789e;\n    text-align: center;\n    border-radius: 44%;\n    height: 21px;\n    width: 38px;\n    float: right;\n    \">\n    \n               <div id=\"countDisplay";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"  class=\"DisplayStyle\">0</div>\n               \n             \n</div>\n\n<div style=\"clear: both;\"></div>\n\n</div>\n\n -->\n</div>\n        \n        </div>\n        \n                    \n</div>\n  \n \n  \n   \n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n <div class=\"sortableInactive\"   style=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"   id=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="_E\" data-id=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="_E\"  data-visible=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" data-usercode=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n                    <!-- table cell drag icon area -->\n\n<div class=\"MenuItemTableEdit\">\n<div class=\"MenuItemRowEdit\">\n<div class=\"MenuItemDragIconEdit\" >\n\n\n\n<div class=\"dragImageEdit\"> \n\n</div>\n<div class=\"dynamicImageEdit\"> \n<img src=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="  \n</div>\n\n</div>\n\n<!-- table cell Count Minus area -->\n\n<div class=\"MenuItemCountMinusEdit\" >\n\n<div class=\"userAddImageEdit\" onclick=\"clickADD(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="_E\');\">\n    \n               \n</div>\n\n<div style=\"clear: both;\"></div>\n\n</div>\n\n</div>\n        \n        </div>\n        \n                    \n</div>\n ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n  \n  ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n  \n   \n\n\n                    \n  </div>\n                \n                \n\n\n\n</div>\n\n\n</div>\n\n</div>\n\n</div>\n\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\n</div>\n</div>\n<div class=\"nonClickableWarpper\" id=\"backGroundWrapper\" onclick=\"closeUserSummary()\"style=\"\">\n\n</div>\n</div>\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
 String widgetList=request.getParameter("mode")==null?"":request.getParameter("mode");
PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
WidgetOrderBC bc = new WidgetOrderBC();
WidgetOrderResponse widgetOrderResp = new WidgetOrderResponse();



if(widgetList.equalsIgnoreCase("restore")){
	widgetOrderResp = bc.getDefaultWidgetOrder(patientContext);
	
}else{
	
	 widgetOrderResp = bc.getUserWidgetOrder(patientContext);
}



ArrayList<WidgetItems> allPrefered = new ArrayList();

int activeCount=0;
int InactiveCount=0;

ArrayList<WidgetItems> allPreferncescativeAll =  widgetOrderResp.getActiveWidgets();

activeCount=allPreferncescativeAll.size();



for(int u=0;u<allPreferncescativeAll.size();u++){
	 
	 WidgetItems currentItem = allPreferncescativeAll.get(u); 
	 allPrefered.add(currentItem);
	 
}


ArrayList<WidgetItems> allPreferncesIncativeAll =  widgetOrderResp.getInactiveWidgets();

InactiveCount=allPreferncesIncativeAll.size();


for(int u=0;u<allPreferncesIncativeAll.size();u++){
	 
	 WidgetItems currentItem = allPreferncesIncativeAll.get(u); 
	 allPrefered.add(currentItem);
	 
}




            _bw.write(_wl_block3Bytes, _wl_block3);
 if(widgetList.equalsIgnoreCase("Normal")){
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block5Bytes, _wl_block5);
 }else{
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
} 
            _bw.write(_wl_block10Bytes, _wl_block10);


 
 ArrayList<WidgetItems> allPreferncescative =  widgetOrderResp.getActiveWidgets();
 ArrayList<WidgetItems> allPrefernces_idcative =  widgetOrderResp.getActiveWidgets();
 
 
 

 /*
 allPrefernces.add("Latest vitals");
 allPrefernces.add("Allergies");
 allPrefernces.add("Procedure details");
 allPrefernces.add("Active Problem");
 allPrefernces.add("Clinical Notes");
 allPrefernces.add("Results");
 allPrefernces.add("Pending Orders");
 allPrefernces.add("Current Medication");

 
 allPrefernces_id.add("Latestvitals");
 allPrefernces_id.add("Allergies");
 allPrefernces_id.add("Proceduredetails");
 allPrefernces_id.add("ActiveProblem");
 allPrefernces_id.add("ClinicalNotes");
 allPrefernces_id.add("Results");
 allPrefernces_id.add("PendingOrders");
 allPrefernces_id.add("CurrentMedication");
 */
 
 
 for(int u=0;u<allPrefered.size();u++){
	 
	 WidgetItems currentItem = allPrefered.get(u); 
	 
	 String preferncesValue=currentItem.getWidgetId();
	 
	 String prefernces_id=currentItem.getWidgetId();
	 
	 String Style="display:none;";
	 
	
	 
	  String visible="N";
	 if(activeCount>=u+1){
		 
		 Style="";
		 visible="Y";
		 
	 }
	 

	 
 
 
 
            _bw.write(_wl_block11Bytes, _wl_block11);
 
String imageSrc="";
 

if(prefernces_id.equalsIgnoreCase(currentItem.VITALS.getWidgetId())){
	imageSrc="Userpref_Latestvitals24x24.png";
	preferncesValue="Latest vitals";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.ALLERGY.getWidgetId())){
	imageSrc="Userpref_Allergies24x24.png";
	preferncesValue="Allergies";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.PROCEDURE.getWidgetId())){
	
	imageSrc="Userpref_Proceduredetails24x24.png";
	preferncesValue="Procedure details";
}else if(prefernces_id.equalsIgnoreCase(currentItem.PROBLEMS.getWidgetId())){
	imageSrc="Userpref_Activeproblems_diagnosis24x24.png";
	preferncesValue="Active Problems & Diagnosis";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.NOTES.getWidgetId())){
	
	imageSrc="Userpref_Clinicalnotes24x24.png";
	preferncesValue="Clinical Notes";
}else if(prefernces_id.equalsIgnoreCase(currentItem.RESULTS.getWidgetId())){
	imageSrc="Userpref_Results24x24.png";
	preferncesValue="Results";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.PENDINGORDERS.getWidgetId())){
	imageSrc="Userpref_Pendingorders24x24.png";
	preferncesValue="Pending Orders";
	
}else if(prefernces_id.equalsIgnoreCase(currentItem.MEDICATIONS.getWidgetId())){
	
	imageSrc="Userpref_Currentmedication24x24.png";
	preferncesValue="Current Medication";
}



            _bw.write(_wl_block11Bytes, _wl_block11);
 if(widgetList.equalsIgnoreCase("Normal")){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(Style));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(imageSrc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( preferncesValue ));
            _bw.write(_wl_block18Bytes, _wl_block18);
 if(!prefernces_id.equalsIgnoreCase("VITALS")){ 
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
 } 
            _bw.write(_wl_block21Bytes, _wl_block21);
 }else {
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(Style));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(visible ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(imageSrc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( preferncesValue ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
 }
            _bw.write(_wl_block31Bytes, _wl_block31);
 }
            _bw.write(_wl_block32Bytes, _wl_block32);


 
 ArrayList<WidgetItems> allPreferncesIncative =  widgetOrderResp.getInactiveWidgets();
 ArrayList<WidgetItems> allPrefernces_idIncative =  widgetOrderResp.getInactiveWidgets();
 
 /*
 allPrefernces.add("Latest vitals");
 allPrefernces.add("Allergies");
 allPrefernces.add("Procedure details");
 allPrefernces.add("Active Problem");
 allPrefernces.add("Clinical Notes");
 allPrefernces.add("Results");
 allPrefernces.add("Pending Orders");
 allPrefernces.add("Current Medication");
*/

/*
  allPrefernces_id =new ArrayList();
  
 allPrefernces_id.add("Latestvitals_E");
 allPrefernces_id.add("Allergies_E");
 allPrefernces_id.add("Proceduredetails_E");
 allPrefernces_id.add("ActiveProblem_E");
 allPrefernces_id.add("ClinicalNotes_E");
 allPrefernces_id.add("Results_E");
 allPrefernces_id.add("PendingOrders_E");
 allPrefernces_id.add("CurrentMedication_E");
 */
 int pos=allPrefered.size();
 
 for(int u=0;u<allPrefered.size();u++){
	 
	 //pos=allPrefered.size();
	 
	 WidgetItems currentItem = allPrefered.get(u); 
	 
 String preferncesValue=currentItem.getWidgetId();
 
 String prefernces_id=currentItem.getWidgetId();
 
 String Style="display:none; background:#023c59; opacity:0.7";
 String visible="N";
 
 
 
 pos--;
 
 
 

 
 if(InactiveCount>pos){
	 
	 Style="background:#023c59; opacity:0.7";
	 visible="Y";
 }
 
 
 
            _bw.write(_wl_block33Bytes, _wl_block33);
 
String imageSrc="";

 if(prefernces_id.equalsIgnoreCase(currentItem.VITALS.getWidgetId())){
		imageSrc="Userpref_Latestvitals24x24.png";
		preferncesValue="Latest vitals";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.ALLERGY.getWidgetId())){
		imageSrc="Userpref_Allergies24x24.png";
		preferncesValue="Allergies";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.PROCEDURE.getWidgetId())){
		
		imageSrc="Userpref_Proceduredetails24x24.png";
		preferncesValue="Procedure details";
	}else if(prefernces_id.equalsIgnoreCase(currentItem.PROBLEMS.getWidgetId())){
		imageSrc="Userpref_Activeproblems_diagnosis24x24.png";
		preferncesValue="Active Problems & Diagnosis";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.NOTES.getWidgetId())){
		
		imageSrc="Userpref_Clinicalnotes24x24.png";
		preferncesValue="Clinical Notes";
	}else if(prefernces_id.equalsIgnoreCase(currentItem.RESULTS.getWidgetId())){
		imageSrc="Userpref_Results24x24.png";
		preferncesValue="Results";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.PENDINGORDERS.getWidgetId())){
		imageSrc="Userpref_Pendingorders24x24.png";
		preferncesValue="Pending Orders";
		
	}else if(prefernces_id.equalsIgnoreCase(currentItem.MEDICATIONS.getWidgetId())){
		
		imageSrc="Userpref_Currentmedication24x24.png";
		preferncesValue="Current Medication";
	}



            _bw.write(_wl_block34Bytes, _wl_block34);
 if(widgetList.equalsIgnoreCase("Normal")){
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(Style));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(imageSrc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( preferncesValue ));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
 }else {
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(Style));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(visible ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${path}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(imageSrc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( preferncesValue ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(prefernces_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
 }
            _bw.write(_wl_block47Bytes, _wl_block47);
 }
            _bw.write(_wl_block48Bytes, _wl_block48);
            _bw.write(_wl_block49Bytes, _wl_block49);
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
