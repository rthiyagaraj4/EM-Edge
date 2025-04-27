package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __administrativefunctionobjectcollect extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AdministrativeFunctionobjectCollect.jsp", 1709120142000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2_0 ="\n<html>\n<head>\n\n<script type=\'text/javascript\' src=\'../../eOT/js/OTCommon.js\'></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script type=\'text/javascript\' src=\'../../eOT/js/AdministrativeFunctionforAllCharges.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n<script language=\'javascript\'>\nvar rows = new Array();\nvar rowLength=0;\nvar line_no=0;\nvar op_rows = new Array();\nvar oprowLength=0;\n\nvar personnelrows = new Array();\nvar personnelrowLength=0;\nvar specimen_rows = new Array();\nvar specimen_len=0;\nvar disposal_rows = new Array();\nvar disposal_len=0;\nvar instrument_rows = new Array();\nvar instrument_len=0;\nvar equipment_rows = new Array();\nvar equipment_len = 0;\nvar packs_rows=new Array();\nvar packs_len = 0;\nvar implants_rows = new Array();\nvar implants_len = 0;\nvar time_rows = new Array();\nvar time_len = 0;\nvar visit_pers_rows=new Array();\nvar visit_pers_len=0;\n//For Sugery History\nvar diagnosis_rows = new Array();\nvar diagnosis_len = 0;\n//for displaying the rows only one time from db(initially)\nvar db_flag=\"ON\";\nvar splty_code=\"\";\nvar TIME_AND_DETAILS_ENTERED=\"N\";\nvar VISIT_PERSONEL_ENTERED=\"N\";\nvar mandatory_proc=new Array();\n</script>\n\n<script language=\'javascript\'>\n\n \n\nfunction createXMLForOperations(){\n  var rows=parent.AdminObjectCollect.op_rows;\n  var bill_flag=document.forms[0].bill_flag.value;\n  var len = rows.length;\n  var table_name = \"OT_POST_OPER_DTLS\";\n  var xmlString =\"\";\n\n\n  for(var i=0;i<len;i++){\n\t // here we skip the rows db_mode=\'L\' since no modification is done (fetched records from db)\n\t //if(rows[i]!=null && rows[i].db_mode!=\'L\'){\n\n\t if(rows[i]!=null){\n\t\txmlString+=\"<PROC_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"right_left_flag=\\\"\"+rows[i].side_applicable+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_remarks=\\\"\"+rows[i].remarks+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_line_num=\\\"\"+rows[i].line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"order_line_num=\\\"\"+rows[i].order_line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_line_status=\\\"\"+rows[i].chk_status+\"\\\"\"+\" \";\n\t\txmlString+=\"cancel_remarks=\\\"\"+rows[i].cancel_remarks+\"\\\"\"+\" \";\n\t\txmlString+=\"bill_yn=\\\"\"+rows[i].bill_yn+\"\\\"\"+\" \";\n\t\txmlString+=\"billed_yn=\\\"\"+rows[i].billed_yn+\"\\\"\"+\" \";\n\t\t // alert(\"xmlString--->\"+xmlString)\n\t\txmlString+=\"fpp_category=\\\"\"+rows[i].fpp_category+\"\\\"\"+\" \";//Added Against ML-MMOH-CRF-1939-US4\n\t\t//if(bill_flag==\"true\")\n\t\t//{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \";\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \";\n\t\t//}\n\t\txmlString+=\"order_id=\\\"\"+rows[i].order_id+\"\\\"\"+\" \";\n\t\txmlString+=\"insert_flag=\\\"\"+\"Operation\"+\"\\\"\"+\" \";\n\t\t\n\t\tif(rows[i].db_mode==\"L\")\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\t\n\t\t//xmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n  }\n\n return xmlString;\n}\n\n\nfunction createXMLForImplants(){\n  var rows=parent.AdminObjectCollect.implants_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_IMPLANTS\";\n  var accessory_type = \"S\";\n  var len = rows.length;\n  var xmlString =\"\";\n  var bill_flag=document.forms[0].bill_flag.value;\n  var st_interface_flag=document.forms[0].st_interface_flag.value;\n  for(var i=0;i<len;i++){\n  //Maheshwaran K added for the SKR-SCF-0788 [IN:039522]  as on 30/09/2013   \n   //if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t if((rows[i]!=null)||(rows[i]!=\'undefined\')){\n\t\txmlString+=\"<IMPL_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"implant_code=\\\"\"+rows[i].implant_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\" )\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \"; // Newly added by bshankar\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"reserved_qty=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"requested_qty=\\\"\"+rows[i].requested_qty+\"\\\"\"+\" \";\n\t\txmlString+=\"req_store_code=\\\"\"+rows[i].req_store_code+\"\\\"\"+\" \";\n\t\t//xmlString+=\"Store_desc=\\\"\"+rows[i].Store_desc+\"\\\"\"+\" \";\n\t\txmlString+=\"sale_document_no=\\\"\"+rows[i].sale_document_no+\"\\\"\"+\" \";\n\t\txmlString+=\"sale_document_type=\\\"\"+rows[i].sale_document_type+\"\\\"\"+\" \";\n\t\txmlString+=\"Stockavail=\\\"\"+rows[i].Stockavail+\"\\\"\"+\" \";\n\n\t\txmlString+=\"insert_flag=\\\"\"+\"Accessories\"+\"\\\"\"+\" \";\n\t\t\n\t\t\n\t\tif(st_interface_flag==\"N\"){\n\t\txmlString+=\"manufacturer=\\\"\"+rows[i].manufacturer+\"\\\"\"+\" \";\n\t\txmlString+=\"batch=\\\"\"+rows[i].batch+\"\\\"\"+\" \";\n\t\t}\n\t\t//xmlString+=\"remarks=\\\"\"+rows[i].remarks+\"\\\"\"+\" \";\n\t\t//Added encodeURIComponent on 10/19/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\t\n\t\tif(typeof(rows[i].frm_pick_list)==\'undefined\') \n\t\t {\n\t\trows[i].frm_pick_list=\"N\";\n\t\t }\n      \n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\tif(rows[i].db_mode==\"L\")\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n  }\n  return xmlString;\n}\n\nfunction createXMLForPackage(){\t\n  var rows=parent.AdminObjectCollect.packs_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_PACKAGES\";\n  var accessory_type = \"P\";\n  var len = rows.length;\n  var xmlString =\"\";\n  var bill_flag=document.forms[0].bill_flag.value;\n  for(var i=0;i<len;i++){\n\t //if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t if(rows[i]!=null){\n\t\txmlString+=\"<PACK_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"package_code=\\\"\"+rows[i].package_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key=\\\"\"+rows[i].key+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \"; // Newly added by bshankar\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\t//xmlString+=\"remarks=\\\"\"+checkSpl(rows[i].remarks)+\"\\\"\"+\" \";\n\t\t//Added encodeURIComponent on 10/19/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\txmlString+=\"insert_flag=\\\"\"+\"Accessories\"+\"\\\"\"+\" \";\n\t\tif(typeof(rows[i].frm_pick_list)==\'undefined\') \n\t\t{\n\t\trows[i].frm_pick_list=\"N\";\n\t\t}\n      \n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\tif(rows[i].db_mode==\"L\")\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n  }\n  //alert(\"xmlString\")\n  // alert(\"xmlString---->\"+xmlString)\n  return xmlString;\n}\n\n\n\nfunction createXMLForEquipments(){\n  var rows=parent.AdminObjectCollect.equipment_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_EQUIPMENTS\";\n  var accessory_type = \"E\";\n  var len = rows.length;\n  var xmlString =\"\";\n  var bill_flag=document.forms[0].bill_flag.value;\n  for(var i=0;i<len;i++){\n\t //if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t if(rows[i]!=null)\n\t {\n\t\t//rows[i].quantity=\"1\";// just for now after adding quantity field remove this one and pass quantity field value\n\t\txmlString+=\"<EQUIP_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"equip_code=\\\"\"+rows[i].equip_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \"; // Newly added by bshankar\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\txmlString+=\"equip_id=\\\"\"+rows[i].equip_id+\"\\\"\"+\" \";\n\t\t//xmlString+=\"remarks=\\\"\"+checkSpl( rows[i].remarks )+\"\\\"\"+\" \";\n\t\t//Added encodeURIComponent on 10/28/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\t\txmlString+=\"desiredDate=\\\"\"+rows[i].desiredDate+\"\\\"\"+\" \";\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\txmlString+=\"insert_flag=\\\"\"+\"Accessories\"+\"\\\"\"+\" \";\n\t\tif(typeof(rows[i].frm_pick_list)==\'undefined\') \n\t\t{\n\t\trows[i].frm_pick_list=\"N\";\n\t\t}\n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\tif(rows[i].db_mode==\"L\"){\n\t\t\t//Added Against Start AMRI-CRF-0294 [IN049121]\n\t\t\tif(rows[i].oper_line_status==\'99\'){\n\t\t\t\txmlString+=\"db_mode=\\\"\"+\"D\"+\"\\\"\"+\" \";\n\t\t\t}else{ //Added Against End AMRI-CRF-0294 [IN049121]\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\t\t} //Added Against AMRI-CRF-0294 [IN049121]\n\t\t\t}\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\t\t\n\t }\n  }\n  return xmlString;\n}\n function createXMLForInstruments(){\n  var rows=parent.AdminObjectCollect.instrument_rows;\n  var table_name=\"OT_SURGICAL_ACCESSORIES_INSTRUMENT\";\n  var accessory_type = \"I\";\n  var len = rows.length;\n  var xmlString =\"\";\n   var bill_flag=document.forms[0].bill_flag.value;\n  for(var i=0;i<len;i++){\n\t //if(rows[i]!=null &&  rows[i].db_mode!=\'L\'){\n\t if(rows[i]!=null){\n\t    //rows[i].quantity=\"1\";// just for now after adding quantity field remove this one and pass quantity field value\n\t\txmlString+=\"<INSTR_DTL\"+i+\" \";\n\t\txmlString+=\"oper_num=\\\"\"+document.forms[0].oper_num.value+\"\\\"\"+\" \";\n\t\txmlString+=\"oper_code=\\\"\"+rows[i].oper_code+\"\\\"\"+\" \";\n\t\txmlString+=\"instr_code=\\\"\"+rows[i].instr_code+\"\\\"\"+\" \";\n\t\txmlString+=\"key_line=\\\"\"+rows[i].key_line+\"\\\"\"+\" \"; // Use this during update mode for Billing\n\t\tif(bill_flag==\"true\")\n\t\t{\n\t\txmlString+=\"bill_str=\\\"\"+rows[i].rate+\"::\"+rows[i].bill_str+\"\\\"\"+\" \"; // Newly added by bshankar\n\t\txmlString+=\"panel_str=\\\"\"+escape(rows[i].panel_str)+\"\\\"\"+\" \"; // Newly Added by bshankar\n\t\t}\n\t\txmlString+=\"oper_line_no=\\\"\"+rows[i].oper_line_no+\"\\\"\"+\" \";\n\t\t//Encoded for CRF-0058 by Rajesh\n\t\txmlString+=\"tray_no=\\\"\"+encodeURIComponent(rows[i].tray_no)+\"\\\"\"+\" \";\n\t\t//Encoded for CRF-0058 by Rajesh\n\t\t//xmlString+=\"remarks=\\\"\"+checkSpl( rows[i].remarks )+\"\\\"\"+\" \";\n\t\t//";
    private final static byte[]  _wl_block2_0Bytes = _getBytes( _wl_block2_0 );

    private final static java.lang.String  _wl_block2_1 ="Added encodeURIComponent on 10/19/2010 for IN023758 by AnithaJ\n\t\txmlString+=\"remarks=\\\"\"+encodeURIComponent(rows[i].remarks)+\"\\\"\"+\" \";\n\n\t\txmlString+=\"quantity=\\\"\"+rows[i].quantity+\"\\\"\"+\" \";\n\t\txmlString+=\"accessory_type=\\\"\"+accessory_type+\"\\\"\"+\" \";\n\t\txmlString+=\"insert_flag=\\\"\"+\"Accessories\"+\"\\\"\"+\" \";\n\t\tif(typeof(rows[i].frm_pick_list)==\'undefined\') \n\t\t{\n\t\trows[i].frm_pick_list=\"N\";\n\t\t}\n\t\txmlString+=\"frm_pick_list=\\\"\"+rows[i].frm_pick_list+\"\\\"\"+\" \";\n\t\t\n\t\tif(rows[i].db_mode==\"L\")\n\t\t\txmlString+=\"db_mode=\\\"\"+\"U\"+\"\\\"\"+\" \";\n\t\telse\n\t\t\txmlString+=\"db_mode=\\\"\"+rows[i].db_mode+\"\\\"\"+\" \";\n\t\txmlString+=\"table_name=\\\"\"+table_name+\"\\\"\"+\" />\";\n\t }\n  }\n   return xmlString;\n}\n\n//Modified by DhanasekarV on 27/01/2011 against issue IN026046\nfunction assignAdminFunction(param)\n{\n parent.AdministrativeFucntionFrame.location.href = \"../../eOT/jsp/AdministrativeFunctionforAllChargesFrame.jsp?\"+param;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n";
    private final static byte[]  _wl_block2_1Bytes = _getBytes( _wl_block2_1 );

    private final static java.lang.String  _wl_block3 ="\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\n<form name=\"AdminCollectForm\" id=\"AdminCollectForm\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' >\n<input type=\'hidden\' name=\'bill_flag\' id=\'bill_flag\' value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' >\n<input type=\'hidden\' name=\'st_interface_flag\' id=\'st_interface_flag\' value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' >\n<input type=\'hidden\' name=\'slate_user_id\' id=\'slate_user_id\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' >\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' >\n<!-- Modified by DhanasekarV on 27/01/2011 against issue IN026046   -->\n<script>assignAdminFunction(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'); </script>\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
            _bw.write(_wl_block2_0Bytes, _wl_block2_0);
            _bw.write(_wl_block2_1Bytes, _wl_block2_1);
 
String oper_num = checkForNull(request.getParameter("oper_num")); 
String bill_flag = checkForNull(request.getParameter("bill_flag")); 
String st_interface_flag = checkForNull(request.getParameter("st_interface_flag1")); 

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(st_interface_flag));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(checkForNull(request.getParameter("slate_user_id"))));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
