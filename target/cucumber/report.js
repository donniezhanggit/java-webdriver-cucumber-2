$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/predefined.feature");
formatter.feature({
  "name": "Smoke steps",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@predefined"
    }
  ]
});
formatter.scenario({
  "name": "Predefined steps for Google",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@predefined"
    },
    {
      "name": "@predefined1"
    }
  ]
});
