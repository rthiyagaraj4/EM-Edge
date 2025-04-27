/**
 * 
 */
package eIPAD.chartsummary.recordconsent.response;

/**
 * @author SaraswathiR
 *
 */
public class RecordConsentTransactionResponse {

	public final int TRANSACTION_RESULT_SUCCESS = 0;
	public final int TRANSACTION_RESULT_FAILURE = -1;
	public final int TRANSACTION_RESULT_WARNING = 1;
	
	private String transactionMessage;
	private int transactionResult = -1;
	
	/**
	 * @return the transactionMessage
	 */
	public String getTransactionMessage() {
		return transactionMessage;
	}
	/**
	 * @param transactionMessage the transactionMessage to set
	 */
	public void setTransactionMessage(String transactionMessage) {
		this.transactionMessage = transactionMessage;
	}
	/**
	 * @return the transactionResult
	 */
	public int getTransactionResult() {
		return transactionResult;
	}
	/**
	 * @param transactionResult the transactionResult to set
	 */
	public void setTransactionResult(int transactionResult) {
		this.transactionResult = transactionResult;
	}
	
}
