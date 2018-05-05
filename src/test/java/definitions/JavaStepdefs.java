package definitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.assertj.core.api.UrlAssert;

import java.net.URL;

public class JavaStepdefs {
    @Given("^I write java code$")
    public void iWriteJavaCode() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

        System.out.println("Hello World");
        String firstName = "Elena";
        String lastName = "Iskhacova";
        String favouriteColour = "gray";
//
//        System.out.println(firstName);
//        System.out.println(lastName);
//        System.out.println(favouriteColour);
//
//        System.out.println("Hi, my name is " + firstName + " " + lastName + ", my favourite colour is " + favouriteColour + ".");

//        System.out.println(firstName.toUpperCase() + " " + lastName.toUpperCase());


    }

    @Given("^I print \"([^\"]*)\" argument$")
    public void iPrintArgument(String var) throws Throwable {
        System.out.println(var);
        System.out.println(var.toLowerCase());
        System.out.println(var.length());
        System.out.println(var.equals("Elena"));
    }

    @Given("^I perform actions with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iPerformActionsWithAnd(String var1, String var2) throws Throwable {
        System.out.println(var1 + " " + var2);
        System.out.println(var1.toUpperCase() + " " + var2.toUpperCase());
        System.out.println(var1.length() + " " + var2);
        System.out.println(var1.equals(var2));
        System.out.println(var1.equalsIgnoreCase(var2));
        System.out.println(var1.contains(var2));
//
    }

    @Given("^I run operators with (\\d+) and (\\d+)$")
    public void iRunOperatorsWithAnd(int num1, int num2) throws Throwable {
//        Number sum = num1 + num2;
//        System.out.println(sum);
//
//        Number difference = num1 - num2;
//        System.out.println(difference);

        if (num1 < num2) {
            System.out.println("first number smaller than second");
        } else {
            System.out.println("first number larger or equals second");

        }
    }

    @Given("^I compare \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iCompareAnd(String var1, String var2) throws Throwable {
        if (!var1.equalsIgnoreCase(var2)) {
            System.out.println("Strings are not equal" + " " + var1 + " " + var2);
        }
    }

    @Given("^I print url for \"([^\"]*)\" page$")
    public void iPrintUrlForPage(String site) throws Throwable {

        if (site.equalsIgnoreCase("Google")) {
            System.out.println("https://www.google.com/");
        }
        if (site.equalsIgnoreCase("sample")) {
            System.out.println("http://skryabin.com/webdriver/html/sample.html");
        } else {
            System.out.println("Unknown site!");
        }
    }

    @Given("^I print arrays$")
    public void iPrintArrays() throws Throwable {
//        String[] groceryList = {"milk", "apple", "pear", "orange"};
//        for (int i = 0; i < groceryList.length; i++) {
//            System.out.println(groceryList[i]);
//
//            for (String element : groceryList) {
//                System.out.println(element);
         int[] nums = {1,5,18,46,98};
//             for (int i = 0; i < nums.length; i++) {
//                 System.out.println(nums[i]);

                 for (int element : nums) {
                     System.out.println(element);
                 }

        }
        }