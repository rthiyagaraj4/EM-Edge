/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOR;

import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.*;

public class OrClassLoaderServlet extends javax.servlet.http.HttpServlet
{
  	public void doPost(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException
	{
		//HttpSession session = request.getSession(false);
		 
		try{
				// Functional Beans
				eOR.Common.OrRepository				OrBean1		= new  eOR.Common.OrRepository();
				eOR.Common.AccessRightBean			OrBean2		= new  eOR.Common.AccessRightBean();
				eOR.Common.OrRepositoryExt			OrBean3		= new  eOR.Common.OrRepositoryExt();
				eOR.OrderType						OrBean4		= new  eOR.OrderType();
				//eOR.PinIdentificationByOrderType	OrBean5		= new  eOR.PinIdentificationByOrderType();
				eOR.OrderStatusCode					OrBean6		= new  eOR.OrderStatusCode();
				eOR.MultiFacilityProcessingBean		OrBean7		= new  eOR.MultiFacilityProcessingBean();
				eOR.ClosingProcessOrderBean        	OrBean8		= new  eOR.ClosingProcessOrderBean();
				eOR.Common.MultiRecordBean         	OrBean9		= new  eOR.Common.MultiRecordBean();
				eOR.IndexTickSheet                 	OrBean10	= new  eOR.IndexTickSheet();
				eOR.IndexRecBean                   	OrBean11	= new  eOR.IndexRecBean();
				eOR.CatalogsBySection              	OrBean12	= new  eOR.CatalogsBySection();
				eOR.SpecimenCollectionBean         	OrBean13	= new  eOR.SpecimenCollectionBean();
				eOR.Tick_Sheets                    	OrBean14	= new  eOR.Tick_Sheets();
				eOR.ReasonCode                     	OrBean15	= new  eOR.ReasonCode();
				eOR.OrderTypesForOrderableBean     	OrBean16	= new  eOR.OrderTypesForOrderableBean();
				eOR.ConsentFormat                  	OrBean17	= new  eOR.ConsentFormat();
				eOR.UserForReview                  	OrBean18	= new  eOR.UserForReview();
				eOR.UserForReporting               	OrBean19	= new  eOR.UserForReporting();
				eOR.AccessionNumberRules           	OrBean20	= new  eOR.AccessionNumberRules();
				eOR.SpecimenLblGenerationBean      	OrBean21	= new  eOR.SpecimenLblGenerationBean();
				eOR.OrderingRulebyPatientClass     	OrBean22	= new  eOR.OrderingRulebyPatientClass();
				eOR.OrderEntryFormatItem           	OrBean23	= new  eOR.OrderEntryFormatItem();
				eOR.FrequencyScopeBean             	OrBean24	= new  eOR.FrequencyScopeBean();
				eOR.OrderPrintRoutingBean          	OrBean25	= new  eOR.OrderPrintRoutingBean();
				eOR.PrivilegeExceptionGrpBean      	OrBean26	= new  eOR.PrivilegeExceptionGrpBean();
				eOR.OrderEntryFormats              	OrBean27	= new  eOR.OrderEntryFormats();
				eOR.OrderCatalogBean               	OrBean28	= new  eOR.OrderCatalogBean();
				//eOR.PrivilegeManager               	OrBean29	= new  eOR.PrivilegeManager();
				eOR.PrivilegeBean                  	OrBean30	= new  eOR.PrivilegeBean();
				eOR.OrderEntryBean                 	OrBean31	= new  eOR.OrderEntryBean();
				eOR.AuthoriseOrders                	OrBean32	= new  eOR.AuthoriseOrders();
				eOR.ConsentOrders                  	OrBean33	= new  eOR.ConsentOrders();
				eOR.RegisterOrder                  	OrBean34	= new  eOR.RegisterOrder();
				eOR.ViewOrder                      	OrBean35	= new  eOR.ViewOrder();
				eOR.ResultReportingBean            	OrBean36	= new  eOR.ResultReportingBean();
				eOR.SpecimenOrder                  	OrBean37	= new  eOR.SpecimenOrder();
				eOR.ExistingOrder					OrBean38	= new  eOR.ExistingOrder();
				eOR.ReportAuthorizationBean        	OrBean39	= new  eOR.ReportAuthorizationBean();
				eOR.CompleteOrderBean              	OrBean40	= new  eOR.CompleteOrderBean();
				eOR.ReviewStatusBean               	OrBean41	= new  eOR.ReviewStatusBean();
				eOR.CancelOrder                    	OrBean42	= new  eOR.CancelOrder();
				eOR.ResultEntryBean                	OrBean43	= new  eOR.ResultEntryBean();
				eOR.TextBlockBean                  	OrBean44	= new  eOR.TextBlockBean();
				eOR.ImageHotSpotLinkBean           	OrBean45	= new  eOR.ImageHotSpotLinkBean();
				eOR.ScheduleFrequencyCompBean      	OrBean46	= new  eOR.ScheduleFrequencyCompBean();
				eOR.IndexOrderCareSetBean          	OrBean47	= new  eOR.IndexOrderCareSetBean();
				eOR.ImageHotSpotBean               	OrBean48	= new  eOR.ImageHotSpotBean();
				eOR.CareSetBean                    	OrBean49	= new  eOR.CareSetBean();
				eOR.ConsignOrders                  	OrBean50	= new  eOR.ConsignOrders();
				eOR.ReviewResults                  	OrBean51	= new  eOR.ReviewResults();
				eOR.IndexOrderCatalogBean          	OrBean52	= new  eOR.IndexOrderCatalogBean();
				eOR.SpecialApproveOrders           	OrBean53	= new  eOR.SpecialApproveOrders();
				eOR.DispenseBean                   	OrBean54	= new  eOR.DispenseBean();
				eOR.ReprintFormsBean               	OrBean55	= new  eOR.ReprintFormsBean();
				eOR.PatOrderByLocnBean             	OrBean56	= new  eOR.PatOrderByLocnBean();
				eOR.ORReportsConsolidatedOrderList 	OrBean57	= new  eOR.ORReportsConsolidatedOrderList();
				eOR.ResultReportingBean            	OrBean58	= new  eOR.ResultReportingBean();
				eOR.RapidOrdersBean                	OrBean59	= new  eOR.RapidOrdersBean();
				eOR.RefusalOrdersBean              	OrBean60	= new  eOR.RefusalOrdersBean();
				eOR.Common.OrderEntryRecordBean    	OrBean61	= new  eOR.Common.OrderEntryRecordBean();
				eOR.MultiPatientOrdersBean         	OrBean62	= new  eOR.MultiPatientOrdersBean();
				eOR.OrdersTabBean                  	OrBean63	= new  eOR.OrdersTabBean();
				eOR.RecordProcedureBean            	OrBean64	= new  eOR.RecordProcedureBean();
				eOR.ExternalOrdersBean             	OrBean65	= new  eOR.ExternalOrdersBean();
				eOR.PatOrderByPrivRelnBean         	OrBean66	= new  eOR.PatOrderByPrivRelnBean();
				eOR.OrParameterForFacilityBean     	OrBean67	= new  eOR.OrParameterForFacilityBean();
				eOR.OrderablePerformingLocationBean	OrBean68	= new  eOR.OrderablePerformingLocationBean();
				eOR.ChartHorizontalBean            	OrBean69	= new  eOR.ChartHorizontalBean();
				eOR.ChartResultType                	OrBean70	= new  eOR.ChartResultType();
				eOR.ChartVerticalBean              	OrBean71	= new  eOR.ChartVerticalBean();
				eOR.OrParameterBean                	OrBean72	= new  eOR.OrParameterBean();
				eOR.OrderEntryDrawingToolBean      	OrBean73	= new  eOR.OrderEntryDrawingToolBean();
				eOR.ChargeType						OrBean74	= new  eOR.ChargeType();
				eOR.OrderCatalogProcedureLink		OrBean75	= new  eOR.OrderCatalogProcedureLink();
 				//eOR.ResultTemplateBean			OrBean76	= new  eOR.ResultTemplateBean();
				eOR.QueryBean						OrBean77	= new  eOR.QueryBean();
   		}  
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws javax.servlet.ServletException,IOException
	{
		try
		{
			doPost(request, response);
		}
		catch(Exception ex)	
		{	
			ex.printStackTrace();
		}
	}
	
}
