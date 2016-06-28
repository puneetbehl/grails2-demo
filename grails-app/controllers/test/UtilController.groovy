package test
import grails.converters.JSON

class UtilController {

    def index(PersonCO personCO) {
		render personCO as JSON
	 }
}
