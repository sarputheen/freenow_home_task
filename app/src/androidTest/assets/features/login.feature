Feature:Freenow Test
    This feature will verify the login , driver name search and make call to selected driver actions

    
    @login
    Scenario Outline: Login with Username and Password
        Given I am on login screen
        When I input username <username>
        And I input password "<password>"
        And I press login button

    Examples:
        | username    | password|  
        | crazydog335 | venture |



    @callDriver
    Scenario Outline: Call the Cab driver based on the selected search result
        Given I am on main screen
        When I type the driver name as <drivername>
        Then I click on the search result <resultNumber>
        And I click on call button

        Examples:
            | drivername    | resultNumber|
            | sa | 2 |
        