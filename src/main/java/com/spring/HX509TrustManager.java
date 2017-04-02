package com.spring;

import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

public class HX509TrustManager implements X509TrustManager {
public X509Certificate[] getAcceptedIssuers() {
return null;
}

public void checkClientTrusted(X509Certificate[] certs, String authType) {
}

public void checkServerTrusted(X509Certificate[] certs, String authType) {
}
}