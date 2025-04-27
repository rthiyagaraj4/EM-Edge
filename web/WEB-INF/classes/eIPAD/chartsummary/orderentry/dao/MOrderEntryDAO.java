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
package eIPAD.chartsummary.orderentry.dao;

import java.util.ArrayList;

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
public interface MOrderEntryDAO {
	public MOrderCatalogListResponse getOrdersBySearch(MOrderCatalogsSearchRequest request,boolean ignorePH);
	public MOrderCatalogListResponse getTickSheetOrders(MOrderCatalogsTickSearchRequest request,boolean ignorePH);
	public MOrderEntryFieldResponse getTickSheetList(OrderEntryBean orderEntryBean, String orderCategory, boolean ignorePH);
	public MOrderEntryFieldResponse getSectionsUnderTickSheet(OrderEntryBean orderEntryBean, String tickSheetId, boolean ignorePH);
	public MOrderEntryFieldResponse getAllOrderCategories(OrderEntryBean orderEntryBean, boolean ignorePH);
	public MOrderEntryFieldResponse getOrderTypesUnderCategory(OrderEntryBean orderEntryBean, String orderCategory, boolean ignorePH);
	public MOrderEntryFieldResponse getAllOrderCategories(String locale, boolean ignorePH);
	public MOrderEntryFieldResponse getOrderTypesUnderCategory(String locale, String orderCategory, boolean ignorePH);
	public MOrderCatalogCountResponse getTickSheetOrdersCount(MOrderCatalogsTickSearchRequest request,boolean ignorePH);
	public MOrderCatalogCountResponse getOrdersBySearchCount(MOrderCatalogsSearchRequest request,boolean ignorePH);
}
