
 <%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
03/09/2020      IN073899            Haribabu                                MMS-DM-CRF-0174.2
---------------------------------------------------------------------------------------------------------
*/
%>
 <%@page import="java.util.*, eST.Common.*, eST.*,java.sql.*,java.text.NumberFormat,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale					=		(String)session.getAttribute("LOCALE");

	ChangeExpiryFlagBean bean		=		(ChangeExpiryFlagBean)getBeanObject( "ChangeExpiryFlagBean","eST.ChangeExpiryFlagBean",request ) ;  
	bean.setLanguageId(locale);

	String item_code				=		request.getParameter("item_code");
	String validate					=		request.getParameter("validate");
	String qty						=		"";
	String message					=		"";
	String flag						=		"INVALID_VALIDATE_FLAG";
	boolean	result					=		false;
	int no_of_decimals              =       0;
	try {
		if (validate.equals("QOH")) {

			flag					=		"";
			try{
				String expiry_yn = bean.checkForNull((String)request.getParameter("expiry_yn"),"N");
				bean.setItem_code(item_code);
				bean.setExpiry_yn(expiry_yn);
				bean.loadData();

				ArrayList alParameters	=		new ArrayList(1);
				alParameters.add(item_code);
				alParameters.add(bean.getLanguageId());
				alParameters.add(bean.getLoginFacilityId());

				HashMap hmRecord		=		new HashMap();
				try {
					hmRecord			=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_QOH"),alParameters);
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
				qty						=		(String)hmRecord.get("QTY" )	;
				
				/**
				* @Name - Suri
				* @Date - 19/01/2010
				* @Inc# - IN015496
				* @Desc - Code added to accept decimal values dynamically.
				* @ getAllowDecimalsYN() return's 'Y' that accept decimal values dynamically.other wise it should not accept decimal values dynamically. 
			   */

				if((bean.getAllowDecimalsYN(item_code)).equals("Y"))
					no_of_decimals=bean.getNoOfDecimals();
				else
					no_of_decimals=0;
				out.println("setQty(\""+bean.setNumber((bean.checkForNull(qty,"0")),no_of_decimals)+"\");");

				hmRecord				=		new HashMap();
				try {
					   hmRecord			=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_PH_ASSOCIATION_CHECK"));
					}
					catch(Exception ex) {
						ex.printStackTrace();
					}
              
               /* Commented by Rabbani #Inc no :50968 on 11-09-2014 Starts
			   String PHinstalled		=		"";
                PHinstalled				=		(String)hmRecord.get("INSTALL_YN");
				PHinstalled				=		PHinstalled.trim();
        
                hmRecord				=		new HashMap();
				String stPHAssocaited	=		"N" ;

                if( PHinstalled.equals("Y") )
				{ 
						try {
							 hmRecord	=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_ASSOCIATED_WITH_PH_COUNT"),item_code);
						}
						catch(Exception ex) {
							ex.printStackTrace();
						}
						String count	=		"";
						count			=		(String)hmRecord.get("COUNT" )	;
						count			=		count.trim();
						if( ! count.equals("0") ) 
						{
							stPHAssocaited =	"Y" ;
						}						
			      }
				  out.println("setFlagForPHAssoc(\""+stPHAssocaited+"\");"); ends*/
                  result				=		true;
			}
			catch(Exception exception) {
				exception.printStackTrace();
				flag					=		"INVALID_ITEM_CODE";
				result					=		false;
							}
		}
		else if(validate.equals("EXPIRY")) {
			String expiry_yn			=		request.getParameter("expiry_yn");
			bean.setExpiry_yn(expiry_yn);
		}
		else if(validate.equals("BATCH_DETAILS")) {
			Hashtable hash				=		(Hashtable) XMLobj.parseXMLString(request);
		    hash						=		(Hashtable) hash.get ("SEARCH");
			String date					=		"";
			int batchCount				=		Integer.parseInt(request.getParameter("batchCount"));
			
			bean.setBatchReload(bean.checkForNull((String)request.getParameter("batchchange")));
			bean.setALBatchChangedData(hash);
			for(int i=0;i<batchCount;i++) {
				date=(String)hash.get("expiry_date_or_receipt_date"+i);
				bean.updateBatchDetails(i,date);
			}  			
		}
		else if(validate.equals("BARCODE")) {//Added for GHL-CRF-0413 starts
			String barcode			=		request.getParameter("barcode");
			String item_code1="";
			String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
			try{
				if(barcode_2d_applicable_yn.equals("Y")){//Adding start for MMS-DM-CRF-0174.6
					 item_code1  =bean.get2DBarcodeItem("",barcode);
				}else{//Adding end for MMS-DM-CRF-0174.6
				     item_code1=	(String)bean.fetchRecord("select item_code from st_item_batch where barcode_id =?",new String[]{barcode}).get("ITEM_CODE");
				item_code1 = bean.checkForNull(item_code1, "");
				}
				String item_desc1=	(String)bean.fetchRecord("select short_desc from mm_item where item_code =?",new String[]{item_code1}).get("SHORT_DESC");
				item_desc1 = bean.checkForNull(item_desc1, "");
				//Added for IN:073899 start
				if(!item_desc1.equals("")&&item_desc1!=null){
					item_desc1=item_desc1.replaceAll(" ","%20");
					item_desc1=	java.net.URLEncoder.encode(item_desc1,"UTF-8");
					item_desc1=item_desc1.replaceAll("%2520","%20");
				}
				//Added for IN:073899 start
				if(item_desc1.length() <= 0){
					result = false;
				}
				else
					result = true;
				out.println("document.getElementById('item_desc').value = decodeURIComponent('"+item_desc1+"');");//Modified for IN:073899 
				out.println("document.getElementById('item_code').value = '"+item_code1+"'");//Modified for IN:073900
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}//Added for GHL-CRF-0413 ends
	}
	catch (Exception exception){
		result	=	false;
		message	=	exception.getMessage(); 
	}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("ChangeExpiryFlagBean",bean,request);
%>
