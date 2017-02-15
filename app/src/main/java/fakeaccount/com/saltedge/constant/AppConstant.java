package fakeaccount.com.saltedge.constant;

import okhttp3.MediaType;

public class AppConstant {

    public static class ClientDetails
    {
        public static final String CLIENT_ID = "Cv1TjYOCPQBGGZQU3rYifQ";
        public static final String SERVICE_SECRET = "H3MM3KszycMvTQtGKf3h7E5Hn0wbGYjmdnnjy0cFBLU";
        public static final String APP_SECRET = "Q5jm9RaU41AqeJf3zGPpxGYf8LNJ77dYXx5fqjablMQ";
        public static final String IDENTIFIER = "identifier";
        public static final String DATA = "data";
    }

    public static class Header
    {
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String ACCEPT = "Accept";
        public static final String CLIENT_ID = "Client-id";
        public static final String SERVICE_SECRET = "Service-secret";
        public static final String APP_SECRET = "App-secret";
        public static final String APP_JSON = "application/json";
        public static final MediaType MEDIA_TYPE = MediaType.parse("application/json; charset=utf-8");
    }

    public static class CreateCustomer
    {
        public static final String CREATECUSTOMER_URL = "https://www.saltedge.com/api/v3/customers";
    }

    public static class ProvidersList
    {
        public static final String PROVIDERS_URL = "https://www.saltedge.com/api/v3/providers";
    }


}
