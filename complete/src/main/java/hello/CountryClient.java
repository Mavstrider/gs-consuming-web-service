
package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import hello.wsdl.ExistsCountryRequest;
import hello.wsdl.ExistsCountryResponse;
import hello.wsdl.GetCountryRequest;
import hello.wsdl.GetCountryResponse;

public class CountryClient extends WebServiceGatewaySupport {

	private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

	public GetCountryResponse getCountry(String country) {

		GetCountryRequest request = new GetCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		GetCountryResponse response = (GetCountryResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws/countries", request,
						new SoapActionCallback(
								"http://spring.io/guides/gs-producing-web-service/GetCountryRequest"));

		return response;
	}

	public ExistsCountryResponse existsCountry(String country) {

		ExistsCountryRequest request = new ExistsCountryRequest();
		request.setName(country);

		log.info("Requesting location for " + country);

		ExistsCountryResponse response = (ExistsCountryResponse) getWebServiceTemplate().marshalSendAndReceive(
				"http://localhost:8080/ws/countries", request,
				new SoapActionCallback("http://spring.io/guides/gs-producing-web-service/ExistsCountryRequest"));

		return response;
	}

}
