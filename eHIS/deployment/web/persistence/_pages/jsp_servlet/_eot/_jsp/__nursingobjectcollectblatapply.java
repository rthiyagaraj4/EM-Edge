package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import eOR.OrderEntryBillingQueryBean;
import eOT.OTBillingBean;

public final class __nursingobjectcollectblatapply extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/NursingObjectCollectBLAtApply.jsp", 1709120260000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HTML>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/OTCommon.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\"JavaScript\" src=\"../../eOT/js/RecordNursing.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\' ></script>\n\n<script language=\'javascript\'>\n\nfunction Class_row(load_rows_type){\n\tif(load_rows_type==\"S\"){\n\t\tthis.oper_code =\"\";\n\t\tthis.oper_desc=\"\";\n\t\tthis.package_code=\"\";\n\t\tthis.package_desc=\"\";\n\t\tthis.oper_line_no =\"\";\n\t\tthis.quantity =\"\";\n\t\tthis.remarks =\"\";\n\t\tthis.order=\"\";\n\t\tthis.accessory_type=\"\";\n\t\tthis.db_mode=\"\";\n\t\tthis.recId=\"\";\n\t\tthis.bill_str=\"\";\n\t\tthis.panel_str=\"\";\n\t\tthis.key=\"\";\n\t\tthis.key_line=\"\";\n\t\tthis.rate=\"\";\n\t}else if(load_rows_type==\"E\"){\n\t\tthis.oper_code =\"\";\n\t\tthis.oper_desc=\"\";\n\t\tthis.equip_code=\"\";\n\t\tthis.equip_desc=\"\";\n\t\tthis.oper_line_no =\"\";\n\t\tthis.equip_id =\"\";\n\t\tthis.remarks =\"\";\n\t\tthis.quantity =\"\";\n\t\tthis.order=\"\";\n\t\tthis.accessory_type=\"\";\n\t\tthis.db_mode=\"\";\n\t\tthis.recId=\"\";\n\t\tthis.bill_str=\"\";\n\t\tthis.panel_str=\"\";\n\t\tthis.key=\"\";\n\t\tthis.key_line=\"\";\n\t\tthis.rate=\"\";\n\t}else if(load_rows_type==\"C\"){\n\t\tthis.oper_code =\"\";\n\t\tthis.oper_desc=\"\";\n\t\tthis.package_code=\"\";\n\t\tthis.package_desc=\"\";\n\t\tthis.oper_line_no =\"\";\n\t\tthis.quantity =\"\";\n\t\tthis.remarks =\"\";\n\t\tthis.order=\"\";\n\t\tthis.accessory_type=\"\";\n\t\tthis.db_mode=\"\";\n\t\tthis.recId=\"\";\n\t\tthis.bill_str=\"\";\n\t\tthis.panel_str=\"\";\n\t\tthis.key=\"\";\n\t\tthis.key_line=\"\";\n\t\tthis.reserved_qty=\"\";\n\t\tthis.requested_qty=\"\";\n\t\tthis.req_store_code=\"\";\n\t\tthis.rate=\"\";\n\t}else if(load_rows_type==\"I\"){\n\t\tthis.oper_code =\"\";\n\t\tthis.oper_desc=\"\";\n\t\tthis.implants_code=\"\";\n\t\tthis.implants_desc=\"\";\n\t\tthis.oper_line_no =\"\";\n\t\tthis.manufacturer=\"\";\n\t\tthis.batch=\"\";\n\t\tthis.order=\"\";\n\t\tthis.quantity =\"\";\n\t\tthis.remarks =\"\";\n\t\tthis.accessory_type=\"\";\n\t\tthis.db_mode=\"\";\n\t\tthis.recId=\"\";\n\t\tthis.reserved_qty=\"\";\n\t\tthis.requested_qty=\"\";\n\t\tthis.sale_document_no =\"\";\n\t\tthis.sale_document_type =\"\";\n\t\tthis.req_store_code=\"\";\n\t\tthis.Store_desc=\"\";\n\t\tthis.Stockavail = \"\";\n\t\tthis.bill_str=\"\";\n\t\tthis.bill_str_conspack=\"\";\n\t\tthis.panel_str=\"\";\n\t\tthis.panel_str_conspack=\"\";\n\t\tthis.key=\"\";\n\t\tthis.key_line=\"\";\n\t\tthis.rate=\"\";\n\t}\n}\n\nfunction loadCodes(){\n/*\n\tvar formObj = document.AllAccessoriesRecordForm;\n\tvar codes =  formObj.operation.value;\n    var arr = codes.split(\"##\");\n\t//alert(arr);\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n*/\n}\n\nfunction assignCodes(obj){\n\tvar formObj = document.AllAccessoriesRecordForm;\n\tvar codes =  obj.value;\n    var arr = codes.split(\"##\");\n\t//alert(arr);\n\tformObj.oper_code.value=arr[0];\n\tformObj.oper_line_no.value=arr[1];\n}\n\nfunction loadInstrumentRows(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,oper_num,mode,order,bill_str,panel_str,key,key_line,frompicklist,quantity){ \n  //alert(\"In loadInstrumentRows, mode:\"+mode);\n  //alert(\"In loadInstrumentRows, rowLength:\"+rowLength);\n//alert(parent.ObjectCollect.hello);\n/*alert(\"mode---->\"+mode)\nalert(\"oper_code---->\"+oper_code)\nalert(\"oper_desc---->\"+oper_desc)\nalert(\"line_no---->\"+line_no)\nalert(\"instr_code---->\"+instr_code)\nalert(\"instr_desc---->\"+instr_desc)\nalert(\"instr_desc---->\"+instr_desc)\nalert(\"order---->\"+order)\nalert(\"panel_str---->\"+panel_str)\nalert(\"key---->\"+key)\nalert(\"key_line---->\"+key_line)*/\n //alert(\"BLAt apply\");\n //alert(\"order----->\"+order)\n  var rows=parent.ObjectCollect.instrument_rows;\n  var rowLength=parent.ObjectCollect.instrument_len;\n   //alert(\"rowLength---->\"+rowLength);\n   if(mode==\'L\' && (rowLength==0 || rowLength==undefined || rowLength==\"undefined\") ){\n\n\t   //alert(\"162\");\n\t  var objrow = newRow(\"S\");\n\t  objrow.oper_code=oper_code;\n\t  objrow.oper_desc=decodeUTF8(oper_desc);\n\t  objrow.instr_code=instr_code;\n\t  objrow.instr_desc=decodeUTF8(instr_desc);\n\t  objrow.oper_line_no=line_no;\n\t  objrow.tray_no=tray_no;\n\t   objrow.quantity=quantity;\n\t  objrow.remarks=decodeUTF8(remarks);\n\t  objrow.recId = index;\n\t  objrow.db_mode=\"L\";\n\t  //objrow.db_mode=(order==1)?\"L\":\"I\";\n\t  objrow.order=order;\n\t  objrow.bill_str=bill_str;\n\t  objrow.panel_str=panel_str;\n\t  objrow.key=key;\n\t  objrow.key_line=key_line;\n\t  objrow.rate=\"\";\n\t//  alert(\"179\");\n\t // alert(\"objrow---->\"+objrow);\n\t  rows.push(objrow);\n\t//  alert(\"objrow.bill_str=======\"+objrow.bill_str);\n\t}\n//alert(parent.ObjectCollect.createXMLForInstruments());\n}\n\nfunction decodeUTF8(str){\n\t var REG_EXP =/\\+/g;\n\treturn decodeURIComponent(str,\"UTF-8\").replace(REG_EXP,\" \");\n}\n\nfunction loadEquipmentRows(oper_code,oper_desc,line_no,instr_code,instr_desc,tray_no,remarks,index,mode,order,bill_str,panel_str,key,key_line,from_picklist,quantity){ \n  //alert(\"In loadEquipmentRows, mode:\"+mode);\n  //alert(\"In loadEquipmentRows, rowLength:\"+rowLength);\n  //alert(\"bill_str-177-->\"+bill_str);\n  var objrow = newRow(\"E\");\n  var rows=parent.ObjectCollect.equipment_rows;\n  var rowLength=parent.ObjectCollect.equipment_len;\n\n  if(mode==\'L\' && (rowLength==0 || rowLength==undefined || rowLength==\"undefined\")){\n\t  objrow.oper_code=oper_code;\n\t  objrow.oper_desc=decodeURIComponent(oper_desc,\"UTF-8\").replace(/\\+/g,\" \");\n\t  objrow.equip_code=instr_code;\t  \n\t  objrow.equip_desc=decodeURIComponent(instr_desc,\"UTF-8\").replace(/\\+/g,\" \");\n\t  objrow.oper_line_no=line_no;\n\t  objrow.equip_id=tray_no;\n\t  objrow.remarks=decodeURIComponent(remarks,\"UTF-8\").replace(/\\+/g,\" \");\n\t  objrow.recId = index;\n\t   objrow.quantity=quantity;\n\t  objrow.db_mode=\"L\";\n\t  //objrow.db_mode=(order==1)?\"L\":\"I\";\n\t  objrow.order = order;\n\t  objrow.bill_str=bill_str;\n\t  objrow.panel_str=panel_str;\n\t  objrow.key=key;\n\t  objrow.key_line=key_line;\n\t  objrow.rate=\"\";\n\t  rows.push(objrow);\n\t  //alert(rows.toString());\n\t }\t \n}\nfunction loadPackageRows(oper_code,oper_desc,line_no,package_code,package_desc,quantity,remarks,index,mode,order,bill_str_conspack,panel_str_conspack,key,key_line,req_store_code,reserved_qty, requested_qty){ \n  //alert(\"In loadPackageRows, mode:\"+mode);\n  //alert(\"In loadPackageRows, rowLength:\"+rowLength);\n\n\tvar objrow = newRow(\"C\");\n\tvar rows_copk=parent.parent.parent.ObjectCollect.packs_rows;\n  var rowLength=parent.parent.parent.parent.ObjectCollect.packs_len;\n if(mode==\'L\' && rowLength==0){\n\t  objrow.oper_code=oper_code;\n\t  objrow.oper_desc=unescape(oper_desc);\n\t  objrow.package_code=package_code;\n\t  objrow.package_desc=unescape(package_desc);\n\t  objrow.oper_line_no=line_no;\n\t  objrow.quantity=quantity;\n\t   \n\t  objrow.reserved_qty=reserved_qty;\n\t  objrow.requested_qty=requested_qty;\n\n\t  objrow.remarks=unescape(remarks);\n\t  objrow.recId = index;\n\t  objrow.db_mode=(order==1)?\"L\":\"I\";\n\t  objrow.order = order;\n\t  objrow.bill_str_conspack=bill_str_conspack;\n\t  objrow.panel_str_conspack=panel_str_conspack;\n\t  objrow.key=key;\n\t  objrow.key_line=key_line;\n\t  objrow.rate=\"\";\n\n\t  objrow.req_store_code=req_store_code;\n\t  rows_copk.push(objrow);\n\t \n\t  }\n//alert(parent.ObjectCollect.createXMLForPackage());\n}\n\nfunction loadImplantRows(oper_code,oper_desc,line_no,implant_code,implant_desc,quantity,mfgr,batch,remarks,index,mode,order,bill_str,panel_str,key,key_line,req_store_code,reserved_qty, requested_qty,no_of_units,sale_document_no,sale_document_type,Stockavail,Store_desc){ \n  //alert(\"In loadImplantRows, mode:\"+mode);\n\n\tvar objrow = newRow(\"I\");\n\tvar rows=parent.parent.parent.ObjectCollect.implants_rows;\n    var rowLength=parent.parent.parent.parent.ObjectCollect.implants_len;\n\n  \n  if(mode==\'L\' && rowLength==0){\n\t  //alert(\"1384\")\n\t  objrow.oper_code=oper_code;\n\t  objrow.oper_desc=unescape(oper_desc);\n\t  objrow.implant_code=implant_code;\n\t  objrow.implant_desc=unescape(implant_desc);\n\t  objrow.Store_desc=unescape(Store_desc);\n\t  objrow.oper_line_no=line_no;\n\t  objrow.quantity=quantity;\n\t  objrow.sale_document_no=sale_document_no;\n\t  objrow.sale_document_type=sale_document_type;\n\n\t // objrow.quantity=no_of_units;\n\t  objrow.reserved_qty=reserved_qty;\n\t  objrow.requested_qty=requested_qty;\n\n\n\t  //alert(\"reserved_qty===\"+reserved_qty)\n\t  \n\t  objrow.manufacturer=mfgr\n\t  objrow.batch=batch;\n\t  objrow.remarks=unescape(remarks);\n\t  objrow.order=order;\n\t  objrow.recId = index;\n\t  objrow.db_mode=(order==1)?\"L\":\"I\";\n\t  objrow.bill_str=bill_str;\n\t  objrow.panel_str=panel_str;\n\t  objrow.key=key;\n\t  objrow.key_line=key_line;\n\t  objrow.rate=\"\";\n\t  objrow.req_store_code=req_store_code;\n\t  objrow.Stockavail=Stockavail;\n\n\t\n\t\n\t  rows.push(objrow);\n\t}\n//alert(parent.ObjectCollect.createXMLForImplants());\n}\n\nfunction newRow(load_rows_type){\n  var objrow = new Class_row(load_rows_type);\n   return(objrow);\n}\n\nfunction assignRecId(load_rows_type){\n\tif(load_rows_type==\"S\"){// For Instruments\n\t\tvar rows = parent.ObjectCollect.instrument_rows;\n\t\tparent.ObjectCollect.instrument_len=rows.length;\n\t}else if(load_rows_type==\"E\"){// For Equipments\n\t\tvar rows = parent.ObjectCollect.equipment_rows;\n\t\tparent.ObjectCollect.equipment_len=rows.length;\n\t}else if(load_rows_type==\"C\"){// For Consumables\n\t\tvar rows = parent.ObjectCollect.packs_rows;\n\t\tparent.ObjectCollect.packs_len=rows.length;\n\t}else if(load_rows_type==\"I\"){// For Implants\n\t\tvar rows = parent.ObjectCollect.implants_rows;\n\t\tparent.ObjectCollect.implants_len=rows.length;\n\t}\t\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\"loadCodes();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name = \'AllAccessoriesRecordForm\'>\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'oper_code\' id=\'oper_code\' value=\'\'>\n<input type=\'hidden\' name=\'oper_line_no\' id=\'oper_line_no\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<input type=\'hidden\' name=\'oper_num\' id=\'oper_num\' value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n</form>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );
 
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

 
	String encode(String data){	  
		String outDat = "";
		byte byteData[] = data.getBytes();
		for (int i=0; i<byteData.length; i++){
			outDat = outDat +"%"+Integer.toHexString((int)byteData[i]);
		}
		return(outDat);
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
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" contentType=" text/html;charset=" 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String facility_id  = (String) session.getValue("facility_id");
	String trace="0";

	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	or_bean.clearBean();

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean	= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String cssd_load_yn	= checkForNull(request.getParameter("cssd_load_yn"));
	String eqp_load_yn	= checkForNull(request.getParameter("eqp_load_yn"));
	String cons_load_yn = checkForNull(request.getParameter("cons_load_yn"));
	String imp_load_yn	= checkForNull(request.getParameter("imp_load_yn"));
	String no_of_units="";


	String oper_num = checkForNull(request.getParameter("oper_num"));
//	String facility_id = checkForNull(request.getParameter("facility_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
//	String booking_num = checkForNull(request.getParameter("booking_num"));	
	String surgeon_code = checkForNull(request.getParameter("surgeon_code"));
	String nursing_doc_comp_yn = checkForNull(request.getParameter("nursing_doc_comp_yn"));
	HashMap line_no_map = new HashMap();
	String line_no="";
	boolean exist_rec = false;
	boolean pick_list = false;
	StringBuffer oper_codes = new StringBuffer();

	String key = "";
	String key_line="";
	String bill_str="";
	String panel_str="";
	HashMap bill_info=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	String order_id="";
	String order_line_num="";
	String booking_date  = "";
	String encounter_id   = "";
	String patient_class   = "";
	String visit_id   = "";
	String catalog_code   = "";

	String SQL_EXIST = "SELECT ACCESSORY_CODE FROM OT_SURGICAL_ACCESSORIES WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND ROWNUM=1";

	String SQL1 = "SELECT A.OPER_CODE OPR_CODE,A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',B.OPER_CODE) OPR_DESC FROM OT_POST_OPER_DTLS A, OT_OPER_MAST B WHERE OPERATING_FACILITY_ID=? AND OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE";

	String CSSD_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_INSTRUMENT_LANG_VW','LONG_DESC','INSTR_CODE',A.ACCESSORY_CODE) ACC_DESC, A.TRAY_NO TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE ,A.Quantity actual_units FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_INSTRUMENT_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND C.LANGUAGE_ID=? AND ACCESSORY_TYPE='I' AND A.OPER_NUM=? AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.INSTR_CODE "; 
	
	String EQP_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_EQUIPMENT_LANG_VW','LONG_DESC','EQUIPMENT_CODE',A.ACCESSORY_CODE) ACC_DESC, A.EQUIPMENT_ID TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.Quantity actual_units  FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_EQUIPMENT C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'E' AND A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.EQUIPMENT_CODE";

	//String CONS_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM"; 
	String CONS_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE) OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PACKAGE_HDR_LANG_VW','LONG_DESC','PACKAGE_CODE',C.PACKAGE_CODE) ACC_DESC, A.QUANTITY TR_NO, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PACKAGE_HDR_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'P' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PACKAGE_CODE AND C.LANGUAGE_ID=? ORDER BY BILL_SUB_REGN_LINE_NUM"; 

	//String IMP_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"' ";
	String IMP_SQL = "SELECT A.OPER_CODE OPR_CODE, A.OPER_LINE_NUM LN_NUM, GET_DESC('"+locale+"','OT_OPER_MAST_LANG_VW','SHORT_DESC','OPER_CODE',A.OPER_CODE)  OPR_DESC, A.ACCESSORY_CODE ACC_CODE, GET_DESC('"+locale+"','OT_PROSTHESIS_LANG_VW','LONG_DESC','PROSTHESIS_CODE',A.ACCESSORY_CODE) ACC_DESC,GET_DESC('"+locale+"','MM_STORE_LANG_VW','SHORT_DESC','STORE_CODE',A.REQ_STORE_CODE) Store_desc, A.QUANTITY TR_NO, A.PROSTHESIS_MFR MFR,A.PROSTHESIS_BATCH_NO BTCH, A.REMARKS REMKS,BILL_SUB_REGN_NUM KEY, BILL_SUB_REGN_LINE_NUM KEY_LINE,A.REQ_STORE_CODE, A.RESERVED_QTY, A.REQUESTED_QTY ,A.SALE_DOCUMENT_TYPE SALE_DOCUMENT_TYPE ,A.SALE_DOCUMENT_NO SALE_DOCUMENT_NO FROM OT_SURGICAL_ACCESSORIES A , OT_OPER_MAST B, OT_PROSTHESIS_LANG_VW C WHERE A.OPERATING_FACILITY_ID=? AND A.OPER_NUM=? AND ACCESSORY_TYPE = 'S' AND  A.OPER_CODE=B.OPER_CODE AND A.ACCESSORY_CODE = C.PROSTHESIS_CODE AND C.LANGUAGE_ID='"+locale+"' ";
	
	Connection con = null;
	PreparedStatement pstmt = null;
	String val= "";
	ResultSet rst = null;
	String rst_acc_code = "";
	String rst_tr_no = "";
	int index=0;
	String load_rows_type = "";
	String load_rows_yn = "";
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(SQL1);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="1";
		rst = pstmt.executeQuery();
		int fetch_count = 0;
		while(rst.next()){
			++fetch_count;
			if(fetch_count==1)
				oper_codes.append("'"+rst.getString(1)+"'");
			else
				oper_codes.append(","+"'"+rst.getString(1)+"'");
			line_no_map.put(rst.getString(1),rst.getString(2));
		}
		if(pstmt!=null)			pstmt.close();
		if(rst!=null)           rst.close();

		pstmt = con.prepareStatement(SQL_EXIST);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,oper_num);
		trace="2";
		rst = pstmt.executeQuery();
		if(rst.next()){
			exist_rec=true;
		}
		if(pstmt!=null)			pstmt.close();
		if(rst!=null)           rst.close();
		if(exist_rec==true){
			for(int k=1;k<=4;k++){			
				// These are fixed consitions just for logic... Nothing functional logic is involved
				// k is iterated from 1 to 4 and for each time different acc_types are considered. k is just a dummy counter
				load_rows_type = "";
				load_rows_yn = "";
				if(k==1 && cssd_load_yn.equals("Y")){ 
					load_rows_type = "S";// Load Instruments
					load_rows_yn = "Y";
				}else if(k==2 && eqp_load_yn.equals("Y")){
					load_rows_type = "E";// Load Equipments
					load_rows_yn = "Y";
				}else if(k==3 && cons_load_yn.equals("Y")){
					load_rows_type = "C";// Load Consumables
					load_rows_yn = "Y";
				}else if(k==4 && imp_load_yn.equals("Y")){
					load_rows_type = "I";// Load Implants
					load_rows_yn = "Y";
				}else{
					load_rows_yn = "N";
				}
				if(load_rows_yn.equals("Y")){
					if(load_rows_type.equals("S")){
						pstmt = con.prepareStatement(CSSD_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,locale);
						pstmt.setString(3,oper_num);
					}else if(load_rows_type.equals("E")){
						pstmt = con.prepareStatement(EQP_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
					}else if(load_rows_type.equals("C")){
						pstmt = con.prepareStatement(CONS_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
						pstmt.setString(3,locale);
					}else if(load_rows_type.equals("I")){
						pstmt = con.prepareStatement(IMP_SQL);
						pstmt.setString(1,facility_id);
						pstmt.setString(2,oper_num);
					}
					trace="3";

					rst = pstmt.executeQuery();
					int count=0;
					while(rst.next()){
                        
					   ++index;	
						key_line = rst.getString("KEY_LINE");
						key = oper_num+"@"+rst.getString("OPR_CODE")+"@S@"+rst.getString("ACC_CODE");
						bill_info = or_bean.getOrderBillDtls(key+key_line);
			
						if(bill_info==null){
							bill_info = new HashMap();
							bill_info.put("key",key);
							bill_info.put("key_line_no",key_line);
							rst_acc_code = rst.getString("ACC_CODE");
							bill_info.put("oper_code",rst_acc_code);//pass acc_code in oper_code
							//bill_info.put("acc_type","C");
							bill_info.put("acc_type",load_rows_type);
							bill_info.put("oper_num",oper_num);
							bill_info.put("locale",locale);
							bill_info.put("module_id","OT");
							//populate billing details from OTBillingBean........	
							if(load_rows_type.equals("C") || load_rows_type.equals("I")){
								// In case of Consumables and Implants, quantity is applicable
								rst_tr_no = rst.getString("TR_NO");
							}else
							{
								rst_tr_no= rst.getString("actual_units");
							}
							bill_info.put("quantity",rst_tr_no);
							bill_info = billing_bean.getBillingParams(bill_info,"C");//C-> for Surgical Accessories Billing
							or_bean.setOrderBillDtls(key+key_line,bill_info);
							putObjectInBean(or_bean_id,or_bean,request);
						}
						String overridden_incl_excl_ind=null;
						String overridden_action_reason_code=null;
						panel_str = (String) bill_info.get("bl_panel_str");	
						bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
						bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
						bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
						bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
						bl_bfr.append(overridden_incl_excl_ind).append("::");
						bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
						bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"))).append("::");
						bl_bfr.append(overridden_action_reason_code).append("::");
						bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"E")).append("::");
						bill_str = bl_bfr.toString();
						bl_bfr.setLength(0);
						if(load_rows_type.equals("S")){
						String from_picklist="";	out.println("<script>loadInstrumentRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("REMKS"))+"','"+index+"','"+oper_num+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+from_picklist+"','"+checkForNull(rst.getString("actual_units"))+"');</script>");
						}else if(load_rows_type.equals("E")){
						String from_picklist="";	out.println("<script>loadEquipmentRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("OPR_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("ACC_DESC")),"UTF-8")+"','"+checkForNull(rst.getString("TR_NO"))+"','"+java.net.URLEncoder.encode(checkForNull(rst.getString("REMKS")),"UTF-8")+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+from_picklist+"','"+checkForNull(rst.getString("actual_units"))+"'); </script>");	
						}else if(load_rows_type.equals("C")){
						String from_picklist="";	out.println("<script>loadPackageRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+encode(checkForNull(rst.getString("REMKS")))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("REQ_STORE_CODE"))+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"');</script>");	
						}else if(load_rows_type.equals("I")){
							//out.println("<script>loadImplantRows('"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("MFR"))+"','"+checkForNull(rst.getString("BTCH"))+"','"+encode(checkForNull(rst.getString("REMKS")))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"'); </script>");	
						String stock_val="";
						String tabval="";
					String from_picklist="";	out.println("<script>loadImplantRows('"+tabval+"','"+checkForNull(rst.getString("OPR_CODE"))+"','"+encode(checkForNull(rst.getString("OPR_DESC")))+"','"+checkForNull(rst.getString("LN_NUM"))+"','"+checkForNull(rst.getString("ACC_CODE"))+"','"+encode(checkForNull(rst.getString("ACC_DESC")))+"','"+checkForNull(rst.getString("TR_NO"))+"','"+checkForNull(rst.getString("MFR"))+"','"+checkForNull(rst.getString("BTCH"))+"','"+encode(checkForNull(rst.getString("REMKS")))+"','"+index+"','L','1','"+bill_str+"','"+panel_str+"','"+key+"','"+key_line+"','"+checkForNull(rst.getString("RESERVED_QTY"))+"','"+checkForNull(rst.getString("REQUESTED_QTY"))+"','"+no_of_units+"','"+checkForNull(rst.getString("SALE_DOCUMENT_NO"))+"','"+checkForNull(rst.getString("SALE_DOCUMENT_TYPE"))+"','"+stock_val+"','"+checkForNull(rst.getString("REQ_STORE_CODE"))+"','"+from_picklist+"'); </script>");	
						}
						count++;
					}
					out.println("<script>assignRecId('"+load_rows_type+"')</script>");
					if(pstmt!=null)			pstmt.close();
					if(rst!=null)           rst.close();
				}
			}
		}
	}catch(Exception e){
		 System.err.println("Err Msg in NursingObjectCollectBLAtApply"+e.getMessage());
		 System.err.println("Err Msg in NursingObjectCollectBLAtApply at trace="+trace);
	}finally{
		try{
			if(rst!=null)rst.close();
			if(pstmt!=null)pstmt.close();
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
  
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(oper_num));
            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
