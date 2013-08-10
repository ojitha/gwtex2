package au.com.blogspot.ojitha.gwtex2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface StateServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see au.com.blogspot.ojitha.gwtex2.client.StateService
     */
    void getAllStates( AsyncCallback<java.util.List<au.com.blogspot.ojitha.gwtex2.shared.StateDto>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static StateServiceAsync instance;

        public static final StateServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (StateServiceAsync) GWT.create( StateService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
