package org.example.demo.configuration;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Objects;

public class SSLSocketConfig {
    public static SSLSocketFactory getSSLSocketFactory() {
        try {
            SSLContext sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, getTrustManagers(), new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static TrustManager[] getTrustManagers() {
        TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
            @Override
            public void checkClientTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public void checkServerTrusted(X509Certificate[] chain, String authType) {
            }

            @Override
            public X509Certificate[] getAcceptedIssuers() {
                return new X509Certificate[] {};
            }
        } };

        return trustAllCerts;
    }

    public static HostnameVerifier getHostnameVerifier() {
        HostnameVerifier hostnameVerifier = new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, SSLSession session) {
                if (Objects.isNull(hostname)) {
                    return false;
                }
                if ("apisvc-test.tcbbank.com.tw".equals(hostname) || "172.16.85.187".equals(hostname)
                        || "172.16.85.149".equals(hostname) || "rvp-cms-test.tcbbank.com.tw".equals(hostname)) { // 本地端 / 測試環境
                    // if(""){ // 正式環境
                    return true;
                } else {
                    return false;
                }
            }
        };

        return hostnameVerifier;
    }

}
