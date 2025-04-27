/**
 *  @author poorani
 */
package eIPAD.chartsummary.CLEventHistory.healthobject;

public class CLEventHistoryItemHO{
	private String ItemDescription;//"Clinical Notes
	private String ItemType; //Mis
	private String ItemCount;//20
	private String assertionNo;//20

private String ItemCode; //CN
/**
 * @return the itemCode
 */
public String getItemCode() {
	return ItemCode;
}
/**
 * @param itemCode the itemCode to set
 */
public void setItemCode(String itemCode) {
	ItemCode = itemCode;
}
/**
 * @return the itemDescription
 */
public String getItemDescription() {
	return ItemDescription;
}
/**
 * @param itemDescription the itemDescription to set
 */
public void setItemDescription(String itemDescription) {
	ItemDescription = itemDescription;
}
/**
 * @return the itemType
 */
public String getItemType() {
	return ItemType;
}
/**
 * @param itemType the itemType to set
 */
public void setItemType(String itemType) {
	ItemType = itemType;
}
/**
 * @return the itemCount
 */
public String getItemCount() {
	return ItemCount;
}
/**
 * @param itemCount the itemCount to set
 */
public void setItemCount(String itemCount) {
	ItemCount = itemCount;
}

/**
 * @return the assertionNo
 */
public String getAssertionNo() {
	return assertionNo;
}
/**
 * @param assertionNo the assertionNo to set
 */
public void setAssertionNo(String assertionNo) {
	this.assertionNo = assertionNo;
}



}
