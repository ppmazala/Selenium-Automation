Narrative:
As a computer dataBase user
I want to add/modify/delete a new computer  
So that I can see Acceptance test for computer dataBase application

Scenario: Add a New Computer
Given The user is on Computer dataBase Home Page
When User clicks on Create New Computer button
And User creates a new computer named: Mazala and with company: IBM
Then A create Sucess Message displays on Home Page

Scenario: Edit the computer recentlly created
Given User searchs for the computer recentlly created
Then User clicks on link result
And User modifies the computer named to: Mazala1 and with company to: IBM
Then A update Sucess Message displays on Home Page

Scenario: Verifiy applicable changes
Given User searchs for the computer recentlly updated
When User clicks on link result
Then User checks with the Computer Name was updated

Scenario: Delete created user
When User delete the create computer
Then A delete Sucess Message displays on Home Page
Then User exit application
