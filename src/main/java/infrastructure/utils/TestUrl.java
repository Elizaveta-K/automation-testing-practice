package infrastructure.utils;

import java.util.HashMap;
import java.util.Map;

public class TestUrl {
    private String protocol = "";
    private String domain = "";
    private String port = "";
    private String path = "";
    private String stringParams = "";
    HashMap<String, String> params = new HashMap<>();

    public TestUrl() {
    }

    public TestUrl(String protocol, String domain, String port, String path, HashMap<String, String> params) {
        this.protocol = protocol;
        this.domain = domain;
        this.port = port;
        this.path = path;
        this.params = params;
    }

    public String getProtocol() {
        return protocol;
    }

    public String getDomain() {
        return domain;
    }

    public String getPort() {
        return port;
    }

    public String getPath() {
        return path;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public String buildUrl(){
        return new Builder()
                .withProtocol(protocol)
                .withDomain(domain)
                .withPort(port)
                .withPath(path)
                .withParams(params)
                .build();
    }

    public static String editorUrl(){
        HashMap<String, String> defaultParams = new HashMap<>();
        defaultParams.put("1", "a");
        defaultParams.put("2", "b");
        return new Builder()
                .withProtocol("http://")
                .withDomain("site.com")
                .withPath("/editor")
                .withParams(defaultParams)
                .build();
    }

    public static class Builder{

        private TestUrl url;

        public Builder() {

            url = new TestUrl();
        }

        public Builder withProtocol(String protocol){
            url.protocol = protocol;
            return this;
        }

        public Builder withDomain(String domain){
            url.domain = domain;
            return this;
        }

        public Builder withPort(String port){
            url.port = port;
            return this;
        }

        public Builder withPath(String path){
            url.path = path;
            return this;
        }

        public Builder withParams(String params){
            url.stringParams += params + "&";
            return this;
        }

        public Builder withParams(HashMap<String, String> params){
            url.params = params;
            return this;
        }

        public String build(){

            String resultUrl = "";

            if(url.protocol.isBlank()){
                resultUrl += "https://";
            }else if(!url.protocol.endsWith("://")){
                resultUrl += url.protocol + "://";
            }else{
                resultUrl += url.protocol;
            }

            if(url.domain.isBlank()){
                resultUrl += "localhost";
            }else{
                resultUrl += url.domain;
            }

            if(!url.port.isBlank()){
                resultUrl += url.port.startsWith(":") ? url.port : ":" + url.port;
            }

            if(!url.path.isBlank()){
                resultUrl += url.path.startsWith("/") ? url.path : "/" + url.path;
            }

            if(!url.stringParams.isBlank() || !url.params.isEmpty()){
                resultUrl += "?";
            }
            if(!url.params.isEmpty()){
                for(Map.Entry<String, String> pair: url.params.entrySet()){
                    resultUrl += pair.getKey();
                    if(!pair.getValue().isEmpty()){
                        resultUrl += "=" + pair.getValue();
                    }
                    resultUrl += "&";
                }
            }
            if(!url.stringParams.isBlank()){
                resultUrl += url.stringParams;
            }

            return resultUrl;
        }

        public TestUrl getUrl(){
            return url;
        }
    }
}
