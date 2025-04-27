/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/**
 * 
 */
package eIPAD.chartsummary.orderentry.bc;

import eIPAD.chartsummary.orderentry.dao.MOrderEntryDAO;
import eIPAD.chartsummary.orderentry.daoimpl.MOrderEntryDAOImpl;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsSearchRequest;
import eIPAD.chartsummary.orderentry.request.MOrderCatalogsTickSearchRequest;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogCountResponse;
import eIPAD.chartsummary.orderentry.response.MOrderCatalogListResponse;
import eIPAD.chartsummary.orderentry.response.MOrderEntryFieldResponse;
import eOR.OrderEntryBean;

/**
 * @author SaraswathiR
 *
 */
public class MOrderEntryBC {
	public MOrderCatalogListResponse getTickSheetOrders(MOrderCatalogsTickSearchRequest request, boolean ignorePH) {
		MOrderCatalogListResponse resp = new MOrderCatalogListResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getTickSheetOrders(request,ignorePH);
		return resp;
	}
	public MOrderCatalogListResponse getOrdersBySearch(MOrderCatalogsSearchRequest request, boolean ignorePH) {
		MOrderCatalogListResponse resp = new MOrderCatalogListResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getOrdersBySearch(request,ignorePH);
		return resp;
	}
	public MOrderEntryFieldResponse getTickSheetList(OrderEntryBean bean, String orderCategory, boolean ignorePH) {
		MOrderEntryFieldResponse resp = new MOrderEntryFieldResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getTickSheetList(bean,orderCategory,ignorePH);
		return resp;
	}
	public MOrderEntryFieldResponse getSectionsUnderTickSheet(OrderEntryBean bean, String tickSheetId, boolean ignorePH) {
		MOrderEntryFieldResponse resp = new MOrderEntryFieldResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getSectionsUnderTickSheet(bean,tickSheetId,ignorePH);
		return resp;
	}
	public MOrderEntryFieldResponse getAllOrderCategories(OrderEntryBean bean, boolean ignorePH) {
		MOrderEntryFieldResponse resp = new MOrderEntryFieldResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getAllOrderCategories(bean,ignorePH);
		return resp;
	}
	public MOrderEntryFieldResponse getOrderTypesUnderCategory(OrderEntryBean bean, String orderCategory, boolean ignorePH) {
		MOrderEntryFieldResponse resp = new MOrderEntryFieldResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getOrderTypesUnderCategory(bean,orderCategory,ignorePH);
		return resp;
	}
	public MOrderEntryFieldResponse getAllOrderCategories(String locale, boolean ignorePH) {
		MOrderEntryFieldResponse resp = new MOrderEntryFieldResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getAllOrderCategories(locale,ignorePH);
		return resp;
	}
	public MOrderEntryFieldResponse getOrderTypesUnderCategory(String locale, String orderCategory, boolean ignorePH) {
		MOrderEntryFieldResponse resp = new MOrderEntryFieldResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getOrderTypesUnderCategory(locale,orderCategory,ignorePH);
		return resp;
	}
	public MOrderCatalogCountResponse getTickSheetOrdersCount(MOrderCatalogsTickSearchRequest request,boolean ignorePH){
		MOrderCatalogCountResponse resp = new MOrderCatalogCountResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getTickSheetOrdersCount(request, ignorePH);
		return resp;
	}
	public MOrderCatalogCountResponse getOrdersBySearchCount(MOrderCatalogsSearchRequest request,boolean ignorePH){
		MOrderCatalogCountResponse resp = new MOrderCatalogCountResponse();
		MOrderEntryDAO dao = new MOrderEntryDAOImpl();
		resp = dao.getOrdersBySearchCount(request, ignorePH);
		return resp;
	}
}
