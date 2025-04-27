package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eDS.Common.DlQuery;
import java.util.Date;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import eOT.Common.*;
import eCommon.XSSRequestWrapper;
import eOT.Common.OTRepository;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __dlcommonvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DLCommonValidation.jsp", 1724242376000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	//Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
    //Added Against MMS Vulnerability Issue - Ends
	String locale = (String)session.getAttribute("LOCALE");
	String func_mode = request.getParameter("func_mode")== null?"":request.getParameter("func_mode");
	Connection con = null;
	ResultSet rst = null;
	PreparedStatement pstmt = null;
	java.util.Properties prop;
	prop = (java.util.Properties) session.getValue("jdbc");
	String login_user = prop.getProperty( "login_user" ) ;
	String str_client_ip_address = prop.getProperty("client_ip_address"); //Added Against for 832-CRF
	Connection conForMenuList = null;
	ResultSet rstForMenuList = null;
	PreparedStatement pstmtForMenuList = null;
	try{
		if(func_mode.equals("getKitchenAreas")){
			String kitchenCode = checkForNull(request.getParameter("kitchen_code"));
			String kitchenArea = "";
			StringBuffer strKitchen= new StringBuffer();
			String sql="select kitchen_area_code,long_desc,short_desc,eff_status from ds_kitchen_area where kitchen_code = '"+kitchenCode+"'";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strKitchen.append("???");
				}
				strKitchen.append(rst.getString("kitchen_area_code")+":::"+rst.getString("long_desc")+":::"+rst.getString("short_desc")+":::"+rst.getString("eff_status"));
				i++;
			}
			kitchenArea = strKitchen.toString();
			out.println(kitchenArea);
		}
		//Added against CRF-0678 starts Here
		else if(func_mode.equals("getPractitionerName")){
			String orderfromdate=request.getParameter("orderfromdate");
			String ordertodate=request.getParameter("ordertodate");
			//Added Against ML-MMOH-SCF-1796 Starts
			String current_date=request.getParameter("current_date");
			if(orderfromdate.equals("") || orderfromdate.equals(null)) orderfromdate=current_date;	
			if(ordertodate.equals("") || ordertodate.equals(null)) ordertodate=current_date;	
			//Added Against ML-MMOH-SCF-1796 Ends
			String PractName = "";
			StringBuffer strPractName= new StringBuffer();
			/*String sql="SELECT distinct practitioner_id, am_get_desc.am_practitioner(practitioner_id,'en',1)  FROM ds_staff_orders_hdr WHERE meal_category = 'DOC' AND practitioner_id IS NOT NULL  AND order_from_date BETWEEN TO_DATE('"+orderfromdate+"','DD/MM/YYYY') AND TO_DATE('"+ordertodate+"','DD/MM/YYYY') AND order_to_date BETWEEN TO_DATE('"+orderfromdate+"','DD/MM/YYYY') AND TO_DATE('"+ordertodate+"','DD/MM/YYYY')";*/
			
			String sql="SELECT DISTINCT practitioner_id,am_get_desc.am_practitioner (practitioner_id, 'en', 1) FROM ds_staff_orders_hdr WHERE meal_category = 'DOC' AND practitioner_id IS NOT NULL AND ((order_from_date BETWEEN TO_DATE ('"+orderfromdate+"','DD/MM/YYYY') AND TO_DATE ('"+ordertodate+"', 'DD/MM/YYYY') OR order_to_date BETWEEN TO_DATE ('"+orderfromdate+"','DD/MM/YYYY') AND TO_DATE ('"+ordertodate+"','DD/MM/YYYY')) OR (   TO_DATE ('"+orderfromdate+"', 'DD/MM/YYYY')BETWEEN order_from_date AND order_to_date OR TO_DATE ('"+ordertodate+"', 'DD/MM/YYYY')BETWEEN order_from_date AND order_to_date)) and NVL(eff_status,'A')!= 'D'"; //Added Eff Status Against ML-MMOH-SCF-1796
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			
			while(rst!= null && rst.next()){				
				strPractName.append(checkForNull(rst.getString(1)));
		   		strPractName.append("##");
	   			strPractName.append(checkForNull(rst.getString(2)));
	   			strPractName.append(",");			
			}
			PractName = strPractName.toString();
			out.println(PractName);            
		}
		//Added against CRF-0678 Ends Here
		//Added Against MMS-JU-SCF-0174 Starts
		else if(func_mode.equals("DietOrderSheet")){
			
		String p_facility_id=checkForNull(request.getParameter("p_facility_id"));
		String p_kitchen_code=checkForNull(request.getParameter("p_kitchen_code"));
		String nd_serv_date=checkForNull(request.getParameter("nd_serv_date"));
		String nd_patient_id=checkForNull(request.getParameter("nd_patient_id"));
		String nd_ward_code=checkForNull(request.getParameter("nd_ward_code"));
		String nd_dt_category=checkForNull(request.getParameter("nd_dt_category"));
		String nd_diet_type=checkForNull(request.getParameter("nd_diet_type"));
		String nd_meal_class=checkForNull(request.getParameter("nd_meal_class"));
		String nd_meal_type=checkForNull(request.getParameter("nd_meal_type"));
		String nd_flag=checkForNull(request.getParameter("nd_flag"));
		String p_language_id=checkForNull(request.getParameter("p_language_id"));
		
		con = ConnectionManager.getConnection(request);
		CallableStatement cstmt = null ;
		cstmt=con.prepareCall("{call DS_DIET_ORDER_REPORT(?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString( 1, p_facility_id);
			cstmt.setString( 2, p_kitchen_code);
			cstmt.setString( 3, nd_serv_date);
			cstmt.setString( 4, nd_patient_id);
			cstmt.setString( 5, nd_ward_code);
			cstmt.setString( 6, nd_dt_category);
			cstmt.setString( 7, nd_diet_type);
			cstmt.setString( 8, nd_meal_class);
			cstmt.setString( 9, nd_meal_type);
			cstmt.setString( 10, nd_flag);
			cstmt.setString( 11, p_language_id);

			cstmt.registerOutParameter( 12, java.sql.Types.VARCHAR );	
			cstmt.execute() ;
			out.println(cstmt.getString(12));
		}
		//Added Against MMS-JU-SCF-0174 Ends
		else if(func_mode.equals("getNutrientsList")){
			String nutrientsCode = checkForNull(request.getParameter("nutrients_code"));
			String kitchenArea = "";
			StringBuffer strKitchen= new StringBuffer();
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_DS_GET_NUTRIENTS_FOOD);
			pstmt.setString(1, nutrientsCode);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strKitchen.append("???");
				}
				strKitchen.append(rst.getString("long_desc")+":::"+rst.getString("content_value")+":::"+rst.getString("nutrient_code"));
				i++;
			}
			kitchenArea = strKitchen.toString();
			out.println(kitchenArea);
		}
		else if(func_mode.equals("getUom")){
			String nutrientsCode = checkForNull(request.getParameter("nutrients_code"));
			String uomCode = "";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_DS_COM_NUTRIENTS_UOM);
			pstmt.setString(1, locale);
			pstmt.setString(2, nutrientsCode);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				uomCode = rst.getString("uom_code");
			}
			out.println(uomCode);
		}
		else if(func_mode.equals("comNutList")){
			String nutrientsCode = checkForNull(request.getParameter("nutrients_code"));
			String kitchenArea = "";
			StringBuffer strKitchen= new StringBuffer();
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_COM_NUT_LIST);
			pstmt.setString(1, nutrientsCode);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strKitchen.append("???");
				}
				strKitchen.append(rst.getString("short_desc")+":::"+rst.getString("content_value")+":::"+rst.getString("uom_code")+":::"+rst.getString("nutrient_code"));
				i++;
			}
			kitchenArea = strKitchen.toString();
			out.println(kitchenArea);
		}
		else if(func_mode.equals("loadDayNo")){
		
			//IN::39898- Getting MenuList:: start
			//Loading Menu list for the given diettype, mealclass and mealtype on change of the same ::
			String dietType = checkForNull(request.getParameter("dietType"));
			String mealClass = checkForNull(request.getParameter("mealClass")); 
			String mealType = checkForNull(request.getParameter("mealType"));
			String sql_MenuList = "select menu_code,short_desc from ds_menu_lang_vw where language_id = ? and eff_status = 'E' and diet_type = ? and meal_class = ? and meal_type = ? ";
			StringBuffer strMenu= new StringBuffer();			
			conForMenuList = ConnectionManager.getConnection(request);
			pstmtForMenuList = conForMenuList.prepareStatement(sql_MenuList);
			pstmtForMenuList.setString(1, locale);
			pstmtForMenuList.setString(2, dietType);
			pstmtForMenuList.setString(3, mealClass);
			pstmtForMenuList.setString(4, mealType);
			rstForMenuList = pstmtForMenuList.executeQuery();
			int startPos = 0;
			while(rstForMenuList!= null && rstForMenuList.next()){
					if(!(startPos==0)){
						strMenu.append("???");
					}
					strMenu.append(rstForMenuList.getString("menu_code")+":::"+rstForMenuList.getString("short_desc"));;
					startPos++;
				}
			
			String strMenuKey = checkForNull(request.getParameter("strMenuKey"));
			if("menulist".equals(strMenuKey)) //To avoid load of DayNo list on change of DietType.
			{
				strMenu = strMenu.append("%%%" + strMenu);
				out.println(strMenu.toString());
			}else //Getting MenuList:: End
			{
				String dayNo = "";
				StringBuffer day= new StringBuffer();
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(DlQuery.DL_GET_DAY_NO);
				pstmt.setString(1, dietType);
				pstmt.setString(2, mealClass);
				rst = pstmt.executeQuery();
				int i = 0;
				while(rst!= null && rst.next()){
					if(!(i==0)){
						day.append("???");
					}
					day.append(rst.getString("menu_sched_cycle_days")+":::"+rst.getString("meal_plan_ref_day_no"));
					i++;
				}
				
				day = day.append("%%%" + strMenu);
				dayNo = day.toString();
				out.println(dayNo);
			}
		}
		else if(func_mode.equals("recNutList")){
			String foodItem = checkForNull(request.getParameter("fooditem_code"));
			String ing = "";
			StringBuffer ingr= new StringBuffer();
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_FOOD_ITEM_INGREDIENT);
			pstmt.setString(1, foodItem);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					ingr.append("???");
				}
				ingr.append(rst.getString("ingredient_code")+":::"+rst.getString("ingredient_qty")+":::"+rst.getString("ingredient_uom")+":::"+rst.getString("eff_status"));
				i++;
			}
			ing = ingr.toString();
			out.println(ing);
		}
		else if(func_mode.equals("recUomQty")){
			String foodItem = checkForNull(request.getParameter("fooditem_code"));
			String ing = "";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_FOOD_UOM_QTY);
			pstmt.setString(1, locale);
			pstmt.setString(2, foodItem);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				ing = rst.getString("prep_uom")+"::"+rst.getString("prep_base_qty");
			}
			out.println(ing);
		}
		else if(func_mode.equals("getUomCode")){
			String itemType = checkForNull(request.getParameter("item_type"));
			String itemCode = checkForNull(request.getParameter("item_code"));
			String uom = "";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_GET_UOM_CODE);
			pstmt.setString(1, locale);
			pstmt.setString(2, itemType);
			pstmt.setString(3, itemCode);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				uom = rst.getString("serving_uom_code");
			}
			out.println(uom);
		}
		//Added Against PMG2017-COMN-CRF-0012.1-US003 Starts Here
		else if(func_mode.equals("getItemTypeDesc")){
			String itemTypeCode = checkForNull(request.getParameter("item_type"));
			String itemTypeDesc = "";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_ITEM_TYPE_DESC);
			pstmt.setString(1, itemTypeCode);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				itemTypeDesc = rst.getString("item_Type_Desc");
			}
			out.println(itemTypeDesc);
		}
		//Added Against PMG2017-COMN-CRF-0012.1-US003 Ends Here
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
		else if(func_mode.equals("getIngDesc")){
			String ingredientCode = checkForNull(request.getParameter("ingredient_code"));
			String ingredientDesc = "";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DlQuery.DL_INGREDIENT_DESC);
			pstmt.setString(1, ingredientCode);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				ingredientDesc = rst.getString("ingredient_Desc");
			}
			out.println(ingredientDesc);
		}
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Starts Here
		else if(func_mode.equals("getUomDesc")){
			String uomCode = checkForNull(request.getParameter("uom_code"));
			String uomDesc = "";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select short_desc uom_Desc from am_uom where uom_code=?");
			pstmt.setString(1, uomCode);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				uomDesc = rst.getString("uom_Desc");
			}
			out.println(uomDesc);
		}
		//Added Against PMG2017-COMN-CRF-0012.1-US004 Ends Here
		else if(func_mode.equals("chkOrderEntry")){
			int order = Integer.parseInt(request.getParameter("order"));
			String uom = "";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement("select count(meal_order) orderCnt from ds_meal_type where meal_order = ?");
			pstmt.setInt(1, order);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				uom = rst.getString("orderCnt");
			}
			out.println(uom);
		}

		else if(func_mode.equals("getStatusCheck")){
		con = ConnectionManager.getConnection(request);
		String facility_id = checkForNull(request.getParameter("facility_id"));
		String meal_Category = checkForNull(request.getParameter("meal_Category"));
		String from_Date = checkForNull(request.getParameter("from_Date"));
		StringBuffer strRemarks = new StringBuffer();
		String temp  = "";
		String sql="select STAFF_ORDER_ID from DS_STAFF_ORDERS_HDR where FACILITY_ID='"+facility_id+"' and MEAL_CATEGORY='"+meal_Category+"' and (nvl('"+from_Date+"', '31/12/3000') between to_char(ORDER_FROM_DATE , 'dd/mm/yyyy') and nvl(to_char(ORDER_TO_DATE , 'dd/mm/yyyy'), '31/12/3000')) and (nvl(STATUS , 'OS')!='CM' ) order by 1"; // issue corrected
		pstmt = con.prepareStatement(sql);
		rst = pstmt.executeQuery();
		while(rst!= null && rst.next()){
	   	 	temp= checkForNull(rst.getString(1));
	   	 	strRemarks.append(temp);
	   		strRemarks.append("~");
			}
			out.println(strRemarks);
		}
		
		/* Added Against Start 832-crf */
		else if(func_mode.equals("deleteStatus")){
				con = ConnectionManager.getConnection(request);
				String facility_id = checkForNull(request.getParameter("facility_id"));	
				String staff_order_id_value = checkForNull(request.getParameter("staff_order_id"));	
				String sql_update= "UPDATE DS_STAFF_ORDERS_HDR SET EFF_STATUS = ?, MODIFIED_BY_ID = ?, MODIFIED_DATE = SYSDATE, MODIFIED_FACILITY_ID = ?, MODIFIED_AT_WS_NO = ? WHERE FACILITY_ID = ? AND STAFF_ORDER_ID = ? ";
					if(rst!=null) rst.close();
				    if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement(sql_update);
					pstmt.setString(1,"D");
					pstmt.setString(2,login_user);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,str_client_ip_address);
					pstmt.setString(5,facility_id);
					pstmt.setString(6,staff_order_id_value);
				    int  flag=pstmt.executeUpdate();
					if(flag>0) 
			       		 {
						con.commit();
					}else{
						con.rollback();
					}
					out.println(flag);
			}	
		/* Added Against End 832-crf */

		else if(func_mode.equals("get_DietType_MealStatus")){
		con = ConnectionManager.getConnection(request);
		String meal_Category = checkForNull(request.getParameter("meal_Category"));
		StringBuffer strRemarks = new StringBuffer();
		String temp  = "";
		String sql="select default_Diet_Type,default_Meal_Class from Ds_Meal_Category where meal_Category_Code = '"+meal_Category+"'";
		pstmt = con.prepareStatement(sql);
		rst = pstmt.executeQuery();
		while(rst!= null && rst.next()){
	   	 	temp= checkForNull(rst.getString(1));
	   	 	strRemarks.append(checkForNull(rst.getString(1)));
	   		strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(2)));
			}
			out.println(strRemarks);
		}

		else if(func_mode.equals("update_MealServed_Details")){
		con = ConnectionManager.getConnection(request);
		String facilityId = checkForNull(request.getParameter("facilityId"));
		String fromDate = checkForNull(request.getParameter("fromDate"));
		String toDate = checkForNull(request.getParameter("toDate"));
		String mealType = checkForNull(request.getParameter("mealType"));
		String mealCategory = checkForNull(request.getParameter("mealCategory"));
		String dietType = checkForNull(request.getParameter("dietType"));
		String dietLocation= "";
		/*CRF-0684*/
		String menuType= "";
		menuType = checkForNull(request.getParameter("menuType"));		
		String chkYN= "";
		chkYN = checkForNull(request.getParameter("chkYN")); 
		String isMealComplaints= "";
		isMealComplaints = checkForNull(request.getParameter("chkMealComp")); //Added Against CRF-1125
		//CRF-0684
		String sql="";
		dietLocation= checkForNull(request.getParameter("dietLocation"));//Added against cRf-0419 Ends Here
		//Added against CRF-0678 Starts Here
		String practName="";
		practName=checkForNull(request.getParameter("practName"));
		//Added against CRF-0678 Ends Here
		StringBuffer strRemarks = new StringBuffer();
		String temp,temp1 = "";//ML-MMOH-CRF-0730
		//Added against CRF-0419 Starts Here
		//CRF-0684
		sql=" SELECT HDR.STAFF_ORDER_ID, DTL.STAFF_ORDER_LINE_NUM, DTL.NO_OF_MEALS_ORDERS, DTL.NO_OF_MEALS_SERVED,DTL.NO_OF_MEALS_RECEIVED,DTL.NO_OF_MEALS_REJECTED ";		
		//Added Against Start CRF-1125
		if(isMealComplaints.equalsIgnoreCase("Y")){			
			sql +=" , DTL.OTH_COMPLAINT_DESC AS OTH_COMPLAINT_DESC";			
		}
		//Added Against End CRF-1125
		sql +=" , DTL.COMPLAINT_CODE";			
		
		if(chkYN.equals("Y")){			
			if(!menuType.equals("")){
			sql +=" , HDR.MENU_TYPE ";
			}
		}
				
		//CRF-0684 & CRF-832-US4
		sql += " FROM DS_STAFF_ORDERS_DTL DTL, DS_STAFF_ORDERS_HDR HDR WHERE (DTL.FACILITY_ID='"+facilityId+"' ) AND HDR.EFF_STATUS IS NULL AND('"+fromDate+"' BETWEEN TO_CHAR(HDR.ORDER_FROM_DATE , 'DD/MM/YYYY') AND NVL(TO_CHAR(HDR.ORDER_TO_DATE , 'DD/MM/YYYY'), '31/12/3000') AND DTL.FACILITY_ID=HDR.FACILITY_ID AND DTL.STAFF_ORDER_ID=HDR.STAFF_ORDER_ID AND DTL.FACILITY_ID=HDR.FACILITY_ID AND DTL.STAFF_ORDER_ID=HDR.STAFF_ORDER_ID) AND(NVL('"+toDate+"' , '"+fromDate+"')BETWEEN TO_CHAR(HDR.ORDER_FROM_DATE , 'DD/MM/YYYY') AND NVL(TO_CHAR(HDR.ORDER_TO_DATE , 'DD/MM/YYYY'), '31/12/3000') AND DTL.FACILITY_ID=HDR.FACILITY_ID AND DTL.STAFF_ORDER_ID=HDR.STAFF_ORDER_ID AND DTL.FACILITY_ID=HDR.FACILITY_ID AND DTL.STAFF_ORDER_ID=HDR.STAFF_ORDER_ID)AND(DTL.MEAL_TYPE='"+mealType+"' ) AND(HDR.MEAL_CATEGORY='"+mealCategory+"'  AND DTL.FACILITY_ID=HDR.FACILITY_ID AND DTL.STAFF_ORDER_ID=HDR.STAFF_ORDER_ID) AND(DTL.DIET_TYPE='"+dietType+"' ) AND(NVL(HDR.STATUS , 'OS')='OS'  AND DTL.FACILITY_ID=HDR.FACILITY_ID AND DTL.STAFF_ORDER_ID=HDR.STAFF_ORDER_ID)"; 
		// Modified above query for ML-MMOH-CRF-0730

		//CRF-0684
		if(chkYN.equals("Y")){			
	        	if(!menuType.equals("")){
				sql +=" AND HDR.MENU_TYPE='"+menuType+"'";			
			}
			}
		//CRF-0684

            if(!dietLocation.equalsIgnoreCase(""))
			sql +=" AND HDR.LOCATION_CODE='"+dietLocation+"'";	
			if(!practName.equalsIgnoreCase(""))
			sql +=" AND HDR.PRACTITIONER_ID='"+practName+"'";//Added against CRF-0678	
			sql +=" ORDER BY  2 , 1";//Modified against CRF-0419		
		
		//Added against CRF-0419 Ends Here	
		pstmt = con.prepareStatement(sql);
		rst = pstmt.executeQuery();
		while(rst!= null && rst.next()){
	   	 	temp= checkForNull(rst.getString(1));
	   	 	strRemarks.append(checkForNull(rst.getString(1)));
	   		strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(2)));
	   		strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(3)));
	   		strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(4)));
			/* Added Start for ML-MMOH-CRF-0730 */
			strRemarks.append("##");
			strRemarks.append(checkForNull(rst.getString(5)));
			strRemarks.append("##");
			strRemarks.append(checkForNull(rst.getString(6)));
			//Added Against Start CRF-1125
			if(isMealComplaints.equalsIgnoreCase("Y")){			
			strRemarks.append("##");
			strRemarks.append(checkForNull(rst.getString(7)));	//other compliants
			strRemarks.append("##");
			strRemarks.append(checkForNull(rst.getString(8))); // compliantsCode 
			temp1 = checkForNull(rst.getString(8));	
			if(chkYN.equals("Y")){			
				if(!menuType.equals("")){
				strRemarks.append("##");
				strRemarks.append(checkForNull(rst.getString(9))); //MenuType 
				}
			}			
			} //Added Against End CRF-1125
			else{	
			strRemarks.append("##");
			strRemarks.append(checkForNull(rst.getString(7))); //complainstCode 
			temp1 = checkForNull(rst.getString(7));			
			if(chkYN.equals("Y")){			
				if(!menuType.equals("")){
				strRemarks.append("##");
				strRemarks.append(checkForNull(rst.getString(8))); //MenuType 
				}
			}
			}
			} //end of while 
			//CRF-0684
			if(temp1.equals(""))
			strRemarks.append(",");
		 	if(!(temp1.equals(""))){
			pstmt = con.prepareStatement("select long_desc from ds_complaints_lang_vw where COMPLAINT_CODE = '"+temp1+"' and language_id = '"+locale+"' " );
			rst= pstmt.executeQuery();
		while(rst!=null && rst.next()){
			strRemarks.append("##");
			strRemarks.append(checkForNull(rst.getString(1)));
			strRemarks.append(",");
		}  }
		
		/* Added End for ML-MMOH-CRF-0730 */
			out.println(strRemarks);
		}
		else if(func_mode.equals("getKaloriForItem")){
			con = ConnectionManager.getConnection(request);
// 		String locale = checkForNull(request.getParameter("locale"));
		String foodItemCode = checkForNull(request.getParameter("foodItemCode"));

		StringBuffer strRemarks = new StringBuffer();
		//Checkstyle Violation commented by Munisekhar
		//String temp  = "";
		//Modified Against ICN-#65555 0352
		String sql="SELECT items.food_item_code,TO_CHAR (items.calorific_cont_per_uom, '999999.99'),LOWER (param.energy_uom),items.ITEM_TYPE ,items.serving_uom_code,am_get_desc.am_uom (items.serving_uom_code,'"+locale+"', '2') serving_uom_desc,am_get_desc.am_uom (param.energy_uom, '"+locale+"', '2') energy_uom_desc FROM ds_items items, ds_param param WHERE items.food_item_code = '"+foodItemCode+"' and language_id='"+locale+"'"; // AAKH-CRF-0065
		pstmt = con.prepareStatement(sql);
		rst = pstmt.executeQuery();
		while(rst!= null && rst.next()){
	   	 	strRemarks.append(checkForNull(rst.getString(1)));
	   		strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(2)));
	   		strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(3)));
			strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(4)));
			strRemarks.append("##"); // AAKH-CRF-0065
	   		strRemarks.append(checkForNull(rst.getString(5))); // AAKH-CRF-0065
			//Added Against ICN-#65555 0352 starts Here
			strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(6)));
			strRemarks.append("##");
	   		strRemarks.append(checkForNull(rst.getString(7)));
			//Added Against ICN-#65555 0352 Ends Here
			}
			out.println(strRemarks);
		}
		else if(func_mode.equals("checkPatId")){
			String sql = "select count(patient_id) from mp_patient where patient_id = ?";
			String fromPatient = checkForNull(request.getParameter("fromPatient"));
			String toPatient = checkForNull(request.getParameter("toPatient"));			
			StringBuffer retResult =new StringBuffer();
			int count = 0;
			if(!("".equals(fromPatient))){
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,fromPatient);
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					count = rst.getInt(1);
					if(count>0)	retResult.append("Valid");
					else retResult.append("Invalid");
				}
			}
			else{
			  retResult.append("NA");
				
			}
			pstmt = null;
			rst = null;
			con = null;
			if(!("".equals(toPatient))){
				con = ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,toPatient);
				rst = pstmt.executeQuery();
				if(rst != null && rst.next()){
					count = rst.getInt(1);
					if(count>0)	retResult.append(":Valid");
					else retResult.append(":Invalid");
				}
			}
			else{
			   retResult.append(":NA");
				
			}
			out.println(retResult);
		}
		else if(func_mode.equals("getCommFormList")){
			String kitchenCode = checkForNull(request.getParameter("commFormulakitchenValue"));			
			String facility = checkForNull(request.getParameter("facility_id"));			
			StringBuffer strKitchenArea= new StringBuffer();
			String kitchenArea = "";
			String sql = "SELECT AREA.SHORT_DESC,AREA.KITCHEN_AREA_CODE FROM DS_KITCHEN_AREA_LANG_VW AREA	WHERE AREA.OPERATING_FACILITY_ID LIKE '"+facility+"' AND AREA.KITCHEN_CODE LIKE '"+kitchenCode+"' AND AREA.LANGUAGE_ID LIKE '"+locale+"' AND AREA.EFF_STATUS = 'E'";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strKitchenArea.append("???");
				}
				strKitchenArea.append(rst.getString("SHORT_DESC")+":::"+rst.getString("KITCHEN_AREA_CODE"));
				i++;
			}
			kitchenArea = strKitchenArea.toString();
			out.println(kitchenArea);
		}
		else if(func_mode.equals("foodItemForKitchenArea")){
			String KitchenValue = checkForNull(request.getParameter("KitchenValue"));			
			String facility = checkForNull(request.getParameter("facilityId"));
			StringBuffer strKitchenArea= new StringBuffer();
			String kitchenArea = "";			
			String sql = "select area.short_Desc,area.kitchen_Area_Code from Ds_Kitchen_Area_Lang_Vw area where area.operating_Facility_Id like '"+facility+"' and area.kitchen_Code like '"+KitchenValue+"' and area.language_Id like '"+locale+"' and area.eff_Status = 'E'";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strKitchenArea.append("???");
				}
				strKitchenArea.append(rst.getString("SHORT_DESC")+":::"+rst.getString("KITCHEN_AREA_CODE"));
				i++;
			}
			kitchenArea = strKitchenArea.toString();
			out.println(kitchenArea);

		}   else if(func_mode.equals("getMasterCodeList")){
			String query = checkForNull(request.getParameter("query"));			
			StringBuffer str= new StringBuffer();
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query);
			rst = pstmt.executeQuery();
			String result="";
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					str.append("##");
				}
				str.append(rst.getString(1));
				str.append("::");
				str.append(rst.getString(2));
				i++;
			}
			result = str.toString();			
			out.println(result);
		} else if(func_mode.equals("foodItemForKitchenAreaItem")){
			String kitchenAreaCode = checkForNull(request.getParameter("kitchenAreaCode"));
			String kitchenCode = checkForNull(request.getParameter("kitchenCode"));
			String facilityId = checkForNull(request.getParameter("facilityId"));
			StringBuffer strKitchenAreaItem = new StringBuffer();
			String kitchenAreaItem = "";
			String sql = "select dsk.FOOD_ITEM_CODE , dsi.SHORT_DESC from DS_KITCHEN_AREA_ITEMS dsk, DS_ITEMS dsi where (dsk.FOOD_ITEM_CODE=dsi.FOOD_ITEM_CODE )and(dsk.OPERATING_FACILITY_ID like '"+facilityId+"')and(dsk.KITCHEN_CODE like '"+kitchenCode+"')and(dsk.KITCHEN_AREA_CODE like '"+kitchenAreaCode+"')and(dsi.LANGUAGE_ID like 'en')";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strKitchenAreaItem.append("???");
				}
				strKitchenAreaItem.append(rst.getString("FOOD_ITEM_CODE")+":::"+rst.getString("SHORT_DESC"));
				i++;
			}			
			kitchenAreaItem = strKitchenAreaItem.toString();			
			out.println(kitchenAreaItem);
		} else if(func_mode.equals("getmealPlanSeqNo")){
			String servingDate = checkForNull(request.getParameter("servingDate"));
			String facility = checkForNull(request.getParameter("facility"));
			StringBuffer strmealPlanSeqNo = new StringBuffer();
			String mealPlanSeqNo = "";
			//String sql = "select distinct planHdr.meal_Plan_Seq_No,planHdr.meal_Plan_Seq_No from Ds_Epsd_Meal_Plan_Hdr planHdr where planHdr.OPERATING_FACILITY_ID ='"+facility+"' and to_char(planHdr.serving_Date,'dd/mm/yyyy') ='"+servingDate+"'";
			String sql = "select distinct nvl(planHdr.meal_Plan_Seq_No,'') meal_Plan_Seq_No,nvl(planHdr.meal_Plan_Seq_No,'') meal_Plan_Seq_No from Ds_Epsd_Meal_Plan_Hdr planHdr where planHdr.OPERATING_FACILITY_ID ='"+facility+"' and to_char(planHdr.serving_Date,'dd/mm/yyyy') ='"+servingDate+"' AND meal_plan_seq_no is not null";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strmealPlanSeqNo.append("???");
				}
				strmealPlanSeqNo.append(rst.getString("MEAL_PLAN_SEQ_NO")+":::"+rst.getString("MEAL_PLAN_SEQ_NO"));
				i++;
			}
			mealPlanSeqNo = strmealPlanSeqNo.toString();
			out.println(mealPlanSeqNo);
		}
		else if(func_mode.equals("orderTypeDuplicate")){
			StringBuffer orderTypeCodeStr = new StringBuffer();
			String orderTypeCode = "";
			String sql = "select dietCategory.diet_Category_Code,dietCategory.order_Type_Code from Ds_Diet_Category dietCategory";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					orderTypeCodeStr.append("???");
				}
				orderTypeCodeStr.append(rst.getString("diet_Category_Code")+":::"+rst.getString("order_Type_Code"));
				i++;
			}
			orderTypeCode = orderTypeCodeStr.toString();
			out.println(orderTypeCode);
		}else if(func_mode.equals("getWards")){
			StringBuffer wardCodeStr = new StringBuffer();
			String wards = "";
			String facility = checkForNull(request.getParameter("facility"));
			String wardCode = checkForNull(request.getParameter("wardCode"));
			String ward_sql = "select nursing_Unit_Code,short_Desc from Ds_Wards_Kitchen_Vw where operating_Facility_Id = '"+facility+"' and  nvl(kitchen_Code,'!!') in('"+wardCode+"','!!') and linked_Yn = 'Y' order by short_Desc ASC";			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(ward_sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					wardCodeStr.append("???");
				}
				wardCodeStr.append(rst.getString("nursing_Unit_Code")+":::"+rst.getString("short_Desc"));
				i++;
			}
			wards = wardCodeStr.toString();
			out.println(wards);
		}else if(func_mode.equals("getBedNumbers")){
			StringBuffer wardCodeStr = new StringBuffer();
			String wards = "";
			String facility = checkForNull(request.getParameter("facility"));
			String wardCodeFrom = checkForNull(request.getParameter("wardCodeFrom"));
			String wardCodeTo = checkForNull(request.getParameter("wardCodeTo"));			
			String ward_sql = "SELECT BED_NO FROM IP_NURSING_UNIT_BED where NURSING_UNIT_CODE between NVL ('"+wardCodeFrom+"', '!')  AND NVL ('"+wardCodeTo+"', '~') AND FACILITY_ID='"+facility+"' AND EFF_STATUS='E' ORDER BY 1";			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(ward_sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					wardCodeStr.append("???");
				}
				wardCodeStr.append(rst.getString("BED_NO"));
				i++;
			}
			wards = wardCodeStr.toString();
			out.println(wards);
		}else if(func_mode.equals("getMealDesc")){
			String fecthedMealTypes = checkForNull(request.getParameter("fecthedMealTypes"));
			fecthedMealTypes = "'" + fecthedMealTypes.replaceAll("::", "','") +"'";
			StringBuffer strMealDesc = new StringBuffer();
			//String sQueryForMealDesc = "SELECT DISTINCT meal_type, ds_get_desc.ds_meal_type (meal_type, '"+locale+"', '2') short_desc FROM ds_meal_type WHERE meal_type in("+fecthedMealTypes+") and eff_status = 'E' ORDER BY meal_order ASC ";//Commented against ML-MMOH-SCF- 0556
			
			String sQueryForMealDesc = "SELECT meal_type, ds_get_desc.ds_meal_type (meal_type, '"+locale+"', '2') short_desc FROM ds_meal_type WHERE meal_type in("+fecthedMealTypes+") and eff_status = 'E' ORDER BY meal_order ASC ";//Added against ML-MMOH-SCF- 0556			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(sQueryForMealDesc);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					strMealDesc.append("???");
				}
				strMealDesc.append(rst.getString("meal_type")+":::"+rst.getString("short_desc"));
				i++;
			}
			String sMealDesc = strMealDesc.toString().trim(); 
			out.println(sMealDesc);
		}
		else if(func_mode.equals("getSpeciality")){
			StringBuffer spcltyCodeStr = new StringBuffer();
			String specialities = "";
			String facility = checkForNull(request.getParameter("facility"));
			String kitchenCode = checkForNull(request.getParameter("kitchenCode"));
			String mealOrderFor = checkForNull(request.getParameter("mealOrderFor"));
			StringBuffer speciality_sql =new  StringBuffer();
			speciality_sql.append("select distinct a.speciality_code,a.speciality_desc from ds_speciality_kitchen_vw a, op_clinic b where a.operating_Facility_Id = '"+facility+"' and  a.kitchen_code='"+kitchenCode+"' and a.linked_Yn = 'Y' and b.eff_status = 'E' and a.SPECIALITY_CODE=b.SPECIALITY_CODE and   a.operating_Facility_Id =b.FACILITY_ID and b.FACILITY_ID='"+facility+"' ");
			if(mealOrderFor.equals("ALL"))
				{
				speciality_sql.append(" and b.clinic_type IN ('C','E') and b.LEVEL_OF_CARE_IND in('A','E') ");
				}
			if(mealOrderFor.equals("OP"))
				{
				speciality_sql.append(" and b.clinic_type IN ('C','E') and b.LEVEL_OF_CARE_IND = 'A' ");
				}
			if(mealOrderFor.equals("EM"))
				{
				speciality_sql.append(" and b.clinic_type IN ('C') and b.LEVEL_OF_CARE_IND = 'E' ");
				}
			speciality_sql.append(" order by a.speciality_desc ");			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(speciality_sql.toString());
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					spcltyCodeStr.append("???");
				}
				spcltyCodeStr.append(rst.getString("speciality_code")+":::"+rst.getString("speciality_desc"));
				i++;
			}
			specialities = spcltyCodeStr.toString();
			out.println(specialities);
		}
		else if(func_mode.equals("getLocation")){
			StringBuffer locCodeStr = new StringBuffer();
			String locations = "";			
			String facilityId = checkForNull(request.getParameter("facility"));
// 			String locale = checkForNull(request.getParameter("locale"));
			String mealOrderFor= request.getParameter("mealOrderFor");
			String specialityCodes=request.getParameter("specialityCodes");			
			String levelOfCareWhereClause="";
			String clinicTypeWhereClause="";
			String specialityCodesWhereClause="";
			
			if(mealOrderFor.equalsIgnoreCase("OP")) {levelOfCareWhereClause=" AND a.level_of_care_ind = 'A' ";}
			
			else if(mealOrderFor.equalsIgnoreCase("EM")) {levelOfCareWhereClause=" AND a.level_of_care_ind = 'E' ";}
						
			if(mealOrderFor.equalsIgnoreCase("OP")) {clinicTypeWhereClause=" AND a.clinic_type in ('C','E','Y') ";}
			
			else if(mealOrderFor.equalsIgnoreCase("EM")) {clinicTypeWhereClause=" AND a.clinic_type='C' ";}
			
			if(!specialityCodes.equals("")) {specialityCodesWhereClause=" AND a.speciality_code in ("+specialityCodes+") ";}
						
			String location_sql = "SELECT a.clinic_code code, a.long_desc description FROM op_clinic_lang_vw a, am_os_user_locn_access_vw b WHERE a.facility_id = '"+facilityId+"' AND a.language_id='"+locale+"'"+levelOfCareWhereClause+"AND a.eff_status='E'"+clinicTypeWhereClause+" and a.facility_id = b.facility_id  AND a.clinic_code = b.locn_code and b.appl_user_id = '"+login_user+"' and  b.oper_stn_id = (SELECT OPER_STN_ID  FROM AM_USER_FOR_OPER_STN A  WHERE FACILITY_ID = b.facility_id AND APPL_USER_ID = b.appl_user_id AND TRUNC (SYSDATE) BETWEEN EFF_DATE_FROM AND NVL (EFF_DATE_TO, TRUNC (SYSDATE))) and b.manage_queue_yn = 'Y' and a.CLINIC_TYPE=b.LOCN_TYPE and a.rd_appl_yn = 'N'"+specialityCodesWhereClause+" and a.eff_status='E' ";			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(location_sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					locCodeStr.append("???");
				}
				locCodeStr.append(rst.getString("code")+":::"+rst.getString("description"));
				i++;
			}
			locations = locCodeStr.toString();
			out.println(locations);
		}
		else if(func_mode.equals("getTreatmentArea")){
			StringBuffer treatmentAreaStr = new StringBuffer();
			String treatmentArea = "";			
			String facility = checkForNull(request.getParameter("facility"));
			String locationList = checkForNull(request.getParameter("locationList"));
			String priorityZone = checkForNull(request.getParameter("priorityZone"));
			String priorityZoneWhereClause="";
			
			if(!priorityZone.equals("")) {priorityZoneWhereClause=" and priority_zone='"+priorityZone+"' ";}
			
			String treatmentArea_sql = "select treatment_area_code,short_desc from ae_tmt_area_for_clinic where clinic_code in ("+locationList+") and facility_id = '"+facility+"'"+priorityZoneWhereClause+" and eff_status='E' order by short_desc";			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(treatmentArea_sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					treatmentAreaStr.append("???");
				}
				treatmentAreaStr.append(rst.getString("treatment_area_code")+":::"+rst.getString("short_desc"));
				i++;
			}
			treatmentArea = treatmentAreaStr.toString();
			out.println(treatmentArea);
		}
		else if(func_mode.equals("getPriorityZone")){
			StringBuffer priorityZoneStr = new StringBuffer();
			String priorityZones = "";
			String locationList = checkForNull(request.getParameter("locationList"));
			String priorityZone_sql = "select distinct a.priority_zone,b.priority_zone_desc from ae_tmt_area_for_clinic a,ae_priority_zone b where a.priority_zone=b.priority_zone and a.clinic_code in ("+locationList+") and a.eff_status='E' and b.eff_status='E' order by priority_zone_desc";						
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(priorityZone_sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					priorityZoneStr.append("???");
				}
				priorityZoneStr.append(rst.getString("priority_zone")+":::"+rst.getString("priority_zone_desc"));
				i++;
			}
			priorityZones = priorityZoneStr.toString();
			out.println(priorityZones);
		}
		else if(func_mode.equals("getMealType_MealOrder")){
			StringBuffer mealTypeStr = new StringBuffer();
			String mealTypes = "";
			String mealOrderWhereClause="";
			String mealOrder = checkForNull(request.getParameter("mealOrder"));			
			
			if(!mealOrder.equals("")) {
				if(mealOrder.equals("OP")){
				mealOrderWhereClause=" and (opmealorder_yn='Y') ";
				}
				if(mealOrder.equals("EM")){
				mealOrderWhereClause=" and (em_meal_order_yn='Y') ";
				}
				if(mealOrder.equals("ALL")){
				mealOrderWhereClause=" and (opmealorder_yn='Y' or em_meal_order_yn='Y') ";
				}
			}else{
				mealOrderWhereClause=" and (opmealorder_yn='Y' or em_meal_order_yn='Y') ";
			}
					
			String mealType_sql = "select meal_type,short_Desc from ds_meal_type where eff_Status ='E'"+mealOrderWhereClause+"order by meal_order";			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(mealType_sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					mealTypeStr.append("???");
				}
				mealTypeStr.append(rst.getString("meal_type")+":::"+rst.getString("short_Desc"));
				i++;
			}
			mealTypes = mealTypeStr.toString();
			out.println(mealTypes);
		}
		else if(func_mode.equals("chkSessionVal"))
		{			
			if(session.getAttribute("ALLMENUITEMSMAP") != null)
				out.println("true");
			else
				out.println("false");
		
		}
		//GDOH-CRF-0083 STARTS
		else if(func_mode.equals("checkDateDiff")){
		String StartTime=checkForNull(request.getParameter("StartTime"));
		String EndTime=checkForNull(request.getParameter("EndTime"));
		String result="";
		StringBuffer query=new StringBuffer();		
		query.append("	SELECT   TO_DATE (?, 'DD/MM/YYYY')	");
		query.append("	- TO_DATE (?, 'DD/MM/YYYY') AS datediff	");
		query.append("	FROM DUAL	");
		
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(query.toString());		
		pstmt.setString(1,EndTime);
		pstmt.setString(2,StartTime);
		rst = pstmt.executeQuery();
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);		
			
		}
		//GDOH-CRF-0083 ENDS
		//ML-MMOH-CRF-419 Starts
		else if(func_mode.equals("getlocationstaff")){
			StringBuffer locCodeStr = new StringBuffer();
			String loc = "";
			String loc_sql = "SELECT LOCATION_CODE, SHORT_DESC FROM ds_diet_request_loc WHERE  eff_status = 'E' ORDER BY 2, 1";			
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(loc_sql);
			rst = pstmt.executeQuery();
			int i = 0;
			while(rst!= null && rst.next()){
				if(!(i==0)){
					locCodeStr.append("???");
				}
				locCodeStr.append(rst.getString("LOCATION_CODE")+":::"+rst.getString("SHORT_DESC"));
				i++;
			}
			loc = locCodeStr.toString();
			out.println(loc);
		}
		//ML-MMOH-CRF-419 Ends
		 //ML-MMOH-CRF-0596 Starts OutPatient
		 else if(func_mode.equals("OPMealCount")){			
	        String patient_id = checkForNull(request.getParameter("patient_id"));
			String specality = checkForNull(request.getParameter("specality"));
			String mealCode = "";
			String mealCount = "SELECT COUNT(SPECIALTY_CODE) count FROM pr_encounter a WHERE patient_id = '"+patient_id+"' AND TRUNC (visit_adm_date_time) = TRUNC (SYSDATE) and specialty_code not in('"+specality+"') AND  (a.PATIENT_ID) IN (select b.PATIENT_ID from ds_op_diet_order_dtl b where a.FACILITY_ID = b.FACILITY_ID AND a.PATIENT_ID = b.PATIENT_ID AND TRUNC (serving_date) = TRUNC (SYSDATE))"; 
		   	con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(mealCount);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				mealCode = rst.getString("count");			
			}
			out.println(mealCode);
		}
		 else if(func_mode.equals("OPMealCount2")){            		
		 	String encounteridnew=checkForNull(request.getParameter("encounteridnew"));
			String specality = checkForNull(request.getParameter("specality"));
			String mealCode = "";
			String mealCount = "SELECT COUNT (specialty_code) COUNT FROM pr_encounter a WHERE encounter_id = '"+encounteridnew+"' AND TRUNC (visit_adm_date_time) = TRUNC (SYSDATE) AND specialty_code IN ('"+specality+"') AND (a.patient_id) IN (SELECT b.patient_id FROM ds_op_diet_order_dtl b WHERE a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND TRUNC (serving_date) = TRUNC (SYSDATE))"; 
		      	con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(mealCount);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				mealCode = rst.getString("count");			
			}
			out.println(mealCode);
		}
		//ML-MMOH-CRF-0596 Ends
		//ML-MMOH-CRF-0596 Starts Emergency Patient
		else if(func_mode.equals("EMMealCount")){			
           	String patient_id = checkForNull(request.getParameter("patient_id"));
			String location = checkForNull(request.getParameter("location"));
			String EMmealCode = "";
			String EMmealCount = "SELECT COUNT (ASSIGN_CARE_LOCN_CODE) COUNT FROM pr_encounter a WHERE patient_id = '"+patient_id+"' AND TRUNC (visit_adm_date_time) = TRUNC (SYSDATE) AND ASSIGN_CARE_LOCN_CODE not in ('"+location+"') AND (a.patient_id) IN (SELECT b.patient_id FROM ds_em_diet_order_dtl b  WHERE a.facility_id = b.facility_id  AND a.patient_id = b.patient_id AND TRUNC (serving_date) = TRUNC (SYSDATE))";  
        	con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(EMmealCount);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				EMmealCode = rst.getString("count");		
			}
			out.println(EMmealCode);
		}
		
		 else if(func_mode.equals("EMMealCount2")){            		
		 	String encounteridnew=checkForNull(request.getParameter("encounteridnew"));
			String location = checkForNull(request.getParameter("location"));
			String EMmealCode = "";
			String EMmealCount = "SELECT COUNT (specialty_code) COUNT FROM pr_encounter a WHERE encounter_id = '"+encounteridnew+"' AND TRUNC (visit_adm_date_time) = TRUNC (SYSDATE) AND ASSIGN_CARE_LOCN_CODE IN ('"+location+"') AND (a.patient_id) IN (SELECT b.patient_id FROM ds_em_diet_order_dtl b WHERE a.facility_id = b.facility_id  AND a.encounter_id = b.encounter_id AND TRUNC (serving_date) = TRUNC (SYSDATE))"; 
	      	con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(EMmealCount);
			rst = pstmt.executeQuery();
			while(rst!= null && rst.next()){
				EMmealCode = rst.getString("count");			
			}
			out.println(EMmealCode);
		}
		//ML-MMOH-CRF-0596 Ends
		// ML-MMOH-CRF-0599 Starts
		else if(func_mode.equals("getDatediff")){
			String fromDate = checkForNull(request.getParameter("fromDate"));
			String toDate = checkForNull(request.getParameter("toDate"));
			String diff ="";
			String DiffCount="SELECT  TO_DATE ('"+toDate+"', 'DD/MM/YYYY') - TO_DATE ('"+fromDate+"', 'DD/MM/YYYY') datediff FROM DUAL";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(DiffCount);
			rst = pstmt.executeQuery();
		  	while(rst!= null && rst.next()){
			diff = rst.getString("datediff");	
             	}
			out.println(diff);
			}
		 // ML-MMOH-CRF-0599 Ends
		 // ML-MMOH-CRF-0600-US2 Starts
		 else if(func_mode.equals("ActionPendingTooltip")){
			String facility_Id = checkForNull(request.getParameter("facility_Id"));
			String encounter_Id = checkForNull(request.getParameter("encounter_Id"));
			String serving_date="";
			String meal_type="";
			String Status="";
			String PendingTooltip="SELECT serving_date,ds_get_desc.ds_meal_type(meal_type,'en','2') MEAL_TYPE_DESC, DECODE(curr_stat,'MP','Meal Prepared','MR','Meal Received','MS','Meal Served','MJ','Meal Rejected','NA') Status FROM (SELECT DISTINCT a.encounter_id, a.serving_date, b.status curr_stat,a.meal_type FROM ds_epsd_meal_plan_dtl a, ds_epsd_meal_plan_hdr_audit b, ds_epsd_diet_profile_hdr c WHERE a.operating_facility_id = '"+facility_Id+"' AND a.encounter_id = '"+encounter_Id+"' AND a.operating_facility_id = b.operating_facility_id(+) AND a.encounter_id = b.encounter_id(+) AND a.serving_date = b.serving_date(+) AND a.meal_type = b.meal_type(+) AND a.operating_facility_id = c.operating_facility_id AND a.encounter_id = c.encounter_id AND c.profile_sl = (SELECT MAX (profile_sl) FROM ds_epsd_diet_profile_hdr WHERE operating_facility_id = a.operating_facility_id AND encounter_id = a.encounter_id) AND a.serving_date BETWEEN c.period_from AND c.period_to ORDER BY a.serving_date DESC)";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(PendingTooltip);
			rst = pstmt.executeQuery();
		  	while(rst!= null && rst.next()){				
				serving_date = rst.getString("serving_date");				
				meal_type = rst.getString("MEAL_TYPE_DESC");				
				Status = rst.getString("Status");				
				}
			out.println(serving_date+","+meal_type+","+Status);
			}
		  //ML-MMOH-CRF-0600-US2 Ends
		 //ML-MMOH-CRF-0669 Starts
		else if(func_mode.equals("editmenu")){
			String mealClass = checkForNull(request.getParameter("mealClass"));
	       	String edit ="";
			String edit_menu ="select EDIT_MENU_APPL_YN from ds_meal_class where MEAL_CLASS='"+mealClass+"'";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(edit_menu);
			rst = pstmt.executeQuery();
		  	while(rst!= null && rst.next()){
			edit = rst.getString("EDIT_MENU_APPL_YN");	
             		}
			out.println(edit);
			}
		//ML-MMOH-CRF-0669 Ends
		 //ML-MMOH-CRF-0677 Starts
		else if(func_mode.equals("PlaceOrderRightsEdit")){
			String facility_id = checkForNull(request.getParameter("facility_id"));
			String appl_user_id = checkForNull(request.getParameter("appl_user_id"));
	        String edit_meals_yn="";
			String nutrient_supplement_yn="";
			String food_dislike_yn="";
			String special_food_order_yn="";
			String PlaceOrderRights_edit="SELECT EDIT_MEALS_YN, NUTRIENT_SUPPLEMENT_YN, FOOD_DISLIKE_YN, SPECIAL_FOOD_ORDER_YN  FROM DS_PLACE_DIET_ORDER_RIGHTS WHERE OPERATING_FACILITY_ID ='"+facility_id+"' AND APPL_USER_ID = '"+appl_user_id+"'";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(PlaceOrderRights_edit);
			rst = pstmt.executeQuery();
		  	while(rst!= null && rst.next()){
				edit_meals_yn = rst.getString("EDIT_MEALS_YN");	
				nutrient_supplement_yn = rst.getString("NUTRIENT_SUPPLEMENT_YN");				
				food_dislike_yn = rst.getString("FOOD_DISLIKE_YN");	
				special_food_order_yn = rst.getString("SPECIAL_FOOD_ORDER_YN");	
				}
			out.println(edit_meals_yn+","+nutrient_supplement_yn+","+food_dislike_yn+","+special_food_order_yn);
			}
		//ML-MMOH-CRF-0677 Ends
		//ML-MMOH-CRF-409 STARTS
		else if(func_mode.equals("checkMealTimeOverLap")){
		String ServingStartTime=checkForNull(request.getParameter("ServingStartTime"));
		String ServingEndTime=checkForNull(request.getParameter("ServingEndTime"));
		String IrregularEndTime=checkForNull(request.getParameter("IrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time IS NOT NULL	");
			query.append("	AND serving_end_time IS NOT NULL	");
			query.append("	AND meal_order < ?	");//Meal order
			//query.append("	AND serving_end_time >= ?	");//Serving start time
			query.append("	AND greatest(nvl(serving_end_time,'00:01'),nvl(irregular_end_time,'00:01')) >= ?	");//Serving start time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time IS NOT NULL	");
			query.append("	AND serving_end_time IS NOT NULL	");
			query.append("	AND meal_order > ?	");//Meal order
			query.append("	AND serving_start_time <= ?	");//serving end time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time IS NOT NULL	");
			query.append("	AND serving_end_time IS NOT NULL	");
			query.append("	AND meal_order > ?	");//Meal order
			query.append("	AND serving_start_time <= ?	");//irregular end time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			//query.append("	|| (SELECT serving_end_time	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time,'00:01'),nvl(irregular_end_time,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time IS NOT NULL	");
			query.append("	AND serving_end_time IS NOT NULL	");
			query.append("	AND meal_order < ?	");//meal order
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time IS NOT NULL	");
			query.append("	AND serving_end_time IS NOT NULL	");
			query.append("	AND meal_order > ?	");//MEAL ORDER
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,ServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,ServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,IrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();
			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}		
		//ML-MMOH-CRF-409 ENDS	
		// Added Against Start ML-MMOH-CRF-825-US002
		else if(func_mode.equals("checkMealTimeOverLapOp")){
		String OpServingStartTime=checkForNull(request.getParameter("OpServingStartTime"));
		String OpServingEndTime=checkForNull(request.getParameter("OpServingEndTime"));
		String OpIrregularEndTime=checkForNull(request.getParameter("OpIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_op	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_op IS NOT NULL	");
			query.append("	AND serving_end_time_op IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND greatest(nvl(serving_end_time_op,'00:01'),nvl(irregular_end_time_op,'00:01')) >= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_op	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_op IS NOT NULL	");
			query.append("	AND serving_end_time_op IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_op <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_op	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_op IS NOT NULL	");
			query.append("	AND serving_end_time_op IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_op <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_op,'00:01'),nvl(irregular_end_time_op,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_op IS NOT NULL	");
			query.append("	AND serving_end_time_op IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_op	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_op IS NOT NULL	");
			query.append("	AND serving_end_time_op IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_op	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OpServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OpServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OpIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 OP end
		// 825 EM start
		else if(func_mode.equals("checkMealTimeOverLapEm")){
		String EmServingStartTime=checkForNull(request.getParameter("EmServingStartTime"));
		String EmServingEndTime=checkForNull(request.getParameter("EmServingEndTime"));
		String EmIrregularEndTime=checkForNull(request.getParameter("EmIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_em	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_em IS NOT NULL	");
			query.append("	AND serving_end_time_em IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND greatest(nvl(serving_end_time_em,'00:01'),nvl(irregular_end_time_em,'00:01')) >= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_em	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_em IS NOT NULL	");
			query.append("	AND serving_end_time_em IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_em <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_em	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_em IS NOT NULL	");
			query.append("	AND serving_end_time_em IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_em <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_em,'00:01'),nvl(irregular_end_time_em,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_em IS NOT NULL	");
			query.append("	AND serving_end_time_em IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_em	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_em IS NOT NULL	");
			query.append("	AND serving_end_time_em IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_em	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,EmServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,EmServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,EmIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();
			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 EM end
		// 825 Supplement start
		else if(func_mode.equals("checkMealTimeOverLapSupplement")){
		String SupplementServingStartTime=checkForNull(request.getParameter("SupplementServingStartTime"));
		String SupplementServingEndTime=checkForNull(request.getParameter("SupplementServingEndTime"));
		String SupplementIrregularEndTime=checkForNull(request.getParameter("SupplementIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_sup	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_sup IS NOT NULL	");
			query.append("	AND serving_end_time_sup IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND greatest(nvl(serving_end_time_sup,'00:01'),nvl(irregular_end_time_sup,'00:01')) >= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_sup	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_sup IS NOT NULL	");
			query.append("	AND serving_end_time_sup IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_sup <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_sup	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_sup IS NOT NULL	");
			query.append("	AND serving_end_time_sup IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_sup <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_sup,'00:01'),nvl(irregular_end_time_sup,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_sup IS NOT NULL	");
			query.append("	AND serving_end_time_sup IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_sup	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_sup IS NOT NULL	");
			query.append("	AND serving_end_time_sup IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_sup	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,SupplementServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,SupplementServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,SupplementIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 Supplement end
		// 825 Doc on call start
		else if(func_mode.equals("checkMealTimeOverLapDoc")){
		String DocServingStartTime=checkForNull(request.getParameter("DocServingStartTime"));
		String DocServingEndTime=checkForNull(request.getParameter("DocServingEndTime"));
		String DocIrregularEndTime=checkForNull(request.getParameter("DocIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_doc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_doc IS NOT NULL	");
			query.append("	AND serving_end_time_doc IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND greatest(nvl(serving_end_time_doc,'00:01'),nvl(irregular_end_time_doc,'00:01')) >= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_doc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_doc IS NOT NULL	");
			query.append("	AND serving_end_time_doc IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_doc <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_doc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_doc IS NOT NULL	");
			query.append("	AND serving_end_time_doc IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_doc <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_doc,'00:01'),nvl(irregular_end_time_doc,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_doc IS NOT NULL	");
			query.append("	AND serving_end_time_doc IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_doc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_doc IS NOT NULL	");
			query.append("	AND serving_end_time_doc IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_doc	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,DocServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,DocServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,DocIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();
			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 Doc on call end
		// 825 OPS start
		else if(func_mode.equals("checkMealTimeOverLapOps")){
		String OpsServingStartTime=checkForNull(request.getParameter("OpsServingStartTime"));
		String OpsServingEndTime=checkForNull(request.getParameter("OpsServingEndTime"));
		String OpsIrregularEndTime=checkForNull(request.getParameter("OpsIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_ops	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_ops IS NOT NULL	");
			query.append("	AND serving_end_time_ops IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND greatest(nvl(serving_end_time_ops,'00:01'),nvl(irregular_end_time_ops,'00:01')) >= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_ops	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_ops IS NOT NULL	");
			query.append("	AND serving_end_time_ops IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_ops <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_ops	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_ops IS NOT NULL	");
			query.append("	AND serving_end_time_ops IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_ops <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_ops,'00:01'),nvl(irregular_end_time_ops,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_ops IS NOT NULL	");
			query.append("	AND serving_end_time_ops IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_ops	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_ops IS NOT NULL	");
			query.append("	AND serving_end_time_ops IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_ops	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OpsServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OpsServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OpsIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 OPS end
		// 825 On call Staff start
		else if(func_mode.equals("checkMealTimeOverLapOnc")){
		String OncServingStartTime=checkForNull(request.getParameter("OncServingStartTime"));
		String OncServingEndTime=checkForNull(request.getParameter("OncServingEndTime"));
		String OncIrregularEndTime=checkForNull(request.getParameter("OncIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_onc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_onc IS NOT NULL	");
			query.append("	AND serving_end_time_onc IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND greatest(nvl(serving_end_time_onc,'00:01'),nvl(irregular_end_time_onc,'00:01')) >= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_onc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_onc IS NOT NULL	");
			query.append("	AND serving_end_time_onc IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_onc <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_onc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_onc IS NOT NULL	");
			query.append("	AND serving_end_time_onc IS NOT NULL	");
			query.append("	AND meal_order > ?	");
			query.append("	AND serving_start_time_onc <= ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_onc,'00:01'),nvl(irregular_end_time_onc,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_onc IS NOT NULL	");
			query.append("	AND serving_end_time_onc IS NOT NULL	");
			query.append("	AND meal_order < ?	");
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_onc	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_onc IS NOT NULL	");
			query.append("	AND serving_end_time_onc IS NOT NULL	");
			query.append("	AND meal_order > ?	");//MEAL ORDER
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_onc	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OncServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OncServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,OncIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();
			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 On call Staff end
		// 825 staff start
		else if(func_mode.equals("checkMealTimeOverLapStaff")){
		String StaffServingStartTime=checkForNull(request.getParameter("StaffServingStartTime"));
		String StaffServingEndTime=checkForNull(request.getParameter("StaffServingEndTime"));
		String StaffIrregularEndTime=checkForNull(request.getParameter("StaffIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_stf	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stf IS NOT NULL	");
			query.append("	AND serving_end_time_stf IS NOT NULL	");
			query.append("	AND meal_order < ?	");//Meal order
			query.append("	AND greatest(nvl(serving_end_time_stf,'00:01'),nvl(irregular_end_time_stf,'00:01')) >= ?	");//Serving start time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_stf	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stf IS NOT NULL	");
			query.append("	AND serving_end_time_stf IS NOT NULL	");
			query.append("	AND meal_order > ?	");//Meal order
			query.append("	AND serving_start_time_stf <= ?	");//serving end time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_stf	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stf IS NOT NULL	");
			query.append("	AND serving_end_time_stf IS NOT NULL	");
			query.append("	AND meal_order > ?	");//Meal order
			query.append("	AND serving_start_time_stf <= ?	");//irregular end time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_stf,'00:01'),nvl(irregular_end_time_stf,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stf IS NOT NULL	");
			query.append("	AND serving_end_time_stf IS NOT NULL	");
			query.append("	AND meal_order < ?	");//meal order
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_stf	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stf IS NOT NULL	");
			query.append("	AND serving_end_time_stf IS NOT NULL	");
			query.append("	AND meal_order > ?	");//MEAL ORDER
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_stf	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,StaffServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,StaffServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,StaffIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();
			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 staff end
		// 825 Students start
		else if(func_mode.equals("checkMealTimeOverLapStudent")){
		String StudentServingStartTime=checkForNull(request.getParameter("StudentServingStartTime"));
		String StudentServingEndTime=checkForNull(request.getParameter("StudentServingEndTime"));
		String StudentIrregularEndTime=checkForNull(request.getParameter("StudentIrregularEndTime"));
		String order_no=checkForNull(request.getParameter("order_no"));
		int index=0;
		String result="";
		StringBuffer query=new StringBuffer();
			query.append("	SELECT    (SELECT serving_end_time_stu	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stu IS NOT NULL	");
			query.append("	AND serving_end_time_stu IS NOT NULL	");
			query.append("	AND meal_order < ?	");//Meal order
			query.append("	AND greatest(nvl(serving_end_time_stu,'00:01'),nvl(irregular_end_time_stu,'00:01')) >= ?	");//Serving start time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_stu	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stu IS NOT NULL	");
			query.append("	AND serving_end_time_stu IS NOT NULL	");
			query.append("	AND meal_order > ?	");//Meal order
			query.append("	AND serving_start_time_stu <= ?	");//serving end time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT serving_start_time_stu	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stu IS NOT NULL	");
			query.append("	AND serving_end_time_stu IS NOT NULL	");
			query.append("	AND meal_order > ?	");//Meal order
			query.append("	AND serving_start_time_stu <= ?	");//irregular end time
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| (SELECT greatest(nvl(serving_end_time_stu,'00:01'),nvl(irregular_end_time_stu,'00:01'))	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MAX (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stu IS NOT NULL	");
			query.append("	AND serving_end_time_stu IS NOT NULL	");
			query.append("	AND meal_order < ?	");//meal order
			query.append("	AND eff_status = 'E'))	");
			query.append("	|| '#'	");
			query.append("	|| NVL((SELECT serving_start_time_stu	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE meal_order IN (	");
			query.append("	SELECT MIN (meal_order)	");
			query.append("	FROM ds_meal_type	");
			query.append("	WHERE serving_start_time_stu IS NOT NULL	");
			query.append("	AND serving_end_time_stu IS NOT NULL	");
			query.append("	AND meal_order > ?	");//MEAL ORDER
			query.append("	AND eff_status = 'E')),'23:59') serving_end_time_stu	");
			query.append("	FROM DUAL	");

			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(query.toString());
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,StudentServingStartTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,StudentServingEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setString(++index,StudentIrregularEndTime);
			pstmt.setInt(++index,Integer.parseInt(order_no));
			pstmt.setInt(++index,Integer.parseInt(order_no));
			rst = pstmt.executeQuery();
			
			if(rst.next())
			{
			result=rst.getString(1);
			}
			out.println(result);
		}
		//	825 Students end
		// Added Against End ML-MOH-CRF-825-US002
	//ML-MMOH-CRF-1006-US3 Starts
	else if(func_mode.equals("getMealTypeForCat")){
		StringBuffer mealtypeCat = new StringBuffer();
		StringBuilder mealtypeCat1 = new StringBuilder();
		String mealCategory = checkForNull(request.getParameter("meal_Category"));
		String patient_class = checkForNull(request.getParameter("patient_class")); //Added Against 1006-US5
		
		mealtypeCat.append( " SELECT MEAL_TYPE,SHORT_DESC ");
		/* Added Against ML-MOH-CRF-825-US006 */
		if(!mealCategory.equals("") && mealCategory.length()>0){	
		if(mealCategory.equals("DOC"))
			mealtypeCat.append(" ,IRREGULAR_START_TIME_DOC,IRREGULAR_END_TIME_DOC");
		else if(mealCategory.equals("OPS"))
			mealtypeCat.append(" ,IRREGULAR_START_TIME_OPS,IRREGULAR_END_TIME_OPS");
		else if(mealCategory.equals("ONC"))
			mealtypeCat.append(" ,IRREGULAR_START_TIME_ONC,IRREGULAR_END_TIME_ONC");
		else if(mealCategory.equals("STF"))
			mealtypeCat.append(" ,IRREGULAR_START_TIME_STF,IRREGULAR_END_TIME_STF");
		else if(mealCategory.equals("STU"))
			mealtypeCat.append(" ,IRREGULAR_START_TIME_STU,IRREGULAR_END_TIME_STU");
		}	
		/* Added Against End ML-MOH-CRF-825-US006 */	
		mealtypeCat.append( " FROM DS_MEAL_TYPE_LANG_VW WHERE LANGUAGE_ID=? AND (EFF_STATUS='E') ");
	if(!mealCategory.equals("") && mealCategory.length()>0){	
		if(mealCategory.equals("DOC"))
			mealtypeCat.append(" AND DOC_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("OPS"))
			mealtypeCat.append(" AND OPS_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("ONC"))
			mealtypeCat.append(" AND ONC_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("STF"))
			mealtypeCat.append(" AND STF_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("STU"))
			mealtypeCat.append(" AND STU_MEAL_ORDER_YN ='Y'");
	}
	/* Added Against Strat-1006-US5 */
	else if(!patient_class.equals("") && patient_class.length()>0){	
		if(patient_class.equalsIgnoreCase("IP"))
			mealtypeCat.append(" AND IP_MEAL_ORDER_YN ='Y' ");
		else if(patient_class.equalsIgnoreCase("OP"))
			mealtypeCat.append(" AND OPMEALORDER_YN ='Y'");	
		else if(patient_class.equalsIgnoreCase("EM"))
			mealtypeCat.append(" AND EM_MEAL_ORDER_YN ='Y'");		
		else if(patient_class.equalsIgnoreCase("ST"))
			mealtypeCat.append(" AND (DOC_MEAL_ORDER_YN ='Y' OR ONC_MEAL_ORDER_YN ='Y' OR OPS_MEAL_ORDER_YN ='Y' OR STF_MEAL_ORDER_YN ='Y' OR STU_MEAL_ORDER_YN ='Y') ");			
	}
	/* Added Against End-1006-US5 */
		mealtypeCat.append(" ORDER BY MEAL_ORDER");
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(mealtypeCat.toString());
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		int i = 0;
		while(rst!= null && rst.next()){
			if(!(i==0)){
				mealtypeCat1.append("???");
			}
			mealtypeCat1.append(rst.getString("MEAL_TYPE")+":::"+rst.getString("SHORT_DESC")); //Modified Against ML-MOH-CRF-825-US006
			if(!mealCategory.equals("") && mealCategory.length()>0)
				mealtypeCat1.append(":::"+rst.getString(3)+":::"+rst.getString(4));	
			i++;
		}
		out.println(mealtypeCat1);
	}
	/* Added Against Strat-1006-US5 */

	/* Added Against ML-MOH-CRF-825-US006 Starts Here*/
	else if(func_mode.equals("getMealTypeForCatSTF")){
		StringBuffer mealtypeCat = new StringBuffer();
		StringBuilder mealtypeCat1 = new StringBuilder();
		String mealCategory = checkForNull(request.getParameter("meal_Category"));
		String patient_class = checkForNull(request.getParameter("patient_class")); //Added Against 1006-US5
		
		mealtypeCat.append( " SELECT c.MEAL_TYPE,SHORT_DESC ");
		
		if(!mealCategory.equals("") && mealCategory.length()>0){	
		if(mealCategory.equals("DOC"))
			mealtypeCat.append(" ,SERVING_START_TIME_DOC,SERVING_END_TIME_DOC,IRREGULAR_START_TIME_DOC,IRREGULAR_END_TIME_DOC");
		else if(mealCategory.equals("OPS"))
			mealtypeCat.append(" ,SERVING_START_TIME_OPS,SERVING_END_TIME_OPS,IRREGULAR_START_TIME_OPS,IRREGULAR_END_TIME_OPS");
		else if(mealCategory.equals("ONC"))
			mealtypeCat.append(" ,SERVING_START_TIME_ONC,SERVING_END_TIME_ONC,IRREGULAR_START_TIME_ONC,IRREGULAR_END_TIME_ONC");
		else if(mealCategory.equals("STF"))
			mealtypeCat.append(" ,SERVING_START_TIME_STF,SERVING_END_TIME_STF,IRREGULAR_START_TIME_STF,IRREGULAR_END_TIME_STF");
		else if(mealCategory.equals("STU"))
			mealtypeCat.append(" ,SERVING_START_TIME_STU,SERVING_END_TIME_STU,IRREGULAR_START_TIME_STU,IRREGULAR_END_TIME_STU");
		}
			mealtypeCat.append( " ,meal_order ");
		if(!mealCategory.equals("") && mealCategory.length()>0){	
		if(mealCategory.equals("DOC"))
			mealtypeCat.append( " ,NVL ((SELECT SERVING_START_TIME_DOC");
		else if(mealCategory.equals("OPS"))
			mealtypeCat.append(" ,NVL ((SELECT SERVING_START_TIME_OPS");
		else if(mealCategory.equals("ONC"))
			mealtypeCat.append(" ,NVL ((SELECT SERVING_START_TIME_ONC");
		else if(mealCategory.equals("STF"))
			mealtypeCat.append(" ,NVL ((SELECT SERVING_START_TIME_STF");
		else if(mealCategory.equals("STU"))
			mealtypeCat.append(" ,NVL ((SELECT SERVING_START_TIME_STU");
		}
		mealtypeCat.append(" FROM ds_meal_type_lang_vw a WHERE a.meal_order = (SELECT MIN (b.meal_order) FROM ds_meal_type_lang_vw b");
		if(!mealCategory.equals("") && mealCategory.length()>0){	
		if(mealCategory.equals("DOC"))
			mealtypeCat.append( " WHERE b.SERVING_START_TIME_DOC");
		else if(mealCategory.equals("OPS"))
			mealtypeCat.append(" WHERE b.SERVING_START_TIME_OPS");
		else if(mealCategory.equals("ONC"))
			mealtypeCat.append(" WHERE b.SERVING_START_TIME_ONC");
		else if(mealCategory.equals("STF"))
			mealtypeCat.append(" WHERE b.SERVING_START_TIME_STF");
		else if(mealCategory.equals("STU"))
			mealtypeCat.append(" WHERE b.SERVING_START_TIME_STU");
		}
		mealtypeCat.append(" IS NOT NULL AND b.meal_order > c.meal_order) AND a.language_id = ? ), '23:59') next_meal_start_time FROM ds_meal_type c");
	if(!mealCategory.equals("") && mealCategory.length()>0){	
		if(mealCategory.equals("DOC"))
			mealtypeCat.append(" WHERE DOC_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("OPS"))
			mealtypeCat.append(" WHERE OPS_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("ONC"))
			mealtypeCat.append(" WHERE ONC_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("STF"))
			mealtypeCat.append(" WHERE STF_MEAL_ORDER_YN ='Y'");
		else if(mealCategory.equals("STU"))
			mealtypeCat.append(" WHERE STU_MEAL_ORDER_YN ='Y'");
	}
		mealtypeCat.append(" AND eff_status = 'E' ORDER BY c.meal_order");
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(mealtypeCat.toString());
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();
		int i = 0;
		while(rst!= null && rst.next()){
			if(!(i==0)){
				mealtypeCat1.append("???");
			}
			mealtypeCat1.append(rst.getString("MEAL_TYPE")+":::"+checkForNull(rst.getString("SHORT_DESC"))+":::"+checkForNull(rst.getString(3))+":::"+checkForNull(rst.getString(4))+":::"+checkForNull(rst.getString(5))+":::"+checkForNull(rst.getString(6))+":::"+checkForNull(rst.getString(7))+":::"+checkForNull(rst.getString(8))); //Modified Against ML-MOH-CRF-825-US006
			i++;
		}
		out.println(mealtypeCat1);
	}
	/* Added Against Start-1006-US5 */
	
	//Added by Gaurav Against ML-MMOH-SCF-2400...starts
	else if(func_mode.equals("checkOrderForStaff")){
		String menu_type = checkForNull(request.getParameter("menuTypeVal")); 
		String meal_type = checkForNull(request.getParameter("mealTypeVal"));
		String meal_order_from = checkForNull(request.getParameter("mealOrderFrom"));
		String meal_order_to = checkForNull(request.getParameter("mealOrderTo"));
		String diet_type = checkForNull(request.getParameter("dietTypeVal"));
		String meal_class = checkForNull(request.getParameter("mealClassVal"));
		String diet_location = checkForNull(request.getParameter("dietLocationVal"));
		String meal_category = checkForNull(request.getParameter("meal_Category"));
		String practitioner_id = checkForNull(request.getParameter("practId"));
		String isMenuType = checkForNull(request.getParameter("isMenuType"));
		Integer count = 0;
	
		con = ConnectionManager.getConnection(request);
		
		//String sql_OnLoadQuery = "SELECT COUNT(a.staff_order_id) AS total FROM ds_staff_orders_hdr a, ds_staff_orders_dtl b WHERE a.meal_category = ? AND a.location_code = ? AND b.diet_type = ? AND b.meal_class = ? AND b.meal_type = ?  AND a.facility_id = b.facility_id AND a.staff_order_id = b.staff_order_id AND NVL (a.eff_status, 'A') != 'D' AND ((nvl( ? , '31/12/3000') between to_char(ORDER_FROM_DATE , 'dd/mm/yyyy') and nvl(to_char(ORDER_TO_DATE , 'dd/mm/yyyy'), '31/12/3000')) OR (nvl( ? , '31/12/3000') between to_char(ORDER_FROM_DATE , 'dd/mm/yyyy') and nvl(to_char(ORDER_TO_DATE , 'dd/mm/yyyy'), '31/12/3000')))";
				 
		String sql_OnLoadQuery = "SELECT COUNT(a.staff_order_id) AS total FROM ds_staff_orders_hdr a, ds_staff_orders_dtl b WHERE a.meal_category = ? AND a.location_code = ? AND b.diet_type = ? AND b.meal_class = ? AND b.meal_type = ?  AND a.facility_id = b.facility_id AND a.staff_order_id = b.staff_order_id AND NVL (a.eff_status, 'A') != 'D' AND (((order_from_date BETWEEN to_date (?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')) OR (order_TO_date BETWEEN to_date (?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy'))) OR ((to_date (?,'dd/mm/yyyy') BETWEEN order_from_date and order_to_date) OR (to_date (?,'dd/mm/yyyy') BETWEEN order_from_date and order_to_date)))";//Modified By Gaurav Against ML-MMOH-CRF-2484
		
		//String sql_OnLoadQuery = "SELECT COUNT(a.staff_order_id) AS total FROM ds_staff_orders_hdr a, ds_staff_orders_dtl b WHERE a.meal_category = ? AND a.location_code = ? AND b.diet_type = ? AND b.meal_class = ? AND b.meal_type = ?  AND a.facility_id = b.facility_id AND a.staff_order_id = b.staff_order_id AND NVL (a.eff_status, 'A') != 'D' AND ((order_from_date BETWEEN to_date (?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy')) OR (order_TO_date BETWEEN to_date (?,'dd/mm/yyyy') AND to_date (?,'dd/mm/yyyy'))) ";
		
		if(!practitioner_id.equals(""))	sql_OnLoadQuery += "AND a.PRACTITIONER_ID = NVL( ? , '')";
		if(isMenuType.equals("true"))	sql_OnLoadQuery += "AND a.menu_type = ?";
			
			pstmt	= con.prepareStatement(sql_OnLoadQuery) ;							
			pstmt.setString(1,meal_category);	
			pstmt.setString(2,diet_location);	
			pstmt.setString(3,diet_type);	
			pstmt.setString(4,meal_class);
			pstmt.setString(5,meal_type);
			pstmt.setString(6,meal_order_from);
			pstmt.setString(7,meal_order_to);
			pstmt.setString(8,meal_order_from);//Added By Gaurav Against ML-MMOH-CRF-2484
			pstmt.setString(9,meal_order_to);//Added By Gaurav Against ML-MMOH-CRF-2484
			pstmt.setString(10,meal_order_from);//Added By Gaurav Against ML-MMOH-CRF-2484
			pstmt.setString(11,meal_order_to);//Added By Gaurav Against ML-MMOH-CRF-2484
			if(!practitioner_id.equals("")){
				pstmt.setString(12,practitioner_id);
				if(isMenuType.equals("true")) pstmt.setString(13,menu_type);
			}else{
				if(isMenuType.equals("true")) pstmt.setString(12,menu_type);
			}
									
			rst = pstmt.executeQuery();
			while(rst!=null && rst.next()){ 
			count = rst.getInt(1);
			}
			
			out.println(count.toString());
			
	}
	//Added by Gaurav Against ML-MMOH-SCF-2400...ends
	
	else if(func_mode.equals("getDietTypeValues")){
		StringBuffer dietTypeCat = new StringBuffer();
		StringBuilder dietTypeCat1 = new StringBuilder();
		String patient_class = checkForNull(request.getParameter("patient_class")); 
		
		dietTypeCat.append( "SELECT DIET_TYPE,SHORT_DESC FROM DS_DIET_TYPE WHERE EFF_STATUS='E' ");	
	
	if(!patient_class.equals("") && patient_class.length()>0){	
		if(patient_class.equalsIgnoreCase("IP"))
			dietTypeCat.append(" AND (IP_DIET_TYPE_YN = 'Y' OR DC_DIET_TYPE_YN = 'Y')");
		else if(patient_class.equalsIgnoreCase("OP"))
			dietTypeCat.append(" AND OP_DIET_TYPE_YN ='Y'");	
		else if(patient_class.equalsIgnoreCase("EM"))
			dietTypeCat.append(" AND EM_DIET_TYPE_YN ='Y'");		
		else if(patient_class.equalsIgnoreCase("ST"))
			dietTypeCat.append(" AND APPL_STAFF_ORDER_YN ='Y'");			
	}
		dietTypeCat.append(" ORDER BY SHORT_DESC");
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(dietTypeCat.toString());
		rst = pstmt.executeQuery();
		
		int i = 0;
		while(rst!= null && rst.next()){
			if(!(i==0)){
				dietTypeCat1.append("???");
			}
			dietTypeCat1.append(rst.getString("DIET_TYPE")+":::"+rst.getString("SHORT_DESC"));
			i++;
		}
		out.println(dietTypeCat1);
	}
	/* Added Against End-1006-US5 */
	//Added Against Start ML-MMOH-CRF-0825-US007
	else if(func_mode.equals("getSuplMealType")){
		StringBuffer mealtypeCat = new StringBuffer();
		StringBuilder mealtypeCat1 = new StringBuilder();
		String mealCategory = checkForNull(request.getParameter("meal_Category"));
		String patient_class = checkForNull(request.getParameter("patient_class"));
		String facility_id = checkForNull(request.getParameter("facility_id"));
		String mealTypeCode = checkForNull(request.getParameter("mealTypeCode"));		
		
		mealtypeCat.append( " SELECT c.meal_type, short_desc, serving_start_time_sup, serving_end_time_sup, irregular_start_time_sup, irregular_end_time_sup, meal_order,  NVL ((SELECT serving_start_time_sup FROM ds_meal_type_lang_vw a  WHERE a.meal_order = (SELECT MIN (b.meal_order) FROM ds_meal_type_lang_vw b WHERE b.serving_start_time_sup IS NOT NULL AND b.meal_order > c.meal_order) AND a.language_id = ?), '23:59') next_serving_start_time_sup ");
		mealtypeCat.append( " FROM ds_meal_type c ");
		mealtypeCat.append( " WHERE eff_status = 'E' ");
		mealtypeCat.append( " AND suppl_diet_order_yn = 'Y' ");
		mealtypeCat.append( " AND added_facility_id = ? ");
		if(!mealTypeCode.equals("") && mealTypeCode.length()>0)
		mealtypeCat.append( " AND MEAL_TYPE = ? ");
		mealtypeCat.append( " ORDER BY c.meal_order ");
		
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(mealtypeCat.toString());		
		pstmt.setString(1,locale);
		pstmt.setString(2,facility_id);		
		if(!mealTypeCode.equals("") && mealTypeCode.length()>0)		
		pstmt.setString(3,mealTypeCode);
		rst = pstmt.executeQuery();
		int i = 0;
		while(rst!= null && rst.next()){
			if(!(i==0)){
				mealtypeCat1.append("???");
			}
			mealtypeCat1.append(rst.getString("meal_type")+":::"+checkForNull(rst.getString("short_desc"))+":::"+checkForNull(rst.getString(3))+":::"+checkForNull(rst.getString(4))+":::"+checkForNull(rst.getString(5))+":::"+checkForNull(rst.getString(6))+":::"+checkForNull(rst.getString(7))+":::"+checkForNull(rst.getString(8)));
			i++;
		}
		out.println(mealtypeCat1);
	}
	//Added Against Ends ML-MMOH-CRF-0825-US007
	//Added Against MMS-KH-CRF-29.1 Starts
		else if(func_mode.equals("validateDrugInteraction")){
			String drug_Intr ="";
			int ret_val=0;
			String item_code = checkForNull(request.getParameter("item_code"));
			String servDate = checkForNull(request.getParameter("servDate"));
			String facility_id = checkForNull(request.getParameter("falility_ID"));
			String encounter_id = checkForNull(request.getParameter("encounter_id"));
			StringBuilder item_chk = new StringBuilder();
	       		String Drug_Itract = "select ds_drug_interaction(?, ?, TO_DATE (?, 'dd/mm/yyyy'), TO_DATE (?, 'dd/mm/yyyy')) DRUG_INTR from dual";
			//String Drug_Itract = "select ds_drug_interaction(?, 27013684, TO_DATE ('16/12/2019', 'dd/mm/yyyy'), TO_DATE ('16/12/2019', 'dd/mm/yyyy')) //DRUG_INTR from dual";
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(Drug_Itract);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,encounter_id);
			pstmt.setString(3,servDate);
			pstmt.setString(4,servDate);
			rst = pstmt.executeQuery();
		  	while(rst!= null && rst.next()){
				drug_Intr = rst.getString("DRUG_INTR");	
            }
			if(drug_Intr !=null && !drug_Intr.equals("")){
				String menuType_arr[]=drug_Intr.split("!");
				//System.out.println("menuType_arr2032 "+menuType_arr);
				
				drug_Intr = menuType_arr[1];
				//System.out.println("drug_Intr2032 "+drug_Intr);	//item code - CO018
				 item_chk.append("SELECT 1 cnt1 FROM ds_food_item_ingredients b WHERE b.food_item_code = 'CO018' AND (b.ingredient_code IN (SELECT REGEXP_SUBSTR (?, '[^,]+', 1, LEVEL ) FROM DUAL CONNECT BY REGEXP_SUBSTR (?, '[^,]+', 1, LEVEL) IS NOT NULL))");
				pstmt = con.prepareStatement(item_chk.toString());
				pstmt.setString(1,item_code);
				pstmt.setString(2,drug_Intr);
				pstmt.setString(3,drug_Intr);
				rst = pstmt.executeQuery();
				while(rst!= null && rst.next()){
					ret_val = 1;
            	}
			}
			else{
				ret_val = 0;
			}
			out.println(ret_val);
			}
		//Added Against MMS-KH-CRF-029.1 Ends
	}catch(Exception e)
	{
		System.err.println("DLComVal---->"+e.toString());
		e.printStackTrace();
	}
	finally{
		if(con != null)
				ConnectionManager.returnConnection(con,request);
				
		if(pstmtForMenuList != null)
			pstmtForMenuList.close();
		
		if(rstForMenuList != null)
			rstForMenuList.close();
		
		if(conForMenuList != null)
			ConnectionManager.returnConnection(conForMenuList,request);
	}

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
