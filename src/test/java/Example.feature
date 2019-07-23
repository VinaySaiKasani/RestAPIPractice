Feature:Creating Calculator Application
	Scenario:Invoking Addition
		Given Rest API "http://localhost:8080/addition?firstOperand=50&secondOperand=70"
		When invoking the given rest api
		Then expecting result as "120"
