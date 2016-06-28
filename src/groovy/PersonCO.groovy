package test

class PersonCO {
	String name
	List<String> tags
	List<String> roles
	
	
	List<String> getTags() {
		this?.tags?.findAll { it }
	}
	
	List<String> getRoles() {
		this.roles = this?.roles?.findAll { it }
		this.roles
	}
}