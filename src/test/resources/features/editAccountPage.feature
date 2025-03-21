Feature: Edit Account Page Functionality Test
  i will login to open cart site
  visit edit account page
  do edit in account and save it

  Background:
    Given user has already logged in to application
      | username                          | password   |
      | kvikramautomationtesting@gmail.com | Test@1234  |

    Scenario: in this scenario i check visiting edit account page and verify it
      Given i visit editaccounts by clicking on editaccounts link on homepage
      When i verify the pag is editaccounts page


    Scenario: in this scenario i check first name edit and save
      Given i visit editaccounts by clicking on editaccounts link on homepage
      When i enter new name in firstname field
      Then i click on continue button

      Scenario: in this scenario i revert firstname back to original one
        Given i visit editaccounts by clicking on editaccounts link on homepage
        When i enter old name in firstname field
        Then i click on continue button

