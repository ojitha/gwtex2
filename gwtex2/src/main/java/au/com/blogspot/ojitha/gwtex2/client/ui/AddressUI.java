package au.com.blogspot.ojitha.gwtex2.client.ui;

import java.util.List;

import au.com.blogspot.ojitha.gwtex2.client.StateService;
import au.com.blogspot.ojitha.gwtex2.client.StateServiceAsync;
import au.com.blogspot.ojitha.gwtex2.shared.StateDto;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

/**
 * Composit component for the Address
 * The associated XHTML UI is AddressUI.ui.xml
 * @author Ojitha
 *
 */
public class AddressUI extends Composite{

	
	private static AddressUIUiBinder uiBinder = GWT
			.create(AddressUIUiBinder.class);
	@UiField TextBox firstStreet;
	@UiField TextBox secondStreed;
	@UiField ListBox cmbState;
	

	interface AddressUIUiBinder extends UiBinder<Widget, AddressUI> {
	}

	public AddressUI() {
		initWidget(uiBinder.createAndBindUi(this));

	}
	
	/*
	 * Initialize the address with states 
	 */
	private void readAllStates(){
		StateServiceAsync stateService = GWT.create(StateService.class);
		if (cmbState.getItemCount() == 0){
			stateService.getAllStates(new AsyncCallback<List<StateDto>>() {
	
				
				@Override
				public void onFailure(Throwable caught) {
					//FIXME need to fix this for exceptions
					// exceptions are not considered in this POC
				}
	
				@Override
				public void onSuccess(List<StateDto> result) {
					for (StateDto stateDto : result) {
						cmbState.addItem(stateDto.getState(),stateDto.getCode());
					}
					
				}
			});
		}
	}

	/*
	 * (non-Javadoc)
	 * @see com.google.gwt.user.client.ui.Widget#onLoad()
	 */
	@Override
	protected void onLoad() {
		// initialize with RPC call to get all States
		super.onLoad();
		readAllStates();
	}
	
	
}
