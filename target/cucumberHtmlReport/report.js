$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/my_first.feature");
formatter.feature({
  "line": 1,
  "name": "Login",
  "description": "      As a user I should able to login into my app",
  "id": "login",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 4,
  "name": "I login with valid credential",
  "description": "",
  "id": "login;i-login-with-valid-credential",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "I navigate to \"http://the-internet.herokuapp.com/login\"",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I take screenshot",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "I enter \"tomsmith\" into input field having id \"username\"",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I enter \"SuperSecretPassword!\" into input field having id \"password\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "I click on element having class \"radius\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I should get logged-in",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "http://the-internet.herokuapp.com/login",
      "offset": 15
    }
  ],
  "location": "PredefinedStepDefinitions.navigate_to(String)"
});
