package au.com.blogspot.ojitha.gwtex2.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.ServiceDefTarget;

public interface CustomerServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see au.com.blogspot.ojitha.gwtex2.client.CustomerService
     */
    void addCustomer( au.com.blogspot.ojitha.gwtex2.shared.CustomerDto customer, AsyncCallback<java.lang.Boolean> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static CustomerServiceAsync instance;

        public static final CustomerServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (CustomerServiceAsync) GWT.create( CustomerService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instanciated
        }
    }
}
