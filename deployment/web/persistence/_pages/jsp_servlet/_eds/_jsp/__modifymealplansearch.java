package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import eCommon.XSSRequestWrapper;
import webbeans.op.CurrencyFormat;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __modifymealplansearch extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/ModifyMealPlanSearch.jsp", 1724407430000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\'javascript\' src=\'../../eDS/js/ModifyMealPlan.js\'></script>\n</head>\n<body onLoad=\"\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t\t<script language=\"javascript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eBL/js/BLEnterServiceRequest.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<form name=\"ModifyMealPlanSearch_form\" id=\"ModifyMealPlanSearch_form\"  onload=\'FocusFirstElement()\'  action=\"../../servlet/eDL.ModifyMealPlanServlet\" method=\"post\" target=\"messageFrame\">\n\n\t<table id=\"listContentTable\" border=\'1\' cellpadding=0  cellspacing=\'0\' width=\'100%\'>\n\t<tr>\n\t\t\t<th class=\'columnheader\'>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</th>\n\t\t\t<th class=\'columnheader\'>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</th>\n\t\t\t<th class=\'columnheader\' width = \'25%\'>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</th>\n\t</tr>\n<!-- modified by N Munisekhar on 21-May-2013 against [IN39611]-->\n<!-- modified by Subhani on 09-July-2013 against [INC 41451]-->\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</table>\n\t\t<input type=hidden name=\"rowCount\" id=\"rowCount\" value=\"\" />\n\t\t<input type=hidden name=\"flag\" id=\"flag\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" />\n\t\t<input type=hidden name=\"item_slr\" id=\"item_slr\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" />\n\t\t<input type=hidden name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" />\n\t\t<input type=hidden name=\"service_date\" id=\"service_date\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" />\n\t\t<input type=hidden name=\"kitchenCode\" id=\"kitchenCode\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" />\n\t\t<input type=hidden name=\"mealType\" id=\"mealType\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" />\n\t\t<input type=hidden name=\"dietType\" id=\"dietType\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" />\n\t\t<input type=hidden name=\"frequency\" id=\"frequency\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" />\n\t\t<input type=hidden name=\"item_Type\" id=\"item_Type\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" />\n\t\t<input type=hidden name=\"item_Code\" id=\"item_Code\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" />\n\t\t<input type=hidden name=\"short_Desc\" id=\"short_Desc\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" />\n\t\t<input type=hidden name=\"item_Qty\" id=\"item_Qty\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" />\n\t\t<input type=hidden name=\"meal_Category\" id=\"meal_Category\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" />\n\t\t<input type=hidden name=\"patient_Class\" id=\"patient_Class\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" />\n\t\t<input type=hidden name=\"status\" id=\"status\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" />\n\t\t<input type=hidden name=\"spl_Food_Item_Yn\" id=\"spl_Food_Item_Yn\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" />\n\t\t<input type=hidden name=\"serving_Uom_Code\" id=\"serving_Uom_Code\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" />\n\t\t<input type=hidden name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" />\n\t\t<input type=hidden name=\"freq_Yn\" id=\"freq_Yn\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" />\n\t\t<input type=hidden name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" />\n\t\t<input type=hidden name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" />\n\t\t<!-- Added for MMS-KH-CRF-0029.1-US009-->\n\t\t<input type=hidden name=\"onLoadRem\" id=\"onLoadRem\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" />\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection conn	= null;
	Statement stmt	= null;
	ResultSet rs	= null;
	try
	{
		HttpSession httpSession = request.getSession(false);
		Properties p = (Properties)httpSession.getValue("jdbc");
		//Checkstyle Violation commented by Munisekhar
		//String params = request.getQueryString();
		String locale = (String)session.getAttribute("LOCALE");
		String facilityid = (String) session.getValue("facility_id");
		if (facilityid==null) facilityid = "";
		String strloggeduser =  (String) session.getValue("login_user");
		if (strloggeduser==null) strloggeduser = "";
		String strclientip = p.getProperty("client_ip_address");
		if (strclientip==null) strclientip = "";
		String patient_id = request.getParameter("patient_id");
		if(patient_id==null) patient_id="";
		String episode_type = request.getParameter("episode_type");
		if(episode_type==null) episode_type="";
		String episode_id = request.getParameter("episode_id");
		if(episode_id==null) episode_id="";
		String visit_id = request.getParameter("visit_id");
		if(visit_id==null) visit_id="";
		String encounter_id = request.getParameter("encounterId");
		if(encounter_id==null) encounter_id="";
		//String service_date = request.getParameter("servingDate");
		String service_date = com.ehis.util.DateUtils.convertDate(request.getParameter("servingDate"),"DMY",locale,"en");
		if(service_date==null) service_date="";
		String kitchenCode = request.getParameter("kitchenCode");
		if(kitchenCode==null) kitchenCode="";
		String mealType = request.getParameter("mealType");
		if(mealType==null) mealType="";
		String dietType = request.getParameter("dietType");
		if(dietType==null) dietType="";
		String frequency = "";
		String flag ="";
		String mode="";

		String class_val = "";
		int rowCount=0;
		String item_slr   = "";
		String item_Type   = "";
		String item_Code   = "";
		String short_Desc   = "";
		// Added for INC 41451
		String short_Desc1   = "";
		String item_Qty   = "";
		String meal_Category   = "";
		String patient_Class = "";
		String serving_Uom_Code = "";
		String spl_Food_Item_Yn = "";
		String freq_Yn = "";
		String status = "";
		String rowNum = "";
		//Added for MMS-KH-CRF-0029.1 - US009
		String remarks = "";
		String enbDrugYN = "";


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
 if ( (!kitchenCode.equals("")) && (kitchenCode!=null)) {
		conn	=	ConnectionManager.getConnection(request);

		String sql1="";
		sql1 = "select rowNum, plandtl.item_Sl,plandtl.item_Type,plandtl.item_Code,items.short_Desc as itemShortDesc ,itmtype.short_desc as itemTypeShortDesc,plandtl.item_Qty, plandtl.meal_Category,plandtl.patient_Class,planhdr.status,items.serving_Uom_Code,plandtl.spl_Food_Item_Yn,plandtl.freq_Yn,to_char(plandtl.serving_Date,'dd/mm/yyyy') from Ds_Epsd_Meal_Plan_Dtl plandtl ,Ds_Epsd_Meal_Plan_Hdr planhdr,Ds_Items items,ds_Item_Type itmtype where plandtl.operating_Facility_Id = planhdr.operating_facility_Id and plandtl.encounter_Id = planhdr.encounter_Id and   plandtl.serving_Date = planhdr.serving_Date and plandtl.meal_Type = planhdr.meal_Type and plandtl.item_Code = items.food_Item_Code and plandtl.item_type = itmtype.item_type and plandtl.operating_Facility_Id like '"+facilityid+"' and to_char(plandtl.serving_Date,'dd/mm/yyyy') like '"+service_date+"' and plandtl.kitchen_Code like '"+kitchenCode+"' and plandtl.encounter_Id like nvl('"+encounter_id+"',plandtl.encounter_Id) and nvl(planhdr.diet_Type,'##') like nvl('"+dietType+"','##') and nvl(planhdr.meal_Type,'##') like nvl('"+mealType+"','##') and  items.language_Id like '"+locale+"' ORDER BY item_sl ASC ";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		if(rs!=null){
			while(rs.next())
			{
					rowNum = rs.getString(1);
					item_slr=rs.getString(2);
					item_Type=rs.getString(3);
					item_Code=rs.getString(4);
					short_Desc=rs.getString(5);
					short_Desc1=rs.getString(6);
					item_Qty=rs.getString(7);
					meal_Category=rs.getString(8);
					patient_Class=rs.getString(9);
					status=rs.getString(10);
					serving_Uom_Code=rs.getString(11);
					spl_Food_Item_Yn=rs.getString(12);
					freq_Yn=rs.getString(13);
					service_date=rs.getString(14);
					
					if (status==null) status="";

	rowCount++;
	//IN:39963 
	out.println("<script>fetchStatusValue('"+status.toUpperCase()+"');</script>");

	out.println("<tr>");
	out.println("<td id='"+"item_slr"+rowCount+"' class='"+class_val+"'>"+"<a href=\"javascript:getItemDetails('"+item_slr+"','"+item_Type+"','"+item_Code+"','"+short_Desc+"','"+spl_Food_Item_Yn+"','"+freq_Yn+"','"+rowCount+"');\">"+item_slr+"</a></td><input type='hidden' name='"+"hid_item_slr"+rowCount+"' id='"+"hid_item_slr"+rowCount+"' value='"+item_slr+"'/>");

	out.println("<td id='"+"item_Type"+rowCount+"' class='"+class_val+"'>"+short_Desc1+"</td><input type='hidden' name='"+"hid_item_Type"+rowCount+"' id='"+"hid_item_Type"+rowCount+"' value='"+item_Type+"'/>");

	out.println("<td id='"+"item_Code"+rowCount+"' class='"+class_val+"'>"+short_Desc+"</td><input type='hidden' name='"+"hid_item_Code"+rowCount+"' id='"+"hid_item_Code"+rowCount+"' value='"+item_Code+"'/>");

	out.println("<td id='"+"item_Qty"+rowCount+"' class='"+class_val+"'>"+item_Qty+"</td><input type='hidden' name='"+"hid_item_Qty"+rowCount+"' id='"+"hid_item_Qty"+rowCount+"' value='"+item_Qty+"'/>");

	out.println("<td id='"+"spl_Food_Item_Yn"+rowCount+"' class='"+class_val+"'>"+spl_Food_Item_Yn+"</td><input type='hidden' name='"+"hid_spl_Food_Item_Yn"+rowCount+"' id='"+"hid_spl_Food_Item_Yn"+rowCount+"' value='"+spl_Food_Item_Yn+"'/>");

	out.println("<td id='"+"freq_Yn"+rowCount+"' class='"+class_val+"'>"+freq_Yn+"</td><input type='hidden' name='"+"mode"+rowCount+"' id='"+"mode"+rowCount+"' value='update'/><input type='hidden' name='"+"hid_freq_Yn"+rowCount+"' id='"+"hid_freq_Yn"+rowCount+"' value='"+freq_Yn+"'/>");

	out.println("</tr>");
	}
	}
	//Added for MMS-KH-CRF-0029.1 - US009 Start
	enbDrugYN = request.getParameter("enbDrugYN");
	if(enbDrugYN.equals("Y")){
		sql1 = "SELECT b.override_reason FROM ds_epsd_diet_profile_hdr a, or_order_drug_interaction b WHERE a.order_id = b.order_id AND a.encounter_id = "+encounter_id+" AND TO_DATE ('"+service_date+"', 'dd/mm/yyyy') BETWEEN period_from AND period_to and ROWNUM = 1";			
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql1);
		if(rs!=null && rs.next()){
			remarks = rs.getString(1);
		}
	}
	//Added for MMS-KH-CRF-0029.1 - US009 End
	// added by N Munisekhar on 21-May-2013 against [IN39611]
	 if(rowCount==0)
	 {
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); //history.go(-1);</script>");
	}
				rs.close();
				stmt.close();
				}
	
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(item_slr));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(service_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(mealType));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dietType));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(frequency));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(item_Type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(item_Code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(short_Desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(item_Qty));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(meal_Category));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_Class));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(status));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(spl_Food_Item_Yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(serving_Uom_Code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(freq_Yn));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block34Bytes, _wl_block34);

}catch(Exception ee)
	{
		out.println("from main :"+ee);
	}
	finally
	{
		if(conn!=null){
						ConnectionManager.returnConnection(conn, request);
					  }
	}

            _bw.write(_wl_block35Bytes, _wl_block35);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SrlNo.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Itemtype.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.item.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ServingQty.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SpclFoodItems.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Freq.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
