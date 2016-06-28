package test

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UtilController)
class UtilControllerSpec extends Specification {

    void populateValidParams() {
		params["name"] = "John Doe"
		params["tags"] = ["one", "two"]
		params["roles"] = ["admin", "user"]
		
    }


    void "databinding is working on roles but not on tags"() {
		when:
		populateValidParams() 
		controller.index()
		
		then:
		response.text == '{"name":"John Doe","roles":["admin","user"],"tags":["one","two"]}'
		
    }
	
}
