package com.test.curator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InstanceDetails {

    public static final String ROOT_PATH = "/service";
    /**
     * 该服务有哪些方法
     */
    private Map<String, Service> serviceMap = new HashMap<>();
    /**
     * 服务描述
     */
    private String serviceDesc;

    public InstanceDetails() {
        this.serviceDesc = "";
    }

    public InstanceDetails(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public String getServiceDesc() {
        return serviceDesc;
    }

    public void setServiceDesc(String serviceDesc) {
        this.serviceDesc = serviceDesc;
    }

    public Map<String, Service> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, Service> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public static class Service {

        /**
         * 方法名称
         */
        private String methodName;
        /**
         * 方法描述
         */
        private String methodDesc;
        /**
         * 方法所需要的参数列表
         */
        private List<String> params;

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public String getMethodDesc() {
            return methodDesc;
        }

        public void setMethodDesc(String methodDesc) {
            this.methodDesc = methodDesc;
        }

        public List<String> getParams() {
            return params;
        }

        public void setParams(List<String> params) {
            this.params = params;
        }
    }
}
