package stepdefinations;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import org.junit.Assert;
import com.factory.DriverFactory;
import com.pages.HomePage;
import com.pages.LoginPageOpenMRS;
import com.util.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinationLoginPageOpenMRS {

	private LoginPageOpenMRS loginpage = new LoginPageOpenMRS(DriverFactory.getDriver());
	private Properties properties;
	ConfigReader configRead = new ConfigReader();
	HomePage homePage;
	String userName;
	String password;

	@Given("user already logged in to application")
	public void user_already_logged_in_to_application(DataTable credentials) throws IOException {
		List<Map<String, String>> validCrdentials = credentials.asMaps();
		userName = validCrdentials.get(0).get("username");
		password = validCrdentials.get(0).get("password");
		/*
		 * properties = configRead.init_prop(); String locationName=
		 * properties.getProperty("location"); System.out.println("locationName : " +
		 * locationName); homePage=loginpage.doLogin(userName, password, locationName);
		 */
	}

	@When("user navigates to homepage")
	public void user_navigates_to_homepage() {
		homePage.navigateToHomePage();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		String homepageTitle = homePage.homePageTitle();
		Assert.assertEquals(homepageTitle, title);
	}

	@Then("user Logged in as Super User \\(admin) at Inpatient Ward")
	public void user_logged_in_as_super_user_admin_at_inpatient_ward() throws IOException {
		properties = configRead.init_prop();
		String locationName = properties.getProperty("location_InpatientWard");
		homePage = loginpage.dologinInpatientWardLocation(userName, password, locationName);
	}

	@Then("user Logged in as Super User \\(admin) at Isolation Ward")
	public void user_logged_in_as_super_user_admin_at_isolation_ward() throws IOException {
		properties = configRead.init_prop();
		String locationName = properties.getProperty("location_IsolationWard");
		homePage = loginpage.dologinIsolationWard(userName, password, locationName);
	}

	@Then("user Logged in as Super User \\(admin) at Laboratory")
	public void user_logged_in_as_super_user_admin_at_laboratory() throws IOException {
		properties = configRead.init_prop();
		String locationName = properties.getProperty("location_Laboratory");
		homePage = loginpage.dologinLaboratory(userName, password, locationName);
	}

	@Then("user Logged in as Super User \\(admin) at Outpatient Clinic")
	public void user_logged_in_as_super_user_admin_at_outpatient_clinic() throws IOException {
		properties = configRead.init_prop();
		String locationName = properties.getProperty("location_Outpatient");
		homePage = loginpage.dologinOutpatient(userName, password, locationName);
	}

	@Then("user Logged in as Super User \\(admin) at Pharmacy")
	public void user_logged_in_as_super_user_admin_at_pharmacy() throws IOException {
		properties = configRead.init_prop();
		String locationName = properties.getProperty("location_Pharmacy");
		homePage = loginpage.dologinPharmacy(userName, password, locationName);
	}

	@Then("user Logged in as Super User \\(admin) at Registration Desk")
	public void user_logged_in_as_super_user_admin_at_registration_desk() throws IOException {
		properties = configRead.init_prop();
		String locationName = properties.getProperty("location_RegistrationDesk");
		homePage = loginpage.dologinRegistrationDesk(userName, password, locationName);
	}

	@Given("select patient record")
	public void select_patient_record() throws IOException {
		properties = configRead.init_prop();
		String locationName = properties.getProperty("location_InpatientWard");
		homePage = loginpage.dologinInpatientWardLocation(userName, password, locationName);
		homePage.navigateToPatientRecordPage();
	}

	@When("user navigates to FindPatientRecordPage")
	public void user_navigates_to_find_patient_record_page() {
	}

	@Then("Page title should {string}")
	public void page_title_should(String string) {
	}
}
