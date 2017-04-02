package com.spring;

import java.io.IOException;
import java.util.List;

import org.apache.http.Consts;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

import com.google.common.collect.Lists;

import io.dropwizard.jersey.params.DateTimeParam;

public class HttpClientTest2 {
	String URL = "http://localhost:8080/hello-world/date1";

	@Test
	public void test() throws ClientProtocolException, IOException {

		List<NameValuePair> params = Lists.newArrayList();

		// DateTimeParam a = new DateTimeParam("20170221");

		params.add(new BasicNameValuePair("date1", "20170221"));
		String str = EntityUtils.toString(new UrlEncodedFormEntity(params, Consts.UTF_8));
		HttpGet httpGet = new HttpGet(URL + "?" + str);

		HttpClient httpClient = HttpClients.createMinimal();
		HttpResponse httpResponse = httpClient.execute(httpGet);

		String response = EntityUtils.toString(httpResponse.getEntity());
		System.out.println(response);
		DateTimeParam s = new ObjectMapper().readValue(response, DateTimeParam.class);
		System.out.print(s);

	}

}
