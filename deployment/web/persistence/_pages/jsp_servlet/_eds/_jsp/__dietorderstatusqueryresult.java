package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.*;
import eDS.DSCommonBean;
import eDS.*;
import java.util.*;
import com.ehis.util.*;

public final class __dietorderstatusqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/DietOrderStatusQueryResult.jsp", 1709116718000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- Created for ML-MMOH-CRF-0423 -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n<script language=\'javascript\' src=\'../../eDS/js/DietOrderStatus.js\'></script>\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n</head>\n<body class=\'CONTENT\'  OnMouseDown=\'CodeArrest()\' onKeyDown=\"lockKey()\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'QueryResult\' id=\'QueryResult\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<P>\n<table align=\'right\'>\n<tr>\n<td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n</td>\n</tr>\n</table>\n<br><br>\n</p>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<table border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t\t\t<tr>\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t</th>\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t</th>\n\t\t\t   <th>\n\t\t\t   <!-- ML-MMOH-SCF-0812 -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<!--";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="-->\n\t\t\t\t<!-- ML-MMOH-SCF-0812 -->\n\t\t\t\t</th>\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</th>\n\t\t\t\t<!-- ML-MMOH-CRF-0902 -->\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</th>\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t<!-- ML-MMOH-CRF-0902 -->\n\t\t\t\t<th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</th>\n\t\t\t</tr>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n</td></tr>\n</table>\n</center>\n<br><center>\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n</center>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
 request.setCharacterEncoding("UTF-8"); 
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
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String)session.getAttribute("facility_id");

            _bw.write(_wl_block1Bytes, _wl_block1);
            eDS.DSCommonBean DSCommonBeanObj= null;{
                DSCommonBeanObj=(eDS.DSCommonBean)pageContext.getAttribute("DSCommonBeanObj");
                if(DSCommonBeanObj==null){
                    DSCommonBeanObj=new eDS.DSCommonBean();
                    pageContext.setAttribute("DSCommonBeanObj",DSCommonBeanObj);

                }
            }
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	try{
		String from = request.getParameter( "from" ) ;
		String to = request.getParameter( "to" ) ;
		String patientClass = request.getParameter("patient_Class");
		String ward_Clinic_code =request.getParameter("ward_Clinic_code");
		String wardClinicDesc=request.getParameter("ward_Clinic_Desc");
		String servDate =request.getParameter("serv_Date");
            			
		//Temporary Variables
		String wardOrClinicTemp="";
		int count=0;			
        	int total_No_Of_Patients=0;
        	int total_Orders=0;
		int total_Orders_temp=0;
        	int pending_orders=0;
		int full_Nbm=0;
		int mac_Only=0; //ML-MMOH-CRF-1826
		int total_Orders_Nbm=0;
		int attendant_Orders=0;
		String diet_Type_temp="";
		String menu_Type_temp="";	//ML-MMOH-CRF-0902
		//Variables Used for Permanent
		String wardOrClinic = "";
		String totalNoOfPatients = "";
		String totalOrders= "";
		String totalOrdersNbm="";
		String pendingorders = "";
		String attendantOrders="";
		String fullNbm="";
		String dietType="";
		String macOnlyCnt=""; //ML-MMOH-CRF-1826
		String menuType="";//ML-MMOH-CRF-0902
		String assignMenuTypeCnt="";//ML-MMOH-CRF-0902
		boolean isMenuType =false;//ML-MMOH-CRF-0902
		boolean isDietTypeCnt =false;//ML-MMOH-CRF-0968
	    	String assignDietTypeCnt="";//Added Against Linked issue 63512
		//Query
		String Attendent_Label_Name="";//ML-MMOH-SCF-0812
		String stafforder_Sql="";
		int start = 0 ;
		int end = 0 ;
		int i=1;

		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt( to ) ;

		Connection conn  =  ConnectionManager.getConnection(request);
		//ML-MMOH-CRF-0902
        	isMenuType = CommonBean.isSiteSpecific(conn,"DS","DS_MENU_TYPE");
		//ML-MMOH-CRF-0902
		//ML-MMOH-CRF-0968
       		isDietTypeCnt = CommonBean.isSiteSpecific(conn,"DS","DS_NOTIFICATIONS");
		//ML-MMOH-CRF-0968
		PreparedStatement stmt = null;
		PreparedStatement stmt1 = null,pstmt1=null;
			
		int maxRecord = 0;
			
		ResultSet rset=null;
		ResultSet rs = null,rs1=null;
		int gracePeriod = 0;
		String strQury = "select grace_period,Attendent_Label_Name from DS_PARAM_FOR_FACILITY where OPERATING_FACILITY_ID = '"+facility_id+"'";//ML-MMOH-SCF-0812
    	try{
    		stmt = conn.prepareStatement(strQury);
    		rset	= stmt.executeQuery();
    		if(rset != null && rset.next()){
    			gracePeriod = rset.getInt(1);
			Attendent_Label_Name = rset.getString(2);//ML-MMOH-SCF-0812
    		}
    	}
    	catch(Exception ee){
			ee.printStackTrace();
			System.err.println("93->DietOrderStatusQueryResult.jsp===>"+ee.getMessage());  		
    	}
	
	try{		
		stafforder_Sql=DSCommonBeanObj.getDietOrderQuery(wardClinicDesc,ward_Clinic_code,patientClass,facility_id,locale,servDate,gracePeriod,isDietTypeCnt);//CRF-968-US2
		
		stmt1=conn.prepareStatement(stafforder_Sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		rset = stmt1.executeQuery();
		rset.last();
		maxRecord=rset.getRow();
        if(maxRecord == 0){
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common'));</script>");
		}
	    rset.beforeFirst();

	}catch(Exception e){
		e.printStackTrace();
		System.err.println("110->DietOrderStatusQueryResult.jsp===>"+e.getMessage());
	}

            _bw.write(_wl_block8Bytes, _wl_block8);

	ArrayList<String> wardOrClinic_Value=new ArrayList<String>();
	ArrayList<String> totalNoOfPatients_value=new ArrayList<String>();
	ArrayList<String> totalOrders_value=new ArrayList<String>();
	ArrayList<String> pendingorders_value=new ArrayList<String>();
	ArrayList<String> attendantOrders_value=new ArrayList<String>();
	ArrayList<String> fullNbm_value=new ArrayList<String>();
	ArrayList<String> macOnlyCnt_value=new ArrayList<String>(); //ML-MMOH-CRF-1826
	ArrayList<String> menuType_value=new ArrayList<String>();//ML-MMOH-CRF-0902
	ArrayList<String> dietType_value=new ArrayList<String>();

	String classValue= " ";
    while ( rset.next() )
	{		
	//Code starts here for separation
	count++;	
	
	if(count ==1)
	{
		wardOrClinicTemp=rset.getString(1);//NURSING_UNIT
		wardOrClinic = rset.getString(1);//NURSING_UNIT
		if(wardOrClinic == null)
		wardOrClinic="";	
		if(wardOrClinicTemp == null)
		wardOrClinicTemp="";
	
	    dietType=rset.getString(3);	//DIET_TYPE_DESC
	    totalOrders= rset.getString(4);//TOT_ORDER_PLACED		
		totalNoOfPatients =rset.getString(5);//TOTAL_PATIENT
		attendantOrders=rset.getString(6);//Attendant Orders
		fullNbm=rset.getString(7);//FULL_NBM
		//Added for Linked issue-63512 Starts Here               
		assignDietTypeCnt=rset.getString(8);//ASSIGN_DIET_TYPE_CNT 
		 menuType=rset.getString(9);	//MENU_TYPE_DESC
		 assignMenuTypeCnt=rset.getString(10);//ASSIGN_MENU_TYPE_CNT
		 macOnlyCnt=rset.getString(11);//MAC_ORDERS_CNT //ML-MMOH-CRF-1826
		 System.err.println("macOnlyCnt===>"+macOnlyCnt);
	if(dietType == null)
		dietType="";
	
	if(menuType == null)	//ML-MMOH-CRF-0902
		menuType="";
	
		//integer Conversion starts Here
		total_No_Of_Patients += Integer.parseInt(totalNoOfPatients);
		total_Orders +=Integer.parseInt(totalOrders);
		total_Orders_temp=Integer.parseInt(totalOrders);
		full_Nbm +=Integer.parseInt(fullNbm);	
		mac_Only +=Integer.parseInt(macOnlyCnt);	//ML-MMOH-CRF-1826
		total_Orders_Nbm =total_Orders+full_Nbm;
		//total_Orders_Nbm =total_Orders+full_Nbm+mac_Only; //ML-MMOH-CRF-1826 reverted
		//To Avoid Negative Values starts here
	if(total_No_Of_Patients == 0 || total_No_Of_Patients <= total_Orders_Nbm)
		pending_orders =0;
	else
		pending_orders =total_No_Of_Patients-total_Orders_Nbm;
	//To Avoid Negative Values Ends here
	
		attendant_Orders +=Integer.parseInt(attendantOrders);
	//Modified for Linked issue-63512
	if(!dietType.equalsIgnoreCase(""))		
		diet_Type_temp +=dietType+"-"+assignDietTypeCnt+",";	
		
	//ML-MMOH-CRF-0902 starts here
	if(isMenuType){
	if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +=menuType+"-"+assignMenuTypeCnt+",";	
		System.err.println("menu_Type_temp"+menu_Type_temp);
	}
	else{
		if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +="";	
	}
	//ML-MMOH-CRF-0902 ends here
	//integer Conversion Ends Here
	
		totalNoOfPatients =""+total_No_Of_Patients;
	    totalOrders= ""+total_Orders;
		totalOrdersNbm=""+total_Orders_Nbm;
		fullNbm=""+full_Nbm;
		macOnlyCnt=""+mac_Only; //ML-MMOH-CRF-1826
	    pendingorders =""+pending_orders;
		dietType=""+diet_Type_temp;
		menuType=""+menu_Type_temp;//ML-MMOH-CRF-0902
		
	//If Only One Record is Available Starts Here
		if(maxRecord == 1)
		{
			wardOrClinic_Value.add(wardOrClinicTemp);
			totalNoOfPatients_value.add(totalNoOfPatients);
			totalOrders_value.add(totalOrdersNbm);
			pendingorders_value.add(pendingorders);
			attendantOrders_value.add(attendantOrders);
			fullNbm_value.add(fullNbm);
			macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
			dietType_value.add(dietType);
			menuType_value.add(menuType);
		}
   //If Only One Record is Available Ends Here
	}
	else
	{
		wardOrClinic = rset.getString(1);//NURSING_UNIT
	if(wardOrClinic == null)
		wardOrClinic="";	
	if(wardOrClinicTemp.equalsIgnoreCase("") || !wardOrClinicTemp.equalsIgnoreCase(wardOrClinic))
	{		
		wardOrClinic_Value.add(wardOrClinicTemp);
		totalNoOfPatients_value.add(totalNoOfPatients);
		totalOrders_value.add(totalOrdersNbm);
		pendingorders_value.add(pendingorders);
		attendantOrders_value.add(attendantOrders);
		fullNbm_value.add(fullNbm);
		macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
		dietType_value.add(dietType);
		menuType_value.add(menuType);
		
		//Reset Values starts Here 
		total_No_Of_Patients=0;
		total_Orders=0;
		full_Nbm=0;
		mac_Only=0; //ML-MMOH-CRF-1826
		total_Orders_Nbm=0;
		pending_orders=0;	
		attendant_Orders=0;
		diet_Type_temp="";
		menu_Type_temp="";
		//Reset Values Ends Here 

		wardOrClinicTemp=rset.getString(1);//NURSING_UNIT
		wardOrClinic = rset.getString(1);//NURSING_UNIT
		if(wardOrClinic == null)
			wardOrClinic="";	
		if(wardOrClinicTemp == null)
			wardOrClinicTemp="";

		dietType=rset.getString(3);	//DIET_TYPE_DESC
		totalOrders= rset.getString(4);//TOT_ORDER_PLACED		
		totalNoOfPatients =rset.getString(5);//TOTAL_PATIENT
		attendantOrders=rset.getString(6);//Attendant Orders
		fullNbm=rset.getString(7);//FULL_NBM
	   //Added for Linked issue-63512 
		assignDietTypeCnt=rset.getString(8);//ASSIGN_DIET_TYPE_CNT 
		menuType=rset.getString(9);	//MENU_TYPE_DESC
		assignMenuTypeCnt=rset.getString(10);//ASSIGN_MENU_TYPE_CNT
		macOnlyCnt=rset.getString(11);//MAC_ORDERS_CNT //ML-MMOH-CRF-1826
		
	if(dietType == null)
	   dietType="";
 	
	if(menuType == null)	//ML-MMOH-CRF-0902
		menuType="";
		
		//integer Conversion starts Here
		total_No_Of_Patients += Integer.parseInt(totalNoOfPatients);
		total_Orders +=Integer.parseInt(totalOrders);
		total_Orders_temp=Integer.parseInt(totalOrders);
		full_Nbm +=Integer.parseInt(fullNbm);	
		mac_Only +=Integer.parseInt(macOnlyCnt);	//ML-MMOH-CRF-1826
		total_Orders_Nbm =total_Orders+full_Nbm;
		//total_Orders_Nbm =total_Orders+full_Nbm+mac_Only; //ML-MMOH-CRF-1826 reverted
		//To Avoid Negative Values starts here
		if(total_No_Of_Patients == 0 || total_No_Of_Patients <= total_Orders_Nbm)
		pending_orders =0;
	else
		pending_orders =total_No_Of_Patients-total_Orders_Nbm;
		//To Avoid Negative Values Ends here
		attendant_Orders +=Integer.parseInt(attendantOrders);
	
	//Modified for Linked issue-63512 
	if(!dietType.equalsIgnoreCase(""))
		diet_Type_temp +=dietType+"-"+assignDietTypeCnt+",";
		
	if(isMenuType){
	if(!menuType.equalsIgnoreCase(""))
		menu_Type_temp +=menuType+"-"+assignMenuTypeCnt+",";	
	}
	else{
		if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +="";	
	}
	//ML-MMOH-CRF-0902 ends here
	//integer Conversion Ends Here	
	 totalNoOfPatients =""+total_No_Of_Patients;
   	 totalOrders= ""+total_Orders;
	 totalOrdersNbm=""+total_Orders_Nbm;
	 fullNbm=""+full_Nbm;
	 macOnlyCnt=""+mac_Only; //ML-MMOH-CRF-1826
   	 pendingorders =""+pending_orders;
  	 dietType=diet_Type_temp;
	 menuType=menu_Type_temp;
	  
	 //For Last Record
	if(count == maxRecord)
	{	
		wardOrClinic_Value.add(wardOrClinicTemp);
		totalNoOfPatients_value.add(totalNoOfPatients);
		totalOrders_value.add(totalOrdersNbm);
		pendingorders_value.add(pendingorders);
		attendantOrders_value.add(attendantOrders);
		fullNbm_value.add(fullNbm);
		macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
		dietType_value.add(dietType);		
		menuType_value.add(menuType);				
	}
	//For last Record Ends Here
	}
	else
	{
	
	wardOrClinic = rset.getString(1);//NURSING_UNIT
	if(wardOrClinic == null)
	wardOrClinic="";	
	
    	dietType=rset.getString(3);	//DIET_TYPE_DESC
	totalOrders= rset.getString(4);//TOT_ORDER_PLACED		
	totalNoOfPatients =rset.getString(5);//TOTAL_PATIENT
	attendantOrders=rset.getString(6);//Attendant Orders
	fullNbm=rset.getString(7);//FULL_NBM	
	//Added for Linked issue-63512        	
	assignDietTypeCnt=rset.getString(8);//ASSIGN_DIET_TYPE_CNT 
	menuType=rset.getString(9);	//MENU_TYPE_DESC
	assignMenuTypeCnt=rset.getString(10);//ASSIGN_MENU_TYPE_CNT
	macOnlyCnt=rset.getString(11);//MAC_ORDERS_CNT //ML-MMOH-CRF-1826
	
	if(dietType == null)
	dietType="";
	
	if(menuType == null)	//ML-MMOH-CRF-0902
	menuType="";
	
	//integer Conversion starts Here
	total_No_Of_Patients += Integer.parseInt(totalNoOfPatients);
	total_Orders +=Integer.parseInt(totalOrders);
	total_Orders_temp=Integer.parseInt(totalOrders);
	full_Nbm +=Integer.parseInt(fullNbm);	
	mac_Only +=Integer.parseInt(macOnlyCnt);	//ML-MMOH-CRF-1826
	total_Orders_Nbm =total_Orders+full_Nbm;
	//total_Orders_Nbm =total_Orders+full_Nbm+mac_Only; //ML-MMOH-CRF-1826 reverted
	
	//To Avoid Negative Values starts here
	if(total_No_Of_Patients == 0 || total_No_Of_Patients <= total_Orders_Nbm)
	pending_orders =0;
	else
	pending_orders =total_No_Of_Patients-total_Orders_Nbm;
	//To Avoid Negative Values Ends here
	attendant_Orders +=Integer.parseInt(attendantOrders);
	
	//Modified for Linked issue-63512 
	if(!dietType.equalsIgnoreCase(""))
       diet_Type_temp +=dietType+"-"+assignDietTypeCnt+",";
	if(isMenuType){
	if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +=menuType+"-"+assignMenuTypeCnt+",";	
	}
	else{
		if(!menuType.equalsIgnoreCase(""))	
		menu_Type_temp +="";	
	}
	//ML-MMOH-CRF-0902 ends here
	//integer Conversion Ends Here
	
	 totalNoOfPatients =""+total_No_Of_Patients;
         totalOrders= ""+total_Orders;
	 totalOrdersNbm=""+total_Orders_Nbm;
         fullNbm=""+full_Nbm;
         macOnlyCnt=""+mac_Only; //ML-MMOH-CRF-1826
         pendingorders =""+pending_orders;
	
	dietType=diet_Type_temp;
	menuType=menu_Type_temp;	//ML-MMOH-CRF-0902

	//For Last Record
	if(count == maxRecord)
	{	
		wardOrClinic_Value.add(wardOrClinicTemp);
		totalNoOfPatients_value.add(totalNoOfPatients);
		totalOrders_value.add(totalOrdersNbm);
		pendingorders_value.add(pendingorders);
		attendantOrders_value.add(attendantOrders);
		fullNbm_value.add(fullNbm);
		macOnlyCnt_value.add(macOnlyCnt); //ML-MMOH-CRF-1826
		dietType_value.add(dietType);		
		menuType_value.add(menuType);	//ML-MMOH-CRF-0902	
	}
	//For last Record Ends Here
	}	
	}//Count!=1 else 
	//Code Ends here for separation
}   

            _bw.write(_wl_block9Bytes, _wl_block9);

	if ( !(start <= 1) )
		out.println("<A HREF='../../eDS/jsp/DietOrderStatusQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&patient_Class="+patientClass+"&ward_Clinic_code="+ward_Clinic_code+"&ward_Clinic_Desc="+wardClinicDesc+"&serv_Date="+servDate+ "'" + " text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

	if ( !( (start+14) > wardOrClinic_Value.size() ) )
		out.println("<A HREF='../../eDS/jsp/DietOrderStatusQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&patient_Class="+patientClass+"&ward_Clinic_code="+ward_Clinic_code+"&ward_Clinic_Desc="+wardClinicDesc+"&serv_Date="+servDate+ "'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");

            _bw.write(_wl_block10Bytes, _wl_block10);
             org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setValue(locale 
);
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.fmt.SetLocaleTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Attendent_Label_Name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if(isMenuType) { 
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

    int m=0;//Count to Manage Next and Previous

	if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
    	m++;
		classValue= " ";
   while(m<wardOrClinic_Value.size() && m<end)
{
	if ( m % 2 == 0 )
		classValue = "QRYEVEN" ;  
			else
		classValue = "QRYODD" ;

		out.println("<td class='" + classValue+"' nowrap>"+wardOrClinic_Value.get(m)+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+totalNoOfPatients_value.get(m)+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+totalOrders_value.get(m)+"</td>");
		out.println("<td class='" + classValue+"' nowrap>"+pendingorders_value.get(m)+"</td>");
		if(wardClinicDesc.equalsIgnoreCase("Nursing Unit"))	
		{
			out.println("<td class='" + classValue+"' nowrap>"+attendantOrders_value.get(m)+"</td>");
			out.println("<td class='" + classValue+"' nowrap>"+fullNbm_value.get(m)+"</td>");
		}
		else
		{
			out.println("<td class='" + classValue+"' nowrap>NA</td>");
			out.println("<td class='" + classValue+"' nowrap>NA</td>");		
		}
		
		if(isMenuType){
		
		String menuType_arr[]=menuType_value.get(m).split(",");
		out.println("<td class='" + classValue+"' nowrap>");
	
		for(int y=0;y<menuType_arr.length;y++)
		{
		if(y!=0)
		{
			out.print(",<br>");
			out.print(menuType_arr[y]);
		}
		else
		{
		if(menuType_arr[y].equalsIgnoreCase(""))
			out.print("<br>");
		else
			out.print(menuType_arr[y]);
		}
		}
		out.println("</td>");
		
		}
	
		String dietType_arr[]=dietType_value.get(m).split(",");
		out.println("<td class='" + classValue+"' nowrap>");
			
	
		for(int y=0;y<dietType_arr.length;y++)
		{
		if(y!=0)
		{
			out.print(",<br>");
			out.print(dietType_arr[y]);
		}
		else
		{
		if(dietType_arr[y].equalsIgnoreCase(""))
			out.print("<br>");
		else
			out.print(dietType_arr[y]);
		}
		}
		out.println("</td>");
		out.println("</tr>");
		m++;
		}	

            _bw.write(_wl_block22Bytes, _wl_block22);

		if(stmt!=null)	stmt.close();
		if(stmt1!=null)	stmt1.close();
		if(rs!=null)	rs.close();
		if(rset!=null) rset.close();
		ConnectionManager.returnConnection(conn,request);
}
catch(Exception e)
{
    e.printStackTrace();
    System.err.println("452->DietOrderStatusQueryResult.jsp===>"+e.getMessage());
}

            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.WardOrClinicDesc.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.TotalNoOfPatients.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.TotalOrders.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PendingOrders.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Orders.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.AttendantOrders.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.FullNBM.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.MenuType.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eDS.DietType.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ds_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }
}
