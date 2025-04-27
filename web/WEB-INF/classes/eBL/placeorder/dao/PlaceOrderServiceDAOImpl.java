/* 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210324             15760          MOHE-SCF-0091                  Shikha Seth
 */
package eBL.placeorder.dao;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;



import webbeans.eCommon.ConnectionManager;


import eBL.Common.BlRepository;
import eBL.placeorder.model.BLChargePatientNewOrderBean;
import eBL.placeorder.model.BLChargePatientServiceDetailsBean;
import eBL.placeorder.request.PlaceNewOrderRequest;
import eBL.placeorder.response.PlaceNewOrderResponse;

/**
 * @author ravaradharajan
 * DAO Class which makes JDBC Calls to Get Service or Panel Details
 *
 */
public class PlaceOrderServiceDAOImpl implements PlaceOrderServiceDAO {
	
	/**
	 * Method used to retrieve all the Service Group
	 */

	public HashMap<String,String> getBlngServGroup(String locale){
		HashMap<String, String> blngServGroup = new HashMap<String,String>();
		PreparedStatement pstmt = null;
		Connection con = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_BLNG_SERV_LUKP"));
			pstmt.setString(1, locale);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					blngServGroup.put(rst.getString("SERV_GRP_CODE"), rst.getString("SHORT_DESC"));
				}
			}
			
		}
		catch(Exception e){
			System.err.println("Exception in getBlngServGroup ->"+e);
		}
		finally{
			ConnectionManager.returnConnection(con);
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in getBlngServGroup2"+e);
			}
			//added against checkstyle ends
		}
		return blngServGroup;
	}
	
	/**
	 * Method used to convert Date from String format to Date Format
	 * @param dateString
	 * @return
	 */
	private long getDateInLong(String dateString){ 
		
		if(dateString==null){
			return 0; 
		}
		else{
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Timestamp inputTimestamp = new Timestamp(sdf.parse(dateString).getTime());
				return inputTimestamp.getTime();
			} 
			catch (ParseException e) {
				System.err.println("Error in Input Date Format");
				e.printStackTrace();
			}
		}
		return 0;
	} 
	
	/**
	 * Method used to retrieve the Existing Orders for the Patient. 
	 * This Method will be called from BLChargePatientExisOrderServDetails.jsp
	 */
	@SuppressWarnings("rawtypes")
	public PlaceNewOrderResponse getServiceDetailsData(PlaceNewOrderRequest bean){
		Connection con = null;
		CallableStatement cstmt = null;
		ResultSet rst = null;
		LinkedHashMap serviceDeatils = null;
		Array listArray	=	null;
		BLChargePatientServiceDetailsBean 	bLChargePatientServiceDetailsBean	=	null; 
		PlaceNewOrderResponse response = new PlaceNewOrderResponse();
		ResourceBundle rb = null;
		Locale loc = null;
		try
		{
			loc = new Locale(bean.getLocale());
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			//System.out.println("In getPriceDetailsData:::: ");
			con = ConnectionManager.getConnection();
			serviceDeatils	=	new LinkedHashMap();
			String sql							=	"{ call   IBAEHIS.blplaceservice.get_existing_bl_serv_pkg_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cstmt 			= con.prepareCall(sql);
			
			cstmt.setString(1,bean.getFacilityId());						
			cstmt.setString(2, bean.getServGroupCode());			
			cstmt.setString(3,bean.getServClass());	
			cstmt.setString(4,bean.getServCode());		
			cstmt.setString(5,bean.getItemCode());		
			cstmt.setString(6,bean.getEntServGroup()); 	
			cstmt.setString(7,bean.getEntGrpLine()); 	

			if(bean.getFromDate().length()==0 || bean.getFromDate().equals("null"))		
				cstmt.setDate(8,null);
			else			
				cstmt.setDate(8,new Date(getDateInLong(bean.getFromDate())));
			

			if(bean.getToDate().length()==0 || bean.getToDate().equals("null") )		
				cstmt.setDate(9,null);
			else	
				cstmt.setDate(9,new Date(getDateInLong(bean.getToDate())));
			
		
			cstmt.setString(10,bean.getBilled_unbilled());		
			cstmt.setString(11,bean.getDirect_indirectchgs());			
			cstmt.setString(12,bean.getGroupLineService());
			cstmt.setString(13, bean.getEpisodeType());
			cstmt.setString(14, bean.getPatientId());
			cstmt.setString(15, bean.getEpisodeId());
			cstmt.setString(16, bean.getVisitId());	
			cstmt.setString(17, bean.getLocale());	

			cstmt.registerOutParameter(18, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(19, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(20, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(21, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(22, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(23, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(24, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			cstmt.registerOutParameter(25, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(26, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");  
			cstmt.registerOutParameter(27, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(28, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			
			cstmt.registerOutParameter(29, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(30, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(31, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(32, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(33, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(34, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			cstmt.registerOutParameter(35, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(36, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");  
			cstmt.registerOutParameter(37, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(38, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 			 
			cstmt.registerOutParameter(39, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(40, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(41, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(42, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(43, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(44, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			cstmt.registerOutParameter(45, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(46, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");  
			cstmt.registerOutParameter(47, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(48, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(49, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100"); 
			cstmt.registerOutParameter(50, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(51, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			cstmt.registerOutParameter(52, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER"); 
			cstmt.registerOutParameter(53, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			cstmt.registerOutParameter(54, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			cstmt.registerOutParameter(55, java.sql.Types.ARRAY, "BL_CMN_TYPE_DATE");
			cstmt.setString(56, bean.getProcessed());
			cstmt.registerOutParameter(57, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			cstmt.setString(58, bean.getUnderChrgOnly());
			cstmt.registerOutParameter(59, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.registerOutParameter(60, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.registerOutParameter(61, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.registerOutParameter(62, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.registerOutParameter(63, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.registerOutParameter(64, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.setString(65, bean.getLoginUser());
			cstmt.setInt(66, bean.getStartFrom());
			cstmt.setInt(67, bean.getEndWith());
			cstmt.registerOutParameter(68, java.sql.Types.INTEGER);
			
			
			cstmt.execute(); 
			
			for(int k=18;k<65;k++)
			{
				if(k != 56 && k != 58){
					
				
				Object[] values;
				listArray = cstmt.getArray (k); 
				if(listArray!=null){
					try{
						values = (Object[]) listArray.getArray(); 
					}
					catch(Exception e){
						values = null;
					}
					
				}
				else{
					values=null;
				}
	           
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {		           
			            if(serviceDeatils.containsKey(i))
		            	{
			            	bLChargePatientServiceDetailsBean = (BLChargePatientServiceDetailsBean) serviceDeatils.get(i);
		            		switch(k)
		            		{      				            				 		            		
			            		case 18: 	bLChargePatientServiceDetailsBean.setServGrpCode(((String)values[i]));
	    									break;
				    			case 19: 	bLChargePatientServiceDetailsBean.setServGrpDesc((String)values[i]);
											break;
				    			case 20:	bLChargePatientServiceDetailsBean.setLineCode((String)values[i]);
				    						break;
				    			case 21:	bLChargePatientServiceDetailsBean.setLineDesc((String)values[i]);
	    									break;
				    			case 22:	bLChargePatientServiceDetailsBean.setItemCode((String)values[i]);
	    									break;
				    			case 23:	bLChargePatientServiceDetailsBean.setItemDesc((String)values[i]);
	    									break;
				    			case 24: 	bLChargePatientServiceDetailsBean.setGrossAmt((BigDecimal)(values[i]));
											break;
				    			case 25: 	bLChargePatientServiceDetailsBean.setDiscAmt((BigDecimal)(values[i]));
											break;
				    			case 26: 	bLChargePatientServiceDetailsBean.setNetAmt((BigDecimal)(values[i]));
											break;
				    			case 27: 	bLChargePatientServiceDetailsBean.setBlngServCode((String)(values[i]));
											break;
				    			case 28: 	bLChargePatientServiceDetailsBean.setBlngServDesc((String)(values[i]));
											break;
				    			
											
				    			case 29: 	bLChargePatientServiceDetailsBean.setTrxDocRef((String)values[i]);
											break;
				    			case 30:	bLChargePatientServiceDetailsBean.setTrxDocRefLineNum((BigDecimal)(values[i]));
				    						break;
				    			case 31:	bLChargePatientServiceDetailsBean.setTrxDocRefSeqNum((BigDecimal)(values[i]));
											break;
				    			case 32:	bLChargePatientServiceDetailsBean.setPrimKeyLineNum((BigDecimal)(values[i]));
											break;
				    			case 33:	bLChargePatientServiceDetailsBean.setPrimKeyMain((String)values[i]);
											break;
				    			case 34: 	bLChargePatientServiceDetailsBean.setPrimKeyModId((String)(values[i]));
											break;
				    			case 35: 	bLChargePatientServiceDetailsBean.setConfirmedYn((String)(values[i]));
											break;
				    			case 36: 	bLChargePatientServiceDetailsBean.setServedpanelQty((BigDecimal)(values[i]));
											break;
				    			case 37: 	bLChargePatientServiceDetailsBean.setServQty((BigDecimal)(values[i]));
											break;
				    			case 38: 	bLChargePatientServiceDetailsBean.setPhysicianId((String)(values[i]));
											break;
				    			case 39: 	bLChargePatientServiceDetailsBean.setUomCode((String)values[i]);
											break;
				    			case 40:	bLChargePatientServiceDetailsBean.setPractStaffInd((String)values[i]);
				    						break;
				    			case 41:	bLChargePatientServiceDetailsBean.setInclExclInd((String)values[i]);
											break;
				    			case 42:	bLChargePatientServiceDetailsBean.setReason((String)values[i]);
											break;
				    			case 43:	bLChargePatientServiceDetailsBean.setRemarks((String)values[i]);
											break;
				    			case 44: 	bLChargePatientServiceDetailsBean.setDailyProcessInd((String)(values[i]));
											break;
				    			case 45: 	bLChargePatientServiceDetailsBean.setBedTypeCode((String)(values[i]));
											break;
				    			case 46: 	bLChargePatientServiceDetailsBean.setTokenSeriesCode((String)(values[i]));
											break;
				    			case 47: 	bLChargePatientServiceDetailsBean.setTokenSeriesNo((BigDecimal)(values[i]));
											break;
				    			case 48: 	bLChargePatientServiceDetailsBean.setDispLocn((String)(values[i]));
											break;											
				    			case 49: 	bLChargePatientServiceDetailsBean.setSecKeyMain((String)(values[i]));
											break;
				    			case 50: 	bLChargePatientServiceDetailsBean.setSecKeyLineNo((BigDecimal)(values[i]));
											break;
				    			case 51: 	bLChargePatientServiceDetailsBean.setServOrPanel((String)(values[i]));
											break;		
				    			case 52: 	bLChargePatientServiceDetailsBean.setBaseRate((BigDecimal)(values[i]));
											break;	
				    			case 53: 	bLChargePatientServiceDetailsBean.setRateIndicator((String)(values[i]));
											break;
				    			case 54: 	bLChargePatientServiceDetailsBean.setAdhocDiscount((BigDecimal)(values[i]));
											break;
				    			case 55: 	bLChargePatientServiceDetailsBean.setChargeDateTime((Timestamp)(values[i]));
											break;
				    			case 57: 	bLChargePatientServiceDetailsBean.setModuleId((String)(values[i]));
											break;
				    			case 59: 	bLChargePatientServiceDetailsBean.setPanelCode((String)(values[i]));
											break;
				    			case 60: 	bLChargePatientServiceDetailsBean.setPanelDesc((String)(values[i]));
											break;
				    			case 61: {
				    				bLChargePatientServiceDetailsBean.setPhysicianName((String)(values[i]));				    			
				    			System.out.println("here in if 61"+(String)(values[i]));
											break;		}
								case 62:{ 	
				    						bLChargePatientServiceDetailsBean.setErrorCode((String)(values[i]));
				    						if("BL9145".equals(bLChargePatientServiceDetailsBean.getErrorCode())){
				    							bLChargePatientServiceDetailsBean.setErrorCode("BL9146");
				    						}
				    						/*if(bLChargePatientServiceDetailsBean.getErrorCode() != null){
				    							try{
				    								bLChargePatientServiceDetailsBean.setErrorCode(rb.getString(bLChargePatientServiceDetailsBean.getErrorCode()));
				    							}
				    							catch(Exception rbException){
				    								bLChargePatientServiceDetailsBean.setErrorCode(getMessageString(bLChargePatientServiceDetailsBean.getErrorCode(),con));
				    								System.err.println("Exceprion in RB ->"+rbException);
				    							}
				    						}*/
		    						    						
		    							}				    			
	    									break;	
				    			case 63:{ 	
				    						bLChargePatientServiceDetailsBean.setWarningMessage((String)(values[i]));
				    						/*if(bLChargePatientServiceDetailsBean.getWarningMessage() != null){
				    							try{
				    								bLChargePatientServiceDetailsBean.setWarningMessage(rb.getString(bLChargePatientServiceDetailsBean.getWarningMessage()));
				    							}
				    							catch(Exception rbException){
				    								bLChargePatientServiceDetailsBean.setWarningMessage(getMessageString(bLChargePatientServiceDetailsBean.getWarningMessage(),con));
				    								System.err.println("Exceprion in RB ->"+rbException);
				    							}
				    						}*/
		    						    						
		    							}				    			
	    									break;	
				    			case 64: 	bLChargePatientServiceDetailsBean.setaddedBy((String)(values[i]));
								break;		
								default:	
		    				}
		            	}
		            	else
		            	{	
		            		bLChargePatientServiceDetailsBean = new BLChargePatientServiceDetailsBean();
		            		switch(k)
		            		{
		            		
		            		case 18: 	bLChargePatientServiceDetailsBean.setServGrpCode(((String)values[i]));
										break;
		            		case 19: 	bLChargePatientServiceDetailsBean.setServGrpDesc((String)values[i]);
										break;
		            		case 20:	bLChargePatientServiceDetailsBean.setLineCode((String)values[i]);
			    						break;
			    			case 21:	bLChargePatientServiceDetailsBean.setLineDesc((String)values[i]);
										break;
			    			case 22:	bLChargePatientServiceDetailsBean.setItemCode((String)values[i]);
										break;
			    			case 23:	bLChargePatientServiceDetailsBean.setItemDesc((String)values[i]);
										break;
		            		case 24: 	bLChargePatientServiceDetailsBean.setGrossAmt((BigDecimal)(values[i]));
										break;
		            		case 25: 	bLChargePatientServiceDetailsBean.setDiscAmt((BigDecimal)(values[i]));
										break;
		            		case 26: 	bLChargePatientServiceDetailsBean.setNetAmt((BigDecimal)(values[i]));
										break;
		            		case 27: 	bLChargePatientServiceDetailsBean.setBlngServCode((String)(values[i]));
										break;
		            		case 28: 	bLChargePatientServiceDetailsBean.setBlngServDesc((String)(values[i]));
										break;
		            		
		            		case 29: 	bLChargePatientServiceDetailsBean.setTrxDocRef((String)values[i]);
										break;
			    			case 30:	bLChargePatientServiceDetailsBean.setTrxDocRefLineNum((BigDecimal)(values[i]));
			    						break;
			    			case 31:	bLChargePatientServiceDetailsBean.setTrxDocRefSeqNum((BigDecimal)(values[i]));
										break;
			    			case 32:	bLChargePatientServiceDetailsBean.setPrimKeyLineNum((BigDecimal)(values[i]));
										break;
			    			case 33:	bLChargePatientServiceDetailsBean.setPrimKeyMain((String)values[i]);
										break;
			    			case 34: 	bLChargePatientServiceDetailsBean.setPrimKeyModId((String)(values[i]));
										break;
			    			case 35: 	bLChargePatientServiceDetailsBean.setConfirmedYn((String)(values[i]));
										break;
			    			case 36: 	bLChargePatientServiceDetailsBean.setServedpanelQty((BigDecimal)(values[i]));
										break;
			    			case 37: 	bLChargePatientServiceDetailsBean.setServQty((BigDecimal)(values[i]));
										break;
			    			case 38: 	bLChargePatientServiceDetailsBean.setPhysicianId((String)(values[i]));
										break;
			    			case 39: 	bLChargePatientServiceDetailsBean.setUomCode((String)values[i]);
										break;
			    			case 40:	bLChargePatientServiceDetailsBean.setPractStaffInd((String)values[i]);
			    						break;
			    			case 41:	bLChargePatientServiceDetailsBean.setInclExclInd((String)values[i]);
										break;
			    			case 42:	bLChargePatientServiceDetailsBean.setReason((String)values[i]);
										break;
			    			case 43:	bLChargePatientServiceDetailsBean.setRemarks((String)values[i]);
										break;
			    			case 44: 	bLChargePatientServiceDetailsBean.setDailyProcessInd((String)(values[i]));
										break;
			    			case 45: 	bLChargePatientServiceDetailsBean.setBedTypeCode((String)(values[i]));
										break;
			    			case 46: 	bLChargePatientServiceDetailsBean.setTokenSeriesCode((String)(values[i]));
										break;
			    			case 47: 	bLChargePatientServiceDetailsBean.setTokenSeriesNo((BigDecimal)(values[i]));
										break;
			    			case 48: 	bLChargePatientServiceDetailsBean.setDispLocn((String)(values[i]));
										break;											
			    			case 49: 	bLChargePatientServiceDetailsBean.setSecKeyMain((String)(values[i]));
										break;
			    			case 50: 	bLChargePatientServiceDetailsBean.setSecKeyLineNo((BigDecimal)(values[i]));
										break;
			    			case 51: 	bLChargePatientServiceDetailsBean.setServOrPanel((String)(values[i]));
										break;
			    			case 52: 	bLChargePatientServiceDetailsBean.setBaseRate((BigDecimal)(values[i]));
										break;	
			    			case 53: 	bLChargePatientServiceDetailsBean.setRateIndicator((String)(values[i]));
										break;
			    			case 54: 	bLChargePatientServiceDetailsBean.setAdhocDiscount((BigDecimal)(values[i]));
										break;
			    			case 55: 	bLChargePatientServiceDetailsBean.setChargeDateTime((Timestamp)(values[i]));
										break;
			    			case 57: 	bLChargePatientServiceDetailsBean.setModuleId((String)(values[i]));
										break;
			    			case 59: 	bLChargePatientServiceDetailsBean.setPanelCode((String)(values[i]));
										break;
			    			case 60: 	bLChargePatientServiceDetailsBean.setPanelDesc((String)(values[i]));
										break;
			    			case 61: 	bLChargePatientServiceDetailsBean.setPhysicianName((String)(values[i]));			    			
			    						break;	
			    			case 62:{ 	
					    				if("BL9145".equals(bLChargePatientServiceDetailsBean.getErrorCode())){
			    							bLChargePatientServiceDetailsBean.setErrorCode("BL9146");
			    						}
			    						/*if(bLChargePatientServiceDetailsBean.getErrorCode() != null){
			    							try{
			    								bLChargePatientServiceDetailsBean.setErrorCode(rb.getString(bLChargePatientServiceDetailsBean.getErrorCode()));
			    							}
			    							catch(Exception rbException){
			    								bLChargePatientServiceDetailsBean.setErrorCode(getMessageString(bLChargePatientServiceDetailsBean.getErrorCode(),con));
			    								System.err.println("Exceprion in RB ->"+rbException);
			    							}
			    						}*/
			    						    						
			    					}	
										break;	
			    			case 63:{ 	
			    						bLChargePatientServiceDetailsBean.setWarningMessage((String)(values[i]));
			    						/*if(bLChargePatientServiceDetailsBean.getWarningMessage() != null){
			    							try{
			    								bLChargePatientServiceDetailsBean.setWarningMessage(rb.getString(bLChargePatientServiceDetailsBean.getWarningMessage()));
			    							}
			    							catch(Exception rbException){
			    								bLChargePatientServiceDetailsBean.setWarningMessage(getMessageString(bLChargePatientServiceDetailsBean.getWarningMessage(),con));
			    								System.err.println("Exceprion in RB ->"+rbException);
			    							}
			    						}*/
								    						
									}				    			
										break;
			    			case 64: {	bLChargePatientServiceDetailsBean.setaddedBy((String)(values[i]));
			    			System.out.println("(String)(values[i])="+(String)(values[i])+"-i="+i);
			    			}
							break;
							default:	
		    				}
		            		serviceDeatils.put(i, bLChargePatientServiceDetailsBean);
		            	}
		            }    
				}     
	        }
	            
			}   
			response.setTotalRecordCount(cstmt.getInt(68));
			
		}catch(Exception e){
			System.out.println("Exception in getPriceDetailsData in bLChargePatientServiceDetailsBean=>>>>>>>><<<<<<<<,BEANNN>>>>>>>> "+e); 
			e.printStackTrace();
		}
		finally
		{
				response.setExistingServiceDetails(serviceDeatils);
				cstmt = null;
				if(con!=null) ConnectionManager.returnConnection(con);
				
		}

		
		return response;
	}
	
	/**
	 * Method retrieves the List of Billing Service Group
	 */
	public HashMap<String,String> getServiceGroup(String locale){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		HashMap<String,String> serviceGroupMap = new HashMap<String, String>();
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("CP_SERVICE_GROUP"));
			pstmt.setString(1, locale);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					serviceGroupMap.put(rst.getString("CODE"), rst.getString("description"));
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in BLChargePatientNewOrderBean -> "+e);
		}
		finally{
			pstmt = null;
			rst = null;
			if(con!=null){
				ConnectionManager.returnConnection(con);
			}
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in getServiceGroup"+e);
			}
			//added against checkstyle ends
		}
		return serviceGroupMap;
	}
	
	/**
	 * Method Retrieves the Service List or Panel List.
	 * Used for Placing New Order.
	 * Called from BLChargePatientNewOrderDetails.jsp
	 */
	public PlaceNewOrderResponse getServicePkgDtls(PlaceNewOrderRequest chargeBean){
		Connection con = null;
		CallableStatement cstmt = null;
		Array listArray	= null;
		LinkedHashMap serviceDtlsMap = new LinkedHashMap();
		PlaceNewOrderResponse response = new PlaceNewOrderResponse();
		BLChargePatientNewOrderBean bean = new BLChargePatientNewOrderBean();
		//String strPanel = ""; commented against checkstyle
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall("{ call   blplaceservice.get_bl_serv_pkg_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	//V210324 ADDED
//			cstmt = con.prepareCall("{ call   blplaceservice.get_bl_serv_pkg_dtls(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }");	//V210324 COMMENTED
			cstmt.setString(1,chargeBean.getFacilityId());
			cstmt.setString(2,chargeBean.getServGroupCode());
			cstmt.setString(3,chargeBean.getServClass());
			cstmt.setString(4,chargeBean.getServPanelCode());
			cstmt.setString(5,chargeBean.getServPanelDesc());
			cstmt.setString(6,"S");
			if("P".equals(chargeBean.getServOrPanel())){
				cstmt.setString(7,"N");
				cstmt.setString(8,"Y");
			}
			else{
				cstmt.setString(7,"Y");
				cstmt.setString(8,"N");
			}			
			cstmt.setString(9,"N");
			cstmt.setInt(10, chargeBean.getStartFrom());
			cstmt.setInt(11, chargeBean.getEndWith());
			cstmt.registerOutParameter(12, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(13, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			cstmt.registerOutParameter(14, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR100");
			cstmt.registerOutParameter(15, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");			
			cstmt.registerOutParameter(16, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			cstmt.registerOutParameter(17, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(18, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10");
			cstmt.registerOutParameter(19, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(20, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(21, java.sql.Types.ARRAY, "BL_CMN_TYPE_VARCHAR10"); 
			cstmt.registerOutParameter(22, java.sql.Types.ARRAY, "BL_CMN_TYPE_NUMBER");
			cstmt.registerOutParameter(23,Types.INTEGER);
		    cstmt.setString(24,chargeBean.getLocale());//V210324
		    cstmt.setString(25,chargeBean.getLoginUser());//V210324
			cstmt.execute(); 
			for(int k=12;k<23;k++)
			{
				listArray = cstmt.getArray (k);  
	            Object[] values = (Object[]) listArray.getArray(); 	        
	            if(values!=null)
	            {
	            	for (int i=0; i < values.length; i++)                 
		            {
		           
			            if(serviceDtlsMap.containsKey(i))
		            	{
			            	bean = (BLChargePatientNewOrderBean) serviceDtlsMap.get(i);
		            		switch(k)
		            		{
			            		case 12: 	bean.setServOrPanel(((String)values[i]));
	    									break;
				    			case 13: 	bean.setBlngServCode((String)values[i]);
											break;
				    			case 14: 	bean.setBlngServDesc((String)values[i]);
											break;
				    			case 15: 	bean.setRateIndicator((String)values[i]);
											break;				    				
				    			case 16: 	bean.setBasePrice((BigDecimal)values[i]);
											break;
				    			case 17: 	bean.setPrintGroup((String)values[i]);
											break;
				    			case 18: 	bean.setPrintLine((String)values[i]);
											break;
				    			case 19: 	bean.setDirEntry((String)values[i]);
											break;
				    			case 20: 	bean.setDrFee((String)values[i]);
											break;
				    			case 21: 	bean.setMiscServ((String)values[i]);
											break;
				    			case 22: 	bean.setMinimumAmt((BigDecimal)values[i]);
											break;
				    							
								default:	
		    				}
		            	}
		            	else
		            	{	
		            		bean = new BLChargePatientNewOrderBean();
		            		switch(k)
		            		{
			            		case 12: 	bean.setServOrPanel(((String)values[i]));
											break;
				    			case 13: 	bean.setBlngServCode((String)values[i]);
											break;
				    			case 14: 	bean.setBlngServDesc((String)values[i]);
											break;
				    			case 15: 	bean.setRateIndicator((String)values[i]);
											break;				    		
				    			case 16: 	{
				    			//	System.out.println("here in else 16"+(String)(values[i]));
				    				bean.setBasePrice((BigDecimal)values[i]);				    								    			
				    						break;
				    			}
				    			case 17: 	bean.setPrintGroup((String)values[i]);
											break;
				    			case 18: 	bean.setPrintLine((String)values[i]);
											break;
				    			case 19: 	bean.setDirEntry((String)values[i]);
											break;
				    			case 20: 	bean.setDrFee((String)values[i]);
											break;
				    			case 21: 	bean.setMiscServ((String)values[i]);
											break;
				    			case 22: 	bean.setMinimumAmt((BigDecimal)values[i]);
											break;				
								default:	
		    				}
		            		serviceDtlsMap.put(i, bean);
		            	}
		            }    
				}     
	        }
			response.setTotalRecordCount(cstmt.getInt(23));
			
		}
		catch(Exception e){
			System.err.println("Exception happened in getting Results -> "+e);
		}
		finally{
			response.setNewServiceDetails(serviceDtlsMap);
			cstmt = null;
			if(con!=null){
				ConnectionManager.returnConnection(con);
			}
			//added against checkstyle starts
			try{
				 if(cstmt!=null) cstmt.close();
			   }
			catch(Exception e)
			{
				System.err.println("Exception in getServicePkgDtls"+e);
			}
			//added against checkstyle ends
		}
		return response;
	}

	/**
	 * Method Sends the Details for a Service or Panel. 
	 * This is Executed once user clicks the Service / Panel.
	 * Calls orginates from Ajax request BLChargePatientNewOrderPersistence.jsp
	 */
	public PlaceNewOrderResponse getServiceDetails(PlaceNewOrderRequest chargeBean) {
		Connection con = null;
		CallableStatement cstmt = null;
		PlaceNewOrderResponse responseBean = new PlaceNewOrderResponse();
		BLChargePatientNewOrderBean bean = new BLChargePatientNewOrderBean();
		String str_error_level = "", str_sysmesage_id="", str_error_text="";
		ResourceBundle rb = null;
		Locale loc = null;
		List<String> errorList = null;
		Calendar cal = Calendar.getInstance();
		java.util.Date dt = cal.getTime();
		try{
			con = ConnectionManager.getConnection();
			String serviceQuery = "{call blplaceservice.populate_charge_bl_serv_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			//String panelQuery = "{call blplaceservice_1.populate_charge_bl_panel(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";

			
			cstmt = con.prepareCall(serviceQuery);
			
			cstmt.setString(1, chargeBean.getFacilityId());
			cstmt.setString(2, "BL");
			cstmt.setString(3, chargeBean.getEpisodeType());
			cstmt.setString(4, chargeBean.getPatientId());
			cstmt.setString(5, chargeBean.getEpisodeId());
			cstmt.setString(6, chargeBean.getVisitId());
			cstmt.setString(7, chargeBean.getEncounterId());
			cstmt.setString(8, chargeBean.getAcctSeqNo());
			cstmt.setDate(9, new Date(dt.getTime()));

			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.VARCHAR);
			cstmt.registerOutParameter(14, Types.VARCHAR);
			cstmt.setString(15,null);
			cstmt.setString(16,chargeBean.getServOrPanel());
			/*if("L".equals(chargeBean.getServOrPanel())){
				strPanel = orderDao.getPanelStr(chargeBean.getServPanelCode(), con);
				cstmt.setString(17,strPanel);		
			}
			else{*/
				cstmt.setString(17,chargeBean.getServPanelCode());
			//}		
			cstmt.setString(18,chargeBean.getQuantity());
			cstmt.setString(19,null);
			cstmt.registerOutParameter(20, Types.INTEGER);
			cstmt.registerOutParameter(21, Types.INTEGER);
			cstmt.registerOutParameter(22, Types.INTEGER);
			cstmt.registerOutParameter(23, Types.INTEGER);
			cstmt.registerOutParameter(24, Types.INTEGER);
			cstmt.registerOutParameter(25, Types.INTEGER);
			cstmt.registerOutParameter(26, Types.INTEGER);
			cstmt.registerOutParameter(27, Types.INTEGER);
			cstmt.registerOutParameter(28, Types.INTEGER);
			cstmt.registerOutParameter(29, Types.INTEGER);
			
			cstmt.registerOutParameter(30, Types.INTEGER);
			cstmt.registerOutParameter(31, Types.INTEGER);
			cstmt.registerOutParameter(32, Types.INTEGER);
			cstmt.registerOutParameter(33, Types.INTEGER);
			cstmt.registerOutParameter(34, Types.VARCHAR);			
			cstmt.registerOutParameter(35, Types.VARCHAR);
			cstmt.registerOutParameter(36, Types.INTEGER);
			cstmt.registerOutParameter(37, Types.VARCHAR);
			cstmt.registerOutParameter(38, Types.VARCHAR);
			cstmt.registerOutParameter(39, Types.VARCHAR);
			cstmt.registerOutParameter(40, Types.VARCHAR);
			cstmt.registerOutParameter(41, Types.INTEGER);
			cstmt.setString(42,chargeBean.getLocale());
			cstmt.registerOutParameter(43, Types.VARCHAR);
			cstmt.setString(44,"P");
			System.out.println("chargeBean.getSplDepChkYn() in ejb"+chargeBean.getSplDepChkYn());
			if("".equals(chargeBean.getSplDepChkYn()) || chargeBean.getSplDepChkYn()==null)
			{
				System.out.println("in if");
				cstmt.setString(45,null);
			}
			else
			{
				cstmt.setString(45,chargeBean.getSplDepChkYn());		
						System.out.println("else");
			}
			cstmt.registerOutParameter(45, Types.VARCHAR);
			cstmt.registerOutParameter(46, Types.VARCHAR);
			cstmt.registerOutParameter(47, Types.VARCHAR);
			cstmt.registerOutParameter(48, Types.INTEGER);
			cstmt.registerOutParameter(49, Types.INTEGER);
			cstmt.setString(50,chargeBean.getLoginUser());
			cstmt.registerOutParameter(51, Types.VARCHAR);
			cstmt.registerOutParameter(52, Types.VARCHAR);
			cstmt.registerOutParameter(53, Types.VARCHAR);
			cstmt.registerOutParameter(54, Types.VARCHAR);

			cstmt.execute();			
			
			bean.setBlngServCode(chargeBean.getServPanelCode());
			bean.setBlngServDesc(chargeBean.getServPanelDesc());
			bean.setServOrPanel(chargeBean.getServOrPanel());
			bean.setRateIndicator(chargeBean.getRateIndicator());
			
			//bean.setRateIndicator(cstmt.getString(10));
			bean.setQuantity(cstmt.getString(20));
			bean.setRate(cstmt.getString(21));
			bean.setAddlCharges(cstmt.getString(22));
			bean.setBaseChargeAmt(cstmt.getString(23));
			bean.setGrossAmount(cstmt.getString(24));
			bean.setServDiscount(cstmt.getString(25));
			
			bean.setServDiscPerc(cstmt.getString(27));
			bean.setPatGrossChargeAmt(cstmt.getString(28));
			bean.setPatDiscAmt(cstmt.getString(29));
			
			bean.setCustGrossChargeAmt(cstmt.getString(31));
			bean.setCustDiscAmt(cstmt.getString(32));
			bean.setCustNetChargeAmt(cstmt.getString(33));
			bean.setSpiltInd(cstmt.getString(34));
			bean.setUomCode(cstmt.getString(35));
			bean.setCurrAvailed(cstmt.getString(36));
			bean.setCreditAuthRef(cstmt.getString(37));
			bean.setPolicyIncl(cstmt.getString(38));
			bean.setOrgIncl(bean.getPolicyIncl());
			bean.setOverrideInd(cstmt.getString(39));
			bean.setPreAppYn(cstmt.getString(40));
			bean.setPatPaidAmt(cstmt.getString(41));
			bean.setPanelString(cstmt.getString(43));
			bean.setDrName(cstmt.getString(45));
			bean.setEditPanel(cstmt.getString(46));
			
			if("S".equalsIgnoreCase(chargeBean.getServOrPanel())){
				bean.setNetChargeAmount(cstmt.getString(26));
				bean.setPatNetChargeAmt(cstmt.getString(30));
			}
			else{
				bean.setNetChargeAmount(cstmt.getString(48));
				bean.setPatNetChargeAmt(cstmt.getString(49));
			}
			bean.setPractStaffType(cstmt.getString(51));
			
			str_error_level = cstmt.getString(52);
			str_sysmesage_id = cstmt.getString(53);
			str_error_text = cstmt.getString(54);
			
			System.err.println("str_error_level"+str_error_level);
			System.err.println("str_sysmesage_id"+str_sysmesage_id);
			System.err.println("str_error_text"+str_error_text);
			loc = new Locale(chargeBean.getLocale());
			rb = ResourceBundle.getBundle("eBL.resources.Messages",loc);
			
			errorList = new ArrayList<String>();

			if(str_error_level!=null || str_error_text!=null){
				errorList.add(str_error_text);
			}
						
			if(str_sysmesage_id!=null){
				if(str_sysmesage_id.contains("|")){
					String msgArr[] = str_sysmesage_id.split("\\|");
					for(int l=0;l<msgArr.length;l++){
						
						try{
							msgArr[l] = rb.getString(msgArr[l]);
						}
						catch(Exception rbException){
							msgArr[l] = getMessageString(msgArr[l],con);
							System.err.println("Exceprion in RB ->"+rbException);
						}
						
						errorList.add(msgArr[l]);
					}
				}else{
					
					try{
						str_sysmesage_id = rb.getString(str_sysmesage_id);
					}
					catch(Exception rbException){
						str_sysmesage_id = getMessageString(str_sysmesage_id,con);
						System.err.println("Exceprion in RB ->"+rbException);
					}
					errorList.add(str_sysmesage_id);					
				}
			}
			
			if(bean.getDrName() != null && !"".equals(bean.getDrName())){
				PreparedStatement pstmtDr = con.prepareStatement("select NAME FROM BL_AM_PRACT_STAFF_VW WHERE PRACTITIONER_ID = ? and FACILITY_ID = ? and UPPER(LANGUAGE_ID) = UPPER('en') ");
				ResultSet rstDr = null;
				pstmtDr.setString(1,bean.getDrName());
				pstmtDr.setString(2,chargeBean.getFacilityId());
				rstDr = pstmtDr.executeQuery();
				if(rstDr!=null && rstDr.next()){
					bean.setPhysicianName(rstDr.getString("NAME"));
				}
				rstDr = null;
				pstmtDr = null;
				if(pstmtDr!=null) pstmtDr.close();
				 if(rstDr!=null) rstDr.close();
			}
			
		}
		catch(Exception e){
			System.err.println("Exception happened in getting Results -> "+e);
		}
		finally{
			responseBean.setErrorList(errorList);
			responseBean.setNewOrderBean(bean);
			cstmt = null;
			if(con!=null){
				ConnectionManager.returnConnection(con);
			}
			//added against checkstyle starts
			try{
				 if(cstmt!=null) cstmt.close();
				 /*if(pstmtDr!=null) pstmtDr.close();
				 if(rstDr!=null) rstDr.close();*/
			   }
			catch(Exception e)
			{
				System.err.println("Exception in getServiceDetails"+e);
			}
			//added against checkstyle ends
		}
		return responseBean;
	}
	
	public List<BLChargePatientServiceDetailsBean> getFutureOrder(){
		List<BLChargePatientServiceDetailsBean> futureList = null;
		try{
			//con = ConnectionManager.getConnection();
		}
		catch(Exception e){
			
		}
		finally{
			
		}
		return futureList;
	}
	
	public String[] getPrivilege(String user, String facility){
		String[] privilege = new String[2];
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		try{
			con = ConnectionManager.getConnection();
			pstmt = con.prepareStatement(BlRepository.getBlKeyValue("GET_PRIV_FOR_CANCEL"));
			pstmt.setString(1, facility);
			pstmt.setString(2, user);
			rst = pstmt.executeQuery();
			if(rst != null){
				while(rst.next()){
					privilege[0] = rst.getString("CANCEL_INDIRECT_SERV_YN");
					privilege[1] = rst.getString("CANCEL_SELF_ENTERED_SRVC_ONLY");
				}
			}
		}
		catch(Exception e){
			System.err.println("Exception in getPrivilege -> "+e);
		}
		finally{
			pstmt = null;
			rst = null;
			if(con!=null){
				ConnectionManager.returnConnection(con);
			}
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in getPanelStr"+e);
			}
			//added against checkstyle ends
		}
		return privilege;
	}
	
	public String replaceNull(String input){
		if(input == null || "null".equals(input)){
			input = "";
		}
		return input;
	}
	
	public String[] getPrivilegeForUser(String user, String facility){
		String[] privilege = new String[11];
		Connection con = null;
		CallableStatement cstmt = null;
		try{
			con = ConnectionManager.getConnection();
			cstmt = con.prepareCall(BlRepository.getBlKeyValue("GET_PRIVILEGE_FOR_USER"));
			cstmt.setString(1, facility);
			cstmt.setString(2, user);
			cstmt.registerOutParameter(3, Types.VARCHAR);
			cstmt.registerOutParameter(4, Types.VARCHAR);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.registerOutParameter(6, Types.VARCHAR);
			cstmt.registerOutParameter(7, Types.VARCHAR);
			cstmt.registerOutParameter(8, Types.VARCHAR);
			cstmt.registerOutParameter(9, Types.VARCHAR);
			cstmt.registerOutParameter(10, Types.VARCHAR);
			cstmt.registerOutParameter(11, Types.VARCHAR);
			cstmt.registerOutParameter(12, Types.VARCHAR);
			cstmt.registerOutParameter(13, Types.VARCHAR);

			cstmt.execute();
			privilege[0] = cstmt.getString(3);
			privilege[1] = cstmt.getString(4);
			privilege[2] = cstmt.getString(5);
			privilege[3] = cstmt.getString(6);
			privilege[4] = cstmt.getString(7);
			privilege[5] = cstmt.getString(8);
			privilege[6] = cstmt.getString(9);
			privilege[7] = cstmt.getString(10);
			privilege[8] = cstmt.getString(11);
			privilege[9] = cstmt.getString(12);
			privilege[10] = cstmt.getString(13);
			
			
		}
		catch(Exception e){
			System.err.println("Exception in getPrivilege -> "+e);
		}
		finally{
			cstmt = null;
			if(con!=null){
				ConnectionManager.returnConnection(con);
			}
			//added against checkstyle starts
			try{
				if(cstmt!=null) cstmt.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in getPanelStr"+e);
			}
			//added against checkstyle ends
		}
		return privilege;
	}
	
	public String getMessageString(String messageId, Connection con) {
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String output = "";
		String messageQuery = "select message_text_sysdef from sm_message where message_id = ?";
		try{
			pstmt = con.prepareStatement(messageQuery);
			pstmt.setString(1, messageId);
			rst = pstmt.executeQuery();
			if(rst != null && rst.next()){
				output = messageId+"-"+rst.getString("message_text_sysdef");
			}						
			
		}
		catch(Exception e){
			System.err.println("Exception in getting Message String ->"+e);
			output = messageId;
		}
		finally{
			pstmt = null;
			rst = null;
			//added against checkstyle starts
			try{
				if(pstmt!=null) pstmt.close();
				if(rst!=null) rst.close();
			}
			catch(Exception e)
			{
				System.err.println("Exception in getPanelStr"+e);
			}
			//added against checkstyle ends
			
		}
		return output;
	}	

}
