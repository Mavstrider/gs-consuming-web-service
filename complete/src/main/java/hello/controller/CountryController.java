/**
 * 
 */
package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import hello.CountryClient;
import hello.wsdl.ExistsCountryResponse;
import hello.wsdl.GetCountryResponse;

/**
 * @author admin
 *
 */

@RestController
@RequestMapping(value = "/country")
public class CountryController {

	@Autowired
	private CountryClient countryClient;

	@RequestMapping(value = "/geByName/{country}", method = RequestMethod.GET)
	public GetCountryResponse mostraCountry(@PathVariable String country) {

		return countryClient.getCountry(country);
	}

	@RequestMapping(value = "/existsCountry/{country}", method = RequestMethod.GET)
	public ExistsCountryResponse existsCountry(@PathVariable String country) {
		return countryClient.existsCountry(country);


	}

}
